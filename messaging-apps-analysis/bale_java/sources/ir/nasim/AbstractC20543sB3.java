package ir.nasim;

import android.os.Build;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import ir.nasim.AbstractC20543sB3;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.sB3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20543sB3 {
    private static final String[] a = new String[0];
    private static final Comparator b = new Comparator() { // from class: ir.nasim.rB3
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC20543sB3.g((AbstractC20543sB3.a) obj, (AbstractC20543sB3.a) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.sB3$a */
    static class a {
        URLSpan a;
        String b;
        int c;
        int d;

        a() {
        }
    }

    public static boolean b(Spannable spannable, int i) throws UnsupportedEncodingException {
        if (j()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            e(arrayList, spannable, I15.h, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            e(arrayList, spannable, I15.i, new String[]{"mailto:"}, null, null);
        }
        if ((i & 8) != 0) {
            f(arrayList, spannable);
        }
        i(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a == null) {
                c(aVar.b, aVar.c, aVar.d, spannable);
            }
        }
        return true;
    }

    private static void c(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static String d(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : AbstractC22774vo2.c(str);
    }

    private static void e(ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strGroup = matcher.group(0);
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                if (strGroup != null) {
                    a aVar = new a();
                    aVar.b = h(strGroup, strArr, matcher, transformFilter);
                    aVar.c = iStart;
                    aVar.d = iEnd;
                    arrayList.add(aVar);
                }
            }
        }
    }

    private static void f(ArrayList arrayList, Spannable spannable) throws UnsupportedEncodingException {
        int iIndexOf;
        String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String strD = d(string);
                if (strD != null && (iIndexOf = string.indexOf(strD)) >= 0) {
                    a aVar = new a();
                    int length = strD.length() + iIndexOf;
                    aVar.c = iIndexOf + i;
                    i += length;
                    aVar.d = i;
                    string = string.substring(length);
                    try {
                        aVar.b = "geo:0,0?q=" + URLEncoder.encode(strD, "UTF-8");
                        arrayList.add(aVar);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(a aVar, a aVar2) {
        int i = aVar.c;
        int i2 = aVar2.c;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return Integer.compare(aVar2.d, aVar.d);
    }

    private static String h(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            String str2 = strArr[i];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i++;
            }
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void i(ArrayList arrayList, Spannable spannable) {
        int i;
        int i2 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            a aVar = new a();
            aVar.a = uRLSpan;
            aVar.c = spannable.getSpanStart(uRLSpan);
            aVar.d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(aVar);
        }
        Collections.sort(arrayList, b);
        int size = arrayList.size();
        while (i2 < size - 1) {
            a aVar2 = (a) arrayList.get(i2);
            int i3 = i2 + 1;
            a aVar3 = (a) arrayList.get(i3);
            int i4 = aVar2.c;
            int i5 = aVar3.c;
            if (i4 <= i5 && (i = aVar2.d) > i5) {
                int i6 = aVar3.d;
                int i7 = (i6 > i && i - i4 <= i6 - i5) ? i - i4 < i6 - i5 ? i2 : -1 : i3;
                if (i7 != -1) {
                    Object obj = ((a) arrayList.get(i7)).a;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i7);
                    size--;
                }
            }
            i2 = i3;
        }
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
