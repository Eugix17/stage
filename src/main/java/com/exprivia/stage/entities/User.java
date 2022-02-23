package com.exprivia.stage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class User {

    @Getter @Setter
    String id;

    @Getter @Setter
    String name;

    @Getter @Setter
    String surname;

    @Getter @Setter
    String email;
    
}
