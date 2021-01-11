package com.example.dao;

import com.example.domain.User;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @createDate: 2020/12/28
 * @author: zbh
 */
public interface UserRepository extends JpaRepository<User,Integer> {
  User findByUserName(String userName);

  @Override
  <S extends User> S save(S s);
}
