package com.stcassessment.filemanager.service.impl;

import com.stcassessment.filemanager.enums.PermissionLevel;
import com.stcassessment.filemanager.model.Permission;
import com.stcassessment.filemanager.repository.PermissionRepository;
import com.stcassessment.filemanager.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
  private final PermissionRepository permissionRepository;
  @Override
  public Permission createPermission(String userEmail, PermissionLevel permissionLevel, long adminGroupId) {
    Permission permission = new Permission();
    permission.setUserEmail(userEmail);
    permission.setPermissionLevel(permissionLevel);
    permission.setGroupId(adminGroupId);
    return permissionRepository.save(permission);
  }

  @Override
  public boolean hasViewPermission(long permissionGroupId, String userName) {
    return !permissionRepository.findByGroupIdAndUserEmailAndPermissionLevel(permissionGroupId, userName, PermissionLevel.VIEW).isEmpty();
  }

  @Override
  public boolean hasEditPermission(long permissionGroupId, String userName) {
    return !permissionRepository.findByGroupIdAndUserEmailAndPermissionLevel(permissionGroupId, userName, PermissionLevel.EDIT).isEmpty();
  }
}
