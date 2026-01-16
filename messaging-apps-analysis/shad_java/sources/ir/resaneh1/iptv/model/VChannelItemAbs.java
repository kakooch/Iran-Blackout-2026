package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import ir.resaneh1.iptv.enums.EnumVChannelItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class VChannelItemAbs extends PresenterItem {
    public String image_url;
    public String image_url_Channel;
    public boolean isMyPost = false;
    public String item_id;
    public TimeObject time;
    public String title;

    @SerializedName("type")
    public EnumVChannelItemType vChannelItemType;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.VChannelItemAbs;
    }
}
