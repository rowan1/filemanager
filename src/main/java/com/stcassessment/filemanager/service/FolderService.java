package com.stcassessment.filemanager.service;

import com.stcassessment.filemanager.dto.folders.FolderRequestDTO;
import com.stcassessment.filemanager.dto.folders.FolderResponseDTO;

public interface FolderService {
  FolderResponseDTO createFolder(FolderRequestDTO folderRequestDTO);
}
