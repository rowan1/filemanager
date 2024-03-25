package com.stcassessment.filemanager.service;

import com.stcassessment.filemanager.dto.file.FileMetadataResponseDTO;
import com.stcassessment.filemanager.dto.file.GetFileDataDTO;
import com.stcassessment.filemanager.dto.file.UploadFileRequestDTO;
import com.stcassessment.filemanager.dto.file.FileResponseDTO;

public interface FileService {
  FileResponseDTO uploadFile(UploadFileRequestDTO uploadFileRequestDTO);

  GetFileDataDTO getFileData(Long fileId);

  FileMetadataResponseDTO getFileMetadata(Long fileId);
}
