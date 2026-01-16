package ir.nasim;

import android.content.ClipData;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ir.nasim.C5787Kv2;
import java.util.List;

/* renamed from: ir.nasim.Sw2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7708Sw2 implements InterfaceC6762Ow2 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipData f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(UA2 ua2, List list) {
        AbstractC13042fc3.i(ua2, "$onSuccess");
        AbstractC13042fc3.i(list, "it");
        ua2.invoke(list);
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC6762Ow2
    public void a(Fragment fragment, C11458d25 c11458d25, List list, boolean z, boolean z2, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, final UA2 ua2) {
        FragmentManager fragmentManagerB0;
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(sa23, "addPostToStory");
        AbstractC13042fc3.i(sa24, "sharePost");
        AbstractC13042fc3.i(ua2, "onSuccess");
        C5787Kv2.Companion companion = C5787Kv2.INSTANCE;
        SA2 sa25 = sa2 == null ? new SA2() { // from class: ir.nasim.Pw2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C7708Sw2.e();
            }
        } : sa2;
        SA2 sa26 = sa22 == null ? new SA2() { // from class: ir.nasim.Qw2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C7708Sw2.f();
            }
        } : sa22;
        J44 j44 = (J44) AbstractC15401jX0.s0(list);
        C5787Kv2 c5787Kv2A = companion.a(fragment, c11458d25, sa25, c11458d25, list, z, z2, sa26, sa23, sa24, j44 != null ? j44.F() : null, new UA2() { // from class: ir.nasim.Rw2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7708Sw2.g(ua2, (List) obj);
            }
        }, false);
        FragmentActivity fragmentActivityA5 = fragment.A5();
        if (fragmentActivityA5 == null || (fragmentManagerB0 = fragmentActivityA5.B0()) == null) {
            return;
        }
        c5787Kv2A.K8(fragmentManagerB0, "ForwardBottomSheet");
    }
}
