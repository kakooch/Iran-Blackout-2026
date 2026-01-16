package ir.nasim;

import ir.nasim.C12644ex5;
import ir.nasim.C14464hx5;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Ww5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8652Ww5 extends h.d implements V64 {
    private static final C8652Ww5 l;
    public static LW4 m = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private List e;
    private List f;
    private List g;
    private C12644ex5 h;
    private C14464hx5 i;
    private byte j;
    private int k;

    /* renamed from: ir.nasim.Ww5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C8652Ww5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C8652Ww5(eVar, fVar);
        }
    }

    static {
        C8652Ww5 c8652Ww5 = new C8652Ww5(true);
        l = c8652Ww5;
        c8652Ww5.e0();
    }

    public static C8652Ww5 O() {
        return l;
    }

    private void e0() {
        this.e = Collections.emptyList();
        this.f = Collections.emptyList();
        this.g = Collections.emptyList();
        this.h = C12644ex5.w();
        this.i = C14464hx5.s();
    }

    public static b f0() {
        return b.q();
    }

    public static b g0(C8652Ww5 c8652Ww5) {
        return f0().e(c8652Ww5);
    }

    public static C8652Ww5 i0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        return (C8652Ww5) m.a(inputStream, fVar);
    }

    @Override // ir.nasim.V64
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C8652Ww5 getDefaultInstanceForType() {
        return l;
    }

    public C7950Tw5 Q(int i) {
        return (C7950Tw5) this.e.get(i);
    }

    public int R() {
        return this.e.size();
    }

    public List S() {
        return this.e;
    }

    public C9193Yw5 T(int i) {
        return (C9193Yw5) this.f.get(i);
    }

    public int U() {
        return this.f.size();
    }

    public List V() {
        return this.f;
    }

    public C11410cx5 W(int i) {
        return (C11410cx5) this.g.get(i);
    }

    public int X() {
        return this.g.size();
    }

    public List Y() {
        return this.g;
    }

    public C12644ex5 Z() {
        return this.h;
    }

    public C14464hx5 a0() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        for (int i = 0; i < this.e.size(); i++) {
            codedOutputStream.c0(3, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i));
        }
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            codedOutputStream.c0(4, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.f.get(i2));
        }
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            codedOutputStream.c0(5, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.g.get(i3));
        }
        if ((this.d & 1) == 1) {
            codedOutputStream.c0(30, this.h);
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.c0(32, this.i);
        }
        aVarZ.a(200, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    public boolean b0() {
        return (this.d & 1) == 1;
    }

    public boolean c0() {
        return (this.d & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.k;
        if (i != -1) {
            return i;
        }
        int iR = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            iR += CodedOutputStream.r(3, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i2));
        }
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            iR += CodedOutputStream.r(4, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.f.get(i3));
        }
        for (int i4 = 0; i4 < this.g.size(); i4++) {
            iR += CodedOutputStream.r(5, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.g.get(i4));
        }
        if ((this.d & 1) == 1) {
            iR += CodedOutputStream.r(30, this.h);
        }
        if ((this.d & 2) == 2) {
            iR += CodedOutputStream.r(32, this.i);
        }
        int iR2 = iR + r() + this.c.size();
        this.k = iR2;
        return iR2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return f0();
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.j;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < R(); i++) {
            if (!Q(i).isInitialized()) {
                this.j = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < U(); i2++) {
            if (!T(i2).isInitialized()) {
                this.j = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < X(); i3++) {
            if (!W(i3).isInitialized()) {
                this.j = (byte) 0;
                return false;
            }
        }
        if (b0() && !Z().isInitialized()) {
            this.j = (byte) 0;
            return false;
        }
        if (q()) {
            this.j = (byte) 1;
            return true;
        }
        this.j = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return g0(this);
    }

    private C8652Ww5(h.c cVar) {
        super(cVar);
        this.j = (byte) -1;
        this.k = -1;
        this.c = cVar.d();
    }

    private C8652Ww5(boolean z) {
        this.j = (byte) -1;
        this.k = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private C8652Ww5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.j = (byte) -1;
        this.k = -1;
        e0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        char c = 0;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 26) {
                            int i = (c == true ? 1 : 0) & 1;
                            c = c;
                            if (i != 1) {
                                this.e = new ArrayList();
                                c = (c == true ? 1 : 0) | 1;
                            }
                            this.e.add(eVar.t(C7950Tw5.t, fVar));
                        } else if (iJ == 34) {
                            int i2 = (c == true ? 1 : 0) & 2;
                            c = c;
                            if (i2 != 2) {
                                this.f = new ArrayList();
                                c = (c == true ? 1 : 0) | 2;
                            }
                            this.f.add(eVar.t(C9193Yw5.t, fVar));
                        } else if (iJ != 42) {
                            if (iJ == 242) {
                                C12644ex5.b bVarK = (this.d & 1) == 1 ? this.h.toBuilder() : null;
                                C12644ex5 c12644ex5 = (C12644ex5) eVar.t(C12644ex5.i, fVar);
                                this.h = c12644ex5;
                                if (bVarK != null) {
                                    bVarK.e(c12644ex5);
                                    this.h = bVarK.k();
                                }
                                this.d |= 1;
                            } else if (iJ != 258) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                C14464hx5.b bVarE = (this.d & 2) == 2 ? this.i.toBuilder() : null;
                                C14464hx5 c14464hx5 = (C14464hx5) eVar.t(C14464hx5.g, fVar);
                                this.i = c14464hx5;
                                if (bVarE != null) {
                                    bVarE.e(c14464hx5);
                                    this.i = bVarE.k();
                                }
                                this.d |= 2;
                            }
                        } else {
                            int i3 = (c == true ? 1 : 0) & 4;
                            c = c;
                            if (i3 != 4) {
                                this.g = new ArrayList();
                                c = (c == true ? 1 : 0) | 4;
                            }
                            this.g.add(eVar.t(C11410cx5.q, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & 1) == 1) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    if (((c == true ? 1 : 0) & 2) == 2) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
                    if (((c == true ? 1 : 0) & 4) == 4) {
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
            } catch (InvalidProtocolBufferException e) {
                throw e.k(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
            }
        }
        if (((c == true ? 1 : 0) & 1) == 1) {
            this.e = Collections.unmodifiableList(this.e);
        }
        if (((c == true ? 1 : 0) & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
        }
        if (((c == true ? 1 : 0) & 4) == 4) {
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

    /* renamed from: ir.nasim.Ww5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private List e = Collections.emptyList();
        private List f = Collections.emptyList();
        private List g = Collections.emptyList();
        private C12644ex5 h = C12644ex5.w();
        private C14464hx5 i = C14464hx5.s();

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        private void r() {
            if ((this.d & 1) != 1) {
                this.e = new ArrayList(this.e);
                this.d |= 1;
            }
        }

        private void s() {
            if ((this.d & 2) != 2) {
                this.f = new ArrayList(this.f);
                this.d |= 2;
            }
        }

        private void t() {
            if ((this.d & 4) != 4) {
                this.g = new ArrayList(this.g);
                this.d |= 4;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C8652Ww5 a() {
            C8652Ww5 c8652Ww5O = o();
            if (c8652Ww5O.isInitialized()) {
                return c8652Ww5O;
            }
            throw a.AbstractC1828a.c(c8652Ww5O);
        }

        public C8652Ww5 o() {
            C8652Ww5 c8652Ww5 = new C8652Ww5(this);
            int i = this.d;
            if ((i & 1) == 1) {
                this.e = Collections.unmodifiableList(this.e);
                this.d &= -2;
            }
            c8652Ww5.e = this.e;
            if ((this.d & 2) == 2) {
                this.f = Collections.unmodifiableList(this.f);
                this.d &= -3;
            }
            c8652Ww5.f = this.f;
            if ((this.d & 4) == 4) {
                this.g = Collections.unmodifiableList(this.g);
                this.d &= -5;
            }
            c8652Ww5.g = this.g;
            int i2 = (i & 8) != 8 ? 0 : 1;
            c8652Ww5.h = this.h;
            if ((i & 16) == 16) {
                i2 |= 2;
            }
            c8652Ww5.i = this.i;
            c8652Ww5.d = i2;
            return c8652Ww5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b e(C8652Ww5 c8652Ww5) {
            if (c8652Ww5 == C8652Ww5.O()) {
                return this;
            }
            if (!c8652Ww5.e.isEmpty()) {
                if (this.e.isEmpty()) {
                    this.e = c8652Ww5.e;
                    this.d &= -2;
                } else {
                    r();
                    this.e.addAll(c8652Ww5.e);
                }
            }
            if (!c8652Ww5.f.isEmpty()) {
                if (this.f.isEmpty()) {
                    this.f = c8652Ww5.f;
                    this.d &= -3;
                } else {
                    s();
                    this.f.addAll(c8652Ww5.f);
                }
            }
            if (!c8652Ww5.g.isEmpty()) {
                if (this.g.isEmpty()) {
                    this.g = c8652Ww5.g;
                    this.d &= -5;
                } else {
                    t();
                    this.g.addAll(c8652Ww5.g);
                }
            }
            if (c8652Ww5.b0()) {
                x(c8652Ww5.Z());
            }
            if (c8652Ww5.c0()) {
                y(c8652Ww5.a0());
            }
            l(c8652Ww5);
            f(d().h(c8652Ww5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C8652Ww5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C8652Ww5.m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Ww5 r3 = (ir.nasim.C8652Ww5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Ww5 r4 = (ir.nasim.C8652Ww5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8652Ww5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Ww5$b");
        }

        public b x(C12644ex5 c12644ex5) {
            if ((this.d & 8) != 8 || this.h == C12644ex5.w()) {
                this.h = c12644ex5;
            } else {
                this.h = C12644ex5.H(this.h).e(c12644ex5).k();
            }
            this.d |= 8;
            return this;
        }

        public b y(C14464hx5 c14464hx5) {
            if ((this.d & 16) != 16 || this.i == C14464hx5.s()) {
                this.i = c14464hx5;
            } else {
                this.i = C14464hx5.C(this.i).e(c14464hx5).k();
            }
            this.d |= 16;
            return this;
        }

        private void u() {
        }
    }
}
