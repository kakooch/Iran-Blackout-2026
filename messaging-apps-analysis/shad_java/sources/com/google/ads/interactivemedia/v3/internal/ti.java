package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ti extends ta<tg> {
    private static final dg a;
    private final List<tg> b;
    private final Set<tf> c;
    private Handler d;
    private final List<tg> e;
    private final IdentityHashMap<tv, tg> f;
    private final Map<Object, tg> g;
    private final Set<tg> h;
    private boolean i;
    private Set<tf> j;
    private ve k;

    static {
        db dbVar = new db();
        dbVar.h(Uri.EMPTY);
        a = dbVar.a();
    }

    public ti(ve veVar, ty... tyVarArr) {
        this.k = veVar.a() > 0 ? veVar.h() : veVar;
        this.f = new IdentityHashMap<>();
        this.g = new HashMap();
        this.b = new ArrayList();
        this.e = new ArrayList();
        this.j = new HashSet();
        this.c = new HashSet();
        this.h = new HashSet();
        E(Arrays.asList(tyVarArr));
    }

    private final void J() {
        K(null);
    }

    private final void K(tf tfVar) {
        if (this.i) {
            return;
        }
        M().obtainMessage(4).sendToTarget();
        this.i = true;
    }

    private final void L() {
        this.i = false;
        Set<tf> set = this.j;
        this.j = new HashSet();
        e(new td(this.e, this.k));
        M().obtainMessage(5, set).sendToTarget();
    }

    private final Handler M() {
        Handler handler = this.d;
        ary.t(handler);
        return handler;
    }

    private final synchronized void N(Set<tf> set) {
        Iterator<tf> it = set.iterator();
        if (it.hasNext()) {
            it.next();
            throw null;
        }
        this.c.removeAll(set);
    }

    private final void O(int i, Collection<tg> collection) {
        for (tg tgVar : collection) {
            int i2 = i + 1;
            if (i > 0) {
                tg tgVar2 = this.e.get(i - 1);
                tgVar.a(i, tgVar2.e + tgVar2.a.C().s());
            } else {
                tgVar.a(i, 0);
            }
            Q(i, 1, tgVar.a.C().s());
            this.e.add(i, tgVar);
            this.g.put(tgVar.b, tgVar);
            v(tgVar, tgVar.a);
            if (j() && this.f.isEmpty()) {
                this.h.add(tgVar);
            } else {
                x(tgVar);
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.ads.interactivemedia.v3.internal.ta
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final void B(tg tgVar, es esVar) {
        if (tgVar.d + 1 < this.e.size()) {
            int iS = esVar.s() - (this.e.get(tgVar.d + 1).e - tgVar.e);
            if (iS != 0) {
                Q(tgVar.d + 1, 0, iS);
            }
        }
        J();
    }

    private final void Q(int i, int i2, int i3) {
        while (i < this.e.size()) {
            tg tgVar = this.e.get(i);
            tgVar.d += i2;
            tgVar.e += i3;
            i++;
        }
    }

    private final void R(tg tgVar) {
        if (tgVar.f && tgVar.c.isEmpty()) {
            this.h.remove(tgVar);
            y(tgVar);
        }
    }

    private final void S() {
        Iterator<tg> it = this.h.iterator();
        while (it.hasNext()) {
            tg next = it.next();
            if (next.c.isEmpty()) {
                x(next);
                it.remove();
            }
        }
    }

    private final void T(int i, Collection<ty> collection) {
        ary.o(true);
        Handler handler = this.d;
        Iterator<ty> it = collection.iterator();
        while (it.hasNext()) {
            ary.t(it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<ty> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new tg(it2.next()));
        }
        this.b.addAll(i, arrayList);
        if (handler == null || collection.isEmpty()) {
            return;
        }
        handler.obtainMessage(0, new th(i, arrayList, null)).sendToTarget();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta
    protected final /* bridge */ /* synthetic */ tw A(tg tgVar, tw twVar) {
        int i = 0;
        while (true) {
            tg tgVar2 = tgVar;
            if (i >= tgVar2.c.size()) {
                return null;
            }
            if (tgVar2.c.get(i).d == twVar.d) {
                return twVar.a(Pair.create(tgVar2.b, twVar.a));
            }
            i++;
        }
    }

    public final synchronized void C(ty tyVar) {
        D(this.b.size(), tyVar);
    }

    public final synchronized void D(int i, ty tyVar) {
        T(i, Collections.singletonList(tyVar));
    }

    public final synchronized void E(Collection<ty> collection) {
        T(this.b.size(), collection);
    }

    public final synchronized ty F(int i) {
        return this.b.get(i).a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd A[LOOP:1: B:29:0x00cb->B:30:0x00cd, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* bridge */ /* synthetic */ boolean H(android.os.Message r8) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ti.H(android.os.Message):boolean");
    }

    public final synchronized void I(int i) {
        F(i);
        int i2 = i + 1;
        ary.o(true);
        Handler handler = this.d;
        aeu.e(this.b, i, i2);
        if (handler != null) {
            handler.obtainMessage(1, new th(i, Integer.valueOf(i2), null)).sendToTarget();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final dg U() {
        return a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void V(tv tvVar) {
        tg tgVarRemove = this.f.remove(tvVar);
        ary.t(tgVarRemove);
        tgVarRemove.a.V(tvVar);
        tgVarRemove.c.remove(((tp) tvVar).b);
        if (!this.f.isEmpty()) {
            S();
        }
        R(tgVarRemove);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final tv W(tw twVar, acc accVar, long j) {
        Object objA = ay.a(twVar.a);
        tw twVarA = twVar.a(ay.b(twVar.a));
        tg tgVar = this.g.get(objA);
        if (tgVar == null) {
            tgVar = new tg(new te(null));
            tgVar.f = true;
            v(tgVar, tgVar.a);
        }
        this.h.add(tgVar);
        w(tgVar);
        tgVar.c.add(twVarA);
        tp tpVarW = tgVar.a.W(twVarA, accVar, j);
        this.f.put(tpVarW, tgVar);
        S();
        return tpVarW;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ss
    protected final void X() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ss
    protected final synchronized void a(adh adhVar) {
        super.a(adhVar);
        this.d = new Handler(new Handler.Callback(this) { // from class: com.google.ads.interactivemedia.v3.internal.tc
            private final ti a;

            {
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                this.a.H(message);
                return true;
            }
        });
        if (this.b.isEmpty()) {
            L();
            return;
        }
        this.k = this.k.f(0, this.b.size());
        O(0, this.b);
        J();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ss
    protected final void c() {
        super.c();
        this.h.clear();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ss
    protected final synchronized void d() {
        super.d();
        this.e.clear();
        this.h.clear();
        this.g.clear();
        this.k = this.k.h();
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
        this.i = false;
        this.j.clear();
        N(this.c);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss, com.google.ads.interactivemedia.v3.internal.ty
    public final synchronized es r() {
        return new td(this.b, this.k.a() != this.b.size() ? this.k.h().f(0, this.b.size()) : this.k);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss, com.google.ads.interactivemedia.v3.internal.ty
    public final boolean s() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta
    protected final /* bridge */ /* synthetic */ int z(tg tgVar, int i) {
        return i + tgVar.e;
    }
}
