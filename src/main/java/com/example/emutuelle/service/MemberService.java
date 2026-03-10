package com.example.emutuelle.service;

import com.example.emutuelle.entity.Member;
import com.example.emutuelle.entity.MemberCard;
import com.example.emutuelle.entity.HealthPackage;
import com.example.emutuelle.repository.MemberRepository;
import com.example.emutuelle.repository.HealthPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private HealthPackageRepository healthPackageRepository;

    public Member registerMember(Member member) {
        if (memberRepository.existsByNationalId(member.getNationalId())) {
            throw new RuntimeException("Member with this National ID already exists");
        }
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new RuntimeException("Member with this email already exists");
        }
        MemberCard card = new MemberCard();
        card.setCardNumber("MC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        card.setIssueDate(LocalDate.now());
        card.setExpiryDate(LocalDate.now().plusYears(1));
        card.setStatus("ACTIVE");
        member.setMemberCard(card);
        return memberRepository.save(member);
    }

    public Page<Member> getAllMembers(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("DESC") ?
            Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return memberRepository.findAll(PageRequest.of(page, size, sort));
    }

    public List<Member> getMembersByProvinceCode(String code) {
        return memberRepository.findByVillage_Cell_Sector_District_Province_Code(code);
    }

    public List<Member> getMembersByProvinceName(String name) {
        return memberRepository.findByVillage_Cell_Sector_District_Province_Name(name);
    }

    public Member assignPackage(Long memberId, Long packageId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("Member not found"));
        HealthPackage healthPackage = healthPackageRepository.findById(packageId)
            .orElseThrow(() -> new RuntimeException("Package not found"));
        member.getHealthPackages().add(healthPackage);
        return memberRepository.save(member);
    }
}