package com.stcassessment.filemanager.repository;

import com.stcassessment.filemanager.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
