package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC16417lE5;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC24131y57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C17574nB7;
import ir.nasim.C18435of2;
import ir.nasim.C19026pf2;
import ir.nasim.C22477vI7;
import ir.nasim.C22697vg5;
import ir.nasim.C24749z85;
import ir.nasim.C4278El2;
import ir.nasim.C7501Rz2;
import ir.nasim.FH3;
import ir.nasim.G37;
import ir.nasim.HU1;
import ir.nasim.Q87;
import ir.nasim.SD6;
import ir.nasim.TD5;
import ir.nasim.YZ2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21456c;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.ColorPicker;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.StickerView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.TextPaintView;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoPaintView;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class PhotoPaintView extends FrameLayout implements YZ2, EntityView.g {
    private ActionBarPopupWindow A;
    private ArrayList A0;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout B;
    private boolean B0;
    private G37 C0;
    private Rect D;
    private int D0;
    private boolean E0;
    private MediaController.i F0;
    private SD6 G;
    private final m.h G0;
    private float H;
    private float H0;
    private int[] I0;
    private int J;
    private Bitmap a;
    private Bitmap b;
    private C17574nB7 c;
    int d;
    private FrameLayout e;
    private TextView f;
    private TextView g;
    private FrameLayout h;
    private RenderView i;
    private EntitiesContainerView j;
    private FrameLayout k;
    private FrameLayout l;
    private FrameLayout m;
    private FrameLayout n;
    private ColorPicker o;
    private float p;
    private float q;
    private float[] r;
    private ImageView s;
    private EntityView t;
    private boolean u;
    private C22697vg5 v;
    private float w;
    private float x;
    private String y;
    private BigInteger z;
    private HU1 z0;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            PhotoPaintView.this.k.setVisibility(8);
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            PhotoPaintView.this.l.setVisibility(8);
            if (PhotoPaintView.this.l.getParent() != null) {
                ((EntitiesContainerView) PhotoPaintView.this.l.getParent()).removeView(PhotoPaintView.this.l);
            }
        }
    }

    private C22697vg5 J() {
        SD6 paintingSize = getPaintingSize();
        float f = paintingSize.a / 2.0f;
        float f2 = paintingSize.b / 2.0f;
        if (this.F0 != null) {
            double radians = (float) Math.toRadians(-(r2.i + r2.d));
            float fCos = (float) ((this.F0.a * Math.cos(radians)) - (this.F0.b * Math.sin(radians)));
            float fSin = (float) ((this.F0.a * Math.sin(radians)) + (this.F0.b * Math.cos(radians)));
            f -= fCos * paintingSize.a;
            f2 -= fSin * paintingSize.b;
        }
        return new C22697vg5(f, f2);
    }

    private void L() {
        this.z0.i(new Runnable() { // from class: ir.nasim.l95
            @Override // java.lang.Runnable
            public final void run() {
                this.a.R();
            }
        });
    }

    private void M() {
        EntityView entityView;
        EntityView entityView2 = this.t;
        if (entityView2 == null) {
            return;
        }
        C22697vg5 c22697vg5K0 = k0(entityView2);
        EntityView entityView3 = this.t;
        if (entityView3 instanceof StickerView) {
            StickerView stickerView = new StickerView(getContext(), (StickerView) this.t, c22697vg5K0);
            stickerView.setDelegate(this);
            this.j.addView(stickerView);
            entityView = stickerView;
        } else if (entityView3 instanceof TextPaintView) {
            TextPaintView textPaintView = new TextPaintView(getContext(), (TextPaintView) this.t, c22697vg5K0);
            textPaintView.setDelegate(this);
            textPaintView.setMaxWidth((int) (getPaintingSize().a - 20.0f));
            this.j.addView(textPaintView, AbstractC13840gu3.b(-2, -2.0f));
            entityView = textPaintView;
        } else {
            entityView = null;
        }
        d0(entityView);
        f0(entityView);
        l0();
    }

    private void N() {
        if (!(this.t instanceof TextPaintView) || this.u) {
            return;
        }
        this.h.setVisibility(0);
        TextPaintView textPaintView = (TextPaintView) this.t;
        this.y = textPaintView.getText().toString();
        this.u = true;
        this.v = textPaintView.getPosition();
        this.w = textPaintView.getRotation();
        this.x = textPaintView.getScale();
        textPaintView.setPosition(J());
        MediaController.i iVar = this.F0;
        if (iVar != null) {
            textPaintView.setRotation(-(iVar.i + iVar.d));
            textPaintView.setScale(1.0f / this.F0.c);
        } else {
            textPaintView.setRotation(0.0f);
            textPaintView.setScale(1.0f);
        }
        this.e.setVisibility(8);
        h0(true, textPaintView);
        textPaintView.i0();
        View focusedView = textPaintView.getFocusedView();
        focusedView.requestFocus();
        AbstractC21455b.C1(focusedView);
    }

    private int[] O(View view) {
        view.getLocationInWindow(this.I0);
        float rotation = view.getRotation();
        float radians = (float) Math.toRadians(rotation + (this.F0 != null ? r1.d + r1.i : 0.0f));
        double width = view.getWidth() * view.getScaleX() * this.j.getScaleX();
        double d = radians;
        double height = view.getHeight() * view.getScaleY() * this.j.getScaleY();
        float fCos = (float) ((Math.cos(d) * width) - (Math.sin(d) * height));
        float fSin = (float) ((width * Math.sin(d)) + (height * Math.cos(d)));
        int[] iArr = this.I0;
        iArr[0] = (int) (iArr[0] + (fCos / 2.0f));
        iArr[1] = (int) (iArr[1] + (fSin / 2.0f));
        return iArr;
    }

    private int P(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.G0);
    }

    private boolean Q() {
        int i = this.D0;
        return i % 360 == 90 || i % 360 == 270;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        int i;
        C19026pf2 c19026pf2A = null;
        try {
            try {
                c19026pf2A = new C19026pf2.a(getContext()).c(1).b(1).d(false).a();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                if (0 == 0) {
                    return;
                }
            }
            if (!c19026pf2A.c()) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("face detection is not operational");
                }
                c19026pf2A.a();
                return;
            }
            try {
                SparseArray sparseArrayB = c19026pf2A.b(new C7501Rz2.a().b(this.b).c(getFrameRotation()).a());
                ArrayList arrayList = new ArrayList();
                SD6 paintingSize = getPaintingSize();
                for (i = 0; i < sparseArrayB.size(); i++) {
                    C24749z85 c24749z85 = new C24749z85((C18435of2) sparseArrayB.get(sparseArrayB.keyAt(i)), this.b, paintingSize, Q());
                    if (c24749z85.d()) {
                        arrayList.add(c24749z85);
                    }
                }
                this.A0 = arrayList;
                c19026pf2A.a();
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
                c19026pf2A.a();
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                c19026pf2A.a();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        N();
        ActionBarPopupWindow actionBarPopupWindow = this.A;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.A.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        M();
        ActionBarPopupWindow actionBarPopupWindow = this.A;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.A.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(final EntityView entityView) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7;
        textView.setTextColor(P(i));
        textView.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
        textView.setGravity(16);
        textView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(14.0f), 0);
        textView.setTextSize(1, 18.0f);
        textView.setTag(0);
        textView.setText(FH3.E("PaintDelete", TD5.tgwidget_PaintDelete));
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.n95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Y(entityView, view);
            }
        });
        linearLayout.addView(textView, AbstractC13840gu3.g(-2, 48));
        if (entityView instanceof TextPaintView) {
            TextView textView2 = new TextView(getContext());
            textView2.setTextColor(P(i));
            textView2.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
            textView2.setGravity(16);
            textView2.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
            textView2.setTextSize(1, 18.0f);
            textView2.setTag(1);
            textView2.setText(FH3.E("PaintEdit", TD5.tgwidget_PaintEdit));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.o95
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.V(view);
                }
            });
            linearLayout.addView(textView2, AbstractC13840gu3.g(-2, 48));
        }
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(P(i));
        textView3.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
        textView3.setGravity(16);
        textView3.setPadding(AbstractC21455b.F(14.0f), 0, AbstractC21455b.F(16.0f), 0);
        textView3.setTextSize(1, 18.0f);
        textView3.setTag(2);
        textView3.setText(FH3.E("PaintDuplicate", TD5.tgwidget_PaintDuplicate));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.p95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.W(view);
            }
        });
        linearLayout.addView(textView3, AbstractC13840gu3.g(-2, 48));
        this.B.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(EntityView entityView, View view) {
        T(entityView);
        ActionBarPopupWindow actionBarPopupWindow = this.A;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.A.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Z(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.A) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.D);
        if (this.D.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.A.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.A) != null && actionBarPopupWindow.isShowing()) {
            this.A.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        this.B.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    private void d0(final EntityView entityView) {
        this.c.f(entityView.getUUID(), new Runnable() { // from class: ir.nasim.k95
            @Override // java.lang.Runnable
            public final void run() {
                this.a.T(entityView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void T(EntityView entityView) {
        EntityView entityView2 = this.t;
        if (entityView == entityView2) {
            entityView2.H();
            if (this.u) {
                K(false);
            }
            this.t = null;
            l0();
        }
        this.j.removeView(entityView);
        this.c.j(entityView.getUUID());
    }

    private boolean f0(EntityView entityView) {
        boolean z;
        EntityView entityView2 = this.t;
        boolean z2 = true;
        if (entityView2 == null) {
            z = false;
        } else {
            if (entityView2 == entityView) {
                if (!this.u) {
                    i0(entityView2);
                }
                return true;
            }
            entityView2.H();
            z = true;
        }
        EntityView entityView3 = this.t;
        this.t = entityView;
        if ((entityView3 instanceof TextPaintView) && TextUtils.isEmpty(((TextPaintView) entityView3).getText())) {
            T(entityView3);
        }
        EntityView entityView4 = this.t;
        if (entityView4 != null) {
            entityView4.a0(this.n);
            this.j.bringChildToFront(this.t);
            EntityView entityView5 = this.t;
            if (entityView5 instanceof TextPaintView) {
                g0(((TextPaintView) entityView5).getSwatch(), true);
            }
        } else {
            z2 = z;
        }
        l0();
        return z2;
    }

    private void g0(G37 g37, boolean z) {
        this.i.setColor(g37.a);
        this.i.setBrushSize(g37.c);
        if (z) {
            if (this.C0 == null && this.s.getColorFilter() != null) {
                this.C0 = this.o.getSwatch();
            }
            this.o.setSwatch(g37);
        }
        EntityView entityView = this.t;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setSwatch(g37);
        }
    }

    private int getFrameRotation() {
        int i = this.D0;
        if (i == 90) {
            return 1;
        }
        if (i != 180) {
            return i != 270 ? 0 : 3;
        }
        return 2;
    }

    private SD6 getPaintingSize() {
        SD6 sd6 = this.G;
        if (sd6 != null) {
            return sd6;
        }
        SD6 sd62 = new SD6(this.a.getWidth(), this.a.getHeight());
        sd62.a = 1280.0f;
        float fFloor = (float) Math.floor((1280.0f * r1) / r0);
        sd62.b = fFloor;
        if (fFloor > 1280.0f) {
            sd62.b = 1280.0f;
            sd62.a = (float) Math.floor((1280.0f * r0) / r1);
        }
        this.G = sd62;
        return sd62;
    }

    private void h0(boolean z, EntityView entityView) {
        ObjectAnimator objectAnimatorOfFloat;
        if (z && entityView != null) {
            ViewGroup viewGroup = (ViewGroup) entityView.getParent();
            if (this.l.getParent() != null) {
                ((EntitiesContainerView) this.l.getParent()).removeView(this.l);
            }
            viewGroup.addView(this.l, viewGroup.indexOfChild(entityView));
        }
        entityView.setSelectionVisibility(!z);
        if (z) {
            this.l.setVisibility(0);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.l, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.l, (Property<FrameLayout, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.addListener(new b(z));
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    private void i0(final EntityView entityView) {
        int[] iArrO = O(entityView);
        j0(new Runnable() { // from class: ir.nasim.j95
            @Override // java.lang.Runnable
            public final void run() {
                this.a.X(entityView);
            }
        }, this, 51, iArrO[0], iArrO[1] - AbstractC21455b.F(32.0f));
    }

    private void j0(Runnable runnable, View view, int i, int i2, int i3) {
        ActionBarPopupWindow actionBarPopupWindow = this.A;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.A.dismiss();
            return;
        }
        if (this.B == null) {
            this.D = new Rect();
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext());
            this.B = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setAnimationEnabled(false);
            this.B.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.q95
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.a.Z(view2, motionEvent);
                }
            });
            this.B.setDispatchKeyEventListener(new ActionBarPopupWindow.d() { // from class: ir.nasim.r95
                @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.d
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.a.a0(keyEvent);
                }
            });
            this.B.setShownFromBottom(true);
        }
        this.B.n();
        runnable.run();
        if (this.A == null) {
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.B, -2, -2);
            this.A = actionBarPopupWindow2;
            actionBarPopupWindow2.r(false);
            this.A.setAnimationStyle(AbstractC16417lE5.PopupAnimation);
            this.A.setOutsideTouchable(true);
            this.A.setClippingEnabled(true);
            this.A.setInputMethodMode(2);
            this.A.setSoftInputMode(0);
            this.A.getContentView().setFocusableInTouchMode(true);
            this.A.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.s95
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.a.b0();
                }
            });
        }
        this.B.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(1000.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(1000.0f), RecyclerView.UNDEFINED_DURATION));
        this.A.setFocusable(true);
        if ((i & 48) != 0) {
            i2 -= this.B.getMeasuredWidth() / 2;
            i3 -= this.B.getMeasuredHeight();
        }
        this.A.showAtLocation(view, i, i2, i3);
        this.A.u();
    }

    private C22697vg5 k0(EntityView entityView) {
        MediaController.i iVar = this.F0;
        float f = iVar != null ? 200.0f / iVar.c : 200.0f;
        if (entityView != null) {
            C22697vg5 position = entityView.getPosition();
            return new C22697vg5(position.a + f, position.b + f);
        }
        float f2 = iVar != null ? 100.0f / iVar.c : 100.0f;
        C22697vg5 c22697vg5J = J();
        while (true) {
            boolean z = false;
            for (int i = 0; i < this.j.getChildCount(); i++) {
                View childAt = this.j.getChildAt(i);
                if (childAt instanceof EntityView) {
                    C22697vg5 position2 = ((EntityView) childAt).getPosition();
                    if (((float) Math.sqrt(Math.pow(position2.a - c22697vg5J.a, 2.0d) + Math.pow(position2.b - c22697vg5J.b, 2.0d))) < f2) {
                        z = true;
                    }
                }
            }
            if (!z) {
                return c22697vg5J;
            }
            c22697vg5J = new C22697vg5(c22697vg5J.a + f, c22697vg5J.b + f);
        }
    }

    private void l0() {
        int i = AbstractC23598xB5.photo_paint_brush;
        this.o.e.setContentDescription(FH3.E("AccDescrBrushType", TD5.tgwidget_AccDescrBrushType));
        EntityView entityView = this.t;
        if (entityView != null) {
            if (entityView instanceof StickerView) {
                i = AbstractC23598xB5.msg_photo_flip;
                this.o.e.setContentDescription(FH3.E("AccDescrMirror", TD5.tgwidget_AccDescrMirror));
            } else if (entityView instanceof TextPaintView) {
                i = AbstractC23598xB5.photo_outline;
                this.o.e.setContentDescription(FH3.E("PaintOutlined", TD5.tgwidget_PaintOutlined));
            }
            this.s.setImageResource(AbstractC23598xB5.msg_photo_draw);
            this.s.setColorFilter((ColorFilter) null);
        } else {
            G37 g37 = this.C0;
            if (g37 != null) {
                g0(g37, true);
                this.C0 = null;
            }
            this.s.setColorFilter(new PorterDuffColorFilter(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
            this.s.setImageResource(AbstractC23598xB5.msg_photo_draw);
        }
        this.m.setVisibility(this.t instanceof TextPaintView ? 4 : 0);
        this.o.setSettingsButtonImage(i);
    }

    private void setBrush(int i) {
        RenderView renderView = this.i;
        List list = ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a;
        this.d = i;
        renderView.setBrush((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) list.get(i));
    }

    private void setDimVisibility(boolean z) {
        ObjectAnimator objectAnimatorOfFloat;
        if (z) {
            this.k.setVisibility(0);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.k, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.k, (Property<FrameLayout, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.addListener(new a(z));
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    private void setType(int i) {
        this.J = i;
        if (this.t instanceof TextPaintView) {
            G37 swatch = this.o.getSwatch();
            if (i == 0 && swatch.a == -1) {
                g0(new G37(-16777216, 0.85f, swatch.c), true);
            } else if ((i == 1 || i == 2) && swatch.a == -16777216) {
                g0(new G37(-1, 1.0f, swatch.c), true);
            }
            ((TextPaintView) this.t).setType(i);
        }
    }

    @Override // ir.nasim.YZ2
    public void B() {
        ImageView imageView = this.s;
        if (imageView != null && imageView.getColorFilter() != null) {
            this.s.setColorFilter(new PorterDuffColorFilter(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setTextColor(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4));
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean D(EntityView entityView) {
        i0(entityView);
        return true;
    }

    public void K(boolean z) {
        if (this.u) {
            EntityView entityView = this.t;
            if (entityView instanceof TextPaintView) {
                TextPaintView textPaintView = (TextPaintView) entityView;
                this.e.setVisibility(0);
                AbstractC21455b.t0(textPaintView.getFocusedView());
                textPaintView.getFocusedView().clearFocus();
                textPaintView.k0();
                if (!z) {
                    textPaintView.setText(this.y);
                }
                if (textPaintView.getText().toString().trim().length() == 0) {
                    this.j.removeView(textPaintView);
                    f0(null);
                } else {
                    textPaintView.setPosition(this.v);
                    textPaintView.setRotation(this.w);
                    textPaintView.setScale(this.x);
                    this.v = null;
                    this.w = 0.0f;
                    this.x = 0.0f;
                }
                h0(false, textPaintView);
                this.u = false;
                this.y = null;
                this.h.setVisibility(8);
            }
        }
    }

    @Override // ir.nasim.YZ2
    public boolean a() {
        return false;
    }

    @Override // ir.nasim.YZ2
    public boolean c(MotionEvent motionEvent) {
        if (this.t != null) {
            if (this.u) {
                K(true);
            } else {
                f0(null);
            }
        }
        float x = ((motionEvent.getX() - this.i.getTranslationX()) - (getMeasuredWidth() / 2)) / this.i.getScaleX();
        float y = (((motionEvent.getY() - this.i.getTranslationY()) - (getMeasuredHeight() / 2)) + AbstractC21455b.F(32.0f)) / this.i.getScaleY();
        double d = x;
        double radians = (float) Math.toRadians(-this.i.getRotation());
        double d2 = y;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, motionEvent.getActionMasked(), ((float) ((Math.cos(radians) * d) - (Math.sin(radians) * d2))) + (this.i.getMeasuredWidth() / 2), ((float) ((d * Math.sin(radians)) + (d2 * Math.cos(radians)))) + (this.i.getMeasuredHeight() / 2), 0);
        this.i.B(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean d(EntityView entityView) {
        return !this.u;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if ((view == this.i || view == this.j || view == this.n) && this.F0 != null) {
            canvas.save();
            int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + (this.E0 ? 0 : AbstractC21455b.d);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            MediaController.i iVar = this.F0;
            int i = iVar.i;
            if (i == 90 || i == 270) {
                measuredHeight = measuredWidth;
                measuredWidth = measuredHeight;
            }
            float scaleX = measuredWidth * iVar.e * view.getScaleX();
            MediaController.i iVar2 = this.F0;
            int i2 = (int) (scaleX / iVar2.c);
            int scaleY = (int) (((measuredHeight * iVar2.f) * view.getScaleY()) / this.F0.c);
            float fCeil = ((float) Math.ceil((getMeasuredWidth() - i2) / 2)) + this.p;
            float measuredHeight2 = ((((getMeasuredHeight() - currentActionBarHeight) - AbstractC21455b.F(48.0f)) - scaleY) / 2) + AbstractC21455b.F(8.0f) + r1 + this.q;
            canvas.clipRect(Math.max(0.0f, fCeil), Math.max(0.0f, measuredHeight2), Math.min(fCeil + i2, getMeasuredWidth()), Math.min(getMeasuredHeight(), measuredHeight2 + scaleY));
            i = 1;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (i != 0) {
            canvas.restore();
        }
        return zDrawChild;
    }

    @Override // ir.nasim.YZ2
    public void e(boolean z) {
    }

    @Override // ir.nasim.YZ2
    public Bitmap f(ArrayList arrayList, Bitmap[] bitmapArr) {
        int i;
        Canvas canvas;
        byte b2;
        int i2;
        byte b3;
        int i3;
        PhotoPaintView photoPaintView = this;
        ArrayList arrayList2 = arrayList;
        Bitmap resultBitmap = photoPaintView.i.getResultBitmap();
        photoPaintView.z = BigInteger.ONE;
        if (resultBitmap != null && photoPaintView.j.d() > 0) {
            int childCount = photoPaintView.j.getChildCount();
            byte b4 = 0;
            int i4 = 0;
            Canvas canvas2 = null;
            while (i4 < childCount) {
                View childAt = photoPaintView.j.getChildAt(i4);
                if (childAt instanceof EntityView) {
                    EntityView entityView = (EntityView) childAt;
                    C22697vg5 position = entityView.getPosition();
                    if (arrayList2 != null) {
                        H.b bVar = new H.b();
                        if (entityView instanceof TextPaintView) {
                            bVar.a = (byte) 1;
                            TextPaintView textPaintView = (TextPaintView) entityView;
                            bVar.h = textPaintView.getText().toString();
                            int type = textPaintView.getType();
                            if (type == 0) {
                                bVar.b = (byte) (bVar.b | 1);
                            } else if (type == 2) {
                                bVar.b = (byte) (bVar.b | 4);
                            }
                            bVar.j = textPaintView.getSwatch().a;
                            bVar.k = textPaintView.getTextSize();
                            b2 = b4;
                        } else {
                            if (entityView instanceof StickerView) {
                                bVar.a = b4;
                                StickerView stickerView = (StickerView) entityView;
                                SD6 baseSize = stickerView.getBaseSize();
                                bVar.f = baseSize.a;
                                bVar.g = baseSize.b;
                                bVar.v = stickerView.getSticker();
                                bVar.w = stickerView.getParentObject();
                                AbstractC18106o57 sticker = stickerView.getSticker();
                                bVar.h = C4278El2.H(C22477vI7.f).Q(sticker, true).getAbsolutePath();
                                if (C10743c74.m0(sticker, true) || C10743c74.h1(sticker)) {
                                    boolean zM0 = C10743c74.m0(sticker, true);
                                    bVar.b = (byte) (bVar.b | (zM0 ? (byte) 1 : (byte) 4));
                                    long duration = zM0 ? stickerView.getDuration() : 5000L;
                                    if (duration != 0) {
                                        BigInteger bigIntegerValueOf = BigInteger.valueOf(duration);
                                        photoPaintView.z = photoPaintView.z.multiply(bigIntegerValueOf).divide(photoPaintView.z.gcd(bigIntegerValueOf));
                                    }
                                    b2 = 1;
                                } else {
                                    b2 = b4;
                                }
                                if (stickerView.h0()) {
                                    bVar.b = (byte) (bVar.b | 2);
                                }
                            }
                            i = i4;
                            i2 = childCount;
                            b3 = 0;
                        }
                        arrayList2.add(bVar);
                        float scaleX = childAt.getScaleX();
                        float scaleY = childAt.getScaleY();
                        float x = childAt.getX();
                        float y = childAt.getY();
                        bVar.n = childAt.getWidth();
                        bVar.o = childAt.getHeight();
                        bVar.f = (childAt.getWidth() * scaleX) / photoPaintView.j.getMeasuredWidth();
                        bVar.g = (childAt.getHeight() * scaleY) / photoPaintView.j.getMeasuredHeight();
                        bVar.c = (((childAt.getWidth() * (1.0f - scaleX)) / 2.0f) + x) / photoPaintView.j.getMeasuredWidth();
                        bVar.d = (y + ((childAt.getHeight() * (1.0f - scaleY)) / 2.0f)) / photoPaintView.j.getMeasuredHeight();
                        i = i4;
                        bVar.e = (float) ((-childAt.getRotation()) * 0.017453292519943295d);
                        bVar.t = (x + (childAt.getWidth() / 2)) / photoPaintView.j.getMeasuredWidth();
                        bVar.u = (y + (childAt.getHeight() / 2)) / photoPaintView.j.getMeasuredHeight();
                        bVar.r = bVar.n / photoPaintView.j.getMeasuredWidth();
                        bVar.s = bVar.o / photoPaintView.j.getMeasuredHeight();
                        bVar.q = scaleX;
                        if (bitmapArr[0] == null) {
                            bitmapArr[0] = Bitmap.createBitmap(resultBitmap.getWidth(), resultBitmap.getHeight(), resultBitmap.getConfig());
                            canvas2 = new Canvas(bitmapArr[0]);
                            canvas2.drawBitmap(resultBitmap, 0.0f, 0.0f, (Paint) null);
                        }
                        canvas = canvas2;
                    } else {
                        i = i4;
                        canvas = canvas2;
                        b2 = 0;
                    }
                    Canvas canvas3 = new Canvas(resultBitmap);
                    int i5 = 0;
                    while (i5 < 2) {
                        Canvas canvas4 = i5 == 0 ? canvas3 : canvas;
                        if (canvas4 == null || (i5 == 0 && b2 != 0)) {
                            i3 = childCount;
                        } else {
                            canvas4.save();
                            canvas4.translate(position.a, position.b);
                            canvas4.scale(childAt.getScaleX(), childAt.getScaleY());
                            canvas4.rotate(childAt.getRotation());
                            canvas4.translate((-entityView.getWidth()) / 2, (-entityView.getHeight()) / 2);
                            if (childAt instanceof TextPaintView) {
                                Bitmap bitmapA = AbstractC21456c.a(childAt.getWidth(), childAt.getHeight(), Bitmap.Config.ARGB_8888);
                                Canvas canvas5 = new Canvas(bitmapA);
                                childAt.draw(canvas5);
                                i3 = childCount;
                                canvas4.drawBitmap(bitmapA, (Rect) null, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), (Paint) null);
                                try {
                                    canvas5.setBitmap(null);
                                } catch (Exception e) {
                                    AbstractC6403Nl2.d(e);
                                }
                                bitmapA.recycle();
                            } else {
                                i3 = childCount;
                                childAt.draw(canvas4);
                            }
                            canvas4.restore();
                        }
                        i5++;
                        childCount = i3;
                    }
                    i2 = childCount;
                    b3 = 0;
                    canvas2 = canvas;
                } else {
                    i = i4;
                    i2 = childCount;
                    b3 = 0;
                }
                i4 = i + 1;
                photoPaintView = this;
                arrayList2 = arrayList;
                b4 = b3;
                childCount = i2;
            }
        }
        return resultBitmap;
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ int getAdditionalBottom() {
        return super.getAdditionalBottom();
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ int getAdditionalTop() {
        return super.getAdditionalTop();
    }

    @Override // ir.nasim.YZ2
    public View getCancelView() {
        return this.f;
    }

    public ColorPicker getColorPicker() {
        return this.o;
    }

    public FrameLayout getColorPickerBackground() {
        return this.m;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public float getCropRotation() {
        MediaController.i iVar = this.F0;
        if (iVar != null) {
            return iVar.d + iVar.i;
        }
        return 0.0f;
    }

    public FrameLayout getCurtainView() {
        return this.h;
    }

    public View getDoneView() {
        return this.g;
    }

    @Override // ir.nasim.YZ2
    public long getLcm() {
        return this.z.longValue();
    }

    @Override // ir.nasim.YZ2
    public float getOffsetTranslationY() {
        return this.H0;
    }

    @Override // ir.nasim.YZ2
    public RenderView getRenderView() {
        return this.i;
    }

    public FrameLayout getToolsView() {
        return this.e;
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ View getView() {
        return super.getView();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean i(EntityView entityView) {
        return f0(entityView);
    }

    @Override // ir.nasim.YZ2
    public void init() {
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        if (this.b != null) {
            L();
        }
    }

    @Override // ir.nasim.YZ2
    public int j(boolean z) {
        return 0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public float[] k(MotionEvent motionEvent, float f, float f2) {
        Point point = AbstractC21455b.h;
        float f3 = f2 - (point.y / 2);
        double d = f - (point.x / 2);
        double radians = (float) Math.toRadians(-this.j.getRotation());
        double d2 = f3;
        this.r[0] = ((float) ((Math.cos(radians) * d) - (Math.sin(radians) * d2))) + (AbstractC21455b.h.x / 2);
        this.r[1] = ((float) ((d * Math.sin(radians)) + (d2 * Math.cos(radians)))) + (AbstractC21455b.h.y / 2);
        return this.r;
    }

    @Override // ir.nasim.YZ2
    public void o(PhotoViewer photoViewer, Activity activity, final Runnable runnable) {
        if (this.u) {
            K(false);
            return;
        }
        if (!x()) {
            runnable.run();
            return;
        }
        if (activity == null) {
            return;
        }
        AlertDialog.i iVar = new AlertDialog.i(activity);
        iVar.e(FH3.E("PhotoEditorDiscardAlert", TD5.tgwidget_PhotoEditorDiscardAlert));
        iVar.j(FH3.E("DiscardChanges", TD5.tgwidget_DiscardChanges));
        iVar.i(FH3.E("PassportDiscard", TD5.tgwidget_PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.nasim.u95
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                runnable.run();
            }
        });
        iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), null);
        photoViewer.jb(iVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = !this.E0 ? AbstractC21455b.d : 0;
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + i7;
        int i8 = AbstractC21455b.h.y;
        AbstractC21455b.F(48.0f);
        int iCeil = (int) Math.ceil((i5 - this.i.getMeasuredWidth()) / 2);
        int iF = ((((i6 - currentActionBarHeight) - AbstractC21455b.F(48.0f)) - this.i.getMeasuredHeight()) / 2) + AbstractC21455b.F(8.0f) + i7;
        RenderView renderView = this.i;
        renderView.layout(iCeil, iF, renderView.getMeasuredWidth() + iCeil, this.i.getMeasuredHeight() + iF);
        int measuredWidth = ((this.i.getMeasuredWidth() - this.j.getMeasuredWidth()) / 2) + iCeil;
        int measuredHeight = ((this.i.getMeasuredHeight() - this.j.getMeasuredHeight()) / 2) + iF;
        EntitiesContainerView entitiesContainerView = this.j;
        entitiesContainerView.layout(measuredWidth, measuredHeight, entitiesContainerView.getMeasuredWidth() + measuredWidth, this.j.getMeasuredHeight() + measuredHeight);
        FrameLayout frameLayout = this.k;
        frameLayout.layout(0, i7, frameLayout.getMeasuredWidth(), this.k.getMeasuredHeight() + i7);
        FrameLayout frameLayout2 = this.n;
        frameLayout2.layout(iCeil, iF, frameLayout2.getMeasuredWidth() + iCeil, this.n.getMeasuredHeight() + iF);
        ColorPicker colorPicker = this.o;
        colorPicker.layout(0, currentActionBarHeight, colorPicker.getMeasuredWidth(), this.o.getMeasuredHeight() + currentActionBarHeight);
        FrameLayout frameLayout3 = this.e;
        frameLayout3.layout(0, i6 - frameLayout3.getMeasuredHeight(), this.e.getMeasuredWidth(), i6);
        FrameLayout frameLayout4 = this.h;
        frameLayout4.layout(0, iF, frameLayout4.getMeasuredWidth(), this.h.getMeasuredHeight() + iF);
        this.m.layout(0, (i6 - AbstractC21455b.F(45.0f)) - this.m.getMeasuredHeight(), this.m.getMeasuredWidth(), i6 - AbstractC21455b.F(45.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        float currentActionBarHeight;
        float width;
        this.B0 = true;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        int currentActionBarHeight2 = (AbstractC21455b.h.y - ActionBar.getCurrentActionBarHeight()) - AbstractC21455b.F(48.0f);
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            width = bitmap.getWidth();
            currentActionBarHeight = this.a.getHeight();
        } else {
            currentActionBarHeight = (size2 - ActionBar.getCurrentActionBarHeight()) - AbstractC21455b.F(48.0f);
            width = size;
        }
        float fFloor = size;
        float fFloor2 = (float) Math.floor((fFloor * currentActionBarHeight) / width);
        float f = currentActionBarHeight2;
        if (fFloor2 > f) {
            fFloor = (float) Math.floor((width * f) / currentActionBarHeight);
            fFloor2 = f;
        }
        int i3 = (int) fFloor;
        int i4 = (int) fFloor2;
        this.i.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        float f2 = fFloor / this.G.a;
        this.H = f2;
        this.j.setScaleX(f2);
        this.j.setScaleY(this.H);
        this.j.measure(View.MeasureSpec.makeMeasureSpec((int) this.G.a, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.G.b, 1073741824));
        this.k.measure(i, View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, RecyclerView.UNDEFINED_DURATION));
        EntityView entityView = this.t;
        if (entityView != null) {
            entityView.d0();
        }
        this.n.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        this.o.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, 1073741824));
        this.e.measure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(48.0f), 1073741824));
        this.h.measure(i, View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, 1073741824));
        this.m.measure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(72.0f), 1073741824));
        this.B0 = false;
    }

    @Override // ir.nasim.YZ2
    public float p() {
        return 0.0f;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.B0) {
            return;
        }
        super.requestLayout();
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ void setOffsetTranslationX(float f) {
        super.setOffsetTranslationX(f);
    }

    @Override // ir.nasim.YZ2
    public void setOffsetTranslationY(float f, float f2, int i, boolean z) {
        this.H0 = f;
        getColorPicker().setTranslationY(f);
        getToolsView().setTranslationY(f);
        getColorPickerBackground().setTranslationY(f);
        getCurtainView().setTranslationY(f);
    }

    @Override // ir.nasim.YZ2
    public void setOnDoneButtonClickedListener(final Runnable runnable) {
        this.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.m95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                runnable.run();
            }
        });
    }

    @Override // ir.nasim.YZ2
    public void setTransform(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        this.p = f2;
        this.q = f3;
        int i = 0;
        while (i < 3) {
            View view = i == 0 ? this.j : i == 1 ? this.n : this.i;
            MediaController.i iVar = this.F0;
            float f10 = 1.0f;
            if (iVar != null) {
                float f11 = iVar.c * 1.0f;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                if (measuredWidth == 0 || measuredHeight == 0) {
                    return;
                }
                int i2 = this.F0.i;
                if (i2 == 90 || i2 == 270) {
                    measuredHeight = measuredWidth;
                    measuredWidth = measuredHeight;
                }
                float fMax = Math.max(f4 / ((int) (r9.e * r7)), f5 / ((int) (r9.f * r8)));
                f6 = f11 * fMax;
                MediaController.i iVar2 = this.F0;
                float f12 = iVar2.a * measuredWidth * f * fMax;
                float f13 = iVar2.c;
                f8 = (f12 * f13) + f2;
                f9 = f3 + (iVar2.b * measuredHeight * f * fMax * f13);
                f7 = iVar2.d + i2;
            } else {
                f6 = i == 0 ? this.H * 1.0f : 1.0f;
                f7 = 0.0f;
                f8 = f2;
                f9 = f3;
            }
            float f14 = f6 * f;
            if (!Float.isNaN(f14)) {
                f10 = f14;
            }
            view.setScaleX(f10);
            view.setScaleY(f10);
            view.setTranslationX(f8);
            view.setTranslationY(f9);
            view.setRotation(f7);
            view.invalidate();
            i++;
        }
        invalidate();
    }

    @Override // ir.nasim.YZ2
    public void shutdown() {
        this.i.H();
        this.j.setVisibility(8);
        this.n.setVisibility(8);
        this.z0.i(new Runnable() { // from class: ir.nasim.t95
            @Override // java.lang.Runnable
            public final void run() {
                PhotoPaintView.c0();
            }
        });
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public int[] v(EntityView entityView) {
        return O(entityView);
    }

    @Override // ir.nasim.YZ2
    public boolean x() {
        return this.c.b();
    }

    @Override // ir.nasim.YZ2
    public ArrayList<AbstractC24131y57> getMasks() {
        int childCount = this.j.getChildCount();
        ArrayList<AbstractC24131y57> arrayList = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.j.getChildAt(i);
            if (childAt instanceof StickerView) {
                AbstractC18106o57 sticker = ((StickerView) childAt).getSticker();
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                Q87 q87 = new Q87();
                q87.b = sticker.c;
                q87.c = sticker.d;
                byte[] bArr = sticker.e;
                q87.d = bArr;
                if (bArr == null) {
                    q87.d = new byte[0];
                }
                arrayList.add(q87);
            }
        }
        return arrayList;
    }
}
