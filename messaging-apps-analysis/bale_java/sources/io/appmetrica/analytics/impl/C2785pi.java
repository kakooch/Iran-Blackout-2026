package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import ir.nasim.AbstractC13042fc3;
import java.lang.ref.WeakReference;

/* renamed from: io.appmetrica.analytics.impl.pi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2785pi implements InterfaceC2646k {
    public C2637je a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C2761oi e = new C2761oi();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        try {
            this.f = new WeakReference(activity);
            if (!this.d) {
                if (this.a == null) {
                    this.a = new C2637je(W6.a(activity).a());
                }
                C2637je c2637je = this.a;
                AbstractC13042fc3.f(c2637je);
                this.b = c2637je.p();
                if (this.a == null) {
                    this.a = new C2637je(W6.a(activity).a());
                }
                C2637je c2637je2 = this.a;
                AbstractC13042fc3.f(c2637je2);
                this.c = c2637je2.t();
                this.d = true;
            }
            if (this.b == null) {
                b(activity);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo screenInfoA = C2761oi.a(context);
            if (screenInfoA == null || AbstractC13042fc3.d(screenInfoA, this.b)) {
                return;
            }
            this.b = screenInfoA;
            if (this.a == null) {
                this.a = new C2637je(W6.a(context).a());
            }
            C2637je c2637je = this.a;
            AbstractC13042fc3.f(c2637je);
            c2637je.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        try {
            if (!this.d) {
                if (this.a == null) {
                    this.a = new C2637je(W6.a(context).a());
                }
                C2637je c2637je = this.a;
                AbstractC13042fc3.f(c2637je);
                this.b = c2637je.p();
                if (this.a == null) {
                    this.a = new C2637je(W6.a(context).a());
                }
                C2637je c2637je2 = this.a;
                AbstractC13042fc3.f(c2637je2);
                this.c = c2637je2.t();
                this.d = true;
            }
            b((Context) this.f.get());
            if (this.b == null) {
                if (AndroidUtils.isApiAchieved(30)) {
                    if (!this.c) {
                        b(context);
                        this.c = true;
                        if (this.a == null) {
                            this.a = new C2637je(W6.a(context).a());
                        }
                        C2637je c2637je3 = this.a;
                        AbstractC13042fc3.f(c2637je3);
                        c2637je3.v();
                    }
                } else {
                    b(context);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    public final void a(C2637je c2637je) {
        this.a = c2637je;
    }
}
