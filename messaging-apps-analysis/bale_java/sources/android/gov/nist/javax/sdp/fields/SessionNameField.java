package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC11382cu6;

/* loaded from: classes.dex */
public class SessionNameField extends SDPField implements InterfaceC11382cu6 {
    protected String sessionName;

    public SessionNameField() {
        super(SDPFieldNames.SESSION_NAME_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return SDPFieldNames.SESSION_NAME_FIELD + this.sessionName + Separators.NEWLINE;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public String getValue() {
        return getSessionName();
    }

    public void setSessionName(String str) {
        this.sessionName = str;
    }

    public void setValue(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The value is null");
        }
        setSessionName(str);
    }
}
