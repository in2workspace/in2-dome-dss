# Change Log

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [release v1.0.0] (https://dev.azure.com/in2Gencat/Gene_identitat_empleat_public/_git/gencat-iep-remote-signature-ms?version=GTv1.0.0-SNAPSHOT) - 2024-03-07

### Added
- Added security configuration for the application.
- Defined security filters and rules for HTTP requests.
- Enabled centralized cross-origin resource sharing (CORS) to allow frontend applications to call the endpoints.
- Azure configuration setup and service for accessing Azure App Configuration properties.
- Added configuration for OpenAPI documentation generation.
- Add `SignatureServiceFactory` interface and provides functionality for creating signature services based on the type of signature.
- Add `SignatureService` to provide functionality for signing data using COSE (CBOR Object Signing and Encryption) and signing data using JAdES (Joint Electronic Signature).
- Added utility class for HTTP-related operations.
- Added unit tests for controllers, dtos, exceptions, services and utils.
- Added abstract configuration properties
- Added abstract service properties
- Added abstract vault configuration 
- Added abstract vault service
- Added IDEP Certificate Signature
- Added dynamic version in pipelines