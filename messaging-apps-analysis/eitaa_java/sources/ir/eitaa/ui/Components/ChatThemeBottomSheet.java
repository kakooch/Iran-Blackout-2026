package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.util.ObjectsCompat$Api19Impl$$ExternalSynthetic0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatThemeController;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.ResultCallback;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.ChatTheme;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.RecyclerListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatThemeBottomSheet extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private final Adapter adapter;
    private final View applyButton;
    private TextView applyTextView;
    private View changeDayNightView;
    private ValueAnimator changeDayNightViewAnimator;
    private float changeDayNightViewProgress;
    private final ChatActivity chatActivity;
    private final RLottieDrawable darkThemeDrawable;
    private final RLottieImageView darkThemeView;
    private boolean forceDark;
    HintView hintView;
    private boolean isApplyClicked;
    private boolean isLightDarkChangeAnimation;
    private final LinearLayoutManager layoutManager;
    private final boolean originalIsDark;
    private final ChatTheme originalTheme;
    private int prevSelectedPosition;
    private final FlickerLoadingView progressView;
    private final RecyclerListView recyclerView;
    private TextView resetTextView;
    private final LinearSmoothScroller scroller;
    private ChatThemeItem selectedItem;
    private final ChatActivity.ThemeDelegate themeDelegate;
    private final TextView titleView;

    public ChatThemeBottomSheet(final ChatActivity chatActivity, final ChatActivity.ThemeDelegate themeDelegate) throws InterruptedException {
        int i;
        String str;
        super(chatActivity.getParentActivity(), true, themeDelegate);
        this.prevSelectedPosition = -1;
        this.chatActivity = chatActivity;
        this.themeDelegate = themeDelegate;
        this.originalTheme = themeDelegate.getCurrentTheme();
        this.originalIsDark = Theme.getActiveTheme().isDark();
        Adapter adapter = new Adapter(themeDelegate);
        this.adapter = adapter;
        setDimBehind(false);
        setCanDismissWithSwipe(false);
        setApplyBottomPadding(false);
        FrameLayout frameLayout = new FrameLayout(getContext());
        setCustomView(frameLayout);
        TextView textView = new TextView(getContext());
        this.titleView = textView;
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setLines(1);
        textView.setSingleLine(true);
        textView.setText(LocaleController.getString("SelectTheme", R.string.SelectTheme));
        textView.setTextColor(getThemedColor("dialogTextBlack"));
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f));
        frameLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 8388659, 0.0f, 0.0f, 62.0f, 0.0f));
        int themedColor = getThemedColor("featuredStickers_addButton");
        int iDp = AndroidUtilities.dp(28.0f);
        RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.sun_outline, "2131624029", iDp, iDp, true, (int[]) null);
        this.darkThemeDrawable = rLottieDrawable;
        rLottieDrawable.setPlayInDirectionOfCustomEndFrame(true);
        rLottieDrawable.beginApplyLayerColors();
        setDarkButtonColor(themedColor);
        rLottieDrawable.commitApplyLayerColors();
        RLottieImageView rLottieImageView = new RLottieImageView(getContext());
        this.darkThemeView = rLottieImageView;
        rLottieImageView.setAnimation(rLottieDrawable);
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        rLottieImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$HLnb2BJ2lrxcgm5dKNYmzB-TH2k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$ChatThemeBottomSheet(view);
            }
        });
        frameLayout.addView(rLottieImageView, LayoutHelper.createFrame(44, 44.0f, 8388661, 0.0f, 0.0f, 7.0f, 0.0f));
        this.forceDark = !Theme.getActiveTheme().isDark();
        setForceDark(Theme.getActiveTheme().isDark(), false);
        this.scroller = new LinearSmoothScroller(getContext()) { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForScrolling(int dx) {
                return super.calculateTimeForScrolling(dx) * 6;
            }
        };
        RecyclerListView recyclerListView = new RecyclerListView(getContext());
        this.recyclerView = recyclerListView;
        recyclerListView.setAdapter(adapter);
        recyclerListView.setClipChildren(false);
        recyclerListView.setClipToPadding(false);
        recyclerListView.setHasFixedSize(true);
        recyclerListView.setItemAnimator(null);
        recyclerListView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        recyclerListView.setPadding(AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f), 0);
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$ekVhuT47cvdX7JXXq5AXb7B2YtA
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) throws InterruptedException {
                this.f$0.lambda$new$1$ChatThemeBottomSheet(themeDelegate, view, i2);
            }
        });
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(getContext(), this.resourcesProvider);
        this.progressView = flickerLoadingView;
        flickerLoadingView.setViewType(14);
        flickerLoadingView.setVisibility(0);
        frameLayout.addView(flickerLoadingView, LayoutHelper.createFrame(-1, 104.0f, 8388611, 0.0f, 44.0f, 0.0f, 0.0f));
        frameLayout.addView(recyclerListView, LayoutHelper.createFrame(-1, 104.0f, 8388611, 0.0f, 44.0f, 0.0f, 0.0f));
        View view = new View(getContext());
        this.applyButton = view;
        view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), getThemedColor("featuredStickers_addButton"), getThemedColor("featuredStickers_addButtonPressed")));
        view.setEnabled(false);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$lhS6VG66aTYnbIL3mfi7rjMahK8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$2$ChatThemeBottomSheet(view2);
            }
        });
        frameLayout.addView(view, LayoutHelper.createFrame(-1, 48.0f, 8388611, 16.0f, 162.0f, 16.0f, 16.0f));
        TextView textView2 = new TextView(getContext());
        this.resetTextView = textView2;
        textView2.setAlpha(0.0f);
        this.resetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.resetTextView.setGravity(17);
        this.resetTextView.setLines(1);
        this.resetTextView.setSingleLine(true);
        TextView textView3 = this.resetTextView;
        if (themeDelegate.getCurrentTheme() == null) {
            i = R.string.DoNoSetTheme;
            str = "DoNoSetTheme";
        } else {
            i = R.string.ChatResetTheme;
            str = "ChatResetTheme";
        }
        textView3.setText(LocaleController.getString(str, i));
        this.resetTextView.setTextColor(getThemedColor("featuredStickers_buttonText"));
        this.resetTextView.setTextSize(1, 15.0f);
        this.resetTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.resetTextView.setVisibility(4);
        frameLayout.addView(this.resetTextView, LayoutHelper.createFrame(-1, 48.0f, 8388611, 16.0f, 162.0f, 16.0f, 16.0f));
        TextView textView4 = new TextView(getContext());
        this.applyTextView = textView4;
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        this.applyTextView.setGravity(17);
        this.applyTextView.setLines(1);
        this.applyTextView.setSingleLine(true);
        this.applyTextView.setText(LocaleController.getString("ChatApplyTheme", R.string.ChatApplyTheme));
        this.applyTextView.setTextColor(getThemedColor("featuredStickers_buttonText"));
        this.applyTextView.setTextSize(1, 15.0f);
        this.applyTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.applyTextView.setVisibility(4);
        frameLayout.addView(this.applyTextView, LayoutHelper.createFrame(-1, 48.0f, 8388611, 16.0f, 162.0f, 16.0f, 16.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatThemeBottomSheet(View view) {
        if (this.changeDayNightViewAnimator != null) {
            return;
        }
        setupLightDarkTheme(!this.forceDark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatThemeBottomSheet(ChatActivity.ThemeDelegate themeDelegate, View view, final int i) throws InterruptedException {
        if (this.adapter.items.get(i) == this.selectedItem || this.changeDayNightView != null) {
            return;
        }
        ChatThemeItem chatThemeItem = (ChatThemeItem) this.adapter.items.get(i);
        this.selectedItem = chatThemeItem;
        this.isLightDarkChangeAnimation = false;
        ChatTheme chatTheme = chatThemeItem.chatTheme;
        if (chatTheme == null || chatTheme.isDefault) {
            this.applyTextView.animate().alpha(0.0f).setDuration(300L).start();
            this.resetTextView.animate().alpha(1.0f).setDuration(300L).start();
        } else {
            this.resetTextView.animate().alpha(0.0f).setDuration(300L).start();
            this.applyTextView.animate().alpha(1.0f).setDuration(300L).start();
        }
        ChatTheme chatTheme2 = this.selectedItem.chatTheme;
        if (chatTheme2.isDefault) {
            themeDelegate.setCurrentTheme(null, true, Boolean.valueOf(this.forceDark));
        } else {
            themeDelegate.setCurrentTheme(chatTheme2, true, Boolean.valueOf(this.forceDark));
        }
        this.adapter.setSelectedItem(i);
        this.containerView.postDelayed(new Runnable() { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.2
            @Override // java.lang.Runnable
            public void run() {
                int iMax;
                RecyclerView.LayoutManager layoutManager = ChatThemeBottomSheet.this.recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    if (i <= ChatThemeBottomSheet.this.prevSelectedPosition) {
                        iMax = Math.max(i - 1, 0);
                    } else {
                        iMax = Math.min(i + 1, ChatThemeBottomSheet.this.adapter.items.size() - 1);
                    }
                    ChatThemeBottomSheet.this.scroller.setTargetPosition(iMax);
                    layoutManager.startSmoothScroll(ChatThemeBottomSheet.this.scroller);
                }
                ChatThemeBottomSheet.this.prevSelectedPosition = i;
            }
        }, 100L);
        for (int i2 = 0; i2 < this.recyclerView.getChildCount(); i2++) {
            Adapter.ChatThemeView chatThemeView = (Adapter.ChatThemeView) this.recyclerView.getChildAt(i2);
            if (chatThemeView != view) {
                chatThemeView.cancelAnimation();
            }
        }
        if (((ChatThemeItem) this.adapter.items.get(i)).chatTheme.isDefault) {
            return;
        }
        ((Adapter.ChatThemeView) view).playEmojiAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ChatThemeBottomSheet(View view) {
        applySelectedTheme();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        ChatThemeController.preloadAllWallpaperThumbs(true);
        ChatThemeController.preloadAllWallpaperThumbs(false);
        ChatThemeController.preloadAllWallpaperImages(true);
        ChatThemeController.preloadAllWallpaperImages(false);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        this.isApplyClicked = false;
        List<ChatTheme> cachedThemes = this.themeDelegate.getCachedThemes();
        if (cachedThemes == null || cachedThemes.isEmpty()) {
            ChatThemeController.requestAllChatThemes(new ResultCallback<List<ChatTheme>>() { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.3
                @Override // ir.eitaa.tgnet.ResultCallback
                public void onComplete(List<ChatTheme> result) {
                    if (result != null && !result.isEmpty()) {
                        ChatThemeBottomSheet.this.themeDelegate.setCachedThemes(result);
                    }
                    ChatThemeBottomSheet.this.onDataLoaded(result);
                }

                @Override // ir.eitaa.tgnet.ResultCallback
                public void onError(TLRPC$TL_error error) {
                    Toast.makeText(ChatThemeBottomSheet.this.getContext(), error.text, 0).show();
                }
            }, true);
        } else {
            onDataLoaded(cachedThemes);
        }
        if (this.chatActivity.getCurrentUser() == null || (i = SharedConfig.dayNightThemeSwitchHintCount) <= 0) {
            return;
        }
        SharedConfig.updateDayNightThemeSwitchHintCount(i - 1);
        HintView hintView = new HintView(getContext(), 9, this.chatActivity.getResourceProvider());
        this.hintView = hintView;
        hintView.setVisibility(4);
        this.hintView.setShowingDuration(5000L);
        this.hintView.setBottomOffset(-AndroidUtilities.dp(8.0f));
        this.hintView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ChatThemeDayNightSwitchTooltip", R.string.ChatThemeDayNightSwitchTooltip, this.chatActivity.getCurrentUser().first_name)));
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$wq9gXJ5v3QlAyZI3KW_UJ3vEMDc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$3$ChatThemeBottomSheet();
            }
        }, 1500L);
        this.container.addView(this.hintView, LayoutHelper.createFrame(-2, -2.0f, 51, 10.0f, 0.0f, 10.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$3$ChatThemeBottomSheet() {
        this.hintView.showForView(this.darkThemeView, true);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void onContainerTranslationYChanged(float y) {
        HintView hintView = this.hintView;
        if (hintView != null) {
            hintView.hide();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        close();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        super.dismiss();
        if (this.isApplyClicked) {
            return;
        }
        this.themeDelegate.setCurrentTheme(this.originalTheme, true, Boolean.valueOf(this.originalIsDark));
    }

    public void close() {
        if (hasChanges()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), this.resourcesProvider);
            builder.setTitle(LocaleController.getString("ChatThemeSaveDialogTitle", R.string.ChatThemeSaveDialogTitle));
            builder.setSubtitle(LocaleController.getString("ChatThemeSaveDialogText", R.string.ChatThemeSaveDialogText));
            builder.setPositiveButton(LocaleController.getString("ChatThemeSaveDialogApply", R.string.ChatThemeSaveDialogApply), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$3qYlX-WjEIMdal_G5eg53Fwm0ic
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$close$4$ChatThemeBottomSheet(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("ChatThemeSaveDialogDiscard", R.string.ChatThemeSaveDialogDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$r6sFqIblu6Wix4FxlJN7eD-wn6E
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$close$5$ChatThemeBottomSheet(dialogInterface, i);
                }
            });
            builder.show();
            return;
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$close$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$close$4$ChatThemeBottomSheet(DialogInterface dialogInterface, int i) {
        applySelectedTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$close$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$close$5$ChatThemeBottomSheet(DialogInterface dialogInterface, int i) {
        dismiss();
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    @SuppressLint({"NotifyDataSetChanged"})
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.emojiLoaded) {
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.4
            private boolean isAnimationStarted = false;

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public void didSetColor() {
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public void onAnimationProgress(float progress) {
                if (progress == 0.0f && !this.isAnimationStarted) {
                    ChatThemeBottomSheet.this.onAnimationStart();
                    this.isAnimationStarted = true;
                }
                ChatThemeBottomSheet chatThemeBottomSheet = ChatThemeBottomSheet.this;
                chatThemeBottomSheet.setDarkButtonColor(chatThemeBottomSheet.getThemedColor("featuredStickers_addButton"));
                ChatThemeBottomSheet chatThemeBottomSheet2 = ChatThemeBottomSheet.this;
                chatThemeBottomSheet2.setOverlayNavBarColor(chatThemeBottomSheet2.getThemedColor("dialogBackground"));
                if (ChatThemeBottomSheet.this.isLightDarkChangeAnimation) {
                    ChatThemeBottomSheet.this.setItemsAnimationProgress(progress);
                }
                if (progress == 1.0f && this.isAnimationStarted) {
                    ChatThemeBottomSheet.this.isLightDarkChangeAnimation = false;
                    ChatThemeBottomSheet.this.onAnimationEnd();
                    this.isAnimationStarted = false;
                }
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, new Drawable[]{this.shadowDrawable}, themeDescriptionDelegate, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.titleView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.recyclerView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{Adapter.ChatThemeView.class}, null, null, null, "dialogBackgroundGray"));
        arrayList.add(new ThemeDescription(this.applyButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.applyButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "featuredStickers_addButtonPressed"));
        Iterator<ThemeDescription> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().resourcesProvider = this.themeDelegate;
        }
        return arrayList;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setupLightDarkTheme(final boolean isDark) {
        ValueAnimator valueAnimator = this.changeDayNightViewAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        FrameLayout frameLayout = (FrameLayout) this.chatActivity.getParentActivity().getWindow().getDecorView();
        FrameLayout frameLayout2 = (FrameLayout) getWindow().getDecorView();
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(frameLayout2.getWidth(), frameLayout2.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmapCreateBitmap);
        this.darkThemeView.setAlpha(0.0f);
        frameLayout.draw(canvas);
        frameLayout2.draw(canvas);
        this.darkThemeView.setAlpha(1.0f);
        final Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        final Paint paint2 = new Paint(1);
        paint2.setFilterBitmap(true);
        int[] iArr = new int[2];
        this.darkThemeView.getLocationInWindow(iArr);
        final float f = iArr[0];
        final float f2 = iArr[1];
        final float measuredWidth = f + (this.darkThemeView.getMeasuredWidth() / 2.0f);
        final float measuredHeight = f2 + (this.darkThemeView.getMeasuredHeight() / 2.0f);
        final float fMax = Math.max(bitmapCreateBitmap.getHeight(), bitmapCreateBitmap.getWidth()) * 0.9f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        this.changeDayNightView = new View(getContext()) { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.5
            @Override // android.view.View
            protected void onDraw(Canvas canvas2) {
                super.onDraw(canvas2);
                if (!isDark) {
                    canvas2.drawCircle(measuredWidth, measuredHeight, fMax * (1.0f - ChatThemeBottomSheet.this.changeDayNightViewProgress), paint2);
                } else {
                    if (ChatThemeBottomSheet.this.changeDayNightViewProgress > 0.0f) {
                        canvas.drawCircle(measuredWidth, measuredHeight, fMax * ChatThemeBottomSheet.this.changeDayNightViewProgress, paint);
                    }
                    canvas2.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint2);
                }
                canvas2.save();
                canvas2.translate(f, f2);
                ChatThemeBottomSheet.this.darkThemeView.draw(canvas2);
                canvas2.restore();
            }
        };
        this.changeDayNightViewProgress = 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.changeDayNightViewAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ChatThemeBottomSheet.this.changeDayNightViewProgress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ChatThemeBottomSheet.this.changeDayNightView.invalidate();
            }
        });
        this.changeDayNightViewAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatThemeBottomSheet.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ChatThemeBottomSheet.this.changeDayNightView != null) {
                    if (ChatThemeBottomSheet.this.changeDayNightView.getParent() != null) {
                        ((ViewGroup) ChatThemeBottomSheet.this.changeDayNightView.getParent()).removeView(ChatThemeBottomSheet.this.changeDayNightView);
                    }
                    ChatThemeBottomSheet.this.changeDayNightView = null;
                }
                ChatThemeBottomSheet.this.changeDayNightViewAnimator = null;
                super.onAnimationEnd(animation);
            }
        });
        this.changeDayNightViewAnimator.setDuration(400L);
        this.changeDayNightViewAnimator.setInterpolator(Easings.easeInOutQuad);
        this.changeDayNightViewAnimator.start();
        frameLayout2.addView(this.changeDayNightView, new ViewGroup.LayoutParams(-1, -1));
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$BEw07XgI_ofIwVYBrTeNR8hXm6U
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$setupLightDarkTheme$6$ChatThemeBottomSheet(isDark);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupLightDarkTheme$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setupLightDarkTheme$6$ChatThemeBottomSheet(boolean z) throws InterruptedException {
        Adapter adapter = this.adapter;
        if (adapter == null || adapter.items == null) {
            return;
        }
        setForceDark(z, true);
        ChatThemeItem chatThemeItem = this.selectedItem;
        if (chatThemeItem != null) {
            this.isLightDarkChangeAnimation = true;
            ChatTheme chatTheme = chatThemeItem.chatTheme;
            if (chatTheme.isDefault) {
                this.themeDelegate.setCurrentTheme(null, false, Boolean.valueOf(z));
            } else {
                this.themeDelegate.setCurrentTheme(chatTheme, false, Boolean.valueOf(z));
            }
        }
        Adapter adapter2 = this.adapter;
        if (adapter2 == null || adapter2.items == null) {
            return;
        }
        for (int i = 0; i < this.adapter.items.size(); i++) {
            ((ChatThemeItem) this.adapter.items.get(i)).isDark = z;
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onContainerTouchEvent(MotionEvent event) {
        if (event == null || !hasChanges()) {
            return false;
        }
        int x = (int) event.getX();
        if (((int) event.getY()) >= this.containerView.getTop() && x >= this.containerView.getLeft() && x <= this.containerView.getRight()) {
            return false;
        }
        this.chatActivity.getFragmentView().dispatchTouchEvent(event);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataLoaded(List<ChatTheme> result) {
        if (result == null || result.isEmpty()) {
            return;
        }
        boolean z = false;
        ChatThemeItem chatThemeItem = new ChatThemeItem(result.get(0));
        ArrayList arrayList = new ArrayList(result.size());
        ChatTheme currentTheme = this.themeDelegate.getCurrentTheme();
        arrayList.add(0, chatThemeItem);
        this.selectedItem = chatThemeItem;
        for (int i = 1; i < result.size(); i++) {
            ChatTheme chatTheme = result.get(i);
            ChatThemeItem chatThemeItem2 = new ChatThemeItem(chatTheme);
            HashMap<String, Integer> currentColors = chatTheme.getCurrentColors(this.chatActivity.getCurrentAccount(), true);
            Integer numValueOf = currentColors.get("chat_inBubble");
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(getThemedColor("chat_inBubble"));
            }
            chatThemeItem2.inBubbleColorDark = numValueOf.intValue();
            Integer numValueOf2 = currentColors.get("chat_outBubble");
            if (numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(getThemedColor("chat_outBubble"));
            }
            chatThemeItem2.outBubbleColorDark = numValueOf2.intValue();
            Integer num = currentColors.get("featuredStickers_addButton");
            chatThemeItem2.strokeColorLight = num != null ? num.intValue() : 0;
            HashMap<String, Integer> currentColors2 = chatTheme.getCurrentColors(this.chatActivity.getCurrentAccount(), false);
            Integer numValueOf3 = currentColors2.get("chat_inBubble");
            if (numValueOf3 == null) {
                numValueOf3 = Integer.valueOf(getThemedColor("chat_inBubble"));
            }
            chatThemeItem2.inBubbleColorLight = numValueOf3.intValue();
            Integer numValueOf4 = currentColors2.get("chat_outBubble");
            if (numValueOf4 == null) {
                numValueOf4 = Integer.valueOf(getThemedColor("chat_outBubble"));
            }
            chatThemeItem2.outBubbleColorLight = numValueOf4.intValue();
            Integer num2 = currentColors2.get("featuredStickers_addButton");
            chatThemeItem2.strokeColorDark = num2 != null ? num2.intValue() : 0;
            chatThemeItem2.isDark = this.forceDark;
            arrayList.add(chatThemeItem2);
        }
        this.adapter.setItems(arrayList);
        this.applyButton.setEnabled(true);
        this.applyTextView.setAlpha(0.0f);
        this.resetTextView.setAlpha(0.0f);
        this.recyclerView.setAlpha(0.0f);
        this.applyTextView.setVisibility(0);
        this.resetTextView.setVisibility(0);
        this.darkThemeView.setVisibility(0);
        if (currentTheme != null) {
            int i2 = 0;
            while (true) {
                if (i2 == arrayList.size()) {
                    i2 = -1;
                    break;
                } else {
                    if (((ChatThemeItem) arrayList.get(i2)).chatTheme.getEmoticon().equals(currentTheme.getEmoticon())) {
                        this.selectedItem = (ChatThemeItem) arrayList.get(i2);
                        break;
                    }
                    i2++;
                }
            }
            if (i2 != -1) {
                this.prevSelectedPosition = i2;
                this.adapter.setSelectedItem(i2);
                this.layoutManager.scrollToPositionWithOffset(Math.min(i2, this.adapter.items.size() - 1), 0);
            }
        } else {
            this.adapter.setSelectedItem(0);
            this.layoutManager.scrollToPositionWithOffset(0, 0);
            z = true;
        }
        this.recyclerView.animate().alpha(1.0f).setDuration(150L).start();
        this.resetTextView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).start();
        this.applyTextView.animate().alpha(z ? 0.0f : 1.0f).setDuration(150L).start();
        this.progressView.animate().alpha(0.0f).setListener(new HideViewAfterAnimation(this.progressView)).setDuration(150L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimationStart() {
        Adapter adapter = this.adapter;
        if (adapter != null && adapter.items != null) {
            Iterator it = this.adapter.items.iterator();
            while (it.hasNext()) {
                ((ChatThemeItem) it.next()).isDark = this.forceDark;
            }
        }
        if (this.isLightDarkChangeAnimation) {
            return;
        }
        setItemsAnimationProgress(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimationEnd() {
        this.isLightDarkChangeAnimation = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDarkButtonColor(int color) {
        this.darkThemeDrawable.setLayerColor("Sunny.**", color);
        this.darkThemeDrawable.setLayerColor("Path.**", color);
        this.darkThemeDrawable.setLayerColor("Path 10.**", color);
        this.darkThemeDrawable.setLayerColor("Path 11.**", color);
    }

    private void setForceDark(boolean isDark, boolean playAnimation) throws InterruptedException {
        this.useLightNavBar = isDark;
        this.useLightStatusBar = isDark;
        if (this.forceDark == isDark) {
            return;
        }
        this.forceDark = isDark;
        if (playAnimation) {
            RLottieDrawable rLottieDrawable = this.darkThemeDrawable;
            rLottieDrawable.setCustomEndFrame(isDark ? rLottieDrawable.getFramesCount() : 0);
            this.darkThemeView.playAnimation();
        } else {
            RLottieDrawable rLottieDrawable2 = this.darkThemeDrawable;
            rLottieDrawable2.setCurrentFrame(isDark ? rLottieDrawable2.getFramesCount() - 1 : 0, false, true);
            this.darkThemeView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemsAnimationProgress(float progress) {
        for (int i = 0; i < this.adapter.getItemCount(); i++) {
            ((ChatThemeItem) this.adapter.items.get(i)).animationProgress = progress;
        }
    }

    private void applySelectedTheme() {
        boolean z;
        ChatThemeItem chatThemeItem = this.selectedItem;
        ChatTheme chatTheme = chatThemeItem.chatTheme;
        boolean z2 = chatTheme.isDefault;
        Bulletin bulletinMake = null;
        ChatTheme chatTheme2 = z2 ? null : chatTheme;
        if (chatThemeItem != null && chatTheme2 != this.originalTheme) {
            String emoticon = (chatTheme == null || z2) ? null : chatTheme.getEmoticon();
            ChatThemeController.getInstance(this.currentAccount).setDialogTheme(this.chatActivity.getDialogId(), emoticon, true);
            if (chatTheme != null && !chatTheme.isDefault) {
                this.themeDelegate.setCurrentTheme(chatTheme, true, Boolean.valueOf(this.originalIsDark));
            } else {
                this.themeDelegate.setCurrentTheme(null, true, Boolean.valueOf(this.originalIsDark));
            }
            this.isApplyClicked = true;
            TLRPC$User currentUser = this.chatActivity.getCurrentUser();
            if (currentUser != null && !currentUser.self) {
                if (TextUtils.isEmpty(emoticon)) {
                    emoticon = "❌";
                    z = true;
                } else {
                    z = false;
                }
                StickerSetBulletinLayout stickerSetBulletinLayout = new StickerSetBulletinLayout(getContext(), null, -1, emoticon != null ? MediaDataController.getInstance(this.currentAccount).getEmojiAnimatedSticker(emoticon) : null, this.chatActivity.getResourceProvider());
                stickerSetBulletinLayout.subtitleTextView.setVisibility(8);
                if (z) {
                    stickerSetBulletinLayout.titleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ThemeAlsoDisabledForHint", R.string.ThemeAlsoDisabledForHint, currentUser.first_name)));
                } else {
                    stickerSetBulletinLayout.titleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ThemeAlsoAppliedForHint", R.string.ThemeAlsoAppliedForHint, currentUser.first_name)));
                }
                stickerSetBulletinLayout.titleTextView.setTypeface(null);
                bulletinMake = Bulletin.make(this.chatActivity, stickerSetBulletinLayout, 2750);
            }
        }
        dismiss();
        if (bulletinMake != null) {
            bulletinMake.show();
        }
    }

    private boolean hasChanges() {
        if (this.selectedItem == null) {
            return false;
        }
        ChatTheme chatTheme = this.originalTheme;
        String emoticon = chatTheme != null ? chatTheme.getEmoticon() : null;
        if (TextUtils.isEmpty(emoticon)) {
            emoticon = "❌";
        }
        ChatTheme chatTheme2 = this.selectedItem.chatTheme;
        return !ObjectsCompat$Api19Impl$$ExternalSynthetic0.m0(emoticon, TextUtils.isEmpty(chatTheme2 != null ? chatTheme2.getEmoticon() : null) ? "❌" : r1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<ChatThemeItem> items;
        private final Theme.ResourcesProvider resourcesProvider;
        private int selectedItemPosition = -1;
        private WeakReference<ChatThemeView> selectedViewRef;

        public Adapter(Theme.ResourcesProvider resourcesProvider) {
            this.resourcesProvider = resourcesProvider;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new ChatThemeView(parent.getContext(), this.resourcesProvider));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ChatThemeView chatThemeView = (ChatThemeView) holder.itemView;
            chatThemeView.setItem(this.items.get(position));
            chatThemeView.setSelected(position == this.selectedItemPosition);
            if (position == this.selectedItemPosition) {
                this.selectedViewRef = new WeakReference<>(chatThemeView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<ChatThemeItem> list = this.items;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void setItems(List<ChatThemeItem> newItems) {
            this.items = newItems;
            notifyDataSetChanged();
        }

        public void setSelectedItem(int position) {
            int i = this.selectedItemPosition;
            if (i == position) {
                return;
            }
            if (i >= 0) {
                notifyItemChanged(i);
                ChatThemeView chatThemeView = this.selectedViewRef.get();
                if (chatThemeView != null) {
                    chatThemeView.setSelected(false);
                }
            }
            this.selectedItemPosition = position;
            notifyItemChanged(position);
        }

        /* JADX INFO: Access modifiers changed from: private */
        class ChatThemeView extends FrameLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
            private final float BUBBLE_HEIGHT;
            private final float BUBBLE_WIDTH;
            private final float INNER_RADIUS;
            private final float INNER_RECT_SPACE;
            private final float STROKE_RADIUS;
            Runnable animationCancelRunnable;
            private final Paint backgroundFillPaint;
            private BackupImageView backupImageView;
            private ChatThemeItem chatThemeItem;
            private final Path clipPath;
            private boolean hasAnimatedEmoji;
            private final Paint inBubblePaint;
            private boolean isDark;
            private TextPaint noThemeTextPaint;
            private final Paint outBubblePaintFirst;
            private final Paint outBubblePaintSecond;
            private final RectF rectF;
            private final Theme.ResourcesProvider resourcesProvider;
            private ValueAnimator strokeAlphaAnimator;
            private final Paint strokePaint;
            private StaticLayout textLayout;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            public ChatThemeView(Context context, Theme.ResourcesProvider resourcesProvider) {
                super(context);
                this.STROKE_RADIUS = AndroidUtilities.dp(8.0f);
                this.INNER_RADIUS = AndroidUtilities.dp(6.0f);
                this.INNER_RECT_SPACE = AndroidUtilities.dp(4.0f);
                this.BUBBLE_HEIGHT = AndroidUtilities.dp(21.0f);
                this.BUBBLE_WIDTH = AndroidUtilities.dp(41.0f);
                this.backgroundFillPaint = new Paint(1);
                Paint paint = new Paint(1);
                this.strokePaint = paint;
                this.outBubblePaintFirst = new Paint(1);
                this.outBubblePaintSecond = new Paint(1);
                this.inBubblePaint = new Paint(1);
                this.rectF = new RectF();
                this.clipPath = new Path();
                this.resourcesProvider = resourcesProvider;
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
                setBackgroundColor(getThemedColor("dialogBackgroundGray"));
                BackupImageView backupImageView = new BackupImageView(context);
                this.backupImageView = backupImageView;
                backupImageView.getImageReceiver().setCrossfadeWithOldImage(true);
                this.backupImageView.getImageReceiver().setAllowStartLottieAnimation(false);
                this.backupImageView.getImageReceiver().setAutoRepeat(0);
                addView(this.backupImageView, LayoutHelper.createFrame(28, 28.0f, 81, 0.0f, 0.0f, 0.0f, 12.0f));
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(77.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 1073741824));
            }

            @Override // android.view.View
            protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                super.onSizeChanged(w, h, oldw, oldh);
                if (w == oldw && h == oldh) {
                    return;
                }
                RectF rectF = this.rectF;
                float f = this.INNER_RECT_SPACE;
                rectF.set(f, f, w - f, h - f);
                this.clipPath.reset();
                Path path = this.clipPath;
                RectF rectF2 = this.rectF;
                float f2 = this.INNER_RADIUS;
                path.addRoundRect(rectF2, f2, f2, Path.Direction.CW);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                ChatThemeItem chatThemeItem = this.chatThemeItem;
                if (chatThemeItem == null) {
                    super.dispatchDraw(canvas);
                    return;
                }
                if (chatThemeItem.isSelected || this.strokeAlphaAnimator != null) {
                    float strokeWidth = this.strokePaint.getStrokeWidth() * 0.5f;
                    this.rectF.set(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth);
                    RectF rectF = this.rectF;
                    float f = this.STROKE_RADIUS;
                    canvas.drawRoundRect(rectF, f, f, this.strokePaint);
                }
                RectF rectF2 = this.rectF;
                float f2 = this.INNER_RECT_SPACE;
                rectF2.set(f2, f2, getWidth() - this.INNER_RECT_SPACE, getHeight() - this.INNER_RECT_SPACE);
                ChatThemeItem chatThemeItem2 = this.chatThemeItem;
                ChatTheme chatTheme = chatThemeItem2.chatTheme;
                if (chatTheme == null || chatTheme.isDefault) {
                    RectF rectF3 = this.rectF;
                    float f3 = this.INNER_RADIUS;
                    canvas.drawRoundRect(rectF3, f3, f3, this.backgroundFillPaint);
                    canvas.save();
                    StaticLayout noThemeStaticLayout = getNoThemeStaticLayout();
                    canvas.translate((getWidth() - noThemeStaticLayout.getWidth()) * 0.5f, AndroidUtilities.dp(18.0f));
                    noThemeStaticLayout.draw(canvas);
                    canvas.restore();
                } else {
                    if (chatThemeItem2.previewDrawable != null) {
                        canvas.save();
                        canvas.clipPath(this.clipPath);
                        this.chatThemeItem.previewDrawable.setBounds(0, 0, getWidth(), getHeight());
                        this.chatThemeItem.previewDrawable.draw(canvas);
                        canvas.restore();
                    } else {
                        RectF rectF4 = this.rectF;
                        float f4 = this.INNER_RADIUS;
                        canvas.drawRoundRect(rectF4, f4, f4, this.backgroundFillPaint);
                    }
                    float fDp = this.INNER_RECT_SPACE + AndroidUtilities.dp(8.0f);
                    float fDp2 = this.INNER_RECT_SPACE + AndroidUtilities.dp(22.0f);
                    this.rectF.set(fDp2, fDp, this.BUBBLE_WIDTH + fDp2, this.BUBBLE_HEIGHT + fDp);
                    RectF rectF5 = this.rectF;
                    canvas.drawRoundRect(rectF5, rectF5.height() * 0.5f, this.rectF.height() * 0.5f, this.outBubblePaintFirst);
                    RectF rectF6 = this.rectF;
                    canvas.drawRoundRect(rectF6, rectF6.height() * 0.5f, this.rectF.height() * 0.5f, this.outBubblePaintSecond);
                    float fDp3 = this.INNER_RECT_SPACE + AndroidUtilities.dp(5.0f);
                    float fDp4 = fDp + this.BUBBLE_HEIGHT + AndroidUtilities.dp(4.0f);
                    this.rectF.set(fDp3, fDp4, this.BUBBLE_WIDTH + fDp3, this.BUBBLE_HEIGHT + fDp4);
                    RectF rectF7 = this.rectF;
                    canvas.drawRoundRect(rectF7, rectF7.height() * 0.5f, this.rectF.height() * 0.5f, this.inBubblePaint);
                }
                super.dispatchDraw(canvas);
            }

            public void setItem(ChatThemeItem item) {
                boolean z = this.chatThemeItem != item;
                boolean z2 = this.isDark;
                boolean z3 = item.isDark;
                boolean z4 = z2 != z3;
                this.isDark = z3;
                this.chatThemeItem = item;
                this.hasAnimatedEmoji = false;
                TLRPC$Document emojiAnimatedSticker = item.chatTheme.getEmoticon() != null ? MediaDataController.getInstance(((BottomSheet) ChatThemeBottomSheet.this).currentAccount).getEmojiAnimatedSticker(item.chatTheme.getEmoticon()) : null;
                if (z) {
                    Runnable runnable = this.animationCancelRunnable;
                    if (runnable != null) {
                        AndroidUtilities.cancelRunOnUIThread(runnable);
                        this.animationCancelRunnable = null;
                    }
                    this.backupImageView.animate().cancel();
                    this.backupImageView.setScaleX(1.0f);
                    this.backupImageView.setScaleY(1.0f);
                }
                BackupImageView backupImageView = this.backupImageView;
                ImageLocation forDocument = ImageLocation.getForDocument(emojiAnimatedSticker);
                ChatTheme chatTheme = item.chatTheme;
                backupImageView.setImage(forDocument, "50_50", Emoji.getEmojiDrawable(chatTheme == null ? "❌" : chatTheme.getEmoticon()), (Object) null);
                ChatTheme chatTheme2 = item.chatTheme;
                if (chatTheme2 != null && !chatTheme2.isDefault) {
                    updatePreviewBackground();
                    if (z || z4) {
                        final long j = item.chatTheme.getTlTheme(this.isDark).id;
                        final int i = item.chatTheme.getWallpaper(this.isDark).settings.intensity;
                        item.chatTheme.loadWallpaperThumb(this.isDark, new ResultCallback() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$Adapter$ChatThemeView$ZuDmz86oSIQrpmG5dZ7J2hVOiCg
                            @Override // ir.eitaa.tgnet.ResultCallback
                            public final void onComplete(Object obj) {
                                this.f$0.lambda$setItem$0$ChatThemeBottomSheet$Adapter$ChatThemeView(j, i, (Pair) obj);
                            }

                            @Override // ir.eitaa.tgnet.ResultCallback
                            public /* synthetic */ void onError(TLRPC$TL_error tLRPC$TL_error) {
                                ResultCallback.CC.$default$onError(this, tLRPC$TL_error);
                            }
                        });
                    }
                }
                setBackgroundColor(0);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$setItem$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$setItem$0$ChatThemeBottomSheet$Adapter$ChatThemeView(long j, int i, Pair pair) {
                if (pair == null || ((Long) pair.first).longValue() != j) {
                    return;
                }
                MotionBackgroundDrawable previewDrawable = getPreviewDrawable();
                if (previewDrawable != null) {
                    previewDrawable.setPatternBitmap(i >= 0 ? 100 : -100, (Bitmap) pair.second);
                    previewDrawable.setPatternColorFilter(previewDrawable.getPatternColor());
                }
                invalidate();
            }

            @Override // android.view.View
            public void setSelected(boolean selected) {
                super.setSelected(selected);
                if (this.chatThemeItem.isSelected != selected) {
                    ValueAnimator valueAnimator = this.strokeAlphaAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    if (selected) {
                        this.strokePaint.setAlpha(0);
                    }
                    int[] iArr = new int[2];
                    iArr[0] = selected ? 0 : 255;
                    iArr[1] = selected ? 255 : 0;
                    ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iArr);
                    this.strokeAlphaAnimator = valueAnimatorOfInt;
                    valueAnimatorOfInt.addUpdateListener(this);
                    this.strokeAlphaAnimator.addListener(this);
                    this.strokeAlphaAnimator.setDuration(350L);
                    this.strokeAlphaAnimator.start();
                }
                this.chatThemeItem.isSelected = selected;
            }

            @Override // android.view.View
            public void setBackgroundColor(int color) {
                this.backgroundFillPaint.setColor(getThemedColor("dialogBackgroundGray"));
                TextPaint textPaint = this.noThemeTextPaint;
                if (textPaint != null) {
                    textPaint.setColor(getThemedColor("chat_emojiPanelTrendingDescription"));
                }
                invalidate();
            }

            private void fillOutBubblePaint(Paint paint, List<Integer> messageColors) {
                if (messageColors.size() > 1) {
                    int[] iArr = new int[messageColors.size()];
                    for (int i = 0; i != messageColors.size(); i++) {
                        iArr[i] = messageColors.get(i).intValue();
                    }
                    float fDp = this.INNER_RECT_SPACE + AndroidUtilities.dp(8.0f);
                    paint.setShader(new LinearGradient(0.0f, fDp, 0.0f, fDp + this.BUBBLE_HEIGHT, iArr, (float[]) null, Shader.TileMode.CLAMP));
                    return;
                }
                paint.setShader(null);
            }

            public void updatePreviewBackground() {
                ChatTheme chatTheme;
                ChatThemeItem chatThemeItem = this.chatThemeItem;
                if (chatThemeItem == null || (chatTheme = chatThemeItem.chatTheme) == null || chatTheme.isDefault) {
                    return;
                }
                this.inBubblePaint.setColor(chatThemeItem.isDark ? chatThemeItem.inBubbleColorDark : chatThemeItem.inBubbleColorLight);
                ChatThemeItem chatThemeItem2 = this.chatThemeItem;
                this.outBubblePaintSecond.setColor(chatThemeItem2.isDark ? chatThemeItem2.outBubbleColorDark : chatThemeItem2.outBubbleColorLight);
                fillOutBubblePaint(this.outBubblePaintFirst, this.chatThemeItem.chatTheme.getTlTheme(!r0.isDark).settings.message_colors);
                ChatThemeItem chatThemeItem3 = this.chatThemeItem;
                TLRPC$TL_theme tlTheme = chatThemeItem3.chatTheme.getTlTheme(chatThemeItem3.isDark);
                fillOutBubblePaint(this.outBubblePaintSecond, tlTheme.settings.message_colors);
                this.outBubblePaintSecond.setAlpha(255);
                MotionBackgroundDrawable previewDrawable = getPreviewDrawable();
                if (previewDrawable != null) {
                    TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tlTheme.settings.wallpaper.settings;
                    int i = tLRPC$WallPaperSettings.background_color | (-16777216);
                    if (i == -16777216) {
                        i = 0;
                    }
                    int i2 = tLRPC$WallPaperSettings.second_background_color | (-16777216);
                    if (i2 == -16777216) {
                        i2 = 0;
                    }
                    int i3 = tLRPC$WallPaperSettings.third_background_color | (-16777216);
                    if (i3 == -16777216) {
                        i3 = 0;
                    }
                    int i4 = tLRPC$WallPaperSettings.fourth_background_color | (-16777216);
                    if (i4 == -16777216) {
                        i4 = 0;
                    }
                    previewDrawable.setPatternBitmap(tLRPC$WallPaperSettings.intensity >= 0 ? 100 : -100);
                    previewDrawable.setColors(i, i2, i3, i4, false);
                    previewDrawable.setPatternColorFilter(previewDrawable.getPatternColor());
                }
                invalidate();
            }

            private MotionBackgroundDrawable getPreviewDrawable() {
                ChatThemeItem chatThemeItem = this.chatThemeItem;
                if (chatThemeItem == null) {
                    return null;
                }
                MotionBackgroundDrawable motionBackgroundDrawable = chatThemeItem.previewDrawable;
                if (motionBackgroundDrawable != null) {
                    return motionBackgroundDrawable;
                }
                MotionBackgroundDrawable motionBackgroundDrawable2 = new MotionBackgroundDrawable();
                this.chatThemeItem.previewDrawable = motionBackgroundDrawable2;
                return motionBackgroundDrawable2;
            }

            private StaticLayout getNoThemeStaticLayout() {
                StaticLayout staticLayout = this.textLayout;
                if (staticLayout != null) {
                    return staticLayout;
                }
                TextPaint textPaint = new TextPaint(129);
                this.noThemeTextPaint = textPaint;
                textPaint.setColor(getThemedColor("chat_emojiPanelTrendingDescription"));
                this.noThemeTextPaint.setTextSize(AndroidUtilities.dp(14.0f));
                this.noThemeTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
                StaticLayout staticLayoutCreateStaticLayout2 = StaticLayoutEx.createStaticLayout2(LocaleController.getString("ChatNoTheme", R.string.ChatNoTheme), this.noThemeTextPaint, AndroidUtilities.dp(52.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true, TextUtils.TruncateAt.END, AndroidUtilities.dp(52.0f), 3);
                this.textLayout = staticLayoutCreateStaticLayout2;
                return staticLayoutCreateStaticLayout2;
            }

            private int getThemedColor(String key) {
                Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
                Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
                return color != null ? color.intValue() : Theme.getColor(key);
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int themedColor;
                ChatThemeItem chatThemeItem = this.chatThemeItem;
                if (chatThemeItem.chatTheme.isDefault) {
                    themedColor = getThemedColor("featuredStickers_addButton");
                } else {
                    themedColor = chatThemeItem.isDark ? chatThemeItem.strokeColorDark : chatThemeItem.strokeColorLight;
                }
                this.strokePaint.setColor(themedColor);
                this.strokePaint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.strokeAlphaAnimator = null;
                invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.strokeAlphaAnimator = null;
                invalidate();
            }

            public void playEmojiAnimation() throws InterruptedException {
                if (this.backupImageView.getImageReceiver().getLottieAnimation() != null) {
                    AndroidUtilities.cancelRunOnUIThread(this.animationCancelRunnable);
                    this.backupImageView.setVisibility(0);
                    this.backupImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(0, false);
                    this.backupImageView.getImageReceiver().getLottieAnimation().start();
                    this.backupImageView.setPivotY(AndroidUtilities.dp(24.0f));
                    this.backupImageView.setPivotX(AndroidUtilities.dp(12.0f));
                    this.backupImageView.animate().scaleX(2.0f).scaleY(2.0f).setDuration(300L).setInterpolator(AndroidUtilities.overshootInterpolator).start();
                    Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatThemeBottomSheet$Adapter$ChatThemeView$nlUBTzvbYTtO9U234PAdxfboCOk
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$playEmojiAnimation$1$ChatThemeBottomSheet$Adapter$ChatThemeView();
                        }
                    };
                    this.animationCancelRunnable = runnable;
                    AndroidUtilities.runOnUIThread(runnable, 2500L);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$playEmojiAnimation$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$playEmojiAnimation$1$ChatThemeBottomSheet$Adapter$ChatThemeView() {
                this.animationCancelRunnable = null;
                this.backupImageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
            }

            public void cancelAnimation() {
                Runnable runnable = this.animationCancelRunnable;
                if (runnable != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable);
                    this.animationCancelRunnable.run();
                }
            }
        }
    }

    private static class ChatThemeItem {
        public float animationProgress = 1.0f;
        public final ChatTheme chatTheme;
        public int inBubbleColorDark;
        public int inBubbleColorLight;
        public boolean isDark;
        public boolean isSelected;
        public int outBubbleColorDark;
        public int outBubbleColorLight;
        public MotionBackgroundDrawable previewDrawable;
        public int strokeColorDark;
        public int strokeColorLight;

        public ChatThemeItem(ChatTheme chatTheme) {
            this.chatTheme = chatTheme;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        int i;
        String str;
        super.show();
        TextView textView = this.resetTextView;
        if (this.themeDelegate.getCurrentTheme() == null) {
            i = R.string.DoNoSetTheme;
            str = "DoNoSetTheme";
        } else {
            i = R.string.ChatResetTheme;
            str = "ChatResetTheme";
        }
        textView.setText(LocaleController.getString(str, i));
    }
}
