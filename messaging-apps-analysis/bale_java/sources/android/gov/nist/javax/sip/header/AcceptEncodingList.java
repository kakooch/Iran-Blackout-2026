package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class AcceptEncodingList extends SIPHeaderList<AcceptEncoding> {
    public AcceptEncodingList() {
        super(AcceptEncoding.class, SIPHeaderNames.ACCEPT_ENCODING);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        AcceptEncodingList acceptEncodingList = new AcceptEncodingList();
        acceptEncodingList.clonehlist(this.hlist);
        return acceptEncodingList;
    }
}
