package ir.nasim;

import ir.nasim.C23802xY2;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.rY2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20140rY2 extends YL3 {
    private final C23802xY2 a;
    private final C18469oi6 b;
    private final C8575Wo0 c;
    private final Integer d;

    /* renamed from: ir.nasim.rY2$b */
    public static class b {
        private C23802xY2 a;
        private C18469oi6 b;
        private Integer c;

        private C8575Wo0 b() {
            if (this.a.g() == C23802xY2.d.e) {
                return C8575Wo0.a(new byte[0]);
            }
            if (this.a.g() == C23802xY2.d.d || this.a.g() == C23802xY2.d.c) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.c.intValue()).array());
            }
            if (this.a.g() == C23802xY2.d.b) {
                return C8575Wo0.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.c.intValue()).array());
            }
            throw new IllegalStateException("Unknown HmacParameters.Variant: " + this.a.g());
        }

        public C20140rY2 a() throws GeneralSecurityException {
            C23802xY2 c23802xY2 = this.a;
            if (c23802xY2 == null || this.b == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (c23802xY2.e() != this.b.b()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.a.a() && this.c == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.a.a() && this.c != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C20140rY2(this.a, this.b, b(), this.c);
        }

        public b c(Integer num) {
            this.c = num;
            return this;
        }

        public b d(C18469oi6 c18469oi6) {
            this.b = c18469oi6;
            return this;
        }

        public b e(C23802xY2 c23802xY2) {
            this.a = c23802xY2;
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
    public C23802xY2 b() {
        return this.a;
    }

    private C20140rY2(C23802xY2 c23802xY2, C18469oi6 c18469oi6, C8575Wo0 c8575Wo0, Integer num) {
        this.a = c23802xY2;
        this.b = c18469oi6;
        this.c = c8575Wo0;
        this.d = num;
    }
}
