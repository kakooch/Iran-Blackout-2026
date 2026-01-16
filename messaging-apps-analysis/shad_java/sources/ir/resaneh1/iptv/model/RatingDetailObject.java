package ir.resaneh1.iptv.model;

import android.view.View;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class RatingDetailObject extends PresenterItem {
    public String count;
    public String id;
    public View.OnClickListener onSendCommentClick;
    public float star;
    public TagObject.TagType type;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.ratingDetail;
    }
}
