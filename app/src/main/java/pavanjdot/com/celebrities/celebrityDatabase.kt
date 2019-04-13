package pavanjdot.com.celebrities

class celebrityDatabase {

    var celebrityList: ArrayList<celebrity>? = null

    constructor(){

        celebrityList = ArrayList()
        celebrityList?.add(celebrity("Angelena Jolie",
            "Angelena Jolie is an American Acteress",
            R.drawable.angelina_jolie, true))

        celebrityList?.add(
            celebrity("Andrey Hepburn",
            "Andrey Hepburn was a British actress",
            R.drawable.audrey_hepburn, true)
        )

        celebrityList?.add(
            celebrity("Brad Pitt",
            " Brad Pitt is an American actor",
            R.drawable.brad_pitt, true)
        )

        celebrityList?.add(
            celebrity("Elizabeth Taylor",
            "Elizabeth Taylor was a British-Amarican actress",
            R.drawable.elizabeth_taylor, false)
        )

        celebrityList?.add(
            celebrity("Ingrid Bergman",
            "Ingrid Bergman is was a Swedish actress",
            R.drawable.ingrid_bergman, false)
        )

        celebrityList?.add(
            celebrity("James Stewart",
            "James Stewart was an American ",
            R.drawable.james_stewart, false))

        celebrityList?.add(celebrity("Marilyn Monroe",
             "Marilyn Monroe was an American Actress",
            R.drawable.marilyn_monroe, false))



    }
}