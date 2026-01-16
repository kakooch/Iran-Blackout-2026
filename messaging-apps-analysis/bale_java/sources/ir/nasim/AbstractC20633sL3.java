package ir.nasim;

/* renamed from: ir.nasim.sL3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20633sL3 {
    private final int a;
    private final int b;

    protected AbstractC20633sL3(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i, byte[] bArr);

    public final int d() {
        return this.a;
    }

    public AbstractC20633sL3 e() {
        return new C14261hd3(this);
    }

    public boolean f() {
        return false;
    }

    public AbstractC20633sL3 g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.a;
        byte[] bArrC = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrC = c(i2, bArrC);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArrC[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
