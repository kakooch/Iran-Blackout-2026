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
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.Zw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9427Zw5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C9427Zw5 f;
    public static LW4 g = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private List c;
    private byte d;
    private int e;

    /* renamed from: ir.nasim.Zw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C9427Zw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C9427Zw5(eVar, fVar);
        }
    }

    static {
        C9427Zw5 c9427Zw5 = new C9427Zw5(true);
        f = c9427Zw5;
        c9427Zw5.y();
    }

    public static b C(C9427Zw5 c9427Zw5) {
        return z().e(c9427Zw5);
    }

    public static C9427Zw5 s() {
        return f;
    }

    private void y() {
        this.c = Collections.emptyList();
    }

    public static b z() {
        return b.m();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return C(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.c.size(); i++) {
            codedOutputStream.c0(1, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.c.get(i));
        }
        codedOutputStream.h0(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int iR = 0;
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            iR += CodedOutputStream.r(1, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.c.get(i2));
        }
        int size = iR + this.b.size();
        this.e = size;
        return size;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.d;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < w(); i++) {
            if (!u(i).isInitialized()) {
                this.d = (byte) 0;
                return false;
            }
        }
        this.d = (byte) 1;
        return true;
    }

    public c u(int i) {
        return (c) this.c.get(i);
    }

    public int w() {
        return this.c.size();
    }

    /* renamed from: ir.nasim.Zw5$c */
    public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final c i;
        public static LW4 j = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private int c;
        private int d;
        private int e;
        private EnumC0820c f;
        private byte g;
        private int h;

        /* renamed from: ir.nasim.Zw5$c$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new c(eVar, fVar);
            }
        }

        /* renamed from: ir.nasim.Zw5$c$c, reason: collision with other inner class name */
        public enum EnumC0820c implements i.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);

            private static i.b e = new a();
            private final int a;

            /* renamed from: ir.nasim.Zw5$c$c$a */
            static class a implements i.b {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0820c a(int i) {
                    return EnumC0820c.a(i);
                }
            }

            EnumC0820c(int i, int i2) {
                this.a = i2;
            }

            public static EnumC0820c a(int i) {
                if (i == 0) {
                    return CLASS;
                }
                if (i == 1) {
                    return PACKAGE;
                }
                if (i != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
            public final int getNumber() {
                return this.a;
            }
        }

        static {
            c cVar = new c(true);
            i = cVar;
            cVar.G();
        }

        private void G() {
            this.d = -1;
            this.e = 0;
            this.f = EnumC0820c.PACKAGE;
        }

        public static b H() {
            return b.m();
        }

        public static b J(c cVar) {
            return H().e(cVar);
        }

        public static c w() {
            return i;
        }

        public int C() {
            return this.e;
        }

        public boolean D() {
            return (this.c & 4) == 4;
        }

        public boolean E() {
            return (this.c & 1) == 1;
        }

        public boolean F() {
            return (this.c & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return H();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return J(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public void b(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.Z(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.Z(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.R(3, this.f.getNumber());
            }
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i2 = this.h;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iO += CodedOutputStream.o(2, this.e);
            }
            if ((this.c & 4) == 4) {
                iO += CodedOutputStream.h(3, this.f.getNumber());
            }
            int size = iO + this.b.size();
            this.h = size;
            return size;
        }

        @Override // ir.nasim.V64
        public final boolean isInitialized() {
            byte b2 = this.g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (F()) {
                this.g = (byte) 1;
                return true;
            }
            this.g = (byte) 0;
            return false;
        }

        public EnumC0820c y() {
            return this.f;
        }

        public int z() {
            return this.d;
        }

        private c(h.b bVar) {
            super(bVar);
            this.g = (byte) -1;
            this.h = -1;
            this.b = bVar.d();
        }

        private c(boolean z) {
            this.g = (byte) -1;
            this.h = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.g = (byte) -1;
            this.h = -1;
            G();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int iJ = eVar.J();
                            if (iJ != 0) {
                                if (iJ == 8) {
                                    this.c |= 1;
                                    this.d = eVar.r();
                                } else if (iJ == 16) {
                                    this.c |= 2;
                                    this.e = eVar.r();
                                } else if (iJ != 24) {
                                    if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                    }
                                } else {
                                    int iM = eVar.m();
                                    EnumC0820c enumC0820cA = EnumC0820c.a(iM);
                                    if (enumC0820cA == null) {
                                        codedOutputStreamI.n0(iJ);
                                        codedOutputStreamI.n0(iM);
                                    } else {
                                        this.c |= 4;
                                        this.f = enumC0820cA;
                                    }
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

        /* renamed from: ir.nasim.Zw5$c$b */
        public static final class b extends h.b implements V64 {
            private int b;
            private int d;
            private int c = -1;
            private EnumC0820c e = EnumC0820c.PACKAGE;

            private b() {
                n();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b m() {
                return new b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public c a() {
                c cVarK = k();
                if (cVarK.isInitialized()) {
                    return cVarK;
                }
                throw a.AbstractC1828a.c(cVarK);
            }

            public c k() {
                c cVar = new c(this);
                int i = this.b;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.d = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.e = this.d;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f = this.e;
                cVar.c = i2;
                return cVar;
            }

            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return m().e(k());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b e(c cVar) {
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.E()) {
                    r(cVar.z());
                }
                if (cVar.F()) {
                    s(cVar.C());
                }
                if (cVar.D()) {
                    q(cVar.y());
                }
                f(d().h(cVar.b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.nasim.C9427Zw5.c.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.C9427Zw5.c.j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.Zw5$c r3 = (ir.nasim.C9427Zw5.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    ir.nasim.Zw5$c r4 = (ir.nasim.C9427Zw5.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9427Zw5.c.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Zw5$c$b");
            }

            public b q(EnumC0820c enumC0820c) {
                enumC0820c.getClass();
                this.b |= 4;
                this.e = enumC0820c;
                return this;
            }

            public b r(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            public b s(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            private void n() {
            }
        }
    }

    private C9427Zw5(h.b bVar) {
        super(bVar);
        this.d = (byte) -1;
        this.e = -1;
        this.b = bVar.d();
    }

    private C9427Zw5(boolean z) {
        this.d = (byte) -1;
        this.e = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C9427Zw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.d = (byte) -1;
        this.e = -1;
        y();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ != 10) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.c = new ArrayList();
                                    z2 = true;
                                }
                                this.c.add(eVar.t(c.j, fVar));
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
                if (z2 & true) {
                    this.c = Collections.unmodifiableList(this.c);
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
        }
        if (z2 & true) {
            this.c = Collections.unmodifiableList(this.c);
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

    /* renamed from: ir.nasim.Zw5$b */
    public static final class b extends h.b implements V64 {
        private int b;
        private List c = Collections.emptyList();

        private b() {
            o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b m() {
            return new b();
        }

        private void n() {
            if ((this.b & 1) != 1) {
                this.c = new ArrayList(this.c);
                this.b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C9427Zw5 a() {
            C9427Zw5 c9427Zw5K = k();
            if (c9427Zw5K.isInitialized()) {
                return c9427Zw5K;
            }
            throw a.AbstractC1828a.c(c9427Zw5K);
        }

        public C9427Zw5 k() {
            C9427Zw5 c9427Zw5 = new C9427Zw5(this);
            if ((this.b & 1) == 1) {
                this.c = Collections.unmodifiableList(this.c);
                this.b &= -2;
            }
            c9427Zw5.c = this.c;
            return c9427Zw5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return m().e(k());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b e(C9427Zw5 c9427Zw5) {
            if (c9427Zw5 == C9427Zw5.s()) {
                return this;
            }
            if (!c9427Zw5.c.isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = c9427Zw5.c;
                    this.b &= -2;
                } else {
                    n();
                    this.c.addAll(c9427Zw5.c);
                }
            }
            f(d().h(c9427Zw5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C9427Zw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C9427Zw5.g     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Zw5 r3 = (ir.nasim.C9427Zw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Zw5 r4 = (ir.nasim.C9427Zw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9427Zw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Zw5$b");
        }

        private void o() {
        }
    }
}
