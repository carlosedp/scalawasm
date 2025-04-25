//> using scala 3
//> using platform jvm
//> using dep com.lihaoyi::cask:0.10.2
//> using dep com.lihaoyi::os-lib:0.11.4
//> using resourceDir ../resources
//> using resourceDir ../../main.js

object StaticFiles extends cask.MainRoutes:
  override def port: Int = 8080

  @cask.get("/")
  def index() =
    cask.Response(
      os.read.bytes(os.resource / "index.html"),
      headers = Seq("Content-Type" -> "text/html"),
    )

  @cask.staticResources("/main.js/")
  def staticResourceRoutes() = "."

  println("Serving static files on http://localhost:" + port)
  initialize()
end StaticFiles
