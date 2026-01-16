package ir.nasim;

import android.text.Html;
import android.text.Spanned;

/* renamed from: ir.nasim.hZ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14221hZ2 {

    /* renamed from: ir.nasim.hZ2$a */
    static class a {
        static Spanned a(String str, int i) {
            return Html.fromHtml(str, i);
        }

        static Spanned b(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i, imageGetter, tagHandler);
        }

        static String c(Spanned spanned, int i) {
            return Html.toHtml(spanned, i);
        }
    }

    public static Spanned a(String str, int i) {
        return a.a(str, i);
    }
}
