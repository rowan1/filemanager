package com.stcassessment.filemanager.dto.file;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
public class FileMetadataResponseDTO {
  private BigInteger id;
  private String name;
  private BigInteger size;
  private Timestamp createdAt;
  private Timestamp updatedAt;
}
