package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: ir.nasim.Gn1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4778Gn1 extends AbstractC17902nl0 implements InterfaceC8844Xo3 {
    public static InterfaceC17311ml0 v = new InterfaceC17311ml0() { // from class: ir.nasim.En1
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return C4778Gn1.r();
        }
    };
    public static InterfaceC15345jQ7 w = new InterfaceC15345jQ7() { // from class: ir.nasim.Fn1
        @Override // ir.nasim.InterfaceC15345jQ7
        public final Object a(long j) {
            return C4778Gn1.m0(j);
        }
    };
    private C11458d25 a;
    private ExPeerType b;
    private boolean c;
    private boolean d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private List k;
    private List l;
    private String m;
    private String n;
    private String o;
    private J44 p;
    private J44 q;
    private long r;
    private long s;
    private int t;
    private SortedSet u;

    public C4778Gn1(C11458d25 c11458d25, ExPeerType exPeerType, boolean z, boolean z2, int i, long j, long j2, long j3, long j4, boolean z3, String str, String str2, String str3, J44 j44, J44 j442, long j5, long j6, int i2, List list, List list2) {
        this.r = -1L;
        this.s = -1L;
        this.t = 0;
        this.u = new TreeSet();
        this.a = c11458d25;
        this.b = exPeerType;
        this.c = z;
        this.d = z2;
        this.e = i;
        this.f = j;
        this.g = j2;
        this.h = j3;
        this.i = j4;
        this.j = z3;
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.p = j44;
        this.q = j442;
        this.r = j5;
        this.s = j6;
        this.t = i2;
        this.k = list;
        this.l = list2;
    }

    private boolean l0(J44 j44) {
        if (j44 == null || j44.F() == null) {
            return false;
        }
        C22149uk7 c22149uk7 = (C22149uk7) j44.F();
        return c22149uk7.x() || c22149uk7.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C4778Gn1 m0(long j) {
        return new C4778Gn1(C11458d25.r(j), ExPeerType.UNKNOWN, false, false, 0, 0L, 0L, 0L, 0L, false, null, null, null, null, null, -1L, -1L, 0, new ArrayList(), new ArrayList());
    }

    public static /* synthetic */ C4778Gn1 r() {
        return new C4778Gn1();
    }

    public C4778Gn1 C(boolean z) {
        this.j = z;
        return this;
    }

    public C4778Gn1 D(long j) {
        this.f = j;
        return this;
    }

    public C4778Gn1 E(long j) {
        this.g = j;
        return this;
    }

    public C4778Gn1 F(J44 j44) {
        this.p = j44;
        if (l0(j44)) {
            this.q = j44;
        }
        return this;
    }

    public C4778Gn1 G(long j, long j2, int i) {
        this.r = j;
        this.s = j2;
        this.t = i;
        return this;
    }

    public C4778Gn1 H(SortedSet sortedSet) {
        TreeSet treeSet = new TreeSet(this.u);
        treeSet.addAll(sortedSet);
        this.u = treeSet;
        return this;
    }

    public C4778Gn1 J(long j) {
        this.h = j;
        return this;
    }

    public C4778Gn1 K(long j) {
        this.i = j;
        return this;
    }

    public C4778Gn1 L(List list) {
        if (C8386Vt0.U5()) {
            this.k = list;
        }
        return this;
    }

    public C4778Gn1 M(List list) {
        if (C8386Vt0.W5()) {
            this.l = list;
        }
        return this;
    }

    public String N() {
        return this.n;
    }

    public String O() {
        return this.m;
    }

    public String P() {
        return this.o;
    }

    public long Q() {
        return Math.max(this.f, 0L);
    }

    public long R() {
        return Math.max(this.g, 0L);
    }

    public J44 S() {
        J44 j44 = this.q;
        return j44 == null ? this.p : j44;
    }

    public J44 T() {
        return this.p;
    }

    public int U() {
        return this.t;
    }

    public long V() {
        return this.r;
    }

    public long W() {
        return this.s;
    }

    public SortedSet X() {
        return this.u;
    }

    public long Y() {
        return Math.max(this.h, 0L);
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return this.a.u();
    }

    public long a0() {
        return Math.max(this.i, 0L);
    }

    public C11458d25 b0() {
        return this.a;
    }

    public int c0() {
        return this.e;
    }

    public List d0() {
        return this.k;
    }

    public List e0() {
        return this.l;
    }

    public boolean g0() {
        long j = this.g;
        return j > 0 && j < this.f && this.e > 0;
    }

    public ExPeerType getExPeerType() {
        return this.b;
    }

    public boolean h0() {
        return this.d;
    }

    public boolean i0() {
        return this.c;
    }

    public boolean j0() {
        return this.j;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = C11458d25.q(c19084pl0.d(1));
        this.j = c19084pl0.c(2, false);
        this.g = c19084pl0.j(3, 0L);
        this.i = c19084pl0.j(4, 0L);
        this.h = c19084pl0.j(5, 0L);
        this.e = c19084pl0.g(6);
        if (c19084pl0.t()) {
            int iH = c19084pl0.h(7, 0);
            this.f = c19084pl0.j(iH + 8, 0L);
            this.d = c19084pl0.c(iH + 9, false);
            this.c = c19084pl0.c(iH + 11, false);
            String strA = c19084pl0.A(iH + 13);
            this.m = strA;
            if (strA != null && strA.equals("Empty")) {
                this.m = null;
            }
            String strA2 = c19084pl0.A(iH + 14);
            this.n = strA2;
            if (strA2 != null && strA2.equals("Empty")) {
                this.n = null;
            }
            String strA3 = c19084pl0.A(iH + 15);
            this.o = strA3;
            if (strA3 != null && strA3.equals("Empty")) {
                this.o = null;
            }
            this.p = (J44) c19084pl0.z(iH + 16, new J44());
            this.r = c19084pl0.j(iH + 17, -1L);
            this.s = c19084pl0.j(iH + 18, -1L);
            this.t = c19084pl0.h(iH + 19, 0);
            this.q = (J44) c19084pl0.z(iH + 20, new J44());
            this.b = ExPeerType.fromValue(c19084pl0.x(iH + 22));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(23); i++) {
            arrayList.add(new Q64());
        }
        this.u = new TreeSet(c19084pl0.p(23, arrayList));
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(24); i2++) {
            arrayList2.add(new Q64());
        }
        this.k = new ArrayList(c19084pl0.p(24, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(25); i3++) {
            arrayList3.add(new Q64());
        }
        this.l = new ArrayList(c19084pl0.p(25, arrayList3));
    }

    public C4778Gn1 s(String str) {
        this.o = str;
        return this;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.b(1, this.a.toByteArray());
        c19675ql0.a(2, this.j);
        c19675ql0.g(3, this.g);
        c19675ql0.g(4, this.i);
        c19675ql0.g(5, this.h);
        c19675ql0.f(6, this.e);
        c19675ql0.g(8, this.f);
        c19675ql0.a(9, this.d);
        c19675ql0.a(11, this.c);
        c19675ql0.o(13, (String) AbstractC4061Dn1.a(this.m, "Empty"));
        c19675ql0.o(14, (String) AbstractC4061Dn1.a(this.n, "Empty"));
        c19675ql0.o(15, (String) AbstractC4061Dn1.a(this.o, "Empty"));
        J44 j44 = this.p;
        if (j44 != null) {
            c19675ql0.i(16, j44);
        }
        c19675ql0.g(17, this.r);
        c19675ql0.g(18, this.s);
        c19675ql0.f(19, this.t);
        J44 j442 = this.q;
        if (j442 != null) {
            c19675ql0.i(20, j442);
        }
        c19675ql0.f(22, this.b.getValue());
        c19675ql0.m(23, new ArrayList(this.u));
        c19675ql0.m(24, this.k);
        c19675ql0.m(25, this.l);
    }

    public C4778Gn1 u(int i) {
        if (i < 0) {
            C19406qI3.j("UNREAD", "DialogsActor => onCounterChanged NEGATIVE " + i, new Object[0]);
        }
        this.e = i;
        return this;
    }

    public C4778Gn1 w(ExPeerType exPeerType) {
        this.b = exPeerType;
        return this;
    }

    public C4778Gn1 y(boolean z) {
        this.d = z;
        return this;
    }

    public C4778Gn1 z(boolean z) {
        this.c = z;
        return this;
    }

    private C4778Gn1() {
        this.r = -1L;
        this.s = -1L;
        this.t = 0;
        this.u = new TreeSet();
    }
}
