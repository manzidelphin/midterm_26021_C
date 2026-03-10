package com.example.emutuelle.controller;

import com.example.emutuelle.entity.Member;
import com.example.emutuelle.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> registerMember(@RequestBody Member member) {
        Member registeredMember = memberService.registerMember(member);
        return new ResponseEntity<>(registeredMember, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Member>> getAllMembers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {
        Page<Member> members = memberService.getAllMembers(page, size, sortBy, direction);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/province/code/{code}")
    public ResponseEntity<List<Member>> getMembersByProvinceCode(@PathVariable String code) {
        List<Member> members = memberService.getMembersByProvinceCode(code);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/province/name/{name}")
    public ResponseEntity<List<Member>> getMembersByProvinceName(@PathVariable String name) {
        List<Member> members = memberService.getMembersByProvinceName(name);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PostMapping("/{memberId}/packages/{packageId}")
    public ResponseEntity<Void> assignPackage(@PathVariable Long memberId, @PathVariable Long packageId) {
        memberService.assignPackage(memberId, packageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}