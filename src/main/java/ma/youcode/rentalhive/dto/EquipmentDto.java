package ma.youcode.rentalhive.dto;

import lombok.*;
import ma.youcode.rentalhive.entities.Equipment;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Equipment}
 */
@Value @Data
public class EquipmentDto implements Serializable {
    @PositiveOrZero
    Long id;
    @NotNull(message = "name should not be null")
    @Pattern(regexp = "[a-zA-Z]+")
    @NotEmpty(message = "name should not be empty")
    @NotBlank(message = "name should not be blank")
    String name;
    @NotEmpty(message = "name should not be empty")
    @NotBlank(message = "name should not be blank")
    @PositiveOrZero
    Integer quantity;
    @NotEmpty(message = "name should not be empty")
    @NotBlank(message = "name should not be blank")
    @NotNull
    Float pricePerDay;
    @NotEmpty(message = "name should not be empty")
    @NotBlank(message = "name should not be blank")
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    String manufacturerName;
    @NotEmpty(message = "name should not be empty")
    @NotBlank(message = "name should not be blank")
    @NotNull
    Long category_id;
}