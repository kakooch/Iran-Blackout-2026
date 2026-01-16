package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import ir.nasim.C14451hw1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: ir.nasim.xw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C24044xw7 {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final C3441Aw7 f;
    private final String[] g;
    public final String h;
    public final String i;
    public final C24044xw7 j;
    private final HashMap k;
    private final HashMap l;
    private List m;

    private C24044xw7(String str, String str2, long j, long j2, C3441Aw7 c3441Aw7, String[] strArr, String str3, String str4, C24044xw7 c24044xw7) {
        this.a = str;
        this.b = str2;
        this.i = str4;
        this.f = c3441Aw7;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        this.h = (String) AbstractC20011rK.e(str3);
        this.j = c24044xw7;
        this.k = new HashMap();
        this.l = new HashMap();
    }

    private void b(Map map, C14451hw1.b bVar, int i, int i2, int i3) {
        C3441Aw7 c3441Aw7F = AbstractC25228zw7.f(this.f, this.g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (c3441Aw7F != null) {
            AbstractC25228zw7.a(spannableStringBuilder2, i, i2, c3441Aw7F, this.j, map, i3);
            if ("p".equals(this.a)) {
                if (c3441Aw7F.k() != Float.MAX_VALUE) {
                    bVar.m((c3441Aw7F.k() * (-90.0f)) / 100.0f);
                }
                if (c3441Aw7F.m() != null) {
                    bVar.p(c3441Aw7F.m());
                }
                if (c3441Aw7F.h() != null) {
                    bVar.j(c3441Aw7F.h());
                }
            }
        }
    }

    public static C24044xw7 c(String str, long j, long j2, C3441Aw7 c3441Aw7, String[] strArr, String str2, String str3, C24044xw7 c24044xw7) {
        return new C24044xw7(str, null, j, j2, c3441Aw7, strArr, str2, str3, c24044xw7);
    }

    public static C24044xw7 d(String str) {
        return new C24044xw7(null, AbstractC25228zw7.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (MH1 mh1 : (MH1[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MH1.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(mh1), spannableStringBuilder.getSpanEnd(mh1), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == '\n') {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet treeSet, boolean z) {
        boolean zEquals = "p".equals(this.a);
        boolean zEquals2 = "div".equals(this.a);
        if (z || zEquals || (zEquals2 && this.i != null)) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            ((C24044xw7) this.m.get(i)).i(treeSet, z || zEquals);
        }
    }

    private static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            C14451hw1.b bVar = new C14451hw1.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) AbstractC20011rK.e(((C14451hw1.b) map.get(str)).e());
    }

    private void n(long j, String str, List list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (m(j) && "div".equals(this.a) && this.i != null) {
            list.add(new Pair(str, this.i));
            return;
        }
        for (int i = 0; i < g(); i++) {
            f(i).n(j, str, list);
        }
    }

    private void o(long j, Map map, Map map2, String str, Map map3) {
        int i;
        if (m(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator it = this.l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int iIntValue = this.k.containsKey(str3) ? ((Integer) this.k.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (C14451hw1.b) AbstractC20011rK.e((C14451hw1.b) map3.get(str3)), iIntValue, iIntValue2, ((C24634yw7) AbstractC20011rK.e((C24634yw7) map2.get(str2))).j);
                }
            }
            while (i < g()) {
                f(i).o(j, map, map2, str2, map3);
                i++;
            }
        }
    }

    private void p(long j, boolean z, String str, Map map) {
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
            return;
        }
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (this.c && z) {
            k(str, map).append((CharSequence) AbstractC20011rK.e(this.b));
            return;
        }
        if ("br".equals(this.a) && z) {
            k(str, map).append('\n');
            return;
        }
        if (m(j)) {
            for (Map.Entry entry : map.entrySet()) {
                this.k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) AbstractC20011rK.e(((C14451hw1.b) entry.getValue()).e())).length()));
            }
            boolean zEquals = "p".equals(this.a);
            for (int i = 0; i < g(); i++) {
                f(i).p(j, z || zEquals, str, map);
            }
            if (zEquals) {
                AbstractC25228zw7.c(k(str, map));
            }
            for (Map.Entry entry2 : map.entrySet()) {
                this.l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) AbstractC20011rK.e(((C14451hw1.b) entry2.getValue()).e())).length()));
            }
        }
    }

    public void a(C24044xw7 c24044xw7) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(c24044xw7);
    }

    public C24044xw7 f(int i) {
        List list = this.m;
        if (list != null) {
            return (C24044xw7) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        n(j, this.h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j, false, this.h, treeMap);
        o(j, map, map2, this.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                C24634yw7 c24634yw7 = (C24634yw7) AbstractC20011rK.e((C24634yw7) map2.get(pair.first));
                arrayList2.add(new C14451hw1.b().f(bitmapDecodeByteArray).k(c24634yw7.b).l(0).h(c24634yw7.c, 0).i(c24634yw7.e).n(c24634yw7.f).g(c24634yw7.g).r(c24634yw7.j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            C24634yw7 c24634yw72 = (C24634yw7) AbstractC20011rK.e((C24634yw7) map2.get(entry.getKey()));
            C14451hw1.b bVar = (C14451hw1.b) entry.getValue();
            e((SpannableStringBuilder) AbstractC20011rK.e(bVar.e()));
            bVar.h(c24634yw72.c, c24634yw72.d);
            bVar.i(c24634yw72.e);
            bVar.k(c24634yw72.b);
            bVar.n(c24634yw72.f);
            bVar.q(c24634yw72.i, c24634yw72.h);
            bVar.r(c24634yw72.j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public String[] l() {
        return this.g;
    }

    public boolean m(long j) {
        long j2 = this.d;
        return (j2 == -9223372036854775807L && this.e == -9223372036854775807L) || (j2 <= j && this.e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.e) || (j2 <= j && j < this.e));
    }
}
