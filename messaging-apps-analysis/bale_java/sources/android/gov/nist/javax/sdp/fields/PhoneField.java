package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC23330wk2;

/* loaded from: classes.dex */
public class PhoneField extends SDPField implements InterfaceC23330wk2 {
    protected String name;
    protected String phoneNumber;

    public PhoneField() {
        super(SDPFieldNames.PHONE_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = this.name;
        String str2 = SDPFieldNames.PHONE_FIELD;
        if (str != null) {
            str2 = SDPFieldNames.PHONE_FIELD + this.name + Separators.LESS_THAN;
        }
        String str3 = str2 + this.phoneNumber;
        if (this.name != null) {
            str3 = str3 + Separators.GREATER_THAN;
        }
        return str3 + Separators.NEWLINE;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getValue() {
        return getName();
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setValue(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The value parameter is null");
        }
        setName(str);
    }
}
