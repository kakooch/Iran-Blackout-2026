package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;

/* loaded from: classes3.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int p = AbstractC21175tE5.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    private void r() {
        setIndeterminateDrawable(h.t(getContext(), (LinearProgressIndicatorSpec) this.a));
        setProgressDrawable(d.v(getContext(), (LinearProgressIndicatorSpec) this.a));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.a).g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.a).h;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a aVar = this.a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) aVar;
        boolean z2 = true;
        if (((LinearProgressIndicatorSpec) aVar).h != 1 && ((AbstractC12990fW7.A(this) != 1 || ((LinearProgressIndicatorSpec) this.a).h != 2) && (AbstractC12990fW7.A(this) != 0 || ((LinearProgressIndicatorSpec) this.a).h != 3))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.i = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        h indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        d progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinearProgressIndicatorSpec i(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i) {
        if (((LinearProgressIndicatorSpec) this.a).g == i) {
            return;
        }
        if (p() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        a aVar = this.a;
        ((LinearProgressIndicatorSpec) aVar).g = i;
        ((LinearProgressIndicatorSpec) aVar).e();
        if (i == 0) {
            getIndeterminateDrawable().w(new j((LinearProgressIndicatorSpec) this.a));
        } else {
            getIndeterminateDrawable().w(new k(getContext(), (LinearProgressIndicatorSpec) this.a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.a).e();
    }

    public void setIndicatorDirection(int i) {
        a aVar = this.a;
        ((LinearProgressIndicatorSpec) aVar).h = i;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) aVar;
        boolean z = true;
        if (i != 1 && ((AbstractC12990fW7.A(this) != 1 || ((LinearProgressIndicatorSpec) this.a).h != 2) && (AbstractC12990fW7.A(this) != 0 || i != 3))) {
            z = false;
        }
        linearProgressIndicatorSpec.i = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null && ((LinearProgressIndicatorSpec) aVar).g == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i, z);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((LinearProgressIndicatorSpec) this.a).e();
        invalidate();
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, p);
        r();
    }
}
