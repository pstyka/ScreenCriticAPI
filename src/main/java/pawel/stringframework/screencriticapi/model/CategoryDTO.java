package pawel.stringframework.screencriticapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Builder
@Data
public class CategoryDTO {

    private UUID id;

    @NotNull
    @NotBlank
    private String name;
}
