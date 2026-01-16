package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.Locale;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class abd {
    arn<String> a = arn.i();
    arn<String> b = arn.i();
    int c = 0;

    @Deprecated
    public abd() {
    }

    public void b(Context context) {
        CaptioningManager captioningManager;
        int i = aeu.a;
        if (i >= 19) {
            if ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.c = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.b = arn.j(aeu.u(locale));
                }
            }
        }
    }
}
