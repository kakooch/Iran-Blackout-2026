package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Oi0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6634Oi0 {
    private final String a;
    private final a b;

    /* renamed from: ir.nasim.Oi0$a */
    public interface a {

        /* renamed from: ir.nasim.Oi0$a$a, reason: collision with other inner class name */
        public static final class C0559a implements a {
            private final String a;

            public C0559a(String str) {
                AbstractC13042fc3.i(str, "filePath");
                this.a = str;
            }

            public final String a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0559a) && AbstractC13042fc3.d(this.a, ((C0559a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Gif(filePath=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Oi0$a$b */
        public static final class b implements a {
            private final String a;

            public b(String str) {
                AbstractC13042fc3.i(str, "filePath");
                this.a = str;
            }

            public final String a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Photo(filePath=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Oi0$a$c */
        public static final class c implements a {
            private final byte[] a;

            public c(byte[] bArr) {
                AbstractC13042fc3.i(bArr, "value");
                this.a = bArr;
            }

            public final byte[] a() {
                return this.a;
            }
        }

        /* renamed from: ir.nasim.Oi0$a$d */
        public static final class d implements a {
            private final String a;

            public d(String str) {
                AbstractC13042fc3.i(str, "downloadUpdateLink");
                this.a = str;
            }

            public final String a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Unsupported(downloadUpdateLink=" + this.a + Separators.RPAREN;
            }
        }
    }

    public C6634Oi0(String str, a aVar) {
        this.a = str;
        this.b = aVar;
    }

    public final a a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final boolean c() {
        String str = this.a;
        return (str == null || AbstractC20762sZ6.n0(str)) && this.b == null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6634Oi0)) {
            return false;
        }
        C6634Oi0 c6634Oi0 = (C6634Oi0) obj;
        return AbstractC13042fc3.d(this.a, c6634Oi0.a) && AbstractC13042fc3.d(this.b, c6634Oi0.b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        a aVar = this.b;
        return iHashCode + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "BotIntroUi(text=" + this.a + ", media=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C6634Oi0(String str, a aVar, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : aVar);
    }
}
