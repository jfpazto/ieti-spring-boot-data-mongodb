package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDocument create(UserDocument user )
    {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<UserDocument> findById(String id )
    {

        return userRepository.findById(id);
    }

    @Override
    public List<UserDocument> all()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
        if (userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDocument update(UserDto userDto, String id )
    {
        if (userRepository.existsById(id))
        {
            UserDocument user=userRepository.findById(id).get();
            user.update(userDto);
            userRepository.save(user);
            return user;
        }
        return null;
    }
}
