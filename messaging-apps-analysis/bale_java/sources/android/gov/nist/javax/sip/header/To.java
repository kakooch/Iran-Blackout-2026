package android.gov.nist.javax.sip.header;

import android.gov.nist.core.HostPort;
import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.parser.Parser;
import ir.nasim.InterfaceC18560or7;

/* loaded from: classes.dex */
public final class To extends AddressParametersHeader implements InterfaceC18560or7 {
    private static final long serialVersionUID = -4057413800584586316L;

    public To() {
        super(SIPHeaderNames.TO, true);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return this.headerName + ":" + Separators.SP + encodeBody() + Separators.NEWLINE;
    }

    protected String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.AddressParametersHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC18560or7) && super.equals(obj);
    }

    public String getDisplayName() {
        AddressImpl addressImpl = this.address;
        if (addressImpl == null) {
            return null;
        }
        return addressImpl.getDisplayName();
    }

    public HostPort getHostPort() {
        AddressImpl addressImpl = this.address;
        if (addressImpl == null) {
            return null;
        }
        return addressImpl.getHostPort();
    }

    @Override // ir.nasim.InterfaceC18560or7
    public String getTag() {
        if (this.parameters == null) {
            return null;
        }
        return getParameter(ParameterNames.TAG);
    }

    public String getUserAtHostPort() {
        AddressImpl addressImpl = this.address;
        if (addressImpl == null) {
            return null;
        }
        return addressImpl.getUserAtHostPort();
    }

    public boolean hasTag() {
        if (this.parameters == null) {
            return false;
        }
        return hasParameter(ParameterNames.TAG);
    }

    public void removeTag() {
        NameValueList nameValueList = this.parameters;
        if (nameValueList != null) {
            nameValueList.delete(ParameterNames.TAG);
        }
    }

    @Override // ir.nasim.InterfaceC18560or7
    public void setTag(String str) {
        Parser.checkToken(str);
        setParameter(ParameterNames.TAG, str);
    }

    public To(From from) {
        super(SIPHeaderNames.TO);
        setAddress(from.address);
        setParameters(from.parameters);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        AddressImpl addressImpl = this.address;
        if (addressImpl != null) {
            if (addressImpl.getAddressType() == 2) {
                sb.append(Separators.LESS_THAN);
            }
            this.address.encode(sb);
            if (this.address.getAddressType() == 2) {
                sb.append(Separators.GREATER_THAN);
            }
            if (!this.parameters.isEmpty()) {
                sb.append(Separators.SEMICOLON);
                this.parameters.encode(sb);
            }
        }
        return sb;
    }
}
