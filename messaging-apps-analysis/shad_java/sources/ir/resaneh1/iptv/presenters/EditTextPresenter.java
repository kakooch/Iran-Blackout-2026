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

/* loaded from: classes3.dex */
public class EditTextPresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    Context mContext;

    public EditTextPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_edit_text, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final EditTextItem editTextItem) {
        super.onBindViewHolder((EditTextPresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.edittext.setText(editTextItem.text);
        myViewHolder.edittext.setHint(editTextItem.hint);
        myViewHolder.edittext.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.EditTextPresenter.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                editTextItem.text = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                editTextItem.text = myViewHolder.edittext.getText().toString();
            }
        });
        if (editTextItem.isEditable) {
            myViewHolder.edittext.setInputType(1);
            return;
        }
        myViewHolder.edittext.setInputType(0);
        View.OnClickListener onClickListener = editTextItem.onClickListener;
        if (onClickListener != null) {
            myViewHolder.edittext.setOnClickListener(onClickListener);
            myViewHolder.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextPresenter.2
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        editTextItem.onClickListener.onClick(view);
                    }
                }
            });
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public EditText edittext;

        public MyViewHolder(EditTextPresenter editTextPresenter, View view) {
            super(view);
            this.edittext = (EditText) view.findViewById(R.id.editText);
        }
    }
}
