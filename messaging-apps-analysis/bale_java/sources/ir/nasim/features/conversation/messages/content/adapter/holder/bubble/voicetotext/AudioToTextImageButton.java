package ir.nasim.features.conversation.messages.content.adapter.holder.bubble.voicetotext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.EnumC9477a18;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.KB5;
import ir.nasim.OY0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/holder/bubble/voicetotext/AudioToTextImageButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "a", "()Z", "Lir/nasim/a18;", "s", "Lir/nasim/rB7;", "setState", "(Lir/nasim/a18;)V", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "d", "Z", "mIsLoading", "Lir/nasim/Zm4;", "e", "Lir/nasim/Zm4;", "_state", "Lir/nasim/bL6;", "f", "Lir/nasim/bL6;", "getState", "()Lir/nasim/bL6;", "state", "g", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class AudioToTextImageButton extends AppCompatImageButton {
    public static final int h = 8;
    private static final int[] i = {AbstractC21139tA5.state_loading};

    /* renamed from: d, reason: from kotlin metadata */
    private boolean mIsLoading;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC9336Zm4 _state;

    /* renamed from: f, reason: from kotlin metadata */
    private final InterfaceC10258bL6 state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioToTextImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(EnumC9477a18.b);
        this._state = interfaceC9336Zm4A;
        this.state = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    public final boolean a() {
        return this.state.getValue() == EnumC9477a18.d;
    }

    public final InterfaceC10258bL6 getState() {
        return this.state;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        if (!this.mIsLoading) {
            int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace);
            AbstractC13042fc3.h(iArrOnCreateDrawableState, "onCreateDrawableState(...)");
            return iArrOnCreateDrawableState;
        }
        int[] iArrOnCreateDrawableState2 = super.onCreateDrawableState(extraSpace + 1);
        View.mergeDrawableStates(iArrOnCreateDrawableState2, i);
        AbstractC13042fc3.f(iArrOnCreateDrawableState2);
        return iArrOnCreateDrawableState2;
    }

    public final void setState(EnumC9477a18 s) {
        Drawable drawable;
        AbstractC13042fc3.i(s, "s");
        this._state.setValue(s);
        this.mIsLoading = this._state.getValue() == EnumC9477a18.c;
        refreshDrawableState();
        if (this._state.getValue() == EnumC9477a18.d) {
            setImageDrawable(AbstractC4043Dl1.f(getContext(), KB5.audio_to_text_loaded));
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.mutate();
                Context context = getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                AbstractC21710u02.h(drawable2, OY0.b(context, AbstractC21139tA5.bubble_secondary));
                return;
            }
            return;
        }
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.audio_to_text_button_icon_states);
        setImageDrawable(drawableF instanceof StateListDrawable ? (StateListDrawable) drawableF : null);
        if (!this.mIsLoading || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.mutate();
        Context context2 = getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        AbstractC21710u02.h(drawable, OY0.b(context2, AbstractC21139tA5.bubble_secondary));
    }
}
