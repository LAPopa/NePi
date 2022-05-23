package com.codecool.nepi.security;


import com.codecool.nepi.entity.useraccounts.*;
import com.codecool.nepi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.stream.Collectors;

@Component
public class CustomClientDetailsService implements UserDetailsService{

    private AdminRepository adminRepository;
    private OverseerRepository overseerRepository;
    private OperatorRepository operatorRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;

    @Autowired
    public CustomClientDetailsService(AdminRepository adminRepository, OverseerRepository overseerRepository,
                                      OperatorRepository operatorRepository, OwnerRepository ownerRepository,
                                      RenterRepository renterRepository) {
        this.adminRepository = adminRepository;
        this.overseerRepository = overseerRepository;
        this.operatorRepository = operatorRepository;
        this.ownerRepository = ownerRepository;
        this.renterRepository = renterRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByEmail(email);
        Overseer overseer = overseerRepository.findByEmail(email);
        Operator operator = operatorRepository.findByEmail(email);
        Owner owner = ownerRepository.findByEmail(email);
        Renter renter = renterRepository.findByEmail(email);

        if( admin != null) return new User(admin.getEmail(), admin.getPassword(), admin.getRoles().stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        else if (overseer != null) return new User(overseer.getEmail(), overseer.getPassword(), overseer.getRoles().stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        else if (operator != null) return new User(operator.getEmail(), operator.getPassword(), operator.getRoles().stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        else if (owner != null) return new User(owner.getEmail(), owner.getPassword(), owner.getRoles().stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        else if (renter != null) return new User(renter.getEmail(), renter.getPassword(), renter.getRoles().stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        else throw new UsernameNotFoundException("Email : " + email + " not found !");
    }
}
