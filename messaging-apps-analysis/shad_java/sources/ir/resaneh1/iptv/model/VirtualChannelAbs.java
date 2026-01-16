package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class VirtualChannelAbs extends PresenterItem {
    public String count_post;
    public String subtitle;
    public String vchannel_id;
    public String title = BuildConfig.FLAVOR;
    public String image_url = BuildConfig.FLAVOR;
    public EnumViewType default_view = EnumViewType.tile;

    public enum EnumViewType {
        tile,
        list
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.virtualChannelAbs;
    }
}
