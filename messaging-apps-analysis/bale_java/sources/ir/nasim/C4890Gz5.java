package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;
import java.util.ArrayList;

/* renamed from: ir.nasim.Gz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4890Gz5 {
    private final long a;
    private final long b;
    private final long c;
    private final ExPeer d;
    private final String e;
    private final String f;
    private final String g;
    private final InterfaceC19401qH7 h;
    private final Long i;
    private long j;
    private final boolean k;
    private final EnumC4543Fo6 l;
    private final ir.nasim.tgwidgets.editor.messenger.H m;
    private final InterfaceC10839cH7 n;
    private int o;
    private float p;
    private boolean q;
    private boolean r;
    private final ArrayList s;
    private VH7 t;
    private C12855fH7 u;

    public C4890Gz5(long j, long j2, long j3, ExPeer exPeer, String str, String str2, String str3, InterfaceC19401qH7 interfaceC19401qH7, Long l, long j4, boolean z, EnumC4543Fo6 enumC4543Fo6, ir.nasim.tgwidgets.editor.messenger.H h, InterfaceC10839cH7 interfaceC10839cH7, int i, float f, boolean z2, boolean z3, ArrayList arrayList) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "fileDescriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC10839cH7, "fileType");
        AbstractC13042fc3.i(arrayList, "callbacks");
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = exPeer;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = interfaceC19401qH7;
        this.i = l;
        this.j = j4;
        this.k = z;
        this.l = enumC4543Fo6;
        this.m = h;
        this.n = interfaceC10839cH7;
        this.o = i;
        this.p = f;
        this.q = z2;
        this.r = z3;
        this.s = arrayList;
    }

    public final void A(boolean z) {
        this.r = z;
    }

    public final void B(long j) {
        this.j = j;
    }

    public final void C(boolean z) {
        this.q = z;
    }

    public final void D(VH7 vh7) {
        this.t = vh7;
    }

    public final C4890Gz5 a(long j, long j2, long j3, ExPeer exPeer, String str, String str2, String str3, InterfaceC19401qH7 interfaceC19401qH7, Long l, long j4, boolean z, EnumC4543Fo6 enumC4543Fo6, ir.nasim.tgwidgets.editor.messenger.H h, InterfaceC10839cH7 interfaceC10839cH7, int i, float f, boolean z2, boolean z3, ArrayList arrayList) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "fileDescriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC10839cH7, "fileType");
        AbstractC13042fc3.i(arrayList, "callbacks");
        return new C4890Gz5(j, j2, j3, exPeer, str, str2, str3, interfaceC19401qH7, l, j4, z, enumC4543Fo6, h, interfaceC10839cH7, i, f, z2, z3, arrayList);
    }

    public final ArrayList c() {
        return this.s;
    }

    public final String d() {
        return this.g;
    }

    public final boolean e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4890Gz5)) {
            return false;
        }
        C4890Gz5 c4890Gz5 = (C4890Gz5) obj;
        return this.a == c4890Gz5.a && this.b == c4890Gz5.b && this.c == c4890Gz5.c && AbstractC13042fc3.d(this.d, c4890Gz5.d) && AbstractC13042fc3.d(this.e, c4890Gz5.e) && AbstractC13042fc3.d(this.f, c4890Gz5.f) && AbstractC13042fc3.d(this.g, c4890Gz5.g) && AbstractC13042fc3.d(this.h, c4890Gz5.h) && AbstractC13042fc3.d(this.i, c4890Gz5.i) && this.j == c4890Gz5.j && this.k == c4890Gz5.k && this.l == c4890Gz5.l && AbstractC13042fc3.d(this.m, c4890Gz5.m) && AbstractC13042fc3.d(this.n, c4890Gz5.n) && this.o == c4890Gz5.o && Float.compare(this.p, c4890Gz5.p) == 0 && this.q == c4890Gz5.q && this.r == c4890Gz5.r && AbstractC13042fc3.d(this.s, c4890Gz5.s);
    }

    public final ExPeer f() {
        return this.d;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        InterfaceC19401qH7 interfaceC19401qH7 = this.h;
        int iHashCode3 = (iHashCode2 + (interfaceC19401qH7 == null ? 0 : interfaceC19401qH7.hashCode())) * 31;
        Long l = this.i;
        int iHashCode4 = (((((((iHashCode3 + (l == null ? 0 : l.hashCode())) * 31) + Long.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + this.l.hashCode()) * 31;
        ir.nasim.tgwidgets.editor.messenger.H h = this.m;
        return ((((((((((((iHashCode4 + (h != null ? h.hashCode() : 0)) * 31) + this.n.hashCode()) * 31) + Integer.hashCode(this.o)) * 31) + Float.hashCode(this.p)) * 31) + Boolean.hashCode(this.q)) * 31) + Boolean.hashCode(this.r)) * 31) + this.s.hashCode();
    }

    public final int i() {
        return this.o;
    }

    public final InterfaceC10839cH7 j() {
        return this.n;
    }

    public final C12855fH7 k() {
        return this.u;
    }

    public final long l() {
        return this.b;
    }

    public final float m() {
        return this.p;
    }

    public final Long n() {
        return this.i;
    }

    public final long o() {
        return this.a;
    }

    public final EnumC4543Fo6 p() {
        return this.l;
    }

    public final long q() {
        return this.j;
    }

    public final long r() {
        return this.c;
    }

    public final InterfaceC19401qH7 s() {
        return this.h;
    }

    public final VH7 t() {
        return this.t;
    }

    public String toString() {
        return "QueueItem{rid=" + this.a + "messageId=" + this.b + ", uniqueId=" + this.c + ", fileDescriptor='" + this.e + "', isStarted=" + this.q + ", progress=" + this.p + ", fileName='" + this.f + "'}";
    }

    public final ir.nasim.tgwidgets.editor.messenger.H u() {
        return this.m;
    }

    public final boolean v() {
        return this.r;
    }

    public final boolean w() {
        return this.q;
    }

    public final void x(int i) {
        this.o = i;
    }

    public final void y(C12855fH7 c12855fH7) {
        this.u = c12855fH7;
    }

    public final void z(float f) {
        this.p = f;
    }

    public /* synthetic */ C4890Gz5(long j, long j2, long j3, ExPeer exPeer, String str, String str2, String str3, InterfaceC19401qH7 interfaceC19401qH7, Long l, long j4, boolean z, EnumC4543Fo6 enumC4543Fo6, ir.nasim.tgwidgets.editor.messenger.H h, InterfaceC10839cH7 interfaceC10839cH7, int i, float f, boolean z2, boolean z3, ArrayList arrayList, int i2, ED1 ed1) {
        this(j, j2, j3, exPeer, str, str2, str3, interfaceC19401qH7, l, j4, z, enumC4543Fo6, h, interfaceC10839cH7, (i2 & 16384) != 0 ? 1 : i, (32768 & i2) != 0 ? 0.0f : f, (65536 & i2) != 0 ? false : z2, (131072 & i2) != 0 ? false : z3, (i2 & 262144) != 0 ? new ArrayList() : arrayList);
    }
}
