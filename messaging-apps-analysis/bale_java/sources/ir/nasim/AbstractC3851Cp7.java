package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Cp7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3851Cp7 {

    /* renamed from: ir.nasim.Cp7$a */
    static final class a extends AbstractC22163um1 {
        long a;
        Object b;
        /* synthetic */ Object c;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC3851Cp7.c(0L, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Cp7$b */
    static final class b extends AbstractC22163um1 {
        long a;
        long b;
        Object c;
        /* synthetic */ Object d;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC3851Cp7.d(0L, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Cp7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ EnumC4085Dp7 d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;

        /* renamed from: ir.nasim.Cp7$c$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC4085Dp7.values().length];
                try {
                    iArr[EnumC4085Dp7.FIXED_PERIOD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC4085Dp7.FIXED_DELAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(EnumC4085Dp7 enumC4085Dp7, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC4085Dp7;
            this.e = j;
            this.f = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, this.f, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                int i2 = a.a[this.d.ordinal()];
                if (i2 == 1) {
                    long j = this.e;
                    long j2 = this.f;
                    InterfaceC16756lo6 interfaceC16756lo6J = interfaceC16204ks5.j();
                    this.b = 1;
                    if (AbstractC3851Cp7.d(j, j2, interfaceC16756lo6J, this) == objE) {
                        return objE;
                    }
                } else if (i2 == 2) {
                    long j3 = this.e;
                    long j4 = this.f;
                    InterfaceC16756lo6 interfaceC16756lo6J2 = interfaceC16204ks5.j();
                    this.b = 2;
                    if (AbstractC3851Cp7.c(j3, j4, interfaceC16756lo6J2, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(long r6, long r8, ir.nasim.InterfaceC16756lo6 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            boolean r0 = r11 instanceof ir.nasim.AbstractC3851Cp7.a
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Cp7$a r0 = (ir.nasim.AbstractC3851Cp7.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Cp7$a r0 = new ir.nasim.Cp7$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L48
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            long r6 = r0.a
            java.lang.Object r8 = r0.b
            ir.nasim.lo6 r8 = (ir.nasim.InterfaceC16756lo6) r8
            ir.nasim.AbstractC10685c16.b(r11)
        L34:
            r10 = r8
            goto L63
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            long r6 = r0.a
            java.lang.Object r8 = r0.b
            ir.nasim.lo6 r8 = (ir.nasim.InterfaceC16756lo6) r8
            ir.nasim.AbstractC10685c16.b(r11)
            goto L73
        L48:
            long r6 = r0.a
            java.lang.Object r8 = r0.b
            r10 = r8
            ir.nasim.lo6 r10 = (ir.nasim.InterfaceC16756lo6) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L63
        L53:
            ir.nasim.AbstractC10685c16.b(r11)
            r0.b = r10
            r0.a = r6
            r0.d = r5
            java.lang.Object r8 = ir.nasim.HG1.b(r8, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            r0.b = r10
            r0.a = r6
            r0.d = r4
            java.lang.Object r8 = r10.o(r8, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            r8 = r10
        L73:
            r0.b = r8
            r0.a = r6
            r0.d = r3
            java.lang.Object r9 = ir.nasim.HG1.b(r6, r0)
            if (r9 != r1) goto L34
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3851Cp7.c(long, long, ir.nasim.lo6, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ec -> B:27:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0102 -> B:15:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(long r18, long r20, ir.nasim.InterfaceC16756lo6 r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3851Cp7.d(long, long, ir.nasim.lo6, ir.nasim.rm1):java.lang.Object");
    }

    public static final VI5 e(long j, long j2, InterfaceC11938do1 interfaceC11938do1, EnumC4085Dp7 enumC4085Dp7) {
        if (j < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return AbstractC13822gs5.d(C17050mJ2.a, C12366eV1.d().X(interfaceC11938do1), 0, new c(enumC4085Dp7, j, j2, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    public static /* synthetic */ VI5 f(long j, long j2, InterfaceC11938do1 interfaceC11938do1, EnumC4085Dp7 enumC4085Dp7, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if ((i & 8) != 0) {
            enumC4085Dp7 = EnumC4085Dp7.FIXED_PERIOD;
        }
        return e(j, j2, interfaceC11938do1, enumC4085Dp7);
    }
}
