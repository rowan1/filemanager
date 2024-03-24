package com.stcassessment.filemanager.service;

import com.stcassessment.filemanager.enums.PermissionLevel;
import com.stcassessment.filemanager.model.Permission;

import java.util.List;

public interface PermissionService {
  Permission createPermission(String userEmail, PermissionLevel permissionLevel, long adminGroupId);
}
