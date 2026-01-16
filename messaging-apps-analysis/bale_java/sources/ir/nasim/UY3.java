package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes7.dex */
public abstract class UY3 {
    private final AbstractC15995kX3 a;
    private final E84 b;
    private final List c;
    private InterfaceC8327Vm4 d;
    private final InterfaceC10040ay6 e;

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
            return UY3.this.g(null, null, this);
        }
    }

    public UY3(AbstractC15995kX3 abstractC15995kX3, E84 e84) {
        AbstractC13042fc3.i(abstractC15995kX3, "dataSource");
        AbstractC13042fc3.i(e84, "messagesModule");
        this.a = abstractC15995kX3;
        this.b = e84;
        this.c = new ArrayList();
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(0, 1, EnumC6162Ml0.DROP_OLDEST);
        this.d = interfaceC8327Vm4A;
        this.e = interfaceC8327Vm4A;
    }

    private final List b(Long l) {
        if (l != null || !this.c.isEmpty()) {
            long jLongValue = l != null ? l.longValue() : Long.MAX_VALUE;
            InterfaceC17445my6 interfaceC17445my6 = (InterfaceC17445my6) AbstractC15401jX0.F0(this.c);
            if (jLongValue >= (interfaceC17445my6 != null ? interfaceC17445my6.h() : 0L)) {
                Object obj = null;
                if (l != null) {
                    List list = this.c;
                    ListIterator listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            break;
                        }
                        Object objPrevious = listIterator.previous();
                        if (((InterfaceC17445my6) objPrevious).h() >= l.longValue()) {
                            obj = objPrevious;
                            break;
                        }
                    }
                    obj = (InterfaceC17445my6) obj;
                }
                int iD0 = l == null ? -1 : AbstractC15401jX0.D0(this.c, obj);
                return AbstractC15401jX0.Y0(this.c, new C24411ya3(AbstractC23053wG5.i(iD0 + 1, this.c.size() - 1), AbstractC23053wG5.i(iD0 + 21, this.c.size() - 1)));
            }
        }
        return AbstractC10360bX0.m();
    }

    private final Object d(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.d.a(arrayList, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    static /* synthetic */ Object f(UY3 uy3, List list, C11458d25 c11458d25, List list2, List list3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C3767Cg4((InterfaceC17445my6) it.next(), EnumC3533Bg4.a));
        }
        uy3.c.removeAll(list);
        Object objD = uy3.d(arrayList, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    protected abstract AbstractC15995kX3 a();

    public final InterfaceC10040ay6 c() {
        return this.e;
    }

    public Object e(List list, C11458d25 c11458d25, List list2, List list3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return f(this, list, c11458d25, list2, list3, z, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.C11458d25 r5, java.lang.Long r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.UY3.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.UY3$a r0 = (ir.nasim.UY3.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.UY3$a r0 = new ir.nasim.UY3$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.UY3 r5 = (ir.nasim.UY3) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L54
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r7)
            java.util.List r7 = r4.b(r6)
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L5f
            ir.nasim.kX3 r7 = r4.a()
            r0.a = r4
            r0.d = r3
            java.lang.Object r7 = r7.b(r6, r5, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            r5 = r4
        L54:
            java.util.List r7 = (java.util.List) r7
            java.util.List r5 = r5.c
            r6 = r7
            java.util.Collection r6 = (java.util.Collection) r6
            r5.addAll(r6)
            return r7
        L5f:
            java.util.List r7 = (java.util.List) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UY3.g(ir.nasim.d25, java.lang.Long, ir.nasim.rm1):java.lang.Object");
    }
}
