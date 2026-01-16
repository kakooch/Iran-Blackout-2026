package ir.nasim;

import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.mL1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17067mL1 extends AbstractC17902nl0 implements HB3 {
    public static final a D = new a(null);
    public static final int G = 8;
    public static final InterfaceC17311ml0 H = new InterfaceC17311ml0() { // from class: ir.nasim.lL1
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return C17067mL1.r();
        }
    };
    private List A;
    private List B;
    private long a;
    private long b;
    private int c;
    private int d;
    private String e;
    private EnumC18494ol1 f;
    private long g;
    private J44 h;
    private C11458d25 i;
    private String j;
    private int k;
    private String l;
    private Long m;
    private Long n;
    private Avatar o;
    private ExPeerType p;
    private E25 q;
    private boolean r;
    private boolean s;
    private long t;
    private String u;
    private boolean v;
    private Long w;
    private Long x;
    private ir.nasim.features.mxp.entity.a y;
    private C15280jJ5 z;

    /* renamed from: ir.nasim.mL1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C17067mL1(C11458d25 c11458d25, J44 j44, long j, String str, Avatar avatar, int i, Long l, Long l2, ExPeerType exPeerType, E25 e25, boolean z, boolean z2, long j2, String str2, Long l3, boolean z3, ir.nasim.features.mxp.entity.a aVar, C15280jJ5 c15280jJ5, List list, List list2, Long l4) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DIALOG_TITLE);
        AbstractC13042fc3.i(list, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
        AbstractC13042fc3.i(list2, "unreadReactions");
        this.t = -1L;
        this.A = AbstractC10360bX0.m();
        AbstractC10360bX0.m();
        this.i = c11458d25;
        this.h = j44;
        this.g = j;
        this.j = str;
        this.o = avatar;
        this.k = i;
        this.m = l;
        this.n = l2;
        this.p = exPeerType;
        this.q = e25;
        this.r = z;
        this.s = z2;
        this.t = j2;
        this.u = str2;
        this.x = l3;
        this.v = z3;
        this.w = l4;
        this.y = aVar;
        this.z = c15280jJ5;
        this.A = list;
        this.B = list2;
    }

    public static /* synthetic */ C17067mL1 E(C17067mL1 c17067mL1, String str, Avatar avatar, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return c17067mL1.D(str, avatar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ C17067mL1 r() {
        return new C17067mL1();
    }

    public static /* synthetic */ C17067mL1 w(C17067mL1 c17067mL1, C11458d25 c11458d25, J44 j44, long j, String str, Avatar avatar, int i, Long l, Long l2, ExPeerType exPeerType, E25 e25, boolean z, boolean z2, long j2, String str2, Long l3, boolean z3, ir.nasim.features.mxp.entity.a aVar, C15280jJ5 c15280jJ5, Long l4, List list, List list2, int i2, Object obj) {
        return c17067mL1.u((i2 & 1) != 0 ? c17067mL1.R() : c11458d25, (i2 & 2) != 0 ? c17067mL1.Q() : j44, (i2 & 4) != 0 ? c17067mL1.g : j, (i2 & 8) != 0 ? c17067mL1.J() : str, (i2 & 16) != 0 ? c17067mL1.o : avatar, (i2 & 32) != 0 ? c17067mL1.k : i, (i2 & 64) != 0 ? c17067mL1.m : l, (i2 & 128) != 0 ? c17067mL1.n : l2, (i2 & 256) != 0 ? c17067mL1.p : exPeerType, (i2 & 512) != 0 ? c17067mL1.q : e25, (i2 & 1024) != 0 ? c17067mL1.r : z, (i2 & 2048) != 0 ? c17067mL1.s : z2, (i2 & 4096) != 0 ? c17067mL1.t : j2, (i2 & 8192) != 0 ? c17067mL1.u : str2, (i2 & 16384) != 0 ? c17067mL1.x : l3, (i2 & 32768) != 0 ? c17067mL1.v : z3, (i2 & 65536) != 0 ? c17067mL1.y : aVar, (i2 & 131072) != 0 ? c17067mL1.z : c15280jJ5, (i2 & 262144) != 0 ? c17067mL1.w : l4, (i2 & 524288) != 0 ? c17067mL1.A : list, (i2 & 1048576) != 0 ? c17067mL1.B : list2);
    }

    private final J44 y() {
        long j = this.a;
        long j2 = this.g;
        long j3 = this.b;
        int i = this.c;
        EnumC23558x74 enumC23558x74 = EnumC23558x74.UNKNOWN;
        EnumC18494ol1 enumC18494ol1 = this.f;
        String str = null;
        if (enumC18494ol1 == null) {
            AbstractC13042fc3.y("legacyContentType");
            enumC18494ol1 = null;
        }
        String str2 = this.e;
        if (str2 == null) {
            AbstractC13042fc3.y("legacyText");
        } else {
            str = str2;
        }
        return new J44(j, j2, j3, i, enumC23558x74, new C18285oP1(enumC18494ol1, str, this.d), null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null);
    }

    public final C17067mL1 C(String str, Avatar avatar) {
        AbstractC13042fc3.i(str, "title");
        return E(this, str, avatar, false, 4, null);
    }

    public final C17067mL1 D(String str, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(str, "title");
        return w(this, null, null, 0L, str, avatar, 0, null, null, null, null, false, z, 0L, null, null, false, null, null, null, null, null, 2095079, null);
    }

    public final C17067mL1 F(long j) {
        return w(this, null, null, 0L, null, null, 0, null, null, null, null, false, false, j, null, null, false, null, null, null, null, null, 2093055, null);
    }

    public final C17067mL1 G(ir.nasim.features.mxp.entity.a aVar) {
        return w(this, null, null, 0L, null, null, 0, null, null, null, null, false, false, 0L, null, null, false, aVar, null, null, null, null, 2031615, null);
    }

    public final Avatar H() {
        return this.o;
    }

    public final String J() {
        String str = this.j;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y(DialogEntity.COLUMN_DIALOG_TITLE);
        return null;
    }

    public final String K() {
        return this.u;
    }

    public final Long L() {
        return this.x;
    }

    public final boolean M() {
        return this.r;
    }

    public final Long N() {
        return this.m;
    }

    public final Long O() {
        return this.n;
    }

    public final Long P() {
        return this.w;
    }

    public final J44 Q() {
        J44 j44 = this.h;
        if (j44 != null) {
            return j44;
        }
        AbstractC13042fc3.y(DialogEntity.COLUMN_MESSAGE);
        return null;
    }

    public final C11458d25 R() {
        C11458d25 c11458d25 = this.i;
        if (c11458d25 != null) {
            return c11458d25;
        }
        AbstractC13042fc3.y("peer");
        return null;
    }

    public final E25 S() {
        return this.q;
    }

    public final long T() {
        return this.t;
    }

    public final ir.nasim.features.mxp.entity.a U() {
        return this.y;
    }

    public final C15280jJ5 V() {
        return this.z;
    }

    public final String W() {
        return this.l;
    }

    public final long X() {
        return this.g;
    }

    public final int Y() {
        return this.k;
    }

    @Override // ir.nasim.HB3
    public long a() {
        return R().u();
    }

    public final List a0() {
        return this.A;
    }

    public final List b0() {
        return this.B;
    }

    public final boolean c0() {
        return this.s;
    }

    public final boolean d0() {
        return this.v;
    }

    public final boolean e0() {
        return this.t != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && AbstractC13042fc3.d(C17067mL1.class, obj.getClass()) && R().u() == ((C17067mL1) obj).R().u();
    }

    public final boolean g0() {
        Long l = this.m;
        if (l != null) {
            return this.g <= l.longValue();
        }
        return false;
    }

    public final ExPeerType getExPeerType() {
        return this.p;
    }

    public final boolean h0() {
        Long l = this.n;
        if (l != null) {
            return this.g <= l.longValue();
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(R().u()));
    }

    public final void i0(String str) {
        this.l = str;
    }

    @Override // ir.nasim.HB3
    public long j() {
        if (e0()) {
            return 9223372036854765806L - this.t;
        }
        String str = this.u;
        Long l = this.x;
        return (str == null || l == null || str.length() <= 0) ? this.g : Math.max(l.longValue(), this.g);
    }

    @Override // ir.nasim.HB3
    public String p() {
        return J();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ff  */
    @Override // ir.nasim.AbstractC17902nl0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parse(ir.nasim.C19084pl0 r11) throws ir.nasim.core.runtime.bser.IncorrectTypeException {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17067mL1.parse(ir.nasim.pl0):void");
    }

    public final C17067mL1 s(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        return w(this, null, j44, 0L, null, null, 0, null, null, null, null, false, false, 0L, null, null, false, null, null, null, null, null, 2097149, null);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.i(1, R());
        c19675ql0.o(2, J());
        Avatar avatar = this.o;
        if (avatar != null) {
            c19675ql0.i(3, avatar);
        }
        c19675ql0.f(4, this.k);
        c19675ql0.g(5, this.g);
        if (this.h == null) {
            this.h = y();
        }
        Long l = this.n;
        if (l != null) {
            c19675ql0.g(13, l.longValue());
        }
        Long l2 = this.m;
        if (l2 != null) {
            c19675ql0.g(14, l2.longValue());
        }
        ExPeerType exPeerType = this.p;
        if (exPeerType != null) {
            c19675ql0.f(15, exPeerType.getValue());
        }
        E25 e25 = this.q;
        if (e25 != null) {
            c19675ql0.f(16, e25.p());
        }
        c19675ql0.a(17, this.r);
        c19675ql0.a(18, this.s);
        c19675ql0.g(19, this.t);
        String str = this.u;
        if (str != null) {
            c19675ql0.o(21, str);
        }
        Long l3 = this.x;
        if (l3 != null) {
            c19675ql0.g(22, l3.longValue());
        }
        c19675ql0.a(24, this.v);
        ir.nasim.features.mxp.entity.a aVar = this.y;
        if (aVar != null) {
            c19675ql0.f(25, aVar.r());
        }
        c19675ql0.i(26, Q());
        c19675ql0.m(27, this.A);
        c19675ql0.m(28, this.B);
        Long l4 = this.w;
        c19675ql0.g(30, l4 != null ? l4.longValue() : -1L);
    }

    public final C17067mL1 u(C11458d25 c11458d25, J44 j44, long j, String str, Avatar avatar, int i, Long l, Long l2, ExPeerType exPeerType, E25 e25, boolean z, boolean z2, long j2, String str2, Long l3, boolean z3, ir.nasim.features.mxp.entity.a aVar, C15280jJ5 c15280jJ5, Long l4, List list, List list2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DIALOG_TITLE);
        AbstractC13042fc3.i(list, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
        AbstractC13042fc3.i(list2, "unreadReactions");
        return new C17067mL1(c11458d25, j44, j, str, avatar, i, l, l2, exPeerType, e25, z, z2, j2, str2, l3, z3, aVar, c15280jJ5, list, list2, l4);
    }

    public final C17067mL1 z(E25 e25) {
        return w(this, null, null, 0L, null, null, 0, null, null, null, e25, false, false, 0L, null, null, false, null, null, null, null, null, 2096639, null);
    }

    private C17067mL1() {
        this.t = -1L;
        this.A = AbstractC10360bX0.m();
        this.B = AbstractC10360bX0.m();
    }
}
