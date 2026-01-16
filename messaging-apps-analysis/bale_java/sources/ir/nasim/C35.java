package ir.nasim;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class C35 {
    private boolean a = false;
    private final Set b = new PJ();
    private final Map c = new HashMap();
    private final Comparator d = new a();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(YV4 yv4, YV4 yv42) {
            float fFloatValue = ((Float) yv4.b).floatValue();
            float fFloatValue2 = ((Float) yv42.b).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public void a(String str, float f) {
        if (this.a) {
            YV3 yv3 = (YV3) this.c.get(str);
            if (yv3 == null) {
                yv3 = new YV3();
                this.c.put(str, yv3);
            }
            yv3.a(f);
            if (str.equals("__container")) {
                Iterator it = this.b.iterator();
                if (it.hasNext()) {
                    AbstractC18350oW3.a(it.next());
                    throw null;
                }
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
