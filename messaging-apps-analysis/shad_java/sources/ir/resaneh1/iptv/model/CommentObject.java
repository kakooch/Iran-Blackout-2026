package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class CommentObject extends PresenterItem {
    public String avatar_url;
    public String count_like;
    public boolean has_page;
    public String id;
    public String message;
    public boolean more_reply;
    public TagObject replies;
    public CommentObject reply_comment;
    public String star;
    public TimeObject time;
    public String usertitle;
    public boolean isLiked = false;
    public String username = BuildConfig.FLAVOR;
    public boolean isReply = false;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.comment;
    }

    public Float getStar() {
        try {
            return Float.valueOf(Float.parseFloat(this.star));
        } catch (Exception unused) {
            return Float.valueOf(0.0f);
        }
    }
}
