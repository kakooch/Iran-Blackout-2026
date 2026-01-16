package ir.nasim;

import androidx.fragment.app.FragmentActivity;
import ir.nasim.features.conversation.sharedmedia.old.SharedMediaActivity;

/* renamed from: ir.nasim.uz4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22292uz4 implements UA2 {
    final /* synthetic */ C21015sz4 a;

    public C22292uz4(C21015sz4 c21015sz4) {
        this.a = c21015sz4;
    }

    public final void a(FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(fragmentActivity, "activity");
        fragmentActivity.startActivity(SharedMediaActivity.INSTANCE.a(fragmentActivity, this.a.z));
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((FragmentActivity) obj);
        return C19938rB7.a;
    }
}
