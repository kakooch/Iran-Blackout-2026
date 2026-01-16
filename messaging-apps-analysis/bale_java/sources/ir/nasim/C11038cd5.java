package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.BackgroundPreviewViewGlide;
import ir.nasim.designsystem.TintImageView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: ir.nasim.cd5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C11038cd5 extends C22042ua0 {
    private BackgroundPreviewViewGlide c1;
    private SharedPreferences.Editor d1;
    private String g1;
    private A18 i1;
    private HV1 j1;
    private int e1 = 0;
    int f1 = 90;
    private boolean h1 = false;

    private void aa() {
        File fileJ = X38.j();
        if (fileJ != null) {
            AbstractC5969Lp4.d().b2(fileJ.getAbsolutePath());
            return;
        }
        AbstractC5969Lp4.d().b2("local:" + this.e1);
    }

    public static C11038cd5 ba(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("EXTRA_ID", i);
        C11038cd5 c11038cd5 = new C11038cd5();
        c11038cd5.a8(bundle);
        return c11038cd5;
    }

    private void ca() {
        HV1 hv1 = this.j1;
        if (hv1 != null) {
            hv1.dispose();
            this.j1 = null;
        }
    }

    private Drawable da() {
        File fileJ = X38.j();
        if (fileJ == null) {
            return null;
        }
        return Drawable.createFromPath(fileJ.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer ea() {
        Context contextG5 = G5();
        if (contextG5 == null) {
            return -1;
        }
        return Integer.valueOf(BackgroundPreviewViewGlide.e(AbstractC5969Lp4.d().r2(), contextG5, contextG5.getSharedPreferences("wallpaper", 0).getInt("wallpaper", 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fa(Integer num) {
        this.e1 = num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object ga() {
        A18.c.b(S7(), C22078ud6.a(this.f1), C22078ud6.a(this.f1));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(View.OnClickListener onClickListener, LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams, Object obj) {
        for (int i = 0; i < BackgroundPreviewViewGlide.getSize() + F15.a().size() + 1; i++) {
            if (i != BackgroundPreviewViewGlide.getSize()) {
                Context contextG5 = G5();
                if (contextG5 == null) {
                    return;
                }
                FrameLayout frameLayout = new FrameLayout(contextG5);
                BackgroundPreviewViewGlide backgroundPreviewViewGlide = new BackgroundPreviewViewGlide(contextG5);
                backgroundPreviewViewGlide.f(C22078ud6.a(this.f1), C22078ud6.a(this.f1));
                backgroundPreviewViewGlide.c(i);
                frameLayout.setTag(Integer.valueOf(i));
                frameLayout.setOnClickListener(onClickListener);
                frameLayout.setBackgroundColor(C5495Jo7.a.n());
                frameLayout.addView(backgroundPreviewViewGlide);
                linearLayout.addView(frameLayout, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(View view) {
        Q7().z2().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object ja() {
        A18 a18 = this.i1;
        if (a18 == null) {
            return null;
        }
        a18.b(((E15) F15.a().get((this.e1 - BackgroundPreviewViewGlide.getSize()) - 1)).f());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ka(Object obj) {
        try {
            File fileI = X38.i();
            if (fileI != null) {
                AbstractC5969Lp4.d().b2(new File(fileI.getAbsolutePath(), X38.b(((E15) F15.a().get((this.e1 - BackgroundPreviewViewGlide.getSize()) - 1)).f())).getAbsolutePath());
                Context contextG5 = G5();
                if (contextG5 != null) {
                    AbstractC5963Lo7.c(contextG5);
                }
            }
        } catch (Exception e) {
            C19406qI3.d("PickWallpaperFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void la() {
        SharedPreferences.Editor editorEdit = S7().getSharedPreferences("wallpaper", 0).edit();
        this.d1 = editorEdit;
        editorEdit.putInt("wallpaper", this.e1);
        this.d1.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma(View view) {
        String str;
        if (this.h1 && (str = this.g1) != null && !str.isEmpty()) {
            AbstractC5969Lp4.d().b2(this.g1);
            AbstractC5963Lo7.c(S7());
        } else if (this.e1 == BackgroundPreviewViewGlide.getSize()) {
            aa();
            AbstractC5963Lo7.c(S7());
        } else if (this.e1 > BackgroundPreviewViewGlide.getSize()) {
            SZ.e(new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.bd5
                @Override // ir.nasim.InterfaceC7298Rc6
                public final Object run() {
                    return this.a.ja();
                }
            }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.Rc5
                @Override // ir.nasim.InterfaceC5620Kc6
                public final void onSuccess(Object obj) {
                    this.a.ka(obj);
                }
            }));
        } else {
            AbstractC5969Lp4.d().b2("local:" + this.e1);
            AbstractC5963Lo7.c(S7());
        }
        SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.Sc5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.la();
            }
        })).h(EnumC11723dV1.IO));
        Q7().z2().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void na(Drawable drawable) {
        if (drawable == null || this.c1.getDrawable() != null) {
            return;
        }
        this.c1.setBackGroundWallpaper(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(View view) {
        startActivityForResult(C22055ub3.j(S7(), true, false, false, true), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa(View view) {
        this.h1 = false;
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.e1 = iIntValue;
        qa(iIntValue, C22078ud6.c(), C22078ud6.b());
    }

    private void qa(int i, int i2, int i3) {
        Drawable drawableDa;
        if (i == BackgroundPreviewViewGlide.getSize() && (drawableDa = da()) != null) {
            this.c1.setBackGroundWallpaper(drawableDa);
            return;
        }
        if (i < BackgroundPreviewViewGlide.getSize()) {
            this.c1.setBackGroundWallpaper(b6().getDrawable(BackgroundPreviewViewGlide.d(i)));
            return;
        }
        if (i > BackgroundPreviewViewGlide.getSize()) {
            A18 a18A = A18.c.a(S7(), i2, i3, ((E15) F15.a().get((i - BackgroundPreviewViewGlide.getSize()) - 1)).f());
            this.i1 = a18A;
            if (a18A != null) {
                this.c1.setBackGroundWallpaper(a18A.a());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int i, int i2, Intent intent) throws Throwable {
        Bitmap bitmapE;
        File fileJ;
        if (i == 1 && i2 == -1 && intent != null) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("PHOTOS");
            String absolutePath = null;
            String str = (arrayList == null || arrayList.size() == 0) ? null : (String) arrayList.get(0);
            if (str == null) {
                return;
            }
            try {
                bitmapE = V13.e(str);
            } catch (IOException e) {
                C19406qI3.d("PickWallpaperFragment", e);
            }
            if (bitmapE == null || (fileJ = X38.j()) == null) {
                return;
            }
            absolutePath = fileJ.getAbsolutePath();
            V13.f(bitmapE, absolutePath);
            this.h1 = true;
            this.g1 = absolutePath;
            int iE = BackgroundPreviewViewGlide.e(absolutePath, G5(), BackgroundPreviewViewGlide.getSize());
            this.e1 = iE;
            qa(iE, C22078ud6.c(), C22078ud6.b());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = E5().getInt("EXTRA_ID");
        this.e1 = i;
        if (i == -1) {
            ca();
            this.j1 = SZ.e(new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.Qc5
                @Override // ir.nasim.InterfaceC7298Rc6
                public final Object run() {
                    return this.a.ea();
                }
            }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.Tc5
                @Override // ir.nasim.InterfaceC5620Kc6
                public final void onSuccess(Object obj) {
                    this.a.fa((Integer) obj);
                }
            }));
        }
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_pick_wallpaper, viewGroup, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.o());
        ((TextView) viewInflate.findViewById(BC5.cancel)).setTextColor(c5495Jo7.g0());
        ((TextView) viewInflate.findViewById(BC5.ok)).setTextColor(c5495Jo7.g0());
        ((TextView) viewInflate.findViewById(BC5.cancel)).setBackgroundColor(c5495Jo7.f0());
        ((TextView) viewInflate.findViewById(BC5.ok)).setBackgroundColor(c5495Jo7.f0());
        viewInflate.findViewById(BC5.dividerTop).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
        viewInflate.findViewById(BC5.dividerBot).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
        viewInflate.findViewById(BC5.cancel).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Uc5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ia(view);
            }
        });
        viewInflate.findViewById(BC5.ok).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vc5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ma(view);
            }
        });
        this.c1 = (BackgroundPreviewViewGlide) viewInflate.findViewById(BC5.wallpaper);
        AbstractC5963Lo7.b().j(p6(), new QG4() { // from class: ir.nasim.Wc5
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.na((Drawable) obj);
            }
        });
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(BC5.wallpaper_preview_container);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) viewInflate.findViewById(BC5.container_scrollview);
        final LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(BC5.background_container);
        linearLayout.setBackgroundColor(c5495Jo7.o());
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C22078ud6.a(this.f1), C22078ud6.a(this.f1));
        if (c5495Jo7.J2()) {
            horizontalScrollView.setBackgroundColor(b6().getColor(TA5.color8));
            layoutParams.setMargins(1, 1, 0, 1);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.nasim.Xc5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.oa(view);
            }
        };
        TintImageView tintImageView = new TintImageView(S7());
        tintImageView.setResource(KB5.ic_plus_white_24dp);
        tintImageView.setTint(c5495Jo7.m0());
        tintImageView.setOnClickListener(onClickListener);
        tintImageView.setTag(-1);
        linearLayout2.addView(tintImageView, layoutParams);
        final View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: ir.nasim.Yc5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.pa(view);
            }
        };
        SZ.e(new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.Zc5
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return this.a.ga();
            }
        }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.ad5
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                this.a.ha(onClickListener2, linearLayout2, layoutParams, obj);
            }
        }));
        ((BaleToolbar) viewInflate.findViewById(BC5.pick_wallpaper_toolbar)).setHasBackButton(Q7(), true);
        return viewInflate;
    }
}
