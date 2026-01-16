package ir.nasim.features.conversation.messages.content.adapter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.E0;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.ED1;
import ir.nasim.OY0;
import ir.nasim.SA2;
import ir.nasim.features.conversation.messages.content.adapter.view.BubblePlayerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/BubblePlayerView;", "Lcom/google/android/exoplayer2/ui/PlayerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/google/android/exoplayer2/z0;", "player", "Lir/nasim/rB7;", "setPlayer", "(Lcom/google/android/exoplayer2/z0;)V", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function0;", "z", "Lir/nasim/SA2;", "getOnPlayerClicked", "()Lir/nasim/SA2;", "setOnPlayerClicked", "(Lir/nasim/SA2;)V", "onPlayerClicked", "A", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BubblePlayerView extends PlayerView {
    public static final int B = 8;

    /* renamed from: z, reason: from kotlin metadata */
    private SA2 onPlayerClicked;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubblePlayerView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(BubblePlayerView bubblePlayerView, View.OnClickListener onClickListener, View view) {
        AbstractC13042fc3.i(bubblePlayerView, "this$0");
        SA2 sa2 = bubblePlayerView.onPlayerClicked;
        if (sa2 != null) {
            sa2.invoke();
        }
        onClickListener.onClick(view);
    }

    public final SA2 getOnPlayerClicked() {
        return this.onPlayerClicked;
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener l) {
        View.OnClickListener onClickListener = l != null ? new View.OnClickListener() { // from class: ir.nasim.xl0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BubblePlayerView.P(this.a, l, view);
            }
        } : null;
        View videoSurfaceView = getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnClickListener(onClickListener);
        }
    }

    public final void setOnPlayerClicked(SA2 sa2) {
        this.onPlayerClicked = sa2;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerView
    public void setPlayer(z0 player) {
        super.setPlayer(player);
        E0 e0 = player instanceof E0 ? (E0) player : null;
        if (e0 != null) {
            e0.S(a.g, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubblePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ BubblePlayerView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubblePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        setUseArtwork(true);
        setUseController(false);
        setControllerAutoShow(false);
        setControllerHideOnTouch(false);
        setKeepContentOnPlayerReset(true);
        setResizeMode(4);
        setShutterBackgroundColor(OY0.b(context, AbstractC21139tA5.bubble_third));
        AbstractC12990fW7.L0(this, toString());
    }
}
