package android.gov.nist.core;

import java.text.ParseException;

/* loaded from: classes.dex */
public class HostNameParser extends ParserCore {
    private static boolean stripAddressScopeZones = Boolean.getBoolean("android.gov.nist.core.STRIP_ADDR_SCOPES");
    private static final char[] VALID_DOMAIN_LABEL_CHAR = {65533, '-', '.', '_'};

    public HostNameParser(String str) {
        this.lexer = new LexerCore("charLexer", str);
    }

    private boolean isIPv6Address(String str) {
        int iIndexOf = str.indexOf(",");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf(63);
        int iIndexOf3 = str.indexOf(59);
        if (iIndexOf2 == -1 || (iIndexOf3 != -1 && iIndexOf2 > iIndexOf3)) {
            iIndexOf2 = iIndexOf3;
        }
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        String strSubstring = str.substring(0, iIndexOf2);
        int iIndexOf4 = strSubstring.indexOf(58);
        return (iIndexOf4 == -1 || strSubstring.indexOf(58, iIndexOf4 + 1) == -1) ? false : true;
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"foo.bar.com:1234", "proxima.chaplin.bt.co.uk", "129.6.55.181:2345", ":1234", "foo.bar.com:         1234", "foo.bar.com     :      1234   ", "MIK_S:1234"};
        for (int i = 0; i < 7; i++) {
            try {
                HostPort hostPort = new HostNameParser(strArr2[i]).hostPort(true);
                System.out.println("[" + hostPort.encode() + "]");
            } catch (ParseException e) {
                System.out.println("exception text = " + e.getMessage());
            }
        }
    }

    protected void consumeDomainLabel() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("domainLabel");
        }
        try {
            this.lexer.consumeValidChars(VALID_DOMAIN_LABEL_CHAR);
            if (z) {
                dbg_leave("domainLabel");
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("domainLabel");
            }
            throw th;
        }
    }

    public Host host() {
        String strSubstring;
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("host");
        }
        try {
            if (this.lexer.lookAhead(0) == '[') {
                strSubstring = ipv6Reference();
            } else if (isIPv6Address(this.lexer.getRest())) {
                int ptr = this.lexer.getPtr();
                this.lexer.consumeValidChars(new char[]{65533, ':'});
                strSubstring = "[" + this.lexer.getBuffer().substring(ptr, this.lexer.getPtr()) + "]";
            } else {
                int ptr2 = this.lexer.getPtr();
                consumeDomainLabel();
                strSubstring = this.lexer.getBuffer().substring(ptr2, this.lexer.getPtr());
            }
            if (strSubstring.length() != 0) {
                Host host = new Host(strSubstring);
                if (z) {
                    dbg_leave("host");
                }
                return host;
            }
            throw new ParseException(this.lexer.getBuffer() + ": Missing host name", this.lexer.getPtr());
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("host");
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2 A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:5:0x0009, B:7:0x0017, B:10:0x0020, B:12:0x0028, B:47:0x00a2, B:48:0x00cd, B:35:0x005c, B:37:0x0064, B:38:0x0069, B:40:0x0077, B:41:0x0099, B:42:0x009a), top: B:58:0x0009, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.gov.nist.core.HostPort hostPort(boolean r7) {
        /*
            r6 = this;
            boolean r0 = android.gov.nist.core.ParserCore.debug
            java.lang.String r1 = "hostPort"
            if (r0 == 0) goto L9
            r6.dbg_enter(r1)
        L9:
            android.gov.nist.core.Host r2 = r6.host()     // Catch: java.lang.Throwable -> L1d
            android.gov.nist.core.HostPort r3 = new android.gov.nist.core.HostPort     // Catch: java.lang.Throwable -> L1d
            r3.<init>()     // Catch: java.lang.Throwable -> L1d
            r3.setHost(r2)     // Catch: java.lang.Throwable -> L1d
            if (r7 == 0) goto L20
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            r2.SPorHT()     // Catch: java.lang.Throwable -> L1d
            goto L20
        L1d:
            r7 = move-exception
            goto Ld4
        L20:
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.hasMoreChars()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto Lce
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            r4 = 0
            char r2 = r2.lookAhead(r4)     // Catch: java.lang.Throwable -> L1d
            r5 = 9
            if (r2 == r5) goto Lce
            r5 = 10
            if (r2 == r5) goto Lce
            r5 = 13
            if (r2 == r5) goto Lce
            r5 = 32
            if (r2 == r5) goto Lce
            r5 = 37
            if (r2 == r5) goto L9a
            r5 = 44
            if (r2 == r5) goto Lce
            r5 = 47
            if (r2 == r5) goto Lce
            r5 = 58
            if (r2 == r5) goto L5c
            r5 = 59
            if (r2 == r5) goto Lce
            r5 = 62
            if (r2 == r5) goto Lce
            r5 = 63
            if (r2 == r5) goto Lce
            goto L9f
        L5c:
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            r4 = 1
            r2.consume(r4)     // Catch: java.lang.Throwable -> L1d
            if (r7 == 0) goto L69
            android.gov.nist.core.LexerCore r7 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            r7.SPorHT()     // Catch: java.lang.Throwable -> L1d
        L69:
            android.gov.nist.core.LexerCore r7 = r6.lexer     // Catch: java.lang.Throwable -> L1d java.lang.NumberFormatException -> L77
            java.lang.String r7 = r7.number()     // Catch: java.lang.Throwable -> L1d java.lang.NumberFormatException -> L77
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L1d java.lang.NumberFormatException -> L77
            r3.setPort(r7)     // Catch: java.lang.Throwable -> L1d java.lang.NumberFormatException -> L77
            goto Lce
        L77:
            java.text.ParseException r7 = new java.text.ParseException     // Catch: java.lang.Throwable -> L1d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r0.<init>()     // Catch: java.lang.Throwable -> L1d
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = r2.getBuffer()     // Catch: java.lang.Throwable -> L1d
            r0.append(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = " :Error parsing port "
            r0.append(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1d
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.getPtr()     // Catch: java.lang.Throwable -> L1d
            r7.<init>(r0, r2)     // Catch: java.lang.Throwable -> L1d
            throw r7     // Catch: java.lang.Throwable -> L1d
        L9a:
            boolean r2 = android.gov.nist.core.HostNameParser.stripAddressScopeZones     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L9f
            goto Lce
        L9f:
            if (r7 == 0) goto La2
            goto Lce
        La2:
            java.text.ParseException r7 = new java.text.ParseException     // Catch: java.lang.Throwable -> L1d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r0.<init>()     // Catch: java.lang.Throwable -> L1d
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = r2.getBuffer()     // Catch: java.lang.Throwable -> L1d
            r0.append(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = " Illegal character in hostname:"
            r0.append(r2)     // Catch: java.lang.Throwable -> L1d
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            char r2 = r2.lookAhead(r4)     // Catch: java.lang.Throwable -> L1d
            r0.append(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1d
            android.gov.nist.core.LexerCore r2 = r6.lexer     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.getPtr()     // Catch: java.lang.Throwable -> L1d
            r7.<init>(r0, r2)     // Catch: java.lang.Throwable -> L1d
            throw r7     // Catch: java.lang.Throwable -> L1d
        Lce:
            if (r0 == 0) goto Ld3
            r6.dbg_leave(r1)
        Ld3:
            return r3
        Ld4:
            boolean r0 = android.gov.nist.core.ParserCore.debug
            if (r0 == 0) goto Ldb
            r6.dbg_leave(r1)
        Ldb:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.core.HostNameParser.hostPort(boolean):android.gov.nist.core.HostPort");
    }

    protected String ipv6Reference() {
        int iIndexOf;
        StringBuilder sb = new StringBuilder();
        if (ParserCore.debug) {
            dbg_enter("ipv6Reference");
        }
        try {
            if (!stripAddressScopeZones) {
                while (true) {
                    if (!this.lexer.hasMoreChars()) {
                        break;
                    }
                    char cLookAhead = this.lexer.lookAhead(0);
                    if (!StringTokenizer.isHexDigit(cLookAhead) && cLookAhead != '.' && cLookAhead != ':' && cLookAhead != '[') {
                        if (cLookAhead == ']') {
                            this.lexer.consume(1);
                            sb.append(cLookAhead);
                            String string = sb.toString();
                            if (ParserCore.debug) {
                                dbg_leave("ipv6Reference");
                            }
                            return string;
                        }
                    }
                    this.lexer.consume(1);
                    sb.append(cLookAhead);
                }
            } else {
                while (true) {
                    if (!this.lexer.hasMoreChars()) {
                        break;
                    }
                    char cLookAhead2 = this.lexer.lookAhead(0);
                    if (!StringTokenizer.isHexDigit(cLookAhead2) && cLookAhead2 != '.' && cLookAhead2 != ':' && cLookAhead2 != '[') {
                        if (cLookAhead2 == ']') {
                            this.lexer.consume(1);
                            sb.append(cLookAhead2);
                            return sb.toString();
                        }
                        if (cLookAhead2 == '%') {
                            this.lexer.consume(1);
                            String rest = this.lexer.getRest();
                            if (rest != null && rest.length() != 0 && (iIndexOf = rest.indexOf(93)) != -1) {
                                this.lexer.consume(iIndexOf + 1);
                                sb.append("]");
                                String string2 = sb.toString();
                                if (ParserCore.debug) {
                                    dbg_leave("ipv6Reference");
                                }
                                return string2;
                            }
                        }
                    }
                    this.lexer.consume(1);
                    sb.append(cLookAhead2);
                }
            }
            throw new ParseException(this.lexer.getBuffer() + ": Illegal Host name ", this.lexer.getPtr());
        } finally {
            if (ParserCore.debug) {
                dbg_leave("ipv6Reference");
            }
        }
    }

    public HostNameParser(LexerCore lexerCore) {
        this.lexer = lexerCore;
        lexerCore.selectLexer("charLexer");
    }
}
