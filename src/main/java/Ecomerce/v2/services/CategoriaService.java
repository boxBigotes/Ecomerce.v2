package Ecomerce.v2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Ecomerce.v2.entitties.Categoria;
import Ecomerce.v2.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository=categoriaRepository;
    }

    //Categorias_All
    public List<Categoria> Categorias_All(){
        return categoriaRepository.findAll();
    }

    //Categoria_findById
    public Optional<Categoria> Categoria_findById(Long id){
        return categoriaRepository.findById(id);
    }

    //Categoria_save
    public Categoria Categoria_save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //Categoria_deleteById
    public void Categoria_deleteById(Long id){
        categoriaRepository.deleteById(id);
    }

    //Categoria_deleteByNombre
     public void Categoria_deleteByNombre(String nombre) {
        categoriaRepository.Categoria_deleteByNombre(nombre);
    }
}
