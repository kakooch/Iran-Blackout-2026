package ir.nasim.features.pfm;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;
import androidx.appcompat.widget.AppCompatSpinner;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lir/nasim/features/pfm/PFMSpinner;", "Landroidx/appcompat/widget/AppCompatSpinner;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "d", "()V", "", "c", "()Z", "performClick", "hasFocus", "onWindowFocusChanged", "(Z)V", "Lir/nasim/features/pfm/PFMSpinner$a;", "onSpinnerEventsListener", "setSpinnerEventsListener", "(Lir/nasim/features/pfm/PFMSpinner$a;)V", "pixels", "setDropDownVerticalOffset", "(I)V", "j", "Lir/nasim/features/pfm/PFMSpinner$a;", "mListener", "k", "Z", "mOpenInitiated", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PFMSpinner extends AppCompatSpinner {

    /* renamed from: j, reason: from kotlin metadata */
    private a mListener;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean mOpenInitiated;

    public interface a {
        void a(Spinner spinner);

        void b(Spinner spinner);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PFMSpinner(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
    }

    /* renamed from: c, reason: from getter */
    private final boolean getMOpenInitiated() {
        return this.mOpenInitiated;
    }

    private final void d() {
        this.mOpenInitiated = false;
        a aVar = this.mListener;
        if (aVar != null) {
            AbstractC13042fc3.f(aVar);
            aVar.b(this);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasFocus) {
        if (getMOpenInitiated() && hasFocus) {
            d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.view.View
    public boolean performClick() {
        this.mOpenInitiated = true;
        a aVar = this.mListener;
        if (aVar != null) {
            AbstractC13042fc3.f(aVar);
            aVar.a(this);
        }
        return super.performClick();
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner
    public void setDropDownVerticalOffset(int pixels) {
        super.setDropDownVerticalOffset(pixels);
    }

    public final void setSpinnerEventsListener(a onSpinnerEventsListener) {
        this.mListener = onSpinnerEventsListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PFMSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PFMSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
