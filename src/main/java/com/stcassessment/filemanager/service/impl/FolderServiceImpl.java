package com.stcassessment.filemanager.service.impl;

import com.stcassessment.filemanager.dto.folder.FolderRequestDTO;
import com.stcassessment.filemanager.dto.folder.FolderResponseDTO;
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
    item.setRootId(folderRequestDTO.getSpaceId());
    return modelMapper.map(itemRepository.save(item), FolderResponseDTO.class);
  }

}
