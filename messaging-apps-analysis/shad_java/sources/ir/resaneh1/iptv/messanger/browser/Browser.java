package ir.resaneh1.iptv.messanger.browser;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.messanger.support.customtabs.CustomTabsIntent;
import ir.resaneh1.iptv.messanger.support.customtabs.CustomTabsSession;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.CustomTabsCopyReceiver;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.ShareBroadcastReceiver;
import org.rbmain.messenger.SharedConfig;

/* loaded from: classes3.dex */
public class Browser {
    private static CustomTabsSession getSession() {
        return null;
    }

    public static boolean openUrl(Context context, Uri uri) {
        PendingIntent broadcast;
        if (context != null && uri != null) {
            try {
                String lowerCase = uri.getScheme() != null ? uri.getScheme().toLowerCase() : BuildConfig.FLAVOR;
                if ("http".equals(lowerCase) || "https".equals(lowerCase)) {
                    try {
                        uri = uri.normalizeScheme();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                if (SharedConfig.customTabs && !lowerCase.equals("tel")) {
                    Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) ShareBroadcastReceiver.class);
                    intent.setAction("android.intent.action.SEND");
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 23) {
                        broadcast = PendingIntent.getBroadcast(ApplicationLoader.applicationContext, 0, new Intent(ApplicationLoader.applicationContext, (Class<?>) CustomTabsCopyReceiver.class), 167772160);
                    } else {
                        broadcast = PendingIntent.getBroadcast(ApplicationLoader.applicationContext, 0, new Intent(ApplicationLoader.applicationContext, (Class<?>) CustomTabsCopyReceiver.class), 134217728);
                    }
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(getSession());
                    builder.addMenuItem(LocaleController.getString("CopyLink", R.string.CopyLinkEnglish), broadcast);
                    builder.setToolbarColor(-657931);
                    builder.setShowTitle(true);
                    if (i >= 23) {
                        builder.setActionButton(BitmapFactory.decodeResource(context.getResources(), R.drawable.abc_ic_menu_share_mtrl_alpha), LocaleController.getString("ShareFile", R.string.ShareFile), PendingIntent.getBroadcast(context, 0, intent, 167772160), true);
                    } else {
                        builder.setActionButton(BitmapFactory.decodeResource(context.getResources(), R.drawable.abc_ic_menu_share_mtrl_alpha), LocaleController.getString("ShareFile", R.string.ShareFile), PendingIntent.getBroadcast(context, 0, intent, 134217728), true);
                    }
                    CustomTabsIntent customTabsIntentBuild = builder.build();
                    customTabsIntentBuild.setUseNewTask();
                    customTabsIntentBuild.launchUrl(context, uri);
                    return true;
                }
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        return false;
    }
}
