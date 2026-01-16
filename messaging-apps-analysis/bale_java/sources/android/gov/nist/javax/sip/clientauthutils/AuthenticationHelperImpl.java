package android.gov.nist.javax.sip.clientauthutils;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.stack.SIPClientTransaction;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.javax.sip.InvalidArgumentException;
import android.javax.sip.SipException;
import ir.nasim.C23720xP1;
import ir.nasim.CV0;
import ir.nasim.FY2;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC21052t18;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC9436Zx5;
import ir.nasim.LD6;
import ir.nasim.LU2;
import ir.nasim.ND6;
import ir.nasim.UP5;
import ir.nasim.VR;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Timer;

/* loaded from: classes.dex */
public class AuthenticationHelperImpl implements AuthenticationHelper {
    private static StackLogger logger = CommonLogger.getLogger(AuthenticationHelperImpl.class);
    private Object accountManager;
    private CredentialsCache cachedCredentials;
    private LU2 headerFactory;
    private SIPTransactionStack sipStack;
    Timer timer;

    public AuthenticationHelperImpl(SIPTransactionStack sIPTransactionStack, AccountManager accountManager, LU2 lu2) {
        this.accountManager = accountManager;
        this.headerFactory = lu2;
        this.sipStack = sIPTransactionStack;
        this.cachedCredentials = new CredentialsCache(sIPTransactionStack.getTimer());
    }

    private VR getAuthorization(String str, String str2, String str3, InterfaceC21052t18 interfaceC21052t18, UserCredentials userCredentials) {
        String str4 = interfaceC21052t18.getQop() != null ? "auth" : null;
        String strCalculateResponse = MessageDigestAlgorithm.calculateResponse(interfaceC21052t18.getAlgorithm(), userCredentials.getUserName(), interfaceC21052t18.getRealm(), userCredentials.getPassword(), interfaceC21052t18.getNonce(), "00000001", "xyz", str, str2, str3, str4, logger);
        try {
            VR vrCreateProxyAuthorizationHeader = interfaceC21052t18 instanceof InterfaceC9436Zx5 ? this.headerFactory.createProxyAuthorizationHeader(interfaceC21052t18.getScheme()) : this.headerFactory.createAuthorizationHeader(interfaceC21052t18.getScheme());
            vrCreateProxyAuthorizationHeader.setUsername(userCredentials.getUserName());
            vrCreateProxyAuthorizationHeader.setRealm(interfaceC21052t18.getRealm());
            vrCreateProxyAuthorizationHeader.setNonce(interfaceC21052t18.getNonce());
            vrCreateProxyAuthorizationHeader.setParameter("uri", str2);
            vrCreateProxyAuthorizationHeader.setResponse(strCalculateResponse);
            if (interfaceC21052t18.getAlgorithm() != null) {
                vrCreateProxyAuthorizationHeader.setAlgorithm(interfaceC21052t18.getAlgorithm());
            }
            if (interfaceC21052t18.getOpaque() != null) {
                vrCreateProxyAuthorizationHeader.setOpaque(interfaceC21052t18.getOpaque());
            }
            if (str4 != null) {
                vrCreateProxyAuthorizationHeader.setQop(str4);
                vrCreateProxyAuthorizationHeader.setCNonce("xyz");
                vrCreateProxyAuthorizationHeader.setNonceCount(Integer.parseInt("00000001"));
            }
            vrCreateProxyAuthorizationHeader.setResponse(strCalculateResponse);
            return vrCreateProxyAuthorizationHeader;
        } catch (ParseException unused) {
            throw new RuntimeException("Failed to create an authorization header!");
        }
    }

    private void removeBranchID(UP5 up5) {
        ((InterfaceC18318oS7) up5.getHeader(SIPHeaderNames.VIA)).removeParameter("branch");
    }

    @Override // android.gov.nist.javax.sip.clientauthutils.AuthenticationHelper
    public CV0 handleChallenge(InterfaceC10981cX5 interfaceC10981cX5, CV0 cv0, LD6 ld6, int i) {
        return handleChallenge(interfaceC10981cX5, cv0, ld6, i, false);
    }

    @Override // android.gov.nist.javax.sip.clientauthutils.AuthenticationHelper
    public void removeCachedAuthenticationHeaders(String str) {
        if (str == null) {
            throw new NullPointerException("Null callId argument ");
        }
        this.cachedCredentials.removeAuthenticationHeader(str);
    }

