package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Ow5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6765Ow5 extends h.d implements V64 {
    private static final C6765Ow5 j;
    public static LW4 k = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private List f;
    private List g;
    private byte h;
    private int i;

    /* renamed from: ir.nasim.Ow5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C6765Ow5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C6765Ow5(eVar, fVar);
        }
    }

    static {
        C6765Ow5 c6765Ow5 = new C6765Ow5(true);
        j = c6765Ow5;
        c6765Ow5.T();
    }

    public static C6765Ow5 L() {
        return j;
    }

    private void T() {
        this.e = 6;
        this.f = Collections.emptyList();
        this.g = Collections.emptyList();
    }

    public static b U() {
        return b.q();
    }

    public static b V(C6765Ow5 c6765Ow5) {
        return U().e(c6765Ow5);
    }

    @Override // ir.nasim.V64
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public C6765Ow5 getDefaultInstanceForType() {
        return j;
    }

    public int N() {
        return this.e;
    }

    public C13280fx5 O(int i) {
        return (C13280fx5) this.f.get(i);
    }

    public int P() {
        return this.f.size();
    }

    public List Q() {
        return this.f;
    }

    public List R() {
        return this.g;
    }

    public boolean S() {
        return (this.d & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return V(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(1, this.e);
        }
        for (int i = 0; i < this.f.size(); i++) {
            codedOutputStream.c0(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.f.get(i));
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            codedOutputStream.Z(31, ((Integer) this.g.get(i2)).intValue());
        }
        aVarZ.a(19000, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 1) == 1 ? CodedOutputStream.o(1, this.e) : 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            iO += CodedOutputStream.r(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.f.get(i2));
        }
        int iP = 0;
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            iP += CodedOutputStream.p(((Integer) this.g.get(i3)).intValue());
        }
        int size = iO + iP + (R().size() * 2) + r() + this.c.size();
        this.i = size;
        return size;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.h;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < P(); i++) {
            if (!O(i).isInitialized()) {
                this.h = (byte) 0;
                return false;
            }
        }
        if (q()) {
            this.h = (byte) 1;
            return true;
        }
        this.h = (byte) 0;
        return false;
    }

    private C6765Ow5(h.c cVar) {
        super(cVar);
        this.h = (byte) -1;
        this.i = -1;
        this.c = cVar.d();
    }

    private C6765Ow5(boolean z) {
        this.h = (byte) -1;
        this.i = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C6765Ow5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.h = (byte) -1;
        this.i = -1;
        T();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.d |= 1;
                                this.e = eVar.r();
                            } else if (iJ == 18) {
                                if ((i & 2) != 2) {
                                    this.f = new ArrayList();
                                    i |= 2;
                                }
                                this.f.add(eVar.t(C13280fx5.n, fVar));
                            } else if (iJ == 248) {
                                if ((i & 4) != 4) {
                                    this.g = new ArrayList();
                                    i |= 4;
                                }
                                this.g.add(Integer.valueOf(eVar.r()));
                            } else if (iJ != 250) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                int i2 = eVar.i(eVar.z());
                                if ((i & 4) != 4 && eVar.e() > 0) {
                                    this.g = new ArrayList();
                                    i |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.g.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i2);
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.k(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                }
            } catch (Throwable th) {
                if ((i & 2) == 2) {
                    this.f = Collections.unmodifiableList(this.f);
                }
                if ((i & 4) == 4) {
                    this.g = Collections.unmodifiableList(this.g);
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
        if ((i & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
        }
        if ((i & 4) == 4) {
            this.g = Collections.unmodifiableList(this.g);
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

    /* renamed from: ir.nasim.Ow5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int e = 6;
        private List f = Collections.emptyList();
        private List g = Collections.emptyList();

        private b() {
            t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        private void r() {
            if ((this.d & 2) != 2) {
                this.f = new ArrayList(this.f);
                this.d |= 2;
            }
        }

        private void s() {
            if ((this.d & 4) != 4) {
                this.g = new ArrayList(this.g);
                this.d |= 4;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C6765Ow5 a() {
            C6765Ow5 c6765Ow5O = o();
            if (c6765Ow5O.isInitialized()) {
                return c6765Ow5O;
            }
            throw a.AbstractC1828a.c(c6765Ow5O);
        }

        public C6765Ow5 o() {
            C6765Ow5 c6765Ow5 = new C6765Ow5(this);
            int i = (this.d & 1) != 1 ? 0 : 1;
            c6765Ow5.e = this.e;
            if ((this.d & 2) == 2) {
                this.f = Collections.unmodifiableList(this.f);
                this.d &= -3;
            }
            c6765Ow5.f = this.f;
            if ((this.d & 4) == 4) {
                this.g = Collections.unmodifiableList(this.g);
                this.d &= -5;
            }
            c6765Ow5.g = this.g;
            c6765Ow5.d = i;
            return c6765Ow5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b e(C6765Ow5 c6765Ow5) {
            if (c6765Ow5 == C6765Ow5.L()) {
                return this;
            }
            if (c6765Ow5.S()) {
                w(c6765Ow5.N());
            }
            if (!c6765Ow5.f.isEmpty()) {
                if (this.f.isEmpty()) {
                    this.f = c6765Ow5.f;
                    this.d &= -3;
                } else {
                    r();
                    this.f.addAll(c6765Ow5.f);
                }
            }
            if (!c6765Ow5.g.isEmpty()) {
                if (this.g.isEmpty()) {
                    this.g = c6765Ow5.g;
                    this.d &= -5;
                } else {
                    s();
                    this.g.addAll(c6765Ow5.g);
                }
            }
            l(c6765Ow5);
            f(d().h(c6765Ow5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C6765Ow5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C6765Ow5.k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Ow5 r3 = (ir.nasim.C6765Ow5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Ow5 r4 = (ir.nasim.C6765Ow5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6765Ow5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Ow5$b");
        }

        public b w(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        private void t() {
        }
    }
}
