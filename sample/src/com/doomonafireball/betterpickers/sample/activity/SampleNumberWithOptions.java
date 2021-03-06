package com.doomonafireball.betterpickers.sample.activity;

import com.doomonafireball.betterpickers.BetterPickerUtils;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.doomonafireball.betterpickers.sample.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * User: derek Date: 3/17/13 Time: 3:59 PM
 */
public class SampleNumberWithOptions extends BaseSampleActivity
        implements NumberPickerDialogFragment.NumberPickerDialogHandler {

    private TextView text;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_and_button);

        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);

        text.setText("--");
        button.setText("Set Number");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BetterPickerUtils
                        .showNumberEditDialog(getSupportFragmentManager(), R.style.BetterPickersDialogFragment, null,
                                null,
                                View.INVISIBLE, View.INVISIBLE);
            }
        });
    }

    @Override
    public void onDialogNumberSet(int number, double decimal, boolean isNegative, double fullNumber) {
        text.setText("Number: " + number + "\nDecimal: " + decimal + "\nIs negative: " + isNegative + "\nFull number: "
                + fullNumber);
    }
}
