package ir.resaneh1.iptv.model;

import android.net.Uri;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class AODObjectAbs extends Abs {
    public String duration;
    public boolean is_album = false;
    public String name;
    public String singer;
    public String streamPath;
    public String track_id;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.aod;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.track_id;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        String str = this.name;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public Uri getMediaSourceUri() {
        String str = this.streamPath;
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return this.name + this.singer;
    }
}
