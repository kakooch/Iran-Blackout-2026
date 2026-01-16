package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchToolsCell extends LinearLayout {
    private int currentTabId;
    private SearchToolsDelegate delegate;
    private int indicatorColor;
    private int indicatorHeight;
    AccelerateDecelerateInterpolator interpolator;
    private Paint rectPaint;
    private int tabCount;
    float tabScrollOffset;
    private List<Integer> tabTags;
    private int underlineColor;
    private int underlineHeight;

    public interface SearchToolsDelegate {
        void onItemClicked(int id);
    }

    public class ActionItem extends ImageView {
        public ActionItem(Context context) {
            super(context);
        }
    }

    public SearchToolsCell(Context context) {
        super(context);
        this.currentTabId = 0;
        this.tabCount = 0;
        this.tabTags = new ArrayList();
        this.underlineColor = 436207616;
        this.underlineHeight = AndroidUtilities.dp(2.0f);
        this.indicatorColor = Theme.getColor("actionBarDefaultIcon");
        this.indicatorHeight = AndroidUtilities.dp(2.0f);
        this.tabScrollOffset = 0.0f;
        this.interpolator = new AccelerateDecelerateInterpolator();
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        setOrientation(0);
        setBackgroundColor(Theme.getColor(Theme.getCurrentTheme().isDark() ? "windowBackgroundWhite" : "profile_tabSelectedLine"));
        setGravity(16);
    }

    public void addTabItem(int id, String text, int resId) {
        this.tabCount++;
        ImageView imageView = new ImageView(getContext());
        imageView.setContentDescription(text);
        imageView.setFocusable(true);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setColorFilter(Theme.getColor("actionBarDefaultIcon"), PorterDuff.Mode.SRC_IN);
        imageView.setPadding(4, 4, 4, 4);
        imageView.setTag(Integer.valueOf(id));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.SearchToolsCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchToolsCell.this.onTabSelected(((Integer) v.getTag()).intValue());
            }
        });
        imageView.setLayoutParams(LayoutHelper.createLinear(0, -1, 1.0f));
        if (LocaleController.isRTL) {
            addView(imageView, 0);
        } else {
            addView(imageView);
        }
        this.tabTags.add(Integer.valueOf(id));
    }

    public ActionItem addActionItem(int id, int icon) {
        return addActionItem(id, icon, null);
    }

    public ActionItem addActionItem(final int id, int icon, Drawable drawable) {
        ActionItem actionItem = new ActionItem(getContext());
        actionItem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        actionItem.setColorFilter(Theme.getColor("actionBarDefaultIcon"), PorterDuff.Mode.SRC_IN);
        actionItem.setPadding(4, 4, 4, 4);
        actionItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.SearchToolsCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SearchToolsCell.this.delegate != null) {
                    SearchToolsCell.this.delegate.onItemClicked(id);
                }
            }
        });
        if (drawable != null) {
            actionItem.setImageDrawable(drawable);
        } else {
            actionItem.setImageResource(icon);
        }
        addView(actionItem, LayoutHelper.createLinear(40, 40));
        return actionItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTabSelected(int id) {
        this.currentTabId = id;
        Iterator<Integer> it = this.tabTags.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            final View viewFindViewWithTag = findViewWithTag(Integer.valueOf(iIntValue));
            if (viewFindViewWithTag != null) {
                if (id == iIntValue) {
                    if (viewFindViewWithTag.getAlpha() != 1.0f) {
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewWithTag, "alpha", 0.3f, 1.0f);
                        objectAnimatorOfFloat.setDuration(200L);
                        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.SearchToolsCell.3
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                viewFindViewWithTag.setAlpha(1.0f);
                            }
                        });
                        objectAnimatorOfFloat.start();
                    }
                } else if (viewFindViewWithTag.getAlpha() != 0.3f) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewWithTag, "alpha", 1.0f, 0.3f);
                    objectAnimatorOfFloat2.setDuration(200L);
                    objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
                    objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.SearchToolsCell.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            viewFindViewWithTag.setAlpha(0.3f);
                        }
                    });
                    objectAnimatorOfFloat2.start();
                }
            }
        }
        SearchToolsDelegate searchToolsDelegate = this.delegate;
        if (searchToolsDelegate != null) {
            searchToolsDelegate.onItemClicked(id);
        }
        invalidate();
    }

    public void setTabSelected(int id) {
        onTabSelected(id);
    }

    public void setTabSelected(boolean next) {
        int size = this.tabTags.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (this.tabTags.get(i).intValue() == this.currentTabId) {
                break;
            } else {
                i++;
            }
        }
        int i2 = next ? i + 1 : i - 1;
        int i3 = this.tabCount;
        setTabSelected(this.tabTags.get(i2 <= i3 + (-1) ? i2 < 0 ? i3 - 1 : i2 : 0).intValue());
    }

    public int getCurrentTabId() {
        return this.currentTabId;
    }

    public void setDelegate(SearchToolsDelegate delegate) {
        this.delegate = delegate;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        float measuredWidth;
        float measuredWidth2;
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        this.rectPaint.setColor(this.underlineColor);
        float f = width;
        float f2 = height;
        canvas.drawRect(0.0f, height - this.underlineHeight, f, f2, this.rectPaint);
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.currentTabId));
        if (viewFindViewWithTag == null) {
            return;
        }
        float left = viewFindViewWithTag.getLeft();
        float right = viewFindViewWithTag.getRight();
        if (this.tabScrollOffset < 0.0f) {
            measuredWidth2 = left + (viewFindViewWithTag.getMeasuredWidth() * (-this.interpolator.getInterpolation(this.tabScrollOffset)));
            measuredWidth = right + (viewFindViewWithTag.getMeasuredWidth() * (-this.interpolator.getInterpolation(this.tabScrollOffset)));
        } else {
            measuredWidth = right + (viewFindViewWithTag.getMeasuredWidth() * this.interpolator.getInterpolation(this.tabScrollOffset));
            measuredWidth2 = left + (viewFindViewWithTag.getMeasuredWidth() * this.interpolator.getInterpolation(this.tabScrollOffset));
        }
        this.rectPaint.setColor(this.indicatorColor);
        if (this.indicatorHeight > 0) {
            int measuredWidth3 = this.tabCount * viewFindViewWithTag.getMeasuredWidth();
            if (measuredWidth2 < 0.0f) {
                float f3 = measuredWidth3;
                canvas.drawRect(measuredWidth2 + f3, height - this.indicatorHeight, f3, f2, this.rectPaint);
            }
            float f4 = measuredWidth3;
            if (measuredWidth > f4) {
                canvas.drawRect(0.0f, height - this.indicatorHeight, measuredWidth - f4, f2, this.rectPaint);
                canvas.drawRect(measuredWidth2, height - this.indicatorHeight, f4, f2, this.rectPaint);
            } else {
                canvas.drawRect(measuredWidth2, height - this.indicatorHeight, measuredWidth, f2, this.rectPaint);
            }
        }
    }
}
