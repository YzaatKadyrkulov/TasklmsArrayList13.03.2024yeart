
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
        for (Reader reader : Database.readers) {
            if (reader.getId() == readerId) {
                for (Library library : Database.libraries) {
                    if (library.getId() == libraryId) {
                        Database.libraries.add(library);
                    }
                }
            }
        }
    }
}
