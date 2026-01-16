package android.gov.nist.javax.sip.clientauthutils;

import ir.nasim.CV0;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.LD6;
import ir.nasim.UP5;

/* loaded from: classes.dex */
public interface AuthenticationHelper {
    CV0 handleChallenge(InterfaceC10981cX5 interfaceC10981cX5, CV0 cv0, LD6 ld6, int i);

    CV0 handleChallenge(InterfaceC10981cX5 interfaceC10981cX5, CV0 cv0, LD6 ld6, int i, boolean z);

    void removeCachedAuthenticationHeaders(String str);

    void setAuthenticationHeaders(UP5 up5);
}
