package com.stcassessment.filemanager.controller;

import com.stcassessment.filemanager.dto.common.ApiErrorResponse;
import com.stcassessment.filemanager.dto.common.ApiResponse;
import com.stcassessment.filemanager.dto.file.FileMetadataResponseDTO;
import com.stcassessment.filemanager.dto.file.UploadFileRequestDTO;
import com.stcassessment.filemanager.dto.file.FileResponseDTO;
import com.stcassessment.filemanager.validation.OneNotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "${api.files.tag.name}", description = "${api.files.tag.desc}")
@RequestMapping("/api/files")
@Valid
public interface FileApi {
  @Operation(
          summary = "${api.files.operation.post.summary}",
          description = "${api.files.operation.post.desc}")
  @ApiResponses(
          value = {
                  @io.swagger.v3.oas.annotations.responses.ApiResponse(
                          responseCode = HttpServletResponse.SC_CREATED + "",
                          description = "${api.response-codes.created.desc}"),
                  @io.swagger.v3.oas.annotations.responses.ApiResponse(
                          responseCode = HttpServletResponse.SC_BAD_REQUEST + "",
                          description = "${api.response-codes.badRequest.desc}",
                          content = {
                                  @Content(
                                          mediaType = "application/json",
                                          schema = @Schema(implementation = ApiErrorResponse.class))
                          }),
                  @io.swagger.v3.oas.annotations.responses.ApiResponse(
                          responseCode = HttpServletResponse.SC_UNAUTHORIZED + "",
                          description = "${api.response-codes.unauthorized.desc}",
                          content = @Content),
                  @io.swagger.v3.oas.annotations.responses.ApiResponse(
                          responseCode = HttpServletResponse.SC_FORBIDDEN + "",
                          description = "${api.response-codes.forbidden.desc}",
                          content = @Content)
          })
  @PostMapping("/upload")
//  @PreAuthorize("hasPermission(#spaceId, 'Folder', {permission: 'EDIT', userEmail: #userEmail})")
  @ResponseStatus(code = HttpStatus.CREATED)
  ResponseEntity<ApiResponse<FileResponseDTO>> uploadFile(
          @OneNotNull(
          fields = {"spaceId", "folderId"},
          message = "{validation.constraints.spaceIdOrFolderId.message}") @ModelAttribute UploadFileRequestDTO uploadFileRequestDTO);

  @GetMapping("/{fileId}/download")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId, @RequestParam("userEmail") String userEmail);

  @GetMapping("/{fileId}/metadata")
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<ApiResponse<FileMetadataResponseDTO>> getFileMetadata(@PathVariable Long fileId, @RequestParam("userEmail") String userEmail);
}
