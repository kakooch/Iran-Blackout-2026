package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.vM, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22505vM {
    private final EnumC21915uM a;
    private final InterfaceC10876cM b;
    private final EnumC20638sM c;

    public C22505vM(EnumC21915uM enumC21915uM, InterfaceC10876cM interfaceC10876cM, EnumC20638sM enumC20638sM) {
        AbstractC13042fc3.i(enumC21915uM, "speed");
        AbstractC13042fc3.i(interfaceC10876cM, "content");
        AbstractC13042fc3.i(enumC20638sM, "playbackState");
        this.a = enumC21915uM;
        this.b = interfaceC10876cM;
        this.c = enumC20638sM;
    }

    public static /* synthetic */ C22505vM b(C22505vM c22505vM, EnumC21915uM enumC21915uM, InterfaceC10876cM interfaceC10876cM, EnumC20638sM enumC20638sM, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC21915uM = c22505vM.a;
        }
        if ((i & 2) != 0) {
            interfaceC10876cM = c22505vM.b;
        }
        if ((i & 4) != 0) {
            enumC20638sM = c22505vM.c;
        }
        return c22505vM.a(enumC21915uM, interfaceC10876cM, enumC20638sM);
    }

    public final C22505vM a(EnumC21915uM enumC21915uM, InterfaceC10876cM interfaceC10876cM, EnumC20638sM enumC20638sM) {
        AbstractC13042fc3.i(enumC21915uM, "speed");
        AbstractC13042fc3.i(interfaceC10876cM, "content");
        AbstractC13042fc3.i(enumC20638sM, "playbackState");
        return new C22505vM(enumC21915uM, interfaceC10876cM, enumC20638sM);
    }

    public final InterfaceC10876cM c() {
        return this.b;
    }

    public final EnumC20638sM d() {
        return this.c;
    }

    public final EnumC21915uM e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22505vM)) {
            return false;
        }
        C22505vM c22505vM = (C22505vM) obj;
        return this.a == c22505vM.a && AbstractC13042fc3.d(this.b, c22505vM.b) && this.c == c22505vM.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AudioBarState(speed=" + this.a + ", content=" + this.b + ", playbackState=" + this.c + Separators.RPAREN;
    }
}
