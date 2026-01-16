package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC15571jo3;

/* loaded from: classes.dex */
public class KeyField extends SDPField implements InterfaceC15571jo3 {
    protected String keyData;
    protected String type;

    public KeyField() {
        super(SDPFieldNames.KEY_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = SDPFieldNames.KEY_FIELD + this.type;
        if (this.keyData != null) {
            str = (str + ":") + this.keyData;
        }
        return str + Separators.NEWLINE;
    }

    public String getKey() {
        return getKeyData();
    }

    public String getKeyData() {
        return this.keyData;
    }

    public String getMethod() {
        return this.type;
    }

    public String getType() {
        return this.type;
    }

    public boolean hasKey() {
        return getKeyData() != null;
    }

    public void setKey(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The key is null");
        }
        setKeyData(str);
    }

    public void setKeyData(String str) {
        this.keyData = str;
    }

    public void setMethod(String str) {
        this.type = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
