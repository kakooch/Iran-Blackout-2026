package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.InterfaceC23654xH7;
import ir.nasim.JH7;
import ir.nasim.TH1;
import ir.nasim.Y06;
import ir.nasim.ZG7;
import ir.nasim.core.modules.file.FileSizeExceededException;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.settings.SettingsModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* renamed from: ir.nasim.Sz4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C7737Sz4 implements VH7 {
    public static final C7738a H = new C7738a(null);
    public static final int I = 8;
    private static final String J = "chunk";
    private final int A;
    private final long B;
    private final int C;
    private final InterfaceC9336Zm4 D;
    private final InterfaceC9173Yu3 E;
    private final InterfaceC13730gj3 F;
    private final InterfaceC22299v01 G;
    private final long a;
    private final long b;
    private final String c;
    private final String d;
    private final String e;
    private final ExPeer f;
    private final C9528a7 g;
    private final AbstractC13778go1 h;
    private final InterfaceC3570Bk5 i;
    private final OkHttpClient j;
    private final InterfaceC12532em2 k;
    private final EnumC4543Fo6 l;
    private final InterfaceC14603iB2 m;
    private final InterfaceC4557Fq2 n;
    private final InterfaceC24838zH7 o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final InterfaceC14371ho1 x;
    private final InterfaceC20315ro1 y;
    private final int z;

    /* renamed from: ir.nasim.Sz4$A */
    static final class A extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.F0(null, null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WG7 d;
        final /* synthetic */ VI5 e;
        final /* synthetic */ InterfaceC9336Zm4 f;
        final /* synthetic */ JH7.b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(WG7 wg7, VI5 vi5, InterfaceC9336Zm4 interfaceC9336Zm4, JH7.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = wg7;
            this.e = vi5;
            this.f = interfaceC9336Zm4;
            this.g = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new B(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.b
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L29
                if (r1 == r5) goto L25
                if (r1 == r4) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ir.nasim.AbstractC10685c16.b(r15)
                goto L9a
            L19:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L21:
                ir.nasim.AbstractC10685c16.b(r15)
                goto L86
            L25:
                ir.nasim.AbstractC10685c16.b(r15)
                goto L56
            L29:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.Vt0 r15 = ir.nasim.C8386Vt0.a
                boolean r15 = r15.N3()
                if (r15 == 0) goto L45
                ir.nasim.Sz4 r15 = ir.nasim.C7737Sz4.this
                ir.nasim.WG7 r1 = r14.d
                ir.nasim.VI5 r4 = r14.e
                ir.nasim.Zm4 r6 = r14.f
                r14.b = r5
                java.lang.Object r15 = ir.nasim.C7737Sz4.f(r15, r1, r4, r6, r14)
                if (r15 != r0) goto L56
                return r0
            L45:
                ir.nasim.Sz4 r15 = ir.nasim.C7737Sz4.this
                ir.nasim.WG7 r1 = r14.d
                ir.nasim.VI5 r5 = r14.e
                ir.nasim.Zm4 r6 = r14.f
                r14.b = r4
                java.lang.Object r15 = ir.nasim.C7737Sz4.g(r15, r1, r5, r6, r14)
                if (r15 != r0) goto L56
                return r0
            L56:
                ir.nasim.Vt0 r15 = ir.nasim.C8386Vt0.a
                boolean r15 = r15.J3()
                if (r15 == 0) goto L72
                ir.nasim.Sz4 r15 = ir.nasim.C7737Sz4.this
                ir.nasim.a7 r15 = ir.nasim.C7737Sz4.o(r15)
                ir.nasim.IH7 r1 = new ir.nasim.IH7
                ir.nasim.Sz4 r4 = ir.nasim.C7737Sz4.this
                long r4 = ir.nasim.C7737Sz4.s(r4)
                r1.<init>(r4)
                r15.d(r1)
            L72:
                ir.nasim.Sz4 r6 = ir.nasim.C7737Sz4.this
                ir.nasim.JH7$b r7 = r14.g
                ir.nasim.WG7 r8 = r14.d
                r14.b = r3
                r9 = 0
                r12 = 4
                r13 = 0
                r11 = r14
                java.lang.Object r15 = ir.nasim.C7737Sz4.B0(r6, r7, r8, r9, r11, r12, r13)
                if (r15 != r0) goto L86
                return r0
            L86:
                java.lang.Boolean r15 = (java.lang.Boolean) r15
                boolean r15 = r15.booleanValue()
                if (r15 == 0) goto L9a
                ir.nasim.Sz4 r15 = ir.nasim.C7737Sz4.this
                r14.b = r2
                r1 = 0
                java.lang.Object r15 = ir.nasim.C7737Sz4.h(r15, r1, r14)
                if (r15 != r0) goto L9a
                return r0
            L9a:
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.B.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ VI5 e;
        final /* synthetic */ C7737Sz4 f;
        final /* synthetic */ String g;
        final /* synthetic */ InterfaceC9336Zm4 h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(VI5 vi5, C7737Sz4 c7737Sz4, String str, InterfaceC9336Zm4 interfaceC9336Zm4, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = vi5;
            this.f = c7737Sz4;
            this.g = str;
            this.h = interfaceC9336Zm4;
            this.i = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C(this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0047 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0072 -> B:21:0x0073). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r8 = r16
                java.lang.Object r9 = ir.nasim.AbstractC13660gc3.e()
                int r0 = r8.d
                r10 = 0
                r11 = 0
                r12 = 2
                r13 = 1
                if (r0 == 0) goto L32
                if (r0 == r13) goto L27
                if (r0 != r12) goto L1f
                java.lang.Object r0 = r8.c
                ir.nasim.IT0 r0 = (ir.nasim.IT0) r0
                java.lang.Object r1 = r8.b
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                ir.nasim.AbstractC10685c16.b(r17)
                r14 = r1
                goto L73
            L1f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L27:
                java.lang.Object r0 = r8.b
                ir.nasim.CJ0 r0 = (ir.nasim.CJ0) r0
                ir.nasim.AbstractC10685c16.b(r17)
                r1 = r17
            L30:
                r14 = r0
                goto L48
            L32:
                ir.nasim.AbstractC10685c16.b(r17)
                ir.nasim.VI5 r0 = r8.e
                ir.nasim.CJ0 r0 = r0.iterator()
            L3b:
                r8.b = r0
                r8.c = r11
                r8.d = r13
                java.lang.Object r1 = r0.a(r8)
                if (r1 != r9) goto L30
                return r9
            L48:
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r0 = r1.booleanValue()
                if (r0 == 0) goto L9a
                java.lang.Object r0 = r14.next()
                r15 = r0
                ir.nasim.IT0 r15 = (ir.nasim.IT0) r15
                ir.nasim.Sz4 r0 = r8.f
                okhttp3.OkHttpClient r1 = ir.nasim.C7737Sz4.p(r0)
                java.lang.String r3 = r8.g
                r8.b = r14
                r8.c = r15
                r8.d = r12
                r4 = 0
                r6 = 4
                r7 = 0
                r2 = r15
                r5 = r16
                java.lang.Object r0 = ir.nasim.C7737Sz4.G0(r0, r1, r2, r3, r4, r5, r6, r7)
                if (r0 != r9) goto L72
                return r9
            L72:
                r0 = r15
            L73:
                ir.nasim.Zm4 r1 = r8.h
            L75:
                java.lang.Object r2 = r1.getValue()
                r3 = r2
                ir.nasim.Sz4$c r3 = (ir.nasim.C7737Sz4.C7740c) r3
                java.util.List r4 = r3.c()
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                int r5 = r0.c()
                java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                java.util.List r4 = ir.nasim.ZW0.O0(r4, r5)
                ir.nasim.Sz4$c r3 = ir.nasim.C7737Sz4.C7740c.b(r3, r10, r4, r13, r11)
                boolean r2 = r1.f(r2, r3)
                if (r2 == 0) goto L75
                r0 = r14
                goto L3b
            L9a:
                ir.nasim.Sz4 r0 = r8.f
                java.lang.String r0 = r0.e0()
                int r1 = r8.i
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "worker("
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = ") ended"
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.Object[] r2 = new java.lang.Object[r10]
                ir.nasim.C19406qI3.j(r0, r1, r2)
                ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.C.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$a, reason: case insensitive filesystem */
    public static final class C7738a {
        private C7738a() {
        }

        public final String a() {
            return C7737Sz4.J;
        }

        public /* synthetic */ C7738a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Sz4$b, reason: case insensitive filesystem */
    private static final class C7739b extends Exception {
        public C7739b() {
            super("Upload file has been expired");
        }
    }

    /* renamed from: ir.nasim.Sz4$d */
    private static final class d extends Exception {
        public d() {
            super("Upload url has been expired");
        }
    }

    /* renamed from: ir.nasim.Sz4$e */
    protected static final class e {
        private final String a;
        private final long b;
        private final boolean c;

        public e(String str, long j, boolean z) {
            AbstractC13042fc3.i(str, "url");
            this.a = str;
            this.b = j;
            this.c = z;
        }

        public final long a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public final boolean c() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.Sz4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ VI5 e;
        final /* synthetic */ WG7 f;
        final /* synthetic */ InterfaceC9336Zm4 g;

        /* renamed from: ir.nasim.Sz4$f$a */
        public static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C7737Sz4 d;
            final /* synthetic */ ArrayList e;
            final /* synthetic */ C12106e30 f;
            final /* synthetic */ C11637dL5 g;
            final /* synthetic */ WG7 h;
            final /* synthetic */ TH1 i;
            final /* synthetic */ InterfaceC9336Zm4 j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC20295rm1 interfaceC20295rm1, C7737Sz4 c7737Sz4, ArrayList arrayList, C12106e30 c12106e30, C11637dL5 c11637dL5, WG7 wg7, TH1 th1, InterfaceC9336Zm4 interfaceC9336Zm4) {
                super(2, interfaceC20295rm1);
                this.d = c7737Sz4;
                this.e = arrayList;
                this.f = c12106e30;
                this.g = c11637dL5;
                this.h = wg7;
                this.i = th1;
                this.j = interfaceC9336Zm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    XG7 xg7 = (XG7) this.c;
                    long jA = xg7.a();
                    int iB = xg7.b();
                    int i2 = 0;
                    C19406qI3.a(this.d.e0(), "Chunks count changed: " + this.e.size() + " -> " + iB, new Object[0]);
                    this.f.b(jA);
                    if (this.e.size() > iB) {
                        int size = this.e.size() - iB;
                        while (i2 < size) {
                            ArrayList arrayList = this.e;
                            InterfaceC13730gj3.a.a((InterfaceC13730gj3) arrayList.remove(AbstractC10360bX0.o(arrayList)), null, 1, null);
                            i2++;
                        }
                    } else if (this.e.size() < iB) {
                        int size2 = iB - this.e.size();
                        while (i2 < size2) {
                            C11637dL5 c11637dL5 = this.g;
                            int i3 = c11637dL5.a;
                            c11637dL5.a = i3 + 1;
                            this.e.add(this.d.Q(i3, this.h.h(), this.i, this.f, this.j));
                            i2++;
                        }
                    }
                    ArrayList arrayList2 = this.e;
                    this.b = 1;
                    if (AbstractC24549yo1.a(arrayList2, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(obj, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sz4$f$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C7737Sz4 b;
            final /* synthetic */ WG7 c;

            /* renamed from: ir.nasim.Sz4$f$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C7737Sz4 b;
                final /* synthetic */ WG7 c;

                /* renamed from: ir.nasim.Sz4$f$b$a$a, reason: collision with other inner class name */
                public static final class C0635a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0635a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C7737Sz4 c7737Sz4, WG7 wg7) {
                    this.a = interfaceC4806Gq2;
                    this.b = c7737Sz4;
                    this.c = wg7;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r11, ir.nasim.InterfaceC20295rm1 r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof ir.nasim.C7737Sz4.f.b.a.C0635a
                        if (r0 == 0) goto L13
                        r0 = r12
                        ir.nasim.Sz4$f$b$a$a r0 = (ir.nasim.C7737Sz4.f.b.a.C0635a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Sz4$f$b$a$a r0 = new ir.nasim.Sz4$f$b$a$a
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        ir.nasim.AbstractC10685c16.b(r12)
                        goto La5
                    L2a:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L32:
                        ir.nasim.AbstractC10685c16.b(r12)
                        ir.nasim.Gq2 r12 = r10.a
                        r4 = r11
                        ir.nasim.XG7 r4 = (ir.nasim.XG7) r4
                        ir.nasim.Sz4 r11 = r10.b
                        int r11 = r11.a0()
                        float r11 = (float) r11
                        ir.nasim.WG7 r2 = r10.c
                        int r2 = r2.c()
                        float r2 = (float) r2
                        float r11 = r11 / r2
                        double r5 = (double) r11
                        double r5 = java.lang.Math.ceil(r5)
                        float r11 = (float) r5
                        int r11 = (int) r11
                        if (r11 > 0) goto L88
                        ir.nasim.Sz4 r2 = r10.b
                        java.lang.String r2 = r2.e0()
                        ir.nasim.Sz4 r5 = r10.b
                        int r5 = r5.a0()
                        ir.nasim.WG7 r6 = r10.c
                        int r6 = r6.c()
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        r7.<init>()
                        java.lang.String r8 = "The maxAvailableChunkCount is not positive!! Current fileSize("
                        r7.append(r8)
                        r7.append(r5)
                        java.lang.String r5 = ") and chunkSize($"
                        r7.append(r5)
                        r7.append(r6)
                        java.lang.String r5 = ")"
                        r7.append(r5)
                        java.lang.String r5 = r7.toString()
                        r6 = 0
                        java.lang.Object[] r6 = new java.lang.Object[r6]
                        ir.nasim.C19406qI3.j(r2, r5, r6)
                    L88:
                        int r2 = r4.e()
                        int r11 = java.lang.Math.min(r2, r11)
                        int r7 = ir.nasim.AbstractC21867uG5.e(r11, r3)
                        r8 = 1
                        r9 = 0
                        r5 = 0
                        ir.nasim.XG7 r11 = ir.nasim.XG7.d(r4, r5, r7, r8, r9)
                        r0.b = r3
                        java.lang.Object r11 = r12.a(r11, r0)
                        if (r11 != r1) goto La5
                        return r1
                    La5:
                        ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.f.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, C7737Sz4 c7737Sz4, WG7 wg7) {
                this.a = interfaceC4557Fq2;
                this.b = c7737Sz4;
                this.c = wg7;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(VI5 vi5, WG7 wg7, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = vi5;
            this.f = wg7;
            this.g = interfaceC9336Zm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C7737Sz4.this.new f(this.e, this.f, this.g, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TH1 th1 = new TH1(AbstractC24249yI3.a(AbstractC6392Nk0.e(C7737Sz4.this.a)), 10, (InterfaceC20315ro1) this.c, C7737Sz4.this.h, this.e);
                th1.n();
                C11637dL5 c11637dL5 = new C11637dL5();
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.X(new b(C7737Sz4.this.n, C7737Sz4.this, this.f), new a(null, C7737Sz4.this, new ArrayList(), new C12106e30(-1L), c11637dL5, this.f, th1, this.g));
                this.b = 1;
                if (AbstractC6459Nq2.G(interfaceC4557Fq2X, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.a(C7737Sz4.this.e0(), "clearUploadConfig(removeTempFile: " + this.d + Separators.RPAREN, new Object[0]);
            if (this.d) {
                C7737Sz4.this.s0();
            }
            C7737Sz4.this.i.remove(C7737Sz4.this.r);
            C7737Sz4.this.i.remove(C7737Sz4.this.s);
            C7737Sz4.this.i.remove(C7737Sz4.this.t);
            C7737Sz4.this.i.remove(C7737Sz4.this.u);
            C7737Sz4.this.i.remove(C7737Sz4.this.v);
            C7737Sz4.this.i.remove(C7737Sz4.this.d0());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new h(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0082 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ir.nasim.AbstractC10685c16.b(r12)
                goto L83
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1d:
                ir.nasim.AbstractC10685c16.b(r12)
                goto L76
            L21:
                ir.nasim.AbstractC10685c16.b(r12)
                goto L59
            L25:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.Sz4 r12 = ir.nasim.C7737Sz4.this
                ir.nasim.ro1 r12 = r12.U()
                r1 = 0
                ir.nasim.AbstractC20906so1.d(r12, r1, r4, r1)
                ir.nasim.Sz4 r12 = ir.nasim.C7737Sz4.this
                java.lang.String r12 = r12.e0()
                r1 = 0
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r5 = "close() running on NonCancellable job"
                ir.nasim.C19406qI3.a(r12, r5, r1)
                ir.nasim.Sz4 r12 = ir.nasim.C7737Sz4.this
                ir.nasim.Zm4 r12 = r12.a()
                java.lang.Object r12 = r12.getValue()
                boolean r12 = r12 instanceof ir.nasim.InterfaceC23654xH7.d
                if (r12 == 0) goto L78
                ir.nasim.Sz4 r12 = ir.nasim.C7737Sz4.this
                r11.b = r4
                java.lang.Object r12 = ir.nasim.C7737Sz4.C(r12, r11)
                if (r12 != r0) goto L59
                return r0
            L59:
                ir.nasim.WG7 r12 = (ir.nasim.WG7) r12
                if (r12 == 0) goto L78
                ir.nasim.Sz4 r1 = ir.nasim.C7737Sz4.this
                ir.nasim.em2 r5 = r1.Z()
                long r6 = r12.e()
                int r12 = ir.nasim.AbstractC5969Lp4.f()
                long r8 = (long) r12
                r11.b = r3
                r10 = r11
                java.lang.Object r12 = r5.f(r6, r8, r10)
                if (r12 != r0) goto L76
                return r0
            L76:
                ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            L78:
                ir.nasim.Sz4 r12 = ir.nasim.C7737Sz4.this
                r11.b = r2
                java.lang.Object r12 = ir.nasim.C7737Sz4.h(r12, r4, r11)
                if (r12 != r0) goto L83
                return r0
            L83:
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ TH1 e;
        final /* synthetic */ int f;
        final /* synthetic */ C7737Sz4 g;
        final /* synthetic */ String h;
        final /* synthetic */ C12106e30 i;
        final /* synthetic */ InterfaceC9336Zm4 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(TH1 th1, int i, C7737Sz4 c7737Sz4, String str, C12106e30 c12106e30, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = th1;
            this.f = i;
            this.g = c7737Sz4;
            this.h = str;
            this.i = c12106e30;
            this.j = interfaceC9336Zm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
            iVar.d = obj;
            return iVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
        
            if (ir.nasim.AbstractC20906so1.g(r13) != false) goto L12;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:7:0x001a). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.c
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2d
                if (r1 == r4) goto L24
                if (r1 != r3) goto L1c
                java.lang.Object r1 = r12.b
                ir.nasim.IT0 r1 = (ir.nasim.IT0) r1
                java.lang.Object r5 = r12.d
                ir.nasim.ro1 r5 = (ir.nasim.InterfaceC20315ro1) r5
                ir.nasim.AbstractC10685c16.b(r13)
            L1a:
                r13 = r5
                goto L66
            L1c:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L24:
                java.lang.Object r1 = r12.d
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r13)
                r5 = r1
                goto L47
            L2d:
                ir.nasim.AbstractC10685c16.b(r13)
                java.lang.Object r13 = r12.d
                ir.nasim.ro1 r13 = (ir.nasim.InterfaceC20315ro1) r13
            L34:
                ir.nasim.TH1 r1 = r12.e
                int r5 = r12.f
                r12.d = r13
                r12.b = r2
                r12.c = r4
                java.lang.Object r1 = r1.i(r5, r12)
                if (r1 != r0) goto L45
                return r0
            L45:
                r5 = r13
                r13 = r1
            L47:
                r1 = r13
                ir.nasim.IT0 r1 = (ir.nasim.IT0) r1
                if (r1 != 0) goto L4d
                goto L99
            L4d:
                ir.nasim.Sz4 r6 = r12.g
                okhttp3.OkHttpClient r7 = ir.nasim.C7737Sz4.p(r6)
                java.lang.String r9 = r12.h
                ir.nasim.e30 r10 = r12.i
                r12.d = r5
                r12.b = r1
                r12.c = r3
                r8 = r1
                r11 = r12
                java.lang.Object r13 = ir.nasim.C7737Sz4.H(r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L1a
                return r0
            L66:
                ir.nasim.TH1 r5 = r12.e
                int r6 = r12.f
                r5.h(r6, r1)
                ir.nasim.Zm4 r5 = r12.j
            L6f:
                java.lang.Object r6 = r5.getValue()
                r7 = r6
                ir.nasim.Sz4$c r7 = (ir.nasim.C7737Sz4.C7740c) r7
                java.util.List r8 = r7.c()
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                int r9 = r1.c()
                java.lang.Integer r9 = ir.nasim.AbstractC6392Nk0.d(r9)
                java.util.List r8 = ir.nasim.ZW0.O0(r8, r9)
                r9 = 0
                ir.nasim.Sz4$c r7 = ir.nasim.C7737Sz4.C7740c.b(r7, r9, r8, r4, r2)
                boolean r6 = r5.f(r6, r7)
                if (r6 == 0) goto L6f
                boolean r1 = ir.nasim.AbstractC20906so1.g(r13)
                if (r1 != 0) goto L34
            L99:
                ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        int i;
        private /* synthetic */ Object j;
        final /* synthetic */ WG7 l;
        final /* synthetic */ JH7.b m;
        final /* synthetic */ InterfaceC16756lo6 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(WG7 wg7, JH7.b bVar, InterfaceC16756lo6 interfaceC16756lo6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.l = wg7;
            this.m = bVar;
            this.n = interfaceC16756lo6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = C7737Sz4.this.new j(this.l, this.m, this.n, interfaceC20295rm1);
            jVar.j = obj;
            return jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x009f A[Catch: all -> 0x0033, ClosedSendChannelException -> 0x0123, TryCatch #0 {ClosedSendChannelException -> 0x0123, blocks: (B:6:0x002e, B:14:0x0099, B:16:0x009f, B:18:0x00c8, B:19:0x00cc, B:22:0x00eb, B:23:0x00f2, B:24:0x00f3, B:13:0x0088), top: B:36:0x000a, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x012c A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #1 {all -> 0x0033, blocks: (B:6:0x002e, B:14:0x0099, B:16:0x009f, B:18:0x00c8, B:19:0x00cc, B:22:0x00eb, B:23:0x00f2, B:24:0x00f3, B:29:0x012c, B:28:0x0123, B:13:0x0088), top: B:36:0x000a, inners: #0 }] */
        /* JADX WARN: Type inference failed for: r10v7, types: [java.io.Closeable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x011c -> B:27:0x011f). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$k */
    static final class k extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.b0(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$l */
    static final class l extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.i0(null, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$m */
    static final class m extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.j0(null, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Sz4$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C7737Sz4 d;

            /* renamed from: ir.nasim.Sz4$n$a$a, reason: collision with other inner class name */
            static final class C0636a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC23654xH7 c;
                final /* synthetic */ C7737Sz4 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0636a(InterfaceC23654xH7 interfaceC23654xH7, C7737Sz4 c7737Sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC23654xH7;
                    this.d = c7737Sz4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0636a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC23654xH7 interfaceC23654xH7 = this.c;
                        if (!AbstractC13042fc3.d(interfaceC23654xH7, InterfaceC23654xH7.b.a)) {
                            if (interfaceC23654xH7 instanceof InterfaceC23654xH7.d) {
                                C7737Sz4 c7737Sz4 = this.d;
                                InterfaceC23654xH7.d dVar = (InterfaceC23654xH7.d) this.c;
                                this.b = 1;
                                if (c7737Sz4.m0(dVar, this) == objE) {
                                    return objE;
                                }
                            } else if (interfaceC23654xH7 instanceof InterfaceC23654xH7.a) {
                                C7737Sz4 c7737Sz42 = this.d;
                                InterfaceC23654xH7.a aVar = (InterfaceC23654xH7.a) this.c;
                                this.b = 2;
                                if (c7737Sz42.j0(aVar, this) == objE) {
                                    return objE;
                                }
                            } else {
                                if (!(interfaceC23654xH7 instanceof InterfaceC23654xH7.c)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                this.d.l0((InterfaceC23654xH7.c) this.c);
                            }
                        }
                    } else {
                        if (i != 1 && i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0636a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C7737Sz4 c7737Sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c7737Sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC23654xH7 interfaceC23654xH7 = (InterfaceC23654xH7) this.c;
                    C19406qI3.a("states of upload", "state: " + interfaceC23654xH7.getClass().getSimpleName(), new Object[0]);
                    C7737Sz4 c7737Sz4 = this.d;
                    C7976Tz4 c7976Tz4 = new C7976Tz4(c7737Sz4, new C0636a(interfaceC23654xH7, c7737Sz4, null), null);
                    this.b = 1;
                    if (P17.c(c7976Tz4, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC23654xH7 interfaceC23654xH7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC23654xH7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4A = C7737Sz4.this.a();
                a aVar = new a(C7737Sz4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4A, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC23654xH7.d e;
        final /* synthetic */ InterfaceC9336Zm4 f;

        /* renamed from: ir.nasim.Sz4$o$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C7737Sz4 c;
            final /* synthetic */ InterfaceC23654xH7.d d;
            final /* synthetic */ InterfaceC9336Zm4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C7737Sz4 c7737Sz4, InterfaceC23654xH7.d dVar, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c7737Sz4;
                this.d = dVar;
                this.e = interfaceC9336Zm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C7737Sz4 c7737Sz4 = this.c;
                    WG7 wg7A = this.d.a();
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
                    this.b = 1;
                    if (c7737Sz4.D0(wg7A, interfaceC9336Zm4, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sz4$o$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9336Zm4 c;
            final /* synthetic */ C7737Sz4 d;

            /* renamed from: ir.nasim.Sz4$o$b$a */
            static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ C7737Sz4 a;

                a(C7737Sz4 c7737Sz4) {
                    this.a = c7737Sz4;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(C7740c c7740c, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objE0 = this.a.E0(c7740c.d(), c7740c.c(), interfaceC20295rm1);
                    return objE0 == AbstractC14862ic3.e() ? objE0 : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Sz4$o$b$b, reason: collision with other inner class name */
            public static final class C0637b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.Sz4$o$b$b$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.Sz4$o$b$b$a$a, reason: collision with other inner class name */
                    public static final class C0638a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C0638a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.C7737Sz4.o.b.C0637b.a.C0638a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.Sz4$o$b$b$a$a r0 = (ir.nasim.C7737Sz4.o.b.C0637b.a.C0638a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.Sz4$o$b$b$a$a r0 = new ir.nasim.Sz4$o$b$b$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L48
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            r2 = r5
                            ir.nasim.Sz4$c r2 = (ir.nasim.C7737Sz4.C7740c) r2
                            int r2 = r2.d()
                            if (r2 <= 0) goto L48
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L48
                            return r1
                        L48:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.o.b.C0637b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public C0637b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC9336Zm4 interfaceC9336Zm4, C7737Sz4 c7737Sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9336Zm4;
                this.d = c7737Sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C0637b c0637b = new C0637b(this.c);
                    a aVar = new a(this.d);
                    this.b = 1;
                    if (c0637b.b(aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(InterfaceC23654xH7.d dVar, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = dVar;
            this.f = interfaceC9336Zm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            o oVar = C7737Sz4.this.new o(this.e, this.f, interfaceC20295rm1);
            oVar.c = obj;
            return oVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C7737Sz4.this, this.e, this.f, null), 3, null);
            return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.f, C7737Sz4.this, null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$p */
    static final class p implements UA2 {
        final /* synthetic */ Call a;

        p(Call call) {
            this.a = call;
        }

        public final void a(Throwable th) {
            this.a.cancel();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Sz4$q */
    public static final class q implements Callback {
        final /* synthetic */ HE0 a;

        q(HE0 he0) {
            this.a = he0;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(iOException, "e");
            AbstractC24549yo1.c(this.a, new Y06.a(iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(response, "response");
            AbstractC24549yo1.c(this.a, new Y06.b(response));
        }
    }

    /* renamed from: ir.nasim.Sz4$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return null;
            }
            AbstractC10685c16.b(obj);
            if (!C7737Sz4.this.i.contains(C7737Sz4.this.r)) {
                C7737Sz4 c7737Sz4 = C7737Sz4.this;
                this.b = 1;
                if (c7737Sz4.L(true, this) == objE) {
                    return objE;
                }
                return null;
            }
            long j = C7737Sz4.this.i.getLong(C7737Sz4.this.r, -1L);
            int i2 = C7737Sz4.this.i.getInt(C7737Sz4.this.s, -1);
            String string = C7737Sz4.this.i.getString(C7737Sz4.this.t, "");
            AbstractC13042fc3.h(string, "getString(...)");
            int i3 = C7737Sz4.this.i.getInt(C7737Sz4.this.u, -1);
            String string2 = C7737Sz4.this.i.getString(C7737Sz4.this.v, "");
            AbstractC13042fc3.h(string2, "getString(...)");
            ArrayList arrayList = new ArrayList();
            C7737Sz4 c7737Sz42 = C7737Sz4.this;
            NW0 nw0 = NW0.a;
            byte[] bArrB = c7737Sz42.i.b(c7737Sz42.d0());
            AbstractC13042fc3.h(bArrB, "getBytes(...)");
            nw0.a(bArrB, arrayList);
            WG7 wg7 = new WG7(j, i2, i3, string, string2, arrayList);
            C19406qI3.a(C7737Sz4.this.e0(), "loadUploadConfig(" + wg7 + Separators.RPAREN, new Object[0]);
            return wg7;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$s */
    static final class s extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.p0(null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new t(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C7737Sz4.this.i.f(C7737Sz4.this.d0(), NW0.a.b(this.d));
            C19406qI3.a(C7737Sz4.this.e0(), "saveRemainingChunks()", new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WG7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(WG7 wg7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = wg7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new u(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.a(C7737Sz4.this.e0(), "saveUploadConfig(" + this.d + Separators.RPAREN, new Object[0]);
            C7737Sz4.this.i.putLong(C7737Sz4.this.r, this.d.e());
            C7737Sz4.this.i.putInt(C7737Sz4.this.s, this.d.c());
            C7737Sz4.this.i.putString(C7737Sz4.this.t, this.d.h());
            C7737Sz4.this.i.putInt(C7737Sz4.this.u, this.d.g());
            C7737Sz4.this.i.putString(C7737Sz4.this.v, this.d.d());
            C7737Sz4.this.i.f(C7737Sz4.this.d0(), NW0.a.b(this.d.f()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$v */
    static final class v extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        long d;
        /* synthetic */ Object e;
        int g;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.A0(null, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$w */
    public static final class w extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C7737Sz4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(InterfaceC14371ho1.a aVar, C7737Sz4 c7737Sz4) {
            super(aVar);
            this.b = c7737Sz4;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            Object value;
            C19406qI3.c(this.b.e0(), "Unknown exception (caught by the handler): " + th.getMessage(), th);
            InterfaceC9336Zm4 interfaceC9336Zm4A = this.b.a();
            do {
                value = interfaceC9336Zm4A.getValue();
            } while (!interfaceC9336Zm4A.f(value, new InterfaceC23654xH7.a(th instanceof FileSizeExceededException ? new ZG7.b((FileSizeExceededException) th) : th instanceof IOException ? new ZG7.d((IOException) th) : new ZG7.f(th))));
        }
    }

    /* renamed from: ir.nasim.Sz4$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        x(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7737Sz4.this.new x(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C7737Sz4 c7737Sz4 = C7737Sz4.this;
                this.b = 1;
                obj = c7737Sz4.o0(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            WG7 wg7 = (WG7) obj;
            InterfaceC9336Zm4 interfaceC9336Zm4A = C7737Sz4.this.a();
            do {
                value = interfaceC9336Zm4A.getValue();
            } while (!interfaceC9336Zm4A.f(value, new InterfaceC23654xH7.d(wg7)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sz4$y */
    static final class y extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        y(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.D0(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Sz4$z */
    static final class z extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C7737Sz4.this.E0(0, null, this);
        }
    }

    public C7737Sz4(long j2, long j3, long j4, String str, String str2, String str3, ExPeer exPeer, C9528a7 c9528a7, AbstractC13778go1 abstractC13778go1, SettingsModule settingsModule, InterfaceC3570Bk5 interfaceC3570Bk5, OkHttpClient okHttpClient, InterfaceC12532em2 interfaceC12532em2, EnumC4543Fo6 enumC4543Fo6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC24838zH7 interfaceC24838zH7) {
        AbstractC13042fc3.i(str, "descriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(c9528a7, "manager");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcherIo");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSendEvent");
        AbstractC13042fc3.i(interfaceC4557Fq2, "configurationFlow");
        AbstractC13042fc3.i(interfaceC24838zH7, "storage");
        this.a = j3;
        this.b = j4;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = exPeer;
        this.g = c9528a7;
        this.h = abstractC13778go1;
        this.i = interfaceC3570Bk5;
        this.j = okHttpClient;
        this.k = interfaceC12532em2;
        this.l = enumC4543Fo6;
        this.m = interfaceC14603iB2;
        this.n = interfaceC4557Fq2;
        this.o = interfaceC24838zH7;
        this.p = "NewUploadTask(" + AbstractC24249yI3.a(Long.valueOf(j2)) + ")_(rid=" + AbstractC24249yI3.a(Long.valueOf(j3)) + Separators.RPAREN;
        StringBuilder sb = new StringBuilder();
        sb.append("Upload_Parts_Of_");
        sb.append(j3);
        String string = sb.toString();
        this.q = string;
        this.r = string + "_fileId";
        this.s = string + "_chunkSize";
        this.t = string + "_uploadUrl";
        this.u = string + "_totalChunks";
        this.v = string + "_fileDescriptor";
        this.w = string + "_remainingChunkIndices";
        w wVar = new w(InterfaceC14371ho1.h0, this);
        this.x = wVar;
        this.y = AbstractC20906so1.a(abstractC13778go1.X(P17.b(null, 1, null)).X(wVar));
        this.z = settingsModule.A4();
        this.A = settingsModule.B4();
        this.B = settingsModule.z4();
        this.C = settingsModule.D4();
        this.D = AbstractC12281eL6.a(InterfaceC23654xH7.b.a);
        this.E = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Qz4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C7737Sz4.S(this.a));
            }
        });
        this.G = AbstractC23485x01.c(null, 1, null);
        this.F = k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01da -> B:14:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A0(ir.nasim.JH7 r18, ir.nasim.WG7 r19, long r20, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.A0(ir.nasim.JH7, ir.nasim.WG7, long, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object B0(C7737Sz4 c7737Sz4, JH7 jh7, WG7 wg7, long j2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendLastChunk");
        }
        if ((i2 & 4) != 0) {
            j2 = System.currentTimeMillis();
        }
        return c7737Sz4.A0(jh7, wg7, j2, interfaceC20295rm1);
    }

    private final Object C0(long j2) {
        try {
            C9475a16.a aVar = C9475a16.b;
            this.m.invoke("upload_last_put", new C13473gH7(a0(), (int) (System.currentTimeMillis() - j2)).a());
            return C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D0(ir.nasim.WG7 r22, ir.nasim.InterfaceC9336Zm4 r23, ir.nasim.InterfaceC20295rm1 r24) throws ir.nasim.C7737Sz4.C7739b, java.io.IOException, ir.nasim.core.modules.file.FileSizeExceededException {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.D0(ir.nasim.WG7, ir.nasim.Zm4, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E0(int r10, java.util.List r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.E0(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0185 -> B:27:0x00e8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01f6 -> B:56:0x01f7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0251 -> B:63:0x0252). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x02c0 -> B:16:0x004f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F0(okhttp3.OkHttpClient r23, ir.nasim.IT0 r24, java.lang.String r25, ir.nasim.C12106e30 r26, ir.nasim.InterfaceC20295rm1 r27) throws ir.nasim.C7737Sz4.d {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.F0(okhttp3.OkHttpClient, ir.nasim.IT0, java.lang.String, ir.nasim.e30, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object G0(C7737Sz4 c7737Sz4, OkHttpClient okHttpClient, IT0 it0, String str, C12106e30 c12106e30, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadChunk");
        }
        if ((i2 & 4) != 0) {
            c12106e30 = null;
        }
        return c7737Sz4.F0(okHttpClient, it0, str, c12106e30, interfaceC20295rm1);
    }

    private final InterfaceC24823zG1 H0(WG7 wg7, JH7.b bVar, VI5 vi5, InterfaceC9336Zm4 interfaceC9336Zm4) {
        return AbstractC10533bm0.b(this.y, null, null, new B(wg7, vi5, interfaceC9336Zm4, bVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(WG7 wg7, VI5 vi5, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = P17.c(new f(vi5, wg7, interfaceC9336Zm4, null), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    private final InterfaceC24823zG1 I0(int i2, String str, VI5 vi5, InterfaceC9336Zm4 interfaceC9336Zm4) {
        return AbstractC10533bm0.b(this.y, null, null, new C(vi5, this, str, interfaceC9336Zm4, i2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J(WG7 wg7, VI5 vi5, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
        int i2 = this.A;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(I0(i3, wg7.h(), vi5, interfaceC9336Zm4));
        }
        Object objA = DV.a(arrayList, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    private final boolean K(InterfaceC3346Am2 interfaceC3346Am2) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            File file = new File(interfaceC3346Am2.getDescriptor());
            objB = C9475a16.b(Boolean.valueOf(file.exists() && file.canRead()));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (C9475a16.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L(boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.h, new g(z2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final WG7 N(int i2, JH7 jh7, WG7 wg7, InterfaceC3346Am2 interfaceC3346Am2, e eVar) {
        int iD;
        if (wg7 != null) {
            return wg7.a((38 & 1) != 0 ? wg7.a : eVar.a(), (38 & 2) != 0 ? wg7.b : 0, (38 & 4) != 0 ? wg7.c : 0, (38 & 8) != 0 ? wg7.d : eVar.b(), (38 & 16) != 0 ? wg7.e : interfaceC3346Am2.getDescriptor(), (38 & 32) != 0 ? wg7.f : null);
        }
        if (jh7 instanceof JH7.a) {
            iD = 1;
        } else {
            if (!(jh7 instanceof JH7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            iD = AbstractC20723sV3.d((float) Math.ceil(interfaceC3346Am2.f() / i2));
        }
        int i3 = iD;
        C19406qI3.a(e0(), "fileSize: " + interfaceC3346Am2.f() + ", chunkSize: " + i2 + ", totalChunks: " + i3, new Object[0]);
        long jA = eVar.a();
        String strB = eVar.b();
        String descriptor = interfaceC3346Am2.getDescriptor();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        return new WG7(jA, i2, i3, strB, descriptor, arrayList);
    }

    private final Request O(IT0 it0, String str, C12106e30 c12106e30) {
        Request.Builder builderAddHeader = new Request.Builder().url(str).put(RequestBody.Companion.create$default(RequestBody.INSTANCE, it0.a(), (MediaType) null, 0, 0, 7, (Object) null)).addHeader("chunk", String.valueOf(it0.c())).addHeader(AuthorizationHeaderIms.NO, String.valueOf(it0.d()));
        C24411ya3 c24411ya3B = it0.b();
        return builderAddHeader.addHeader("bytes", c24411ya3B.o() + "-" + c24411ya3B.t()).tag(C12106e30.class, c12106e30).build();
    }

    private final Object P(WG7 wg7, JH7.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        Object value;
        if (aVar.c() != null) {
            Object objB0 = B0(this, aVar, wg7, 0L, interfaceC20295rm1, 4, null);
            return objB0 == AbstractC14862ic3.e() ? objB0 : C19938rB7.a;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4A = a();
        do {
            value = interfaceC9336Zm4A.getValue();
        } while (!interfaceC9336Zm4A.f(value, new InterfaceC23654xH7.a(new ZG7.e(new IOException("Failed to read from input stream.")))));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 Q(int i2, String str, final TH1 th1, C12106e30 c12106e30, InterfaceC9336Zm4 interfaceC9336Zm4) {
        final int iB = TH1.b.b(i2);
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.y, null, null, new i(th1, iB, this, str, c12106e30, interfaceC9336Zm4, null), 3, null);
        interfaceC13730gj3D.s(new UA2() { // from class: ir.nasim.Rz4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7737Sz4.R(th1, iB, (Throwable) obj);
            }
        });
        return interfaceC13730gj3D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(TH1 th1, int i2, Throwable th) {
        AbstractC13042fc3.i(th1, "$deliveryBuffer");
        th1.m(i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int S(C7737Sz4 c7737Sz4) {
        Object objB;
        AbstractC13042fc3.i(c7737Sz4, "this$0");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(Integer.valueOf((int) new File(c7737Sz4.c).length()));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = 0;
        }
        return ((Number) objB).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x012d -> B:14:0x0041). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(ir.nasim.WG7 r17, ir.nasim.JH7 r18, ir.nasim.InterfaceC20295rm1 r19) throws ir.nasim.C7737Sz4.C7739b, ir.nasim.core.modules.file.FileSizeExceededException {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.b0(ir.nasim.WG7, ir.nasim.JH7, ir.nasim.rm1):java.lang.Object");
    }

    private final JH7 h0(WG7 wg7, InterfaceC3346Am2 interfaceC3346Am2) throws IOException {
        if ((wg7 == null || wg7.g() != 1) && (C8386Vt0.a.N3() || interfaceC3346Am2.f() > this.C)) {
            return new JH7.b(interfaceC3346Am2);
        }
        C11947dp0 c11947dp0 = new C11947dp0();
        InterfaceC17551n93 interfaceC17551n93C = interfaceC3346Am2.c();
        try {
            C9316Zk2 c9316Zk2O0 = interfaceC17551n93C.O0(0, interfaceC3346Am2.f());
            byte[] bArr = null;
            byte[] bArrA = c9316Zk2O0 != null ? c9316Zk2O0.a() : null;
            YV0.a(interfaceC17551n93C, null);
            if (bArrA != null) {
                c11947dp0.d(bArrA);
                bArr = bArrA;
            }
            return new JH7.a(c11947dp0.a(), bArr, interfaceC3346Am2);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(interfaceC17551n93C, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00cf -> B:13:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i0(ir.nasim.JH7 r10, ir.nasim.InterfaceC20295rm1 r11) throws ir.nasim.core.modules.file.FileSizeExceededException {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C7737Sz4.l
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Sz4$l r0 = (ir.nasim.C7737Sz4.l) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Sz4$l r0 = new ir.nasim.Sz4$l
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r10 = r0.b
            ir.nasim.Sz4 r10 = (ir.nasim.C7737Sz4) r10
            java.lang.Object r2 = r0.a
            ir.nasim.JH7 r2 = (ir.nasim.JH7) r2
            ir.nasim.AbstractC10685c16.b(r11)
        L34:
            r11 = r10
            r10 = r2
            goto L4f
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            java.lang.Object r10 = r0.b
            ir.nasim.Sz4 r10 = (ir.nasim.C7737Sz4) r10
            java.lang.Object r2 = r0.a
            ir.nasim.JH7 r2 = (ir.nasim.JH7) r2
            ir.nasim.AbstractC10685c16.b(r11)
            goto L6b
        L4b:
            ir.nasim.AbstractC10685c16.b(r11)
            r11 = r9
        L4f:
            java.lang.String r2 = r11.e0()
            java.lang.String r6 = "getUploadUrl()"
            java.lang.Object[] r7 = new java.lang.Object[r3]
            ir.nasim.C19406qI3.a(r2, r6, r7)
            r0.a = r10
            r0.b = r11
            r0.e = r5
            java.lang.Object r2 = r11.t0(r10, r0)
            if (r2 != r1) goto L67
            return r1
        L67:
            r8 = r2
            r2 = r10
            r10 = r11
            r11 = r8
        L6b:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r6 = r11 instanceof ir.nasim.Z06.b
            if (r6 == 0) goto L9c
            ir.nasim.Sz4$e r10 = new ir.nasim.Sz4$e
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r0 = r11.a()
            ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl r0 = (ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl) r0
            java.lang.String r0 = r0.getUrl()
            java.lang.String r1 = "getUrl(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            com.google.protobuf.P r1 = r11.a()
            ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl r1 = (ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl) r1
            long r1 = r1.getFileId()
            com.google.protobuf.P r11 = r11.a()
            ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl r11 = (ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl) r11
            boolean r11 = r11.getDuplicate()
            r10.<init>(r0, r1, r11)
            return r10
        L9c:
            boolean r6 = r11 instanceof ir.nasim.Z06.a
            if (r6 == 0) goto Ld8
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r6 = r11.a()
            java.lang.String r6 = r6.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String()
            java.lang.String r7 = "File size exceeded limit"
            boolean r6 = ir.nasim.AbstractC13042fc3.d(r6, r7)
            if (r6 != 0) goto Ld2
            java.lang.String r6 = r10.e0()
            ir.nasim.core.network.RpcException r11 = r11.a()
            java.lang.String r11 = r11.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            java.lang.Object[] r7 = new java.lang.Object[r3]
            ir.nasim.C19406qI3.j(r6, r11, r7)
            long r6 = r10.B
            r0.a = r2
            r0.b = r10
            r0.e = r4
            java.lang.Object r11 = ir.nasim.HG1.b(r6, r0)
            if (r11 != r1) goto L34
            return r1
        Ld2:
            ir.nasim.core.modules.file.FileSizeExceededException r10 = new ir.nasim.core.modules.file.FileSizeExceededException
            r10.<init>()
            throw r10
        Ld8:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.i0(ir.nasim.JH7, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fd, code lost:
    
        if (r5.f(r4, new ir.nasim.InterfaceC23654xH7.d((ir.nasim.WG7) r1)) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01cc, code lost:
    
        if (r6.f(r4, new ir.nasim.InterfaceC23654xH7.d((ir.nasim.WG7) r1)) == false) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ef -> B:39:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01be -> B:75:0x01c1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j0(ir.nasim.InterfaceC23654xH7.a r19, ir.nasim.InterfaceC20295rm1 r20) throws ir.nasim.C7737Sz4.C7739b, ir.nasim.core.modules.file.FileSizeExceededException {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.j0(ir.nasim.xH7$a, ir.nasim.rm1):java.lang.Object");
    }

    private final InterfaceC24823zG1 k0() {
        return AbstractC10533bm0.b(this.y, null, EnumC23959xo1.LAZY, new n(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object m0(InterfaceC23654xH7.d dVar, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new o(dVar, AbstractC12281eL6.a(new C7740c(0, null, 3, 0 == true ? 1 : 0)), null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    private final Object n0(Call call, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        call.enqueue(new q(ie0));
        ie0.J(new p(call));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o0(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.h, new r(null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r8v0, types: [ir.nasim.WG7, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v13, types: [ir.nasim.lo6] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [ir.nasim.lo6] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p0(ir.nasim.WG7 r8, ir.nasim.JH7.b r9, ir.nasim.InterfaceC9336Zm4 r10, ir.nasim.InterfaceC20295rm1 r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.p0(ir.nasim.WG7, ir.nasim.JH7$b, ir.nasim.Zm4, ir.nasim.rm1):java.lang.Object");
    }

    private final void q0() {
        InterfaceC22299v01 interfaceC22299v01 = this.G;
        if (interfaceC22299v01.b()) {
            interfaceC22299v01.U(C19938rB7.a);
        }
    }

    private final Object r0(String str) {
        try {
            return Boolean.valueOf(new File(str).delete());
        } catch (Exception unused) {
            return C19938rB7.a;
        }
    }

    static /* synthetic */ Object u0(C7737Sz4 c7737Sz4, JH7 jh7, InterfaceC20295rm1 interfaceC20295rm1) {
        return c7737Sz4.k.h(jh7.b().f(), jh7.a(), c7737Sz4.b, c7737Sz4.d, C6906Pm2.o(c7737Sz4.c), c7737Sz4.f, c7737Sz4.l, interfaceC20295rm1);
    }

    static /* synthetic */ Object w0(C7737Sz4 c7737Sz4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(c7737Sz4.h, c7737Sz4.new t(list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    static /* synthetic */ Object y0(C7737Sz4 c7737Sz4, WG7 wg7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(c7737Sz4.h, c7737Sz4.new u(wg7, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final void z0(String str) {
        this.i.putString(this.v, str);
    }

    protected Request M(JH7 jh7, WG7 wg7) {
        AbstractC13042fc3.i(jh7, "uploadType");
        AbstractC13042fc3.i(wg7, "uploadConfig");
        if (!(jh7 instanceof JH7.a)) {
            if (jh7 instanceof JH7.b) {
                return new Request.Builder().url(wg7.h()).put(RequestBody.Companion.create$default(RequestBody.INSTANCE, new byte[0], (MediaType) null, 0, 0, 7, (Object) null)).addHeader(AuthorizationHeaderIms.NO, "0").addHeader(J, String.valueOf(wg7.g())).build();
            }
            throw new NoWhenBranchMatchedException();
        }
        Request.Builder builderUrl = new Request.Builder().url(wg7.h());
        RequestBody.Companion companion = RequestBody.INSTANCE;
        byte[] bArrC = ((JH7.a) jh7).c();
        AbstractC13042fc3.f(bArrC);
        return builderUrl.put(RequestBody.Companion.create$default(companion, bArrC, (MediaType) null, 0, 0, 7, (Object) null)).build();
    }

    protected InterfaceC24823zG1 T(WG7 wg7, JH7.b bVar, InterfaceC16756lo6 interfaceC16756lo6) {
        AbstractC13042fc3.i(wg7, "uploadConfig");
        AbstractC13042fc3.i(bVar, "uploadType");
        AbstractC13042fc3.i(interfaceC16756lo6, "producerChannel");
        return AbstractC10533bm0.b(this.y, null, null, new j(wg7, bVar, interfaceC16756lo6, null), 3, null);
    }

    protected final InterfaceC20315ro1 U() {
        return this.y;
    }

    protected final String V() {
        return this.c;
    }

    protected final ExPeer W() {
        return this.f;
    }

    protected final String X() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected ir.nasim.InterfaceC3346Am2 Y(ir.nasim.WG7 r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L1b
            java.lang.String r5 = r5.d()
            if (r5 == 0) goto L1b
            boolean r1 = ir.nasim.AbstractC14836iZ6.n0(r5)
            r1 = r1 ^ 1
            if (r1 == 0) goto L12
            goto L13
        L12:
            r5 = r0
        L13:
            if (r5 == 0) goto L1b
            ir.nasim.Yo r1 = new ir.nasim.Yo
            r1.<init>(r5)
            goto L38
        L1b:
            ir.nasim.zH7 r5 = r4.o
            java.lang.String r1 = r4.c
            ir.nasim.Am2 r1 = r5.a(r1)
            if (r1 != 0) goto L38
            ir.nasim.Yo r1 = new ir.nasim.Yo
            java.lang.String r5 = r4.c
            r1.<init>(r5)
            java.lang.String r5 = r4.e0()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "The original file will be used for upload."
            ir.nasim.C19406qI3.j(r5, r3, r2)
        L38:
            boolean r5 = r4.K(r1)
            if (r5 == 0) goto L3f
            r0 = r1
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7737Sz4.Y(ir.nasim.WG7):ir.nasim.Am2");
    }

    protected final InterfaceC12532em2 Z() {
        return this.k;
    }

    protected int a0() {
        return ((Number) this.E.getValue()).intValue();
    }

    @Override // ir.nasim.VH7
    public boolean b() {
        return this.F.b();
    }

    protected final EnumC4543Fo6 c0() {
        return this.l;
    }

    public final String d0() {
        return this.w;
    }

    protected String e0() {
        return this.p;
    }

    protected final long f0() {
        return this.b;
    }

    @Override // ir.nasim.VH7
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public InterfaceC9336Zm4 a() {
        return this.D;
    }

    @Override // ir.nasim.VH7
    public InterfaceC13730gj3 i(boolean z2) {
        C19406qI3.j(e0(), "close(cancel: " + z2 + Separators.RPAREN, new Object[0]);
        if (z2) {
            return AbstractC10533bm0.d(this.y, C12798fB4.b, null, new h(null), 2, null);
        }
        AbstractC20906so1.d(this.y, null, 1, null);
        InterfaceC24075y01 interfaceC24075y01B = AbstractC20267rj3.b(null, 1, null);
        interfaceC24075y01B.c();
        return interfaceC24075y01B;
    }

    protected void l0(InterfaceC23654xH7.c cVar) {
        AbstractC13042fc3.i(cVar, "state");
        InterfaceC3346Am2 interfaceC3346Am2B = this.o.b(cVar.d(), this.d, cVar.c());
        if (interfaceC3346Am2B == null) {
            interfaceC3346Am2B = cVar.d();
        }
        this.g.d(new EH7(this.a, new FileReference(new C12056dy(cVar.c(), this.b, 1), this.d, this.e, interfaceC3346Am2B.f()), interfaceC3346Am2B));
        q0();
    }

    protected void s0() {
        String strE = this.i.e(this.v);
        if (strE == null || AbstractC13042fc3.d(strE, this.c)) {
            return;
        }
        r0(strE);
    }

    @Override // ir.nasim.VH7
    public void start() {
        if (this.F.start()) {
            C19406qI3.j(e0(), "Starting the state handler.", new Object[0]);
        }
        AbstractC10533bm0.d(this.y, null, null, new x(null), 3, null);
    }

    protected Object t0(JH7 jh7, InterfaceC20295rm1 interfaceC20295rm1) {
        return u0(this, jh7, interfaceC20295rm1);
    }

    protected Object v0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return w0(this, list, interfaceC20295rm1);
    }

    protected Object x0(WG7 wg7, InterfaceC20295rm1 interfaceC20295rm1) {
        return y0(this, wg7, interfaceC20295rm1);
    }

    /* renamed from: ir.nasim.Sz4$c, reason: case insensitive filesystem */
    protected static final class C7740c {
        private final int a;
        private final List b;

        public C7740c(int i, List list) {
            AbstractC13042fc3.i(list, "remainingChunkIndices");
            this.a = i;
            this.b = list;
        }

        public static /* synthetic */ C7740c b(C7740c c7740c, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = c7740c.a;
            }
            if ((i2 & 2) != 0) {
                list = c7740c.b;
            }
            return c7740c.a(i, list);
        }

        public final C7740c a(int i, List list) {
            AbstractC13042fc3.i(list, "remainingChunkIndices");
            return new C7740c(i, list);
        }

        public final List c() {
            return this.b;
        }

        public final int d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7740c)) {
                return false;
            }
            C7740c c7740c = (C7740c) obj;
            return this.a == c7740c.a && AbstractC13042fc3.d(this.b, c7740c.b);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "UploadProgress(totalChunks=" + this.a + ", remainingChunkIndices=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ C7740c(int i, List list, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? AbstractC10360bX0.m() : list);
        }
    }

    public /* synthetic */ C7737Sz4(long j2, long j3, long j4, String str, String str2, String str3, ExPeer exPeer, C9528a7 c9528a7, AbstractC13778go1 abstractC13778go1, SettingsModule settingsModule, InterfaceC3570Bk5 interfaceC3570Bk5, OkHttpClient okHttpClient, InterfaceC12532em2 interfaceC12532em2, EnumC4543Fo6 enumC4543Fo6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC24838zH7 interfaceC24838zH7, int i2, ED1 ed1) {
        this(j2, j3, j4, str, str2, str3, exPeer, c9528a7, abstractC13778go1, settingsModule, interfaceC3570Bk5, okHttpClient, interfaceC12532em2, enumC4543Fo6, interfaceC14603iB2, interfaceC4557Fq2, (i2 & 65536) != 0 ? new AH7() : interfaceC24838zH7);
    }
}
