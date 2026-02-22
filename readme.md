# HDA using preact components

Hypermedia Driven Application using preact components

Proof of Concept for the architecture described
by Thomas Schilling's https://tschuehly.de/preact-islands-in-spring-boot-with-htmx-when-alpinejs-isnt-enough-anymore[great article].

## Stack

- Spring Boot
- JTE
- preact (for JSX components and signals)

## Usage

- In a Terminal in the root folder run `bun run watch`  
  (there is also the IntelliJ run configuration 'bun watch' to do this)
- Start Springboot Application (`src/main/java/org/svenehrke/demo/Application.java`)
- Point browser to: http://localhost:8080/ which should display page1

## Further Info

- https://tschuehly.de/preact-islands-in-spring-boot-with-htmx-when-alpinejs-isnt-enough-anymore

