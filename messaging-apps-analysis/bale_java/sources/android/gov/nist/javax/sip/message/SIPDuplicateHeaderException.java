package android.gov.nist.javax.sip.message;

import android.gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

/* loaded from: classes.dex */
public class SIPDuplicateHeaderException extends ParseException {
    private static final long serialVersionUID = 8241107266407879291L;
    protected SIPHeader sipHeader;
    protected SIPMessage sipMessage;

    public SIPDuplicateHeaderException(String str) {
        super(str, 0);
    }

    public SIPHeader getSIPHeader() {
        return this.sipHeader;
    }

    public SIPMessage getSIPMessage() {
        return this.sipMessage;
    }

    public void setSIPHeader(SIPHeader sIPHeader) {
        this.sipHeader = sIPHeader;
    }

    public void setSIPMessage(SIPMessage sIPMessage) {
        this.sipMessage = sIPMessage;
    }
}
