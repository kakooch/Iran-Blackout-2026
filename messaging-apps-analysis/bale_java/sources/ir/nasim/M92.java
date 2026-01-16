package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class M92 {
    private final Map a;
    private final Map b;

    public static final class b {
        Map a;
        Map b;

        public b a(Enum r2, Object obj) {
            this.a.put(r2, obj);
            this.b.put(obj, r2);
            return this;
        }

        public M92 b() {
            return new M92(Collections.unmodifiableMap(this.a), Collections.unmodifiableMap(this.b));
        }

        private b() {
            this.a = new HashMap();
            this.b = new HashMap();
        }
    }

    public static b a() {
        return new b();
    }

    public Object b(Enum r4) throws GeneralSecurityException {
        Object obj = this.a.get(r4);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: " + r4);
    }

    public Enum c(Object obj) throws GeneralSecurityException {
        Enum r0 = (Enum) this.b.get(obj);
        if (r0 != null) {
            return r0;
        }
        throw new GeneralSecurityException("Unable to convert object enum: " + obj);
    }

    private M92(Map map, Map map2) {
        this.a = map;
        this.b = map2;
    }
}
