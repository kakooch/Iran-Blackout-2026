package ir.nasim;

import ir.nasim.C7711Sw5;
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

/* renamed from: ir.nasim.Qw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7243Qw5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C7243Qw5 j;
    public static LW4 k = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private int c;
    private c d;
    private List e;
    private C7711Sw5 f;
    private d g;
    private byte h;
    private int i;

    /* renamed from: ir.nasim.Qw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C7243Qw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C7243Qw5(eVar, fVar);
        }
    }

    /* renamed from: ir.nasim.Qw5$c */
    public enum c implements i.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);

        private static i.b e = new a();
        private final int a;

        /* renamed from: ir.nasim.Qw5$c$a */
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
                return RETURNS_CONSTANT;
            }
            if (i == 1) {
                return CALLS;
            }
            if (i != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int getNumber() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Qw5$d */
    public enum d implements i.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);

        private static i.b e = new a();
        private final int a;

        /* renamed from: ir.nasim.Qw5$d$a */
        static class a implements i.b {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i) {
                return d.a(i);
            }
        }

        d(int i, int i2) {
            this.a = i2;
        }

        public static d a(int i) {
            if (i == 0) {
                return AT_MOST_ONCE;
            }
            if (i == 1) {
                return EXACTLY_ONCE;
            }
            if (i != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        C7243Qw5 c7243Qw5 = new C7243Qw5(true);
        j = c7243Qw5;
        c7243Qw5.L();
    }

    public static C7243Qw5 C() {
        return j;
    }

    private void L() {
        this.d = c.RETURNS_CONSTANT;
        this.e = Collections.emptyList();
        this.f = C7711Sw5.J();
        this.g = d.AT_MOST_ONCE;
    }

    public static b M() {
        return b.m();
    }

    public static b N(C7243Qw5 c7243Qw5) {
        return M().e(c7243Qw5);
    }

    public C7711Sw5 D(int i) {
        return (C7711Sw5) this.e.get(i);
    }

    public int E() {
        return this.e.size();
    }

    public c F() {
        return this.d;
    }

    public d G() {
        return this.g;
    }

    public boolean H() {
        return (this.c & 2) == 2;
    }

    public boolean J() {
        return (this.c & 1) == 1;
    }

    public boolean K() {
        return (this.c & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return N(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.c & 1) == 1) {
            codedOutputStream.R(1, this.d.getNumber());
        }
        for (int i = 0; i < this.e.size(); i++) {
            codedOutputStream.c0(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i));
        }
        if ((this.c & 2) == 2) {
            codedOutputStream.c0(3, this.f);
        }
        if ((this.c & 4) == 4) {
            codedOutputStream.R(4, this.g.getNumber());
        }
        codedOutputStream.h0(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iH = (this.c & 1) == 1 ? CodedOutputStream.h(1, this.d.getNumber()) : 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            iH += CodedOutputStream.r(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i2));
        }
        if ((this.c & 2) == 2) {
            iH += CodedOutputStream.r(3, this.f);
        }
        if ((this.c & 4) == 4) {
            iH += CodedOutputStream.h(4, this.g.getNumber());
        }
        int size = iH + this.b.size();
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
        for (int i = 0; i < E(); i++) {
            if (!D(i).isInitialized()) {
                this.h = (byte) 0;
                return false;
            }
        }
        if (!H() || z().isInitialized()) {
            this.h = (byte) 1;
            return true;
        }
        this.h = (byte) 0;
        return false;
    }

    public C7711Sw5 z() {
        return this.f;
    }

    private C7243Qw5(h.b bVar) {
        super(bVar);
        this.h = (byte) -1;
        this.i = -1;
        this.b = bVar.d();
    }

    private C7243Qw5(boolean z) {
        this.h = (byte) -1;
        this.i = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C7243Qw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.h = (byte) -1;
        this.i = -1;
        L();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        char c2 = 0;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            int iM = eVar.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                codedOutputStreamI.n0(iJ);
                                codedOutputStreamI.n0(iM);
                            } else {
                                this.c |= 1;
                                this.d = cVarA;
                            }
                        } else if (iJ == 18) {
                            if ((c2 & 2) != 2) {
                                this.e = new ArrayList();
                                c2 = 2;
                            }
                            this.e.add(eVar.t(C7711Sw5.n, fVar));
                        } else if (iJ == 26) {
                            C7711Sw5.b builder = (this.c & 2) == 2 ? this.f.toBuilder() : null;
                            C7711Sw5 c7711Sw5 = (C7711Sw5) eVar.t(C7711Sw5.n, fVar);
                            this.f = c7711Sw5;
                            if (builder != null) {
                                builder.e(c7711Sw5);
                                this.f = builder.k();
                            }
                            this.c |= 2;
                        } else if (iJ != 32) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            int iM2 = eVar.m();
                            d dVarA = d.a(iM2);
                            if (dVarA == null) {
                                codedOutputStreamI.n0(iJ);
                                codedOutputStreamI.n0(iM2);
                            } else {
                                this.c |= 4;
                                this.g = dVarA;
                            }
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((c2 & 2) == 2) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    try {
                        codedOutputStreamI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = bVarB.e();
                        throw th2;
                    }
                    this.b = bVarB.e();
                    j();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.k(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
            }
        }
        if ((c2 & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        try {
            codedOutputStreamI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.b = bVarB.e();
            throw th3;
        }
        this.b = bVarB.e();
        j();
    }

    /* renamed from: ir.nasim.Qw5$b */
    public static final class b extends h.b implements V64 {
        private int b;
        private c c = c.RETURNS_CONSTANT;
        private List d = Collections.emptyList();
        private C7711Sw5 e = C7711Sw5.J();
        private d f = d.AT_MOST_ONCE;

        private b() {
            o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b m() {
            return new b();
        }

        private void n() {
            if ((this.b & 2) != 2) {
                this.d = new ArrayList(this.d);
                this.b |= 2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C7243Qw5 a() {
            C7243Qw5 c7243Qw5K = k();
            if (c7243Qw5K.isInitialized()) {
                return c7243Qw5K;
            }
            throw a.AbstractC1828a.c(c7243Qw5K);
        }

        public C7243Qw5 k() {
            C7243Qw5 c7243Qw5 = new C7243Qw5(this);
            int i = this.b;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c7243Qw5.d = this.c;
            if ((this.b & 2) == 2) {
                this.d = Collections.unmodifiableList(this.d);
                this.b &= -3;
            }
            c7243Qw5.e = this.d;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            c7243Qw5.f = this.e;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            c7243Qw5.g = this.f;
            c7243Qw5.c = i2;
            return c7243Qw5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return m().e(k());
        }

        public b p(C7711Sw5 c7711Sw5) {
            if ((this.b & 4) != 4 || this.e == C7711Sw5.J()) {
                this.e = c7711Sw5;
            } else {
                this.e = C7711Sw5.X(this.e).e(c7711Sw5).k();
            }
            this.b |= 4;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b e(C7243Qw5 c7243Qw5) {
            if (c7243Qw5 == C7243Qw5.C()) {
                return this;
            }
            if (c7243Qw5.J()) {
                s(c7243Qw5.F());
            }
            if (!c7243Qw5.e.isEmpty()) {
                if (this.d.isEmpty()) {
                    this.d = c7243Qw5.e;
                    this.b &= -3;
                } else {
                    n();
                    this.d.addAll(c7243Qw5.e);
                }
            }
            if (c7243Qw5.H()) {
                p(c7243Qw5.z());
            }
            if (c7243Qw5.K()) {
                t(c7243Qw5.G());
            }
            f(d().h(c7243Qw5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C7243Qw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C7243Qw5.k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Qw5 r3 = (ir.nasim.C7243Qw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Qw5 r4 = (ir.nasim.C7243Qw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7243Qw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Qw5$b");
        }

        public b s(c cVar) {
            cVar.getClass();
            this.b |= 1;
            this.c = cVar;
            return this;
        }

        public b t(d dVar) {
            dVar.getClass();
            this.b |= 8;
            this.f = dVar;
            return this;
        }

        private void o() {
        }
    }
}
