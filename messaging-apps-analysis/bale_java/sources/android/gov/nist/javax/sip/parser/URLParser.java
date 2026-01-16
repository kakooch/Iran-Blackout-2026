package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.HostNameParser;
import android.gov.nist.core.LexerCore;
import android.gov.nist.core.NameValue;
import android.gov.nist.core.NameValueList;
import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StringTokenizer;
import android.gov.nist.core.Token;
import android.gov.nist.javax.sip.address.GenericURI;
import android.gov.nist.javax.sip.address.SipUri;
import android.gov.nist.javax.sip.address.TelURLImpl;
import android.gov.nist.javax.sip.address.TelephoneNumber;
import java.io.PrintStream;
import java.text.ParseException;

/* loaded from: classes.dex */
public class URLParser extends Parser {
    public URLParser(String str) {
        this.lexer = new Lexer("sip_urlLexer", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        if (android.gov.nist.core.ParserCore.debug == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        dbg_leave("base_phone_number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String base_phone_number() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = android.gov.nist.core.ParserCore.debug
            java.lang.String r2 = "base_phone_number"
            if (r1 == 0) goto Le
            r7.dbg_enter(r2)
        Le:
            r1 = 0
            r3 = r1
        L10:
            android.gov.nist.core.LexerCore r4 = r7.lexer     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r4.hasMoreChars()     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L5c
            android.gov.nist.core.LexerCore r4 = r7.lexer     // Catch: java.lang.Throwable -> L4e
            char r4 = r4.lookAhead(r1)     // Catch: java.lang.Throwable -> L4e
            boolean r5 = android.gov.nist.core.StringTokenizer.isDigit(r4)     // Catch: java.lang.Throwable -> L4e
            if (r5 != 0) goto L50
            r5 = 45
            if (r4 == r5) goto L50
            r5 = 46
            if (r4 == r5) goto L50
            r5 = 40
            if (r4 == r5) goto L50
            r5 = 41
            if (r4 != r5) goto L35
            goto L50
        L35:
            if (r3 <= 0) goto L38
            goto L5c
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r0.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = "unexpected "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4e
            r0.append(r4)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4e
            java.text.ParseException r0 = r7.createParseException(r0)     // Catch: java.lang.Throwable -> L4e
            throw r0     // Catch: java.lang.Throwable -> L4e
        L4e:
            r0 = move-exception
            goto L68
        L50:
            android.gov.nist.core.LexerCore r5 = r7.lexer     // Catch: java.lang.Throwable -> L4e
            r6 = 1
            r5.consume(r6)     // Catch: java.lang.Throwable -> L4e
            r0.append(r4)     // Catch: java.lang.Throwable -> L4e
            int r3 = r3 + 1
            goto L10
        L5c:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4e
            boolean r1 = android.gov.nist.core.ParserCore.debug
            if (r1 == 0) goto L67
            r7.dbg_leave(r2)
        L67:
            return r0
        L68:
            boolean r1 = android.gov.nist.core.ParserCore.debug
            if (r1 == 0) goto L6f
            r7.dbg_leave(r2)
        L6f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.parser.URLParser.base_phone_number():java.lang.String");
    }

    private final TelephoneNumber global_phone_number(boolean z) {
        boolean z2 = ParserCore.debug;
        if (z2) {
            dbg_enter("global_phone_number");
        }
        try {
            TelephoneNumber telephoneNumber = new TelephoneNumber();
            telephoneNumber.setGlobal(true);
            this.lexer.match(43);
            telephoneNumber.setPhoneNumber(base_phone_number());
            if (this.lexer.hasMoreChars() && this.lexer.lookAhead(0) == ';' && z) {
                this.lexer.consume(1);
                telephoneNumber.setParameters(tel_parameters());
            }
            if (z2) {
                dbg_leave("global_phone_number");
            }
            return telephoneNumber;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("global_phone_number");
            }
            throw th;
        }
    }

    protected static boolean isMark(char c) {
        if (c == '!' || c == '_' || c == '~' || c == '-' || c == '.') {
            return true;
        }
        switch (c) {
            case '\'':
            case '(':
            case ')':
            case '*':
                return true;
            default:
                return false;
        }
    }

    protected static boolean isReserved(char c) {
        return c == '$' || c == '&' || c == '/' || c == '=' || c == '+' || c == ',' || c == ':' || c == ';' || c == '?' || c == '@';
    }

    protected static boolean isReservedNoSlash(char c) {
        return c == '$' || c == '&' || c == '+' || c == ',' || c == ':' || c == ';' || c == '?' || c == '@';
    }

    protected static boolean isUnreserved(char c) {
        return StringTokenizer.isAlphaDigit(c) || isMark(c);
    }

    protected static boolean isUserUnreserved(char c) {
        return c == '#' || c == '$' || c == '&' || c == '/' || c == ';' || c == '=' || c == '?' || c == '+' || c == ',';
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (android.gov.nist.core.ParserCore.debug == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        dbg_leave("local_number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String local_number() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = android.gov.nist.core.ParserCore.debug
            java.lang.String r2 = "local_number"
            if (r1 == 0) goto Le
            r7.dbg_enter(r2)
        Le:
            r1 = 0
            r3 = r1
        L10:
            android.gov.nist.core.LexerCore r4 = r7.lexer     // Catch: java.lang.Throwable -> L56
            boolean r4 = r4.hasMoreChars()     // Catch: java.lang.Throwable -> L56
            if (r4 == 0) goto L64
            android.gov.nist.core.LexerCore r4 = r7.lexer     // Catch: java.lang.Throwable -> L56
            char r4 = r4.lookAhead(r1)     // Catch: java.lang.Throwable -> L56
            r5 = 42
            if (r4 == r5) goto L58
            r5 = 35
            if (r4 == r5) goto L58
            r5 = 45
            if (r4 == r5) goto L58
            r5 = 46
            if (r4 == r5) goto L58
            r5 = 40
            if (r4 == r5) goto L58
            r5 = 41
            if (r4 == r5) goto L58
            boolean r5 = android.gov.nist.core.StringTokenizer.isHexDigit(r4)     // Catch: java.lang.Throwable -> L56
            if (r5 == 0) goto L3d
            goto L58
        L3d:
            if (r3 <= 0) goto L40
            goto L64
        L40:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = "unexepcted "
            r0.append(r1)     // Catch: java.lang.Throwable -> L56
            r0.append(r4)     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L56
            java.text.ParseException r0 = r7.createParseException(r0)     // Catch: java.lang.Throwable -> L56
            throw r0     // Catch: java.lang.Throwable -> L56
        L56:
            r0 = move-exception
            goto L70
        L58:
            android.gov.nist.core.LexerCore r5 = r7.lexer     // Catch: java.lang.Throwable -> L56
            r6 = 1
            r5.consume(r6)     // Catch: java.lang.Throwable -> L56
            r0.append(r4)     // Catch: java.lang.Throwable -> L56
            int r3 = r3 + 1
            goto L10
        L64:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L56
            boolean r1 = android.gov.nist.core.ParserCore.debug
            if (r1 == 0) goto L6f
            r7.dbg_leave(r2)
        L6f:
            return r0
        L70:
            boolean r1 = android.gov.nist.core.ParserCore.debug
            if (r1 == 0) goto L77
            r7.dbg_leave(r2)
        L77:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.parser.URLParser.local_number():java.lang.String");
    }

    private TelephoneNumber local_phone_number(boolean z) {
        boolean z2 = ParserCore.debug;
        if (z2) {
            dbg_enter("local_phone_number");
        }
        TelephoneNumber telephoneNumber = new TelephoneNumber();
        telephoneNumber.setGlobal(false);
        try {
            telephoneNumber.setPhoneNumber(local_number());
            if (this.lexer.hasMoreChars() && this.lexer.peekNextToken().getTokenType() == 59 && z) {
                this.lexer.consume(1);
                telephoneNumber.setParameters(tel_parameters());
            }
            if (z2) {
                dbg_leave("local_phone_number");
            }
            return telephoneNumber;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("local_phone_number");
            }
            throw th;
        }
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"sip:alice@example.com", "sips:alice@examples.com", "sip:3Zqkv5dajqaaas0tCjCxT0xH2ZEuEMsFl0xoasip%3A%2B3519116786244%40siplab.domain.com@213.0.115.163:7070"};
        for (int i = 0; i < 3; i++) {
            GenericURI genericURI = new URLParser(strArr2[i]).parse();
            PrintStream printStream = System.out;
            printStream.println("uri type returned " + genericURI.getClass().getName());
            printStream.println(strArr2[i] + " is SipUri? " + genericURI.isSipURI() + Separators.GREATER_THAN + genericURI.encode());
        }
    }

    private NameValue phone_context() throws ParseException {
        String tokenValue;
        this.lexer.match(61);
        char cLookAhead = this.lexer.lookAhead(0);
        if (cLookAhead == '+') {
            this.lexer.consume(1);
            tokenValue = "+" + base_phone_number();
        } else {
            if (!StringTokenizer.isAlphaDigit(cLookAhead)) {
                throw new ParseException("Invalid phone-context:" + cLookAhead, -1);
            }
            tokenValue = this.lexer.match(4095).getTokenValue();
        }
        return new NameValue("phone-context", tokenValue, false);
    }

    private NameValueList tel_parameters() throws ParseException {
        NameValue nameValue;
        NameValueList nameValueList = new NameValueList();
        while (true) {
            String strParamNameOrValue = paramNameOrValue();
            if (strParamNameOrValue.equalsIgnoreCase("phone-context")) {
                nameValue = phone_context();
            } else if (this.lexer.lookAhead(0) == '=') {
                this.lexer.consume(1);
                nameValue = new NameValue(strParamNameOrValue, paramNameOrValue(), false);
            } else {
                nameValue = new NameValue(strParamNameOrValue, "", true);
            }
            nameValueList.set(nameValue);
            if (this.lexer.lookAhead(0) != ';') {
                return nameValueList;
            }
            this.lexer.consume(1);
        }
    }

    private NameValue uriParam() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("uriParam");
        }
        try {
            String strParamNameOrValue = "";
            String strParamNameOrValue2 = paramNameOrValue();
            boolean z2 = false;
            if (this.lexer.lookAhead(0) == '=') {
                this.lexer.consume(1);
                strParamNameOrValue = paramNameOrValue();
            } else {
                z2 = true;
            }
            if (strParamNameOrValue2.length() == 0 && (strParamNameOrValue == null || strParamNameOrValue.length() == 0)) {
                if (!z) {
                    return null;
                }
                dbg_leave("uriParam");
                return null;
            }
            NameValue nameValue = new NameValue(strParamNameOrValue2, strParamNameOrValue, z2);
            if (z) {
                dbg_leave("uriParam");
            }
            return nameValue;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("uriParam");
            }
            throw th;
        }
    }

    protected String escaped() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("escaped");
        }
        try {
            StringBuilder sb = new StringBuilder();
            char cLookAhead = this.lexer.lookAhead(0);
            char cLookAhead2 = this.lexer.lookAhead(1);
            char cLookAhead3 = this.lexer.lookAhead(2);
            if (cLookAhead != '%' || !StringTokenizer.isHexDigit(cLookAhead2) || !StringTokenizer.isHexDigit(cLookAhead3)) {
                throw createParseException("escaped");
            }
            this.lexer.consume(3);
            sb.append(cLookAhead);
            sb.append(cLookAhead2);
            sb.append(cLookAhead3);
            String string = sb.toString();
            if (z) {
                dbg_leave("escaped");
            }
            return string;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("escaped");
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0038. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x003b. Please report as an issue. */
    protected String hvalue() {
        StringBuilder sb = new StringBuilder();
        while (this.lexer.hasMoreChars()) {
            char cLookAhead = this.lexer.lookAhead(0);
            if (cLookAhead != '!' && cLookAhead != '\"' && cLookAhead != '$' && cLookAhead != ':' && cLookAhead != '?' && cLookAhead != '[' && cLookAhead != ']' && cLookAhead != '_' && cLookAhead != '~') {
                switch (cLookAhead) {
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                        break;
                    default:
                        switch (cLookAhead) {
                            case '-':
                            case '.':
                            case '/':
                                break;
                            default:
                                if (!StringTokenizer.isAlphaDigit(cLookAhead)) {
                                    if (cLookAhead != '%') {
                                        break;
                                    } else {
                                        sb.append(escaped());
                                    }
                                } else {
                                    break;
                                }
                        }
                }
                return sb.toString();
            }
            this.lexer.consume(1);
            sb.append(cLookAhead);
        }
        return sb.toString();
    }

    protected boolean isEscaped() {
        try {
            if (this.lexer.lookAhead(0) == '%' && StringTokenizer.isHexDigit(this.lexer.lookAhead(1))) {
                return StringTokenizer.isHexDigit(this.lexer.lookAhead(2));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    protected String mark() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("mark");
        }
        try {
            char cLookAhead = this.lexer.lookAhead(0);
            if (!isMark(cLookAhead)) {
                throw createParseException("mark");
            }
            this.lexer.consume(1);
            String str = new String(new char[]{cLookAhead});
            if (z) {
                dbg_leave("mark");
            }
            return str;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("mark");
            }
            throw th;
        }
    }

    protected String paramNameOrValue() {
        int ptr = this.lexer.getPtr();
        while (this.lexer.hasMoreChars()) {
            char cLookAhead = this.lexer.lookAhead(0);
            if (cLookAhead != '$' && cLookAhead != '&' && cLookAhead != '+' && cLookAhead != '/' && cLookAhead != ':' && cLookAhead != '[' && cLookAhead != ']' && !isUnreserved(cLookAhead)) {
                if (!isEscaped()) {
                    break;
                }
                this.lexer.consume(3);
            } else {
                this.lexer.consume(1);
            }
        }
        return this.lexer.getBuffer().substring(ptr, this.lexer.getPtr());
    }

    public GenericURI parse() {
        return uriReference(true);
    }

    public final TelephoneNumber parseTelephoneNumber(boolean z) {
        TelephoneNumber telephoneNumberLocal_phone_number;
        boolean z2 = ParserCore.debug;
        if (z2) {
            dbg_enter("telephone_subscriber");
        }
        this.lexer.selectLexer("charLexer");
        try {
            char cLookAhead = this.lexer.lookAhead(0);
            if (cLookAhead == '+') {
                telephoneNumberLocal_phone_number = global_phone_number(z);
            } else {
                if (!StringTokenizer.isHexDigit(cLookAhead) && cLookAhead != '#' && cLookAhead != '*' && cLookAhead != '-' && cLookAhead != '.' && cLookAhead != '(' && cLookAhead != ')') {
                    throw createParseException("unexpected char " + cLookAhead);
                }
                telephoneNumberLocal_phone_number = local_phone_number(z);
            }
            if (z2) {
                dbg_leave("telephone_subscriber");
            }
            return telephoneNumberLocal_phone_number;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("telephone_subscriber");
            }
            throw th;
        }
    }

    protected String password() {
        int ptr = this.lexer.getPtr();
        while (true) {
            char cLookAhead = this.lexer.lookAhead(0);
            if (cLookAhead == '$' || cLookAhead == '&' || cLookAhead == '=' || cLookAhead == '+' || cLookAhead == ',' || isUnreserved(cLookAhead)) {
                this.lexer.consume(1);
            } else {
                if (!isEscaped()) {
                    return this.lexer.getBuffer().substring(ptr, this.lexer.getPtr());
                }
                this.lexer.consume(3);
            }
        }
    }

    public String peekScheme() {
        return this.lexer.getString(':');
    }

    protected NameValue qheader() throws ParseException {
        String nextToken = this.lexer.getNextToken('=');
        this.lexer.consume(1);
        return new NameValue(nextToken, hvalue(), false);
    }

    protected String reserved() throws ParseException {
        char cLookAhead = this.lexer.lookAhead(0);
        if (!isReserved(cLookAhead)) {
            throw createParseException("reserved");
        }
        this.lexer.consume(1);
        StringBuilder sb = new StringBuilder();
        sb.append(cLookAhead);
        return sb.toString();
    }

    public SipUri sipURL(boolean z) {
        String str;
        String strPassword;
        if (ParserCore.debug) {
            dbg_enter("sipURL");
        }
        SipUri sipUri = new SipUri();
        int tokenType = this.lexer.peekNextToken().getTokenType();
        int i = TokenTypes.SIPS;
        if (tokenType == 2136) {
            str = "sips";
        } else {
            i = TokenTypes.SIP;
            str = "sip";
        }
        try {
            this.lexer.match(i);
            this.lexer.match(58);
            sipUri.setScheme(str);
            int iMarkInputPosition = this.lexer.markInputPosition();
            String strUser = user();
            if (this.lexer.lookAhead() == ':') {
                this.lexer.consume(1);
                strPassword = password();
            } else {
                strPassword = null;
            }
            if (this.lexer.lookAhead() == '@') {
                this.lexer.consume(1);
                sipUri.setUser(strUser);
                if (strPassword != null) {
                    sipUri.setUserPassword(strPassword);
                }
            } else {
                this.lexer.rewindInputPosition(iMarkInputPosition);
            }
            sipUri.setHostPort(new HostNameParser(getLexer()).hostPort(false));
            this.lexer.selectLexer("charLexer");
            while (this.lexer.hasMoreChars() && this.lexer.lookAhead(0) == ';' && z) {
                this.lexer.consume(1);
                NameValue nameValueUriParam = uriParam();
                if (nameValueUriParam != null) {
                    sipUri.setUriParameter(nameValueUriParam);
                }
            }
            if (this.lexer.hasMoreChars() && this.lexer.lookAhead(0) == '?') {
                this.lexer.consume(1);
                while (this.lexer.hasMoreChars()) {
                    sipUri.setQHeader(qheader());
                    if (!this.lexer.hasMoreChars() || this.lexer.lookAhead(0) == '&') {
                        this.lexer.consume(1);
                    }
                }
            }
            return sipUri;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("sipURL");
            }
        }
    }

    public TelURLImpl telURL(boolean z) throws ParseException {
        this.lexer.match(TokenTypes.TEL);
        this.lexer.match(58);
        TelephoneNumber telephoneNumber = parseTelephoneNumber(z);
        TelURLImpl telURLImpl = new TelURLImpl();
        telURLImpl.setTelephoneNumber(telephoneNumber);
        return telURLImpl;
    }

    protected String unreserved() throws ParseException {
        char cLookAhead = this.lexer.lookAhead(0);
        if (!isUnreserved(cLookAhead)) {
            throw createParseException("unreserved");
        }
        this.lexer.consume(1);
        return String.valueOf(cLookAhead);
    }

    public GenericURI uriReference(boolean z) throws ParseException {
        GenericURI genericURISipURL;
        boolean z2 = ParserCore.debug;
        if (z2) {
            dbg_enter("uriReference");
        }
        Token[] tokenArrPeekNextToken = this.lexer.peekNextToken(2);
        Token token = tokenArrPeekNextToken[0];
        Token token2 = tokenArrPeekNextToken[1];
        try {
            if (token.getTokenType() == 2051 || token.getTokenType() == 2136) {
                if (token2.getTokenType() != 58) {
                    throw createParseException("Expecting ':'");
                }
                genericURISipURL = sipURL(z);
            } else if (token.getTokenType() != 2105) {
                try {
                    genericURISipURL = new GenericURI(uricString());
                } catch (ParseException e) {
                    throw createParseException(e.getMessage());
                }
            } else {
                if (token2.getTokenType() != 58) {
                    throw createParseException("Expecting ':'");
                }
                genericURISipURL = telURL(z);
            }
            if (z2) {
                dbg_leave("uriReference");
            }
            return genericURISipURL;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("uriReference");
            }
            throw th;
        }
    }

    protected String uric() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("uric");
        }
        try {
            char cLookAhead = this.lexer.lookAhead(0);
            if (isUnreserved(cLookAhead)) {
                this.lexer.consume(1);
                String strCharAsString = LexerCore.charAsString(cLookAhead);
                if (z) {
                    dbg_leave("uric");
                }
                return strCharAsString;
            }
            if (isReserved(cLookAhead)) {
                this.lexer.consume(1);
                String strCharAsString2 = LexerCore.charAsString(cLookAhead);
                if (z) {
                    dbg_leave("uric");
                }
                return strCharAsString2;
            }
            if (!isEscaped()) {
                if (z) {
                    dbg_leave("uric");
                }
                return null;
            }
            String strCharAsString3 = this.lexer.charAsString(3);
            this.lexer.consume(3);
            if (z) {
                dbg_leave("uric");
            }
            return strCharAsString3;
        } catch (Exception unused) {
            if (ParserCore.debug) {
                dbg_leave("uric");
            }
            return null;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("uric");
            }
            throw th;
        }
    }

    protected String uricNoSlash() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("uricNoSlash");
        }
        try {
            char cLookAhead = this.lexer.lookAhead(0);
            if (isEscaped()) {
                String strCharAsString = this.lexer.charAsString(3);
                this.lexer.consume(3);
                if (z) {
                    dbg_leave("uricNoSlash");
                }
                return strCharAsString;
            }
            if (isUnreserved(cLookAhead)) {
                this.lexer.consume(1);
                String strCharAsString2 = LexerCore.charAsString(cLookAhead);
                if (z) {
                    dbg_leave("uricNoSlash");
                }
                return strCharAsString2;
            }
            if (!isReservedNoSlash(cLookAhead)) {
                if (z) {
                    dbg_leave("uricNoSlash");
                }
                return null;
            }
            this.lexer.consume(1);
            String strCharAsString3 = LexerCore.charAsString(cLookAhead);
            if (z) {
                dbg_leave("uricNoSlash");
            }
            return strCharAsString3;
        } catch (ParseException unused) {
            if (ParserCore.debug) {
                dbg_leave("uricNoSlash");
            }
            return null;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("uricNoSlash");
            }
            throw th;
        }
    }

    protected String uricString() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String strUric = uric();
            if (strUric != null) {
                sb.append(strUric);
            } else {
                if (this.lexer.lookAhead(0) != '[') {
                    return sb.toString();
                }
                sb.append(new HostNameParser(getLexer()).hostPort(false).toString());
            }
        }
    }

    protected String urlString() {
        char cLookAhead;
        StringBuilder sb = new StringBuilder();
        this.lexer.selectLexer("charLexer");
        while (this.lexer.hasMoreChars() && (cLookAhead = this.lexer.lookAhead(0)) != ' ' && cLookAhead != '\t' && cLookAhead != '\n' && cLookAhead != '>' && cLookAhead != '<') {
            this.lexer.consume(0);
            sb.append(cLookAhead);
        }
        return sb.toString();
    }

    protected String user() {
        if (ParserCore.debug) {
            dbg_enter("user");
        }
        try {
            int ptr = this.lexer.getPtr();
            while (this.lexer.hasMoreChars()) {
                char cLookAhead = this.lexer.lookAhead(0);
                if (!isUnreserved(cLookAhead) && !isUserUnreserved(cLookAhead)) {
                    if (!isEscaped()) {
                        break;
                    }
                    this.lexer.consume(3);
                } else {
                    this.lexer.consume(1);
                }
            }
            String strSubstring = this.lexer.getBuffer().substring(ptr, this.lexer.getPtr());
            if (ParserCore.debug) {
                dbg_leave("user");
            }
            return strSubstring;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("user");
            }
            throw th;
        }
    }

    public URLParser(Lexer lexer) {
        this.lexer = lexer;
        lexer.selectLexer("sip_urlLexer");
    }
}
