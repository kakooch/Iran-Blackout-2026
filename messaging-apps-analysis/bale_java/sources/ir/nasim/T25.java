package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class T25 {

    public static final class a extends T25 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -2125432233;
        }

        public String toString() {
            return "Invited";
        }
    }

    public static final class b extends T25 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1840507923;
        }

        public String toString() {
            return "Joined";
        }
    }

    public static final class c extends T25 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 883049899;
        }

        public String toString() {
            return "Left";
        }
    }

    public static final class d extends T25 {
        public static final d a = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 1591167010;
        }

        public String toString() {
            return "Rejected";
        }
    }

    public static final class e extends T25 {
        private final f a;
        private final int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f fVar, int i) {
            super(null);
            AbstractC13042fc3.i(fVar, "trackSource");
            this.a = fVar;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final f b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && this.b == eVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "TrackMuted(trackSource=" + this.a + ", muterId=" + this.b + Separators.RPAREN;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class f {
        public static final f a = new f("VIDEO", 0);
        public static final f b = new f("AUDIO", 1);
        private static final /* synthetic */ f[] c;
        private static final /* synthetic */ F92 d;

        static {
            f[] fVarArrA = a();
            c = fVarArrA;
            d = G92.a(fVarArrA);
        }

        private f(String str, int i) {
        }

        private static final /* synthetic */ f[] a() {
            return new f[]{a, b};
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) c.clone();
        }
    }

    public static final class g extends T25 {
        public static final g a = new g();

        private g() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof g);
        }

        public int hashCode() {
            return -75336666;
        }

        public String toString() {
            return "Unknown";
        }
    }

    private T25() {
    }

    public /* synthetic */ T25(ED1 ed1) {
        this();
    }
}
