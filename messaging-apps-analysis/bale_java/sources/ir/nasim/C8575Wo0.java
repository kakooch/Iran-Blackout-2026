package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.Wo0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8575Wo0 {
    private final byte[] a;

    private C8575Wo0(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.a = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public static C8575Wo0 a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static C8575Wo0 b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        return new C8575Wo0(bArr, i, i2);
    }

    public int c() {
        return this.a.length;
    }

    public byte[] d() {
        byte[] bArr = this.a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C8575Wo0) {
            return Arrays.equals(((C8575Wo0) obj).a, this.a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        return "Bytes(" + AbstractC21999uV2.b(this.a) + Separators.RPAREN;
    }
}
