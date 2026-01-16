package ir.nasim;

import ir.nasim.MX1;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.cm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11298cm2 implements InterfaceC14123hO3 {
    private final IT7 a;

    public C11298cm2(IT7 it7) {
        AbstractC13042fc3.i(it7, "videoPlayerCacheIdGenerator");
        this.a = it7;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MX1.b a(FileReference fileReference) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        return new MX1.b(this.a.a(fileReference.getFileId(), fileReference.getAccessHash()), fileReference.getFileSize(), fileReference.getFileName(), new C4995Hl2(fileReference.getFileId(), fileReference.getAccessHash()));
    }
}
