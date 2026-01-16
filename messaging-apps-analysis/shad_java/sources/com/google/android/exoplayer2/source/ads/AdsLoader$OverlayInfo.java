package com.google.android.exoplayer2.source.ads;

import android.view.View;

/* loaded from: classes.dex */
public final class AdsLoader$OverlayInfo {
    public final int purpose;
    public final String reasonDetail;
    public final View view;

    public AdsLoader$OverlayInfo(View view, int i) {
        this(view, i, null);
    }

    public AdsLoader$OverlayInfo(View view, int i, String str) {
        this.view = view;
        this.purpose = i;
        this.reasonDetail = str;
    }
}
