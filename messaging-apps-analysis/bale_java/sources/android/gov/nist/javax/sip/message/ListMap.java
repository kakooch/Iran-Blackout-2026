package android.gov.nist.javax.sip.message;

import android.gov.nist.javax.sip.header.Accept;
import android.gov.nist.javax.sip.header.AcceptEncoding;
import android.gov.nist.javax.sip.header.AcceptEncodingList;
import android.gov.nist.javax.sip.header.AcceptLanguage;
import android.gov.nist.javax.sip.header.AcceptLanguageList;
import android.gov.nist.javax.sip.header.AcceptList;
import android.gov.nist.javax.sip.header.AlertInfo;
import android.gov.nist.javax.sip.header.AlertInfoList;
import android.gov.nist.javax.sip.header.Allow;
import android.gov.nist.javax.sip.header.AllowEvents;
import android.gov.nist.javax.sip.header.AllowEventsList;
import android.gov.nist.javax.sip.header.AllowList;
import android.gov.nist.javax.sip.header.Authorization;
import android.gov.nist.javax.sip.header.AuthorizationList;
import android.gov.nist.javax.sip.header.CallInfo;
import android.gov.nist.javax.sip.header.CallInfoList;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.ContactList;
import android.gov.nist.javax.sip.header.ContentEncoding;
import android.gov.nist.javax.sip.header.ContentEncodingList;
import android.gov.nist.javax.sip.header.ContentLanguage;
import android.gov.nist.javax.sip.header.ContentLanguageList;
import android.gov.nist.javax.sip.header.ErrorInfo;
import android.gov.nist.javax.sip.header.ErrorInfoList;
import android.gov.nist.javax.sip.header.ExtensionHeaderImpl;
import android.gov.nist.javax.sip.header.ExtensionHeaderList;
import android.gov.nist.javax.sip.header.InReplyTo;
import android.gov.nist.javax.sip.header.InReplyToList;
import android.gov.nist.javax.sip.header.ProxyAuthenticate;
import android.gov.nist.javax.sip.header.ProxyAuthenticateList;
import android.gov.nist.javax.sip.header.ProxyAuthorization;
import android.gov.nist.javax.sip.header.ProxyAuthorizationList;
import android.gov.nist.javax.sip.header.ProxyRequire;
import android.gov.nist.javax.sip.header.ProxyRequireList;
import android.gov.nist.javax.sip.header.Reason;
import android.gov.nist.javax.sip.header.ReasonList;
import android.gov.nist.javax.sip.header.RecordRoute;
import android.gov.nist.javax.sip.header.RecordRouteList;
import android.gov.nist.javax.sip.header.Require;
import android.gov.nist.javax.sip.header.RequireList;
import android.gov.nist.javax.sip.header.Route;
import android.gov.nist.javax.sip.header.RouteList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderList;
import android.gov.nist.javax.sip.header.Supported;
import android.gov.nist.javax.sip.header.SupportedList;
import android.gov.nist.javax.sip.header.Unsupported;
import android.gov.nist.javax.sip.header.UnsupportedList;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.header.ViaList;
import android.gov.nist.javax.sip.header.WWWAuthenticate;
import android.gov.nist.javax.sip.header.WWWAuthenticateList;
import android.gov.nist.javax.sip.header.Warning;
import android.gov.nist.javax.sip.header.WarningList;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentity;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import android.gov.nist.javax.sip.header.ims.PAssociatedURI;
import android.gov.nist.javax.sip.header.ims.PAssociatedURIList;
import android.gov.nist.javax.sip.header.ims.PMediaAuthorization;
import android.gov.nist.javax.sip.header.ims.PMediaAuthorizationList;
import android.gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import android.gov.nist.javax.sip.header.ims.PVisitedNetworkIDList;
import android.gov.nist.javax.sip.header.ims.Path;
import android.gov.nist.javax.sip.header.ims.PathList;
import android.gov.nist.javax.sip.header.ims.Privacy;
import android.gov.nist.javax.sip.header.ims.PrivacyList;
import android.gov.nist.javax.sip.header.ims.SecurityClient;
import android.gov.nist.javax.sip.header.ims.SecurityClientList;
import android.gov.nist.javax.sip.header.ims.SecurityServer;
import android.gov.nist.javax.sip.header.ims.SecurityServerList;
import android.gov.nist.javax.sip.header.ims.SecurityVerify;
import android.gov.nist.javax.sip.header.ims.SecurityVerifyList;
import android.gov.nist.javax.sip.header.ims.ServiceRoute;
import android.gov.nist.javax.sip.header.ims.ServiceRouteList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ListMap {
    private static Map<Class<?>, Class<?>> headerListTable;
    private static boolean initialized;

    static {
        initializeListMap();
    }

    public static void addListHeader(Class<? extends SIPHeader> cls, Class<? extends SIPHeaderList<? extends SIPHeader>> cls2) {
        headerListTable.put(cls, cls2);
    }

    public static SIPHeaderList<SIPHeader> getList(SIPHeader sIPHeader) {
        if (!initialized) {
            initializeListMap();
        }
        try {
            SIPHeaderList<SIPHeader> sIPHeaderList = (SIPHeaderList) headerListTable.get(sIPHeader.getClass()).newInstance();
            sIPHeaderList.setHeaderName(sIPHeader.getName());
            return sIPHeaderList;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Class<?> getListClass(Class<?> cls) {
        if (!initialized) {
            initializeListMap();
        }
        return headerListTable.get(cls);
    }

    public static boolean hasList(SIPHeader sIPHeader) {
        if (sIPHeader instanceof SIPHeaderList) {
            return false;
        }
        return headerListTable.get(sIPHeader.getClass()) != null;
    }

    private static void initializeListMap() {
        HashMap map = new HashMap(34);
        headerListTable = map;
        map.put(ExtensionHeaderImpl.class, ExtensionHeaderList.class);
        headerListTable.put(Contact.class, ContactList.class);
        headerListTable.put(ContentEncoding.class, ContentEncodingList.class);
        headerListTable.put(Via.class, ViaList.class);
        headerListTable.put(WWWAuthenticate.class, WWWAuthenticateList.class);
        headerListTable.put(Accept.class, AcceptList.class);
        headerListTable.put(AcceptEncoding.class, AcceptEncodingList.class);
        headerListTable.put(AcceptLanguage.class, AcceptLanguageList.class);
        headerListTable.put(ProxyRequire.class, ProxyRequireList.class);
        headerListTable.put(Route.class, RouteList.class);
        headerListTable.put(Require.class, RequireList.class);
        headerListTable.put(Warning.class, WarningList.class);
        headerListTable.put(Unsupported.class, UnsupportedList.class);
        headerListTable.put(AlertInfo.class, AlertInfoList.class);
        headerListTable.put(CallInfo.class, CallInfoList.class);
        headerListTable.put(ProxyAuthenticate.class, ProxyAuthenticateList.class);
        headerListTable.put(ProxyAuthorization.class, ProxyAuthorizationList.class);
        headerListTable.put(Authorization.class, AuthorizationList.class);
        headerListTable.put(Allow.class, AllowList.class);
        headerListTable.put(AllowEvents.class, AllowEventsList.class);
        headerListTable.put(RecordRoute.class, RecordRouteList.class);
        headerListTable.put(ContentLanguage.class, ContentLanguageList.class);
        headerListTable.put(ErrorInfo.class, ErrorInfoList.class);
        headerListTable.put(Supported.class, SupportedList.class);
        headerListTable.put(InReplyTo.class, InReplyToList.class);
        headerListTable.put(PAssociatedURI.class, PAssociatedURIList.class);
        headerListTable.put(PMediaAuthorization.class, PMediaAuthorizationList.class);
        headerListTable.put(Path.class, PathList.class);
        headerListTable.put(Privacy.class, PrivacyList.class);
        headerListTable.put(ServiceRoute.class, ServiceRouteList.class);
        headerListTable.put(PVisitedNetworkID.class, PVisitedNetworkIDList.class);
        headerListTable.put(SecurityClient.class, SecurityClientList.class);
        headerListTable.put(SecurityServer.class, SecurityServerList.class);
        headerListTable.put(SecurityVerify.class, SecurityVerifyList.class);
        headerListTable.put(PAssertedIdentity.class, PAssertedIdentityList.class);
        headerListTable.put(Reason.class, ReasonList.class);
        initialized = true;
    }

    public static boolean hasList(Class<?> cls) {
        if (!initialized) {
            initializeListMap();
        }
        return headerListTable.get(cls) != null;
    }
}
