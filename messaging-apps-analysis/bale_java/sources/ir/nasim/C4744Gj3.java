package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Gj3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4744Gj3 {
    private final C4627Fy0 a;
    private final C23631xF2 b;

    /* renamed from: ir.nasim.Gj3$a */
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
            Object objA = C4744Gj3.this.a(null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public C4744Gj3(C4627Fy0 c4627Fy0, C23631xF2 c23631xF2) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(c23631xF2, "getCallLinkDetailsUseCase");
        this.a = c4627Fy0;
        this.b = c23631xF2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4744Gj3.a(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
