package android.gov.nist.core;

/* loaded from: classes.dex */
public class Token {
    protected int tokenType;
    protected String tokenValue;

    public int getTokenType() {
        return this.tokenType;
    }

    public String getTokenValue() {
        return this.tokenValue;
    }

    public String toString() {
        return "tokenValue = " + this.tokenValue + "/tokenType = " + this.tokenType;
    }
}
