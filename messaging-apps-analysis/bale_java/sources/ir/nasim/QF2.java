package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC18013nw1;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.MX1;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class QF2 {
    private final IY1 a;
    private final C14970in2 b;
    private final InterfaceC12532em2 c;
    private final C5229Il2 d;
    private final C9847af4 e;
    private final IT7 f;

    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return QF2.this.d(0L, 0L, null, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return QF2.this.e(0L, 0L, null, this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return QF2.this.f(null, this);
        }
    }

    static final class d extends AbstractC22163um1 {
        long a;
        long b;
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
            return QF2.this.n(0L, 0L, false, this);
        }
    }

    public QF2(IY1 iy1, C14970in2 c14970in2, InterfaceC12532em2 interfaceC12532em2, C5229Il2 c5229Il2, C9847af4 c9847af4, IT7 it7) {
        AbstractC13042fc3.i(iy1, "downloadRepository");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(c5229Il2, "fileLocationToStreamableItemDownloadInputMapper");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        AbstractC13042fc3.i(it7, "videoPlayerCacheIdGenerator");
        this.a = iy1;
        this.b = c14970in2;
        this.c = interfaceC12532em2;
        this.d = c5229Il2;
        this.e = c9847af4;
        this.f = it7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r5, long r7, ir.nasim.InterfaceC8807Xk2 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof ir.nasim.QF2.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.QF2$a r0 = (ir.nasim.QF2.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.QF2$a r0 = new ir.nasim.QF2$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.a
            r9 = r5
            ir.nasim.Xk2 r9 = (ir.nasim.InterfaceC8807Xk2) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto L49
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.Hl2 r10 = new ir.nasim.Hl2
            r10.<init>(r5, r7)
            r0.a = r9
            r0.d = r3
            java.lang.Object r10 = r4.h(r10, r0)
            if (r10 != r1) goto L49
            return r1
        L49:
            ir.nasim.nw1 r10 = (ir.nasim.InterfaceC18013nw1) r10
            boolean r5 = r10 instanceof ir.nasim.InterfaceC18013nw1.a
            if (r5 == 0) goto L64
            ir.nasim.Yo r5 = new ir.nasim.Yo
            ir.nasim.nw1$a r10 = (ir.nasim.InterfaceC18013nw1.a) r10
            ir.nasim.al2 r6 = r10.a()
            ir.nasim.al2$a r6 = (ir.nasim.InterfaceC9905al2.a) r6
            java.lang.String r6 = r6.a()
            r5.<init>(r6)
            r9.d(r5)
            goto L6c
        L64:
            boolean r5 = r10 instanceof ir.nasim.InterfaceC18013nw1.b
            if (r5 == 0) goto L6f
            r5 = 0
            r9.g(r5)
        L6c:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        L6f:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QF2.d(long, long, ir.nasim.Xk2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(long r5, long r7, ir.nasim.InterfaceC8807Xk2 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof ir.nasim.QF2.b
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.QF2$b r0 = (ir.nasim.QF2.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.QF2$b r0 = new ir.nasim.QF2$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.a
            r9 = r5
            ir.nasim.Xk2 r9 = (ir.nasim.InterfaceC8807Xk2) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto L4f
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.Il2 r10 = r4.d
            ir.nasim.Hl2 r2 = new ir.nasim.Hl2
            r2.<init>(r5, r7)
            ir.nasim.MX1$b r5 = r10.a(r2)
            r0.a = r9
            r0.d = r3
            java.lang.Object r10 = r4.g(r5, r0)
            if (r10 != r1) goto L4f
            return r1
        L4f:
            ir.nasim.nw1 r10 = (ir.nasim.InterfaceC18013nw1) r10
            boolean r5 = r10 instanceof ir.nasim.InterfaceC18013nw1.a
            if (r5 == 0) goto L60
            ir.nasim.Yo r5 = new ir.nasim.Yo
            java.lang.String r6 = ""
            r5.<init>(r6)
            r9.d(r5)
            goto L67
        L60:
            boolean r5 = r10 instanceof ir.nasim.InterfaceC18013nw1.b
            if (r5 == 0) goto L6a
            r9.e()
        L67:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        L6a:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QF2.e(long, long, ir.nasim.Xk2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.C4995Hl2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.QF2.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.QF2$c r0 = (ir.nasim.QF2.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.QF2$c r0 = new ir.nasim.QF2$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.a
            ir.nasim.Hl2 r6 = (ir.nasim.C4995Hl2) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.IY1 r7 = r5.a
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = r7.b(r6, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.nw1 r7 = (ir.nasim.InterfaceC18013nw1) r7
            boolean r0 = r7 instanceof ir.nasim.InterfaceC18013nw1.a
            if (r0 == 0) goto L66
            ir.nasim.nw1$a r7 = (ir.nasim.InterfaceC18013nw1.a) r7
            ir.nasim.al2 r7 = r7.a()
            ir.nasim.al2$a r7 = (ir.nasim.InterfaceC9905al2.a) r7
            ir.nasim.bZ1 r0 = new ir.nasim.bZ1
            long r1 = r6.b()
            long r3 = r7.b()
            int r6 = (int) r3
            java.lang.String r7 = r7.a()
            r0.<init>(r1, r6, r7)
            goto L6b
        L66:
            boolean r6 = r7 instanceof ir.nasim.InterfaceC18013nw1.b
            if (r6 == 0) goto L6c
            r0 = 0
        L6b:
            return r0
        L6c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QF2.f(ir.nasim.Hl2, ir.nasim.rm1):java.lang.Object");
    }

    private final Object g(MX1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.a(bVar, interfaceC20295rm1);
    }

    private final Object h(C4995Hl2 c4995Hl2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.b(c4995Hl2, interfaceC20295rm1);
    }

    private final C10405bZ1 i(long j) {
        return (C10405bZ1) this.b.O().d(j);
    }

    private final void j(long j, long j2, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z) {
        this.b.V(j, j2, interfaceC8807Xk2, z);
    }

    private final Object k(long j, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.c.l(j, j2, z, interfaceC20295rm1);
    }

    private final RY1 q(InterfaceC18013nw1 interfaceC18013nw1, long j, long j2) {
        if (!(interfaceC18013nw1 instanceof InterfaceC18013nw1.a)) {
            if (interfaceC18013nw1 instanceof InterfaceC18013nw1.b) {
                return new RY1.c(null, 1, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC9905al2 interfaceC9905al2A = ((InterfaceC18013nw1.a) interfaceC18013nw1).a();
        if (interfaceC9905al2A instanceof InterfaceC9905al2.a) {
            return new RY1.a(new C9115Yo(((InterfaceC9905al2.a) interfaceC9905al2A).a()));
        }
        if (interfaceC9905al2A instanceof InterfaceC9905al2.b) {
            return new RY1.a(new C9115Yo(this.f.a(j, j2)));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object l(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.e.b() ? f(new C4995Hl2(j, j2), interfaceC20295rm1) : i(j);
    }

    public final Object m(long j, long j2, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!this.e.b()) {
            j(j, j2, interfaceC8807Xk2, z);
            return C19938rB7.a;
        }
        if (z) {
            Object objE = e(j, j2, interfaceC8807Xk2, interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }
        Object objD = d(j, j2, interfaceC8807Xk2, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(long r9, long r11, boolean r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof ir.nasim.QF2.d
            if (r0 == 0) goto L14
            r0 = r14
            ir.nasim.QF2$d r0 = (ir.nasim.QF2.d) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            ir.nasim.QF2$d r0 = new ir.nasim.QF2$d
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r14 = r7.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.f
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L58
            if (r1 == r4) goto L49
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            ir.nasim.AbstractC10685c16.b(r14)
            goto Lb6
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            long r11 = r7.b
            long r9 = r7.a
            java.lang.Object r13 = r7.c
            ir.nasim.QF2 r13 = (ir.nasim.QF2) r13
            ir.nasim.AbstractC10685c16.b(r14)
            r3 = r9
            r5 = r11
            r1 = r13
            goto La1
        L49:
            long r11 = r7.b
            long r9 = r7.a
            java.lang.Object r13 = r7.c
            ir.nasim.QF2 r13 = (ir.nasim.QF2) r13
            ir.nasim.AbstractC10685c16.b(r14)
            r3 = r9
            r5 = r11
            r1 = r13
            goto L82
        L58:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.af4 r14 = r8.e
            boolean r14 = r14.b()
            if (r14 == 0) goto La9
            if (r13 == 0) goto L8a
            ir.nasim.Il2 r13 = r8.d
            ir.nasim.Hl2 r14 = new ir.nasim.Hl2
            r14.<init>(r9, r11)
            ir.nasim.MX1$b r13 = r13.a(r14)
            r7.c = r8
            r7.a = r9
            r7.b = r11
            r7.f = r4
            java.lang.Object r14 = r8.g(r13, r7)
            if (r14 != r0) goto L7f
            return r0
        L7f:
            r1 = r8
            r3 = r9
            r5 = r11
        L82:
            r2 = r14
            ir.nasim.nw1 r2 = (ir.nasim.InterfaceC18013nw1) r2
            ir.nasim.RY1 r9 = r1.q(r2, r3, r5)
            goto La8
        L8a:
            ir.nasim.Hl2 r13 = new ir.nasim.Hl2
            r13.<init>(r9, r11)
            r7.c = r8
            r7.a = r9
            r7.b = r11
            r7.f = r3
            java.lang.Object r14 = r8.h(r13, r7)
            if (r14 != r0) goto L9e
            return r0
        L9e:
            r1 = r8
            r3 = r9
            r5 = r11
        La1:
            r2 = r14
            ir.nasim.nw1 r2 = (ir.nasim.InterfaceC18013nw1) r2
            ir.nasim.RY1 r9 = r1.q(r2, r3, r5)
        La8:
            return r9
        La9:
            r7.f = r2
            r1 = r8
            r2 = r9
            r4 = r11
            r6 = r13
            java.lang.Object r14 = r1.k(r2, r4, r6, r7)
            if (r14 != r0) goto Lb6
            return r0
        Lb6:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QF2.n(long, long, boolean, ir.nasim.rm1):java.lang.Object");
    }

    public final Object o(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.e.b() ? f(new C4995Hl2(fileReference.getFileId(), fileReference.getAccessHash()), interfaceC20295rm1) : i(fileReference.getFileId());
    }
}
