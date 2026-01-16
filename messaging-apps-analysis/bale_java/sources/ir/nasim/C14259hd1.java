package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.hd1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14259hd1 {
    private final InterfaceC9336Zm4 a;
    private final InterfaceC4557Fq2 b;

    /* renamed from: ir.nasim.hd1$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.hd1$a$a, reason: collision with other inner class name */
        public static final class C1270a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.hd1$a$a$a, reason: collision with other inner class name */
            public static final class C1271a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1271a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C1270a.this.a(null, this);
                }
            }

            public C1270a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C14259hd1.a.C1270a.C1271a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.hd1$a$a$a r0 = (ir.nasim.C14259hd1.a.C1270a.C1271a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.hd1$a$a$a r0 = new ir.nasim.hd1$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.XV4 r5 = (ir.nasim.XV4) r5
                    java.lang.Object r5 = r5.f()
                    if (r5 == 0) goto L47
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14259hd1.a.C1270a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C1270a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C14259hd1(Object obj) {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new XV4(Integer.valueOf(RecyclerView.UNDEFINED_DURATION), obj));
        this.a = interfaceC9336Zm4A;
        this.b = new a(interfaceC9336Zm4A);
    }

    public final InterfaceC4557Fq2 a() {
        return this.b;
    }

    public final void b(Object obj) {
        AbstractC13042fc3.i(obj, "data");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        interfaceC9336Zm4.setValue(new XV4(Integer.valueOf(((Number) ((XV4) interfaceC9336Zm4.getValue()).e()).intValue() + 1), obj));
    }

    public /* synthetic */ C14259hd1(Object obj, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : obj);
    }
}
