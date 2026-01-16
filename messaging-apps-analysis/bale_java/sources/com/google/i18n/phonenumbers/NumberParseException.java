package com.google.i18n.phonenumbers;

/* loaded from: classes3.dex */
public class NumberParseException extends Exception {
    private a a;
    private String b;

    public enum a {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(a aVar, String str) {
        super(str);
        this.b = str;
        this.a = aVar;
    }

    public a a() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.a + ". " + this.b;
    }
}
