package com.stcassessment.filemanager.service;

import com.stcassessment.filemanager.dto.folder.FolderRequestDTO;
import com.stcassessment.filemanager.dto.folder.FolderResponseDTO;

public interface FolderService {
  FolderResponseDTO createFolder(FolderRequestDTO folderRequestDTO);
}
