package com.softtek.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softtek.entity.UserInfo;
import com.softtek.repository.IUserDetailsRepository;
import com.softtek.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IUserDetailsRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> opt = userRepo.findByUserName(username);
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("User Not Found");
		} else {
			UserInfo info = opt.get();
			User user = new User(info.getUserName(), info.getUserPassword(),
					info.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			return user;
		}
	}

	@Override
	public String register(UserInfo details) {
		details.setUserPassword(encoder.encode(details.getUserPassword()));
		return "UserId :: " + userRepo.save(details).getUserId();
	}

}
