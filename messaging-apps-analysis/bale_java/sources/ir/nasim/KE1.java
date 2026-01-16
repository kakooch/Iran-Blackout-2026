package ir.nasim;

import android.util.Base64;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.InterfaceC9040Yf5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes2.dex */
public final class KE1 implements InterfaceC9040Yf5 {
    public static final Q17 h = new Q17() { // from class: ir.nasim.JE1
        @Override // ir.nasim.Q17
        public final Object get() {
            return KE1.k();
        }
    };
    private static final Random i = new Random();
    private final J0.d a;
    private final J0.b b;
    private final HashMap c;
    private final Q17 d;
    private InterfaceC9040Yf5.a e;
    private com.google.android.exoplayer2.J0 f;
    private String g;

    private final class a {
        private final String a;
        private int b;
        private long c;
        private MediaSource.MediaPeriodId d;
        private boolean e;
        private boolean f;

        public a(String str, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            this.a = str;
            this.b = i;
            this.c = mediaPeriodId == null ? -1L : mediaPeriodId.d;
            if (mediaPeriodId == null || !mediaPeriodId.c()) {
                return;
            }
            this.d = mediaPeriodId;
        }

        private int l(com.google.android.exoplayer2.J0 j0, com.google.android.exoplayer2.J0 j02, int i) {
            if (i >= j0.u()) {
                if (i < j02.u()) {
                    return i;
                }
                return -1;
            }
            j0.s(i, KE1.this.a);
            for (int i2 = KE1.this.a.o; i2 <= KE1.this.a.p; i2++) {
                int iG = j02.g(j0.r(i2));
                if (iG != -1) {
                    return j02.k(iG, KE1.this.b).c;
                }
            }
            return -1;
        }

        public boolean i(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i == this.b;
            }
            MediaSource.MediaPeriodId mediaPeriodId2 = this.d;
            return mediaPeriodId2 == null ? !mediaPeriodId.c() && mediaPeriodId.d == this.c : mediaPeriodId.d == mediaPeriodId2.d && mediaPeriodId.b == mediaPeriodId2.b && mediaPeriodId.c == mediaPeriodId2.c;
        }

        public boolean j(InterfaceC6170Mm.a aVar) {
            MediaSource.MediaPeriodId mediaPeriodId = aVar.d;
            if (mediaPeriodId == null) {
                return this.b != aVar.c;
            }
            long j = this.c;
            if (j == -1) {
                return false;
            }
            if (mediaPeriodId.d > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int iG = aVar.b.g(mediaPeriodId.a);
            int iG2 = aVar.b.g(this.d.a);
            MediaSource.MediaPeriodId mediaPeriodId2 = aVar.d;
            if (mediaPeriodId2.d < this.d.d || iG < iG2) {
                return false;
            }
            if (iG > iG2) {
                return true;
            }
            if (!mediaPeriodId2.c()) {
                int i = aVar.d.e;
                return i == -1 || i > this.d.b;
            }
            MediaSource.MediaPeriodId mediaPeriodId3 = aVar.d;
            int i2 = mediaPeriodId3.b;
            int i3 = mediaPeriodId3.c;
            MediaSource.MediaPeriodId mediaPeriodId4 = this.d;
            int i4 = mediaPeriodId4.b;
            if (i2 <= i4) {
                return i2 == i4 && i3 > mediaPeriodId4.c;
            }
            return true;
        }

        public void k(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.c == -1 && i == this.b && mediaPeriodId != null) {
                this.c = mediaPeriodId.d;
            }
        }

        public boolean m(com.google.android.exoplayer2.J0 j0, com.google.android.exoplayer2.J0 j02) {
            int iL = l(j0, j02, this.b);
            this.b = iL;
            if (iL == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.d;
            return mediaPeriodId == null || j02.g(mediaPeriodId.a) != -1;
        }
    }

