package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: io.appmetrica.analytics.impl.dc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2491dc extends C2605i5 {
    public final C2881tj m;

    public C2491dc(Context context, W4 w4, C3010z4 c3010z4, AbstractC2434b5 abstractC2434b5, C2549fl c2549fl, InterfaceC3022zg interfaceC3022zg, ICommonExecutor iCommonExecutor, int i, C2881tj c2881tj, C2969xb c2969xb) {
        super(context, w4, c3010z4, abstractC2434b5, c2549fl, interfaceC3022zg, iCommonExecutor, i, c2969xb);
        this.m = c2881tj;
    }

    public final C2603i3 a(C2466cc c2466cc) {
        String str;
        Field field;
        Context context = this.c;
        IHandlerExecutor iHandlerExecutorA = this.m.a();
        Executor executorF = this.m.f();
        try {
            Class<?> clsFindClass = ReflectionUtils.findClass("com.android.billingclient.BuildConfig");
            str = (String) ((clsFindClass == null || (field = clsFindClass.getField("VERSION_NAME")) == null) ? null : field.get(null));
        } catch (Throwable unused) {
            str = null;
        }
        BillingType billingType = (str == null || AbstractC20762sZ6.n0(str) || AbstractC20153rZ6.S(str, "2.", false, 2, null) || AbstractC20153rZ6.S(str, "3.", false, 2, null) || AbstractC20153rZ6.S(str, "4.", false, 2, null)) ? BillingType.NONE : (!AbstractC20153rZ6.S(str, "5.", false, 2, null) && AbstractC20153rZ6.S(str, "6.", false, 2, null)) ? BillingType.LIBRARY_V6 : BillingType.LIBRARY_V6;
        return new C2603i3(context, iHandlerExecutorA, executorF, billingType, new C2507e3(Ql.a(C2816r2.class).a(this.c)), new C2482d3(c2466cc, C2586ha.h().u().e()));
    }

    public final Ef b(C2466cc c2466cc) {
        Cd cd = new Cd(c2466cc);
        Objects.requireNonNull(c2466cc);
        return new Ef(cd, new C2441bc(c2466cc), c2466cc);
    }
}
