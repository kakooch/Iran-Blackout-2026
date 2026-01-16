package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC23330wk2;

/* loaded from: classes.dex */
public class EmailField extends SDPField implements InterfaceC23330wk2 {
    protected EmailAddress emailAddress;

    public EmailField() {
        super(SDPFieldNames.EMAIL_FIELD);
        this.emailAddress = new EmailAddress();
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        EmailField emailField = (EmailField) super.clone();
        EmailAddress emailAddress = this.emailAddress;
        if (emailAddress != null) {
            emailField.emailAddress = (EmailAddress) emailAddress.clone();
        }
        return emailField;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return SDPFieldNames.EMAIL_FIELD + this.emailAddress.encode() + Separators.NEWLINE;
    }

    public EmailAddress getEmailAddress() {
        return this.emailAddress;
    }

    public String getValue() {
        EmailAddress emailAddress = this.emailAddress;
        if (emailAddress == null) {
            return null;
        }
        return emailAddress.getDisplayName();
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setValue(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The value is null");
        }
        this.emailAddress.setDisplayName(str);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject
    public String toString() {
        return encode();
    }
}
