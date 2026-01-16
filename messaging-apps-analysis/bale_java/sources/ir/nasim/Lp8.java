package ir.nasim;

import android.net.Uri;

/* loaded from: classes3.dex */
public final class Lp8 {
    final String a;
    final Uri b;
    final String c;
    final String d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;

    private Lp8(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, InterfaceC15006iq8 interfaceC15006iq8) {
        this.a = null;
        this.b = uri;
        this.c = "";
        this.d = "";
        this.e = z;
        this.f = false;
        this.g = z3;
        this.h = false;
    }

    public final Lp8 a() {
        return new Lp8(null, this.b, this.c, this.d, this.e, false, true, false, null);
    }

    public final Lp8 b() {
        if (this.c.isEmpty()) {
            return new Lp8(null, this.b, this.c, this.d, true, false, this.g, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final AbstractC11344cq8 c(String str, double d) {
        return new Hp8(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final AbstractC11344cq8 d(String str, long j) {
        return new Ep8(this, str, Long.valueOf(j), true);
    }

    public final AbstractC11344cq8 e(String str, String str2) {
        return new Ip8(this, str, str2, true);
    }

    public final AbstractC11344cq8 f(String str, boolean z) {
        return new Gp8(this, str, Boolean.valueOf(z), true);
    }

    public Lp8(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }
}
