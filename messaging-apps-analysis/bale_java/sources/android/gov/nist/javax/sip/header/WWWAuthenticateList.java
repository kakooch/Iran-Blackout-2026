package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class WWWAuthenticateList extends SIPHeaderList<WWWAuthenticate> {
    private static final long serialVersionUID = -6978902284285501346L;

    public WWWAuthenticateList() {
        super(WWWAuthenticate.class, SIPHeaderNames.WWW_AUTHENTICATE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new WWWAuthenticateList().clonehlist(this.hlist);
    }
}
