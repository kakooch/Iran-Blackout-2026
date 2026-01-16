package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.dm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11920dm2 implements InterfaceC18505om2 {
    private final FileReference a;

    public C11920dm2(FileReference fileReference) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        this.a = fileReference;
    }

    @Override // ir.nasim.InterfaceC18505om2
    public String a() {
        return this.a.getFileName();
    }

    public final FileReference b() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC18505om2
    public int f() {
        return this.a.getFileSize();
    }
}
