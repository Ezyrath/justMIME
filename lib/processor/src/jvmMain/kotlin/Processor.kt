import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import java.io.OutputStreamWriter

class Processor(val codeGenerator: CodeGenerator, val logger: KSPLogger) : SymbolProcessor {
    var invoked = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (invoked) {
            return emptyList()
        }
        invoked = true

        codeGenerator.createNewFile(Dependencies(false), "", "TypesMIME", "kt").use { output ->
            OutputStreamWriter(output).use { writer ->
                writer.write("""
                    package ezy.justmine.lib
                    
                    val allTypes = arrayOf(
                        arrayOf("pdf", "application/pdf"),
                        arrayOf("odt", "it a doc HAHA !")
                    )
                    
                """.trimIndent())
            }
        }
        return emptyList()
    }
}

class ProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return Processor(environment.codeGenerator, environment.logger)
    }
}
