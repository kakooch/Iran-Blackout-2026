package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ar {
    public abstract as build();

    public abstract ar height(int i);

    public abstract ar left(int i);

    public ar locationOnScreenOfView(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return left(iArr[0]).top(iArr[1]).height(view.getHeight()).width(view.getWidth());
    }

    public abstract ar top(int i);

    public abstract ar width(int i);
}
