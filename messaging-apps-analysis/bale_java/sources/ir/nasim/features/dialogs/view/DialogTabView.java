package ir.nasim.features.dialogs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.DP1;
import ir.nasim.JF5;
import ir.nasim.XY6;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lir/nasim/features/dialogs/view/DialogTabView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "counter", "", "b", "(I)Ljava/lang/String;", "getMaxCounterValue", "()Ljava/lang/String;", "intCounterValue", "a", "title", "Lir/nasim/rB7;", "setTitle", "(Ljava/lang/String;)V", "", "textSize", "setTitleSize", "(F)V", "setCounter", "(I)V", "c", "()V", "Lir/nasim/DP1;", "Lir/nasim/DP1;", "getBinding", "()Lir/nasim/DP1;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class DialogTabView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final DP1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogTabView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        DP1 dp1C = DP1.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(dp1C, "inflate(...)");
        this.binding = dp1C;
        TextView textView = dp1C.c;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.o0());
        dp1C.c.setTypeface(C6011Lu2.i());
        dp1C.d.setTextColor(c5495Jo7.Y0());
        dp1C.d.setTypeface(C6011Lu2.i());
        dp1C.d.setBackground(AbstractC4310Eo7.d(C22078ud6.a(24.0f), c5495Jo7.U0()));
    }

    private final String a(int intCounterValue) {
        String strValueOf = String.valueOf(intCounterValue);
        return JF5.g() ? XY6.e(strValueOf) : strValueOf;
    }

    private final String b(int counter) {
        return counter > 99 ? getMaxCounterValue() : a(counter);
    }

    private final String getMaxCounterValue() {
        if (JF5.g()) {
            return a(99) + "+";
        }
        return "+" + a(99);
    }

    public final void c() {
        this.binding.d.setVisibility(8);
    }

    public final DP1 getBinding() {
        return this.binding;
    }

    public final void setCounter(int counter) {
        this.binding.d.setText(b(counter));
        if (this.binding.d.getVisibility() != 0) {
            this.binding.d.setVisibility(0);
        }
    }

    public final void setTitle(String title) {
        AbstractC13042fc3.i(title, "title");
        this.binding.c.setText(title);
    }

    public final void setTitleSize(float textSize) {
        this.binding.c.setTextSize(1, textSize);
    }
}
