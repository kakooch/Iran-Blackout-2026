package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C10441bc8;
import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.ac8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C9821ac8 extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.ac8$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(Xb8 xb8) {
            return new Wb8(xb8.U().W());
        }
    }

    C9821ac8() {
        super(Xb8.class, new a(InterfaceC3780Ci.class));
    }

    private static Map l() {
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", C10441bc8.b(C10441bc8.a.b));
        map.put("XCHACHA20_POLY1305_RAW", C10441bc8.b(C10441bc8.a.d));
        return Collections.unmodifiableMap(map);
    }

    public static void n(boolean z) {
        AbstractC24881zM5.h(new C9821ac8(), z);
        AbstractC13047fc8.f();
        C4523Fm4.b().d(l());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(Zb8.class);
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public C20317ro3.c g() {
        return C20317ro3.c.SYMMETRIC;
    }

    public int k() {
        return 0;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Xb8 h(AbstractC2345g abstractC2345g) {
        return Xb8.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(Xb8 xb8) throws GeneralSecurityException {
        AbstractC12327eQ7.c(xb8.V(), k());
        if (xb8.U().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    /* renamed from: ir.nasim.ac8$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Xb8 a(Zb8 zb8) {
            return (Xb8) Xb8.W().q(C9821ac8.this.k()).p(AbstractC2345g.C(AbstractC16435lG5.a(32))).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Zb8 b(AbstractC2345g abstractC2345g) {
            return Zb8.U(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(Zb8 zb8) {
        }
    }
}
