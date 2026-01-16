package ir.nasim;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ir.nasim.mr3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17374mr3 implements InterfaceC3780Ci {
    private static final byte[] c = new byte[0];
    private static final Set d = e();
    private final C6691Oo3 a;
    private final InterfaceC3780Ci b;

    public C17374mr3(C6691Oo3 c6691Oo3, InterfaceC3780Ci interfaceC3780Ci) {
        if (d(c6691Oo3.X())) {
            this.a = c6691Oo3;
            this.b = interfaceC3780Ci;
        } else {
            throw new IllegalArgumentException("Unsupported DEK key type: " + c6691Oo3.X() + ". Only Tink AEAD key types are supported.");
        }
    }

    private byte[] c(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }

    public static boolean d(String str) {
        return d.contains(str);
    }

    private static Set e() {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrW = AbstractC24881zM5.g(this.a).Y().W();
        return c(this.b.a(bArrW, c), ((InterfaceC3780Ci) AbstractC24881zM5.f(this.a.X(), bArrW, InterfaceC3780Ci.class)).a(bArr, bArr2));
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((InterfaceC3780Ci) AbstractC24881zM5.f(this.a.X(), this.b.b(bArr3, c), InterfaceC3780Ci.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
