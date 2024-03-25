package com.stcassessment.filemanager.repository;

import com.stcassessment.filemanager.dto.file.FileMetadataResponseDTO;
import org.springframework.stereotype.Repository;

public interface FileDataItemCustomRepository {
  FileMetadataResponseDTO getFileMetadata(Long fileId);
}
