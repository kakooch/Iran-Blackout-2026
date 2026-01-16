package ir.nasim.features.media.components;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C19406qI3;
import ir.nasim.C22078ud6;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;
import ir.nasim.features.media.components.SizeNotifierFrameLayoutPhoto;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class PhotoViewerCaptionEnterView extends FrameLayout implements SizeNotifierFrameLayoutPhoto.SizeNotifierFrameLayoutPhotoDelegate {
    private ImageView a;
    private EditText b;
    private ImageView c;
    private SizeNotifierFrameLayoutPhoto d;
    private ActionMode e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private PhotoViewerCaptionEnterViewDelegate l;
    private View m;

    public interface PhotoViewerCaptionEnterViewDelegate {
        void onDoneButtonClicked();
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoViewerCaptionEnterView.this.isPopupShowing()) {
                PhotoViewerCaptionEnterView.this.j();
            } else {
                PhotoViewerCaptionEnterView.this.k(1);
            }
        }
    }

    class b extends EditText {
        b(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            try {
                super.onMeasure(i, i2);
            } catch (Exception e) {
                setMeasuredDimension(View.MeasureSpec.getSize(i), C22078ud6.a(51.0f));
                C19406qI3.d("baleMessages", e);
            }
        }
    }

    class c implements ActionMode.Callback {
        c() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            PhotoViewerCaptionEnterView.this.e = actionMode;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            if (PhotoViewerCaptionEnterView.this.e == actionMode) {
                PhotoViewerCaptionEnterView.this.e = null;
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            PhotoViewerCaptionEnterView.this.h(actionMode);
            return true;
        }
    }

    class d implements ActionMode.Callback {
        d() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            PhotoViewerCaptionEnterView.this.e = actionMode;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            if (PhotoViewerCaptionEnterView.this.e == actionMode) {
                PhotoViewerCaptionEnterView.this.e = null;
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            PhotoViewerCaptionEnterView.this.h(actionMode);
            return true;
        }
    }

    class e implements View.OnKeyListener {
        e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (PhotoViewerCaptionEnterView.this.hideActionMode()) {
                    return true;
                }
                if (!PhotoViewerCaptionEnterView.this.j && PhotoViewerCaptionEnterView.this.isPopupShowing()) {
                    if (keyEvent.getAction() == 1) {
                        PhotoViewerCaptionEnterView.this.k(0);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoViewerCaptionEnterView.this.isPopupShowing()) {
                PhotoViewerCaptionEnterView.this.k(AbstractC7426Rr.I() ? 0 : 2);
            }
        }
    }

    class g implements TextWatcher {
        boolean a = false;

        g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.a) {
                for (ImageSpan imageSpan : (ImageSpan[]) editable.getSpans(0, editable.length(), ImageSpan.class)) {
                    editable.removeSpan(imageSpan);
                }
                this.a = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i2 == i3 || i3 - i2 <= 1) {
                return;
            }
            this.a = true;
        }
    }

    public PhotoViewerCaptionEnterView(Context context, SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto, View view) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.m = view;
        this.d = sizeNotifierFrameLayoutPhoto;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        addView(linearLayout, C14433hu3.b(-1, -2.0f, 51, 2.0f, 0.0f, 0.0f, 0.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, C14433hu3.e(0, -2, 1.0f));
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setImageResource(KB5.ic_emoji);
        ImageView imageView2 = this.c;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        imageView2.setScaleType(scaleType);
        this.c.setPadding(C22078ud6.a(4.0f), C22078ud6.a(1.0f), 0, 0);
        frameLayout.addView(this.c, C14433hu3.c(48, 48, 83));
        this.c.setOnClickListener(new a());
        ImageView imageView3 = new ImageView(context);
        this.a = imageView3;
        imageView3.setImageResource(KB5.ic_done_white_24dp);
        this.a.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        this.a.setScaleType(scaleType);
        this.a.setPadding(0, C22078ud6.a(1.0f), C22078ud6.a(4.0f), 0);
        frameLayout.addView(this.a, C14433hu3.c(48, 48, 85));
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Eb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.i(view2);
            }
        });
        b bVar = new b(context);
        this.b = bVar;
        bVar.setTypeface(C6011Lu2.k());
        this.c.setVisibility(8);
        this.b.setCustomSelectionActionModeCallback(new c());
        this.b.setCustomInsertionActionModeCallback(new d());
        this.b.setHint(AbstractC12217eE5.AddCaption);
        this.b.setImeOptions(268435456);
        EditText editText = this.b;
        editText.setInputType(editText.getInputType() | 16384);
        this.b.setMaxLines(4);
        this.b.setHorizontallyScrolling(false);
        this.b.setTextSize(1, 18.0f);
        this.b.setGravity(80);
        this.b.setPadding(0, C22078ud6.a(11.0f), 0, C22078ud6.a(12.0f));
        this.b.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 29) {
            this.b.setTextCursorDrawable(0);
        } else {
            AbstractC7426Rr.x(this.b);
        }
        this.b.setTextColor(c5495Jo7.l2());
        this.b.setHintTextColor(c5495Jo7.y0(c5495Jo7.l2(), 70));
        this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(AbstractC5969Lp4.d().Q())});
        frameLayout.addView(this.b, C14433hu3.b(-1, -2.0f, 83, 6.0f, 0.0f, 52.0f, 0.0f));
        this.b.setOnKeyListener(new e());
        this.b.setOnClickListener(new f());
        this.b.addTextChangedListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ActionMode actionMode) {
        try {
            Class<?> cls = Class.forName("com.android.internal.view.FloatingActionMode");
            Field declaredField = cls.getDeclaredField("mFloatingToolbar");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(actionMode);
            Class<?> cls2 = Class.forName("com.android.internal.widget.FloatingToolbar");
            Field declaredField2 = cls2.getDeclaredField("mPopup");
            Field declaredField3 = cls2.getDeclaredField("mWidthChanged");
            declaredField2.setAccessible(true);
            declaredField3.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField4 = Class.forName("com.android.internal.widget.FloatingToolbar$FloatingToolbarPopup").getDeclaredField("mParent");
            declaredField4.setAccessible(true);
            View view = (View) declaredField4.get(obj2);
            View view2 = this.m;
            if (view != view2) {
                declaredField4.set(obj2, view2);
                Method declaredMethod = cls.getDeclaredMethod("updateViewLocationInWindow", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(actionMode, null);
            }
        } catch (Throwable th) {
            C19406qI3.d("baleMessages", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        this.l.onDoneButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        k(AbstractC7426Rr.I() ? 0 : 2);
        C23381wp3.g(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto;
        if (i == 1 || (sizeNotifierFrameLayoutPhoto = this.d) == null) {
            return;
        }
        if (i == 0) {
            this.k = 0;
        }
        sizeNotifierFrameLayoutPhoto.requestLayout();
    }

    public void closeKeyboard() {
        C23381wp3.f(this.b);
    }

    public int getEmojiPadding() {
        return this.k;
    }

    public CharSequence getFieldCharSequence() {
        return this.b.getText();
    }

    public boolean hideActionMode() {
        ActionMode actionMode = this.e;
        if (actionMode == null) {
            return false;
        }
        actionMode.finish();
        this.e = null;
        return true;
    }

    public void hidePopup() {
        if (isPopupShowing()) {
            k(0);
        }
    }

    public boolean isKeyboardVisible() {
        return (AbstractC7426Rr.I() && getLayoutParams() != null && ((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin == 0) || this.j;
    }

    public boolean isPopupShowing() {
        return false;
    }

    public boolean isPopupView() {
        return false;
    }

    public void onCreate() {
        this.d.setDelegate(this);
    }

    public void onDestroy() {
        hidePopup();
        if (isKeyboardVisible()) {
            closeKeyboard();
        }
        this.j = false;
        SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto = this.d;
        if (sizeNotifierFrameLayoutPhoto != null) {
            sizeNotifierFrameLayoutPhoto.setDelegate(null);
        }
    }

    @Override // ir.nasim.features.media.components.SizeNotifierFrameLayoutPhoto.SizeNotifierFrameLayoutPhotoDelegate
    public void onSizeChanged(int i, boolean z) {
        boolean z2;
        if (i > C22078ud6.a(50.0f) && this.j) {
            if (z) {
                this.i = i;
                C5721Ko.b.getSharedPreferences("emoji_recent", 0).edit().putInt("kbd_height_land3", this.i).apply();
            } else {
                this.h = i;
                C5721Ko.b.getSharedPreferences("emoji_recent", 0).edit().putInt("kbd_height", this.h).apply();
            }
        }
        if (this.f == i && this.g == z) {
            return;
        }
        this.f = i;
        this.g = z;
        boolean z3 = this.j;
        boolean z4 = i > 0;
        this.j = z4;
        if (z4 && isPopupShowing()) {
            k(0);
        }
        if (this.k == 0 || (z2 = this.j) || z2 == z3 || isPopupShowing()) {
            return;
        }
        this.k = 0;
        this.d.requestLayout();
    }

    public void openKeyboard() {
        this.b.requestFocus();
        C23381wp3.g(this.b);
    }

    public void setDelegate(PhotoViewerCaptionEnterViewDelegate photoViewerCaptionEnterViewDelegate) {
        this.l = photoViewerCaptionEnterViewDelegate;
    }

    public void setFieldText(CharSequence charSequence) {
        EditText editText = this.b;
        if (editText == null) {
            return;
        }
        editText.setText(charSequence);
        EditText editText2 = this.b;
        editText2.setSelection(editText2.getText().length());
    }
}
