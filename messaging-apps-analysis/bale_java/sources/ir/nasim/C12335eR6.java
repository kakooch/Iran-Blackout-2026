package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.eR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12335eR6 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C11692dR6 a;
    private final QQ6 b;

    /* renamed from: ir.nasim.eR6$a */
    public static final class a {
        private a() {
        }

        public final List a(Map map) {
            AbstractC13042fc3.i(map, "map");
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) entry.getValue()));
            }
            return arrayList;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12335eR6(C11692dR6 c11692dR6, QQ6 qq6) {
        AbstractC13042fc3.i(c11692dR6, "storyKey");
        AbstractC13042fc3.i(qq6, "storyItem");
        this.a = c11692dR6;
        this.b = qq6;
    }

    public final QQ6 a() {
        return this.b;
    }

    public final C11692dR6 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12335eR6)) {
            return false;
        }
        C12335eR6 c12335eR6 = (C12335eR6) obj;
        return AbstractC13042fc3.d(this.a, c12335eR6.a) && AbstractC13042fc3.d(this.b, c12335eR6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "StoryKeyItem(storyKey=" + this.a + ", storyItem=" + this.b + Separators.RPAREN;
    }
}
