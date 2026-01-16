package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class UnsupportedList extends SIPHeaderList<Unsupported> {
    private static final long serialVersionUID = -4052610269407058661L;

    public UnsupportedList() {
        super(Unsupported.class, SIPHeaderNames.UNSUPPORTED);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new UnsupportedList().clonehlist(this.hlist);
    }
}
