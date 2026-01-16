package android.javax.sdp;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class SdpException extends Exception {
    public SdpException() {
    }

    public SdpException(String str) {
        super(str);
    }

    public SdpException(String str, Throwable th) {
        super(th.getMessage() + Separators.SEMICOLON + str);
    }
}
