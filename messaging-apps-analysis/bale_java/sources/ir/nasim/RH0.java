package ir.nasim;

import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class RH0 extends PH0 {
    protected RH0(String str) {
        super(str);
    }

    @Override // ir.nasim.PH0
    protected boolean c(byte[] bArr) {
        byte[] bArrDigest;
        MessageDigest messageDigest = AbstractC17827nd5.c;
        synchronized (messageDigest) {
            bArrDigest = messageDigest.digest(bArr);
        }
        return Arrays.equals(this.a, bArrDigest);
    }
}
