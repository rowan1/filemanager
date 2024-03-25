package com.stcassessment.filemanager.dto.space;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaceRequestDTO {
  private String spaceName;
  private String adminUserName;
  private String viewerUserName;
  private String editorUserName;
}
