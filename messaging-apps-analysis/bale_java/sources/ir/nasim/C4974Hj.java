package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.C5208Ij;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: ir.nasim.Hj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4974Hj extends AbstractC8110Uo3 {

    /* renamed from: ir.nasim.Hj$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC3780Ci a(C4491Fj c4491Fj) {
            return new C4023Dj(c4491Fj.U().W());
        }
    }

    /* renamed from: ir.nasim.Hj$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C4491Fj a(C4740Gj c4740Gj) {
            return (C4491Fj) C4491Fj.W().p(AbstractC2345g.C(AbstractC16435lG5.a(c4740Gj.T()))).q(C4974Hj.this.l()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C4740Gj b(AbstractC2345g abstractC2345g) {
            return C4740Gj.W(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C4740Gj c4740Gj) throws InvalidAlgorithmParameterException {
            AbstractC12327eQ7.a(c4740Gj.T());
        }
    }

    C4974Hj() {
        super(C4491Fj.class, new a(InterfaceC3780Ci.class));
    }

    private static boolean k() throws NoSuchPaddingException, NoSuchAlgorithmException {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    private static Map m() throws InvalidAlgorithmParameterException {
        HashMap map = new HashMap();
        C5208Ij.b bVarB = C5208Ij.b().b(16);
        C5208Ij.c cVar = C5208Ij.c.b;
        map.put("AES128_GCM_SIV", bVarB.c(cVar).a());
        C5208Ij.b bVarB2 = C5208Ij.b().b(16);
        C5208Ij.c cVar2 = C5208Ij.c.d;
        map.put("AES128_GCM_SIV_RAW", bVarB2.c(cVar2).a());
        map.put("AES256_GCM_SIV", C5208Ij.b().b(32).c(cVar).a());
        map.put("AES256_GCM_SIV_RAW", C5208Ij.b().b(32).c(cVar2).a());
        return Collections.unmodifiableMap(map);
    }

    public static void o(boolean z) {
        if (k()) {
            AbstractC24881zM5.h(new C4974Hj(), z);
            AbstractC6143Mj.f();
            C4523Fm4.b().d(m());
        }
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C4740Gj.class);
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public C20317ro3.c g() {
        return C20317ro3.c.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C4491Fj h(AbstractC2345g abstractC2345g) {
        return C4491Fj.X(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void j(C4491Fj c4491Fj) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c4491Fj.V(), l());
        AbstractC12327eQ7.a(c4491Fj.U().size());
    }
}
