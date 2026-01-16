package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public final class ViaList extends SIPHeaderList<Via> {
    private static final long serialVersionUID = 3899679374556152313L;

    public ViaList() {
        super(Via.class, SIPHeaderNames.VIA);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new ViaList().clonehlist(this.hlist);
    }
}
