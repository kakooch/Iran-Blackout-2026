package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class Z05 {
    private float c;
    private float d;
    private float e;
    private float f;
    private Path a = new Path();
    private float b = -1.0f;
    private ArrayList g = new ArrayList();

    private static class a {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        private a() {
        }
    }

    private static class b {
        public ArrayList a;
        public float b;

        private b() {
            this.a = new ArrayList();
        }
    }

    private static class c {
        public float a;
        public float b;

        private c() {
        }
    }

    private static class d {
        public float a;
        public float b;

        private d() {
        }
    }

    public Z05(float f, float f2, float f3, float f4) {
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, float f) {
        if (str == null) {
            return;
        }
        try {
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            b bVar = new b();
            bVar.b = f * this.f;
            String[] strArrSplit = str.split(Separators.SP);
            int i = 0;
            while (i < strArrSplit.length) {
                char cCharAt = strArrSplit[i].charAt(0);
                if (cCharAt == 'C') {
                    a aVar = new a();
                    aVar.c = (Float.parseFloat(strArrSplit[i + 1]) + this.d) * this.c;
                    aVar.d = (Float.parseFloat(strArrSplit[i + 2]) + this.e) * this.c;
                    aVar.e = (Float.parseFloat(strArrSplit[i + 3]) + this.d) * this.c;
                    aVar.f = (Float.parseFloat(strArrSplit[i + 4]) + this.e) * this.c;
                    aVar.a = (Float.parseFloat(strArrSplit[i + 5]) + this.d) * this.c;
                    i += 6;
                    aVar.b = (Float.parseFloat(strArrSplit[i]) + this.e) * this.c;
                    bVar.a.add(aVar);
                } else if (cCharAt == 'L') {
                    c cVar = new c();
                    cVar.a = (Float.parseFloat(strArrSplit[i + 1]) + this.d) * this.c;
                    i += 2;
                    cVar.b = (Float.parseFloat(strArrSplit[i]) + this.e) * this.c;
                    bVar.a.add(cVar);
                } else if (cCharAt == 'M') {
                    d dVar = new d();
                    dVar.a = (Float.parseFloat(strArrSplit[i + 1]) + this.d) * this.c;
                    i += 2;
                    dVar.b = (Float.parseFloat(strArrSplit[i]) + this.e) * this.c;
                    bVar.a.add(dVar);
                }
                i++;
            }
            this.g.add(bVar);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    public void b(Canvas canvas, Paint paint, float f) {
        float f2;
        if (this.b != f) {
            this.b = f;
            int size = this.g.size();
            b bVar = null;
            b bVar2 = null;
            for (int i = 0; i < size; i++) {
                b bVar3 = (b) this.g.get(i);
                if ((bVar2 == null || bVar2.b < bVar3.b) && bVar3.b <= f) {
                    bVar2 = bVar3;
                }
                if ((bVar == null || bVar.b > bVar3.b) && bVar3.b >= f) {
                    bVar = bVar3;
                }
            }
            if (bVar == bVar2) {
                bVar2 = null;
            }
            if (bVar2 != null && bVar == null) {
                bVar = bVar2;
                bVar2 = null;
            }
            if (bVar == null) {
                return;
            }
            if (bVar2 != null && bVar2.a.size() != bVar.a.size()) {
                return;
            }
            this.a.reset();
            int size2 = bVar.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Object obj = bVar2 != null ? bVar2.a.get(i2) : null;
                Object obj2 = bVar.a.get(i2);
                if (obj != null && obj.getClass() != obj2.getClass()) {
                    return;
                }
                if (bVar2 != null) {
                    float f3 = bVar2.b;
                    f2 = (f - f3) / (bVar.b - f3);
                } else {
                    f2 = 1.0f;
                }
                if (obj2 instanceof d) {
                    d dVar = (d) obj2;
                    d dVar2 = (d) obj;
                    if (dVar2 != null) {
                        Path path = this.a;
                        float f4 = dVar2.a;
                        float fH = AbstractC21455b.H(f4 + ((dVar.a - f4) * f2));
                        float f5 = dVar2.b;
                        path.moveTo(fH, AbstractC21455b.H(f5 + ((dVar.b - f5) * f2)));
                    } else {
                        this.a.moveTo(AbstractC21455b.H(dVar.a), AbstractC21455b.H(dVar.b));
                    }
                } else if (obj2 instanceof c) {
                    c cVar = (c) obj2;
                    c cVar2 = (c) obj;
                    if (cVar2 != null) {
                        Path path2 = this.a;
                        float f6 = cVar2.a;
                        float fH2 = AbstractC21455b.H(f6 + ((cVar.a - f6) * f2));
                        float f7 = cVar2.b;
                        path2.lineTo(fH2, AbstractC21455b.H(f7 + ((cVar.b - f7) * f2)));
                    } else {
                        this.a.lineTo(AbstractC21455b.H(cVar.a), AbstractC21455b.H(cVar.b));
                    }
                } else if (obj2 instanceof a) {
                    a aVar = (a) obj2;
                    a aVar2 = (a) obj;
                    if (aVar2 != null) {
                        Path path3 = this.a;
                        float f8 = aVar2.c;
                        float fH3 = AbstractC21455b.H(f8 + ((aVar.c - f8) * f2));
                        float f9 = aVar2.d;
                        float fH4 = AbstractC21455b.H(f9 + ((aVar.d - f9) * f2));
                        float f10 = aVar2.e;
                        float fH5 = AbstractC21455b.H(f10 + ((aVar.e - f10) * f2));
                        float f11 = aVar2.f;
                        float fH6 = AbstractC21455b.H(f11 + ((aVar.f - f11) * f2));
                        float f12 = aVar2.a;
                        float fH7 = AbstractC21455b.H(f12 + ((aVar.a - f12) * f2));
                        float f13 = aVar2.b;
                        path3.cubicTo(fH3, fH4, fH5, fH6, fH7, AbstractC21455b.H(f13 + ((aVar.b - f13) * f2)));
                    } else {
                        this.a.cubicTo(AbstractC21455b.H(aVar.c), AbstractC21455b.H(aVar.d), AbstractC21455b.H(aVar.e), AbstractC21455b.H(aVar.f), AbstractC21455b.H(aVar.a), AbstractC21455b.H(aVar.b));
                    }
                }
            }
            this.a.close();
        }
        canvas.drawPath(this.a, paint);
    }
}
