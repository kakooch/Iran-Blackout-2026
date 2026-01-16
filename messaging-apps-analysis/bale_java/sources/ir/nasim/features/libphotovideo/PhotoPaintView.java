package ir.nasim.features.libphotovideo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC17261mg0;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9160Yt;
import ir.nasim.C14433hu3;
import ir.nasim.C16983mB7;
import ir.nasim.C19406qI3;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.H37;
import ir.nasim.InterfaceC13156fl0;
import ir.nasim.KB5;
import ir.nasim.NZ;
import ir.nasim.SZ;
import ir.nasim.features.libphotovideo.Paint.RenderView;
import ir.nasim.features.libphotovideo.Paint.Views.ColorPicker;
import ir.nasim.features.libphotovideo.Paint.Views.EditTextOutline;
import ir.nasim.features.libphotovideo.Paint.Views.EntitiesContainerView;
import ir.nasim.features.libphotovideo.Paint.Views.EntityView;
import ir.nasim.features.libphotovideo.Paint.Views.TextPaintView;
import ir.nasim.features.media.Actionbar.ActionBar;
import ir.nasim.features.media.Actionbar.ActionBarMenu;
import ir.nasim.features.media.Actionbar.ActionBarMenuItem;
import ir.nasim.features.media.components.ActionBarPopupWindow;
import ir.nasim.features.media.components.PhotoViewerInterface;
import ir.nasim.features.media.components.Point;
import ir.nasim.features.media.components.Size;

