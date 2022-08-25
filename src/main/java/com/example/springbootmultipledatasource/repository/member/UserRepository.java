package com.example.springbootmultipledatasource.repository.member;

import com.example.springbootmultipledatasource.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
}
