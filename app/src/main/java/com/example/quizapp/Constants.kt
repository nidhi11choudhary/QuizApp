package com.example.quizapp

object Constants {

    const val User_Name : String = "User_Name"
    const val Tatal_que : String = "Tatal_que"
    const val Correct_Ans : String = "Correct_Ans"

    fun getQuestionsList() : ArrayList<Questions>{
        var questionList = ArrayList<Questions>()

        val question1 = Questions(1, "How to pass the data between activities in Android?",
            "Intent", "Content Provider", "Broadcast receiver",
            "None of the Above", 1)

        val question2 = Questions(2, "Which of the following is/are are the subclasses in Android?",
            "Action Bar Activity", "Launcher Activity", "Preference Activity",
            "All of above", 4)

        val question3 = Questions(3, "Which of the following is a valid declaration of a char in Java?",
            "char ch = '\'utea';", "char ca = 'tea';", "char cr = \u0223;",
            "char cc = '\'itea';", 1)

        val question4 = Questions(4, "What is the return type of the hashCode() method in the Object class?",
            "Object", "int", "long",
            "void", 2)

        val question5 = Questions(5, "What does the expression float a = 35 / 0 return?",
            "0", "Not a Number", "Infinity",
            "Run time exception", 3)

        val question6 = Questions(6, "Which permissions are required to get a location in android?",
            "ACCESS_FINE and ACCESS_COARSE", "GPRS permission", "Internet permission",
            "WIFI permission", 1)

        val question7 = Questions(7, "Which method of the Class.class is used to determine the name of a class represented by the class object as a String?",
            "getClass()", "intern()", "getName()",
            "toString()", 3)

        val question8 = Questions(8, "What is JSON in android?",
            "Java Script Object Native", "Java Script Oriented Notation", "Java Script Object Notation",
            "None of the Above", 3)

        val question9 = Questions(9, "An interface with no fields or methods is known as a ______.",
            "Runnable Interface", "Marker Interface", "Abstract Interface",
            "CharSequence Interface", 2)

        val question10 = Questions(10, "What is sleep mode in android?",
            "Only Radio interface layer and alarm are in active mode", "Switched off", "Air plane mode",
            "None of the Above", 1)

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)

        return questionList
    }
}