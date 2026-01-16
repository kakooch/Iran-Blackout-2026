package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C22289uz1;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
class Aes128DataSource implements com.google.android.exoplayer2.upstream.a {
    private final com.google.android.exoplayer2.upstream.a a;
    private final byte[] b;
    private final byte[] c;
    private CipherInputStream d;

    public Aes128DataSource(com.google.android.exoplayer2.upstream.a aVar, byte[] bArr, byte[] bArr2) {
        this.a = aVar;
        this.b = bArr;
        this.c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final long b(com.google.android.exoplayer2.upstream.b bVar) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipherN = n();
            try {
                cipherN.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                C22289uz1 c22289uz1 = new C22289uz1(this.a, bVar);
                this.d = new CipherInputStream(c22289uz1, cipherN);
                c22289uz1.b();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.d != null) {
            this.d = null;
            this.a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final Map d() {
        return this.a.d();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void i(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC20011rK.e(interfaceC25209zu7);
        this.a.i(interfaceC25209zu7);
    }

    protected Cipher n() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        AbstractC20011rK.e(this.d);
        int i3 = this.d.read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }
}
