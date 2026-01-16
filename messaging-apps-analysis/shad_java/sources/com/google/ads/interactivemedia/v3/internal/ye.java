package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ye implements abx {
    private final abx a;
    private final byte[] b;
    private final byte[] c;
    private CipherInputStream d;

    public ye(abx abxVar, byte[] bArr, byte[] bArr2) {
        this.a = abxVar;
        this.b = bArr;
        this.c = bArr2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        ary.t(this.d);
        int i3 = this.d.read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void b(adh adhVar) {
        ary.t(adhVar);
        this.a.b(adhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                abz abzVar = new abz(this.a, acbVar);
                this.d = new CipherInputStream(abzVar, cipher);
                abzVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.a.d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Map<String, List<String>> e() {
        return this.a.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws IOException {
        if (this.d != null) {
            this.d = null;
            this.a.f();
        }
    }
}
