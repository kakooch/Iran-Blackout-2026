package ir.nasim;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.uM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C21921uM5 {
    private a a;

    /* renamed from: ir.nasim.uM5$a */
    private static class a {
        private LinkedHashMap a;
        private int b;

        /* renamed from: ir.nasim.uM5$a$a, reason: collision with other inner class name */
        class C1633a extends LinkedHashMap {
            C1633a(int i, float f, boolean z) {
                super(i, f, z);
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > a.this.b;
            }
        }

        public a(int i) {
            this.b = i;
            this.a = new C1633a(((i * 4) / 3) + 1, 0.75f, true);
        }

        public synchronized Object b(Object obj) {
            return this.a.get(obj);
        }

        public synchronized void c(Object obj, Object obj2) {
            this.a.put(obj, obj2);
        }
    }

    public C21921uM5(int i) {
        this.a = new a(i);
    }

    public Pattern a(String str) {
        Pattern pattern = (Pattern) this.a.b(str);
        if (pattern != null) {
            return pattern;
        }
        Pattern patternCompile = Pattern.compile(str);
        this.a.c(str, patternCompile);
        return patternCompile;
    }
}
