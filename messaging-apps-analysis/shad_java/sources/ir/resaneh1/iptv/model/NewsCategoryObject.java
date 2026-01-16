package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class NewsCategoryObject extends PresenterItem {
    public float X1;
    public float X2;
    public float Y1;
    public float Y2;
    public String id;
    public int listType;
    public int order;
    public String thumb_Url;
    public String title;
    public int xAxis;
    public int yAxis;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.newsCategory;
    }
}
