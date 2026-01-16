package ir.resaneh1.iptv.model;

import android.view.View;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class LoadMoreItem extends PresenterItem {
    public LoadMoreType loadMoreType;
    public View.OnClickListener onClickListener;
    public boolean isLoading = false;
    public int width = -1;
    public int height = -1;

    public enum LoadMoreType {
        moreText,
        moreIcon
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.loadMore;
    }

    public LoadMoreItem(View.OnClickListener onClickListener, LoadMoreType loadMoreType) {
        this.loadMoreType = LoadMoreType.moreIcon;
        this.onClickListener = onClickListener;
        this.loadMoreType = loadMoreType;
    }
}
