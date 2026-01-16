package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.sN7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC20655sN7 {
    public static final String a(String str, Context context, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(context, "context");
        if (!z) {
            return str;
        }
        return str + context.getString(AbstractC12217eE5.all_they_pronoun_suffix);
    }

    public static final String b(String str, Context context, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(context, "context");
        if (!z) {
            return str;
        }
        return str + context.getString(AbstractC12217eE5.all_you_pronoun_suffix);
    }

    public static final String c(Context context, int i, Object... objArr) {
        AbstractC13042fc3.i(context, "<this>");
        AbstractC13042fc3.i(objArr, "args");
        String string = context.getString(i, Arrays.copyOf(objArr, objArr.length));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public static final String d(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "<this>");
        return C24847zI7.a.a(context, i, str, z);
    }

    public static /* synthetic */ String e(Context context, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return d(context, i, str, z);
    }

    public static final String f(int i) {
        return g(i);
    }

    public static final String g(long j) {
        float f;
        String str;
        if (j < 1000) {
            f = j;
            str = "";
        } else if (j < 1000000) {
            f = j / 1000.0f;
            str = TokenNames.K;
        } else {
            f = j / 1000000.0f;
            str = TokenNames.M;
        }
        DY6 dy6 = DY6.a;
        String str2 = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        AbstractC13042fc3.h(str2, "format(...)");
        return XY6.v(AbstractC20762sZ6.E0(str2, ".0")) + str;
    }

    public static final String h(Context context, boolean z, boolean z2) {
        AbstractC13042fc3.i(context, "<this>");
        String string = z ? context.getString(AbstractC12217eE5.dialog_type_group) : context.getString(AbstractC12217eE5.dialog_type_channel);
        AbstractC13042fc3.f(string);
        if (!z2) {
            return string;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static /* synthetic */ String i(Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return h(context, z, z2);
    }

    public static final List j(String str) {
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return AbstractC10360bX0.m();
        }
        List listN0 = AbstractC20762sZ6.N0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listN0.iterator();
        while (it.hasNext()) {
            Long lQ = AbstractC19562qZ6.q(AbstractC20762sZ6.n1((String) it.next()).toString());
            if (lQ != null) {
                arrayList.add(lQ);
            }
        }
        return arrayList;
    }
}
