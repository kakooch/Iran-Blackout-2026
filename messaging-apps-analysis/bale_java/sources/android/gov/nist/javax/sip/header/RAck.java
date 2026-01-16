package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.ZE5;

/* loaded from: classes.dex */
public class RAck extends SIPHeader implements ZE5 {
    private static final long serialVersionUID = 743999286077404118L;
    protected long cSeqNumber;
    protected String method;
    protected long rSeqNumber;

    public RAck() {
        super(SIPHeaderNames.RACK);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.rSeqNumber);
        sb.append(Separators.SP);
        sb.append(this.cSeqNumber);
        sb.append(Separators.SP);
        sb.append(this.method);
        return sb;
    }

    public int getCSeqNumber() {
        return (int) this.cSeqNumber;
    }

    public long getCSeqNumberLong() {
        return this.cSeqNumber;
    }

    public long getCSequenceNumber() {
        return this.cSeqNumber;
    }

    public String getMethod() {
        return this.method;
    }

    public int getRSeqNumber() {
        return (int) this.rSeqNumber;
    }

    public long getRSequenceNumber() {
        return this.rSeqNumber;
    }

    public void setCSeqNumber(int i) {
        setCSequenceNumber(i);
    }

    public void setCSequenceNumber(long j) {
        if (j > 0 && j <= 2147483648L) {
            this.cSeqNumber = j;
            return;
        }
        throw new InvalidArgumentException("Bad CSeq # " + j);
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRSeqNumber(int i) {
        setRSequenceNumber(i);
    }

    public void setRSequenceNumber(long j) {
        if (j > 0 && this.cSeqNumber <= 2147483648L) {
            this.rSeqNumber = j;
            return;
        }
        throw new InvalidArgumentException("Bad rSeq # " + j);
    }
}
