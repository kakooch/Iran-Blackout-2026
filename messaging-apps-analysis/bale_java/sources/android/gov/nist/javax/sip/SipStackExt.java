package android.gov.nist.javax.sip;

import android.gov.nist.core.net.AddressResolver;
import android.gov.nist.javax.sip.clientauthutils.AccountManager;
import android.gov.nist.javax.sip.clientauthutils.AuthenticationHelper;
import android.gov.nist.javax.sip.clientauthutils.SecureAccountManager;
import android.gov.nist.javax.sip.header.extensions.JoinHeader;
import android.gov.nist.javax.sip.header.extensions.ReplacesHeader;
import ir.nasim.InterfaceC17579nC3;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.LD6;
import ir.nasim.LU2;
import ir.nasim.MD6;
import ir.nasim.W46;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface SipStackExt extends MD6 {
    /* synthetic */ InterfaceC17579nC3 createListeningPoint(int i, String str);

    /* synthetic */ InterfaceC17579nC3 createListeningPoint(String str, int i, String str2);

    /* synthetic */ LD6 createSipProvider(InterfaceC17579nC3 interfaceC17579nC3);

    /* synthetic */ void deleteListeningPoint(InterfaceC17579nC3 interfaceC17579nC3);

    /* synthetic */ void deleteSipProvider(LD6 ld6);

    AuthenticationHelper getAuthenticationHelper(AccountManager accountManager, LU2 lu2);

    Collection<InterfaceC17658nL1> getDialogs();

    /* synthetic */ String getIPAddress();

    InterfaceC17658nL1 getJoinDialog(JoinHeader joinHeader);

    /* synthetic */ Iterator getListeningPoints();

    SocketAddress getLocalAddressForTcpDst(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2);

    SocketAddress getLocalAddressForTlsDst(InetAddress inetAddress, int i, InetAddress inetAddress2);

    InterfaceC17658nL1 getReplacesDialog(ReplacesHeader replacesHeader);

    /* synthetic */ W46 getRouter();

    AuthenticationHelper getSecureAuthenticationHelper(SecureAccountManager secureAccountManager, LU2 lu2);

    /* synthetic */ Iterator getSipProviders();

    /* synthetic */ String getStackName();

    /* synthetic */ boolean isRetransmissionFilterActive();

    void setAddressResolver(AddressResolver addressResolver);

    void setEnabledCipherSuites(String[] strArr);

    /* synthetic */ void start();

    /* synthetic */ void stop();
}
