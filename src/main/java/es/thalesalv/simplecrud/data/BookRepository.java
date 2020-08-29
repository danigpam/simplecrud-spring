package es.thalesalv.simplecrud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.thalesalv.simplecrud.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}