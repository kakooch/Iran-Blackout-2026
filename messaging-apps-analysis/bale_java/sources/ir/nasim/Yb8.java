package ir.nasim;

import ir.nasim.C10441bc8;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class Yb8 extends AbstractC4248Ei {
    private final C10441bc8 a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    private Yb8(C10441bc8 c10441bc8, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c10441bc8;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }

    public static Yb8 a(C10441bc8.a aVar, C18469oi6 c18469oi6, Integer num) throws GeneralSecurityException {
        C10441bc8.a aVar2 = C10441bc8.a.d;
        if (aVar != aVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + aVar + " the value of idRequirement must be non-null");
        }
        if (aVar == aVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (c18469oi6.b() == 32) {
            C10441bc8 c10441bc8B = C10441bc8.b(aVar);
            return new Yb8(c10441bc8B, c18469oi6, b(c10441bc8B, num), num);
        }
        throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + c18469oi6.b());
    }

    private static C8575Wo0 b(C10441bc8 c10441bc8, Integer num) {
        if (c10441bc8.c() == C10441bc8.a.d) {
            return C8575Wo0.a(new byte[0]);
        }
        if (c10441bc8.c() == C10441bc8.a.c) {
            return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (c10441bc8.c() == C10441bc8.a.b) {
            return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown Variant: " + c10441bc8.c());
    }
}
