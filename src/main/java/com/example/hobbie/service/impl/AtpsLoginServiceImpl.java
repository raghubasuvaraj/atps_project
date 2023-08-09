package com.example.hobbie.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hobbie.handler.InvalidCredentialsException;
import com.example.hobbie.model.binding.AtpsLoginModel;
import com.example.hobbie.model.entities.AtpsLoginEntity;
import com.example.hobbie.model.entities.AtpsUserEntity;
import com.example.hobbie.model.repostiory.AtpsLoginRepository;
import com.example.hobbie.model.repostiory.AtpsUserRepository;
import com.example.hobbie.service.AtpsLoginService;
@Service
public class AtpsLoginServiceImpl implements AtpsLoginService {
@Autowired
    private final AtpsLoginRepository atpsLoginRepository;
@Autowired
private final AtpsUserRepository atpsSignupRepository;

    

	@Autowired
    public AtpsLoginServiceImpl(AtpsLoginRepository atpsLoginRepository,AtpsUserRepository atpsSignupRepository) {
        this.atpsLoginRepository = atpsLoginRepository;
		this.atpsSignupRepository =atpsSignupRepository;
    }

    @Override
    public List<AtpsLoginModel> getAll() {
        List<AtpsLoginEntity> loginEntities = atpsLoginRepository.findAll();
        return loginEntities.stream()
                .map(this::convertEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public AtpsLoginModel getByUsername(String username) {
        AtpsLoginEntity loginEntity = atpsLoginRepository.findByUsername(username);
        return convertEntityToModel(loginEntity);
    }

    @Override
    public AtpsLoginModel save(AtpsLoginModel atpsLoginModel) {
        AtpsLoginEntity loginEntity = convertModelToEntity(atpsLoginModel);
        loginEntity = atpsLoginRepository.save(loginEntity);
        return convertEntityToModel(loginEntity);
    }

    

    // Helper methods for conversion between Entity and Model
    private AtpsLoginModel convertEntityToModel(AtpsLoginEntity entity) {
        if (entity == null) {
            return null;
        }
        AtpsLoginModel model = new AtpsLoginModel();
        model.setUsername(entity.getUsername());
        model.setPassword(entity.getPassword());
        return model;
    }

    private AtpsLoginEntity convertModelToEntity(AtpsLoginModel model) {
        if (model == null) {
            return null;
        }
        AtpsLoginEntity entity = new AtpsLoginEntity();
        entity.setUsername(model.getUsername());
        entity.setPassword(model.getPassword());
        return entity;
    }
    @Override
    public void validateLogin(String username, String password) throws InvalidCredentialsException {
        AtpsUserEntity loginEntity = atpsSignupRepository.findByUsername(username);
        if (loginEntity == null) {
            throw new InvalidCredentialsException("Username not found");
        }
}
}

	