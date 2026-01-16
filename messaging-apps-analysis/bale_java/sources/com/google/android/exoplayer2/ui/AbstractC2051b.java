package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.ui.AbstractC2051b;
import ir.nasim.AbstractC13937h43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C13379g76;
import ir.nasim.C6169Ml7;
import ir.nasim.QY2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.ui.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC2051b {
    private static final Pattern a = Pattern.compile("(&#13;)?&#10;");

    /* renamed from: com.google.android.exoplayer2.ui.b$b, reason: collision with other inner class name */
    public static class C0162b {
        public final String a;
        public final Map b;

        private C0162b(String str, Map map) {
            this.a = str;
            this.b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.ui.b$c */
    static final class c {
        private static final Comparator e = new Comparator() { // from class: com.google.android.exoplayer2.ui.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC2051b.c.e((AbstractC2051b.c) obj, (AbstractC2051b.c) obj2);
            }
        };
        private static final Comparator f = new Comparator() { // from class: com.google.android.exoplayer2.ui.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC2051b.c.f((AbstractC2051b.c) obj, (AbstractC2051b.c) obj2);
            }
        };
        public final int a;
        public final int b;
        public final String c;
        public final String d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.b, cVar.b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.c.compareTo(cVar2.c);
            return iCompareTo != 0 ? iCompareTo : cVar.d.compareTo(cVar2.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int f(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.a, cVar.a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.c.compareTo(cVar.c);
            return iCompareTo != 0 ? iCompareTo : cVar2.d.compareTo(cVar.d);
        }

        private c(int i, int i2, String str, String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.b$d */
    private static final class d {
        private final List a = new ArrayList();
        private final List b = new ArrayList();
    }

    public static C0162b a(CharSequence charSequence, float f) {
        if (charSequence == null) {
            return new C0162b("", AbstractC13937h43.p());
        }
        if (!(charSequence instanceof Spanned)) {
            return new C0162b(b(charSequence), AbstractC13937h43.p());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            map.put(AbstractC2050a.a("bg_" + iIntValue), AbstractC9683aN7.A("background-color:%s;", AbstractC2050a.b(iIntValue)));
        }
        SparseArray sparseArrayC = c(spanned, f);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i2 = 0;
        while (i < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i);
            sb.append(b(spanned.subSequence(i2, iKeyAt)));
            d dVar = (d) sparseArrayC.get(iKeyAt);
            Collections.sort(dVar.b, c.f);
            Iterator it2 = dVar.b.iterator();
            while (it2.hasNext()) {
                sb.append(((c) it2.next()).d);
            }
            Collections.sort(dVar.a, c.e);
            Iterator it3 = dVar.a.iterator();
            while (it3.hasNext()) {
                sb.append(((c) it3.next()).c);
            }
            i++;
            i2 = iKeyAt;
        }
        sb.append(b(spanned.subSequence(i2, spanned.length())));
        return new C0162b(sb.toString(), map);
    }

    private static String b(CharSequence charSequence) {
        return a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray c(Spanned spanned, float f) {
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                AbstractC20011rK.e(strD);
                c cVar = new c(spanStart, spanEnd, strE, strD);
                f(sparseArray, spanStart).a.add(cVar);
                f(sparseArray, spanEnd).b.add(cVar);
            }
        }
        return sparseArray;
    }

    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof QY2) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof C6169Ml7)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof C13379g76) {
                return "<rt>" + b(((C13379g76) obj).a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    private static String e(Object obj, float f) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return AbstractC9683aN7.A("<span style='color:%s;'>", AbstractC2050a.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return AbstractC9683aN7.A("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof QY2) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            return AbstractC9683aN7.A("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r3.getSize() : r3.getSize() / f));
        }
        if (obj instanceof RelativeSizeSpan) {
            return AbstractC9683aN7.A("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return AbstractC9683aN7.A("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof C13379g76)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof C6169Ml7)) {
                return null;
            }
            C6169Ml7 c6169Ml7 = (C6169Ml7) obj;
            return AbstractC9683aN7.A("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(c6169Ml7.a, c6169Ml7.b), g(c6169Ml7.c));
        }
        int i = ((C13379g76) obj).b;
        if (i == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    private static d f(SparseArray sparseArray, int i) {
        d dVar = (d) sparseArray.get(i);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i, dVar2);
        return dVar2;
    }

    private static String g(int i) {
        return i != 2 ? "over right" : "under left";
    }

    private static String h(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 1) {
            sb.append("filled ");
        } else if (i2 == 2) {
            sb.append("open ");
        }
        if (i == 0) {
            sb.append("none");
        } else if (i == 1) {
            sb.append("circle");
        } else if (i == 2) {
            sb.append("dot");
        } else if (i != 3) {
            sb.append("unset");
        } else {
            sb.append("sesame");
        }
        return sb.toString();
    }
}
