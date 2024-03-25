package com.stcassessment.filemanager.repository;

import com.stcassessment.filemanager.enums.PermissionLevel;
import com.stcassessment.filemanager.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
  List<Permission> findByGroupIdAndUserEmailAndPermissionLevel(long groupId, String userEmail, PermissionLevel permissionLevel);
}
