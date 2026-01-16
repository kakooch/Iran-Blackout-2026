package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class AuthenticationInfoList extends SIPHeaderList<AuthenticationInfo> {
    private static final long serialVersionUID = 1;

    public AuthenticationInfoList() {
        super(AuthenticationInfo.class, SIPHeaderNames.AUTHENTICATION_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        AuthenticationInfoList authenticationInfoList = new AuthenticationInfoList();
        authenticationInfoList.clonehlist(this.hlist);
        return authenticationInfoList;
    }
}
