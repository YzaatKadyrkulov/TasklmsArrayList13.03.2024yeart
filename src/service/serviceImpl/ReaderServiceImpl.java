
package service.serviceImpl;

import models.Database;
import models.Library;
import models.Reader;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        Reader reader10 = new Reader();
        for (Reader reader : Database.readers) {
            if (reader.getId() == id) {
                reader10 = reader;
            }
        }
        return reader10;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader2 : Database.readers) {
            if (reader2.getId() == id) {
                Database.readers.set(0, reader);

            }
        }
        return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader targetReader = null;
        Library targetLibrary = null;
        for (Reader reader : Database.readers) {
            if (reader.getId() == (readerId)) {
                targetReader = reader;
                break;
            }
        }

        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)) {
                targetLibrary = library;
                break;
            }
        }
        if (targetReader != null && targetLibrary != null) {
            targetLibrary.getReaders().add(targetReader);
        } else {
            System.out.println("Читатель или библиотека не найдены.");
        }
    }
}
