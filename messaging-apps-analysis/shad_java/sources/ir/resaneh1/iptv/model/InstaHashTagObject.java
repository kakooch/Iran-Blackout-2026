package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class InstaHashTagObject extends PresenterItem {
    public String content;
    public String full_post_thumbnail_url;
    public String id;
    public String public_post_count;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.instaHashTag;
    }

    public String getText() {
        return this.public_post_count + " پست";
    }

    public String getImageUrl() {
        return this.full_post_thumbnail_url;
    }
}
