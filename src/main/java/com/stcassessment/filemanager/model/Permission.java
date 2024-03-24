package com.stcassessment.filemanager.model;

import com.stcassessment.filemanager.enums.PermissionLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "permissions")
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column private String userEmail;
  @Enumerated(EnumType.STRING) private PermissionLevel permissionLevel;
  @Column private long groupId;
  @ManyToOne(optional=false)
  @JoinColumn(name = "groupId", insertable=false, updatable=false)
  private PermissionGroup permissionGroup;
  @CreationTimestamp
  private Timestamp createdAt;
  @UpdateTimestamp
  private Timestamp updatedAt;
}
