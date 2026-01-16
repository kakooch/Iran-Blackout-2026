package ir.nasim;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class X72 {
    private final C11515d82 a;
    private final byte[] b;

    public X72(C11515d82 c11515d82, byte[] bArr) {
        if (c11515d82 == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.a = c11515d82;
        this.b = bArr;
    }

    public byte[] a() {
        return this.b;
    }

    public C11515d82 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X72)) {
            return false;
        }
        X72 x72 = (X72) obj;
        if (this.a.equals(x72.a)) {
            return Arrays.equals(this.b, x72.b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}
