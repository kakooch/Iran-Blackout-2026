package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.Vm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8325Vm2 extends IL implements InterfaceC7857Tm2 {
    private final FileReference b;
    private final boolean c;
    private final C14970in2 d;
    private final InterfaceC8091Um2 e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private InterfaceC8807Xk2 i;

    /* renamed from: ir.nasim.Vm2$a */
    private static final class a {
        private final InterfaceC3346Am2 a;

        public a(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            this.a = interfaceC3346Am2;
        }

        public final InterfaceC3346Am2 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Vm2$b */
    private static final class b {
        private final float a;

        public b(float f) {
            this.a = f;
        }

        public final float a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Vm2$c */
    private static final class c {
        private final DX1 a;

        public c(DX1 dx1) {
            this.a = dx1;
        }

        public final DX1 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Vm2$d */
    public static final class d implements InterfaceC8807Xk2 {
        d() {
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            C8325Vm2.this.f(new b(f));
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            C8325Vm2.this.f(new a(interfaceC3346Am2));
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void g(DX1 dx1) {
            C8325Vm2.this.f(new c(dx1));
        }
    }

    public C8325Vm2(FileReference fileReference, boolean z, C14970in2 c14970in2, InterfaceC8091Um2 interfaceC8091Um2, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(fileReference, "location");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC8091Um2, "vmCallback");
        this.b = fileReference;
        this.c = z;
        this.d = c14970in2;
        this.e = interfaceC8091Um2;
        this.f = z2;
        this.g = z3;
        this.h = z4;
    }

    @Override // ir.nasim.IL, ir.nasim.InterfaceC7857Tm2
    public void a(boolean z) {
        super.b();
        this.d.j0(this.b.getFileId(), this.i, z);
    }

    @Override // ir.nasim.IL, ir.nasim.InterfaceC7857Tm2
    public void b() {
        super.b();
        this.d.j0(this.b.getFileId(), this.i, false);
    }

    @Override // ir.nasim.IL
    protected void e(Object obj) {
        AbstractC13042fc3.i(obj, "obj");
        if (obj instanceof c) {
            this.e.g(((c) obj).a());
        } else if (obj instanceof b) {
            this.e.c(((b) obj).a());
        } else if (obj instanceof a) {
            this.e.d(((a) obj).a());
        }
    }

    @Override // ir.nasim.InterfaceC7857Tm2
    public void init() {
        d dVar = new d();
        this.d.J(this.b, this.c, dVar, this.f, this.g, this.h);
        this.i = dVar;
    }
}
