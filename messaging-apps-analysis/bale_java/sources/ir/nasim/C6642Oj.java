package ir.nasim;

import ir.nasim.C7588Sj;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Oj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6642Oj extends IJ1 {
    private final C7588Sj a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    /* renamed from: ir.nasim.Oj$b */
    public static class b {
        private C7588Sj a;
        private C18469oi6 b;
        private Integer c;

        private C8575Wo0 b() {
            if (this.a.d() == C7588Sj.c.d) {
                return C8575Wo0.a(new byte[0]);
            }
            if (this.a.d() == C7588Sj.c.c) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.c.intValue()).array());
            }
            if (this.a.d() == C7588Sj.c.b) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.c.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesSivParameters.Variant: " + this.a.d());
        }

        public C6642Oj a() throws GeneralSecurityException {
            C7588Sj c7588Sj = this.a;
            if (c7588Sj == null || this.b == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            }
            if (c7588Sj.c() != this.b.b()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.a.a() && this.c == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.a.a() && this.c != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C6642Oj(this.a, this.b, b(), this.c);
        }

        public b c(Integer num) {
            this.c = num;
            return this;
        }

        public b d(C18469oi6 c18469oi6) {
            this.b = c18469oi6;
            return this;
        }

        public b e(C7588Sj c7588Sj) {
            this.a = c7588Sj;
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

    private C6642Oj(C7588Sj c7588Sj, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c7588Sj;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }
}
