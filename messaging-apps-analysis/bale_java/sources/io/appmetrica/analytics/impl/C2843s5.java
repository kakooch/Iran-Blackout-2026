package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;

/* renamed from: io.appmetrica.analytics.impl.s5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2843s5 {
    public final Ud a(Context context) {
        SafePackageManager safePackageManager = Vd.a;
        return (Ud) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ud.UNDEFINED, new Td());
    }
}
