package com.stcassessment.filemanager.dto.space;

import com.stcassessment.filemanager.enums.ItemType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;

@Getter
@Setter
public class SpaceResponseDTO {
  private long id;
  private String name;
  private ItemType type;
  private long permissionGroupId;
  private Timestamp createdAt;
}
