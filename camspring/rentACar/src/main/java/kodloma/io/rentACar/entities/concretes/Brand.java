package kodloma.io.rentACar.entities.concretes;


import jakarta.persistence.*;
import kodloma.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity//varlık
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")

public class Brand {
    @Id//PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "brand")
    List<Model> models;

    }



