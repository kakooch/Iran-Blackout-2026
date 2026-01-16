package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Pu, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6975Pu {
    private final E84 a;
    private final InterfaceC11621dJ7 b;
    private final InterfaceC20315ro1 c;
    private final AbstractC13778go1 d;
    private final KM2 e;

    /* renamed from: ir.nasim.Pu$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        boolean d;
        int e;
        final /* synthetic */ C11458d25 g;
        final /* synthetic */ J44 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11458d25 c11458d25, J44 j44, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = c11458d25;
            this.h = j44;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6975Pu.this.new a(this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00c2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f3 A[LOOP:0: B:33:0x00ed->B:35:0x00f3, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x011a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0138 A[ADDED_TO_REGION] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 350
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6975Pu.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6975Pu(E84 e84, InterfaceC11621dJ7 interfaceC11621dJ7, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, KM2 km2) {
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(km2, "groupRepository");
        this.a = e84;
        this.b = interfaceC11621dJ7;
        this.c = interfaceC20315ro1;
        this.d = abstractC13778go1;
        this.e = km2;
    }

    public final KM2 c() {
        return this.e;
    }

    public final void d(J44 j44, C11458d25 c11458d25) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC10533bm0.d(this.c, this.d, null, new a(c11458d25, j44, null), 2, null);
    }
}
