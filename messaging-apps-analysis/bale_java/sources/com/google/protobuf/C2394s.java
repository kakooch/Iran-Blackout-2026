package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2394s {
    private static boolean b = true;
    private static volatile C2394s c;
    static final C2394s d = new C2394s(true);
    private final Map a = Collections.emptyMap();

    /* renamed from: com.google.protobuf.s$a */
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

    C2394s(boolean z) {
    }

    public static C2394s b() {
        if (!b) {
            return d;
        }
        C2394s c2394sA = c;
        if (c2394sA == null) {
            synchronized (C2394s.class) {
                try {
                    c2394sA = c;
                    if (c2394sA == null) {
                        c2394sA = r.a();
                        c = c2394sA;
                    }
                } finally {
                }
            }
        }
        return c2394sA;
    }

    public GeneratedMessageLite.f a(P p, int i) {
        return (GeneratedMessageLite.f) this.a.get(new a(p, i));
    }
}
