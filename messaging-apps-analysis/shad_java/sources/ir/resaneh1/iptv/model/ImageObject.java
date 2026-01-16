package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ImageObject extends PresenterItem {
    public float height;
    public String image_url;
    public Link link;
    public float w_h_ratio;

    public ImageObject(String str) {
        this.w_h_ratio = -1.0f;
        this.height = -1.0f;
        this.image_url = str;
    }

    public ImageObject(String str, Link link) {
        this.w_h_ratio = -1.0f;
        this.height = -1.0f;
        this.image_url = str;
        this.link = link;
    }

    public ImageObject(String str, float f, float f2) {
        this.w_h_ratio = -1.0f;
        this.height = -1.0f;
        this.image_url = str;
        this.w_h_ratio = f;
        this.height = f2;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.ImageObject;
    }
}
