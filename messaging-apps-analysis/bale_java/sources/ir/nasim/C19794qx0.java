package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qx0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19794qx0 {
    private final String a;
    private final InterfaceC10258bL6 b;
    private final InterfaceC10258bL6 c;
    private final InterfaceC10258bL6 d;
    private final InterfaceC10258bL6 e;
    private final InterfaceC10258bL6 f;

    public C19794qx0(String str, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, InterfaceC10258bL6 interfaceC10258bL63, InterfaceC10258bL6 interfaceC10258bL64, InterfaceC10258bL6 interfaceC10258bL65) {
        AbstractC13042fc3.i(str, "configs");
        AbstractC13042fc3.i(interfaceC10258bL6, "callState");
        AbstractC13042fc3.i(interfaceC10258bL62, "outBoundAudioTracks");
        AbstractC13042fc3.i(interfaceC10258bL63, "outBoundVideoTracks");
        AbstractC13042fc3.i(interfaceC10258bL64, "inBoundAudioTracks");
        AbstractC13042fc3.i(interfaceC10258bL65, "inBoundVideoTracks");
        this.a = str;
        this.b = interfaceC10258bL6;
        this.c = interfaceC10258bL62;
        this.d = interfaceC10258bL63;
        this.e = interfaceC10258bL64;
        this.f = interfaceC10258bL65;
    }

    public final InterfaceC10258bL6 a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final InterfaceC10258bL6 c() {
        return this.e;
    }

    public final InterfaceC10258bL6 d() {
        return this.f;
    }

    public final InterfaceC10258bL6 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19794qx0)) {
            return false;
        }
        C19794qx0 c19794qx0 = (C19794qx0) obj;
        return AbstractC13042fc3.d(this.a, c19794qx0.a) && AbstractC13042fc3.d(this.b, c19794qx0.b) && AbstractC13042fc3.d(this.c, c19794qx0.c) && AbstractC13042fc3.d(this.d, c19794qx0.d) && AbstractC13042fc3.d(this.e, c19794qx0.e) && AbstractC13042fc3.d(this.f, c19794qx0.f);
    }

    public final InterfaceC10258bL6 f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "CallMonitoringState(configs=" + this.a + ", callState=" + this.b + ", outBoundAudioTracks=" + this.c + ", outBoundVideoTracks=" + this.d + ", inBoundAudioTracks=" + this.e + ", inBoundVideoTracks=" + this.f + Separators.RPAREN;
    }
}
