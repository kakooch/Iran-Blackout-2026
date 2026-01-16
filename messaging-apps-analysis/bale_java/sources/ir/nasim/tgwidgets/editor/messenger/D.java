package ir.nasim.tgwidgets.editor.messenger;

import android.gov.nist.core.Separators;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import ir.nasim.AbstractC12724f57;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC15742k57;
import ir.nasim.AbstractC19652qi7;
import ir.nasim.AbstractC19879r57;
import ir.nasim.AbstractC21539ti7;
import ir.nasim.AbstractC22951w57;
import ir.nasim.AbstractC23541x57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C10743c74;
import ir.nasim.C19328q97;
import ir.nasim.C21892uJ3;
import ir.nasim.C22669vd7;
import ir.nasim.C23078wJ3;
import ir.nasim.C23265wd7;
import ir.nasim.C24741z77;
import ir.nasim.C3261Ac7;
import ir.nasim.C3752Ce7;
import ir.nasim.C4220Ee7;
import ir.nasim.C4427Fb7;
import ir.nasim.C4937He7;
import ir.nasim.C5612Kb7;
import ir.nasim.C7047Qa7;
import ir.nasim.D57;
import ir.nasim.F90;
import ir.nasim.HU1;
import ir.nasim.L57;
import ir.nasim.M57;
import ir.nasim.N57;
import ir.nasim.P57;
import ir.nasim.Q57;
import ir.nasim.S67;
import ir.nasim.T57;
import ir.nasim.U57;
import ir.nasim.U87;
import ir.nasim.Z57;
import ir.nasim.ZO1;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteDatabase;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteException;
import ir.nasim.tgwidgets.editor.SQLite.SQLitePreparedStatement;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.F;
import ir.nasim.tgwidgets.editor.tgnet.NativeByteBuffer;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
public class D extends F90 {
    private static volatile D[] A = new D[1];
    private static final Object[] B = {new Object()};
    private HU1 c;
    private SQLiteDatabase d;
    private File e;
    private File f;
    private File g;
    private AtomicLong h;
    private SparseArray i;
    private byte[] j;
    private ArrayList k;
    private SparseArray l;
    private C21892uJ3 m;
    private boolean n;
    private CountDownLatch o;
    private boolean p;
    public boolean q;
    private C23078wJ3 r;
    boolean s;
    private int[][] t;
    private int[][] u;
    private int[][] v;
    private int[][] w;
    private int[][] x;
    private C21892uJ3 y;
    private C21892uJ3 z;

