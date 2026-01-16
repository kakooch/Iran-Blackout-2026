package ir.nasim;

import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes2.dex */
public class OF1 implements InterfaceC4355Et7 {
    private final Resources a;

    public OF1(Resources resources) {
        this.a = (Resources) AbstractC20011rK.e(resources);
    }

    private String b(com.google.android.exoplayer2.X x) {
        int i = x.y;
        return (i == -1 || i < 1) ? "" : i != 1 ? i != 2 ? (i == 6 || i == 7) ? this.a.getString(AbstractC20563sD5.exo_track_surround_5_point_1) : i != 8 ? this.a.getString(AbstractC20563sD5.exo_track_surround) : this.a.getString(AbstractC20563sD5.exo_track_surround_7_point_1) : this.a.getString(AbstractC20563sD5.exo_track_stereo) : this.a.getString(AbstractC20563sD5.exo_track_mono);
    }

    private String c(com.google.android.exoplayer2.X x) {
        int i = x.h;
        return i == -1 ? "" : this.a.getString(AbstractC20563sD5.exo_track_bitrate, Float.valueOf(i / 1000000.0f));
    }

    private String d(com.google.android.exoplayer2.X x) {
        return TextUtils.isEmpty(x.b) ? "" : x.b;
    }

    private String e(com.google.android.exoplayer2.X x) {
        String strJ = j(f(x), h(x));
        return TextUtils.isEmpty(strJ) ? d(x) : strJ;
    }

    private String f(com.google.android.exoplayer2.X x) {
        String str = x.c;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = AbstractC9683aN7.a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale localeO = AbstractC9683aN7.O();
        String displayName = localeForLanguageTag.getDisplayName(localeO);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeO) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(com.google.android.exoplayer2.X x) {
        int i = x.q;
        int i2 = x.r;
        return (i == -1 || i2 == -1) ? "" : this.a.getString(AbstractC20563sD5.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private String h(com.google.android.exoplayer2.X x) {
        String string = (x.e & 2) != 0 ? this.a.getString(AbstractC20563sD5.exo_track_role_alternate) : "";
        if ((x.e & 4) != 0) {
            string = j(string, this.a.getString(AbstractC20563sD5.exo_track_role_supplementary));
        }
        if ((x.e & 8) != 0) {
            string = j(string, this.a.getString(AbstractC20563sD5.exo_track_role_commentary));
        }
        return (x.e & 1088) != 0 ? j(string, this.a.getString(AbstractC20563sD5.exo_track_role_closed_captions)) : string;
    }

    private static int i(com.google.android.exoplayer2.X x) {
        int iK = AbstractC24462yf4.k(x.l);
        if (iK != -1) {
            return iK;
        }
        if (AbstractC24462yf4.n(x.i) != null) {
            return 2;
        }
        if (AbstractC24462yf4.c(x.i) != null) {
            return 1;
        }
        if (x.q == -1 && x.r == -1) {
            return (x.y == -1 && x.z == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.a.getString(AbstractC20563sD5.exo_item_list, string, str);
            }
        }
        return string;
    }

    @Override // ir.nasim.InterfaceC4355Et7
    public String a(com.google.android.exoplayer2.X x) {
        int i = i(x);
        String strJ = i == 2 ? j(h(x), g(x), c(x)) : i == 1 ? j(e(x), b(x), c(x)) : e(x);
        return strJ.length() == 0 ? this.a.getString(AbstractC20563sD5.exo_track_unknown) : strJ;
    }
}
