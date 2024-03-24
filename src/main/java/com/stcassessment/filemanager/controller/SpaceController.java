package com.stcassessment.filemanager.controller;

import com.stcassessment.filemanager.dto.common.ApiResponse;
import com.stcassessment.filemanager.dto.space.SpaceRequestDTO;
import com.stcassessment.filemanager.dto.space.SpaceResponseDTO;
import com.stcassessment.filemanager.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class SpaceController implements SpaceApi{
  private final SpaceService spaceService;

  @Override
  public ResponseEntity<ApiResponse<SpaceResponseDTO>> createSpace(SpaceRequestDTO spaceRequestDTO) {
    SpaceResponseDTO space = spaceService.createSpace(spaceRequestDTO);
    URI location =
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(space.getId())
                    .toUri();
    return ResponseEntity.created(location)
            .body(new ApiResponse<>(HttpStatus.CREATED.value(), space));
  }
}
