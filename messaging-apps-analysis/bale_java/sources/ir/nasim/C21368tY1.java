package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.DX1;
import ir.nasim.MX1;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.tY1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21368tY1 extends AbstractC6360Ng4 {
    private static final c w = new c(null);
    public static final int x = 8;
    private final C9057Yh4 m;
    private boolean n;
    private final ArrayList o;
    private final InterfaceC9173Yu3 p;
    private final InterfaceC9173Yu3 q;
    private final InterfaceC9173Yu3 r;
    private final InterfaceC9173Yu3 s;
    private final InterfaceC9173Yu3 t;
    private final InterfaceC9173Yu3 u;
    private final InterfaceC9173Yu3 v;

    /* renamed from: ir.nasim.tY1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ long c;
        /* synthetic */ long d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = this.c;
                long j2 = this.d;
                InterfaceC12532em2 interfaceC12532em2N1 = C21368tY1.this.n1();
                this.b = 1;
                obj = interfaceC12532em2N1.c(j, j2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        public final Object n(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C21368tY1.this.new a(interfaceC20295rm1);
            aVar.c = j;
            aVar.d = j2;
            return aVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n(((Number) obj).longValue(), ((Number) obj2).longValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.tY1$b */
    private static final class b {
    }

    /* renamed from: ir.nasim.tY1$c */
    private static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tY1$d */
    public static final class d {
        private final FileReference a;
        private final boolean b;
        private boolean c;
        private ArrayList d;
        private boolean e;
        private float f;
        private ZY1 g;
        private boolean h;

        public d(FileReference fileReference, boolean z) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            this.a = fileReference;
            this.b = z;
            this.d = new ArrayList();
        }

        public final ArrayList a() {
            return this.d;
        }

        public final FileReference b() {
            return this.a;
        }

        public final float c() {
            return this.f;
        }

        public final ZY1 d() {
            return this.g;
        }

        public final boolean e() {
            return this.h;
        }

        public final boolean f() {
            return this.e;
        }

        public final boolean g() {
            return this.c;
        }

        public final boolean h() {
            return this.b;
        }

        public final void i(boolean z) {
            this.h = z;
        }

        public final void j(float f) {
            this.f = f;
        }

        public final void k(boolean z) {
            this.e = z;
        }

        public final void l(boolean z) {
            this.c = z;
        }

        public final void m(ZY1 zy1) {
            this.g = zy1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21368tY1(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = true;
        this.o = new ArrayList();
        this.p = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XX1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.c1(this.a);
            }
        });
        this.q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.YX1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.d1();
            }
        });
        this.r = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ZX1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.q1();
            }
        });
        this.s = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bY1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.f1(this.a);
            }
        });
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.cY1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.R0(this.a);
            }
        });
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.dY1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.Q0(this.a);
            }
        });
        this.v = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.eY1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21368tY1.b1(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.g(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(InterfaceC8807Xk2 interfaceC8807Xk2, float f) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.c(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.g(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.c(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(InterfaceC8807Xk2 interfaceC8807Xk2, RY1.a aVar) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        AbstractC13042fc3.i(aVar, "$it");
        interfaceC8807Xk2.d(aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.d(new C9115Yo(""));
    }

    private final void H0(d dVar, boolean z) {
        int size;
        Iterator it = this.o.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            d dVar2 = (d) next;
            if (!dVar2.g() && !dVar2.e()) {
                i++;
            }
        }
        if (!z) {
            this.o.add(dVar);
            return;
        }
        if (i > 10 && this.o.size() - 1 >= 0) {
            while (true) {
                int i2 = size - 1;
                if (!((d) this.o.get(size)).g() && !((d) this.o.get(size)).e()) {
                    T0((d) this.o.get(size));
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        this.o.add(0, dVar);
    }

    private final void I0(FileReference fileReference, boolean z, final InterfaceC8807Xk2 interfaceC8807Xk2, boolean z2, boolean z3, boolean z4) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "Binding file #" + fileReference.getFileId(), new Object[0]);
        }
        final RY1.a aVarV0 = V0(fileReference.getFileId(), fileReference.getAccessHash());
        if (aVarV0 != null) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.kY1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.J0(interfaceC8807Xk2, aVarV0);
                }
            });
            return;
        }
        if (z3 && p1(fileReference.getFileId(), fileReference.getAccessHash())) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.lY1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.K0(interfaceC8807Xk2);
                }
            });
            return;
        }
        d dVarG1 = g1(fileReference.getFileId());
        if (dVarG1 == null) {
            if (this.n) {
                C19406qI3.a("DownloadManager", fileReference.getFileId() + "- Adding to queue", new Object[0]);
            }
            d dVar = new d(fileReference, z3);
            if (interfaceC8807Xk2 != null) {
                dVar.a().add(interfaceC8807Xk2);
            }
            if (z) {
                dVar.l(false);
                dVar.i(true);
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.mY1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C21368tY1.L0(interfaceC8807Xk2);
                    }
                });
            } else {
                dVar.l(true);
                dVar.i(false);
                if (z4) {
                    W0(fileReference, interfaceC8807Xk2);
                } else {
                    AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.nY1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C21368tY1.M0(interfaceC8807Xk2);
                        }
                    });
                }
            }
            H0(dVar, z2);
        } else {
            if (this.n) {
                C19406qI3.a("DownloadManager", fileReference.getFileId() + "- Promoting in queue", new Object[0]);
            }
            x1(fileReference.getFileId());
            if (!AbstractC15401jX0.i0(dVarG1.a(), interfaceC8807Xk2) && interfaceC8807Xk2 != null) {
                dVarG1.a().add(interfaceC8807Xk2);
            }
            if (z) {
                dVarG1.l(false);
            }
            if (dVarG1.g()) {
                if (z4) {
                    W0(fileReference, interfaceC8807Xk2);
                } else {
                    AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.oY1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C21368tY1.N0(interfaceC8807Xk2);
                        }
                    });
                }
            } else if (dVarG1.f()) {
                final float fC = dVarG1.c();
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.pY1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C21368tY1.O0(interfaceC8807Xk2, fC);
                    }
                });
            } else {
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.qY1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C21368tY1.P0(interfaceC8807Xk2);
                    }
                });
            }
        }
        r().d(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.c(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(InterfaceC8807Xk2 interfaceC8807Xk2, RY1.a aVar) {
        AbstractC13042fc3.i(aVar, "$it");
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.d(aVar.a());
        }
    }

    private final void J1(long j, boolean z, InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "Unbind file #" + j, new Object[0]);
        }
        d dVarG1 = g1(j);
        if (dVarG1 == null) {
            if (this.n) {
                C19406qI3.a("DownloadManager", Separators.POUND + j + "- Not present in queue", new Object[0]);
            }
        } else if (z) {
            if (this.n) {
                C19406qI3.a("DownloadManager", Separators.POUND + j + "- Force Cancel download task", new Object[0]);
            }
            if (dVarG1.f() && dVarG1.e()) {
                if (this.n) {
                    C19406qI3.a("DownloadManager", "- Close download task", new Object[0]);
                }
                ZY1 zy1D = dVarG1.d();
                if (zy1D != null) {
                    zy1D.cancel();
                }
                dVarG1.m(null);
                dVarG1.k(false);
                this.o.remove(dVarG1);
            } else {
                if (this.n) {
                    C19406qI3.a("DownloadManager", Separators.POUND + j + "- Auto Cancel Removing callback", new Object[0]);
                }
                dVarG1.a().remove(interfaceC8807Xk2);
            }
        } else {
            if (this.n) {
                C19406qI3.a("DownloadManager", Separators.POUND + j + "- Removing callback", new Object[0]);
            }
            dVarG1.a().remove(interfaceC8807Xk2);
        }
        r().d(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.d(new C9115Yo(""));
        }
    }

    private final void K1(long j, long j2) {
        d dVarG1;
        if (!p1(j, j2) || (dVarG1 = g1(j)) == null) {
            return;
        }
        final C9115Yo c9115Yo = new C9115Yo("");
        Iterator it = dVarG1.a().iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            final InterfaceC8807Xk2 interfaceC8807Xk2 = (InterfaceC8807Xk2) next;
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.aY1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.L1(interfaceC8807Xk2, c9115Yo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.c(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(InterfaceC8807Xk2 interfaceC8807Xk2, C9115Yo c9115Yo) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$fileCallback");
        AbstractC13042fc3.i(c9115Yo, "$reference");
        interfaceC8807Xk2.d(c9115Yo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.g(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.g(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(InterfaceC8807Xk2 interfaceC8807Xk2, float f) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.c(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.c(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a.c Q0(C21368tY1 c21368tY1) {
        AbstractC13042fc3.i(c21368tY1, "this$0");
        return c21368tY1.m1().K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IT7 R0(C21368tY1 c21368tY1) {
        AbstractC13042fc3.i(c21368tY1, "this$0");
        return c21368tY1.m1().u();
    }

    private final void S0(long j) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "Stopping download #" + j, new Object[0]);
        }
        d dVarG1 = g1(j);
        if (dVarG1 != null) {
            T0(dVarG1);
        } else if (this.n) {
            C19406qI3.a("DownloadManager", "- Not present in queue", new Object[0]);
        }
        r().d(new b());
    }

    private final void T0(d dVar) {
        AbstractC13042fc3.f(dVar);
        if (dVar.f()) {
            if (this.n) {
                C19406qI3.a("DownloadManager", "- Stopping queue", new Object[0]);
            }
            ZY1 zy1D = dVar.d();
            if (zy1D != null) {
                zy1D.cancel();
            }
            dVar.m(null);
            dVar.k(false);
        }
        if (this.n) {
            C19406qI3.a("DownloadManager", "- Marking as stopped", new Object[0]);
        }
        dVar.l(true);
        Iterator it = dVar.a().iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            final InterfaceC8807Xk2 interfaceC8807Xk2 = (InterfaceC8807Xk2) next;
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.jY1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.U0(interfaceC8807Xk2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
        interfaceC8807Xk2.g(DX1.a.a);
    }

    private final RY1.a V0(long j, long j2) {
        String str;
        C10405bZ1 c10405bZ1 = (C10405bZ1) l1().d(j);
        if (c10405bZ1 == null) {
            return null;
        }
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(c10405bZ1.q());
        int fileSize = c10405bZ1.getFileSize();
        boolean zA = interfaceC3346Am2R.a();
        int iF = interfaceC3346Am2R.f();
        if (zA && iF == fileSize) {
            if (this.n) {
                C19406qI3.a("DownloadManager", "- Downloaded", new Object[0]);
            }
            InterfaceC3346Am2 interfaceC3346Am2R2 = KN6.r(c10405bZ1.q());
            AbstractC13042fc3.f(interfaceC3346Am2R2);
            return new RY1.a(interfaceC3346Am2R2);
        }
        l1().b(c10405bZ1.getFileId());
        if (this.n) {
            if (!zA) {
                str = "- File not found";
            } else if (iF != c10405bZ1.getFileSize()) {
                str = "- Incorrect file size. downloaded: " + iF + ", expected: " + c10405bZ1.getFileSize();
            } else {
                str = "";
            }
            C19406qI3.a("DownloadManager", str, new Object[0]);
        }
        return null;
    }

    private final void W0(FileReference fileReference, final InterfaceC8807Xk2 interfaceC8807Xk2) {
        C9528a7 c9528a7R = r();
        AbstractC13042fc3.h(c9528a7R, "self(...)");
        final Float fN = new C18495ol2(fileReference, c9528a7R, this.m, m1().f(), n1()).n();
        if (fN != null) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.hY1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.X0(interfaceC8807Xk2, fN);
                }
            });
        } else {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.iY1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.Y0(interfaceC8807Xk2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(InterfaceC8807Xk2 interfaceC8807Xk2, Float f) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.g(new DX1.c(f.floatValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(InterfaceC8807Xk2 interfaceC8807Xk2) {
        if (interfaceC8807Xk2 != null) {
            interfaceC8807Xk2.g(null);
        }
    }

    private final void Z0() {
        d dVar;
        d dVar2;
        ZY1 c18495ol2;
        if (this.n) {
            C19406qI3.a("DownloadManager", "- Checking queue", new Object[0]);
        }
        Iterator it = this.o.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            d dVar3 = (d) next;
            if (dVar3.f()) {
                if (dVar3.e()) {
                    i++;
                } else {
                    i2++;
                }
            }
        }
        if (i + i2 >= AbstractC4430Fc1.c(j1(), o1().b()) * 2) {
            if (this.n) {
                C19406qI3.a("DownloadManager", "- Already have max number of simultaneous downloads", new Object[0]);
                return;
            }
            return;
        }
        Iterator it2 = this.o.iterator();
        AbstractC13042fc3.h(it2, "iterator(...)");
        while (true) {
            if (!it2.hasNext()) {
                dVar = null;
                dVar2 = null;
                break;
            }
            Object next2 = it2.next();
            AbstractC13042fc3.h(next2, "next(...)");
            dVar2 = (d) next2;
            if (!dVar2.f() && !dVar2.g()) {
                if (dVar2.e()) {
                    dVar = null;
                } else {
                    dVar = dVar2;
                    dVar2 = null;
                }
            }
        }
        final C12889fL5 c12889fL5 = new C12889fL5();
        if (i2 < AbstractC4430Fc1.c(j1(), o1().b())) {
            c12889fL5.a = dVar;
        }
        if (c12889fL5.a == null && i < AbstractC4430Fc1.c(j1(), o1().b())) {
            c12889fL5.a = dVar2;
        }
        Object obj = c12889fL5.a;
        if (obj == null) {
            if (this.n) {
                C19406qI3.a("DownloadManager", "- No work for downloading", new Object[0]);
                return;
            }
            return;
        }
        if (this.n) {
            C19406qI3.a("DownloadManager", "- Starting download file #" + ((d) obj).b().getFileId(), new Object[0]);
        }
        ((d) c12889fL5.a).k(true);
        if (((d) c12889fL5.a).h()) {
            if (C8386Vt0.a.R3()) {
                C16007kY6 c16007kY6J = m1().j();
                InterfaceC20315ro1 interfaceC20315ro1A = m1().A();
                C9528a7 c9528a7R = r();
                AbstractC13042fc3.h(c9528a7R, "self(...)");
                c18495ol2 = new C13629gZ1(c16007kY6J, interfaceC20315ro1A, c9528a7R, new MX1.b(i1().a(((d) c12889fL5.a).b().getFileId(), ((d) c12889fL5.a).b().getAccessHash()), ((d) c12889fL5.a).b().getFileSize(), ((d) c12889fL5.a).b().getFileName(), new C4995Hl2(((d) c12889fL5.a).b().getFileId(), ((d) c12889fL5.a).b().getAccessHash())));
            } else {
                FileReference fileReferenceB = ((d) c12889fL5.a).b();
                C9528a7 c9528a7R2 = r();
                AbstractC13042fc3.h(c9528a7R2, "self(...)");
                c18495ol2 = new C3265Ad2(fileReferenceB, c9528a7R2, i1(), h1(), new a(null));
            }
        } else if (C8386Vt0.a.R3()) {
            LJ6 lj6A = m1().R0().a(new KT0() { // from class: ir.nasim.gY1
                @Override // ir.nasim.KT0
                public final InterfaceC4557Fq2 f(MX1 mx1) {
                    return C21368tY1.a1(c12889fL5, mx1);
                }
            });
            InterfaceC20315ro1 interfaceC20315ro1A2 = m1().A();
            C9528a7 c9528a7R3 = r();
            AbstractC13042fc3.h(c9528a7R3, "self(...)");
            c18495ol2 = new C13629gZ1(lj6A, interfaceC20315ro1A2, c9528a7R3, new MX1.a(((d) c12889fL5.a).b().getFileSize(), ((d) c12889fL5.a).b().getFileName(), new C11910dl2(EnumC9082Yk2.h, NN6.b), new C4995Hl2(((d) c12889fL5.a).b().getFileId(), ((d) c12889fL5.a).b().getAccessHash())));
        } else {
            C9528a7 c9528a7R4 = r();
            AbstractC13042fc3.h(c9528a7R4, "self(...)");
            c18495ol2 = new C18495ol2(((d) c12889fL5.a).b(), c9528a7R4, this.m, m1().f(), n1());
        }
        ((d) c12889fL5.a).m(c18495ol2);
        c18495ol2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 a1(C12889fL5 c12889fL5, MX1 mx1) {
        AbstractC13042fc3.i(c12889fL5, "$pendingItem");
        AbstractC13042fc3.i(mx1, "it");
        return AbstractC6459Nq2.T(new JT0(16, ((d) c12889fL5.a).b().getFileSize() < 10485760 ? BX1.b : BX1.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9824ad1 b1(C21368tY1 c21368tY1) {
        AbstractC13042fc3.i(c21368tY1, "this$0");
        return c21368tY1.m1().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8344Vo3 c1(C21368tY1 c21368tY1) {
        AbstractC13042fc3.i(c21368tY1, "this$0");
        return c21368tY1.m.D().O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC19086pl2 d1() {
        return (InterfaceC19086pl2) C92.a(C5721Ko.a.d(), InterfaceC19086pl2.class);
    }

    private final DX1 e1(Exception exc) {
        RpcException rpcException = exc instanceof RpcException ? (RpcException) exc : null;
        return AbstractC13042fc3.d(rpcException != null ? rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String() : null, "File is banned") ? DX1.b.a : new DX1.d(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC12532em2 f1(C21368tY1 c21368tY1) {
        AbstractC13042fc3.i(c21368tY1, "this$0");
        return c21368tY1.m1().Q();
    }

    private final d g1(long j) {
        Iterator it = this.o.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            d dVar = (d) next;
            if (dVar.b().getFileId() == j) {
                return dVar;
            }
        }
        return null;
    }

    private final a.c h1() {
        return (a.c) this.u.getValue();
    }

    private final IT7 i1() {
        return (IT7) this.t.getValue();
    }

    private final InterfaceC9824ad1 j1() {
        return (InterfaceC9824ad1) this.v.getValue();
    }

    private final RY1 k1(long j, long j2) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "Requesting state file #" + j, new Object[0]);
        }
        RY1.a aVarV0 = V0(j, j2);
        if (aVarV0 != null) {
            return aVarV0;
        }
        d dVarG1 = g1(j);
        if (dVarG1 == null) {
            return new RY1.c(null, 1, null);
        }
        if (!dVarG1.f() && dVarG1.g()) {
            return new RY1.c(null, 1, null);
        }
        RY1.b bVar = new RY1.b(dVarG1.c());
        return bVar;
    }

    private final InterfaceC8344Vo3 l1() {
        return (InterfaceC8344Vo3) this.p.getValue();
    }

    private final InterfaceC19086pl2 m1() {
        return (InterfaceC19086pl2) this.q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC12532em2 n1() {
        return (InterfaceC12532em2) this.s.getValue();
    }

    private final C9847af4 o1() {
        return (C9847af4) this.r.getValue();
    }

    private final boolean p1(long j, long j2) {
        long jA;
        String strA = i1().a(j, j2);
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0164b().j("").f(strA).b(4).a();
        AbstractC13042fc3.h(bVarA, "build(...)");
        long jC = DD6.c().c(strA, bVarA.g, bVarA.h);
        long j3 = bVarA.h;
        if (j3 != -1) {
            jA = bVarA.g + j3;
        } else {
            jA = InterfaceC8806Xk1.a(DD6.c().b(strA));
            if (jA == -1) {
                jA = -1;
            }
        }
        long j4 = jA == -1 ? -1L : jA - bVarA.g;
        C19406qI3.a("DownloadManager", "bindDownload stream: downloadedBytes: " + jC + ", endPosition: " + jA + ", length: " + j4, new Object[0]);
        if (j4 != -1) {
            return j4 <= jC || j4 == jC + ((long) 8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9847af4 q1() {
        return ((InterfaceC23211wY1) C92.a(C5721Ko.a.d(), InterfaceC23211wY1.class)).X0();
    }

    private final void r1(long j, Exception exc) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "onDownloadError file #" + j + ", with error=" + exc, new Object[0]);
        }
        d dVarG1 = g1(j);
        if (dVarG1 == null) {
            return;
        }
        if (this.n) {
            C19406qI3.a("DownloadManager", "onDownloadError #" + j + " found in queue!", new Object[0]);
        }
        if (!dVarG1.f()) {
            if (this.n) {
                C19406qI3.a("DownloadManager", "onDownloadError  #" + j + " queueItem is not started!", new Object[0]);
                return;
            }
            return;
        }
        ZY1 zy1D = dVarG1.d();
        if (zy1D != null) {
            zy1D.cancel();
        }
        dVarG1.m(null);
        dVarG1.l(true);
        dVarG1.k(false);
        final DX1 dx1E1 = exc != null ? e1(exc) : null;
        Iterator it = dVarG1.a().iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            final InterfaceC8807Xk2 interfaceC8807Xk2 = (InterfaceC8807Xk2) next;
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.QX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.s1(interfaceC8807Xk2, dx1E1);
                }
            });
        }
        r().d(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(InterfaceC8807Xk2 interfaceC8807Xk2, DX1 dx1) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$fileCallback");
        interfaceC8807Xk2.g(dx1);
    }

    private final void t1(long j, final float f) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "onDownloadProgress file #" + j + Separators.SP + f, new Object[0]);
        }
        d dVarG1 = g1(j);
        if (dVarG1 != null && dVarG1.f()) {
            dVarG1.j(f);
            Iterator it = dVarG1.a().iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                final InterfaceC8807Xk2 interfaceC8807Xk2 = (InterfaceC8807Xk2) next;
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.rY1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C21368tY1.u1(interfaceC8807Xk2, f);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(InterfaceC8807Xk2 interfaceC8807Xk2, float f) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$fileCallback");
        interfaceC8807Xk2.c(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(InterfaceC8807Xk2 interfaceC8807Xk2, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "$fileCallback");
        interfaceC8807Xk2.d(interfaceC3346Am2);
    }

    private final void x1(long j) {
        Iterator it = this.o.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            d dVar = (d) next;
            if (dVar.b().getFileId() == j) {
                if (dVar.f()) {
                    return;
                }
                this.o.remove(dVar);
                H0(dVar, true);
                return;
            }
        }
    }

    private final void y1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            C10405bZ1 c10405bZ1 = (C10405bZ1) l1().d(jLongValue);
            String strQ = c10405bZ1 != null ? c10405bZ1.q() : null;
            l1().b(jLongValue);
            if (strQ != null && strQ.length() != 0) {
                File file = new File(strQ);
                if (file.exists()) {
                    file.delete();
                } else {
                    C19406qI3.a("DownloadManager", "file does not exist", new Object[0]);
                }
            }
        }
    }

    private final void z1(List list, InterfaceC7850Tl4 interfaceC7850Tl4) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            XV4 xv4 = (XV4) it.next();
            arrayList.add(k1(((Number) xv4.e()).longValue(), ((Number) xv4.f()).longValue()));
        }
        interfaceC7850Tl4.a(arrayList);
    }

    public final void A1(long j, long j2, final InterfaceC8807Xk2 interfaceC8807Xk2, boolean z) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "callback");
        if (this.n) {
            C19406qI3.a("DownloadManager", "Requesting state file #" + j, new Object[0]);
        }
        final RY1.a aVarV0 = V0(j, j2);
        if (aVarV0 != null) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.RX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.F1(interfaceC8807Xk2, aVarV0);
                }
            });
            return;
        }
        if (z && p1(j, j2)) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.SX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.G1(interfaceC8807Xk2);
                }
            });
            return;
        }
        d dVarG1 = g1(j);
        if (dVarG1 == null) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.TX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.B1(interfaceC8807Xk2);
                }
            });
            return;
        }
        if (dVarG1.f()) {
            final float fC = dVarG1.c();
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.UX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.C1(interfaceC8807Xk2, fC);
                }
            });
        } else if (dVarG1.g()) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.VX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.D1(interfaceC8807Xk2);
                }
            });
        } else {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.WX1
                @Override // java.lang.Runnable
                public final void run() {
                    C21368tY1.E1(interfaceC8807Xk2);
                }
            });
        }
    }

    public final void H1(FileReference fileReference, boolean z) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        if (this.n) {
            C19406qI3.a("DownloadManager", "Starting download #" + fileReference.getFileId(), new Object[0]);
        }
        if (((C10405bZ1) l1().d(fileReference.getFileId())) != null) {
            return;
        }
        d dVarG1 = g1(fileReference.getFileId());
        if (dVarG1 == null) {
            if (this.n) {
                C19406qI3.a("DownloadManager", "- Adding to queue", new Object[0]);
            }
            d dVar = new d(fileReference, z);
            dVar.l(false);
            dVar.i(false);
            H0(dVar, true);
        } else {
            if (this.n) {
                C19406qI3.a("DownloadManager", "- Promoting in queue", new Object[0]);
            }
            if (dVarG1.g()) {
                dVarG1.l(false);
                Iterator it = dVarG1.a().iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    AbstractC13042fc3.h(next, "next(...)");
                    final InterfaceC8807Xk2 interfaceC8807Xk2 = (InterfaceC8807Xk2) next;
                    AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.PX1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C21368tY1.I1(interfaceC8807Xk2);
                        }
                    });
                }
            }
            x1(fileReference.getFileId());
        }
        r().d(new b());
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C7544Se0) {
            C7544Se0 c7544Se0 = (C7544Se0) obj;
            I0(c7544Se0.c(), c7544Se0.e(), c7544Se0.a(), c7544Se0.d(), c7544Se0.f(), c7544Se0.b());
            return;
        }
        if (obj instanceof C23030wE0) {
            S0(((C23030wE0) obj).a());
            return;
        }
        if (obj instanceof GN5) {
            y1(((GN5) obj).a());
            return;
        }
        if (obj instanceof WA7) {
            WA7 wa7 = (WA7) obj;
            J1(wa7.c(), wa7.b(), wa7.a());
            return;
        }
        if (obj instanceof C9655aK6) {
            C9655aK6 c9655aK6 = (C9655aK6) obj;
            H1(c9655aK6.a(), c9655aK6.b());
            return;
        }
        if (obj instanceof GV5) {
            GV5 gv5 = (GV5) obj;
            A1(gv5.c(), gv5.a(), gv5.b(), gv5.d());
            return;
        }
        if (obj instanceof C8084Ul4) {
            C8084Ul4 c8084Ul4 = (C8084Ul4) obj;
            z1(c8084Ul4.a(), c8084Ul4.b());
            return;
        }
        if (obj instanceof b) {
            Z0();
            return;
        }
        if (obj instanceof C12870fJ4) {
            C12870fJ4 c12870fJ4 = (C12870fJ4) obj;
            t1(c12870fJ4.a(), c12870fJ4.b());
            return;
        }
        if (obj instanceof C13488gJ4) {
            C13488gJ4 c13488gJ4 = (C13488gJ4) obj;
            v1(c13488gJ4.a(), c13488gJ4.b());
        } else if (obj instanceof C14079hJ4) {
            C14079hJ4 c14079hJ4 = (C14079hJ4) obj;
            r1(c14079hJ4.b(), c14079hJ4.a());
        } else if (!(obj instanceof DF7)) {
            super.m(obj);
        } else {
            DF7 df7 = (DF7) obj;
            K1(df7.b(), df7.a());
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        if (AbstractC7607Sl0.b.booleanValue()) {
            m1().K0().c();
        }
    }

    public final void v1(long j, final InterfaceC3346Am2 interfaceC3346Am2) {
        if (this.n) {
            C19406qI3.a("DownloadManager", "onDownloaded file #" + j, new Object[0]);
        }
        d dVarG1 = g1(j);
        if (dVarG1 != null && dVarG1.f()) {
            InterfaceC8344Vo3 interfaceC8344Vo3L1 = l1();
            long fileId = dVarG1.b().getFileId();
            int fileSize = dVarG1.b().getFileSize();
            AbstractC13042fc3.f(interfaceC3346Am2);
            interfaceC8344Vo3L1.e(new C10405bZ1(fileId, fileSize, interfaceC3346Am2.getDescriptor()));
            this.o.remove(dVarG1);
            ZY1 zy1D = dVarG1.d();
            if (zy1D != null) {
                zy1D.cancel();
            }
            dVarG1.m(null);
            Iterator it = dVarG1.a().iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                final InterfaceC8807Xk2 interfaceC8807Xk2 = (InterfaceC8807Xk2) next;
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.fY1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C21368tY1.w1(interfaceC8807Xk2, interfaceC3346Am2);
                    }
                });
            }
            r().d(new b());
        }
    }
}
