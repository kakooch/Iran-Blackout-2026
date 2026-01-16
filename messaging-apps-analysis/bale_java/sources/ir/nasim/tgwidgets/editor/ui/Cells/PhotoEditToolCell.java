package ir.nasim.tgwidgets.editor.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoEditorSeekBar;

/* loaded from: classes7.dex */
public class PhotoEditToolCell extends FrameLayout {
    private final m.h a;
    private TextView b;
    private TextView c;
    private PhotoEditorSeekBar d;
    private AnimatorSet e;
    private Runnable f;

    class a implements Runnable {

        /* renamed from: ir.nasim.tgwidgets.editor.ui.Cells.PhotoEditToolCell$a$a, reason: collision with other inner class name */
        class C1583a extends AnimatorListenerAdapter {
            C1583a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(PhotoEditToolCell.this.e)) {
                    PhotoEditToolCell.this.e = null;
                }
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoEditToolCell.this.c.setTag(null);
            PhotoEditToolCell.this.e = new AnimatorSet();
            AnimatorSet animatorSet = PhotoEditToolCell.this.e;
            TextView textView = PhotoEditToolCell.this.c;
            Property property = View.ALPHA;
            animatorSet.playTogether(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, 0.0f), ObjectAnimator.ofFloat(PhotoEditToolCell.this.b, (Property<TextView, Float>) property, 1.0f));
            PhotoEditToolCell.this.e.setDuration(250L);
            PhotoEditToolCell.this.e.setInterpolator(new DecelerateInterpolator());
            PhotoEditToolCell.this.e.addListener(new C1583a());
            PhotoEditToolCell.this.e.start();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC21455b.n1(PhotoEditToolCell.this.f, 1000L);
        }
    }

    public PhotoEditToolCell(Context context, m.h hVar) {
        super(context);
        this.f = new a();
        this.a = hVar;
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setGravity(5);
        this.b.setTextColor(-1);
        this.b.setTextSize(1, 12.0f);
        this.b.setMaxLines(1);
        this.b.setSingleLine(true);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.b, AbstractC13840gu3.c(80, -2.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.c = textView2;
        textView2.setTextColor(g(m.F4));
        this.c.setTextSize(1, 12.0f);
        this.c.setGravity(5);
        this.c.setSingleLine(true);
        addView(this.c, AbstractC13840gu3.c(80, -2.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        PhotoEditorSeekBar photoEditorSeekBar = new PhotoEditorSeekBar(context);
        this.d = photoEditorSeekBar;
        addView(photoEditorSeekBar, AbstractC13840gu3.c(-1, 40.0f, 19, 96.0f, 0.0f, 24.0f, 0.0f));
    }

    private int g(int i) {
        return m.j0(i, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(PhotoEditorSeekBar.a aVar, int i, int i2) {
        aVar.a(i, i2);
        if (i2 > 0) {
            this.c.setText("+" + i2);
        } else {
            this.c.setText("" + i2);
        }
        if (this.c.getTag() != null) {
            AbstractC21455b.t(this.f);
            AbstractC21455b.n1(this.f, 1000L);
            return;
        }
        AnimatorSet animatorSet = this.e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.c.setTag(1);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.e = animatorSet2;
        TextView textView = this.c;
        Property property = View.ALPHA;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<TextView, Float>) property, 0.0f));
        this.e.setDuration(250L);
        this.e.setInterpolator(new DecelerateInterpolator());
        this.e.addListener(new b());
        this.e.start();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(40.0f), 1073741824));
    }

    public void setIconAndTextAndValue(String str, float f, int i, int i2) {
        AnimatorSet animatorSet = this.e;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.e = null;
        }
        AbstractC21455b.t(this.f);
        this.c.setTag(null);
        this.b.setText(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
        if (f > 0.0f) {
            this.c.setText("+" + ((int) f));
        } else {
            this.c.setText("" + ((int) f));
        }
        this.c.setAlpha(0.0f);
        this.b.setAlpha(1.0f);
        this.d.setMinMax(i, i2);
        this.d.setProgress((int) f, false);
    }

    public void setSeekBarDelegate(final PhotoEditorSeekBar.a aVar) {
        this.d.setDelegate(new PhotoEditorSeekBar.a() { // from class: ir.nasim.t85
            @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoEditorSeekBar.a
            public final void a(int i, int i2) {
                this.a.h(aVar, i, i2);
            }
        });
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        this.d.setTag(obj);
    }
}
