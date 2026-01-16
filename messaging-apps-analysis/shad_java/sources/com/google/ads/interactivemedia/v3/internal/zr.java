package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zr extends zu {
    public static final zr a = new zr(BuildConfig.FLAVOR, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    public final List<Uri> b;
    public final List<zq> c;
    public final List<zp> d;
    public final List<zp> e;
    public final cy f;
    public final List<cy> g;
    public final Map<String, String> h;
    public final List<jc> i;

    public zr(String str, List<String> list, List<zq> list2, List<zp> list3, List<zp> list4, List<zp> list5, List<zp> list6, cy cyVar, List<cy> list7, boolean z, Map<String, String> map, List<jc> list8) {
        super(str, list, z);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            Uri uri = list2.get(i).a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        c(list3, arrayList);
        c(list4, arrayList);
        c(list5, arrayList);
        c(list6, arrayList);
        this.b = Collections.unmodifiableList(arrayList);
        this.c = Collections.unmodifiableList(list2);
        Collections.unmodifiableList(list3);
        this.d = Collections.unmodifiableList(list4);
        this.e = Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
        this.f = cyVar;
        this.g = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.h = Collections.unmodifiableMap(map);
        this.i = Collections.unmodifiableList(list8);
    }

    public static zr b(String str) {
        Uri uri = Uri.parse(str);
        cx cxVar = new cx();
        cxVar.S("0");
        cxVar.K("application/x-mpegURL");
        return new zr(BuildConfig.FLAVOR, Collections.emptyList(), Collections.singletonList(new zq(uri, cxVar.a(), null, null, null, null)), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static void c(List<zp> list, List<Uri> list2) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> d(List<T> list, int i, List<sr> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < list2.size()) {
                    sr srVar = list2.get(i3);
                    if (srVar.b == i && srVar.c == i2) {
                        arrayList.add(t);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.so
    public final /* bridge */ /* synthetic */ zu a(List list) {
        return new zr(this.p, this.q, d(this.c, 0, list), Collections.emptyList(), d(this.d, 1, list), d(this.e, 2, list), Collections.emptyList(), this.f, this.g, this.r, this.h, this.i);
    }
}
