package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* loaded from: classes5.dex */
public final class EH7 {
    private final long a;
    private final FileReference b;
    private final InterfaceC3346Am2 c;

    public EH7(long j, FileReference fileReference, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(fileReference, "location");
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        this.a = j;
        this.b = fileReference;
        this.c = interfaceC3346Am2;
    }

    public final FileReference a() {
        return this.b;
    }

    public final InterfaceC3346Am2 b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }
}
