package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;

/* renamed from: io.appmetrica.analytics.impl.r9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2823r9 implements IExecutionPolicy {
    public static final EnumSet c = EnumSet.of(Ud.OFFLINE);
    public final C2843s5 a = new C2843s5();
    public final Context b;

    public C2823r9(Context context) {
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        C2843s5 c2843s5 = this.a;
        Context context = this.b;
        c2843s5.getClass();
        SafePackageManager safePackageManager = Vd.a;
        return !c.contains((Ud) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ud.UNDEFINED, new Td()));
    }
}
