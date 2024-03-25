package com.stcassessment.filemanager.service.impl;


import com.stcassessment.filemanager.model.PermissionGroup;
import com.stcassessment.filemanager.repository.PermissionGroupRepository;
import com.stcassessment.filemanager.service.PermissionGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionGroupServiceImpl implements PermissionGroupService {
  private final PermissionGroupRepository permissionGroupRepository;
  @Override
  public PermissionGroup createPermissionGroup(String userName) {
    PermissionGroup adminGroup = new PermissionGroup();
    adminGroup.setGroupName(userName);
    return permissionGroupRepository.save(adminGroup);
  }
}
