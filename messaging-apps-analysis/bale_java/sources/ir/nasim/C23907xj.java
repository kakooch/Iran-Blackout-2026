package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC5747Kq7;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.C24497yj;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.xj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23907xj extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.xj$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(C22721vj c22721vj) {
            return new C21541tj(c22721vj.U().W());
        }
    }

    /* renamed from: ir.nasim.xj$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C22721vj a(C23317wj c23317wj) {
            return (C22721vj) C22721vj.W().p(AbstractC2345g.C(AbstractC16435lG5.a(c23317wj.T()))).q(C23907xj.this.k()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C23317wj b(AbstractC2345g abstractC2345g) {
            return C23317wj.W(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C23317wj c23317wj) throws InvalidAlgorithmParameterException {
            AbstractC12327eQ7.a(c23317wj.T());
        }
    }

    C23907xj() {
        super(C22721vj.class, new a(InterfaceC3780Ci.class));
    }

    private static Map l() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_GCM", AbstractC7126Qj5.a);
        C24497yj.b bVarD = C24497yj.b().b(12).c(16).d(16);
        C24497yj.c cVar = C24497yj.c.d;
        map.put("AES128_GCM_RAW", bVarD.e(cVar).a());
        map.put("AES256_GCM", AbstractC7126Qj5.b);
        map.put("AES256_GCM_RAW", C24497yj.b().b(12).c(32).d(16).e(cVar).a());
        return Collections.unmodifiableMap(map);
    }

    public static void n(boolean z) {
        AbstractC24881zM5.h(new C23907xj(), z);
        AbstractC3789Cj.f();
        C4523Fm4.b().d(l());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC5747Kq7.b a() {
        return AbstractC5747Kq7.b.b;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C23317wj.class);
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
    public C22721vj h(AbstractC2345g abstractC2345g) {
        return C22721vj.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(C22721vj c22721vj) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c22721vj.V(), k());
        AbstractC12327eQ7.a(c22721vj.U().size());
    }
}
