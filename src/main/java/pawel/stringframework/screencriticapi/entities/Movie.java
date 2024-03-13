package pawel.stringframework.screencriticapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pawel.stringframework.screencriticapi.model.Category;

import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(length = 50)
    private String movieName;

    @NotNull
    private Category movieCategory;

    @NotNull
    @Size(max=300)
    @Column(length = 300)
    private String movieDescription;

    @NotNull
    @Size(max=40)
    @Column(length = 40)
    private String movieDirector;

    @NotNull
    private Integer movieReleaseDate;

    @NotNull
    private float movieAverageRating;


}
