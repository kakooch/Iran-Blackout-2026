package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.TextViewItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class TextViewPresenter extends AbstractPresenter<TextViewItem, MyViewHolder> {
    Context mContext;

    public TextViewPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_text_view, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TextViewItem textViewItem) {
        super.onBindViewHolder((TextViewPresenter) myViewHolder, (MyViewHolder) textViewItem);
        myViewHolder.textView.setText(textViewItem.text);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TextViewItem> {
        public TextView textView;

        public MyViewHolder(TextViewPresenter textViewPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
