package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* loaded from: classes5.dex */
public final class A23 {
    private final int a;
    private final int b;
    private final FileReference c;

    public A23(C4626Fy c4626Fy, String str, String str2) {
        AbstractC13042fc3.i(c4626Fy, "imageLocation");
        AbstractC13042fc3.i(str, "fileName");
        this.a = c4626Fy.r();
        this.b = c4626Fy.q();
        C12056dy fileLocation = c4626Fy.getFileLocation();
        this.c = fileLocation != null ? new FileReference(fileLocation, str, str2, c4626Fy.getFileSize()) : null;
    }

    public final int a() {
        return this.b;
    }

    public final FileReference b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }
}
