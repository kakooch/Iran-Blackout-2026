package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public class StreetViewPanoramaView extends FrameLayout {
    private final h a;

    public StreetViewPanoramaView(Context context) {
        super((Context) AbstractC3795Cj5.k(context, "context must not be null"));
        this.a = new h(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super((Context) AbstractC3795Cj5.k(context, "context must not be null"), attributeSet);
        this.a = new h(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super((Context) AbstractC3795Cj5.k(context, "context must not be null"), attributeSet, i);
        this.a = new h(this, context, null);
    }
}
