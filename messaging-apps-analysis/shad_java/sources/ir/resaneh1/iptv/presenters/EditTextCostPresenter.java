package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class EditTextCostPresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    public static final CharSequence space = ",";
    private String current;
    Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid(String str) {
        return false;
    }

    public EditTextCostPresenter(Context context) {
        super(context);
        this.current = BuildConfig.FLAVOR;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_edit_text_with_icon, viewGroup, false));
        myViewHolder.edittext.setGravity(3);
        myViewHolder.edittext.setTextDirection(3);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final EditTextItem editTextItem) {
        super.onBindViewHolder((EditTextCostPresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.edittext.setText(editTextItem.text);
        myViewHolder.edittext.setHint(editTextItem.hint);
        myViewHolder.edittext.setInputType(3);
        myViewHolder.edittext.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.presenters.EditTextCostPresenter.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MyLog.e("EditTextCardNoPresenter", "onTextChanged: " + i + " " + i2 + " " + i3);
                if (charSequence.toString().equals(EditTextCostPresenter.this.current)) {
                    return;
                }
                if (i2 == 0) {
                    editTextItem.isDelete = false;
                    i++;
                } else {
                    editTextItem.isDelete = true;
                }
                myViewHolder.edittext.removeTextChangedListener(this);
                String format = EditTextCostPresenter.setFormat(charSequence.toString().replace(EditTextCostPresenter.space, BuildConfig.FLAVOR));
                EditTextCostPresenter.this.current = format;
                myViewHolder.edittext.setText(format);
                int length = i + (format.length() - charSequence.length());
                int length2 = length >= 0 ? length : 0;
                if (length2 > format.length()) {
                    length2 = format.length();
                }
                myViewHolder.edittext.setSelection(length2);
                myViewHolder.edittext.addTextChangedListener(this);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = myViewHolder.edittext.getText().toString();
                editTextItem.text = string;
                if (EditTextCostPresenter.this.isValid(string)) {
                    myViewHolder.edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                } else {
                    myViewHolder.edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
        });
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public EditText edittext;

        public MyViewHolder(EditTextCostPresenter editTextCostPresenter, View view) {
            super(view);
            this.edittext = (EditText) view.findViewById(R.id.editText);
        }
    }

    public static String setFormat(String str) {
        boolean z;
        CharSequence charSequence = space;
        String strSubstring = BuildConfig.FLAVOR;
        String strReplace = str.replace(charSequence, BuildConfig.FLAVOR);
        if (strReplace.contains("-")) {
            strReplace = strReplace.replace("-", BuildConfig.FLAVOR);
            z = true;
        } else {
            z = false;
        }
        int i = 0;
        for (int length = strReplace.length() - 1; length >= 0; length--) {
            strSubstring = strSubstring + strReplace.charAt(length);
            if (Character.isDigit(strReplace.charAt(length))) {
                i++;
            }
            if (i == 3) {
                strSubstring = strSubstring + ((Object) space);
                i = 0;
            }
        }
        if (strSubstring.length() > 3 && strSubstring.charAt(strSubstring.length() - 1) == space.charAt(0)) {
            MyLog.e("EditTextCost", "setFormat: ");
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        if (z) {
            strSubstring = strSubstring + "-";
        }
        return new StringBuilder(strSubstring).reverse().toString();
    }
}
