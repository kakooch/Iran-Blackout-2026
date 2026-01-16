package ir.nasim;

import android.view.RenderNode;

/* renamed from: ir.nasim.lO5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16507lO5 {
    public static final C16507lO5 a = new C16507lO5();

    private C16507lO5() {
    }

    public final int a(RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public final int b(RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public final void c(RenderNode renderNode, int i) {
        renderNode.setAmbientShadowColor(i);
    }

    public final void d(RenderNode renderNode, int i) {
        renderNode.setSpotShadowColor(i);
    }
}
