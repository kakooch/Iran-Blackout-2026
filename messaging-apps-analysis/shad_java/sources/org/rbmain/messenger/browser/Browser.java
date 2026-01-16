package org.rbmain.messenger.browser;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidMessenger.utilites.MessengerLinkHandler;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.lang.ref.WeakReference;
import java.util.List;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.CustomTabsCopyReceiver;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.ShareBroadcastReceiver;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.support.customtabs.CustomTabsCallback;
import org.rbmain.messenger.support.customtabs.CustomTabsClient;
import org.rbmain.messenger.support.customtabs.CustomTabsIntent;
import org.rbmain.messenger.support.customtabs.CustomTabsServiceConnection;
import org.rbmain.messenger.support.customtabs.CustomTabsSession;
import org.rbmain.messenger.support.customtabsclient.shared.CustomTabsHelper;
import org.rbmain.messenger.support.customtabsclient.shared.ServiceConnection;
import org.rbmain.messenger.support.customtabsclient.shared.ServiceConnectionCallback;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes4.dex */
public class Browser {
    private static WeakReference<Activity> currentCustomTabsActivity;
    private static CustomTabsClient customTabsClient;
    private static String customTabsPackageToBind;
    private static CustomTabsServiceConnection customTabsServiceConnection;
    private static CustomTabsSession customTabsSession;

    public static boolean isPassportUrl(String str) {
        return false;
    }

    private static void setCurrentSession(CustomTabsSession customTabsSession2) {
        new WeakReference(customTabsSession2);
    }

    private static CustomTabsSession getSession() {
        CustomTabsClient customTabsClient2 = customTabsClient;
        if (customTabsClient2 == null) {
            customTabsSession = null;
        } else if (customTabsSession == null) {
            CustomTabsSession customTabsSessionNewSession = customTabsClient2.newSession(new NavigationCallback());
            customTabsSession = customTabsSessionNewSession;
            setCurrentSession(customTabsSessionNewSession);
        }
        return customTabsSession;
    }

