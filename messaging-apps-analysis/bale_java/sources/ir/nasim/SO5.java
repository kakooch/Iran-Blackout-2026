package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class SO5 {
    private final UA2 a;
    private final UA2 b;
    private final UA2 c;
    private final InterfaceC14603iB2 d;
    private final InterfaceC14603iB2 e;
    private final UA2 f;

    public SO5(UA2 ua2, UA2 ua22, UA2 ua23, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, UA2 ua24) {
        AbstractC13042fc3.i(ua2, "sendMessage");
        AbstractC13042fc3.i(ua22, "sendContact");
        AbstractC13042fc3.i(ua23, "sendLocation");
        AbstractC13042fc3.i(interfaceC14603iB2, "openWebApp");
        AbstractC13042fc3.i(interfaceC14603iB22, "customAction");
        AbstractC13042fc3.i(ua24, "unsupportedAction");
        this.a = ua2;
        this.b = ua22;
        this.c = ua23;
        this.d = interfaceC14603iB2;
        this.e = interfaceC14603iB22;
        this.f = ua24;
    }

    public final InterfaceC14603iB2 a() {
        return this.e;
    }

    public final InterfaceC14603iB2 b() {
        return this.d;
    }

    public final UA2 c() {
        return this.b;
    }

    public final UA2 d() {
        return this.c;
    }

    public final UA2 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SO5)) {
            return false;
        }
        SO5 so5 = (SO5) obj;
        return AbstractC13042fc3.d(this.a, so5.a) && AbstractC13042fc3.d(this.b, so5.b) && AbstractC13042fc3.d(this.c, so5.c) && AbstractC13042fc3.d(this.d, so5.d) && AbstractC13042fc3.d(this.e, so5.e) && AbstractC13042fc3.d(this.f, so5.f);
    }

    public final UA2 f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "ReplyKeyboardCallback(sendMessage=" + this.a + ", sendContact=" + this.b + ", sendLocation=" + this.c + ", openWebApp=" + this.d + ", customAction=" + this.e + ", unsupportedAction=" + this.f + Separators.RPAREN;
    }
}
