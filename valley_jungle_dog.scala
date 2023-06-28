//File: MindfulNetworking.scala 

//Imports
import scala.util.Try
import scala.io.Source
import java.net.Socket

// Networking Utilities
object NetworkingUtils { 
  def getSocket(host: String, port: Int): Option[Socket] = Try(new Socket(host, port)).toOption 
  def readLines(socket: Socket): Option[List[String]] = Try(Source.fromInputStream(socket.getInputStream).getLines.toList).toOption 
  def write(socket: Socket, line: String): Try[Unit] = Try(socket.getOutputStream.write(line.getBytes)) 
} 

// Networking Service
trait NetworkingService { 
  def getLines(host: String, port: Int): Option[List[String]] = for { 
   socket <- NetworkingUtils.getSocket(host, port) 
   lines <- NetworkingUtils.readLines(socket) 
  } yield lines 
 
  def write(host: String, port: Int, line: String): Try[Unit] = 
    NetworkingUtils.getSocket(host, port).flatMap(socket => NetworkingUtils.write(socket, line)) 
}

object MindfulNetworking extends NetworkingService { 
  def mindfulGetLines(host: String, port: Int): Option[List[String]] = { 
    val startTime = System.nanoTime() 
    val result = getLines(host, port) 
    val endTime = System.nanoTime() 
    println(s"Getting lines from $host:$port took ${(endTime - startTime) / 1000000} ms.") 
    result 
  } 

  def mindfulWrite(host: String, port: Int, line: String): Try[Unit] = { 
    val startTime = System.nanoTime() 
    val result = write(host, port, line) 
    val endTime = System.nanoTime() 
    println(s"Writing '$line' to $host:$port took ${(endTime - startTime) / 1000000} ms.") 
    result 
  } 
}