package bg.softuni.pathfinderDemo.repository;

import bg.softuni.pathfinderDemo.model.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Pictures, Long> {

    @Query("SELECT p.url from Pictures p")
    List<String> findAllUrls();
}
