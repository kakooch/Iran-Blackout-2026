package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class bk {
    public abstract bk attached(boolean z);

    public abstract bk bounds(as asVar);

    public abstract bl build();

    public abstract bk detailedReason(String str);

    public abstract bk hidden(boolean z);

    public abstract bk purpose(FriendlyObstructionPurpose friendlyObstructionPurpose);

    public abstract bk type(String str);

    bk view(View view) {
        return attached(ViewCompat.isAttachedToWindow(view)).bounds(as.builder().locationOnScreenOfView(view).build()).hidden(!view.isShown()).type(view.getClass().getCanonicalName());
    }
}
