package ir.nasim;

import java.util.LinkedHashMap;

/* loaded from: classes6.dex */
public final class PP0 {
    private static Long b;
    public static final PP0 a = new PP0();
    public static final int c = 8;

    private PP0() {
    }

    public final void a(boolean z) {
        Long l = b;
        if (l != null) {
            long jLongValue = l.longValue();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("duration", Long.valueOf(System.currentTimeMillis() - jLongValue));
            linkedHashMap.put("is_messages_loaded", Boolean.valueOf(z));
            C3343Am.i("open_chat", linkedHashMap);
            b = null;
        }
    }

    public final void b(Long l) {
        b = l;
    }
}
