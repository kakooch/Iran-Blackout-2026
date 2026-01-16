package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class TextLikeEditTextPresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    Context mContext;

    public TextLikeEditTextPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_text_like_edit_text, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final EditTextItem editTextItem) {
        super.onBindViewHolder((TextLikeEditTextPresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.textView.setText(editTextItem.text);
        myViewHolder.textView.setHint(editTextItem.hint);
        myViewHolder.textView.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.TextLikeEditTextPresenter.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                editTextItem.text = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                editTextItem.text = myViewHolder.textView.getText().toString();
            }
        });
        View.OnClickListener onClickListener = editTextItem.onClickListener;
        if (onClickListener != null) {
            myViewHolder.textView.setOnClickListener(onClickListener);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public TextView textView;

        public MyViewHolder(TextLikeEditTextPresenter textLikeEditTextPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
