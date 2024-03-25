package com.stcassessment.filemanager.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="file_data")
public class FileData {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;
  private long itemId;
  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] file;

  private BigInteger size;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "itemId", referencedColumnName = "id", insertable=false, updatable=false)
  private Item item;

  @CreationTimestamp
  private Timestamp createdAt;
  @UpdateTimestamp
  private Timestamp updatedAt;

}
