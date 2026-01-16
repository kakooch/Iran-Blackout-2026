package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: classes3.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int a;

    public GooglePlayServicesManifestException(int i, String str) {
        super(str);
        this.a = i;
    }
}
