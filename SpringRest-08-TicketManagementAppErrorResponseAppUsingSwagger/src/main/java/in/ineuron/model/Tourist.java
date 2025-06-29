package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @NotBlank(message = "City must not be blank")
    private String city;

    @NotNull(message = "Name must not be null")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @NotBlank(message = "Package type must not be blank")
    private String packageType;

    @NotNull(message = "Budget must not be null")
    @DecimalMin(value = "1000.0", message = "Budget must be at least 1000")
    private Double budget;
}
