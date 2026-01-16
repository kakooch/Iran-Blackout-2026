package ir.nasim;

/* loaded from: classes4.dex */
public final class VU implements InterfaceC8121Up5 {
    private final UU a = new UU(false, YI7.b, null, null, "", 1, false, 73, null);
    private final InterfaceC23384wp6 b = AbstractC9131Yp6.b(new a(null));

    static final class a extends V06 implements InterfaceC14603iB2 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = VU.this.new a(interfaceC20295rm1);
            aVar.f = obj;
            return aVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00f4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00e5 -> B:25:0x00e8). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instructions count: 295
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VU.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // ir.nasim.InterfaceC8121Up5
    public InterfaceC23384wp6 a() {
        return this.b;
    }

    public final UU b() {
        return this.a;
    }
}
