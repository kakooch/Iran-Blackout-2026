package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.Or6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC6721Or6 {

    /* renamed from: ir.nasim.Or6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return InterfaceC6721Or6.d(InterfaceC6721Or6.this, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object d(ir.nasim.InterfaceC6721Or6 r5, java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.InterfaceC6721Or6.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Or6$a r0 = (ir.nasim.InterfaceC6721Or6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Or6$a r0 = new ir.nasim.Or6$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r7)
            goto L5f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.b
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r5 = r0.a
            ir.nasim.Or6 r5 = (ir.nasim.InterfaceC6721Or6) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L51
        L41:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.a(r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r7 = 0
            r0.a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r5 = r5.c(r6, r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.InterfaceC6721Or6.d(ir.nasim.Or6, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    Object a(InterfaceC20295rm1 interfaceC20295rm1);

    default Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(this, list, interfaceC20295rm1);
    }

    Object c(List list, InterfaceC20295rm1 interfaceC20295rm1);

    InterfaceC4557Fq2 e();
}
