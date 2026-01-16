package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.InstaPostObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class MediaObject extends PresenterItem {
    public InstaPostObject.FileTypeEnum fileType;
    public String imageUrl;
    public String postId;
    public String postProfileId;
    public String snapShotUrl;
    public String streamUrl;
    public String thumbnailUrl;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.Media;
    }

    public MediaObject(String str, String str2) {
        this.imageUrl = str;
        this.thumbnailUrl = str2;
        this.fileType = InstaPostObject.FileTypeEnum.Picture;
    }

    public void setForPicture(String str, String str2) {
        this.imageUrl = str;
        this.thumbnailUrl = str2;
        this.fileType = InstaPostObject.FileTypeEnum.Picture;
    }

    public MediaObject() {
    }

    public void setForVideo(String str, String str2, String str3, String str4, String str5) {
        this.postId = str;
        this.postProfileId = str2;
        this.thumbnailUrl = str3;
        this.streamUrl = str5;
        this.snapShotUrl = str4;
        this.fileType = InstaPostObject.FileTypeEnum.Video;
    }
}
