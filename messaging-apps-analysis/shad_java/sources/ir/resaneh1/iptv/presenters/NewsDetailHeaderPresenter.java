package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.LinearFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class NewsDetailHeaderPresenter extends AbstractPresenter<NewsObject, MyViewHolder> {
    Context mContext;

    public NewsDetailHeaderPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.news_detail_header, viewGroup, false));
        myViewHolder.imageView.getLayoutParams().height = DimensionHelper.getHeaderHeight(this.mContext);
        myViewHolder.imageView2.getLayoutParams().height = DimensionHelper.getHeaderHeight(this.mContext);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, NewsObject newsObject) {
        super.onBindViewHolder((NewsDetailHeaderPresenter) myViewHolder, (MyViewHolder) newsObject);
        myViewHolder.imageView2.setImageResource(R.color.transparent);
        GlideHelper.load(this.mContext, myViewHolder.imageView, newsObject.thumb_Url1, R.color.transparent);
        refresh(myViewHolder);
    }

    public void refresh(MyViewHolder myViewHolder) {
        final NewsObject newsObject = (NewsObject) myViewHolder.item;
        myViewHolder.imageView2.getLayoutParams().width = DimensionHelper.getScreenWidth((Activity) this.context);
        GlideHelper.load(this.mContext, myViewHolder.imageView2, newsObject.thumb_Url1, R.color.transparent);
        myViewHolder.resourceTitle.setText(newsObject.resTitle);
        String str = newsObject.publishTime;
        if (str != null) {
            myViewHolder.time.setText(NumberUtils.toPersian(str));
        } else {
            myViewHolder.time.setText(BuildConfig.FLAVOR);
        }
        if (newsObject.resource != null) {
            myViewHolder.resourceImg.setVisibility(0);
            GlideHelper.loadRoundedCorner(this.mContext, myViewHolder.resourceImg, newsObject.resource, R.color.transparent);
        } else {
            myViewHolder.resourceImg.setVisibility(4);
        }
        if (newsObject.isVideoStream == 1 || newsObject.isVocalStream == 1) {
            myViewHolder.playImageView.setVisibility(0);
            myViewHolder.imageView.setOnClickListener(null);
            return;
        }
        myViewHolder.playImageView.setVisibility(8);
        if (newsObject.thumb_Url1 != null) {
            myViewHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.NewsDetailHeaderPresenter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ((LaunchActivity) ((AbstractPresenter) NewsDetailHeaderPresenter.this).context).lambda$runLinkRequest$40(new LinearFragment(new ImageLargeZoomPresenter(NewsDetailHeaderPresenter.this.mContext).createViewHolderAndBind(new ImageObject(newsObject.thumb_Url1)).itemView));
                }
            });
        } else {
            myViewHolder.imageView.setOnClickListener(null);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<NewsObject> {
        public FrameLayout frameLayout;
        public ImageView imageView;
        public ImageView imageView2;
        public ImageView playImageView;
        public ImageView resourceImg;
        public TextView resourceTitle;
        public TextView time;

        public MyViewHolder(NewsDetailHeaderPresenter newsDetailHeaderPresenter, View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.imageView2 = (ImageView) view.findViewById(R.id.imageView2);
            this.time = (TextView) view.findViewById(R.id.textViewTime);
            this.resourceTitle = (TextView) view.findViewById(R.id.textViewResource);
            this.resourceImg = (ImageView) view.findViewById(R.id.imageViewResource);
            this.frameLayout = (FrameLayout) view.findViewById(R.id.frameLayoutVideoPlayer);
            view.findViewById(R.id.progressBar);
            this.playImageView = (ImageView) view.findViewById(R.id.imageViewPlay);
        }
    }
}
