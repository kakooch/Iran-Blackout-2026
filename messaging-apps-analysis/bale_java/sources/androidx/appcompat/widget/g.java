package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.u;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC20545sB5;
import ir.nasim.AbstractC9594aE;
import ir.nasim.HA5;
import ir.nasim.QY0;
import ir.nasim.YA5;

/* loaded from: classes.dex */
public final class g {
    private static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    private static g c;
    private u a;

    class a implements u.c {
        private final int[] a = {AbstractC20545sB5.abc_textfield_search_default_mtrl_alpha, AbstractC20545sB5.abc_textfield_default_mtrl_alpha, AbstractC20545sB5.abc_ab_share_pack_mtrl_alpha};
        private final int[] b = {AbstractC20545sB5.abc_ic_commit_search_api_mtrl_alpha, AbstractC20545sB5.abc_seekbar_tick_mark_material, AbstractC20545sB5.abc_ic_menu_share_mtrl_alpha, AbstractC20545sB5.abc_ic_menu_copy_mtrl_am_alpha, AbstractC20545sB5.abc_ic_menu_cut_mtrl_alpha, AbstractC20545sB5.abc_ic_menu_selectall_mtrl_alpha, AbstractC20545sB5.abc_ic_menu_paste_mtrl_am_alpha};
        private final int[] c = {AbstractC20545sB5.abc_textfield_activated_mtrl_alpha, AbstractC20545sB5.abc_textfield_search_activated_mtrl_alpha, AbstractC20545sB5.abc_cab_background_top_mtrl_alpha, AbstractC20545sB5.abc_text_cursor_material, AbstractC20545sB5.abc_text_select_handle_left_mtrl, AbstractC20545sB5.abc_text_select_handle_middle_mtrl, AbstractC20545sB5.abc_text_select_handle_right_mtrl};
        private final int[] d = {AbstractC20545sB5.abc_popup_background_mtrl_mult, AbstractC20545sB5.abc_cab_background_internal_bg, AbstractC20545sB5.abc_menu_hardkey_panel_mtrl_mult};
        private final int[] e = {AbstractC20545sB5.abc_tab_indicator_material, AbstractC20545sB5.abc_textfield_search_material};
        private final int[] f = {AbstractC20545sB5.abc_btn_check_material, AbstractC20545sB5.abc_btn_radio_material, AbstractC20545sB5.abc_btn_check_material_anim, AbstractC20545sB5.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i) {
            int iC = y.c(context, AbstractC15790kA5.colorControlHighlight);
            return new ColorStateList(new int[][]{y.b, y.e, y.c, y.i}, new int[]{y.b(context, AbstractC15790kA5.colorButtonNormal), QY0.g(iC, i), QY0.g(iC, i), i});
        }