    public D(int i) {
        super(i);
        this.h = new AtomicLong(System.currentTimeMillis());
        this.i = new SparseArray();
        this.j = null;
        this.k = new ArrayList();
        this.l = new SparseArray();
        this.m = new C21892uJ3();
        this.o = new CountDownLatch(1);
        this.r = new C23078wJ3();
        this.t = new int[][]{new int[2], new int[2]};
        this.u = new int[][]{new int[2], new int[2]};
        this.v = new int[][]{new int[2], new int[2]};
        this.w = new int[][]{new int[2], new int[2]};
        this.x = new int[][]{new int[2], new int[2]};
        this.y = new C21892uJ3();
        this.z = new C21892uJ3();
        HU1 hu1 = new HU1("storageQueue_" + i);
        this.c = hu1;
        hu1.i(new Runnable() { // from class: ir.nasim.K84
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.a.P();
            }
        });
    }

    public static D F(int i) {
        D d = A[i];
        if (d == null) {
            synchronized (B[i]) {
                try {
                    d = A[i];
                    if (d == null) {
                        D[] dArr = A;
                        D d2 = new D(i);
                        dArr[i] = d2;
                        d = d2;
                    }
                } finally {
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        e().s(E.S3, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(long j) {
        try {
            this.d.d("DELETE FROM story_pushes WHERE uid = " + j).k().e();
        } catch (Exception e) {
            x(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(C.a aVar, C.a aVar2) {
        int i = aVar.c;
        int i2 = aVar2.c;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void L() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.D.L():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        try {
            SQLiteCursor sQLiteCursorG = this.d.g("SELECT id, data FROM pending_tasks WHERE 1", new Object[0]);
            while (sQLiteCursorG.h()) {
                long jG = sQLiteCursorG.g(0);
                NativeByteBuffer nativeByteBufferB = sQLiteCursorG.b(1);
                if (nativeByteBufferB != null) {
                    int iE = nativeByteBufferB.e(false);
                    if (iE != 100) {
                        switch (iE) {
                            case 0:
                                AbstractC15742k57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 1:
                                nativeByteBufferB.e(false);
                                nativeByteBufferB.e(false);
                                break;
                            case 2:
                            case 5:
                            case 8:
                            case 10:
                            case 14:
                                C24741z77 c24741z77 = new C24741z77();
                                c24741z77.p = nativeByteBufferB.f(false);
                                c24741z77.e = nativeByteBufferB.e(false);
                                c24741z77.f = nativeByteBufferB.e(false);
                                c24741z77.g = nativeByteBufferB.e(false);
                                c24741z77.h = nativeByteBufferB.e(false);
                                c24741z77.o = nativeByteBufferB.e(false);
                                c24741z77.l = nativeByteBufferB.e(false);
                                c24741z77.b = nativeByteBufferB.e(false);
                                if (iE >= 5) {
                                    c24741z77.c = nativeByteBufferB.a(false);
                                    c24741z77.q = nativeByteBufferB.e(false);
                                }
                                if (iE >= 8) {
                                    c24741z77.i = nativeByteBufferB.e(false);
                                }
                                if (iE >= 10) {
                                    c24741z77.d = nativeByteBufferB.a(false);
                                }
                                if (iE >= 14) {
                                    c24741z77.m = nativeByteBufferB.e(false);
                                }
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 3:
                                nativeByteBufferB.f(false);
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 4:
                                nativeByteBufferB.f(false);
                                nativeByteBufferB.a(false);
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 6:
                                nativeByteBufferB.e(false);
                                nativeByteBufferB.e(false);
                                AbstractC22951w57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 7:
                                nativeByteBufferB.e(false);
                                int iE2 = nativeByteBufferB.e(false);
                                AbstractC12724f57 abstractC12724f57D = C22669vd7.d(nativeByteBufferB, iE2, false);
                                if (abstractC12724f57D == null) {
                                    abstractC12724f57D = S67.d(nativeByteBufferB, iE2, false);
                                }
                                if (abstractC12724f57D == null) {
                                    d0(jG);
                                    break;
                                }
                                break;
                            case 9:
                                nativeByteBufferB.f(false);
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 11:
                                nativeByteBufferB.e(false);
                                long jE = nativeByteBufferB.e(false);
                                nativeByteBufferB.e(false);
                                if (jE != 0) {
                                    AbstractC22951w57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                    break;
                                }
                                break;
                            case 12:
                            case 19:
                            case 20:
                                d0(jG);
                                break;
                            case 13:
                                nativeByteBufferB.f(false);
                                nativeByteBufferB.a(false);
                                nativeByteBufferB.e(false);
                                nativeByteBufferB.e(false);
                                nativeByteBufferB.a(false);
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 15:
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 16:
                                nativeByteBufferB.e(false);
                                int iE3 = nativeByteBufferB.e(false);
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < iE3; i++) {
                                    arrayList.add(AbstractC23541x57.d(nativeByteBufferB, nativeByteBufferB.e(false), false));
                                }
                                break;
                            case 17:
                                nativeByteBufferB.e(false);
                                int iE4 = nativeByteBufferB.e(false);
                                ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < iE4; i2++) {
                                    arrayList2.add(U87.d(nativeByteBufferB, nativeByteBufferB.e(false), false));
                                }
                                break;
                            case 18:
                                nativeByteBufferB.f(false);
                                nativeByteBufferB.e(false);
                                if (C23265wd7.d(nativeByteBufferB, nativeByteBufferB.e(false), false) == null) {
                                    d0(jG);
                                    break;
                                }
                                break;
                            case 21:
                                m.g gVar = new m.g();
                                nativeByteBufferB.f(false);
                                gVar.i = nativeByteBufferB.a(false);
                                gVar.j = nativeByteBufferB.a(false);
                                gVar.d = nativeByteBufferB.e(false);
                                gVar.e = nativeByteBufferB.e(false);
                                gVar.h = nativeByteBufferB.e(false);
                                gVar.k = (float) nativeByteBufferB.d(false);
                                nativeByteBufferB.a(false);
                                gVar.c = nativeByteBufferB.g(false);
                                gVar.b = nativeByteBufferB.g(false);
                                break;
                            case 22:
                                D57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                            case 23:
                                long jF = nativeByteBufferB.f(false);
                                nativeByteBufferB.e(false);
                                nativeByteBufferB.e(false);
                                if (!ZO1.c(jF) && ZO1.b(jF) && nativeByteBufferB.r()) {
                                    AbstractC22951w57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                    break;
                                }
                                break;
                            case 24:
                                nativeByteBufferB.f(false);
                                int iE5 = nativeByteBufferB.e(false);
                                AbstractC12724f57 abstractC12724f57D2 = C22669vd7.d(nativeByteBufferB, iE5, false);
                                if (abstractC12724f57D2 == null) {
                                    abstractC12724f57D2 = S67.d(nativeByteBufferB, iE5, false);
                                }
                                if (abstractC12724f57D2 == null) {
                                    d0(jG);
                                    break;
                                }
                                break;
                            case 25:
                                nativeByteBufferB.f(false);
                                nativeByteBufferB.e(false);
                                AbstractC22951w57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                                break;
                        }
                    } else {
                        nativeByteBufferB.e(false);
                        nativeByteBufferB.a(false);
                    }
                    nativeByteBufferB.t();
                }
            }
            sQLiteCursorG.d();
        } catch (Exception e) {
            x(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(C21892uJ3 c21892uJ3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, HashMap map) {
        f().A(c21892uJ3, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, map.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:227:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ad  */
    /* JADX WARN: Type inference failed for: r2v15, types: [ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v22, types: [ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r5v39, types: [ir.nasim.T1, ir.nasim.tgwidgets.editor.tgnet.NativeByteBuffer] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void O() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.D.O():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() throws InterruptedException {
        a0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (this.p) {
            this.p = false;
            E.k(this.a).s(E.t3, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.q = false;
        E.k(this.a).s(E.A3, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(F.b bVar) {
        try {
            this.d.d("DELETE FROM story_pushes WHERE uid = " + bVar.a).k().e();
            SQLitePreparedStatement sQLitePreparedStatementD = this.d.d("REPLACE INTO story_pushes VALUES(?, ?, ?, ?, ?, ?)");
            for (Map.Entry entry : bVar.c.entrySet()) {
                int iIntValue = ((Integer) entry.getKey()).intValue();
                long jLongValue = ((Long) ((Pair) entry.getValue()).first).longValue();
                long jLongValue2 = ((Long) ((Pair) entry.getValue()).second).longValue();
                sQLitePreparedStatementD.i();
                sQLitePreparedStatementD.b(1, bVar.a);
                sQLitePreparedStatementD.a(2, iIntValue);
                sQLitePreparedStatementD.b(3, jLongValue);
                if (bVar.b == null) {
                    bVar.b = "";
                }
                sQLitePreparedStatementD.c(4, bVar.b);
                sQLitePreparedStatementD.a(5, bVar.d ? 1 : 0);
                sQLitePreparedStatementD.b(6, jLongValue2);
                sQLitePreparedStatementD.j();
            }
            sQLitePreparedStatementD.e();
        } catch (Exception e) {
            x(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(long j) {
        try {
            this.d.d("DELETE FROM pending_tasks WHERE id = " + j).k().e();
        } catch (Exception e) {
            x(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ArrayList arrayList) {
        this.k.clear();
        this.l.clear();
        this.k.addAll(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            ((C.a) arrayList.get(i)).c = i;
            this.l.put(((C.a) arrayList.get(i)).a, (C.a) arrayList.get(i));
        }
        f0();
    }

    private void V() {
        this.c.i(new Runnable() { // from class: ir.nasim.P84
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.L();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03d5  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.nasim.AbstractC3788Ci7 W(java.lang.String r20, java.util.ArrayList r21, java.util.ArrayList r22, java.util.ArrayList r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.D.W(java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList):ir.nasim.Ci7");
    }

    private void X() {
        this.c.i(new Runnable() { // from class: ir.nasim.O84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M();
            }
        });
    }

    private boolean c0() {
        return false;
    }

    public static void w(L57 l57, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        String str;
        Z57 z57;
        long jQ = C10743c74.Q(l57);
        if (ZO1.e(jQ)) {
            if (!arrayList.contains(Long.valueOf(jQ))) {
                arrayList.add(Long.valueOf(jQ));
            }
        } else if (ZO1.b(jQ)) {
            long j = -jQ;
            if (!arrayList2.contains(Long.valueOf(j))) {
                arrayList2.add(Long.valueOf(j));
            }
        }
        long j2 = l57.B;
        if (j2 != 0 && !arrayList.contains(Long.valueOf(j2))) {
            arrayList.add(Long.valueOf(l57.B));
        }
        M57 m57 = l57.f;
        if (m57 != null) {
            long j3 = m57.k;
            if (j3 != 0 && !arrayList.contains(Long.valueOf(j3))) {
                arrayList.add(Long.valueOf(l57.f.k));
            }
            long j4 = l57.f.h;
            if (j4 != 0 && !arrayList2.contains(Long.valueOf(j4))) {
                arrayList2.add(Long.valueOf(l57.f.h));
            }
            long j5 = l57.f.j;
            if (j5 != 0 && !arrayList2.contains(Long.valueOf(j5))) {
                arrayList2.add(Long.valueOf(l57.f.j));
            }
            M57 m572 = l57.f;
            if (m572 instanceof C7047Qa7) {
                C7047Qa7 c7047Qa7 = (C7047Qa7) m572;
                long jA0 = C10743c74.a0(c7047Qa7.F);
                if (!ZO1.e(jA0)) {
                    long j6 = -jA0;
                    if (!arrayList2.contains(Long.valueOf(j6))) {
                        arrayList2.add(Long.valueOf(j6));
                    }
                } else if (!arrayList.contains(Long.valueOf(jA0))) {
                    arrayList.add(Long.valueOf(jA0));
                }
                long jA02 = C10743c74.a0(c7047Qa7.G);
                if (jA02 <= 0) {
                    long j7 = -jA02;
                    if (!arrayList2.contains(Long.valueOf(j7))) {
                        arrayList2.add(Long.valueOf(j7));
                    }
                } else if (!arrayList.contains(Long.valueOf(jA02))) {
                    arrayList.add(Long.valueOf(jA02));
                }
            }
            if (!l57.f.f.isEmpty()) {
                for (int i = 0; i < l57.f.f.size(); i++) {
                    Long l = (Long) l57.f.f.get(i);
                    if (!arrayList.contains(l)) {
                        arrayList.add(l);
                    }
                }
            }
        }
        if (!l57.n.isEmpty()) {
            for (int i2 = 0; i2 < l57.n.size(); i2++) {
                N57 n57 = (N57) l57.n.get(i2);
                if (n57 instanceof C5612Kb7) {
                    arrayList.add(Long.valueOf(((C5612Kb7) n57).f));
                } else if (n57 instanceof C19328q97) {
                    arrayList.add(Long.valueOf(((C19328q97) n57).f.b));
                } else if (arrayList3 != null && (n57 instanceof C4427Fb7)) {
                    arrayList3.add(Long.valueOf(((C4427Fb7) n57).f));
                }
            }
        }
        Q57 q57 = l57.h;
        if (q57 != null) {
            long j8 = q57.A;
            if (j8 != 0 && !arrayList.contains(Long.valueOf(j8))) {
                arrayList.add(Long.valueOf(l57.h.A));
            }
            Q57 q572 = l57.h;
            if (q572 instanceof C3261Ac7) {
                C3261Ac7 c3261Ac7 = (C3261Ac7) q572;
                if (!c3261Ac7.O.f.isEmpty()) {
                    for (int i3 = 0; i3 < c3261Ac7.O.f.size(); i3++) {
                        Z57 z572 = (Z57) c3261Ac7.O.f.get(i3);
                        long j9 = z572.b;
                        if (j9 != 0) {
                            arrayList.add(Long.valueOf(j9));
                        } else {
                            long j10 = z572.c;
                            if (j10 != 0) {
                                arrayList2.add(Long.valueOf(-j10));
                            } else {
                                long j11 = z572.d;
                                if (j11 != 0) {
                                    arrayList2.add(Long.valueOf(-j11));
                                }
                            }
                        }
                    }
                }
            }
        }
        T57 t57 = l57.s;
        if (t57 != null) {
            int size = t57.f.size();
            for (int i4 = 0; i4 < size; i4++) {
                long jA03 = C10743c74.a0((Z57) l57.s.f.get(i4));
                if (ZO1.e(jA03)) {
                    if (!arrayList.contains(Long.valueOf(jA03))) {
                        arrayList.add(Long.valueOf(jA03));
                    }
                } else if (ZO1.b(jA03)) {
                    long j12 = -jA03;
                    if (!arrayList2.contains(Long.valueOf(j12))) {
                        arrayList2.add(Long.valueOf(j12));
                    }
                }
            }
        }
        U57 u57 = l57.C;
        if (u57 != null && (z57 = u57.f) != null) {
            long jA04 = C10743c74.a0(z57);
            if (ZO1.e(jA04)) {
                if (!arrayList.contains(Long.valueOf(jA04))) {
                    arrayList.add(Long.valueOf(jA04));
                }
            } else if (ZO1.b(jA04)) {
                long j13 = -jA04;
                if (!arrayList2.contains(Long.valueOf(j13))) {
                    arrayList2.add(Long.valueOf(j13));
                }
            }
        }
        P57 p57 = l57.A;
        if (p57 != null) {
            Z57 z573 = p57.d;
            if (z573 instanceof C4937He7) {
                if (!arrayList.contains(Long.valueOf(z573.b))) {
                    arrayList.add(Long.valueOf(l57.A.d.b));
                }
            } else if (z573 instanceof C3752Ce7) {
                if (!arrayList2.contains(Long.valueOf(z573.d))) {
                    arrayList2.add(Long.valueOf(l57.A.d.d));
                }
            } else if ((z573 instanceof C4220Ee7) && !arrayList2.contains(Long.valueOf(z573.c))) {
                arrayList2.add(Long.valueOf(l57.A.d.c));
            }
            Z57 z574 = l57.A.i;
            if (z574 != null) {
                long j14 = z574.b;
                if (j14 == 0) {
                    long j15 = z574.d;
                    if (j15 == 0) {
                        long j16 = z574.c;
                        if (j16 != 0 && !arrayList2.contains(Long.valueOf(j16))) {
                            arrayList2.add(Long.valueOf(l57.A.i.c));
                        }
                    } else if (!arrayList2.contains(Long.valueOf(j15))) {
                        arrayList2.add(Long.valueOf(l57.A.i.d));
                    }
                } else if (!arrayList2.contains(Long.valueOf(j14))) {
                    arrayList.add(Long.valueOf(l57.A.i.b));
                }
            }
        }
        HashMap map = l57.N;
        if (map == null || (str = (String) map.get("fwd_peer")) == null) {
            return;
        }
        long jLongValue = Utilities.i(str).longValue();
        if (jLongValue < 0) {
            long j17 = -jLongValue;
            if (arrayList2.contains(Long.valueOf(j17))) {
                return;
            }
            arrayList2.add(Long.valueOf(j17));
        }
    }

    private void y(Throwable th, boolean z) {
        if (!(th instanceof SQLiteException) || th.getMessage() == null || !th.getMessage().contains("is malformed") || this.s) {
            AbstractC6403Nl2.e(th, z);
            return;
        }
        this.s = true;
        AbstractC6403Nl2.b("disk image malformed detected, try recover");
        if (!c0()) {
            AbstractC6403Nl2.e(new Exception(th), z);
            return;
        }
        this.s = false;
        z();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.N84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.I();
            }
        });
        AbstractC6403Nl2.d(new Exception("database restored!!"));
    }

    private void z() {
    }

    public void A(final long j) {
        this.c.i(new Runnable() { // from class: ir.nasim.J84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J(j);
            }
        });
    }

    public void B(String str, ArrayList arrayList) {
        C(str, arrayList, true);
    }

    public void C(String str, ArrayList arrayList, boolean z) {
        if (str == null || str.length() == 0 || arrayList == null) {
            return;
        }
        SQLiteCursor sQLiteCursorG = this.d.g(String.format(Locale.US, "SELECT data FROM chats WHERE uid IN(%s)", str), new Object[0]);
        while (sQLiteCursorG.h()) {
            try {
                NativeByteBuffer nativeByteBufferB = sQLiteCursorG.b(0);
                if (nativeByteBufferB != null) {
                    AbstractC15742k57 abstractC15742k57E = AbstractC15742k57.e(nativeByteBufferB, nativeByteBufferB.e(false), false, z);
                    nativeByteBufferB.t();
                    if (abstractC15742k57E != null) {
                        arrayList.add(abstractC15742k57E);
                    }
                }
            } catch (Exception e) {
                x(e);
            }
        }
        sQLiteCursorG.d();
    }

    public SQLiteDatabase D() {
        return this.d;
    }

    public void E(String str, ArrayList arrayList, ArrayList arrayList2) {
        if (str == null || str.length() == 0 || arrayList == null) {
            return;
        }
        SQLiteCursor sQLiteCursorG = this.d.g(String.format(Locale.US, "SELECT data, user, g, authkey, ttl, layer, seq_in, seq_out, use_count, exchange_id, key_date, fprint, fauthkey, khash, in_seq_no, admin_id, mtproto_seq FROM enc_chats WHERE uid IN(%s)", str), new Object[0]);
        while (sQLiteCursorG.h()) {
            try {
                NativeByteBuffer nativeByteBufferB = sQLiteCursorG.b(0);
                if (nativeByteBufferB != null) {
                    AbstractC19879r57 abstractC19879r57D = AbstractC19879r57.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                    nativeByteBufferB.t();
                    if (abstractC19879r57D != null) {
                        long jG = sQLiteCursorG.g(1);
                        abstractC19879r57D.p = jG;
                        if (arrayList2 != null && !arrayList2.contains(Long.valueOf(jG))) {
                            arrayList2.add(Long.valueOf(abstractC19879r57D.p));
                        }
                        abstractC19879r57D.n = sQLiteCursorG.a(2);
                        abstractC19879r57D.o = sQLiteCursorG.a(3);
                        abstractC19879r57D.q = sQLiteCursorG.e(4);
                        abstractC19879r57D.r = sQLiteCursorG.e(5);
                        abstractC19879r57D.s = sQLiteCursorG.e(6);
                        abstractC19879r57D.t = sQLiteCursorG.e(7);
                        int iE = sQLiteCursorG.e(8);
                        abstractC19879r57D.x = (short) (iE >> 16);
                        abstractC19879r57D.y = (short) iE;
                        abstractC19879r57D.z = sQLiteCursorG.g(9);
                        abstractC19879r57D.A = sQLiteCursorG.e(10);
                        abstractC19879r57D.B = sQLiteCursorG.g(11);
                        abstractC19879r57D.C = sQLiteCursorG.a(12);
                        abstractC19879r57D.w = sQLiteCursorG.a(13);
                        abstractC19879r57D.u = sQLiteCursorG.e(14);
                        long jG2 = sQLiteCursorG.g(15);
                        if (jG2 != 0) {
                            abstractC19879r57D.g = jG2;
                        }
                        abstractC19879r57D.v = sQLiteCursorG.e(16);
                        arrayList.add(abstractC19879r57D);
                    }
                }
            } catch (Exception e) {
                x(e);
            }
        }
        sQLiteCursorG.d();
    }

    public HU1 G() {
        return this.c;
    }

    public void H(String str, ArrayList arrayList) {
        if (str == null || str.length() == 0 || arrayList == null) {
            return;
        }
        SQLiteCursor sQLiteCursorG = this.d.g(String.format(Locale.US, "SELECT data, status FROM users WHERE uid IN(%s)", str), new Object[0]);
        while (sQLiteCursorG.h()) {
            try {
                NativeByteBuffer nativeByteBufferB = sQLiteCursorG.b(0);
                if (nativeByteBufferB != null) {
                    AbstractC19652qi7 abstractC19652qi7D = AbstractC19652qi7.d(nativeByteBufferB, nativeByteBufferB.e(false), false);
                    nativeByteBufferB.t();
                    if (abstractC19652qi7D != null) {
                        AbstractC21539ti7 abstractC21539ti7 = abstractC19652qi7D.i;
                        if (abstractC21539ti7 != null) {
                            abstractC21539ti7.b = sQLiteCursorG.e(1);
                        }
                        arrayList.add(abstractC19652qi7D);
                    }
                }
            } catch (Exception e) {
                x(e);
            }
        }
        sQLiteCursorG.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [ir.nasim.L57] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r3v5, types: [ir.nasim.T1, ir.nasim.tgwidgets.editor.tgnet.NativeByteBuffer] */
    protected void Y(C21892uJ3 c21892uJ3, C21892uJ3 c21892uJ32, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        ?? r13;
        D d = this;
        C21892uJ3 c21892uJ33 = c21892uJ3;
        if (c21892uJ3.i()) {
            return;
        }
        int iO = c21892uJ3.o();
        int i = 0;
        while (i < iO) {
            long jK = c21892uJ33.k(i);
            SparseArray sparseArray = (SparseArray) c21892uJ33.p(i);
            ArrayList arrayList3 = (ArrayList) c21892uJ32.f(jK);
            if (arrayList3 != null) {
                int i2 = 0;
                ?? G = 0;
                while (i2 < 2) {
                    if (i2 != 1 || z) {
                        if (i2 == 1) {
                            try {
                                try {
                                    G = d.d.g(String.format(Locale.US, "SELECT data, mid, date, uid FROM scheduled_messages_v2 WHERE mid IN(%s) AND uid = %d", TextUtils.join(",", arrayList3), Long.valueOf(jK)), new Object[0]);
                                    r13 = 0;
                                } catch (Exception e) {
                                    throw e;
                                }
                            } catch (Throwable th) {
                                if (G != 0) {
                                    G.d();
                                }
                                throw th;
                            }
                        } else {
                            r13 = 0;
                            G = d.d.g(String.format(Locale.US, "SELECT data, mid, date, uid FROM messages_v2 WHERE mid IN(%s) AND uid = %d", TextUtils.join(",", arrayList3), Long.valueOf(jK)), new Object[0]);
                        }
                        while (G.h()) {
                            ?? B2 = G.b(r13);
                            if (B2 != 0) {
                                ?? D = L57.d(B2, B2.e(r13), r13);
                                D.e(B2, g().c);
                                B2.t();
                                D.b = G.e(1);
                                D.e = G.e(2);
                                D.Q = G.g(3);
                                w(D, arrayList, arrayList2, null);
                                ArrayList arrayList4 = (ArrayList) sparseArray.get(D.b);
                                if (arrayList4 != null) {
                                    int size = arrayList4.size();
                                    for (int i3 = 0; i3 < size; i3++) {
                                        ((L57) arrayList4.get(i3)).U = D;
                                        C10743c74.G(D);
                                    }
                                }
                            }
                            r13 = 0;
                        }
                        G.d();
                    }
                    i2++;
                    d = this;
                    G = G;
                }
                if (G != 0) {
                    G.d();
                }
            }
            i++;
            d = this;
            c21892uJ33 = c21892uJ3;
        }
    }

    public void Z() {
        this.c.i(new Runnable() { // from class: ir.nasim.Q84
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.O();
            }
        });
    }

    public void a0(int i) throws InterruptedException {
        if (!NativeLoader.d()) {
            int i2 = 0;
            while (!NativeLoader.d()) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i2++;
                if (i2 > 5) {
                    break;
                }
            }
        }
        File fileB = AbstractC14047hG.b();
        if (this.a != 0) {
            File file = new File(fileB, "account" + this.a + Separators.SLASH);
            file.mkdirs();
            fileB = file;
        }
        this.e = new File(fileB, "cache4.db");
        this.f = new File(fileB, "cache4.db-wal");
        this.g = new File(fileB, "cache4.db-shm");
        this.n = false;
        this.e.exists();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.L84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Q();
            }
        });
        V();
        Z();
        X();
        try {
            this.o.countDown();
        } catch (Throwable unused) {
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.M84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.R();
            }
        });
    }

    public void b0(final F.b bVar) {
        this.c.i(new Runnable() { // from class: ir.nasim.I84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.S(bVar);
            }
        });
    }

    public void d0(final long j) {
        this.c.i(new Runnable() { // from class: ir.nasim.R84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.T(j);
            }
        });
    }

    public void e0() {
        final ArrayList arrayList = new ArrayList(c().e);
        this.c.i(new Runnable() { // from class: ir.nasim.G84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.U(arrayList);
            }
        });
    }

    public void f0() {
        SQLitePreparedStatement sQLitePreparedStatementD = null;
        try {
            try {
                sQLitePreparedStatementD = this.d.d("UPDATE dialog_filter SET ord = ?, flags = ? WHERE id = ?");
                int size = this.k.size();
                for (int i = 0; i < size; i++) {
                    C.a aVar = (C.a) this.k.get(i);
                    sQLitePreparedStatementD.i();
                    sQLitePreparedStatementD.a(1, aVar.c);
                    sQLitePreparedStatementD.a(2, aVar.d);
                    sQLitePreparedStatementD.a(3, aVar.a);
                    sQLitePreparedStatementD.j();
                }
                sQLitePreparedStatementD.e();
            } catch (Exception e) {
                x(e);
                if (sQLitePreparedStatementD != null) {
                    sQLitePreparedStatementD.e();
                }
            }
        } catch (Throwable th) {
            if (sQLitePreparedStatementD != null) {
                sQLitePreparedStatementD.e();
            }
            throw th;
        }
    }

    public void x(Throwable th) {
        y(th, true);
    }

    protected static void v(L57 l57, C21892uJ3 c21892uJ3, C21892uJ3 c21892uJ32) {
    }
}
