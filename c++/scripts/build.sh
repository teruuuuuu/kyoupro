#!/bin/bash

cd "$(dirname "$0")"
cd ../build

cmake -S ../ -B build
make
