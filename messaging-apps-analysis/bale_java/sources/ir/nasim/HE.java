package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes.dex */
public final class HE extends VW7 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final String b;
    private final SettingsModule c;
    private final C6409Nm d;
    private final androidx.lifecycle.y e;
    private final InterfaceC9336Zm4 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ZR3.values().length];
            try {
                iArr[ZR3.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZR3.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public HE(String str, SettingsModule settingsModule, C6409Nm c6409Nm, androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(str, "flavour");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = str;
        this.c = settingsModule;
        this.d = c6409Nm;
        this.e = yVar;
        this.f = AbstractC12281eL6.a(new GE(false, null, false, 7, null));
        R0();
    }

    private final void R0() {
        if (C8386Vt0.a.ya() && this.c.F5()) {
            S0();
        } else {
            Z0();
        }
    }

    private final void Z0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, GE.b((GE) value, true, null, false, 6, null)));
    }

    public final void P0() {
        Y0(6);
        S0();
    }

    public final void S0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, GE.b((GE) value, false, null, true, 3, null)));
    }

    public final InterfaceC10258bL6 T0() {
        return this.f;
    }

    public final void U0(boolean z) {
        this.c.g7(z);
    }

    public final void V0(ZR3 zr3) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(zr3, "marketPlaceState");
        int i = b.a[zr3.ordinal()];
        if (i == 1) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, GE.b((GE) value, false, ZR3.d, false, 5, null)));
        } else {
            if (i != 2) {
                P0();
                return;
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.f;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, GE.b((GE) value2, false, ZR3.e, false, 5, null)));
        }
    }

    public final void W0() {
        Object value;
        Object value2;
        Object value3;
        if (AbstractC20762sZ6.X(this.b, "bazaar", false, 2, null)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
            do {
                value3 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value3, GE.b((GE) value3, false, ZR3.b, false, 5, null)));
        } else if (AbstractC20762sZ6.X(this.b, "myket", false, 2, null) || AbstractC20762sZ6.X(this.b, "bale", false, 2, null)) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.f;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, GE.b((GE) value, false, ZR3.c, false, 5, null)));
        } else {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.f;
            do {
                value2 = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value2, GE.b((GE) value2, false, ZR3.d, false, 5, null)));
        }
    }

    public final void X0(ZR3 zr3) {
        AbstractC13042fc3.i(zr3, "marketPlaceState");
        Y0(zr3.j());
        S0();
    }

    public final void Y0(int i) {
        Integer num = (Integer) this.e.c("peer_id");
        this.d.d("Review_bot", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(num != null ? num.intValue() : 0)), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("event_type", Integer.valueOf(i))));
    }
}
