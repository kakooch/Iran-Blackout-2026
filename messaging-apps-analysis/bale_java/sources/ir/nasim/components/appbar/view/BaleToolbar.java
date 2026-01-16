package ir.nasim.components.appbar.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.AdapterView;
import android.widget.ListPopupWindow;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17008mE5;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC24118y44;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.AbstractC7562Sg0;
import ir.nasim.C14433hu3;
import ir.nasim.C16731lm1;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C5161Id6;
import ir.nasim.C5495Jo7;
import ir.nasim.ED1;
import ir.nasim.EnumC8503Wg0;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4103Dr7;
import ir.nasim.InterfaceC4228Ef6;
import ir.nasim.M10;
import ir.nasim.ME5;
import ir.nasim.SA2;
import ir.nasim.SV;
import ir.nasim.UA2;
import ir.nasim.UB3;
import ir.nasim.UD5;
import ir.nasim.VW5;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 b2\u00020\u0001:\u0001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J-\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001eH\u0007¢\u0006\u0004\b!\u0010\"J5\u0010&\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\f0#H\u0007¢\u0006\u0004\b&\u0010'J\u001b\u0010*\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0(¢\u0006\u0004\b*\u0010+J)\u00101\u001a\u00020\f2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020\u001eH\u0007¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\fH\u0007¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\f¢\u0006\u0004\b5\u00104J\u0015\u00107\u001a\u00020\f2\u0006\u00106\u001a\u00020,¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u001e¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\f2\u0006\u0010%\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\f2\u0006\u0010%\u001a\u00020;¢\u0006\u0004\b@\u0010=J\u001d\u0010A\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0002¢\u0006\u0004\bA\u0010+J\u000f\u0010B\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u00104J\u000f\u0010C\u001a\u00020\fH\u0002¢\u0006\u0004\bC\u00104J\u000f\u0010D\u001a\u00020\fH\u0002¢\u0006\u0004\bD\u00104J\u001f\u0010G\u001a\u00020\f2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\u001eH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u00104R\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010U\u001a\u00020N8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010]\u001a\u00020V8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lir/nasim/components/appbar/view/BaleToolbar;", "Lcom/google/android/material/appbar/MaterialToolbar;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "r0", "(Landroid/util/AttributeSet;)V", "", "duration", "y0", "(J)V", "q0", "moreMenuId", "", "Lir/nasim/p44;", "itemList", "Landroid/widget/AdapterView$OnItemClickListener;", "listener", "l0", "(ILjava/util/List;Landroid/widget/AdapterView$OnItemClickListener;)V", "Landroid/app/Activity;", "activity", "", "hasBackButton", "rotateToClose", "setHasBackButton", "(Landroid/app/Activity;ZZ)V", "Lkotlin/Function1;", "Landroid/view/View;", "onClickListener", "setHasBackButtonClickListener", "(ZZLir/nasim/UA2;)V", "Lkotlin/Function0;", "content", "setHasSearchMenu", "(Lir/nasim/iB2;)V", "", "searchHint", "Lir/nasim/Ef6;", "searchCallback", "alwaysExpanded", "setHasSearchButton", "(Ljava/lang/String;Lir/nasim/Ef6;Z)V", "n0", "()V", "p0", "query", "setSearchQuery", "(Ljava/lang/String;)V", "j0", "()Z", "Landroid/view/View$OnClickListener;", "e0", "(Landroid/view/View$OnClickListener;)V", "c0", "(Landroid/app/Activity;)V", "f0", "t0", "u0", "z0", "h0", "view", "isShow", "g0", "(Landroid/view/View;Z)V", "i0", "Lir/nasim/components/appbar/view/SearchViewToolbar;", "U0", "Lir/nasim/components/appbar/view/SearchViewToolbar;", "searchViewToolbar", "Landroid/widget/ListPopupWindow;", "V0", "Landroid/widget/ListPopupWindow;", "getPopupWindow", "()Landroid/widget/ListPopupWindow;", "setPopupWindow", "(Landroid/widget/ListPopupWindow;)V", "popupWindow", "Lir/nasim/UB3;", "W0", "Lir/nasim/UB3;", "getListAdapter", "()Lir/nasim/UB3;", "setListAdapter", "(Lir/nasim/UB3;)V", "listAdapter", "Landroidx/compose/ui/platform/ComposeView;", "X0", "Landroidx/compose/ui/platform/ComposeView;", "searchComposeView", "Y0", "a", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public class BaleToolbar extends MaterialToolbar {

    /* renamed from: Y0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int Z0 = 8;

    /* renamed from: U0, reason: from kotlin metadata */
    private SearchViewToolbar searchViewToolbar;

    /* renamed from: V0, reason: from kotlin metadata */
    public ListPopupWindow popupWindow;

    /* renamed from: W0, reason: from kotlin metadata */
    public UB3 listAdapter;

    /* renamed from: X0, reason: from kotlin metadata */
    private ComposeView searchComposeView;

    /* renamed from: ir.nasim.components.appbar.view.BaleToolbar$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ BaleToolbar d(Companion companion, Activity activity, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.c(activity, str, z);
        }

        public final AppBarLayout a(Context context) {
            AbstractC13042fc3.i(context, "context");
            AppBarLayout appBarLayout = new AppBarLayout(context);
            appBarLayout.setFitsSystemWindows(true);
            return appBarLayout;
        }

        public final BaleToolbar b(Activity activity, String str) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(str, "title");
            return d(this, activity, str, false, 4, null);
        }

        public final BaleToolbar c(Activity activity, String str, boolean z) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(str, "title");
            BaleToolbar baleToolbar = new BaleToolbar(activity);
            C5161Id6 c5161Id6 = C5161Id6.a;
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            int iF = c5161Id6.f(baseContext, R.attr.actionBarSize);
            if (iF <= 0) {
                iF = -2;
            }
            baleToolbar.setLayoutParams(C14433hu3.d(-1, iF));
            if (z) {
                BaleToolbar.setHasBackButton$default(baleToolbar, activity, true, false, 4, null);
            }
            baleToolbar.setTitle(str);
            return baleToolbar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ BaleToolbar b;

        b(boolean z, BaleToolbar baleToolbar) {
            this.a = z;
            this.b = baleToolbar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            super.onAnimationEnd(animator);
            if (!this.a) {
                this.b.i0();
                return;
            }
            SearchViewToolbar searchViewToolbar = this.b.searchViewToolbar;
            if (searchViewToolbar != null) {
                searchViewToolbar.t();
            }
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            super.onAnimationEnd(animator);
            BaleToolbar.this.setVisibility(4);
        }
    }

    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 a;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14603iB2 a;

            a(InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.invoke(interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d(InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-283440917, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            super.onAnimationEnd(animator);
            BaleToolbar.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleToolbar(Context context) {
        super(new C16731lm1(context, AbstractC17008mE5.Theme_Bale_Base));
        AbstractC13042fc3.i(context, "context");
        s0(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void d0(Activity activity, View view) {
        AbstractC13042fc3.i(activity, "$activity");
        if (activity instanceof InterfaceC4103Dr7) {
            ((InterfaceC4103Dr7) activity).i(true);
        } else {
            activity.onBackPressed();
        }
    }

    private final void g0(View view, boolean isShow) {
        Animator animatorCreateCircularReveal;
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float fHypot = (float) Math.hypot(width, height);
        if (isShow) {
            animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, width, height, 0.0f, getWidth());
            AbstractC13042fc3.f(animatorCreateCircularReveal);
        } else {
            animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, width, height, fHypot, 0.0f);
            AbstractC13042fc3.f(animatorCreateCircularReveal);
        }
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new b(isShow, this));
        animatorCreateCircularReveal.start();
    }

    private final void h0() {
        setNavigationIcon((Drawable) null);
        if (getMenu() != null) {
            Menu menu = getMenu();
            AbstractC13042fc3.h(menu, "getMenu(...)");
            Iterator itA = AbstractC24118y44.a(menu);
            while (itA.hasNext()) {
                ((MenuItem) itA.next()).setVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        z0();
        if (getMenu() != null) {
            Menu menu = getMenu();
            AbstractC13042fc3.h(menu, "getMenu(...)");
            Iterator itA = AbstractC24118y44.a(menu);
            while (itA.hasNext()) {
                ((MenuItem) itA.next()).setVisible(true);
            }
        }
        SearchViewToolbar searchViewToolbar = this.searchViewToolbar;
        if (searchViewToolbar != null) {
            searchViewToolbar.setVisibility(8);
        }
    }

    public static final AppBarLayout k0(Context context) {
        return INSTANCE.a(context);
    }

    public static final BaleToolbar m0(Activity activity, String str) {
        return INSTANCE.b(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0(BaleToolbar baleToolbar) {
        AbstractC13042fc3.i(baleToolbar, "this$0");
        SearchViewToolbar searchViewToolbar = baleToolbar.searchViewToolbar;
        AbstractC13042fc3.f(searchViewToolbar);
        baleToolbar.g0(searchViewToolbar, false);
        return C19938rB7.a;
    }

    public static /* synthetic */ void s0(BaleToolbar baleToolbar, AttributeSet attributeSet, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        baleToolbar.r0(attributeSet);
    }

    public static /* synthetic */ void setHasBackButton$default(BaleToolbar baleToolbar, Activity activity, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHasBackButton");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        baleToolbar.setHasBackButton(activity, z, z2);
    }

    public static /* synthetic */ void setHasBackButtonClickListener$default(BaleToolbar baleToolbar, boolean z, boolean z2, UA2 ua2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHasBackButtonClickListener");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        baleToolbar.setHasBackButtonClickListener(z, z2, ua2);
    }

    public static /* synthetic */ void setHasSearchButton$default(BaleToolbar baleToolbar, String str, InterfaceC4228Ef6 interfaceC4228Ef6, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHasSearchButton");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        baleToolbar.setHasSearchButton(str, interfaceC4228Ef6, z);
    }

    private final void t0(InterfaceC14603iB2 content) {
        View view = this.searchComposeView;
        if (view != null) {
            AbstractC13042fc3.f(view);
            if (indexOfChild(view) != -1) {
                return;
            }
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setLayoutParams(new Toolbar.LayoutParams(-1, -1));
        composeView.setContent(AbstractC19242q11.c(-1060334096, true, new d(content)));
        this.searchComposeView = composeView;
        addView(composeView, 0);
        ComposeView composeView2 = this.searchComposeView;
        if (composeView2 != null) {
            composeView2.setVisibility(8);
        }
    }

    private final void u0() {
        View view = this.searchViewToolbar;
        if (view != null) {
            AbstractC13042fc3.f(view);
            if (indexOfChild(view) != -1) {
                return;
            }
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        SearchViewToolbar searchViewToolbar = new SearchViewToolbar(context);
        this.searchViewToolbar = searchViewToolbar;
        addView(searchViewToolbar, 0);
        SearchViewToolbar searchViewToolbar2 = this.searchViewToolbar;
        if (searchViewToolbar2 != null) {
            searchViewToolbar2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v0(Activity activity, View view) {
        AbstractC13042fc3.i(activity, "$activity");
        if (activity instanceof InterfaceC4103Dr7) {
            ((InterfaceC4103Dr7) activity).i(true);
        } else {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(BaleToolbar baleToolbar, View view) {
        AbstractC13042fc3.i(baleToolbar, "this$0");
        baleToolbar.n0();
    }

    private final void z0() {
        setNavigationIcon(VW5.f(getResources(), AbstractC24188yB5.search_vd, null));
        setNavigationContentDescription(getContext().getResources().getText(UD5.bale_toolbar_search_icon_content_description));
    }

    public final void c0(final Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon instanceof SV) {
            ((SV) navigationIcon).a(0.0f, true);
        }
        setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaleToolbar.d0(activity, view);
            }
        });
        setNavigationContentDescription(getContext().getResources().getString(UD5.bale_toolbar_navigation_back_icon_content_description));
    }

    public final void e0(View.OnClickListener onClickListener) {
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon instanceof SV) {
            ((SV) navigationIcon).a(1.0f, true);
        }
        setNavigationOnClickListener(onClickListener);
        setNavigationContentDescription(getContext().getResources().getString(UD5.dialog_negative_button_cancel));
    }

    public final void f0(View.OnClickListener onClickListener) {
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        getNavigationIcon();
        setNavigationOnClickListener(onClickListener);
    }

    public final UB3 getListAdapter() {
        UB3 ub3 = this.listAdapter;
        if (ub3 != null) {
            return ub3;
        }
        AbstractC13042fc3.y("listAdapter");
        return null;
    }

    public final ListPopupWindow getPopupWindow() {
        ListPopupWindow listPopupWindow = this.popupWindow;
        if (listPopupWindow != null) {
            return listPopupWindow;
        }
        AbstractC13042fc3.y("popupWindow");
        return null;
    }

    public final boolean j0() {
        ComposeView composeView = this.searchComposeView;
        if (composeView != null && composeView.getVisibility() == 0) {
            ComposeView composeView2 = this.searchComposeView;
            if (composeView2 != null) {
                composeView2.setVisibility(8);
            }
            return true;
        }
        SearchViewToolbar searchViewToolbar = this.searchViewToolbar;
        if (searchViewToolbar == null || searchViewToolbar.getVisibility() != 0) {
            return false;
        }
        SearchViewToolbar searchViewToolbar2 = this.searchViewToolbar;
        if (searchViewToolbar2 != null) {
            searchViewToolbar2.k();
        }
        return true;
    }

    public final void l0(int moreMenuId, List itemList, AdapterView.OnItemClickListener listener) {
        AbstractC13042fc3.i(itemList, "itemList");
        setPopupWindow(new ListPopupWindow(getContext()));
        getPopupWindow().setOnItemClickListener(listener);
        setListAdapter(new UB3(getContext(), itemList, true));
        getPopupWindow().setAnchorView(findViewById(moreMenuId));
        getPopupWindow().setAdapter(getListAdapter());
        getPopupWindow().setWidth(C5161Id6.e(212.0f));
        getPopupWindow().setAnimationStyle(AbstractC17008mE5.PopupAnimation);
        getPopupWindow().setModal(true);
        ListPopupWindow popupWindow = getPopupWindow();
        float fA = C22078ud6.a(2.0f);
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        popupWindow.setVerticalOffset(C5161Id6.d(fA, context));
        getPopupWindow().setHorizontalOffset(-(getPopupWindow().getWidth() - C22078ud6.a(34.0f)));
    }

    public final void n0() {
        SearchViewToolbar searchViewToolbar = this.searchViewToolbar;
        if (searchViewToolbar != null) {
            h0();
            searchViewToolbar.setVisibility(0);
            g0(searchViewToolbar, true);
            searchViewToolbar.setCloseSearch(new SA2() { // from class: ir.nasim.R10
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return BaleToolbar.o0(this.a);
                }
            });
        }
    }

    public final void p0() {
        ComposeView composeView = this.searchComposeView;
        if (composeView != null) {
            h0();
            composeView.setVisibility(0);
        }
    }

    public final void q0(long duration) {
        animate().alpha(0.0f).setDuration(duration).setListener(new c()).start();
    }

    public final void r0(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, ME5.BaleToolbar);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setLayoutDirection(typedArrayObtainStyledAttributes.getInteger(ME5.BaleToolbar_android_layoutDirection, 0));
        setTitleTextAppearance(getContext(), AbstractC17008mE5.AppBarTitle);
        setPopupTheme(AbstractC17008mE5.PopupMenu);
        setTitleCentered(true);
        Drawable overflowIcon = getOverflowIcon();
        if (overflowIcon != null) {
            overflowIcon.setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.l2(), EnumC8503Wg0.DST));
        }
        setContentInsetsAbsolute(0, 0);
        setContentInsetStartWithNavigation(0);
        setContentInsetEndWithActions(0);
    }

    public final void setHasBackButton(Activity activity, boolean z) {
        AbstractC13042fc3.i(activity, "activity");
        setHasBackButton$default(this, activity, z, false, 4, null);
    }

    public final void setHasBackButtonClickListener(boolean z, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onClickListener");
        setHasBackButtonClickListener$default(this, z, false, ua2, 2, null);
    }

    public final void setHasSearchButton(String str, InterfaceC4228Ef6 interfaceC4228Ef6) {
        AbstractC13042fc3.i(str, "searchHint");
        AbstractC13042fc3.i(interfaceC4228Ef6, "searchCallback");
        setHasSearchButton$default(this, str, interfaceC4228Ef6, false, 4, null);
    }

    public final void setHasSearchMenu(InterfaceC14603iB2 content) {
        AbstractC13042fc3.i(content, "content");
        t0(content);
    }

    public final void setListAdapter(UB3 ub3) {
        AbstractC13042fc3.i(ub3, "<set-?>");
        this.listAdapter = ub3;
    }

    public final void setPopupWindow(ListPopupWindow listPopupWindow) {
        AbstractC13042fc3.i(listPopupWindow, "<set-?>");
        this.popupWindow = listPopupWindow;
    }

    public final void setSearchQuery(String query) {
        AbstractC13042fc3.i(query, "query");
        SearchViewToolbar searchViewToolbar = this.searchViewToolbar;
        if (searchViewToolbar != null) {
            searchViewToolbar.setSearchQuery(query);
        }
    }

    public final void y0(long duration) {
        setVisibility(0);
        animate().alpha(1.0f).setDuration(duration).setListener(new e()).start();
    }

    public final void setHasBackButton(final Activity activity, boolean hasBackButton, boolean rotateToClose) {
        AbstractC13042fc3.i(activity, "activity");
        if (!hasBackButton) {
            setNavigationIcon((Drawable) null);
            setNavigationOnClickListener(null);
            return;
        }
        SV sv = new SV(false);
        if (rotateToClose) {
            sv.a(1.0f, false);
        }
        setNavigationIcon(sv);
        setNavigationContentDescription(getContext().getResources().getString(UD5.bale_toolbar_navigation_back_icon_content_description));
        setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.O10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaleToolbar.v0(activity, view);
            }
        });
    }

    public final void setHasBackButtonClickListener(boolean hasBackButton, boolean rotateToClose, final UA2 onClickListener) {
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        if (!hasBackButton) {
            setNavigationIcon((Drawable) null);
            setNavigationOnClickListener(null);
            return;
        }
        SV sv = new SV(false);
        if (rotateToClose) {
            sv.a(1.0f, false);
        }
        setNavigationIcon(sv);
        setNavigationContentDescription(getContext().getResources().getString(UD5.bale_toolbar_navigation_back_icon_content_description));
        setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.P10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaleToolbar.w0(onClickListener, view);
            }
        });
    }

    public final void setHasSearchButton(String searchHint, InterfaceC4228Ef6 searchCallback, boolean alwaysExpanded) {
        AbstractC13042fc3.i(searchHint, "searchHint");
        AbstractC13042fc3.i(searchCallback, "searchCallback");
        z0();
        u0();
        SearchViewToolbar searchViewToolbar = this.searchViewToolbar;
        if (searchViewToolbar != null) {
            searchViewToolbar.setSearchHint(searchHint);
            searchViewToolbar.setSearchCallback(searchCallback);
            if (!alwaysExpanded) {
                setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.N10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaleToolbar.x0(this.a, view);
                    }
                });
                return;
            }
            searchViewToolbar.setVisibility(0);
            h0();
            searchViewToolbar.t();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleToolbar(Context context, AttributeSet attributeSet) {
        super(new C16731lm1(context, AbstractC17008mE5.Theme_Bale_Base), attributeSet);
        AbstractC13042fc3.i(context, "context");
        r0(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleToolbar(Context context, AttributeSet attributeSet, int i) {
        super(new C16731lm1(context, AbstractC17008mE5.Theme_Bale_Base), attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        r0(attributeSet);
    }
}
