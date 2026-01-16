package ir.nasim;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pr7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class EnumC19151pr7 implements InterfaceC19742qr7 {
    public static final EnumC19151pr7 a;
    public static final EnumC19151pr7 b;
    public static final EnumC19151pr7 c;
    public static final EnumC19151pr7 d;
    private static final /* synthetic */ EnumC19151pr7[] e;

    /* renamed from: ir.nasim.pr7$a */
    enum a extends EnumC19151pr7 {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // ir.nasim.InterfaceC19742qr7
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Double a(C12523el3 c12523el3) {
            return Double.valueOf(c12523el3.f1());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        a = aVar;
        EnumC19151pr7 enumC19151pr7 = new EnumC19151pr7("LAZILY_PARSED_NUMBER", 1) { // from class: ir.nasim.pr7.b
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC19742qr7
            public Number a(C12523el3 c12523el3) {
                return new C8632Wu3(c12523el3.T0());
            }
        };
        b = enumC19151pr7;
        EnumC19151pr7 enumC19151pr72 = new EnumC19151pr7("LONG_OR_DOUBLE", 2) { // from class: ir.nasim.pr7.c
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC19742qr7
            public Number a(C12523el3 c12523el3) throws IOException, NumberFormatException {
                String strT0 = c12523el3.T0();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strT0));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strT0);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!c12523el3.m()) {
                                throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + c12523el3.k());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e2) {
                    throw new JsonParseException("Cannot parse " + strT0 + "; at path " + c12523el3.k(), e2);
                }
            }
        };
        c = enumC19151pr72;
        EnumC19151pr7 enumC19151pr73 = new EnumC19151pr7("BIG_DECIMAL", 3) { // from class: ir.nasim.pr7.d
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC19742qr7
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(C12523el3 c12523el3) throws IOException {
                String strT0 = c12523el3.T0();
                try {
                    return new BigDecimal(strT0);
                } catch (NumberFormatException e2) {
                    throw new JsonParseException("Cannot parse " + strT0 + "; at path " + c12523el3.k(), e2);
                }
            }
        };
        d = enumC19151pr73;
        e = new EnumC19151pr7[]{aVar, enumC19151pr7, enumC19151pr72, enumC19151pr73};
    }

    private EnumC19151pr7(String str, int i) {
    }

    public static EnumC19151pr7 valueOf(String str) {
        return (EnumC19151pr7) Enum.valueOf(EnumC19151pr7.class, str);
    }

    public static EnumC19151pr7[] values() {
        return (EnumC19151pr7[]) e.clone();
    }

    /* synthetic */ EnumC19151pr7(String str, int i, a aVar) {
        this(str, i);
    }
}
