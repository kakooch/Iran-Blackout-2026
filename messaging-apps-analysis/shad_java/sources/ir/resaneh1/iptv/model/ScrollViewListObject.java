package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ScrollViewListObject extends PresenterItem {
    public boolean hasLoadMore;
    public boolean isLoading;
    public int itemHeight;
    public int lastPosition;
    public ArrayList<PresenterItem> list;
    public ListInput listInput;
    public OnPresenterItemClickListener onPresenterItemClickListener;
    public PresenterSelector presenterSelector;

    public ScrollViewListObject(ListInput listInput, PresenterSelector presenterSelector) {
        this.lastPosition = -1;
        this.isLoading = false;
        this.hasLoadMore = false;
        this.itemHeight = -1;
        this.list = new ArrayList<>();
        this.listInput = listInput;
        this.presenterSelector = presenterSelector;
    }

    public ScrollViewListObject(ArrayList<PresenterItem> arrayList, PresenterSelector presenterSelector) {
        this.lastPosition = -1;
        this.isLoading = false;
        this.hasLoadMore = false;
        this.itemHeight = -1;
        this.list = new ArrayList<>();
        this.list = arrayList;
        this.presenterSelector = presenterSelector;
        this.hasLoadMore = false;
    }

    public int getLastPosition() {
        if (this.lastPosition < 0) {
            this.lastPosition = this.list.size() - 1;
        }
        return this.lastPosition;
    }

    public void setLastPosition(int i) {
        this.lastPosition = i;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.ScrollViewList;
    }
}
