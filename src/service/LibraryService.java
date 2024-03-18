package service;

import models.Library;

import java.util.List;

public interface LibraryService {
    List<Library> saveLibrary(Library libraries);

    List<Library>getAllLibraries();

    Library getLibraryById(Long id);

    String updateLibrary(Long id, Library library);

    String deleteLibrary(Long id);
}