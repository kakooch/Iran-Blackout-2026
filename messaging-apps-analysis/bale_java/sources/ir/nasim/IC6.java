package ir.nasim;

import com.google.android.exoplayer2.C2018a0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
public final class IC6 implements HC6 {
    public static final IC6 a = new IC6();
    private static final HashSet b = new HashSet();
    private static final HashSet c = new HashSet();
    private static final HashMap d = new HashMap();
    private static final InterfaceC19086pl2 e;
    public static final int f;

    static {
        C92 c92 = C92.a;
        e = (InterfaceC19086pl2) C92.a(C5721Ko.a.d(), InterfaceC19086pl2.class);
        f = 8;
    }

    private IC6() {
    }

    private final void h(com.google.android.exoplayer2.E0 e0) {
        e0.stop();
        e0.g(1.0f);
        e0.t();
        e0.R(null);
        e0.v(null);
        e0.j(null);
    }

    @Override // ir.nasim.HC6
    public void a(Object obj, com.google.android.exoplayer2.E0 e0) {
        AbstractC13042fc3.i(obj, "owner");
        AbstractC13042fc3.i(e0, "player");
        HashMap map = d;
        Set set = (Set) map.get(e0);
        if (set != null) {
            set.remove(obj);
            if (set.isEmpty()) {
                a.g(e0);
                map.remove(e0);
            }
        }
        C19406qI3.a("SimpleExoPlayerPoolImpl", "releaseShared(" + obj + ", " + e0 + ") ---> pool: " + b + ", sharedPool: " + c + ", owners: " + map, new Object[0]);
    }

    @Override // ir.nasim.HC6
    public com.google.android.exoplayer2.E0 c() {
        HashSet hashSet = b;
        com.google.android.exoplayer2.E0 e0Q0 = (com.google.android.exoplayer2.E0) AbstractC15401jX0.r0(hashSet);
        AbstractC19810qy7.a(hashSet).remove(e0Q0);
        if (e0Q0 == null) {
            e0Q0 = e.q0();
        }
        C19406qI3.a("SimpleExoPlayerPoolImpl", "obtain(): " + e0Q0 + " ---> pool: " + hashSet + ", sharedPool: " + c + ", owners: " + d, new Object[0]);
        return e0Q0;
    }

    @Override // ir.nasim.HC6
    public void d(com.google.android.exoplayer2.E0 e0, Object obj) {
        AbstractC13042fc3.i(e0, "player");
        HashSet hashSet = b;
        hashSet.remove(e0);
        HashSet hashSet2 = c;
        hashSet2.add(e0);
        HashMap map = d;
        Object hashSet3 = map.get(e0);
        if (hashSet3 == null) {
            hashSet3 = new HashSet();
            map.put(e0, hashSet3);
        }
        Set set = (Set) hashSet3;
        if (obj != null) {
            set.add(obj);
        }
        C19406qI3.a("SimpleExoPlayerPoolImpl", "share(" + e0 + ") ---> pool: " + hashSet + ", sharedPool: " + hashSet2 + ", owners: " + map, new Object[0]);
    }

    @Override // ir.nasim.HC6
    public com.google.android.exoplayer2.E0 f(String str, Object obj, boolean z) {
        com.google.android.exoplayer2.E0 e0;
        Object next;
        AbstractC13042fc3.i(str, "mediaId");
        AbstractC13042fc3.i(obj, "owner");
        Iterator it = c.iterator();
        while (true) {
            e0 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            C2018a0 c2018a0N = ((com.google.android.exoplayer2.E0) next).n();
            if (AbstractC13042fc3.d(c2018a0N != null ? c2018a0N.a : null, str)) {
                break;
            }
        }
        com.google.android.exoplayer2.E0 e02 = (com.google.android.exoplayer2.E0) next;
        if (e02 != null) {
            if (z) {
                c.remove(e02);
                d.remove(e02);
            } else {
                Set set = (Set) d.get(e02);
                if (set != null) {
                    set.add(obj);
                }
            }
            e0 = e02;
        }
        if (e0 == null) {
            C19406qI3.a("SimpleExoPlayerPoolImpl", "failed to obtainShared(" + str + ", " + obj + ", " + z + ") ---> pool: " + b + ", sharedPool: " + c + ", owners: " + d, new Object[0]);
        } else {
            C19406qI3.a("SimpleExoPlayerPoolImpl", e0 + " obtainShared(" + str + ", " + obj + ", " + z + ") ---> pool: " + b + ", sharedPool: " + c + ", owners: " + d, new Object[0]);
        }
        return e0;
    }

    public void g(com.google.android.exoplayer2.E0 e0) {
        AbstractC13042fc3.i(e0, "player");
        h(e0);
        HashSet hashSet = b;
        hashSet.add(e0);
        HashSet hashSet2 = c;
        hashSet2.remove(e0);
        C19406qI3.a("SimpleExoPlayerPoolImpl", "recycle(" + e0 + ") ---> pool: " + hashSet + ", sharedPool: " + hashSet2 + ", owners: " + d, new Object[0]);
    }
}
