package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public final class InReplyToList extends SIPHeaderList<InReplyTo> {
    private static final long serialVersionUID = -7993498496830999237L;

    public InReplyToList() {
        super(InReplyTo.class, SIPHeaderNames.IN_REPLY_TO);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        InReplyToList inReplyToList = new InReplyToList();
        inReplyToList.clonehlist(this.hlist);
        return inReplyToList;
    }
}
