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

/* renamed from: ir.nasim.Pw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6999Pw5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C6999Pw5 f;
    public static LW4 g = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private List c;
    private byte d;
    private int e;

    /* renamed from: ir.nasim.Pw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C6999Pw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C6999Pw5(eVar, fVar);
        }
    }

    static {
        C6999Pw5 c6999Pw5 = new C6999Pw5(true);
        f = c6999Pw5;
        c6999Pw5.y();
    }

    public static b C(C6999Pw5 c6999Pw5) {
        return z().e(c6999Pw5);
    }

    public static C6999Pw5 s() {
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

    public C7243Qw5 u(int i) {
        return (C7243Qw5) this.c.get(i);
    }

    public int w() {
        return this.c.size();
    }

    private C6999Pw5(h.b bVar) {
        super(bVar);
        this.d = (byte) -1;
        this.e = -1;
        this.b = bVar.d();
    }

    private C6999Pw5(boolean z) {
        this.d = (byte) -1;
        this.e = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C6999Pw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.c.add(eVar.t(C7243Qw5.k, fVar));
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

    /* renamed from: ir.nasim.Pw5$b */
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
        public C6999Pw5 a() {
            C6999Pw5 c6999Pw5K = k();
            if (c6999Pw5K.isInitialized()) {
                return c6999Pw5K;
            }
            throw a.AbstractC1828a.c(c6999Pw5K);
        }

        public C6999Pw5 k() {
            C6999Pw5 c6999Pw5 = new C6999Pw5(this);
            if ((this.b & 1) == 1) {
                this.c = Collections.unmodifiableList(this.c);
                this.b &= -2;
            }
            c6999Pw5.c = this.c;
            return c6999Pw5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return m().e(k());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b e(C6999Pw5 c6999Pw5) {
            if (c6999Pw5 == C6999Pw5.s()) {
                return this;
            }
            if (!c6999Pw5.c.isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = c6999Pw5.c;
                    this.b &= -2;
                } else {
                    n();
                    this.c.addAll(c6999Pw5.c);
                }
            }
            f(d().h(c6999Pw5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C6999Pw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C6999Pw5.g     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Pw5 r3 = (ir.nasim.C6999Pw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Pw5 r4 = (ir.nasim.C6999Pw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6999Pw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Pw5$b");
        }

        private void o() {
        }
    }
}
