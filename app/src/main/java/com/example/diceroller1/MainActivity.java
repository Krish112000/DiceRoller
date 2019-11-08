package com.example.diceroller1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int s1= 0; //defined here so that it does not return to 0 everytime the button is clicked.
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {
        //Allows to the user to input a value
        EditText input = (EditText) findViewById(R.id.EnterNumber);
        int ui = Integer.parseInt(input.getText().toString());

        if ((ui >6)||(ui<1)){
            throw new IllegalArgumentException("Input number betwwen 1-6");
        }

        TextView tv = this.findViewById(R.id.numberTextView);

        //Generates random number
        Random r = new Random();
        int number = r.nextInt(6) + 1;

        tv.setText(Integer.toString(number));
        TextView s = this.findViewById(R.id.Score);
        s.setText(Integer.toString(s1));
        // s1++;

        if (ui == number) {
            s1++;
            Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();

        }
        else {
            // Allow the user to continue rolling the dice
        }
    }

    public void onClick (View v){
        TextView tv = this.findViewById(R.id.numberTextView);

        //Generates random number
        Random r2 = new Random();
        int number = r2.nextInt(6) + 1;

        if (number == 1) {

            tv.setText("If you could go anywhere in the world, where would you go?");

        }
        else if (number == 2) {

            tv.setText("If you were stranded on a desert island, what three things would you want to take with you?");
        }
        else if (number == 3){
            tv.setText("If you could eat only one food for the rest of your life, what would that be?");

        }
        else if (number == 4){
            tv.setText("If you won a million dollars, what is the first thing you would buy?");

        }
        else if (number == 5){
            tv.setText("If you could spend the day with one fictional character, who would it be?");
        }
        else if (number ==6){
            tv.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        }



    }
         /*List<String> Q = new ArrayList<>();
        Q.add ("If you could go anywhere in the world, where would you go?");
        Q.add ("If you were stranded on a desert island, what three things would you want to take with you?");
        Q.add ("If you could eat only one food for the rest of your life, what would that be?");
        Q.add ("If you won a million dollars, what is the first thing you would buy?");
        Q.add ("If you could spend the day with one fictional character, who would it be?");
        Q.add ("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Random r2 = new Random();
        int num = r2.nextInt(6)+1;

    }
    public void roll_the_Dice(){
        TextView tv= this.findViewById(R.id.numberTextView);
        Random r = new Random();
        int number = r.nextInt(6)+1;
        tv.setText (Integer.toString(number));
    }*/
}
