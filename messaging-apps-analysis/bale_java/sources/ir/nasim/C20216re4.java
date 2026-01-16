package ir.nasim;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;

/* renamed from: ir.nasim.re4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20216re4 {
    private final List b(C16018ka c16018ka) {
        if (c16018ka == null) {
            return AbstractC10360bX0.m();
        }
        String strA = c16018ka.a();
        return AbstractC10360bX0.q(strA != null ? new C20420rz("bale_ramz_token", new OC(strA)) : null);
    }

    private final List c(C19018pe4 c19018pe4) {
        return AbstractC10360bX0.p(new C20420rz("sdk_version", new C5577Jy(c19018pe4.d())), new C20420rz("app_version", new C5577Jy(c19018pe4.a())), new C20420rz("session_id", new C5811Ky(c19018pe4.e())), new C20420rz("os_type", new OC(c19018pe4.b())), new C20420rz(CommonUrlParts.OS_VERSION, new OC(c19018pe4.c())));
    }

    public final C19811qz a(C19018pe4 c19018pe4, C16018ka c16018ka) {
        AbstractC13042fc3.i(c19018pe4, "metaData");
        return new C19811qz(AbstractC15401jX0.R0(c(c19018pe4), b(c16018ka)));
    }
}
