package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.vl2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22744vl2 implements InterfaceC23971xp3 {
    private final boolean a;

    public C22744vl2(boolean z) {
        this.a = z;
    }

    @Override // ir.nasim.InterfaceC23971xp3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(File file, IL4 il4) {
        if (!this.a) {
            return file.getPath();
        }
        return file.getPath() + ':' + file.lastModified();
    }
}
