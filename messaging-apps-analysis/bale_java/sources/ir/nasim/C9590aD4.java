package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.aD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9590aD4 {
    public static final C9590aD4 a = new C9590aD4();

    private C9590aD4() {
    }

    public final C12056dy a(C10361bX1 c10361bX1) {
        AbstractC13042fc3.i(c10361bX1, "<this>");
        return new C12056dy(c10361bX1.b(), c10361bX1.a(), c10361bX1.c());
    }

    public final FileReference b(C10977cX1 c10977cX1) {
        AbstractC13042fc3.i(c10977cX1, "<this>");
        return new FileReference(a(c10977cX1.b()), c10977cX1.c(), c10977cX1.a(), c10977cX1.d());
    }

    public final C9767aX1 c(C6035Lx c6035Lx) {
        AbstractC13042fc3.i(c6035Lx, "<this>");
        ZC zcU = c6035Lx.u();
        String strZ = zcU != null ? zcU.z() : null;
        long fileId = c6035Lx.getFileId();
        long accessHash = c6035Lx.getAccessHash();
        int fileSize = c6035Lx.getFileSize();
        Integer fileStorageVersion = c6035Lx.getFileStorageVersion();
        String strZ2 = c6035Lx.z();
        AbstractC13042fc3.h(strZ2, "getMimeType(...)");
        return new C9767aX1(strZ, fileId, accessHash, fileSize, fileStorageVersion, strZ2);
    }

    public final C10361bX1 d(C12056dy c12056dy) {
        AbstractC13042fc3.i(c12056dy, "<this>");
        return new C10361bX1(c12056dy.getFileId(), c12056dy.getAccessHash(), c12056dy.getFileStorageVersion());
    }

    public final C11741dX1 e(C4626Fy c4626Fy) {
        AbstractC13042fc3.i(c4626Fy, "<this>");
        C12056dy fileLocation = c4626Fy.getFileLocation();
        return new C11741dX1(fileLocation != null ? d(fileLocation) : null, c4626Fy.r(), c4626Fy.q(), c4626Fy.getFileSize());
    }
}
