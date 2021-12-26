package main.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class UserDTO {

    private String email;
    private String password;
    private String name;
    private long id;
}
