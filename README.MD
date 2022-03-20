# justMIME

## Install

```shell
podman build . -t justmime-builder
```

## Build
```shell
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

> :warning: Work with container entrypoint (without launch prefix)

* Test library
```shell
launch lib test
```

* Build and distribution
```shell
launch build
```

## Fix intellij generated code resolution (For Dev)

> Temporary solution while waiting to find better

1. `File > Project Structure` -> import module
2. Select `lib/build/generated/ksp/metadata`
3. Add module `metadata` as a dependencies in module `commonMain`
