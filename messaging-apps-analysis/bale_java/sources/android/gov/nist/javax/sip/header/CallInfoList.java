package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class CallInfoList extends SIPHeaderList<CallInfo> {
    private static final long serialVersionUID = -4949850334388806423L;

    public CallInfoList() {
        super(CallInfo.class, SIPHeaderNames.CALL_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        CallInfoList callInfoList = new CallInfoList();
        callInfoList.clonehlist(this.hlist);
        return callInfoList;
    }
}
