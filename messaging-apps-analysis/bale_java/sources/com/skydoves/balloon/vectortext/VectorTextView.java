package com.skydoves.balloon.vectortext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16166ko7;
import ir.nasim.ED1;
import ir.nasim.FG1;
import ir.nasim.JE5;
import ir.nasim.YQ7;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR.\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "r", "", "rtlLayout", "s", "(Z)V", "Lir/nasim/YQ7;", "value", "h", "Lir/nasim/YQ7;", "getDrawableTextViewParams", "()Lir/nasim/YQ7;", "setDrawableTextViewParams", "(Lir/nasim/YQ7;)V", "drawableTextViewParams", "balloon_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VectorTextView extends AppCompatTextView {

    /* renamed from: h, reason: from kotlin metadata */
    private YQ7 drawableTextViewParams;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VectorTextView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(context, "context");
    }

    private final void r(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, JE5.VectorTextView);
            AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            setDrawableTextViewParams(new YQ7(FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableStart, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableEnd, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableBottom, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableTop, RecyclerView.UNDEFINED_DURATION)), null, null, null, null, false, null, null, null, null, FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawablePadding, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getColor(JE5.VectorTextView_balloon_drawableTintColor, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableWidth, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableHeight, RecyclerView.UNDEFINED_DURATION)), FG1.a(typedArrayObtainStyledAttributes.getResourceId(JE5.VectorTextView_balloon_drawableSquareSize, RecyclerView.UNDEFINED_DURATION)), 8176, null));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final YQ7 getDrawableTextViewParams() {
        return this.drawableTextViewParams;
    }

    public final void s(boolean rtlLayout) {
        YQ7 yq7 = this.drawableTextViewParams;
        if (yq7 != null) {
            yq7.A(rtlLayout);
            AbstractC16166ko7.a(this, yq7);
        }
    }

    public final void setDrawableTextViewParams(YQ7 yq7) {
        if (yq7 != null) {
            AbstractC16166ko7.a(this, yq7);
        } else {
            yq7 = null;
        }
        this.drawableTextViewParams = yq7;
    }

    public /* synthetic */ VectorTextView(Context context, AttributeSet attributeSet, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        r(context, attributeSet);
    }
}
