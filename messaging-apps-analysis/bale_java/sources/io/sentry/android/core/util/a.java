package io.sentry.android.core.util;

import android.content.Context;

/* loaded from: classes3.dex */
public final class a {
    private volatile Object a = null;
    private final InterfaceC0230a b;

    /* renamed from: io.sentry.android.core.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0230a {
        Object a(Context context);
    }

    public a(InterfaceC0230a interfaceC0230a) {
        this.b = interfaceC0230a;
    }

    public Object a(Context context) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = this.b.a(context);
                    }
                } finally {
                }
            }
        }
        return this.a;
    }
}
