import java.io.File

fun main(){
    val resDir = File("${System.getProperty("user.dir")}/src/main/resources")
    val generatedDir = File("${System.getProperty("user.dir")}/build/generated")
    val generated = File("${generatedDir.path}/ListTypes.kt")

    generatedDir.mkdirs()
    var types = "\n"

    resDir.listFiles().forEach { file ->
        file.reader().readLines().forEach { line ->
            line.split(",").let {
                types += "                 arrayOf(\"${it[0]}\",\"${it[1]}\"),\n"
            }
        }
    }

    generated.writer().let {
        it.write(
            """
            package ezy.justmime.lib
            
            val allTypes = arrayOf(
            $types
            )
            
            """.trimIndent())
        it.close()
    }
}
