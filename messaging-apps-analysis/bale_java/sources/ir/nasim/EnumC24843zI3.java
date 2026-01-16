package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.parser.TokenNames;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.zI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC24843zI3 {
    public static final EnumC24843zI3 b = new EnumC24843zI3("Verbose", 0, TokenNames.V);
    public static final EnumC24843zI3 c = new EnumC24843zI3("Debug", 1, "D");
    public static final EnumC24843zI3 d = new EnumC24843zI3("Info", 2, TokenNames.I);
    public static final EnumC24843zI3 e = new EnumC24843zI3(SIPHeaderNames.WARNING, 3, "W");
    public static final EnumC24843zI3 f = new EnumC24843zI3("Error", 4, TokenNames.E);
    private static final /* synthetic */ EnumC24843zI3[] g;
    private static final /* synthetic */ F92 h;
    private final String a;

    static {
        EnumC24843zI3[] enumC24843zI3ArrA = a();
        g = enumC24843zI3ArrA;
        h = G92.a(enumC24843zI3ArrA);
    }

    private EnumC24843zI3(String str, int i, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC24843zI3[] a() {
        return new EnumC24843zI3[]{b, c, d, e, f};
    }

    public static EnumC24843zI3 valueOf(String str) {
        return (EnumC24843zI3) Enum.valueOf(EnumC24843zI3.class, str);
    }

    public static EnumC24843zI3[] values() {
        return (EnumC24843zI3[]) g.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