/* loaded from: classes3.dex */
public class PhotoPaintView extends FrameLayout implements EntityView.b {
    private ActionBarPopupWindow.ActionBarPopupWindowLayout A;
    private Rect B;
    private Size D;
    private boolean G;
    private Animator H;
    private NZ J;
    private Bitmap a;
    private int b;
    private C16983mB7 c;
    int d;
    private InterfaceC13156fl0[] e;
    private FrameLayout f;
    private TextView g;
    private TextView h;
    private FrameLayout i;
    private RenderView j;
    private EntitiesContainerView k;
    private FrameLayout l;
    private FrameLayout m;
    private FrameLayout n;
    private ColorPicker o;
    private ImageView p;
    private ActionBar q;
    private ActionBarMenuItem r;
    private ActionBarMenuItem s;
    private EntityView t;
    private boolean u;
    private Point v;
    private float w;
    private float x;
    private String y;
    private ActionBarPopupWindow z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null) {
                looperMyLooper.quit();
            }
        }
    }

    class b implements DialogInterface.OnClickListener {
        final /* synthetic */ Runnable a;

        b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.run();
        }
    }

    class c extends AbstractC9160Yt {
        c() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PhotoPaintView.this.H != null) {
                PhotoPaintView.this.H = null;
            }
        }
    }

    class d extends AbstractC9160Yt {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            PhotoPaintView.this.l.setVisibility(8);
        }
    }

    class e extends AbstractC9160Yt {
        final /* synthetic */ boolean a;

        e(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            PhotoPaintView.this.m.setVisibility(8);
            if (PhotoPaintView.this.m.getParent() != null) {
                ((EntitiesContainerView) PhotoPaintView.this.m.getParent()).removeView(PhotoPaintView.this.m);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ EntityView a;

        f(EntityView entityView) {
            this.a = entityView;
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoPaintView.this.T(this.a);
        }
    }

    class g implements Runnable {
        final /* synthetic */ EntityView a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = g.this;
                PhotoPaintView.this.T(gVar.a);
                if (PhotoPaintView.this.z == null || !PhotoPaintView.this.z.isShowing()) {
                    return;
                }
                PhotoPaintView.this.z.dismiss(true);
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoPaintView.this.N();
                if (PhotoPaintView.this.z == null || !PhotoPaintView.this.z.isShowing()) {
                    return;
                }
                PhotoPaintView.this.z.dismiss(true);
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoPaintView.this.M();
                if (PhotoPaintView.this.z == null || !PhotoPaintView.this.z.isShowing()) {
                    return;
                }
                PhotoPaintView.this.z.dismiss(true);
            }
        }

        g(EntityView entityView) {
            this.a = entityView;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout linearLayout = new LinearLayout(PhotoPaintView.this.getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(PhotoPaintView.this.getContext());
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.j2());
            textView.setBackgroundResource(KB5.list_selector);
            textView.setGravity(16);
            textView.setPadding(AbstractC7426Rr.z(16.0f), 0, AbstractC7426Rr.z(14.0f), 0);
            textView.setTextSize(1, 18.0f);
            textView.setTag(0);
            textView.setText(AbstractC12217eE5.PaintDelete);
            textView.setOnClickListener(new a());
            linearLayout.addView(textView, C14433hu3.d(-2, 48));
            if (this.a instanceof TextPaintView) {
                TextView textView2 = new TextView(PhotoPaintView.this.getContext());
                textView2.setTextColor(c5495Jo7.j2());
                textView2.setBackgroundResource(KB5.list_selector);
                textView2.setGravity(16);
                textView2.setPadding(AbstractC7426Rr.z(16.0f), 0, AbstractC7426Rr.z(16.0f), 0);
                textView2.setTextSize(1, 18.0f);
                textView2.setTag(1);
                textView2.setText(AbstractC12217eE5.PaintEdit);
                textView2.setOnClickListener(new b());
                linearLayout.addView(textView2, C14433hu3.d(-2, 48));
            }
            TextView textView3 = new TextView(PhotoPaintView.this.getContext());
            textView3.setTextColor(c5495Jo7.j2());
            textView3.setBackgroundResource(KB5.list_selector);
            textView3.setGravity(16);
            textView3.setPadding(AbstractC7426Rr.z(14.0f), 0, AbstractC7426Rr.z(16.0f), 0);
            textView3.setTextSize(1, 18.0f);
            textView3.setTag(2);
            textView3.setText(AbstractC12217eE5.PaintDuplicate);
            textView3.setOnClickListener(new c());
            linearLayout.addView(textView3, C14433hu3.d(-2, 48));
            PhotoPaintView.this.A.addView(linearLayout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ int a;

        h(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPaintView.this.setBrush(this.a);
            if (PhotoPaintView.this.z == null || !PhotoPaintView.this.z.isShowing()) {
                return;
            }
            PhotoPaintView.this.z.dismiss(true);
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoPaintView photoPaintView = PhotoPaintView.this;
            FrameLayout frameLayoutH = photoPaintView.H(0, KB5.paint_radial_preview, photoPaintView.d == 0);
            PhotoPaintView.this.A.addView(frameLayoutH);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayoutH.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = AbstractC7426Rr.z(52.0f);
            frameLayoutH.setLayoutParams(layoutParams);
            PhotoPaintView photoPaintView2 = PhotoPaintView.this;
            FrameLayout frameLayoutH2 = photoPaintView2.H(1, KB5.paint_elliptical_preview, photoPaintView2.d == 1);
            PhotoPaintView.this.A.addView(frameLayoutH2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayoutH2.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = AbstractC7426Rr.z(52.0f);
            frameLayoutH2.setLayoutParams(layoutParams2);
            PhotoPaintView photoPaintView3 = PhotoPaintView.this;
            FrameLayout frameLayoutH3 = photoPaintView3.H(2, KB5.paint_neon_preview, photoPaintView3.d == 2);
            PhotoPaintView.this.A.addView(frameLayoutH3);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) frameLayoutH3.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = AbstractC7426Rr.z(52.0f);
            frameLayoutH3.setLayoutParams(layoutParams3);
        }
    }

    class j extends FrameLayout {
        j(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    class k implements C16983mB7.b {
        k() {
        }

        @Override // ir.nasim.C16983mB7.b
        public void a() {
            PhotoPaintView photoPaintView = PhotoPaintView.this;
            photoPaintView.setMenuItemEnabled(photoPaintView.c.b());
        }
    }

    class l implements View.OnClickListener {
        final /* synthetic */ boolean a;

        l(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPaintView.this.setStroke(this.a);
            if (PhotoPaintView.this.z == null || !PhotoPaintView.this.z.isShowing()) {
                return;
            }
            PhotoPaintView.this.z.dismiss(true);
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout frameLayoutI = PhotoPaintView.this.I(true, C5721Ko.b.getString(AbstractC12217eE5.PaintOutlined), PhotoPaintView.this.G);
            PhotoPaintView.this.A.addView(frameLayoutI);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayoutI.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = AbstractC7426Rr.z(48.0f);
            frameLayoutI.setLayoutParams(layoutParams);
            FrameLayout frameLayoutI2 = PhotoPaintView.this.I(false, C5721Ko.b.getString(AbstractC12217eE5.PaintRegular), true ^ PhotoPaintView.this.G);
            PhotoPaintView.this.A.addView(frameLayoutI2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayoutI2.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = AbstractC7426Rr.z(48.0f);
            frameLayoutI2.setLayoutParams(layoutParams2);
        }
    }

    class n implements View.OnTouchListener {
        n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0 || PhotoPaintView.this.z == null || !PhotoPaintView.this.z.isShowing()) {
                return false;
            }
            view.getHitRect(PhotoPaintView.this.B);
            if (PhotoPaintView.this.B.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
            PhotoPaintView.this.z.dismiss();
            return false;
        }
    }

    class o implements ActionBarPopupWindow.OnDispatchKeyEventListener {
        o() {
        }

        @Override // ir.nasim.features.media.components.ActionBarPopupWindow.OnDispatchKeyEventListener
        public void onDispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && PhotoPaintView.this.z != null && PhotoPaintView.this.z.isShowing()) {
                PhotoPaintView.this.z.dismiss();
            }
        }
    }

    class p implements PopupWindow.OnDismissListener {
        p() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PhotoPaintView.this.A.removeInnerViews();
        }
    }

    class q implements RenderView.f {
        q() {
        }

        @Override // ir.nasim.features.libphotovideo.Paint.RenderView.f
        public boolean a() {
            boolean z = PhotoPaintView.this.t == null;
            if (!z) {
                PhotoPaintView.this.U(null);
            }
            return z;
        }

        @Override // ir.nasim.features.libphotovideo.Paint.RenderView.f
        public void b(boolean z) {
            if (z) {
                PhotoPaintView.this.setColorPickerVisibilityFade(true);
            }
            PhotoPaintView photoPaintView = PhotoPaintView.this;
            photoPaintView.setMenuItemEnabled(photoPaintView.c.b());
        }

        @Override // ir.nasim.features.libphotovideo.Paint.RenderView.f
        public void c() {
            PhotoPaintView.this.setColorPickerVisibilityFade(false);
            if (PhotoPaintView.this.t != null) {
                PhotoPaintView.this.U(null);
            }
        }
    }

    class r implements EntitiesContainerView.a {
        r() {
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.EntitiesContainerView.a
        public void a() {
            PhotoPaintView.this.U(null);
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.EntitiesContainerView.a
        public EntityView b() {
            return PhotoPaintView.this.t;
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.EntitiesContainerView.a
        public boolean c() {
            return PhotoPaintView.this.m.getVisibility() != 0;
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPaintView.this.K(true);
        }
    }

    class t extends FrameLayout {
        t(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }
    }

    class u implements ColorPicker.b {
        u() {
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.ColorPicker.b
        public void a() {
            if (PhotoPaintView.this.t instanceof TextPaintView) {
                return;
            }
            PhotoPaintView.this.setDimVisibility(true);
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.ColorPicker.b
        public void b() {
            PhotoPaintView photoPaintView = PhotoPaintView.this;
            photoPaintView.V(photoPaintView.o.getSwatch(), false);
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.ColorPicker.b
        public void c() {
            PhotoPaintView photoPaintView = PhotoPaintView.this;
            photoPaintView.V(photoPaintView.o.getSwatch(), false);
            if (PhotoPaintView.this.t instanceof TextPaintView) {
                return;
            }
            PhotoPaintView.this.setDimVisibility(false);
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.ColorPicker.b
        public void d() {
            if (PhotoPaintView.this.t == null) {
                PhotoPaintView.this.X();
            } else if (PhotoPaintView.this.t instanceof TextPaintView) {
                PhotoPaintView.this.a0();
            }
        }
    }

    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPaintView.this.U(null);
        }
    }

    class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPaintView.this.L();
        }
    }

    class x extends ActionBar.b {
        x() {
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBar.b
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBar.b
        public void b(int i) {
            if (i == -1) {
                PhotoPaintView.this.g.callOnClick();
            } else if (i == 1) {
                PhotoPaintView.this.K(true);
            } else if (i == 2) {
                PhotoPaintView.this.c.f();
            }
        }
    }

    public PhotoPaintView(Context context, Bitmap bitmap, int i2) {
        super(context);
        this.e = new InterfaceC13156fl0[]{new InterfaceC13156fl0.c(), new InterfaceC13156fl0.a(), new InterfaceC13156fl0.b()};
        this.G = true;
        this.J = SZ.g("Q_PPV_Paint");
        this.a = bitmap;
        this.b = i2;
        C16983mB7 c16983mB7 = new C16983mB7();
        this.c = c16983mB7;
        c16983mB7.e(new k());
        FrameLayout frameLayout = new FrameLayout(context);
        this.i = frameLayout;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        frameLayout.setBackgroundColor(c5495Jo7.j2());
        this.i.setVisibility(4);
        addView(this.i);
        RenderView renderView = new RenderView(context, new ir.nasim.features.libphotovideo.Paint.a(getPaintingSize()), bitmap, this.b);
        this.j = renderView;
        renderView.setDelegate(new q());
        this.j.setUndoStore(this.c);
        this.j.setQueue(this.J);
        this.j.setVisibility(4);
        this.j.setBrush(this.e[0]);
        addView(this.j, C14433hu3.c(-1, -1, 51));
        EntitiesContainerView entitiesContainerView = new EntitiesContainerView(context, new r());
        this.k = entitiesContainerView;
        entitiesContainerView.setPivotX(0.0f);
        this.k.setPivotY(0.0f);
        addView(this.k);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.l = frameLayout2;
        frameLayout2.setAlpha(0.0f);
        this.l.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 40));
        this.l.setVisibility(8);
        addView(this.l);
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.m = frameLayout3;
        frameLayout3.setAlpha(0.0f);
        this.m.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 40));
        this.m.setVisibility(8);
        this.m.setOnClickListener(new s());
        t tVar = new t(context);
        this.n = tVar;
        addView(tVar);
        ColorPicker colorPicker = new ColorPicker(context);
        this.o = colorPicker;
        addView(colorPicker);
        this.o.setDelegate(new u());
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.f = frameLayout4;
        frameLayout4.setBackgroundColor(c5495Jo7.j2());
        addView(this.f, C14433hu3.c(-1, 48, 83));
        TextView textView = new TextView(context);
        this.g = textView;
        textView.setTextSize(1, 14.0f);
        this.g.setTextColor(c5495Jo7.f0());
        this.g.setGravity(17);
        this.g.setBackgroundDrawable(AbstractC4310Eo7.c(c5495Jo7.p2(), false));
        this.g.setPadding(AbstractC7426Rr.z(20.0f), 0, AbstractC7426Rr.z(20.0f), 0);
        this.g.setText(C5721Ko.b.getString(AbstractC12217eE5.Cancel).toUpperCase());
        this.g.setTypeface(C6011Lu2.k());
        this.f.addView(this.g, C14433hu3.c(-2, -1, 51));
        TextView textView2 = new TextView(context);
        this.h = textView2;
        textView2.setTextSize(1, 14.0f);
        this.h.setTextColor(c5495Jo7.t2());
        this.h.setGravity(17);
        this.h.setBackgroundDrawable(AbstractC4310Eo7.c(c5495Jo7.p2(), false));
        this.h.setPadding(AbstractC7426Rr.z(20.0f), 0, AbstractC7426Rr.z(20.0f), 0);
        this.h.setText(C5721Ko.b.getString(AbstractC12217eE5.Done).toUpperCase());
        this.h.setTypeface(C6011Lu2.k());
        this.f.addView(this.h, C14433hu3.c(-2, -1, 53));
        ImageView imageView = new ImageView(context);
        this.p = imageView;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView.setScaleType(scaleType);
        this.p.setImageResource(KB5.photo_paint);
        this.p.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        this.f.addView(this.p, C14433hu3.c(54, -1, 17));
        this.p.setVisibility(8);
        this.p.setOnClickListener(new v());
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(scaleType);
        imageView2.setImageResource(KB5.photo_paint_text);
        imageView2.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        imageView2.setOnClickListener(new w());
        ActionBar actionBar = new ActionBar(context);
        this.q = actionBar;
        actionBar.setTitleCenter(false);
        this.q.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.q.setItemsBackgroundColor(c5495Jo7.y0(c5495Jo7.f0(), 25));
        this.q.setBackButtonImage(KB5.ic_arrow_back_white_24dp);
        this.q.setTitle(C5721Ko.b.getString(AbstractC12217eE5.PaintDraw));
        addView(this.q, C14433hu3.a(-1, -2.0f));
        this.q.a(new x());
        ActionBarMenu actionBarMenuD = this.q.d();
        this.r = actionBarMenuD.a(2, KB5.photo_undo);
        setMenuItemEnabled(false);
        ActionBarMenuItem actionBarMenuItemD = actionBarMenuD.d(1, KB5.ic_done_white_24dp, AbstractC7426Rr.z(56.0f));
        this.s = actionBarMenuItemD;
        actionBarMenuItemD.setVisibility(8);
        V(this.o.getSwatch(), false);
        d0();
    }

    private int G() {
        return (int) (getPaintingSize().width / 9.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout H(int i2, int i3, boolean z) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundResource(KB5.list_selector);
        frameLayout.setOnClickListener(new h(i2));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(i3);
        frameLayout.addView(imageView, C14433hu3.b(165, 44.0f, 19, 46.0f, 0.0f, 8.0f, 0.0f));
        if (z) {
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setImageResource(KB5.ic_ab_done_gray);
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            frameLayout.addView(imageView2, C14433hu3.a(50, -1.0f));
        }
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout I(boolean z, String str, boolean z2) {
        j jVar = new j(getContext());
        jVar.setBackgroundResource(KB5.list_selector);
        jVar.setOnClickListener(new l(z));
        EditTextOutline editTextOutline = new EditTextOutline(getContext());
        editTextOutline.setBackgroundColor(0);
        editTextOutline.setEnabled(false);
        editTextOutline.setStrokeWidth(AbstractC7426Rr.z(3.0f));
        editTextOutline.setTextColor(z ? -1 : -16777216);
        editTextOutline.setStrokeColor(z ? -16777216 : 0);
        editTextOutline.setPadding(AbstractC7426Rr.z(2.0f), 0, AbstractC7426Rr.z(2.0f), 0);
        editTextOutline.setTextSize(1, 18.0f);
        editTextOutline.setTypeface(null, 1);
        editTextOutline.setTag(Boolean.valueOf(z));
        editTextOutline.setText(str);
        jVar.addView(editTextOutline, C14433hu3.b(-2, -2.0f, 19, 46.0f, 0.0f, 16.0f, 0.0f));
        if (z2) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(KB5.ic_ab_done_gray);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            jVar.addView(imageView, C14433hu3.a(50, -1.0f));
        }
        return jVar;
    }

    private Point J() {
        Size paintingSize = getPaintingSize();
        return new Point(paintingSize.width / 2.0f, paintingSize.height / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        H37 swatch = this.o.getSwatch();
        H37 h37 = new H37(-1, 1.0f, swatch.c);
        H37 h372 = new H37(-16777216, 0.85f, swatch.c);
        if (this.G) {
            h37 = h372;
        }
        V(h37, true);
        TextPaintView textPaintView = new TextPaintView(getContext(), c0(null), G(), "", this.o.getSwatch(), this.G);
        textPaintView.setDelegate(this);
        textPaintView.setMaxWidth((int) (getPaintingSize().width - 20.0f));
        this.k.addView(textPaintView, C14433hu3.a(-2, -2.0f));
        S(textPaintView);
        U(textPaintView);
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        TextPaintView textPaintView;
        EntityView entityView = this.t;
        if (entityView == null) {
            return;
        }
        Point pointC0 = c0(entityView);
        if (this.t instanceof TextPaintView) {
            textPaintView = new TextPaintView(getContext(), (TextPaintView) this.t, pointC0);
            textPaintView.setDelegate(this);
            textPaintView.setMaxWidth((int) (getPaintingSize().width - 20.0f));
            this.k.addView(textPaintView, C14433hu3.a(-2, -2.0f));
        } else {
            textPaintView = null;
        }
        S(textPaintView);
        U(textPaintView);
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (!(this.t instanceof TextPaintView) || this.u) {
            return;
        }
        this.i.setVisibility(0);
        TextPaintView textPaintView = (TextPaintView) this.t;
        this.y = textPaintView.getText();
        this.u = true;
        this.v = textPaintView.getPosition();
        this.w = textPaintView.getRotation();
        this.x = textPaintView.getScale();
        textPaintView.setPosition(J());
        textPaintView.setRotation(0.0f);
        textPaintView.setScale(1.0f);
        this.r.setVisibility(8);
        this.s.setVisibility(0);
        this.q.setTitle(C5721Ko.b.getString(AbstractC12217eE5.PaintText));
        this.f.setVisibility(8);
        setColorPickerVisibilitySlide(false);
        W(true, textPaintView);
        textPaintView.D();
        ((InputMethodManager) C5721Ko.b.getSystemService("input_method")).toggleSoftInputFromWindow(textPaintView.getFocusedView().getWindowToken(), 2, 0);
    }

    private boolean O() {
        return this.c.b() || this.k.d() > 0;
    }

    private boolean Q() {
        int i2 = this.b;
        return i2 % 360 == 90 || i2 % 360 == 270;
    }

    private void S(EntityView entityView) {
        this.c.d(entityView.getUUID(), new f(entityView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(EntityView entityView) {
        EntityView entityView2 = this.t;
        if (entityView == entityView2) {
            entityView2.t();
            this.t = null;
            d0();
        }
        this.k.removeView(entityView);
        this.c.g(entityView.getUUID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(EntityView entityView) {
        boolean z;
        EntityView entityView2 = this.t;
        boolean z2 = true;
        if (entityView2 == null) {
            z = false;
        } else {
            if (entityView2 == entityView) {
                if (!this.u) {
                    Y(entityView2);
                }
                return true;
            }
            entityView2.t();
            z = true;
        }
        this.t = entityView;
        if (entityView != null) {
            entityView.z(this.n);
            this.k.c(this.t);
            EntityView entityView3 = this.t;
            if (entityView3 instanceof TextPaintView) {
                V(((TextPaintView) entityView3).getSwatch(), true);
            }
        } else {
            z2 = z;
        }
        d0();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(H37 h37, boolean z) {
        this.j.setColor(h37.a);
        this.j.setBrushSize(h37.c);
        if (z) {
            this.o.setSwatch(h37);
        }
        EntityView entityView = this.t;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setSwatch(h37);
        }
    }

    private void W(boolean z, EntityView entityView) {
        ObjectAnimator objectAnimatorOfFloat;
        if (z && entityView != null) {
            ViewGroup viewGroup = (ViewGroup) entityView.getParent();
            if (this.m.getParent() != null) {
                ((EntitiesContainerView) this.m.getParent()).removeView(this.m);
            }
            viewGroup.addView(this.m, viewGroup.indexOfChild(entityView));
        }
        entityView.setSelectionVisibility(!z);
        if (z) {
            this.m.setVisibility(0);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.m, "alpha", 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.m, "alpha", 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.addListener(new e(z));
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        Z(new i(), this, 85, 0, AbstractC7426Rr.z(48.0f));
    }

    private void Y(EntityView entityView) {
        Z(new g(entityView), entityView, 17, (int) ((entityView.getPosition().x - (this.k.getWidth() / 2)) * this.k.getScaleX()), ((int) (((entityView.getPosition().y - ((entityView.getHeight() * entityView.getScale()) / 2.0f)) - (this.k.getHeight() / 2)) * this.k.getScaleY())) - AbstractC7426Rr.z(32.0f));
    }

    private void Z(Runnable runnable, View view, int i2, int i3, int i4) {
        ActionBarPopupWindow actionBarPopupWindow = this.z;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.z.dismiss();
            return;
        }
        if (this.A == null) {
            this.B = new Rect();
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext());
            this.A = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setOnTouchListener(new n());
            this.A.setDispatchKeyEventListener(new o());
            this.A.setShowedFromBotton(true);
        }
        this.A.removeInnerViews();
        runnable.run();
        if (this.z == null) {
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.A, -2, -2);
            this.z = actionBarPopupWindow2;
            actionBarPopupWindow2.setAnimationEnabled(false);
            this.z.setAnimationStyle(AbstractC23035wE5.PopupAnimation);
            this.z.setOutsideTouchable(true);
            this.z.setClippingEnabled(true);
            this.z.setInputMethodMode(2);
            this.z.setSoftInputMode(0);
            this.z.getContentView().setFocusableInTouchMode(true);
            this.z.setOnDismissListener(new p());
        }
        this.A.measure(View.MeasureSpec.makeMeasureSpec(AbstractC7426Rr.z(1000.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC7426Rr.z(1000.0f), RecyclerView.UNDEFINED_DURATION));
        this.z.setFocusable(true);
        this.z.showAtLocation(view, i2, i3, i4);
        this.z.startAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        Z(new m(), this, 85, 0, AbstractC7426Rr.z(48.0f));
    }

    private Point c0(EntityView entityView) {
        if (entityView != null) {
            Point position = entityView.getPosition();
            return new Point(position.x + 200.0f, position.y + 200.0f);
        }
        Point pointJ = J();
        while (true) {
            boolean z = false;
            for (int i2 = 0; i2 < this.k.getChildCount(); i2++) {
                View childAt = this.k.getChildAt(i2);
                if (childAt instanceof EntityView) {
                    Point position2 = ((EntityView) childAt).getPosition();
                    if (((float) Math.sqrt(Math.pow(position2.x - pointJ.x, 2.0d) + Math.pow(position2.y - pointJ.y, 2.0d))) < 100.0f) {
                        z = true;
                    }
                }
            }
            if (!z) {
                return pointJ;
            }
            pointJ = new Point(pointJ.x + 200.0f, pointJ.y + 200.0f);
        }
    }

    private void d0() {
        int i2 = KB5.photo_paint_brush;
        EntityView entityView = this.t;
        if (entityView != null) {
            if (entityView instanceof TextPaintView) {
                i2 = KB5.ic_text_fields_white_24dp;
            }
            this.p.setImageResource(KB5.photo_paint);
        } else {
            this.p.setImageResource(KB5.photo_paint2);
        }
        this.o.setSettingsButtonImage(i2);
    }

    private Size getPaintingSize() {
        Size size = this.D;
        if (size != null) {
            return size;
        }
        Size size2 = new Size(Q() ? this.a.getHeight() : this.a.getWidth(), Q() ? this.a.getWidth() : this.a.getHeight());
        size2.width = 1280.0f;
        float fFloor = (float) Math.floor((1280.0f * r1) / r0);
        size2.height = fFloor;
        if (fFloor > 1280.0f) {
            size2.height = 1280.0f;
            size2.width = (float) Math.floor((1280.0f * r0) / r1);
        }
        this.D = size2;
        return size2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrush(int i2) {
        RenderView renderView = this.j;
        InterfaceC13156fl0[] interfaceC13156fl0Arr = this.e;
        this.d = i2;
        renderView.setBrush(interfaceC13156fl0Arr[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorPickerVisibilityFade(boolean z) {
        if (!z) {
            Animator animator = this.H;
            if (animator != null) {
                animator.cancel();
                this.H = null;
            }
            this.o.setAlpha(0.0f);
            return;
        }
        ColorPicker colorPicker = this.o;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(colorPicker, "alpha", colorPicker.getAlpha(), 1.0f);
        this.H = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setStartDelay(200L);
        this.H.setDuration(200L);
        this.H.addListener(new c());
        this.H.start();
    }

    private void setColorPickerVisibilitySlide(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.o, "translationX", z ? AbstractC7426Rr.z(60.0f) : 0.0f, z ? 0.0f : AbstractC7426Rr.z(60.0f));
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDimVisibility(boolean z) {
        ObjectAnimator objectAnimatorOfFloat;
        if (z) {
            this.l.setVisibility(0);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.l, "alpha", 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.l, "alpha", 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.addListener(new d(z));
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMenuItemEnabled(boolean z) {
        this.r.setAlpha(z ? 1.0f : 0.3f);
        this.r.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStroke(boolean z) {
        this.G = z;
        if (this.t instanceof TextPaintView) {
            H37 swatch = this.o.getSwatch();
            if (z && swatch.a == -1) {
                V(new H37(-16777216, 0.85f, swatch.c), true);
            } else if (!z && swatch.a == -16777216) {
                V(new H37(-1, 1.0f, swatch.c), true);
            }
            ((TextPaintView) this.t).setStroke(z);
        }
    }

    public void K(boolean z) {
        if (this.u) {
            EntityView entityView = this.t;
            if (entityView instanceof TextPaintView) {
                TextPaintView textPaintView = (TextPaintView) entityView;
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.q.setTitle(C5721Ko.b.getString(AbstractC12217eE5.PaintDraw));
                this.f.setVisibility(0);
                setColorPickerVisibilitySlide(true);
                C23381wp3.f(textPaintView.getFocusedView());
                textPaintView.getFocusedView().clearFocus();
                textPaintView.F();
                if (!z) {
                    textPaintView.setText(this.y);
                }
                if (textPaintView.getText().trim().length() == 0) {
                    this.k.removeView(textPaintView);
                    U(null);
                } else {
                    textPaintView.setPosition(this.v);
                    textPaintView.setRotation(this.w);
                    textPaintView.setScale(this.x);
                    this.v = null;
                    this.w = 0.0f;
                    this.x = 0.0f;
                }
                W(false, textPaintView);
                this.u = false;
                this.y = null;
                this.i.setVisibility(8);
            }
        }
    }

    public void P() {
        this.j.setVisibility(0);
    }

    public void R(PhotoViewerInterface photoViewerInterface, Activity activity, Runnable runnable) {
        if (this.u) {
            K(false);
            return;
        }
        if (!O()) {
            runnable.run();
            return;
        }
        if (activity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, AbstractC23035wE5.AlertDialogStyle);
        builder.setMessage(AbstractC12217eE5.DiscardChanges);
        builder.setTitle(AbstractC12217eE5.PaintEdit);
        builder.setPositiveButton(AbstractC12217eE5.Yes, new b(runnable));
        builder.setNegativeButton(AbstractC12217eE5.No, (DialogInterface.OnClickListener) null);
        photoViewerInterface.showAlertDialog(builder);
    }

    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView.b
    public boolean a() {
        return !this.u;
    }

    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView.b
    public void b() {
        setColorPickerVisibilityFade(true);
    }

    public void b0() {
        this.j.s();
        this.k.setVisibility(8);
        this.n.setVisibility(8);
        this.J.postRunnable(new a());
    }

    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView.b
    public void c() {
        setColorPickerVisibilityFade(false);
    }

    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView.b
    public boolean d(EntityView entityView) {
        return U(entityView);
    }

    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView.b
    public boolean e(EntityView entityView) {
        Y(entityView);
        return true;
    }

    public ActionBar getActionBar() {
        return this.q;
    }

    public Bitmap getBitmap() {
        Bitmap resultBitmap = this.j.getResultBitmap();
        if (resultBitmap != null && this.k.d() > 0) {
            Canvas canvas = new Canvas(resultBitmap);
            for (int i2 = 0; i2 < this.k.getChildCount(); i2++) {
                View childAt = this.k.getChildAt(i2);
                canvas.save();
                if (childAt instanceof EntityView) {
                    EntityView entityView = (EntityView) childAt;
                    canvas.translate(entityView.getPosition().x, entityView.getPosition().y);
                    canvas.scale(childAt.getScaleX(), childAt.getScaleY());
                    canvas.rotate(childAt.getRotation());
                    canvas.translate((-entityView.getWidth()) / 2, (-entityView.getHeight()) / 2);
                    if (childAt instanceof TextPaintView) {
                        Bitmap bitmapA = AbstractC17261mg0.a(childAt.getWidth(), childAt.getHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapA);
                        childAt.draw(canvas2);
                        canvas.drawBitmap(bitmapA, (Rect) null, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), (Paint) null);
                        try {
                            canvas2.setBitmap(null);
                        } catch (Exception e2) {
                            C19406qI3.d("baleMessages", e2);
                        }
                        bitmapA.recycle();
                    } else {
                        childAt.draw(canvas);
                    }
                }
                canvas.restore();
            }
        }
        return resultBitmap;
    }

    public TextView getCancelTextView() {
        return this.g;
    }

    public ColorPicker getColorPicker() {
        return this.o;
    }

    public TextView getDoneTextView() {
        return this.h;
    }

    public FrameLayout getToolsView() {
        return this.f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float fZ;
        float height;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
        int measuredHeight = this.q.getMeasuredHeight();
        ActionBar actionBar = this.q;
        actionBar.layout(0, 0, actionBar.getMeasuredWidth(), measuredHeight);
        int iZ = (AbstractC7426Rr.C().y - currentActionBarHeight) - AbstractC7426Rr.z(48.0f);
        if (this.a != null) {
            height = Q() ? this.a.getHeight() : this.a.getWidth();
            fZ = Q() ? this.a.getWidth() : this.a.getHeight();
        } else {
            fZ = (i7 - currentActionBarHeight) - AbstractC7426Rr.z(48.0f);
            height = i6;
        }
        float fFloor = i6;
        if (((float) Math.floor((fFloor * fZ) / height)) > iZ) {
            fFloor = (float) Math.floor((r5 * height) / fZ);
        }
        int iCeil = (int) Math.ceil((i6 - this.j.getMeasuredWidth()) / 2);
        int iZ2 = ((((i7 - measuredHeight) - AbstractC7426Rr.z(48.0f)) - this.j.getMeasuredHeight()) / 2) + measuredHeight;
        RenderView renderView = this.j;
        renderView.layout(iCeil, iZ2, renderView.getMeasuredWidth() + iCeil, this.j.getMeasuredHeight() + iZ2);
        float f2 = fFloor / this.D.width;
        this.k.setScaleX(f2);
        this.k.setScaleY(f2);
        EntitiesContainerView entitiesContainerView = this.k;
        entitiesContainerView.layout(iCeil, iZ2, entitiesContainerView.getMeasuredWidth() + iCeil, this.k.getMeasuredHeight() + iZ2);
        FrameLayout frameLayout = this.l;
        frameLayout.layout(0, measuredHeight, frameLayout.getMeasuredWidth(), this.l.getMeasuredHeight() + measuredHeight);
        FrameLayout frameLayout2 = this.n;
        frameLayout2.layout(0, measuredHeight, frameLayout2.getMeasuredWidth(), this.n.getMeasuredHeight() + measuredHeight);
        ColorPicker colorPicker = this.o;
        colorPicker.layout(0, measuredHeight, colorPicker.getMeasuredWidth(), this.o.getMeasuredHeight() + measuredHeight);
        FrameLayout frameLayout3 = this.f;
        frameLayout3.layout(0, i7 - frameLayout3.getMeasuredHeight(), this.f.getMeasuredWidth(), i7);
        this.i.layout(0, 0, i6, iZ);
        EntityView entityView = this.t;
        if (entityView != null) {
            entityView.B();
            this.t.setOffset(this.k.getLeft() - this.n.getLeft(), this.k.getTop() - this.n.getTop());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        float currentActionBarHeight;
        float height;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        this.q.measure(i2, View.MeasureSpec.makeMeasureSpec(size2, RecyclerView.UNDEFINED_DURATION));
        int currentActionBarHeight2 = (AbstractC7426Rr.C().y - ActionBar.getCurrentActionBarHeight()) - AbstractC7426Rr.z(48.0f);
        if (this.a != null) {
            height = Q() ? this.a.getHeight() : this.a.getWidth();
            currentActionBarHeight = Q() ? this.a.getWidth() : this.a.getHeight();
        } else {
            currentActionBarHeight = (size2 - ActionBar.getCurrentActionBarHeight()) - AbstractC7426Rr.z(48.0f);
            height = size;
        }
        float fFloor = size;
        float fFloor2 = (float) Math.floor((fFloor * currentActionBarHeight) / height);
        float f2 = currentActionBarHeight2;
        if (fFloor2 > f2) {
            fFloor = (float) Math.floor((height * f2) / currentActionBarHeight);
            fFloor2 = f2;
        }
        this.j.measure(View.MeasureSpec.makeMeasureSpec((int) fFloor, 1073741824), View.MeasureSpec.makeMeasureSpec((int) fFloor2, 1073741824));
        this.k.measure(View.MeasureSpec.makeMeasureSpec((int) this.D.width, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.D.height, 1073741824));
        this.l.measure(i2, View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, RecyclerView.UNDEFINED_DURATION));
        this.n.measure(i2, View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, 1073741824));
        this.o.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, 1073741824));
        this.f.measure(i2, View.MeasureSpec.makeMeasureSpec(AbstractC7426Rr.z(48.0f), 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getY() <= this.q.getHeight()) {
            return false;
        }
        if (this.t != null) {
            if (this.u) {
                K(true);
            } else {
                U(null);
            }
        }
        return true;
    }
}
