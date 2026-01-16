package ir.resaneh1.iptv.fragment.rubino;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Property;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ir.resaneh1.iptv.model.Rubino;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class RubinoBottomUpAlert extends BottomSheet {
    private ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarShadow;
    private CompositeDisposable compositeDisposable;
    private Context context;
    private float gradientWidth;
    private ArrayList<Rubino.AlertItem> items;
    public Adapter listAdapter;
    private org.rbmain.ui.Components.RecyclerListView listView;
    private boolean loadingResults;
    private LinearGradient placeholderGradient;
    private Matrix placeholderMatrix;
    private Paint placeholderPaint;
    private ArrayList<Disposable> queries;
    private RectF rect;
    private int scrollOffsetY;
    private Drawable shadowDrawable;
    private TextView titleTextView;
    private float totalTranslation;

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    static /* synthetic */ float access$2816(RubinoBottomUpAlert rubinoBottomUpAlert, float f) {
        float f2 = rubinoBottomUpAlert.totalTranslation + f;
        rubinoBottomUpAlert.totalTranslation = f2;
        return f2;
    }

    static /* synthetic */ float access$2824(RubinoBottomUpAlert rubinoBottomUpAlert, float f) {
        float f2 = rubinoBottomUpAlert.totalTranslation - f;
        rubinoBottomUpAlert.totalTranslation = f2;
        return f2;
    }

    public class SectionCell extends FrameLayout {
        private TextView middleTextView;
        private TextView righTextView;
        private TextView textView;

        protected void onCollapseClick() {
        }

        public SectionCell(Context context) {
            super(context);
            setBackgroundColor(Theme.getColor(Theme.key_graySection));
            TextView textView = new TextView(getContext(), RubinoBottomUpAlert.this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.SectionCell.1
                @Override // android.view.View
                public boolean post(Runnable runnable) {
                    return ((BottomSheet) RubinoBottomUpAlert.this).containerView.post(runnable);
                }

                @Override // android.view.View
                public boolean postDelayed(Runnable runnable, long j) {
                    return ((BottomSheet) RubinoBottomUpAlert.this).containerView.postDelayed(runnable, j);
                }
            };
            this.textView = textView;
            textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            this.textView.setLines(1);
            TextView textView2 = this.textView;
            int i = Theme.key_graySectionText;
            textView2.setTextColor(Theme.getColor(i));
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            TextView textView3 = new TextView(getContext());
            this.middleTextView = textView3;
            textView3.setTextSize(1, 14.0f);
            this.middleTextView.setTextColor(Theme.getColor(i));
            this.middleTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            TextView textView4 = new TextView(getContext(), RubinoBottomUpAlert.this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.SectionCell.2
                @Override // android.view.View
                public boolean post(Runnable runnable) {
                    return ((BottomSheet) RubinoBottomUpAlert.this).containerView.post(runnable);
                }

                @Override // android.view.View
                public boolean postDelayed(Runnable runnable, long j) {
                    return ((BottomSheet) RubinoBottomUpAlert.this).containerView.postDelayed(runnable, j);
                }
            };
            this.righTextView = textView4;
            textView4.setTextSize(1, 14.0f);
            this.righTextView.setTextColor(Theme.getColor(i));
            this.righTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 16);
            this.righTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert$SectionCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            TextView textView5 = this.textView;
            boolean z = LocaleController.isRTL;
            addView(textView5, LayoutHelper.createFrame(-2, -1.0f, (z ? 5 : 3) | 48, z ? 0 : 16, 0.0f, z ? 16 : 0, 0.0f));
            addView(this.middleTextView, LayoutHelper.createFrame(-2, -1.0f, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 0.0f, 0.0f, 0.0f));
            addView(this.righTextView, LayoutHelper.createFrame(-2, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, 16.0f, 0.0f, 16.0f, 0.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            onCollapseClick();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824);
            measureChildWithMargins(this.middleTextView, i, 0, iMakeMeasureSpec, 0);
            measureChildWithMargins(this.righTextView, i, 0, iMakeMeasureSpec, 0);
            measureChildWithMargins(this.textView, i, this.middleTextView.getMeasuredWidth() + this.righTextView.getMeasuredWidth() + AndroidUtilities.dp(32.0f), iMakeMeasureSpec, 0);
            setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(32.0f));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (LocaleController.isRTL) {
                int left = this.textView.getLeft() - this.middleTextView.getMeasuredWidth();
                TextView textView = this.middleTextView;
                textView.layout(left, textView.getTop(), this.middleTextView.getMeasuredWidth() + left, this.middleTextView.getBottom());
            } else {
                int right = this.textView.getRight();
                TextView textView2 = this.middleTextView;
                textView2.layout(right, textView2.getTop(), this.middleTextView.getMeasuredWidth() + right, this.middleTextView.getBottom());
            }
        }
    }

    public class TextAndIconCell extends FrameLayout {
        private ArrayList<Animator> animators;
        private Rubino.AlertItem currentItem;
        private boolean drawPlaceholder;
        private int iconId;
        private ImageView imageView;
        private boolean needDivider;
        private float placeholderAlpha;
        private int placeholderNum;
        private String text;
        private SimpleTextView textView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public TextAndIconCell(Context context) {
            super(context);
            this.placeholderAlpha = 1.0f;
            setWillNotDraw(false);
            new AvatarDrawable();
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            addView(imageView, LayoutHelper.createFrame(24, 24.0f, 53, 8.0f, 8.0f, 8.0f, 0.0f));
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.textView = simpleTextView;
            simpleTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            this.textView.setTextSize(16);
            this.textView.setGravity(51);
            View view = this.textView;
            boolean z = LocaleController.isRTL;
            addView(view, LayoutHelper.createFrame(-1, 20.0f, (z ? 5 : 3) | 48, z ? 28.0f : 65.0f, 14.0f, z ? 65.0f : 28.0f, 0.0f));
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            setBackgroundResource(typedValue.resourceId);
        }

        public void setData(Rubino.AlertItem alertItem, int i, boolean z) {
            this.currentItem = alertItem;
            this.needDivider = z;
            this.drawPlaceholder = alertItem == null;
            this.placeholderNum = i;
            if (alertItem == null) {
                this.textView.setText(BuildConfig.FLAVOR);
                this.imageView.setVisibility(8);
            } else {
                update(0);
            }
            ArrayList<Animator> arrayList = this.animators;
            if (arrayList != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.imageView, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.textView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f, 1.0f));
            } else {
                if (this.drawPlaceholder) {
                    return;
                }
                this.placeholderAlpha = 0.0f;
            }
        }

        @Keep
        public void setPlaceholderAlpha(float f) {
            this.placeholderAlpha = f;
            invalidate();
        }

        @Keep
        public float getPlaceholderAlpha() {
            return this.placeholderAlpha;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }

        public void update(int i) {
            Rubino.AlertItem alertItem = this.currentItem;
            if (alertItem != null) {
                this.text = alertItem.getText();
                int iconId = this.currentItem.getIconId();
                this.iconId = iconId;
                if (iconId != 0) {
                    this.imageView.setVisibility(0);
                    this.imageView.setImageDrawable(getResources().getDrawable(this.iconId));
                } else {
                    this.imageView.setVisibility(4);
                }
            } else {
                this.text = BuildConfig.FLAVOR;
                this.imageView.setVisibility(4);
            }
            this.textView.setText(this.text);
            if (this.currentItem instanceof Rubino.AlertBoldItem) {
                this.textView.setTypeface(Theme.getRubinoTypeFaceBold());
            } else {
                this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int iDp;
            int iDp2;
            int iDp3;
            int iDp4;
            if (this.drawPlaceholder || this.placeholderAlpha != 0.0f) {
                RubinoBottomUpAlert.this.placeholderPaint.setAlpha((int) (this.placeholderAlpha * 255.0f));
                canvas.drawCircle(this.imageView.getLeft() + (this.imageView.getMeasuredWidth() / 2), this.imageView.getTop() + (this.imageView.getMeasuredHeight() / 2), this.imageView.getMeasuredWidth() / 2, RubinoBottomUpAlert.this.placeholderPaint);
                if (this.placeholderNum % 2 == 0) {
                    iDp = AndroidUtilities.dp(65.0f);
                    iDp2 = AndroidUtilities.dp(48.0f);
                } else {
                    iDp = AndroidUtilities.dp(65.0f);
                    iDp2 = AndroidUtilities.dp(60.0f);
                }
                if (LocaleController.isRTL) {
                    iDp = (getMeasuredWidth() - iDp) - iDp2;
                }
                RubinoBottomUpAlert.this.rect.set(iDp, r1 - AndroidUtilities.dp(4.0f), iDp + iDp2, AndroidUtilities.dp(4.0f) + r1);
                canvas.drawRoundRect(RubinoBottomUpAlert.this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), RubinoBottomUpAlert.this.placeholderPaint);
                if (this.placeholderNum % 2 == 0) {
                    iDp3 = AndroidUtilities.dp(119.0f);
                    iDp4 = AndroidUtilities.dp(60.0f);
                } else {
                    iDp3 = AndroidUtilities.dp(131.0f);
                    iDp4 = AndroidUtilities.dp(80.0f);
                }
                if (LocaleController.isRTL) {
                    iDp3 = (getMeasuredWidth() - iDp3) - iDp4;
                }
                RubinoBottomUpAlert.this.rect.set(iDp3, r1 - AndroidUtilities.dp(4.0f), iDp3 + iDp4, r1 + AndroidUtilities.dp(4.0f));
                canvas.drawRoundRect(RubinoBottomUpAlert.this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), RubinoBottomUpAlert.this.placeholderPaint);
            }
            if (this.needDivider) {
                canvas.drawLine(5.0f, 1.0f, getMeasuredWidth() - 5, 1.0f, Theme.dividerPaint);
            }
        }
    }

    public class TextAndValueCell extends FrameLayout {
        private ArrayList<Animator> animators;
        private Rubino.AlertTextValueItem currentItem;
        private boolean needDivider;
        private String text;
        private SimpleTextView textView;
        private SimpleTextView textViewValue;
        private String value;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public TextAndValueCell(RubinoBottomUpAlert rubinoBottomUpAlert, Context context) {
            super(context);
            setWillNotDraw(false);
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.textView = simpleTextView;
            simpleTextView.setTextColor(context.getResources().getColor(ir.medu.shad.R.color.grey_900));
            this.textView.setTypeface(Theme.getRubinoTypeFaceBold());
            this.textView.setTextSize(16);
            this.textView.setGravity(51);
            SimpleTextView simpleTextView2 = this.textView;
            boolean z = LocaleController.isRTL;
            addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, 51, z ? 28.0f : 65.0f, 14.0f, z ? 65.0f : 28.0f, 0.0f));
            SimpleTextView simpleTextView3 = new SimpleTextView(context);
            this.textViewValue = simpleTextView3;
            simpleTextView3.setTextColor(context.getResources().getColor(ir.medu.shad.R.color.grey_600));
            this.textViewValue.setTypeface(Theme.getRubinoTypeFaceRegular());
            this.textViewValue.setTextSize(16);
            this.textViewValue.setGravity(51);
            SimpleTextView simpleTextView4 = this.textViewValue;
            boolean z2 = LocaleController.isRTL;
            addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, 51, z2 ? 28.0f : 65.0f, 34.0f, z2 ? 65.0f : 28.0f, 0.0f));
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            setBackgroundResource(typedValue.resourceId);
        }

        public void setData(Rubino.AlertTextValueItem alertTextValueItem, boolean z) {
            this.currentItem = alertTextValueItem;
            this.needDivider = z;
            if (alertTextValueItem == null) {
                this.textView.setText(BuildConfig.FLAVOR);
                this.textViewValue.setVisibility(8);
            } else {
                update(0);
            }
            ArrayList<Animator> arrayList = this.animators;
            if (arrayList != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.textViewValue, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.textView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f, 1.0f));
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(56.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }

        public void update(int i) {
            Rubino.AlertTextValueItem alertTextValueItem = this.currentItem;
            if (alertTextValueItem != null) {
                this.text = alertTextValueItem.getText();
                String str = this.currentItem.value;
                this.value = str;
                if (str != null) {
                    this.textViewValue.setVisibility(0);
                    this.textViewValue.setText(this.value);
                } else {
                    this.textViewValue.setVisibility(8);
                }
            } else {
                this.text = BuildConfig.FLAVOR;
                this.textViewValue.setVisibility(8);
            }
            this.textView.setText(this.text);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(5.0f, 1.0f, getMeasuredWidth() - 5, 1.0f, Theme.dividerPaint);
            }
        }
    }

    public static RubinoBottomUpAlert createRubinoDialogItems(BaseFragment baseFragment, String str, ArrayList<Rubino.AlertItem> arrayList) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return null;
        }
        return new RubinoBottomUpAlert(baseFragment, str, arrayList);
    }

    public RubinoBottomUpAlert(final BaseFragment baseFragment, String str, ArrayList<Rubino.AlertItem> arrayList) {
        super(baseFragment.getParentActivity(), true);
        this.queries = new ArrayList<>();
        this.placeholderPaint = new Paint(1);
        this.loadingResults = true;
        this.rect = new RectF();
        this.compositeDisposable = new CompositeDisposable();
        this.items = arrayList;
        this.context = baseFragment.getParentActivity();
        updatePlaceholder();
        Drawable drawableMutate = this.context.getResources().getDrawable(ir.medu.shad.R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        int i = Theme.key_dialogBackground;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(this.context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.1
            private boolean ignoreLayout = false;
            private RectF rect = new RectF();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int size = View.MeasureSpec.getSize(i3);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                int paddingTop = size - getPaddingTop();
                ((FrameLayout.LayoutParams) RubinoBottomUpAlert.this.listView.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                ((FrameLayout.LayoutParams) RubinoBottomUpAlert.this.actionBarShadow.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                int iDp = ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop + AndroidUtilities.dp(15.0f) + AndroidUtilities.statusBarHeight;
                int sectionCount = RubinoBottomUpAlert.this.listAdapter.getSectionCount();
                for (int i4 = 0; i4 < sectionCount; i4++) {
                    if (i4 == 0) {
                        RubinoBottomUpAlert.this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2 - (((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft * 2)), 1073741824), i3);
                        iDp += RubinoBottomUpAlert.this.titleTextView.getMeasuredHeight();
                    } else {
                        iDp += AndroidUtilities.dp(16.0f) + (AndroidUtilities.dp(56.0f) * RubinoBottomUpAlert.this.listAdapter.getCountForSection(i4));
                    }
                }
                int iDp2 = (iDp < paddingTop ? paddingTop - iDp : paddingTop - ((paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f);
                if (RubinoBottomUpAlert.this.listView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    RubinoBottomUpAlert.this.listView.setPinnedSectionOffsetY(-iDp2);
                    RubinoBottomUpAlert.this.listView.setPadding(0, iDp2, 0, AndroidUtilities.dp(16.0f));
                    this.ignoreLayout = false;
                }
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                RubinoBottomUpAlert.this.updateLayout(false);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && RubinoBottomUpAlert.this.scrollOffsetY != 0 && motionEvent.getY() < RubinoBottomUpAlert.this.scrollOffsetY + AndroidUtilities.dp(12.0f) && RubinoBottomUpAlert.this.actionBar.getAlpha() == 0.0f) {
                    RubinoBottomUpAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !RubinoBottomUpAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                int iDp = AndroidUtilities.dp(13.0f);
                int translationY = (int) (((RubinoBottomUpAlert.this.scrollOffsetY - ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop) - iDp) + RubinoBottomUpAlert.this.listView.getTranslationY());
                int iDp2 = AndroidUtilities.dp(20.0f) + translationY;
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop;
                if (((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop + translationY < ActionBar.getCurrentActionBarHeight()) {
                    float fDp = iDp + AndroidUtilities.dp(4.0f);
                    float fMin = Math.min(1.0f, ((ActionBar.getCurrentActionBarHeight() - translationY) - ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop) / fDp);
                    int currentActionBarHeight = (int) ((ActionBar.getCurrentActionBarHeight() - fDp) * fMin);
                    translationY -= currentActionBarHeight;
                    iDp2 -= currentActionBarHeight;
                    measuredHeight += currentActionBarHeight;
                    f = 1.0f - fMin;
                } else {
                    f = 1.0f;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    int i2 = AndroidUtilities.statusBarHeight;
                    translationY += i2;
                    iDp2 += i2;
                }
                RubinoBottomUpAlert.this.shadowDrawable.setBounds(0, translationY, getMeasuredWidth(), measuredHeight);
                RubinoBottomUpAlert.this.shadowDrawable.draw(canvas);
                if (f != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(Theme.getColor(Theme.key_dialogBackground));
                    this.rect.set(((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft, ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop + translationY, getMeasuredWidth() - ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft, ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop + translationY + AndroidUtilities.dp(24.0f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(12.0f) * f, AndroidUtilities.dp(12.0f) * f, Theme.dialogs_onlineCirclePaint);
                }
                if (f != 0.0f) {
                    int iDp3 = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp3) / 2, iDp2, (getMeasuredWidth() + iDp3) / 2, iDp2 + AndroidUtilities.dp(4.0f));
                    int color = Theme.getColor(Theme.key_sheet_scrollUp);
                    int iAlpha = Color.alpha(color);
                    Theme.dialogs_onlineCirclePaint.setColor(color);
                    Theme.dialogs_onlineCirclePaint.setAlpha((int) (iAlpha * 1.0f * f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                }
                int color2 = Theme.getColor(Theme.key_dialogBackground);
                Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (RubinoBottomUpAlert.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(color2) * 0.8f), (int) (Color.green(color2) * 0.8f), (int) (Color.blue(color2) * 0.8f)));
                canvas.drawRect(((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, Theme.dialogs_onlineCirclePaint);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i2 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i2, 0, i2, 0);
        org.rbmain.ui.Components.RecyclerListView recyclerListView = new org.rbmain.ui.Components.RecyclerListView(this.context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.2
            long lastUpdateTime;

            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return f2 >= ((float) (RubinoBottomUpAlert.this.scrollOffsetY + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (RubinoBottomUpAlert.this.loadingResults) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jAbs = Math.abs(this.lastUpdateTime - jElapsedRealtime);
                    if (jAbs > 17) {
                        jAbs = 16;
                    }
                    this.lastUpdateTime = jElapsedRealtime;
                    RubinoBottomUpAlert rubinoBottomUpAlert = RubinoBottomUpAlert.this;
                    RubinoBottomUpAlert.access$2816(rubinoBottomUpAlert, (jAbs * rubinoBottomUpAlert.gradientWidth) / 1800.0f);
                    while (RubinoBottomUpAlert.this.totalTranslation >= RubinoBottomUpAlert.this.gradientWidth * 2.0f) {
                        RubinoBottomUpAlert rubinoBottomUpAlert2 = RubinoBottomUpAlert.this;
                        RubinoBottomUpAlert.access$2824(rubinoBottomUpAlert2, rubinoBottomUpAlert2.gradientWidth * 2.0f);
                    }
                    RubinoBottomUpAlert.this.placeholderMatrix.setTranslate(RubinoBottomUpAlert.this.totalTranslation, 0.0f);
                    RubinoBottomUpAlert.this.placeholderGradient.setLocalMatrix(RubinoBottomUpAlert.this.placeholderMatrix);
                    invalidateViews();
                    invalidate();
                }
                super.dispatchDraw(canvas);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setSectionsType(2);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        org.rbmain.ui.Components.RecyclerListView recyclerListView2 = this.listView;
        Adapter adapter = new Adapter(this.context);
        this.listAdapter = adapter;
        recyclerListView2.setAdapter(adapter);
        this.listView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$new$0(baseFragment, view, i3);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                if (RubinoBottomUpAlert.this.listView.getChildCount() <= 0) {
                    return;
                }
                RubinoBottomUpAlert.this.updateLayout(true);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (i3 == 0) {
                    if (((RubinoBottomUpAlert.this.scrollOffsetY - ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f)) + ((BottomSheet) RubinoBottomUpAlert.this).backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || !RubinoBottomUpAlert.this.listView.canScrollVertically(1)) {
                        return;
                    }
                    RubinoBottomUpAlert.this.listView.getChildAt(0);
                    RecyclerListView.Holder holder = (RecyclerListView.Holder) RubinoBottomUpAlert.this.listView.findViewHolderForAdapterPosition(0);
                    if (holder == null || holder.itemView.getTop() <= AndroidUtilities.dp(7.0f)) {
                        return;
                    }
                    RubinoBottomUpAlert.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(7.0f));
                }
            }
        });
        TextView textView = new TextView(this.context);
        this.titleTextView = textView;
        textView.setTextSize(1, 18.0f);
        this.titleTextView.setTypeface(Theme.getRubinoTypeFaceRegular(), 1);
        this.titleTextView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(21.0f));
        TextView textView2 = this.titleTextView;
        int i3 = Theme.key_dialogTextBlack;
        textView2.setTextColor(Theme.getColor(i3));
        this.titleTextView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        TextView textView3 = this.titleTextView;
        textView3.setText(Emoji.replaceEmoji(str, textView3.getPaint().getFontMetricsInt(), AndroidUtilities.dp(18.0f), false));
        ActionBar actionBar = new ActionBar(this.context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.4
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                ((BottomSheet) RubinoBottomUpAlert.this).containerView.invalidate();
            }
        };
        this.actionBar = actionBar;
        actionBar.setBackgroundColor(Theme.getColor(i));
        this.actionBar.setBackButtonImage(ir.medu.shad.R.drawable.ic_arrow_back_white);
        this.actionBar.setItemsColor(Theme.getColor(i3), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_dialogButtonSelector), false);
        this.actionBar.setTitleColor(Theme.getColor(i3));
        this.actionBar.setSubtitleColor(Theme.getColor(Theme.key_player_actionBarSubtitle));
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAlpha(0.0f);
        this.actionBar.setTitle(str);
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.5
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i4) {
                if (i4 == -1) {
                    RubinoBottomUpAlert.this.dismiss();
                }
            }
        });
        View view = new View(this.context);
        this.actionBarShadow = view;
        view.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(BaseFragment baseFragment, View view, int i) {
        ArrayList<Disposable> arrayList;
        if (baseFragment == null || baseFragment.getParentActivity() == null || (arrayList = this.queries) == null) {
            return;
        }
        arrayList.isEmpty();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        this.compositeDisposable.dispose();
        super.dismissInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(boolean z) {
        if (this.listView.getChildCount() <= 0) {
            org.rbmain.ui.Components.RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        int iDp = AndroidUtilities.dp(7.0f);
        if (top < AndroidUtilities.dp(7.0f) || holder == null || holder.getAdapterPosition() != 0) {
            top = iDp;
        }
        boolean z2 = top <= AndroidUtilities.dp(12.0f);
        if ((z2 && this.actionBar.getTag() == null) || (!z2 && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z2 ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            AnimatorSet animatorSet3 = this.actionBarAnimation;
            Animator[] animatorArr = new Animator[2];
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z2 ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr);
            View view = this.actionBarShadow;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = z2 ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr);
            this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    RubinoBottomUpAlert.this.actionBarAnimation = null;
                }
            });
            this.actionBarAnimation.start();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
        int iDp2 = top + (layoutParams.topMargin - AndroidUtilities.dp(11.0f));
        if (this.scrollOffsetY != iDp2) {
            org.rbmain.ui.Components.RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = iDp2;
            recyclerListView2.setTopGlowOffset(iDp2 - layoutParams.topMargin);
            this.containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholder() {
        if (this.placeholderPaint == null) {
            return;
        }
        int color = Theme.getColor(Theme.key_dialogBackground);
        int color2 = Theme.getColor(Theme.key_dialogBackgroundGray);
        int averageColor = AndroidUtilities.getAverageColor(color2, color);
        this.placeholderPaint.setColor(color2);
        float fDp = AndroidUtilities.dp(500.0f);
        this.gradientWidth = fDp;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, fDp, 0.0f, new int[]{color2, averageColor, color2}, new float[]{0.0f, 0.18f, 0.36f}, Shader.TileMode.REPEAT);
        this.placeholderGradient = linearGradient;
        this.placeholderPaint.setShader(linearGradient);
        Matrix matrix = new Matrix();
        this.placeholderMatrix = matrix;
        this.placeholderGradient.setLocalMatrix(matrix);
    }

    public class Adapter extends RecyclerListView.SectionsAdapter {
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(org.rbmain.ui.Components.RecyclerListView recyclerListView, float f, int[] iArr) {
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            return 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        }

        public Adapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            return (i == 0 || i2 >= RubinoBottomUpAlert.this.items.size() || ((Rubino.AlertItem) RubinoBottomUpAlert.this.items.get(i2)).getOnClickListener() == null) ? false : true;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if (i == 0) {
                return 1;
            }
            if (RubinoBottomUpAlert.this.items != null) {
                return RubinoBottomUpAlert.this.items.size();
            }
            return 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = RubinoBottomUpAlert.this.new SectionCell(this.mContext);
            }
            SectionCell sectionCell = (SectionCell) view;
            if (i == 0) {
                sectionCell.setAlpha(0.0f);
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textAndValueCell;
            if (i == 1) {
                if (RubinoBottomUpAlert.this.titleTextView.getParent() != null) {
                    ((ViewGroup) RubinoBottomUpAlert.this.titleTextView.getParent()).removeView(RubinoBottomUpAlert.this.titleTextView);
                }
                RubinoBottomUpAlert.this.titleTextView.setGravity(17);
                textAndValueCell = RubinoBottomUpAlert.this.titleTextView;
            } else if (i == 3) {
                textAndValueCell = new TextAndValueCell(RubinoBottomUpAlert.this, this.mContext);
            } else {
                textAndValueCell = RubinoBottomUpAlert.this.new TextAndIconCell(this.mContext);
            }
            return new RecyclerListView.Holder(textAndValueCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 2) {
                TextAndIconCell textAndIconCell = (TextAndIconCell) viewHolder.itemView;
                Rubino.AlertItem alertItem = (Rubino.AlertItem) RubinoBottomUpAlert.this.items.get(i2);
                textAndIconCell.setData(alertItem, 0, i2 == 0);
                if (alertItem.getOnClickListener() != null) {
                    textAndIconCell.setOnClickListener(alertItem.getOnClickListener());
                    return;
                } else {
                    textAndIconCell.setOnClickListener(null);
                    return;
                }
            }
            if (itemViewType != 3) {
                return;
            }
            TextAndValueCell textAndValueCell = (TextAndValueCell) viewHolder.itemView;
            Rubino.AlertTextValueItem alertTextValueItem = (Rubino.AlertTextValueItem) RubinoBottomUpAlert.this.items.get(i2);
            textAndValueCell.setData(alertTextValueItem, i2 == 0);
            if (alertTextValueItem.getOnClickListener() != null) {
                textAndValueCell.setOnClickListener(alertTextValueItem.getOnClickListener());
            } else {
                textAndValueCell.setOnClickListener(null);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            Rubino.AlertItem alertItem;
            if (i == 0) {
                return 1;
            }
            return (RubinoBottomUpAlert.this.items == null || i2 >= RubinoBottomUpAlert.this.items.size() || (alertItem = (Rubino.AlertItem) RubinoBottomUpAlert.this.items.get(i2)) == null || !(alertItem instanceof Rubino.AlertTextValueItem)) ? 2 : 3;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updatePlaceholder();
            }
        };
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, null, null, Theme.key_sheet_scrollUp));
        ViewGroup viewGroup = this.containerView;
        Drawable[] drawableArr = {this.shadowDrawable};
        int i = Theme.key_dialogBackground;
        arrayList.add(new ThemeDescription(viewGroup, 0, null, null, drawableArr, null, i));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_dialogScrollGlow));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_AB_ITEMSCOLOR;
        int i3 = Theme.key_dialogTextBlack;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBTITLECOLOR, null, null, null, null, Theme.key_player_actionBarSubtitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBarShadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_dialogShadowLine));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, i));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_dialogBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        return arrayList;
    }
}
