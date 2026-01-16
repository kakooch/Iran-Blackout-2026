package ir.nasim.core.modules.banking;

import ir.nasim.C13466gH0;
import ir.nasim.XY6;

/* loaded from: classes5.dex */
public class m extends l {
    private final String d;
    private final String e;
    private final String f;

    m(C13466gH0 c13466gH0) {
        super(c13466gH0);
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public static m k(l lVar, String str, String str2, String str3) {
        return new m(lVar, XY6.h(str), XY6.h(str2), XY6.h(str3));
    }

    String l() {
        return this.d;
    }

    String m() {
        return this.e + this.f;
    }

    private m(l lVar, String str, String str2, String str3) {
        super(lVar);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }
}
