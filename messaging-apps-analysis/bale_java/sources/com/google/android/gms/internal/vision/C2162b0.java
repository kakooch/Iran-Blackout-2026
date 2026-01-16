package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC18561or8;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.vision.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2162b0 {
    private static volatile C2162b0 b;
    private static volatile C2162b0 c;
    private static final C2162b0 d = new C2162b0(true);
    private final Map a = Collections.emptyMap();

    /* renamed from: com.google.android.gms.internal.vision.b0$a */
    private static final class a {
        private final Object a;
        private final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    private C2162b0(boolean z) {
    }

    public static C2162b0 b() {
        C2162b0 c2162b0 = b;
        if (c2162b0 == null) {
            synchronized (C2162b0.class) {
                try {
                    c2162b0 = b;
                    if (c2162b0 == null) {
                        c2162b0 = d;
                        b = c2162b0;
                    }
                } finally {
                }
            }
        }
        return c2162b0;
    }

    public static C2162b0 c() {
        C2162b0 c2162b0 = c;
        if (c2162b0 != null) {
            return c2162b0;
        }
        synchronized (C2162b0.class) {
            try {
                C2162b0 c2162b02 = c;
                if (c2162b02 != null) {
                    return c2162b02;
                }
                C2162b0 c2162b0A = AbstractC2174h0.a(C2162b0.class);
                c = c2162b0A;
                return c2162b0A;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AbstractC2178j0.c a(InterfaceC18561or8 interfaceC18561or8, int i) {
        AbstractC18350oW3.a(this.a.get(new a(interfaceC18561or8, i)));
        return null;
    }
}
