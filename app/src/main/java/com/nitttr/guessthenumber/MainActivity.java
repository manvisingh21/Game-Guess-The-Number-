package com.nitttr.guessthenumber;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText minRangeEditText, maxRangeEditText, guessEditText;
    private Button newTargetButton, guessButton;
    private int targetNumber;
    private int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minRangeEditText = findViewById(R.id.minRangeEditText);
        maxRangeEditText = findViewById(R.id.maxRangeEditText);
        guessEditText = findViewById(R.id.guessEditText);
        newTargetButton = findViewById(R.id.newTargetButton);
        guessButton = findViewById(R.id.guessButton);

        newTargetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewTarget();
            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });
    }

    private void setNewTarget() {
        int minRange = Integer.parseInt(minRangeEditText.getText().toString());
        int maxRange = Integer.parseInt(maxRangeEditText.getText().toString());

        if (minRange >= maxRange) {
            Toast.makeText(this, "Invalid range! Please enter a valid range.", Toast.LENGTH_SHORT).show();
            return;
        }

        Random random = new Random();
        targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        attempts = 0;
        guessEditText.setText("");
        Toast.makeText(this, "New target set! Guess the number.", Toast.LENGTH_SHORT).show();
    }

    private void checkGuess() {
        int guess = Integer.parseInt(guessEditText.getText().toString());
        attempts++;

        if (guess == targetNumber) {
            Toast.makeText(this, "Well Done! It took you " + attempts + " attempts to guess this number.", Toast.LENGTH_LONG).show();
        } else if (guess < targetNumber) {
            Toast.makeText(this, "Too low! Try again.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Too high! Try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
