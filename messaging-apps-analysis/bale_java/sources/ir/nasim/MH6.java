package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
final class MH6 {
    private final String a;
    private final String b;
    private final int c;
    private final List d;
    private final int e;
    private final List f;
    private final boolean g;
    private final boolean h;
    private int i;

    public MH6(String str, String str2, int i, List list, int i2, List list2, boolean z, boolean z2) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = list;
        this.e = i2;
        this.f = list2;
        this.g = z;
        this.h = z2;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final List c() {
        return this.f;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.g;
    }

    public final boolean f() {
        return this.h;
    }

    public final TH6 g() {
        int i;
        if (this.i >= this.d.size() && (i = this.e) >= 0) {
            this.i = i;
        }
        if (this.i >= this.d.size()) {
            return null;
        }
        List list = this.d;
        int i2 = this.i;
        this.i = i2 + 1;
        VH6 vh6 = (VH6) list.get(i2);
        Integer numB = vh6.b();
        int iIntValue = numB != null ? numB.intValue() : -1;
        Integer numC = vh6.c();
        int iIntValue2 = numC != null ? numC.intValue() : -1;
        Integer numA = vh6.a();
        return new TH6(iIntValue, iIntValue2, numA != null ? numA.intValue() : -1, this.b, this.c);
    }
}
