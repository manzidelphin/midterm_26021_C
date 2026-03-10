package com.example.emutuelle.repository;

import com.example.emutuelle.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByNationalId(String nationalId);
    boolean existsByEmail(String email);
    List<Member> findByVillage_Cell_Sector_District_Province_Code(String code);
    List<Member> findByVillage_Cell_Sector_District_Province_Name(String name);
    Page<Member> findAll(Pageable pageable);
}