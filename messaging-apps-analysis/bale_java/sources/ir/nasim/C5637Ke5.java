package ir.nasim;

import java.security.PublicKey;
import java.util.Arrays;

/* renamed from: ir.nasim.Ke5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5637Ke5 extends AbstractC16262ky5 {
    private final PublicKey d;

    protected C5637Ke5(String str) {
        super(str);
        this.d = Ub8.b(this.a);
    }

    @Override // ir.nasim.AbstractC16262ky5
    protected boolean c(byte[] bArr) {
        return Arrays.equals(this.a, bArr);
    }
}
