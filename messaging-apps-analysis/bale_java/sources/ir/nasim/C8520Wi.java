package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC5747Kq7;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.C8786Xi;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Wi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8520Wi extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.Wi$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(C8052Ui c8052Ui) {
            return new C12749f82((Y53) new C13726gj().e(c8052Ui.V(), Y53.class), (WL3) new C23212wY2().e(c8052Ui.W(), WL3.class), c8052Ui.W().X().W());
        }
    }

    /* renamed from: ir.nasim.Wi$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C8052Ui a(C8286Vi c8286Vi) {
            C12499ej c12499ej = (C12499ej) new C13726gj().f().a(c8286Vi.U());
            return (C8052Ui) C8052Ui.Y().p(c12499ej).q((C20749sY2) new C23212wY2().f().a(c8286Vi.V())).r(C8520Wi.this.k()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C8286Vi b(AbstractC2345g abstractC2345g) {
            return C8286Vi.X(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C8286Vi c8286Vi) throws InvalidAlgorithmParameterException {
            new C13726gj().f().c(c8286Vi.U());
            new C23212wY2().f().c(c8286Vi.V());
            AbstractC12327eQ7.a(c8286Vi.U().V());
        }
    }

    C8520Wi() {
        super(C8052Ui.class, new a(InterfaceC3780Ci.class));
    }

    private static Map l() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", AbstractC7126Qj5.e);
        C8786Xi.b bVarE = C8786Xi.b().b(16).d(32).f(16).e(16);
        C8786Xi.c cVar = C8786Xi.c.d;
        C8786Xi.b bVarC = bVarE.c(cVar);
        C8786Xi.d dVar = C8786Xi.d.d;
        map.put("AES128_CTR_HMAC_SHA256_RAW", bVarC.g(dVar).a());
        map.put("AES256_CTR_HMAC_SHA256", AbstractC7126Qj5.f);
        map.put("AES256_CTR_HMAC_SHA256_RAW", C8786Xi.b().b(32).d(32).f(32).e(16).c(cVar).g(dVar).a());
        return Collections.unmodifiableMap(map);
    }

    public static void n(boolean z) {
        AbstractC24881zM5.h(new C8520Wi(), z);
        AbstractC11265cj.g();
        C4523Fm4.b().d(l());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC5747Kq7.b a() {
        return AbstractC5747Kq7.b.b;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C8286Vi.class);
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
    public C8052Ui h(AbstractC2345g abstractC2345g) {
        return C8052Ui.Z(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(C8052Ui c8052Ui) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c8052Ui.X(), k());
        new C13726gj().j(c8052Ui.V());
        new C23212wY2().j(c8052Ui.W());
    }
}
