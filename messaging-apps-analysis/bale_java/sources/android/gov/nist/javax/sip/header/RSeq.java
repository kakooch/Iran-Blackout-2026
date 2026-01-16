package android.gov.nist.javax.sip.header;

import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC13453gF5;

/* loaded from: classes.dex */
public class RSeq extends SIPHeader implements InterfaceC13453gF5 {
    private static final long serialVersionUID = 8765762413224043394L;
    protected long sequenceNumber;

    public RSeq() {
        super(SIPHeaderNames.RSEQ);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Long.toString(this.sequenceNumber));
        return sb;
    }

    public long getSeqNumber() {
        return this.sequenceNumber;
    }

    public int getSequenceNumber() {
        return (int) this.sequenceNumber;
    }

    public void setSeqNumber(long j) {
        if (j > 0 && j <= 2147483648L) {
            this.sequenceNumber = j;
            return;
        }
        throw new InvalidArgumentException("Bad seq number " + j);
    }

    public void setSequenceNumber(int i) {
        setSeqNumber(i);
    }
}
