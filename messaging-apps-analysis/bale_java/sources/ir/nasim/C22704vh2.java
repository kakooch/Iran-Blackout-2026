package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.vh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22704vh2 implements InterfaceC20468s37 {
    private static final a e = new a(null);
    public static final int f = 8;
    private final C14930ij2 a;
    private final C10299bQ2 b;
    private final D44 c;
    private final SF3 d;

    /* renamed from: ir.nasim.vh2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vh2$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C22704vh2.this.a(null, this);
        }
    }

    public C22704vh2(C14930ij2 c14930ij2, C10299bQ2 c10299bQ2, D44 d44, SF3 sf3) {
        AbstractC13042fc3.i(c14930ij2, "feedMapper");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(d44, "mergeFeedReactions");
        AbstractC13042fc3.i(sf3, "loadFeedRequiredGroupsUseCase");
        this.a = c14930ij2;
        this.b = c10299bQ2;
        this.c = d44;
        this.d = sf3;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.util.List r24, ir.nasim.InterfaceC20295rm1 r25) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22704vh2.a(java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
