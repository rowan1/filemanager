# filemanager

# JPA Entities:
Item: Represents the items in the file system. \
FileData: Holds the binary data of files. \
PermissionGroup: Represents permission groups. \
Permission: Associates users with permission levels and groups. \

# RESTful API Design:
POST /api/space: Create a new space and assign permission groups. \
POST /api/space/{spaceId}/folder: Create a new folder under a space. \
POST /api/folder/{folderId}/file: Upload a new file under a folder. \
GET /api/file/{fileId}/metadata: View metadata of a file. \
GET /api/file/{fileId}/download: Download a file. \

## Implementation:
### Controller Layer:

SpaceController: Handles requests related to spaces.
FolderController: Handles requests related to folders.
FileController: Handles requests related to files.

### Service Layer:

SpaceService: Implements business logic for spaces.
FolderService: Implements business logic for folders.
FileService: Implements business logic for files.

### Repository Layer:

ItemRepository: Interacts with the database for CRUD operations on items. \
FileDataRepository: Interacts with the database for file-related operations. \

### Security Layer (optional but recommended):

Use Spring Security to handle authentication and authorization.
Define custom authentication providers and authorization rules.

### Exception Handling:

Implement global exception handlers to handle errors gracefully.
Configuration:

Configure database connection and other properties using application.yml.
