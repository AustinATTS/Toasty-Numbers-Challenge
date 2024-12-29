package uk.co.austinatts.toastynumberschallenge

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.robinhood.ticker.TickerUtils
import com.robinhood.ticker.TickerView

class EndlessActivity : AppCompatActivity() {

    private lateinit var constraintLayoutSolvedEqs: ConstraintLayout
    private lateinit var solvedEquationsText: TextView
    private lateinit var textViewSolvedCount: TextView
    private lateinit var constraintLayoutEquation: ConstraintLayout
    private lateinit var etickerViewA1: TickerView
    private lateinit var etickerViewA2: TickerView
    private lateinit var etickerViewOP: TickerView
    private lateinit var etickerViewB: TickerView
    private lateinit var textViewEquals: TextView
    private lateinit var editTextNumber: EditText
    private lateinit var buttonNext: Button
    private lateinit var imageViewPause: ImageView
    private lateinit var errorBackgroundTraining: View
    private lateinit var errorSignTraining: ImageView
    private lateinit var correctAnswerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_endless)

        // Initialize the views
        constraintLayoutSolvedEqs = findViewById(R.id.constraintLayoutSolvedEqs)
        solvedEquationsText = findViewById(R.id.solved_eqs_text)
        textViewSolvedCount = findViewById(R.id.textViewSolvedCount)
        constraintLayoutEquation = findViewById(R.id.constraintLayoutEquation)
        etickerViewA1 = findViewById(R.id.etickerViewA1)
        etickerViewA2 = findViewById(R.id.etickerViewA2)
        etickerViewOP = findViewById(R.id.etickerViewOP)
        etickerViewB = findViewById(R.id.etickerViewB)
        textViewEquals = findViewById(R.id.etextViewEquals)
        editTextNumber = findViewById(R.id.editTextNumber)
        buttonNext = findViewById(R.id.buttonNext)
        imageViewPause = findViewById(R.id.imageViewPause)
        errorBackgroundTraining = findViewById(R.id.errorBackgroundTraining)
        errorSignTraining = findViewById(R.id.errorSignTraining)
        correctAnswerText = findViewById(R.id.correctAnswerText)

        etickerViewA1.setCharacterLists(TickerUtils.provideNumberList())
        etickerViewA2.setCharacterLists(TickerUtils.provideNumberList())
        etickerViewOP.setCharacterLists(TickerUtils.provideAlphabeticalList())
        etickerViewB.setCharacterLists(TickerUtils.provideNumberList())

        // Set up any desired behaviors or listeners here
        // For example, if you want to start the ticker animation:
        etickerViewA1.setText("1")
        etickerViewA2.setText("2")
        etickerViewOP.setText(" - ")
        etickerViewB.setText("3")

        // You can use this to set the animation duration as needed
        etickerViewA1.setAnimationDuration(1000) // Example: 1 second
        etickerViewA2.setAnimationDuration(1000)
        etickerViewOP.setAnimationDuration(1000)
        etickerViewB.setAnimationDuration(1000)

        // Set any other properties or listeners for other views
        buttonNext.setOnClickListener {
            // Add behavior when "NEXT" button is clicked
        }

        // More setup or interaction logic as required for your app
    }
}
