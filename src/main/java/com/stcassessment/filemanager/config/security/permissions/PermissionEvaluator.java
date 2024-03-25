package com.stcassessment.filemanager.config.security.permissions;

import com.stcassessment.filemanager.exception.EntityNotFoundException;
import com.stcassessment.filemanager.exception.UserNotAuthorizedException;
import com.stcassessment.filemanager.model.Item;
import com.stcassessment.filemanager.repository.ItemRepository;
import com.stcassessment.filemanager.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PermissionEvaluator {
  private final ItemRepository itemRepository;
  private final PermissionService permissionService;

  public void validateFolderEditAccess(long spaceId, String userEmail){
    if(!permissionService.hasEditPermission(getItem(spaceId).getPermissionGroupId(), userEmail))
      throw new UserNotAuthorizedException("User does not have EDIT access on this space");
  }
  public void validateFolderViewAccess(long spaceId, String userEmail){
    if(!permissionService.hasViewPermission(getItem(spaceId).getPermissionGroupId(), userEmail))
      throw new UserNotAuthorizedException("User does not have VIEW access on this space");
  }

  public void validateFileEditAccess(Long spaceId, Long folderId, String userEmail){
    Item item;
    if(spaceId != null) {
      item = getItem(spaceId);
      if (!permissionService.hasEditPermission(item.getPermissionGroupId(), userEmail))
       throw new UserNotAuthorizedException("User does not have EDIT access on this space");
    }
    if(folderId != null) {
      item = getItem(folderId);
      if (!permissionService.hasEditPermission(item.getRoot().getPermissionGroupId(), userEmail))
        throw new UserNotAuthorizedException("User does not have EDIT access on this space");
    }
  }
  public void validateFileViewAccess(long fileId, String userEmail){
    Item item = getItem(fileId);
    if(item.getRootId() != null) {
      if (!permissionService.hasViewPermission(item.getRoot().getPermissionGroupId(), userEmail))
        throw new UserNotAuthorizedException("User does not have EDIT access on this space");
    }
    else if(item.getParentId() != null) {
      if (!permissionService.hasViewPermission(item.getParent().getRoot().getPermissionGroupId(), userEmail))
        throw new UserNotAuthorizedException("User does not have EDIT access on this space");
    }

  }
  private Item getItem(long itemId){
    return itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException(Item.class, "id", String.valueOf(itemId)));
  }
}
