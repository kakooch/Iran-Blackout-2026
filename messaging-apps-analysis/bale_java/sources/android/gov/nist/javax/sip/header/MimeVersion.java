package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC3285Af4;

/* loaded from: classes.dex */
public class MimeVersion extends SIPHeader implements InterfaceC3285Af4 {
    private static final long serialVersionUID = -7951589626435082068L;
    protected int majorVersion;
    protected int minorVersion;

    public MimeVersion() {
        super(SIPHeaderNames.MIME_VERSION);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Integer.toString(this.majorVersion));
        sb.append(Separators.DOT);
        sb.append(Integer.toString(this.minorVersion));
        return sb;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public void setMajorVersion(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("JAIN-SIP Exception, MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        }
        this.majorVersion = i;
    }

    public void setMinorVersion(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("JAIN-SIP Exception, MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        }
        this.minorVersion = i;
    }
}
