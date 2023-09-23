package com.devshehan.student;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Long schoolId;

}
