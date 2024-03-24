package com.stcassessment.filemanager.service;

import com.stcassessment.filemanager.dto.space.SpaceRequestDTO;
import com.stcassessment.filemanager.dto.space.SpaceResponseDTO;

public interface SpaceService {

  SpaceResponseDTO createSpace(SpaceRequestDTO spaceRequestDTO);
  SpaceResponseDTO getSpace(long spaceId);
}
