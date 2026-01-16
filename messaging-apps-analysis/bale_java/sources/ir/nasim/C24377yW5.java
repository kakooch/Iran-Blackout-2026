package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.yW5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C24377yW5 {
    private static final double h = Math.sqrt(2.3703703703703702d);
    private final Size a;
    private final Rational b;
    private final Rational c;
    private final Set d;
    private final C16303l27 e;
    private final InterfaceC14623iD0 f;
    private final Map g;

    /* renamed from: ir.nasim.yW5$a */
    private static class a implements Comparator {
        private final Rational a;
        private final boolean b;

        a(Rational rational, boolean z) {
            this.a = rational;
            this.b = z;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Rational rational, Rational rational2) {
            float fC = C24377yW5.c(rational, this.a);
            float fC2 = C24377yW5.c(rational2, this.a);
            return this.b ? Float.compare(fC2, fC) : Float.compare(fC, fC2);
        }
    }

    C24377yW5(InterfaceC15221jD0 interfaceC15221jD0, Set set) {
        this(AbstractC14447hv7.m(interfaceC15221jD0.b().c()), interfaceC15221jD0.j(), set);
    }

    private static boolean A(Collection collection, Size size) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!y((Size) it.next(), size)) {
                return true;
            }
        }
        return false;
    }

    private boolean B(Rational rational, Size size) {
        if (this.b.equals(rational) || AbstractC19420qK.a(size, rational)) {
            return false;
        }
        return b(this.b.floatValue(), rational.floatValue(), N(size).floatValue());
    }

    private boolean C(Size size, Size size2) {
        return B(N(size), size2);
    }

    private boolean D() {
        Iterator it = l().iterator();
        while (it.hasNext()) {
            if (!AbstractC19420qK.a((Size) it.next(), this.c)) {
                return true;
            }
        }
        return false;
    }

    private static List E(List list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    static Rect F(Rect rect) {
        return new Rect(rect.top, rect.left, rect.bottom, rect.right);
    }

    private List G(List list, boolean z) {
        Map mapX = x(list);
        ArrayList<Rational> arrayList = new ArrayList(mapX.keySet());
        K(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Rational rational : arrayList) {
            if (!rational.equals(AbstractC19420qK.c) && !rational.equals(AbstractC19420qK.a)) {
                List list2 = (List) mapX.get(rational);
                Objects.requireNonNull(list2);
                arrayList2.addAll(I(rational, list2, z));
            }
        }
        return arrayList2;
    }

    private List H(List list) {
        ArrayList arrayList = new ArrayList();
        if (D()) {
            arrayList.addAll(I(this.b, list, false));
        }
        arrayList.addAll(I(this.c, list, false));
        arrayList.addAll(G(list, false));
        if (arrayList.isEmpty()) {
            PI3.l("ResolutionsMerger", "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
            arrayList.addAll(G(list, true));
        }
        PI3.a("ResolutionsMerger", "Parent resolutions: " + arrayList);
        return arrayList;
    }

    private List I(Rational rational, List list, boolean z) {
        List<Size> listG = g(rational, list);
        L(listG);
        HashSet hashSet = new HashSet(listG);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            List listV = v((androidx.camera.core.impl.C) it.next());
            if (!z) {
                listV = d(rational, listV);
            }
            if (listV.isEmpty()) {
                return new ArrayList();
            }
            listG = f(listV, listG);
            hashSet.retainAll(p(listV, listG));
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : listG) {
            if (!hashSet.contains(size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    private boolean J() {
        boolean z;
        C22601vW5 c22601vW5G;
        Iterator it = this.d.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            androidx.camera.core.impl.C c = (androidx.camera.core.impl.C) it.next();
            if (!c.S(false) && (c instanceof androidx.camera.core.impl.o) && (c22601vW5G = ((androidx.camera.core.impl.o) c).G(null)) != null) {
                z = true;
                if (c22601vW5G.a() == 1) {
                    break;
                }
            }
        }
        return z;
    }

    private void K(List list) {
        Collections.sort(list, new a(M(this.a), true));
    }

    static void L(List list) {
        Collections.sort(list, new C15686k01(true));
    }

    private static Rational M(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private static Rational N(Size size) {
        Rational rational = AbstractC19420qK.a;
        if (AbstractC19420qK.a(size, rational)) {
            return rational;
        }
        Rational rational2 = AbstractC19420qK.c;
        return AbstractC19420qK.a(size, rational2) ? rational2 : M(size);
    }

    private boolean b(float f, float f2, float f3) {
        if (f == f2 || f2 == f3) {
            return false;
        }
        return f > f2 ? f2 < f3 : f2 > f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float c(Rational rational, Rational rational2) {
        float fFloatValue = rational.floatValue();
        float fFloatValue2 = rational2.floatValue();
        return fFloatValue > fFloatValue2 ? fFloatValue2 / fFloatValue : fFloatValue / fFloatValue2;
    }

    private List d(Rational rational, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (!B(rational, size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    private static List e(List list) {
        Rational rationalM;
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            Iterator it2 = map.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    rationalM = null;
                    break;
                }
                rationalM = (Rational) it2.next();
                if (AbstractC19420qK.a(size, rationalM)) {
                    break;
                }
            }
            if (rationalM != null) {
                Size size2 = (Size) map.get(rationalM);
                Objects.requireNonNull(size2);
                if (size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth() || (size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight())) {
                }
            } else {
                rationalM = M(size);
            }
            arrayList.add(size);
            map.put(rationalM, size);
        }
        return arrayList;
    }

    static List f(Collection collection, List list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (A(collection, size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    static List g(Rational rational, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (AbstractC19420qK.a(size, rational)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    private static Rational h(Size size) {
        return ((double) size.getWidth()) / ((double) size.getHeight()) > h ? AbstractC19420qK.c : AbstractC19420qK.a;
    }

    private List i() {
        return this.f.e(34);
    }

    private List j() {
        return this.f.h(34);
    }

    private static Rect k(Rational rational, Size size) {
        RectF rectF;
        RectF rectF2;
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rationalM = M(size);
        if (rational.floatValue() == rationalM.floatValue()) {
            rectF2 = new RectF(0.0f, 0.0f, width, height);
        } else {
            if (rational.floatValue() > rationalM.floatValue()) {
                float f = width;
                float fFloatValue = f / rational.floatValue();
                float f2 = (height - fFloatValue) / 2.0f;
                rectF = new RectF(0.0f, f2, f, fFloatValue + f2);
            } else {
                float f3 = height;
                float fFloatValue2 = rational.floatValue() * f3;
                float f4 = (width - fFloatValue2) / 2.0f;
                rectF = new RectF(f4, 0.0f, fFloatValue2 + f4, f3);
            }
            rectF2 = rectF;
        }
        Rect rect = new Rect();
        rectF2.round(rect);
        return rect;
    }

    private Set l() {
        HashSet hashSet = new HashSet();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            hashSet.addAll(v((androidx.camera.core.impl.C) it.next()));
        }
        return hashSet;
    }

    static Rect m(Size size, Size size2) {
        return k(M(size2), size);
    }

    private static Rational n(Rational rational) {
        Rational rational2 = AbstractC19420qK.a;
        if (rational.equals(rational2)) {
            return AbstractC19420qK.c;
        }
        if (rational.equals(AbstractC19420qK.c)) {
            return rational2;
        }
        throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + rational);
    }

    static List p(Collection collection, List list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        List<Size> listE = E(list);
        ArrayList arrayList = new ArrayList();
        for (Size size : listE) {
            if (z(collection, size)) {
                arrayList.add(size);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    private Pair t(Rect rect, androidx.camera.core.impl.C c, boolean z) {
        Size sizeQ;
        if (z) {
            sizeQ = r(AbstractC14447hv7.m(rect), c);
        } else {
            Size sizeM = AbstractC14447hv7.m(rect);
            sizeQ = q(sizeM, c);
            rect = m(sizeM, sizeQ);
        }
        return new Pair(rect, sizeQ);
    }

    private static Rational u(Size size) {
        Rational rationalH = h(size);
        PI3.a("ResolutionsMerger", "The closer aspect ratio to the sensor size (" + size + ") is " + rationalH + Separators.DOT);
        return rationalH;
    }

    private List v(androidx.camera.core.impl.C c) {
        if (!this.d.contains(c)) {
            throw new IllegalArgumentException("Invalid child config: " + c);
        }
        if (this.g.containsKey(c)) {
            List list = (List) this.g.get(c);
            Objects.requireNonNull(list);
            return list;
        }
        List listE = e(this.e.m(c));
        this.g.put(c, listE);
        return listE;
    }

    private static List w(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((Integer) pair.first).equals(34)) {
                return Arrays.asList((Size[]) pair.second);
            }
        }
        return new ArrayList();
    }

    private Map x(List list) {
        List arrayList;
        HashMap map = new HashMap();
        Rational rational = AbstractC19420qK.a;
        map.put(rational, new ArrayList());
        Rational rational2 = AbstractC19420qK.c;
        map.put(rational2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(rational);
        arrayList2.add(rational2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.getHeight() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        arrayList = null;
                        break;
                    }
                    Rational rational3 = (Rational) it2.next();
                    if (AbstractC19420qK.a(size, rational3)) {
                        arrayList = (List) map.get(rational3);
                        break;
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    Rational rationalM = M(size);
                    arrayList2.add(rationalM);
                    map.put(rationalM, arrayList);
                }
                arrayList.add(size);
            }
        }
        return map;
    }

    static boolean y(Size size, Size size2) {
        return size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth();
    }

    private static boolean z(Collection collection, Size size) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (y((Size) it.next(), size)) {
                return false;
            }
        }
        return true;
    }

    List o(androidx.camera.core.impl.p pVar) {
        List listJ = j();
        if (J()) {
            ArrayList arrayList = new ArrayList(listJ);
            arrayList.addAll(i());
            listJ = arrayList;
        }
        List list = (List) pVar.g(androidx.camera.core.impl.o.q, null);
        if (list != null) {
            listJ = w(list);
        }
        return H(listJ);
    }

    Size q(Size size, androidx.camera.core.impl.C c) {
        List<Size> listV = v(c);
        for (Size size2 : listV) {
            if (!C(size, size2) && !y(size2, size)) {
                return size2;
            }
        }
        for (Size size3 : listV) {
            if (!y(size3, size)) {
                return size3;
            }
        }
        return size;
    }

    Size r(Size size, androidx.camera.core.impl.C c) {
        Iterator it = v(c).iterator();
        while (it.hasNext()) {
            Size sizeM = AbstractC14447hv7.m(m((Size) it.next(), size));
            if (!y(sizeM, size)) {
                return sizeM;
            }
        }
        return size;
    }

    Pair s(androidx.camera.core.impl.C c, Rect rect, int i, boolean z) {
        boolean z2;
        if (AbstractC14447hv7.i(i)) {
            rect = F(rect);
            z2 = true;
        } else {
            z2 = false;
        }
        Pair pairT = t(rect, c, z);
        Rect rectF = (Rect) pairT.first;
        Size sizeN = (Size) pairT.second;
        if (z2) {
            sizeN = AbstractC14447hv7.n(sizeN);
            rectF = F(rectF);
        }
        return new Pair(rectF, sizeN);
    }

    private C24377yW5(Size size, InterfaceC14623iD0 interfaceC14623iD0, Set set) {
        this(size, interfaceC14623iD0, set, new C16303l27(interfaceC14623iD0, size));
    }

    C24377yW5(Size size, InterfaceC14623iD0 interfaceC14623iD0, Set set, C16303l27 c16303l27) {
        this.g = new HashMap();
        this.a = size;
        Rational rationalU = u(size);
        this.b = rationalU;
        this.c = n(rationalU);
        this.f = interfaceC14623iD0;
        this.d = set;
        this.e = c16303l27;
    }
}
