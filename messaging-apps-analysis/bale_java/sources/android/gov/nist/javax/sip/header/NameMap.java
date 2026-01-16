package android.gov.nist.javax.sip.header;

import android.gov.nist.core.PackageNames;
import android.gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentity;
import android.gov.nist.javax.sip.header.ims.PAssociatedURI;
import android.gov.nist.javax.sip.header.ims.PCalledPartyID;
import android.gov.nist.javax.sip.header.ims.PChargingFunctionAddresses;
import android.gov.nist.javax.sip.header.ims.PChargingVector;
import android.gov.nist.javax.sip.header.ims.PMediaAuthorization;
import android.gov.nist.javax.sip.header.ims.PPreferredIdentity;
import android.gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import android.gov.nist.javax.sip.header.ims.Path;
import android.gov.nist.javax.sip.header.ims.Privacy;
import android.gov.nist.javax.sip.header.ims.ServiceRoute;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class NameMap implements SIPHeaderNames, PackageNames {
    static Map<String, String> nameMap;

    static {
        initializeNameMap();
    }

    public static void addExtensionHeader(String str, String str2) {
        nameMap.put(str.toLowerCase(), str2);
    }

    public static Class getClassFromName(String str) {
        String str2 = nameMap.get(str.toLowerCase());
        if (str2 == null) {
            return null;
        }
        try {
            return Class.forName(str2);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void initializeNameMap() {
        nameMap = new HashMap(63);
        putNameMap(SIPHeaderNames.MIN_EXPIRES, MinExpires.class.getName());
        putNameMap(SIPHeaderNames.ERROR_INFO, ErrorInfo.class.getName());
        putNameMap(SIPHeaderNames.MIME_VERSION, MimeVersion.class.getName());
        putNameMap(SIPHeaderNames.IN_REPLY_TO, InReplyTo.class.getName());
        putNameMap(SIPHeaderNames.ALLOW, Allow.class.getName());
        putNameMap(SIPHeaderNames.CONTENT_LANGUAGE, ContentLanguage.class.getName());
        putNameMap(SIPHeaderNames.CALL_INFO, CallInfo.class.getName());
        putNameMap(SIPHeaderNames.CSEQ, CSeq.class.getName());
        putNameMap(SIPHeaderNames.ALERT_INFO, AlertInfo.class.getName());
        putNameMap(SIPHeaderNames.ACCEPT_ENCODING, AcceptEncoding.class.getName());
        putNameMap(SIPHeaderNames.ACCEPT, Accept.class.getName());
        putNameMap(SIPHeaderNames.ACCEPT_LANGUAGE, AcceptLanguage.class.getName());
        putNameMap(SIPHeaderNames.RECORD_ROUTE, RecordRoute.class.getName());
        putNameMap(SIPHeaderNames.TIMESTAMP, TimeStamp.class.getName());
        putNameMap(SIPHeaderNames.TO, To.class.getName());
        putNameMap(SIPHeaderNames.VIA, Via.class.getName());
        putNameMap(SIPHeaderNames.FROM, From.class.getName());
        putNameMap(SIPHeaderNames.CALL_ID, CallID.class.getName());
        putNameMap(SIPHeaderNames.AUTHORIZATION, Authorization.class.getName());
        putNameMap(SIPHeaderNames.PROXY_AUTHENTICATE, ProxyAuthenticate.class.getName());
        putNameMap(SIPHeaderNames.SERVER, Server.class.getName());
        putNameMap(SIPHeaderNames.UNSUPPORTED, Unsupported.class.getName());
        putNameMap(SIPHeaderNames.RETRY_AFTER, RetryAfter.class.getName());
        putNameMap(SIPHeaderNames.CONTENT_TYPE, ContentType.class.getName());
        putNameMap(SIPHeaderNames.CONTENT_ENCODING, ContentEncoding.class.getName());
        putNameMap(SIPHeaderNames.CONTENT_LENGTH, ContentLength.class.getName());
        putNameMap(SIPHeaderNames.ROUTE, Route.class.getName());
        putNameMap(SIPHeaderNames.CONTACT, Contact.class.getName());
        putNameMap(SIPHeaderNames.WWW_AUTHENTICATE, WWWAuthenticate.class.getName());
        putNameMap(SIPHeaderNames.MAX_FORWARDS, MaxForwards.class.getName());
        putNameMap(SIPHeaderNames.ORGANIZATION, Organization.class.getName());
        putNameMap(SIPHeaderNames.PROXY_AUTHORIZATION, ProxyAuthorization.class.getName());
        putNameMap(SIPHeaderNames.PROXY_REQUIRE, ProxyRequire.class.getName());
        putNameMap(SIPHeaderNames.REQUIRE, Require.class.getName());
        putNameMap(SIPHeaderNames.CONTENT_DISPOSITION, ContentDisposition.class.getName());
        putNameMap(SIPHeaderNames.SUBJECT, Subject.class.getName());
        putNameMap(SIPHeaderNames.USER_AGENT, UserAgent.class.getName());
        putNameMap(SIPHeaderNames.WARNING, Warning.class.getName());
        putNameMap(SIPHeaderNames.PRIORITY, Priority.class.getName());
        putNameMap(SIPHeaderNames.DATE, SIPDateHeader.class.getName());
        putNameMap(SIPHeaderNames.EXPIRES, Expires.class.getName());
        putNameMap(SIPHeaderNames.SUPPORTED, Supported.class.getName());
        putNameMap(SIPHeaderNames.REPLY_TO, ReplyTo.class.getName());
        putNameMap(SIPHeaderNames.SUBSCRIPTION_STATE, SubscriptionState.class.getName());
        putNameMap(SIPHeaderNames.EVENT, Event.class.getName());
        putNameMap(SIPHeaderNames.ALLOW_EVENTS, AllowEvents.class.getName());
        putNameMap("Referred-By", "ReferredBy");
        putNameMap("Session-Expires", "SessionExpires");
        putNameMap("Min-SE", "MinSE");
        putNameMap("Replaces", "Replaces");
        putNameMap("Join", "Join");
        putNameMap("P-Access-Network-Info", PAccessNetworkInfo.class.getName());
        putNameMap("P-Asserted-Identity", PAssertedIdentity.class.getName());
        putNameMap("P-Associated-URI", PAssociatedURI.class.getName());
        putNameMap("P-Called-Party-ID", PCalledPartyID.class.getName());
        putNameMap("P-Charging-Function-Addresses", PChargingFunctionAddresses.class.getName());
        putNameMap("P-Charging-Vector", PChargingVector.class.getName());
        putNameMap("P-Media-Authorization", PMediaAuthorization.class.getName());
        putNameMap("Path", Path.class.getName());
        putNameMap("P-Preferred-Identity", PPreferredIdentity.class.getName());
        putNameMap("Privacy", Privacy.class.getName());
        putNameMap("Service-Route", ServiceRoute.class.getName());
        putNameMap("P-Visited-Network-ID", PVisitedNetworkID.class.getName());
    }

    protected static void putNameMap(String str, String str2) {
        nameMap.put(str.toLowerCase(), str2);
    }
}
