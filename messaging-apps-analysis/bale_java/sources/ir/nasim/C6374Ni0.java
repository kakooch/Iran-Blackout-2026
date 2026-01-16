package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.Ni0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6374Ni0 {
    private final String a;
    private final a b;

    /* renamed from: ir.nasim.Ni0$a */
    public static abstract class a {
        private final C0536a a;
        private final String b;
        private final int c;
        private final String d;

        /* renamed from: ir.nasim.Ni0$a$a, reason: collision with other inner class name */
        public static final class C0536a {
            private final long a;
            private final long b;

            public C0536a(long j, long j2) {
                this.a = j;
                this.b = j2;
            }

            public final long a() {
                return this.b;
            }

            public final long b() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0536a)) {
                    return false;
                }
                C0536a c0536a = (C0536a) obj;
                return this.a == c0536a.a && this.b == c0536a.b;
            }

            public int hashCode() {
                return (Long.hashCode(this.a) * 31) + Long.hashCode(this.b);
            }

            public String toString() {
                return "FileLocation(fileId=" + this.a + ", accessHash=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Ni0$a$b */
        public static final class b extends a {
            private final int e;
            private final int f;
            private final d g;
            private final C0536a h;
            private final String i;
            private final int j;
            private final String k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i, int i2, d dVar, C0536a c0536a, String str, int i3, String str2) {
                super(c0536a, str, i3, str2, null);
                AbstractC13042fc3.i(c0536a, "fileLocation");
                AbstractC13042fc3.i(str, "fileName");
                AbstractC13042fc3.i(str2, "mimeType");
                this.e = i;
                this.f = i2;
                this.g = dVar;
                this.h = c0536a;
                this.i = str;
                this.j = i3;
                this.k = str2;
            }

            @Override // ir.nasim.C6374Ni0.a
            public C0536a a() {
                return this.h;
            }

            @Override // ir.nasim.C6374Ni0.a
            public String b() {
                return this.i;
            }

            @Override // ir.nasim.C6374Ni0.a
            public int c() {
                return this.j;
            }

            public final d d() {
                return this.g;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.e == bVar.e && this.f == bVar.f && AbstractC13042fc3.d(this.g, bVar.g) && AbstractC13042fc3.d(this.h, bVar.h) && AbstractC13042fc3.d(this.i, bVar.i) && this.j == bVar.j && AbstractC13042fc3.d(this.k, bVar.k);
            }

            public int hashCode() {
                int iHashCode = ((Integer.hashCode(this.e) * 31) + Integer.hashCode(this.f)) * 31;
                d dVar = this.g;
                return ((((((((iHashCode + (dVar == null ? 0 : dVar.hashCode())) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + this.k.hashCode();
            }

            public String toString() {
                return "Gif(width=" + this.e + ", height=" + this.f + ", thumb=" + this.g + ", fileLocation=" + this.h + ", fileName=" + this.i + ", fileSize=" + this.j + ", mimeType=" + this.k + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Ni0$a$c */
        public static final class c extends a {
            private final int e;
            private final int f;
            private final d g;
            private final C0536a h;
            private final String i;
            private final int j;
            private final String k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(int i, int i2, d dVar, C0536a c0536a, String str, int i3, String str2) {
                super(c0536a, str, i3, str2, null);
                AbstractC13042fc3.i(c0536a, "fileLocation");
                AbstractC13042fc3.i(str, "fileName");
                AbstractC13042fc3.i(str2, "mimeType");
                this.e = i;
                this.f = i2;
                this.g = dVar;
                this.h = c0536a;
                this.i = str;
                this.j = i3;
                this.k = str2;
            }

            @Override // ir.nasim.C6374Ni0.a
            public C0536a a() {
                return this.h;
            }

            @Override // ir.nasim.C6374Ni0.a
            public String b() {
                return this.i;
            }

            @Override // ir.nasim.C6374Ni0.a
            public int c() {
                return this.j;
            }

            public final d d() {
                return this.g;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.e == cVar.e && this.f == cVar.f && AbstractC13042fc3.d(this.g, cVar.g) && AbstractC13042fc3.d(this.h, cVar.h) && AbstractC13042fc3.d(this.i, cVar.i) && this.j == cVar.j && AbstractC13042fc3.d(this.k, cVar.k);
            }

            public int hashCode() {
                int iHashCode = ((Integer.hashCode(this.e) * 31) + Integer.hashCode(this.f)) * 31;
                d dVar = this.g;
                return ((((((((iHashCode + (dVar == null ? 0 : dVar.hashCode())) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + this.k.hashCode();
            }

            public String toString() {
                return "Photo(width=" + this.e + ", height=" + this.f + ", thumb=" + this.g + ", fileLocation=" + this.h + ", fileName=" + this.i + ", fileSize=" + this.j + ", mimeType=" + this.k + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Ni0$a$d */
        public static final class d {
            private final int a;
            private final int b;
            private final byte[] c;

            public d(int i, int i2, byte[] bArr) {
                AbstractC13042fc3.i(bArr, "value");
                this.a = i;
                this.b = i2;
                this.c = bArr;
            }

            public final byte[] a() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!AbstractC13042fc3.d(d.class, obj != null ? obj.getClass() : null)) {
                    return false;
                }
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.users.entity.BotIntro.Media.Thumb");
                d dVar = (d) obj;
                return this.a == dVar.a && this.b == dVar.b;
            }

            public int hashCode() {
                return (this.a * 31) + this.b;
            }

            public String toString() {
                return "Thumb(w=" + this.a + ", h=" + this.b + ", value=" + Arrays.toString(this.c) + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Ni0$a$e */
        public static final class e extends a {
            private final C0536a e;
            private final String f;
            private final int g;
            private final String h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(C0536a c0536a, String str, int i, String str2) {
                super(c0536a, str, i, str2, null);
                AbstractC13042fc3.i(c0536a, "fileLocation");
                AbstractC13042fc3.i(str, "fileName");
                AbstractC13042fc3.i(str2, "mimeType");
                this.e = c0536a;
                this.f = str;
                this.g = i;
                this.h = str2;
            }

            @Override // ir.nasim.C6374Ni0.a
            public C0536a a() {
                return this.e;
            }

            @Override // ir.nasim.C6374Ni0.a
            public String b() {
                return this.f;
            }

            @Override // ir.nasim.C6374Ni0.a
            public int c() {
                return this.g;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return AbstractC13042fc3.d(this.e, eVar.e) && AbstractC13042fc3.d(this.f, eVar.f) && this.g == eVar.g && AbstractC13042fc3.d(this.h, eVar.h);
            }

            public int hashCode() {
                return (((((this.e.hashCode() * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode();
            }

            public String toString() {
                return "Unsupported(fileLocation=" + this.e + ", fileName=" + this.f + ", fileSize=" + this.g + ", mimeType=" + this.h + Separators.RPAREN;
            }
        }

        public /* synthetic */ a(C0536a c0536a, String str, int i, String str2, ED1 ed1) {
            this(c0536a, str, i, str2);
        }

        public abstract C0536a a();

        public abstract String b();

        public abstract int c();

        private a(C0536a c0536a, String str, int i, String str2) {
            this.a = c0536a;
            this.b = str;
            this.c = i;
            this.d = str2;
        }
    }

    public C6374Ni0(String str, a aVar) {
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
        if (!(obj instanceof C6374Ni0)) {
            return false;
        }
        C6374Ni0 c6374Ni0 = (C6374Ni0) obj;
        return AbstractC13042fc3.d(this.a, c6374Ni0.a) && AbstractC13042fc3.d(this.b, c6374Ni0.b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        a aVar = this.b;
        return iHashCode + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "BotIntro(text=" + this.a + ", media=" + this.b + Separators.RPAREN;
    }
}
