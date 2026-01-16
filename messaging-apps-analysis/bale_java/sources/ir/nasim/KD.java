package ir.nasim;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.base.activity.BaseActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002&'B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J!\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lir/nasim/KD;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lir/nasim/KD$b;", "currentTheme", "Lir/nasim/rB7;", "B8", "(Lir/nasim/KD$b;)V", "theme", "w8", "z8", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/px2;", "W0", "Lir/nasim/bW7;", "u8", "()Lir/nasim/px2;", "binding", "Lir/nasim/n10;", "X0", "Lir/nasim/n10;", "baleSnackBar", "Lir/nasim/Bk5;", "Y0", "Lir/nasim/Yu3;", "v8", "()Lir/nasim/Bk5;", "storage", "Z0", "Lir/nasim/KD$b;", "a1", "b", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class KD extends Fragment {

    /* renamed from: W0, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: X0, reason: from kotlin metadata */
    private C17468n10 baleSnackBar;

    /* renamed from: Y0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 storage;

    /* renamed from: Z0, reason: from kotlin metadata */
    private b currentTheme;
    static final /* synthetic */ InterfaceC5239Im3[] b1 = {AbstractC10882cM5.i(new C25226zw5(KD.class, "binding", "getBinding()Lir/nasim/databinding/FragmentAppbarSettingBinding;", 0))};
    public static final int c1 = 8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b b = new b("DEFAULT", 0, AbstractC23035wE5.BaseTheme);
        public static final b c = new b("CLASSIC", 1, AbstractC23035wE5.BaseTheme_gradiant);
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;
        private final int a;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i, int i2) {
            this.a = i2;
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        public final int j() {
            return this.a;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C19205px2.a(fragment.V7());
        }
    }

    public KD() {
        super(AbstractC12208eD5.fragment_appbar_setting);
        this.binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
        this.storage = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.JD
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KD.A8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3570Bk5 A8() {
        return C7183Qq.q(EnumC18608ow5.d);
    }

    private final void B8(b currentTheme) {
        C19205px2 c19205px2U8 = u8();
        int iD = WU3.d(c19205px2U8.getRoot(), AbstractC21139tA5.colorPrimary);
        if (currentTheme == b.b) {
            c19205px2U8.f.setTextColor(iD);
            c19205px2U8.e.setTextColor(C5495Jo7.a.g1());
            c19205px2U8.d.setStrokeColor(ColorStateList.valueOf(iD));
            c19205px2U8.d.setStrokeWidth(AbstractC7426Rr.a.f(3.0f));
            c19205px2U8.c.setStrokeWidth(0.0f);
            return;
        }
        c19205px2U8.e.setTextColor(iD);
        c19205px2U8.f.setTextColor(C5495Jo7.a.g1());
        c19205px2U8.c.setStrokeColor(ColorStateList.valueOf(iD));
        c19205px2U8.c.setStrokeWidth(AbstractC7426Rr.a.f(3.0f));
        c19205px2U8.d.setStrokeWidth(0.0f);
    }

    private final C19205px2 u8() {
        Object objA = this.binding.a(this, b1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C19205px2) objA;
    }

    private final InterfaceC3570Bk5 v8() {
        Object value = this.storage.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (InterfaceC3570Bk5) value;
    }

    private final void w8(b theme) {
        if (this.currentTheme == theme) {
            C17468n10 c17468n10 = this.baleSnackBar;
            if (c17468n10 != null) {
                String strH6 = h6(AbstractC12217eE5.settings_appearance_appbar_setting_reselect_current);
                AbstractC13042fc3.h(strH6, "getString(...)");
                c17468n10.o(strH6);
                return;
            }
            return;
        }
        B8(theme);
        v8().putString("selected_theme", theme.name());
        this.currentTheme = theme;
        if (!C5495Jo7.a.J2()) {
            BaseActivity.INSTANCE.a(theme);
            Q7().onBackPressed();
            return;
        }
        C17468n10 c17468n102 = this.baleSnackBar;
        if (c17468n102 != null) {
            String strH62 = h6(AbstractC12217eE5.settings_appearance_appbar_setting_on_select);
            AbstractC13042fc3.h(strH62, "getString(...)");
            c17468n102.o(strH62);
        }
        BaseActivity.INSTANCE.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x8(KD kd, View view) {
        AbstractC13042fc3.i(kd, "this$0");
        kd.w8(b.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y8(KD kd, View view) {
        AbstractC13042fc3.i(kd, "this$0");
        kd.w8(b.b);
    }

    private final void z8() {
        C19205px2 c19205px2U8 = u8();
        c19205px2U8.g.setTypeface(C6011Lu2.k());
        c19205px2U8.e.setTypeface(C6011Lu2.i());
        c19205px2U8.f.setTypeface(C6011Lu2.i());
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        this.baleSnackBar = null;
        super.T6();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        C19205px2 c19205px2U8 = u8();
        BaleToolbar baleToolbar = c19205px2U8.h;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        z8();
        ConstraintLayout constraintLayoutB = u8().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        this.baleSnackBar = new C17468n10(constraintLayoutB, null, 0, 6, null);
        String string = v8().getString("selected_theme", "DEFAULT");
        AbstractC13042fc3.h(string, "getString(...)");
        b bVarValueOf = b.valueOf(string);
        B8(bVarValueOf);
        this.currentTheme = bVarValueOf;
        c19205px2U8.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HD
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KD.x8(this.a, view2);
            }
        });
        c19205px2U8.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ID
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KD.y8(this.a, view2);
            }
        });
    }
}
