import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.streams.toList


suspend fun  main(args: Array<String>) {
    println("Hello World!")
//    val sourcePath = Paths.get("D:/FileDownloads/test.txt")
//    val targetPath = Paths.get("D:/FileLoad/test.txt")
//    //Files.move(sourcePath,targetPath, StandardCopyOption.REPLACE_EXISTING)
//    Files.copy(sourcePath,targetPath, StandardCopyOption.REPLACE_EXISTING)

  //  delay(5l)

    val sharedFolderPath = "D:/FileDownloads"//"\\\\DESKTOP-FMV3MM5\\eb1"
    val fileName = "t5.txt"


    //todo show all files in remote folders

    val folder = Paths.get(sharedFolderPath)

    if (Files.isDirectory(folder)) {

//        val lastTimeFile = Files.walk(folder)
//                .filter { Files.isRegularFile(it) }
//                .map { file ->
//                    val time = file.getTimeFileCreate()//Files.readAttributes(file, BasicFileAttributes::class.java).creationTime()
//
////                    val instant = Instant.ofEpochMilli(time.toMillis() )
////                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
////                            .withZone(ZoneId.systemDefault())
////                    println(formatter.format(instant))
//                    time
//                }
//                .max(Comparator.naturalOrder())
//
//        println(lastTimeFile)
//
//        val lastFile = Files.walk(folder)
//                .filter { Files.isRegularFile(it) }
//                .map { file ->
//                    val time = file.getTimeFileCreate()//Files.readAttributes(file, BasicFileAttributes::class.java).creationTime().toMillis()
//                    val path = file.fileName
//                    time to path
//                }
//                .toList()
//                .toMap()[lastTimeFile.get()]
//
//        println(lastFile)
        val myFile = Files.walk(folder)
                .filter { Files.isRegularFile(it) }
                .map { file ->
                    val time = file.getTimeFileCreate()
                    val name = file.fileName
                    MyFile(name = name.toString(), date = time)
                }
                .toList()
                .maxByOrNull{it.date}

        println(myFile)
    }




    //todo this is work part (get file and save local pc)
/*
     val sharedFilePath = Paths.get(sharedFolderPath,fileName)
    println(Files.getLastModifiedTime(sharedFilePath))
    println(Files.readAttributes(sharedFilePath,BasicFileAttributes::class.java).creationTime())//todo GOOD SOLUTION FOR ME
    if (Files.exists(sharedFilePath)) {
//         val destinationPath = "D:\\FileDownloads"
//         val destinationFile = Paths.get(destinationPath,fileName)
//         Files.move(sharedFilePath,destinationFile,StandardCopyOption.REPLACE_EXISTING)
//         println("ok")


     }
     else
         println("no")

*/
}


fun Path.getTimeFileCreate(): Long =
        Files.readAttributes(this, BasicFileAttributes::class.java).creationTime().toMillis()

data class MyFile(val name: String,
                  val date: Long)