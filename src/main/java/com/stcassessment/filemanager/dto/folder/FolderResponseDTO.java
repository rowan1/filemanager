package com.stcassessment.filemanager.dto.folder;

import com.stcassessment.filemanager.enums.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class FolderResponseDTO {
  private long id;
  private String name;
  private ItemType type;
  private Long permissionGroupId;
  private Long rootId;
  private Timestamp createdAt;
}
