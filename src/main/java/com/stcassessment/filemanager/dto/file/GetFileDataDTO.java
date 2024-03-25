package com.stcassessment.filemanager.dto.file;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetFileDataDTO {
  private byte[] fileBytes;
  private String fileName;
}
