package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.SIPHeaderNamesCache;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import android.gov.nist.javax.sip.parser.extensions.JoinParser;
import android.gov.nist.javax.sip.parser.extensions.MinSEParser;
import android.gov.nist.javax.sip.parser.extensions.ReferencesParser;
import android.gov.nist.javax.sip.parser.extensions.ReferredByParser;
import android.gov.nist.javax.sip.parser.extensions.ReplacesParser;
import android.gov.nist.javax.sip.parser.extensions.SessionExpiresParser;
import android.gov.nist.javax.sip.parser.ims.PAccessNetworkInfoParser;
import android.gov.nist.javax.sip.parser.ims.PAssertedIdentityParser;
import android.gov.nist.javax.sip.parser.ims.PAssertedServiceParser;
import android.gov.nist.javax.sip.parser.ims.PAssociatedURIParser;
import android.gov.nist.javax.sip.parser.ims.PCalledPartyIDParser;
import android.gov.nist.javax.sip.parser.ims.PChargingFunctionAddressesParser;
import android.gov.nist.javax.sip.parser.ims.PChargingVectorParser;
import android.gov.nist.javax.sip.parser.ims.PMediaAuthorizationParser;
import android.gov.nist.javax.sip.parser.ims.PPreferredIdentityParser;
import android.gov.nist.javax.sip.parser.ims.PPreferredServiceParser;
import android.gov.nist.javax.sip.parser.ims.PProfileKeyParser;
import android.gov.nist.javax.sip.parser.ims.PServedUserParser;
import android.gov.nist.javax.sip.parser.ims.PUserDatabaseParser;
import android.gov.nist.javax.sip.parser.ims.PVisitedNetworkIDParser;
import android.gov.nist.javax.sip.parser.ims.PathParser;
import android.gov.nist.javax.sip.parser.ims.PrivacyParser;
import android.gov.nist.javax.sip.parser.ims.SecurityClientParser;
import android.gov.nist.javax.sip.parser.ims.SecurityServerParser;
import android.gov.nist.javax.sip.parser.ims.SecurityVerifyParser;
import android.gov.nist.javax.sip.parser.ims.ServiceRouteParser;
import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class ParserFactory {
    private static Map<String, Class<? extends HeaderParser>> parserTable = new ConcurrentHashMap(90);
    private static ConcurrentHashMap<Class, Constructor> parserConstructorCache = new ConcurrentHashMap<>();
    private static Class[] constructorArgs = {String.class};

    static {
        parserTable.put(SIPHeaderNames.REPLY_TO.toLowerCase(), ReplyToParser.class);
        parserTable.put(SIPHeaderNames.IN_REPLY_TO.toLowerCase(), InReplyToParser.class);
        parserTable.put(SIPHeaderNames.ACCEPT_ENCODING.toLowerCase(), AcceptEncodingParser.class);
        parserTable.put(SIPHeaderNames.ACCEPT_LANGUAGE.toLowerCase(), AcceptLanguageParser.class);
        parserTable.put("t", ToParser.class);
        parserTable.put(SIPHeaderNames.TO.toLowerCase(), ToParser.class);
        parserTable.put(SIPHeaderNames.FROM.toLowerCase(), FromParser.class);
        parserTable.put("f", FromParser.class);
        parserTable.put(SIPHeaderNames.CSEQ.toLowerCase(), CSeqParser.class);
        parserTable.put(SIPHeaderNames.VIA.toLowerCase(), ViaParser.class);
        parserTable.put("v", ViaParser.class);
        parserTable.put(SIPHeaderNames.CONTACT.toLowerCase(), ContactParser.class);
        parserTable.put("m", ContactParser.class);
        parserTable.put(SIPHeaderNames.CONTENT_TYPE.toLowerCase(), ContentTypeParser.class);
        parserTable.put("c", ContentTypeParser.class);
        parserTable.put(SIPHeaderNames.CONTENT_LENGTH.toLowerCase(), ContentLengthParser.class);
        parserTable.put("l", ContentLengthParser.class);
        parserTable.put(SIPHeaderNames.AUTHORIZATION.toLowerCase(), AuthorizationParser.class);
        parserTable.put(SIPHeaderNames.WWW_AUTHENTICATE.toLowerCase(), WWWAuthenticateParser.class);
        parserTable.put(SIPHeaderNames.CALL_ID.toLowerCase(), CallIDParser.class);
        parserTable.put("i", CallIDParser.class);
        parserTable.put(SIPHeaderNames.ROUTE.toLowerCase(), RouteParser.class);
        parserTable.put(SIPHeaderNames.RECORD_ROUTE.toLowerCase(), RecordRouteParser.class);
        parserTable.put(SIPHeaderNames.DATE.toLowerCase(), DateParser.class);
        parserTable.put(SIPHeaderNames.PROXY_AUTHORIZATION.toLowerCase(), ProxyAuthorizationParser.class);
        parserTable.put(SIPHeaderNames.PROXY_AUTHENTICATE.toLowerCase(), ProxyAuthenticateParser.class);
        parserTable.put(SIPHeaderNames.RETRY_AFTER.toLowerCase(), RetryAfterParser.class);
        parserTable.put(SIPHeaderNames.REQUIRE.toLowerCase(), RequireParser.class);
        parserTable.put(SIPHeaderNames.PROXY_REQUIRE.toLowerCase(), ProxyRequireParser.class);
        parserTable.put(SIPHeaderNames.TIMESTAMP.toLowerCase(), TimeStampParser.class);
        parserTable.put(SIPHeaderNames.UNSUPPORTED.toLowerCase(), UnsupportedParser.class);
        parserTable.put(SIPHeaderNames.USER_AGENT.toLowerCase(), UserAgentParser.class);
        parserTable.put(SIPHeaderNames.SUPPORTED.toLowerCase(), SupportedParser.class);
        parserTable.put("k", SupportedParser.class);
        parserTable.put(SIPHeaderNames.SERVER.toLowerCase(), ServerParser.class);
        parserTable.put(SIPHeaderNames.SUBJECT.toLowerCase(), SubjectParser.class);
        parserTable.put("s", SubjectParser.class);
        parserTable.put(SIPHeaderNames.SUBSCRIPTION_STATE.toLowerCase(), SubscriptionStateParser.class);
        parserTable.put(SIPHeaderNames.MAX_FORWARDS.toLowerCase(), MaxForwardsParser.class);
        parserTable.put(SIPHeaderNames.MIME_VERSION.toLowerCase(), MimeVersionParser.class);
        parserTable.put(SIPHeaderNames.MIN_EXPIRES.toLowerCase(), MinExpiresParser.class);
        parserTable.put(SIPHeaderNames.ORGANIZATION.toLowerCase(), OrganizationParser.class);
        parserTable.put(SIPHeaderNames.PRIORITY.toLowerCase(), PriorityParser.class);
        parserTable.put(SIPHeaderNames.RACK.toLowerCase(), RAckParser.class);
        parserTable.put(SIPHeaderNames.RSEQ.toLowerCase(), RSeqParser.class);
        parserTable.put(SIPHeaderNames.REASON.toLowerCase(), ReasonParser.class);
        parserTable.put(SIPHeaderNames.WARNING.toLowerCase(), WarningParser.class);
        parserTable.put(SIPHeaderNames.EXPIRES.toLowerCase(), ExpiresParser.class);
        parserTable.put(SIPHeaderNames.EVENT.toLowerCase(), EventParser.class);
        parserTable.put("o", EventParser.class);
        parserTable.put(SIPHeaderNames.ERROR_INFO.toLowerCase(), ErrorInfoParser.class);
        parserTable.put(SIPHeaderNames.CONTENT_LANGUAGE.toLowerCase(), ContentLanguageParser.class);
        parserTable.put(SIPHeaderNames.CONTENT_ENCODING.toLowerCase(), ContentEncodingParser.class);
        parserTable.put("e", ContentEncodingParser.class);
        parserTable.put(SIPHeaderNames.CONTENT_DISPOSITION.toLowerCase(), ContentDispositionParser.class);
        parserTable.put(SIPHeaderNames.CALL_INFO.toLowerCase(), CallInfoParser.class);
        parserTable.put(SIPHeaderNames.AUTHENTICATION_INFO.toLowerCase(), AuthenticationInfoParser.class);
        parserTable.put(SIPHeaderNames.ALLOW.toLowerCase(), AllowParser.class);
        parserTable.put(SIPHeaderNames.ALLOW_EVENTS.toLowerCase(), AllowEventsParser.class);
        parserTable.put("u", AllowEventsParser.class);
        parserTable.put(SIPHeaderNames.ALERT_INFO.toLowerCase(), AlertInfoParser.class);
        parserTable.put(SIPHeaderNames.ACCEPT.toLowerCase(), AcceptParser.class);
        parserTable.put("Refer-To".toLowerCase(), ReferToParser.class);
        parserTable.put("r", ReferToParser.class);
        parserTable.put(SIPHeaderNames.SIP_ETAG.toLowerCase(), SIPETagParser.class);
        parserTable.put(SIPHeaderNames.SIP_IF_MATCH.toLowerCase(), SIPIfMatchParser.class);
        parserTable.put("P-Access-Network-Info".toLowerCase(), PAccessNetworkInfoParser.class);
        parserTable.put("P-Asserted-Identity".toLowerCase(), PAssertedIdentityParser.class);
        parserTable.put("P-Preferred-Identity".toLowerCase(), PPreferredIdentityParser.class);
        parserTable.put("P-Charging-Vector".toLowerCase(), PChargingVectorParser.class);
        parserTable.put("P-Charging-Function-Addresses".toLowerCase(), PChargingFunctionAddressesParser.class);
        parserTable.put("P-Media-Authorization".toLowerCase(), PMediaAuthorizationParser.class);
        parserTable.put("Path".toLowerCase(), PathParser.class);
        parserTable.put("Privacy".toLowerCase(), PrivacyParser.class);
        parserTable.put("Service-Route".toLowerCase(), ServiceRouteParser.class);
        parserTable.put("P-Visited-Network-ID".toLowerCase(), PVisitedNetworkIDParser.class);
        parserTable.put("P-Served-User".toLowerCase(), PServedUserParser.class);
        parserTable.put("P-Preferred-Service".toLowerCase(), PPreferredServiceParser.class);
        parserTable.put("P-Asserted-Service".toLowerCase(), PAssertedServiceParser.class);
        parserTable.put("P-Profile-Key".toLowerCase(), PProfileKeyParser.class);
        parserTable.put("P-User-Database".toLowerCase(), PUserDatabaseParser.class);
        parserTable.put("P-Associated-URI".toLowerCase(), PAssociatedURIParser.class);
        parserTable.put("P-Called-Party-ID".toLowerCase(), PCalledPartyIDParser.class);
        parserTable.put("Security-Server".toLowerCase(), SecurityServerParser.class);
        parserTable.put("Security-Client".toLowerCase(), SecurityClientParser.class);
        parserTable.put("Security-Verify".toLowerCase(), SecurityVerifyParser.class);
        parserTable.put("Referred-By".toLowerCase(), ReferredByParser.class);
        parserTable.put("b", ReferToParser.class);
        parserTable.put("Session-Expires".toLowerCase(), SessionExpiresParser.class);
        parserTable.put("x", SessionExpiresParser.class);
        parserTable.put("Min-SE".toLowerCase(), MinSEParser.class);
        parserTable.put("Replaces".toLowerCase(), ReplacesParser.class);
        parserTable.put("Join".toLowerCase(), JoinParser.class);
        parserTable.put(ReferencesHeader.NAME.toLowerCase(), ReferencesParser.class);
    }

    public static void addToParserTable(String str, Class<? extends HeaderParser> cls) {
        parserTable.put(str.toLowerCase(), cls);
    }

    public static HeaderParser createParser(String str) {
        String headerName = Lexer.getHeaderName(str);
        String headerValue = Lexer.getHeaderValue(str);
        if (headerName == null || headerValue == null) {
            throw new ParseException("The header name or value is null", 0);
        }
        Class<? extends HeaderParser> cls = parserTable.get(SIPHeaderNamesCache.toLowerCase(headerName));
        if (cls == null) {
            return new HeaderParser(str);
        }
        try {
            Constructor constructor = parserConstructorCache.get(cls);
            if (constructor == null) {
                constructor = cls.getConstructor(constructorArgs);
                parserConstructorCache.putIfAbsent(cls, constructor);
            }
            return constructor.newInstance(str);
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
            return null;
        }
    }
}
