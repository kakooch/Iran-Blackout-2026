package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.hp6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14386hp6 {

    /* renamed from: ir.nasim.hp6$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C13202fp6 b;

        /* renamed from: ir.nasim.hp6$a$a, reason: collision with other inner class name */
        public static final class C1284a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C13202fp6 b;

            /* renamed from: ir.nasim.hp6$a$a$a, reason: collision with other inner class name */
            public static final class C1285a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C1285a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C1284a.this.a(null, this);
                }
            }

            public C1284a(InterfaceC4806Gq2 interfaceC4806Gq2, C13202fp6 c13202fp6) {
                this.a = interfaceC4806Gq2;
                this.b = c13202fp6;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.AbstractC14386hp6.a.C1284a.C1285a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.hp6$a$a$a r0 = (ir.nasim.AbstractC14386hp6.a.C1284a.C1285a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.hp6$a$a$a r0 = new ir.nasim.hp6$a$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.VS4 r7 = (ir.nasim.VS4) r7
                    ir.nasim.fp6 r2 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r2.c(r7, r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14386hp6.a.C1284a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, C13202fp6 c13202fp6) {
            this.a = interfaceC4557Fq2;
            this.b = c13202fp6;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C1284a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hp6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Object obj2 = this.c;
                Object obj3 = this.d;
                InterfaceC15796kB2 interfaceC15796kB2 = this.e;
                this.c = null;
                this.b = 1;
                obj = interfaceC15796kB2.q(obj2, obj3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(Object obj, Object obj2, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.e, interfaceC20295rm1);
            bVar.c = obj;
            bVar.d = obj2;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hp6$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        int g;
        /* synthetic */ Object h;
        int i;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC14386hp6.d(null, null, this);
        }
    }

    public static final void a(List list, Object obj, C15054iv7 c15054iv7, C15054iv7 c15054iv72, int i, int i2) {
        AbstractC13042fc3.i(list, "<this>");
        int[] iArrE = c15054iv7 != null ? c15054iv7.e() : null;
        int[] iArrE2 = c15054iv72 != null ? c15054iv72.e() : null;
        if (iArrE != null && iArrE2 != null) {
            iArrE = AbstractC15401jX0.l1(AbstractC15401jX0.Z0(AbstractC10242bK.W(AbstractC9648aK.C(iArrE, iArrE2))));
        } else if (iArrE == null && iArrE2 != null) {
            iArrE = iArrE2;
        } else if (iArrE == null || iArrE2 != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        b(list, obj, iArrE, i, i2);
    }

    public static final void b(List list, Object obj, int[] iArr, int i, int i2) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(iArr, "originalPageOffsets");
        if (obj == null) {
            return;
        }
        list.add(e(obj, iArr, i, i2));
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, EnumC5225Ik7 enumC5225Ik7, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        AbstractC13042fc3.i(interfaceC15796kB2, "generator");
        return new a(interfaceC4557Fq2, new C13202fp6(enumC5225Ik7, new b(interfaceC15796kB2, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d1 -> B:28:0x00da). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(ir.nasim.C15054iv7 r12, ir.nasim.InterfaceC15796kB2 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14386hp6.d(ir.nasim.iv7, ir.nasim.kB2, ir.nasim.rm1):java.lang.Object");
    }

    public static final C15054iv7 e(Object obj, int[] iArr, int i, int i2) {
        AbstractC13042fc3.i(obj, "separator");
        AbstractC13042fc3.i(iArr, "originalPageOffsets");
        return new C15054iv7(iArr, AbstractC9766aX0.e(obj), i, AbstractC9766aX0.e(Integer.valueOf(i2)));
    }
}
