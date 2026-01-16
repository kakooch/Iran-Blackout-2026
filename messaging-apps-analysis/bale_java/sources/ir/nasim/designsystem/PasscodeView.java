package ir.nasim.designsystem;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9160Yt;
import ir.nasim.C19406qI3;
import ir.nasim.C22078ud6;
import ir.nasim.C23073wI7;
import ir.nasim.C23381wp3;
import ir.nasim.C4071Do2;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.QE0;
import ir.nasim.XY6;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes5.dex */
public class PasscodeView extends FrameLayout {
    private Drawable a;
    private FrameLayout b;
    private ArrayList c;
    private ArrayList d;
    private ArrayList e;
    private FrameLayout f;
    private ImageView g;
    private EditText h;
    private m i;
    private FrameLayout j;
    private TextView k;
    private ImageView l;
    private int m;
    private QE0 n;
    private boolean o;
    private Rect p;
    private n q;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PasscodeView.this.h != null) {
                PasscodeView.this.h.requestFocus();
                C23381wp3.g(PasscodeView.this.h);
            }
        }
    }

    class b extends C4071Do2.b {
        b() {
        }

        @Override // ir.nasim.C4071Do2.b
        public void a(CharSequence charSequence) {
            if (PasscodeView.this.o) {
                return;
            }
            PasscodeView.this.s(charSequence.toString());
        }

        @Override // ir.nasim.C4071Do2.b
        public void b() {
            PasscodeView.this.m();
        }

        @Override // ir.nasim.C4071Do2.b
        public void c() {
            try {
                if (PasscodeView.this.n != null) {
                    PasscodeView.this.o = true;
                    PasscodeView.this.n.a();
                    PasscodeView.this.n = null;
                }
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
            PasscodeView.this.q(true);
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            PasscodeView.this.q(false);
            return true;
        }
    }

    class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (PasscodeView.this.h.length() == 6 && C23073wI7.d == 0) {
                PasscodeView.this.q(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class f implements ActionMode.Callback {
        f() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PasscodeView.this.q(false);
        }
    }

    class h implements View.OnLongClickListener {
        h() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PasscodeView.this.h.setText("");
            PasscodeView.this.i.h(true);
            return true;
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ boolean a;
        final /* synthetic */ char[] b;

        i(boolean z, char[] cArr) {
            this.a = z;
            this.b = cArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (((Integer) view.getTag()).intValue()) {
                case 0:
                    if (!this.a) {
                        PasscodeView.this.i.g("0");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[0]));
                        break;
                    }
                case 1:
                    if (!this.a) {
                        PasscodeView.this.i.g("1");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[1]));
                        break;
                    }
                case 2:
                    if (!this.a) {
                        PasscodeView.this.i.g("2");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[2]));
                        break;
                    }
                case 3:
                    if (!this.a) {
                        PasscodeView.this.i.g("3");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[3]));
                        break;
                    }
                case 4:
                    if (!this.a) {
                        PasscodeView.this.i.g("4");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[4]));
                        break;
                    }
                case 5:
                    if (!this.a) {
                        PasscodeView.this.i.g("5");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[5]));
                        break;
                    }
                case 6:
                    if (!this.a) {
                        PasscodeView.this.i.g("6");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[6]));
                        break;
                    }
                case 7:
                    if (!this.a) {
                        PasscodeView.this.i.g("7");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[7]));
                        break;
                    }
                case 8:
                    if (!this.a) {
                        PasscodeView.this.i.g("8");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[8]));
                        break;
                    }
                case 9:
                    if (!this.a) {
                        PasscodeView.this.i.g("9");
                        break;
                    } else {
                        PasscodeView.this.i.g(String.valueOf(this.b[9]));
                        break;
                    }
                case 10:
                    PasscodeView.this.i.i();
                    break;
            }
            if (PasscodeView.this.i.l() == 6) {
                PasscodeView.this.q(false);
            }
        }
    }

    class j extends AbstractC9160Yt {
        j() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PasscodeView.this.setVisibility(8);
        }
    }

    class k extends AbstractC9160Yt {
        final /* synthetic */ int a;
        final /* synthetic */ float b;

        k(int i, float f) {
            this.a = i;
            this.b = f;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PasscodeView passcodeView = PasscodeView.this;
            int i = this.a;
            passcodeView.r(i == 5 ? 0.0f : -this.b, i + 1);
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PasscodeView.this.k != null) {
                PasscodeView.this.k.setText(AbstractC12217eE5.EnterPasscodeOrTouchFingerScanner);
            }
        }
    }

    private class m extends FrameLayout {
        private ArrayList a;
        private ArrayList b;
        private StringBuilder c;
        private String d;
        private AnimatorSet e;
        private Runnable f;

        class a implements Runnable {
            final /* synthetic */ int a;

            /* renamed from: ir.nasim.designsystem.PasscodeView$m$a$a, reason: collision with other inner class name */
            class C1019a extends AbstractC9160Yt {
                C1019a() {
                }

                @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.e == null || !m.this.e.equals(animator)) {
                        return;
                    }
                    m.this.e = null;
                }
            }

            a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f != this) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                TextView textView = (TextView) m.this.a.get(this.a);
                arrayList.add(ObjectAnimator.ofFloat(textView, "scaleX", 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView, "scaleY", 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView, "alpha", 0.0f));
                TextView textView2 = (TextView) m.this.b.get(this.a);
                arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleX", 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleY", 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView2, "alpha", 1.0f));
                m.this.e = new AnimatorSet();
                m.this.e.setDuration(150L);
                m.this.e.playTogether(arrayList);
                m.this.e.addListener(new C1019a());
                m.this.e.start();
            }
        }

        class b extends AbstractC9160Yt {
            b() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (m.this.e == null || !m.this.e.equals(animator)) {
                    return;
                }
                m.this.e = null;
            }
        }

        class c extends AbstractC9160Yt {
            c() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (m.this.e == null || !m.this.e.equals(animator)) {
                    return;
                }
                m.this.e = null;
            }
        }

        class d extends AbstractC9160Yt {
            d() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (m.this.e == null || !m.this.e.equals(animator)) {
                    return;
                }
                m.this.e = null;
            }
        }

        public m(Context context) {
            super(context);
            this.d = "•";
            this.a = new ArrayList(6);
            this.b = new ArrayList(6);
            this.c = new StringBuilder(6);
            for (int i = 0; i < 6; i++) {
                TextView textView = new TextView(context);
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                textView.setTextColor(c5495Jo7.f0());
                textView.setTextSize(1, 36.0f);
                textView.setGravity(17);
                textView.setAlpha(0.0f);
                textView.setPivotX(C22078ud6.a(25.0f));
                textView.setPivotY(C22078ud6.a(25.0f));
                addView(textView);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.width = C22078ud6.a(50.0f);
                layoutParams.height = C22078ud6.a(50.0f);
                layoutParams.gravity = 51;
                textView.setLayoutParams(layoutParams);
                this.a.add(textView);
                TextView textView2 = new TextView(context);
                textView2.setTextColor(c5495Jo7.f0());
                textView2.setTextSize(1, 36.0f);
                textView2.setGravity(17);
                textView2.setAlpha(0.0f);
                textView2.setText(this.d);
                textView2.setPivotX(C22078ud6.a(25.0f));
                textView2.setPivotY(C22078ud6.a(25.0f));
                addView(textView2);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams2.width = C22078ud6.a(50.0f);
                layoutParams2.height = C22078ud6.a(50.0f);
                layoutParams2.gravity = 51;
                textView2.setLayoutParams(layoutParams2);
                this.b.add(textView2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(boolean z) {
            if (this.c.length() == 0) {
                return;
            }
            Runnable runnable = this.f;
            if (runnable != null) {
                AbstractC7426Rr.w(runnable);
                this.f = null;
            }
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.e = null;
            }
            StringBuilder sb = this.c;
            sb.delete(0, sb.length());
            if (!z) {
                for (int i = 0; i < 6; i++) {
                    ((TextView) this.a.get(i)).setAlpha(0.0f);
                    ((TextView) this.b.get(i)).setAlpha(0.0f);
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 6; i2++) {
                TextView textView = (TextView) this.a.get(i2);
                if (textView.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView, "scaleX", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, "scaleY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, "alpha", 0.0f));
                }
                TextView textView2 = (TextView) this.b.get(i2);
                if (textView2.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleX", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "alpha", 0.0f));
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.e = animatorSet2;
            animatorSet2.setDuration(150L);
            this.e.playTogether(arrayList);
            this.e.addListener(new d());
            this.e.start();
        }

        private int k(int i) {
            return (((getMeasuredWidth() - (this.c.length() * C22078ud6.a(30.0f))) / 2) + (i * C22078ud6.a(30.0f))) - C22078ud6.a(10.0f);
        }

        public void g(String str) {
            if (this.c.length() == 6) {
                return;
            }
            try {
                performHapticFeedback(3);
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
            ArrayList arrayList = new ArrayList();
            int length = this.c.length();
            this.c.append(str);
            TextView textView = (TextView) this.a.get(length);
            textView.setText(str);
            textView.setTranslationX(k(length));
            arrayList.add(ObjectAnimator.ofFloat(textView, "scaleX", 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, "scaleY", 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, "translationY", C22078ud6.a(20.0f), 0.0f));
            TextView textView2 = (TextView) this.b.get(length);
            textView2.setTranslationX(k(length));
            textView2.setAlpha(0.0f);
            arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleX", 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleY", 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView2, "translationY", C22078ud6.a(20.0f), 0.0f));
            for (int i = length + 1; i < 6; i++) {
                TextView textView3 = (TextView) this.a.get(i);
                if (textView3.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView3, "scaleX", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView3, "scaleY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView3, "alpha", 0.0f));
                }
                TextView textView4 = (TextView) this.b.get(i);
                if (textView4.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView4, "scaleX", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView4, "scaleY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView4, "alpha", 0.0f));
                }
            }
            Runnable runnable = this.f;
            if (runnable != null) {
                AbstractC7426Rr.w(runnable);
            }
            a aVar = new a(length);
            this.f = aVar;
            AbstractC7426Rr.Q(aVar, 1500L);
            for (int i2 = 0; i2 < length; i2++) {
                TextView textView5 = (TextView) this.a.get(i2);
                arrayList.add(ObjectAnimator.ofFloat(textView5, "translationX", k(i2)));
                arrayList.add(ObjectAnimator.ofFloat(textView5, "scaleX", 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView5, "scaleY", 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView5, "alpha", 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView5, "translationY", 0.0f));
                TextView textView6 = (TextView) this.b.get(i2);
                arrayList.add(ObjectAnimator.ofFloat(textView6, "translationX", k(i2)));
                arrayList.add(ObjectAnimator.ofFloat(textView6, "scaleX", 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView6, "scaleY", 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView6, "alpha", 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView6, "translationY", 0.0f));
            }
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.e = animatorSet2;
            animatorSet2.setDuration(150L);
            this.e.playTogether(arrayList);
            this.e.addListener(new b());
            this.e.start();
        }

        public void i() {
            if (this.c.length() == 0) {
                return;
            }
            try {
                performHapticFeedback(3);
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
            ArrayList arrayList = new ArrayList();
            int length = this.c.length() - 1;
            if (length != 0) {
                this.c.deleteCharAt(length);
            }
            for (int i = length; i < 6; i++) {
                TextView textView = (TextView) this.a.get(i);
                if (textView.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView, "scaleX", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, "scaleY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, "alpha", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, "translationY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, "translationX", k(i)));
                }
                TextView textView2 = (TextView) this.b.get(i);
                if (textView2.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleX", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "scaleY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "alpha", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "translationY", 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, "translationX", k(i)));
                }
            }
            if (length == 0) {
                this.c.deleteCharAt(length);
            }
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(ObjectAnimator.ofFloat((TextView) this.a.get(i2), "translationX", k(i2)));
                arrayList.add(ObjectAnimator.ofFloat((TextView) this.b.get(i2), "translationX", k(i2)));
            }
            Runnable runnable = this.f;
            if (runnable != null) {
                AbstractC7426Rr.w(runnable);
                this.f = null;
            }
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.e = animatorSet2;
            animatorSet2.setDuration(150L);
            this.e.playTogether(arrayList);
            this.e.addListener(new c());
            this.e.start();
        }

        public String j() {
            return this.c.toString();
        }

        public int l() {
            return this.c.length();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Runnable runnable = this.f;
            if (runnable != null) {
                AbstractC7426Rr.w(runnable);
                this.f = null;
            }
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.e = null;
            }
            for (int i5 = 0; i5 < 6; i5++) {
                if (i5 < this.c.length()) {
                    TextView textView = (TextView) this.a.get(i5);
                    textView.setAlpha(0.0f);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setTranslationY(0.0f);
                    textView.setTranslationX(k(i5));
                    TextView textView2 = (TextView) this.b.get(i5);
                    textView2.setAlpha(1.0f);
                    textView2.setScaleX(1.0f);
                    textView2.setScaleY(1.0f);
                    textView2.setTranslationY(0.0f);
                    textView2.setTranslationX(k(i5));
                } else {
                    ((TextView) this.a.get(i5)).setAlpha(0.0f);
                    ((TextView) this.b.get(i5)).setAlpha(0.0f);
                }
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public interface n {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasscodeView(Context context) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context);
        this.m = 0;
        this.p = new Rect();
        setWillNotDraw(false);
        setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        this.j = frameLayout;
        addView(frameLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.j.setLayoutParams(layoutParams);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f = frameLayout2;
        addView(frameLayout2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.gravity = 51;
        this.f.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(KB5.ic_bale);
        this.f.addView(imageView);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        if (C22078ud6.c < 1.0f) {
            layoutParams3.width = C22078ud6.a(30.0f);
            layoutParams3.height = C22078ud6.a(30.0f);
        } else {
            layoutParams3.width = C22078ud6.a(40.0f);
            layoutParams3.height = C22078ud6.a(40.0f);
        }
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = C22078ud6.a(100.0f);
        imageView.setLayoutParams(layoutParams3);
        TextView textView = new TextView(context);
        this.k = textView;
        textView.setTypeface(C6011Lu2.k());
        TextView textView2 = this.k;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.f0());
        this.k.setTextSize(1, 14.0f);
        this.k.setGravity(1);
        this.f.addView(this.k);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams4.width = -2;
        layoutParams4.height = -2;
        layoutParams4.bottomMargin = C22078ud6.a(62.0f);
        layoutParams4.gravity = 81;
        this.k.setLayoutParams(layoutParams4);
        m mVar = new m(context);
        this.i = mVar;
        this.f.addView(mVar);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams5.height = -2;
        layoutParams5.width = -1;
        layoutParams5.leftMargin = C22078ud6.a(70.0f);
        layoutParams5.rightMargin = C22078ud6.a(70.0f);
        layoutParams5.bottomMargin = C22078ud6.a(6.0f);
        layoutParams5.gravity = 81;
        this.i.setLayoutParams(layoutParams5);
        EditText editText = new EditText(context);
        this.h = editText;
        float f2 = 36.0f;
        editText.setTextSize(1, 36.0f);
        this.h.setTextColor(c5495Jo7.f0());
        this.h.setMaxLines(1);
        this.h.setLines(1);
        this.h.setGravity(1);
        this.h.setSingleLine(true);
        this.h.setImeOptions(6);
        this.h.setTypeface(Typeface.DEFAULT);
        this.h.setBackgroundDrawable(null);
        AbstractC7426Rr.x(this.h);
        this.f.addView(this.h);
        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams6.height = -2;
        layoutParams6.width = -1;
        layoutParams6.leftMargin = C22078ud6.a(70.0f);
        layoutParams6.rightMargin = C22078ud6.a(70.0f);
        layoutParams6.bottomMargin = C22078ud6.a(6.0f);
        layoutParams6.gravity = 81;
        this.h.setLayoutParams(layoutParams6);
        this.h.setOnEditorActionListener(new d());
        this.h.addTextChangedListener(new e());
        this.h.setCustomSelectionActionModeCallback(new f());
        ImageView imageView2 = new ImageView(context);
        this.l = imageView2;
        imageView2.setImageResource(KB5.ic_check_white_18dp);
        this.l.setScaleType(ImageView.ScaleType.CENTER);
        this.l.setBackgroundResource(KB5.selector);
        this.f.addView(this.l);
        FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams7.width = C22078ud6.a(60.0f);
        layoutParams7.height = C22078ud6.a(60.0f);
        layoutParams7.bottomMargin = C22078ud6.a(4.0f);
        layoutParams7.rightMargin = C22078ud6.a(10.0f);
        layoutParams7.gravity = 85;
        this.l.setLayoutParams(layoutParams7);
        this.l.setOnClickListener(new g());
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setBackgroundColor(c5495Jo7.y0(c5495Jo7.f0(), 15));
        this.f.addView(frameLayout3);
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) frameLayout3.getLayoutParams();
        layoutParams8.width = -1;
        layoutParams8.height = C22078ud6.a(1.0f);
        layoutParams8.gravity = 83;
        layoutParams8.leftMargin = C22078ud6.a(20.0f);
        layoutParams8.rightMargin = C22078ud6.a(20.0f);
        frameLayout3.setLayoutParams(layoutParams8);
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.b = frameLayout4;
        addView(frameLayout4);
        FrameLayout.LayoutParams layoutParams9 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams9.width = -1;
        layoutParams9.height = -1;
        layoutParams9.gravity = 51;
        this.b.setLayoutParams(layoutParams9);
        this.d = new ArrayList(10);
        this.c = new ArrayList(10);
        this.e = new ArrayList(10);
        boolean zG = JF5.g();
        char[] cArr = {1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};
        int i2 = 0;
        while (i2 < 10) {
            TextView textView3 = new TextView(context);
            textView3.setTypeface(C6011Lu2.k());
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            textView3.setTextColor(c5495Jo72.f0());
            textView3.setTextSize(1, f2);
            textView3.setGravity(17);
            if (zG) {
                textView3.setText(String.valueOf(cArr[i2]));
            } else {
                textView3.setText(String.format(Locale.US, "%d", Integer.valueOf(i2)));
            }
            this.b.addView(textView3);
            FrameLayout.LayoutParams layoutParams10 = (FrameLayout.LayoutParams) textView3.getLayoutParams();
            layoutParams10.width = C22078ud6.a(50.0f);
            layoutParams10.height = C22078ud6.a(50.0f);
            layoutParams10.gravity = 51;
            textView3.setLayoutParams(layoutParams10);
            this.c.add(textView3);
            TextView textView4 = new TextView(context);
            textView4.setTextSize(1, 12.0f);
            textView4.setTextColor(c5495Jo72.y0(c5495Jo72.f0(), 50));
            textView4.setGravity(17);
            this.b.addView(textView4);
            FrameLayout.LayoutParams layoutParams11 = (FrameLayout.LayoutParams) textView4.getLayoutParams();
            layoutParams11.width = C22078ud6.a(50.0f);
            layoutParams11.height = C22078ud6.a(20.0f);
            layoutParams11.gravity = 51;
            textView4.setLayoutParams(layoutParams11);
            if (i2 != 0) {
                switch (i2) {
                    case 2:
                        textView4.setText("ABC");
                        break;
                    case 3:
                        textView4.setText("DEF");
                        break;
                    case 4:
                        textView4.setText("GHI");
                        break;
                    case 5:
                        textView4.setText("JKL");
                        break;
                    case 6:
                        textView4.setText("MNO");
                        break;
                    case 7:
                        textView4.setText("PQRS");
                        break;
                    case 8:
                        textView4.setText("TUV");
                        break;
                    case 9:
                        textView4.setText("WXYZ");
                        break;
                }
            } else {
                textView4.setText("+");
            }
            this.d.add(textView4);
            i2++;
            f2 = 36.0f;
        }
        ImageView imageView3 = new ImageView(context);
        this.g = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        this.g.setImageResource(KB5.passcode_delete);
        this.b.addView(this.g);
        FrameLayout.LayoutParams layoutParams12 = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams12.width = C22078ud6.a(50.0f);
        layoutParams12.height = C22078ud6.a(50.0f);
        layoutParams12.gravity = 51;
        this.g.setLayoutParams(layoutParams12);
        for (int i3 = 0; i3 < 11; i3++) {
            FrameLayout frameLayout5 = new FrameLayout(context);
            frameLayout5.setBackgroundResource(KB5.bar_selector_lock);
            frameLayout5.setTag(Integer.valueOf(i3));
            if (i3 == 10) {
                frameLayout5.setOnLongClickListener(new h());
            }
            frameLayout5.setOnClickListener(new i(zG, cArr));
            this.e.add(frameLayout5);
        }
        for (int i4 = 10; i4 >= 0; i4--) {
            FrameLayout frameLayout6 = (FrameLayout) this.e.get(i4);
            this.b.addView(frameLayout6);
            FrameLayout.LayoutParams layoutParams13 = (FrameLayout.LayoutParams) frameLayout6.getLayoutParams();
            layoutParams13.width = C22078ud6.a(100.0f);
            layoutParams13.height = C22078ud6.a(100.0f);
            layoutParams13.gravity = 51;
            frameLayout6.setLayoutParams(layoutParams13);
        }
    }

    private void l() {
        if (((Activity) getContext()) == null || !C23073wI7.e || C5721Ko.c) {
            return;
        }
        try {
            C4071Do2 c4071Do2B = C4071Do2.b(C5721Ko.b);
            if (c4071Do2B.d() && c4071Do2B.c()) {
                TextView textView = this.k;
                if (textView != null) {
                    textView.setText(AbstractC12217eE5.EnterPasscodeOrTouchFingerScanner);
                }
                QE0 qe0 = new QE0();
                this.n = qe0;
                this.o = false;
                c4071Do2B.a(0, qe0, new b(), null);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        r(2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        String string;
        if (!z) {
            int i2 = C23073wI7.d;
            if (i2 == 0) {
                string = this.i.j();
                if (JF5.g()) {
                    string = XY6.h(string);
                }
            } else if (i2 == 1) {
                string = this.h.getText().toString();
                if (JF5.g()) {
                    string = XY6.h(string);
                }
            } else {
                string = "";
            }
            if (string.length() == 0) {
                m();
                return;
            } else if (!C23073wI7.b(string)) {
                this.h.setText("");
                this.i.h(true);
                m();
                return;
            }
        }
        this.h.clearFocus();
        C23381wp3.f(this.h);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "translationY", C22078ud6.a(20.0f)), ObjectAnimator.ofFloat(this, "alpha", C22078ud6.a(0.0f)));
        animatorSet.addListener(new j());
        animatorSet.start();
        C23073wI7.i = false;
        C23073wI7.e();
        setOnTouchListener(null);
        n nVar = this.q;
        if (nVar != null) {
            nVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(float f2, int i2) {
        if (i2 == 6) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.k, "translationX", C22078ud6.a(f2)));
        animatorSet.setDuration(50L);
        animatorSet.addListener(new k(i2, f2));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        TextView textView = this.k;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        AbstractC7426Rr.Q(new l(), 5000L);
    }

    public void n() {
        try {
            QE0 qe0 = this.n;
            if (qe0 != null) {
                qe0.a();
                this.n = null;
            }
        } catch (Exception e2) {
            C19406qI3.d("baleMessages", e2);
        }
    }

    public void o() {
        if (C23073wI7.d == 1) {
            EditText editText = this.h;
            if (editText != null) {
                editText.requestFocus();
                C23381wp3.g(this.h);
            }
            AbstractC7426Rr.Q(new a(), 200L);
        }
        l();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (getVisibility() != 0) {
            return;
        }
        Drawable drawable = this.a;
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (drawable instanceof ColorDrawable) {
            drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.a.draw(canvas);
            return;
        }
        float measuredWidth = getMeasuredWidth() / this.a.getIntrinsicWidth();
        float measuredHeight = (getMeasuredHeight() + this.m) / this.a.getIntrinsicHeight();
        if (measuredWidth < measuredHeight) {
            measuredWidth = measuredHeight;
        }
        int iCeil = (int) Math.ceil(this.a.getIntrinsicWidth() * measuredWidth);
        int iCeil2 = (int) Math.ceil(this.a.getIntrinsicHeight() * measuredWidth);
        int measuredWidth2 = (getMeasuredWidth() - iCeil) / 2;
        int measuredHeight2 = ((getMeasuredHeight() - iCeil2) + this.m) / 2;
        this.a.setBounds(measuredWidth2, measuredHeight2, iCeil + measuredWidth2, iCeil2 + measuredHeight2);
        this.a.draw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View rootView = getRootView();
        int height = rootView.getHeight() - AbstractC7426Rr.J(rootView);
        getWindowVisibleDisplayFrame(this.p);
        Rect rect = this.p;
        this.m = height - (rect.bottom - rect.top);
        if (C23073wI7.d == 1 && getContext().getResources().getConfiguration().orientation != 2) {
            int iIntValue = this.f.getTag() != null ? ((Integer) this.f.getTag()).intValue() : 0;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.topMargin = (iIntValue + layoutParams.height) - (this.m / 2);
            this.f.setLayoutParams(layoutParams);
        }
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        int iA;
        int size = View.MeasureSpec.getSize(i2);
        int iH = AbstractC7426Rr.C().y - AbstractC7426Rr.H();
        int i4 = 0;
        if (getContext().getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams3.width = C23073wI7.d == 0 ? size / 2 : size;
            layoutParams3.height = C22078ud6.a(140.0f);
            layoutParams3.topMargin = (iH - C22078ud6.a(140.0f)) / 2;
            this.f.setLayoutParams(layoutParams3);
            layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height = iH;
            int i5 = size / 2;
            layoutParams.leftMargin = i5;
            layoutParams.topMargin = iH - iH;
            layoutParams.width = i5;
            this.b.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            int i6 = iH / 3;
            layoutParams4.height = i6;
            layoutParams4.width = size;
            layoutParams4.topMargin = 0;
            layoutParams4.leftMargin = 0;
            this.f.setTag(0);
            this.f.setLayoutParams(layoutParams4);
            layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            int i7 = i6 * 2;
            layoutParams.height = i7;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = iH - i7;
            layoutParams.width = size;
            this.b.setLayoutParams(layoutParams);
        }
        int iA2 = (layoutParams.width - (C22078ud6.a(50.0f) * 3)) / 4;
        int iA3 = (layoutParams.height - (C22078ud6.a(50.0f) * 4)) / 5;
        while (true) {
            int i8 = 11;
            if (i4 >= 11) {
                super.onMeasure(i2, i3);
                return;
            }
            if (i4 == 0) {
                i8 = 10;
            } else if (i4 != 10) {
                i8 = i4 - 1;
            }
            int i9 = i8 / 3;
            int i10 = i8 % 3;
            if (i4 < 10) {
                TextView textView = (TextView) this.c.get(i4);
                TextView textView2 = (TextView) this.d.get(i4);
                layoutParams2 = (FrameLayout.LayoutParams) textView.getLayoutParams();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                iA = ((C22078ud6.a(50.0f) + iA3) * i9) + iA3;
                layoutParams2.topMargin = iA;
                layoutParams5.topMargin = iA;
                int iA4 = ((C22078ud6.a(50.0f) + iA2) * i10) + iA2;
                layoutParams2.leftMargin = iA4;
                layoutParams5.leftMargin = iA4;
                layoutParams5.topMargin += C22078ud6.a(40.0f);
                textView.setLayoutParams(layoutParams2);
                textView2.setLayoutParams(layoutParams5);
            } else {
                layoutParams2 = (FrameLayout.LayoutParams) this.g.getLayoutParams();
                int iA5 = ((C22078ud6.a(50.0f) + iA3) * i9) + iA3 + C22078ud6.a(8.0f);
                layoutParams2.topMargin = iA5;
                layoutParams2.leftMargin = ((C22078ud6.a(50.0f) + iA2) * i10) + iA2;
                iA = iA5 - C22078ud6.a(8.0f);
                this.g.setLayoutParams(layoutParams2);
            }
            FrameLayout frameLayout = (FrameLayout) this.e.get(i4);
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams6.topMargin = iA - C22078ud6.a(17.0f);
            layoutParams6.leftMargin = layoutParams2.leftMargin - C22078ud6.a(25.0f);
            frameLayout.setLayoutParams(layoutParams6);
            i4++;
        }
    }

    public void p() {
        View currentFocus;
        Activity activity = (Activity) getContext();
        if (C23073wI7.d == 1) {
            EditText editText = this.h;
            if (editText != null) {
                editText.requestFocus();
                C23381wp3.g(this.h);
            }
        } else if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            currentFocus.clearFocus();
            C23381wp3.f(((Activity) getContext()).getCurrentFocus());
        }
        l();
        if (getVisibility() == 0) {
            return;
        }
        setAlpha(1.0f);
        setTranslationY(0.0f);
        if (C5721Ko.b.getSharedPreferences("mainconfig", 0).getInt("selectedBackground", 1000001) == 1000001) {
            this.j.setBackgroundColor(C5495Jo7.a.t2());
        } else {
            this.a = null;
            this.j.setBackgroundColor(C5495Jo7.a.g0());
        }
        this.k.setText(AbstractC12217eE5.EnterYourPasscode);
        int i2 = C23073wI7.d;
        if (i2 == 0) {
            this.b.setVisibility(0);
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.l.setVisibility(8);
        } else if (i2 == 1) {
            this.h.setFilters(new InputFilter[0]);
            this.h.setInputType(129);
            this.b.setVisibility(8);
            this.h.setFocusable(true);
            this.h.setFocusableInTouchMode(true);
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.l.setVisibility(0);
        }
        setVisibility(0);
        this.h.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.h.setText("");
        this.i.h(false);
        setOnTouchListener(new c());
    }

    public void setDelegate(n nVar) {
        this.q = nVar;
    }
}
