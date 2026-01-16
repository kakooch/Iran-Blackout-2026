package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.zB2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24775zB2 extends MI2 {

    /* renamed from: ir.nasim.zB2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24185yB2.values().length];
            iArr[EnumC24185yB2.d.ordinal()] = 1;
            iArr[EnumC24185yB2.e.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24775zB2(ON6 on6, C23595xB2 c23595xB2) {
        super(on6, c23595xB2);
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(c23595xB2, "containingClass");
    }

    @Override // ir.nasim.MI2
    protected List i() {
        int i = a.a[((C23595xB2) l()).T0().ordinal()];
        return i != 1 ? i != 2 ? AbstractC10360bX0.m() : AbstractC9766aX0.e(CB2.G.a((C23595xB2) l(), true)) : AbstractC9766aX0.e(CB2.G.a((C23595xB2) l(), false));
    }
}
