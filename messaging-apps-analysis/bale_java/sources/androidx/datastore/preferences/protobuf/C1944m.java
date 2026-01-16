package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1950t;
import ir.nasim.AbstractC18350oW3;
import java.util.Collections;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1944m {
    private static boolean b = true;
    private static volatile C1944m d;
    private final Map a = Collections.emptyMap();
    private static final Class c = c();
    static final C1944m e = new C1944m(true);

    /* renamed from: androidx.datastore.preferences.protobuf.m$a */
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

    C1944m(boolean z) {
    }

    public static C1944m b() {
        C1944m c1944mA = d;
        if (c1944mA == null) {
            synchronized (C1944m.class) {
                try {
                    c1944mA = d;
                    if (c1944mA == null) {
                        c1944mA = b ? AbstractC1943l.a() : e;
                        d = c1944mA;
                    }
                } finally {
                }
            }
        }
        return c1944mA;
    }

    static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public AbstractC1950t.c a(I i, int i2) {
        AbstractC18350oW3.a(this.a.get(new a(i, i2)));
        return null;
    }
}
