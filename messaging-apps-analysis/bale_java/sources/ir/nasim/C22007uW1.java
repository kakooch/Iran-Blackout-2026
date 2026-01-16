package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.LY1;
import ir.nasim.MW1;
import ir.nasim.MX1;
import ir.nasim.SY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.uW1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22007uW1 implements InterfaceC8091Um2, InterfaceC12246eH7 {
    private final C14970in2 a;
    private final AbstractC17757nW1 b;
    private final SettingsModule c;
    private final ArrayList d;
    private InterfaceC7857Tm2 e;
    private C11603dH7 f;
    private float g;
    private final InterfaceC9173Yu3 h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9173Yu3 j;
    private final C10535bm2 k;
    private final IX1 l;
    private a m;

    /* renamed from: ir.nasim.uW1$a */
    protected static final class a {
        private final InterfaceC20315ro1 a;
        private final MX1 b;

        public a(InterfaceC20315ro1 interfaceC20315ro1, MX1 mx1) {
            AbstractC13042fc3.i(interfaceC20315ro1, "scope");
            AbstractC13042fc3.i(mx1, "input");
            this.a = interfaceC20315ro1;
            this.b = mx1;
        }

        public final MX1 a() {
            return this.b;
        }

        public final InterfaceC20315ro1 b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "NewDownloaderData(scope=" + this.a + ", input=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uW1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ a d;
        final /* synthetic */ FileReference e;

        /* renamed from: ir.nasim.uW1$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C22007uW1 a;
            final /* synthetic */ FileReference b;

            a(C22007uW1 c22007uW1, FileReference fileReference) {
                this.a = c22007uW1;
                this.b = fileReference;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
                C22007uW1.F(this.a, -1, "collected state= " + sy1, this.b, null, 8, null);
                if (sy1 instanceof SY1.a) {
                    this.a.d(new C9115Yo(((InterfaceC9905al2.a) ((SY1.a) sy1).a()).a()));
                } else if (sy1 instanceof SY1.b) {
                    this.a.c(((SY1.b) sy1).a());
                } else {
                    if (!(sy1 instanceof SY1.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C22007uW1 c22007uW1 = this.a;
                    EX1 ex1A = ((SY1.c) sy1).a();
                    c22007uW1.g(ex1A != null ? this.a.t().a(ex1A) : null);
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
            this.e = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22007uW1.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = C22007uW1.this.v().r((MX1.a) this.d.a());
                a aVar = new a(C22007uW1.this, this.e);
                this.b = 1;
                if (interfaceC4557Fq2R.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22007uW1(C14970in2 c14970in2, AbstractC17757nW1 abstractC17757nW1, SettingsModule settingsModule) {
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = c14970in2;
        this.b = abstractC17757nW1;
        this.c = settingsModule;
        this.d = new ArrayList();
        this.g = -1.0f;
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rW1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22007uW1.q();
            }
        });
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.sW1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22007uW1.p();
            }
        });
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.tW1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22007uW1.G(this.a);
            }
        });
        this.k = C10535bm2.a;
        this.l = IX1.a;
    }

    private final boolean D(String str) {
        return AbstractC20153rZ6.B(str, ".apk", true);
    }

    public static /* synthetic */ void F(C22007uW1 c22007uW1, int i, String str, FileReference fileReference, MX1 mx1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logDownload");
        }
        if ((i2 & 4) != 0) {
            fileReference = null;
        }
        if ((i2 & 8) != 0) {
            mx1 = null;
        }
        c22007uW1.E(i, str, fileReference, mx1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9847af4 G(C22007uW1 c22007uW1) {
        AbstractC13042fc3.i(c22007uW1, "this$0");
        return c22007uW1.w().X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC23211wY1 p() {
        return (InterfaceC23211wY1) C92.a(C5721Ko.a.d(), InterfaceC23211wY1.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20748sY1 q() {
        return ((InterfaceC24012xt4) C92.a(C5721Ko.a.d(), InterfaceC24012xt4.class)).y();
    }

    protected final a A() {
        return this.m;
    }

    protected final SettingsModule B() {
        return this.c;
    }

    protected final C11603dH7 C() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void E(int r7, java.lang.String r8, ir.nasim.core.modules.file.entity.FileReference r9, ir.nasim.MX1 r10) {
        /*
            r6 = this;
            java.lang.String r0 = "message"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "NDownloaderS"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = ""
            java.lang.String r1 = "-"
            if (r9 == 0) goto L3d
            int r2 = r9.getFileSize()
            java.lang.String r9 = r9.getFileName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "\nfileRef:"
            r3.append(r4)
            r3.append(r2)
            r3.append(r1)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            if (r9 != 0) goto L3e
        L3d:
            r9 = r0
        L3e:
            if (r10 == 0) goto L63
            long r2 = r10.b()
            java.lang.String r10 = r10.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\ndownloadInput:"
            r4.append(r5)
            r4.append(r2)
            r4.append(r1)
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            if (r10 != 0) goto L62
            goto L63
        L62:
            r0 = r10
        L63:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "message:"
            r10.append(r1)
            r10.append(r8)
            r10.append(r9)
            r10.append(r0)
            java.lang.String r8 = r10.toString()
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]
            ir.nasim.C19406qI3.a(r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22007uW1.E(int, java.lang.String, ir.nasim.core.modules.file.entity.FileReference, ir.nasim.MX1):void");
    }

    public void H() {
        MW1 mw1B = this.b.b();
        if (!(mw1B instanceof MW1.b)) {
            if (!(mw1B instanceof MW1.a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.a.S(((MW1.a) mw1B).c());
            return;
        }
        a aVar = this.m;
        if (aVar != null) {
            F(this, 0, "pause", null, aVar.a(), 4, null);
            v().h(aVar.a());
        } else {
            this.a.H(((MW1.b) mw1B).a().b().getFileId());
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((AbstractC22597vW1) it.next()).o(this.g);
            }
        }
    }

    public final void I(AbstractC22597vW1 abstractC22597vW1) {
        AbstractC13042fc3.i(abstractC22597vW1, "documentBinderAdapter");
        this.d.add(abstractC22597vW1);
    }

    public final void J(List list) {
        AbstractC13042fc3.i(list, "adapters");
        AbstractC13610gX0.D(this.d, list);
    }

    public void K(MW1 mw1) {
        AbstractC13042fc3.i(mw1, "documentState");
        a aVar = this.m;
        if (aVar != null) {
            S(aVar, true);
        } else {
            InterfaceC7857Tm2 interfaceC7857Tm2 = this.e;
            if (interfaceC7857Tm2 != null) {
                interfaceC7857Tm2.a(false);
            }
            this.e = null;
            C11603dH7 c11603dH7 = this.f;
            if (c11603dH7 != null) {
                c11603dH7.a(false);
            }
            this.f = null;
        }
        this.g = mw1.a().f() / 1024.0f;
        if (!(mw1 instanceof MW1.b)) {
            if (!(mw1 instanceof MW1.a)) {
                throw new NoWhenBranchMatchedException();
            }
            MW1.a aVar2 = (MW1.a) mw1;
            if (aVar2.b()) {
                this.f = AbstractC5969Lp4.d().r(aVar2.c(), this);
                return;
            }
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((AbstractC22597vW1) it.next()).t(this.g);
            }
            return;
        }
        MW1.b bVar = (MW1.b) mw1;
        boolean zQ = Q(this.b.a(), bVar.a().b());
        if (!z().b()) {
            this.e = this.a.D(bVar.a().b(), zQ, this, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            return;
        }
        a aVarO = o(bVar.a().b());
        this.m = aVarO;
        F(this, 0, "rebind", bVar.a().b(), null, 8, null);
        if (zQ) {
            v().u(aVarO.a(), new FY1(null, 1, null), new LY1.a(null, 1, null));
        }
    }

    public void L() {
        MW1 mw1B = this.b.b();
        if (mw1B instanceof MW1.b) {
            a aVar = this.m;
            if (aVar != null) {
                F(this, 0, "resume", null, aVar.a(), 4, null);
                v().u(aVar.a(), new FY1(null, 1, null), LY1.b.a);
            } else {
                C14970in2.i0(this.a, ((MW1.b) mw1B).a().b(), false, 2, null);
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((AbstractC22597vW1) it.next()).p();
                }
            }
        }
    }

    protected final void M(InterfaceC7857Tm2 interfaceC7857Tm2) {
        this.e = interfaceC7857Tm2;
    }

    protected final void N(float f) {
        this.g = f;
    }

    protected final void O(a aVar) {
        this.m = aVar;
    }

    protected final void P(C11603dH7 c11603dH7) {
        this.f = c11603dH7;
    }

    public boolean Q(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        return AbstractC3574Bl0.b(enumC18310oS) && ((float) fileReference.getFileSize()) / 1048576.0f <= ((float) this.c.B0()) && !D(fileReference.getFileName());
    }

    public void R() {
        a aVar = this.m;
        if (aVar != null) {
            F(this, -3, "unbind", null, aVar.a(), 4, null);
            S(aVar, false);
        }
        this.m = null;
        this.g = -1.0f;
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.e;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.e = null;
        C11603dH7 c11603dH7 = this.f;
        if (c11603dH7 != null) {
            c11603dH7.b();
        }
        this.f = null;
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).a();
        }
        this.d.clear();
    }

    protected final void S(a aVar, boolean z) {
        AbstractC13042fc3.i(aVar, "downloaderData");
        if (z) {
            v().h(aVar.a());
        } else {
            v().g(aVar.a());
        }
        AbstractC20906so1.d(aVar.b(), null, 1, null);
    }

    public void b() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).t(this.g);
        }
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void c(float f) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).q(f, this.g);
        }
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).d(interfaceC3346Am2);
        }
        C19938rB7 c19938rB7 = C19938rB7.a;
        F(this, -2, "onDownloaded, ref.size= " + interfaceC3346Am2.f(), null, null, 12, null);
    }

    public void f(float f, int i) {
        for (AbstractC22597vW1 abstractC22597vW1 : this.d) {
            float f2 = i / 1024.0f;
            this.g = f2;
            abstractC22597vW1.u(f, f2);
        }
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void g(DX1 dx1) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).s(this.g, dx1);
        }
    }

    public void l() {
        MW1 mw1B = this.b.b();
        if (mw1B instanceof MW1.b) {
            m(this.b.a(), ((MW1.b) mw1B).a().b());
        } else {
            if (!(mw1B instanceof MW1.a)) {
                throw new NoWhenBranchMatchedException();
            }
            n((MW1.a) mw1B);
        }
    }

    protected void m(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        F(this, 0, "bind", fileReference, null, 8, null);
        this.g = fileReference.getFileSize() / 1024.0f;
        boolean zQ = Q(enumC18310oS, fileReference);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).m(this.g, zQ);
        }
        if (!z().b()) {
            this.e = this.a.D(fileReference, zQ, this, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            return;
        }
        a aVarO = o(fileReference);
        this.m = aVarO;
        if (zQ) {
            F(this, 0, "bind,start Immediate", fileReference, null, 8, null);
            v().u(aVarO.a(), new FY1(null, 1, null), new LY1.a(null, 1, null));
        }
    }

    protected final void n(MW1.a aVar) {
        AbstractC13042fc3.i(aVar, "local");
        this.g = aVar.a().f() / 1024.0f;
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).n(aVar.a(), this.g, aVar.c());
        }
        if (aVar.b()) {
            this.f = AbstractC5969Lp4.d().r(aVar.c(), this);
            return;
        }
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((AbstractC22597vW1) it2.next()).t(this.g);
        }
    }

    protected a o(FileReference fileReference) {
        InterfaceC20315ro1 interfaceC20315ro1B;
        AbstractC13042fc3.i(fileReference, "fileReference");
        a aVar = this.m;
        if (aVar != null && (interfaceC20315ro1B = aVar.b()) != null) {
            AbstractC20906so1.d(interfaceC20315ro1B, null, 1, null);
        }
        a aVar2 = new a(AbstractC20906so1.a(C12366eV1.c()), this.k.a(fileReference));
        if (aVar2.a() instanceof MX1.a) {
            AbstractC10533bm0.d(aVar2.b(), null, null, new b(aVar2, fileReference, null), 3, null);
        }
        return aVar2;
    }

    protected final ArrayList r() {
        return this.d;
    }

    protected final AbstractC17757nW1 s() {
        return this.b;
    }

    protected final IX1 t() {
        return this.l;
    }

    protected final InterfaceC7857Tm2 u() {
        return this.e;
    }

    protected final C20748sY1 v() {
        return (C20748sY1) this.h.getValue();
    }

    protected final InterfaceC23211wY1 w() {
        return (InterfaceC23211wY1) this.i.getValue();
    }

    protected final float x() {
        return this.g;
    }

    protected final C14970in2 y() {
        return this.a;
    }

    protected final C9847af4 z() {
        return (C9847af4) this.j.getValue();
    }

    public /* synthetic */ C22007uW1(C14970in2 c14970in2, AbstractC17757nW1 abstractC17757nW1, SettingsModule settingsModule, int i, ED1 ed1) {
        this(c14970in2, abstractC17757nW1, (i & 4) != 0 ? AbstractC5969Lp4.e().S() : settingsModule);
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public final void e() {
    }
}
