package android.gov.nist.javax.sip.parser;

/* loaded from: classes.dex */
public class ServerParser extends HeaderParser {
    public ServerParser(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[DONT_GENERATE] */
    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.gov.nist.javax.sip.header.SIPHeader parse() {
        /*
            r7 = this;
            boolean r0 = android.gov.nist.core.ParserCore.debug
            java.lang.String r1 = "ServerParser.parse"
            if (r0 == 0) goto L9
            r7.dbg_enter(r1)
        L9:
            android.gov.nist.javax.sip.header.Server r0 = new android.gov.nist.javax.sip.header.Server
            r0.<init>()
            r2 = 2066(0x812, float:2.895E-42)
            r7.headerName(r2)     // Catch: java.lang.Throwable -> L56
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            r3 = 0
            char r2 = r2.lookAhead(r3)     // Catch: java.lang.Throwable -> L56
            r4 = 10
            if (r2 == r4) goto L97
        L1e:
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            char r2 = r2.lookAhead(r3)     // Catch: java.lang.Throwable -> L56
            if (r2 == r4) goto L8f
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            char r2 = r2.lookAhead(r3)     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L8f
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            char r2 = r2.lookAhead(r3)     // Catch: java.lang.Throwable -> L56
            r5 = 40
            if (r2 != r5) goto L58
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r2.comment()     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r6.<init>()     // Catch: java.lang.Throwable -> L56
            r6.append(r5)     // Catch: java.lang.Throwable -> L56
            r6.append(r2)     // Catch: java.lang.Throwable -> L56
            r2 = 41
            r6.append(r2)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L56
            r0.addProductToken(r2)     // Catch: java.lang.Throwable -> L56
            goto L1e
        L56:
            r0 = move-exception
            goto L9e
        L58:
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L7d
            int r2 = r2.markInputPosition()     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L7d
            android.gov.nist.core.LexerCore r5 = r7.lexer     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L77
            r6 = 47
            java.lang.String r5 = r5.getString(r6)     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L77
            int r6 = r5.length()     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L77
            int r6 = r6 + (-1)
            char r6 = r5.charAt(r6)     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L77
            if (r6 != r4) goto L79
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L77
            goto L79
        L77:
            r3 = r2
            goto L7d
        L79:
            r0.addProductToken(r5)     // Catch: java.lang.Throwable -> L56 java.text.ParseException -> L77
            goto L1e
        L7d:
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            r2.rewindInputPosition(r3)     // Catch: java.lang.Throwable -> L56
            android.gov.nist.core.LexerCore r2 = r7.lexer     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r2.getRest()     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L56
            r0.addProductToken(r2)     // Catch: java.lang.Throwable -> L56
        L8f:
            boolean r2 = android.gov.nist.core.ParserCore.debug
            if (r2 == 0) goto L96
            r7.dbg_leave(r1)
        L96:
            return r0
        L97:
            java.lang.String r0 = "empty header"
            java.text.ParseException r0 = r7.createParseException(r0)     // Catch: java.lang.Throwable -> L56
            throw r0     // Catch: java.lang.Throwable -> L56
        L9e:
            boolean r2 = android.gov.nist.core.ParserCore.debug
            if (r2 == 0) goto La5
            r7.dbg_leave(r1)
        La5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.parser.ServerParser.parse():android.gov.nist.javax.sip.header.SIPHeader");
    }

    protected ServerParser(Lexer lexer) {
        super(lexer);
    }
}
