package ir.nasim;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.oy2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18623oy2 {
    public static final void b(Fragment fragment, String str) {
        fragment.V5().z(str);
    }

    public static final void c(Fragment fragment, String str, Bundle bundle) {
        fragment.V5().G1(str, bundle);
    }

    public static final void d(Fragment fragment, String str, final InterfaceC14603iB2 interfaceC14603iB2) {
        fragment.V5().H1(str, fragment, new InterfaceC13295fz2() { // from class: ir.nasim.ny2
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str2, Bundle bundle) {
                AbstractC18623oy2.e(interfaceC14603iB2, str2, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(InterfaceC14603iB2 interfaceC14603iB2, String str, Bundle bundle) {
        interfaceC14603iB2.invoke(str, bundle);
    }
}
