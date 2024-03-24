package com.stcassessment.filemanager.dto.file;

import com.stcassessment.filemanager.enums.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class FileResponseDTO {
  private long id;
  private String name;
  private ItemType type;
  private Long permissionGroupId;
  private Long parentId;
  private Timestamp createdAt;
}