    @Override // android.gov.nist.javax.sip.clientauthutils.AuthenticationHelper
    public void setAuthenticationHeaders(UP5 up5) {
        String callId = ((SIPRequest) up5).getCallId().getCallId();
        up5.removeHeader(SIPHeaderNames.AUTHORIZATION);
        Collection<VR> cachedAuthorizationHeaders = this.cachedCredentials.getCachedAuthorizationHeaders(callId);
        if (cachedAuthorizationHeaders != null) {
            Iterator<VR> it = cachedAuthorizationHeaders.iterator();
            while (it.hasNext()) {
                up5.addHeader(it.next());
            }
        } else if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Could not find authentication headers for " + callId);
        }
    }

    @Override // android.gov.nist.javax.sip.clientauthutils.AuthenticationHelper
    public CV0 handleChallenge(InterfaceC10981cX5 interfaceC10981cX5, CV0 cv0, LD6 ld6, int i, boolean z) throws SipException {
        UP5 up5CreateRequest;
        ListIterator headers;
        VR authorization;
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("handleChallenge: " + interfaceC10981cX5);
            }
            SIPRequest sIPRequest = (SIPRequest) cv0.getRequest();
            if (sIPRequest.getToTag() == null && cv0.getDialog() != null && cv0.getDialog().getState() == C23720xP1.e) {
                up5CreateRequest = cv0.getDialog().createRequest(sIPRequest.getMethod());
                ListIterator<String> headerNames = sIPRequest.getHeaderNames();
                while (headerNames.hasNext()) {
                    String next = headerNames.next();
                    if (up5CreateRequest.getHeader(next) == null) {
                        ListIterator<SIPHeader> headers2 = sIPRequest.getHeaders(next);
                        while (headers2.hasNext()) {
                            up5CreateRequest.addHeader(headers2.next());
                        }
                    }
                }
            } else {
                up5CreateRequest = (UP5) sIPRequest.clone();
            }
            removeBranchID(up5CreateRequest);
            if (interfaceC10981cX5 == null || up5CreateRequest == null) {
                throw new NullPointerException("A null argument was passed to handle challenge.");
            }
            if (interfaceC10981cX5.getStatusCode() == 401) {
                headers = interfaceC10981cX5.getHeaders(SIPHeaderNames.WWW_AUTHENTICATE);
            } else {
                if (interfaceC10981cX5.getStatusCode() != 407) {
                    throw new IllegalArgumentException("Unexpected status code ");
                }
                headers = interfaceC10981cX5.getHeaders(SIPHeaderNames.PROXY_AUTHENTICATE);
            }
            if (headers == null) {
                throw new IllegalArgumentException("Could not find WWWAuthenticate or ProxyAuthenticate headers");
            }
            up5CreateRequest.removeHeader(SIPHeaderNames.AUTHORIZATION);
            up5CreateRequest.removeHeader(SIPHeaderNames.PROXY_AUTHORIZATION);
            InterfaceC12560ep0 interfaceC12560ep0 = (InterfaceC12560ep0) up5CreateRequest.getHeader(SIPHeaderNames.CSEQ);
            try {
                interfaceC12560ep0.setSeqNumber(interfaceC12560ep0.getSeqNumber() + 1);
                if (!z && sIPRequest.getRouteHeaders() == null) {
                    FY2 nextHop = ((SIPClientTransaction) cv0).getNextHop();
                    ND6 nd6 = (ND6) up5CreateRequest.getRequestURI();
                    nd6.setMAddrParam(nextHop.getHost());
                    if (nextHop.getPort() != -1) {
                        nd6.setPort(nextHop.getPort());
                    }
                }
                CV0 newClientTransaction = ld6.getNewClientTransaction(up5CreateRequest);
                while (headers.hasNext()) {
                    InterfaceC21052t18 interfaceC21052t18 = (InterfaceC21052t18) headers.next();
                    String realm = interfaceC21052t18.getRealm();
                    Object obj = this.accountManager;
                    if (obj instanceof SecureAccountManager) {
                        UserCredentialHash credentialHash = ((SecureAccountManager) obj).getCredentialHash(cv0, realm);
                        if (credentialHash == null) {
                            logger.logDebug("Could not find creds");
                            throw new SipException("Cannot find user creds for the given user name and realm");
                        }
                        InterfaceC21815uA7 requestURI = up5CreateRequest.getRequestURI();
                        credentialHash.getSipDomain();
                        authorization = getAuthorization(up5CreateRequest.getMethod(), requestURI.toString(), up5CreateRequest.getContent() == null ? "" : new String(up5CreateRequest.getRawContent()), interfaceC21052t18, credentialHash);
                    } else {
                        UserCredentials credentials = ((AccountManager) obj).getCredentials(cv0, realm);
                        if (credentials == null) {
                            throw new SipException("Cannot find user creds for the given user name and realm");
                        }
                        credentials.getSipDomain();
                        authorization = getAuthorization(up5CreateRequest.getMethod(), up5CreateRequest.getRequestURI().toString(), up5CreateRequest.getContent() == null ? "" : new String(up5CreateRequest.getRawContent()), interfaceC21052t18, credentials);
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Created authorization header: " + authorization.toString());
                    }
                    if (i != 0) {
                        this.cachedCredentials.cacheAuthorizationHeader(sIPRequest.getCallId().getCallId(), authorization, i);
                    }
                    up5CreateRequest.addHeader(authorization);
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Returning authorization transaction." + newClientTransaction);
                }
                return newClientTransaction;
            } catch (InvalidArgumentException unused) {
                throw new SipException("Invalid CSeq -- could not increment : " + interfaceC12560ep0.getSeqNumber());
            }
        } catch (SipException e) {
            throw e;
        } catch (Exception e2) {
            logger.logError("Unexpected exception ", e2);
            throw new SipException("Unexpected exception ", e2);
        }
    }

    public AuthenticationHelperImpl(SIPTransactionStack sIPTransactionStack, SecureAccountManager secureAccountManager, LU2 lu2) {
        this.accountManager = secureAccountManager;
        this.headerFactory = lu2;
        this.sipStack = sIPTransactionStack;
        this.cachedCredentials = new CredentialsCache(sIPTransactionStack.getTimer());
    }

    private VR getAuthorization(String str, String str2, String str3, InterfaceC21052t18 interfaceC21052t18, UserCredentialHash userCredentialHash) {
        VR vrCreateAuthorizationHeader;
        String str4 = interfaceC21052t18.getQop() != null ? "auth" : null;
        String strCalculateResponse = MessageDigestAlgorithm.calculateResponse(interfaceC21052t18.getAlgorithm(), userCredentialHash.getHashUserDomainPassword(), interfaceC21052t18.getNonce(), "00000001", "xyz", str, str2, str3, str4, logger);
        try {
            if (interfaceC21052t18 instanceof InterfaceC9436Zx5) {
                vrCreateAuthorizationHeader = this.headerFactory.createProxyAuthorizationHeader(interfaceC21052t18.getScheme());
            } else {
                vrCreateAuthorizationHeader = this.headerFactory.createAuthorizationHeader(interfaceC21052t18.getScheme());
            }
            vrCreateAuthorizationHeader.setUsername(userCredentialHash.getUserName());
            vrCreateAuthorizationHeader.setRealm(interfaceC21052t18.getRealm());
            vrCreateAuthorizationHeader.setNonce(interfaceC21052t18.getNonce());
            vrCreateAuthorizationHeader.setParameter("uri", str2);
            vrCreateAuthorizationHeader.setResponse(strCalculateResponse);
            if (interfaceC21052t18.getAlgorithm() != null) {
                vrCreateAuthorizationHeader.setAlgorithm(interfaceC21052t18.getAlgorithm());
            }
            if (interfaceC21052t18.getOpaque() != null) {
                vrCreateAuthorizationHeader.setOpaque(interfaceC21052t18.getOpaque());
            }
            if (str4 != null) {
                vrCreateAuthorizationHeader.setQop(str4);
                vrCreateAuthorizationHeader.setCNonce("xyz");
                vrCreateAuthorizationHeader.setNonceCount(Integer.parseInt("00000001"));
            }
            vrCreateAuthorizationHeader.setResponse(strCalculateResponse);
            return vrCreateAuthorizationHeader;
        } catch (ParseException unused) {
            throw new RuntimeException("Failed to create an authorization header!");
        }
    }
}
