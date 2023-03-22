package com.hara.hara.controller;

import com.hara.hara.domain.Member;
import com.hara.hara.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public List<Member> GetUsers(){
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Member GetUser(@PathVariable Long id){
        return memberRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Member PostUser(@RequestBody Member user){
        return memberRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public Long DeleteUser(@PathVariable Long id){
        memberRepository.deleteById(id);
        return id;
    }
}
