package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class GameCommentObject extends PresenterItem {
    public String comment_id;
    public String text;
    public String user_image_url;
    public String username;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.gameComment;
    }

    public GameCommentObject(String str, String str2, String str3) {
        this.text = str2;
        this.username = str;
        this.user_image_url = str3;
    }

    public SpannableString getSpannableString() {
        if (this.username == null) {
            this.username = BuildConfig.FLAVOR;
        }
        return SpanHelper.makeWithColorAndRelativeSize(new SpannableString(this.username + " \u061c" + this.text), 0, this.username.length(), ApplicationLoader.applicationContext.getResources().getColor(R.color.colorPrimary), 1.0f);
    }
}
