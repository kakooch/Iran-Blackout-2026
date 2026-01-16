package ir.nasim;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;

/* renamed from: ir.nasim.yv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24625yv7 implements ComposeAnimation, InterfaceC23445wv7 {
    private final C21669tv7 a;
    private final Set b;
    private final String c;
    private final ComposeAnimationType d = ComposeAnimationType.TRANSITION_ANIMATION;

    public C24625yv7(C21669tv7 c21669tv7, Set set, String str) {
        this.a = c21669tv7;
        this.b = set;
        this.c = str;
    }

    @Override // ir.nasim.InterfaceC23445wv7
    public C21669tv7 a() {
        return this.a;
    }
}
