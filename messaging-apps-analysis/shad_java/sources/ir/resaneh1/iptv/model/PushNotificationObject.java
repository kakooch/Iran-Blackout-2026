package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class PushNotificationObject {
    public String img;
    public Link link;
    public String msg;
    public String title = LocaleController.getString(R.string.AppName) + BuildConfig.FLAVOR;
}