    public KE1() {
        this(h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k() {
        byte[] bArr = new byte[12];
        i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private a l(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        a aVar = null;
        long j = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            aVar2.k(i2, mediaPeriodId);
            if (aVar2.i(i2, mediaPeriodId)) {
                long j2 = aVar2.c;
                if (j2 == -1 || j2 < j) {
                    aVar = aVar2;
                    j = j2;
                } else if (j2 == j && ((a) AbstractC9683aN7.j(aVar)).d != null && aVar2.d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = (String) this.d.get();
        a aVar3 = new a(str, i2, mediaPeriodId);
        this.c.put(str, aVar3);
        return aVar3;
    }

    private void m(InterfaceC6170Mm.a aVar) {
        if (aVar.b.v()) {
            this.g = null;
            return;
        }
        a aVar2 = (a) this.c.get(this.g);
        a aVarL = l(aVar.c, aVar.d);
        this.g = aVarL.a;
        c(aVar);
        MediaSource.MediaPeriodId mediaPeriodId = aVar.d;
        if (mediaPeriodId == null || !mediaPeriodId.c()) {
            return;
        }
        if (aVar2 != null && aVar2.c == aVar.d.d && aVar2.d != null && aVar2.d.b == aVar.d.b && aVar2.d.c == aVar.d.c) {
            return;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = aVar.d;
        this.e.c(aVar, l(aVar.c, new MediaSource.MediaPeriodId(mediaPeriodId2.a, mediaPeriodId2.d)).a, aVarL.a);
    }

    @Override // ir.nasim.InterfaceC9040Yf5
    public synchronized String a() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC9040Yf5
    public void b(InterfaceC9040Yf5.a aVar) {
        this.e = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r25.d.d < r2.c) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    @Override // ir.nasim.InterfaceC9040Yf5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c(ir.nasim.InterfaceC6170Mm.a r25) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KE1.c(ir.nasim.Mm$a):void");
    }

    @Override // ir.nasim.InterfaceC9040Yf5
    public synchronized void d(InterfaceC6170Mm.a aVar) {
        try {
            AbstractC20011rK.e(this.e);
            com.google.android.exoplayer2.J0 j0 = this.f;
            this.f = aVar.b;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (!aVar2.m(j0, this.f) || aVar2.j(aVar)) {
                    it.remove();
                    if (aVar2.e) {
                        if (aVar2.a.equals(this.g)) {
                            this.g = null;
                        }
                        this.e.b(aVar, aVar2.a, false);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC9040Yf5
    public synchronized String e(com.google.android.exoplayer2.J0 j0, MediaSource.MediaPeriodId mediaPeriodId) {
        return l(j0.m(mediaPeriodId.a, this.b).c, mediaPeriodId).a;
    }

    @Override // ir.nasim.InterfaceC9040Yf5
    public synchronized void f(InterfaceC6170Mm.a aVar) {
        InterfaceC9040Yf5.a aVar2;
        this.g = null;
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            a aVar3 = (a) it.next();
            it.remove();
            if (aVar3.e && (aVar2 = this.e) != null) {
                aVar2.b(aVar, aVar3.a, false);
            }
        }
    }

    @Override // ir.nasim.InterfaceC9040Yf5
    public synchronized void g(InterfaceC6170Mm.a aVar, int i2) {
        try {
            AbstractC20011rK.e(this.e);
            boolean z = i2 == 0;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.j(aVar)) {
                    it.remove();
                    if (aVar2.e) {
                        boolean zEquals = aVar2.a.equals(this.g);
                        boolean z2 = z && zEquals && aVar2.f;
                        if (zEquals) {
                            this.g = null;
                        }
                        this.e.b(aVar, aVar2.a, z2);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public KE1(Q17 q17) {
        this.d = q17;
        this.a = new J0.d();
        this.b = new J0.b();
        this.c = new HashMap();
        this.f = com.google.android.exoplayer2.J0.a;
    }
}
