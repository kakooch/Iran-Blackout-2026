package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.xbill.DNS.utils.base16;
import org.xbill.DNS.utils.base32;
import org.xbill.DNS.utils.base64;

/* loaded from: classes8.dex */
public class Tokenizer implements AutoCloseable {
    public static final int COMMENT = 5;
    private static final String DEFAULT_DELIMITERS = " \t\n;()\"";
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int IDENTIFIER = 3;
    public static final int QUOTED_STRING = 4;
    private static final String QUOTES = "\"";
    public static final int WHITESPACE = 2;
    private Token current;
    private String delimiters;
    private String filename;
    private final PushbackInputStream is;
    private int line;
    private int multiline;
    private boolean quoting;
    private final StringBuilder sb;
    private boolean ungottenToken;
    private boolean wantClose;

    public static class Token {

        @Deprecated
        public int type;

        @Deprecated
        public String value;

        public boolean isEOL() {
            int i = this.type;
            return i == 1 || i == 0;
        }

        public boolean isString() {
            int i = this.type;
            return i == 3 || i == 4;
        }

        public String toString() {
            int i = this.type;
            if (i == 0) {
                return "<eof>";
            }
            if (i == 1) {
                return "<eol>";
            }
            if (i == 2) {
                return "<whitespace>";
            }
            if (i == 3) {
                return "<identifier: " + this.value + Separators.GREATER_THAN;
            }
            if (i == 4) {
                return "<quoted_string: " + this.value + Separators.GREATER_THAN;
            }
            if (i != 5) {
                return "<unknown>";
            }
            return "<comment: " + this.value + Separators.GREATER_THAN;
        }

        public int type() {
            return this.type;
        }

        public String value() {
            return this.value;
        }

