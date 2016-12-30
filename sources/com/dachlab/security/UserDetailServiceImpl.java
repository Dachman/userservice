package com.dachlab.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dachlab.dao.IUserRepository;

@Service("userDetailserviceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("Authenticating user " + userName + ".");
		com.dachlab.model.User user = userRepository.getByUserName(userName);
		if (user != null) {
			log.info("Found user Id " + user.getUserId() + ".");
			return new User(user.getUserName(), user.getUserPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(user.getUserRole()));
		} else {
			log.info("User " + userName + " not found.");
			throw new UsernameNotFoundException("Could not find user " + userName + ".");
		}
	}

}
