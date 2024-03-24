package com.stcassessment.filemanager.repository;

import com.stcassessment.filemanager.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>, FileDataItemCustomRepository {
  Optional<FileData> findByItemId(long itemId);
}
