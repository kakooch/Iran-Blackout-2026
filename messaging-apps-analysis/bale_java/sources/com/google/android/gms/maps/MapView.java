package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class MapView extends FrameLayout {
    private final d a;

    public MapView(Context context) {
        super(context);
        this.a = new d(this, context, null);
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new d(this, context, GoogleMapOptions.x0(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new d(this, context, GoogleMapOptions.x0(context, attributeSet));
        setClickable(true);
    }
}
