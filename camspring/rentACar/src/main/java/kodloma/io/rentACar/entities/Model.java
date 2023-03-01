package kodloma.io.rentACar.entities;

import jakarta.persistence.*;
import kodloma.io.rentACar.entities.concretes.Brand;
import kodloma.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity//varlık
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "models")
public class Model {// 3,3.20,2008,3008
    @Id//PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;//BMW ,PEQUET
    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
