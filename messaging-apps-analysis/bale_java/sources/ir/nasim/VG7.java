package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* loaded from: classes5.dex */
public final class VG7 {
    private final long a;
    private final FileReference b;
    private final Long c;
    private final C7880To7 d;

    public VG7(long j, FileReference fileReference, Long l, C7880To7 c7880To7) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        this.a = j;
        this.b = fileReference;
        this.c = l;
        this.d = c7880To7;
    }

    public final FileReference a() {
        return this.b;
    }

    public final Long b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public final C7880To7 d() {
        return this.d;
    }
}
