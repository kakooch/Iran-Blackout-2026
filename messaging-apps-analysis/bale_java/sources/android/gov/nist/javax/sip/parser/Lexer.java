package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.LexerCore;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class Lexer extends LexerCore {
    public Lexer(String str, String str2) {
        super(str, str2);
        selectLexer(str);
    }

    public static String getHeaderName(String str) {
        if (str == null) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf >= 1) {
                return str.substring(0, iIndexOf).trim();
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static String getHeaderValue(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.substring(str.indexOf(":") + 1);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // android.gov.nist.core.LexerCore
    public void selectLexer(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> concurrentHashMap = LexerCore.lexerTables;
        ConcurrentHashMap<String, Integer> concurrentHashMap2 = concurrentHashMap.get(str);
        this.currentLexerName = str;
        if (concurrentHashMap2 != null) {
            this.currentLexer = concurrentHashMap2;
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap3 = new ConcurrentHashMap<>();
        this.currentLexer = concurrentHashMap3;
        if (str.equals("method_keywordLexer")) {
            addKeyword(TokenNames.REGISTER, TokenTypes.REGISTER);
            addKeyword(TokenNames.ACK, TokenTypes.ACK);
            addKeyword(TokenNames.OPTIONS, TokenTypes.OPTIONS);
            addKeyword(TokenNames.BYE, TokenTypes.BYE);
            addKeyword(TokenNames.INVITE, TokenTypes.INVITE);
            addKeyword("sip", TokenTypes.SIP);
            addKeyword("sips", TokenTypes.SIPS);
            addKeyword(TokenNames.SUBSCRIBE, TokenTypes.SUBSCRIBE);
            addKeyword(TokenNames.NOTIFY, TokenTypes.NOTIFY);
            addKeyword(TokenNames.MESSAGE, TokenTypes.MESSAGE);
            addKeyword(TokenNames.PUBLISH, TokenTypes.PUBLISH);
        } else if (str.equals("command_keywordLexer")) {
            addKeyword(SIPHeaderNames.ERROR_INFO, TokenTypes.ERROR_INFO);
            addKeyword(SIPHeaderNames.ALLOW_EVENTS, TokenTypes.ALLOW_EVENTS);
            addKeyword(SIPHeaderNames.AUTHENTICATION_INFO, TokenTypes.AUTHENTICATION_INFO);
            addKeyword(SIPHeaderNames.EVENT, TokenTypes.EVENT);
            addKeyword(SIPHeaderNames.MIN_EXPIRES, TokenTypes.MIN_EXPIRES);
            addKeyword(SIPHeaderNames.RSEQ, TokenTypes.RSEQ);
            addKeyword(SIPHeaderNames.RACK, TokenTypes.RACK);
            addKeyword(SIPHeaderNames.REASON, TokenTypes.REASON);
            addKeyword(SIPHeaderNames.REPLY_TO, TokenTypes.REPLY_TO);
            addKeyword(SIPHeaderNames.SUBSCRIPTION_STATE, TokenTypes.SUBSCRIPTION_STATE);
            addKeyword(SIPHeaderNames.TIMESTAMP, TokenTypes.TIMESTAMP);
            addKeyword(SIPHeaderNames.IN_REPLY_TO, TokenTypes.IN_REPLY_TO);
            addKeyword(SIPHeaderNames.MIME_VERSION, TokenTypes.MIME_VERSION);
            addKeyword(SIPHeaderNames.ALERT_INFO, TokenTypes.ALERT_INFO);
            addKeyword(SIPHeaderNames.FROM, TokenTypes.FROM);
            addKeyword(SIPHeaderNames.TO, TokenTypes.TO);
            addKeyword("Refer-To", TokenTypes.REFER_TO);
            addKeyword(SIPHeaderNames.VIA, TokenTypes.VIA);
            addKeyword(SIPHeaderNames.USER_AGENT, TokenTypes.USER_AGENT);
            addKeyword(SIPHeaderNames.SERVER, TokenTypes.SERVER);
            addKeyword(SIPHeaderNames.ACCEPT_ENCODING, TokenTypes.ACCEPT_ENCODING);
            addKeyword(SIPHeaderNames.ACCEPT, 2068);
            addKeyword(SIPHeaderNames.ALLOW, TokenTypes.ALLOW);
            addKeyword(SIPHeaderNames.ROUTE, TokenTypes.ROUTE);
            addKeyword(SIPHeaderNames.AUTHORIZATION, TokenTypes.AUTHORIZATION);
            addKeyword(SIPHeaderNames.PROXY_AUTHORIZATION, TokenTypes.PROXY_AUTHORIZATION);
            addKeyword(SIPHeaderNames.RETRY_AFTER, TokenTypes.RETRY_AFTER);
            addKeyword(SIPHeaderNames.PROXY_REQUIRE, TokenTypes.PROXY_REQUIRE);
            addKeyword(SIPHeaderNames.CONTENT_LANGUAGE, TokenTypes.CONTENT_LANGUAGE);
            addKeyword(SIPHeaderNames.UNSUPPORTED, TokenTypes.UNSUPPORTED);
            addKeyword(SIPHeaderNames.SUPPORTED, 2068);
            addKeyword(SIPHeaderNames.WARNING, TokenTypes.WARNING);
            addKeyword(SIPHeaderNames.MAX_FORWARDS, TokenTypes.MAX_FORWARDS);
            addKeyword(SIPHeaderNames.DATE, TokenTypes.DATE);
            addKeyword(SIPHeaderNames.PRIORITY, TokenTypes.PRIORITY);
            addKeyword(SIPHeaderNames.PROXY_AUTHENTICATE, TokenTypes.PROXY_AUTHENTICATE);
            addKeyword(SIPHeaderNames.CONTENT_ENCODING, TokenTypes.CONTENT_ENCODING);
            addKeyword(SIPHeaderNames.CONTENT_LENGTH, TokenTypes.CONTENT_LENGTH);
            addKeyword(SIPHeaderNames.SUBJECT, TokenTypes.SUBJECT);
            addKeyword(SIPHeaderNames.CONTENT_TYPE, TokenTypes.CONTENT_TYPE);
            addKeyword(SIPHeaderNames.CONTACT, TokenTypes.CONTACT);
            addKeyword(SIPHeaderNames.CALL_ID, TokenTypes.CALL_ID);
            addKeyword(SIPHeaderNames.REQUIRE, TokenTypes.REQUIRE);
            addKeyword(SIPHeaderNames.EXPIRES, TokenTypes.EXPIRES);
            addKeyword(SIPHeaderNames.RECORD_ROUTE, TokenTypes.RECORD_ROUTE);
            addKeyword(SIPHeaderNames.ORGANIZATION, TokenTypes.ORGANIZATION);
            addKeyword(SIPHeaderNames.CSEQ, TokenTypes.CSEQ);
            addKeyword(SIPHeaderNames.ACCEPT_LANGUAGE, TokenTypes.ACCEPT_LANGUAGE);
            addKeyword(SIPHeaderNames.WWW_AUTHENTICATE, TokenTypes.WWW_AUTHENTICATE);
            addKeyword(SIPHeaderNames.CALL_INFO, TokenTypes.CALL_INFO);
            addKeyword(SIPHeaderNames.CONTENT_DISPOSITION, TokenTypes.CONTENT_DISPOSITION);
            addKeyword(TokenNames.K, 2068);
            addKeyword(TokenNames.C, TokenTypes.CONTENT_TYPE);
            addKeyword(TokenNames.E, TokenTypes.CONTENT_ENCODING);
            addKeyword(TokenNames.F, TokenTypes.FROM);
            addKeyword(TokenNames.I, TokenTypes.CALL_ID);
            addKeyword(TokenNames.M, TokenTypes.CONTACT);
            addKeyword(TokenNames.L, TokenTypes.CONTENT_LENGTH);
            addKeyword(TokenNames.S, TokenTypes.SUBJECT);
            addKeyword(TokenNames.T, TokenTypes.TO);
            addKeyword(TokenNames.U, TokenTypes.ALLOW_EVENTS);
            addKeyword(TokenNames.V, TokenTypes.VIA);
            addKeyword(TokenNames.R, TokenTypes.REFER_TO);
            addKeyword(TokenNames.O, TokenTypes.EVENT);
            addKeyword(TokenNames.X, TokenTypes.SESSIONEXPIRES_TO);
            addKeyword(SIPHeaderNames.SIP_ETAG, TokenTypes.SIP_ETAG);
            addKeyword(SIPHeaderNames.SIP_IF_MATCH, TokenTypes.SIP_IF_MATCH);
            addKeyword("Session-Expires", TokenTypes.SESSIONEXPIRES_TO);
            addKeyword("Min-SE", TokenTypes.MINSE_TO);
            addKeyword("Referred-By", TokenTypes.REFERREDBY_TO);
            addKeyword("Replaces", TokenTypes.REPLACES_TO);
            addKeyword("Join", TokenTypes.JOIN_TO);
            addKeyword("Path", TokenTypes.PATH);
            addKeyword("Service-Route", TokenTypes.SERVICE_ROUTE);
            addKeyword("P-Asserted-Identity", TokenTypes.P_ASSERTED_IDENTITY);
            addKeyword("P-Preferred-Identity", TokenTypes.P_PREFERRED_IDENTITY);
            addKeyword("Privacy", TokenTypes.PRIVACY);
            addKeyword("P-Called-Party-ID", TokenTypes.P_CALLED_PARTY_ID);
            addKeyword("P-Associated-URI", TokenTypes.P_ASSOCIATED_URI);
            addKeyword("P-Visited-Network-ID", TokenTypes.P_VISITED_NETWORK_ID);
            addKeyword("P-Charging-Function-Addresses", TokenTypes.P_CHARGING_FUNCTION_ADDRESSES);
            addKeyword("P-Charging-Vector", TokenTypes.P_VECTOR_CHARGING);
            addKeyword("P-Access-Network-Info", TokenTypes.P_ACCESS_NETWORK_INFO);
            addKeyword("P-Media-Authorization", TokenTypes.P_MEDIA_AUTHORIZATION);
            addKeyword("Security-Server", TokenTypes.SECURITY_SERVER);
            addKeyword("Security-Verify", TokenTypes.SECURITY_VERIFY);
            addKeyword("Security-Client", TokenTypes.SECURITY_CLIENT);
            addKeyword("P-User-Database", TokenTypes.P_USER_DATABASE);
            addKeyword("P-Profile-Key", TokenTypes.P_PROFILE_KEY);
            addKeyword("P-Served-User", TokenTypes.P_SERVED_USER);
            addKeyword("P-Preferred-Service", TokenTypes.P_PREFERRED_SERVICE);
            addKeyword("P-Asserted-Service", TokenTypes.P_ASSERTED_SERVICE);
            addKeyword(ReferencesHeader.NAME, TokenTypes.REFERENCES);
        } else if (str.equals("status_lineLexer") || str.equals("request_lineLexer")) {
            addKeyword("sip", TokenTypes.SIP);
        } else if (str.equals("sip_urlLexer")) {
            addKeyword("tel", TokenTypes.TEL);
            addKeyword("sip", TokenTypes.SIP);
            addKeyword("sips", TokenTypes.SIPS);
        }
        ConcurrentHashMap<String, Integer> concurrentHashMapPutIfAbsent = concurrentHashMap.putIfAbsent(str, concurrentHashMap3);
        if (concurrentHashMapPutIfAbsent != null) {
            concurrentHashMap3 = concurrentHashMapPutIfAbsent;
        }
        this.currentLexer = concurrentHashMap3;
    }
}
