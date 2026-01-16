package ir.nasim;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ir.nasim.premium.ui.badge.BadgeRecyclerView;
import ir.nasim.premium.ui.badge.tab.TabLayoutRecycler;

/* renamed from: ir.nasim.rW, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20119rW implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final CoordinatorLayout b;
    public final LinearLayoutCompat c;
    public final BadgeRecyclerView d;
    public final TabLayoutRecycler e;

    private C20119rW(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, LinearLayoutCompat linearLayoutCompat, BadgeRecyclerView badgeRecyclerView, TabLayoutRecycler tabLayoutRecycler) {
        this.a = coordinatorLayout;
        this.b = coordinatorLayout2;
        this.c = linearLayoutCompat;
        this.d = badgeRecyclerView;
        this.e = tabLayoutRecycler;
    }

    public static C20119rW a(View view) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
        int i = AbstractC14619iC5.llTabContainer;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) AbstractC11738dW7.a(view, i);
        if (linearLayoutCompat != null) {
            i = AbstractC14619iC5.rcBadges;
            BadgeRecyclerView badgeRecyclerView = (BadgeRecyclerView) AbstractC11738dW7.a(view, i);
            if (badgeRecyclerView != null) {
                i = AbstractC14619iC5.tlrBadges;
                TabLayoutRecycler tabLayoutRecycler = (TabLayoutRecycler) AbstractC11738dW7.a(view, i);
                if (tabLayoutRecycler != null) {
                    return new C20119rW(coordinatorLayout, coordinatorLayout, linearLayoutCompat, badgeRecyclerView, tabLayoutRecycler);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
