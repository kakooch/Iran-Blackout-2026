package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ViewPagerListItem extends PresenterItem {
    public ArrayList<? extends PresenterItem> list;
    public OnPresenterItemClickListener onPresenterItemClickListener;
    public PresenterSelector presenterSelector;

    public ViewPagerListItem(ArrayList<? extends PresenterItem> arrayList, PresenterSelector presenterSelector, OnPresenterItemClickListener onPresenterItemClickListener) {
        this.list = new ArrayList<>();
        this.list = arrayList;
        this.presenterSelector = presenterSelector;
        this.onPresenterItemClickListener = onPresenterItemClickListener;
    }
}