        private ColorStateList i(Context context) {
            return h(context, y.c(context, AbstractC15790kA5.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, y.c(context, AbstractC15790kA5.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = y.e(context, AbstractC15790kA5.colorSwitchThumbNormal);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = y.b;
                iArr2[0] = y.b(context, AbstractC15790kA5.colorSwitchThumbNormal);
                iArr[1] = y.f;
                iArr2[1] = y.c(context, AbstractC15790kA5.colorControlActivated);
                iArr[2] = y.i;
                iArr2[2] = y.c(context, AbstractC15790kA5.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = y.b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = y.f;
                iArr2[1] = y.c(context, AbstractC15790kA5.colorControlActivated);
                iArr[2] = y.i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(u uVar, Context context, int i) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawableI = uVar.i(context, AbstractC20545sB5.abc_star_black_48dp);
            Drawable drawableI2 = uVar.i(context, AbstractC20545sB5.abc_star_half_black_48dp);
            if ((drawableI instanceof BitmapDrawable) && drawableI.getIntrinsicWidth() == dimensionPixelSize && drawableI.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableI;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableI.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableI2 instanceof BitmapDrawable) && drawableI2.getIntrinsicWidth() == dimensionPixelSize && drawableI2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableI2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableI2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (r.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = g.b;
            }
            drawable.setColorFilter(g.e(i, mode));
        }

        @Override // androidx.appcompat.widget.u.c
        public Drawable a(u uVar, Context context, int i) {
            if (i == AbstractC20545sB5.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{uVar.i(context, AbstractC20545sB5.abc_cab_background_internal_bg), uVar.i(context, AbstractC20545sB5.abc_cab_background_top_mtrl_alpha)});
            }
            if (i == AbstractC20545sB5.abc_ratingbar_material) {
                return l(uVar, context, YA5.abc_star_big);
            }
            if (i == AbstractC20545sB5.abc_ratingbar_indicator_material) {
                return l(uVar, context, YA5.abc_star_medium);
            }
            if (i == AbstractC20545sB5.abc_ratingbar_small_material) {
                return l(uVar, context, YA5.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.u.c
        public ColorStateList b(Context context, int i) {
            if (i == AbstractC20545sB5.abc_edit_text_material) {
                return AbstractC9594aE.a(context, HA5.abc_tint_edittext);
            }
            if (i == AbstractC20545sB5.abc_switch_track_mtrl_alpha) {
                return AbstractC9594aE.a(context, HA5.abc_tint_switch_track);
            }
            if (i == AbstractC20545sB5.abc_switch_thumb_material) {
                return k(context);
            }
            if (i == AbstractC20545sB5.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i == AbstractC20545sB5.abc_btn_borderless_material) {
                return g(context);
            }
            if (i == AbstractC20545sB5.abc_btn_colored_material) {
                return i(context);
            }
            if (i == AbstractC20545sB5.abc_spinner_mtrl_am_alpha || i == AbstractC20545sB5.abc_spinner_textfield_background_material) {
                return AbstractC9594aE.a(context, HA5.abc_tint_spinner);
            }
            if (f(this.b, i)) {
                return y.e(context, AbstractC15790kA5.colorControlNormal);
            }
            if (f(this.e, i)) {
                return AbstractC9594aE.a(context, HA5.abc_tint_default);
            }
            if (f(this.f, i)) {
                return AbstractC9594aE.a(context, HA5.abc_tint_btn_checkable);
            }
            if (i == AbstractC20545sB5.abc_seekbar_thumb_material) {
                return AbstractC9594aE.a(context, HA5.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[RETURN] */
        @Override // androidx.appcompat.widget.u.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
            /*
                r7 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.g.a()
                int[] r1 = r7.a
                boolean r1 = r7.f(r1, r9)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r9 = ir.nasim.AbstractC15790kA5.colorControlNormal
            L11:
                r1 = r0
                r5 = r2
            L13:
                r0 = r4
                goto L4f
            L15:
                int[] r1 = r7.c
                boolean r1 = r7.f(r1, r9)
                if (r1 == 0) goto L20
                int r9 = ir.nasim.AbstractC15790kA5.colorControlActivated
                goto L11
            L20:
                int[] r1 = r7.d
                boolean r1 = r7.f(r1, r9)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r0 = r4
                r9 = r5
                r5 = r2
                goto L4f
            L32:
                int r1 = ir.nasim.AbstractC20545sB5.abc_list_divider_mtrl_alpha
                if (r9 != r1) goto L46
                r9 = 1109603123(0x42233333, float:40.8)
                int r9 = java.lang.Math.round(r9)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r5 = r2
                r6 = r0
                r0 = r9
                r9 = r1
                r1 = r6
                goto L4f
            L46:
                int r1 = ir.nasim.AbstractC20545sB5.abc_dialog_material_background
                if (r9 != r1) goto L4b
                goto L2d
            L4b:
                r1 = r0
                r9 = r3
                r5 = r9
                goto L13
            L4f:
                if (r5 == 0) goto L6c
                boolean r3 = androidx.appcompat.widget.r.a(r10)
                if (r3 == 0) goto L5b
                android.graphics.drawable.Drawable r10 = r10.mutate()
            L5b:
                int r8 = androidx.appcompat.widget.y.c(r8, r9)
                android.graphics.PorterDuffColorFilter r8 = androidx.appcompat.widget.g.e(r8, r1)
                r10.setColorFilter(r8)
                if (r0 == r4) goto L6b
                r10.setAlpha(r0)
            L6b:
                return r2
            L6c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g.a.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.u.c
        public PorterDuff.Mode d(int i) {
            if (i == AbstractC20545sB5.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.u.c
        public boolean e(Context context, int i, Drawable drawable) {
            if (i == AbstractC20545sB5.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), y.c(context, AbstractC15790kA5.colorControlNormal), g.b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), y.c(context, AbstractC15790kA5.colorControlNormal), g.b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), y.c(context, AbstractC15790kA5.colorControlActivated), g.b);
                return true;
            }
            if (i != AbstractC20545sB5.abc_ratingbar_material && i != AbstractC20545sB5.abc_ratingbar_indicator_material && i != AbstractC20545sB5.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), y.b(context, AbstractC15790kA5.colorControlNormal), g.b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), y.c(context, AbstractC15790kA5.colorControlActivated), g.b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), y.c(context, AbstractC15790kA5.colorControlActivated), g.b);
            return true;
        }
    }

    public static synchronized g b() {
        try {
            if (c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        return u.k(i, mode);
    }

    public static synchronized void h() {
        if (c == null) {
            g gVar = new g();
            c = gVar;
            gVar.a = u.g();
            c.a.t(new a());
        }
    }

    static void i(Drawable drawable, A a2, int[] iArr) {
        u.v(drawable, a2, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.a.i(context, i);
    }

    synchronized Drawable d(Context context, int i, boolean z) {
        return this.a.j(context, i, z);
    }

    synchronized ColorStateList f(Context context, int i) {
        return this.a.l(context, i);
    }

    public synchronized void g(Context context) {
        this.a.r(context);
    }
}
