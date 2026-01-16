package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.ho8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14378ho8 implements Er8 {
    final /* synthetic */ Po8 a;

    C14378ho8(Po8 po8) {
        this.a = po8;
    }

    @Override // ir.nasim.Er8
    public final void a(Wr8 wr8, File file, boolean z) {
        this.a.b.add(file);
        if (z) {
            return;
        }
        this.a.c.set(false);
    }
}
