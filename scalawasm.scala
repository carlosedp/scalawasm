//> using scala 3
//> using platform js
//> using jsEmitWasm
//> using jsModuleKind es
//> using jsModuleSplitStyleStr fewestmodules

//> using dep org.scala-js::scalajs-dom::2.8.0

import scala.scalajs.js
import org.scalajs.dom

@main
def main(): Unit =
  println("Hello from Scala WASM!")
  // Check if document is defined
  if js.typeOf(dom.document) != "undefined" then
    // If document is defined, call the helloWorld function
    helloWorld()
  else
    println("Document is not defined, running in the console...")

// Create a simple method that prints "Hello from Scala WASM!" as HTML and a button with a counter
def helloWorld(): Unit =
  dom.document.querySelector("#app").innerHTML = s"""
  <div>
  <h1>Hello from Scala WASM!</h1>
      <div class="card">
        <button id="counter" type="button"></button>
      </div>
    </div>
  """
  setupCounter(dom.document.getElementById("counter"))

def setupCounter(element: dom.Element): Unit =
  var counter = 0

  def setCounter(count: Int): Unit =
    counter = count
    element.innerHTML = s"count is $counter"

  element.addEventListener("click", e => setCounter(counter + 1))
  setCounter(0)
