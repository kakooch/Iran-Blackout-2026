package ir.nasim.core.modules.banking;

import ir.nasim.C19231q00;
import ir.nasim.C8542Wk3;

/* loaded from: classes5.dex */
public class a {
    private String a;
    private String b;
    private String c;
    private String d;

    public a(String str, String str2, String str3, String str4) {
        this.a = str;
        this.c = str2;
        this.d = str3;
        this.b = str4;
    }

    public C8542Wk3 a() {
        return new C19231q00().f("cardNumber", this.a).f("pin2", this.d).f("cvv2", this.c).f("expireDate", this.b).l();
    }

    C8542Wk3 b() {
        return new C19231q00().f("pan", this.a).f("pin", this.d).f("cvv2", this.c).f("expireDate", this.b).l();
    }

    public String toString() {
        return a().toString();
    }
}
