package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC19238q07;

/* loaded from: classes.dex */
public class SubscriptionState extends ParametersHeader implements InterfaceC19238q07 {
    private static final long serialVersionUID = -6673833053927258745L;
    protected int expires;
    protected String reasonCode;
    protected int retryAfter;
    protected String state;

    public SubscriptionState() {
        super(SIPHeaderNames.SUBSCRIPTION_STATE);
        this.expires = -1;
        this.retryAfter = -1;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    public int getExpires() {
        return this.expires;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public int getRetryAfter() {
        return this.retryAfter;
    }

    public String getState() {
        return this.state;
    }

    public void setExpires(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("JAIN-SIP Exception, SubscriptionState, setExpires(), the expires parameter is  < 0");
        }
        this.expires = i;
    }

    public void setReasonCode(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, SubscriptionState, setReasonCode(), the reasonCode parameter is null");
        }
        this.reasonCode = str;
    }

    public void setRetryAfter(int i) throws InvalidArgumentException {
        if (i <= 0) {
            throw new InvalidArgumentException("JAIN-SIP Exception, SubscriptionState, setRetryAfter(), the retryAfter parameter is <=0");
        }
        this.retryAfter = i;
    }

    public void setState(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, SubscriptionState, setState(), the state parameter is null");
        }
        this.state = str;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        String str = this.state;
        if (str != null) {
            sb.append(str);
        }
        if (this.reasonCode != null) {
            sb.append(";reason=");
            sb.append(this.reasonCode);
        }
        if (this.expires != -1) {
            sb.append(";expires=");
            sb.append(this.expires);
        }
        if (this.retryAfter != -1) {
            sb.append(";retry-after=");
            sb.append(this.retryAfter);
        }
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }
}
