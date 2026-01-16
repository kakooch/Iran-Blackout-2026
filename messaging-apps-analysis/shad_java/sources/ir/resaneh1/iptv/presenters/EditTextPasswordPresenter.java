package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AsteriskPasswordTransformationMethod;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class EditTextPasswordPresenter extends AbstractPresenter<EditTextItem, MyViewHolder> {
    Context mContext;
    View.OnClickListener onToggleClickListener;

    public EditTextPasswordPresenter(Context context) {
        super(context);
        this.onToggleClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextPasswordPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                Titem titem = myViewHolder.item;
                ((EditTextItem) titem).isShowPass = !((EditTextItem) titem).isShowPass;
                if (!((EditTextItem) titem).isShowPass) {
                    myViewHolder.edittext.setTransformationMethod(new AsteriskPasswordTransformationMethod());
                } else {
                    myViewHolder.edittext.setTransformationMethod(null);
                }
            }
        };
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_edit_text_with_drawable, viewGroup, false));
        myViewHolder.drawableRight.setTag(myViewHolder);
        myViewHolder.drawableRight.setOnClickListener(this.onToggleClickListener);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final EditTextItem editTextItem) {
        super.onBindViewHolder((EditTextPasswordPresenter) myViewHolder, (MyViewHolder) editTextItem);
        myViewHolder.edittext.setText(editTextItem.text);
        myViewHolder.edittext.setHint(editTextItem.hint);
        myViewHolder.edittext.setSingleLine();
        myViewHolder.edittext.setEllipsize(TextUtils.TruncateAt.END);
        myViewHolder.edittext.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.EditTextPasswordPresenter.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                editTextItem.text = myViewHolder.edittext.getText().toString();
            }
        });
        if (editTextItem.isEditable) {
            myViewHolder.edittext.setInputType(3);
        } else {
            myViewHolder.edittext.setInputType(0);
            View.OnClickListener onClickListener = editTextItem.onClickListener;
            if (onClickListener != null) {
                myViewHolder.edittext.setOnClickListener(onClickListener);
                myViewHolder.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.presenters.EditTextPasswordPresenter.2
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            editTextItem.onClickListener.onClick(view);
                        }
                    }
                });
            }
        }
        if (!((EditTextItem) myViewHolder.item).isShowPass) {
            myViewHolder.edittext.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        } else {
            myViewHolder.edittext.setTransformationMethod(null);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<EditTextItem> {
        public ImageView drawableRight;
        public EditText edittext;

        public MyViewHolder(EditTextPasswordPresenter editTextPasswordPresenter, View view) {
            super(view);
            this.edittext = (EditText) view.findViewById(R.id.editText);
            this.drawableRight = (ImageView) view.findViewById(R.id.drawableRight);
        }
    }
}
