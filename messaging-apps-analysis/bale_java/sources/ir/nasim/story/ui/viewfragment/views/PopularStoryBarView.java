package ir.nasim.story.ui.viewfragment.views;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.C5545Ju3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC3313Ai5;
import ir.nasim.XY6;
import ir.nasim.story.ui.viewfragment.views.PopularStoryBarView;
import ir.nasim.story.ui.viewfragment.views.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/PopularStoryBarView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "c", "()V", "f", "Landroid/animation/LayoutTransition;", "getLayoutTransition", "()Landroid/animation/LayoutTransition;", "Lir/nasim/story/ui/viewfragment/views/a;", "reactionButtonState", "setReaction", "(Lir/nasim/story/ui/viewfragment/views/a;)V", "count", "setReactionCount", "(I)V", "setViewCount", "Lir/nasim/Ai5;", "a", "Lir/nasim/Ai5;", "getListener", "()Lir/nasim/Ai5;", "setListener", "(Lir/nasim/Ai5;)V", "listener", "Lir/nasim/Ju3;", "b", "Lir/nasim/Ju3;", "binding", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class PopularStoryBarView extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private InterfaceC3313Ai5 listener;

    /* renamed from: b, reason: from kotlin metadata */
    private final C5545Ju3 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopularStoryBarView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void c() {
        ReactionButton reactionButton = this.binding.d;
        reactionButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Bi5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopularStoryBarView.d(this.a, view);
            }
        });
        reactionButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Ci5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return PopularStoryBarView.e(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PopularStoryBarView popularStoryBarView, View view) {
        AbstractC13042fc3.i(popularStoryBarView, "this$0");
        popularStoryBarView.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(PopularStoryBarView popularStoryBarView, View view) {
        AbstractC13042fc3.i(popularStoryBarView, "this$0");
        InterfaceC3313Ai5 interfaceC3313Ai5 = popularStoryBarView.listener;
        if (interfaceC3313Ai5 != null) {
            return interfaceC3313Ai5.a();
        }
        return false;
    }

    private final void f() {
        a state = this.binding.d.getState();
        if ((state instanceof a.C1549a) || (state instanceof a.b)) {
            this.binding.d.setState(new a.c(false, 1, null));
        } else {
            if (!(state instanceof a.c)) {
                throw new NoWhenBranchMatchedException();
            }
            this.binding.d.setState(new a.C1549a(false, 1, null));
        }
        C19938rB7 c19938rB7 = C19938rB7.a;
        InterfaceC3313Ai5 interfaceC3313Ai5 = this.listener;
        if (interfaceC3313Ai5 != null) {
            interfaceC3313Ai5.b(this.binding.d.getState());
        }
    }

    @Override // android.view.ViewGroup
    public LayoutTransition getLayoutTransition() {
        return new LayoutTransition();
    }

    public final InterfaceC3313Ai5 getListener() {
        return this.listener;
    }

    public final void setListener(InterfaceC3313Ai5 interfaceC3313Ai5) {
        this.listener = interfaceC3313Ai5;
    }

    public final void setReaction(a reactionButtonState) {
        AbstractC13042fc3.i(reactionButtonState, "reactionButtonState");
        this.binding.d.setState(reactionButtonState);
    }

    public final void setReactionCount(int count) {
        if (count <= 0) {
            this.binding.e.setVisibility(8);
        } else {
            this.binding.e.setVisibility(0);
            this.binding.e.setText(XY6.e(XY6.i(count)));
        }
    }

    public final void setViewCount(int count) {
        if (count <= 0) {
            this.binding.b.setVisibility(8);
            this.binding.c.setVisibility(8);
            this.binding.f.setVisibility(8);
        } else {
            this.binding.b.setVisibility(0);
            this.binding.c.setVisibility(0);
            this.binding.f.setVisibility(0);
            this.binding.f.setText(XY6.e(XY6.i(count)));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopularStoryBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ PopularStoryBarView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopularStoryBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.binding = C5545Ju3.b(LayoutInflater.from(context), this);
        setClickable(true);
        setFocusable(true);
        setGravity(16);
        c();
    }
}
