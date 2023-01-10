package signature
import java.lang.Math.abs
import java.io.File
fun main() {
    val roman = File("C:/roman.txt").readLines(Charsets.US_ASCII)
    val medium = File("C:/medium.txt").readLines(Charsets.US_ASCII)
    val border = "8"
    val nameSpace= " ".repeat(10)
    val statusSpace= " ".repeat(5)
    println("Enter a name and surname:")
    val fullName = readln()
    println("Enter person's status:")
    val status = readln()
    var nameSymbolCount = 0
    var statusSymbolCount = 0
    fullName.forEach { letter -> if(letter.isWhitespace()) nameSymbolCount += 10 else roman.forEach { line -> if(line.first() == letter && line.length <= 4) nameSymbolCount += line.split(" ").last().toInt()} }
    status.forEach { letter -> if(letter.isWhitespace()) statusSymbolCount += 5 else medium.forEach { line -> if(line.first() == letter) statusSymbolCount += line.split(" ").last().toInt()} }
    val isLarger = nameSymbolCount > statusSymbolCount
    val leftIdent = if(isLarger) (nameSymbolCount + 4 - statusSymbolCount) / 2 else (statusSymbolCount + 4 - nameSymbolCount) / 2
    val rightIdent = if(isLarger) nameSymbolCount + 4 - statusSymbolCount - leftIdent else statusSymbolCount + 4 - nameSymbolCount - leftIdent
    val borderReplication = 8 + if(isLarger) nameSymbolCount else statusSymbolCount
    println(border.repeat(borderReplication))
    printFont(fullName, roman, nameSpace, if(isLarger) 2 else leftIdent , if(isLarger) 2 else rightIdent)
    printFont(status, medium, statusSpace, if(!isLarger) 2 else leftIdent , if(!isLarger) 2 else rightIdent)
    println(border.repeat(borderReplication))
}
fun printFont(name: String, font: List<String>, space: String, leftIdent: Int, rightIdent: Int) {
    val size = font[0].split(" ").first().toInt()
    var pointer = 1
    while(pointer <= size){
        print("8".repeat(2) + " ".repeat(leftIdent))
        name.forEach { letter -> if(letter.isWhitespace()) print(space)  else font.forEachIndexed{i, line -> if(font[i].first() == letter && line.length <= 4) print(font[i + pointer])} }
        print(" ".repeat(rightIdent) + "8".repeat(2))
        println()
        pointer++
    }
}
