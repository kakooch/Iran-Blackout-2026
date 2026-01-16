package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC12560ep0;

/* loaded from: classes.dex */
public class CSeq extends SIPHeader implements InterfaceC12560ep0 {
    private static final long serialVersionUID = -5405798080040422910L;
    protected String method;
    protected Long seqno;

    public CSeq() {
        super(SIPHeaderNames.CSEQ);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return this.headerName + ":" + Separators.SP + encodeBody() + Separators.NEWLINE;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC12560ep0)) {
            return false;
        }
        InterfaceC12560ep0 interfaceC12560ep0 = (InterfaceC12560ep0) obj;
        return getSeqNumber() == interfaceC12560ep0.getSeqNumber() && getMethod().equals(interfaceC12560ep0.getMethod());
    }

    @Override // ir.nasim.InterfaceC12560ep0
    public String getMethod() {
        return this.method;
    }

    @Override // ir.nasim.InterfaceC12560ep0
    public long getSeqNumber() {
        return this.seqno.longValue();
    }

    public int getSequenceNumber() {
        Long l = this.seqno;
        if (l == null) {
            return 0;
        }
        return l.intValue();
    }

    @Override // ir.nasim.InterfaceC12560ep0
    public void setMethod(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, CSeq, setMethod(), the meth parameter is null");
        }
        this.method = SIPRequest.getCannonicalName(str);
    }

    @Override // ir.nasim.InterfaceC12560ep0
    public void setSeqNumber(long j) {
        if (j < 0) {
            throw new InvalidArgumentException("JAIN-SIP Exception, CSeq, setSequenceNumber(), the sequence number parameter is < 0 : " + j);
        }
        if (j <= 2147483648L) {
            this.seqno = Long.valueOf(j);
            return;
        }
        throw new InvalidArgumentException("JAIN-SIP Exception, CSeq, setSequenceNumber(), the sequence number parameter is too large : " + j);
    }

    public void setSequenceNumber(int i) {
        setSeqNumber(i);
    }

    public CSeq(long j, String str) {
        this();
        this.seqno = Long.valueOf(j);
        this.method = SIPRequest.getCannonicalName(str);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.seqno);
        sb.append(Separators.SP);
        sb.append(this.method.toUpperCase());
        return sb;
    }
}
