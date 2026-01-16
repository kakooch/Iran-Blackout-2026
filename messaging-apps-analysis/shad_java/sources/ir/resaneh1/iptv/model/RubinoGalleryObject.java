package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class RubinoGalleryObject extends PresenterItem {
    public long dateAdded;
    public long duration;
    public long galleryObjectId;
    public boolean isVideo;
    public String path;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.rubinoGallery;
    }

    public String getDurationString() {
        Object objValueOf;
        Object objValueOf2;
        long j = this.duration;
        long j2 = (j / 1000) / 60;
        int i = (int) ((j / 1000) % 60);
        StringBuilder sb = new StringBuilder();
        if (j2 < 10) {
            objValueOf = "0" + j2;
        } else {
            objValueOf = Long.valueOf(j2);
        }
        sb.append(objValueOf);
        sb.append(":");
        if (i < 10) {
            objValueOf2 = "0" + i;
        } else {
            objValueOf2 = Integer.valueOf(i);
        }
        sb.append(objValueOf2);
        return sb.toString();
    }
}
