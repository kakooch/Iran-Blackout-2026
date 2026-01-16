package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.C7588Sj;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Rj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7354Rj extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.Rj$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public GJ1 a(C6876Pj c6876Pj) {
            return new C6382Nj(c6876Pj.U().W());
        }
    }

    /* renamed from: ir.nasim.Rj$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C6876Pj a(C7120Qj c7120Qj) {
            return (C6876Pj) C6876Pj.W().p(AbstractC2345g.C(AbstractC16435lG5.a(c7120Qj.T()))).q(C7354Rj.this.k()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C7120Qj b(AbstractC2345g abstractC2345g) {
            return C7120Qj.W(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C7120Qj c7120Qj) throws InvalidAlgorithmParameterException {
            if (c7120Qj.T() == 64) {
                return;
            }
            throw new InvalidAlgorithmParameterException("invalid key size: " + c7120Qj.T() + ". Valid keys must have 64 bytes.");
        }
    }

    C7354Rj() {
        super(C6876Pj.class, new a(GJ1.class));
    }

    private static Map l() {
        HashMap map = new HashMap();
        map.put("AES256_SIV", AbstractC7594Sj5.a);
        map.put("AES256_SIV_RAW", C7588Sj.b().b(64).c(C7588Sj.c.d).a());
        return Collections.unmodifiableMap(map);
    }

    public static void n(boolean z) {
        AbstractC24881zM5.h(new C7354Rj(), z);
        AbstractC8529Wj.h();
        C4523Fm4.b().d(l());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C7120Qj.class);
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
    public C6876Pj h(AbstractC2345g abstractC2345g) {
        return C6876Pj.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(C6876Pj c6876Pj) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c6876Pj.V(), k());
        if (c6876Pj.U().size() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + c6876Pj.U().size() + ". Valid keys must have 64 bytes.");
    }
}
