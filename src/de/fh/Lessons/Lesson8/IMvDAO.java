package de.fh.Lessons.Lesson8;

import de.fh.Model.WithStream.Medium;
import java.util.List;

public interface IMvDAO {
    void speichern(List<Medium> liste) throws PersistenzException;
    List<Medium> laden() throws PersistenzException;
}
