package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Ov3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6754Ov3 implements SU2 {
    private final Map c;
    private volatile Map d;

    /* renamed from: ir.nasim.Ov3$a */
    public static final class a {
        private static final String d;
        private static final Map e;
        private boolean a = true;
        private Map b = e;
        private boolean c = true;

        static {
            String strB = b();
            d = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put(SIPHeaderNames.USER_AGENT, Collections.singletonList(new b(strB)));
            }
            e = Collections.unmodifiableMap(map);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public C6754Ov3 a() {
            this.a = true;
            return new C6754Ov3(this.b);
        }
    }

    /* renamed from: ir.nasim.Ov3$b */
    static final class b implements InterfaceC6515Nv3 {
        private final String a;

        b(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC6515Nv3
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    C6754Ov3(Map map) {
        this.c = Collections.unmodifiableMap(map);
    }

    private String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strA = ((InterfaceC6515Nv3) list.get(i)).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map c() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.c.entrySet()) {
            String strB = b((List) entry.getValue());
            if (!TextUtils.isEmpty(strB)) {
                map.put((String) entry.getKey(), strB);
            }
        }
        return map;
    }

    @Override // ir.nasim.SU2
    public Map a() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = Collections.unmodifiableMap(c());
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C6754Ov3) {
            return this.c.equals(((C6754Ov3) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}
