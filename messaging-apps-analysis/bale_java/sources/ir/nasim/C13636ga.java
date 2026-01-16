package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ga, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13636ga {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;
    private final SA2 e;
    private final SA2 f;
    private final SA2 g;
    private final SA2 h;
    private final InterfaceC15974kV0 i;

    public C13636ga(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, SA2 sa27, SA2 sa28, InterfaceC15974kV0 interfaceC15974kV0) {
        AbstractC13042fc3.i(sa2, "onCameraClick");
        AbstractC13042fc3.i(sa22, "onGalleryClick");
        AbstractC13042fc3.i(sa23, "onThoughtsClick");
        AbstractC13042fc3.i(sa24, "onTextStoryClick");
        AbstractC13042fc3.i(sa25, "onBackClicked");
        AbstractC13042fc3.i(sa26, "onStorySettingsClick");
        AbstractC13042fc3.i(sa27, "onGetFallClick");
        AbstractC13042fc3.i(sa28, "onCloseSuggestedListClick");
        AbstractC13042fc3.i(interfaceC15974kV0, "onSelectSuggestion");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
        this.d = sa24;
        this.e = sa25;
        this.f = sa26;
        this.g = sa27;
        this.h = sa28;
        this.i = interfaceC15974kV0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p() {
        return C19938rB7.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13636ga)) {
            return false;
        }
        C13636ga c13636ga = (C13636ga) obj;
        return AbstractC13042fc3.d(this.a, c13636ga.a) && AbstractC13042fc3.d(this.b, c13636ga.b) && AbstractC13042fc3.d(this.c, c13636ga.c) && AbstractC13042fc3.d(this.d, c13636ga.d) && AbstractC13042fc3.d(this.e, c13636ga.e) && AbstractC13042fc3.d(this.f, c13636ga.f) && AbstractC13042fc3.d(this.g, c13636ga.g) && AbstractC13042fc3.d(this.h, c13636ga.h) && AbstractC13042fc3.d(this.i, c13636ga.i);
    }

    public int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public final SA2 q() {
        return this.e;
    }

    public final SA2 r() {
        return this.a;
    }

    public final SA2 s() {
        return this.b;
    }

    public final SA2 t() {
        return this.g;
    }

    public String toString() {
        return "AddStoryUIEvents(onCameraClick=" + this.a + ", onGalleryClick=" + this.b + ", onThoughtsClick=" + this.c + ", onTextStoryClick=" + this.d + ", onBackClicked=" + this.e + ", onStorySettingsClick=" + this.f + ", onGetFallClick=" + this.g + ", onCloseSuggestedListClick=" + this.h + ", onSelectSuggestion=" + this.i + Separators.RPAREN;
    }

    public final InterfaceC15974kV0 u() {
        return this.i;
    }

    public final SA2 v() {
        return this.f;
    }

    public final SA2 w() {
        return this.d;
    }

    public final SA2 x() {
        return this.c;
    }

    public /* synthetic */ C13636ga(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, SA2 sa27, SA2 sa28, InterfaceC15974kV0 interfaceC15974kV0, int i, ED1 ed1) {
        this((i & 1) != 0 ? new SA2() { // from class: ir.nasim.Y9
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.i();
            }
        } : sa2, (i & 2) != 0 ? new SA2() { // from class: ir.nasim.Z9
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.j();
            }
        } : sa22, (i & 4) != 0 ? new SA2() { // from class: ir.nasim.aa
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.k();
            }
        } : sa23, (i & 8) != 0 ? new SA2() { // from class: ir.nasim.ba
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.l();
            }
        } : sa24, (i & 16) != 0 ? new SA2() { // from class: ir.nasim.ca
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.m();
            }
        } : sa25, (i & 32) != 0 ? new SA2() { // from class: ir.nasim.da
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.n();
            }
        } : sa26, (i & 64) != 0 ? new SA2() { // from class: ir.nasim.ea
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.o();
            }
        } : sa27, (i & 128) != 0 ? new SA2() { // from class: ir.nasim.fa
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13636ga.p();
            }
        } : sa28, interfaceC15974kV0);
    }
}
