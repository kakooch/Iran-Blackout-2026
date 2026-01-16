package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;

/* loaded from: classes3.dex */
public class InstaPostEditTextPresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    Context mContext;
    OnDoneListener onDeleteIfNeeded;
    OnDoneListener onDoneListener;
    TextWatcher textWatcher;

    public InstaPostEditTextPresenter(Context context, OnDoneListener onDoneListener, OnDoneListener onDoneListener2) {
        super(context);
        this.mContext = context;
        this.onDoneListener = onDoneListener;
        this.onDeleteIfNeeded = onDoneListener2;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.insta_item_edit_text, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, EditTextItem editTextItem) {
        super.onBindViewHolder((InstaPostEditTextPresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.edittext.setHint(editTextItem.hint);
        myViewHolder.edittext.setText(editTextItem.text);
        myViewHolder.edittext.removeTextChangedListener(this.textWatcher);
        TextWatcher textWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.presenters.InstaPostEditTextPresenter.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                MyViewHolder myViewHolder2 = myViewHolder;
                ((EditTextItem) myViewHolder2.item).text = myViewHolder2.edittext.getText().toString();
                OnDoneListener onDoneListener = InstaPostEditTextPresenter.this.onDoneListener;
                if (onDoneListener != null) {
                    onDoneListener.onDone(myViewHolder);
                }
            }
        };
        this.textWatcher = textWatcher;
        myViewHolder.edittext.addTextChangedListener(textWatcher);
        myViewHolder.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.resaneh1.iptv.presenters.InstaPostEditTextPresenter.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                OnDoneListener onDoneListener;
                if (z || !((EditTextItem) myViewHolder.item).text.isEmpty() || (onDoneListener = InstaPostEditTextPresenter.this.onDeleteIfNeeded) == null) {
                    return;
                }
                onDoneListener.onDone(myViewHolder);
            }
        });
        if (((EditTextItem) myViewHolder.item).isRequestFocus) {
            myViewHolder.edittext.requestFocus();
            ((EditTextItem) myViewHolder.item).isRequestFocus = false;
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public EditText edittext;

        public MyViewHolder(InstaPostEditTextPresenter instaPostEditTextPresenter, View view) {
            super(view);
            this.edittext = (EditText) view.findViewById(R.id.editText);
        }
    }
}
