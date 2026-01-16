package ir.nasim;

import ir.nasim.C6373Ni;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Hi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4965Hi extends YL3 {
    private final C6373Ni a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    /* renamed from: ir.nasim.Hi$b */
    public static class b {
        private C6373Ni a;
        private C18469oi6 b;
        private Integer c;

        private C8575Wo0 b() {
            if (this.a.f() == C6373Ni.c.e) {
                return C8575Wo0.a(new byte[0]);
            }
            if (this.a.f() == C6373Ni.c.d || this.a.f() == C6373Ni.c.c) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.c.intValue()).array());
            }
            if (this.a.f() == C6373Ni.c.b) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.c.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + this.a.f());
        }

        public C4965Hi a() throws GeneralSecurityException {
            C6373Ni c6373Ni = this.a;
            if (c6373Ni == null || this.b == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (c6373Ni.d() != this.b.b()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.a.a() && this.c == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.a.a() && this.c != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C4965Hi(this.a, this.b, b(), this.c);
        }

        public b c(C18469oi6 c18469oi6) {
            this.b = c18469oi6;
            return this;
        }

        public b d(Integer num) {
            this.c = num;
            return this;
        }

        public b e(C6373Ni c6373Ni) {
            this.a = c6373Ni;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }

    public static b c() {
        return new b();
    }

    @Override // ir.nasim.YL3
    public C8575Wo0 a() {
        return this.c;
    }

    public C18469oi6 d() {
        return this.b;
    }

    @Override // ir.nasim.YL3
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C6373Ni b() {
        return this.a;
    }

    private C4965Hi(C6373Ni c6373Ni, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c6373Ni;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }
}
