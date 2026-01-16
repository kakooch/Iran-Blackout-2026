package ir.nasim;

import ir.nasim.C8786Xi;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Ti, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7816Ti extends AbstractC4248Ei {
    private final C8786Xi a;
    private final C18469oi6 b;
    private final C18469oi6 c;
    private final C8575Wo0 d;
    private final Integer e;

    /* renamed from: ir.nasim.Ti$b */
    public static class b {
        private C8786Xi a;
        private C18469oi6 b;
        private C18469oi6 c;
        private Integer d;

        private C8575Wo0 b() {
            if (this.a.h() == C8786Xi.d.d) {
                return C8575Wo0.a(new byte[0]);
            }
            if (this.a.h() == C8786Xi.d.c) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.d.intValue()).array());
            }
            if (this.a.h() == C8786Xi.d.b) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.d.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + this.a.h());
        }

        public C7816Ti a() throws GeneralSecurityException {
            C8786Xi c8786Xi = this.a;
            if (c8786Xi == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (this.b == null || this.c == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            }
            if (c8786Xi.c() != this.b.b()) {
                throw new GeneralSecurityException("AES key size mismatch");
            }
            if (this.a.e() != this.c.b()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            }
            if (this.a.a() && this.d == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.a.a() && this.d != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C7816Ti(this.a, this.b, this.c, b(), this.d);
        }

        public b c(C18469oi6 c18469oi6) {
            this.b = c18469oi6;
            return this;
        }

        public b d(C18469oi6 c18469oi6) {
            this.c = c18469oi6;
            return this;
        }

        public b e(Integer num) {
            this.d = num;
            return this;
        }

        public b f(C8786Xi c8786Xi) {
            this.a = c8786Xi;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public static b a() {
        return new b();
    }

    private C7816Ti(C8786Xi c8786Xi, C18469oi6 c18469oi6, C18469oi6 c18469oi62, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c8786Xi;
        this.b = c18469oi6;
        this.c = c18469oi62;
        this.d = c8575Wo0;
        this.e = num;
    }
}
