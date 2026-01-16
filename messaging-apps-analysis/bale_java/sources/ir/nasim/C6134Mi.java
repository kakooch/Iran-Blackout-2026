package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC23983xq5;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.C6373Ni;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Mi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6134Mi extends AbstractC8110Uo3 {
    private static final AbstractC23983xq5 d = AbstractC23983xq5.b(new AbstractC23983xq5.b() { // from class: ir.nasim.Ki
        @Override // ir.nasim.AbstractC23983xq5.b
        public final Object a(AbstractC14981io3 abstractC14981io3) {
            return new PT0((C4965Hi) abstractC14981io3);
        }
    }, C4965Hi.class, RT0.class);
    private static final AbstractC23983xq5 e = AbstractC23983xq5.b(new AbstractC23983xq5.b() { // from class: ir.nasim.Li
        @Override // ir.nasim.AbstractC23983xq5.b
        public final Object a(AbstractC14981io3 abstractC14981io3) {
            return C20930sq5.c((C4965Hi) abstractC14981io3);
        }
    }, C4965Hi.class, WL3.class);

    /* renamed from: ir.nasim.Mi$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public WL3 a(C5199Ii c5199Ii) {
            return new C20930sq5(new C19730qq5(c5199Ii.V().W()), c5199Ii.W().U());
        }
    }

    /* renamed from: ir.nasim.Mi$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C5199Ii a(C5433Ji c5433Ji) {
            return (C5199Ii) C5199Ii.Y().r(0).p(AbstractC2345g.C(AbstractC16435lG5.a(c5433Ji.U()))).q(c5433Ji.V()).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C5433Ji b(AbstractC2345g abstractC2345g) {
            return C5433Ji.X(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C5433Ji c5433Ji) throws GeneralSecurityException {
            C6134Mi.r(c5433Ji.V());
            C6134Mi.s(c5433Ji.U());
        }
    }

    C6134Mi() {
        super(C5199Ii.class, new a(WL3.class));
    }

    private static Map n() {
        HashMap map = new HashMap();
        C6373Ni c6373Ni = AbstractC9898ak5.e;
        map.put("AES_CMAC", c6373Ni);
        map.put("AES256_CMAC", c6373Ni);
        map.put("AES256_CMAC_RAW", C6373Ni.b().b(32).c(16).d(C6373Ni.c.e).a());
        return Collections.unmodifiableMap(map);
    }

    public static void p(boolean z) {
        AbstractC24881zM5.h(new C6134Mi(), z);
        AbstractC7579Si.g();
        C5006Hm4.c().d(d);
        C5006Hm4.c().d(e);
        C4523Fm4.b().d(n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(C6633Oi c6633Oi) throws GeneralSecurityException {
        if (c6633Oi.U() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (c6633Oi.U() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C5433Ji.class);
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public C20317ro3.c g() {
        return C20317ro3.c.SYMMETRIC;
    }

    public int m() {
        return 0;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C5199Ii h(AbstractC2345g abstractC2345g) {
        return C5199Ii.Z(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void j(C5199Ii c5199Ii) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c5199Ii.X(), m());
        s(c5199Ii.V().size());
        r(c5199Ii.W());
    }
}
