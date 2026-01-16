package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.regex.Pattern;

/* renamed from: io.appmetrica.analytics.impl.i0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2600i0 {
    public final Um a;
    public volatile Boolean b;
    public InterfaceC2920va c;
    public InterfaceC2944wa d;

    public C2600i0() {
        this(new Um());
    }

    public final synchronized InterfaceC2920va a(Context context, C2556g4 c2556g4) {
        try {
            if (this.c == null) {
                if (a(context)) {
                    this.c = new C2647k0();
                } else {
                    this.c = new C2576h0(context, c2556g4);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    public C2600i0(Um um) {
        this.a = um;
    }

    public final boolean a(Context context) {
        Boolean boolValueOf = this.b;
        if (boolValueOf == null) {
            synchronized (this) {
                try {
                    boolValueOf = this.b;
                    if (boolValueOf == null) {
                        this.a.getClass();
                        boolean z = !Um.a(context);
                        boolValueOf = Boolean.valueOf(z);
                        this.b = boolValueOf;
                        if (z) {
                            Pattern pattern = AbstractC2904ui.a;
                            ImportantLogger.INSTANCE.info("AppMetrica", "User is locked. So use stubs. Events will not be sent.", new Object[0]);
                        }
                    }
                } finally {
                }
            }
        }
        return boolValueOf.booleanValue();
    }
}
