package com.google.android.play.core.splitcompat;

import android.app.Application;
import android.content.Context;
import ir.nasim.NI6;

/* loaded from: classes3.dex */
public class SplitCompatApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        NI6.a(this);
    }
}
