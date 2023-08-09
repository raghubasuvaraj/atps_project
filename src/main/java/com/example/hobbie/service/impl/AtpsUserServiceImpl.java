package com.example.hobbie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hobbie.model.binding.AtpsSignupModel;
import com.example.hobbie.model.entities.AtpsUserEntity;
import com.example.hobbie.model.entities.BusinessOwner;
import com.example.hobbie.model.entities.enums.AtpsUserRoleEnum;
import com.example.hobbie.model.repostiory.AtpsUserRepository;
import com.example.hobbie.service.AtpsUserService;




import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtpsUserServiceImpl implements AtpsUserService {
	@Autowired
     AtpsUserRepository signupRepository;
    private final ModelMapper modelMapper = new ModelMapper();

	/*
	 * @Autowired public AtpsUserServiceImpl(AtpsUserRepository signupRepository) {
	 * this.signupRepository = signupRepository; }
	 */

    @Override
    public void saveAtpsSignup(AtpsSignupModel signupModel) {
        //AtpsUserEntity signupEntity = new AtpsUserEntity();
        //signupEntity.setUsername(signupModel.getUsername());
       //signupEntity.setEmail(signupModel.getEmail());
       //signupEntity.setPassword(signupModel.getPassword());
    	signupModel.setUserRole(AtpsUserRoleEnum.USER);
    	AtpsUserEntity   signupEntity = this.modelMapper.map(signupModel, AtpsUserEntity.class);

        //signupEntity.setUser_roles(AtpsUserRoleEnum.USER);
        signupRepository.save(signupEntity);
    }


}

 

