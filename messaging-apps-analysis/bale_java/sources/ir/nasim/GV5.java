package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* loaded from: classes5.dex */
public final class GV5 {
    private final long a;
    private final long b;
    private final InterfaceC8807Xk2 c;
    private final boolean d;
    private final FileReference e;

    public GV5(long j, long j2, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, FileReference fileReference) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "callback");
        this.a = j;
        this.b = j2;
        this.c = interfaceC8807Xk2;
        this.d = z;
        this.e = fileReference;
    }

    public final long a() {
        return this.b;
    }

    public final InterfaceC8807Xk2 b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public /* synthetic */ GV5(long j, long j2, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, FileReference fileReference, int i, ED1 ed1) {
        this(j, j2, interfaceC8807Xk2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : fileReference);
    }
}
