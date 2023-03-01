package kodloma.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import kodloma.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "plate",unique = true)
    private String plate;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "state")
    private int state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
