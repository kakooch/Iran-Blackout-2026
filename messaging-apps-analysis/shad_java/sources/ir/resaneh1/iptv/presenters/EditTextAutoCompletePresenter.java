package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EditTextAutoCompletePresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    Context mContext;

    public EditTextAutoCompletePresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_auto_complete_text_with_icon, viewGroup, false));
        myViewHolder.edittext.setGravity(5);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final EditTextItem editTextItem) {
        super.onBindViewHolder((EditTextAutoCompletePresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.edittext.setText(editTextItem.text);
        myViewHolder.edittext.setHint(editTextItem.hint);
        ArrayList<String> arrayList = editTextItem.suggestions;
        if (arrayList != null && arrayList.size() > 0 && editTextItem.isEditable) {
            myViewHolder.edittext.setAdapter(new ArrayAdapter(this.mContext, R.layout.item_text_in_list_gravity_right_row, R.id.textView, editTextItem.suggestions));
            myViewHolder.edittext.setThreshold(0);
            myViewHolder.edittext.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextAutoCompletePresenter.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    myViewHolder.edittext.showDropDown();
                    return false;
                }
            });
        }
        if (editTextItem.isEditable) {
            myViewHolder.edittext.setInputType(1);
        } else {
            myViewHolder.edittext.setInputType(0);
            View.OnClickListener onClickListener = editTextItem.onClickListener;
            if (onClickListener != null) {
                myViewHolder.edittext.setOnClickListener(onClickListener);
                myViewHolder.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextAutoCompletePresenter.2
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            editTextItem.onClickListener.onClick(view);
                        }
                    }
                });
            }
        }
        myViewHolder.edittext.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.EditTextAutoCompletePresenter.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                myViewHolder.edittext.getText().toString();
            }
        });
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public AutoCompleteTextView edittext;

        public MyViewHolder(EditTextAutoCompletePresenter editTextAutoCompletePresenter, View view) {
            super(view);
            this.edittext = (AutoCompleteTextView) view.findViewById(R.id.editText);
        }
    }
}
