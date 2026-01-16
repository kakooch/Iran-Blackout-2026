package ir.nasim;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lir/nasim/bU0;", "Landroidx/fragment/app/l;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.bU0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10333bU0 extends androidx.fragment.app.l {
    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        AbstractC13042fc3.i(inflater, "inflater");
        G8(false);
        Dialog dialogY8 = y8();
        if (dialogY8 != null && (window = dialogY8.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return inflater.inflate(AbstractC12208eD5.fragment_circle_loading, container, false);
    }
}
