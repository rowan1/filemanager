package com.stcassessment.filemanager.service.impl;

import com.stcassessment.filemanager.dto.folders.FolderRequestDTO;
import com.stcassessment.filemanager.dto.folders.FolderResponseDTO;
import com.stcassessment.filemanager.enums.ItemType;
import com.stcassessment.filemanager.model.Item;
import com.stcassessment.filemanager.repository.ItemRepository;
import com.stcassessment.filemanager.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {
  private final ItemRepository itemRepository;
  private final ModelMapper modelMapper;
  @Override
  public FolderResponseDTO createFolder(FolderRequestDTO folderRequestDTO) {
    Item item = new Item();
    item.setName(folderRequestDTO.getFolderName());
    item.setType(ItemType.FOLDER);
    setPermissionGroupId(item, folderRequestDTO.getSpaceId());
    return modelMapper.map(itemRepository.save(item), FolderResponseDTO.class);
  }
  private void setPermissionGroupId(Item item, long spaceId){
    Optional<Item> optionalItem = itemRepository.findById(spaceId);

    if(optionalItem.isPresent()) item.setPermissionGroupId(optionalItem.get().getPermissionGroupId());
  }

}
