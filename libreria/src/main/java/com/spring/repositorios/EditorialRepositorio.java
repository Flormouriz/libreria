
package com.spring.repositorios;

import com.spring.entidades.Editorial;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,String> {
     @Modifying
    @Query("UPDATE Editorial e SET e.nombre = :nombre WHERE e.id = :id")
    void modificar(@Param ("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Editorial e SET e.alta = true WHERE e.id = :id")
    void habilitar(@Param("id") Integer id);

   
}
