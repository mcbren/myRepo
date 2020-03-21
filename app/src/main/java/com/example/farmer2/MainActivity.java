package com.example.farmer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView moneyView;
    TextView roundView;
    TextView diceOneView;
    TextView diceTwoView;

    TextView rabbitView;
    TextView sheepView;
    TextView pigView;
    TextView horseView;
    TextView cowView;
    TextView smallDogView;
    TextView bigDogView;

    Button diceThrow;
    Button rabbitMinusButton;
    Button rabbitPlusButton;
    Button sheepMinusButton;
    Button sheepPlusButton;
    Button pigMinusButton;
    Button pigPlusButton;
    Button cowMinusButton;
    Button cowPlusButton;
    Button horseMinusButton;
    Button horsePlusButton;

    int money = 0;
    int round = 0;
    int rabbitAmount = 0;
    int rabbitTempAmount = 0;
    int sheepAmount = 0;
    int sheepTempAmount = 0;
    int pigAmount = 0;
    int pigTempAmount = 0;
    int horseAmount = 0;
    int horseTempAmount = 0;
    int cowAmount = 0;
    int cowTempAmount = 0;
    int smallDogAmount = 0;
    int bigDogAmount = 0;

    Random random = new Random();



    String [] animalOneDice = new String[] {"Rabbit", "Rabbit","Rabbit","Rabbit","Rabbit","Sheep","Rabbit","Sheep","Sheep", "Pig","Cow","Wolf"};
    String [] animalTwoDice = new String[] {"Rabbit", "Rabbit","Rabbit", "Rabbit","Rabbit", "Rabbit","Sheep", "Sheep","Pig","Pig","Horse","Fox"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        while ( rabbitAmount>0 && sheepAmount>0 && pigAmount>0 && horseAmount>0 && cowAmount>0)
        {Toast.makeText(MainActivity.this,  "You win !!!",
                Toast.LENGTH_LONG).show();}



        moneyView =(TextView)findViewById(R.id.moneyView);
        roundView =(TextView)findViewById(R.id.roundView);
        diceOneView =(TextView)findViewById(R.id.diceOneView);
        diceTwoView =(TextView)findViewById(R.id.diceTwoView);
        diceThrow =(Button) findViewById(R.id.diceThrow);
        rabbitMinusButton=findViewById(R.id.rabbitMinusButon);
        rabbitPlusButton=findViewById(R.id.rabbitPlusButon);
        sheepMinusButton=findViewById(R.id.sheepMinusButon);
        sheepPlusButton=findViewById(R.id.sheepPlusButon);
        pigMinusButton=findViewById(R.id.pigMinusButton);
        pigPlusButton=findViewById(R.id.pigPlusbutton);
        cowMinusButton=findViewById(R.id.cowMinusButton);
        cowPlusButton=findViewById(R.id.cowPlusButton);
        horseMinusButton=findViewById(R.id.horseMinusButton);
        horsePlusButton=findViewById(R.id.horsePlusButton);

        rabbitView=findViewById(R.id.rabbitView);
        sheepView=findViewById(R.id.sheepView);
        pigView=findViewById(R.id.pigView);
        horseView=findViewById(R.id.cowView);
        cowView=findViewById(R.id.horseView);
        smallDogView=findViewById(R.id.smalDogView);
        bigDogView=findViewById(R.id.bigDogView);


        diceThrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                int diceOne = random.nextInt(12);
                int diceTwo = random.nextInt(12);
                round +=1;

                diceOneView.setText(animalOneDice[diceOne]);
                diceTwoView.setText(animalTwoDice[diceTwo]);
                roundView.setText(""+round);

                if (diceOne==0){ rabbitTempAmount += 1;}
                if (diceOne==1){ rabbitTempAmount += 1;}
                if (diceOne==2){ rabbitTempAmount += 1;}
                if (diceOne==3){ rabbitTempAmount += 1;}
                if (diceOne==4){ rabbitTempAmount += 1;}
                if (diceOne==5){ rabbitTempAmount += 1;}
                if (diceOne==6){ sheepTempAmount += 1;}
                if (diceOne==7){ sheepTempAmount += 1;}
                if (diceOne==8){ sheepTempAmount += 1;}
                if (diceOne==9){ pigTempAmount += 1;}
                if (diceOne==10){ cowTempAmount += 1;}

                if (diceTwo==0){ rabbitTempAmount += 1;}
                if (diceTwo==1){ rabbitTempAmount += 1;}
                if (diceTwo==2){ rabbitTempAmount += 1;}
                if (diceTwo==3){ rabbitTempAmount += 1;}
                if (diceTwo==4){ rabbitTempAmount += 1;}
                if (diceTwo==5){ rabbitTempAmount += 1;}
                if (diceTwo==6){ sheepTempAmount += 1;}
                if (diceTwo==7){ sheepTempAmount += 1;}
                if (diceTwo==8){ pigTempAmount += 1;}
                if (diceTwo==9){ pigTempAmount += 1;}
                if (diceTwo==10){ horseTempAmount += 1;}

                rabbitAmount += (rabbitAmount + rabbitTempAmount) /2;
                sheepAmount += (sheepAmount + sheepTempAmount) /2;
                pigAmount += (pigAmount + pigTempAmount) /2;
                horseAmount += (horseAmount + horseTempAmount) /2;
                cowAmount += (cowAmount +cowTempAmount) /2;

                rabbitView.setText("Rabbit: "+rabbitAmount);
                sheepView.setText("Sheep: "+sheepAmount);
                pigView.setText("Pig: "+pigAmount);
                horseView.setText("Horse: "+horseAmount);
                cowView.setText("Cow: "+cowAmount);
                smallDogView.setText("Small dog:"+smallDogAmount);
                bigDogView.setText("Big dog: "+bigDogAmount);

                rabbitTempAmount = 0;
                sheepTempAmount =0;
                pigTempAmount = 0;
                horseTempAmount = 0;
                cowTempAmount = 0;

                if (diceOne==11){ Toast.makeText(MainActivity.this,  "Wolf is eating all animal without cow!!!",
                        Toast.LENGTH_LONG).show();
                rabbitAmount=0; sheepAmount=0;pigAmount=0; horseAmount=0; money=0;
                }

                if (diceTwo==11){ Toast.makeText(MainActivity.this, "Fox is eating all rabbit!!!",
                        Toast.LENGTH_LONG).show();
                rabbitAmount=0; money=0;
                }





            }
        });

        rabbitMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
            if (rabbitAmount>0) {
                rabbitAmount -=1;
                money +=1;
            }

                rabbitView.setText("Rabbit: "+rabbitAmount);
                moneyView.setText("Money: "+money);


            }
        });

        rabbitPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
            if (money>0) {
                rabbitAmount += 1;
                money -= 1;
            }
                rabbitView.setText("Rabbit: "+rabbitAmount);
                moneyView.setText("Money: "+money);



        };

        });

        sheepMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (sheepAmount>0) {
                    sheepAmount -=1;
                    money +=6;
                }

                sheepView.setText("Sheep: "+sheepAmount);
                moneyView.setText("Money: "+money);


            }
        });

        sheepPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (money>5) {
                    sheepAmount +=1;
                    money -=6;
                }

                sheepView.setText("Sheep: "+sheepAmount);
                moneyView.setText("Money: "+money);


            }
        });

        pigMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (pigAmount>0) {
                    pigAmount -=1;
                    money +=12;
                }

                pigView.setText("Pig: "+pigAmount);
                moneyView.setText("Money: "+money);


            }
        });



        pigPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (money>11) {
                    pigAmount +=1;
                    money -=12;
                }

                pigView.setText("Pig: "+pigAmount);
                moneyView.setText("Money: "+money);


            }
        });


        cowMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (cowAmount>0) {
                    cowAmount -=1;
                    money +=36;
                }

                cowView.setText("Cow: "+cowAmount);
                moneyView.setText("Money: "+money);


            }
        });


        cowPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (money>35) {
                    cowAmount +=1;
                    money -=36;
                }

                cowView.setText("Cow: "+cowAmount);
                moneyView.setText("Money: "+money);


            }
        });

        horseMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (horseAmount>0) {
                    horseAmount -=1;
                    money +=72;
                }

                horseView.setText("Horse: "+horseAmount);
                moneyView.setText("Money: "+money);


            }
        });


        horsePlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (money>71) {
                    horseAmount +=1;
                    money -=72;
                }

                horseView.setText("Horse: "+horseAmount);
                moneyView.setText("Money: "+money);


            }
        });


    }
}
