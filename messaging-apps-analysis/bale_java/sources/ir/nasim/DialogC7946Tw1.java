package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.features.conversation.NewAdvancedForward;

/* renamed from: ir.nasim.Tw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class DialogC7946Tw1 extends Dialog {
    private final View a;
    private final View b;
    private BottomSheetBehavior c;
    private View d;

    /* renamed from: ir.nasim.Tw1$a */
    public static final class a extends BottomSheetBehavior.f {
        private float a;

        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
            AbstractC13042fc3.i(view, "view");
            float f2 = this.a;
            if (f2 <= 0.0f || f <= 0.0f) {
                if (f <= 0.0f || (f > 0.0f && f2 <= 0.0f)) {
                    float f3 = this.a;
                    AlphaAnimation alphaAnimation = new AlphaAnimation(f3 > 0.0f ? 1.0f : f3 + 1.0f, f <= 0.0f ? 1.0f + f : 1.0f);
                    alphaAnimation.setDuration(100L);
                    alphaAnimation.setFillAfter(true);
                    DialogC7946Tw1.this.a.startAnimation(alphaAnimation);
                    View view2 = DialogC7946Tw1.this.d;
                    if (view2 == null) {
                        AbstractC13042fc3.y("backgroundView");
                        view2 = null;
                    }
                    view2.startAnimation(alphaAnimation);
                }
                this.a = f;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            AbstractC13042fc3.i(view, "view");
            if (i == 5) {
                View view2 = DialogC7946Tw1.this.b;
                AbstractC13042fc3.g(view2, "null cannot be cast to non-null type ir.nasim.features.conversation.NewAdvancedForward");
                ((NewAdvancedForward) view2).E();
                DialogC7946Tw1.this.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC7946Tw1(Context context, int i, View view, View view2) {
        WindowManager.LayoutParams attributes;
        super(context, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(view, "bottomView");
        AbstractC13042fc3.i(view2, "topView");
        this.a = view;
        this.b = view2;
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(true);
        Window window2 = getWindow();
        if (window2 != null && (attributes = window2.getAttributes()) != null) {
            attributes.windowAnimations = AbstractC23035wE5.DialogAnimation;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setStatusBarColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DialogC7946Tw1 dialogC7946Tw1, View view) {
        AbstractC13042fc3.i(dialogC7946Tw1, "this$0");
        BottomSheetBehavior bottomSheetBehavior = dialogC7946Tw1.c;
        if (bottomSheetBehavior == null) {
            AbstractC13042fc3.y("bottomSheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.J0(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogC7946Tw1 dialogC7946Tw1, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(dialogC7946Tw1, "this$0");
        BottomSheetBehavior bottomSheetBehavior = dialogC7946Tw1.c;
        if (bottomSheetBehavior == null) {
            AbstractC13042fc3.y("bottomSheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.J0(4);
    }

    public final void f() {
        BottomSheetBehavior bottomSheetBehavior = this.c;
        if (bottomSheetBehavior == null) {
            AbstractC13042fc3.y("bottomSheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.J0(5);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        BottomSheetBehavior bottomSheetBehavior = this.c;
        if (bottomSheetBehavior == null) {
            AbstractC13042fc3.y("bottomSheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.J0(5);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(AbstractC12208eD5.custom_bottomsheet_dialog);
        View viewFindViewById = findViewById(BC5.top_view_container);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        linearLayout.addView(this.b);
        this.c = BottomSheetBehavior.f0(linearLayout);
        View viewFindViewById2 = findViewById(BC5.background_view);
        this.d = viewFindViewById2;
        BottomSheetBehavior bottomSheetBehavior = null;
        if (viewFindViewById2 == null) {
            AbstractC13042fc3.y("backgroundView");
            viewFindViewById2 = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewFindViewById2.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 44));
        View viewFindViewById3 = findViewById(BC5.bottom_view_container);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        ((LinearLayout) viewFindViewById3).addView(this.a);
        BottomSheetBehavior bottomSheetBehavior2 = this.c;
        if (bottomSheetBehavior2 == null) {
            AbstractC13042fc3.y("bottomSheetBehavior");
            bottomSheetBehavior2 = null;
        }
        bottomSheetBehavior2.w0(new a());
        BottomSheetBehavior bottomSheetBehavior3 = this.c;
        if (bottomSheetBehavior3 == null) {
            AbstractC13042fc3.y("bottomSheetBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior3;
        }
        bottomSheetBehavior.J0(5);
        View viewFindViewById4 = findViewById(BC5.custom_dialog_main_container);
        AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
        ((CoordinatorLayout) viewFindViewById4).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Rw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC7946Tw1.g(this.a, view);
            }
        });
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.Sw1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DialogC7946Tw1.h(this.a, dialogInterface);
            }
        });
    }
}
