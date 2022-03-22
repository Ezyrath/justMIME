import ezy.justmine.lib.allTypes

@JsExport
class MIMEResolver() {
    private val hashByExt = allTypes.associate { it[0] to it[1] }
    private val hashByName = allTypes.associate { it[1] to it[0] }

    fun getByExtension(ext: String): String? {
        return hashByExt[ext]
    }

    fun getByName(name: String): String? {
        return hashByName[name]
    }
}
