package mple.noname;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener
{

    private SeekBar slider;
    private TextView textProgress;
    private EditText tipInput;
    private EditText allInput;
    private EditText orderInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider = (SeekBar)findViewById(R.id.slider);
        textProgress = (TextView)findViewById(R.id.textProgress);

        tipInput = (EditText)findViewById(R.id.tipInput);
        allInput = (EditText)findViewById(R.id.allInput);
        orderInput = (EditText)findViewById(R.id.orderInput);

        tipInput.setText(String.valueOf(0));
        allInput.setText(String.valueOf(0));
        orderInput.setText(String.valueOf(0));

        tipInput.setKeyListener(null);
        allInput.setKeyListener(null);


        slider.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        textProgress.setText(String.valueOf(slider.getProgress()));

                        tipInput.setText(String.valueOf(
                                Double.parseDouble(String.valueOf(orderInput.getText()))
                                        * (slider.getProgress())/100)
                        );
                        allInput.setText(String.valueOf(Double.parseDouble(String.valueOf(tipInput.getText())) + Double.parseDouble(String.valueOf(orderInput.getText()))));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
