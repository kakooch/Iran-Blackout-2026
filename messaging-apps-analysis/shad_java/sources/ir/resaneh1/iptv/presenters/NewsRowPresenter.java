package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class NewsRowPresenter extends AbstractPresenter<NewsObject, MyViewHolder> {
    Context mContext;

    public NewsRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.news_row, viewGroup, false));
        myViewHolder.playImageView.setTag(myViewHolder);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, NewsObject newsObject) {
        String str;
        super.onBindViewHolder((NewsRowPresenter) myViewHolder, (MyViewHolder) newsObject);
        myViewHolder.titleTextView.setText(newsObject.title);
        String str2 = newsObject.resTitle;
        if ((str2 == null || str2.equals(BuildConfig.FLAVOR)) && ((str = newsObject.publishTime) == null || str.equals(BuildConfig.FLAVOR))) {
            myViewHolder.firstRowView.setVisibility(8);
        } else {
            myViewHolder.firstRowView.setVisibility(0);
        }
        myViewHolder.resourceTitle.setText(newsObject.resTitle);
        String str3 = newsObject.publishTime;
        if (str3 != null) {
            myViewHolder.time.setText(NumberUtils.toPersian(str3));
        } else {
            myViewHolder.time.setText(BuildConfig.FLAVOR);
        }
        String str4 = newsObject.visitNo;
        if (str4 != null) {
            myViewHolder.count.setText(NumberUtils.toPersian(str4));
        } else {
            myViewHolder.count.setText(NumberUtils.toPersian("0"));
        }
        GlideHelper.loadRoundedCorner(this.mContext, myViewHolder.imageView, newsObject.thumb_Url1, R.drawable.shape_grey_background);
        if (newsObject.resource != null) {
            myViewHolder.resourceImg.setVisibility(0);
            GlideHelper.loadRoundedCorner(this.mContext, myViewHolder.resourceImg, newsObject.resource, R.color.transparent);
        } else {
            myViewHolder.resourceImg.setVisibility(4);
        }
        if (newsObject.isVideoStream == 1 || newsObject.isVocalStream == 1) {
            myViewHolder.playImageView.setVisibility(0);
        } else {
            myViewHolder.playImageView.setVisibility(8);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<NewsObject> {
        public TextView count;
        public View firstRowView;
        public ImageView imageView;
        public ImageView playImageView;
        public ImageView resourceImg;
        public TextView resourceTitle;
        public TextView time;
        public TextView titleTextView;

        public MyViewHolder(NewsRowPresenter newsRowPresenter, View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.titleTextView = (TextView) view.findViewById(R.id.textViewTitle);
            this.count = (TextView) view.findViewById(R.id.textViewCount);
            this.time = (TextView) view.findViewById(R.id.textViewTime);
            this.resourceTitle = (TextView) view.findViewById(R.id.textViewResource);
            this.resourceImg = (ImageView) view.findViewById(R.id.imageViewResource);
            this.playImageView = (ImageView) view.findViewById(R.id.imageViewPlay);
            this.firstRowView = view.findViewById(R.id.firstRow);
        }
    }
}
