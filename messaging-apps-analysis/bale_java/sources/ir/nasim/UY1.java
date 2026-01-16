package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes5.dex */
public interface UY1 {

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return UY1.j(UY1.this, null, 0L, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return UY1.k(UY1.this, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object j(ir.nasim.UY1 r18, ir.nasim.XY1 r19, long r20, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            r0 = r18
            r1 = r22
            boolean r2 = r1 instanceof ir.nasim.UY1.a
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.UY1$a r2 = (ir.nasim.UY1.a) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f = r3
            goto L1c
        L17:
            ir.nasim.UY1$a r2 = new ir.nasim.UY1$a
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.d
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.f
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L49
            if (r4 == r6) goto L38
            if (r4 != r5) goto L30
            ir.nasim.AbstractC10685c16.b(r1)
            goto L8f
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            long r6 = r2.c
            java.lang.Object r0 = r2.b
            ir.nasim.XY1 r0 = (ir.nasim.XY1) r0
            java.lang.Object r4 = r2.a
            ir.nasim.UY1 r4 = (ir.nasim.UY1) r4
            ir.nasim.AbstractC10685c16.b(r1)
            r9 = r6
            r6 = r0
            r0 = r4
            goto L6e
        L49:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.tl2 r1 = new ir.nasim.tl2
            long r7 = r19.d()
            long r9 = r19.c()
            r1.<init>(r7, r9)
            r2.a = r0
            r4 = r19
            r2.b = r4
            r7 = r20
            r2.c = r7
            r2.f = r6
            java.lang.Object r1 = r0.g(r1, r2)
            if (r1 != r3) goto L6c
            return r3
        L6c:
            r6 = r4
            r9 = r7
        L6e:
            r16 = 61
            r17 = 0
            r7 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            ir.nasim.XY1 r1 = ir.nasim.XY1.b(r6, r7, r9, r11, r12, r14, r15, r16, r17)
            ir.nasim.XY1[] r1 = new ir.nasim.XY1[]{r1}
            r4 = 0
            r2.a = r4
            r2.b = r4
            r2.f = r5
            java.lang.Object r0 = r0.d(r1, r2)
            if (r0 != r3) goto L8f
            return r3
        L8f:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UY1.j(ir.nasim.UY1, ir.nasim.XY1, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object k(ir.nasim.UY1 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r0 = r6 instanceof ir.nasim.UY1.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.UY1$b r0 = (ir.nasim.UY1.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.UY1$b r0 = new ir.nasim.UY1$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r6)
            goto L56
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.a
            ir.nasim.UY1 r5 = (ir.nasim.UY1) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4a
        L3c:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L56
            return r1
        L56:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UY1.k(ir.nasim.UY1, ir.nasim.rm1):java.lang.Object");
    }

    Object a(InterfaceC20295rm1 interfaceC20295rm1);

    default Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        return k(this, interfaceC20295rm1);
    }

    Object c(InterfaceC20295rm1 interfaceC20295rm1);

    Object d(XY1[] xy1Arr, InterfaceC20295rm1 interfaceC20295rm1);

    default Object e(XY1 xy1, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return j(this, xy1, j, interfaceC20295rm1);
    }

    Object f(List list, InterfaceC20295rm1 interfaceC20295rm1);

    Object g(C21564tl2 c21564tl2, InterfaceC20295rm1 interfaceC20295rm1);

    Object h(List list, InterfaceC20295rm1 interfaceC20295rm1);

    Object i(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1);
}
