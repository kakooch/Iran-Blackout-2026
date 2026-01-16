package ir.nasim;

import android.gov.nist.javax.sdp.fields.SDPKeywords;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Vm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC8326Vm3 {
    public static final EnumC8326Vm3 a = new EnumC8326Vm3("INVARIANT", 0);
    public static final EnumC8326Vm3 b = new EnumC8326Vm3(SDPKeywords.IN, 1);
    public static final EnumC8326Vm3 c = new EnumC8326Vm3("OUT", 2);
    private static final /* synthetic */ EnumC8326Vm3[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC8326Vm3[] enumC8326Vm3ArrA = a();
        d = enumC8326Vm3ArrA;
        e = G92.a(enumC8326Vm3ArrA);
    }

    private EnumC8326Vm3(String str, int i) {
    }

    private static final /* synthetic */ EnumC8326Vm3[] a() {
        return new EnumC8326Vm3[]{a, b, c};
    }

    public static EnumC8326Vm3 valueOf(String str) {
        return (EnumC8326Vm3) Enum.valueOf(EnumC8326Vm3.class, str);
    }

    public static EnumC8326Vm3[] values() {
        return (EnumC8326Vm3[]) d.clone();
    }
}
