package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ServiceItem extends PresenterItem {
    public float X1;
    public float X2;
    public float Y1;
    public float Y2;
    public String image_url = BuildConfig.FLAVOR;
    public Link link;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.serviceItem;
    }
}
