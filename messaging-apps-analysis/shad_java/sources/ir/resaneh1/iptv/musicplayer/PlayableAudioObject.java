package ir.resaneh1.iptv.musicplayer;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class PlayableAudioObject extends PresenterItem {
    public AODObjectAbs aodObject;
    final int currentAccount;
    public String streamUrl = null;
    public long startTime = 0;
    public String aodViewId = null;
    public Type type = Type.aod;

    public enum Type {
        aod,
        url,
        file
    }

    public String getDurationString() {
        return BuildConfig.FLAVOR;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.playableObject;
    }

    public PlayableAudioObject(AODObjectAbs aODObjectAbs, int i) {
        this.aodObject = aODObjectAbs;
        this.currentAccount = i;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.type == Type.aod ? this.aodObject.track_id : BuildConfig.FLAVOR;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        return this.type == Type.aod ? this.aodObject.name : BuildConfig.FLAVOR;
    }

    public String getSubtitle() {
        return this.type == Type.aod ? this.aodObject.singer : BuildConfig.FLAVOR;
    }

    public String getImageUrl() {
        return this.type == Type.aod ? this.aodObject.image_url : BuildConfig.FLAVOR;
    }
}
