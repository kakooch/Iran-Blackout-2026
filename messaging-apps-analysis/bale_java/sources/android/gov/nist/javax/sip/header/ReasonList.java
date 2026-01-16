package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public final class ReasonList extends SIPHeaderList<Reason> {
    private static final long serialVersionUID = 7459989997463160670L;

    public ReasonList() {
        super(Reason.class, SIPHeaderNames.REASON);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ReasonList reasonList = new ReasonList();
        reasonList.clonehlist(this.hlist);
        return reasonList;
    }
}
