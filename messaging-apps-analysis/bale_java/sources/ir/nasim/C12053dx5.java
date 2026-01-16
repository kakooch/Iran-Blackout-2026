package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.dx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12053dx5 extends h.d implements V64 {
    private static final C12053dx5 n;
    public static LW4 o = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private c h;
    private List i;
    private List j;
    private int k;
    private byte l;
    private int m;

    /* renamed from: ir.nasim.dx5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C12053dx5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C12053dx5(eVar, fVar);
        }
    }

    /* renamed from: ir.nasim.dx5$c */
    public enum c implements i.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);

        private static i.b e = new a();
        private final int a;

        /* renamed from: ir.nasim.dx5$c$a */
        static class a implements i.b {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i) {
                return c.a(i);
            }
        }

        c(int i, int i2) {
            this.a = i2;
        }

        public static c a(int i) {
            if (i == 0) {
                return IN;
            }
            if (i == 1) {
                return OUT;
            }
            if (i != 2) {
                return null;
            }
            return INV;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        C12053dx5 c12053dx5 = new C12053dx5(true);
        n = c12053dx5;
        c12053dx5.c0();
    }

    public static C12053dx5 O() {
        return n;
    }

    private void c0() {
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = c.INV;
        this.i = Collections.emptyList();
        this.j = Collections.emptyList();
    }

    public static b e0() {
        return b.q();
    }

    public static b f0(C12053dx5 c12053dx5) {
        return e0().e(c12053dx5);
    }

    @Override // ir.nasim.V64
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C12053dx5 getDefaultInstanceForType() {
        return n;
    }

    public int Q() {
        return this.e;
    }

    public int R() {
        return this.f;
    }

    public boolean S() {
        return this.g;
    }

    public C10647bx5 T(int i) {
        return (C10647bx5) this.i.get(i);
    }

    public int U() {
        return this.i.size();
    }

    public List V() {
        return this.j;
    }

    public List W() {
        return this.i;
    }

    public c X() {
        return this.h;
    }

    public boolean Y() {
        return (this.d & 1) == 1;
    }

    public boolean Z() {
        return (this.d & 2) == 2;
    }

    public boolean a0() {
        return (this.d & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(1, this.e);
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.Z(2, this.f);
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.K(3, this.g);
        }
        if ((this.d & 8) == 8) {
            codedOutputStream.R(4, this.h.getNumber());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.c0(5, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.i.get(i));
        }
        if (V().size() > 0) {
            codedOutputStream.n0(50);
            codedOutputStream.n0(this.k);
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            codedOutputStream.a0(((Integer) this.j.get(i2)).intValue());
        }
        aVarZ.a(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    public boolean b0() {
        return (this.d & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return e0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.m;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 1) == 1 ? CodedOutputStream.o(1, this.e) : 0;
        if ((this.d & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f);
        }
        if ((this.d & 4) == 4) {
            iO += CodedOutputStream.a(3, this.g);
        }
        if ((this.d & 8) == 8) {
            iO += CodedOutputStream.h(4, this.h.getNumber());
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            iO += CodedOutputStream.r(5, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.i.get(i2));
        }
        int iP = 0;
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            iP += CodedOutputStream.p(((Integer) this.j.get(i3)).intValue());
        }
        int iP2 = iO + iP;
        if (!V().isEmpty()) {
            iP2 = iP2 + 1 + CodedOutputStream.p(iP);
        }
        this.k = iP;
        int iR = iP2 + r() + this.c.size();
        this.m = iR;
        return iR;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return f0(this);
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.l;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!Y()) {
            this.l = (byte) 0;
            return false;
        }
        if (!Z()) {
            this.l = (byte) 0;
            return false;
        }
        for (int i = 0; i < U(); i++) {
            if (!T(i).isInitialized()) {
                this.l = (byte) 0;
                return false;
            }
        }
        if (q()) {
            this.l = (byte) 1;
            return true;
        }
        this.l = (byte) 0;
        return false;
    }

    private C12053dx5(h.c cVar) {
        super(cVar);
        this.k = -1;
        this.l = (byte) -1;
        this.m = -1;
        this.c = cVar.d();
    }

    private C12053dx5(boolean z) {
        this.k = -1;
        this.l = (byte) -1;
        this.m = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C12053dx5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.k = -1;
        this.l = (byte) -1;
        this.m = -1;
        c0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.d |= 1;
                            this.e = eVar.r();
                        } else if (iJ == 16) {
                            this.d |= 2;
                            this.f = eVar.r();
                        } else if (iJ == 24) {
                            this.d |= 4;
                            this.g = eVar.j();
                        } else if (iJ == 32) {
                            int iM = eVar.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                codedOutputStreamI.n0(iJ);
                                codedOutputStreamI.n0(iM);
                            } else {
                                this.d |= 8;
                                this.h = cVarA;
                            }
                        } else if (iJ == 42) {
                            if ((i & 16) != 16) {
                                this.i = new ArrayList();
                                i |= 16;
                            }
                            this.i.add(eVar.t(C10647bx5.v, fVar));
                        } else if (iJ == 48) {
                            if ((i & 32) != 32) {
                                this.j = new ArrayList();
                                i |= 32;
                            }
                            this.j.add(Integer.valueOf(eVar.r()));
                        } else if (iJ != 50) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            int i2 = eVar.i(eVar.z());
                            if ((i & 32) != 32 && eVar.e() > 0) {
                                this.j = new ArrayList();
                                i |= 32;
                            }
                            while (eVar.e() > 0) {
                                this.j.add(Integer.valueOf(eVar.r()));
                            }
                            eVar.h(i2);
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.k(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                }
            } catch (Throwable th) {
                if ((i & 16) == 16) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                if ((i & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                try {
                    codedOutputStreamI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.c = bVarB.e();
                    throw th2;
                }
                this.c = bVarB.e();
                j();
                throw th;
            }
        }
        if ((i & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
        }
        if ((i & 32) == 32) {
            this.j = Collections.unmodifiableList(this.j);
        }
        try {
            codedOutputStreamI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.c = bVarB.e();
            throw th3;
        }
        this.c = bVarB.e();
        j();
    }

    /* renamed from: ir.nasim.dx5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int e;
        private int f;
        private boolean g;
        private c h = c.INV;
        private List i = Collections.emptyList();
        private List j = Collections.emptyList();

        private b() {
            t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        private void r() {
            if ((this.d & 32) != 32) {
                this.j = new ArrayList(this.j);
                this.d |= 32;
            }
        }

        private void s() {
            if ((this.d & 16) != 16) {
                this.i = new ArrayList(this.i);
                this.d |= 16;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C12053dx5 a() {
            C12053dx5 c12053dx5O = o();
            if (c12053dx5O.isInitialized()) {
                return c12053dx5O;
            }
            throw a.AbstractC1828a.c(c12053dx5O);
        }

        public C12053dx5 o() {
            C12053dx5 c12053dx5 = new C12053dx5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c12053dx5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c12053dx5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c12053dx5.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c12053dx5.h = this.h;
            if ((this.d & 16) == 16) {
                this.i = Collections.unmodifiableList(this.i);
                this.d &= -17;
            }
            c12053dx5.i = this.i;
            if ((this.d & 32) == 32) {
                this.j = Collections.unmodifiableList(this.j);
                this.d &= -33;
            }
            c12053dx5.j = this.j;
            c12053dx5.d = i2;
            return c12053dx5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b e(C12053dx5 c12053dx5) {
            if (c12053dx5 == C12053dx5.O()) {
                return this;
            }
            if (c12053dx5.Y()) {
                w(c12053dx5.Q());
            }
            if (c12053dx5.Z()) {
                x(c12053dx5.R());
            }
            if (c12053dx5.a0()) {
                y(c12053dx5.S());
            }
            if (c12053dx5.b0()) {
                z(c12053dx5.X());
            }
            if (!c12053dx5.i.isEmpty()) {
                if (this.i.isEmpty()) {
                    this.i = c12053dx5.i;
                    this.d &= -17;
                } else {
                    s();
                    this.i.addAll(c12053dx5.i);
                }
            }
            if (!c12053dx5.j.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = c12053dx5.j;
                    this.d &= -33;
                } else {
                    r();
                    this.j.addAll(c12053dx5.j);
                }
            }
            l(c12053dx5);
            f(d().h(c12053dx5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C12053dx5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C12053dx5.o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.dx5 r3 = (ir.nasim.C12053dx5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.e(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.l r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ir.nasim.dx5 r4 = (ir.nasim.C12053dx5) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.e(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12053dx5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.dx5$b");
        }

        public b w(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        public b x(int i) {
            this.d |= 2;
            this.f = i;
            return this;
        }

        public b y(boolean z) {
            this.d |= 4;
            this.g = z;
            return this;
        }

        public b z(c cVar) {
            cVar.getClass();
            this.d |= 8;
            this.h = cVar;
            return this;
        }

        private void t() {
        }
    }
}
