package androidMessenger.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes.dex */
public class PushNotificationObject {
    public String img;
    public ir.resaneh1.iptv.model.Link link;
    public String msg;
    public String title = LocaleController.getString("AppName", R.string.AppName) + BuildConfig.FLAVOR;
}
