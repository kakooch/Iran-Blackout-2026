package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class Calligraphy {
    private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
    private static final String ACTION_BAR_TITLE = "action_bar_title";
    private final int[] mAttributeId;
    private final CalligraphyConfig mCalligraphyConfig;

    protected int[] getStyleForTextView(TextView textView) {
        int[] iArr = {-1, -1};
        if (isActionBarTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843512;
        } else if (isActionBarSubTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843513;
        }
        if (iArr[0] == -1) {
            iArr[0] = this.mCalligraphyConfig.getClassStyles().containsKey(textView.getClass()) ? this.mCalligraphyConfig.getClassStyles().get(textView.getClass()).intValue() : android.R.attr.textAppearance;
        }
        return iArr;
    }

    protected static boolean isActionBarTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_TITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getTitle(), textView.getText());
        }
        return false;
    }

    protected static boolean isActionBarSubTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_SUBTITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getSubtitle(), textView.getText());
        }
        return false;
    }

    protected static boolean parentIsToolbarV7(View view) {
        return CalligraphyUtils.canCheckForV7Toolbar() && view.getParent() != null && (view.getParent() instanceof Toolbar);
    }

    protected static boolean matchesResourceIdName(View view, String str) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(str);
    }

    public Calligraphy(CalligraphyConfig calligraphyConfig) {
        this.mCalligraphyConfig = calligraphyConfig;
        this.mAttributeId = new int[]{calligraphyConfig.getAttrId()};
    }

    public View onViewCreated(View view, Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (view != null) {
            int i = R.id.calligraphy_tag_id;
            Object tag = view.getTag(i);
            Boolean bool = Boolean.TRUE;
            if (tag != bool) {
                onViewCreatedInternal(view, context, attributeSet);
                view.setTag(i, bool);
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void onViewCreatedInternal(View view, Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (TypefaceUtils.isLoaded(textView.getTypeface())) {
                return;
            }
            String strResolveFontPath = resolveFontPath(context, attributeSet);
            if (TextUtils.isEmpty(strResolveFontPath)) {
                int[] styleForTextView = getStyleForTextView(textView);
                if (styleForTextView[1] != -1) {
                    strResolveFontPath = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], styleForTextView[1], this.mAttributeId);
                } else {
                    strResolveFontPath = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], this.mAttributeId);
                }
            }
            CalligraphyUtils.applyFontToTextView(context, textView, this.mCalligraphyConfig, applyFontMapper(strResolveFontPath), matchesResourceIdName(view, ACTION_BAR_TITLE) || matchesResourceIdName(view, ACTION_BAR_SUBTITLE));
        }
        if (CalligraphyUtils.canCheckForV7Toolbar() && (view instanceof Toolbar)) {
            Toolbar toolbar = (Toolbar) view;
            toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ToolbarLayoutListener(context, toolbar));
        }
        if (view instanceof HasTypeface) {
            Typeface defaultTypeface = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attributeSet)));
            if (defaultTypeface != null) {
                ((HasTypeface) view).setTypeface(defaultTypeface);
                return;
            }
            return;
        }
        if (this.mCalligraphyConfig.isCustomViewTypefaceSupport() && this.mCalligraphyConfig.isCustomViewHasTypeface(view)) {
            Method method = ReflectionUtils.getMethod(view.getClass(), "setTypeface");
            Typeface defaultTypeface2 = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attributeSet)));
            if (method == null || defaultTypeface2 == null) {
                return;
            }
            ReflectionUtils.invokeMethod(view, method, defaultTypeface2);
        }
    }

    private Typeface getDefaultTypeface(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.mCalligraphyConfig.getFontPath();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TypefaceUtils.load(context.getAssets(), str);
    }

    private String resolveFontPath(Context context, AttributeSet attributeSet) throws Resources.NotFoundException, NumberFormatException {
        String strPullFontPathFromView = CalligraphyUtils.pullFontPathFromView(context, attributeSet, this.mAttributeId);
        if (TextUtils.isEmpty(strPullFontPathFromView)) {
            strPullFontPathFromView = CalligraphyUtils.pullFontPathFromStyle(context, attributeSet, this.mAttributeId);
        }
        return TextUtils.isEmpty(strPullFontPathFromView) ? CalligraphyUtils.pullFontPathFromTextAppearance(context, attributeSet, this.mAttributeId) : strPullFontPathFromView;
    }

    private String applyFontMapper(String str) {
        FontMapper fontMapper = this.mCalligraphyConfig.getFontMapper();
        return fontMapper != null ? fontMapper.map(str) : str;
    }

    private static class ToolbarLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        static String BLANK = " ";
        private final WeakReference<Calligraphy> mCalligraphyFactory;
        private final WeakReference<Context> mContextRef;
        private final WeakReference<Toolbar> mToolbarReference;
        private final CharSequence originalSubTitle;

        private ToolbarLayoutListener(Calligraphy calligraphy, Context context, Toolbar toolbar) {
            this.mCalligraphyFactory = new WeakReference<>(calligraphy);
            this.mContextRef = new WeakReference<>(context);
            this.mToolbarReference = new WeakReference<>(toolbar);
            this.originalSubTitle = toolbar.getSubtitle();
            toolbar.setSubtitle(BLANK);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() throws IllegalAccessException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Toolbar toolbar = this.mToolbarReference.get();
            Context context = this.mContextRef.get();
            Calligraphy calligraphy = this.mCalligraphyFactory.get();
            if (toolbar == null) {
                return;
            }
            if (calligraphy == null || context == null) {
                removeSelf(toolbar);
                return;
            }
            int childCount = toolbar.getChildCount();
            if (childCount != 0) {
                for (int i = 0; i < childCount; i++) {
                    calligraphy.onViewCreated(toolbar.getChildAt(i), context, null);
                }
            }
            removeSelf(toolbar);
            toolbar.setSubtitle(this.originalSubTitle);
        }

        private void removeSelf(Toolbar toolbar) {
            if (Build.VERSION.SDK_INT < 16) {
                toolbar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }
}
