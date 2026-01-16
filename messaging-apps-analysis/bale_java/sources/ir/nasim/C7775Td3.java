package ir.nasim;

import android.graphics.Outline;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C8011Ud3;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Td3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7775Td3 extends RecyclerView.C {
    private final C22095uf3 u;
    private final UA2 v;
    private final C8011Ud3.a.EnumC0692a w;

    /* renamed from: ir.nasim.Td3$a */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: ir.nasim.Td3$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0664a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C8011Ud3.a.EnumC0692a.values().length];
                try {
                    iArr[C8011Ud3.a.EnumC0692a.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[C8011Ud3.a.EnumC0692a.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[C8011Ud3.a.EnumC0692a.e.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(outline, "outline");
            int width = view.getWidth();
            int height = view.getHeight();
            int iApplyDimension = (int) TypedValue.applyDimension(1, 12.0f, C7775Td3.this.u.getRoot().getResources().getDisplayMetrics());
            int i = C0664a.a[C7775Td3.this.w.ordinal()];
            if (i == 1) {
                outline.setRoundRect(0, 0, width, height + iApplyDimension, iApplyDimension);
            } else if (i == 2) {
                outline.setRoundRect(0, 0 - iApplyDimension, width, height, iApplyDimension);
            } else {
                if (i != 3) {
                    return;
                }
                outline.setRoundRect(0, 0, width, height, iApplyDimension);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7775Td3(C22095uf3 c22095uf3, UA2 ua2, C8011Ud3.a.EnumC0692a enumC0692a) {
        super(c22095uf3.getRoot());
        AbstractC13042fc3.i(c22095uf3, "binding");
        AbstractC13042fc3.i(ua2, "onItemClicked");
        AbstractC13042fc3.i(enumC0692a, "viewPosition");
        this.u = c22095uf3;
        this.v = ua2;
        this.w = enumC0692a;
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C7775Td3 c7775Td3, C22613vY c22613vY, View view) {
        AbstractC13042fc3.i(c7775Td3, "this$0");
        AbstractC13042fc3.i(c22613vY, "$contactItem");
        c7775Td3.v.invoke(c22613vY);
    }

    private final void L0() {
        C22095uf3 c22095uf3 = this.u;
        M0();
        c22095uf3.c.B(18.0f, true);
        c22095uf3.e.setTypeface(C6011Lu2.k());
        c22095uf3.d.setTypeface(C6011Lu2.k());
        View root = this.u.f.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C8011Ud3.a.EnumC0692a enumC0692a = this.w;
        root.setVisibility((enumC0692a == C8011Ud3.a.EnumC0692a.d || enumC0692a == C8011Ud3.a.EnumC0692a.e) ? false : true ? 0 : 8);
    }

    private final void M0() {
        C22095uf3 c22095uf3 = this.u;
        if (this.w != C8011Ud3.a.EnumC0692a.c) {
            a aVar = new a();
            ConstraintLayout root = c22095uf3.getRoot();
            root.setOutlineProvider(aVar);
            root.setClipToOutline(true);
        }
    }

    public final void F0(final C22613vY c22613vY) {
        AbstractC13042fc3.i(c22613vY, "contactItem");
        C22095uf3 c22095uf3 = this.u;
        c22095uf3.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Sd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7775Td3.H0(this.a, c22613vY, view);
            }
        });
        c22095uf3.b.setChecked(c22613vY.h());
        AvatarViewGlide.v(c22095uf3.c, c22613vY.c(), XY6.v(c22613vY.f()), c22613vY.d(), false, null, 16, null);
        c22095uf3.e.setText(c22613vY.f());
        c22095uf3.d.setText(c22613vY.e());
    }

    public final void J0(boolean z) {
        this.u.b.setChecked(z);
    }

    public final void a() {
        C22095uf3 c22095uf3 = this.u;
        c22095uf3.b.setChecked(false);
        c22095uf3.c.D();
    }
}
