package ir.nasim.story.ui.viewfragment.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C7691Su3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/PreparingStoryView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progress", "Lir/nasim/rB7;", "setProgress", "(I)V", "", "input", "setText", "(Ljava/lang/CharSequence;)V", "Lir/nasim/Su3;", "a", "Lir/nasim/Su3;", "binding", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class PreparingStoryView extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final C7691Su3 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreparingStoryView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void setProgress(int progress) {
        CircularProgressIndicator circularProgressIndicator = this.binding.c;
        if (progress < 0) {
            circularProgressIndicator.setIndeterminate(true);
            return;
        }
        circularProgressIndicator.setIndeterminate(false);
        circularProgressIndicator.setMax(100);
        circularProgressIndicator.setProgress(progress, true);
    }

    public final void setText(CharSequence input) {
        AbstractC13042fc3.i(input, "input");
        this.binding.b.setText(input);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreparingStoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ PreparingStoryView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreparingStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.binding = C7691Su3.b(LayoutInflater.from(context), this);
        setClickable(true);
        setFocusable(true);
        setGravity(16);
        setProgress(-1);
    }
}
