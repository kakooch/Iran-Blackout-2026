package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.ArrayList;

/* renamed from: ir.nasim.e76, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12152e76 {
    private static final char a(char c) {
        if (c == '0') {
            return (char) 1776;
        }
        if (c == '1') {
            return (char) 1777;
        }
        if (c == '2') {
            return (char) 1778;
        }
        if (c == '3') {
            return (char) 1779;
        }
        if (c == '4') {
            return (char) 1780;
        }
        if (c == '5') {
            return (char) 1781;
        }
        if (c == '6') {
            return (char) 1782;
        }
        if (c == '7') {
            return (char) 1783;
        }
        if (c == '8') {
            return (char) 1784;
        }
        if (c == '9') {
            return (char) 1785;
        }
        return c;
    }

    public static final String b(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return JF5.g() ? XY6.e(str) : str;
    }

    public static final String c(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return JF5.g() ? XY6.f(str) : str;
    }

    public static final String d(String str, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1484888966);
        if (str == null) {
            interfaceC22053ub1.Q();
            return "";
        }
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        if (context.getResources().getBoolean(AbstractC22999wA5.is_right_to_left) || context.getResources().getConfiguration().getLayoutDirection() == 1) {
            ArrayList arrayList = new ArrayList(str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                arrayList.add(Character.valueOf(a(str.charAt(i2))));
            }
            str = AbstractC15401jX0.A0(arrayList, "", null, null, 0, null, null, 62, null);
        }
        interfaceC22053ub1.Q();
        return str;
    }
}
