package pawel.stringframework.screencriticapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;



import java.util.UUID;

@Builder
@Data
public class MovieDTO {

    private UUID id;
    private Integer version;

    @NotNull
    @NotBlank
    private String movieName;

    @NotNull
    private Category movieCategory;

    @NotNull
    private String movieDirector;
    @NotNull
    private String movieDescription;
    @NotNull
    private Integer movieReleaseDate;
    @NotNull
    private float movieAverageRating;



}
