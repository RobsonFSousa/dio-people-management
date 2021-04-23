package one.digitalinnovation.peoplemanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.peoplemanagement.entity.Phone;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @CPF
    @NotEmpty
    private String cpf;

    @NotEmpty
    @Size(min = 2 , max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2 , max = 100)
    private String lastName;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;
}
