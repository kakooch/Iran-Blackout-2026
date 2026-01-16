package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import ir.nasim.HU2;

/* loaded from: classes.dex */
public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, HU2, HeaderExt {
    protected String headerName;

    protected SIPHeader(String str) {
        this.headerName = str.intern();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    protected abstract StringBuilder encodeBody(StringBuilder sb);

    public String getHeaderName() {
        return this.headerName;
    }

    public String getHeaderValue() {
        return encodeBody(new StringBuilder()).toString();
    }

    public String getName() {
        return this.headerName;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderExt
    public String getValue() {
        return getHeaderValue();
    }

    public int hashCode() {
        return this.headerName.hashCode();
    }

    public boolean isHeaderList() {
        return false;
    }

    public void setHeaderName(String str) {
        this.headerName = str;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, ir.nasim.HU2
    public final String toString() {
        return encode();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        sb.append(this.headerName);
        sb.append(":");
        sb.append(Separators.SP);
        encodeBody(sb);
        sb.append(Separators.NEWLINE);
        return sb;
    }

    public SIPHeader() {
    }
}
