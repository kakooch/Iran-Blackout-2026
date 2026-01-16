package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC23547x63;

/* loaded from: classes.dex */
public class InformationField extends SDPField implements InterfaceC23547x63 {
    protected String information;

    public InformationField() {
        super(SDPFieldNames.INFORMATION_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return SDPFieldNames.INFORMATION_FIELD + this.information + Separators.NEWLINE;
    }

    public String getInformation() {
        return this.information;
    }

    public String getValue() {
        return this.information;
    }

    public void setInformation(String str) {
        this.information = str;
    }

    public void setValue(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The value is null");
        }
        setInformation(str);
    }
}
