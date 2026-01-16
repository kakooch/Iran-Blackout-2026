package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.message.SIPMessage;

/* loaded from: classes.dex */
public interface MessageParser {
    SIPMessage parseSIPMessage(byte[] bArr, boolean z, boolean z2, ParseExceptionListener parseExceptionListener);
}
