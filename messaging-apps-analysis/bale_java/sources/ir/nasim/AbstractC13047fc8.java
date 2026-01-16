package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C10441bc8;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.fc8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC13047fc8 {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    /* renamed from: ir.nasim.fc8$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FN4.values().length];
            a = iArr;
            try {
                iArr[FN4.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FN4.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FN4.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.cc8
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC13047fc8.h((C10441bc8) abstractC20124rW4);
            }
        }, C10441bc8.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.dc8
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC13047fc8.e((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), Yb8.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.ec8
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC13047fc8.d((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Yb8 d(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            Xb8 xb8X = Xb8.X(c19799qx5.g(), C2352n.b());
            if (xb8X.V() == 0) {
                return Yb8.a(j(c19799qx5.e()), C18469oi6.a(xb8X.U().W(), C19060pi6.b(c19060pi6)), c19799qx5.c());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C10441bc8 e(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + c22275ux5.d().X());
        }
        try {
            if (Zb8.U(c22275ux5.d().Y(), C2352n.b()).T() == 0) {
                return C10441bc8.b(j(c22275ux5.d().W()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e2);
        }
    }

    public static void f() {
        g(com.google.crypto.tink.internal.b.c());
    }

    public static void g(com.google.crypto.tink.internal.b bVar) {
        bVar.m(b);
        bVar.l(c);
        bVar.k(d);
        bVar.j(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C22275ux5 h(C10441bc8 c10441bc8) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key").r(Zb8.S().b()).p(i(c10441bc8.c())).e());
    }

    private static FN4 i(C10441bc8.a aVar) throws GeneralSecurityException {
        if (C10441bc8.a.b.equals(aVar)) {
            return FN4.TINK;
        }
        if (C10441bc8.a.c.equals(aVar)) {
            return FN4.CRUNCHY;
        }
        if (C10441bc8.a.d.equals(aVar)) {
            return FN4.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + aVar);
    }

    private static C10441bc8.a j(FN4 fn4) throws GeneralSecurityException {
        int i = a.a[fn4.ordinal()];
        if (i == 1) {
            return C10441bc8.a.b;
        }
        if (i == 2 || i == 3) {
            return C10441bc8.a.c;
        }
        if (i == 4) {
            return C10441bc8.a.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }
}
