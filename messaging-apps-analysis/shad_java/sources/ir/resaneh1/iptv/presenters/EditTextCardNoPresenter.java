package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.CardNumbers;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class EditTextCardNoPresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    private static final CharSequence space = " ";
    private String current;
    int currnetAccount;
    Context mContext;
    public int maxLength;

    public EditTextCardNoPresenter(Context context) {
        super(context);
        this.current = BuildConfig.FLAVOR;
        this.maxLength = 19;
        this.currnetAccount = UserConfig.selectedAccount;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_auto_complete_text_with_icon, viewGroup, false));
        myViewHolder.edittext.setGravity(3);
        myViewHolder.edittext.setTextDirection(3);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final EditTextItem editTextItem) {
        super.onBindViewHolder((EditTextCardNoPresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.edittext.setText(editTextItem.text);
        myViewHolder.edittext.setHint(editTextItem.hint);
        CardNumbers cardNumbers = AppPreferences.getInstance(this.currnetAccount).getCardNumbers();
        if (cardNumbers.getNumbers(this.currnetAccount) != null && cardNumbers.getNumbers(this.currnetAccount).size() > 0 && editTextItem.isEditable) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = cardNumbers.getNumbers(this.currnetAccount).iterator();
            while (it.hasNext()) {
                arrayList.add(setFormat(it.next()));
            }
            myViewHolder.edittext.setAdapter(new ArrayAdapter(this.context, R.layout.item_text_in_list_row, R.id.textView, arrayList));
            myViewHolder.edittext.setThreshold(0);
            myViewHolder.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextCardNoPresenter.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        myViewHolder.edittext.showDropDown();
                    }
                }
            });
            myViewHolder.edittext.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextCardNoPresenter.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    myViewHolder.edittext.showDropDown();
                    return false;
                }
            });
        }
        if (editTextItem.isEditable) {
            myViewHolder.edittext.setInputType(3);
        } else {
            myViewHolder.edittext.setInputType(0);
            View.OnClickListener onClickListener = editTextItem.onClickListener;
            if (onClickListener != null) {
                myViewHolder.edittext.setOnClickListener(onClickListener);
                myViewHolder.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextCardNoPresenter.3
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            editTextItem.onClickListener.onClick(view);
                        }
                    }
                });
            }
        }
        myViewHolder.edittext.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength) { // from class: ir.resaneh1.iptv.presenters.EditTextCardNoPresenter.4
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence != null && TextUtils.indexOf(charSequence, '\n') != -1) {
                    return BuildConfig.FLAVOR;
                }
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (charSequenceFilter != null && charSequence != null && charSequenceFilter.length() != charSequence.length()) {
                    ToastiLikeSnack.showL(EditTextCardNoPresenter.this.mContext, "شماره کارت حداکثر ۱۶ رقمی است");
                    AndroidUtilities.shakeView(myViewHolder.itemView, 2.0f, 0);
                }
                return charSequenceFilter;
            }
        }});
        myViewHolder.edittext.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.presenters.EditTextCardNoPresenter.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MyLog.e("EditTextCardNoPresenter", "onTextChanged: " + i + " " + i2 + " " + i3);
                if (charSequence.toString().equals(EditTextCardNoPresenter.this.current)) {
                    return;
                }
                if (i2 == 0) {
                    editTextItem.isDelete = false;
                    i++;
                } else {
                    editTextItem.isDelete = true;
                    if (i > 1 && (i + 1) % 5 == 0) {
                        i--;
                    }
                }
                myViewHolder.edittext.removeTextChangedListener(this);
                String format = EditTextCardNoPresenter.setFormat(charSequence.toString().replace(EditTextCardNoPresenter.space, BuildConfig.FLAVOR));
                int length = format.length();
                EditTextCardNoPresenter editTextCardNoPresenter = EditTextCardNoPresenter.this;
                if (length <= editTextCardNoPresenter.maxLength) {
                    editTextCardNoPresenter.current = format;
                } else {
                    ToastiLikeSnack.showL(editTextCardNoPresenter.mContext, "شماره کارت حداکثر ۱۶ رقمی است");
                }
                myViewHolder.edittext.setText(EditTextCardNoPresenter.this.current);
                int length2 = i + (EditTextCardNoPresenter.this.current.length() - charSequence.length());
                int length3 = length2 >= 0 ? length2 : 0;
                if (length3 > EditTextCardNoPresenter.this.current.length()) {
                    length3 = EditTextCardNoPresenter.this.current.length();
                }
                myViewHolder.edittext.setSelection(length3);
                myViewHolder.edittext.addTextChangedListener(this);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = myViewHolder.edittext.getText().toString();
                editTextItem.text = string.replace(EditTextCardNoPresenter.space, BuildConfig.FLAVOR);
                if (EditTextCardNoPresenter.isValid(string)) {
                    MyLog.e("afterTextChanged", "afterTextChanged: ");
                    myViewHolder.edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                } else {
                    myViewHolder.edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
        });
    }

    public static boolean isValid(String str) {
        return Pattern.compile("\\d{16}$").matcher(str.replace(space, BuildConfig.FLAVOR)).matches();
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public AutoCompleteTextView edittext;

        public MyViewHolder(EditTextCardNoPresenter editTextCardNoPresenter, View view) {
            super(view);
            this.edittext = (AutoCompleteTextView) view.findViewById(R.id.editText);
        }
    }

    public static String setFormat(String str) {
        CharSequence charSequence = space;
        String str2 = BuildConfig.FLAVOR;
        String strReplace = str.replace(charSequence, BuildConfig.FLAVOR);
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            str2 = str2 + strReplace.charAt(i2);
            i++;
            if (i == 4) {
                str2 = str2 + ((Object) space);
                i = 0;
            }
        }
        return (str2.length() <= 3 || str2.charAt(str2.length() + (-1)) != space.charAt(0)) ? str2 : str2.substring(0, str2.length() - 1);
    }
}
