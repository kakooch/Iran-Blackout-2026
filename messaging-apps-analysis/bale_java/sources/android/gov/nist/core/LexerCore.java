package android.gov.nist.core;

import android.gov.nist.javax.sip.Utils;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class LexerCore extends StringTokenizer {
    public static final int ALPHA = 4099;
    static final char ALPHADIGIT_VALID_CHARS = 65533;
    static final char ALPHA_VALID_CHARS = 65535;
    public static final int AND = 38;
    public static final int AT = 64;
    public static final int BACKSLASH = 92;
    public static final int BACK_QUOTE = 96;
    public static final int BAR = 124;
    public static final int COLON = 58;
    public static final int DIGIT = 4098;
    static final char DIGIT_VALID_CHARS = 65534;
    public static final int DOLLAR = 36;
    public static final int DOT = 46;
    public static final int DOUBLEQUOTE = 34;
    public static final int END = 4096;
    public static final int EQUALS = 61;
    public static final int EXCLAMATION = 33;
    public static final int GREATER_THAN = 62;
    public static final int HAT = 94;
    public static final int HT = 9;
    public static final int ID = 4095;
    public static final int ID_NO_WHITESPACE = 4093;
    public static final int IPV6 = 4100;
    public static final int LESS_THAN = 60;
    public static final int LPAREN = 40;
    public static final int L_CURLY = 123;
    public static final int L_SQUARE_BRACKET = 91;
    public static final int MINUS = 45;
    public static final int NULL = 0;
    public static final int PERCENT = 37;
    public static final int PLUS = 43;
    public static final int POUND = 35;
    public static final int QUESTION = 63;
    public static final int QUOTE = 39;
    public static final int RPAREN = 41;
    public static final int R_CURLY = 125;
    public static final int R_SQUARE_BRACKET = 93;
    public static final int SAFE = 4094;
    public static final int SEMICOLON = 59;
    public static final int SLASH = 47;
    public static final int SP = 32;
    public static final int STAR = 42;
    public static final int START = 2048;
    public static final int TILDE = 126;
    public static final int UNDERSCORE = 95;
    public static final int WHITESPACE = 4097;
    protected static final ConcurrentHashMap<Integer, String> globalSymbolTable = new ConcurrentHashMap<>();
    protected static final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> lexerTables = new ConcurrentHashMap<>();
    protected Map<String, Integer> currentLexer;
    protected String currentLexerName;
    protected Token currentMatch;

    protected LexerCore() {
        this.currentLexer = new ConcurrentHashMap();
        this.currentLexerName = "charLexer";
    }

    public static String charAsString(char c) {
        return String.valueOf(c);
    }

    public static final boolean isTokenChar(char c) {
        return StringTokenizer.isAlphaDigit(c) || c == '!' || c == '%' || c == '\'' || c == '~' || c == '*' || c == '+' || c == '-' || c == '.' || c == '_' || c == '`';
    }

    public void SPorHT() {
        try {
            char cLookAhead = lookAhead(0);
            while (true) {
                if (cLookAhead != ' ' && cLookAhead != '\t') {
                    return;
                }
                consume(1);
                cLookAhead = lookAhead(0);
            }
        } catch (ParseException unused) {
        }
    }

    protected void addKeyword(String str, int i) {
        String upperCase = Utils.toUpperCase(str);
        Integer numValueOf = Integer.valueOf(i);
        this.currentLexer.put(upperCase, numValueOf);
        globalSymbolTable.putIfAbsent(numValueOf, upperCase);
    }

    public String byteStringNoComma() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                char cLookAhead = lookAhead(0);
                if (cLookAhead == '\n' || cLookAhead == ',') {
                    break;
                }
                consume(1);
                sb.append(cLookAhead);
            } catch (ParseException unused) {
            }
        }
        return sb.toString();
    }

    public String byteStringNoSemicolon() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                char cLookAhead = lookAhead(0);
                if (cLookAhead == 0 || cLookAhead == '\n' || cLookAhead == ';' || cLookAhead == ',') {
                    break;
                }
                consume(1);
                sb.append(cLookAhead);
            } catch (ParseException unused) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public String byteStringNoSlash() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                char cLookAhead = lookAhead(0);
                if (cLookAhead == 0 || cLookAhead == '\n' || cLookAhead == '/') {
                    break;
                }
                consume(1);
                sb.append(cLookAhead);
            } catch (ParseException unused) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public String comment() throws ParseException {
        StringBuilder sb = new StringBuilder();
        if (lookAhead(0) != '(') {
            return null;
        }
        consume(1);
        while (true) {
            char nextChar = getNextChar();
            if (nextChar == ')') {
                return sb.toString();
            }
            if (nextChar == 0) {
                throw new ParseException(((Object) this.buffer) + " :unexpected EOL", this.ptr);
            }
            if (nextChar == '\\') {
                sb.append(nextChar);
                char nextChar2 = getNextChar();
                if (nextChar2 == 0) {
                    throw new ParseException(((Object) this.buffer) + " : unexpected EOL", this.ptr);
                }
                sb.append(nextChar2);
            } else {
                sb.append(nextChar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032 A[Catch: ParseException -> 0x0036, LOOP:0: B:24:0x0001->B:20:0x0032, LOOP_END, TRY_LEAVE, TryCatch #0 {ParseException -> 0x0036, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x0011, B:9:0x0013, B:18:0x002d, B:13:0x001c, B:14:0x0021, B:15:0x0026, B:20:0x0032), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void consumeValidChars(char[] r7) {
        /*
            r6 = this;
            int r0 = r7.length
        L1:
            boolean r1 = r6.hasMoreChars()     // Catch: java.text.ParseException -> L36
            if (r1 == 0) goto L36
            r1 = 0
            char r2 = r6.lookAhead(r1)     // Catch: java.text.ParseException -> L36
            r3 = r1
            r4 = r3
        Le:
            r5 = 1
            if (r3 >= r0) goto L30
            char r4 = r7[r3]     // Catch: java.text.ParseException -> L36
            switch(r4) {
                case 65533: goto L26;
                case 65534: goto L21;
                case 65535: goto L1c;
                default: goto L16;
            }     // Catch: java.text.ParseException -> L36
        L16:
            if (r2 != r4) goto L1a
            r4 = r5
            goto L2a
        L1a:
            r4 = r1
            goto L2a
        L1c:
            boolean r4 = android.gov.nist.core.StringTokenizer.isAlpha(r2)     // Catch: java.text.ParseException -> L36
            goto L2a
        L21:
            boolean r4 = android.gov.nist.core.StringTokenizer.isDigit(r2)     // Catch: java.text.ParseException -> L36
            goto L2a
        L26:
            boolean r4 = android.gov.nist.core.StringTokenizer.isAlphaDigit(r2)     // Catch: java.text.ParseException -> L36
        L2a:
            if (r4 == 0) goto L2d
            goto L30
        L2d:
            int r3 = r3 + 1
            goto Le
        L30:
            if (r4 == 0) goto L36
            r6.consume(r5)     // Catch: java.text.ParseException -> L36
            goto L1
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.core.LexerCore.consumeValidChars(char[]):void");
    }

    public ParseException createParseException() {
        return new ParseException(getBuffer(), this.ptr);
    }

    public String getBuffer() {
        return String.valueOf(this.buffer);
    }

    public String getNextId() {
        return ttoken();
    }

    public String getNextIdNoWhiteSpace() {
        return ttokenNoWhiteSpace();
    }

    public String getNextIp() {
        return tIpv6address();
    }

    public Token getNextToken() {
        return this.currentMatch;
    }

    public int getPtr() {
        return this.ptr;
    }

    public String getRest() {
        int i = this.ptr;
        int i2 = this.bufferLen;
        if (i > i2) {
            return null;
        }
        return i == i2 ? "" : String.valueOf(this.buffer, i, i2 - i);
    }

    public String getString(char c) throws ParseException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char cLookAhead = lookAhead(0);
            if (cLookAhead == 0) {
                throw new ParseException(((Object) this.buffer) + "unexpected EOL", this.ptr);
            }
            if (cLookAhead == c) {
                consume(1);
                return sb.toString();
            }
            if (cLookAhead == '\\') {
                consume(1);
                char cLookAhead2 = lookAhead(0);
                if (cLookAhead2 == 0) {
                    throw new ParseException(((Object) this.buffer) + "unexpected EOL", this.ptr);
                }
                consume(1);
                sb.append(cLookAhead2);
            } else {
                consume(1);
                sb.append(cLookAhead);
            }
        }
    }

    public String lookupToken(int i) {
        return i > 2048 ? globalSymbolTable.get(Integer.valueOf(i)) : Character.valueOf((char) i).toString();
    }

    public int markInputPosition() {
        return this.ptr;
    }

    public Token match(int i) throws ParseException {
        if (Debug.parserDebug) {
            Debug.println("match " + i);
        }
        if (i <= 2048 || i >= 4096) {
            if (i > 4096) {
                char cLookAhead = lookAhead(0);
                if (i == 4098) {
                    if (!StringTokenizer.isDigit(cLookAhead)) {
                        throw new ParseException(((Object) this.buffer) + "\nExpecting DIGIT", this.ptr);
                    }
                    Token token = new Token();
                    this.currentMatch = token;
                    token.tokenValue = String.valueOf(cLookAhead);
                    this.currentMatch.tokenType = i;
                    consume(1);
                } else if (i == 4099) {
                    if (!StringTokenizer.isAlpha(cLookAhead)) {
                        throw new ParseException(((Object) this.buffer) + "\nExpecting ALPHA", this.ptr);
                    }
                    Token token2 = new Token();
                    this.currentMatch = token2;
                    token2.tokenValue = String.valueOf(cLookAhead);
                    this.currentMatch.tokenType = i;
                    consume(1);
                } else if (i == 4100) {
                    String nextIp = getNextIp();
                    Token token3 = new Token();
                    this.currentMatch = token3;
                    token3.tokenValue = nextIp;
                    token3.tokenType = IPV6;
                }
            } else {
                char c = (char) i;
                char cLookAhead2 = lookAhead(0);
                if (cLookAhead2 != c) {
                    throw new ParseException(((Object) this.buffer) + "\nExpecting  >>>" + c + "<<< got >>>" + cLookAhead2 + "<<<", this.ptr);
                }
                consume(1);
            }
        } else if (i == 4095) {
            if (!startsId()) {
                throw new ParseException(((Object) this.buffer) + "\nID expected", this.ptr);
            }
            String nextId = getNextId();
            Token token4 = new Token();
            this.currentMatch = token4;
            token4.tokenValue = nextId;
            token4.tokenType = 4095;
        } else if (i == 4094) {
            if (!startsSafeToken()) {
                throw new ParseException(((Object) this.buffer) + "\nID expected", this.ptr);
            }
            String strTtokenSafe = ttokenSafe();
            Token token5 = new Token();
            this.currentMatch = token5;
            token5.tokenValue = strTtokenSafe;
            token5.tokenType = 4094;
        } else if (i != 4093) {
            String nextId2 = getNextId();
            Integer num = this.currentLexer.get(Utils.toUpperCase(nextId2));
            if (num == null || num.intValue() != i) {
                throw new ParseException(((Object) this.buffer) + "\nUnexpected Token : " + nextId2, this.ptr);
            }
            Token token6 = new Token();
            this.currentMatch = token6;
            token6.tokenValue = nextId2;
            token6.tokenType = i;
        } else {
            if (!startsIdNoWhiteSpace()) {
                throw new ParseException(((Object) this.buffer) + "\nID no white space expected", this.ptr);
            }
            String nextIdNoWhiteSpace = getNextIdNoWhiteSpace();
            Token token7 = new Token();
            this.currentMatch = token7;
            token7.tokenValue = nextIdNoWhiteSpace;
            token7.tokenType = ID_NO_WHITESPACE;
        }
        return this.currentMatch;
    }

    public String number() throws ParseException {
        int i = this.ptr;
        try {
            if (StringTokenizer.isDigit(lookAhead(0))) {
                consume(1);
                while (StringTokenizer.isDigit(lookAhead(0))) {
                    consume(1);
                }
                return String.valueOf(this.buffer, i, this.ptr - i);
            }
            throw new ParseException(((Object) this.buffer) + ": Unexpected token at " + lookAhead(0), this.ptr);
        } catch (ParseException unused) {
            return String.valueOf(this.buffer, i, this.ptr - i);
        }
    }

    public String peekNextId() {
        int i = this.ptr;
        String strTtoken = ttoken();
        this.savedPtr = this.ptr;
        this.ptr = i;
        return strTtoken;
    }

    public Token peekNextToken() {
        return peekNextToken(1)[0];
    }

    public String quotedString() throws ParseException {
        int i = this.ptr + 1;
        if (lookAhead(0) != '\"') {
            return null;
        }
        consume(1);
        while (true) {
            char nextChar = getNextChar();
            if (nextChar == '\"') {
                return String.valueOf(this.buffer, i, (this.ptr - i) - 1);
            }
            if (nextChar == 0) {
                throw new ParseException(String.valueOf(this.buffer) + " :unexpected EOL", this.ptr);
            }
            if (nextChar == '\\') {
                consume(1);
            }
        }
    }

    public void rewindInputPosition(int i) {
        this.ptr = i;
    }

    public void selectLexer(String str) {
        this.currentLexerName = str;
    }

    public boolean startsId() {
        try {
            return isTokenChar(lookAhead(0));
        } catch (ParseException unused) {
            return false;
        }
    }

    public boolean startsIdNoWhiteSpace() {
        try {
            char cLookAhead = lookAhead(0);
            return (cLookAhead == ' ' || cLookAhead == '\t' || cLookAhead == '\n') ? false : true;
        } catch (ParseException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x003e A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean startsSafeToken() {
        /*
            r4 = this;
            r0 = 0
            char r1 = r4.lookAhead(r0)     // Catch: java.text.ParseException -> L3f
            boolean r2 = android.gov.nist.core.StringTokenizer.isAlphaDigit(r1)     // Catch: java.text.ParseException -> L3f
            r3 = 1
            if (r2 == 0) goto Ld
            return r3
        Ld:
            r2 = 39
            if (r1 == r2) goto L3e
            r2 = 61
            if (r1 == r2) goto L3e
            r2 = 91
            if (r1 == r2) goto L3e
            r2 = 42
            if (r1 == r2) goto L3e
            r2 = 43
            if (r1 == r2) goto L3e
            r2 = 58
            if (r1 == r2) goto L3e
            r2 = 59
            if (r1 == r2) goto L3e
            r2 = 63
            if (r1 == r2) goto L3e
            r2 = 64
            if (r1 == r2) goto L3e
            switch(r1) {
                case 33: goto L3e;
                case 34: goto L3e;
                case 35: goto L3e;
                case 36: goto L3e;
                case 37: goto L3e;
                default: goto L34;
            }
        L34:
            switch(r1) {
                case 45: goto L3e;
                case 46: goto L3e;
                case 47: goto L3e;
                default: goto L37;
            }
        L37:
            switch(r1) {
                case 93: goto L3e;
                case 94: goto L3e;
                case 95: goto L3e;
                case 96: goto L3e;
                default: goto L3a;
            }
        L3a:
            switch(r1) {
                case 123: goto L3e;
                case 124: goto L3e;
                case 125: goto L3e;
                case 126: goto L3e;
                default: goto L3d;
            }
        L3d:
            return r0
        L3e:
            return r3
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.core.LexerCore.startsSafeToken():boolean");
    }

    public String tIpv6address() {
        try {
            char[] cArr = this.buffer;
            int i = this.ptr;
            HostPort hostPort = new HostNameParser(String.valueOf(cArr, i, cArr.length - i)).hostPort(true);
            consume(hostPort.getHost().hostname.length());
            return hostPort.getHost().hostname;
        } catch (ParseException unused) {
            return null;
        }
    }

    public String ttoken() {
        int i = this.ptr;
        while (hasMoreChars() && isTokenChar(lookAhead(0))) {
            try {
                consume(1);
            } catch (ParseException unused) {
                return null;
            }
        }
        return String.valueOf(this.buffer, i, this.ptr - i);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0041 A[Catch: ParseException -> 0x004f, FALL_THROUGH, TryCatch #0 {ParseException -> 0x004f, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0014, B:22:0x0034, B:23:0x0037, B:24:0x003a, B:25:0x003d, B:27:0x0041, B:28:0x0045), top: B:32:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String ttokenGenValue() {
        /*
            r4 = this;
            int r0 = r4.ptr
        L2:
            boolean r1 = r4.hasMoreChars()     // Catch: java.text.ParseException -> L4f
            if (r1 == 0) goto L45
            r1 = 0
            char r1 = r4.lookAhead(r1)     // Catch: java.text.ParseException -> L4f
            boolean r2 = android.gov.nist.core.StringTokenizer.isAlphaDigit(r1)     // Catch: java.text.ParseException -> L4f
            r3 = 1
            if (r2 == 0) goto L18
            r4.consume(r3)     // Catch: java.text.ParseException -> L4f
            goto L2
        L18:
            r2 = 39
            if (r1 == r2) goto L41
            r2 = 58
            if (r1 == r2) goto L41
            r2 = 91
            if (r1 == r2) goto L41
            r2 = 42
            if (r1 == r2) goto L41
            r2 = 43
            if (r1 == r2) goto L41
            r2 = 63
            if (r1 == r2) goto L41
            r2 = 64
            if (r1 == r2) goto L41
            switch(r1) {
                case 33: goto L41;
                case 34: goto L41;
                case 35: goto L41;
                case 36: goto L41;
                case 37: goto L41;
                default: goto L37;
            }     // Catch: java.text.ParseException -> L4f
        L37:
            switch(r1) {
                case 45: goto L41;
                case 46: goto L41;
                case 47: goto L41;
                default: goto L3a;
            }     // Catch: java.text.ParseException -> L4f
        L3a:
            switch(r1) {
                case 93: goto L41;
                case 94: goto L41;
                case 95: goto L41;
                case 96: goto L41;
                default: goto L3d;
            }     // Catch: java.text.ParseException -> L4f
        L3d:
            switch(r1) {
                case 123: goto L41;
                case 124: goto L41;
                case 125: goto L41;
                case 126: goto L41;
                default: goto L40;
            }     // Catch: java.text.ParseException -> L4f
        L40:
            goto L45
        L41:
            r4.consume(r3)     // Catch: java.text.ParseException -> L4f
            goto L2
        L45:
            char[] r1 = r4.buffer     // Catch: java.text.ParseException -> L4f
            int r2 = r4.ptr     // Catch: java.text.ParseException -> L4f
            int r2 = r2 - r0
            java.lang.String r0 = java.lang.String.valueOf(r1, r0, r2)     // Catch: java.text.ParseException -> L4f
            return r0
        L4f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.core.LexerCore.ttokenGenValue():java.lang.String");
    }

    public String ttokenNoWhiteSpace() {
        char cLookAhead;
        int i = this.ptr;
        while (hasMoreChars() && (cLookAhead = lookAhead(0)) != ' ' && cLookAhead != '\n' && cLookAhead != '\t') {
            try {
                consume(1);
            } catch (ParseException unused) {
                return null;
            }
        }
        return String.valueOf(this.buffer, i, this.ptr - i);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0045 A[Catch: ParseException -> 0x0053, FALL_THROUGH, TryCatch #0 {ParseException -> 0x0053, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0014, B:24:0x0038, B:25:0x003b, B:26:0x003e, B:27:0x0041, B:29:0x0045, B:30:0x0049), top: B:34:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String ttokenSafe() {
        /*
            r4 = this;
            int r0 = r4.ptr
        L2:
            boolean r1 = r4.hasMoreChars()     // Catch: java.text.ParseException -> L53
            if (r1 == 0) goto L49
            r1 = 0
            char r1 = r4.lookAhead(r1)     // Catch: java.text.ParseException -> L53
            boolean r2 = android.gov.nist.core.StringTokenizer.isAlphaDigit(r1)     // Catch: java.text.ParseException -> L53
            r3 = 1
            if (r2 == 0) goto L18
            r4.consume(r3)     // Catch: java.text.ParseException -> L53
            goto L2
        L18:
            r2 = 39
            if (r1 == r2) goto L45
            r2 = 91
            if (r1 == r2) goto L45
            r2 = 42
            if (r1 == r2) goto L45
            r2 = 43
            if (r1 == r2) goto L45
            r2 = 58
            if (r1 == r2) goto L45
            r2 = 59
            if (r1 == r2) goto L45
            r2 = 63
            if (r1 == r2) goto L45
            r2 = 64
            if (r1 == r2) goto L45
            switch(r1) {
                case 33: goto L45;
                case 34: goto L45;
                case 35: goto L45;
                case 36: goto L45;
                case 37: goto L45;
                default: goto L3b;
            }     // Catch: java.text.ParseException -> L53
        L3b:
            switch(r1) {
                case 45: goto L45;
                case 46: goto L45;
                case 47: goto L45;
                default: goto L3e;
            }     // Catch: java.text.ParseException -> L53
        L3e:
            switch(r1) {
                case 93: goto L45;
                case 94: goto L45;
                case 95: goto L45;
                case 96: goto L45;
                default: goto L41;
            }     // Catch: java.text.ParseException -> L53
        L41:
            switch(r1) {
                case 123: goto L45;
                case 124: goto L45;
                case 125: goto L45;
                case 126: goto L45;
                default: goto L44;
            }     // Catch: java.text.ParseException -> L53
        L44:
            goto L49
        L45:
            r4.consume(r3)     // Catch: java.text.ParseException -> L53
            goto L2
        L49:
            char[] r1 = r4.buffer     // Catch: java.text.ParseException -> L53
            int r2 = r4.ptr     // Catch: java.text.ParseException -> L53
            int r2 = r2 - r0
            java.lang.String r0 = java.lang.String.valueOf(r1, r0, r2)     // Catch: java.text.ParseException -> L53
            return r0
        L53:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.core.LexerCore.ttokenSafe():java.lang.String");
    }

    public String charAsString(int i) {
        return String.valueOf(this.buffer, this.ptr, i - 1);
    }

    public Token[] peekNextToken(int i) throws ParseException {
        int i2 = this.ptr;
        Token[] tokenArr = new Token[i];
        for (int i3 = 0; i3 < i; i3++) {
            Token token = new Token();
            if (startsId()) {
                String strTtoken = ttoken();
                token.tokenValue = strTtoken;
                String upperCase = Utils.toUpperCase(strTtoken);
                if (this.currentLexer.containsKey(upperCase)) {
                    token.tokenType = this.currentLexer.get(upperCase).intValue();
                } else {
                    token.tokenType = 4095;
                }
            } else {
                char nextChar = getNextChar();
                token.tokenValue = String.valueOf(nextChar);
                if (StringTokenizer.isAlpha(nextChar)) {
                    token.tokenType = 4099;
                } else if (StringTokenizer.isDigit(nextChar)) {
                    token.tokenType = 4098;
                } else {
                    token.tokenType = nextChar;
                }
            }
            tokenArr[i3] = token;
        }
        this.savedPtr = this.ptr;
        this.ptr = i2;
        return tokenArr;
    }

    public LexerCore(String str, String str2) {
        super(str2);
        this.currentLexerName = str;
    }
}
