package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.wi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23316wi8 implements InterfaceC25090zi8 {
    C23316wi8() {
    }

    @Override // ir.nasim.InterfaceC25090zi8
    public final boolean a(Object obj, File file, File file2) {
        return new File((String) com.google.android.play.core.splitinstall.internal.c.g(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
