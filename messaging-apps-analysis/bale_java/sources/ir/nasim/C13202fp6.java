package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.VS4;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.fp6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13202fp6 {
    private final EnumC5225Ik7 a;
    private final InterfaceC15796kB2 b;
    private final List c;
    private boolean d;
    private boolean e;
    private final C20889sm4 f;
    private C14653iG3 g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;

    /* renamed from: ir.nasim.fp6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5225Ik7.values().length];
            try {
                iArr[EnumC5225Ik7.FULLY_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5225Ik7.SOURCE_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.fp6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C24411ya3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C24411ya3 c24411ya3) {
            super(1);
            this.e = c24411ya3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C15054iv7 c15054iv7) {
            AbstractC13042fc3.i(c15054iv7, "stash");
            int[] iArrE = c15054iv7.e();
            C24411ya3 c24411ya3 = this.e;
            int length = iArrE.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (c24411ya3.B(iArrE[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: ir.nasim.fp6$c */
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
            return C13202fp6.this.c(null, this);
        }
    }

    /* renamed from: ir.nasim.fp6$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        boolean k;
        int l;
        int m;
        int n;
        /* synthetic */ Object o;
        int q;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.o = obj;
            this.q |= RecyclerView.UNDEFINED_DURATION;
            return C13202fp6.this.d(null, this);
        }
    }

    /* renamed from: ir.nasim.fp6$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        int f;
        /* synthetic */ Object g;
        int i;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C13202fp6.this.f(null, this);
        }
    }

    public C13202fp6(EnumC5225Ik7 enumC5225Ik7, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        AbstractC13042fc3.i(interfaceC15796kB2, "generator");
        this.a = enumC5225Ik7;
        this.b = interfaceC15796kB2;
        this.c = new ArrayList();
        this.f = new C20889sm4();
    }

    private final C15054iv7 i(C15054iv7 c15054iv7) {
        int[] iArrE = c15054iv7.e();
        List listP = AbstractC10360bX0.p(AbstractC15401jX0.q0(c15054iv7.b()), AbstractC15401jX0.C0(c15054iv7.b()));
        int iD = c15054iv7.d();
        List listC = c15054iv7.c();
        Integer numValueOf = Integer.valueOf(listC != null ? ((Number) AbstractC15401jX0.q0(listC)).intValue() : 0);
        List listC2 = c15054iv7.c();
        return new C15054iv7(iArrE, listP, iD, AbstractC10360bX0.p(numValueOf, Integer.valueOf(listC2 != null ? ((Number) AbstractC15401jX0.C0(listC2)).intValue() : AbstractC10360bX0.o(c15054iv7.b()))));
    }

    public final VS4.b a(VS4.b bVar) {
        AbstractC13042fc3.i(bVar, "<this>");
        return bVar;
    }

    public final VS4.a b(VS4.a aVar) {
        AbstractC13042fc3.i(aVar, "event");
        this.f.c(aVar.e(), AbstractC13460gG3.c.b.b());
        EnumC16433lG3 enumC16433lG3E = aVar.e();
        EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.PREPEND;
        if (enumC16433lG3E == enumC16433lG3) {
            this.h = aVar.i();
            this.k = false;
        } else if (aVar.e() == EnumC16433lG3.APPEND) {
            this.i = aVar.i();
            this.j = false;
        }
        if (this.c.isEmpty()) {
            if (aVar.e() == enumC16433lG3) {
                this.e = false;
            } else {
                this.d = false;
            }
        }
        AbstractC13610gX0.K(this.c, new b(new C24411ya3(aVar.g(), aVar.f())));
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.VS4 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13202fp6.c(ir.nasim.VS4, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:30:0x022b, B:29:0x0229], limit reached: 256 */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x055f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x066e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0698 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x074a  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0785 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0833  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0354  */
    /* JADX WARN: Type inference failed for: r1v52, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x0485 -> B:136:0x048c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x0699 -> B:17:0x00d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x0786 -> B:217:0x0787). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.VS4.b r31, ir.nasim.InterfaceC20295rm1 r32) {
        /*
            Method dump skipped, instructions count: 2164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13202fp6.d(ir.nasim.VS4$b, ir.nasim.rm1):java.lang.Object");
    }

    public final Object e(VS4.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
        C14653iG3 c14653iG3 = this.g;
        if (AbstractC13042fc3.d(this.f.d(), cVar.f()) && AbstractC13042fc3.d(c14653iG3, cVar.e())) {
            AbstractC13042fc3.g(cVar, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
            return cVar;
        }
        this.f.b(cVar.f());
        this.g = cVar.e();
        if (cVar.e() != null && cVar.e().e().a()) {
            if (!AbstractC13042fc3.d(c14653iG3 != null ? c14653iG3.e() : null, cVar.e().e())) {
                return d(VS4.b.g.b(AbstractC10360bX0.m(), this.h, cVar.f(), cVar.e()), interfaceC20295rm1);
            }
        }
        if (cVar.e() != null && cVar.e().d().a()) {
            if (!AbstractC13042fc3.d(c14653iG3 != null ? c14653iG3.d() : null, cVar.e().d())) {
                return d(VS4.b.g.a(AbstractC10360bX0.m(), this.i, cVar.f(), cVar.e()), interfaceC20295rm1);
            }
        }
        AbstractC13042fc3.g(cVar, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.VS4.d r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.C13202fp6.e
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.fp6$e r0 = (ir.nasim.C13202fp6.e) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            ir.nasim.fp6$e r0 = new ir.nasim.fp6$e
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.g
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            int r11 = r0.f
            int r2 = r0.e
            java.lang.Object r4 = r0.d
            java.lang.Object r5 = r0.c
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.b
            ir.nasim.VS4$d r6 = (ir.nasim.VS4.d) r6
            java.lang.Object r7 = r0.a
            ir.nasim.fp6 r7 = (ir.nasim.C13202fp6) r7
            ir.nasim.AbstractC10685c16.b(r12)
            r9 = r4
            r4 = r11
            r11 = r6
            r6 = r9
            goto L88
        L3f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L47:
            ir.nasim.AbstractC10685c16.b(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r2 = r11.e()
            int r2 = r2.size()
            if (r2 < 0) goto L9a
            r4 = 0
            r7 = r10
            r5 = r12
        L5c:
            java.util.List r12 = r11.e()
            int r6 = r4 + (-1)
            java.lang.Object r12 = ir.nasim.ZW0.t0(r12, r6)
            java.util.List r6 = r11.e()
            java.lang.Object r6 = ir.nasim.ZW0.t0(r6, r4)
            ir.nasim.kB2 r8 = r7.b
            r0.a = r7
            r0.b = r11
            r0.c = r5
            r0.d = r6
            r0.e = r4
            r0.f = r2
            r0.i = r3
            java.lang.Object r12 = r8.q(r12, r6, r0)
            if (r12 != r1) goto L85
            return r1
        L85:
            r9 = r4
            r4 = r2
            r2 = r9
        L88:
            if (r12 == 0) goto L8d
            r5.add(r12)
        L8d:
            if (r6 == 0) goto L92
            r5.add(r6)
        L92:
            if (r2 == r4) goto L99
            int r12 = r2 + 1
            r2 = r4
            r4 = r12
            goto L5c
        L99:
            r12 = r5
        L9a:
            ir.nasim.VS4$d r0 = new ir.nasim.VS4$d
            ir.nasim.iG3 r1 = r11.g()
            ir.nasim.iG3 r11 = r11.f()
            r0.<init>(r12, r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13202fp6.f(ir.nasim.VS4$d, ir.nasim.rm1):java.lang.Object");
    }

    public final boolean g(VS4.b bVar, EnumC5225Ik7 enumC5225Ik7) {
        C14653iG3 c14653iG3I;
        AbstractC13460gG3 abstractC13460gG3D;
        AbstractC13042fc3.i(bVar, "<this>");
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        if (bVar.h() == EnumC16433lG3.PREPEND) {
            return this.d;
        }
        int i = a.a[enumC5225Ik7.ordinal()];
        if (i == 1) {
            return bVar.m().d().a() && ((c14653iG3I = bVar.i()) == null || (abstractC13460gG3D = c14653iG3I.d()) == null || abstractC13460gG3D.a());
        }
        if (i == 2) {
            return bVar.m().d().a();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean h(VS4.b bVar, EnumC5225Ik7 enumC5225Ik7) {
        C14653iG3 c14653iG3I;
        AbstractC13460gG3 abstractC13460gG3E;
        AbstractC13042fc3.i(bVar, "<this>");
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        if (bVar.h() == EnumC16433lG3.APPEND) {
            return this.e;
        }
        int i = a.a[enumC5225Ik7.ordinal()];
        if (i == 1) {
            return bVar.m().e().a() && ((c14653iG3I = bVar.i()) == null || (abstractC13460gG3E = c14653iG3I.e()) == null || abstractC13460gG3E.a());
        }
        if (i == 2) {
            return bVar.m().e().a();
        }
        throw new NoWhenBranchMatchedException();
    }
}
