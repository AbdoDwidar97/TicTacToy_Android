package com.example.abd_el_rahman.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Btn_Select(view : View){
        val Btn_Choice = view as Button
        var CellID : Int = 0
        when(Btn_Choice.id){

            R.id.Btn1 -> CellID = 1
            R.id.Btn2 -> CellID = 2
            R.id.Btn3 -> CellID = 3
            R.id.Btn4 -> CellID = 4
            R.id.Btn5 -> CellID = 5
            R.id.Btn6 -> CellID = 6
            R.id.Btn7 -> CellID = 7
            R.id.Btn8 -> CellID = 8
            R.id.Btn9 -> CellID = 9
        }
        GameEngine(Btn_Choice , CellID)

    }


    var Pl1 = ArrayList<Int>()
    var Pl2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun GameEngine(Btn_Choice : Button , CellID : Int){

        if(ActivePlayer == 1){
            Btn_Choice.text = "X"
            Pl1.add(CellID)
            Btn_Choice.setBackgroundResource(R.color.BLUE)
            ActivePlayer = 2
            AutoPlay()
        }else{
            Btn_Choice.text = "O"
            Pl2.add(CellID)
            Btn_Choice.setBackgroundResource(R.color.Green)
            ActivePlayer = 1
        }
        Btn_Choice.isEnabled = false
        WinGame()
    }

    fun WinGame(){
        var Winner = -1

        //Row1
        if(Pl1.contains(1) && Pl1.contains(2) && Pl1.contains(3)){
            Winner = 1
        }
        if(Pl2.contains(1) && Pl2.contains(2) && Pl2.contains(3)){
            Winner = 2
        }


        //Row2
        if(Pl1.contains(4) && Pl1.contains(5) && Pl1.contains(6)){
            Winner = 1
        }
        if(Pl2.contains(4) && Pl2.contains(5) && Pl2.contains(6)){
            Winner = 2
        }


        //Row3
        if(Pl1.contains(7) && Pl1.contains(8) && Pl1.contains(9)){
            Winner = 1
        }
        if(Pl2.contains(7) && Pl2.contains(8) && Pl2.contains(9)){
            Winner = 2
        }


        //Col1
        if(Pl1.contains(1) && Pl1.contains(4) && Pl1.contains(7)){
            Winner = 1
        }
        if(Pl2.contains(1) && Pl2.contains(4) && Pl2.contains(7)){
            Winner = 2
        }


        //Col2
        if(Pl1.contains(2) && Pl1.contains(5) && Pl1.contains(8)){
            Winner = 1
        }
        if(Pl2.contains(2) && Pl2.contains(5) && Pl2.contains(8)){
            Winner = 2
        }


        //Col3
        if(Pl1.contains(3) && Pl1.contains(6) && Pl1.contains(9)){
            Winner = 1
        }
        if(Pl2.contains(3) && Pl2.contains(6) && Pl2.contains(9)){
            Winner = 2
        }


        //Carow1
        if(Pl1.contains(1) && Pl1.contains(5) && Pl1.contains(9)){
            Winner = 1
        }
        if(Pl2.contains(1) && Pl2.contains(5) && Pl2.contains(9)){
            Winner = 2
        }


        //Carow2
        if(Pl1.contains(3) && Pl1.contains(5) && Pl1.contains(7)){
            Winner = 1
        }
        if(Pl2.contains(3) && Pl2.contains(5) && Pl2.contains(7)){
            Winner = 2
        }

        if(Winner != -1){
            if(Winner == 1){
                Toast.makeText(this,"Player 1 is Winner",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Player 2 is Winner",Toast.LENGTH_LONG).show()
            }

            ClearGame()

        }
    }

    fun AutoPlay(){

        var EmptyCells = ArrayList<Int>()
        //Add Empty Cells
        for ( i in 1..9){
            if(!(Pl1.contains(i) || Pl2.contains(i))){
                EmptyCells.add(i)
            }
        }

        var rn = Random()
        var rnIndx = rn.nextInt(EmptyCells.size)
        var Cellid = EmptyCells[rnIndx]

        var BtnSelect : Button

        when(Cellid){
            1 -> BtnSelect = Btn1
            2 -> BtnSelect = Btn2
            3 -> BtnSelect = Btn3
            4 -> BtnSelect = Btn4
            5 -> BtnSelect = Btn5
            6 -> BtnSelect = Btn6
            7 -> BtnSelect = Btn7
            8 -> BtnSelect = Btn8
            9 -> BtnSelect = Btn9
            else -> BtnSelect = Btn1
        }

        GameEngine(BtnSelect , Cellid)
    }


    fun ClearGame(){
        ActivePlayer = 1
        var Btn : Button
        for(i in 1..9){
            when(i){
                1 -> Btn = Btn1
                2 -> Btn = Btn2
                3 -> Btn = Btn3
                4 -> Btn = Btn4
                5 -> Btn = Btn5
                6 -> Btn = Btn6
                7 -> Btn = Btn7
                8 -> Btn = Btn8
                9 -> Btn = Btn9
                else -> Btn = Btn1
            }
            Btn.isEnabled = true
            Btn.setBackgroundColor(Color.WHITE)
            Btn.text = ""
        }


        var NewPl1 = ArrayList<Int>()
        var NewPl2 = ArrayList<Int>()
        Pl1 = NewPl1
        Pl2 = NewPl2


    }

}

