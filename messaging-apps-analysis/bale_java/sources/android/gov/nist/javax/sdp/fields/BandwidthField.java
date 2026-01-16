package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC23330wk2;

/* loaded from: classes.dex */
public class BandwidthField extends SDPField implements InterfaceC23330wk2 {
    protected int bandwidth;
    protected String bwtype;

    public BandwidthField() {
        super(SDPFieldNames.BANDWIDTH_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = this.bwtype;
        String str2 = SDPFieldNames.BANDWIDTH_FIELD;
        if (str != null) {
            str2 = SDPFieldNames.BANDWIDTH_FIELD + this.bwtype + ":";
        }
        return str2 + this.bandwidth + Separators.NEWLINE;
    }

    public int getBandwidth() {
        return this.bandwidth;
    }

    public String getBwtype() {
        return this.bwtype;
    }

    public String getType() {
        return getBwtype();
    }

    public int getValue() {
        return getBandwidth();
    }

    public void setBandwidth(int i) {
        this.bandwidth = i;
    }

    public void setBwtype(String str) {
        this.bwtype = str;
    }

    public void setType(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The type is null");
        }
        setBwtype(str);
    }

    public void setValue(int i) {
        setBandwidth(i);
    }
}
