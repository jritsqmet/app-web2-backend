package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.entidades.Libro;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class AutorControler {

    @Autowired
    AutorRepository autorRepository;

    /////////////////////////////////////
    // LEER - Obtener todos los autores
    /////////////////////////////////////
    @GetMapping("/autores2")
    public List<Autor> autores() {
        // Recuperar todos los autores de la base de datos
        List<Autor> autores = autorRepository.findAll();
        return autores; // Devolver la lista de autores
    }


    //////////////////////////////////////////
    // CREAR - Crear un nuevo autor
    /////////////////////////////////////////
    @PostMapping("/autores2")
    public Autor crear(@RequestBody Autor autor) {
        return autorRepository.save(autor); // Guardar el nuevo autor en la base de datos 
    }

    ////////////////////////////////////////////////
    // ELIMINAR - Eliminar un autor por ID
    ///////////////////////////////////////////////
    @DeleteMapping("/autores2/{id}")
    public ResponseEntity<Boolean> eliminarAutor(@PathVariable int id) {
        // Buscar el autor por ID
        Optional<Autor> autor = autorRepository.findById(id);

        // Verificar si el autor existe
        if (autor.isPresent()) {
            autorRepository.delete(autor.get()); // Eliminar el autor de la base de datos
            return ResponseEntity.ok(true); // Devolver éxito
        } else {
            return ResponseEntity.ok(false); // Devolver falso si el autor no existe
        }
    }


    ///////////////////////////////////////////////////////////
    // EDITAR - Actualizar la información de un autor por ID
    //////////////////////////////////////////////////////////
    @PutMapping("/autores2/{id}")
    public ResponseEntity<Autor> updateUser(@PathVariable int id, @RequestBody Autor autorData) {
        // Buscar el autor por ID
        Optional<Autor> optionalAutor = autorRepository.findById(id);

        // Verificar si el autor existe
        if (optionalAutor.isPresent()) {
            Autor autor = optionalAutor.get();

            // Actualizar los campos del autor con los datos proporcionados
            autor.setNombre(autorData.getNombre());
            autor.setApellido(autorData.getApellido());
            autor.setEmail(autorData.getEmail());

            // Guardar los cambios en la base de datos
            Autor userSaved = autorRepository.save(autor);
            return ResponseEntity.ok(userSaved); // Devolver el autor actualizado
        } else {
            return ResponseEntity.notFound().build(); // Devolver error si el autor no existe
        }
    }

}
