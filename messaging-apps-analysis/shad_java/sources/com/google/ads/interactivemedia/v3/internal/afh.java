package com.google.ads.interactivemedia.v3.internal;

import android.hardware.display.DisplayManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class afh implements DisplayManager.DisplayListener {
    final /* synthetic */ afj a;
    private final DisplayManager b;

    public afh(afj afjVar, DisplayManager displayManager) {
        this.a = afjVar;
        this.b = displayManager;
    }

    public final void a() {
        this.b.registerDisplayListener(this, null);
    }

    public final void b() {
        this.b.unregisterDisplayListener(this);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        if (i == 0) {
            this.a.e();
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }
}
