package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC21175tE5;

/* loaded from: classes3.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int p = AbstractC21175tE5.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    private void r() {
        setIndeterminateDrawable(h.s(getContext(), (CircularProgressIndicatorSpec) this.a));
        setProgressDrawable(d.u(getContext(), (CircularProgressIndicatorSpec) this.a));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.a).i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.a).h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.a).g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public CircularProgressIndicatorSpec i(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndicatorDirection(int i) {
        ((CircularProgressIndicatorSpec) this.a).i = i;
        invalidate();
    }

    public void setIndicatorInset(int i) {
        a aVar = this.a;
        if (((CircularProgressIndicatorSpec) aVar).h != i) {
            ((CircularProgressIndicatorSpec) aVar).h = i;
            invalidate();
        }
    }

    public void setIndicatorSize(int i) {
        int iMax = Math.max(i, getTrackThickness() * 2);
        a aVar = this.a;
        if (((CircularProgressIndicatorSpec) aVar).g != iMax) {
            ((CircularProgressIndicatorSpec) aVar).g = iMax;
            ((CircularProgressIndicatorSpec) aVar).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((CircularProgressIndicatorSpec) this.a).e();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, p);
        r();
    }
}
