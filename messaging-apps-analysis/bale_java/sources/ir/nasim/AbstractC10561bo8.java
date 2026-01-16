package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.bo8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10561bo8 {
    protected volatile int a = -1;

    public static final void c(AbstractC10561bo8 abstractC10561bo8, byte[] bArr, int i, int i2) {
        try {
            com.google.android.gms.internal.clearcut.w0 w0VarQ = com.google.android.gms.internal.clearcut.w0.q(bArr, 0, i2);
            abstractC10561bo8.b(w0VarQ);
            w0VarQ.n();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract void b(com.google.android.gms.internal.clearcut.w0 w0Var);

    public final int d() {
        int iE = e();
        this.a = iE;
        return iE;
    }

    protected abstract int e();

    public AbstractC10561bo8 f() {
        return (AbstractC10561bo8) super.clone();
    }

    public String toString() {
        return AbstractC22190uo8.a(this);
    }
}
