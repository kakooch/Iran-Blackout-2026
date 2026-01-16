package ir.nasim;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Ri4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7350Ri4 {
    public static final C7350Ri4 b = a().a();
    private final Map a;

    /* renamed from: ir.nasim.Ri4$b */
    public static final class b {
        private HashMap a = new HashMap();

        public C7350Ri4 a() {
            if (this.a == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            C7350Ri4 c7350Ri4 = new C7350Ri4(Collections.unmodifiableMap(this.a));
            this.a = null;
            return c7350Ri4;
        }
    }

    public static b a() {
        return new b();
    }

    public Map b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C7350Ri4) {
            return this.a.equals(((C7350Ri4) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    private C7350Ri4(Map map) {
        this.a = map;
    }
}
