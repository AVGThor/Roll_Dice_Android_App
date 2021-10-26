package tdtu.seminar.rolldice

import android.media.MediaActionSound
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private lateinit var diceImage:ImageView
    private lateinit var diceImage2:ImageView
    private lateinit var diceImage3:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        ASSIGN SOUND EFFECT
        val diceSound: MediaPlayer = MediaPlayer.create(this, R.raw.dice_sound)
//        ASSIGN BUTTON ROLL
        val rollButton: Button = findViewById(R.id.btnRoll)

        diceImage = findViewById(R.id.imageView)
        diceImage2 = findViewById(R.id.imageView2)
        diceImage3 = findViewById(R.id.imageView3)

        //When click roll button, show a toast and show random number
        rollButton.setOnClickListener {
            diceSound.start()
            shakeAnimte()
            rollDice()
            val toast = Toast.makeText(this, "Have fun !!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    private fun rollDice() {
        //create a dice with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)
        val dice3 = Dice(6)

        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()
        val diceRoll3 = dice3.roll()


        //find dice image in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val diceImage3: ImageView = findViewById(R.id.imageView3)



        //determine which image of dice is used after roll a dice
        val imageDiceNum = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        val imageDice2Num = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val imageDice3Num = when (diceRoll3) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //UPDATE IMAGE IN LAYOUT
        diceImage.setImageResource(imageDiceNum)
        diceImage2.setImageResource(imageDice2Num)
        diceImage3.setImageResource(imageDice3Num)

       // UPDATE THE CONTENT DESCRIPTION
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
        diceImage3.contentDescription = diceRoll3.toString()
    }

    //        FUNCTION SHAKE ANIMATION
    private fun shakeAnimte(){
        val shake = AnimationUtils.loadAnimation(this,R.anim.shake)
        diceImage.animation = shake
        diceImage2.animation = shake
        diceImage3.animation = shake

    }
}
class Dice(val numSides: Int) {
    //create random number
    fun roll(): Int {
        return (1..numSides).random()
    }
}