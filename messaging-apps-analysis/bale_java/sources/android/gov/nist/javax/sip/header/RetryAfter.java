package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC19838r16;

/* loaded from: classes.dex */
public class RetryAfter extends ParametersHeader implements InterfaceC19838r16 {
    public static final String DURATION = "duration";
    private static final long serialVersionUID = -1029458515616146140L;
    protected String comment;
    protected Integer retryAfter;

    public RetryAfter() {
        super(SIPHeaderNames.RETRY_AFTER);
        this.retryAfter = new Integer(0);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        Integer num = this.retryAfter;
        if (num != null) {
            sb.append(num);
        }
        if (this.comment != null) {
            sb.append(" (" + this.comment + Separators.RPAREN);
        }
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }

    public String getComment() {
        return this.comment;
    }

    public int getDuration() {
        if (getParameter("duration") == null) {
            return -1;
        }
        return super.getParameterAsInt("duration");
    }

    public int getRetryAfter() {
        return this.retryAfter.intValue();
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public void removeComment() {
        this.comment = null;
    }

    public void removeDuration() {
        super.removeParameter("duration");
    }

    public void setComment(String str) {
        if (str == null) {
            throw new NullPointerException("the comment parameter is null");
        }
        this.comment = str;
    }

    public void setDuration(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("the duration parameter is <0");
        }
        setParameter("duration", i);
    }

    public void setRetryAfter(int i) throws InvalidArgumentException {
        if (i >= 0) {
            this.retryAfter = Integer.valueOf(i);
            return;
        }
        throw new InvalidArgumentException("invalid parameter " + i);
    }
}
