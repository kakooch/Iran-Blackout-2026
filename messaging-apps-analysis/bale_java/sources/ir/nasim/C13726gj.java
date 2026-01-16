package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.gj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C13726gj extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.gj$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Y53 a(C12499ej c12499ej) {
            return new C11887dj(c12499ej.W().W(), c12499ej.X().U());
        }
    }

    /* renamed from: ir.nasim.gj$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C12499ej a(C13135fj c13135fj) {
            return (C12499ej) C12499ej.Z().q(c13135fj.W()).p(AbstractC2345g.C(AbstractC16435lG5.a(c13135fj.V()))).r(C13726gj.this.l()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C13135fj b(AbstractC2345g abstractC2345g) {
            return C13135fj.Y(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C13135fj c13135fj) throws GeneralSecurityException {
            AbstractC12327eQ7.a(c13135fj.V());
            C13726gj.this.o(c13135fj.W());
        }
    }

    C13726gj() {
        super(C12499ej.class, new a(Y53.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(C14317hj c14317hj) throws GeneralSecurityException {
        if (c14317hj.U() < 12 || c14317hj.U() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C13135fj.class);
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public C20317ro3.c g() {
        return C20317ro3.c.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C12499ej h(AbstractC2345g abstractC2345g) {
        return C12499ej.a0(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(C12499ej c12499ej) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c12499ej.Y(), l());
        AbstractC12327eQ7.a(c12499ej.W().size());
        o(c12499ej.X());
    }
}
