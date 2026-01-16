package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import ir.nasim.AbstractC23983xq5;
import ir.nasim.AbstractC5747Kq7;
import ir.nasim.AbstractC8110Uo3;
import ir.nasim.C20317ro3;
import ir.nasim.C23802xY2;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.wY2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23212wY2 extends AbstractC8110Uo3 {
    private static final AbstractC23983xq5 d = AbstractC23983xq5.b(new AbstractC23983xq5.b() { // from class: ir.nasim.uY2
        @Override // ir.nasim.AbstractC23983xq5.b
        public final Object a(AbstractC14981io3 abstractC14981io3) {
            return new QT0((C20140rY2) abstractC14981io3);
        }
    }, C20140rY2.class, RT0.class);
    private static final AbstractC23983xq5 e = AbstractC23983xq5.b(new AbstractC23983xq5.b() { // from class: ir.nasim.vY2
        @Override // ir.nasim.AbstractC23983xq5.b
        public final Object a(AbstractC14981io3 abstractC14981io3) {
            return C20930sq5.d((C20140rY2) abstractC14981io3);
        }
    }, C20140rY2.class, WL3.class);

    /* renamed from: ir.nasim.wY2$a */
    class a extends AbstractC24573yq5 {
        a(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC24573yq5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public WL3 a(C20749sY2 c20749sY2) throws GeneralSecurityException {
            EnumC24950zU2 enumC24950zU2V = c20749sY2.X().V();
            SecretKeySpec secretKeySpec = new SecretKeySpec(c20749sY2.W().W(), "HMAC");
            int iW = c20749sY2.X().W();
            int i = c.a[enumC24950zU2V.ordinal()];
            if (i == 1) {
                return new C20930sq5(new C20339rq5("HMACSHA1", secretKeySpec), iW);
            }
            if (i == 2) {
                return new C20930sq5(new C20339rq5("HMACSHA224", secretKeySpec), iW);
            }
            if (i == 3) {
                return new C20930sq5(new C20339rq5("HMACSHA256", secretKeySpec), iW);
            }
            if (i == 4) {
                return new C20930sq5(new C20339rq5("HMACSHA384", secretKeySpec), iW);
            }
            if (i == 5) {
                return new C20930sq5(new C20339rq5("HMACSHA512", secretKeySpec), iW);
            }
            throw new GeneralSecurityException("unknown hash");
        }
    }

    /* renamed from: ir.nasim.wY2$b */
    class b extends AbstractC8110Uo3.a {
        b(Class cls) {
            super(cls);
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C20749sY2 a(C21369tY2 c21369tY2) {
            return (C20749sY2) C20749sY2.Z().r(C23212wY2.this.l()).q(c21369tY2.W()).p(AbstractC2345g.C(AbstractC16435lG5.a(c21369tY2.V()))).e();
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C21369tY2 b(AbstractC2345g abstractC2345g) {
            return C21369tY2.Z(abstractC2345g, C2352n.b());
        }

        @Override // ir.nasim.AbstractC8110Uo3.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(C21369tY2 c21369tY2) throws GeneralSecurityException {
            if (c21369tY2.V() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            C23212wY2.q(c21369tY2.W());
        }
    }

    /* renamed from: ir.nasim.wY2$c */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24950zU2.values().length];
            a = iArr;
            try {
                iArr[EnumC24950zU2.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC24950zU2.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC24950zU2.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC24950zU2.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC24950zU2.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C23212wY2() {
        super(C20749sY2.class, new a(WL3.class));
    }

    private static Map m() {
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", AbstractC9898ak5.a);
        C23802xY2.b bVarD = C23802xY2.b().c(32).d(16);
        C23802xY2.d dVar = C23802xY2.d.e;
        C23802xY2.b bVarE = bVarD.e(dVar);
        C23802xY2.c cVar = C23802xY2.c.d;
        map.put("HMAC_SHA256_128BITTAG_RAW", bVarE.b(cVar).a());
        C23802xY2.b bVarD2 = C23802xY2.b().c(32).d(32);
        C23802xY2.d dVar2 = C23802xY2.d.b;
        map.put("HMAC_SHA256_256BITTAG", bVarD2.e(dVar2).b(cVar).a());
        map.put("HMAC_SHA256_256BITTAG_RAW", C23802xY2.b().c(32).d(32).e(dVar).b(cVar).a());
        C23802xY2.b bVarE2 = C23802xY2.b().c(64).d(16).e(dVar2);
        C23802xY2.c cVar2 = C23802xY2.c.f;
        map.put("HMAC_SHA512_128BITTAG", bVarE2.b(cVar2).a());
        map.put("HMAC_SHA512_128BITTAG_RAW", C23802xY2.b().c(64).d(16).e(dVar).b(cVar2).a());
        map.put("HMAC_SHA512_256BITTAG", C23802xY2.b().c(64).d(32).e(dVar2).b(cVar2).a());
        map.put("HMAC_SHA512_256BITTAG_RAW", C23802xY2.b().c(64).d(32).e(dVar).b(cVar2).a());
        map.put("HMAC_SHA512_512BITTAG", AbstractC9898ak5.d);
        map.put("HMAC_SHA512_512BITTAG_RAW", C23802xY2.b().c(64).d(64).e(dVar).b(cVar2).a());
        return Collections.unmodifiableMap(map);
    }

    public static void o(boolean z) {
        AbstractC24881zM5.h(new C23212wY2(), z);
        CY2.g();
        C5006Hm4.c().d(d);
        C5006Hm4.c().d(e);
        C4523Fm4.b().d(m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(C24392yY2 c24392yY2) throws GeneralSecurityException {
        if (c24392yY2.W() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = c.a[c24392yY2.V().ordinal()];
        if (i == 1) {
            if (c24392yY2.W() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i == 2) {
            if (c24392yY2.W() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i == 3) {
            if (c24392yY2.W() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 4) {
            if (c24392yY2.W() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (c24392yY2.W() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC5747Kq7.b a() {
        return AbstractC5747Kq7.b.b;
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public String d() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // ir.nasim.AbstractC8110Uo3
    public AbstractC8110Uo3.a f() {
        return new b(C21369tY2.class);
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
    public C20749sY2 h(AbstractC2345g abstractC2345g) {
        return C20749sY2.a0(abstractC2345g, C2352n.b());
    }

    @Override // ir.nasim.AbstractC8110Uo3
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void j(C20749sY2 c20749sY2) throws GeneralSecurityException {
        AbstractC12327eQ7.c(c20749sY2.Y(), l());
        if (c20749sY2.W().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        q(c20749sY2.X());
    }
}
