package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class LX6 {
    private final FX6 a;
    private final IX6 b;
    private final KX6 c;

    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return LX6.this.b(null, this);
        }
    }

    public LX6(FX6 fx6, IX6 ix6, KX6 kx6) {
        AbstractC13042fc3.i(fx6, "storyWidgetDao");
        AbstractC13042fc3.i(ix6, "entityMapper");
        AbstractC13042fc3.i(kx6, "dataMapper");
        this.a = fx6;
        this.b = ix6;
        this.c = kx6;
    }

    public final Object a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.a.a(j, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.LX6.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.LX6$a r0 = (ir.nasim.LX6.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.LX6$a r0 = new ir.nasim.LX6$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.LX6 r5 = (ir.nasim.LX6) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.FX6 r6 = r4.a
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.b(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L71
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L5b:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L72
            java.lang.Object r1 = r6.next()
            ir.nasim.HX6 r1 = (ir.nasim.HX6) r1
            ir.nasim.IX6 r2 = r5.b
            ir.nasim.JX6 r1 = r2.a(r1)
            r0.add(r1)
            goto L5b
        L71:
            r0 = 0
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LX6.b(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final Object c(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.a((JX6) it.next()));
        }
        FX6 fx6 = this.a;
        HX6[] hx6Arr = (HX6[]) AbstractC15401jX0.n0(arrayList).toArray(new HX6[0]);
        Object objC = fx6.c((HX6[]) Arrays.copyOf(hx6Arr, hx6Arr.length), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
