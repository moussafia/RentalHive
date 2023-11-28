package ma.youcode.rentalhive.model.dto.userDto;

import lombok.*;
import java.io.Serializable;

@Builder
public record UserDto(Long id,
        String user_name,
        String Email) implements Serializable {

}