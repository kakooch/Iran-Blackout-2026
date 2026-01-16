package ir.nasim;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Pp6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6937Pp6 extends AbstractC17902nl0 {
    private static volatile C6937Pp6 d;
    static final Object e = new Object();
    private Map a = new LinkedHashMap();
    private Map b = new LinkedHashMap();
    private boolean c = false;

    private C6937Pp6() {
    }

    public static C6937Pp6 y() {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new C6937Pp6();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public void C(List list) {
        synchronized (e) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    UB ub = (UB) it.next();
                    this.b.put(Integer.valueOf(ub.q().q()), ub);
                    this.a.put(Integer.valueOf(ub.q().q()), Integer.valueOf(ub.r()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void D(int i, int i2) {
        synchronized (e) {
            try {
                this.a.put(Integer.valueOf(i), Integer.valueOf(i2));
                UB ub = (UB) this.b.get(Integer.valueOf(i));
                if (ub == null) {
                    ub = new UB(new C25238zy(i, -1L), i2, new byte[0]);
                }
                this.b.put(Integer.valueOf(i), new UB(ub.q(), i2, ub.s()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C6937Pp6 E(OK ok) {
        C9863ah0 c9863ah0;
        Map map = this.a;
        if ((map == null || map.isEmpty()) && (c9863ah0 = (C9863ah0) ok.n(4L)) != null) {
            try {
                z(c9863ah0.q());
            } catch (IOException e2) {
                C19406qI3.c("SequenceStateStorage", "withCheckDataLoaded", e2);
            }
        }
        return this;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        List listN = c19084pl0.n(1);
        int iM = c19084pl0.m(2);
        ArrayList arrayList = new ArrayList(iM);
        for (int i = 0; i < iM; i++) {
            arrayList.add(new UB());
        }
        List listP = c19084pl0.p(2, arrayList);
        this.b = new LinkedHashMap();
        for (int i2 = 0; i2 < iM; i2++) {
            this.b.put((Integer) listN.get(i2), (UB) listP.get(i2));
        }
    }

    public void q(int i, long j, byte[] bArr) {
        synchronized (e) {
            this.b.put(Integer.valueOf(i), new UB(new C25238zy(i, j), -1, bArr));
        }
    }

    public void r(int i) {
        this.a.remove(Integer.valueOf(i));
        this.b.remove(Integer.valueOf(i));
    }

    public List s() {
        ArrayList arrayList;
        synchronized (e) {
            try {
                arrayList = new ArrayList();
                for (UB ub : this.b.values()) {
                    arrayList.add((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(ub.q().q()).A(ub.q().getAccessHash()).a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.k(1, new ArrayList(this.b.keySet()));
        c19675ql0.m(2, new ArrayList(this.b.values()));
    }

    public List u() {
        List listA;
        synchronized (e) {
            listA = C14994ip6.a(new ArrayList(this.b.values()));
        }
        return listA;
    }

    public Map w() {
        return this.a;
    }

    public void z(byte[] bArr) {
        synchronized (e) {
            try {
                super.load(bArr);
                for (UB ub : this.b.values()) {
                    this.a.put(Integer.valueOf(ub.q().q()), Integer.valueOf(ub.r()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
