package ir.nasim.features.smiles.panel;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001f¨\u0006("}, d2 = {"Lir/nasim/features/smiles/panel/SmileKeyboardContainer;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "changedView", "visibility", "Lir/nasim/rB7;", "onVisibilityChanged", "(Landroid/view/View;I)V", "Landroid/view/KeyEvent;", "event", "", "dispatchKeyEventPreIme", "(Landroid/view/KeyEvent;)Z", "Landroid/content/res/Configuration;", "newConfig", "dispatchConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lkotlin/Function1;", "p", "Lir/nasim/UA2;", "getOnVisibilityChanged", "()Lir/nasim/UA2;", "setOnVisibilityChanged", "(Lir/nasim/UA2;)V", "q", "getOnDispatchKeyEvent", "setOnDispatchKeyEvent", "onDispatchKeyEvent", "r", "getOnDispatchConfiguration", "setOnDispatchConfiguration", "onDispatchConfiguration", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class SmileKeyboardContainer extends LinearLayoutCompat {

    /* renamed from: p, reason: from kotlin metadata */
    private UA2 onVisibilityChanged;

    /* renamed from: q, reason: from kotlin metadata */
    private UA2 onDispatchKeyEvent;

    /* renamed from: r, reason: from kotlin metadata */
    private UA2 onDispatchConfiguration;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmileKeyboardContainer(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchConfigurationChanged(Configuration newConfig) {
        UA2 ua2;
        if (newConfig != null && (ua2 = this.onDispatchConfiguration) != null) {
            ua2.invoke(newConfig);
        }
        super.dispatchConfigurationChanged(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        UA2 ua2;
        return (event == null || (ua2 = this.onDispatchKeyEvent) == null) ? super.dispatchKeyEventPreIme(event) : ((Boolean) ua2.invoke(event)).booleanValue();
    }

    public final UA2 getOnDispatchConfiguration() {
        return this.onDispatchConfiguration;
    }

    public final UA2 getOnDispatchKeyEvent() {
        return this.onDispatchKeyEvent;
    }

    public final UA2 getOnVisibilityChanged() {
        return this.onVisibilityChanged;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        AbstractC13042fc3.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        UA2 ua2 = this.onVisibilityChanged;
        if (ua2 != null) {
            ua2.invoke(Boolean.valueOf(visibility == 0));
        }
    }

    public final void setOnDispatchConfiguration(UA2 ua2) {
        this.onDispatchConfiguration = ua2;
    }

    public final void setOnDispatchKeyEvent(UA2 ua2) {
        this.onDispatchKeyEvent = ua2;
    }

    public final void setOnVisibilityChanged(UA2 ua2) {
        this.onVisibilityChanged = ua2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmileKeyboardContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ SmileKeyboardContainer(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmileKeyboardContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
