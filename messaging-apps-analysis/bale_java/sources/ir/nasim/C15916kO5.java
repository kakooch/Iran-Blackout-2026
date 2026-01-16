package ir.nasim;

import android.view.RenderNode;

/* renamed from: ir.nasim.kO5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C15916kO5 {
    public static final C15916kO5 a = new C15916kO5();

    private C15916kO5() {
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
