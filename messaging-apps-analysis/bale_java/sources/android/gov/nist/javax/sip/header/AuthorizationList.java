package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class AuthorizationList extends SIPHeaderList<Authorization> {
    private static final long serialVersionUID = 1;

    public AuthorizationList() {
        super(Authorization.class, SIPHeaderNames.AUTHORIZATION);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        AuthorizationList authorizationList = new AuthorizationList();
        authorizationList.clonehlist(this.hlist);
        return authorizationList;
    }
}
