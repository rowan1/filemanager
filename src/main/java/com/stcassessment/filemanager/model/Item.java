package com.stcassessment.filemanager.model;
import com.stcassessment.filemanager.enums.ItemType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column private String name;
  @Enumerated(EnumType.STRING) private ItemType type;
  @Column private long permissionGroupId;
  @CreationTimestamp
  private Timestamp createdAt;
  @UpdateTimestamp private Timestamp updatedAt;
}
