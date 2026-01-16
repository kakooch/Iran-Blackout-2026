package ir.nasim;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.b11, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C10064b11 implements InterfaceC11444d11 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c(String str, I01 i01, S01 s01) {
        try {
            AbstractC11949dp2.b(str);
            return i01.f().a(s01);
        } finally {
            AbstractC11949dp2.a();
        }
    }

    @Override // ir.nasim.InterfaceC11444d11
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final I01 i01R : componentRegistrar.getComponents()) {
            final String strG = i01R.g();
            if (strG != null) {
                i01R = i01R.r(new Y01() { // from class: ir.nasim.a11
                    @Override // ir.nasim.Y01
                    public final Object a(S01 s01) {
                        return C10064b11.c(strG, i01R, s01);
                    }
                });
            }
            arrayList.add(i01R);
        }
        return arrayList;
    }
}
