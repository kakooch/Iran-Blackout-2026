package android.gov.nist.javax.sip.header;

import android.javax.sip.InvalidArgumentException;
import android.javax.sip.header.TooManyHopsException;
import ir.nasim.VV3;

/* loaded from: classes.dex */
public class MaxForwards extends SIPHeader implements VV3 {
    private static final long serialVersionUID = -3096874323347175943L;
    protected int maxForwards;

    public MaxForwards() {
        super(SIPHeaderNames.MAX_FORWARDS);
    }

    public void decrementMaxForwards() throws TooManyHopsException {
        int i = this.maxForwards;
        if (i <= 0) {
            throw new TooManyHopsException("has already reached 0!");
        }
        this.maxForwards = i - 1;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VV3) && getMaxForwards() == ((VV3) obj).getMaxForwards();
    }

    @Override // ir.nasim.VV3
    public int getMaxForwards() {
        return this.maxForwards;
    }

    public boolean hasReachedZero() {
        return this.maxForwards == 0;
    }

    public void setMaxForwards(int i) throws InvalidArgumentException {
        if (i >= 0 && i <= 255) {
            this.maxForwards = i;
            return;
        }
        throw new InvalidArgumentException("bad max forwards value " + i);
    }

    public MaxForwards(int i) throws InvalidArgumentException {
        super(SIPHeaderNames.MAX_FORWARDS);
        setMaxForwards(i);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.maxForwards);
        return sb;
    }
}
