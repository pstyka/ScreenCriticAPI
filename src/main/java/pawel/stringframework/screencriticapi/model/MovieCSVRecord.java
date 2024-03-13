package pawel.stringframework.screencriticapi.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCSVRecord {
//row,movie_name,movie_category,movie_description,movie_director,movie_release_date,movie_avg_rating,version
    @CsvBindByName
    private Integer row;
    @CsvBindByName
    private String movie_name;
    @CsvBindByName
    private String movie_category;
    @CsvBindByName
    private String movie_description;
    @CsvBindByName
    private String movie_director;
    @CsvBindByName
    private Integer movie_release_date;
    @CsvBindByName
    private Float movie_avg_rating;
    @CsvBindByName
    private Integer version;

}
