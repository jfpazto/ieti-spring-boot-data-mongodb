package org.ada.school.controller;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/user" )
public class UserController
{

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDocument>> all()
    {
        return ResponseEntity.ok( userService.all() );
    }

    @GetMapping( "/{id}" )
    public Optional<UserDocument> findById(@PathVariable String id )
    {
        return userService.findById( id );
    }


    @PostMapping
    public ResponseEntity<UserDocument> create( @RequestBody UserDocument user )
    {
        //return ResponseEntity.ok( userService.create( new User( userDto ) ) );

        return ResponseEntity.ok( userService.create(user));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDocument> update(@RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

}
