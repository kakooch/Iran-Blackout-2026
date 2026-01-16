package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.agj;
import com.google.ads.interactivemedia.v3.internal.agk;
import com.google.ads.interactivemedia.v3.internal.agl;
import com.google.ads.interactivemedia.v3.internal.agn;
import com.google.ads.interactivemedia.v3.internal.agq;
import com.google.ads.interactivemedia.v3.internal.aku;
import com.google.ads.interactivemedia.v3.internal.alb;
import com.google.ads.interactivemedia.v3.internal.ald;
import com.google.ads.interactivemedia.v3.internal.ale;
import com.google.ads.interactivemedia.v3.internal.ars;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ax {
    private ax() {
    }

    public static agj a(alb albVar) throws agn {
        boolean z;
        try {
            try {
                albVar.p();
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return aku.V.read(albVar);
            } catch (EOFException e2) {
                e = e2;
                z = false;
                if (z) {
                    return agl.a;
                }
                throw new agq(e);
            }
        } catch (ale e3) {
            throw new agq(e3);
        } catch (IOException e4) {
            throw new agk(e4);
        } catch (NumberFormatException e5) {
            throw new agq(e5);
        }
    }

    public static void b(agj agjVar, ald aldVar) throws IOException {
        aku.V.write(aldVar, agjVar);
    }

    public static Writer c(Appendable appendable) {
        return (Writer) appendable;
    }

    public static ars<String, aw> create(int i) {
        return ars.b("GvnExternalLayer", aw.create(i, true));
    }

    public static DateFormat d(int i, int i2) {
        return new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US);
    }

    public static void e(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> void f(T t) {
        t.getClass();
    }
}
