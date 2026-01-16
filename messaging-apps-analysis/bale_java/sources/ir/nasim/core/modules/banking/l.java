package ir.nasim.core.modules.banking;

import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20471s40;
import ir.nasim.C13466gH0;
import ir.nasim.XY6;
import ir.nasim.Y50;

/* loaded from: classes5.dex */
public class l extends AbstractC20471s40 {
    private final C13466gH0 a;
    private final String b;
    private final boolean c;

    l(C13466gH0 c13466gH0) {
        this.a = c13466gH0;
        this.b = null;
        this.c = c13466gH0.z();
    }

    public static l a(String str) {
        String strH = XY6.h(str);
        if (AbstractC19902r80.d(strH) != Y50.d) {
            return new l(strH);
        }
        return null;
    }

    public static l b(String str, boolean z) {
        String strH = XY6.h(str);
        if (AbstractC19902r80.d(strH) != Y50.d) {
            return new l(strH, z);
        }
        return null;
    }

    public String c() {
        return XY6.e(XY6.a(g().replace(":", "xxxxxx"), (char) 8192));
    }

    public Y50 d() {
        C13466gH0 c13466gH0 = this.a;
        return c13466gH0 == null ? new C13466gH0(this.b).r() : c13466gH0.r();
    }

    public C13466gH0 e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        C13466gH0 c13466gH0 = this.a;
        return c13466gH0 == null ? new C13466gH0(this.b).getName() : c13466gH0.getName();
    }

    public String h() {
        C13466gH0 c13466gH0 = this.a;
        return c13466gH0 == null ? new C13466gH0(this.b).u() : c13466gH0.u();
    }

    public String i() {
        C13466gH0 c13466gH0 = this.a;
        return c13466gH0 != null ? c13466gH0.y() : "";
    }

    public boolean j() {
        return this.c;
    }

    l(String str) {
        this(str, false);
    }

    l(String str, boolean z) {
        this.b = str;
        this.a = null;
        this.c = z;
    }

    l(l lVar) {
        this.a = lVar.a;
        this.b = lVar.b;
        this.c = lVar.c;
    }
}
