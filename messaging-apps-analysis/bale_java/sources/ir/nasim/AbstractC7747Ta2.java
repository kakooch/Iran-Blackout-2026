package ir.nasim;

import ir.nasim.C10939cT;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Ta2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7747Ta2 {

    /* renamed from: ir.nasim.Ta2$a */
    public static abstract class a {
        public final a a(String str, int i) {
            e().put(str, String.valueOf(i));
            return this;
        }

        public final a b(String str, long j) {
            e().put(str, String.valueOf(j));
            return this;
        }

        public final a c(String str, String str2) {
            e().put(str, str2);
            return this;
        }

        public abstract AbstractC7747Ta2 d();

        protected abstract Map e();

        protected abstract a f(Map map);

        public abstract a g(Integer num);

        public abstract a h(X72 x72);

        public abstract a i(long j);

        public abstract a j(String str);

        public abstract a k(long j);
    }

    public static a a() {
        return new C10939cT.b().f(new HashMap());
    }

    public final String b(String str) {
        String str2 = (String) c().get(str);
        return str2 == null ? "" : str2;
    }

    protected abstract Map c();

    public abstract Integer d();

    public abstract X72 e();

    public abstract long f();

    public final int g(String str) {
        String str2 = (String) c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long h(String str) {
        String str2 = (String) c().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map i() {
        return Collections.unmodifiableMap(c());
    }

    public abstract String j();

    public abstract long k();

    public a l() {
        return new C10939cT.b().j(j()).g(d()).h(e()).i(f()).k(k()).f(new HashMap(c()));
    }
}
