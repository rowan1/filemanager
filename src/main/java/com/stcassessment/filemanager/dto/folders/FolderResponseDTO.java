package com.stcassessment.filemanager.dto.folders;

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
  private long permissionGroupId;
  private Timestamp createdAt;
}
