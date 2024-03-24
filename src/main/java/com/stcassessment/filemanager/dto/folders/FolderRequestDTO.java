package com.stcassessment.filemanager.dto.folders;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FolderRequestDTO {
  @NotNull private Long spaceId;
  @NotBlank private String folderName;
  @NotBlank private String userEmail;
}
