package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class GG5 extends AbstractC17902nl0 {
    public static final a d = new a(null);
    public static final int e = 8;
    private String a;
    private long b;
    private List c;

    public static final class a {
        private a() {
        }

        public final GG5 a(byte[] bArr) {
            AbstractC17902nl0 abstractC17902nl0B = AbstractC16720ll0.b(new GG5(null), bArr);
            AbstractC13042fc3.h(abstractC17902nl0B, "parse(...)");
            return (GG5) abstractC17902nl0B;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ GG5(ED1 ed1) {
        this();
    }

    public static /* synthetic */ GG5 r(GG5 gg5, String str, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gg5.u();
        }
        if ((i & 2) != 0) {
            list = gg5.c;
        }
        if ((i & 4) != 0) {
            j = gg5.b;
        }
        return gg5.q(str, list, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AbstractC13042fc3.d(GG5.class, obj.getClass())) {
            return false;
        }
        GG5 gg5 = (GG5) obj;
        return AbstractC13042fc3.d(u(), gg5.u()) && AbstractC13042fc3.d(this.c, gg5.c) && this.b == gg5.b;
    }

    public int hashCode() {
        return Objects.hash(u(), this.c, Long.valueOf(this.b));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.r(1);
        this.c = c19084pl0.n(2);
        this.b = c19084pl0.y(3);
    }

    public final GG5 q(String str, List list, long j) {
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(list, "uids");
        return new GG5(str, list, j);
    }

    public final long s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.o(1, u());
        c19675ql0.k(2, this.c);
        c19675ql0.g(3, this.b);
    }

    public final String u() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("code");
        return null;
    }

    public final long w() {
        return AbstractC23053wG5.f(this.b, this.c.size());
    }

    public final List y() {
        return this.c;
    }

    public GG5(String str, List list, long j) {
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(list, "uids");
        new ArrayList();
        this.a = str;
        this.c = list;
        this.b = j;
    }

    private GG5() {
        this.c = new ArrayList();
    }
}
