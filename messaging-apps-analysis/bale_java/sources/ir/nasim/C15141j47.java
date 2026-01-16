package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Date;
import java.util.List;

/* renamed from: ir.nasim.j47, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15141j47 {
    private final C23050wG2 a;
    private final C3748Ce3 b;
    private final InterfaceC3570Bk5 c;
    private final InterfaceC4308Eo5 d;

    /* renamed from: ir.nasim.j47$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C15141j47.this.c(this);
        }
    }

    /* renamed from: ir.nasim.j47$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C15141j47.this.d();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15141j47.this.new b(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.j47$c */
    static final class c implements InterfaceC4806Gq2 {
        c() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objF = C15141j47.this.d.f(list, false, interfaceC20295rm1);
            return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
        }
    }

    public C15141j47(C23050wG2 c23050wG2, C3748Ce3 c3748Ce3, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC4308Eo5 interfaceC4308Eo5) {
        AbstractC13042fc3.i(c23050wG2, "getSplitContactsUserIds");
        AbstractC13042fc3.i(c3748Ce3, "isEligibleToSyncPresenceUseCase");
        AbstractC13042fc3.i(interfaceC3570Bk5, "mainConfig");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        this.a = c23050wG2;
        this.b = c3748Ce3;
        this.c = interfaceC3570Bk5;
        this.d = interfaceC4308Eo5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.c.putLong("LAST_PRESENCES_SYNC_TIME", new Date().getTime());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C15141j47.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.j47$a r0 = (ir.nasim.C15141j47.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.j47$a r0 = new ir.nasim.j47$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L60
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.Ce3 r6 = r5.b
            boolean r6 = r6.a()
            if (r6 != 0) goto L42
            r6 = 0
            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r6)
            return r6
        L42:
            ir.nasim.wG2 r6 = r5.a
            ir.nasim.Fq2 r6 = r6.e()
            ir.nasim.j47$b r2 = new ir.nasim.j47$b
            r4 = 0
            r2.<init>(r4)
            ir.nasim.Fq2 r6 = ir.nasim.AbstractC6459Nq2.a0(r6, r2)
            ir.nasim.j47$c r2 = new ir.nasim.j47$c
            r2.<init>()
            r0.c = r3
            java.lang.Object r6 = r6.b(r2, r0)
            if (r6 != r1) goto L60
            return r1
        L60:
            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15141j47.c(ir.nasim.rm1):java.lang.Object");
    }
}
