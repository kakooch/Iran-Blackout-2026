package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.Se0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7544Se0 {
    private final FileReference a;
    private final boolean b;
    private final InterfaceC8807Xk2 c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public C7544Se0(FileReference fileReference, boolean z, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        this.a = fileReference;
        this.b = z;
        this.c = interfaceC8807Xk2;
        this.d = z2;
        this.e = z3;
        this.f = z4;
    }

    public final InterfaceC8807Xk2 a() {
        return this.c;
    }

    public final boolean b() {
        return this.f;
    }

    public final FileReference c() {
        return this.a;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.b;
    }

    public final boolean f() {
        return this.d;
    }

    public /* synthetic */ C7544Se0(FileReference fileReference, boolean z, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z2, boolean z3, boolean z4, int i, ED1 ed1) {
        this(fileReference, z, interfaceC8807Xk2, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? false : z4);
    }
}
