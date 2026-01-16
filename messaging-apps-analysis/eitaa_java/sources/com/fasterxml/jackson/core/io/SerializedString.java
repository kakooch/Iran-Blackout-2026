package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SerializedString implements SerializableString, Serializable {
    private static final JsonStringEncoder JSON_ENCODER = JsonStringEncoder.getInstance();
    protected char[] _quotedChars;
    protected final String _value;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this._value = str;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final String getValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final char[] asQuotedChars() {
        char[] cArr = this._quotedChars;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrQuoteAsString = JSON_ENCODER.quoteAsString(this._value);
        this._quotedChars = cArrQuoteAsString;
        return cArrQuoteAsString;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int appendQuoted(char[] cArr, int i) {
        char[] cArrQuoteAsString = this._quotedChars;
        if (cArrQuoteAsString == null) {
            cArrQuoteAsString = JSON_ENCODER.quoteAsString(this._value);
            this._quotedChars = cArrQuoteAsString;
        }
        int length = cArrQuoteAsString.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArrQuoteAsString, 0, cArr, i, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int appendUnquoted(char[] cArr, int i) {
        String str = this._value;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    public final String toString() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SerializedString.class) {
            return false;
        }
        return this._value.equals(((SerializedString) obj)._value);
    }
}
