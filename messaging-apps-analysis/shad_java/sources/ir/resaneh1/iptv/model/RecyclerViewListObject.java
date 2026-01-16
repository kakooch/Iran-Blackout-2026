package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class RecyclerViewListObject extends PresenterItem {
    public BaseFragment baseFragment;
    public int decorationSize;
    public boolean hasLoadMore;
    public boolean hasMoreText;
    public boolean hastTitle;
    public RecyclerViewListPresenter.MyViewHolder holder;
    public boolean isGrid;
    public boolean isLoop;
    public boolean isSaveSelected;
    public boolean isStopLoading;
    public boolean isVertical;
    public int itemCount;
    public int itemHeight;
    public int itemWidth;
    public int lastPosition;
    public ArrayList<PresenterItem> list;
    public ListInput listInput;
    public LoadMoreItem loadMoreItem;
    public OnDoneListener onDoneListener;
    public ItemListRequest.Listener onItemLoadedListener;
    public OnPresenterItemClickListener onMoreTextClickListener;
    public OnPresenterItemClickListener onPresenterItemClickListener;
    public String pagePartId;
    public PresenterSelector presenterSelector;

    public RecyclerViewListObject(ListInput listInput, PresenterSelector presenterSelector, BaseFragment baseFragment) {
        this.lastPosition = -1;
        this.isGrid = false;
        this.isVertical = false;
        this.hasLoadMore = true;
        this.hasMoreText = true;
        this.isSaveSelected = false;
        this.isLoop = false;
        this.itemWidth = 0;
        this.itemHeight = 0;
        this.decorationSize = 0;
        this.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.model.RecyclerViewListObject.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(RecyclerViewListObject.this.baseFragment, abstractViewHolder);
            }
        };
        this.isStopLoading = false;
        this.list = new ArrayList<>();
        this.itemCount = 0;
        this.hastTitle = true;
        this.listInput = listInput;
        this.presenterSelector = presenterSelector;
        this.baseFragment = baseFragment;
    }

    public RecyclerViewListObject(ArrayList<? extends PresenterItem> arrayList, PresenterSelector presenterSelector, BaseFragment baseFragment) {
        this.lastPosition = -1;
        this.isGrid = false;
        this.isVertical = false;
        this.hasLoadMore = true;
        this.hasMoreText = true;
        this.isSaveSelected = false;
        this.isLoop = false;
        this.itemWidth = 0;
        this.itemHeight = 0;
        this.decorationSize = 0;
        this.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.model.RecyclerViewListObject.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(RecyclerViewListObject.this.baseFragment, abstractViewHolder);
            }
        };
        this.isStopLoading = false;
        this.list = new ArrayList<>();
        this.itemCount = 0;
        this.hastTitle = true;
        this.list = new ArrayList<>();
        this.listInput = new ListInput(arrayList);
        this.list.addAll(arrayList);
        this.presenterSelector = presenterSelector;
        this.baseFragment = baseFragment;
    }

    public int getLastPosition() {
        if (this.lastPosition < 0) {
            this.lastPosition = 0;
        }
        return this.lastPosition;
    }

    public void setLastPosition(int i) {
        this.lastPosition = i;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        if (this.isGrid) {
            return PresenterItemType.RecyclerViewGrid;
        }
        return PresenterItemType.RecyclerViewList;
    }

    public int getItemHeight() {
        if (this.listInput == null) {
            return AndroidUtilities.dp(40.0f);
        }
        if (this.itemHeight == 0) {
            this.itemHeight = DimensionHelper.getItemHeight(ApplicationLoader.applicationContext, this.listInput);
        }
        return this.itemHeight;
    }

    public int getItemWidth() {
        if (this.itemWidth == 0) {
            this.itemWidth = DimensionHelper.getItemWidth(ApplicationLoader.applicationContext, this.listInput);
        }
        return this.itemWidth;
    }

    public void setGrid() {
        this.isGrid = true;
        this.presenterSelector.isGrid = true;
    }
}
