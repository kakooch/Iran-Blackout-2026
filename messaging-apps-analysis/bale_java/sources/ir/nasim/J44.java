package ir.nasim;

import ir.nasim.GG5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class J44 extends AbstractC17902nl0 implements HB3 {
    public static final a v = new a(null);
    public static final int w = 8;
    public static final InterfaceC17311ml0 x = new InterfaceC17311ml0() { // from class: ir.nasim.I44
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return J44.r();
        }
    };
    private EnumC23558x74 a;
    private long b;
    private C17532n74 c;
    private C7880To7 d;
    private EnumC19769qu4 e;
    private long f;
    private long g;
    private long h;
    private int i;
    private AbstractC17457n0 j;
    private AbstractC17457n0 k;
    private C3460Az l;
    private C3460Az m;
    private List n;
    private int o;
    private C8445Vz5 p;
    private List q;
    private boolean r;
    private Long s;
    private CI7 t;
    private boolean u;

    public static final class a {
        private a() {
        }

        public final J44 a(byte[] bArr) {
            AbstractC17902nl0 abstractC17902nl0B = AbstractC16720ll0.b(new J44(0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524287, null), bArr);
            AbstractC13042fc3.h(abstractC17902nl0B, "parse(...)");
            return (J44) abstractC17902nl0B;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public J44() {
        this(0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524287, null);
    }

    public static /* synthetic */ J44 D(J44 j44, long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0, List list, int i2, C8445Vz5 c8445Vz5, List list2, long j4, C3460Az c3460Az, C3460Az c3460Az2, boolean z, Long l, boolean z2, C17532n74 c17532n74, C7880To7 c7880To7, int i3, Object obj) {
        if (obj == null) {
            return j44.C((i3 & 1) != 0 ? j44.f : j, (i3 & 2) != 0 ? j44.g : j2, (i3 & 4) != 0 ? j44.h : j3, (i3 & 8) != 0 ? j44.i : i, (i3 & 16) != 0 ? j44.a : enumC23558x74, (i3 & 32) != 0 ? j44.F() : abstractC17457n0, (i3 & 64) != 0 ? j44.n : list, (i3 & 128) != 0 ? j44.o : i2, (i3 & 256) != 0 ? j44.p : c8445Vz5, (i3 & 512) != 0 ? j44.q : list2, (i3 & 1024) != 0 ? j44.b : j4, (i3 & 2048) != 0 ? j44.O() : c3460Az, (i3 & 4096) != 0 ? j44.N() : c3460Az2, (i3 & 8192) != 0 ? j44.r : z, (i3 & 16384) != 0 ? j44.s : l, (i3 & 32768) != 0 ? j44.u : z2, (i3 & 65536) != 0 ? j44.c : c17532n74, (i3 & 131072) != 0 ? j44.d : c7880To7);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final J44 r() {
        return new J44(0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524287, null);
    }

    public final J44 C(long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0, List list, int i2, C8445Vz5 c8445Vz5, List list2, long j4, C3460Az c3460Az, C3460Az c3460Az2, boolean z, Long l, boolean z2, C17532n74 c17532n74, C7880To7 c7880To7) {
        AbstractC13042fc3.i(enumC23558x74, "messageState");
        AbstractC13042fc3.i(abstractC17457n0, "content");
        AbstractC13042fc3.i(list, "reactions");
        return new J44(j, j2, j3, i, enumC23558x74, abstractC17457n0, list, i2, c8445Vz5, list2, j4, c3460Az, c3460Az2, z, l, c17532n74, z2, c7880To7, this.e);
    }

    public final J44 E(C8445Vz5 c8445Vz5) {
        return D(this, 0L, 0L, 0L, 0, null, null, null, 0, c8445Vz5, null, 0L, null, null, false, null, false, null, null, 261887, null);
    }

    public final AbstractC17457n0 F() {
        AbstractC17457n0 abstractC17457n0R;
        AbstractC17457n0 abstractC17457n0 = this.j;
        if (!(abstractC17457n0 instanceof C18121o72)) {
            return abstractC17457n0;
        }
        C8445Vz5 c8445Vz5 = this.p;
        return (c8445Vz5 == null || (abstractC17457n0R = c8445Vz5.r()) == null) ? this.j : abstractC17457n0R;
    }

    public final int G() {
        return this.o;
    }

    public C24967zW1 H() {
        return F().f();
    }

    public final Long J() {
        return this.s;
    }

    public final boolean K() {
        return this.u;
    }

    public final EnumC23558x74 L() {
        return this.a;
    }

    public final EnumC19769qu4 M() {
        return this.e;
    }

    public final C3460Az N() {
        if (!(F() instanceof C11907dl)) {
            return this.m;
        }
        AbstractC17457n0 abstractC17457n0F = F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        J44 j44 = (J44) AbstractC15401jX0.F0(((C11907dl) abstractC17457n0F).r());
        if (j44 != null) {
            return j44.N();
        }
        return null;
    }

    public final C3460Az O() {
        if (!(F() instanceof C11907dl)) {
            return this.l;
        }
        AbstractC17457n0 abstractC17457n0F = F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        J44 j44 = (J44) AbstractC15401jX0.s0(((C11907dl) abstractC17457n0F).r());
        if (j44 != null) {
            return j44.O();
        }
        return null;
    }

    public final AbstractC17457n0 P() {
        AbstractC17457n0 abstractC17457n0F = F();
        C5331Iw5 c5331Iw5 = abstractC17457n0F instanceof C5331Iw5 ? (C5331Iw5) abstractC17457n0F : null;
        if (c5331Iw5 != null) {
            return c5331Iw5.r();
        }
        return null;
    }

    public final C8445Vz5 Q() {
        return this.p;
    }

    public final List R() {
        return this.n;
    }

    public final List S() {
        return this.q;
    }

    public final C17532n74 T() {
        return this.c;
    }

    public final int U() {
        return this.i;
    }

    public final boolean V() {
        return this.r;
    }

    public final long W() {
        return this.g;
    }

    public final C7880To7 X() {
        return this.d;
    }

    public final CI7 Y() {
        return this.t;
    }

    @Override // ir.nasim.HB3
    public long a() {
        return this.f;
    }

    public final boolean a0() {
        Long l = this.s;
        return l != null && (l == null || l.longValue() != 0);
    }

    public final boolean b0() {
        return this.o > 0;
    }

    public final boolean c0() {
        AbstractC17457n0 abstractC17457n0F = F();
        C5331Iw5 c5331Iw5 = abstractC17457n0F instanceof C5331Iw5 ? (C5331Iw5) abstractC17457n0F : null;
        return c5331Iw5 != null && c5331Iw5.s();
    }

    public final boolean d0() {
        EnumC23558x74 enumC23558x74 = this.a;
        return enumC23558x74 == EnumC23558x74.SENT || enumC23558x74 == EnumC23558x74.PENDING;
    }

    public final boolean e0() {
        return this.a == EnumC23558x74.SENT;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof J44)) {
            return false;
        }
        J44 j44 = (J44) obj;
        return j44.f == this.f && j44.h == this.h;
    }

    public final boolean g0() {
        return F() instanceof C12872fJ6;
    }

    public final long h() {
        return this.h;
    }

    public final void h0(boolean z) {
        this.u = z;
    }

    public final long i() {
        return this.f;
    }

    public final void i0(EnumC23558x74 enumC23558x74) {
        AbstractC13042fc3.i(enumC23558x74, "<set-?>");
        this.a = enumC23558x74;
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.g;
    }

    public final void j0(C3460Az c3460Az) {
        this.m = c3460Az;
    }

    public final void l0(C3460Az c3460Az) {
        this.l = c3460Az;
    }

    public final void m0(C17532n74 c17532n74) {
        this.c = c17532n74;
    }

    public final void n0(C7880To7 c7880To7) {
        this.d = c7880To7;
    }

    public final void o0(CI7 ci7) {
        this.t = ci7;
    }

    @Override // ir.nasim.HB3
    public String p() {
        String strA;
        C24967zW1 c24967zW1H = H();
        return (c24967zW1H == null || (strA = EnumC15168j74.b.a(c24967zW1H)) == null) ? "other" : strA;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.f = c19084pl0.i(1);
        this.g = c19084pl0.i(2);
        this.h = c19084pl0.i(3);
        this.i = c19084pl0.g(4);
        this.a = EnumC23558x74.j(c19084pl0.h(5, EnumC23558x74.UNKNOWN.a));
        this.j = AbstractC17457n0.n(c19084pl0.d(6));
        List listL = c19084pl0.l(7);
        AbstractC13042fc3.h(listL, "getRepeatedBytes(...)");
        List list = listL;
        GG5.a aVar = GG5.d;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((byte[]) it.next()));
        }
        this.n = arrayList;
        this.o = c19084pl0.h(8, 0);
        this.p = (C8445Vz5) c19084pl0.z(9, new C8445Vz5());
        this.q = c19084pl0.o(10);
        this.l = (C3460Az) c19084pl0.z(11, new C3460Az());
        this.m = (C3460Az) c19084pl0.z(12, new C3460Az());
        this.r = c19084pl0.u(14);
        this.s = Long.valueOf(c19084pl0.y(15));
        this.u = c19084pl0.u(16);
        this.c = (C17532n74) c19084pl0.z(17, new C17532n74(0, null, null, null, null, null, false, 0L, 0, 511, null));
    }

    public final J44 s(long j) {
        return D(this, 0L, j, j, 0, null, null, null, 0, null, null, 0L, null, null, false, null, false, null, null, 262137, null);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.g(1, this.f);
        c19675ql0.g(2, this.g);
        c19675ql0.g(3, this.h);
        c19675ql0.f(4, this.i);
        c19675ql0.f(5, this.a.a);
        c19675ql0.b(6, AbstractC17457n0.o(F()));
        c19675ql0.m(7, this.n);
        c19675ql0.f(8, this.o);
        C8445Vz5 c8445Vz5 = this.p;
        if (c8445Vz5 != null) {
            c19675ql0.i(9, c8445Vz5);
        }
        List list = this.q;
        if (list != null) {
            c19675ql0.l(10, list);
        }
        C3460Az c3460AzO = O();
        if (c3460AzO != null) {
            c19675ql0.i(11, c3460AzO);
        }
        C3460Az c3460AzN = N();
        if (c3460AzN != null) {
            c19675ql0.i(12, c3460AzN);
        }
        c19675ql0.a(14, this.r);
        Long l = this.s;
        if (l != null) {
            c19675ql0.g(15, l.longValue());
        }
        c19675ql0.a(16, this.u);
        C17532n74 c17532n74 = this.c;
        if (c17532n74 != null) {
            c19675ql0.i(17, c17532n74);
        }
    }

    public final J44 u(AbstractC17457n0 abstractC17457n0, boolean z) {
        AbstractC13042fc3.i(abstractC17457n0, "content");
        if (abstractC17457n0.m() && F().m()) {
            C24967zW1 c24967zW1F = abstractC17457n0.f();
            C23345wl7 c23345wl7T = c24967zW1F != null ? c24967zW1F.t() : null;
            C24967zW1 c24967zW1H = H();
            if (AbstractC13042fc3.d(c23345wl7T, c24967zW1H != null ? c24967zW1H.t() : null)) {
                return D(this, 0L, 0L, 0L, 0, null, abstractC17457n0, null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null);
            }
        } else if ((abstractC17457n0 instanceof C23345wl7) && (F() instanceof C23345wl7)) {
            AbstractC17457n0 abstractC17457n0F = F();
            C23345wl7 c23345wl7 = abstractC17457n0F instanceof C23345wl7 ? (C23345wl7) abstractC17457n0F : null;
            if (!((c23345wl7 != null ? c23345wl7.w() : null) instanceof C12202eD) && (((C23345wl7) abstractC17457n0).w() instanceof C12202eD)) {
                return D(this, 0L, 0L, 0L, 0, null, abstractC17457n0, null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null);
            }
        }
        return D(this, 0L, 0L, 0L, 0, null, abstractC17457n0, null, this.o + (!z ? 1 : 0), null, null, 0L, null, null, false, null, false, null, null, 261983, null);
    }

    public final J44 w(AbstractC17457n0 abstractC17457n0) {
        AbstractC13042fc3.i(abstractC17457n0, "content");
        return D(this, 0L, 0L, 0L, 0, null, abstractC17457n0, null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null);
    }

    public final J44 y(EnumC23558x74 enumC23558x74) {
        AbstractC13042fc3.i(enumC23558x74, "messageState");
        return D(this, 0L, 0L, 0L, 0, enumC23558x74, null, null, 0, null, null, 0L, null, null, false, null, false, null, null, 262127, null);
    }

    public final J44 z(List list) {
        AbstractC13042fc3.i(list, "reactions");
        return D(this, 0L, 0L, 0L, 0, null, null, list, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public J44(long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0) {
        this(j, j2, j3, i, enumC23558x74, abstractC17457n0, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null);
        AbstractC13042fc3.i(enumC23558x74, "messageState");
        AbstractC13042fc3.i(abstractC17457n0, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public J44(long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0, List list, int i2, C8445Vz5 c8445Vz5) {
        this(j, j2, j3, i, enumC23558x74, abstractC17457n0, list, i2, c8445Vz5, null, 0L, null, null, false, null, null, false, null, null, 523776, null);
        AbstractC13042fc3.i(enumC23558x74, "messageState");
        AbstractC13042fc3.i(abstractC17457n0, "content");
        AbstractC13042fc3.i(list, "reactions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public J44(long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0, List list, int i2, C8445Vz5 c8445Vz5, List list2, long j4, C3460Az c3460Az, C3460Az c3460Az2, boolean z, Long l) {
        this(j, j2, j3, i, enumC23558x74, abstractC17457n0, list, i2, c8445Vz5, list2, j4, c3460Az, c3460Az2, z, l, null, false, null, null, 491520, null);
        AbstractC13042fc3.i(enumC23558x74, "messageState");
        AbstractC13042fc3.i(abstractC17457n0, "content");
        AbstractC13042fc3.i(list, "reactions");
    }

    public /* synthetic */ J44(long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0, List list, int i2, C8445Vz5 c8445Vz5, List list2, long j4, C3460Az c3460Az, C3460Az c3460Az2, boolean z, Long l, C17532n74 c17532n74, boolean z2, C7880To7 c7880To7, EnumC19769qu4 enumC19769qu4, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0L : j2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? EnumC23558x74.UNKNOWN : enumC23558x74, (i3 & 32) != 0 ? new C18121o72(null) : abstractC17457n0, (i3 & 64) != 0 ? AbstractC10360bX0.m() : list, (i3 & 128) != 0 ? 0 : i2, (i3 & 256) != 0 ? null : c8445Vz5, (i3 & 512) != 0 ? null : list2, (i3 & 1024) != 0 ? 0L : j4, (i3 & 2048) != 0 ? null : c3460Az, (i3 & 4096) != 0 ? null : c3460Az2, (i3 & 8192) != 0 ? false : z, (i3 & 16384) != 0 ? null : l, (i3 & 32768) != 0 ? null : c17532n74, (i3 & 65536) != 0 ? false : z2, (i3 & 131072) != 0 ? null : c7880To7, (i3 & 262144) != 0 ? EnumC19769qu4.d : enumC19769qu4);
    }

    public J44(long j, long j2, long j3, int i, EnumC23558x74 enumC23558x74, AbstractC17457n0 abstractC17457n0, List list, int i2, C8445Vz5 c8445Vz5, List list2, long j4, C3460Az c3460Az, C3460Az c3460Az2, boolean z, Long l, C17532n74 c17532n74, boolean z2, C7880To7 c7880To7, EnumC19769qu4 enumC19769qu4) {
        AbstractC13042fc3.i(enumC23558x74, "messageState");
        AbstractC13042fc3.i(abstractC17457n0, "content");
        AbstractC13042fc3.i(list, "reactions");
        AbstractC13042fc3.i(enumC19769qu4, "newMessageState");
        this.a = enumC23558x74;
        this.b = j4;
        this.c = c17532n74;
        this.d = c7880To7;
        this.e = enumC19769qu4;
        this.f = j;
        this.g = j2;
        this.h = j3;
        this.i = i;
        this.j = abstractC17457n0;
        C5331Iw5 c5331Iw5 = abstractC17457n0 instanceof C5331Iw5 ? (C5331Iw5) abstractC17457n0 : null;
        this.k = c5331Iw5 != null ? c5331Iw5.r() : null;
        this.l = c3460Az;
        this.m = c3460Az2;
        this.n = list;
        this.o = i2;
        this.p = c8445Vz5;
        this.q = list2;
        this.r = z;
        this.s = l;
        this.u = z2;
    }
}
