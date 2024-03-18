package service.serviceImpl;

import models.Database;
import models.Library;
import service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public List<Library> saveLibrary(Library libraries) {
        Database.libraries.add(libraries);
        return Database.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;
    }

    @Override
    public String updateLibrary(Long id, Library library) {
        List<Library> libraries = Database.libraries;
        for (Library library1 :  libraries){
            if (library1.getId().equals(id)) {
                library1.setId(library.getId());
                library1.setName(library.getName());
                library1.setAddress(library.getAddress());
                return "successfully updated";
            }
        }
        return "error";
    }

    @Override
    public String deleteLibrary(Long id) {
        Database.libraries.removeIf(library -> library.getId().equals(id));
        return "successfully deleted";
    }
}