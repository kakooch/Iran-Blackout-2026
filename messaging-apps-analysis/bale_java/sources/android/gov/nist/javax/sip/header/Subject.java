package android.gov.nist.javax.sip.header;

import ir.nasim.YZ6;

/* loaded from: classes.dex */
public class Subject extends SIPHeader implements YZ6 {
    private static final long serialVersionUID = -6479220126758862528L;
    protected String subject;

    public Subject() {
        super(SIPHeaderNames.SUBJECT);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        String str = this.subject;
        if (str != null) {
            sb.append(str);
            return sb;
        }
        sb.append("");
        return sb;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  Subject, setSubject(), the subject parameter is null");
        }
        this.subject = str;
    }
}
