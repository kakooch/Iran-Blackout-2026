package ir.nasim;

import android.content.Context;
import androidx.fragment.app.FragmentContainerView;

/* renamed from: ir.nasim.Px2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C7005Px2 implements UA2 {
    private final int a;
    private FragmentContainerView b;

    public C7005Px2(int i) {
        this.a = i;
    }

    public final FragmentContainerView a() {
        FragmentContainerView fragmentContainerView = this.b;
        if (fragmentContainerView != null) {
            return fragmentContainerView;
        }
        throw new IllegalStateException(("AndroidView has not created a container for " + this.a + " yet").toString());
    }

    @Override // ir.nasim.UA2
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FragmentContainerView invoke(Context context) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(this.a);
        this.b = fragmentContainerView;
        return fragmentContainerView;
    }
}
