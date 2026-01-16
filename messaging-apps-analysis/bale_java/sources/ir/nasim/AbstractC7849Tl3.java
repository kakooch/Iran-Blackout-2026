package ir.nasim;

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
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* renamed from: ir.nasim.Tl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7849Tl3 {
    public static final h.f a;
    public static final h.f b;
    public static final h.f c;
    public static final h.f d;
    public static final h.f e;
    public static final h.f f;
    public static final h.f g;
    public static final h.f h;
    public static final h.f i;
    public static final h.f j;
    public static final h.f k;
    public static final h.f l;
    public static final h.f m;
    public static final h.f n;

    /* renamed from: ir.nasim.Tl3$e */
    public static final class e extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final e h;
        public static LW4 i = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private List c;
        private List d;
        private int e;
        private byte f;
        private int g;

        /* renamed from: ir.nasim.Tl3$e$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public e b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new e(eVar, fVar);
            }
        }

        static {
            e eVar = new e(true);
            h = eVar;
            eVar.C();
        }

        private void C() {
            this.c = Collections.emptyList();
            this.d = Collections.emptyList();
        }

        public static b D() {
            return b.m();
        }

        public static b E(e eVar) {
            return D().e(eVar);
        }

        public static e G(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return (e) i.c(inputStream, fVar);
        }

        public static e w() {
            return h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public void b(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                codedOutputStream.c0(1, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.c.get(i2));
            }
            if (y().size() > 0) {
                codedOutputStream.n0(42);
                codedOutputStream.n0(this.e);
            }
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                codedOutputStream.a0(((Integer) this.d.get(i3)).intValue());
            }
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i2 = this.g;
            if (i2 != -1) {
                return i2;
            }
            int iR = 0;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                iR += CodedOutputStream.r(1, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.c.get(i3));
            }
            int iP = 0;
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                iP += CodedOutputStream.p(((Integer) this.d.get(i4)).intValue());
            }
            int iP2 = iR + iP;
            if (!y().isEmpty()) {
                iP2 = iP2 + 1 + CodedOutputStream.p(iP);
            }
            this.e = iP;
            int size = iP2 + this.b.size();
            this.g = size;
            return size;
        }

        @Override // ir.nasim.V64
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        public List y() {
            return this.d;
        }

        public List z() {
            return this.c;
        }

        /* renamed from: ir.nasim.Tl3$e$c */
        public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
            private static final c n;
            public static LW4 o = new a();
            private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
            private int c;
            private int d;
            private int e;
            private Object f;
            private EnumC0666c g;
            private List h;
            private int i;
            private List j;
            private int k;
            private byte l;
            private int m;

            /* renamed from: ir.nasim.Tl3$e$c$a */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
                a() {
                }

                @Override // ir.nasim.LW4
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    return new c(eVar, fVar);
                }
            }

            /* renamed from: ir.nasim.Tl3$e$c$c, reason: collision with other inner class name */
            public enum EnumC0666c implements i.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);

                private static i.b e = new a();
                private final int a;

                /* renamed from: ir.nasim.Tl3$e$c$c$a */
                static class a implements i.b {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0666c a(int i) {
                        return EnumC0666c.a(i);
                    }
                }

                EnumC0666c(int i, int i2) {
                    this.a = i2;
                }

                public static EnumC0666c a(int i) {
                    if (i == 0) {
                        return NONE;
                    }
                    if (i == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
                public final int getNumber() {
                    return this.a;
                }
            }

            static {
                c cVar = new c(true);
                n = cVar;
                cVar.U();
            }

            public static c F() {
                return n;
            }

            private void U() {
                this.d = 1;
                this.e = 0;
                this.f = "";
                this.g = EnumC0666c.NONE;
                this.h = Collections.emptyList();
                this.j = Collections.emptyList();
            }

            public static b V() {
                return b.m();
            }

            public static b W(c cVar) {
                return V().e(cVar);
            }

            public EnumC0666c G() {
                return this.g;
            }

            public int H() {
                return this.e;
            }

            public int J() {
                return this.d;
            }

            public int K() {
                return this.j.size();
            }

            public List L() {
                return this.j;
            }

            public String M() {
                Object obj = this.f;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                String strL = dVar.L();
                if (dVar.A()) {
                    this.f = strL;
                }
                return strL;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.d N() {
                Object obj = this.f;
                if (!(obj instanceof String)) {
                    return (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVarR = kotlin.reflect.jvm.internal.impl.protobuf.d.r((String) obj);
                this.f = dVarR;
                return dVarR;
            }

            public int O() {
                return this.h.size();
            }

            public List P() {
                return this.h;
            }

            public boolean Q() {
                return (this.c & 8) == 8;
            }

            public boolean R() {
                return (this.c & 2) == 2;
            }

            public boolean S() {
                return (this.c & 1) == 1;
            }

            public boolean T() {
                return (this.c & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            /* renamed from: X, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType() {
                return V();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            /* renamed from: Y, reason: merged with bridge method [inline-methods] */
            public b toBuilder() {
                return W(this);
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
                if ((this.c & 8) == 8) {
                    codedOutputStream.R(3, this.g.getNumber());
                }
                if (P().size() > 0) {
                    codedOutputStream.n0(34);
                    codedOutputStream.n0(this.i);
                }
                for (int i = 0; i < this.h.size(); i++) {
                    codedOutputStream.a0(((Integer) this.h.get(i)).intValue());
                }
                if (L().size() > 0) {
                    codedOutputStream.n0(42);
                    codedOutputStream.n0(this.k);
                }
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    codedOutputStream.a0(((Integer) this.j.get(i2)).intValue());
                }
                if ((this.c & 4) == 4) {
                    codedOutputStream.N(6, N());
                }
                codedOutputStream.h0(this.b);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            public int getSerializedSize() {
                int i = this.m;
                if (i != -1) {
                    return i;
                }
                int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    iO += CodedOutputStream.o(2, this.e);
                }
                if ((this.c & 8) == 8) {
                    iO += CodedOutputStream.h(3, this.g.getNumber());
                }
                int iP = 0;
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    iP += CodedOutputStream.p(((Integer) this.h.get(i2)).intValue());
                }
                int iP2 = iO + iP;
                if (!P().isEmpty()) {
                    iP2 = iP2 + 1 + CodedOutputStream.p(iP);
                }
                this.i = iP;
                int iP3 = 0;
                for (int i3 = 0; i3 < this.j.size(); i3++) {
                    iP3 += CodedOutputStream.p(((Integer) this.j.get(i3)).intValue());
                }
                int iD = iP2 + iP3;
                if (!L().isEmpty()) {
                    iD = iD + 1 + CodedOutputStream.p(iP3);
                }
                this.k = iP3;
                if ((this.c & 4) == 4) {
                    iD += CodedOutputStream.d(6, N());
                }
                int size = iD + this.b.size();
                this.m = size;
                return size;
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
                this.l = (byte) 1;
                return true;
            }

            private c(h.b bVar) {
                super(bVar);
                this.i = -1;
                this.k = -1;
                this.l = (byte) -1;
                this.m = -1;
                this.b = bVar.d();
            }

            private c(boolean z) {
                this.i = -1;
                this.k = -1;
                this.l = (byte) -1;
                this.m = -1;
                this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
            }

            /* renamed from: ir.nasim.Tl3$e$c$b */
            public static final class b extends h.b implements V64 {
                private int b;
                private int d;
                private int c = 1;
                private Object e = "";
                private EnumC0666c f = EnumC0666c.NONE;
                private List g = Collections.emptyList();
                private List h = Collections.emptyList();

                private b() {
                    p();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b m() {
                    return new b();
                }

                private void n() {
                    if ((this.b & 32) != 32) {
                        this.h = new ArrayList(this.h);
                        this.b |= 32;
                    }
                }

                private void o() {
                    if ((this.b & 16) != 16) {
                        this.g = new ArrayList(this.g);
                        this.b |= 16;
                    }
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
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    cVar.g = this.f;
                    if ((this.b & 16) == 16) {
                        this.g = Collections.unmodifiableList(this.g);
                        this.b &= -17;
                    }
                    cVar.h = this.g;
                    if ((this.b & 32) == 32) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.b &= -33;
                    }
                    cVar.j = this.h;
                    cVar.c = i2;
                    return cVar;
                }

                /* renamed from: l, reason: merged with bridge method [inline-methods] */
                public b clone() {
                    return m().e(k());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b e(c cVar) {
                    if (cVar == c.F()) {
                        return this;
                    }
                    if (cVar.S()) {
                        u(cVar.J());
                    }
                    if (cVar.R()) {
                        t(cVar.H());
                    }
                    if (cVar.T()) {
                        this.b |= 4;
                        this.e = cVar.f;
                    }
                    if (cVar.Q()) {
                        s(cVar.G());
                    }
                    if (!cVar.h.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = cVar.h;
                            this.b &= -17;
                        } else {
                            o();
                            this.g.addAll(cVar.h);
                        }
                    }
                    if (!cVar.j.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = cVar.j;
                            this.b &= -33;
                        } else {
                            n();
                            this.h.addAll(cVar.j);
                        }
                    }
                    f(d().h(cVar.b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public ir.nasim.AbstractC7849Tl3.e.c.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        ir.nasim.LW4 r1 = ir.nasim.AbstractC7849Tl3.e.c.o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        ir.nasim.Tl3$e$c r3 = (ir.nasim.AbstractC7849Tl3.e.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        ir.nasim.Tl3$e$c r4 = (ir.nasim.AbstractC7849Tl3.e.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7849Tl3.e.c.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Tl3$e$c$b");
                }

                public b s(EnumC0666c enumC0666c) {
                    enumC0666c.getClass();
                    this.b |= 8;
                    this.f = enumC0666c;
                    return this;
                }

                public b t(int i) {
                    this.b |= 2;
                    this.d = i;
                    return this;
                }

                public b u(int i) {
                    this.b |= 1;
                    this.c = i;
                    return this;
                }

                private void p() {
                }
            }

            private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                this.i = -1;
                this.k = -1;
                this.l = (byte) -1;
                this.m = -1;
                U();
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
                                    this.c |= 1;
                                    this.d = eVar.r();
                                } else if (iJ == 16) {
                                    this.c |= 2;
                                    this.e = eVar.r();
                                } else if (iJ == 24) {
                                    int iM = eVar.m();
                                    EnumC0666c enumC0666cA = EnumC0666c.a(iM);
                                    if (enumC0666cA == null) {
                                        codedOutputStreamI.n0(iJ);
                                        codedOutputStreamI.n0(iM);
                                    } else {
                                        this.c |= 8;
                                        this.g = enumC0666cA;
                                    }
                                } else if (iJ == 32) {
                                    if ((i & 16) != 16) {
                                        this.h = new ArrayList();
                                        i |= 16;
                                    }
                                    this.h.add(Integer.valueOf(eVar.r()));
                                } else if (iJ == 34) {
                                    int i2 = eVar.i(eVar.z());
                                    if ((i & 16) != 16 && eVar.e() > 0) {
                                        this.h = new ArrayList();
                                        i |= 16;
                                    }
                                    while (eVar.e() > 0) {
                                        this.h.add(Integer.valueOf(eVar.r()));
                                    }
                                    eVar.h(i2);
                                } else if (iJ == 40) {
                                    if ((i & 32) != 32) {
                                        this.j = new ArrayList();
                                        i |= 32;
                                    }
                                    this.j.add(Integer.valueOf(eVar.r()));
                                } else if (iJ == 42) {
                                    int i3 = eVar.i(eVar.z());
                                    if ((i & 32) != 32 && eVar.e() > 0) {
                                        this.j = new ArrayList();
                                        i |= 32;
                                    }
                                    while (eVar.e() > 0) {
                                        this.j.add(Integer.valueOf(eVar.r()));
                                    }
                                    eVar.h(i3);
                                } else if (iJ != 50) {
                                    if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                    }
                                } else {
                                    kotlin.reflect.jvm.internal.impl.protobuf.d dVarK = eVar.k();
                                    this.c |= 4;
                                    this.f = dVarK;
                                }
                            }
                            z = true;
                        } catch (Throwable th) {
                            if ((i & 16) == 16) {
                                this.h = Collections.unmodifiableList(this.h);
                            }
                            if ((i & 32) == 32) {
                                this.j = Collections.unmodifiableList(this.j);
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
                if ((i & 16) == 16) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                if ((i & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
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
        }

        private e(h.b bVar) {
            super(bVar);
            this.e = -1;
            this.f = (byte) -1;
            this.g = -1;
            this.b = bVar.d();
        }

        private e(boolean z) {
            this.e = -1;
            this.f = (byte) -1;
            this.g = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.e = -1;
            this.f = (byte) -1;
            this.g = -1;
            C();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            int i2 = 0;
            while (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                if ((i2 & 1) != 1) {
                                    this.c = new ArrayList();
                                    i2 |= 1;
                                }
                                this.c.add(eVar.t(c.o, fVar));
                            } else if (iJ == 40) {
                                if ((i2 & 2) != 2) {
                                    this.d = new ArrayList();
                                    i2 |= 2;
                                }
                                this.d.add(Integer.valueOf(eVar.r()));
                            } else if (iJ != 42) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                int i3 = eVar.i(eVar.z());
                                if ((i2 & 2) != 2 && eVar.e() > 0) {
                                    this.d = new ArrayList();
                                    i2 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.d.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i3);
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.k(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                    }
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.c = Collections.unmodifiableList(this.c);
                    }
                    if ((i2 & 2) == 2) {
                        this.d = Collections.unmodifiableList(this.d);
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
            if ((i2 & 1) == 1) {
                this.c = Collections.unmodifiableList(this.c);
            }
            if ((i2 & 2) == 2) {
                this.d = Collections.unmodifiableList(this.d);
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

        /* renamed from: ir.nasim.Tl3$e$b */
        public static final class b extends h.b implements V64 {
            private int b;
            private List c = Collections.emptyList();
            private List d = Collections.emptyList();

            private b() {
                p();
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

            private void o() {
                if ((this.b & 1) != 1) {
                    this.c = new ArrayList(this.c);
                    this.b |= 1;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public e a() {
                e eVarK = k();
                if (eVarK.isInitialized()) {
                    return eVarK;
                }
                throw a.AbstractC1828a.c(eVarK);
            }

            public e k() {
                e eVar = new e(this);
                if ((this.b & 1) == 1) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.b &= -2;
                }
                eVar.c = this.c;
                if ((this.b & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.b &= -3;
                }
                eVar.d = this.d;
                return eVar;
            }

            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return m().e(k());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b e(e eVar) {
                if (eVar == e.w()) {
                    return this;
                }
                if (!eVar.c.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = eVar.c;
                        this.b &= -2;
                    } else {
                        o();
                        this.c.addAll(eVar.c);
                    }
                }
                if (!eVar.d.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = eVar.d;
                        this.b &= -3;
                    } else {
                        n();
                        this.d.addAll(eVar.d);
                    }
                }
                f(d().h(eVar.b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.nasim.AbstractC7849Tl3.e.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.AbstractC7849Tl3.e.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.Tl3$e r3 = (ir.nasim.AbstractC7849Tl3.e) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    ir.nasim.Tl3$e r4 = (ir.nasim.AbstractC7849Tl3.e) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7849Tl3.e.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Tl3$e$b");
            }

            private void p() {
            }
        }
    }

    static {
        C6765Ow5 c6765Ow5L = C6765Ow5.L();
        c cVarU = c.u();
        c cVarU2 = c.u();
        p.b bVar = p.b.m;
        a = kotlin.reflect.jvm.internal.impl.protobuf.h.l(c6765Ow5L, cVarU, cVarU2, null, 100, bVar, c.class);
        b = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C7950Tw5.W(), c.u(), c.u(), null, 100, bVar, c.class);
        C7950Tw5 c7950Tw5W = C7950Tw5.W();
        p.b bVar2 = p.b.g;
        c = kotlin.reflect.jvm.internal.impl.protobuf.h.l(c7950Tw5W, 0, null, null, 101, bVar2, Integer.class);
        d = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C9193Yw5.U(), d.y(), d.y(), null, 100, bVar, d.class);
        e = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C9193Yw5.U(), 0, null, null, 101, bVar2, Integer.class);
        f = kotlin.reflect.jvm.internal.impl.protobuf.h.k(C10647bx5.b0(), C6266Mw5.C(), null, 100, bVar, false, C6266Mw5.class);
        g = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C10647bx5.b0(), Boolean.FALSE, null, null, 101, p.b.j, Boolean.class);
        h = kotlin.reflect.jvm.internal.impl.protobuf.h.k(C12053dx5.O(), C6266Mw5.C(), null, 100, bVar, false, C6266Mw5.class);
        i = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C6526Nw5.m0(), 0, null, null, 101, bVar2, Integer.class);
        j = kotlin.reflect.jvm.internal.impl.protobuf.h.k(C6526Nw5.m0(), C9193Yw5.U(), null, 102, bVar, false, C9193Yw5.class);
        k = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C6526Nw5.m0(), 0, null, null, 103, bVar2, Integer.class);
        l = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C6526Nw5.m0(), 0, null, null, 104, bVar2, Integer.class);
        m = kotlin.reflect.jvm.internal.impl.protobuf.h.l(C8652Ww5.O(), 0, null, null, 101, bVar2, Integer.class);
        n = kotlin.reflect.jvm.internal.impl.protobuf.h.k(C8652Ww5.O(), C9193Yw5.U(), null, 102, bVar, false, C9193Yw5.class);
    }

    public static void a(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        fVar.a(a);
        fVar.a(b);
        fVar.a(c);
        fVar.a(d);
        fVar.a(e);
        fVar.a(f);
        fVar.a(g);
        fVar.a(h);
        fVar.a(i);
        fVar.a(j);
        fVar.a(k);
        fVar.a(l);
        fVar.a(m);
        fVar.a(n);
    }

    /* renamed from: ir.nasim.Tl3$b */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final b h;
        public static LW4 i = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private int c;
        private int d;
        private int e;
        private byte f;
        private int g;

        /* renamed from: ir.nasim.Tl3$b$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new b(eVar, fVar);
            }
        }

        static {
            b bVar = new b(true);
            h = bVar;
            bVar.D();
        }

        private void D() {
            this.d = 0;
            this.e = 0;
        }

        public static C0665b E() {
            return C0665b.m();
        }

        public static C0665b F(b bVar) {
            return E().e(bVar);
        }

        public static b u() {
            return h;
        }

        public boolean C() {
            return (this.c & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0665b newBuilderForType() {
            return E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public C0665b toBuilder() {
            return F(this);
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
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i2 = this.g;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iO += CodedOutputStream.o(2, this.e);
            }
            int size = iO + this.b.size();
            this.g = size;
            return size;
        }

        @Override // ir.nasim.V64
        public final boolean isInitialized() {
            byte b = this.f;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        public int w() {
            return this.e;
        }

        public int y() {
            return this.d;
        }

        public boolean z() {
            return (this.c & 2) == 2;
        }

        private b(h.b bVar) {
            super(bVar);
            this.f = (byte) -1;
            this.g = -1;
            this.b = bVar.d();
        }

        private b(boolean z) {
            this.f = (byte) -1;
            this.g = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.f = (byte) -1;
            this.g = -1;
            D();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.c |= 1;
                                this.d = eVar.r();
                            } else if (iJ != 16) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                this.c |= 2;
                                this.e = eVar.r();
                            }
                        }
                        z = true;
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.k(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
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

        /* renamed from: ir.nasim.Tl3$b$b, reason: collision with other inner class name */
        public static final class C0665b extends h.b implements V64 {
            private int b;
            private int c;
            private int d;

            private C0665b() {
                n();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0665b m() {
                return new C0665b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public b a() {
                b bVarK = k();
                if (bVarK.isInitialized()) {
                    return bVarK;
                }
                throw a.AbstractC1828a.c(bVarK);
            }

            public b k() {
                b bVar = new b(this);
                int i = this.b;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.d = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.e = this.d;
                bVar.c = i2;
                return bVar;
            }

            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public C0665b clone() {
                return m().e(k());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0665b e(b bVar) {
                if (bVar == b.u()) {
                    return this;
                }
                if (bVar.C()) {
                    r(bVar.y());
                }
                if (bVar.z()) {
                    q(bVar.w());
                }
                f(d().h(bVar.b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.nasim.AbstractC7849Tl3.b.C0665b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.AbstractC7849Tl3.b.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.Tl3$b r3 = (ir.nasim.AbstractC7849Tl3.b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    ir.nasim.Tl3$b r4 = (ir.nasim.AbstractC7849Tl3.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7849Tl3.b.C0665b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Tl3$b$b");
            }

            public C0665b q(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            public C0665b r(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            private void n() {
            }
        }
    }

    /* renamed from: ir.nasim.Tl3$c */
    public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final c h;
        public static LW4 i = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private int c;
        private int d;
        private int e;
        private byte f;
        private int g;

        /* renamed from: ir.nasim.Tl3$c$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new c(eVar, fVar);
            }
        }

        static {
            c cVar = new c(true);
            h = cVar;
            cVar.D();
        }

        private void D() {
            this.d = 0;
            this.e = 0;
        }

        public static b E() {
            return b.m();
        }

        public static b F(c cVar) {
            return E().e(cVar);
        }

        public static c u() {
            return h;
        }

        public boolean C() {
            return (this.c & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return F(this);
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
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i2 = this.g;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iO += CodedOutputStream.o(2, this.e);
            }
            int size = iO + this.b.size();
            this.g = size;
            return size;
        }

        @Override // ir.nasim.V64
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        public int w() {
            return this.e;
        }

        public int y() {
            return this.d;
        }

        public boolean z() {
            return (this.c & 2) == 2;
        }

        private c(h.b bVar) {
            super(bVar);
            this.f = (byte) -1;
            this.g = -1;
            this.b = bVar.d();
        }

        private c(boolean z) {
            this.f = (byte) -1;
            this.g = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.f = (byte) -1;
            this.g = -1;
            D();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.c |= 1;
                                this.d = eVar.r();
                            } else if (iJ != 16) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                this.c |= 2;
                                this.e = eVar.r();
                            }
                        }
                        z = true;
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.k(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
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

        /* renamed from: ir.nasim.Tl3$c$b */
        public static final class b extends h.b implements V64 {
            private int b;
            private int c;
            private int d;

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
                if (cVar == c.u()) {
                    return this;
                }
                if (cVar.C()) {
                    r(cVar.y());
                }
                if (cVar.z()) {
                    q(cVar.w());
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
            public ir.nasim.AbstractC7849Tl3.c.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.AbstractC7849Tl3.c.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.Tl3$c r3 = (ir.nasim.AbstractC7849Tl3.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    ir.nasim.Tl3$c r4 = (ir.nasim.AbstractC7849Tl3.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7849Tl3.c.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Tl3$c$b");
            }

            public b q(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            public b r(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            private void n() {
            }
        }
    }

    /* renamed from: ir.nasim.Tl3$d */
    public static final class d extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final d j;
        public static LW4 k = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private int c;
        private b d;
        private c e;
        private c f;
        private c g;
        private byte h;
        private int i;

        /* renamed from: ir.nasim.Tl3$d$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public d b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new d(eVar, fVar);
            }
        }

        static {
            d dVar = new d(true);
            j = dVar;
            dVar.K();
        }

        private void K() {
            this.d = b.u();
            this.e = c.u();
            this.f = c.u();
            this.g = c.u();
        }

        public static b L() {
            return b.m();
        }

        public static b M(d dVar) {
            return L().e(dVar);
        }

        public static d y() {
            return j;
        }

        public c C() {
            return this.f;
        }

        public c D() {
            return this.g;
        }

        public c E() {
            return this.e;
        }

        public boolean F() {
            return (this.c & 1) == 1;
        }

        public boolean G() {
            return (this.c & 4) == 4;
        }

        public boolean H() {
            return (this.c & 8) == 8;
        }

        public boolean J() {
            return (this.c & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return L();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return M(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public void b(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.c0(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.c0(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.c0(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.c0(4, this.g);
            }
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i = this.i;
            if (i != -1) {
                return i;
            }
            int iR = (this.c & 1) == 1 ? CodedOutputStream.r(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iR += CodedOutputStream.r(2, this.e);
            }
            if ((this.c & 4) == 4) {
                iR += CodedOutputStream.r(3, this.f);
            }
            if ((this.c & 8) == 8) {
                iR += CodedOutputStream.r(4, this.g);
            }
            int size = iR + this.b.size();
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
            this.h = (byte) 1;
            return true;
        }

        public b z() {
            return this.d;
        }

        private d(h.b bVar) {
            super(bVar);
            this.h = (byte) -1;
            this.i = -1;
            this.b = bVar.d();
        }

        private d(boolean z) {
            this.h = (byte) -1;
            this.i = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.h = (byte) -1;
            this.i = -1;
            K();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                b.C0665b builder = (this.c & 1) == 1 ? this.d.toBuilder() : null;
                                b bVar = (b) eVar.t(b.i, fVar);
                                this.d = bVar;
                                if (builder != null) {
                                    builder.e(bVar);
                                    this.d = builder.k();
                                }
                                this.c |= 1;
                            } else if (iJ == 18) {
                                c.b builder2 = (this.c & 2) == 2 ? this.e.toBuilder() : null;
                                c cVar = (c) eVar.t(c.i, fVar);
                                this.e = cVar;
                                if (builder2 != null) {
                                    builder2.e(cVar);
                                    this.e = builder2.k();
                                }
                                this.c |= 2;
                            } else if (iJ == 26) {
                                c.b builder3 = (this.c & 4) == 4 ? this.f.toBuilder() : null;
                                c cVar2 = (c) eVar.t(c.i, fVar);
                                this.f = cVar2;
                                if (builder3 != null) {
                                    builder3.e(cVar2);
                                    this.f = builder3.k();
                                }
                                this.c |= 4;
                            } else if (iJ != 34) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                c.b builder4 = (this.c & 8) == 8 ? this.g.toBuilder() : null;
                                c cVar3 = (c) eVar.t(c.i, fVar);
                                this.g = cVar3;
                                if (builder4 != null) {
                                    builder4.e(cVar3);
                                    this.g = builder4.k();
                                }
                                this.c |= 8;
                            }
                        }
                        z = true;
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.k(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
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

        /* renamed from: ir.nasim.Tl3$d$b */
        public static final class b extends h.b implements V64 {
            private int b;
            private b c = b.u();
            private c d = c.u();
            private c e = c.u();
            private c f = c.u();

            private b() {
                n();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b m() {
                return new b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public d a() {
                d dVarK = k();
                if (dVarK.isInitialized()) {
                    return dVarK;
                }
                throw a.AbstractC1828a.c(dVarK);
            }

            public d k() {
                d dVar = new d(this);
                int i = this.b;
                int i2 = (i & 1) != 1 ? 0 : 1;
                dVar.d = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                dVar.e = this.d;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                dVar.f = this.e;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                dVar.g = this.f;
                dVar.c = i2;
                return dVar;
            }

            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return m().e(k());
            }

            public b o(b bVar) {
                if ((this.b & 1) != 1 || this.c == b.u()) {
                    this.c = bVar;
                } else {
                    this.c = b.F(this.c).e(bVar).k();
                }
                this.b |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b e(d dVar) {
                if (dVar == d.y()) {
                    return this;
                }
                if (dVar.F()) {
                    o(dVar.z());
                }
                if (dVar.J()) {
                    t(dVar.E());
                }
                if (dVar.G()) {
                    r(dVar.C());
                }
                if (dVar.H()) {
                    s(dVar.D());
                }
                f(d().h(dVar.b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.nasim.AbstractC7849Tl3.d.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.AbstractC7849Tl3.d.k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.Tl3$d r3 = (ir.nasim.AbstractC7849Tl3.d) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    ir.nasim.Tl3$d r4 = (ir.nasim.AbstractC7849Tl3.d) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7849Tl3.d.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Tl3$d$b");
            }

            public b r(c cVar) {
                if ((this.b & 4) != 4 || this.e == c.u()) {
                    this.e = cVar;
                } else {
                    this.e = c.F(this.e).e(cVar).k();
                }
                this.b |= 4;
                return this;
            }

            public b s(c cVar) {
                if ((this.b & 8) != 8 || this.f == c.u()) {
                    this.f = cVar;
                } else {
                    this.f = c.F(this.f).e(cVar).k();
                }
                this.b |= 8;
                return this;
            }

            public b t(c cVar) {
                if ((this.b & 2) != 2 || this.d == c.u()) {
                    this.d = cVar;
                } else {
                    this.d = c.F(this.d).e(cVar).k();
                }
                this.b |= 2;
                return this;
            }

            private void n() {
            }
        }
    }
}
