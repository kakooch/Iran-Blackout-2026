package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.nb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17810nb8 {
    private static final String s = HI3.f("WorkSpec");
    public static final InterfaceC21819uB2 t = new a();
    public String a;
    public Ta8 b;
    public String c;
    public String d;
    public androidx.work.b e;
    public androidx.work.b f;
    public long g;
    public long h;
    public long i;
    public C18424oe1 j;
    public int k;
    public EnumC9756aW l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public QM4 r;

    /* renamed from: ir.nasim.nb8$a */
    class a implements InterfaceC21819uB2 {
        a() {
        }

        @Override // ir.nasim.InterfaceC21819uB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    /* renamed from: ir.nasim.nb8$b */
    public static class b {
        public String a;
        public Ta8 b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b) {
                return false;
            }
            return this.a.equals(bVar.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    public C17810nb8(String str, String str2) {
        this.b = Ta8.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.c;
        this.e = bVar;
        this.f = bVar;
        this.j = C18424oe1.i;
        this.l = EnumC9756aW.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = QM4.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = str;
        this.c = str2;
    }

    public long a() {
        if (c()) {
            return this.n + Math.min(18000000L, this.l == EnumC9756aW.LINEAR ? this.m * this.k : (long) Math.scalb(this.m, this.k - 1));
        }
        if (!d()) {
            long jCurrentTimeMillis = this.n;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.g;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j = this.n;
        long j2 = j == 0 ? jCurrentTimeMillis2 + this.g : j;
        long j3 = this.i;
        long j4 = this.h;
        if (j3 != j4) {
            return j2 + j4 + (j == 0 ? j3 * (-1) : 0L);
        }
        return j2 + (j != 0 ? j4 : 0L);
    }

    public boolean b() {
        return !C18424oe1.i.equals(this.j);
    }

    public boolean c() {
        return this.b == Ta8.ENQUEUED && this.k > 0;
    }

    public boolean d() {
        return this.h != 0;
    }

    public void e(long j) {
        if (j > 18000000) {
            HI3.c().h(s, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            j = 18000000;
        }
        if (j < 10000) {
            HI3.c().h(s, "Backoff delay duration less than minimum value", new Throwable[0]);
            j = 10000;
        }
        this.m = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C17810nb8.class != obj.getClass()) {
            return false;
        }
        C17810nb8 c17810nb8 = (C17810nb8) obj;
        if (this.g != c17810nb8.g || this.h != c17810nb8.h || this.i != c17810nb8.i || this.k != c17810nb8.k || this.m != c17810nb8.m || this.n != c17810nb8.n || this.o != c17810nb8.o || this.p != c17810nb8.p || this.q != c17810nb8.q || !this.a.equals(c17810nb8.a) || this.b != c17810nb8.b || !this.c.equals(c17810nb8.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? c17810nb8.d == null : str.equals(c17810nb8.d)) {
            return this.e.equals(c17810nb8.e) && this.f.equals(c17810nb8.f) && this.j.equals(c17810nb8.j) && this.l == c17810nb8.l && this.r == c17810nb8.r;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        long j = this.g;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.h;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.i;
        int iHashCode3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.j.hashCode()) * 31) + this.k) * 31) + this.l.hashCode()) * 31;
        long j4 = this.m;
        int i3 = (iHashCode3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.n;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.o;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.p;
        return ((((i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.q ? 1 : 0)) * 31) + this.r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.a + "}";
    }

    public C17810nb8(C17810nb8 c17810nb8) {
        this.b = Ta8.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.c;
        this.e = bVar;
        this.f = bVar;
        this.j = C18424oe1.i;
        this.l = EnumC9756aW.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = QM4.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = c17810nb8.a;
        this.c = c17810nb8.c;
        this.b = c17810nb8.b;
        this.d = c17810nb8.d;
        this.e = new androidx.work.b(c17810nb8.e);
        this.f = new androidx.work.b(c17810nb8.f);
        this.g = c17810nb8.g;
        this.h = c17810nb8.h;
        this.i = c17810nb8.i;
        this.j = new C18424oe1(c17810nb8.j);
        this.k = c17810nb8.k;
        this.l = c17810nb8.l;
        this.m = c17810nb8.m;
        this.n = c17810nb8.n;
        this.o = c17810nb8.o;
        this.p = c17810nb8.p;
        this.q = c17810nb8.q;
        this.r = c17810nb8.r;
    }
}
