package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.xE0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23620xE0 {
    private final C9847af4 a;
    private final C20748sY1 b;
    private final C14970in2 c;

    public C23620xE0(C9847af4 c9847af4, C20748sY1 c20748sY1, C14970in2 c14970in2) {
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        AbstractC13042fc3.i(c20748sY1, "newDownloadManager");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.a = c9847af4;
        this.b = c20748sY1;
        this.c = c14970in2;
    }

    private final void a(C4995Hl2 c4995Hl2) {
        this.b.i(c4995Hl2);
    }

    private final void b(FileReference fileReference) {
        this.c.H(fileReference.getFileId());
    }

    public final void c(FileReference fileReference) {
        AbstractC13042fc3.i(fileReference, "reference");
        if (this.a.b()) {
            a(new C4995Hl2(fileReference.getFileId(), fileReference.getAccessHash()));
        } else {
            b(fileReference);
        }
    }
}
