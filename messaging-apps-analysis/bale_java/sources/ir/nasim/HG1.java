package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC11938do1;

/* loaded from: classes8.dex */
public abstract class HG1 {

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            return HG1.a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r4) {
        /*
            boolean r0 = r4 instanceof ir.nasim.HG1.a
            if (r0 == 0) goto L13
            r0 = r4
            ir.nasim.HG1$a r0 = (ir.nasim.HG1.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.HG1$a r0 = new ir.nasim.HG1$a
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            ir.nasim.AbstractC10685c16.b(r4)
            goto L52
        L31:
            ir.nasim.AbstractC10685c16.b(r4)
            r0.b = r3
            ir.nasim.IE0 r4 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r4.<init>(r2, r3)
            r4.w()
            java.lang.Object r4 = r4.t()
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            if (r4 != r2) goto L4f
            ir.nasim.WA1.c(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HG1.a(ir.nasim.rm1):java.lang.Object");
    }

    public static final Object b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        if (j <= 0) {
            return C19938rB7.a;
        }
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        if (j < Long.MAX_VALUE) {
            d(ie0.getContext()).e0(j, ie0);
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    public static final Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = b(e(j), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public static final GG1 d(InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC11938do1.b bVarA = interfaceC11938do1.a(InterfaceC22753vm1.g0);
        GG1 gg1 = bVarA instanceof GG1 ? (GG1) bVarA : null;
        return gg1 == null ? QD1.a() : gg1;
    }

    public static final long e(long j) {
        if (Q12.r(j, Q12.b.c()) > 0) {
            return AbstractC23053wG5.f(Q12.A(j), 1L);
        }
        return 0L;
    }
}
