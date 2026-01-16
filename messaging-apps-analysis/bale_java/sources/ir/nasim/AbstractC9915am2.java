package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.am2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9915am2 {

    /* renamed from: ir.nasim.am2$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objB = AbstractC9915am2.b(null, null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.am2$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objC = AbstractC9915am2.c(null, null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.am2$e */
    public static final class e implements InterfaceC8807Xk2 {
        final /* synthetic */ HE0 a;

        e(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("onDownloading")))));
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(interfaceC3346Am2.getDescriptor())));
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("onNotDownloaded")))));
        }
    }

    public static final void a(FileReference fileReference, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "callback");
        if (fileReference == null) {
            ua2.invoke("");
        } else {
            C14970in2 c14970in2D = AbstractC5969Lp4.d().o2().D();
            C14970in2.K(c14970in2D, fileReference, new a(ua2, c14970in2D, fileReference), false, false, 12, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.C10977cX1 r10, ir.nasim.C14970in2 r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            boolean r0 = r12 instanceof ir.nasim.AbstractC9915am2.b
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.am2$b r0 = (ir.nasim.AbstractC9915am2.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.am2$b r0 = new ir.nasim.am2$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r10 = r0.b
            ir.nasim.in2 r10 = (ir.nasim.C14970in2) r10
            java.lang.Object r10 = r0.a
            ir.nasim.cX1 r10 = (ir.nasim.C10977cX1) r10
            ir.nasim.AbstractC10685c16.b(r12)
            goto L72
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            ir.nasim.AbstractC10685c16.b(r12)
            r0.a = r10
            r0.b = r11
            r0.d = r3
            ir.nasim.IE0 r12 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r12.<init>(r2, r3)
            r12.w()
            ir.nasim.aD4 r2 = ir.nasim.C9590aD4.a
            ir.nasim.core.modules.file.entity.FileReference r4 = r2.b(r10)
            ir.nasim.am2$c r5 = new ir.nasim.am2$c
            r5.<init>(r12, r11, r4)
            r8 = 12
            r9 = 0
            r6 = 0
            r7 = 0
            r3 = r11
            ir.nasim.C14970in2.K(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Object r12 = r12.t()
            java.lang.Object r10 = ir.nasim.AbstractC13660gc3.e()
            if (r12 != r10) goto L6f
            ir.nasim.WA1.c(r0)
        L6f:
            if (r12 != r1) goto L72
            return r1
        L72:
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            java.lang.Object r10 = r12.l()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9915am2.b(ir.nasim.cX1, ir.nasim.in2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.core.modules.file.entity.FileReference r4, ir.nasim.C14970in2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r0 = r6 instanceof ir.nasim.AbstractC9915am2.d
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.am2$d r0 = (ir.nasim.AbstractC9915am2.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.am2$d r0 = new ir.nasim.am2$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.b
            ir.nasim.in2 r4 = (ir.nasim.C14970in2) r4
            java.lang.Object r4 = r0.a
            ir.nasim.core.modules.file.entity.FileReference r4 = (ir.nasim.core.modules.file.entity.FileReference) r4
            ir.nasim.AbstractC10685c16.b(r6)
            goto L66
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r4
            r0.b = r5
            r0.d = r3
            ir.nasim.IE0 r6 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r6.<init>(r2, r3)
            r6.w()
            ir.nasim.am2$e r2 = new ir.nasim.am2$e
            r2.<init>(r6)
            r5.P(r4, r2)
            java.lang.Object r6 = r6.t()
            java.lang.Object r4 = ir.nasim.AbstractC13660gc3.e()
            if (r6 != r4) goto L63
            ir.nasim.WA1.c(r0)
        L63:
            if (r6 != r1) goto L66
            return r1
        L66:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r4 = r6.l()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9915am2.c(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.in2, ir.nasim.rm1):java.lang.Object");
    }

    /* renamed from: ir.nasim.am2$a */
    public static final class a implements InterfaceC8807Xk2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ C14970in2 b;
        final /* synthetic */ FileReference c;

        a(UA2 ua2, C14970in2 c14970in2, FileReference fileReference) {
            this.a = ua2;
            this.b = c14970in2;
            this.c = fileReference;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.invoke(interfaceC3346Am2.getDescriptor());
            this.b.j0(this.c.getFileId(), this, false);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            this.a.invoke("");
            this.b.j0(this.c.getFileId(), this, true);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
        }
    }

    /* renamed from: ir.nasim.am2$c */
    public static final class c implements InterfaceC8807Xk2 {
        final /* synthetic */ HE0 a;
        final /* synthetic */ C14970in2 b;
        final /* synthetic */ FileReference c;

        c(HE0 he0, C14970in2 c14970in2, FileReference fileReference) {
            this.a = he0;
            this.b = c14970in2;
            this.c = fileReference;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(interfaceC3346Am2.getDescriptor())));
            this.b.j0(this.c.getFileId(), this, false);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("onNotDownloaded")))));
            this.b.j0(this.c.getFileId(), this, true);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
        }
    }
}
