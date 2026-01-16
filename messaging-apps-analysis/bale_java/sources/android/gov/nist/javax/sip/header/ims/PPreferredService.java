package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeader;
import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PPreferredService extends SIPHeader implements PPreferredServiceHeader, SIPHeaderNamesIms, InterfaceC5634Ke2 {
    private String subAppIds;
    private String subServiceIds;

    protected PPreferredService(String str) {
        super("P-Preferred-Service");
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        return (PPreferredService) super.clone();
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(ParameterNamesIms.SERVICE_ID);
        if (this.subServiceIds != null) {
            sb.append(ParameterNamesIms.SERVICE_ID_LABEL);
            sb.append(Separators.DOT);
            sb.append(getSubserviceIdentifiers());
        } else if (this.subAppIds != null) {
            sb.append(ParameterNamesIms.APPLICATION_ID_LABEL);
            sb.append(Separators.DOT);
            sb.append(getApplicationIdentifiers());
        }
        return sb;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return (obj instanceof PPreferredServiceHeader) && super.equals(obj);
    }

    @Override // android.gov.nist.javax.sip.header.ims.PPreferredServiceHeader
    public String getApplicationIdentifiers() {
        return this.subAppIds.charAt(0) == '.' ? this.subAppIds.substring(1).trim() : this.subAppIds;
    }

    @Override // android.gov.nist.javax.sip.header.ims.PPreferredServiceHeader
    public String getSubserviceIdentifiers() {
        return this.subServiceIds.charAt(0) == '.' ? this.subServiceIds.substring(1).trim() : this.subServiceIds;
    }

    @Override // android.gov.nist.javax.sip.header.ims.PPreferredServiceHeader
    public void setApplicationIdentifiers(String str) {
        this.subAppIds = str;
    }

    @Override // android.gov.nist.javax.sip.header.ims.PPreferredServiceHeader
    public void setSubserviceIdentifiers(String str) {
        this.subServiceIds = Separators.DOT.concat(str);
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }

    public PPreferredService() {
        super("P-Preferred-Service");
    }
}
