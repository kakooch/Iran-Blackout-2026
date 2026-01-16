package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import ir.nasim.InterfaceC9764aW7;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0005J)\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lir/nasim/La0;", "Lir/nasim/aW7;", "B", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/rB7;", "h7", "R6", "", "attachToParent", "s8", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/aW7;", "W0", "Z", "isFirstCreate", "()Z", "setFirstCreate", "(Z)V", "X0", "Lir/nasim/aW7;", "_binding", "r8", "()Lir/nasim/aW7;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.La0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC5830La0<B extends InterfaceC9764aW7> extends Fragment {

    /* renamed from: W0, reason: from kotlin metadata */
    private boolean isFirstCreate = true;

    /* renamed from: X0, reason: from kotlin metadata */
    private InterfaceC9764aW7 _binding;

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = s8(inflater, container, false);
        return r8().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.isFirstCreate = false;
    }

    public final InterfaceC9764aW7 r8() {
        InterfaceC9764aW7 interfaceC9764aW7 = this._binding;
        AbstractC13042fc3.f(interfaceC9764aW7);
        return interfaceC9764aW7;
    }

    public abstract InterfaceC9764aW7 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent);
}
