package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class AlertInfoList extends SIPHeaderList<AlertInfo> {
    private static final long serialVersionUID = 1;

    public AlertInfoList() {
        super(AlertInfo.class, SIPHeaderNames.ALERT_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        AlertInfoList alertInfoList = new AlertInfoList();
        alertInfoList.clonehlist(this.hlist);
        return alertInfoList;
    }
}
