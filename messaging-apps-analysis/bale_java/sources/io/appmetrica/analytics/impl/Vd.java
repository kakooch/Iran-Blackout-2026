package io.appmetrica.analytics.impl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class Vd {
    public static final SafePackageManager a = new SafePackageManager();
    public static final Qd b = new Qd();
    public static final Rd c = new Rd();
    public static final Sd d = new Sd(2);

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        String script = locale.getScript();
        if (!TextUtils.isEmpty(script)) {
            sb.append('-');
            sb.append(script);
        }
        if (!TextUtils.isEmpty(country)) {
            sb.append('_');
            sb.append(country);
        }
        return sb.toString();
    }

    public static Ud a(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        Ud ud = Ud.UNDEFINED;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!AndroidUtils.isApiAchieved(29) ? !(activeNetwork != null && ((networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || networkInfo.isConnected())) : activeNetwork == null) {
            return Ud.OFFLINE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            return ud;
        }
        for (Integer num : c.a.keySet()) {
            if (networkCapabilities.hasTransport(num.intValue())) {
                return (Ud) c.a(num);
            }
        }
        return ud;
    }
}
