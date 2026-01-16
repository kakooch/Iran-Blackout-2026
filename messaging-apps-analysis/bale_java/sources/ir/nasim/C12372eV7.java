package ir.nasim;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;

/* renamed from: ir.nasim.eV7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12372eV7 implements InterfaceC2029g {
    public static final C12372eV7 e = new C12372eV7(0, 0);
    private static final String f = AbstractC9683aN7.r0(0);
    private static final String g = AbstractC9683aN7.r0(1);
    private static final String h = AbstractC9683aN7.r0(2);
    private static final String i = AbstractC9683aN7.r0(3);
    public static final InterfaceC2029g.a j = new InterfaceC2029g.a() { // from class: ir.nasim.dV7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C12372eV7.c(bundle);
        }
    };
    public final int a;
    public final int b;
    public final int c;
    public final float d;

    public C12372eV7(int i2, int i3) {
        this(i2, i3, 0, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C12372eV7 c(Bundle bundle) {
        return new C12372eV7(bundle.getInt(f, 0), bundle.getInt(g, 0), bundle.getInt(h, 0), bundle.getFloat(i, 1.0f));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(f, this.a);
        bundle.putInt(g, this.b);
        bundle.putInt(h, this.c);
        bundle.putFloat(i, this.d);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12372eV7)) {
            return false;
        }
        C12372eV7 c12372eV7 = (C12372eV7) obj;
        return this.a == c12372eV7.a && this.b == c12372eV7.b && this.c == c12372eV7.c && this.d == c12372eV7.d;
    }

    public int hashCode() {
        return ((((((217 + this.a) * 31) + this.b) * 31) + this.c) * 31) + Float.floatToRawIntBits(this.d);
    }

    public C12372eV7(int i2, int i3, int i4, float f2) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = f2;
    }
}
