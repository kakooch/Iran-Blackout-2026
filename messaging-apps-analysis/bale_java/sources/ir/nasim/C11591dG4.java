package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.IM4;
import ir.nasim.InterfaceC18892pR;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.OA2;
import ir.nasim.TR;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.dG4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11591dG4 extends VW7 {
    private static final a k = new a(null);
    public static final int l = 8;
    private final InterfaceC3570Bk5 b;
    private final NR c;
    private final C6409Nm d;
    private final SettingsModule e;
    private final Context f;
    private TR g;
    private EnumC10827cG4 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;

    /* renamed from: ir.nasim.dG4$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dG4$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C11591dG4.this.b1(null, this);
        }
    }

    /* renamed from: ir.nasim.dG4$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C11591dG4.this.d1(null, this);
        }
    }

    /* renamed from: ir.nasim.dG4$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C11591dG4.this.e1(0L, this);
        }
    }

    /* renamed from: ir.nasim.dG4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC10827cG4 c;
        final /* synthetic */ C11591dG4 d;
        final /* synthetic */ long e;

        /* renamed from: ir.nasim.dG4$f$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC10827cG4.values().length];
                try {
                    iArr[EnumC10827cG4.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC10827cG4.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC10827cG4.b.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(EnumC10827cG4 enumC10827cG4, C11591dG4 c11591dG4, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = enumC10827cG4;
            this.d = c11591dG4;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                int i2 = a.a[this.c.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    C11591dG4 c11591dG4 = this.d;
                    long j = this.e;
                    this.b = 1;
                    if (c11591dG4.s1(j, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C11591dG4 c11591dG42 = this.d;
                    long j2 = this.e;
                    this.b = 2;
                    if (c11591dG42.e1(j2, this) == objE) {
                        return objE;
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dG4$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C11591dG4.this.s1(0L, this);
        }
    }

    /* renamed from: ir.nasim.dG4$h */
    public static final class h extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C11591dG4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(InterfaceC20295rm1 interfaceC20295rm1, C11591dG4 c11591dG4) {
            super(3, interfaceC20295rm1);
            this.e = c11591dG4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.R(new j((b) this.d, this.e, null));
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2R, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(interfaceC20295rm1, this.e);
            hVar.c = interfaceC4806Gq2;
            hVar.d = obj;
            return hVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dG4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C11591dG4.this.new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            b bVarB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = C11591dG4.this.i;
                C11591dG4 c11591dG4 = C11591dG4.this;
                do {
                    value = interfaceC9336Zm4.getValue();
                    bVarB = b.b((b) value, null, false, c11591dG4.b.getLong("LAST_OTP_REQUEST_TIME_KEY", 0L), false, false, false, false, false, null, null, false, null, null, 8187, null);
                } while (!interfaceC9336Zm4.f(value, bVarB));
                this.b = 1;
                if (interfaceC4806Gq2.a(bVarB, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dG4$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        long c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ b f;
        final /* synthetic */ C11591dG4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(b bVar, C11591dG4 c11591dG4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = bVar;
            this.g = c11591dG4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.f, this.g, interfaceC20295rm1);
            jVar.e = obj;
            return jVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00f7, code lost:
        
            if ((ir.nasim.AbstractC12234eG4.a() - r28.f.g()) < 120000) goto L12;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00dc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00e7  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00da -> B:7:0x001f). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11591dG4.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dG4$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.dG4$k$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC10827cG4.values().length];
                try {
                    iArr[EnumC10827cG4.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC10827cG4.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC10827cG4.b.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11591dG4.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            b bVarB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C11591dG4.this.i;
                do {
                    value = interfaceC9336Zm4.getValue();
                    bVarB = b.b((b) value, null, false, 0L, false, true, false, false, false, null, null, false, null, null, 8175, null);
                } while (!interfaceC9336Zm4.f(value, bVarB));
                EnumC10827cG4 enumC10827cG4 = C11591dG4.this.h;
                if (enumC10827cG4 == null) {
                    AbstractC13042fc3.y("otpType");
                    enumC10827cG4 = null;
                }
                int i2 = a.a[enumC10827cG4.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    C11591dG4 c11591dG4 = C11591dG4.this;
                    this.b = 1;
                    if (c11591dG4.b1(bVarB, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C11591dG4 c11591dG42 = C11591dG4.this;
                    this.b = 2;
                    if (c11591dG42.d1(bVarB, this) == objE) {
                        return objE;
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11591dG4(InterfaceC3570Bk5 interfaceC3570Bk5, NR nr, C6409Nm c6409Nm, SettingsModule settingsModule, Context context) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(context, "context");
        this.b = interfaceC3570Bk5;
        this.c = nr;
        this.d = c6409Nm;
        this.e = settingsModule;
        this.f = context;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new b(null, false, 0L, false, false, false, false, false, null, null, false, null, null, 8191, null));
        this.i = interfaceC9336Zm4A;
        this.j = AbstractC6459Nq2.o0(AbstractC6459Nq2.s0(AbstractC6459Nq2.c0(interfaceC9336Zm4A, new i(null)), new h(null, this)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), new C15843kG4(0, null, false, false, false, null, null, null, null, null, null, 2047, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(ir.nasim.C11591dG4.b r24, ir.nasim.InterfaceC20295rm1 r25) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11591dG4.b1(ir.nasim.dG4$b, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c1() {
        String string = this.f.getString(AbstractC24800zD5.banking_input_acceptable_digits);
        AbstractC13042fc3.h(string, "getString(...)");
        return "\\b([" + string + "]{6})\\b";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(ir.nasim.C11591dG4.b r22, ir.nasim.InterfaceC20295rm1 r23) throws java.lang.NumberFormatException {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            boolean r2 = r1 instanceof ir.nasim.C11591dG4.d
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.dG4$d r2 = (ir.nasim.C11591dG4.d) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.d = r3
            goto L1c
        L17:
            ir.nasim.dG4$d r2 = new ir.nasim.dG4$d
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.b
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.d
            r5 = 1
            if (r4 == 0) goto L39
            if (r4 != r5) goto L31
            java.lang.Object r2 = r2.a
            ir.nasim.dG4 r2 = (ir.nasim.C11591dG4) r2
            ir.nasim.AbstractC10685c16.b(r1)
            goto L52
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.NR r1 = r0.c
            java.lang.String r4 = r22.h()
            int r4 = java.lang.Integer.parseInt(r4)
            r2.a = r0
            r2.d = r5
            java.lang.Object r1 = r1.k(r4, r2)
            if (r1 != r3) goto L51
            return r3
        L51:
            r2 = r0
        L52:
            ir.nasim.QR r1 = (ir.nasim.QR) r1
            boolean r3 = r1 instanceof ir.nasim.QR.c
            if (r3 == 0) goto L86
            ir.nasim.oR r1 = ir.nasim.EnumC18301oR.e
            r2.q1(r1)
            ir.nasim.Zm4 r3 = r2.i
        L5f:
            java.lang.Object r1 = r3.getValue()
            r4 = r1
            ir.nasim.dG4$b r4 = (ir.nasim.C11591dG4.b) r4
            r19 = 8143(0x1fcf, float:1.1411E-41)
            r20 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            ir.nasim.dG4$b r2 = ir.nasim.C11591dG4.b.b(r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r1 = r3.f(r1, r2)
            if (r1 == 0) goto L5f
            goto L93
        L86:
            boolean r3 = r1 instanceof ir.nasim.QR.b
            if (r3 == 0) goto L96
            ir.nasim.QR$b r1 = (ir.nasim.QR.b) r1
            ir.nasim.pR r1 = r1.b()
            r2.k1(r1)
        L93:
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        L96:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11591dG4.d1(ir.nasim.dG4$b, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e1(long r24, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11591dG4.e1(long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19114po0 f1(b bVar) {
        return bVar.o() ? OA2.a.b : (bVar.h().length() != 6 || bVar.i()) ? InterfaceC19114po0.a.C1453a.a : InterfaceC19114po0.b.a.a;
    }

    private final void g1() {
        TR tr = this.g;
        if (tr == null) {
            AbstractC13042fc3.y("sourceType");
            tr = null;
        }
        XV4 xv4A = tr instanceof TR.a ? AbstractC4616Fw7.a(this.e.K0(), this.e.L0()) : tr instanceof TR.c ? AbstractC4616Fw7.a(this.e.l2(), this.e.n2()) : AbstractC4616Fw7.a("", "");
        String str = (String) xv4A.a();
        String str2 = (String) xv4A.b();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            b bVar = (b) value;
            EnumC10827cG4 enumC10827cG4 = this.h;
            if (enumC10827cG4 == null) {
                AbstractC13042fc3.y("otpType");
                enumC10827cG4 = null;
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, b.b(bVar, null, false, 0L, false, false, false, false, false, null, str2, false, null, enumC10827cG4 == EnumC10827cG4.d ? str : "", 3583, null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IM4 h1(b bVar) {
        long jA = AbstractC12234eG4.a() - bVar.g();
        return jA < 120000 ? new IM4.b(((int) (120000 - jA)) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) : IM4.a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC14472hy4 i1(b bVar) {
        return (bVar.h().length() != 6 || bVar.l()) ? bVar.h().length() > 0 ? bVar.h().length() == 6 ? bVar.n() != null ? new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.f.getString(bVar.n().intValue()), null, 4, null) : new AbstractC14472hy4.a(null, null, null, 7, null) : new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.f.getString(AbstractC24800zD5.otp_length_error), null, 4, null) : new AbstractC14472hy4.d(null, null, null, 7, null) : bVar.f() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null);
    }

    private final void k1(InterfaceC18892pR interfaceC18892pR) {
        Object value;
        Object value2;
        Object value3;
        if (AbstractC13042fc3.d(interfaceC18892pR, InterfaceC18892pR.d.a)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
            do {
                value3 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value3, b.b((b) value3, null, false, 0L, false, false, false, false, false, Integer.valueOf(AbstractC24800zD5.error_time_out), null, true, null, null, 4847, null)));
        } else if (AbstractC13042fc3.d(interfaceC18892pR, InterfaceC18892pR.c.a)) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.i;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, b.b((b) value2, null, false, 0L, false, false, false, false, false, null, null, true, Integer.valueOf(AbstractC24800zD5.password_retry_limit_exceeded), null, 5103, null)));
        } else {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.i;
            do {
                value = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value, b.b((b) value, null, false, 0L, false, false, false, false, false, null, null, true, Integer.valueOf(AbstractC24800zD5.password_in_correct), null, 5103, null)));
        }
    }

    private final void p1(TR.a aVar) {
        this.d.d("authentication_bot", AbstractC20051rO3.m(AbstractC4616Fw7.a("peer_id", Integer.valueOf(aVar.f())), AbstractC4616Fw7.a("peer_type", aVar.b()), AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, Integer.valueOf(aVar.d())), AbstractC4616Fw7.a("random_id", Integer.valueOf(aVar.a())), AbstractC4616Fw7.a("source_type", Integer.valueOf(aVar.e().j()))));
    }

    private final void q1(EnumC18301oR enumC18301oR) {
        TR tr = this.g;
        TR tr2 = null;
        if (tr == null) {
            AbstractC13042fc3.y("sourceType");
            tr = null;
        }
        TR.a aVar = tr instanceof TR.a ? (TR.a) tr : null;
        if (aVar != null) {
            p1(aVar);
        }
        HashMap map = new HashMap();
        map.put("action_type", Integer.valueOf(enumC18301oR.j()));
        TR tr3 = this.g;
        if (tr3 == null) {
            AbstractC13042fc3.y("sourceType");
            tr3 = null;
        }
        map.put("source_type", tr3.b());
        TR tr4 = this.g;
        if (tr4 == null) {
            AbstractC13042fc3.y("sourceType");
        } else {
            tr2 = tr4;
        }
        map.put("random_id", Integer.valueOf(tr2.a()));
        this.d.d("authenticator", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s1(long r24, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11591dG4.s1(long, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 j1() {
        return this.j;
    }

    public final void l1(String str) {
        AbstractC13042fc3.i(str, "otp");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, b.b((b) value, str, true, 0L, false, false, false, false, false, null, null, false, null, null, 5116, null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    public final void m1(int i2) {
        Object value;
        b bVarB;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            bVarB = (b) value;
            Integer numM = bVarB.m();
            if (numM != null && numM.intValue() == i2) {
                bVarB = b.b(bVarB, null, false, 0L, false, false, false, false, false, null, null, false, null, null, 7935, null);
            }
        } while (!interfaceC9336Zm4.f(value, bVarB));
    }

    public final void o1(EnumC10827cG4 enumC10827cG4) {
        Object value;
        AbstractC13042fc3.i(enumC10827cG4, "otpScreenType");
        long j2 = this.b.getLong("LAST_OTP_REQUEST_TIME_KEY", 0L);
        long jA = AbstractC12234eG4.a();
        if (jA - j2 >= 120000) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(enumC10827cG4, this, jA, null), 3, null);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, j2, false, false, false, false, false, null, null, false, null, null, 8187, null)));
    }

    public final void t1(EnumC10827cG4 enumC10827cG4) {
        AbstractC13042fc3.i(enumC10827cG4, "otpScreenType");
        this.h = enumC10827cG4;
        g1();
    }

    public final void u1(TR tr) {
        AbstractC13042fc3.i(tr, "eventSourceType");
        this.g = tr;
    }

    public final void v1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, 0L, false, false, false, false, false, null, null, false, null, null, 8159, null)));
    }

    public final void w1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, 0L, false, false, false, false, false, null, null, false, null, null, 8127, null)));
    }

    public final InterfaceC13730gj3 x1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(null), 3, null);
    }

    /* renamed from: ir.nasim.dG4$b */
    private static final class b {
        private final String a;
        private final boolean b;
        private final long c;
        private final boolean d;
        private final boolean e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final Integer i;
        private final String j;
        private final boolean k;
        private final Integer l;
        private final String m;

        public b(String str, boolean z, long j, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Integer num, String str2, boolean z7, Integer num2, String str3) {
            AbstractC13042fc3.i(str, "otp");
            AbstractC13042fc3.i(str3, "descriptionText");
            this.a = str;
            this.b = z;
            this.c = j;
            this.d = z2;
            this.e = z3;
            this.f = z4;
            this.g = z5;
            this.h = z6;
            this.i = num;
            this.j = str2;
            this.k = z7;
            this.l = num2;
            this.m = str3;
        }

        public static /* synthetic */ b b(b bVar, String str, boolean z, long j, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Integer num, String str2, boolean z7, Integer num2, String str3, int i, Object obj) {
            return bVar.a((i & 1) != 0 ? bVar.a : str, (i & 2) != 0 ? bVar.b : z, (i & 4) != 0 ? bVar.c : j, (i & 8) != 0 ? bVar.d : z2, (i & 16) != 0 ? bVar.e : z3, (i & 32) != 0 ? bVar.f : z4, (i & 64) != 0 ? bVar.g : z5, (i & 128) != 0 ? bVar.h : z6, (i & 256) != 0 ? bVar.i : num, (i & 512) != 0 ? bVar.j : str2, (i & 1024) != 0 ? bVar.k : z7, (i & 2048) != 0 ? bVar.l : num2, (i & 4096) != 0 ? bVar.m : str3);
        }

        public final b a(String str, boolean z, long j, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Integer num, String str2, boolean z7, Integer num2, String str3) {
            AbstractC13042fc3.i(str, "otp");
            AbstractC13042fc3.i(str3, "descriptionText");
            return new b(str, z, j, z2, z3, z4, z5, z6, num, str2, z7, num2, str3);
        }

        public final boolean c() {
            return this.h;
        }

        public final String d() {
            return this.j;
        }

        public final String e() {
            return this.m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h && AbstractC13042fc3.d(this.i, bVar.i) && AbstractC13042fc3.d(this.j, bVar.j) && this.k == bVar.k && AbstractC13042fc3.d(this.l, bVar.l) && AbstractC13042fc3.d(this.m, bVar.m);
        }

        public final boolean f() {
            return this.b;
        }

        public final long g() {
            return this.c;
        }

        public final String h() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31;
            Integer num = this.i;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.j;
            int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.k)) * 31;
            Integer num2 = this.l;
            return ((iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.m.hashCode();
        }

        public final boolean i() {
            return this.d;
        }

        public final boolean j() {
            return this.f;
        }

        public final boolean k() {
            return this.g;
        }

        public final boolean l() {
            return this.k;
        }

        public final Integer m() {
            return this.i;
        }

        public final Integer n() {
            return this.l;
        }

        public final boolean o() {
            return this.e;
        }

        public String toString() {
            return "InnerState(otp=" + this.a + ", hasFocus=" + this.b + ", lastOtpRequestTime=" + this.c + ", otpIsInvalid=" + this.d + ", isRequesting=" + this.e + ", readyToSetupPassword=" + this.f + ", readyToValidatePassword=" + this.g + ", authorizeCompleted=" + this.h + ", snackBarMessage=" + this.i + ", confirmationMessage=" + this.j + ", shouldShowError=" + this.k + ", textFieldErrorMessage=" + this.l + ", descriptionText=" + this.m + Separators.RPAREN;
        }

        public /* synthetic */ b(String str, boolean z, long j, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Integer num, String str2, boolean z7, Integer num2, String str3, int i, ED1 ed1) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5, (i & 128) != 0 ? false : z6, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : str2, (i & 1024) == 0 ? z7 : false, (i & 2048) == 0 ? num2 : null, (i & 4096) == 0 ? str3 : "");
        }
    }
}
