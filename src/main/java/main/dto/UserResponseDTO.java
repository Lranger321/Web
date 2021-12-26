package main.dto;

import lombok.*;
import main.dao.entity.User;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class UserResponseDTO {

    private User user;
}
