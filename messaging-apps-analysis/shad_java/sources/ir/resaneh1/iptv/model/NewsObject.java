package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class NewsObject extends PresenterItem {
    public String Url;
    public String body;
    public int category;
    public String commentNo;
    public String id;
    public int isAdver;
    public int isEvent;
    public int isHot;
    public int isImportant;
    public int isOnTop;
    public int isVideoStream;
    public int isVocalStream;
    public String mmSize;
    public String mmTime;
    public String publishDate;
    public String publishTime;
    public String resTitle;
    public String resource;
    public String share_link;
    public String streamUrl;
    public String thumb_Url1;
    public String thumb_Url2;
    public String title;
    public String visitNo;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        if (this.isAdver == 1) {
            return PresenterItemType.newsAdver;
        }
        if (this.isEvent == 1) {
            return PresenterItemType.newsEvent;
        }
        return PresenterItemType.news;
    }
}
