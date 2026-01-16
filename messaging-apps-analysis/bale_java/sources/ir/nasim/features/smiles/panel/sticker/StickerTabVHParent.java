package ir.nasim.features.smiles.panel.sticker;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lir/nasim/features/smiles/panel/sticker/StickerTabVHParent;", "Landroid/view/View;", TokenNames.T, "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "child", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "Landroid/widget/FrameLayout$LayoutParams;", "param", "Lir/nasim/rB7;", "a", "(Landroid/widget/FrameLayout$LayoutParams;)V", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class StickerTabVHParent<T extends View> extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final View child;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerTabVHParent(Context context, View view) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(view, "child");
        this.child = view;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    public final void a(FrameLayout.LayoutParams param) {
        AbstractC13042fc3.i(param, "param");
        this.child.setLayoutParams(param);
        addView(this.child);
    }

    public final T getChild() {
        return (T) this.child;
    }
}
