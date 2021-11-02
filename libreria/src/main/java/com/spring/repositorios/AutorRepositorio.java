
package com.spring.repositorios;

import com.spring.entidades.Autor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,String> {
    
       @Modifying
    @Query("UPDATE Autor a SET a.nombre = :nombre WHERE a.id = :id")
    void modificar(@Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Autor a SET a.alta = true WHERE a.id = :id")
    void habilitar(@Param("id") Integer id);
}
