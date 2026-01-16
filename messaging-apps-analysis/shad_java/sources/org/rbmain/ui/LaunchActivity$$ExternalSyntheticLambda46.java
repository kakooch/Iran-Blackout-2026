package org.rbmain.ui;

import org.rbmain.messenger.Utilities;

/* loaded from: classes4.dex */
public final /* synthetic */ class LaunchActivity$$ExternalSyntheticLambda46 implements Utilities.Callback16 {
    public final /* synthetic */ LaunchActivity f$0;

    public /* synthetic */ LaunchActivity$$ExternalSyntheticLambda46(LaunchActivity launchActivity) {
        this.f$0 = launchActivity;
    }

    @Override // org.rbmain.messenger.Utilities.Callback16
    public final void run(Object obj) {
        this.f$0.onPowerSaver(((Boolean) obj).booleanValue());
    }
}
