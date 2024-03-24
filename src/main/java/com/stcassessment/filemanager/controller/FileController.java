package com.stcassessment.filemanager.controller;

import com.stcassessment.filemanager.config.security.permissions.PermissionEvaluator;
import com.stcassessment.filemanager.dto.common.ApiResponse;
import com.stcassessment.filemanager.dto.file.FileMetadataResponseDTO;
import com.stcassessment.filemanager.dto.file.GetFileDataDTO;
import com.stcassessment.filemanager.dto.file.UploadFileRequestDTO;
import com.stcassessment.filemanager.dto.file.FileResponseDTO;
import com.stcassessment.filemanager.model.FileData;
import com.stcassessment.filemanager.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class FileController implements FileApi{

  private final FileService fileService;
  private final PermissionEvaluator permissionEvaluator;
  @Override
  public ResponseEntity<ApiResponse<FileResponseDTO>> uploadFile(UploadFileRequestDTO uploadFileRequestDTO) {
    permissionEvaluator.validateFileEditAccess(uploadFileRequestDTO.getSpaceId(),
            uploadFileRequestDTO.getFolderId(), uploadFileRequestDTO.getUserEmail());

    FileResponseDTO file = fileService.uploadFile(uploadFileRequestDTO);
    URI location =
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(file.getId())
                    .toUri();
    return ResponseEntity.created(location)
            .body(new ApiResponse<>(HttpStatus.CREATED.value(), file));
  }

  @Override
  public ResponseEntity<byte[]> downloadFile(Long fileId, String userEmail) {
    permissionEvaluator.validateFileViewAccess(fileId, userEmail);

    GetFileDataDTO fileData = fileService.getFileData(fileId);

    // Set response headers
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.setContentDispositionFormData("attachment", fileData.getFileName());

    // Return the file binary data as the response body
    return new ResponseEntity<>(fileData.getFileBytes(), headers, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse<FileMetadataResponseDTO>> getFileMetadata(Long fileId, String userEmail) {
    permissionEvaluator.validateFileViewAccess(fileId, userEmail);
    FileMetadataResponseDTO fileMetadata = fileService.getFileMetadata(fileId);
    return ResponseEntity.ok()
            .body(new ApiResponse<>(HttpStatus.OK.value(), fileMetadata));
  }
}
