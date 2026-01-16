package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.LoadMoreItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class LoadMorePresenter extends AbstractPresenter<LoadMoreItem, ViewHolder> {
    View.OnClickListener onLoadMoreClicked;

    public LoadMorePresenter(Context context) {
        super(context);
        this.onLoadMoreClicked = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.LoadMorePresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewHolder viewHolder = (ViewHolder) view.getTag();
                MyLog.e("LoadMorePresenter", "onClick: ");
                ((LoadMoreItem) viewHolder.item).isLoading = true;
                LoadMorePresenter.refresh(viewHolder);
                Titem titem = viewHolder.item;
                if (((LoadMoreItem) titem).onClickListener != null) {
                    ((LoadMoreItem) titem).onClickListener.onClick(view);
                }
            }
        };
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.load_more_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewHolder.loadMoreImageView.setOnClickListener(this.onLoadMoreClicked);
        viewHolder.loadMoreImageView.setTag(viewHolder);
        viewHolder.loadMoreTextView.setOnClickListener(this.onLoadMoreClicked);
        viewHolder.loadMoreTextView.setTag(viewHolder);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, LoadMoreItem loadMoreItem) {
        super.onBindViewHolder((LoadMorePresenter) viewHolder, (ViewHolder) loadMoreItem);
        refresh(viewHolder);
        if (loadMoreItem.width > 0 && loadMoreItem.height > 0) {
            viewHolder.itemView.getLayoutParams().width = loadMoreItem.width;
            viewHolder.frameLayout.getLayoutParams().width = loadMoreItem.width;
            viewHolder.frameLayout.getLayoutParams().height = loadMoreItem.height;
            return;
        }
        viewHolder.itemView.getLayoutParams().width = -1;
        viewHolder.frameLayout.getLayoutParams().width = AndroidUtilities.dp(80.0f);
        viewHolder.frameLayout.getLayoutParams().height = AndroidUtilities.dp(80.0f);
    }

    public static void refresh(ViewHolder viewHolder) {
        if (((LoadMoreItem) viewHolder.item).isLoading) {
            viewHolder.frameLayoutProgress.setVisibility(0);
            viewHolder.loadMoreImageView.setVisibility(4);
            viewHolder.loadMoreTextView.setVisibility(4);
            return;
        }
        viewHolder.frameLayoutProgress.setVisibility(4);
        if (((LoadMoreItem) viewHolder.item).loadMoreType == LoadMoreItem.LoadMoreType.moreIcon) {
            viewHolder.loadMoreImageView.setVisibility(0);
            viewHolder.loadMoreTextView.setVisibility(4);
        } else {
            viewHolder.loadMoreTextView.setVisibility(0);
            viewHolder.loadMoreImageView.setVisibility(4);
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<LoadMoreItem> {
        public FrameLayout frameLayout;
        public FrameLayout frameLayoutProgress;
        public ImageView loadMoreImageView;
        public View loadMoreTextView;

        public ViewHolder(View view) {
            super(view);
            this.loadMoreImageView = (ImageView) view.findViewById(R.id.imageViewLoadMore);
            this.frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
            this.loadMoreTextView = view.findViewById(R.id.textViewLoadMore);
            this.frameLayoutProgress = (FrameLayout) view.findViewById(R.id.progressBarFrame);
            if (ApplicationLoader.applicationActivity != null) {
                UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, this.frameLayoutProgress);
            }
        }
    }
}
