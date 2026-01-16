package ir.nasim;

import ir.nasim.IQ0;
import ir.nasim.M44;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes5.dex */
public class N44 implements InterfaceC14123hO3 {
    private final int a;
    private final int b;
    private final SettingsModule c;
    private final IQ0 d;
    private final List e;
    private final boolean f;
    private final UA2 g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23558x74.values().length];
            try {
                iArr[EnumC23558x74.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23558x74.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23558x74.SENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC23558x74.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public N44(int i, int i2, SettingsModule settingsModule, IQ0 iq0, List list, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(list, "pinnedMessage");
        AbstractC13042fc3.i(ua2, "isForwardedFromAnotherChannel");
        this.a = i;
        this.b = i2;
        this.c = settingsModule;
        this.d = iq0;
        this.e = list;
        this.f = z;
        this.g = ua2;
    }

    private final boolean b(C11907dl c11907dl) {
        int i;
        List listR = c11907dl.r();
        if ((listR instanceof Collection) && listR.isEmpty()) {
            i = 0;
        } else {
            Iterator it = listR.iterator();
            i = 0;
            while (it.hasNext()) {
                C23345wl7 c23345wl7L = ((J44) it.next()).F().l();
                String strV = c23345wl7L != null ? c23345wl7L.v() : null;
                if ((!(strV == null || strV.length() == 0)) && (i = i + 1) < 0) {
                    AbstractC10360bX0.v();
                }
            }
        }
        return i <= 1;
    }

    private final boolean c(J44 j44) {
        List<J44> list = this.e;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (J44 j442 : list) {
            arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
        }
        return !arrayList.contains(AbstractC4616Fw7.a(Long.valueOf(j44.i()), Long.valueOf(j44.h())));
    }

    private final boolean e(J44 j44) {
        List<J44> list = this.e;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (J44 j442 : list) {
            arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
        }
        return arrayList.contains(AbstractC4616Fw7.a(Long.valueOf(j44.i()), Long.valueOf(j44.h())));
    }

    private final void l(M44.a aVar, C24967zW1 c24967zW1) {
        if (c24967zW1 instanceof XG2) {
            aVar.F(true);
            aVar.V(false);
            aVar.E(false);
        } else if (c24967zW1 instanceof C13388g85) {
            aVar.V(true);
            aVar.E(true);
        } else if (c24967zW1 instanceof GS7) {
            aVar.V(true);
            aVar.E(false);
        }
    }

    private final void m(M44.a aVar, C5331Iw5 c5331Iw5) {
        if (c5331Iw5.s()) {
            aVar.C((134217727 & 1) != 0 ? false : false, (134217727 & 2) != 0 ? false : false, (134217727 & 4) != 0 ? false : false, (134217727 & 8) != 0 ? false : false, (134217727 & 16) != 0 ? false : false, (134217727 & 32) != 0 ? false : false, (134217727 & 64) != 0 ? false : false, (134217727 & 128) != 0 ? false : false, (134217727 & 256) != 0 ? false : false, (134217727 & 512) != 0 ? false : false, (134217727 & 1024) != 0 ? false : false, (134217727 & 2048) != 0 ? false : false, (134217727 & 4096) != 0 ? false : false, (134217727 & 8192) != 0 ? false : false, (134217727 & 16384) != 0 ? false : false, (134217727 & 32768) != 0 ? false : false, (134217727 & 65536) != 0 ? false : false, (134217727 & 131072) != 0 ? false : false, (134217727 & 262144) != 0 ? false : false, (134217727 & 524288) != 0 ? false : false, (134217727 & 1048576) != 0 ? false : false, (134217727 & 2097152) != 0 ? false : false, (134217727 & 4194304) != 0 ? false : false, (134217727 & 8388608) != 0 ? false : false, (134217727 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? false : false, (134217727 & 33554432) != 0 ? false : false, (134217727 & 67108864) != 0 ? false : false);
            return;
        }
        AbstractC17457n0 abstractC17457n0R = c5331Iw5.r();
        if (abstractC17457n0R != null) {
            k(aVar, abstractC17457n0R);
        }
        aVar.C((134217727 & 1) != 0 ? false : false, (134217727 & 2) != 0 ? false : aVar.e(), (134217727 & 4) != 0 ? false : false, (134217727 & 8) != 0 ? false : false, (134217727 & 16) != 0 ? false : false, (134217727 & 32) != 0 ? false : aVar.w(), (134217727 & 64) != 0 ? false : false, (134217727 & 128) != 0 ? false : false, (134217727 & 256) != 0 ? false : false, (134217727 & 512) != 0 ? false : false, (134217727 & 1024) != 0 ? false : aVar.s(), (134217727 & 2048) != 0 ? false : aVar.j(), (134217727 & 4096) != 0 ? false : aVar.v(), (134217727 & 8192) != 0 ? false : false, (134217727 & 16384) != 0 ? false : false, (134217727 & 32768) != 0 ? false : false, (134217727 & 65536) != 0 ? false : false, (134217727 & 131072) != 0 ? false : false, (134217727 & 262144) != 0 ? false : false, (134217727 & 524288) != 0 ? false : false, (134217727 & 1048576) != 0 ? false : false, (134217727 & 2097152) != 0 ? false : false, (134217727 & 4194304) != 0 ? false : false, (134217727 & 8388608) != 0 ? false : false, (134217727 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? false : false, (134217727 & 33554432) != 0 ? false : false, (134217727 & 67108864) != 0 ? false : false);
    }

    private final M44.a n(M44.a aVar, C8445Vz5 c8445Vz5) {
        if (c8445Vz5.E()) {
            aVar.N(false);
            if (!C8386Vt0.a.E6() && c8445Vz5.w() == 0) {
                aVar.R(false);
            }
            if (((Boolean) this.g.invoke(c8445Vz5)).booleanValue()) {
                aVar.R(false);
            }
        }
        return aVar;
    }

    private final void p(M44.a aVar) {
        if (this.a == 270066638) {
            aVar.R(false);
        }
    }

    protected boolean d(int i) {
        return i != this.b;
    }

    protected final IQ0 f() {
        return this.d;
    }

    protected final int g() {
        return this.b;
    }

    protected final SettingsModule h() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public M44.a a(J44 j44) {
        AbstractC13042fc3.i(j44, "input");
        M44.a aVar = new M44.a();
        o(aVar, j44);
        k(aVar, j44.F());
        j(aVar, j44.U());
        p(aVar);
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q != null) {
            n(aVar, c8445Vz5Q);
        }
        aVar.E(aVar.b() && this.f);
        return aVar;
    }

    protected void j(M44.a aVar, int i) {
        AbstractC13042fc3.i(aVar, "builder");
        IQ0 iq0 = this.d;
        if (iq0 instanceof IQ0.a.C0416a) {
            return;
        }
        boolean z = false;
        if (iq0 instanceof IQ0.a.b) {
            aVar.E(false);
            return;
        }
        if (!(iq0 instanceof IQ0.b.a)) {
            if (!(iq0 instanceof IQ0.b.C0417b)) {
                throw new NoWhenBranchMatchedException();
            }
            aVar.E(false);
        } else {
            if (aVar.b() && i != this.b) {
                z = true;
            }
            aVar.E(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected ir.nasim.M44.a k(ir.nasim.M44.a r5, ir.nasim.AbstractC17457n0 r6) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.N44.k(ir.nasim.M44$a, ir.nasim.n0):ir.nasim.M44$a");
    }

    protected M44.a o(M44.a aVar, J44 j44) {
        AbstractC13042fc3.i(aVar, "builder");
        AbstractC13042fc3.i(j44, "input");
        int i = a.a[j44.L().ordinal()];
        boolean z = false;
        if (i == 1 || i == 2) {
            aVar.H(true);
            aVar.K(true);
        } else if (i == 3 || i == 4) {
            aVar.H(true);
            aVar.S(true);
            aVar.O(true);
            aVar.W(this.a != this.b);
            aVar.K(MI7.a(j44.U(), this.d));
            aVar.N(this.c.I(j44.h()) && j44.U() == this.b);
            aVar.L(false);
            aVar.R(!C18252oL4.c());
            aVar.T(d(j44.U()));
        } else {
            aVar.H(true);
            aVar.K(true);
        }
        aVar.P(C8386Vt0.r9() && c(j44));
        if (C8386Vt0.r9() && e(j44)) {
            z = true;
        }
        aVar.Z(z);
        return aVar;
    }

    public /* synthetic */ N44(int i, int i2, SettingsModule settingsModule, IQ0 iq0, List list, boolean z, UA2 ua2, int i3, ED1 ed1) {
        this(i, i2, settingsModule, iq0, list, (i3 & 32) != 0 ? C8386Vt0.d4() : z, ua2);
    }
}
