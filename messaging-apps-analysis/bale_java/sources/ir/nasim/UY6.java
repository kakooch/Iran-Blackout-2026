package ir.nasim;

import android.content.res.Resources;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class UY6 {
    public static final String a(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) throws Resources.NotFoundException {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1784741530, i3, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:73)");
        }
        String quantityString = YW5.a(interfaceC22053ub1, 0).getQuantityString(i, i2);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return quantityString;
    }

    public static final String b(int i, int i2, Object[] objArr, InterfaceC22053ub1 interfaceC22053ub1, int i3) throws Resources.NotFoundException {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(523207213, i3, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:88)");
        }
        String quantityString = YW5.a(interfaceC22053ub1, 0).getQuantityString(i, i2, Arrays.copyOf(objArr, objArr.length));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return quantityString;
    }

    public static final String c(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1223887937, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        String string = YW5.a(interfaceC22053ub1, 0).getString(i);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return string;
    }

    public static final String d(int i, Object[] objArr, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(2071230100, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
        }
        String string = YW5.a(interfaceC22053ub1, 0).getString(i, Arrays.copyOf(objArr, objArr.length));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return string;
    }
}
