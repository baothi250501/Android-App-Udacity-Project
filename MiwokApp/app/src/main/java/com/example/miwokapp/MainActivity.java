package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the content of activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find the View that shows the number category
        TextView numbers = (TextView)findViewById(R.id.numbers);

        //Set a clickListener on that View
        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }

        });

        //Find the View that shows the phrases category
        TextView phrases = (TextView)findViewById(R.id.phrases);

        //Set a clickListener on that View
        phrases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link NumbersActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                //Start the new activity
                startActivity(phrasesIntent);
            }

        });

        //Find the View that shows the family members category
        TextView family = (TextView)findViewById(R.id.family);

        //Set a clickListener on that View
        family.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link NumbersActivity}
                Intent familyIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);

                //Start the new activity
                startActivity(familyIntent);
            }

        });

        //Find the View that shows the colors category
        TextView colors = (TextView)findViewById(R.id.colors);

        //Set a clickListener on that View
        colors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link NumbersActivity}
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                //Start the new activity
                startActivity(colorsIntent);
            }

        });
    }

}

