package ma.youcode.rentalhive.model.mapper.userMapper;

import ma.youcode.rentalhive.model.domaine.entities.User;
import ma.youcode.rentalhive.model.dto.userDto.UserDto;

public class UserDtoMapper {
    public static UserDto toUserDto(User user){
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .user_name(user.getUser_name())
                .Email(user.getEmail())
                .build();
        return userDto;
    }
}
