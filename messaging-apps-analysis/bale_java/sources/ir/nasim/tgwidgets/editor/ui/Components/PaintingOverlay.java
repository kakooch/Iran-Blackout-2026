package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.C24687z23;
import ir.nasim.C4278El2;
import ir.nasim.FH3;
import ir.nasim.R62;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EditTextOutline;
import ir.nasim.tgwidgets.editor.ui.Components.PaintingOverlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class PaintingOverlay extends FrameLayout {
    private Bitmap a;
    private HashMap b;
    private boolean c;
    private Drawable d;

    class a extends EditTextOutline {
        a(Context context) {
            super(context);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }
    }

    public PaintingOverlay(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        RLottieDrawable rLottieDrawableJ;
        if (!z || z2 || (rLottieDrawableJ = imageReceiver.J()) == null) {
            return;
        }
        rLottieDrawableJ.start();
    }

    public void b() {
        setBackground(null);
    }

    public void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setVisibility(4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void e() {
        this.a = null;
        this.d = null;
        setBackground(null);
        HashMap map = this.b;
        if (map != null) {
            map.clear();
        }
        removeAllViews();
    }

    public void f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setVisibility(0);
        }
        setBackground(this.d);
    }

    public Bitmap getBitmap() {
        return this.a;
    }

    public Bitmap getThumb() {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float fMax = Math.max(measuredWidth / AbstractC21455b.F(120.0f), measuredHeight / AbstractC21455b.F(120.0f));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (measuredWidth / fMax), (int) (measuredHeight / fMax), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = 1.0f / fMax;
        canvas.scale(f, f);
        draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        if (this.b != null) {
            int measuredWidth2 = getMeasuredWidth();
            int measuredHeight2 = getMeasuredHeight();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                H.b bVar = (H.b) this.b.get(childAt);
                if (bVar != null) {
                    if (childAt instanceof EditTextOutline) {
                        measuredWidth = ((int) (measuredWidth2 * bVar.t)) - (childAt.getMeasuredWidth() / 2);
                        measuredHeight = ((int) (measuredHeight2 * bVar.u)) - (childAt.getMeasuredHeight() / 2);
                    } else {
                        measuredWidth = (int) (measuredWidth2 * bVar.c);
                        measuredHeight = (int) (measuredHeight2 * bVar.d);
                    }
                    childAt.layout(measuredWidth, measuredHeight, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.c = true;
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.b != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                H.b bVar = (H.b) this.b.get(childAt);
                if (bVar != null) {
                    if (childAt instanceof EditTextOutline) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(bVar.n, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                        float f = (bVar.r * measuredWidth) / bVar.n;
                        childAt.setScaleX(bVar.q * f);
                        childAt.setScaleY(bVar.q * f);
                    } else {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * bVar.f), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (measuredHeight * bVar.g), 1073741824));
                    }
                }
            }
        }
        this.c = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.c) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setAlpha((int) (255.0f * f));
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && childAt.getParent() == this) {
                childAt.setAlpha(f);
            }
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.a = bitmap;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        this.d = bitmapDrawable;
        setBackground(bitmapDrawable);
    }

    public void setData(String str, ArrayList<H.b> arrayList, boolean z, boolean z2) {
        setEntities(arrayList, z, z2);
        if (str == null) {
            this.a = null;
            this.d = null;
            setBackground(null);
        } else {
            this.a = BitmapFactory.decodeFile(str);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a);
            this.d = bitmapDrawable;
            setBackground(bitmapDrawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, android.widget.TextView, ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EditTextOutline, ir.nasim.tgwidgets.editor.ui.Components.PaintingOverlay$a] */
    public void setEntities(ArrayList<H.b> arrayList, boolean z, boolean z2) {
        BackupImageView backupImageView;
        int i;
        e();
        this.b = new HashMap();
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            H.b bVar = arrayList.get(i2);
            byte b = bVar.a;
            if (b == 0) {
                BackupImageView backupImageView2 = new BackupImageView(getContext());
                backupImageView2.setLayerNum(8);
                backupImageView2.setAspectFit(true);
                ImageReceiver imageReceiver = backupImageView2.getImageReceiver();
                if (z) {
                    imageReceiver.u0(true);
                    imageReceiver.x0(false);
                    if (z2) {
                        imageReceiver.H0(new ImageReceiver.c() { // from class: ir.nasim.UV4
                            @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver.c
                            public final void a(ImageReceiver imageReceiver2, boolean z3, boolean z4, boolean z5) {
                                PaintingOverlay.d(imageReceiver2, z3, z4, z5);
                            }
                        });
                    }
                }
                imageReceiver.T0(C24687z23.b(bVar.v), null, C24687z23.c(C4278El2.y(bVar.v.k, 90), bVar.v), null, "webp", bVar.w, 1);
                if ((2 & bVar.b) != 0) {
                    backupImageView2.setScaleX(-1.0f);
                }
                bVar.C = backupImageView2;
                backupImageView = backupImageView2;
            } else if (b == 1) {
                ?? aVar = new a(getContext());
                aVar.setBackgroundColor(0);
                aVar.setPadding(AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f));
                aVar.setTextSize(0, bVar.k);
                aVar.setTypeface(bVar.l.q());
                SpannableString spannableString = new SpannableString(R62.S(bVar.h, aVar.getPaint().getFontMetricsInt(), (int) (aVar.getTextSize() * 0.8f), false));
                Iterator it = bVar.i.iterator();
                while (it.hasNext()) {
                    H.a aVar2 = (H.a) it.next();
                    AnimatedEmojiSpan animatedEmojiSpan = new AnimatedEmojiSpan(aVar2.f, aVar.getPaint().getFontMetricsInt());
                    int i3 = aVar2.b;
                    spannableString.setSpan(animatedEmojiSpan, i3, aVar2.c + i3, 33);
                }
                aVar.setText(spannableString);
                aVar.setGravity(17);
                int i4 = bVar.m;
                aVar.setGravity(i4 != 1 ? i4 != 2 ? 19 : 21 : 17);
                int i5 = bVar.m;
                if (i5 != 1) {
                    i = 3;
                    if (i5 == 2 ? FH3.D : !FH3.D) {
                        i = 2;
                    }
                } else {
                    i = 4;
                }
                aVar.setTextAlignment(i);
                aVar.setHorizontallyScrolling(false);
                aVar.setImeOptions(268435456);
                aVar.setFocusableInTouchMode(true);
                aVar.setEnabled(false);
                aVar.setInputType(aVar.getInputType() | 16384);
                aVar.setBreakStrategy(0);
                aVar.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                int i6 = bVar.j;
                byte b2 = bVar.b;
                if (b2 == 0) {
                    aVar.setFrameColor(i6);
                    i6 = AbstractC21455b.z(bVar.j) >= 0.721f ? -16777216 : -1;
                } else if (b2 == 1) {
                    aVar.setFrameColor(AbstractC21455b.z(i6) >= 0.25f ? -1728053248 : -1711276033);
                } else if (b2 == 2) {
                    aVar.setFrameColor(AbstractC21455b.z(i6) >= 0.25f ? -16777216 : -1);
                } else {
                    aVar.setFrameColor(0);
                }
                aVar.setTextColor(i6);
                aVar.setCursorColor(i6);
                aVar.setHandlesColor(i6);
                aVar.setHighlightColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Q0(i6, 0.4f));
                bVar.C = aVar;
                backupImageView = aVar;
            } else {
                backupImageView = null;
            }
            if (backupImageView != null) {
                addView(backupImageView);
                backupImageView.setRotation((float) (((-bVar.e) / 3.141592653589793d) * 180.0d));
                this.b.put(backupImageView, bVar);
            }
        }
    }
}
