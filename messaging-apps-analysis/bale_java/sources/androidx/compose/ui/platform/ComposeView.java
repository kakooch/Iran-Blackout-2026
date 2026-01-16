package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC9102Ym4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00100\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0014@RX\u0094\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/compose/ui/platform/ComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "d", "(Lir/nasim/ub1;I)V", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "Lkotlin/Function0;", "content", "setContent", "(Lir/nasim/iB2;)V", "Lir/nasim/Ym4;", "i", "Lir/nasim/Ym4;", "", "<set-?>", "j", "Z", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "shouldCreateCompositionOnAttachedToWindow", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ComposeView extends AbstractComposeView {
    public static final int k = 8;

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 content;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean shouldCreateCompositionOnAttachedToWindow;

    public ComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    protected static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(420213850);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(420213850, i, -1, "androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:429)");
        }
        InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) this.content.getValue();
        if (interfaceC14603iB2 == null) {
            interfaceC22053ub1.W(358356153);
        } else {
            interfaceC22053ub1.W(150107208);
            interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
        }
        interfaceC22053ub1.Q();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return ComposeView.class.getName();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void setContent(InterfaceC14603iB2 content) {
        this.shouldCreateCompositionOnAttachedToWindow = true;
        this.content.setValue(content);
        if (isAttachedToWindow()) {
            g();
        }
    }

    public ComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ComposeView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public ComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.content = AbstractC13472gH6.d(null, null, 2, null);
    }
}
