package ahto.com.kalkulaator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ArrayList<String> arrayList = new ArrayList<String>();
    String string = "";
    String string1 = "";

    public void onClick (View v) {

        TextView textView2 = (TextView) findViewById(R.id.textView2);

        Button button = (Button) v;

        string = (String) button.getText().toString();

        if (!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")) {

            string1 = string1 + string;

            if (arrayList.size() > 0) {

                arrayList.remove((arrayList.size() - 1));
            }
            arrayList.add(string1);
        }
        else {
            arrayList.add(string);
            arrayList.add(string);
            string1="";
        }

            textView2.setText(textView2.getText().toString()+string);

            //textView2.setText(arrayList.toString());


    }

    public void onClick2 (View v) {

        TextView textView1 = (TextView)findViewById(R.id.textView);

        int calc = 0;
        int c = arrayList.size();


//eg: array (2,+,3,*,4,-,3) size = 7, so (2,+,3,*,4,-,3)

        while (c!=1) {

            if (c>3) {

                if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {

                    if (arrayList.get(3).contains("*")) {
                        calc = Integer.parseInt(arrayList.get(2))* Integer.parseInt(arrayList.get(4));
                    }

                    if (arrayList.get(3).contains("/")) {
                        calc = Integer.parseInt(arrayList.get(2))/ Integer.parseInt(arrayList.get(4));
                    }

                    //calc = 12; array = (2,+,3,*,4,-,3)
                    arrayList.remove(2); //(2,+,*,4,-,3)
                    arrayList.remove(2); //(2,+,4,-,3)
                    arrayList.remove(2); //(2,+,-,3)
                    arrayList.add(2, Integer.toString(calc)); //(2,+,12,-,3)
                    c = arrayList.size(); //size 5
                }

                else {
                    //(2,+,12,-,3)
                    if (arrayList.get(1).contains("+")) {

                        calc = Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("-")) {

                        calc = Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("*")) {

                        calc = Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("/")) {

                        calc = Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));
                    }
                    // calc = 14
                    arrayList.remove(0); //(+,12,-,3)
                    arrayList.remove(0); //(12,-,3)
                    arrayList.remove(0); //(-,3)
                    arrayList.add(0, Integer.toString(calc)); //(14,-,3)
                    c = arrayList.size(); // size = 3
                }
            }
                //size <= 3
            else {

                if (arrayList.get(1).contains("+")) {

                    calc = Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("-")) {

                    calc = Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("*")) {

                    calc = Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("/")) {

                    calc = Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));
                }
                    // calc = 11
                arrayList.remove(0); //(-,3)
                arrayList.remove(0); //(3)
                arrayList.remove(0); //()
                arrayList.add(0, Integer.toString(calc)); // (9)
                c = arrayList.size(); //size = 1 since size is 1 loop ends
            }

        }

        textView1.setText(Integer.toString(calc));
    }

    public void clear (View v) {

        TextView textView1 = (TextView)findViewById(R.id.textView);
        TextView textView2 = (TextView)findViewById(R.id.textView2);

        string1 = "";
        string = "";
        textView1.setText("0");
        textView2.setText("");
        arrayList.clear();

    }




}
