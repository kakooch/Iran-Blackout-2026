package ir.nasim;

import ir.nasim.XS;

/* renamed from: ir.nasim.uV0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21997uV0 {

    /* renamed from: ir.nasim.uV0$a */
    public static abstract class a {
        public abstract AbstractC21997uV0 a();

        public abstract a b(AbstractC7863Tn abstractC7863Tn);

        public abstract a c(b bVar);
    }

    /* renamed from: ir.nasim.uV0$b */
    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int a;

        b(int i) {
            this.a = i;
        }
    }

    public static a a() {
        return new XS.b();
    }

    public abstract AbstractC7863Tn b();

    public abstract b c();
}
