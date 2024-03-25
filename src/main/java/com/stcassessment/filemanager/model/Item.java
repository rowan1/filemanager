package com.stcassessment.filemanager.model;
import com.stcassessment.filemanager.enums.ItemType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "items")
@ToString
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING) private ItemType type;
  private Long permissionGroupId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "permissionGroupId", referencedColumnName = "id", insertable=false, updatable=false)
  private PermissionGroup permissionGroup;

  private Long rootId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rootId", referencedColumnName = "id", insertable=false, updatable=false)
  private Item root;

  private Long parentId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "parentId", referencedColumnName = "id", insertable=false, updatable=false)
  private Item parent;

  @CreationTimestamp
  private Timestamp createdAt;

  @UpdateTimestamp private Timestamp updatedAt;
}
