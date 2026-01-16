package ir.nasim;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.y2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24093y2 implements DefaultLifecycleObserver {
    private FragmentManager.n a;

    private final FragmentManager.n b(final FragmentManager fragmentManager) {
        return new FragmentManager.n() { // from class: ir.nasim.x2
            @Override // androidx.fragment.app.FragmentManager.n
            public final void e() {
                C24093y2.d(fragmentManager);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FragmentManager fragmentManager) {
        AbstractC13042fc3.i(fragmentManager, "$fg");
        List<Fragment> listC0 = fragmentManager.C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        if (listC0.isEmpty()) {
            return;
        }
        ListIterator listIterator = listC0.listIterator(listC0.size());
        while (listIterator.hasPrevious()) {
            Fragment fragment = (Fragment) listIterator.previous();
            if (fragment.o6() != null) {
                for (Fragment fragment2 : listC0) {
                    if (fragment2 == fragment) {
                        View viewO6 = fragment2.o6();
                        if (viewO6 != null) {
                            viewO6.setImportantForAccessibility(1);
                        }
                    } else {
                        View viewO62 = fragment2.o6();
                        if (viewO62 != null) {
                            viewO62.setImportantForAccessibility(4);
                        }
                    }
                }
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        super.onCreate(interfaceC18633oz3);
        if (interfaceC18633oz3 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) interfaceC18633oz3;
            FragmentManager fragmentManagerB0 = fragmentActivity.B0();
            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
            FragmentManager.n nVarB = b(fragmentManagerB0);
            fragmentActivity.B0().n(nVarB);
            this.a = nVarB;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        FragmentManager.n nVar;
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        super.onDestroy(interfaceC18633oz3);
        interfaceC18633oz3.getLifecycle().d(this);
        if (!(interfaceC18633oz3 instanceof FragmentActivity) || (nVar = this.a) == null) {
            return;
        }
        ((FragmentActivity) interfaceC18633oz3).B0().w1(nVar);
        this.a = null;
    }
}
