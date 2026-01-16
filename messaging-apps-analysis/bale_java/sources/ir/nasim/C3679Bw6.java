package ir.nasim;

import java.security.MessageDigest;
import java.util.Arrays;

/* renamed from: ir.nasim.Bw6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3679Bw6 extends AbstractC16262ky5 {
    protected C3679Bw6(String str) {
        super(str);
        if (AbstractC17827nd5.c == null) {
            throw new IllegalStateException("Can not create sha256 pins");
        }
    }

    @Override // ir.nasim.AbstractC16262ky5
    protected boolean c(byte[] bArr) {
        byte[] bArrDigest;
        MessageDigest messageDigest = AbstractC17827nd5.c;
        synchronized (messageDigest) {
            bArrDigest = messageDigest.digest(bArr);
        }
        return Arrays.equals(this.a, bArrDigest);
    }
}
