package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.nasim.features.conversation.view.BaleFloatButtonContainer;

/* renamed from: ir.nasim.Py2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7024Py2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final ComposeView c;
    public final AppBarLayout d;
    public final ComposeView e;
    public final ComposeView f;
    public final CoordinatorLayout g;
    public final FloatingActionButton h;
    public final BaleFloatButtonContainer i;
    public final ConstraintLayout j;
    public final ComposeView k;
    public final ComposeView l;
    public final AppBarLayout m;
    public final ViewPager2 n;

    private C7024Py2(ConstraintLayout constraintLayout, View view, ComposeView composeView, AppBarLayout appBarLayout, ComposeView composeView2, ComposeView composeView3, CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, BaleFloatButtonContainer baleFloatButtonContainer, ConstraintLayout constraintLayout2, ComposeView composeView4, ComposeView composeView5, AppBarLayout appBarLayout2, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = composeView;
        this.d = appBarLayout;
        this.e = composeView2;
        this.f = composeView3;
        this.g = coordinatorLayout;
        this.h = floatingActionButton;
        this.i = baleFloatButtonContainer;
        this.j = constraintLayout2;
        this.k = composeView4;
        this.l = composeView5;
        this.m = appBarLayout2;
        this.n = viewPager2;
    }

    public static C7024Py2 a(View view) {
        int i = AbstractC10792cC5.anchor_toast;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = AbstractC10792cC5.appBar;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                i = AbstractC10792cC5.appBarLayout2;
                AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                if (appBarLayout != null) {
                    i = AbstractC10792cC5.compose_bottom_sheet;
                    ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
                    if (composeView2 != null) {
                        i = AbstractC10792cC5.dialogs;
                        ComposeView composeView3 = (ComposeView) AbstractC11738dW7.a(view, i);
                        if (composeView3 != null) {
                            i = AbstractC10792cC5.dialogs_coordinator_layout;
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) AbstractC11738dW7.a(view, i);
                            if (coordinatorLayout != null) {
                                i = AbstractC10792cC5.fabIcon;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) AbstractC11738dW7.a(view, i);
                                if (floatingActionButton != null) {
                                    i = AbstractC10792cC5.nazriFab;
                                    BaleFloatButtonContainer baleFloatButtonContainer = (BaleFloatButtonContainer) AbstractC11738dW7.a(view, i);
                                    if (baleFloatButtonContainer != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = AbstractC10792cC5.topComposable;
                                        ComposeView composeView4 = (ComposeView) AbstractC11738dW7.a(view, i);
                                        if (composeView4 != null) {
                                            i = AbstractC10792cC5.top_spot;
                                            ComposeView composeView5 = (ComposeView) AbstractC11738dW7.a(view, i);
                                            if (composeView5 != null) {
                                                i = AbstractC10792cC5.top_spot_app_bar;
                                                AppBarLayout appBarLayout2 = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                if (appBarLayout2 != null) {
                                                    i = AbstractC10792cC5.viewPager;
                                                    ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                                                    if (viewPager2 != null) {
                                                        return new C7024Py2(constraintLayout, viewA, composeView, appBarLayout, composeView2, composeView3, coordinatorLayout, floatingActionButton, baleFloatButtonContainer, constraintLayout, composeView4, composeView5, appBarLayout2, viewPager2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7024Py2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC11565dD5.fragment_none_compose_dialog_container, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
