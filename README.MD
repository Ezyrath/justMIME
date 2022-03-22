# justMIME

justMIME allows you to resolve the MIME types :
* Get the MIME types for the extension file `pdf -> application/pdf` use `getByExtension`
* Get the extension file for the MIME types `application/pdf -> pdf` use `getByName`

https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_Types

## Download
* [For Javascript / Node.js](/build/justmime.js)

## Use for Javascript

```html
<script src="justmime.js"></script>
```

```javascript
const mime = new justmime.MIMEResolver()

mime.getByExtension("pdf")
mime.getByName("application/pdf")
```

## Use for Node.js
```javascript
const MIMEResolver = new require("./justmime.js").MIMEResolver
const mime = new MIMEResolver()

mime.getByExtension("pdf");
mime.getByName("application/pdf")
```

## Build
```shell
podman build . -t justmime-builder
podman run -it -v $(pwd):/opt/justmime:z --name justmime-build justmime-builder build
```

## Dev Container

### create
```shell
podman create -it -v $(pwd):/opt/justmime:z --name justmime-dev justmime-builder
```

### start
```shell
podman start -ia justmime-dev
```

### List of command (in container)

```shell
launch generate #generate code before use by the lib
launch build    #build and distribution 
```
