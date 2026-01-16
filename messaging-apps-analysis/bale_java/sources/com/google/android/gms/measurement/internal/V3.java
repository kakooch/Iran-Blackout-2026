package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes3.dex */
final class V3 implements e4 {
    final /* synthetic */ Y3 a;

    V3(Y3 y3) {
        this.a = y3;
    }

    @Override // com.google.android.gms.measurement.internal.e4
    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a().z(new U3(this, str, "_err", bundle));
            return;
        }
        Y3 y3 = this.a;
        if (y3.l != null) {
            y3.l.b().r().b("AppId not known when logging event", "_err");
        }
    }
}
