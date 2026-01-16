package ir.nasim;

import ir.nasim.MX1;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.bm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10535bm2 implements InterfaceC14123hO3 {
    public static final C10535bm2 a = new C10535bm2();

    private C10535bm2() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MX1.a a(FileReference fileReference) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        return new MX1.a(fileReference.getFileSize(), fileReference.getFileName(), new C11910dl2(EnumC9082Yk2.h, NN6.b), new C4995Hl2(fileReference.getFileId(), fileReference.getAccessHash()));
    }
}
