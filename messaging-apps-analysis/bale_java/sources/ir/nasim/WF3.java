package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class WF3 {
    private static final a e = new a(null);
    private final InterfaceC20315ro1 a;
    private final LD3 b;
    private final InterfaceC19305q74 c;
    private final AbstractC13778go1 d;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        WF3 a(InterfaceC20315ro1 interfaceC20315ro1);
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ T74 e;
        final /* synthetic */ J44 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, T74 t74, J44 j44, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = t74;
            this.f = j44;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return WF3.this.new c(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                WF3 wf3 = WF3.this;
                long j = this.d;
                C21724u16 c21724u16F = new C21724u16(0, 1, null).f();
                this.b = 1;
                obj = wf3.d(j, c21724u16F, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            FD3 fd3 = (FD3) obj;
            if (fd3 != null) {
                WF3.this.f(this.e.e(), this.f, fd3);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        long a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return WF3.this.d(0L, null, this);
        }
    }

    public WF3(InterfaceC20315ro1 interfaceC20315ro1, LD3 ld3, InterfaceC19305q74 interfaceC19305q74, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(ld3, "liveStreamRepository");
        AbstractC13042fc3.i(interfaceC19305q74, "messageRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC20315ro1;
        this.b = ld3;
        this.c = interfaceC19305q74;
        this.d = abstractC13778go1;
    }

    private final void c(T74 t74, J44 j44, long j) {
        if (j44.F() instanceof LC3) {
            AbstractC10533bm0.d(this.a, this.d, null, new c(j, t74, j44, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c3 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r11, ir.nasim.C21724u16 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.WF3.d
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.WF3$d r0 = (ir.nasim.WF3.d) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.WF3$d r0 = new ir.nasim.WF3$d
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L55
            if (r2 == r5) goto L41
            if (r2 != r4) goto L39
            long r11 = r0.a
            java.lang.Object r13 = r0.c
            ir.nasim.WF3 r13 = (ir.nasim.WF3) r13
            java.lang.Object r2 = r0.b
            ir.nasim.u16 r2 = (ir.nasim.C21724u16) r2
            ir.nasim.AbstractC10685c16.b(r14)
        L36:
            r14 = r13
            r13 = r2
            goto L59
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            long r11 = r0.a
            java.lang.Object r13 = r0.c
            ir.nasim.WF3 r13 = (ir.nasim.WF3) r13
            java.lang.Object r2 = r0.b
            ir.nasim.u16 r2 = (ir.nasim.C21724u16) r2
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r14 = r14.l()
            goto L7f
        L55:
            ir.nasim.AbstractC10685c16.b(r14)
            r14 = r10
        L59:
            boolean r2 = r13.b()
            if (r2 != 0) goto Lc6
            ir.nasim.do1 r2 = r0.getContext()
            boolean r2 = ir.nasim.AbstractC19067pj3.q(r2)
            if (r2 != 0) goto L6a
            goto Lc6
        L6a:
            ir.nasim.LD3 r2 = r14.b
            r0.b = r13
            r0.c = r14
            r0.a = r11
            r0.f = r5
            java.lang.Object r2 = r2.l(r11, r0)
            if (r2 != r1) goto L7b
            return r1
        L7b:
            r9 = r2
            r2 = r13
            r13 = r14
            r14 = r9
        L7f:
            boolean r6 = ir.nasim.C9475a16.j(r14)
            if (r6 == 0) goto L90
            boolean r11 = ir.nasim.C9475a16.g(r14)
            if (r11 == 0) goto L8c
            goto L8d
        L8c:
            r3 = r14
        L8d:
            ir.nasim.FD3 r3 = (ir.nasim.FD3) r3
            return r3
        L90:
            java.lang.Long r6 = ir.nasim.AbstractC6392Nk0.e(r11)
            int r6 = ir.nasim.AbstractC24249yI3.a(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "fetchWithRetry: masked liveKey="
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.Throwable r14 = ir.nasim.C9475a16.e(r14)
            java.lang.String r7 = "LoadLiveStreamDataUseCase"
            ir.nasim.C19406qI3.c(r7, r6, r14)
            r2.e()
            r0.b = r2
            r0.c = r13
            r0.a = r11
            r0.f = r4
            r6 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r14 = ir.nasim.HG1.b(r6, r0)
            if (r14 != r1) goto L36
            return r1
        Lc6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WF3.d(long, ir.nasim.u16, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(C11458d25 c11458d25, J44 j44, FD3 fd3) {
        try {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            LC3 lc3 = abstractC17457n0F instanceof LC3 ? (LC3) abstractC17457n0F : null;
            if (lc3 == null) {
                return;
            }
            try {
                this.c.b(c11458d25, J44.D(j44, 0L, 0L, 0L, 0, null, lc3.r(fd3.e(), fd3.f(), lc3.u()), null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null));
            } catch (RuntimeException e2) {
                e = e2;
                C19406qI3.c("LoadLiveStreamDataUseCase", "updateMessage: ", e);
            }
        } catch (RuntimeException e3) {
            e = e3;
        }
    }

    public final void e(C11458d25 c11458d25, J44 j44, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        c(new T74(c11458d25, j44.i(), j44.h()), j44, j);
    }
}
