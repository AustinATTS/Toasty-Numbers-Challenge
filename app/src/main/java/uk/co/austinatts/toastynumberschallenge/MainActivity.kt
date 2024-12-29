package uk.co.austinatts.toastynumberschallenge

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robinhood.ticker.TickerUtils
import com.robinhood.ticker.TickerView
import uk.co.austinatts.toastynumberschallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tickerViewA1: TickerView
    private lateinit var tickerViewA2: TickerView
    private lateinit var tickerViewOP: TickerView
    private lateinit var tickerViewB: TickerView
    private lateinit var tickerViewR1: TickerView
    private lateinit var tickerViewR2: TickerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button click listeners
        binding.buttonEndless.setOnClickListener {
            navigateToActivity(EndlessActivity::class.java)
        }

        binding.button.setOnClickListener {
            navigateToActivity(PlayActivity::class.java)
        }

        binding.buttonLeaderboard.setOnClickListener {
            navigateToActivity(RankingActivity::class.java)
        }

        binding.buttonStats.setOnClickListener {
            navigateToActivity(StatsActivity::class.java)
        }

        // Initialize TickerViews
        tickerViewA1 = findViewById(R.id.tickerViewA1)
        tickerViewA2 = findViewById(R.id.tickerViewA2)
        tickerViewOP = findViewById(R.id.tickerViewOP)
        tickerViewB = findViewById(R.id.tickerViewB)
        tickerViewR1 = findViewById(R.id.tickerViewR1)
        tickerViewR2 = findViewById(R.id.tickerViewR2)

        // Set character lists for TickerViews
        tickerViewA1.setCharacterLists(TickerUtils.provideNumberList())
        tickerViewA2.setCharacterLists(TickerUtils.provideNumberList())
        tickerViewOP.setCharacterLists(TickerUtils.provideAlphabeticalList())
        tickerViewB.setCharacterLists(TickerUtils.provideNumberList())
        tickerViewR1.setCharacterLists(TickerUtils.provideNumberList())
        tickerViewR2.setCharacterLists(TickerUtils.provideNumberList())

        // Start updating equations
        updateEquation()
    }

    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

    private fun updateEquation() {
        // Example dynamic updates
        var a1 = (0..1).random()
        var a2 = (0..9).random()
        while (a1 * 10 + a2 > 12) {
            a1 = (0..1).random()
            a2 = (1..9).random()
        }
        if (a1 * 10 + a2 < 1) {
            a2 = 1
        }
        val operator = listOf("+", "−", "×", "÷").random()
        var b = (1..9).random()
        var a = (a1 * 10 + a2)
        val result = when (operator) {
            "+" -> a + b
            "−" -> {
                // Regenerate a and b until a - b is not negative
                var result: Int
                do {
                    // Generate new random values for a and b
                    a1 = (0..1).random()
                    a2 = (1..9).random()
                    a = (a1 * 10 + a2)  // a is a two-digit number
                    b = (1..9).random()

                    result = a - b  // Perform the subtraction
                } while (result < 0 || a > 12) // Repeat until result is non-negative
                result  // Return the valid result
            }
            "×" -> {
                // Regenerate a and b until a - b is not negative
                var result: Int
                do {
                    // Generate new random values for a and b
                    a1 = (0..1).random()
                    a2 = (1..9).random()
                    a = (a1 * 10 + a2)  // a is a two-digit number
                    b = (1..9).random()

                    result = a * b  // Perform the subtraction
                } while (result > 99 || a > 12) // Repeat until result is non-negative
                result  // Return the valid result
            }
            "÷" -> {
                // Regenerate a and b until a - b is not negative
                var result: Int
                do {
                    // Generate new random values for a and b
                    a1 = (0..1).random()
                    a2 = (1..9).random()
                    a = (a1 * 10 + a2)  // a is a two-digit number
                    b = (1..9).random()

                    result = a / b  // Perform the subtraction
                } while (a % b != 0 || a > 12) // Repeat until result is non-negative
                result  // Return the valid result
            }
            else -> 0
        }

        val r1 = result / 10
        val r2 = result % 10

        tickerViewA1.setAnimationDuration(1500)  // 1.5 seconds duration for the ticker
        tickerViewA2.setAnimationDuration(1500)
        tickerViewOP.setAnimationDuration(1500)
        tickerViewB.setAnimationDuration(1500)
        tickerViewR1.setAnimationDuration(1500)
        tickerViewR2.setAnimationDuration(1500)

        // Update TickerViews with animations
        tickerViewA1.text = if (a1 == 0) " " else "$a1"
        tickerViewA2.text = "$a2"
        tickerViewOP.text = " $operator "
        tickerViewB.text = "$b"
        tickerViewR1.text = if (r1 == 0) " " else "$r1"
        tickerViewR2.text = "$r2"

        // Repeat the update after a delay
        tickerViewA1.postDelayed({
            updateEquation()
        }, 5000) // 2 seconds delay
    }
}