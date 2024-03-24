package com.stcassessment.filemanager.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties("constants")
public class ConfigProperties {
  private String spaceName;
  private String userViewer;
  private String userEditor;
  private String userAdmin;
}