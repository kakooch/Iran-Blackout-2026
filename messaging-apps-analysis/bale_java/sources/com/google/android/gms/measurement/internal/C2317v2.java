package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.v2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2317v2 implements e4 {
    final /* synthetic */ G2 a;

    C2317v2(G2 g2) {
        this.a = g2;
    }

    @Override // com.google.android.gms.measurement.internal.e4
    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.a.r("auto", "_err", bundle);
        } else {
            this.a.t("auto", "_err", bundle, str);
        }
    }
}
