package ir.nasim;

import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.C4092Dq5;
import ir.nasim.C5032Hp3;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.Ip3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5266Ip3 {
    private final C5032Hp3 a;
    private final List b;
    private final C7350Ri4 c = C7350Ri4.b;

    /* renamed from: ir.nasim.Ip3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6192Mo3.values().length];
            a = iArr;
            try {
                iArr[EnumC6192Mo3.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC6192Mo3.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC6192Mo3.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: ir.nasim.Ip3$b */
    public static final class b {
        private final AbstractC14981io3 a;
        private final C5959Lo3 b;
        private final int c;
        private final boolean d;

        /* synthetic */ b(AbstractC14981io3 abstractC14981io3, C5959Lo3 c5959Lo3, int i, boolean z, a aVar) {
            this(abstractC14981io3, c5959Lo3, i, z);
        }

        public AbstractC14981io3 a() {
            return this.a;
        }

        private b(AbstractC14981io3 abstractC14981io3, C5959Lo3 c5959Lo3, int i, boolean z) {
            this.a = abstractC14981io3;
            this.b = c5959Lo3;
            this.c = i;
            this.d = z;
        }
    }

    private C5266Ip3(C5032Hp3 c5032Hp3, List list) {
        this.a = c5032Hp3;
        this.b = list;
    }

    private static void a(C13976h82 c13976h82) throws GeneralSecurityException {
        if (c13976h82 == null || c13976h82.U().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void b(C5032Hp3 c5032Hp3) throws GeneralSecurityException {
        if (c5032Hp3 == null || c5032Hp3.X() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static C5032Hp3 c(C13976h82 c13976h82, InterfaceC3780Ci interfaceC3780Ci, byte[] bArr) throws GeneralSecurityException {
        try {
            C5032Hp3 c5032Hp3C0 = C5032Hp3.c0(interfaceC3780Ci.b(c13976h82.U().W(), bArr), C2352n.b());
            b(c5032Hp3C0);
            return c5032Hp3C0;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static C13976h82 d(C5032Hp3 c5032Hp3, InterfaceC3780Ci interfaceC3780Ci, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrA = interfaceC3780Ci.a(c5032Hp3.f(), bArr);
        try {
            if (C5032Hp3.c0(interfaceC3780Ci.b(bArrA, bArr), C2352n.b()).equals(c5032Hp3)) {
                return (C13976h82) C13976h82.V().p(AbstractC2345g.C(bArrA)).q(AbstractC10277bN7.b(c5032Hp3)).e();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    static final C5266Ip3 e(C5032Hp3 c5032Hp3) throws GeneralSecurityException {
        b(c5032Hp3);
        return new C5266Ip3(c5032Hp3, f(c5032Hp3));
    }

    private static List f(C5032Hp3 c5032Hp3) {
        ArrayList arrayList = new ArrayList(c5032Hp3.X());
        for (C5032Hp3.c cVar : c5032Hp3.Y()) {
            int iX = cVar.X();
            try {
                arrayList.add(new b(com.google.crypto.tink.internal.b.c().g(r(cVar), J93.a()), n(cVar.Z()), iX, iX == c5032Hp3.Z(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Object g(AbstractC4423Fb3 abstractC4423Fb3, AbstractC14981io3 abstractC14981io3, Class cls) {
        try {
            return abstractC4423Fb3.c(abstractC14981io3, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private static Object j(AbstractC4423Fb3 abstractC4423Fb3, C5032Hp3.c cVar, Class cls) throws GeneralSecurityException {
        try {
            return abstractC4423Fb3.b(cVar.W(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        }
    }

    private Object m(AbstractC4423Fb3 abstractC4423Fb3, Class cls, Class cls2) throws GeneralSecurityException {
        AbstractC10277bN7.d(this.a);
        C4092Dq5.b bVarK = C4092Dq5.k(cls2);
        bVarK.e(this.c);
        for (int i = 0; i < q(); i++) {
            C5032Hp3.c cVarW = this.a.W(i);
            if (cVarW.Z().equals(EnumC6192Mo3.ENABLED)) {
                Object objJ = j(abstractC4423Fb3, cVarW, cls2);
                Object objG = this.b.get(i) != null ? g(abstractC4423Fb3, ((b) this.b.get(i)).a(), cls2) : null;
                if (objG == null && objJ == null) {
                    throw new GeneralSecurityException("Unable to get primitive " + cls2 + " for key of type " + cVarW.W().X());
                }
                if (cVarW.X() == this.a.Z()) {
                    bVarK.b(objG, objJ, cVarW);
                } else {
                    bVarK.a(objG, objJ, cVarW);
                }
            }
        }
        return abstractC4423Fb3.d(bVarK.d(), cls);
    }

    private static C5959Lo3 n(EnumC6192Mo3 enumC6192Mo3) throws GeneralSecurityException {
        int i = a.a[enumC6192Mo3.ordinal()];
        if (i == 1) {
            return C5959Lo3.b;
        }
        if (i == 2) {
            return C5959Lo3.c;
        }
        if (i == 3) {
            return C5959Lo3.d;
        }
        throw new GeneralSecurityException("Unknown key status");
    }

    public static final C5266Ip3 o(InterfaceC5968Lp3 interfaceC5968Lp3, InterfaceC3780Ci interfaceC3780Ci) {
        return p(interfaceC5968Lp3, interfaceC3780Ci, new byte[0]);
    }

    public static final C5266Ip3 p(InterfaceC5968Lp3 interfaceC5968Lp3, InterfaceC3780Ci interfaceC3780Ci, byte[] bArr) throws GeneralSecurityException {
        C13976h82 c13976h82A = interfaceC5968Lp3.a();
        a(c13976h82A);
        return e(c(c13976h82A, interfaceC3780Ci, bArr));
    }

    private static C19799qx5 r(C5032Hp3.c cVar) {
        try {
            return C19799qx5.b(cVar.W().X(), cVar.W().Y(), cVar.W().W(), cVar.Y(), cVar.Y() == FN4.RAW ? null : Integer.valueOf(cVar.X()));
        } catch (GeneralSecurityException e) {
            throw new TinkBugException("Creating a protokey serialization failed", e);
        }
    }

    C5032Hp3 h() {
        return this.a;
    }

    public C5500Jp3 i() {
        return AbstractC10277bN7.b(this.a);
    }

    public Object k(AbstractC8734Xc1 abstractC8734Xc1, Class cls) throws GeneralSecurityException {
        if (!(abstractC8734Xc1 instanceof AbstractC4423Fb3)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        AbstractC4423Fb3 abstractC4423Fb3 = (AbstractC4423Fb3) abstractC8734Xc1;
        Class clsA = abstractC4423Fb3.a(cls);
        if (clsA != null) {
            return m(abstractC4423Fb3, cls, clsA);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public Object l(Class cls) {
        return k(BM5.e(), cls);
    }

    public int q() {
        return this.a.X();
    }

    public void s(InterfaceC6201Mp3 interfaceC6201Mp3, InterfaceC3780Ci interfaceC3780Ci) {
        t(interfaceC6201Mp3, interfaceC3780Ci, new byte[0]);
    }

    public void t(InterfaceC6201Mp3 interfaceC6201Mp3, InterfaceC3780Ci interfaceC3780Ci, byte[] bArr) {
        interfaceC6201Mp3.b(d(this.a, interfaceC3780Ci, bArr));
    }

    public String toString() {
        return i().toString();
    }
}
