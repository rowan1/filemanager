package com.stcassessment.filemanager.controller;
import com.stcassessment.filemanager.dto.common.ApiErrorResponse;
import com.stcassessment.filemanager.dto.common.ApiResponse;
import com.stcassessment.filemanager.dto.space.SpaceRequestDTO;
import com.stcassessment.filemanager.dto.space.SpaceResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletResponse;

@Tag(name = "${api.spaces.tag.name}", description = "${api.spaces.tag.desc}")
@RequestMapping("/api/spaces")
public interface SpaceApi {

  @Operation(
          summary = "${api.spaces.operation.post.summary}",
          description = "${api.spaces.operation.post.desc}")
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
//  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  ResponseEntity<ApiResponse<SpaceResponseDTO>> createSpace(@RequestBody SpaceRequestDTO spaceRequestDTO);
}
