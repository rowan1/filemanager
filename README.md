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


### How to run
#### Docker
```shell
docker-compose up
```

### Hot to use
```shell
curl --location 'http://localhost:8087/api/spaces' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=4ABE8CDE60D3704B2FDF69D5A312D423' \
--data-raw '{
    "spaceName":"stc-assessments",
    "adminUserName": "admin",
    "viewerUserName": "viewer@example.com",
    "editorUserName": "editor@example.com"
}'
```
Response: \
{ \
    "status": 201, \
    "timestamp": "2024-03-25T00:29:03.284498", \
    "data": { \
        "id": 19, \
        "name": "stc-assessments", \
        "type": "SPACE", \
        "permissionGroupId": 16, \
        "createdAt": "2024-03-24T22:29:03.248+00:00" \
    } \
}

```shell
curl --location 'http://localhost:8087/api/folders' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=4ABE8CDE60D3704B2FDF69D5A312D423' \
--data-raw '{
    "spaceId":19,
    "folderName": "backend",
    "userEmail": "editor@example.com"
}'
```

Response: \
{ \
    "status": 201, \
    "timestamp": "2024-03-25T01:04:26.09013", \
    "data": { \
        "id": 22, \
        "name": "backend", \
        "type": "FOLDER", \
        "permissionGroupId": null, \
        "rootId": 19, \
        "createdAt": "2024-03-24T23:04:26.074+00:00" \
    }
}