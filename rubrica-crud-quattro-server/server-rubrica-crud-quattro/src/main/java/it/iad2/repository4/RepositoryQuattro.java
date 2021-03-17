package it.iad2.repository4;

import it.iad2.model4.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryQuattro extends JpaRepository<Contatto, Long> {

    public Contatto findByNome(String s);

}
