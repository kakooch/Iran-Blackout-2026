package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes3.dex */
final class j extends k {
    j(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.k
    final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new zzq(4, "Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.k
    final boolean b() {
        return true;
    }
}
