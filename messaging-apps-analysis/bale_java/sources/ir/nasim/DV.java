package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;

/* loaded from: classes8.dex */
public abstract class DV {

    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return DV.c(null, this);
        }
    }

    public static final Object a(Collection collection, InterfaceC20295rm1 interfaceC20295rm1) {
        return collection.isEmpty() ? AbstractC10360bX0.m() : new BV((InterfaceC24823zG1[]) collection.toArray(new InterfaceC24823zG1[0])).c(interfaceC20295rm1);
    }

    public static final Object b(InterfaceC24823zG1[] interfaceC24823zG1Arr, InterfaceC20295rm1 interfaceC20295rm1) {
        return interfaceC24823zG1Arr.length == 0 ? AbstractC10360bX0.m() : new BV(interfaceC24823zG1Arr).c(interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(java.util.Collection r4, ir.nasim.InterfaceC20295rm1 r5) {
        /*
            boolean r0 = r5 instanceof ir.nasim.DV.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.DV$a r0 = (ir.nasim.DV.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.DV$a r0 = new ir.nasim.DV$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.a
            java.util.Iterator r4 = (java.util.Iterator) r4
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L3e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L55
            java.lang.Object r5 = r4.next()
            ir.nasim.gj3 r5 = (ir.nasim.InterfaceC13730gj3) r5
            r0.a = r4
            r0.c = r3
            java.lang.Object r5 = r5.k0(r0)
            if (r5 != r1) goto L3e
            return r1
        L55:
            ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DV.c(java.util.Collection, ir.nasim.rm1):java.lang.Object");
    }
}
