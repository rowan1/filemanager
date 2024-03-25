package com.stcassessment.filemanager.repository.impl;

import com.stcassessment.filemanager.dto.file.FileMetadataResponseDTO;
import com.stcassessment.filemanager.exception.EntityNotFoundException;
import com.stcassessment.filemanager.model.FileData;
import com.stcassessment.filemanager.repository.FileDataItemCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.math.BigInteger;
import java.sql.Timestamp;

@RequiredArgsConstructor
@Repository
@Slf4j
public class FileDataItemCustomRepositoryImpl implements FileDataItemCustomRepository {
  private final EntityManager entityManager;

  @Override
  public FileMetadataResponseDTO getFileMetadata(Long fileId) {
    String sql = "SELECT items.id, items.name, file_data.size, file_data.created_at, file_data.updated_at " +
            "FROM items inner join file_data on file_data.item_id = items.id " +
            "WHERE items.id = :fileId";

    Query query = entityManager.createNativeQuery(sql);
    query.setParameter("fileId", fileId);

    try {
      Object[] result = (Object[]) query.getSingleResult();

      FileMetadataResponseDTO fileMetadata = new FileMetadataResponseDTO();
      fileMetadata.setId((BigInteger) result[0]);
      fileMetadata.setName((String) result[1]);
      fileMetadata.setSize((BigInteger) result[2]);
      fileMetadata.setCreatedAt((Timestamp) result[3]);
      fileMetadata.setUpdatedAt((Timestamp) result[4]);

      return fileMetadata;
    } catch (NoResultException e) {
      throw new EntityNotFoundException(FileData.class, "id", String.valueOf(fileId));
    }
  }
}
