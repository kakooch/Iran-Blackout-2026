package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.TwoEditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class EditTextTwoPresenter extends AbstractPresenter<TwoEditTextItem, MyViewHolder> {
    Context mContext;
    public int maxLength;

    public EditTextTwoPresenter(Context context) {
        super(context);
        this.maxLength = 2;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_two_edit_text, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final TwoEditTextItem twoEditTextItem) {
        super.onBindViewHolder((EditTextTwoPresenter) myViewHolder, (MyViewHolder) twoEditTextItem);
        myViewHolder.monthEdittext.setText(twoEditTextItem.text1);
        myViewHolder.monthEdittext.setHint(twoEditTextItem.hint1);
        InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(this.maxLength) { // from class: ir.resaneh1.iptv.presenters.EditTextTwoPresenter.1
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence != null && TextUtils.indexOf(charSequence, '\n') != -1) {
                    return BuildConfig.FLAVOR;
                }
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (charSequenceFilter != null && charSequence != null && charSequenceFilter.length() != charSequence.length()) {
                    ToastiLikeSnack.showL(EditTextTwoPresenter.this.mContext, "ماه و سال حداکثر ۲ رقمی است");
                    AndroidUtilities.shakeView(myViewHolder.itemView, 2.0f, 0);
                }
                return charSequenceFilter;
            }
        }};
        myViewHolder.monthEdittext.setFilters(inputFilterArr);
        myViewHolder.yearEdittext.setFilters(inputFilterArr);
        myViewHolder.monthEdittext.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.EditTextTwoPresenter.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                twoEditTextItem.text1 = myViewHolder.monthEdittext.getText().toString();
            }
        });
        if (twoEditTextItem.isEditable1) {
            myViewHolder.monthEdittext.setInputType(1);
        } else {
            myViewHolder.monthEdittext.setInputType(0);
            View.OnClickListener onClickListener = twoEditTextItem.onClickListener;
            if (onClickListener != null) {
                myViewHolder.monthEdittext.setOnClickListener(onClickListener);
                myViewHolder.monthEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextTwoPresenter.3
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            twoEditTextItem.onClickListener.onClick(view);
                        }
                    }
                });
            }
        }
        myViewHolder.yearEdittext.setText(twoEditTextItem.text2);
        myViewHolder.yearEdittext.setHint(twoEditTextItem.hint2);
        myViewHolder.yearEdittext.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.EditTextTwoPresenter.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                twoEditTextItem.text2 = myViewHolder.yearEdittext.getText().toString();
            }
        });
        if (twoEditTextItem.isEditable2) {
            myViewHolder.yearEdittext.setInputType(1);
            return;
        }
        myViewHolder.yearEdittext.setInputType(0);
        View.OnClickListener onClickListener2 = twoEditTextItem.onClickListener;
        if (onClickListener2 != null) {
            myViewHolder.yearEdittext.setOnClickListener(onClickListener2);
            myViewHolder.yearEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextTwoPresenter.5
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        twoEditTextItem.onClickListener.onClick(view);
                    }
                }
            });
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TwoEditTextItem> {
        public EditText monthEdittext;
        public EditText yearEdittext;

        public MyViewHolder(EditTextTwoPresenter editTextTwoPresenter, View view) {
            super(view);
            this.monthEdittext = (EditText) view.findViewById(R.id.editText1);
            this.yearEdittext = (EditText) view.findViewById(R.id.editText2);
        }
    }
}
