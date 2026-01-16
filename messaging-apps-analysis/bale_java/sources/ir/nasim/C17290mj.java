package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C17881nj;
import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.mj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17290mj extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.mj$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(C16108kj c16108kj) {
            return new C14927ij(c16108kj.V().W(), c16108kj.W().U());
        }
    }

    /* renamed from: ir.nasim.mj$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C16108kj a(C16699lj c16699lj) {
            return (C16108kj) C16108kj.Y().p(AbstractC2345g.C(AbstractC16435lG5.a(c16699lj.U()))).q(c16699lj.V()).r(C17290mj.this.k()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C16699lj b(AbstractC2345g abstractC2345g) {
            return C16699lj.X(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C16699lj c16699lj) throws GeneralSecurityException {
            AbstractC12327eQ7.a(c16699lj.U());
            if (c16699lj.V().U() != 12 && c16699lj.V().U() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
        }
    }

    C17290mj() {
        super(C16108kj.class, new a(InterfaceC3780Ci.class));
    }

    private static Map l() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_EAX", AbstractC7126Qj5.c);
        C17881nj.b bVarD = C17881nj.b().b(16).c(16).d(16);
        C17881nj.c cVar = C17881nj.c.d;
        map.put("AES128_EAX_RAW", bVarD.e(cVar).a());
        map.put("AES256_EAX", AbstractC7126Qj5.d);
        map.put("AES256_EAX_RAW", C17881nj.b().b(16).c(32).d(16).e(cVar).a());
        return Collections.unmodifiableMap(map);
    }

    public static void n(boolean z) {
        AbstractC24881zM5.h(new C17290mj(), z);
        AbstractC20854sj.g();
        C4523Fm4.b().d(l());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C16699lj.class);
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
    public C16108kj h(AbstractC2345g abstractC2345g) {
        return C16108kj.Z(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(C16108kj c16108kj) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c16108kj.X(), k());
        AbstractC12327eQ7.a(c16108kj.V().size());
        if (c16108kj.W().U() != 12 && c16108kj.W().U() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
