package android.gov.nist.core;

import java.text.ParseException;

/* loaded from: classes.dex */
public abstract class ParserCore {
    public static final boolean debug = Debug.parserDebug;
    static int nesting_level;
    protected LexerCore lexer;

    protected void dbg_enter(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nesting_level; i++) {
            sb.append(Separators.GREATER_THAN);
        }
        if (debug) {
            System.out.println(((Object) sb) + str + "\nlexer buffer = \n" + this.lexer.getRest());
        }
        nesting_level++;
    }

    protected void dbg_leave(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nesting_level; i++) {
            sb.append(Separators.LESS_THAN);
        }
        if (debug) {
            System.out.println(((Object) sb) + str + "\nlexer buffer = \n" + this.lexer.getRest());
        }
        nesting_level--;
    }

    protected NameValue nameValue(char c) {
        boolean z;
        boolean z2 = debug;
        if (z2) {
            dbg_enter("nameValue");
        }
        try {
            this.lexer.match(4095);
            Token nextToken = this.lexer.getNextToken();
            this.lexer.SPorHT();
            try {
                String strQuotedString = "";
                boolean z3 = true;
                if (this.lexer.lookAhead(0) != c) {
                    NameValue nameValue = new NameValue(nextToken.tokenValue, "", true);
                    if (z2) {
                        dbg_leave("nameValue");
                    }
                    return nameValue;
                }
                this.lexer.consume(1);
                this.lexer.SPorHT();
                char cLookAhead = this.lexer.lookAhead(0);
                if (cLookAhead == '\"') {
                    strQuotedString = this.lexer.quotedString();
                    z = true;
                    z3 = false;
                } else {
                    if (cLookAhead == '[') {
                        this.lexer.match(LexerCore.IPV6);
                        String str = this.lexer.getNextToken().tokenValue;
                        if (str != null) {
                            strQuotedString = str;
                            z3 = false;
                        }
                    } else {
                        this.lexer.match(4095);
                        String str2 = this.lexer.getNextToken().tokenValue;
                        if (str2 != null) {
                            strQuotedString = str2;
                            z = false;
                            z3 = false;
                        }
                    }
                    z = false;
                }
                NameValue nameValue2 = new NameValue(nextToken.tokenValue, strQuotedString, z3);
                if (z) {
                    nameValue2.setQuotedValue();
                }
                if (z2) {
                    dbg_leave("nameValue");
                }
                return nameValue2;
            } catch (ParseException unused) {
                NameValue nameValue3 = new NameValue(nextToken.tokenValue, null, false);
                if (debug) {
                    dbg_leave("nameValue");
                }
                return nameValue3;
            }
        } catch (Throwable th) {
            if (debug) {
                dbg_leave("nameValue");
            }
            throw th;
        }
    }

    protected void peekLine(String str) {
        if (debug) {
            Debug.println(str + Separators.SP + this.lexer.peekLine());
        }
    }

    protected NameValue nameValue() {
        return nameValue('=');
    }
}
