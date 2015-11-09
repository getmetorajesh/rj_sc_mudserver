package mud.mutable

object MUDServer extends App{
  println("you name ?")
  val player = Player(readLine(), "inn")
  val rooms = (xml.XML.loadFile("map.xml") \ "room").map(n => {
    val room = Room(n)
    room.keyword -> room
  }).toMap
  println("Welcome to simple text adv")
  rooms(player.currentRoom).print()
  var input = ""
  while(input != "quit") {
    print("> ")
    input = readLine().trim
    if(input != "quit") {
      player.process(input, rooms)
    }
  }
  println("Goodbye !")
}


