package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;

/* loaded from: classes3.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public void b(Activity activity, int i) throws IntentSender.SendIntentException {
        a().A0(activity, i);
    }
}
