package ir.nasim.designsystem.button;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.InterfaceC14067hI1;
import ir.nasim.MA2;
import ir.nasim.TA5;
import ir.nasim.YE5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001aJ\r\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001aR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u0015¨\u0006+"}, d2 = {"Lir/nasim/designsystem/button/FullWidthButtonPrimary;", "Lir/nasim/designsystem/button/AbsButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "Landroid/widget/ProgressBar;", "e", "()Landroid/widget/ProgressBar;", "", "value", "Lir/nasim/rB7;", "setIsActive", "(Z)V", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", "i", "()V", "j", "()Z", "setDisableStyle", "setEnableStyle", "Lir/nasim/MA2;", "d", "Lir/nasim/MA2;", "getBinding", "()Lir/nasim/MA2;", "setBinding", "(Lir/nasim/MA2;)V", "binding", "Z", "getActive", "setActive", "active", "nasim_release"}, k = 1, mv = {2, 0, 0})
@InterfaceC14067hI1
/* loaded from: classes5.dex */
public final class FullWidthButtonPrimary extends AbsButton {

    /* renamed from: d, reason: from kotlin metadata */
    public MA2 binding;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean active;

    public FullWidthButtonPrimary(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBinding(MA2.a(LayoutInflater.from(context).inflate(AbstractC12208eD5.full_width_button_primary, this)));
        setAttr(context != null ? context.obtainStyledAttributes(attributeSet, YE5.BaleFullWidthButton) : null);
        d();
        f().setElevation(C22078ud6.a(24.0f));
        i();
    }

    @Override // ir.nasim.designsystem.button.AbsButton
    public ImageView c() {
        ImageView imageView = getBinding().c;
        AbstractC13042fc3.h(imageView, ParameterNames.ICON);
        return imageView;
    }

    @Override // ir.nasim.designsystem.button.AbsButton
    public ProgressBar e() {
        ProgressBar progressBar = getBinding().d.b;
        AbstractC13042fc3.h(progressBar, "progressBar");
        return progressBar;
    }

    @Override // ir.nasim.designsystem.button.AbsButton
    public ViewGroup f() {
        LinearLayout root = getBinding().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.designsystem.button.AbsButton
    public TextView g() {
        TextView textView = getBinding().e;
        AbstractC13042fc3.h(textView, "textView");
        return textView;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final MA2 getBinding() {
        MA2 ma2 = this.binding;
        if (ma2 != null) {
            return ma2;
        }
        AbstractC13042fc3.y("binding");
        return null;
    }

    public void i() {
        this.active = true;
        ViewGroup viewGroupF = f();
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewGroupF.setBackground(AbstractC4310Eo7.j(c5495Jo7.e2(), c5495Jo7.y0(c5495Jo7.g0(), 12), 0));
        getBinding().d.b.setVisibility(8);
        getBinding().e.setVisibility(0);
        getBinding().e.setTextColor(c5495Jo7.d0());
        h(c5495Jo7.d0());
    }

    public boolean j() {
        return this.active;
    }

    public final void setActive(boolean z) {
        this.active = z;
    }

    public final void setBinding(MA2 ma2) {
        AbstractC13042fc3.i(ma2, "<set-?>");
        this.binding = ma2;
    }

    public final void setDisableStyle() {
        setBackgroundColor(AbstractC4043Dl1.c(getContext(), TA5.color10));
        setTextColor(AbstractC4043Dl1.c(getContext(), TA5.color12));
    }

    public final void setEnableStyle() {
        setBackgroundColor(AbstractC4043Dl1.c(getContext(), TA5.primary));
        setTextColor(AbstractC4043Dl1.c(getContext(), TA5.color3_2));
    }

    @Override // ir.nasim.designsystem.button.AbsButton
    public void setIsActive(boolean value) {
        this.active = value;
    }
}