        private Token(int i, StringBuilder sb) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
            this.type = i;
            this.value = sb == null ? null : sb.toString();
        }
    }

    public Tokenizer(InputStream inputStream) {
        this.is = new PushbackInputStream(inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream), 2);
        this.ungottenToken = false;
        this.multiline = 0;
        this.quoting = false;
        this.delimiters = DEFAULT_DELIMITERS;
        this.sb = new StringBuilder();
        this.filename = "<none>";
        this.line = 1;
    }

    private void checkUnbalancedParens() throws TextParseException {
        if (this.multiline > 0) {
            throw exception("unbalanced parentheses");
        }
    }

    private int getChar() throws IOException {
        int i = this.is.read();
        if (i == 13) {
            int i2 = this.is.read();
            if (i2 != 10) {
                this.is.unread(i2);
            }
            i = 10;
        }
        if (i == 10) {
            this.line++;
        }
        return i;
    }

    private String getIdentifier(String str) throws TextParseException {
        Token token = get();
        if (token.type == 3) {
            return token.value;
        }
        throw exception("expected " + str);
    }

    private String remainingStrings() {
        StringBuilder sb = null;
        while (true) {
            Token token = get();
            if (!token.isString()) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(token.value);
        }
        unget();
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    private Token setCurrentToken(int i, StringBuilder sb) {
        Token token = new Token(i, sb);
        this.current = token;
        return token;
    }

    private int skipWhitespace() throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            i = getChar();
            if (i != 32 && i != 9 && (i != 10 || this.multiline <= 0)) {
                break;
            }
            i2++;
        }
        ungetChar(i);
        return i2;
    }

    private void ungetChar(int i) throws IOException {
        if (i == -1) {
            return;
        }
        this.is.unread(i);
        if (i == 10) {
            this.line--;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.wantClose) {
            try {
                this.is.close();
            } catch (IOException unused) {
            }
        }
    }

    public TextParseException exception(String str) {
        return new TextParseException(this.filename + ":" + this.line + ": " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x012b, code lost:
    
        ungetChar(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0134, code lost:
    
        if (r9.sb.length() != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0136, code lost:
    
        if (r10 == 4) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0138, code lost:
    
        checkUnbalancedParens();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x013f, code lost:
    
        return setCurrentToken(0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0146, code lost:
    
        return setCurrentToken(r10, r9.sb);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.xbill.DNS.Tokenizer.Token get(boolean r10, boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Tokenizer.get(boolean, boolean):org.xbill.DNS.Tokenizer$Token");
    }

    public InetAddress getAddress(int i) throws TextParseException {
        try {
            return Address.getByAddress(getIdentifier("an address"), i);
        } catch (UnknownHostException e) {
            throw exception(e.getMessage());
        }
    }

    public byte[] getAddressBytes(int i) throws TextParseException {
        String identifier = getIdentifier("an address");
        byte[] v4 = i == 1 ? IPAddressUtils.parseV4(identifier) : i == 2 ? IPAddressUtils.parseV6(identifier) : null;
        if (v4 != null) {
            return v4;
        }
        throw exception("Invalid address: " + identifier);
    }

    public byte[] getBase32String(base32 base32Var) throws IOException {
        byte[] bArrFromString = base32Var.fromString(getIdentifier("a base32 string"));
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid base32 encoding");
    }

    public byte[] getBase64(boolean z) throws IOException {
        String strRemainingStrings = remainingStrings();
        if (strRemainingStrings == null) {
            if (z) {
                throw exception("expected base64 encoded string");
            }
            return null;
        }
        byte[] bArrFromString = base64.fromString(strRemainingStrings);
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid base64 encoding");
    }

    public void getEOL() throws TextParseException {
        int i = get().type;
        if (i != 1 && i != 0) {
            throw exception("expected EOL or EOF");
        }
    }

    public byte[] getHex(boolean z) throws TextParseException {
        String strRemainingStrings = remainingStrings();
        if (strRemainingStrings == null) {
            if (z) {
                throw exception("expected hex encoded string");
            }
            return null;
        }
        byte[] bArrFromString = base16.fromString(strRemainingStrings);
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid hex encoding");
    }

    public byte[] getHexString() throws TextParseException {
        byte[] bArrFromString = base16.fromString(getIdentifier("a hex string"));
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid hex encoding");
    }

    public long getLong() throws TextParseException {
        String identifier = getIdentifier("an integer");
        if (!Character.isDigit(identifier.charAt(0))) {
            throw exception("expected an integer");
        }
        try {
            return Long.parseLong(identifier);
        } catch (NumberFormatException unused) {
            throw exception("expected an integer");
        }
    }

    public Name getName(Name name) throws TextParseException {
        try {
            Name nameFromString = Name.fromString(getIdentifier("a name"), name);
            if (nameFromString.isAbsolute()) {
                return nameFromString;
            }
            throw new RelativeNameException(nameFromString);
        } catch (TextParseException e) {
            throw exception(e.getMessage());
        }
    }

    public String getString() throws TextParseException {
        Token token = get();
        if (token.isString()) {
            return token.value;
        }
        throw exception("expected a string");
    }

    public long getTTL() throws TextParseException {
        try {
            return TTL.parseTTL(getIdentifier("a TTL value"));
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL value");
        }
    }

    public long getTTLLike() throws TextParseException {
        try {
            return TTL.parse(getIdentifier("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL-like value");
        }
    }

    public int getUInt16() {
        long j = getLong();
        if (Utils.isUInt16(j)) {
            return (int) j;
        }
        throw exception("expected an 16 bit unsigned integer");
    }

    public long getUInt32() throws TextParseException {
        long j = getLong();
        if (Utils.isUInt32(j)) {
            return j;
        }
        throw exception("expected an 32 bit unsigned integer");
    }

    public int getUInt8() throws TextParseException {
        long j = getLong();
        if (Utils.isUInt8(j)) {
            return (int) j;
        }
        throw exception("expected an 8 bit unsigned integer");
    }

    public void unget() {
        if (this.ungottenToken) {
            throw new IllegalStateException("Cannot unget multiple tokens");
        }
        if (this.current.type == 1) {
            this.line--;
        }
        this.ungottenToken = true;
    }

    public byte[] getBase64() {
        return getBase64(false);
    }

    public byte[] getHex() {
        return getHex(false);
    }

    public String getIdentifier() {
        return getIdentifier("an identifier");
    }

    public Tokenizer(String str) {
        this(new ByteArrayInputStream(str.getBytes()));
    }

    public Tokenizer(File file) {
        this(new FileInputStream(file));
        this.wantClose = true;
        this.filename = file.getName();
    }

    public Token get() {
        return get(false, false);
    }
}
