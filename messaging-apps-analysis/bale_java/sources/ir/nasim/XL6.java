package ir.nasim;

import android.os.Build;
import android.text.StaticLayout;

/* loaded from: classes2.dex */
final class XL6 implements InterfaceC16490lM6 {
    @Override // ir.nasim.InterfaceC16490lM6
    public boolean a(StaticLayout staticLayout, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return C14719iM6.a(staticLayout);
        }
        if (i >= 28) {
            return z;
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC16490lM6
    public StaticLayout b(C17081mM6 c17081mM6) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(c17081mM6.r(), c17081mM6.q(), c17081mM6.e(), c17081mM6.o(), c17081mM6.u());
        builderObtain.setTextDirection(c17081mM6.s());
        builderObtain.setAlignment(c17081mM6.a());
        builderObtain.setMaxLines(c17081mM6.n());
        builderObtain.setEllipsize(c17081mM6.c());
        builderObtain.setEllipsizedWidth(c17081mM6.d());
        builderObtain.setLineSpacing(c17081mM6.l(), c17081mM6.m());
        builderObtain.setIncludePad(c17081mM6.g());
        builderObtain.setBreakStrategy(c17081mM6.b());
        builderObtain.setHyphenationFrequency(c17081mM6.f());
        builderObtain.setIndents(c17081mM6.i(), c17081mM6.p());
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            ZL6.a(builderObtain, c17081mM6.h());
        }
        if (i >= 28) {
            C10267bM6.a(builderObtain, c17081mM6.t());
        }
        if (i >= 33) {
            C14719iM6.b(builderObtain, c17081mM6.j(), c17081mM6.k());
        }
        if (i >= 35) {
            C15308jM6.a(builderObtain);
        }
        return builderObtain.build();
    }
}
