package jp.suntech.s22035.kadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloListener listener = new HelloListener();

        Button btsend = findViewById(R.id.btSend);

        btsend.setOnClickListener(listener);

        Button btconfirm = findViewById(R.id.btConfirm);

        btconfirm.setOnClickListener(listener);

        Button btclear = findViewById(R.id.btClear);

        btclear.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText inputN=findViewById(R.id.etName);

            EditText inputMT=findViewById(R.id.etTitle);

            EditText inputMA=findViewById(R.id.etMail);

            EditText inputCM=findViewById(R.id.etComment);

            int id = view.getId();

            if(id == R.id.btSend){
                String Namestr = inputN.getText().toString();
                String Titlestr = inputMT.getText().toString();
                String Addstr = inputMA.getText().toString();
                String Cmstr = inputCM.getText().toString();


                String show = "送信しました。　内容\n" + "名前:" + Namestr + "  タイトル「" + Titlestr + "」" + "\nメールアドレス:" + Addstr + "  質問内容:" + Cmstr;
                Snackbar.make(view,show,Snackbar.LENGTH_LONG).show();

            }
            if(id == R.id.btConfirm){
                MailDialog dialogFragment = new MailDialog();
                dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");

                String Namestr = inputN.getText().toString();
                String Titlestr = inputMT.getText().toString();
                String Addstr = inputMA.getText().toString();
                String Cmstr = inputCM.getText().toString();


            }
            if(id == R.id.btClear){
                inputN.setText("");
                inputMA.setText("");
                inputMT.setText("");
                inputCM.setText("");
            }

            }

        }
}
