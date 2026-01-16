package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ClubSetttingItem extends PresenterItem {
    public ColorObject color1;
    public ColorObject color2;
    public String icon_url;
    public ArrayList<ClubSetttingItem> items;
    public Link link;
    public String text1;
    public String text2 = BuildConfig.FLAVOR;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.clubSettingItem;
    }
}
