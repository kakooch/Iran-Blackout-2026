package ir.nasim;

import ir.nasim.AbstractC19849r27;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MS2 {
    public static List a(int i, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f());
        if (i == 0 || i == 1 || i == 3) {
            arrayList.addAll(h());
        }
        if (i == 1 || i == 3) {
            arrayList.addAll(e());
        }
        if (z) {
            arrayList.addAll(j());
        }
        if (z2 && i == 0) {
            arrayList.addAll(c());
        }
        if (i == 3) {
            arrayList.addAll(g());
        }
        return arrayList;
    }

    public static List b() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.PREVIEW;
        c19258q273.a(AbstractC19849r27.a(bVar, aVar2));
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.JPEG;
        c19258q273.a(AbstractC19849r27.a(bVar3, aVar));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q274.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar, aVar2));
        AbstractC19849r27.a aVar3 = AbstractC19849r27.a.RECORD;
        c19258q276.a(AbstractC19849r27.a(bVar, aVar3));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        c19258q277.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q277.a(AbstractC19849r27.a(bVar, aVar3));
        c19258q277.a(AbstractC19849r27.a(bVar2, aVar3));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q278.a(AbstractC19849r27.a(bVar, aVar3));
        c19258q278.a(AbstractC19849r27.a(bVar3, aVar3));
        arrayList.add(c19258q278);
        return arrayList;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.PREVIEW;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar2));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        c19258q272.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q273);
        return arrayList;
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.YUV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.s1440p;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.PRIV;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.JPEG;
        c19258q273.a(AbstractC19849r27.a(bVar3, aVar));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.s720p;
        c19258q274.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q274.a(AbstractC19849r27.a(bVar3, aVar));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar3, aVar));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q276.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        c19258q277.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q277.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q278.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q278);
        C19258q27 c19258q279 = new C19258q27();
        c19258q279.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q279.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q279);
        return arrayList;
    }

    public static List e() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.PREVIEW;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar2));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        c19258q272.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.a(bVar, aVar));
        c19258q274.a(AbstractC19849r27.a(bVar, aVar));
        c19258q274.a(AbstractC19849r27.a(AbstractC19849r27.b.JPEG, aVar2));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        AbstractC19849r27.a aVar3 = AbstractC19849r27.a.VGA;
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar3));
        c19258q275.a(AbstractC19849r27.a(bVar, aVar));
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar3));
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q276);
        return arrayList;
    }

    public static List f() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.JPEG;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.YUV;
        c19258q273.a(AbstractC19849r27.a(bVar3, aVar));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.PREVIEW;
        c19258q274.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q274.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q276.a(AbstractC19849r27.a(bVar, aVar2));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        c19258q277.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q277.a(AbstractC19849r27.a(bVar3, aVar2));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q278.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q278.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q278);
        return arrayList;
    }

    public static List g() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.PREVIEW;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.VGA;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar2));
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        AbstractC19849r27.a aVar3 = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar2, aVar3));
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.RAW;
        c19258q27.a(AbstractC19849r27.a(bVar3, aVar3));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        c19258q272.a(AbstractC19849r27.a(bVar, aVar));
        c19258q272.a(AbstractC19849r27.a(bVar, aVar2));
        c19258q272.a(AbstractC19849r27.a(AbstractC19849r27.b.JPEG, aVar3));
        c19258q272.a(AbstractC19849r27.a(bVar3, aVar3));
        arrayList.add(c19258q272);
        return arrayList;
    }

    public static List h() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.PREVIEW;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.RECORD;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar2));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        c19258q272.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.a(bVar, aVar));
        c19258q274.a(AbstractC19849r27.a(bVar, aVar2));
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.JPEG;
        c19258q274.a(AbstractC19849r27.a(bVar3, aVar2));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar, aVar));
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar3, aVar2));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q276.a(AbstractC19849r27.a(bVar3, AbstractC19849r27.a.MAXIMUM));
        arrayList.add(c19258q276);
        return arrayList;
    }

    public static List i() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.s1440p;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        c19258q273.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.JPEG;
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.MAXIMUM;
        c19258q273.a(AbstractC19849r27.a(bVar3, aVar2));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q274.a(AbstractC19849r27.a(bVar3, aVar2));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar, aVar));
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar));
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar2));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        AbstractC19849r27.a aVar3 = AbstractC19849r27.a.PREVIEW;
        c19258q277.a(AbstractC19849r27.a(bVar, aVar3));
        c19258q277.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.a(bVar2, aVar3));
        c19258q278.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q278);
        C19258q27 c19258q279 = new C19258q27();
        c19258q279.a(AbstractC19849r27.a(bVar, aVar3));
        c19258q279.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q279);
        C19258q27 c19258q2710 = new C19258q27();
        c19258q2710.a(AbstractC19849r27.a(bVar2, aVar3));
        c19258q2710.a(AbstractC19849r27.a(bVar2, aVar));
        arrayList.add(c19258q2710);
        return arrayList;
    }

    public static List j() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.RAW;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.PREVIEW;
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q272.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.YUV;
        c19258q273.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q273.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q274.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q274.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q276.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q276.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        c19258q277.a(AbstractC19849r27.a(bVar2, aVar2));
        AbstractC19849r27.b bVar4 = AbstractC19849r27.b.JPEG;
        c19258q277.a(AbstractC19849r27.a(bVar4, aVar));
        c19258q277.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.a(bVar3, aVar2));
        c19258q278.a(AbstractC19849r27.a(bVar4, aVar));
        c19258q278.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q278);
        return arrayList;
    }

    public static List k() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.s1440p;
        c19258q27.a(AbstractC19849r27.b(bVar, aVar, 4L));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.YUV;
        c19258q272.a(AbstractC19849r27.b(bVar2, aVar, 4L));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.RECORD;
        c19258q273.a(AbstractC19849r27.b(bVar, aVar2, 3L));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.b(bVar2, aVar2, 3L));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.JPEG;
        AbstractC19849r27.a aVar3 = AbstractC19849r27.a.MAXIMUM;
        c19258q275.a(AbstractC19849r27.b(bVar3, aVar3, 2L));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.b(bVar2, aVar3, 2L));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        AbstractC19849r27.a aVar4 = AbstractC19849r27.a.PREVIEW;
        c19258q277.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q277.a(AbstractC19849r27.b(bVar3, aVar3, 2L));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q278.a(AbstractC19849r27.b(bVar2, aVar3, 2L));
        arrayList.add(c19258q278);
        C19258q27 c19258q279 = new C19258q27();
        c19258q279.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q279.a(AbstractC19849r27.b(bVar, aVar2, 3L));
        arrayList.add(c19258q279);
        C19258q27 c19258q2710 = new C19258q27();
        c19258q2710.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q2710.a(AbstractC19849r27.b(bVar2, aVar2, 3L));
        arrayList.add(c19258q2710);
        C19258q27 c19258q2711 = new C19258q27();
        c19258q2711.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q2711.a(AbstractC19849r27.b(bVar2, aVar4, 1L));
        arrayList.add(c19258q2711);
        C19258q27 c19258q2712 = new C19258q27();
        c19258q2712.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q2712.a(AbstractC19849r27.b(bVar, aVar2, 3L));
        c19258q2712.a(AbstractC19849r27.b(bVar3, aVar2, 2L));
        arrayList.add(c19258q2712);
        C19258q27 c19258q2713 = new C19258q27();
        c19258q2713.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q2713.a(AbstractC19849r27.b(bVar2, aVar2, 3L));
        c19258q2713.a(AbstractC19849r27.b(bVar3, aVar2, 2L));
        arrayList.add(c19258q2713);
        C19258q27 c19258q2714 = new C19258q27();
        c19258q2714.a(AbstractC19849r27.b(bVar, aVar4, 1L));
        c19258q2714.a(AbstractC19849r27.b(bVar2, aVar4, 1L));
        c19258q2714.a(AbstractC19849r27.b(bVar3, aVar3, 2L));
        arrayList.add(c19258q2714);
        return arrayList;
    }

    public static List l() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.JPEG_R;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        c19258q272.a(AbstractC19849r27.a(AbstractC19849r27.b.PRIV, AbstractC19849r27.a.PREVIEW));
        c19258q272.a(AbstractC19849r27.a(bVar, aVar));
        arrayList.add(c19258q272);
        return arrayList;
    }

    public static List m() {
        ArrayList arrayList = new ArrayList();
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.YUV;
        AbstractC19849r27.a aVar = AbstractC19849r27.a.ULTRA_MAXIMUM;
        c19258q27.a(AbstractC19849r27.a(bVar, aVar));
        AbstractC19849r27.b bVar2 = AbstractC19849r27.b.PRIV;
        AbstractC19849r27.a aVar2 = AbstractC19849r27.a.PREVIEW;
        c19258q27.a(AbstractC19849r27.a(bVar2, aVar2));
        AbstractC19849r27.a aVar3 = AbstractC19849r27.a.RECORD;
        c19258q27.a(AbstractC19849r27.a(bVar2, aVar3));
        arrayList.add(c19258q27);
        C19258q27 c19258q272 = new C19258q27();
        AbstractC19849r27.b bVar3 = AbstractC19849r27.b.JPEG;
        c19258q272.a(AbstractC19849r27.a(bVar3, aVar));
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q272.a(AbstractC19849r27.a(bVar2, aVar3));
        arrayList.add(c19258q272);
        C19258q27 c19258q273 = new C19258q27();
        AbstractC19849r27.b bVar4 = AbstractC19849r27.b.RAW;
        c19258q273.a(AbstractC19849r27.a(bVar4, aVar));
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q273.a(AbstractC19849r27.a(bVar2, aVar3));
        arrayList.add(c19258q273);
        C19258q27 c19258q274 = new C19258q27();
        c19258q274.a(AbstractC19849r27.a(bVar, aVar));
        c19258q274.a(AbstractC19849r27.a(bVar2, aVar2));
        AbstractC19849r27.a aVar4 = AbstractC19849r27.a.MAXIMUM;
        c19258q274.a(AbstractC19849r27.a(bVar3, aVar4));
        arrayList.add(c19258q274);
        C19258q27 c19258q275 = new C19258q27();
        c19258q275.a(AbstractC19849r27.a(bVar3, aVar));
        c19258q275.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q275.a(AbstractC19849r27.a(bVar3, aVar4));
        arrayList.add(c19258q275);
        C19258q27 c19258q276 = new C19258q27();
        c19258q276.a(AbstractC19849r27.a(bVar4, aVar));
        c19258q276.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q276.a(AbstractC19849r27.a(bVar3, aVar4));
        arrayList.add(c19258q276);
        C19258q27 c19258q277 = new C19258q27();
        c19258q277.a(AbstractC19849r27.a(bVar, aVar));
        c19258q277.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q277.a(AbstractC19849r27.a(bVar, aVar4));
        arrayList.add(c19258q277);
        C19258q27 c19258q278 = new C19258q27();
        c19258q278.a(AbstractC19849r27.a(bVar3, aVar));
        c19258q278.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q278.a(AbstractC19849r27.a(bVar, aVar4));
        arrayList.add(c19258q278);
        C19258q27 c19258q279 = new C19258q27();
        c19258q279.a(AbstractC19849r27.a(bVar4, aVar));
        c19258q279.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q279.a(AbstractC19849r27.a(bVar, aVar4));
        arrayList.add(c19258q279);
        C19258q27 c19258q2710 = new C19258q27();
        c19258q2710.a(AbstractC19849r27.a(bVar, aVar));
        c19258q2710.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q2710.a(AbstractC19849r27.a(bVar4, aVar4));
        arrayList.add(c19258q2710);
        C19258q27 c19258q2711 = new C19258q27();
        c19258q2711.a(AbstractC19849r27.a(bVar3, aVar));
        c19258q2711.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q2711.a(AbstractC19849r27.a(bVar4, aVar4));
        arrayList.add(c19258q2711);
        C19258q27 c19258q2712 = new C19258q27();
        c19258q2712.a(AbstractC19849r27.a(bVar4, aVar));
        c19258q2712.a(AbstractC19849r27.a(bVar2, aVar2));
        c19258q2712.a(AbstractC19849r27.a(bVar4, aVar4));
        arrayList.add(c19258q2712);
        return arrayList;
    }
}
