package com.stcassessment.filemanager.service.impl;

import com.stcassessment.filemanager.dto.file.FileMetadataResponseDTO;
import com.stcassessment.filemanager.dto.file.GetFileDataDTO;
import com.stcassessment.filemanager.dto.file.UploadFileRequestDTO;
import com.stcassessment.filemanager.dto.file.FileResponseDTO;
import com.stcassessment.filemanager.enums.ItemType;
import com.stcassessment.filemanager.exception.EntityNotFoundException;
import com.stcassessment.filemanager.model.FileData;
import com.stcassessment.filemanager.model.Item;
import com.stcassessment.filemanager.repository.FileDataRepository;
import com.stcassessment.filemanager.repository.ItemRepository;
import com.stcassessment.filemanager.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import java.math.BigInteger;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {
  private final ItemRepository itemRepository;
  private final FileDataRepository fileDataRepository;
  private final ModelMapper modelMapper;

  @Override
  public FileResponseDTO uploadFile(UploadFileRequestDTO uploadFileRequestDTO) {
    log.info("Uploading file to {} / {} with name {}.",
            uploadFileRequestDTO.getSpaceId(), uploadFileRequestDTO.getFolderId(), uploadFileRequestDTO.getFileName());
    Item item = new Item();
    item.setName(uploadFileRequestDTO.getFileName());
    item.setType(ItemType.FILE);
    item.setParentId(uploadFileRequestDTO.getFolderId());
    item.setRootId(uploadFileRequestDTO.getSpaceId());
    itemRepository.save(item);

    createFileData(item.getId(), uploadFileRequestDTO.getFile());
    return modelMapper.map(item, FileResponseDTO.class);
  }

  private void createFileData(long fileId, MultipartFile file){
    if (file.isEmpty()) {
      throw new ValidationException("Please select a file to upload");
    }

    try {
      byte[] fileBytes = file.getBytes();
      FileData fileData = new FileData();
      fileData.setItemId(fileId);
      fileData.setFile(fileBytes);
      fileData.setSize(BigInteger.valueOf(file.getSize()));
      fileDataRepository.save(fileData);

    } catch (Exception e) {
      throw new ValidationException("Failed to upload file: " + e.getMessage());
    }
  }
  @Override
  public GetFileDataDTO getFileData(Long fileId) {
    GetFileDataDTO fileDataDTO = new GetFileDataDTO();
    FileData fileData = fileDataRepository.findByItemId(fileId)
            .orElseThrow(() -> new EntityNotFoundException(FileData.class, "id", String.valueOf(fileId)));
    fileDataDTO.setFileBytes(fileData.getFile());
    fileDataDTO.setFileName(fileData.getItem().getName());
    return fileDataDTO;
  }

  @Override
  public FileMetadataResponseDTO getFileMetadata(Long fileId) {
    return fileDataRepository.getFileMetadata(fileId);
  }
}
