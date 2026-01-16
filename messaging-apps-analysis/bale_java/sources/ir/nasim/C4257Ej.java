package ir.nasim;

import ir.nasim.C5208Ij;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Ej, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4257Ej extends AbstractC4248Ei {
    private final C5208Ij a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    /* renamed from: ir.nasim.Ej$b */
    public static class b {
        private C5208Ij a;
        private C18469oi6 b;
        private Integer c;

        private C8575Wo0 b() {
            if (this.a.d() == C5208Ij.c.d) {
                return C8575Wo0.a(new byte[0]);
            }
            if (this.a.d() == C5208Ij.c.c) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.c.intValue()).array());
            }
            if (this.a.d() == C5208Ij.c.b) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.c.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + this.a.d());
        }

        public C4257Ej a() throws GeneralSecurityException {
            C5208Ij c5208Ij = this.a;
            if (c5208Ij == null || this.b == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (c5208Ij.c() != this.b.b()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.a.a() && this.c == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.a.a() && this.c != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C4257Ej(this.a, this.b, b(), this.c);
        }

        public b c(Integer num) {
            this.c = num;
            return this;
        }

        public b d(C18469oi6 c18469oi6) {
            this.b = c18469oi6;
            return this;
        }

        public b e(C5208Ij c5208Ij) {
            this.a = c5208Ij;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }

    public static b a() {
        return new b();
    }

    private C4257Ej(C5208Ij c5208Ij, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c5208Ij;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }
}
