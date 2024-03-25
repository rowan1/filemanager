package com.stcassessment.filemanager.service;

import com.stcassessment.filemanager.enums.PermissionLevel;
import com.stcassessment.filemanager.model.Permission;

public interface PermissionService {
  Permission createPermission(String userEmail, PermissionLevel permissionLevel, long adminGroupId);
  boolean hasViewPermission(long permissionGroupId, String userName);
  boolean hasEditPermission(long permissionGroupId, String userName);
}
