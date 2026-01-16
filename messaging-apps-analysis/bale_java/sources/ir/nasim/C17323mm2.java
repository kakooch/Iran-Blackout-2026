package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.mm2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C17323mm2 {
    C17323mm2() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
