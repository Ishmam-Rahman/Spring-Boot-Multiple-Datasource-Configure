package com.example.springbootmultipledatasource.entity.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
  @Id
  private Long id;

  private String name;

  private Long age;

  private String phoneNo;

  private String address;
}
