package ir.nasim;

import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC21704tz6;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tz6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC21704tz6 {

    /* renamed from: ir.nasim.tz6$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ EnumC14086hK2 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Object c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;
        final /* synthetic */ int h;

        /* renamed from: ir.nasim.tz6$a$a, reason: collision with other inner class name */
        static final class C1621a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ boolean c;
            final /* synthetic */ C15607js d;
            final /* synthetic */ float e;
            final /* synthetic */ float f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;
            final /* synthetic */ int i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1621a(boolean z, C15607js c15607js, float f, float f2, int i, int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = z;
                this.d = c15607js;
                this.e = f;
                this.f = f2;
                this.g = i;
                this.h = i2;
                this.i = i3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1621a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00c2 A[RETURN] */
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
                    int r0 = r8.b
                    r1 = 0
                    r2 = 3
                    r3 = 1
                    r4 = 4
                    r5 = 2
                    r6 = 0
                    if (r0 == 0) goto L35
                    if (r0 == r3) goto L31
                    if (r0 == r5) goto L2b
                    if (r0 == r2) goto L27
                    if (r0 != r4) goto L1f
                    ir.nasim.AbstractC10685c16.b(r17)
                    r0 = r17
                    goto Lc3
                L1f:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L27:
                    ir.nasim.AbstractC10685c16.b(r17)
                    goto L92
                L2b:
                    ir.nasim.AbstractC10685c16.b(r17)
                    r0 = r17
                    goto L7e
                L31:
                    ir.nasim.AbstractC10685c16.b(r17)
                    goto L4d
                L35:
                    ir.nasim.AbstractC10685c16.b(r17)
                    boolean r0 = r8.c
                    if (r0 == 0) goto L81
                    ir.nasim.js r0 = r8.d
                    float r2 = r8.e
                    java.lang.Float r2 = ir.nasim.AbstractC6392Nk0.c(r2)
                    r8.b = r3
                    java.lang.Object r0 = r0.x(r2, r8)
                    if (r0 != r9) goto L4d
                    return r9
                L4d:
                    ir.nasim.js r0 = r8.d
                    float r2 = r8.f
                    java.lang.Float r2 = ir.nasim.AbstractC6392Nk0.c(r2)
                    int r3 = r8.g
                    int r7 = r8.h
                    ir.nasim.Rw7 r10 = ir.nasim.AbstractC5999Lt.l(r3, r7, r6, r4, r6)
                    int r3 = r8.i
                    long r12 = ir.nasim.AbstractC10865cK6.c(r3, r1, r5, r6)
                    r14 = 2
                    r15 = 0
                    r11 = 0
                    ir.nasim.s63 r3 = ir.nasim.AbstractC5999Lt.e(r10, r11, r12, r14, r15)
                    r8.b = r5
                    r4 = 0
                    r5 = 0
                    r6 = 12
                    r7 = 0
                    r1 = r2
                    r2 = r3
                    r3 = r4
                    r4 = r5
                    r5 = r16
                    java.lang.Object r0 = ir.nasim.C15607js.h(r0, r1, r2, r3, r4, r5, r6, r7)
                    if (r0 != r9) goto L7e
                    return r9
                L7e:
                    ir.nasim.Gt r0 = (ir.nasim.C4830Gt) r0
                    goto Lc5
                L81:
                    ir.nasim.js r0 = r8.d
                    float r3 = r8.f
                    java.lang.Float r3 = ir.nasim.AbstractC6392Nk0.c(r3)
                    r8.b = r2
                    java.lang.Object r0 = r0.x(r3, r8)
                    if (r0 != r9) goto L92
                    return r9
                L92:
                    ir.nasim.js r0 = r8.d
                    float r2 = r8.e
                    java.lang.Float r2 = ir.nasim.AbstractC6392Nk0.c(r2)
                    int r3 = r8.g
                    int r7 = r8.h
                    ir.nasim.Rw7 r10 = ir.nasim.AbstractC5999Lt.l(r3, r7, r6, r4, r6)
                    int r3 = r8.i
                    long r12 = ir.nasim.AbstractC10865cK6.c(r3, r1, r5, r6)
                    r14 = 2
                    r15 = 0
                    r11 = 0
                    ir.nasim.s63 r3 = ir.nasim.AbstractC5999Lt.e(r10, r11, r12, r14, r15)
                    r8.b = r4
                    r4 = 0
                    r5 = 0
                    r6 = 12
                    r7 = 0
                    r1 = r2
                    r2 = r3
                    r3 = r4
                    r4 = r5
                    r5 = r16
                    java.lang.Object r0 = ir.nasim.C15607js.h(r0, r1, r2, r3, r4, r5, r6, r7)
                    if (r0 != r9) goto Lc3
                    return r9
                Lc3:
                    ir.nasim.Gt r0 = (ir.nasim.C4830Gt) r0
                Lc5:
                    ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21704tz6.a.C1621a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1621a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.tz6$a$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC14086hK2.values().length];
                try {
                    iArr[EnumC14086hK2.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC14086hK2.a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        a(EnumC14086hK2 enumC14086hK2, boolean z, Object obj, int i, int i2, int i3, List list, int i4) {
            this.a = enumC14086hK2;
            this.b = z;
            this.c = obj;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = list;
            this.h = i4;
        }

        private static final long c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
        }

        private static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
            interfaceC9102Ym4.setValue(C4414Fa3.b(j));
        }

        private static final float f(InterfaceC14354hm4 interfaceC14354hm4) {
            return interfaceC14354hm4.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$size$delegate");
            AbstractC13042fc3.i(interfaceC11379cu3, "it");
            d(interfaceC9102Ym4, interfaceC11379cu3.a());
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            float fMax;
            C4414Fa3 c4414Fa3;
            boolean z;
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(-550997780);
            interfaceC22053ub1.W(1235541185);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(C4414Fa3.b(C4414Fa3.b.a()), null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            int i2 = b.a[this.a.ordinal()];
            if (i2 == 1) {
                fMax = Math.max((int) (c(interfaceC9102Ym4) >> 32), (int) (c(interfaceC9102Ym4) & 4294967295L));
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                fMax = Math.min((int) (c(interfaceC9102Ym4) >> 32), (int) (c(interfaceC9102Ym4) & 4294967295L));
            }
            float f = (-2) * fMax;
            float fC = ((int) (c(interfaceC9102Ym4) >> 32)) + fMax;
            boolean z2 = interfaceC22053ub1.H(AbstractC13040fc1.n()) == EnumC12613eu3.b && this.b;
            interfaceC22053ub1.W(1235560206);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = z2 ? AbstractC19153ps.b(fC, 0.0f, 2, null) : AbstractC19153ps.b(f, 0.0f, 2, null);
                interfaceC22053ub1.s(objB2);
            }
            C15607js c15607js = (C15607js) objB2;
            interfaceC22053ub1.Q();
            Object obj = this.c;
            C4414Fa3 c4414Fa3B = C4414Fa3.b(c(interfaceC9102Ym4));
            interfaceC22053ub1.W(1235569148);
            boolean zE = interfaceC22053ub1.e(this.d) | interfaceC22053ub1.a(z2) | interfaceC22053ub1.D(c15607js) | interfaceC22053ub1.c(fC) | interfaceC22053ub1.c(f) | interfaceC22053ub1.e(this.e) | interfaceC22053ub1.e(this.f);
            int i3 = this.d;
            int i4 = this.e;
            int i5 = this.f;
            Object objB3 = interfaceC22053ub1.B();
            if (zE || objB3 == aVar.a()) {
                c4414Fa3 = c4414Fa3B;
                z = z2;
                objB3 = new C1621a(z2, c15607js, fC, f, i3, i4, i5, null);
                interfaceC22053ub1.s(objB3);
            } else {
                c4414Fa3 = c4414Fa3B;
                z = z2;
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.f(obj, c4414Fa3, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            float fFloatValue = ((Number) c15607js.q()).floatValue();
            interfaceC22053ub1.W(1235598236);
            boolean zC = interfaceC22053ub1.c(fFloatValue);
            Object objB4 = interfaceC22053ub1.B();
            if (zC || objB4 == aVar.a()) {
                objB4 = AbstractC4326Eq5.a(((Number) c15607js.q()).floatValue());
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            float f2 = f((InterfaceC14354hm4) objB4) + fMax;
            float f3 = z ? fMax / 2 : 0.0f;
            float f4 = z ? 0.0f : fMax / 2;
            AbstractC12520el0.a aVar2 = AbstractC12520el0.b;
            List listP = this.g;
            interfaceC22053ub1.W(1235611246);
            if (listP == null) {
                G10 g10 = G10.a;
                listP = AbstractC10360bX0.p(C24381yX0.k(g10.a(interfaceC22053ub1, 6).A()), C24381yX0.k(g10.a(interfaceC22053ub1, 6).E()), C24381yX0.k(g10.a(interfaceC22053ub1, 6).A()));
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarB = androidx.compose.foundation.b.b(eVar, aVar2.c(listP, ZG4.e((Float.floatToRawIntBits(f(r6)) << 32) | (Float.floatToRawIntBits(f3) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f4) & 4294967295L)), this.h), null, 0.0f, 6, null);
            interfaceC22053ub1.W(1235623306);
            Object objB5 = interfaceC22053ub1.B();
            if (objB5 == aVar.a()) {
                objB5 = new UA2() { // from class: ir.nasim.sz6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return AbstractC21704tz6.a.h(interfaceC9102Ym4, (InterfaceC11379cu3) obj2);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.layout.c.a(eVarB, (UA2) objB5);
            interfaceC22053ub1.Q();
            return eVarA;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, int i, int i2, int i3, Object obj, List list, EnumC14086hK2 enumC14086hK2, int i4, boolean z) {
        AbstractC13042fc3.i(eVar, "$this$shimmerEffect");
        AbstractC13042fc3.i(enumC14086hK2, "gradientWidthMode");
        return androidx.compose.ui.c.c(eVar, null, new a(enumC14086hK2, z, obj, i, i3, i2, list, i4), 1, null);
    }
}
