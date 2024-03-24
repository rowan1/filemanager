package com.stcassessment.filemanager.service.impl;

import com.stcassessment.filemanager.config.ConfigProperties;
import com.stcassessment.filemanager.dto.space.SpaceRequestDTO;
import com.stcassessment.filemanager.dto.space.SpaceResponseDTO;
import com.stcassessment.filemanager.enums.ItemType;
import com.stcassessment.filemanager.enums.PermissionLevel;
import com.stcassessment.filemanager.model.Item;
import com.stcassessment.filemanager.model.Permission;
import com.stcassessment.filemanager.model.PermissionGroup;
import com.stcassessment.filemanager.repository.ItemRepository;
import com.stcassessment.filemanager.repository.PermissionRepository;
import com.stcassessment.filemanager.service.PermissionGroupService;
import com.stcassessment.filemanager.service.PermissionService;
import com.stcassessment.filemanager.service.SpaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpaceServiceImpl implements SpaceService {
  private final ConfigProperties configProperties;
  private final ItemRepository itemRepository;
  private final ModelMapper modelMapper;
  private final PermissionService permissionService;
  private final PermissionGroupService permissionGroupService;

  //  private final PermissionRepository permissionRepository;
  @Override
  public SpaceResponseDTO createSpace(SpaceRequestDTO spaceRequestDTO) {

    // Create a new space
    log.info("Creating new space.");
    Item spaceItem = new Item();
    spaceItem.setName(spaceRequestDTO.getSpaceName());
    spaceItem.setType(ItemType.SPACE);

    // Create a permission group named "admin" with VIEW and EDIT access
    log.info("Creating new Permission Group for User Admin {}.", spaceRequestDTO.getAdminUserName());
    PermissionGroup adminGroup = permissionGroupService.createPermissionGroup(spaceRequestDTO.getAdminUserName());

    // Add EDIT access
    log.info("Creating new Permission for user {} as editor.", spaceRequestDTO.getEditorUserName());
    permissionService.createPermission(spaceRequestDTO.getEditorUserName(), PermissionLevel.EDIT, adminGroup.getId());

    // Add VIEW access
    log.info("Creating new Permission for user {} as viewer.", spaceRequestDTO.getViewerUserName());
    permissionService.createPermission(spaceRequestDTO.getViewerUserName(), PermissionLevel.VIEW, adminGroup.getId());

    // Assign the permission group to the created space
    spaceItem.setPermissionGroupId(adminGroup.getId());
    log.info("A new space is created.");
    return modelMapper.map(itemRepository.save(spaceItem), SpaceResponseDTO.class);
  }
}