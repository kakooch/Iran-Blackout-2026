package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeader;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PMediaAuthorization extends SIPHeader implements PMediaAuthorizationHeader, SIPHeaderNamesIms, InterfaceC5634Ke2 {
    private static final long serialVersionUID = -6463630258703731133L;
    private String token;

    public PMediaAuthorization() {
        super("P-Media-Authorization");
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        PMediaAuthorization pMediaAuthorization = (PMediaAuthorization) super.clone();
        String str = this.token;
        if (str != null) {
            pMediaAuthorization.token = str;
        }
        return pMediaAuthorization;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.token);
        return sb;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (obj instanceof PMediaAuthorizationHeader) {
            return getToken().equals(((PMediaAuthorizationHeader) obj).getToken());
        }
        return false;
    }

    @Override // android.gov.nist.javax.sip.header.ims.PMediaAuthorizationHeader
    public String getToken() {
        return this.token;
    }

    @Override // android.gov.nist.javax.sip.header.ims.PMediaAuthorizationHeader
    public void setMediaAuthorizationToken(String str) throws InvalidArgumentException {
        if (str == null || str.length() == 0) {
            throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        }
        this.token = str;
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }
}
