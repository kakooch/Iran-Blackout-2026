package ir.nasim;

import ir.nasim.M44;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class AM2 extends N44 {
    private final C14733iO2 h;
    private final ZN2 i;
    private final List j;
    private final boolean k;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23558x74.values().length];
            try {
                iArr[EnumC23558x74.SENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23558x74.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AM2(int i, int i2, SettingsModule settingsModule, C14733iO2 c14733iO2, ZN2 zn2, List list, IQ0 iq0, boolean z, UA2 ua2) {
        super(i, i2, settingsModule, iq0, list, false, ua2, 32, null);
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        AbstractC13042fc3.i(zn2, "groupType");
        AbstractC13042fc3.i(list, "pinnedMessages");
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(ua2, "isForwardedFromAnotherChannel");
        this.h = c14733iO2;
        this.i = zn2;
        this.j = list;
        this.k = z;
    }

    private final boolean c(J44 j44) {
        if (!this.k && (this.h.x() == g() || FM2.a.j(this.h).k())) {
            List<J44> list = this.j;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (J44 j442 : list) {
                arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
            }
            if (!arrayList.contains(AbstractC4616Fw7.a(Long.valueOf(j44.i()), Long.valueOf(j44.h())))) {
                return true;
            }
        }
        return false;
    }

    private final boolean e(J44 j44) {
        if (!this.k && (this.h.x() == g() || FM2.a.j(this.h).k())) {
            List<J44> list = this.j;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (J44 j442 : list) {
                arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
            }
            if (arrayList.contains(AbstractC4616Fw7.a(Long.valueOf(j44.i()), Long.valueOf(j44.h())))) {
                return true;
            }
        }
        return false;
    }

    private final boolean q() {
        return this.i == ZN2.CHANNEL && this.h.E().b() == W06.PUBLIC;
    }

    private final boolean s(int i) {
        C23104wM2 c23104wM2;
        if (this.i != ZN2.GROUP) {
            return false;
        }
        if (this.h.x() != g()) {
            C19482qQ7 c19482qQ7S = this.h.s();
            if (!((c19482qQ7S == null || (c23104wM2 = (C23104wM2) c19482qQ7S.b()) == null) ? false : c23104wM2.j()) || i == g() || i == this.h.x()) {
                return false;
            }
        } else if (i == g()) {
            return false;
        }
        return true;
    }

    private final boolean t(long j, int i) {
        if (h().I(j)) {
            return this.h.p() == ExPeerType.CHANNEL ? FM2.a.j(this.h).h() : i == g();
        }
        return false;
    }

    private final boolean u(C17532n74 c17532n74) {
        return this.i == ZN2.GROUP && c17532n74 != null && c17532n74.E() > 0;
    }

    private final boolean v(J44 j44) {
        C8445Vz5 c8445Vz5Q;
        C8445Vz5 c8445Vz5Q2;
        C8445Vz5 c8445Vz5Q3 = j44.Q();
        if (c8445Vz5Q3 == null || c8445Vz5Q3.z() != g() || (c8445Vz5Q2 = j44.Q()) == null || !c8445Vz5Q2.E()) {
            return j44.U() == g() && ((c8445Vz5Q = j44.Q()) == null || !c8445Vz5Q.E());
        }
        return true;
    }

    private final boolean w() {
        return GM2.a(this.h, this.k);
    }

    private final boolean x() {
        C23104wM2 c23104wM2;
        if (this.i == ZN2.CHANNEL) {
            if (this.h.x() == g()) {
                return true;
            }
            C19482qQ7 c19482qQ7S = this.h.s();
            if (c19482qQ7S != null && (c23104wM2 = (C23104wM2) c19482qQ7S.b()) != null && c23104wM2.j()) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.N44
    protected boolean d(int i) {
        return super.d(i) && !x();
    }

    @Override // ir.nasim.N44, ir.nasim.InterfaceC14123hO3
    /* renamed from: i */
    public M44.a a(J44 j44) {
        AbstractC13042fc3.i(j44, "input");
        M44.a aVarA = super.a(j44);
        aVarA.E(aVarA.b() && q());
        return aVarA;
    }

    @Override // ir.nasim.N44
    protected M44.a o(M44.a aVar, J44 j44) {
        AbstractC13042fc3.i(aVar, "builder");
        AbstractC13042fc3.i(j44, "input");
        super.o(aVar, j44);
        int i = a.a[j44.L().ordinal()];
        if (i == 1 || i == 2) {
            aVar.S(w());
            aVar.K(MI7.a(j44.U(), f()));
            aVar.N(t(j44.h(), j44.U()));
            aVar.P(c(j44));
            aVar.Z(e(j44));
            aVar.I(r());
            aVar.L(s(j44.U()));
            aVar.G(u(j44.T()));
            aVar.Q(v(j44));
        }
        return aVar;
    }

    protected boolean r() {
        return this.h.q() == ZN2.CHANNEL;
    }
}
