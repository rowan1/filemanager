package com.stcassessment.filemanager.controller;

import com.stcassessment.filemanager.dto.common.ApiErrorResponse;
import com.stcassessment.filemanager.dto.common.ApiResponse;
import com.stcassessment.filemanager.dto.folder.FolderRequestDTO;
import com.stcassessment.filemanager.dto.folder.FolderResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@Tag(name = "${api.folders.tag.name}", description = "${api.folders.tag.desc}")
@RequestMapping("/api/folders")
public interface FolderApi {

  @Operation(
          summary = "${api.folders.operation.post.summary}",
          description = "${api.folders.operation.post.desc}")
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
  @PostMapping()
//  @PreAuthorize("hasPermission(#spaceId, 'Space', {permission: 'EDIT', userEmail: #userEmail})")
  @ResponseStatus(code = HttpStatus.CREATED)
  ResponseEntity<ApiResponse<FolderResponseDTO>> createFolder(@RequestBody FolderRequestDTO folderRequestDTO);
}
