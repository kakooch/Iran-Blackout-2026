package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.ZR7;

/* loaded from: classes.dex */
public class ProtoVersionField extends SDPField implements ZR7 {
    protected int protoVersion;

    public ProtoVersionField() {
        super(SDPFieldNames.PROTO_VERSION_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return SDPFieldNames.PROTO_VERSION_FIELD + this.protoVersion + Separators.NEWLINE;
    }

    public int getProtoVersion() {
        return this.protoVersion;
    }

    public int getVersion() {
        return getProtoVersion();
    }

    public void setProtoVersion(int i) {
        this.protoVersion = i;
    }

    public void setVersion(int i) throws SdpException {
        if (i < 0) {
            throw new SdpException("The value is <0");
        }
        setProtoVersion(i);
    }
}
