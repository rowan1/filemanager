package com.stcassessment.filemanager.config.security.permissions;


import com.stcassessment.filemanager.dto.space.SpaceResponseDTO;
import com.stcassessment.filemanager.exception.EntityNotFoundException;
import com.stcassessment.filemanager.exception.UserNotAuthorizedException;
import com.stcassessment.filemanager.model.Item;
import com.stcassessment.filemanager.repository.ItemRepository;
import com.stcassessment.filemanager.service.PermissionService;
import com.stcassessment.filemanager.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PermissionEvaluator {
  private final SpaceService spaceService;
  private final ItemRepository itemRepository;
  private final PermissionService permissionService;

  public void validateEditAccess(long itemId, String userEmail)  {
    if(!permissionService.hasEditPermission(getItem(itemId).getPermissionGroupId(), userEmail))
      throw new UserNotAuthorizedException("User does not have VIEW access on this space");
  }
  public void validateViewAccess(Long itemId, String userEmail) throws UserNotAuthorizedException {
    if(!permissionService.hasViewPermission(getItem(itemId).getPermissionGroupId(), userEmail))
      throw new UserNotAuthorizedException("User does not have VIEW access on this space");
  }
  private Item getItem(long itemId){
    return itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException(Item.class, "id", String.valueOf(itemId)));

  }
}
