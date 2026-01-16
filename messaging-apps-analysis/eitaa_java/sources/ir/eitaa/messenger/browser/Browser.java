package ir.eitaa.messenger.browser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.support.customtabs.CustomTabsCallback;
import ir.eitaa.messenger.support.customtabs.CustomTabsClient;
import ir.eitaa.messenger.support.customtabs.CustomTabsServiceConnection;
import ir.eitaa.messenger.support.customtabs.CustomTabsSession;
import ir.eitaa.messenger.support.customtabsclient.shared.CustomTabsHelper;
import ir.eitaa.messenger.support.customtabsclient.shared.ServiceConnection;
import ir.eitaa.messenger.support.customtabsclient.shared.ServiceConnectionCallback;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Ads_ClickAction;
import ir.eitaa.tgnet.TLRPC$TL_ads_intentAction;
import ir.eitaa.tgnet.TLRPC$TL_ads_openExternalLinkAction;
import ir.eitaa.tgnet.TLRPC$TL_ads_openLinkAction;
import ir.eitaa.ui.ActionBar.BaseFragment;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class Browser {
    private static WeakReference<Activity> currentCustomTabsActivity;
    private static CustomTabsClient customTabsClient;
    private static WeakReference<CustomTabsSession> customTabsCurrentSession;
    private static String customTabsPackageToBind;
    private static CustomTabsServiceConnection customTabsServiceConnection;
    private static CustomTabsSession customTabsSession;

    private static void setCurrentSession(CustomTabsSession session) {
        customTabsCurrentSession = new WeakReference<>(session);
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
            ServiceConnection serviceConnection = new ServiceConnection(new ServiceConnectionCallback() { // from class: ir.eitaa.messenger.browser.Browser.1
                @Override // ir.eitaa.messenger.support.customtabsclient.shared.ServiceConnectionCallback
                public void onServiceConnected(CustomTabsClient client) {
                    CustomTabsClient unused = Browser.customTabsClient = client;
                    if (!SharedConfig.customTabs || Browser.customTabsClient == null) {
                        return;
                    }
                    try {
                        Browser.customTabsClient.warmup(0L);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }

                @Override // ir.eitaa.messenger.support.customtabsclient.shared.ServiceConnectionCallback
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
        @Override // ir.eitaa.messenger.support.customtabs.CustomTabsCallback
        public void onNavigationEvent(int navigationEvent, Bundle extras) {
        }

        private NavigationCallback() {
        }
    }

    public static void openUrl(Context context, String url) {
        if (url == null) {
            return;
        }
        openUrl(context, Uri.parse(url), true);
    }

    public static void openUrl(Context context, Uri uri) {
        openUrl(context, uri, true);
    }

    public static void openUrl(Context context, String url, boolean allowCustom) {
        if (context == null || url == null) {
            return;
        }
        openUrl(context, Uri.parse(url), allowCustom);
    }

    public static void openUrl(Context context, Uri uri, boolean allowCustom) {
        openUrl(context, uri, allowCustom, true, false);
    }

    public static void openUrl(final Context context, final String url, final boolean allowCustom, boolean tryTelegraph) {
        openUrl(context, Uri.parse(url), allowCustom, tryTelegraph, false);
    }

    public static void openUrl(final Context context, Uri uri, final boolean allowCustom, boolean tryTelegraph, boolean excludePay) {
        openUrl(context, uri, allowCustom, tryTelegraph, excludePay, false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x03bb A[Catch: Exception -> 0x03e1, TryCatch #8 {Exception -> 0x03e1, blocks: (B:145:0x038f, B:147:0x0399, B:148:0x03b4, B:150:0x03bb, B:151:0x03cd), top: B:174:0x038f }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x038f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void openUrl(android.content.Context r18, android.net.Uri r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.browser.Browser.openUrl(android.content.Context, android.net.Uri, boolean, boolean, boolean, boolean, boolean, boolean):void");
    }

    public static boolean isInternalUrl(String url, boolean[] forceBrowser) {
        return isInternalUri(Uri.parse(url), false, forceBrowser, false);
    }

    public static boolean isInternalUrl(String url, boolean all, boolean[] forceBrowser) {
        return isInternalUri(Uri.parse(url), all, forceBrowser, false);
    }

    public static boolean isPassportUrl(String url) {
        String lowerCase;
        if (url == null) {
            return false;
        }
        try {
            lowerCase = url.toLowerCase();
        } catch (Throwable unused) {
        }
        if (lowerCase.startsWith("et:passport") || lowerCase.startsWith("et://passport") || lowerCase.startsWith("et:secureid")) {
            return true;
        }
        if (lowerCase.contains("resolve")) {
            if (lowerCase.contains("domain=eitaapassport")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInternalUri(Uri uri, boolean[] forceBrowser, boolean excludePay) {
        return isInternalUri(uri, false, forceBrowser, excludePay);
    }

    public static boolean isInternalUri(Uri uri, boolean all, boolean[] forceBrowser, boolean excludePay) {
        String host = uri.getHost();
        String lowerCase = host != null ? host.toLowerCase() : "";
        if ("et".equals(uri.getScheme())) {
            return true;
        }
        if ("eitaa.com".equals(lowerCase) || "eitaa.net".equals(lowerCase) || "eitaa.ir".equals(lowerCase)) {
            String path = uri.getPath();
            if (path != null && path.length() > 1) {
                if (all) {
                    return true;
                }
                String lowerCase2 = path.substring(1).toLowerCase();
                if (!lowerCase2.startsWith("blog") && !lowerCase2.startsWith("faq")) {
                    return true;
                }
                if (forceBrowser != null) {
                    forceBrowser[0] = true;
                }
            }
        } else if (!excludePay && lowerCase.equals(MessagesController.getInstance(UserConfig.selectedAccount).payHost)) {
            return true;
        }
        return false;
    }

    public static void performAdAction(final Context context, TLRPC$Ads_Ad ad, BaseFragment fragment) {
        TLRPC$Ads_ClickAction tLRPC$Ads_ClickAction;
        if (ad == null || (tLRPC$Ads_ClickAction = ad.action) == null) {
            return;
        }
        if (tLRPC$Ads_ClickAction instanceof TLRPC$TL_ads_openLinkAction) {
            String str = tLRPC$Ads_ClickAction.link;
            if (str != null && str.startsWith("@") && fragment != null) {
                MessagesController.getInstance(UserConfig.selectedAccount).openByUserName(str.substring(1), fragment, 0);
                return;
            }
            try {
                openUrl(context, Uri.parse(ad.action.link), true, true, false);
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        if (tLRPC$Ads_ClickAction instanceof TLRPC$TL_ads_openExternalLinkAction) {
            try {
                openUrl(context, Uri.parse(tLRPC$Ads_ClickAction.link), true, true, false);
                return;
            } catch (Exception e2) {
                FileLog.e(e2);
                return;
            }
        }
        if (tLRPC$Ads_ClickAction instanceof TLRPC$TL_ads_intentAction) {
            try {
                openUrl(context, Uri.parse(tLRPC$Ads_ClickAction.uri), true, true, false);
            } catch (Exception e3) {
                FileLog.e(e3);
            }
        }
    }

    private static boolean isWhiteListedUrl(String url) {
        String[] strArrSplit = url.split("/");
        if (MessagesController.getInstance(UserConfig.selectedAccount).isWhiteListedUrl(strArrSplit[0])) {
            return true;
        }
        if (strArrSplit.length > 3) {
            return MessagesController.getInstance(UserConfig.selectedAccount).isWhiteListedUrl(strArrSplit[2]);
        }
        return false;
    }
}
