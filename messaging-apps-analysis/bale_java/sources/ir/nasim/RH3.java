package ir.nasim;

import android.net.Uri;

/* loaded from: classes5.dex */
public final class RH3 {
    private final double a;
    private final double b;
    private final String c;
    private final String d;

    public RH3(double d, double d2, String str, String str2) {
        AbstractC13042fc3.i(str, "locationUrl");
        AbstractC13042fc3.i(str2, "fileName");
        this.a = d;
        this.b = d2;
        this.c = str;
        this.d = str2;
    }

    public final Uri a() {
        String str = this.a + "," + this.b;
        return Uri.parse("geo:" + str + "?q=" + str);
    }

    public final String b() {
        return this.c;
    }
}
