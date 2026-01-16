package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC15786kA1;
import java.util.Calendar;

/* loaded from: classes.dex */
public class SIPDateHeader extends SIPHeader implements InterfaceC15786kA1 {
    private static final long serialVersionUID = 1734186339037274664L;
    protected SIPDate date;

    public SIPDateHeader() {
        super(SIPHeaderNames.DATE);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        SIPDateHeader sIPDateHeader = (SIPDateHeader) super.clone();
        SIPDate sIPDate = this.date;
        if (sIPDate != null) {
            sIPDateHeader.date = (SIPDate) sIPDate.clone();
        }
        return sIPDateHeader;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        return this.date.encode(sb);
    }

    public Calendar getDate() {
        SIPDate sIPDate = this.date;
        if (sIPDate == null) {
            return null;
        }
        return sIPDate.getJavaCal();
    }

    public void setDate(SIPDate sIPDate) {
        this.date = sIPDate;
    }

    public void setDate(Calendar calendar) {
        if (calendar != null) {
            this.date = new SIPDate(calendar.getTime().getTime());
        }
    }
}
