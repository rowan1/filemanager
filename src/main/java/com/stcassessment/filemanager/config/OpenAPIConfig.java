package com.stcassessment.filemanager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
  info =
  @Info(
    title = "${info.app.name}",
    version = "${info.app.version}",
    description = "${info.app.description}",
    contact =
    @Contact(
            name = "${info.app.contact.name}",
            url = "${info.app.contact.url}",
            email = "${info.app.contact.email}"),
    termsOfService = "${info.app.termsOfService}",
    license = @License(name = "${info.app.license.name}", url = "${info.app.license.url}")),
  servers = {@Server(url = "${info.app.ingressPath}", description = "Default Server URL Path")})
@Configuration
public class OpenAPIConfig {}