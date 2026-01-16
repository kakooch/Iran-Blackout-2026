package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Lq7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC5981Lq7 {
    public static AbstractC20124rW4 a(byte[] bArr) throws GeneralSecurityException {
        try {
            return com.google.crypto.tink.internal.b.c().i(C22275ux5.b(C6691Oo3.a0(bArr, C2352n.b())));
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] b(AbstractC20124rW4 abstractC20124rW4) {
        return abstractC20124rW4 instanceof C6282My3 ? ((C6282My3) abstractC20124rW4).b().d().f() : ((C22275ux5) com.google.crypto.tink.internal.b.c().n(abstractC20124rW4, C22275ux5.class)).d().f();
    }
}
