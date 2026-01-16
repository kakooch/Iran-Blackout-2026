package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.e53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12129e53 {
    public static final int a = 0;

    /* renamed from: ir.nasim.e53$a */
    public static final class a extends AbstractC12129e53 {
        private final String b;
        private final List c;

        public a(String str, List list) {
            super(null);
            this.b = str;
            this.c = list;
        }

        public final List a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List list = this.c;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Available(versionName=" + this.b + ", changes=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.e53$b */
    public static final class b extends AbstractC12129e53 {
        public static final b b = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1646632266;
        }

        public String toString() {
            return "Disabled";
        }
    }

    /* renamed from: ir.nasim.e53$d */
    public static final class d extends AbstractC12129e53 {
        public static final d b = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 1476278690;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.e53$e */
    public static final class e extends AbstractC12129e53 {
        private final InterfaceC3346Am2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC3346Am2 interfaceC3346Am2) {
            super(null);
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            this.b = interfaceC3346Am2;
        }

        public final InterfaceC3346Am2 a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.b, ((e) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "ReadyToInstall(fileSystemReference=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.e53$f */
    public static final class f extends AbstractC12129e53 {
        public static final f b = new f();

        private f() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -2043250158;
        }

        public String toString() {
            return "UpToDate";
        }
    }

    private AbstractC12129e53() {
    }

    /* renamed from: ir.nasim.e53$c */
    public static final class c extends AbstractC12129e53 {
        private final float b;
        private final int c;
        private final String d;
        private final List e;
        private final a f;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* renamed from: ir.nasim.e53$c$a */
        public static final class a {
            public static final a a = new a("Paused", 0);
            public static final a b = new a("RetryFailed", 1);
            public static final a c = new a("RetryTemporary", 2);
            private static final /* synthetic */ a[] d;
            private static final /* synthetic */ F92 e;

            static {
                a[] aVarArrA = a();
                d = aVarArrA;
                e = G92.a(aVarArrA);
            }

            private a(String str, int i) {
            }

            private static final /* synthetic */ a[] a() {
                return new a[]{a, b, c};
            }

            public static a valueOf(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) d.clone();
            }
        }

        public /* synthetic */ c(float f, int i, String str, List list, a aVar, int i2, ED1 ed1) {
            this(f, i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? a.a : aVar);
        }

        public static /* synthetic */ c b(c cVar, float f, int i, String str, List list, a aVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f = cVar.b;
            }
            if ((i2 & 2) != 0) {
                i = cVar.c;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = cVar.d;
            }
            String str2 = str;
            if ((i2 & 8) != 0) {
                list = cVar.e;
            }
            List list2 = list;
            if ((i2 & 16) != 0) {
                aVar = cVar.f;
            }
            return cVar.a(f, i3, str2, list2, aVar);
        }

        public final c a(float f, int i, String str, List list, a aVar) {
            AbstractC13042fc3.i(aVar, "mode");
            return new c(f, i, str, list, aVar);
        }

        public final List c() {
            return this.e;
        }

        public final int d() {
            return this.c;
        }

        public final a e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Float.compare(this.b, cVar.b) == 0 && this.c == cVar.c && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e) && this.f == cVar.f;
        }

        public final float f() {
            return this.b;
        }

        public final String g() {
            return this.d;
        }

        public int hashCode() {
            int iHashCode = ((Float.hashCode(this.b) * 31) + Integer.hashCode(this.c)) * 31;
            String str = this.d;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            List list = this.e;
            return ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "Downloading(progress=" + this.b + ", fileSize=" + this.c + ", versionName=" + this.d + ", changes=" + this.e + ", mode=" + this.f + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(float f, int i, String str, List list, a aVar) {
            super(null);
            AbstractC13042fc3.i(aVar, "mode");
            this.b = f;
            this.c = i;
            this.d = str;
            this.e = list;
            this.f = aVar;
        }
    }

    public /* synthetic */ AbstractC12129e53(ED1 ed1) {
        this();
    }
}
