package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import ir.nasim.AbstractC18350oW3;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2352n {
    private static boolean b = true;
    private static volatile C2352n c;
    static final C2352n d = new C2352n(true);
    private final Map a = Collections.emptyMap();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.n$a */
    private static final class a {
        private final Object a;
        private final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    C2352n(boolean z) {
    }

    public static C2352n b() {
        C2352n c2352nA = c;
        if (c2352nA == null) {
            synchronized (C2352n.class) {
                try {
                    c2352nA = c;
                    if (c2352nA == null) {
                        c2352nA = b ? AbstractC2351m.a() : d;
                        c = c2352nA;
                    }
                } finally {
                }
            }
        }
        return c2352nA;
    }

    public AbstractC2358u.c a(I i, int i2) {
        AbstractC18350oW3.a(this.a.get(new a(i, i2)));
        return null;
    }
}
