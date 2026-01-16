package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.Map;

/* loaded from: classes3.dex */
public class CommentInfoObject extends PresenterItem {
    public boolean allow_add_comment = true;
    public String commentCount;
    public CommentRequestObject commentRequestObject;
    public Map<String, String> commentTagMessage;
    public String object_id;
    public float star;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.commentInfo;
    }
}
