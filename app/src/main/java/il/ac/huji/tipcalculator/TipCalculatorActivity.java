package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        final EditText ed = (EditText)findViewById(R.id.edtBillAmount);
        final CheckBox box = (CheckBox)findViewById(R.id.chkRound);
        final Button btn = (Button)findViewById(R.id.btnCalculate);
        final TextView txt = (TextView)findViewById(R.id.txtTipResult);
        btn.setAllCaps(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(ed.getText().toString()) * 0.12;
                txt.setText("Tip: $" + (box.isChecked() ?
                        Integer.toString((int)Math.round(a)) : Double.toString(a)));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
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
}
