package inputfilterdemo.forty7.com.inputfilterdmeo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import inputfilterdemo.forty7.com.inputfilterdmeo.views.MyTextWatcher;
import inputfilterdemo.forty7.com.inputfilterdmeo.views.PhoneTextWatcher;
/**
 * Android 手机号、身份证号、银行卡号、格式过滤器
 * Forty'7 2017.11.27
 * xiaowangboke@vip.qq.com
 */
public class MainActivity extends AppCompatActivity {
    private EditText etPhone;
    private EditText etCardNumber;
    private MyTextWatcher mytCardNumberTextWatcher;
    private EditText etCardBank;
    private MyTextWatcher myCardBankTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone = findViewById(R.id.et_phone);
        etCardNumber = findViewById(R.id.et_card_number);
        etCardBank = findViewById(R.id.et_card_bank);
        etPhone.addTextChangedListener(new PhoneTextWatcher(etPhone));
        mytCardNumberTextWatcher = new MyTextWatcher(etCardNumber,21);
        mytCardNumberTextWatcher.setSpaceType(MyTextWatcher.SpaceType.IDCardNumberType);
        myCardBankTextWatcher = new MyTextWatcher(etCardBank,48);
        myCardBankTextWatcher.setSpaceType(MyTextWatcher.SpaceType.bankCardNumberType);

        etPhone.setText("18875047222");
        etCardNumber.setText("500600199512033546");
        etCardBank.setText("6228480402564890018");
    }
}
