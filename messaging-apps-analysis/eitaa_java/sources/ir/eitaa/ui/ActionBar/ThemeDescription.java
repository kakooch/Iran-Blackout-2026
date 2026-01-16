package ir.eitaa.ui.ActionBar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.SpannedString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AnimatedArrowDrawable;
import ir.eitaa.ui.Components.AudioPlayerAlert;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.ChatBigEmptyView;
import ir.eitaa.ui.Components.CheckBox;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EditTextCaption;
import ir.eitaa.ui.Components.EditTextEmoji;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.GroupCreateCheckBox;
import ir.eitaa.ui.Components.GroupCreateSpan;
import ir.eitaa.ui.Components.LetterDrawable;
import ir.eitaa.ui.Components.LineProgressView;
import ir.eitaa.ui.Components.MessageBackgroundDrawable;
import ir.eitaa.ui.Components.NumberTextView;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RadioButton;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScamDrawable;
import ir.eitaa.ui.Components.SeekBarView;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.VideoTimelineView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ThemeDescription {
    public static int FLAG_AB_AM_BACKGROUND = 1048576;
    public static int FLAG_AB_AM_ITEMSCOLOR = 512;
    public static int FLAG_AB_AM_SELECTORCOLOR = 4194304;
    public static int FLAG_AB_AM_TOPBACKGROUND = 2097152;
    public static int FLAG_AB_ITEMSCOLOR = 64;
    public static int FLAG_AB_SEARCH = 134217728;
    public static int FLAG_AB_SEARCHPLACEHOLDER = 67108864;
    public static int FLAG_AB_SELECTORCOLOR = 256;
    public static int FLAG_AB_SUBMENUBACKGROUND = Integer.MIN_VALUE;
    public static int FLAG_AB_SUBMENUITEM = 1073741824;
    public static int FLAG_AB_SUBTITLECOLOR = 1024;
    public static int FLAG_AB_TITLECOLOR = 128;
    public static int FLAG_BACKGROUND = 1;
    public static int FLAG_BACKGROUNDFILTER = 32;
    public static int FLAG_CELLBACKGROUNDCOLOR = 16;
    public static int FLAG_CHECKBOX = 8192;
    public static int FLAG_CHECKBOXCHECK = 16384;
    public static int FLAG_CHECKTAG = 262144;
    public static int FLAG_CURSORCOLOR = 16777216;
    public static int FLAG_DRAWABLESELECTEDSTATE = 65536;
    public static int FLAG_FASTSCROLL = 33554432;
    public static int FLAG_HINTTEXTCOLOR = 8388608;
    public static int FLAG_IMAGECOLOR = 8;
    public static int FLAG_LINKCOLOR = 2;
    public static int FLAG_LISTGLOWCOLOR = 32768;
    public static int FLAG_PROGRESSBAR = 2048;
    public static int FLAG_SECTIONS = 524288;
    public static int FLAG_SELECTOR = 4096;
    public static int FLAG_SELECTORWHITE = 268435456;
    public static int FLAG_SERVICEBACKGROUND = 536870912;
    public static int FLAG_TEXTCOLOR = 4;
    public static int FLAG_USEBACKGROUNDDRAWABLE = 131072;
    private int alphaOverride;
    private HashMap<String, Field> cachedFields;
    private int changeFlags;
    private int currentColor;
    private String currentKey;
    private ThemeDescriptionDelegate delegate;
    private Drawable[] drawablesToUpdate;
    private Class[] listClasses;
    private String[] listClassesFieldName;
    private String lottieLayerName;
    private HashMap<String, Boolean> notFoundCachedFields;
    private Paint[] paintToUpdate;
    private int previousColor;
    private boolean[] previousIsDefault;
    public Theme.ResourcesProvider resourcesProvider;
    private View viewToInvalidate;

    public interface ThemeDescriptionDelegate {

        /* renamed from: ir.eitaa.ui.ActionBar.ThemeDescription$ThemeDescriptionDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onAnimationProgress(ThemeDescriptionDelegate themeDescriptionDelegate, float f) {
            }
        }

        void didSetColor();

        void onAnimationProgress(float progress);
    }

    public ThemeDescription(View view, int flags, Class[] classes, Paint[] paint, Drawable[] drawables, ThemeDescriptionDelegate themeDescriptionDelegate, String key, Object unused) {
        this.alphaOverride = -1;
        this.previousIsDefault = new boolean[1];
        this.currentKey = key;
        this.paintToUpdate = paint;
        this.drawablesToUpdate = drawables;
        this.viewToInvalidate = view;
        this.changeFlags = flags;
        this.listClasses = classes;
        this.delegate = themeDescriptionDelegate;
        if (view instanceof EditTextEmoji) {
            this.viewToInvalidate = ((EditTextEmoji) view).getEditText();
        }
    }

    public ThemeDescription(View view, int flags, Class[] classes, Paint paint, Drawable[] drawables, ThemeDescriptionDelegate themeDescriptionDelegate, String key) {
        this.alphaOverride = -1;
        this.previousIsDefault = new boolean[1];
        this.currentKey = key;
        if (paint != null) {
            this.paintToUpdate = new Paint[]{paint};
        }
        this.drawablesToUpdate = drawables;
        this.viewToInvalidate = view;
        this.changeFlags = flags;
        this.listClasses = classes;
        this.delegate = themeDescriptionDelegate;
        if (view instanceof EditTextEmoji) {
            this.viewToInvalidate = ((EditTextEmoji) view).getEditText();
        }
    }

    public ThemeDescription(View view, int flags, Class[] classes, RLottieDrawable[] drawables, String layerName, String key) {
        this.alphaOverride = -1;
        this.previousIsDefault = new boolean[1];
        this.currentKey = key;
        this.lottieLayerName = layerName;
        this.drawablesToUpdate = drawables;
        this.viewToInvalidate = view;
        this.changeFlags = flags;
        this.listClasses = classes;
        if (view instanceof EditTextEmoji) {
            this.viewToInvalidate = ((EditTextEmoji) view).getEditText();
        }
    }

    public ThemeDescription(View view, int flags, Class[] classes, String[] classesFields, Paint[] paint, Drawable[] drawables, ThemeDescriptionDelegate themeDescriptionDelegate, String key) {
        this(view, flags, classes, classesFields, paint, drawables, -1, themeDescriptionDelegate, key);
    }

    public ThemeDescription(View view, int flags, Class[] classes, String[] classesFields, Paint[] paint, Drawable[] drawables, int alpha, ThemeDescriptionDelegate themeDescriptionDelegate, String key) {
        this.alphaOverride = -1;
        this.previousIsDefault = new boolean[1];
        this.currentKey = key;
        this.paintToUpdate = paint;
        this.drawablesToUpdate = drawables;
        this.viewToInvalidate = view;
        this.changeFlags = flags;
        this.listClasses = classes;
        this.listClassesFieldName = classesFields;
        this.alphaOverride = alpha;
        this.delegate = themeDescriptionDelegate;
        this.cachedFields = new HashMap<>();
        this.notFoundCachedFields = new HashMap<>();
        View view2 = this.viewToInvalidate;
        if (view2 instanceof EditTextEmoji) {
            this.viewToInvalidate = ((EditTextEmoji) view2).getEditText();
        }
    }

    public ThemeDescription(View view, int flags, Class[] classes, String[] classesFields, String layerName, String key) {
        this.alphaOverride = -1;
        this.previousIsDefault = new boolean[1];
        this.currentKey = key;
        this.lottieLayerName = layerName;
        this.viewToInvalidate = view;
        this.changeFlags = flags;
        this.listClasses = classes;
        this.listClassesFieldName = classesFields;
        this.cachedFields = new HashMap<>();
        this.notFoundCachedFields = new HashMap<>();
        View view2 = this.viewToInvalidate;
        if (view2 instanceof EditTextEmoji) {
            this.viewToInvalidate = ((EditTextEmoji) view2).getEditText();
        }
    }

    public ThemeDescriptionDelegate setDelegateDisabled() {
        ThemeDescriptionDelegate themeDescriptionDelegate = this.delegate;
        this.delegate = null;
        return themeDescriptionDelegate;
    }

    public void setColor(int color, boolean useDefault) throws NoSuchFieldException {
        setColor(color, useDefault, true);
    }

    private boolean checkTag(String key, View view) {
        if (key != null && view != null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                return ((String) tag).contains(key);
            }
        }
        return false;
    }

    public void setColor(int color, boolean useDefault, boolean save) throws NoSuchFieldException {
        Class[] clsArr;
        Drawable[] compoundDrawables;
        if (save) {
            Theme.setColor(this.currentKey, color, useDefault);
        }
        this.currentColor = color;
        int i = this.alphaOverride;
        if (i > 0) {
            color = Color.argb(i, Color.red(color), Color.green(color), Color.blue(color));
        }
        if (this.paintToUpdate != null) {
            int i2 = 0;
            while (true) {
                Paint[] paintArr = this.paintToUpdate;
                if (i2 >= paintArr.length) {
                    break;
                }
                if ((this.changeFlags & FLAG_LINKCOLOR) != 0 && (paintArr[i2] instanceof TextPaint)) {
                    ((TextPaint) paintArr[i2]).linkColor = color;
                } else {
                    paintArr[i2].setColor(color);
                }
                i2++;
            }
        }
        if (this.drawablesToUpdate != null) {
            int i3 = 0;
            while (true) {
                Drawable[] drawableArr = this.drawablesToUpdate;
                if (i3 >= drawableArr.length) {
                    break;
                }
                if (drawableArr[i3] != null) {
                    if (drawableArr[i3] instanceof BackDrawable) {
                        ((BackDrawable) drawableArr[i3]).setColor(color);
                    } else if (drawableArr[i3] instanceof ScamDrawable) {
                        ((ScamDrawable) drawableArr[i3]).setColor(color);
                    } else if (drawableArr[i3] instanceof RLottieDrawable) {
                        if (this.lottieLayerName != null) {
                            ((RLottieDrawable) drawableArr[i3]).setLayerColor(this.lottieLayerName + ".**", color);
                        }
                    } else if (drawableArr[i3] instanceof CombinedDrawable) {
                        if ((this.changeFlags & FLAG_BACKGROUNDFILTER) != 0) {
                            ((CombinedDrawable) drawableArr[i3]).getBackground().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                        } else {
                            ((CombinedDrawable) drawableArr[i3]).getIcon().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                        }
                    } else if (drawableArr[i3] instanceof AvatarDrawable) {
                        ((AvatarDrawable) drawableArr[i3]).setColor(color);
                    } else if (drawableArr[i3] instanceof AnimatedArrowDrawable) {
                        ((AnimatedArrowDrawable) drawableArr[i3]).setColor(color);
                    } else {
                        drawableArr[i3].setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                    }
                }
                i3++;
            }
        }
        View view = this.viewToInvalidate;
        if (view != null && this.listClasses == null && this.listClassesFieldName == null && ((this.changeFlags & FLAG_CHECKTAG) == 0 || checkTag(this.currentKey, view))) {
            if ((this.changeFlags & FLAG_BACKGROUND) != 0) {
                Drawable background = this.viewToInvalidate.getBackground();
                if (background instanceof MessageBackgroundDrawable) {
                    ((MessageBackgroundDrawable) background).setColor(color);
                } else {
                    this.viewToInvalidate.setBackgroundColor(color);
                }
            }
            int i4 = this.changeFlags;
            if ((FLAG_BACKGROUNDFILTER & i4) != 0) {
                if ((i4 & FLAG_PROGRESSBAR) != 0) {
                    View view2 = this.viewToInvalidate;
                    if (view2 instanceof EditTextBoldCursor) {
                        ((EditTextBoldCursor) view2).setErrorLineColor(color);
                    }
                } else {
                    Drawable background2 = this.viewToInvalidate.getBackground();
                    if (background2 instanceof CombinedDrawable) {
                        if ((this.changeFlags & FLAG_DRAWABLESELECTEDSTATE) != 0) {
                            background2 = ((CombinedDrawable) background2).getBackground();
                        } else {
                            background2 = ((CombinedDrawable) background2).getIcon();
                        }
                    }
                    if (background2 != null) {
                        if ((background2 instanceof StateListDrawable) || (Build.VERSION.SDK_INT >= 21 && (background2 instanceof RippleDrawable))) {
                            Theme.setSelectorDrawableColor(background2, color, (this.changeFlags & FLAG_DRAWABLESELECTEDSTATE) != 0);
                        } else if (background2 instanceof ShapeDrawable) {
                            ((ShapeDrawable) background2).getPaint().setColor(color);
                        } else {
                            background2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                        }
                    }
                }
            }
        }
        View view3 = this.viewToInvalidate;
        if (view3 instanceof ActionBar) {
            if ((this.changeFlags & FLAG_AB_ITEMSCOLOR) != 0) {
                ((ActionBar) view3).setItemsColor(color, false);
            }
            if ((this.changeFlags & FLAG_AB_TITLECOLOR) != 0) {
                ((ActionBar) this.viewToInvalidate).setTitleColor(color);
            }
            if ((this.changeFlags & FLAG_AB_SELECTORCOLOR) != 0) {
                ((ActionBar) this.viewToInvalidate).setItemsBackgroundColor(color, false);
            }
            if ((this.changeFlags & FLAG_AB_AM_SELECTORCOLOR) != 0) {
                ((ActionBar) this.viewToInvalidate).setItemsBackgroundColor(color, true);
            }
            if ((this.changeFlags & FLAG_AB_AM_ITEMSCOLOR) != 0) {
                ((ActionBar) this.viewToInvalidate).setItemsColor(color, true);
            }
            if ((this.changeFlags & FLAG_AB_SUBTITLECOLOR) != 0) {
                ((ActionBar) this.viewToInvalidate).setSubtitleColor(color);
            }
            if ((this.changeFlags & FLAG_AB_AM_BACKGROUND) != 0) {
                ((ActionBar) this.viewToInvalidate).setActionModeColor(color);
            }
            if ((this.changeFlags & FLAG_AB_AM_TOPBACKGROUND) != 0) {
                ((ActionBar) this.viewToInvalidate).setActionModeTopColor(color);
            }
            if ((this.changeFlags & FLAG_AB_SEARCHPLACEHOLDER) != 0) {
                ((ActionBar) this.viewToInvalidate).setSearchTextColor(color, true);
            }
            if ((this.changeFlags & FLAG_AB_SEARCH) != 0) {
                ((ActionBar) this.viewToInvalidate).setSearchTextColor(color, false);
            }
            int i5 = this.changeFlags;
            if ((FLAG_AB_SUBMENUITEM & i5) != 0) {
                ((ActionBar) this.viewToInvalidate).setPopupItemsColor(color, (i5 & FLAG_IMAGECOLOR) != 0, false);
            }
            if ((this.changeFlags & FLAG_AB_SUBMENUBACKGROUND) != 0) {
                ((ActionBar) this.viewToInvalidate).setPopupBackgroundColor(color, false);
            }
        }
        View view4 = this.viewToInvalidate;
        if (view4 instanceof VideoTimelineView) {
            ((VideoTimelineView) view4).setColor(color);
        }
        View view5 = this.viewToInvalidate;
        if (view5 instanceof EmptyTextProgressView) {
            int i6 = this.changeFlags;
            if ((FLAG_TEXTCOLOR & i6) != 0) {
                ((EmptyTextProgressView) view5).setTextColor(color);
            } else if ((i6 & FLAG_PROGRESSBAR) != 0) {
                ((EmptyTextProgressView) view5).setProgressBarColor(color);
            }
        }
        View view6 = this.viewToInvalidate;
        if (view6 instanceof RadialProgressView) {
            ((RadialProgressView) view6).setProgressColor(color);
        } else if (view6 instanceof LineProgressView) {
            if ((this.changeFlags & FLAG_PROGRESSBAR) != 0) {
                ((LineProgressView) view6).setProgressColor(color);
            } else {
                ((LineProgressView) view6).setBackColor(color);
            }
        } else if (view6 instanceof ContextProgressView) {
            ((ContextProgressView) view6).updateColors();
        } else if ((view6 instanceof SeekBarView) && (this.changeFlags & FLAG_PROGRESSBAR) != 0) {
            ((SeekBarView) view6).setOuterColor(color);
        }
        int i7 = this.changeFlags;
        if ((FLAG_TEXTCOLOR & i7) != 0 && ((i7 & FLAG_CHECKTAG) == 0 || checkTag(this.currentKey, this.viewToInvalidate))) {
            View view7 = this.viewToInvalidate;
            if (view7 instanceof TextView) {
                ((TextView) view7).setTextColor(color);
            } else if (view7 instanceof NumberTextView) {
                ((NumberTextView) view7).setTextColor(color);
            } else if (view7 instanceof SimpleTextView) {
                ((SimpleTextView) view7).setTextColor(color);
            } else if (view7 instanceof ChatBigEmptyView) {
                ((ChatBigEmptyView) view7).setTextColor(color);
            }
        }
        if ((this.changeFlags & FLAG_CURSORCOLOR) != 0) {
            View view8 = this.viewToInvalidate;
            if (view8 instanceof EditTextBoldCursor) {
                ((EditTextBoldCursor) view8).setCursorColor(color);
            }
        }
        int i8 = this.changeFlags;
        if ((FLAG_HINTTEXTCOLOR & i8) != 0) {
            View view9 = this.viewToInvalidate;
            if (view9 instanceof EditTextBoldCursor) {
                if ((i8 & FLAG_PROGRESSBAR) != 0) {
                    ((EditTextBoldCursor) view9).setHeaderHintColor(color);
                } else {
                    ((EditTextBoldCursor) view9).setHintColor(color);
                }
            } else if (view9 instanceof EditText) {
                ((EditText) view9).setHintTextColor(color);
            }
        }
        View view10 = this.viewToInvalidate;
        int i9 = this.changeFlags;
        if ((FLAG_IMAGECOLOR & i9) != 0 && ((i9 & FLAG_CHECKTAG) == 0 || checkTag(this.currentKey, view10))) {
            View view11 = this.viewToInvalidate;
            if (view11 instanceof ImageView) {
                if ((this.changeFlags & FLAG_USEBACKGROUNDDRAWABLE) != 0) {
                    Drawable drawable = ((ImageView) view11).getDrawable();
                    if ((drawable instanceof StateListDrawable) || (Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable))) {
                        Theme.setSelectorDrawableColor(drawable, color, (this.changeFlags & FLAG_DRAWABLESELECTEDSTATE) != 0);
                    }
                } else {
                    ((ImageView) view11).setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                }
            } else if (!(view11 instanceof BackupImageView)) {
                if (view11 instanceof SimpleTextView) {
                    ((SimpleTextView) view11).setSideDrawablesColor(color);
                } else if ((view11 instanceof TextView) && (compoundDrawables = ((TextView) view11).getCompoundDrawables()) != null) {
                    for (int i10 = 0; i10 < compoundDrawables.length; i10++) {
                        if (compoundDrawables[i10] != null) {
                            compoundDrawables[i10].setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                        }
                    }
                }
            }
        }
        View view12 = this.viewToInvalidate;
        if ((view12 instanceof ScrollView) && (this.changeFlags & FLAG_LISTGLOWCOLOR) != 0) {
            AndroidUtilities.setScrollViewEdgeEffectColor((ScrollView) view12, color);
        }
        View view13 = this.viewToInvalidate;
        if ((view13 instanceof ViewPager) && (this.changeFlags & FLAG_LISTGLOWCOLOR) != 0) {
            AndroidUtilities.setViewPagerEdgeEffectColor((ViewPager) view13, color);
        }
        View view14 = this.viewToInvalidate;
        if (view14 instanceof RecyclerListView) {
            RecyclerListView recyclerListView = (RecyclerListView) view14;
            if ((this.changeFlags & FLAG_SELECTOR) != 0) {
                recyclerListView.setListSelectorColor(color);
            }
            if ((this.changeFlags & FLAG_FASTSCROLL) != 0) {
                recyclerListView.updateFastScrollColors();
            }
            if ((this.changeFlags & FLAG_LISTGLOWCOLOR) != 0) {
                recyclerListView.setGlowColor(color);
            }
            if ((this.changeFlags & FLAG_SECTIONS) != 0) {
                ArrayList<View> headers = recyclerListView.getHeaders();
                if (headers != null) {
                    for (int i11 = 0; i11 < headers.size(); i11++) {
                        processViewColor(headers.get(i11), color);
                    }
                }
                ArrayList<View> headersCache = recyclerListView.getHeadersCache();
                if (headersCache != null) {
                    for (int i12 = 0; i12 < headersCache.size(); i12++) {
                        processViewColor(headersCache.get(i12), color);
                    }
                }
                View pinnedHeader = recyclerListView.getPinnedHeader();
                if (pinnedHeader != null) {
                    processViewColor(pinnedHeader, color);
                }
            }
        } else if (view14 != null && ((clsArr = this.listClasses) == null || clsArr.length == 0)) {
            int i13 = this.changeFlags;
            if ((FLAG_SELECTOR & i13) != 0) {
                view14.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            } else if ((i13 & FLAG_SELECTORWHITE) != 0) {
                view14.setBackgroundDrawable(Theme.getSelectorDrawable(true));
            }
        }
        if (this.listClasses != null) {
            View view15 = this.viewToInvalidate;
            if (view15 instanceof RecyclerListView) {
                RecyclerListView recyclerListView2 = (RecyclerListView) view15;
                recyclerListView2.getRecycledViewPool().clear();
                int hiddenChildCount = recyclerListView2.getHiddenChildCount();
                for (int i14 = 0; i14 < hiddenChildCount; i14++) {
                    processViewColor(recyclerListView2.getHiddenChildAt(i14), color);
                }
                int cachedChildCount = recyclerListView2.getCachedChildCount();
                for (int i15 = 0; i15 < cachedChildCount; i15++) {
                    processViewColor(recyclerListView2.getCachedChildAt(i15), color);
                }
                int attachedScrapChildCount = recyclerListView2.getAttachedScrapChildCount();
                for (int i16 = 0; i16 < attachedScrapChildCount; i16++) {
                    processViewColor(recyclerListView2.getAttachedScrapChildAt(i16), color);
                }
            }
            View view16 = this.viewToInvalidate;
            if (view16 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view16;
                int childCount = viewGroup.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    processViewColor(viewGroup.getChildAt(i17), color);
                }
            }
            processViewColor(this.viewToInvalidate, color);
        }
        ThemeDescriptionDelegate themeDescriptionDelegate = this.delegate;
        if (themeDescriptionDelegate != null) {
            themeDescriptionDelegate.didSetColor();
        }
        View view17 = this.viewToInvalidate;
        if (view17 != null) {
            view17.invalidate();
        }
    }

    private void processViewColor(View child, int color) {
        boolean z;
        Object background;
        TypefaceSpan[] typefaceSpanArr;
        TypefaceSpan[] typefaceSpanArr2;
        TypefaceSpan[] typefaceSpanArr3;
        int i = 0;
        while (true) {
            Class[] clsArr = this.listClasses;
            if (i >= clsArr.length) {
                return;
            }
            if (clsArr[i].isInstance(child)) {
                child.invalidate();
                boolean z2 = true;
                if ((this.changeFlags & FLAG_CHECKTAG) == 0 || checkTag(this.currentKey, child)) {
                    child.invalidate();
                    if (this.listClassesFieldName == null && (this.changeFlags & FLAG_BACKGROUNDFILTER) != 0) {
                        Drawable background2 = child.getBackground();
                        if (background2 != null) {
                            int i2 = this.changeFlags;
                            if ((FLAG_CELLBACKGROUNDCOLOR & i2) != 0) {
                                if (background2 instanceof CombinedDrawable) {
                                    Drawable background3 = ((CombinedDrawable) background2).getBackground();
                                    if (background3 instanceof ColorDrawable) {
                                        ((ColorDrawable) background3).setColor(color);
                                    }
                                }
                            } else {
                                if (background2 instanceof CombinedDrawable) {
                                    background2 = ((CombinedDrawable) background2).getIcon();
                                } else if ((background2 instanceof StateListDrawable) || (Build.VERSION.SDK_INT >= 21 && (background2 instanceof RippleDrawable))) {
                                    Theme.setSelectorDrawableColor(background2, color, (i2 & FLAG_DRAWABLESELECTEDSTATE) != 0);
                                }
                                background2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                            }
                        }
                    } else {
                        int i3 = this.changeFlags;
                        if ((FLAG_CELLBACKGROUNDCOLOR & i3) != 0) {
                            child.setBackgroundColor(color);
                        } else if ((FLAG_TEXTCOLOR & i3) != 0) {
                            if (child instanceof TextView) {
                                ((TextView) child).setTextColor(color);
                            } else if (child instanceof AudioPlayerAlert.ClippingTextViewSwitcher) {
                                int i4 = 0;
                                while (i4 < 2) {
                                    AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = (AudioPlayerAlert.ClippingTextViewSwitcher) child;
                                    TextView textView = i4 == 0 ? clippingTextViewSwitcher.getTextView() : clippingTextViewSwitcher.getNextTextView();
                                    if (textView != null) {
                                        textView.setTextColor(color);
                                    }
                                    i4++;
                                }
                            }
                        } else if ((FLAG_SERVICEBACKGROUND & i3) == 0) {
                            if ((FLAG_SELECTOR & i3) != 0) {
                                child.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                            } else if ((i3 & FLAG_SELECTORWHITE) != 0) {
                                child.setBackgroundDrawable(Theme.getSelectorDrawable(true));
                            }
                        }
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (this.listClassesFieldName != null) {
                    String str = this.listClasses[i] + "_" + this.listClassesFieldName[i];
                    HashMap<String, Boolean> map = this.notFoundCachedFields;
                    if (map == null || !map.containsKey(str)) {
                        try {
                            Field declaredField = this.cachedFields.get(str);
                            if (declaredField == null && (declaredField = this.listClasses[i].getDeclaredField(this.listClassesFieldName[i])) != null) {
                                declaredField.setAccessible(true);
                                this.cachedFields.put(str, declaredField);
                            }
                            if (declaredField != null && (background = declaredField.get(child)) != null && (z || !(background instanceof View) || checkTag(this.currentKey, (View) background))) {
                                if (background instanceof View) {
                                    ((View) background).invalidate();
                                }
                                if (this.lottieLayerName != null && (background instanceof RLottieImageView)) {
                                    ((RLottieImageView) background).setLayerColor(this.lottieLayerName + ".**", color);
                                }
                                if ((this.changeFlags & FLAG_USEBACKGROUNDDRAWABLE) != 0 && (background instanceof View)) {
                                    background = ((View) background).getBackground();
                                }
                                int i5 = this.changeFlags;
                                if ((FLAG_BACKGROUND & i5) != 0 && (background instanceof View)) {
                                    View view = (View) background;
                                    Drawable background4 = view.getBackground();
                                    if (background4 instanceof MessageBackgroundDrawable) {
                                        ((MessageBackgroundDrawable) background4).setColor(color);
                                    } else {
                                        view.setBackgroundColor(color);
                                    }
                                } else if (background instanceof EditTextCaption) {
                                    if ((FLAG_HINTTEXTCOLOR & i5) != 0) {
                                        ((EditTextCaption) background).setHintColor(color);
                                        ((EditTextCaption) background).setHintTextColor(color);
                                    } else if ((i5 & FLAG_CURSORCOLOR) != 0) {
                                        ((EditTextCaption) background).setCursorColor(color);
                                    } else {
                                        ((EditTextCaption) background).setTextColor(color);
                                    }
                                } else if (background instanceof SimpleTextView) {
                                    if ((i5 & FLAG_LINKCOLOR) != 0) {
                                        ((SimpleTextView) background).setLinkTextColor(color);
                                    } else {
                                        ((SimpleTextView) background).setTextColor(color);
                                    }
                                } else if (background instanceof TextView) {
                                    TextView textView2 = (TextView) background;
                                    if ((FLAG_IMAGECOLOR & i5) != 0) {
                                        Drawable[] compoundDrawables = textView2.getCompoundDrawables();
                                        if (compoundDrawables != null) {
                                            for (int i6 = 0; i6 < compoundDrawables.length; i6++) {
                                                if (compoundDrawables[i6] != null) {
                                                    compoundDrawables[i6].setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                                }
                                            }
                                        }
                                    } else if ((FLAG_LINKCOLOR & i5) != 0) {
                                        textView2.getPaint().linkColor = color;
                                        textView2.invalidate();
                                    } else if ((i5 & FLAG_FASTSCROLL) != 0) {
                                        CharSequence text = textView2.getText();
                                        if ((text instanceof SpannedString) && (typefaceSpanArr3 = (TypefaceSpan[]) ((SpannedString) text).getSpans(0, text.length(), TypefaceSpan.class)) != null && typefaceSpanArr3.length > 0) {
                                            for (TypefaceSpan typefaceSpan : typefaceSpanArr3) {
                                                typefaceSpan.setColor(color);
                                            }
                                        }
                                    } else {
                                        textView2.setTextColor(color);
                                    }
                                } else if (background instanceof ImageView) {
                                    ImageView imageView = (ImageView) background;
                                    Drawable drawable = imageView.getDrawable();
                                    if (drawable instanceof CombinedDrawable) {
                                        if ((this.changeFlags & FLAG_BACKGROUNDFILTER) != 0) {
                                            ((CombinedDrawable) drawable).getBackground().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                        } else {
                                            ((CombinedDrawable) drawable).getIcon().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                        }
                                    } else {
                                        imageView.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                    }
                                } else if (background instanceof BackupImageView) {
                                    Drawable staticThumb = ((BackupImageView) background).getImageReceiver().getStaticThumb();
                                    if (staticThumb instanceof CombinedDrawable) {
                                        if ((this.changeFlags & FLAG_BACKGROUNDFILTER) != 0) {
                                            ((CombinedDrawable) staticThumb).getBackground().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                        } else {
                                            ((CombinedDrawable) staticThumb).getIcon().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                        }
                                    } else if (staticThumb != null) {
                                        staticThumb.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                    }
                                } else if (background instanceof Drawable) {
                                    if (background instanceof LetterDrawable) {
                                        if ((i5 & FLAG_BACKGROUNDFILTER) != 0) {
                                            ((LetterDrawable) background).setBackgroundColor(color);
                                        } else {
                                            ((LetterDrawable) background).setColor(color);
                                        }
                                    } else if (background instanceof CombinedDrawable) {
                                        if ((i5 & FLAG_BACKGROUNDFILTER) != 0) {
                                            ((CombinedDrawable) background).getBackground().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                        } else {
                                            ((CombinedDrawable) background).getIcon().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                        }
                                    } else if ((background instanceof StateListDrawable) || (Build.VERSION.SDK_INT >= 21 && (background instanceof RippleDrawable))) {
                                        Drawable drawable2 = (Drawable) background;
                                        if ((i5 & FLAG_DRAWABLESELECTEDSTATE) == 0) {
                                            z2 = false;
                                        }
                                        Theme.setSelectorDrawableColor(drawable2, color, z2);
                                    } else if (background instanceof GradientDrawable) {
                                        ((GradientDrawable) background).setColor(color);
                                    } else {
                                        ((Drawable) background).setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                                    }
                                } else if (background instanceof CheckBox) {
                                    if ((FLAG_CHECKBOX & i5) != 0) {
                                        ((CheckBox) background).setBackgroundColor(color);
                                    } else if ((i5 & FLAG_CHECKBOXCHECK) != 0) {
                                        ((CheckBox) background).setCheckColor(color);
                                    }
                                } else if (background instanceof GroupCreateCheckBox) {
                                    ((GroupCreateCheckBox) background).updateColors();
                                } else if (background instanceof Integer) {
                                    declaredField.set(child, Integer.valueOf(color));
                                } else if (background instanceof RadioButton) {
                                    if ((FLAG_CHECKBOX & i5) != 0) {
                                        ((RadioButton) background).setBackgroundColor(color);
                                        ((RadioButton) background).invalidate();
                                    } else if ((i5 & FLAG_CHECKBOXCHECK) != 0) {
                                        ((RadioButton) background).setCheckedColor(color);
                                        ((RadioButton) background).invalidate();
                                    }
                                } else if (background instanceof TextPaint) {
                                    if ((i5 & FLAG_LINKCOLOR) != 0) {
                                        ((TextPaint) background).linkColor = color;
                                    } else {
                                        ((TextPaint) background).setColor(color);
                                    }
                                } else if (background instanceof LineProgressView) {
                                    if ((i5 & FLAG_PROGRESSBAR) != 0) {
                                        ((LineProgressView) background).setProgressColor(color);
                                    } else {
                                        ((LineProgressView) background).setBackColor(color);
                                    }
                                } else if (background instanceof RadialProgressView) {
                                    ((RadialProgressView) background).setProgressColor(color);
                                } else if (background instanceof Paint) {
                                    ((Paint) background).setColor(color);
                                    child.invalidate();
                                } else if (background instanceof SeekBarView) {
                                    if ((i5 & FLAG_PROGRESSBAR) != 0) {
                                        ((SeekBarView) background).setOuterColor(color);
                                    } else {
                                        ((SeekBarView) background).setInnerColor(color);
                                    }
                                } else if (background instanceof AudioPlayerAlert.ClippingTextViewSwitcher) {
                                    if ((FLAG_FASTSCROLL & i5) != 0) {
                                        int i7 = 0;
                                        while (i7 < 2) {
                                            TextView textView3 = i7 == 0 ? ((AudioPlayerAlert.ClippingTextViewSwitcher) background).getTextView() : ((AudioPlayerAlert.ClippingTextViewSwitcher) background).getNextTextView();
                                            if (textView3 != null) {
                                                CharSequence text2 = textView3.getText();
                                                if ((text2 instanceof SpannedString) && (typefaceSpanArr2 = (TypefaceSpan[]) ((SpannedString) text2).getSpans(0, text2.length(), TypefaceSpan.class)) != null && typefaceSpanArr2.length > 0) {
                                                    for (TypefaceSpan typefaceSpan2 : typefaceSpanArr2) {
                                                        typefaceSpan2.setColor(color);
                                                    }
                                                }
                                            }
                                            i7++;
                                        }
                                    } else if ((FLAG_TEXTCOLOR & i5) != 0 && ((i5 & FLAG_CHECKTAG) == 0 || checkTag(this.currentKey, (View) background))) {
                                        int i8 = 0;
                                        while (i8 < 2) {
                                            TextView textView4 = i8 == 0 ? ((AudioPlayerAlert.ClippingTextViewSwitcher) background).getTextView() : ((AudioPlayerAlert.ClippingTextViewSwitcher) background).getNextTextView();
                                            if (textView4 != null) {
                                                textView4.setTextColor(color);
                                                CharSequence text3 = textView4.getText();
                                                if ((text3 instanceof SpannedString) && (typefaceSpanArr = (TypefaceSpan[]) ((SpannedString) text3).getSpans(0, text3.length(), TypefaceSpan.class)) != null && typefaceSpanArr.length > 0) {
                                                    for (TypefaceSpan typefaceSpan3 : typefaceSpanArr) {
                                                        typefaceSpan3.setColor(color);
                                                    }
                                                }
                                            }
                                            i8++;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            FileLog.e(th);
                            this.notFoundCachedFields.put(str, Boolean.TRUE);
                        }
                    }
                } else if (child instanceof GroupCreateSpan) {
                    ((GroupCreateSpan) child).updateColors();
                }
            }
            i++;
        }
    }

    public String getCurrentKey() {
        return this.currentKey;
    }

    public void startEditing() {
        int color = Theme.getColor(this.currentKey, this.previousIsDefault);
        this.previousColor = color;
        this.currentColor = color;
    }

    public int getCurrentColor() {
        return this.currentColor;
    }

    public int getSetColor() {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(this.currentKey) : null;
        return color != null ? color.intValue() : Theme.getColor(this.currentKey);
    }

    public void setAnimatedColor(int color) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        if (resourcesProvider != null) {
            resourcesProvider.setAnimatedColor(getCurrentKey(), color);
        } else {
            Theme.setAnimatedColor(getCurrentKey(), color);
        }
    }

    public void setDefaultColor() throws NoSuchFieldException {
        setColor(Theme.getDefaultColor(this.currentKey), true);
    }

    public void setPreviousColor() throws NoSuchFieldException {
        setColor(this.previousColor, this.previousIsDefault[0]);
    }

    public String getTitle() {
        if (LocaleController.getInstance().isFarsi()) {
            Context context = ApplicationLoader.applicationContext;
            try {
                return context.getResources().getString(context.getResources().getIdentifier(this.currentKey, "string", context.getPackageName()));
            } catch (Exception unused) {
                return this.currentKey;
            }
        }
        return this.currentKey;
    }
}
