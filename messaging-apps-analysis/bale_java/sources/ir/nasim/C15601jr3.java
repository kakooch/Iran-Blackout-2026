package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.jr3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15601jr3 extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.jr3$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(C14403hr3 c14403hr3) {
            String strU = c14403hr3.U().U();
            return AbstractC16783lr3.a(strU).b(strU);
        }
    }

    C15601jr3() {
        super(C14403hr3.class, new a(InterfaceC3780Ci.class));
    }

    public static void m(boolean z) {
        AbstractC24881zM5.h(new C15601jr3(), z);
        AbstractC3928Cy3.f();
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C15011ir3.class);
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public C20317ro3.c g() {
        return C20317ro3.c.REMOTE;
    }

    public int k() {
        return 0;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C14403hr3 h(AbstractC2345g abstractC2345g) {
        return C14403hr3.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(C14403hr3 c14403hr3) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c14403hr3.V(), k());
    }

    /* renamed from: ir.nasim.jr3$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C14403hr3 a(C15011ir3 c15011ir3) {
            return (C14403hr3) C14403hr3.W().p(c15011ir3).q(C15601jr3.this.k()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C15011ir3 b(AbstractC2345g abstractC2345g) {
            return C15011ir3.W(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C15011ir3 c15011ir3) {
        }
    }
}
