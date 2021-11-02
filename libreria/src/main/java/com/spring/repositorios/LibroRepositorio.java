
package com.spring.repositorios;

import com.spring.entidades.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,String> {

     @Modifying
    @Query("UPDATE Libro l SET l.titulo = :titulo, l.isbn = :isbn, l.anio = :anio, l.ejemplares = :ejemplares,l.ejemplaresPrestados = :ejemplaresPrestados, l.ejemplaresRestantes = :ejemplaresRestantes, l.autor = :autor, l.editorial = :editorial WHERE l.titulo = :titulo")
    void modificar(@Param("titulo") String titulo, @Param("isbn") Long isbn, @Param("anio") Integer anio, @Param("ejemplares") Integer ejemplares,@Param("ejemplaresPrestados") Integer ejemplaresPrestados,@Param("ejemplaresRestantes") Integer ejemplaresRestantes, @Param("autor") String autor, @Param("editorial") String editorial);

    @Modifying
    @Query("UPDATE Libro l SET u.alta = true WHERE l.titulo = :titulo")
    void habilitar(@Param("titulo") String titulo);
    
}
