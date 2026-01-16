package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.r32, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19854r32 {
    private final C10299bQ2 a;

    /* renamed from: ir.nasim.r32$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C19854r32.this.b(0, null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.r32$b */
    static final class b implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(C14505i18 c14505i18) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(Boolean.TRUE)));
        }
    }

    /* renamed from: ir.nasim.r32$c */
    static final class c implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        c(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(exc);
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc))));
        }
    }

    public C19854r32(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = c10299bQ2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(int r5, java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C19854r32.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.r32$a r0 = (ir.nasim.C19854r32.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.r32$a r0 = new ir.nasim.r32$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.a
            ir.nasim.r32 r5 = (ir.nasim.C19854r32) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L79
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r4
            r0.b = r6
            r0.c = r5
            r0.f = r3
            ir.nasim.IE0 r7 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r7.<init>(r2, r3)
            r7.w()
            ir.nasim.bQ2 r2 = a(r4)
            ir.nasim.Nv5 r5 = r2.G1(r5, r6)
            ir.nasim.r32$b r6 = new ir.nasim.r32$b
            r6.<init>(r7)
            ir.nasim.Nv5 r5 = r5.m0(r6)
            ir.nasim.r32$c r6 = new ir.nasim.r32$c
            r6.<init>(r7)
            r5.E(r6)
            java.lang.Object r7 = r7.t()
            java.lang.Object r5 = ir.nasim.AbstractC13660gc3.e()
            if (r7 != r5) goto L76
            ir.nasim.WA1.c(r0)
        L76:
            if (r7 != r1) goto L79
            return r1
        L79:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19854r32.b(int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
