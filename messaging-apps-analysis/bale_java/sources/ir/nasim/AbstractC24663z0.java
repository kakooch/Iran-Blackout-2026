package ir.nasim;

import ir.nasim.AbstractC24073y0;

/* renamed from: ir.nasim.z0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC24663z0 {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;
    public static final /* synthetic */ int[] d;

    static {
        int[] iArr = new int[AbstractC24073y0.c.values().length];
        a = iArr;
        AbstractC24073y0.c cVar = AbstractC24073y0.c.STOPPED;
        iArr[cVar.ordinal()] = 1;
        int[] iArr2 = new int[AbstractC24073y0.c.values().length];
        b = iArr2;
        AbstractC24073y0.c cVar2 = AbstractC24073y0.c.ACTIVATED;
        iArr2[cVar2.ordinal()] = 1;
        AbstractC24073y0.c cVar3 = AbstractC24073y0.c.STARTED;
        iArr2[cVar3.ordinal()] = 2;
        iArr2[cVar.ordinal()] = 3;
        int[] iArr3 = new int[AbstractC24073y0.c.values().length];
        c = iArr3;
        iArr3[cVar3.ordinal()] = 1;
        iArr3[cVar2.ordinal()] = 2;
        iArr3[cVar.ordinal()] = 3;
        int[] iArr4 = new int[AbstractC24073y0.c.values().length];
        d = iArr4;
        iArr4[cVar2.ordinal()] = 1;
        iArr4[cVar3.ordinal()] = 2;
        iArr4[cVar.ordinal()] = 3;
    }
}
