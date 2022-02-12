import java.io.File

val filePath = "C:\\Users\\leopa\\AppData\\Roaming\\OuterWildsModManager\\OWML\\Mods\\smallbug.TRAPPIST-1\\kotlin\\"

fun main() {
    val lines = File(filePath + "input").readLines()
    val path = lines[0]

    var props = ""
    for (i in 1 .. lines.size-1) {
        if (lines[i].contains("New Horizons")) continue
        props += createProp(path, lines[i])
    }

    File(filePath + "output").writeText(props)
}

fun createProp(path: String, position: String): String {
    var prop = "{\n"
    prop += "   \"path\": \"${path}\",\n"
    prop += "   \"position\": {${formatPosition(position)}},\n"
    prop += "   \"alignToNormal\": true\n"
    prop += "},\n"
    return prop
}

fun formatPosition(position: String): String {
    var newString = position
    newString = newString.split("{")[1]
    newString = newString.split("}")[0]
    return newString
}

main()