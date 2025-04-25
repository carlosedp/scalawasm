#!/bin/bash

# Load the WASM module from js file

node --experimental-wasm-exnref --experimental-wasm-jspi --experimental-wasm-imported-strings --turboshaft-wasm "$1"
