package ir.nasim;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import ir.nasim.C24007xt;
import java.util.Set;

/* renamed from: ir.nasim.st, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20954st implements ComposeAnimation {
    private final C21669tv7 a;
    private final String b;
    private final ComposeAnimationType c = ComposeAnimationType.ANIMATED_VISIBILITY;
    private final Set d;

    public C20954st(C21669tv7 c21669tv7, String str) {
        this.a = c21669tv7;
        this.b = str;
        C24007xt.a aVar = C24007xt.b;
        this.d = AbstractC4597Fu6.i(C24007xt.c(aVar.a()), C24007xt.c(aVar.b()));
    }

    public C21669tv7 a() {
        return this.a;
    }

    public final C21669tv7 b() {
        Object objT0 = AbstractC15401jX0.t0(a().q(), 0);
        if (objT0 instanceof C21669tv7) {
            return (C21669tv7) objT0;
        }
        return null;
    }
}
