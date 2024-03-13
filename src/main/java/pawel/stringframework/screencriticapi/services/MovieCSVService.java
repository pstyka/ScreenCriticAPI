package pawel.stringframework.screencriticapi.services;

import pawel.stringframework.screencriticapi.model.MovieCSVRecord;

import java.io.File;
import java.util.List;

public interface MovieCSVService {
    List<MovieCSVRecord> convertCSV(File csvfile);
}
