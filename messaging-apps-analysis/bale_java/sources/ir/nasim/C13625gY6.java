package ir.nasim;

import androidx.camera.core.impl.j;
import java.util.List;

/* renamed from: ir.nasim.gY6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C13625gY6 implements androidx.camera.core.impl.C, androidx.camera.core.impl.o, androidx.camera.core.impl.u {
    static final j.a I = j.a.a("camerax.core.streamSharing.captureTypes", List.class);
    private final androidx.camera.core.impl.r H;

    C13625gY6(androidx.camera.core.impl.r rVar) {
        this.H = rVar;
    }

    public List V() {
        return (List) a(I);
    }

    @Override // androidx.camera.core.impl.u
    public androidx.camera.core.impl.j getConfig() {
        return this.H;
    }
}
