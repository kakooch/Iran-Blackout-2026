package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.vS4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC22564vS4 {
    ASAN_PARDAKHT("AsanPardakht"),
    SADAD_PSP("SadadPSP"),
    UNSUPPORTED_VALUE("UNSUPPORTED_VALUE");

    private String a;

    EnumC22564vS4(String str) {
        this.a = str;
    }

    public static EnumC22564vS4 j(String str) throws IOException {
        str.hashCode();
        if (str.equals("AsanPardakht")) {
            return ASAN_PARDAKHT;
        }
        if (str.equals("SadadPSP")) {
            return SADAD_PSP;
        }
        throw new IOException(UNSUPPORTED_VALUE.getValue());
    }

    public String getValue() {
        return this.a;
    }
}
