package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.concurrent.Executor;

/* renamed from: io.appmetrica.analytics.impl.i3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2603i3 implements InterfaceC2668kl {
    public BillingMonitor a;
    public final Context b;
    public final Executor c;
    public final Executor d;
    public final BillingType e;
    public final BillingInfoStorage f;
    public final BillingInfoSender g;
    public final ApplicationStateProvider h;
    public final C2555g3 i;

    public C2603i3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender) {
        this(context, executor, executor2, billingType, billingInfoStorage, billingInfoSender, C2586ha.h().c(), new C2555g3());
    }

    public final void a(C2549fl c2549fl, Boolean bool) {
        BillingMonitor billingLibraryMonitor;
        if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
            synchronized (this) {
                try {
                    C2555g3 c2555g3 = this.i;
                    Context context = this.b;
                    Executor executor = this.c;
                    Executor executor2 = this.d;
                    BillingType billingType = this.e;
                    BillingInfoStorage billingInfoStorage = this.f;
                    BillingInfoSender billingInfoSender = this.g;
                    c2555g3.getClass();
                    billingLibraryMonitor = AbstractC2531f3.a[billingType.ordinal()] == 1 ? new BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null) : new P7();
                    this.a = billingLibraryMonitor;
                } catch (Throwable th) {
                    throw th;
                }
            }
            billingLibraryMonitor.onBillingConfigChanged(c2549fl.x);
            if (this.h.registerStickyObserver(new C2579h3(this)) == ApplicationState.VISIBLE) {
                try {
                    BillingMonitor billingMonitor = this.a;
                    if (billingMonitor != null) {
                        billingMonitor.onSessionResumed();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C2603i3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender, ApplicationStateProvider applicationStateProvider, C2555g3 c2555g3) {
        this.b = context;
        this.c = executor;
        this.d = executor2;
        this.e = billingType;
        this.f = billingInfoStorage;
        this.g = billingInfoSender;
        this.h = applicationStateProvider;
        this.i = c2555g3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2668kl
    public final synchronized void a(C2549fl c2549fl) {
        BillingMonitor billingMonitor;
        synchronized (this) {
            billingMonitor = this.a;
        }
        if (billingMonitor != null) {
            billingMonitor.onBillingConfigChanged(c2549fl.x);
        }
    }
}
