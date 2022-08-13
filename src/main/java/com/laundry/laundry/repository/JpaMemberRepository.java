package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member update(Member member) {
        return null;
    }

    @Override
    public Member delete(Long id) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name" , Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPhoneNumber(String phoneNumber) {
        List<Member> result =  em.createQuery("select m from Member m where m.phoneNumber = :phoneNumber" , Member.class)
                .setParameter("phoneNumber", phoneNumber)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
