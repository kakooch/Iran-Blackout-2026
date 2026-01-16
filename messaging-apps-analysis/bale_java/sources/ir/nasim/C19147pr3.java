package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.pr3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C19147pr3 extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.pr3$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(C17965nr3 c17965nr3) {
            String strW = c17965nr3.U().W();
            return new C17374mr3(c17965nr3.U().V(), AbstractC16783lr3.a(strW).b(strW));
        }
    }

    /* renamed from: ir.nasim.pr3$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C17965nr3 a(C18556or3 c18556or3) {
            return (C17965nr3) C17965nr3.W().p(c18556or3).q(C19147pr3.this.k()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C18556or3 b(AbstractC2345g abstractC2345g) {
            return C18556or3.Z(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C18556or3 c18556or3) throws GeneralSecurityException {
            if (C17374mr3.d(c18556or3.V().X())) {
                if (c18556or3.W().isEmpty() || !c18556or3.X()) {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
            } else {
                throw new GeneralSecurityException("Unsupported DEK key type: " + c18556or3.V().X() + ". Only Tink AEAD key types are supported.");
            }
        }
    }

    C19147pr3() {
        super(C17965nr3.class, new a(InterfaceC3780Ci.class));
    }

    public static void m(boolean z) {
        AbstractC24881zM5.h(new C19147pr3(), z);
        AbstractC5347Iy3.g();
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C18556or3.class);
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
    public C17965nr3 h(AbstractC2345g abstractC2345g) {
        return C17965nr3.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(C17965nr3 c17965nr3) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c17965nr3.V(), k());
        if (C17374mr3.d(c17965nr3.U().V().X())) {
            return;
        }
        throw new GeneralSecurityException("Unsupported DEK key type: " + c17965nr3.U().V().X() + ". Only Tink AEAD key types are supported.");
    }
}
