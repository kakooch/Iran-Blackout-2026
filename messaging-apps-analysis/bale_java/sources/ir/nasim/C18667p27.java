package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.AbstractC1920a;
import androidx.camera.core.impl.w;
import ir.nasim.AbstractC19849r27;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.p27, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18667p27 {
    private final String i;
    private final InterfaceC21808uA0 j;
    private final C19349qC0 k;
    private final C9028Ye2 l;
    private final int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    AbstractC9496a37 t;
    private final C21341tV1 v;
    private final C16889m22 y;
    private final List a = new ArrayList();
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private final Map e = new HashMap();
    private final List f = new ArrayList();
    private final List g = new ArrayList();
    private final List h = new ArrayList();
    List u = new ArrayList();
    private final C23325wj7 w = new C23325wj7();
    private final C20734sW5 x = new C20734sW5();

    /* renamed from: ir.nasim.p27$a */
    static class a {
        static Size[] a(StreamConfigurationMap streamConfigurationMap, int i) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i);
        }
    }

    /* renamed from: ir.nasim.p27$b */
    static abstract class b {
        b() {
        }

        static b e(int i, int i2, boolean z, boolean z2) {
            return new CT(i, i2, z, z2);
        }

        abstract int a();

        abstract int b();

        abstract boolean c();

        abstract boolean d();
    }

    C18667p27(Context context, String str, C17585nD0 c17585nD0, InterfaceC21808uA0 interfaceC21808uA0) throws CameraUnavailableException, NumberFormatException {
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        String str2 = (String) AbstractC4980Hj5.g(str);
        this.i = str2;
        this.j = (InterfaceC21808uA0) AbstractC4980Hj5.g(interfaceC21808uA0);
        this.l = new C9028Ye2();
        this.v = C21341tV1.c(context);
        try {
            C19349qC0 c19349qC0C = c17585nD0.c(str2);
            this.k = c19349qC0C;
            Integer num = (Integer) c19349qC0C.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.m = num != null ? num.intValue() : 2;
            int[] iArr = (int[]) c19349qC0C.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 3) {
                        this.n = true;
                    } else if (i == 6) {
                        this.o = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i == 16) {
                        this.r = true;
                    }
                }
            }
            C16889m22 c16889m22 = new C16889m22(this.k);
            this.y = c16889m22;
            k();
            if (this.r) {
                n();
            }
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.p = zHasSystemFeature;
            if (zHasSystemFeature) {
                h();
            }
            if (c16889m22.d()) {
                g();
            }
            if (J()) {
                m();
            }
            boolean zH = AbstractC14827iY6.h(this.k);
            this.q = zH;
            if (zH) {
                j();
            }
            boolean zA = AbstractC15390jV7.a(this.k);
            this.s = zA;
            if (zA) {
                i();
            }
            l();
            b();
        } catch (CameraAccessExceptionCompat e) {
            throw MD0.a(e);
        }
    }

    private List B(b bVar) {
        if (this.e.containsKey(bVar)) {
            return (List) this.e.get(bVar);
        }
        List arrayList = new ArrayList();
        if (bVar.d()) {
            if (bVar.a() == 0) {
                arrayList.addAll(this.g);
            }
        } else if (bVar.b() == 8) {
            int iA = bVar.a();
            if (iA == 1) {
                arrayList = this.c;
            } else if (iA != 2) {
                arrayList.addAll(bVar.c() ? this.d : this.a);
            } else {
                arrayList.addAll(this.b);
                arrayList.addAll(this.a);
            }
        } else if (bVar.b() == 10 && bVar.a() == 0) {
            arrayList.addAll(this.f);
        }
        this.e.put(bVar, arrayList);
        return arrayList;
    }

    private Pair C(int i, List list, List list2, List list3, List list4, int i2, Map map, Map map2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC1920a abstractC1920a = (AbstractC1920a) it.next();
            arrayList.add(abstractC1920a.g());
            if (map != null) {
                map.put(Integer.valueOf(arrayList.size() - 1), abstractC1920a);
            }
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            Size size = (Size) list2.get(i3);
            androidx.camera.core.impl.C c = (androidx.camera.core.impl.C) list3.get(((Integer) list4.get(i3)).intValue());
            int inputFormat = c.getInputFormat();
            arrayList.add(AbstractC19849r27.h(i, inputFormat, size, F(inputFormat)));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList.size() - 1), c);
            }
            i2 = E(i2, c.getInputFormat(), size);
        }
        return new Pair(arrayList, Integer.valueOf(i2));
    }

    private Range D(List list, List list2, List list3) {
        Iterator it = list.iterator();
        Range rangeG = null;
        while (it.hasNext()) {
            rangeG = G(((AbstractC1920a) it.next()).h(), rangeG);
        }
        Iterator it2 = list3.iterator();
        while (it2.hasNext()) {
            rangeG = G(((androidx.camera.core.impl.C) list2.get(((Integer) it2.next()).intValue())).w(null), rangeG);
        }
        return rangeG;
    }

    private int E(int i, int i2, Size size) {
        return Math.min(i, q(this.k, i2, size));
    }

    private Range G(Range range, Range range2) {
        if (range2 == null) {
            return range;
        }
        if (range != null) {
            try {
                return range2.intersect(range);
            } catch (IllegalArgumentException unused) {
            }
        }
        return range2;
    }

    private static List H(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iZ = ((androidx.camera.core.impl.C) it.next()).z(0);
            if (!arrayList2.contains(Integer.valueOf(iZ))) {
                arrayList2.add(Integer.valueOf(iZ));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                androidx.camera.core.impl.C c = (androidx.camera.core.impl.C) it3.next();
                if (iIntValue == c.z(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(c)));
                }
            }
        }
        return arrayList;
    }

    private static boolean I(List list, Map map) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((AbstractC1920a) it.next()).d() == 4101) {
                return true;
            }
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (((androidx.camera.core.impl.C) it2.next()).getInputFormat() == 4101) {
                return true;
            }
        }
        return false;
    }

    private boolean J() {
        int[] iArrB = this.k.b().b();
        if (iArrB == null) {
            return false;
        }
        for (int i : iArrB) {
            if (i == 4101) {
                return true;
            }
        }
        return false;
    }

    private boolean K(b bVar, List list, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbstractC1920a) it.next()).g());
        }
        C15686k01 c15686k01 = new C15686k01();
        for (androidx.camera.core.impl.C c : map.keySet()) {
            List list2 = (List) map.get(c);
            AbstractC4980Hj5.b((list2 == null || list2.isEmpty()) ? false : true, "No available output size is found for " + c + Separators.DOT);
            Size size = (Size) Collections.min(list2, c15686k01);
            int inputFormat = c.getInputFormat();
            arrayList.add(AbstractC19849r27.h(bVar.a(), inputFormat, size, F(inputFormat)));
        }
        return c(bVar, arrayList);
    }

    private void L() throws NumberFormatException {
        this.v.g();
        if (this.t == null) {
            l();
        } else {
            this.t = AbstractC9496a37.a(this.t.b(), this.t.j(), this.v.f(), this.t.h(), this.t.f(), this.t.d(), this.t.l());
        }
    }

    private void N(Map map, int i) {
        Size sizeR = r(this.k.b().d(), i, true);
        if (sizeR != null) {
            map.put(Integer.valueOf(i), sizeR);
        }
    }

    private void O(Map map, Size size, int i) {
        if (this.p) {
            Size sizeR = r(this.k.b().d(), i, false);
            Integer numValueOf = Integer.valueOf(i);
            if (sizeR != null) {
                size = (Size) Collections.min(Arrays.asList(size, sizeR), new C15686k01());
            }
            map.put(numValueOf, size);
        }
    }

    private void P(Map map, int i) {
        StreamConfigurationMap streamConfigurationMap;
        if (Build.VERSION.SDK_INT < 31 || !this.r || (streamConfigurationMap = (StreamConfigurationMap) this.k.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) == null) {
            return;
        }
        map.put(Integer.valueOf(i), r(streamConfigurationMap, i, true));
    }

    private static Range d(Range range, Range range2, Range range3) {
        double dV = v(range2.intersect(range));
        double dV2 = v(range3.intersect(range));
        double dV3 = dV2 / v(range3);
        double dV4 = dV / v(range2);
        if (dV2 > dV) {
            if (dV3 >= 0.5d || dV3 >= dV4) {
                return range3;
            }
        } else if (dV2 == dV) {
            if (dV3 > dV4) {
                return range3;
            }
            if (dV3 == dV4 && ((Integer) range3.getLower()).intValue() > ((Integer) range2.getLower()).intValue()) {
                return range3;
            }
        } else if (dV4 < 0.5d && dV3 > dV4) {
            return range3;
        }
        return range2;
    }

    private b e(int i, Map map, boolean z, boolean z2) {
        int iZ = z(map);
        if (i != 0 && z2) {
            throw new IllegalArgumentException(String.format("Camera device id is %s. Ultra HDR is not currently supported in %s camera mode.", this.i, AbstractC20558sD0.a(i)));
        }
        if (i == 0 || iZ != 10) {
            return b.e(i, iZ, z, z2);
        }
        throw new IllegalArgumentException(String.format("Camera device id is %s. 10 bit dynamic range is not currently supported in %s camera mode.", this.i, AbstractC20558sD0.a(i)));
    }

    private Map f(Map map, b bVar, Range range) {
        HashMap map2 = new HashMap();
        for (androidx.camera.core.impl.C c : map.keySet()) {
            ArrayList arrayList = new ArrayList();
            HashMap map3 = new HashMap();
            for (Size size : (List) map.get(c)) {
                int inputFormat = c.getInputFormat();
                AbstractC19849r27.a aVarC = AbstractC19849r27.h(bVar.a(), inputFormat, size, F(inputFormat)).c();
                int iQ = range != null ? q(this.k, inputFormat, size) : Integer.MAX_VALUE;
                Set hashSet = (Set) map3.get(aVarC);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map3.put(aVarC, hashSet);
                }
                if (!hashSet.contains(Integer.valueOf(iQ))) {
                    arrayList.add(size);
                    hashSet.add(Integer.valueOf(iQ));
                }
            }
            map2.put(c, arrayList);
        }
        return map2;
    }

    private void g() {
        this.f.addAll(MS2.b());
    }

    private void h() {
        this.c.addAll(MS2.d());
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.d.addAll(MS2.i());
        }
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.h.addAll(MS2.k());
        }
    }

    private void k() {
        this.a.addAll(MS2.a(this.m, this.n, this.o));
        this.a.addAll(this.l.a(this.i));
    }

    private void l() throws NumberFormatException {
        this.t = AbstractC9496a37.a(AbstractC10811cE6.c, new HashMap(), this.v.f(), new HashMap(), w(), new HashMap(), new HashMap());
    }

    private void m() {
        this.g.addAll(MS2.l());
    }

    private void n() {
        this.b.addAll(MS2.m());
    }

    private List o(List list) {
        Iterator it = list.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= ((List) it.next()).size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new ArrayList());
        }
        int size2 = size / ((List) list.get(0)).size();
        int i2 = size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            List list2 = (List) list.get(i3);
            for (int i4 = 0; i4 < size; i4++) {
                ((List) arrayList.get(i4)).add((Size) list2.get((i4 % i2) / size2));
            }
            if (i3 < list.size() - 1) {
                i2 = size2;
                size2 /= ((List) list.get(i3 + 1)).size();
            }
        }
        return arrayList;
    }

    private Range p(Range range, int i) {
        if (range != null) {
            Range rangeD = androidx.camera.core.impl.w.a;
            if (!range.equals(rangeD)) {
                Range[] rangeArr = (Range[]) this.k.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr == null) {
                    return rangeD;
                }
                Range range2 = new Range(Integer.valueOf(Math.min(((Integer) range.getLower()).intValue(), i)), Integer.valueOf(Math.min(((Integer) range.getUpper()).intValue(), i)));
                int iV = 0;
                for (Range range3 : rangeArr) {
                    if (i >= ((Integer) range3.getLower()).intValue()) {
                        if (rangeD.equals(androidx.camera.core.impl.w.a)) {
                            rangeD = range3;
                        }
                        if (range3.equals(range2)) {
                            return range3;
                        }
                        try {
                            int iV2 = v(range3.intersect(range2));
                            if (iV == 0) {
                                iV = iV2;
                            } else {
                                if (iV2 >= iV) {
                                    rangeD = d(range2, rangeD, range3);
                                    iV = v(range2.intersect(rangeD));
                                }
                                range3 = rangeD;
                            }
                        } catch (IllegalArgumentException unused) {
                            if (iV != 0 || (u(range3, range2) >= u(rangeD, range2) && (u(range3, range2) != u(rangeD, range2) || (((Integer) range3.getLower()).intValue() <= ((Integer) rangeD.getUpper()).intValue() && v(range3) >= v(rangeD))))) {
                            }
                        }
                        rangeD = range3;
                    }
                }
                return rangeD;
            }
        }
        return androidx.camera.core.impl.w.a;
    }

    static int q(C19349qC0 c19349qC0, int i, Size size) {
        try {
            return (int) (1.0E9d / ((StreamConfigurationMap) c19349qC0.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(i, size));
        } catch (Exception unused) {
            return 0;
        }
    }

    private Size r(StreamConfigurationMap streamConfigurationMap, int i, boolean z) {
        Size[] sizeArrA;
        Size[] outputSizes = i == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        C15686k01 c15686k01 = new C15686k01();
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), c15686k01);
        Size size2 = AbstractC10811cE6.a;
        if (z && (sizeArrA = a.a(streamConfigurationMap, i)) != null && sizeArrA.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(sizeArrA), c15686k01);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), c15686k01);
    }

    private int s(List list) {
        Iterator it = list.iterator();
        int iE = Integer.MAX_VALUE;
        while (it.hasNext()) {
            AbstractC1920a abstractC1920a = (AbstractC1920a) it.next();
            iE = E(iE, abstractC1920a.d(), abstractC1920a.f());
        }
        return iE;
    }

    private static int u(Range range, Range range2) {
        AbstractC4980Hj5.j((range.contains((Range) range2.getUpper()) || range.contains((Range) range2.getLower())) ? false : true, "Ranges must not intersect");
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    private static int v(Range range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    private Size w() throws NumberFormatException {
        try {
            int i = Integer.parseInt(this.i);
            CamcorderProfile camcorderProfileA = this.j.b(i, 1) ? this.j.a(i, 1) : null;
            return camcorderProfileA != null ? new Size(camcorderProfileA.videoFrameWidth, camcorderProfileA.videoFrameHeight) : x(i);
        } catch (NumberFormatException unused) {
            return y();
        }
    }

    private Size x(int i) {
        Size size = AbstractC10811cE6.d;
        CamcorderProfile camcorderProfileA = this.j.b(i, 10) ? this.j.a(i, 10) : this.j.b(i, 8) ? this.j.a(i, 8) : this.j.b(i, 12) ? this.j.a(i, 12) : this.j.b(i, 6) ? this.j.a(i, 6) : this.j.b(i, 5) ? this.j.a(i, 5) : this.j.b(i, 4) ? this.j.a(i, 4) : null;
        return camcorderProfileA != null ? new Size(camcorderProfileA.videoFrameWidth, camcorderProfileA.videoFrameHeight) : size;
    }

    private Size y() {
        Size[] outputSizes = this.k.b().d().getOutputSizes(MediaRecorder.class);
        if (outputSizes == null) {
            return AbstractC10811cE6.d;
        }
        Arrays.sort(outputSizes, new C15686k01(true));
        for (Size size : outputSizes) {
            int width = size.getWidth();
            Size size2 = AbstractC10811cE6.f;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return AbstractC10811cE6.d;
    }

    private static int z(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            if (((C15116j22) it.next()).a() == 10) {
                return 10;
            }
        }
        return 8;
    }

    Pair A(int i, List list, Map map, boolean z, boolean z2) throws NumberFormatException {
        Map map2;
        HashMap map3;
        HashMap map4;
        Range range;
        List list2;
        Map map5;
        int i2;
        String str;
        String str2;
        Map map6;
        List list3;
        String str3;
        String str4;
        Map map7;
        Map map8;
        List list4;
        List list5;
        HashMap map9;
        int i3;
        int i4;
        int i5;
        String str5;
        L();
        List arrayList = new ArrayList(map.keySet());
        List listH = H(arrayList);
        Map mapG = this.y.g(list, arrayList, listH);
        b bVarE = e(i, mapG, z, I(list, map));
        boolean zK = K(bVarE, list, map);
        String str6 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String str7 = " New configs: ";
        String str8 = "No supported surface combination is found for camera device - Id : ";
        if (!zK) {
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.i + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + arrayList);
        }
        Range rangeD = D(list, arrayList, listH);
        Map mapF = f(map, bVarE, rangeD);
        List arrayList2 = new ArrayList();
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.C c = (androidx.camera.core.impl.C) arrayList.get(((Integer) it.next()).intValue());
            arrayList2.add(a((List) mapF.get(c), c.getInputFormat()));
        }
        List listO = o(arrayList2);
        HashMap map10 = new HashMap();
        HashMap map11 = new HashMap();
        Map map12 = new HashMap();
        Map map13 = new HashMap();
        boolean zD = AbstractC14827iY6.d(list, arrayList);
        int iS = s(list);
        Map map14 = map13;
        if (!this.q || zD) {
            map2 = map12;
            map3 = map11;
            map4 = map10;
            range = rangeD;
            list2 = listH;
            map5 = mapG;
            i2 = iS;
            str = "No supported surface combination is found for camera device - Id : ";
            str2 = " New configs: ";
            map6 = map14;
            list3 = null;
        } else {
            Iterator it2 = listO.iterator();
            List listT = null;
            while (true) {
                if (!it2.hasNext()) {
                    map3 = map11;
                    map4 = map10;
                    range = rangeD;
                    list2 = listH;
                    map5 = mapG;
                    i2 = iS;
                    str = str8;
                    str2 = str7;
                    str5 = str6;
                    map6 = map14;
                    map2 = map12;
                    break;
                }
                Map map15 = map14;
                Map map16 = map12;
                map3 = map11;
                map4 = map10;
                map5 = mapG;
                Range range2 = rangeD;
                List list6 = listH;
                range = range2;
                str = str8;
                int i6 = iS;
                i2 = iS;
                str2 = str7;
                list2 = listH;
                str5 = str6;
                listT = t(bVarE, (List) C(i, list, (List) it2.next(), arrayList, list6, i6, map16, map15).first);
                map2 = map16;
                map6 = map15;
                if (listT != null && !AbstractC14827iY6.a(map2, map6, listT)) {
                    listT = null;
                }
                if (listT != null) {
                    if (AbstractC14827iY6.c(this.k, listT)) {
                        break;
                    }
                    listT = null;
                }
                map2.clear();
                map6.clear();
                map14 = map6;
                map12 = map2;
                str6 = str5;
                str8 = str;
                str7 = str2;
                mapG = map5;
                map11 = map3;
                map10 = map4;
                rangeD = range;
                iS = i2;
                listH = list2;
            }
            if (listT == null && !zK) {
                throw new IllegalArgumentException(str + this.i + str5 + list + str2 + arrayList);
            }
            list3 = listT;
        }
        Iterator it3 = listO.iterator();
        int i7 = Integer.MAX_VALUE;
        int iIntValue = Integer.MAX_VALUE;
        boolean z3 = false;
        boolean z4 = false;
        List list7 = null;
        List list8 = null;
        while (true) {
            if (!it3.hasNext()) {
                str3 = str;
                str4 = str2;
                map7 = map6;
                map8 = map2;
                list4 = list7;
                list5 = list8;
                break;
            }
            List list9 = (List) it3.next();
            int i8 = i7;
            int i9 = iIntValue;
            str4 = str2;
            map7 = map6;
            str3 = str;
            map8 = map2;
            Pair pairC = C(i, list, list9, arrayList, list2, i2, null, null);
            List list10 = (List) pairC.first;
            iIntValue = ((Integer) pairC.second).intValue();
            int i10 = i2;
            boolean z5 = range == null || i10 <= iIntValue || iIntValue >= ((Integer) range.getLower()).intValue();
            if (z3 || !c(bVarE, list10)) {
                i3 = i9;
                i4 = Integer.MAX_VALUE;
            } else {
                i3 = i9;
                i4 = Integer.MAX_VALUE;
                if (i3 == Integer.MAX_VALUE || i3 < iIntValue) {
                    i3 = iIntValue;
                    list7 = list9;
                }
                if (z5) {
                    if (z4) {
                        list5 = list8;
                        list4 = list9;
                        i7 = i8;
                        break;
                    }
                    z3 = true;
                    i3 = iIntValue;
                    list7 = list9;
                }
            }
            if (list3 == null || z4 || t(bVarE, list10) == null) {
                i5 = i8;
            } else {
                i5 = i8;
                if (i5 == i4 || i5 < iIntValue) {
                    i5 = iIntValue;
                    list8 = list9;
                }
                if (!z5) {
                    continue;
                } else {
                    if (z3) {
                        i7 = iIntValue;
                        iIntValue = i3;
                        list4 = list7;
                        list5 = list9;
                        break;
                    }
                    z4 = true;
                    i5 = iIntValue;
                    list8 = list9;
                }
            }
            i2 = i10;
            iIntValue = i3;
            map2 = map8;
            map6 = map7;
            str = str3;
            str2 = str4;
            i7 = i5;
        }
        if (list4 == null) {
            throw new IllegalArgumentException(str3 + this.i + " and Hardware level: " + this.m + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + str4 + arrayList);
        }
        Range rangeP = range != null ? p(range, iIntValue) : null;
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            androidx.camera.core.impl.C c2 = (androidx.camera.core.impl.C) it4.next();
            List list11 = list2;
            Map map17 = map5;
            Iterator it5 = it4;
            w.a aVarF = androidx.camera.core.impl.w.a((Size) list4.get(list11.indexOf(Integer.valueOf(arrayList.indexOf(c2))))).b((C15116j22) AbstractC4980Hj5.g((C15116j22) map17.get(c2))).d(AbstractC14827iY6.e(c2)).f(z2);
            if (rangeP != null) {
                aVarF.c(rangeP);
            }
            map3.put(c2, aVarF.a());
            it4 = it5;
            list2 = list11;
            map5 = map17;
            rangeP = rangeP;
        }
        HashMap map18 = map3;
        if (list3 == null || iIntValue != i7 || list4.size() != list5.size()) {
            map9 = map4;
            break;
        }
        for (int i11 = 0; i11 < list4.size(); i11++) {
            if (!((Size) list4.get(i11)).equals(list5.get(i11))) {
                map9 = map4;
                break;
            }
        }
        map9 = map4;
        if (!AbstractC14827iY6.k(this.k, list, map18, map9)) {
            AbstractC14827iY6.l(map18, map9, map8, map7, list3);
        }
        return new Pair(map18, map9);
    }

    AbstractC9496a37 F(int i) {
        if (!this.u.contains(Integer.valueOf(i))) {
            O(this.t.j(), AbstractC10811cE6.e, i);
            O(this.t.h(), AbstractC10811cE6.g, i);
            N(this.t.d(), i);
            P(this.t.l(), i);
            this.u.add(Integer.valueOf(i));
        }
        return this.t;
    }

    AbstractC19849r27 M(int i, int i2, Size size) {
        return AbstractC19849r27.h(i, i2, size, F(i2));
    }

    List a(List list, int i) {
        Rational rational;
        int iA = this.w.a(this.i, this.k);
        if (iA == 0) {
            rational = AbstractC19420qK.a;
        } else if (iA == 1) {
            rational = AbstractC19420qK.c;
        } else if (iA != 2) {
            rational = null;
        } else {
            Size sizeC = F(256).c(256);
            rational = new Rational(sizeC.getWidth(), sizeC.getHeight());
        }
        if (rational != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if (AbstractC19420qK.a(size, rational)) {
                    arrayList.add(size);
                } else {
                    arrayList2.add(size);
                }
            }
            arrayList2.addAll(0, arrayList);
            list = arrayList2;
        }
        return this.x.a(AbstractC19849r27.e(i), list);
    }

    boolean c(b bVar, List list) {
        Iterator it = B(bVar).iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = ((C19258q27) it.next()).d(list) != null;
            if (z) {
                break;
            }
        }
        return z;
    }

    List t(b bVar, List list) {
        if (!AbstractC14827iY6.n(bVar)) {
            return null;
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            List listD = ((C19258q27) it.next()).d(list);
            if (listD != null) {
                return listD;
            }
        }
        return null;
    }

    private void b() {
    }
}
