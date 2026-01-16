package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BX0 implements InterfaceC2029g {
    public static final BX0 f = new BX0(1, 2, 3, null);
    private static final String g = AbstractC9683aN7.r0(0);
    private static final String h = AbstractC9683aN7.r0(1);
    private static final String i = AbstractC9683aN7.r0(2);
    private static final String j = AbstractC9683aN7.r0(3);
    public static final InterfaceC2029g.a k = new InterfaceC2029g.a() { // from class: ir.nasim.AX0
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return BX0.e(bundle);
        }
    };
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    private int e;

    public BX0(int i2, int i3, int i4, byte[] bArr) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = bArr;
    }

    public static int c(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int d(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BX0 e(Bundle bundle) {
        return new BX0(bundle.getInt(g, -1), bundle.getInt(h, -1), bundle.getInt(i, -1), bundle.getByteArray(j));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(g, this.a);
        bundle.putInt(h, this.b);
        bundle.putInt(i, this.c);
        bundle.putByteArray(j, this.d);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BX0.class != obj.getClass()) {
            return false;
        }
        BX0 bx0 = (BX0) obj;
        return this.a == bx0.a && this.b == bx0.b && this.c == bx0.c && Arrays.equals(this.d, bx0.d);
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }
}
