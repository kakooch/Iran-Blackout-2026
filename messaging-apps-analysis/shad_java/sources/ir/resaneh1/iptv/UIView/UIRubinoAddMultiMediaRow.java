package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.fragment.RubinoAddPostFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.RubinoAddMediaItem;
import ir.resaneh1.iptv.model.SendingMediaInfo;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import ir.resaneh1.iptv.presenters.RubinoAddMediaPresenter;
import ir.resaneh1.iptv.presenters.RubinoSendingMediaInListPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class UIRubinoAddMultiMediaRow {
    public RubinoAddMediaItem addMediaItem;
    public Activity context;
    public PresenterFragment fragment;
    public FrameLayout frameLayoutContainer;
    public View.OnClickListener onAddClick;
    public OnDoneListener onDelete;
    public RecyclerViewListPresenter.MyViewHolder recyclerViewListHolder;
    public RecyclerViewListObject recyclerViewListObject;
    RubinoSendingMediaInListPresenter sendingMediaPresenter;
    int size;
    public View view;
    int y;
    public int limit = 10;
    public boolean isPausePresenterFragment = false;
    int maxDy = AndroidUtilities.dp(56.0f);
    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.UIView.UIRubinoAddMultiMediaRow.4
        public Runnable runnableAutoPlay = new Runnable() { // from class: ir.resaneh1.iptv.UIView.UIRubinoAddMultiMediaRow.4.1
            @Override // java.lang.Runnable
            public void run() {
                UIRubinoAddMultiMediaRow.this.playVideoInListIfNeeded();
            }
        };

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            UIRubinoAddMultiMediaRow.this.y += i;
            AndroidUtilities.cancelRunOnUIThread(this.runnableAutoPlay);
            AndroidUtilities.runOnUIThread(this.runnableAutoPlay, 100L);
            int iAbs = Math.abs(UIRubinoAddMultiMediaRow.this.y);
            UIRubinoAddMultiMediaRow uIRubinoAddMultiMediaRow = UIRubinoAddMultiMediaRow.this;
            if (iAbs < uIRubinoAddMultiMediaRow.maxDy) {
                return;
            }
            uIRubinoAddMultiMediaRow.y = 0;
            RecyclerView.LayoutManager layoutManager = uIRubinoAddMultiMediaRow.recyclerViewListHolder.recyclerView.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            boolean z = false;
            for (int i3 = 0; i3 < layoutManager.getChildCount(); i3++) {
                if (layoutManager.getChildAt(i3) != null && (layoutManager.getChildAt(i3).getTag() instanceof RubinoSendingMediaInListPresenter.ViewHolder) && ((RubinoSendingMediaInListPresenter.ViewHolder) layoutManager.getChildAt(i3).getTag()) == RubinoSendingMediaInListPresenter.lastPlayingHolder) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            if (RubinoSendingMediaInListPresenter.lastPlayingHolder != null) {
                RubinoSendingMediaInListPresenter.lastPlayingHolder = null;
            }
            PlayerPresenter.destroyPlayer(UIRubinoAddMultiMediaRow.this.context);
        }
    };

    public void createView(Activity activity, View.OnClickListener onClickListener, final PresenterFragment presenterFragment) {
        this.context = activity;
        this.onAddClick = onClickListener;
        this.fragment = presenterFragment;
        this.addMediaItem = new RubinoAddMediaItem();
        this.sendingMediaPresenter = new RubinoSendingMediaInListPresenter(activity);
        double screenMinDimension = DimensionHelper.getScreenMinDimension(activity);
        Double.isNaN(screenMinDimension);
        int i = (int) (screenMinDimension * 0.9d);
        this.size = i;
        RubinoSendingMediaInListPresenter rubinoSendingMediaInListPresenter = this.sendingMediaPresenter;
        rubinoSendingMediaInListPresenter.onDelete = this.onDelete;
        rubinoSendingMediaInListPresenter.width = i;
        rubinoSendingMediaInListPresenter.height = i;
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.insta_add_multi_media_row, (ViewGroup) null);
        this.view = viewInflate;
        this.frameLayoutContainer = (FrameLayout) viewInflate.findViewById(R.id.frameLayoutContainer);
        this.onDelete = new OnDoneListener() { // from class: ir.resaneh1.iptv.UIView.UIRubinoAddMultiMediaRow.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnDoneListener
            public void onDone(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                try {
                    UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.remove(abstractViewHolder.item);
                    UIRubinoAddMultiMediaRow.this.recyclerViewListHolder.recyclerView.getAdapter().notifyDataSetChanged();
                    UIRubinoAddMultiMediaRow.this.removeAddItemIfNeeded();
                    if (UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.size() > 0) {
                        UIRubinoAddMultiMediaRow uIRubinoAddMultiMediaRow = UIRubinoAddMultiMediaRow.this;
                        uIRubinoAddMultiMediaRow.refreshSizeByFirstMedia((SendingMediaInfo) uIRubinoAddMultiMediaRow.recyclerViewListObject.list.get(0));
                    }
                    PresenterFragment presenterFragment2 = presenterFragment;
                    if (presenterFragment2 instanceof RubinoAddPostFragment) {
                        ((RubinoAddPostFragment) presenterFragment2).sendingMediaInfos.clear();
                        for (int i2 = 0; i2 < UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.size(); i2++) {
                            if (UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.get(i2) instanceof SendingMediaInfo) {
                                ((RubinoAddPostFragment) presenterFragment).sendingMediaInfos.add((SendingMediaInfo) UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.get(i2));
                            }
                        }
                    }
                    if (UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.size() <= 1) {
                        if (presenterFragment instanceof RubinoAddPostFragment) {
                            UIRubinoAddMultiMediaRow.this.recyclerViewListObject.list.clear();
                            ((RubinoAddPostFragment) presenterFragment).refreshLayout();
                            return;
                        }
                        return;
                    }
                    UIRubinoAddMultiMediaRow.this.addAddItemIfNeeded();
                } catch (Exception unused) {
                }
            }
        };
        initListView();
    }

    public void initListView() {
        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(new ListInput((ArrayList<? extends PresenterItem>) new ArrayList()), new PresenterSelector() { // from class: ir.resaneh1.iptv.UIView.UIRubinoAddMultiMediaRow.2
            RubinoAddMediaPresenter addMediaPresenter;

            {
                this.addMediaPresenter = new RubinoAddMediaPresenter(UIRubinoAddMultiMediaRow.this.context);
            }

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.sendingMediaInfo) {
                    UIRubinoAddMultiMediaRow uIRubinoAddMultiMediaRow = UIRubinoAddMultiMediaRow.this;
                    RubinoSendingMediaInListPresenter rubinoSendingMediaInListPresenter = uIRubinoAddMultiMediaRow.sendingMediaPresenter;
                    rubinoSendingMediaInListPresenter.onDelete = uIRubinoAddMultiMediaRow.onDelete;
                    return rubinoSendingMediaInListPresenter;
                }
                if (presenterItemType == PresenterItemType.rubinoAddMedia) {
                    this.addMediaPresenter.width = AndroidUtilities.dp(150.0f);
                    this.addMediaPresenter.height = AndroidUtilities.dp(150.0f);
                    return this.addMediaPresenter;
                }
                return MainPresenterSelector.getInstance(ApplicationLoader.applicationActivity).getPresenter(presenterItemType);
            }
        }, ApplicationLoader.applicationActivity.getLastFragment());
        this.recyclerViewListObject = recyclerViewListObject;
        recyclerViewListObject.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.UIView.UIRubinoAddMultiMediaRow.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                View.OnClickListener onClickListener;
                if (abstractViewHolder.item.getPresenterType() != PresenterItemType.rubinoAddMedia || (onClickListener = UIRubinoAddMultiMediaRow.this.onAddClick) == null) {
                    return;
                }
                onClickListener.onClick(abstractViewHolder.itemView);
            }
        };
        RecyclerViewListObject recyclerViewListObject2 = this.recyclerViewListObject;
        recyclerViewListObject2.hasMoreText = false;
        recyclerViewListObject2.hasLoadMore = false;
        recyclerViewListObject2.hastTitle = false;
        recyclerViewListObject2.isSaveSelected = false;
        recyclerViewListObject2.itemHeight = this.size;
        recyclerViewListObject2.decorationSize = 8;
        RecyclerViewListPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new RecyclerViewListPresenter(ApplicationLoader.applicationActivity).createViewHolderAndBind(this.recyclerViewListObject);
        this.recyclerViewListHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.recyclerView.setPadding(AndroidUtilities.dp(8.0f), 0, 0, 0);
        this.frameLayoutContainer.removeAllViews();
        this.frameLayoutContainer.addView(this.recyclerViewListHolder.itemView);
        this.recyclerViewListHolder.recyclerView.addOnScrollListener(this.onScrollListener);
    }

    public void refreshSizeByFirstMedia(SendingMediaInfo sendingMediaInfo) {
        int i = this.size;
        int i2 = sendingMediaInfo.width;
        int i3 = i2 != 0 ? (sendingMediaInfo.height * i) / i2 : i;
        RubinoSendingMediaInListPresenter rubinoSendingMediaInListPresenter = this.sendingMediaPresenter;
        rubinoSendingMediaInListPresenter.width = i;
        rubinoSendingMediaInListPresenter.height = i3;
        this.recyclerViewListHolder.recyclerView.getLayoutParams().height = i3 + AndroidUtilities.dp(8.0f);
        this.recyclerViewListHolder.recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void refreshList(ArrayList<SendingMediaInfo> arrayList) {
        if (arrayList == null) {
            return;
        }
        RecyclerViewListObject recyclerViewListObject = this.recyclerViewListObject;
        if (recyclerViewListObject.list == null) {
            recyclerViewListObject.list = new ArrayList<>();
        }
        this.recyclerViewListObject.list.clear();
        Iterator<SendingMediaInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            SendingMediaInfo next = it.next();
            if (this.recyclerViewListObject.list.size() < this.limit) {
                this.recyclerViewListObject.list.add(next);
            }
        }
        if (arrayList.size() > 0) {
            refreshSizeByFirstMedia(arrayList.get(0));
        }
        addAddItemIfNeeded();
        try {
            if (this.recyclerViewListObject.list.size() > 0) {
                this.recyclerViewListHolder.recyclerView.scrollToPosition(this.recyclerViewListObject.list.size() - 1);
            }
        } catch (Exception unused) {
        }
    }

    public void addAddItemIfNeeded() {
        RecyclerViewListObject recyclerViewListObject = this.recyclerViewListObject;
        if (recyclerViewListObject.list == null) {
            recyclerViewListObject.list = new ArrayList<>();
        }
        if (this.recyclerViewListObject.list.size() > 0) {
            if (this.recyclerViewListObject.list.get(r0.size() - 1) instanceof RubinoAddMediaItem) {
                return;
            }
        }
        if (this.recyclerViewListObject.list.size() < this.limit) {
            this.recyclerViewListObject.list.add(this.addMediaItem);
            this.recyclerViewListHolder.recyclerView.getAdapter().notifyItemChanged(this.recyclerViewListObject.list.size() - 1);
        }
    }

    public void removeAddItemIfNeeded() {
        RecyclerViewListObject recyclerViewListObject = this.recyclerViewListObject;
        if (recyclerViewListObject.list == null) {
            recyclerViewListObject.list = new ArrayList<>();
        }
        if (this.recyclerViewListObject.list.size() > 0) {
            if (this.recyclerViewListObject.list.get(r0.size() - 1) instanceof RubinoAddMediaItem) {
                this.recyclerViewListObject.list.remove(r0.size() - 1);
                this.recyclerViewListHolder.recyclerView.getAdapter().notifyItemRemoved(this.recyclerViewListObject.list.size());
            }
        }
    }

    public void playVideoInListIfNeeded() {
        if (this.isPausePresenterFragment) {
            return;
        }
        new ArrayList();
        float f = 0.01f;
        Rect rect = new Rect();
        this.fragment.fragmentView.getGlobalVisibleRect(rect);
        RecyclerView.LayoutManager layoutManager = this.recyclerViewListHolder.recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        RubinoSendingMediaInListPresenter.ViewHolder viewHolder = null;
        for (int i = 0; i < layoutManager.getChildCount(); i++) {
            if (layoutManager.getChildAt(i) != null && (layoutManager.getChildAt(i).getTag() instanceof RubinoSendingMediaInListPresenter.ViewHolder)) {
                RubinoSendingMediaInListPresenter.ViewHolder viewHolder2 = (RubinoSendingMediaInListPresenter.ViewHolder) layoutManager.getChildAt(i).getTag();
                if (((SendingMediaInfo) viewHolder2.item).isVideo) {
                    Rect rect2 = new Rect();
                    viewHolder2.frameLayout.getGlobalVisibleRect(rect2);
                    int i2 = rect2.left;
                    int i3 = rect.right;
                    if (i2 <= i3) {
                        int i4 = rect.left;
                        if (i2 < i4) {
                            i2 = i4;
                        }
                        int i5 = rect2.right;
                        if (i5 >= i4) {
                            if (i5 <= i3) {
                                i3 = i5;
                            }
                            float screenWidth = (i3 - i2) / DimensionHelper.getScreenWidth(this.context);
                            if (screenWidth > f) {
                                viewHolder = viewHolder2;
                                f = screenWidth;
                            }
                            if (screenWidth == f && this.maxDy > 0) {
                                viewHolder = viewHolder2;
                                f = screenWidth;
                            }
                        }
                    }
                }
            }
        }
        if (viewHolder == null || viewHolder == RubinoSendingMediaInListPresenter.lastPlayingHolder || f <= 0.2d) {
            return;
        }
        Titem titem = viewHolder.item;
        if (((SendingMediaInfo) titem).videoEditedInfo != null) {
            this.sendingMediaPresenter.playMedia(viewHolder, Long.valueOf(((SendingMediaInfo) titem).videoEditedInfo.startTime / 1000).longValue(), Long.valueOf(((SendingMediaInfo) viewHolder.item).videoEditedInfo.endTime / 1000).longValue());
            return;
        }
        this.sendingMediaPresenter.playMedia(viewHolder);
    }
}
