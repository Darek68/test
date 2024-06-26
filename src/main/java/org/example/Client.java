package org.example;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    private UUID id;

    @Column(name = "NAME", length = 25,nullable = false)
    private String name;

    public UUID getId() {
        return id;
    }

    public Client(String imie) {
        this.id = UUID.randomUUID();
        this.name = imie;
    }

    public String getName() {
        return name;
    }
}
