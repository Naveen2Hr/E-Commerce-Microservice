package com.softtek.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.UserInfo;

public interface IUserDetailsRepository extends JpaRepository<UserInfo, Integer> {

	public Optional<UserInfo> findByUserName(String userName);
}
