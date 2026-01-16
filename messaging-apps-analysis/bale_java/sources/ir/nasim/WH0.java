package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.XH0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class WH0 extends AbstractC8110Uo3 {

    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(TH0 th0) {
            return new SH0(th0.U().W());
        }
    }

    WH0() {
        super(TH0.class, new a(InterfaceC3780Ci.class));
    }

    private static Map l() {
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", XH0.b(XH0.a.b));
        map.put("CHACHA20_POLY1305_RAW", XH0.b(XH0.a.d));
        return Collections.unmodifiableMap(map);
    }

    public static void n(boolean z) {
        AbstractC24881zM5.h(new WH0(), z);
        AbstractC10225bI0.f();
        C4523Fm4.b().d(l());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(VH0.class);
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
    public TH0 h(AbstractC2345g abstractC2345g) {
        return TH0.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(TH0 th0) throws GeneralSecurityException {
        AbstractC12327eQ7.c(th0.V(), k());
        if (th0.U().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public TH0 a(VH0 vh0) {
            return (TH0) TH0.W().q(WH0.this.k()).p(AbstractC2345g.C(AbstractC16435lG5.a(32))).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public VH0 b(AbstractC2345g abstractC2345g) {
            return VH0.T(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(VH0 vh0) {
        }
    }
}
