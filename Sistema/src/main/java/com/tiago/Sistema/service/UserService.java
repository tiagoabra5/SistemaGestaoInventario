package com.tiago.Sistema.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tiago.Sistema.dto.LoginRequestDTO;
import com.tiago.Sistema.dto.RegisterRequestDTO;
import com.tiago.Sistema.dto.UserResponseDTO;

import com.tiago.Sistema.entity.User;
import com.tiago.Sistema.repository.UserRepository;
import com.tiago.Sistema.exception.InvalidSearchException;
import com.tiago.Sistema.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    @Autowired
    private UserRepository ur;

    @Autowired
    private PasswordEncoder pe;

    //buscar usuario pelo nome
    public List<User> findByName(String name){
        if(name == null || name.isBlank()){
            throw new InvalidSearchException();
        }
        return this.ur.findByNameContainingIgnoreCase(name);
    }

    //buscar usuario pelo id
    public User findById(Long id){
        return this.ur.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    //buscar todos os usuarios
    public List<User> findAll(){
        return this.ur.findAll();
    }

    //salvar usuario
    public UserResponseDTO createUser(RegisterRequestDTO dto){
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(pe.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        User savedUser = this.ur.save(user);
        return toResponseDTO(savedUser);
    }

    //atualizar usuario
    public User updateUser(Long id, RegisterRequestDTO dto){
       User userExisting = findById(id);

       userExisting.setName(dto.getName());
       userExisting.setEmail(dto.getEmail());
       userExisting.setPassword(pe.encode(dto.getPassword()));
       userExisting.setRole(dto.getRole());
       
       return this.ur.save(userExisting);
    }

    //deletar usuario
    public void deleteUser(Long id){
        User user = findById(id);
        this.ur.delete(user);
    }

    //criar toResponseDTO
    public UserResponseDTO toResponseDTO(User user){
        return new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole(),
            user.getCreatedAt()
        );
    }

}