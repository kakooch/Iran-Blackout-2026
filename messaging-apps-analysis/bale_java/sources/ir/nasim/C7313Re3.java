package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.Re3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7313Re3 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final RecyclerView b;
    public final MessageStateView c;

    private C7313Re3(FrameLayout frameLayout, RecyclerView recyclerView, MessageStateView messageStateView) {
        this.a = frameLayout;
        this.b = recyclerView;
        this.c = messageStateView;
    }

    public static C7313Re3 a(View view) {
        int i = BC5.recyclerView;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = BC5.stateView;
            MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
            if (messageStateView != null) {
                return new C7313Re3((FrameLayout) view, recyclerView, messageStateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