    public static void bindCustomTabsService(Activity activity) {
        WeakReference<Activity> weakReference = currentCustomTabsActivity;
        Activity activity2 = weakReference == null ? null : weakReference.get();
        if (activity2 != null && activity2 != activity) {
            unbindCustomTabsService(activity2);
        }
        if (customTabsClient != null) {
            return;
        }
        currentCustomTabsActivity = new WeakReference<>(activity);
        try {
            if (TextUtils.isEmpty(customTabsPackageToBind)) {
                String packageNameToUse = CustomTabsHelper.getPackageNameToUse(activity);
                customTabsPackageToBind = packageNameToUse;
                if (packageNameToUse == null) {
                    return;
                }
            }
            ServiceConnection serviceConnection = new ServiceConnection(new ServiceConnectionCallback() { // from class: org.rbmain.messenger.browser.Browser.1
                @Override // org.rbmain.messenger.support.customtabsclient.shared.ServiceConnectionCallback
                public void onServiceConnected(CustomTabsClient customTabsClient2) {
                    CustomTabsClient unused = Browser.customTabsClient = customTabsClient2;
                    if (!SharedConfig.customTabs || Browser.customTabsClient == null) {
                        return;
                    }
                    try {
                        Browser.customTabsClient.warmup(0L);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }

                @Override // org.rbmain.messenger.support.customtabsclient.shared.ServiceConnectionCallback
                public void onServiceDisconnected() {
                    CustomTabsClient unused = Browser.customTabsClient = null;
                }
            });
            customTabsServiceConnection = serviceConnection;
            if (CustomTabsClient.bindCustomTabsService(activity, customTabsPackageToBind, serviceConnection)) {
                return;
            }
            customTabsServiceConnection = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void unbindCustomTabsService(Activity activity) {
        if (customTabsServiceConnection == null) {
            return;
        }
        WeakReference<Activity> weakReference = currentCustomTabsActivity;
        if ((weakReference == null ? null : weakReference.get()) == activity) {
            currentCustomTabsActivity.clear();
        }
        try {
            activity.unbindService(customTabsServiceConnection);
        } catch (Exception unused) {
        }
        customTabsClient = null;
        customTabsSession = null;
    }

    private static class NavigationCallback extends CustomTabsCallback {
        @Override // org.rbmain.messenger.support.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
        }

        private NavigationCallback() {
        }
    }

    public static void openUrl(Context context, String str) {
        if (str == null) {
            return;
        }
        openUrl(context, Uri.parse(str), true);
    }

    public static void openUrl(Context context, Uri uri) {
        openUrl(context, uri, true);
    }

    public static void openUrl(Context context, String str, boolean z) {
        if (context == null || str == null) {
            return;
        }
        openUrl(context, Uri.parse(str), z);
    }

    public static void openUrl(Context context, Uri uri, boolean z) {
        openUrl(context, uri, z, true);
    }

    public static void openUrl(Context context, String str, boolean z, boolean z2) {
        openUrl(context, Uri.parse(str), z, z2);
    }

    public static boolean isTelegraphUrl(String str, boolean z) {
        return z ? str.equals("telegra.ph") || str.equals("te.legra.ph") || str.equals("graph.org") : str.contains("telegra.ph") || str.contains("te.legra.ph") || str.contains("graph.org");
    }

    public static void openUrl(Context context, Uri uri, boolean z, boolean z2) {
        if (context == null || uri == null) {
            return;
        }
        MessengerLinkHandler.getInstance(UserConfig.selectedAccount).openUrl(uri.toString());
    }

    public static void openUrInside(Context context, Uri uri, boolean z, boolean z2) {
        String[] strArr;
        PendingIntent broadcast;
        List<ResolveInfo> listQueryIntentActivities;
        if (context == null || uri == null) {
            return;
        }
        boolean[] zArr = {false};
        isInternalUri(uri, zArr);
        try {
            String lowerCase = uri.getScheme() != null ? uri.getScheme().toLowerCase() : BuildConfig.FLAVOR;
            if ("http".equals(lowerCase) || "https".equals(lowerCase)) {
                try {
                    uri = uri.normalizeScheme();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            if (uri.getHost() != null) {
                uri.getHost().toLowerCase();
            }
            if (z && SharedConfig.customTabs && !lowerCase.equals("tel")) {
                List<ResolveInfo> listQueryIntentActivities2 = null;
                try {
                    listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com")), 0);
                } catch (Exception unused) {
                }
                if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                    strArr = null;
                } else {
                    strArr = new String[listQueryIntentActivities.size()];
                    for (int i = 0; i < listQueryIntentActivities.size(); i++) {
                        try {
                            strArr[i] = listQueryIntentActivities.get(i).activityInfo.packageName;
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("default browser name = " + strArr[i]);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
                try {
                    listQueryIntentActivities2 = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0);
                    if (strArr != null) {
                        int i2 = 0;
                        while (i2 < listQueryIntentActivities2.size()) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= strArr.length) {
                                    break;
                                }
                                if (strArr[i3].equals(listQueryIntentActivities2.get(i2).activityInfo.packageName)) {
                                    listQueryIntentActivities2.remove(i2);
                                    i2--;
                                    break;
                                }
                                i3++;
                            }
                            i2++;
                        }
                    } else {
                        int i4 = 0;
                        while (i4 < listQueryIntentActivities2.size()) {
                            if (listQueryIntentActivities2.get(i4).activityInfo.packageName.toLowerCase().contains("browser") || listQueryIntentActivities2.get(i4).activityInfo.packageName.toLowerCase().contains("chrome")) {
                                listQueryIntentActivities2.remove(i4);
                                i4--;
                            }
                            i4++;
                        }
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        for (int i5 = 0; i5 < listQueryIntentActivities2.size(); i5++) {
                            FileLog.d("device has " + listQueryIntentActivities2.get(i5).activityInfo.packageName + " to open " + uri.toString());
                        }
                    }
                } catch (Exception unused3) {
                }
                if (zArr[0] || listQueryIntentActivities2 == null || listQueryIntentActivities2.isEmpty()) {
                    Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) ShareBroadcastReceiver.class);
                    intent.setAction("android.intent.action.SEND");
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 23) {
                        broadcast = PendingIntent.getBroadcast(ApplicationLoader.applicationContext, 0, new Intent(ApplicationLoader.applicationContext, (Class<?>) CustomTabsCopyReceiver.class), 167772160);
                    } else {
                        broadcast = PendingIntent.getBroadcast(ApplicationLoader.applicationContext, 0, new Intent(ApplicationLoader.applicationContext, (Class<?>) CustomTabsCopyReceiver.class), 134217728);
                    }
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(getSession());
                    builder.addMenuItem(LocaleController.getString("CopyLink", R.string.CopyLink), broadcast);
                    builder.setToolbarColor(Theme.getColor(Theme.key_actionBarBrowser));
                    builder.setShowTitle(true);
                    if (i6 >= 23) {
                        builder.setActionButton(BitmapFactory.decodeResource(context.getResources(), R.drawable.abc_ic_menu_share_mtrl_alpha), LocaleController.getString("ShareFile", R.string.ShareFile), PendingIntent.getBroadcast(context, 0, intent, 167772160), true);
                    } else {
                        builder.setActionButton(BitmapFactory.decodeResource(context.getResources(), R.drawable.abc_ic_menu_share_mtrl_alpha), LocaleController.getString("ShareFile", R.string.ShareFile), PendingIntent.getBroadcast(context, 0, intent, 134217728), true);
                    }
                    CustomTabsIntent customTabsIntentBuild = builder.build();
                    customTabsIntentBuild.setUseNewTask();
                    customTabsIntentBuild.launchUrl(context, uri);
                    return;
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", uri);
            intent2.putExtra("create_new_tab", true);
            intent2.putExtra("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent2);
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    public static boolean isInternalUrl(String str, boolean[] zArr) {
        return isInternalUri(Uri.parse(str), false, zArr);
    }

    public static boolean isInternalUrl(String str, boolean z, boolean[] zArr) {
        return isInternalUri(Uri.parse(str), z, zArr);
    }

    public static boolean isInternalUri(Uri uri, boolean[] zArr) {
        return isInternalUri(uri, false, zArr);
    }

    public static boolean isInternalUri(Uri uri, boolean z, boolean[] zArr) {
        String host = uri.getHost();
        String lowerCase = host != null ? host.toLowerCase() : BuildConfig.FLAVOR;
        if ("ton".equals(uri.getScheme())) {
            try {
                List<ResolveInfo> listQueryIntentActivities = ApplicationLoader.applicationContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0);
                if (listQueryIntentActivities != null) {
                    if (listQueryIntentActivities.size() > 1) {
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
            return true;
        }
        if ("tg".equals(uri.getScheme())) {
            return true;
        }
        if (".dog".equals(lowerCase)) {
            String path = uri.getPath();
            if (path != null && path.length() > 1) {
                if (z) {
                    return true;
                }
                String lowerCase2 = path.substring(1).toLowerCase();
                if (!lowerCase2.startsWith("blog") && !lowerCase2.equals("iv") && !lowerCase2.startsWith("faq") && !lowerCase2.equals("apps") && !lowerCase2.startsWith("s/")) {
                    return true;
                }
                if (zArr != null) {
                    zArr[0] = true;
                }
                return false;
            }
        } else if ("rubika.ir".equals(lowerCase)) {
            String path2 = uri.getPath();
            if (path2 != null && path2.length() > 1) {
                if (z) {
                    return true;
                }
                String lowerCase3 = path2.substring(1).toLowerCase();
                if (!lowerCase3.equals("iv") && !lowerCase3.startsWith("s/")) {
                    return true;
                }
                if (zArr != null) {
                    zArr[0] = true;
                }
                return false;
            }
        } else if (z && (lowerCase.endsWith("rubika.ir") || lowerCase.endsWith("telegra.ph") || lowerCase.endsWith("telesco.pe"))) {
            return true;
        }
        return false;
    }

    public static String extractUsername(String str) {
        if (str == null || TextUtils.isEmpty(str) || !str.startsWith("@")) {
            return null;
        }
        return str.substring(1);
    }

    public static String replaceHostname(Uri uri, String str) {
        String scheme = uri.getScheme();
        String userInfo = uri.getUserInfo();
        int port = uri.getPort();
        String path = uri.getPath();
        String query = uri.getQuery();
        String fragment = uri.getFragment();
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        if (userInfo != null) {
            sb.append(userInfo);
            sb.append("@");
        }
        sb.append(str);
        if (port != -1) {
            sb.append(":");
            sb.append(port);
        }
        sb.append(path);
        if (query != null) {
            sb.append("?");
            sb.append(query);
        }
        if (fragment != null) {
            sb.append("#");
            sb.append(fragment);
        }
        return sb.toString();
    }
}
