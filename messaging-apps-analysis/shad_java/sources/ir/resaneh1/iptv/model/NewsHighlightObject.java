package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class NewsHighlightObject extends PresenterItem {
    public String WebLink;
    public String bannerSize;
    public String category;
    public String id;
    public String imageUrl;
    public String isMedia;
    public String newsId;
    public String position;
    public String title;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.newsHighlight;
    }
}
