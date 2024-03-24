package com.stcassessment.filemanager.repository;

import com.stcassessment.filemanager.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {
}
