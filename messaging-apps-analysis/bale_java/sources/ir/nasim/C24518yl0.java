package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.features.conversation.messages.content.adapter.view.BubblePlayerView;

/* renamed from: ir.nasim.yl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24518yl0 implements InterfaceC9764aW7 {
    private final BubblePlayerView a;

    private C24518yl0(BubblePlayerView bubblePlayerView) {
        this.a = bubblePlayerView;
    }

    public static C24518yl0 a(View view) {
        if (view != null) {
            return new C24518yl0((BubblePlayerView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static C24518yl0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.bubble_player_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BubblePlayerView getRoot() {
        return this.a;
    }
}
