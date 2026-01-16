package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.gov.nist.core.Separators;
import android.util.Log;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18618ox6;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.HU1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class r {
    private static HU1 o = new HU1("ShapeDetector");
    private static final double p;
    private static final double q;
    private int a;
    private boolean f;
    private Utilities.b g;
    Context h;
    SharedPreferences i;
    private boolean j;
    private final int b = 8;
    private final long c = 150;
    private ArrayList d = new ArrayList();
    private ArrayList e = new ArrayList();
    private ArrayList k = null;
    private AtomicBoolean l = new AtomicBoolean(false);
    private AtomicBoolean m = new AtomicBoolean(false);
    private Runnable n = new Runnable() { // from class: ir.nasim.kx6
        @Override // java.lang.Runnable
        public final void run() {
            this.a.q();
        }
    };

    private static class a {
        public double a;
        public double b;

        public a(double d, double d2) {
            c(d, d2);
        }

        public double a(double d, double d2) {
            return Math.sqrt(Math.pow(d - this.a, 2.0d) + Math.pow(d2 - this.b, 2.0d));
        }

        public double b(a aVar) {
            return a(aVar.a, aVar.b);
        }

        public void c(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    private static class b {
        public double a;
        public double b;
        public double c;
        public double d;

        public b(double d, double d2, double d3, double d4) {
            this.a = d;
            this.b = d2;
            this.c = d3;
            this.d = d4;
        }

        public void a(double d, double d2) {
            if (this.a >= d) {
                this.a = d;
            }
            if (this.b >= d2) {
                this.b = d2;
            }
            if (this.c <= d) {
                this.c = d;
            }
            if (this.d <= d2) {
                this.d = d2;
            }
        }

        public String toString() {
            return "RectD{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
        }
    }

    private static class c {
        public int a;
        public ArrayList b;
        public int c;

        private c() {
            this.b = new ArrayList();
        }
    }

    static {
        double dSqrt = Math.sqrt(125000.0d);
        p = dSqrt;
        q = dSqrt / 2.0d;
    }

    public r(Context context, Utilities.b bVar) {
        this.h = context;
        this.g = bVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shapedetector_conf", 0);
        this.i = sharedPreferences;
        this.j = sharedPreferences.getBoolean("learning", false);
        this.a = this.i.getInt("scoreall", 0);
        t();
    }

    private void A() {
        final ArrayList arrayList = this.k;
        new AlertDialog.i(this.h).j("Shape?").d(new String[]{"Log all", "Circle", "Rectangle", "Star", "Bubble", "Arrow", "None"}, new DialogInterface.OnClickListener() { // from class: ir.nasim.lx6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.s(arrayList, dialogInterface, i);
            }
        }).q();
        this.k = null;
    }

    private void B(ArrayList arrayList, double d, double d2) {
        for (int i = 0; i < arrayList.size(); i++) {
            a aVar = (a) arrayList.get(i);
            aVar.a += d;
            aVar.b += d2;
        }
    }

    private b f(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        double d = ((a) arrayList.get(0)).a;
        double d2 = ((a) arrayList.get(0)).b;
        b bVar = new b(d, d2, d, d2);
        for (int i = 1; i < arrayList.size(); i++) {
            a aVar = (a) arrayList.get(i);
            bVar.a(aVar.a, aVar.b);
        }
        return bVar;
    }

    private a g(ArrayList arrayList) {
        a aVar = new a(0.0d, 0.0d);
        for (int i = 0; i < arrayList.size(); i++) {
            a aVar2 = (a) arrayList.get(i);
            aVar.a += aVar2.a;
            aVar.b += aVar2.b;
        }
        aVar.a /= arrayList.size();
        aVar.b /= arrayList.size();
        return aVar;
    }

    private q i(int i, ArrayList arrayList) {
        int iM;
        if (i < 0 || i >= a.g.b.size() || arrayList.size() < 1) {
            return null;
        }
        q qVar = new q(a.g.q(i));
        if (i == 4) {
            int iL = l(arrayList);
            if (iL <= 0) {
                return null;
            }
            if (iL > 10) {
                iL -= 2;
            }
            a aVar = (a) arrayList.get(iL);
            a aVar2 = (a) arrayList.get(iL / 2);
            a aVar3 = (a) arrayList.get(0);
            qVar.b = (float) aVar.a;
            qVar.c = (float) aVar.b;
            qVar.i = (float) aVar2.a;
            qVar.j = (float) aVar2.b;
            qVar.d = (float) aVar3.a;
            qVar.e = (float) aVar3.b;
            qVar.k = 16.0f;
        } else {
            a aVarG = g(arrayList);
            qVar.b = (float) aVarG.a;
            qVar.c = (float) aVarG.b;
            b bVarF = f(arrayList);
            qVar.d = ((float) (bVarF.c - bVarF.a)) / 2.0f;
            qVar.e = ((float) (bVarF.d - bVarF.b)) / 2.0f;
            if (i == 2 && (iM = m(arrayList, 1)) > 0) {
                a aVar4 = (a) arrayList.get(iM);
                qVar.h = (float) Math.atan2(aVar4.b - qVar.c, aVar4.a - qVar.b);
            }
        }
        return qVar;
    }

    private double j(ArrayList arrayList, a aVar, ArrayList arrayList2, double d) {
        a aVar2 = aVar;
        double dCos = Math.cos(d);
        double dSin = Math.sin(d);
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        double dA = 0.0d;
        int i = 0;
        while (i < iMin) {
            a aVar3 = (a) arrayList.get(i);
            a aVar4 = (a) arrayList2.get(i);
            double d2 = aVar3.a;
            int i2 = i;
            double d3 = aVar2.a;
            double d4 = aVar3.b;
            int i3 = iMin;
            double d5 = aVar2.b;
            double d6 = dCos;
            dA += aVar4.a((((d2 - d3) * dCos) - ((d4 - d5) * dSin)) + d3, ((d2 - d3) * dSin) + ((d4 - d5) * d6) + d5);
            i = i2 + 1;
            aVar2 = aVar;
            iMin = i3;
            dCos = d6;
        }
        return dA / arrayList.size();
    }

    private double k(ArrayList arrayList, a aVar, ArrayList arrayList2, double d, double d2, double d3) {
        double dSqrt = (Math.sqrt(5.0d) - 1.0d) * 0.5d;
        double d4 = 1.0d - dSqrt;
        double d5 = (dSqrt * d) + (d4 * d2);
        double d6 = (d4 * d) + (dSqrt * d2);
        double dJ = j(arrayList, aVar, arrayList2, d5);
        double dJ2 = j(arrayList, aVar, arrayList2, d6);
        double d7 = d5;
        double d8 = d6;
        double d9 = d;
        double d10 = d2;
        while (Math.abs(d10 - d9) > d3) {
            if (dJ < dJ2) {
                double d11 = (dSqrt * d9) + (d4 * d8);
                double d12 = dJ;
                dJ = j(arrayList, aVar, arrayList2, d11);
                dJ2 = d12;
                d10 = d8;
                d8 = d7;
                d7 = d11;
            } else {
                double d13 = (d4 * d7) + (dSqrt * d10);
                dJ = dJ2;
                dJ2 = j(arrayList, aVar, arrayList2, d13);
                double d14 = d7;
                d7 = d8;
                d8 = d13;
                d9 = d14;
            }
        }
        return Math.min(dJ, dJ2);
    }

    private int l(ArrayList arrayList) {
        return m(arrayList, 0);
    }

    private int m(ArrayList arrayList, int i) {
        int iMax = Math.max(1, arrayList.size() / 4);
        int i2 = i;
        while (iMax < arrayList.size() - 1) {
            a aVar = (a) arrayList.get(iMax - 1);
            a aVar2 = (a) arrayList.get(iMax);
            int i3 = iMax + 1;
            a aVar3 = (a) arrayList.get(i3);
            double dB = aVar.b(aVar2);
            double dB2 = aVar.b(aVar3);
            double dB3 = aVar2.b(aVar3);
            if ((Math.acos((((dB * dB) + (dB2 * dB2)) - (dB3 * dB3)) / ((dB * 2.0d) * dB2)) / 3.141592653589793d) * 180.0d > 18.0d) {
                if (i2 <= 0) {
                    return iMax;
                }
                i2--;
            }
            iMax = i3;
        }
        return -1;
    }

    private ArrayList n(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            a aVar = (a) arrayList.get(i);
            arrayList2.add(new a(aVar.a, aVar.b));
        }
        return arrayList2;
    }

    private double o(ArrayList arrayList) {
        a aVarG = g(arrayList);
        return Math.atan2(aVarG.b - ((a) arrayList.get(0)).b, aVarG.a - ((a) arrayList.get(0)).a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(q qVar, int i, ArrayList arrayList) {
        boolean z = qVar != null;
        this.f = z;
        if (!z || i < 0 || i >= this.e.size()) {
            this.k = arrayList;
        } else {
            this.a++;
            ((c) this.e.get(i)).c++;
            this.i.edit().putInt("score" + i, ((c) this.e.get(i)).c).putInt("scoreall", this.a).apply();
            this.k = null;
        }
        this.g.a(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        String str;
        if (this.l.get()) {
            return;
        }
        this.m.set(false);
        this.l.set(true);
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                if (this.d.size() < 8) {
                    this.l.set(false);
                    return;
                }
                ArrayList arrayListV = v(n(this.d), 48);
                ArrayList arrayListN = n(arrayListV);
                w(arrayListN, o(arrayListN));
                a aVarG = g(arrayListN);
                B(arrayListN, -aVarG.a, -aVarG.b);
                y(arrayListN, 250.0d);
                a aVarG2 = g(arrayListN);
                double d = Double.MAX_VALUE;
                int i = 0;
                int i2 = -1;
                int i3 = -1;
                while (i < this.e.size()) {
                    ArrayList arrayList = arrayListN;
                    int i4 = i;
                    ArrayList arrayList2 = arrayListN;
                    int i5 = i2;
                    double dK = k(arrayList, aVarG2, ((c) this.e.get(i)).b, -1.5707963267948966d, 1.5707963267948966d, 0.06981317007977318d);
                    if (dK < d) {
                        d = dK;
                        i3 = ((c) this.e.get(i4)).a;
                        i2 = i4;
                    } else {
                        i2 = i5;
                    }
                    i = i4 + 1;
                    arrayListN = arrayList2;
                }
                final ArrayList arrayList3 = arrayListN;
                final int i6 = i2;
                int i7 = 1.0d - (d / q) < 0.8d ? -1 : i3;
                final q qVarI = i(i7, arrayListV);
                if (AbstractC8814Xl0.b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("took ");
                    sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sb.append("ms to ");
                    sb.append(qVarI != null ? "" : "not ");
                    sb.append("detect a shape");
                    if (qVarI != null) {
                        str = " (template#" + i6 + " shape#" + i7 + Separators.RPAREN;
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    Log.i("shapedetector", sb.toString());
                }
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.nx6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p(qVarI, i6, arrayList3);
                    }
                });
                this.l.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() throws IOException {
        AbstractC18618ox6 abstractC18618ox6;
        char c2;
        String string;
        char c3;
        try {
            InputStream inputStreamOpen = AbstractC14047hG.a.getAssets().open("shapes.dat");
            while (true) {
                abstractC18618ox6 = null;
                c2 = 0;
                if (inputStreamOpen.available() <= 5) {
                    break;
                }
                c cVar = new c();
                cVar.a = inputStreamOpen.read();
                int i = inputStreamOpen.read();
                int i2 = inputStreamOpen.read() - 64;
                int i3 = inputStreamOpen.read() - 64;
                if (inputStreamOpen.available() < i * 2) {
                    break;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    cVar.b.add(new a((inputStreamOpen.read() - i2) - 127, (inputStreamOpen.read() - i3) - 127));
                }
                cVar.c = this.i.getInt("score" + this.e.size(), 0);
                this.e.add(cVar);
            }
            if (this.j && (string = this.i.getString("moretemplates", null)) != null) {
                String[] strArrSplit = string.split("\\|");
                int size = this.e.size();
                int i5 = 0;
                while (i5 < strArrSplit.length) {
                    c cVar2 = new c();
                    String[] strArrSplit2 = strArrSplit[i5].split(",");
                    if (strArrSplit2.length <= 1) {
                        c3 = c2;
                    } else {
                        cVar2.a = Integer.parseInt(strArrSplit2[c2]);
                        for (int i6 = 1; i6 < strArrSplit2.length; i6 += 2) {
                            cVar2.b.add(new a(Double.parseDouble(strArrSplit2[i6]), Double.parseDouble(strArrSplit2[i6 + 1])));
                        }
                        c3 = 0;
                        cVar2.c = this.i.getInt("score" + (size + i5), 0);
                        this.e.add(cVar2);
                    }
                    i5++;
                    c2 = c3;
                    abstractC18618ox6 = null;
                }
            }
            inputStreamOpen.close();
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        if (i != 0) {
            c cVar = new c();
            cVar.a = i - 1;
            cVar.b = arrayList;
            this.e.add(cVar);
            String string = this.i.getString("moretemplates", null);
            String str = string == null ? "" + cVar.a : string + "|" + cVar.a;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                str = str + "," + Math.round(((a) arrayList.get(i2)).a) + "," + Math.round(((a) arrayList.get(i2)).b);
            }
            this.i.edit().putString("moretemplates", str).apply();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            c cVar2 = (c) this.e.get(i3);
            if (i3 > 0) {
                sb.append(",\n");
            }
            sb.append("\t{\n\t\t\"shape\": ");
            sb.append(cVar2.a);
            sb.append(",\n\t\t\"points\": [");
            for (int i4 = 0; i4 < cVar2.b.size(); i4++) {
                if (i4 > 0) {
                    sb.append(",");
                }
                a aVar = (a) cVar2.b.get(i4);
                sb.append("[");
                sb.append(Math.round(aVar.a));
                sb.append(",");
                sb.append(Math.round(aVar.b));
                sb.append("]");
            }
            sb.append("],\n\t\t\"freq\": ");
            sb.append(Math.round(((cVar2.c / this.a) * 100.0f) * 100.0f) / 100.0f);
            sb.append("\n\t}");
        }
        sb.append("\n]");
        Log.i("shapedetector", sb.toString());
    }

    private void t() {
        o.i(new Runnable() { // from class: ir.nasim.mx6
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.r();
            }
        });
    }

    private double u(ArrayList arrayList) {
        double dB = 0.0d;
        for (int i = 1; i < arrayList.size(); i++) {
            dB += ((a) arrayList.get(i - 1)).b((a) arrayList.get(i));
        }
        return dB;
    }

    private ArrayList v(ArrayList arrayList, int i) {
        double d;
        int i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((a) arrayList.get(0));
        int i3 = i - 1;
        double dU = u(arrayList) / i3;
        int i4 = 1;
        double d2 = 0.0d;
        while (i4 < arrayList.size()) {
            int i5 = i4 - 1;
            double dB = ((a) arrayList.get(i5)).b((a) arrayList.get(i4));
            double d3 = d2 + dB;
            if (d3 >= dU) {
                double d4 = (dU - d2) / dB;
                i2 = i3;
                d = dU;
                a aVar = new a(((a) arrayList.get(i5)).a + ((((a) arrayList.get(i4)).a - ((a) arrayList.get(i5)).a) * d4), ((a) arrayList.get(i5)).b + (d4 * (((a) arrayList.get(i4)).b - ((a) arrayList.get(i5)).b)));
                arrayList2.add(aVar);
                arrayList.add(i4, aVar);
                d2 = 0.0d;
            } else {
                d = dU;
                i2 = i3;
                d2 = d3;
            }
            i4++;
            i3 = i2;
            dU = d;
        }
        if (arrayList2.size() == i3) {
            arrayList2.add((a) arrayList.get(arrayList.size() - 1));
        }
        return arrayList2;
    }

    private void w(ArrayList arrayList, double d) {
        x(arrayList, d, g(arrayList));
    }

    private void x(ArrayList arrayList, double d, a aVar) {
        double dCos = Math.cos(d);
        double dSin = Math.sin(d);
        int i = 0;
        while (i < arrayList.size()) {
            a aVar2 = (a) arrayList.get(i);
            double d2 = aVar2.a;
            double d3 = aVar.a;
            double d4 = aVar2.b;
            int i2 = i;
            double d5 = aVar.b;
            aVar2.b = ((d2 - d3) * dSin) + ((d4 - d5) * dCos) + d5;
            aVar2.a = (((d2 - d3) * dCos) - ((d4 - d5) * dSin)) + d3;
            i = i2 + 1;
        }
    }

    private void y(ArrayList arrayList, double d) {
        b bVarF = f(arrayList);
        double d2 = bVarF.c - bVarF.a;
        double d3 = bVarF.d - bVarF.b;
        for (int i = 0; i < arrayList.size(); i++) {
            a aVar = (a) arrayList.get(i);
            aVar.a *= d / d2;
            aVar.b *= d / d3;
        }
    }

    public void e(double d, double d2, boolean z) {
        boolean z2;
        synchronized (this) {
            this.d.add(new a(d, d2));
            z2 = this.d.size() >= 8;
        }
        if (z2) {
            z(z);
        }
    }

    public void h() {
        synchronized (this) {
            this.d.clear();
        }
        o.b(this.n);
        this.m.set(false);
        this.f = false;
        if (!this.j || this.k == null) {
            return;
        }
        A();
    }

    public void z(boolean z) throws InterruptedException {
        if (this.l.get()) {
            return;
        }
        if (this.m.get() && !this.f && z) {
            o.b(this.n);
            o.j(this.n, 150L);
        }
        if (this.m.get()) {
            return;
        }
        this.m.set(true);
        o.j(this.n, 150L);
    }
}
