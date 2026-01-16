package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import okhttp3.Headers;

/* loaded from: classes2.dex */
public final class IL4 {
    private final Context a;
    private final Bitmap.Config b;
    private final ColorSpace c;
    private final PD6 d;
    private final EnumC14254hc6 e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final String i;
    private final Headers j;
    private final C16116kj7 k;
    private final C19533qW4 l;
    private final EnumC16760lp0 m;
    private final EnumC16760lp0 n;
    private final EnumC16760lp0 o;

    public IL4(Context context, Bitmap.Config config, ColorSpace colorSpace, PD6 pd6, EnumC14254hc6 enumC14254hc6, boolean z, boolean z2, boolean z3, String str, Headers headers, C16116kj7 c16116kj7, C19533qW4 c19533qW4, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03) {
        this.a = context;
        this.b = config;
        this.c = colorSpace;
        this.d = pd6;
        this.e = enumC14254hc6;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = str;
        this.j = headers;
        this.k = c16116kj7;
        this.l = c19533qW4;
        this.m = enumC16760lp0;
        this.n = enumC16760lp02;
        this.o = enumC16760lp03;
    }

    public final IL4 a(Context context, Bitmap.Config config, ColorSpace colorSpace, PD6 pd6, EnumC14254hc6 enumC14254hc6, boolean z, boolean z2, boolean z3, String str, Headers headers, C16116kj7 c16116kj7, C19533qW4 c19533qW4, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03) {
        return new IL4(context, config, colorSpace, pd6, enumC14254hc6, z, z2, z3, str, headers, c16116kj7, c19533qW4, enumC16760lp0, enumC16760lp02, enumC16760lp03);
    }

    public final boolean c() {
        return this.f;
    }

    public final boolean d() {
        return this.g;
    }

    public final ColorSpace e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IL4) {
            IL4 il4 = (IL4) obj;
            if (AbstractC13042fc3.d(this.a, il4.a) && this.b == il4.b && ((Build.VERSION.SDK_INT < 26 || AbstractC13042fc3.d(this.c, il4.c)) && AbstractC13042fc3.d(this.d, il4.d) && this.e == il4.e && this.f == il4.f && this.g == il4.g && this.h == il4.h && AbstractC13042fc3.d(this.i, il4.i) && AbstractC13042fc3.d(this.j, il4.j) && AbstractC13042fc3.d(this.k, il4.k) && AbstractC13042fc3.d(this.l, il4.l) && this.m == il4.m && this.n == il4.n && this.o == il4.o)) {
                return true;
            }
        }
        return false;
    }

    public final Bitmap.Config f() {
        return this.b;
    }

    public final Context g() {
        return this.a;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        ColorSpace colorSpace = this.c;
        int iHashCode2 = (((((((((((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31;
        String str = this.i;
        return ((((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode();
    }

    public final EnumC16760lp0 i() {
        return this.n;
    }

    public final Headers j() {
        return this.j;
    }

    public final EnumC16760lp0 k() {
        return this.o;
    }

    public final C19533qW4 l() {
        return this.l;
    }

    public final boolean m() {
        return this.h;
    }

    public final EnumC14254hc6 n() {
        return this.e;
    }

    public final PD6 o() {
        return this.d;
    }

    public final C16116kj7 p() {
        return this.k;
    }
}
