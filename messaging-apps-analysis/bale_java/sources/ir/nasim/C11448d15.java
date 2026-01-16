package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: ir.nasim.d15, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11448d15 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final Path e = new Path();
    private float f = -1.0f;
    private final ArrayList g = new ArrayList();

    /* renamed from: ir.nasim.d15$a */
    private static final class a {
        private float a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;

        public final float a() {
            return this.a;
        }

        public final float b() {
            return this.c;
        }

        public final float c() {
            return this.e;
        }

        public final float d() {
            return this.b;
        }

        public final float e() {
            return this.d;
        }

        public final float f() {
            return this.f;
        }

        public final void g(float f) {
            this.a = f;
        }

        public final void h(float f) {
            this.c = f;
        }

        public final void i(float f) {
            this.e = f;
        }

        public final void j(float f) {
            this.b = f;
        }

        public final void k(float f) {
            this.d = f;
        }

        public final void l(float f) {
            this.f = f;
        }
    }

    /* renamed from: ir.nasim.d15$b */
    private static final class b {
        private ArrayList a = new ArrayList();
        private float b;

        public final ArrayList a() {
            return this.a;
        }

        public final float b() {
            return this.b;
        }

        public final void c(float f) {
            this.b = f;
        }
    }

    /* renamed from: ir.nasim.d15$c */
    private static final class c {
        private float a;
        private float b;

        public final float a() {
            return this.a;
        }

        public final float b() {
            return this.b;
        }

        public final void c(float f) {
            this.a = f;
        }

        public final void d(float f) {
            this.b = f;
        }
    }

    /* renamed from: ir.nasim.d15$d */
    private static final class d {
        private float a;
        private float b;

        public final float a() {
            return this.a;
        }

        public final float b() {
            return this.b;
        }

        public final void c(float f) {
            this.a = f;
        }

        public final void d(float f) {
            this.b = f;
        }
    }

    public C11448d15(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final void a(String str, float f) {
        List listM;
        if (str == null) {
            return;
        }
        try {
            b bVar = new b();
            bVar.c(f * this.d);
            List listM2 = new C20644sM5(Separators.SP).m(str, 0);
            if (listM2.isEmpty()) {
                listM = AbstractC10360bX0.m();
            } else {
                ListIterator listIterator = listM2.listIterator(listM2.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
            }
            String[] strArr = (String[]) listM.toArray(new String[0]);
            int i = 0;
            while (i < strArr.length) {
                char cCharAt = strArr[i].charAt(0);
                if (cCharAt == 'M') {
                    d dVar = new d();
                    dVar.c((Float.parseFloat(strArr[i + 1]) + this.b) * this.a);
                    i += 2;
                    dVar.d((Float.parseFloat(strArr[i]) + this.c) * this.a);
                    bVar.a().add(dVar);
                } else if (cCharAt == 'C') {
                    a aVar = new a();
                    aVar.h((Float.parseFloat(strArr[i + 1]) + this.b) * this.a);
                    aVar.k((Float.parseFloat(strArr[i + 2]) + this.c) * this.a);
                    aVar.i((Float.parseFloat(strArr[i + 3]) + this.b) * this.a);
                    aVar.l((Float.parseFloat(strArr[i + 4]) + this.c) * this.a);
                    aVar.g((Float.parseFloat(strArr[i + 5]) + this.b) * this.a);
                    i += 6;
                    aVar.j((Float.parseFloat(strArr[i]) + this.c) * this.a);
                    bVar.a().add(aVar);
                } else if (cCharAt == 'L') {
                    c cVar = new c();
                    cVar.c((Float.parseFloat(strArr[i + 1]) + this.b) * this.a);
                    i += 2;
                    cVar.d((Float.parseFloat(strArr[i]) + this.c) * this.a);
                    bVar.a().add(cVar);
                }
                i++;
            }
            this.g.add(bVar);
        } catch (Exception unused) {
        }
    }

    public final void b(Canvas canvas, Paint paint, float f) {
        int i;
        float f2 = f;
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        if (this.f != f2) {
            this.f = f2;
            int size = this.g.size();
            int i2 = 0;
            b bVar = null;
            b bVar2 = null;
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = this.g.get(i3);
                AbstractC13042fc3.h(obj, "get(...)");
                b bVar3 = (b) obj;
                if ((bVar2 == null || bVar2.b() < bVar3.b()) && bVar3.b() <= f2) {
                    bVar2 = bVar3;
                }
                if ((bVar == null || bVar.b() > bVar3.b()) && bVar3.b() >= f2) {
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
            if (bVar2 != null && bVar2.a().size() != bVar.a().size()) {
                return;
            }
            this.e.reset();
            int size2 = bVar.a().size();
            while (i2 < size2) {
                Object obj2 = bVar2 != null ? bVar2.a().get(i2) : null;
                Object obj3 = bVar.a().get(i2);
                AbstractC13042fc3.h(obj3, "get(...)");
                if (obj2 != null && !AbstractC13042fc3.d(obj2.getClass(), obj3.getClass())) {
                    return;
                }
                float fB = bVar2 != null ? (f2 - bVar2.b()) / (bVar.b() - bVar2.b()) : 1.0f;
                if (obj3 instanceof d) {
                    if (((d) obj2) != null) {
                        d dVar = (d) obj3;
                        this.e.moveTo(C22078ud6.a(r7.a() + ((dVar.a() - r7.a()) * fB)), C22078ud6.a(r7.b() + ((dVar.b() - r7.b()) * fB)));
                    } else {
                        d dVar2 = (d) obj3;
                        this.e.moveTo(C22078ud6.a(dVar2.a()), C22078ud6.a(dVar2.b()));
                    }
                } else if (obj3 instanceof c) {
                    if (((c) obj2) != null) {
                        c cVar = (c) obj3;
                        this.e.lineTo(C22078ud6.a(r7.a() + ((cVar.a() - r7.a()) * fB)), C22078ud6.a(r7.b() + ((cVar.b() - r7.b()) * fB)));
                    } else {
                        c cVar2 = (c) obj3;
                        this.e.lineTo(C22078ud6.a(cVar2.a()), C22078ud6.a(cVar2.b()));
                    }
                } else {
                    if (obj3 instanceof a) {
                        if (((a) obj2) != null) {
                            a aVar = (a) obj3;
                            i = size2;
                            this.e.cubicTo(C22078ud6.a(r7.b() + ((aVar.b() - r7.b()) * fB)), C22078ud6.a(r7.e() + ((aVar.e() - r7.e()) * fB)), C22078ud6.a(r7.c() + ((aVar.c() - r7.c()) * fB)), C22078ud6.a(r7.f() + ((aVar.f() - r7.f()) * fB)), C22078ud6.a(r7.a() + ((aVar.a() - r7.a()) * fB)), C22078ud6.a(r7.d() + ((aVar.d() - r7.d()) * fB)));
                        } else {
                            i = size2;
                            a aVar2 = (a) obj3;
                            this.e.cubicTo(C22078ud6.a(aVar2.b()), C22078ud6.a(aVar2.e()), C22078ud6.a(aVar2.c()), C22078ud6.a(aVar2.f()), C22078ud6.a(aVar2.a()), C22078ud6.a(aVar2.d()));
                        }
                    }
                    i2++;
                    f2 = f;
                    size2 = i;
                }
                i = size2;
                i2++;
                f2 = f;
                size2 = i;
            }
            this.e.close();
        }
        canvas.drawPath(this.e, paint);
    }
}
