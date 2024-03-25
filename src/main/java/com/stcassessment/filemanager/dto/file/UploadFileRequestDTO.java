package com.stcassessment.filemanager.dto.file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class UploadFileRequestDTO implements Serializable {
  private Long spaceId;
  private Long folderId;
  @NotEmpty private MultipartFile file;
  @NotBlank
  private String fileName;
  @NotBlank private String userEmail;
}
