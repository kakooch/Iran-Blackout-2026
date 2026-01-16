package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class ParserMinimalBase extends JsonParser {
    protected static final BigDecimal BD_MAX_INT;
    protected static final BigDecimal BD_MAX_LONG;
    protected static final BigDecimal BD_MIN_INT;
    protected static final BigDecimal BD_MIN_LONG;
    protected static final BigInteger BI_MAX_INT;
    protected static final BigInteger BI_MAX_LONG;
    protected static final BigInteger BI_MIN_INT;
    protected static final BigInteger BI_MIN_LONG;
    protected static final byte[] NO_BYTES = new byte[0];
    protected static final int[] NO_INTS = new int[0];
    protected JsonToken _currToken;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        BI_MIN_INT = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        BI_MAX_INT = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        BI_MIN_LONG = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        BI_MAX_LONG = bigIntegerValueOf4;
        BD_MIN_LONG = new BigDecimal(bigIntegerValueOf3);
        BD_MAX_LONG = new BigDecimal(bigIntegerValueOf4);
        BD_MIN_INT = new BigDecimal(bigIntegerValueOf);
        BD_MAX_INT = new BigDecimal(bigIntegerValueOf2);
    }

    protected ParserMinimalBase(int i) {
        super(i);
    }
}
