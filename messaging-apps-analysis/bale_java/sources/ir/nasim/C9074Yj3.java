package ir.nasim;

import androidx.camera.core.ImageProcessingUtil;
import java.util.Objects;

/* renamed from: ir.nasim.Yj3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C9074Yj3 implements InterfaceC15888kL4 {
    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PS4 apply(PS4 ps4) {
        androidx.camera.core.i iVar = new androidx.camera.core.i(androidx.camera.core.g.a(ps4.h().getWidth(), ps4.h().getHeight(), 256, 2));
        androidx.camera.core.f fVarB = ImageProcessingUtil.b(iVar, (byte[]) ps4.c());
        iVar.l();
        Objects.requireNonNull(fVarB);
        C14871id2 c14871id2D = ps4.d();
        Objects.requireNonNull(c14871id2D);
        return PS4.k(fVarB, c14871id2D, ps4.b(), ps4.f(), ps4.g(), ps4.a());
    }
}
