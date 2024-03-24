package com.stcassessment.filemanager.controller;

import com.stcassessment.filemanager.config.security.permissions.PermissionEvaluator;
import com.stcassessment.filemanager.dto.common.ApiResponse;
import com.stcassessment.filemanager.dto.folders.FolderRequestDTO;
import com.stcassessment.filemanager.dto.folders.FolderResponseDTO;
import com.stcassessment.filemanager.dto.space.SpaceResponseDTO;
import com.stcassessment.filemanager.exception.UserNotAuthorizedException;
import com.stcassessment.filemanager.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class FolderController implements FolderApi{
  private final PermissionEvaluator permissionEvaluator;
  private final FolderService folderService;
  @Override
  public ResponseEntity<ApiResponse<FolderResponseDTO>> createFolder(FolderRequestDTO folderRequestDTO) {
    permissionEvaluator.validateEditAccess(folderRequestDTO.getSpaceId(), folderRequestDTO.getUserEmail());

    FolderResponseDTO folder = folderService.createFolder(folderRequestDTO);
    URI location =
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(folder.getId())
                    .toUri();
    return ResponseEntity.created(location)
            .body(new ApiResponse<>(HttpStatus.CREATED.value(), folder));
  }
}
