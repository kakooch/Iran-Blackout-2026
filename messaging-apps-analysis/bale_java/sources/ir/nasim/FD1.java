package ir.nasim;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class FD1 implements InterfaceC8806Xk1 {
    public static final FD1 c = new FD1(Collections.emptyMap());
    private int a;
    private final Map b;

    public FD1(Map map) {
        this.b = Collections.unmodifiableMap(map);
    }

    private static void e(HashMap map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            map.put((String) entry.getKey(), i(entry.getValue()));
        }
    }

    private static Map f(Map map, C9315Zk1 c9315Zk1) {
        HashMap map2 = new HashMap(map);
        k(map2, c9315Zk1.c());
        e(map2, c9315Zk1.b());
        return map2;
    }

    private static byte[] i(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(AbstractC12884fL0.c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean j(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void k(HashMap map, List list) {
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }
    }

    @Override // ir.nasim.InterfaceC8806Xk1
    public final long c(String str, long j) {
        byte[] bArr = (byte[]) this.b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j;
    }

    @Override // ir.nasim.InterfaceC8806Xk1
    public final String d(String str, String str2) {
        byte[] bArr = (byte[]) this.b.get(str);
        return bArr != null ? new String(bArr, AbstractC12884fL0.c) : str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FD1.class != obj.getClass()) {
            return false;
        }
        return j(this.b, ((FD1) obj).b);
    }

    public FD1 g(C9315Zk1 c9315Zk1) {
        Map mapF = f(this.b, c9315Zk1);
        return j(this.b, mapF) ? this : new FD1(mapF);
    }

    public Set h() {
        return this.b.entrySet();
    }

    public int hashCode() {
        if (this.a == 0) {
            int iHashCode = 0;
            for (Map.Entry entry : this.b.entrySet()) {
                iHashCode += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.a = iHashCode;
        }
        return this.a;
    }
}
