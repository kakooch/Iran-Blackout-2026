package ir.nasim;

import ir.nasim.XH0;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class UH0 extends AbstractC4248Ei {
    private final XH0 a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    private UH0(XH0 xh0, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = xh0;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }

    public static UH0 a(XH0.a aVar, C18469oi6 c18469oi6, Integer num) throws GeneralSecurityException {
        XH0.a aVar2 = XH0.a.d;
        if (aVar != aVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + aVar + " the value of idRequirement must be non-null");
        }
        if (aVar == aVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (c18469oi6.b() == 32) {
            XH0 xh0B = XH0.b(aVar);
            return new UH0(xh0B, c18469oi6, b(xh0B, num), num);
        }
        throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + c18469oi6.b());
    }

    private static C8575Wo0 b(XH0 xh0, Integer num) {
        if (xh0.c() == XH0.a.d) {
            return C8575Wo0.a(new byte[0]);
        }
        if (xh0.c() == XH0.a.c) {
            return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (xh0.c() == XH0.a.b) {
            return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown Variant: " + xh0.c());
    }
}
