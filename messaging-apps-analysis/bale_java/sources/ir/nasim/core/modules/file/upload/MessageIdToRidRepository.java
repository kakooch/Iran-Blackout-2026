package ir.nasim.core.modules.file.upload;

import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.ED1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.KS2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class MessageIdToRidRepository {
    private static final a e = new a(null);
    public static final int f = 8;
    private final KS2 a;
    private final InterfaceC3570Bk5 b;
    private final String c;
    public Map d;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public MessageIdToRidRepository(KS2 ks2, InterfaceC3570Bk5 interfaceC3570Bk5, String str) {
        AbstractC13042fc3.i(ks2, "gson");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(str, "storageKey");
        this.a = ks2;
        this.b = interfaceC3570Bk5;
        this.c = str;
    }

    private final Map d() {
        Object objB;
        String strE;
        try {
            C9475a16.a aVar = C9475a16.b;
            strE = this.b.e(this.c);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (strE == null) {
            return null;
        }
        objB = C9475a16.b((Map) this.a.l(strE, new TypeToken<Map<Long, Long>>() { // from class: ir.nasim.core.modules.file.upload.MessageIdToRidRepository$loadMapFromPreferences$1$type$1
        }.d()));
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.c("MessageIdToRidRepository", "Failed to load the items from the preferences.", thE);
        }
        return (Map) (C9475a16.g(objB) ? null : objB);
    }

    private final Object f() {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            this.b.putString(this.c, this.a.t(b()));
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.c("MessageIdToRidRepository", "Failed to save the items into the preferences.", thE);
        }
        return objB;
    }

    public final Long a(long j) {
        return (Long) b().get(Long.valueOf(j));
    }

    public final Map b() {
        Map map = this.d;
        if (map != null) {
            return map;
        }
        AbstractC13042fc3.y("map");
        return null;
    }

    public final void c() {
        Map mapD = d();
        if (mapD == null) {
            mapD = new HashMap();
        }
        g(mapD);
    }

    public final void e(long j, long j2) {
        Long l = (Long) b().put(Long.valueOf(j), Long.valueOf(j2));
        if (l != null && l.longValue() == j2) {
            return;
        }
        f();
    }

    public final void g(Map map) {
        AbstractC13042fc3.i(map, "<set-?>");
        this.d = map;
    }

    public /* synthetic */ MessageIdToRidRepository(KS2 ks2, InterfaceC3570Bk5 interfaceC3570Bk5, String str, int i, ED1 ed1) {
        this(ks2, interfaceC3570Bk5, (i & 4) != 0 ? "Upload_MessageId_To_Rid_Key" : str);
    }
}
