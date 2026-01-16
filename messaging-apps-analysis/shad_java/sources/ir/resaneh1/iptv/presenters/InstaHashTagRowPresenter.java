package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.InstaHashTagObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class InstaHashTagRowPresenter extends AbstractPresenter<InstaHashTagObject, MyViewHolder> {
    private Context mContext;

    public InstaHashTagRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.insta_hashtag_row, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        viewInflate.setTag(myViewHolder);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, InstaHashTagObject instaHashTagObject) {
        super.onBindViewHolder((InstaHashTagRowPresenter) myViewHolder, (MyViewHolder) instaHashTagObject);
        GlideHelper.loadCircle(this.mContext, myViewHolder.imageView, instaHashTagObject.getImageUrl(), R.color.transparent);
        myViewHolder.textView.setText(NumberUtils.toPersian(((InstaHashTagObject) myViewHolder.item).getText()));
        myViewHolder.hashtagNameTextView.setText("#" + ((InstaHashTagObject) myViewHolder.item).content);
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<InstaHashTagObject> {
        public TextView hashtagNameTextView;
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.hashtagNameTextView = (TextView) view.findViewById(R.id.hashtagNameTextView);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
