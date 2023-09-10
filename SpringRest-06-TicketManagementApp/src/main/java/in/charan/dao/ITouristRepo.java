package in.charan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.charan.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
