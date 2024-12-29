package uk.co.austinatts.toastynumberschallenge

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Find the button by its ID
        val backButton = findViewById<ImageButton>(R.id.sback_button)

        // Set an OnClickListener for the back button
        backButton.setOnClickListener {
            // Finish the current activity and return to the MainActivity
            finish()
        }
    }
}
