package ir.nasim;

import ir.nasim.C24497yj;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.uj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22131uj extends AbstractC4248Ei {
    private final C24497yj a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    /* renamed from: ir.nasim.uj$b */
    public static class b {
        private C24497yj a;
        private C18469oi6 b;
        private Integer c;

        private C8575Wo0 b() {
            if (this.a.f() == C24497yj.c.d) {
                return C8575Wo0.a(new byte[0]);
            }
            if (this.a.f() == C24497yj.c.c) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.c.intValue()).array());
            }
            if (this.a.f() == C24497yj.c.b) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.c.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + this.a.f());
        }

        public C22131uj a() throws GeneralSecurityException {
            C24497yj c24497yj = this.a;
            if (c24497yj == null || this.b == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (c24497yj.d() != this.b.b()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.a.a() && this.c == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.a.a() && this.c != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C22131uj(this.a, this.b, b(), this.c);
        }

        public b c(Integer num) {
            this.c = num;
            return this;
        }

        public b d(C18469oi6 c18469oi6) {
            this.b = c18469oi6;
            return this;
        }

        public b e(C24497yj c24497yj) {
            this.a = c24497yj;
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

    private C22131uj(C24497yj c24497yj, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c24497yj;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }
}
