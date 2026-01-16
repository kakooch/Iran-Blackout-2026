package io.appmetrica.analytics.networktasks.internal;

import android.net.Uri;

/* loaded from: classes3.dex */
public class NetworkTaskForSendingDataParamsAppender {
    private final RequestBodyEncrypter a;

    public NetworkTaskForSendingDataParamsAppender(RequestBodyEncrypter requestBodyEncrypter) {
        this.a = requestBodyEncrypter;
    }

    public void appendEncryptedData(Uri.Builder builder) {
        if (this.a.getEncryptionMode() == RequestBodyEncryptionMode.AES_RSA) {
            builder.appendQueryParameter(CommonUrlParts.ENCRYPTED_REQUEST, "1");
        }
    }
}
