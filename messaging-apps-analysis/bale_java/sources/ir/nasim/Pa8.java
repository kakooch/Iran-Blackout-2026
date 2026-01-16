package ir.nasim;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class Pa8 extends Oa8 {
    private static final String j = HI3.f("WorkContinuationImpl");
    private final Za8 a;
    private final String b;
    private final EnumC23850xd2 c;
    private final List d;
    private final List e;
    private final List f;
    private final List g;
    private boolean h;
    private InterfaceC15297jL4 i;

    public Pa8(Za8 za8, List list) {
        this(za8, null, EnumC23850xd2.KEEP, list, null);
    }

    private static boolean i(Pa8 pa8, Set set) {
        set.addAll(pa8.c());
        Set setL = l(pa8);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (setL.contains((String) it.next())) {
                return true;
            }
        }
        List listE = pa8.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator it2 = listE.iterator();
            while (it2.hasNext()) {
                if (i((Pa8) it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(pa8.c());
        return false;
    }

    public static Set l(Pa8 pa8) {
        HashSet hashSet = new HashSet();
        List listE = pa8.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((Pa8) it.next()).c());
            }
        }
        return hashSet;
    }

    public InterfaceC15297jL4 a() {
        if (this.h) {
            HI3.c().h(j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.e)), new Throwable[0]);
        } else {
            Z82 z82 = new Z82(this);
            this.a.p().b(z82);
            this.i = z82.d();
        }
        return this.i;
    }

    public EnumC23850xd2 b() {
        return this.c;
    }

    public List c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public List e() {
        return this.g;
    }

    public List f() {
        return this.d;
    }

    public Za8 g() {
        return this.a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.h;
    }

    public void k() {
        this.h = true;
    }

    public Pa8(Za8 za8, String str, EnumC23850xd2 enumC23850xd2, List list, List list2) {
        this.a = za8;
        this.b = str;
        this.c = enumC23850xd2;
        this.d = list;
        this.g = list2;
        this.e = new ArrayList(list.size());
        this.f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f.addAll(((Pa8) it.next()).f);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String strA = ((AbstractC16037kb8) list.get(i)).a();
            this.e.add(strA);
            this.f.add(strA);
        }
    }
}
