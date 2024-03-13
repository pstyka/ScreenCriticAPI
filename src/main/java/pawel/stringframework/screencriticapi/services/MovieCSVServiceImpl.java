package pawel.stringframework.screencriticapi.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import pawel.stringframework.screencriticapi.model.MovieCSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class MovieCSVServiceImpl implements MovieCSVService {
    @Override
    public List<MovieCSVRecord> convertCSV(File csvfile) {
        try{
            List<MovieCSVRecord> movieCSVRecords = new CsvToBeanBuilder<MovieCSVRecord>(new FileReader(csvfile))
                    .withType(MovieCSVRecord.class)
                    .build().parse();
            return movieCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
