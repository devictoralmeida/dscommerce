package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//    List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
//    if (result.size() == 0) {
//      throw new UsernameNotFoundException("Email not found");
//    }

    User user = new User();
//    user.setEmail(result.get(0).getUsername());
//    user.setPassword(result.get(0).getPassword());
//    for (UserDetailsProjection projection : result) {
//      user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
//    }

    return user;
  }
}
