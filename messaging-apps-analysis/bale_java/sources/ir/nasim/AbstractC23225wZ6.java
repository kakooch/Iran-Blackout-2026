package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC11764dZ6;

/* renamed from: ir.nasim.wZ6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23225wZ6 {
    public static final String a(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:25)");
        }
        interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f());
        Resources resources = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources();
        AbstractC11764dZ6.a aVar = AbstractC11764dZ6.a;
        String string = AbstractC11764dZ6.j(i, aVar.e()) ? resources.getString(AbstractC9600aE5.navigation_menu) : AbstractC11764dZ6.j(i, aVar.a()) ? resources.getString(AbstractC9600aE5.close_drawer) : AbstractC11764dZ6.j(i, aVar.b()) ? resources.getString(AbstractC9600aE5.close_sheet) : AbstractC11764dZ6.j(i, aVar.c()) ? resources.getString(AbstractC9600aE5.default_error_message) : AbstractC11764dZ6.j(i, aVar.d()) ? resources.getString(AbstractC9600aE5.dropdown_menu) : AbstractC11764dZ6.j(i, aVar.g()) ? resources.getString(AbstractC9600aE5.range_start) : AbstractC11764dZ6.j(i, aVar.f()) ? resources.getString(AbstractC9600aE5.range_end) : AbstractC11764dZ6.j(i, aVar.h()) ? resources.getString(YD5.mc2_snackbar_pane_title) : "";
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return string;
    }
}
