package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.address.ParameterNames;
import android.gov.nist.javax.sip.address.SipUri;
import android.gov.nist.javax.sip.header.RequestLine;
import android.gov.nist.javax.sip.header.Route;
import android.gov.nist.javax.sip.header.RouteList;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.javax.sip.SipException;
import ir.nasim.FY2;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.MD6;
import ir.nasim.ND6;
import ir.nasim.UP5;
import ir.nasim.W46;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class DefaultRouter implements W46 {
    private static StackLogger logger = CommonLogger.getLogger(DefaultRouter.class);
    private FY2 defaultRoute;
    private SIPTransactionStack sipStack;

    private DefaultRouter() {
    }

    protected final FY2 createHop(ND6 nd6, UP5 up5) {
        String transportParam = nd6.isSecure() ? ParameterNames.TLS : nd6.getTransportParam();
        if (transportParam == null) {
            InterfaceC18318oS7 interfaceC18318oS7 = (InterfaceC18318oS7) up5.getHeader(SIPHeaderNames.VIA);
            if (interfaceC18318oS7 != null) {
                transportParam = interfaceC18318oS7.getTransport();
            }
            if (transportParam == null) {
                transportParam = "UDP";
            }
        }
        return this.sipStack.getAddressResolver().resolveAddress(new HopImpl(nd6.getMAddrParam() != null ? nd6.getMAddrParam() : nd6.getHost(), nd6.getPort() != -1 ? nd6.getPort() : transportParam.equalsIgnoreCase(ParameterNames.TLS) ? SIPConstants.DEFAULT_TLS_PORT : SIPConstants.DEFAULT_PORT, transportParam));
    }

    public void fixStrictRouting(SIPRequest sIPRequest) {
        RouteList routeHeaders = sIPRequest.getRouteHeaders();
        SipUri sipUri = (SipUri) ((Route) routeHeaders.getFirst()).getAddress().getURI();
        routeHeaders.removeFirst();
        AddressImpl addressImpl = new AddressImpl();
        addressImpl.setAddess(sIPRequest.getRequestURI());
        routeHeaders.add((RouteList) new Route(addressImpl));
        sIPRequest.setRequestURI(sipUri);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("post: fixStrictRouting" + sIPRequest);
        }
    }

    @Override // ir.nasim.W46
    public FY2 getNextHop(UP5 up5) throws SipException {
        SIPRequest sIPRequest = (SIPRequest) up5;
        RequestLine requestLine = sIPRequest.getRequestLine();
        if (requestLine == null) {
            return this.defaultRoute;
        }
        InterfaceC21815uA7 uri = requestLine.getUri();
        if (uri == null) {
            throw new IllegalArgumentException("Bad message: Null requestURI");
        }
        RouteList routeHeaders = sIPRequest.getRouteHeaders();
        if (routeHeaders != null && routeHeaders.getFirst() != null) {
            InterfaceC21815uA7 uri2 = ((Route) routeHeaders.getFirst()).getAddress().getURI();
            if (!uri2.isSipURI()) {
                throw new SipException("First Route not a SIP URI");
            }
            ND6 nd6 = (ND6) uri2;
            if (!nd6.hasLrParam()) {
                fixStrictRouting(sIPRequest);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Route post processing fixed strict routing");
                }
            }
            FY2 fy2CreateHop = createHop(nd6, up5);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("NextHop based on Route:" + fy2CreateHop);
            }
            return fy2CreateHop;
        }
        if (uri.isSipURI()) {
            ND6 nd62 = (ND6) uri;
            if (nd62.getMAddrParam() != null) {
                FY2 fy2CreateHop2 = createHop(nd62, up5);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Using request URI maddr to route the request = " + fy2CreateHop2.toString());
                }
                return fy2CreateHop2;
            }
        }
        if (this.defaultRoute != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Using outbound proxy to route the request = " + this.defaultRoute.toString());
            }
            return this.defaultRoute;
        }
        if (!uri.isSipURI()) {
            InternalErrorHandler.handleException("Unexpected non-sip URI", logger);
            return null;
        }
        FY2 fy2CreateHop3 = createHop((ND6) uri, up5);
        if (fy2CreateHop3 != null && logger.isLoggingEnabled(32)) {
            logger.logDebug("Used request-URI for nextHop = " + fy2CreateHop3.toString());
        } else if (logger.isLoggingEnabled(32)) {
            logger.logDebug("returning null hop -- loop detected");
        }
        return fy2CreateHop3;
    }

    public ListIterator getNextHops(UP5 up5) {
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(getNextHop(up5));
            return linkedList.listIterator();
        } catch (SipException unused) {
            return null;
        }
    }

    @Override // ir.nasim.W46
    public FY2 getOutboundProxy() {
        return this.defaultRoute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultRouter(MD6 md6, String str) {
        SIPTransactionStack sIPTransactionStack = (SIPTransactionStack) md6;
        this.sipStack = sIPTransactionStack;
        if (str != null) {
            try {
                this.defaultRoute = sIPTransactionStack.getAddressResolver().resolveAddress(new HopImpl(str));
            } catch (IllegalArgumentException e) {
                logger.logError("Invalid default route specification - need host:port/transport");
                throw e;
            }
        }
    }
}
