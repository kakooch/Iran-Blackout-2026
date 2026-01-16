package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.TwoEditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class TwoTextLikeEditTextPresenter extends AbstractPresenter<TwoEditTextItem, MyViewHolder> {
    Context mContext;

    public TwoTextLikeEditTextPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.two_text_like_edit_text, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TwoEditTextItem twoEditTextItem) {
        super.onBindViewHolder((TwoTextLikeEditTextPresenter) myViewHolder, (MyViewHolder) twoEditTextItem);
        myViewHolder.textView1.setText(twoEditTextItem.text1);
        myViewHolder.textView1.setHint(twoEditTextItem.hint1);
        myViewHolder.textView2.setText(twoEditTextItem.text2);
        myViewHolder.textView2.setHint(twoEditTextItem.hint2);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TwoEditTextItem> {
        public TextView textView1;
        public TextView textView2;

        public MyViewHolder(TwoTextLikeEditTextPresenter twoTextLikeEditTextPresenter, View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
        }
    }
}
