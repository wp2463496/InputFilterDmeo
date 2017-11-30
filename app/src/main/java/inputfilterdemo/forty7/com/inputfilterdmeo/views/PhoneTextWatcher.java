package inputfilterdemo.forty7.com.inputfilterdmeo.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 手机号格式过滤器 优化版
 * Forty'7 2017.11.27
 * xiaowangboke@vip.qq.com
 */
public class PhoneTextWatcher implements TextWatcher {

    private EditText _text;
    private int agoLength = 0;//变化之前的长度

    public PhoneTextWatcher(EditText _text) {
        this._text = _text;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s == null || s.length() == 0) return;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                continue;
            } else {
                sb.append(s.charAt(i));
                if ((sb.length() == 4 || sb.length() == 9) && sb.charAt(sb.length() - 1) != ' ') {
                    sb.insert(sb.length() - 1, ' ');
                }
            }
        }
        if (!sb.toString().equals(s.toString())) {
            int index = start + 1;
            if (sb.charAt(start) == ' ') {
                if (before == 0) {
                    index++;
                } else {
                    index--;
                }
            } else {
                if (before == 1) {
                    index--;
                }
            }
            _text.setText(sb.toString());
            _text.setSelection(index);
        }


        if(agoLength != 0 && agoLength > sb.toString().length()){//退格逻辑,遇空格退2格
            String str = sb.toString();
            if(str.substring(str.length()-1 , str.length()).equals(" ")){
                str = str.substring(0 , str.length() - 1);
                _text.setText(str);
                _text.setSelection(start-1);
            }
        }
        agoLength = s.length();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
