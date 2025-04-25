# Simple Scala WASM Sample

This is a simple example of how to compile Scala code to WebAssembly (WASM) using ScalaJS and the `scala-cli` tool and Mill project file. The project includes a simple Scala program that prints "Hello, World!" to the console and some basic DOM manipulation when running in the browser.

## Pre-requisites

To run the example, it's recommended to use the `scala-cli` tool. You can install it using the steps from the official website: [Scala CLI](https://scala-cli.virtuslab.org/install).

To run the code in the nodejs environment, you need to have `nodejs` 23 installed for your platform. You can download it from the official website: [Node.js](https://nodejs.org/).

## Compiling the code

### Using Scala-cli

As the first step, you need to build the WASM package and the JavaScript wrapper. This can be done by running the following command:

```bash
scala-cli --power package -f -w wasm/src/scalawasm.scala
```

The `-w` option will keep the compiler running and watching for file changes, recompiling as needed. The output will be generated in the `./main.js` directory. If building one time is enough, you can remove the `-w` option. The `-f` option will force the files to be overwritten if they already exist.

#### Running the code

There are multiple ways to run the code, the simplest is by using the `nodewasm.sh` script which uses nodejs and already have the required parameters.

```bash
./scripts/nodewasm.sh main.js/main.js
```

Running the above command will use nodejs in the command line and will output the result of the Scala program in the console. You should see "Hello from Scala WASM!" printed in the console.

Another option which validates the full example is by running the code in the browser.

To do this, you can use a simple HTTP server on another terminal. If you have Python installed, you can use the following command to start a simple HTTP server:

```bash
python3 -m http.server 8080
```

Or use the provided Scala server from `httpserver.scala`:

```bash
scala-cli webserver/src/httpserver.scala
```

Then, open your web browser and navigate to `http://localhost:8080`. You should see the output of the Scala program in the browser console and main website which have a button with a counter that increments on click.

### Using Mill

Using mill centralizes all operation around it's build project. Below is a compilation of most used tasks for this project:

```sh
# Generating the WASM package
./mill show wasm.fastLinkJS

# The output directory will be shown in the console, usually it is `./out/wasm/fastLinkJS.dest`

# Running the WASM package in the console (with nodejs)
./mill wasm.run

# Running the webserver to serve the WASM package
./mill webserver.run
```

And you can open the web browser and navigate to `http://localhost:8080` to see the output of the Scala program in the browser console and main website which have a button with a counter that increments on click.

## Conclusion

This example demonstrates how to compile Scala code to WebAssembly using ScalaJS and run it in both Node.js and a web browser. You can extend this example by adding more complex Scala code and exploring the capabilities of WebAssembly in your projects. Also Scala libraries built for ScalaJs can be used for your projects.
