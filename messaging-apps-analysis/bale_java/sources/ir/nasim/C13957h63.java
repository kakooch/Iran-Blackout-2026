package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.h63, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13957h63 extends AbstractC5117Hy7 {
    private final InterfaceC22882vy7[] c;
    private final InterfaceC3932Cy7[] d;
    private final boolean e;

    public /* synthetic */ C13957h63(InterfaceC22882vy7[] interfaceC22882vy7Arr, InterfaceC3932Cy7[] interfaceC3932Cy7Arr, boolean z, int i, ED1 ed1) {
        this(interfaceC22882vy7Arr, interfaceC3932Cy7Arr, (i & 4) != 0 ? false : z);
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean b() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "key");
        MU0 mu0D = abstractC4099Dr3.K0().d();
        InterfaceC22882vy7 interfaceC22882vy7 = mu0D instanceof InterfaceC22882vy7 ? (InterfaceC22882vy7) mu0D : null;
        if (interfaceC22882vy7 == null) {
            return null;
        }
        int index = interfaceC22882vy7.getIndex();
        InterfaceC22882vy7[] interfaceC22882vy7Arr = this.c;
        if (index >= interfaceC22882vy7Arr.length || !AbstractC13042fc3.d(interfaceC22882vy7Arr[index].j(), interfaceC22882vy7.j())) {
            return null;
        }
        return this.d[index];
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean f() {
        return this.d.length == 0;
    }

    public final InterfaceC3932Cy7[] h() {
        return this.d;
    }

    public final InterfaceC22882vy7[] i() {
        return this.c;
    }

    public C13957h63(InterfaceC22882vy7[] interfaceC22882vy7Arr, InterfaceC3932Cy7[] interfaceC3932Cy7Arr, boolean z) {
        AbstractC13042fc3.i(interfaceC22882vy7Arr, "parameters");
        AbstractC13042fc3.i(interfaceC3932Cy7Arr, "arguments");
        this.c = interfaceC22882vy7Arr;
        this.d = interfaceC3932Cy7Arr;
        this.e = z;
        int length = interfaceC22882vy7Arr.length;
        int length2 = interfaceC3932Cy7Arr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C13957h63(List list, List list2) {
        AbstractC13042fc3.i(list, "parameters");
        AbstractC13042fc3.i(list2, "argumentsList");
        Object[] array = list.toArray(new InterfaceC22882vy7[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        InterfaceC22882vy7[] interfaceC22882vy7Arr = (InterfaceC22882vy7[]) array;
        Object[] array2 = list2.toArray(new InterfaceC3932Cy7[0]);
        if (array2 != null) {
            this(interfaceC22882vy7Arr, (InterfaceC3932Cy7[]) array2, false, 4, null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
