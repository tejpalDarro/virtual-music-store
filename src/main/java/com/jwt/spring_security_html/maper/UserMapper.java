package com.jwt.spring_security_html.maper;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.UserDto;
import com.jwt.spring_security_html.entity.User;
import com.jwt.spring_security_html.entity.product.Album;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserMapper {

    private AlbumMapper albumMapper;

    public UserMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setCreated(LocalDate.now());
        return user;
    }

    public List<UserDto> listOfUserToUserDto(List<User> userList) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User u : userList) {
            UserDto userDto = new UserDto();
            userDto.setName(u.getName());
            userDto.setEmail(u.getEmail());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public UserDto UserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        Set<AlbumDto> albumDtoSet =  albumMapper.mapToSetAlbumDto(user.getAlbums());
        userDto.setAlbum(albumDtoSet);
        return userDto;
    }
}
