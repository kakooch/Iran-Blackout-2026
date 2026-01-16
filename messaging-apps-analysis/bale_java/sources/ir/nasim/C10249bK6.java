package ir.nasim;

import ir.nasim.LY1;
import ir.nasim.MX1;
import ir.nasim.OY1;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.bK6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10249bK6 {
    private final C20748sY1 a;
    private final C14970in2 b;
    private final C11298cm2 c;
    private final C10535bm2 d;
    private final C9847af4 e;

    public C10249bK6(C20748sY1 c20748sY1, C14970in2 c14970in2, C11298cm2 c11298cm2, C10535bm2 c10535bm2, C9847af4 c9847af4) {
        AbstractC13042fc3.i(c20748sY1, "newDownloadManager");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(c11298cm2, "fileReferenceToStreamableDownloadInputMapper");
        AbstractC13042fc3.i(c10535bm2, "fileReferenceToDownloadInputMapper");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        this.a = c20748sY1;
        this.b = c14970in2;
        this.c = c11298cm2;
        this.d = c10535bm2;
        this.e = c9847af4;
    }

    public static /* synthetic */ void b(C10249bK6 c10249bK6, FileReference fileReference, OY1 oy1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            oy1 = OY1.b.a;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        c10249bK6.a(fileReference, oy1, z);
    }

    private final void c(FileReference fileReference, boolean z) {
        this.b.h0(fileReference, z);
    }

    private final void d(MX1.a aVar, OY1 oy1) {
        this.a.u(aVar, new FY1(oy1), LY1.b.a);
    }

    private final void e(MX1.b bVar, OY1 oy1) {
        this.a.u(bVar, new FY1(oy1), LY1.b.a);
    }

    public final void a(FileReference fileReference, OY1 oy1, boolean z) {
        AbstractC13042fc3.i(fileReference, "reference");
        AbstractC13042fc3.i(oy1, "downloadRetryPolicy");
        if (!this.e.b()) {
            c(fileReference, z);
        } else if (z) {
            e(this.c.a(fileReference), oy1);
        } else {
            d(this.d.a(fileReference), oy1);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C10249bK6(C20748sY1 c20748sY1, C14970in2 c14970in2, C11298cm2 c11298cm2, C9847af4 c9847af4) {
        this(c20748sY1, c14970in2, c11298cm2, C10535bm2.a, c9847af4);
        AbstractC13042fc3.i(c20748sY1, "newDownloadManager");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(c11298cm2, "fileReferenceToStreamableDownloadInputMapper");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
    }
}
