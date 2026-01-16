package org.rbmain.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.WebFile;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker;
import org.rbmain.tgnet.TLRPC$TL_webDocument;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ContextLinkCell;
import org.rbmain.ui.Cells.StickerCell;
import org.rbmain.ui.Cells.StickerEmojiCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.ContentPreviewViewer;

/* loaded from: classes4.dex */
public class ContentPreviewViewer {
    private static volatile ContentPreviewViewer Instance;
    private static TextPaint textPaint;
    private float blurProgress;
    private Bitmap blurrBitmap;
    private boolean clearsInputField;
    private boolean closeOnDismiss;
    private FrameLayoutDrawer containerView;
    private int currentAccount;
    private int currentContentType;
    private TLRPC$Document currentDocument;
    private float currentMoveY;
    private float currentMoveYProgress;
    private View currentPreviewCell;
    private String currentQuery;
    private TLRPC$InputStickerSet currentStickerSet;
    private ContentPreviewViewerDelegate delegate;
    private boolean drawEffect;
    private float finalMoveY;
    private TLRPC$BotInlineResult inlineResult;
    private boolean isRecentSticker;
    private WindowInsets lastInsets;
    private float lastTouchY;
    private long lastUpdateTime;
    private boolean menuVisible;
    private Runnable openPreviewRunnable;
    private Activity parentActivity;
    private Object parentObject;
    ActionBarPopupWindow popupWindow;
    private Theme.ResourcesProvider resourcesProvider;
    private float showProgress;
    private Drawable slideUpDrawable;
    private float startMoveY;
    private int startX;
    private int startY;
    private StaticLayout stickerEmojiLayout;
    VibrationEffect vibrationEffect;
    private WindowManager.LayoutParams windowLayoutParams;
    private FrameLayout windowView;
    private float moveY = 0.0f;
    private ColorDrawable backgroundDrawable = new ColorDrawable(1895825408);
    private ImageReceiver centerImage = new ImageReceiver();
    private ImageReceiver effectImage = new ImageReceiver();
    private boolean isVisible = false;
    private int keyboardHeight = AndroidUtilities.dp(200.0f);
    private Paint paint = new Paint(1);
    private Runnable showSheetRunnable = new AnonymousClass1();

    public interface ContentPreviewViewerDelegate {

        /* renamed from: org.rbmain.ui.ContentPreviewViewer$ContentPreviewViewerDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$can(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return true;
            }

            public static Boolean $default$canSetAsStatus(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document) {
                return null;
            }

            public static void $default$copyEmoji(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document) {
            }

            public static String $default$getQuery(ContentPreviewViewerDelegate contentPreviewViewerDelegate, boolean z) {
                return null;
            }

            public static void $default$gifAddedOrDeleted(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
            }

            public static boolean $default$needCopy(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return false;
            }

            public static boolean $default$needMenu(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return true;
            }

            public static boolean $default$needOpen(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return true;
            }

            public static boolean $default$needRemove(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return false;
            }

            public static boolean $default$needRemoveFromRecent(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document) {
                return false;
            }

            public static void $default$removeFromRecent(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document) {
            }

            public static void $default$resetTouch(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
            }

            public static void $default$sendEmoji(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document) {
            }

            public static void $default$sendGif(ContentPreviewViewerDelegate contentPreviewViewerDelegate, Object obj, Object obj2, boolean z, int i) {
            }

            public static void $default$sendSticker(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, int i) {
            }

            public static void $default$setAsEmojiStatus(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document, Integer num) {
            }
        }

        boolean can();

        boolean canSchedule();

        Boolean canSetAsStatus(TLRPC$Document tLRPC$Document);

        void copyEmoji(TLRPC$Document tLRPC$Document);

        long getDialogId();

        String getQuery(boolean z);

        void gifAddedOrDeleted();

        boolean isInScheduleMode();

        boolean needCopy();

        boolean needMenu();

        boolean needOpen();

        boolean needRemove();

        boolean needRemoveFromRecent(TLRPC$Document tLRPC$Document);

        boolean needSend(int i);

        void openSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, boolean z);

        void removeFromRecent(TLRPC$Document tLRPC$Document);

        void resetTouch();

        void sendEmoji(TLRPC$Document tLRPC$Document);

        void sendGif(Object obj, Object obj2, boolean z, int i);

        void sendSticker(TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, int i);

        void setAsEmojiStatus(TLRPC$Document tLRPC$Document, Integer num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnlockPremiumView() {
    }

    private class FrameLayoutDrawer extends FrameLayout {
        public FrameLayoutDrawer(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            ContentPreviewViewer.this.onDraw(canvas);
        }
    }

    /* renamed from: org.rbmain.ui.ContentPreviewViewer$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zHasRecentGif;
            int stableInsetTop;
            int stableInsetBottom;
            int stableInsetTop2;
            int stableInsetBottom2;
            int stableInsetTop3;
            int stableInsetBottom3;
            int i;
            String str;
            if (ContentPreviewViewer.this.parentActivity == null) {
                return;
            }
            ContentPreviewViewer.this.closeOnDismiss = true;
            if (ContentPreviewViewer.this.currentContentType == 0) {
                if (!MessageObject.isPremiumSticker(ContentPreviewViewer.this.currentDocument) || AccountInstance.getInstance(ContentPreviewViewer.this.currentAccount).getUserConfig().isPremium()) {
                    boolean zIsStickerInFavorites = MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).isStickerInFavorites(ContentPreviewViewer.this.currentDocument);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ContentPreviewViewer.this.menuVisible = true;
                    ContentPreviewViewer.this.containerView.invalidate();
                    if (ContentPreviewViewer.this.delegate != null) {
                        if (ContentPreviewViewer.this.delegate.needSend(ContentPreviewViewer.this.currentContentType) && !ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                            arrayList.add(LocaleController.getString("SendStickerPreview", R.string.SendStickerPreview));
                            arrayList3.add(Integer.valueOf(R.drawable.msg_send));
                            arrayList2.add(0);
                        }
                        if (ContentPreviewViewer.this.delegate.needSend(ContentPreviewViewer.this.currentContentType) && !ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                            arrayList.add(LocaleController.getString("SendWithoutSound", R.string.SendWithoutSound));
                            arrayList3.add(Integer.valueOf(R.drawable.input_notify_off));
                            arrayList2.add(6);
                        }
                        if (ContentPreviewViewer.this.delegate.canSchedule()) {
                            arrayList.add(LocaleController.getString("Schedule", R.string.Schedule));
                            arrayList3.add(Integer.valueOf(R.drawable.msg_autodelete));
                            arrayList2.add(3);
                        }
                        if (ContentPreviewViewer.this.currentStickerSet != null && ContentPreviewViewer.this.delegate.needOpen()) {
                            arrayList.add(LocaleController.formatString("ViewPackPreview", R.string.ViewPackPreview, new Object[0]));
                            arrayList3.add(Integer.valueOf(R.drawable.msg_media));
                            arrayList2.add(1);
                        }
                        if (ContentPreviewViewer.this.delegate.needRemove()) {
                            arrayList.add(LocaleController.getString("ImportStickersRemoveMenu", R.string.ImportStickersRemoveMenu));
                            arrayList3.add(Integer.valueOf(R.drawable.msg_delete));
                            arrayList2.add(5);
                        }
                    }
                    if (!MessageObject.isMaskDocument(ContentPreviewViewer.this.currentDocument) && (zIsStickerInFavorites || (MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).canAddStickerToFavorites() && MessageObject.isStickerHasSet(ContentPreviewViewer.this.currentDocument)))) {
                        if (zIsStickerInFavorites) {
                            i = R.string.DeleteFromFavorites;
                            str = "DeleteFromFavorites";
                        } else {
                            i = R.string.AddToFavorites;
                            str = "AddToFavorites";
                        }
                        arrayList.add(LocaleController.getString(str, i));
                        arrayList3.add(Integer.valueOf(zIsStickerInFavorites ? R.drawable.msg_unfave : R.drawable.msg_fave));
                        arrayList2.add(2);
                    }
                    if (ContentPreviewViewer.this.isRecentSticker) {
                        arrayList.add(LocaleController.getString("DeleteFromRecent", R.string.DeleteFromRecent));
                        arrayList3.add(Integer.valueOf(R.drawable.msg_delete));
                        arrayList2.add(4);
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    int[] iArr = new int[arrayList3.size()];
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        iArr[i2] = ((Integer) arrayList3.get(i2)).intValue();
                    }
                    ViewOnClickListenerC00841 viewOnClickListenerC00841 = new ViewOnClickListenerC00841(arrayList2, zIsStickerInFavorites);
                    ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(ContentPreviewViewer.this.containerView.getContext(), R.drawable.popup_fixed_alert3, ContentPreviewViewer.this.resourcesProvider);
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        ActionBarMenuSubItem actionBarMenuSubItemAddItem = ActionBarMenuItem.addItem(actionBarPopupWindowLayout, ((Integer) arrayList3.get(i3)).intValue(), (CharSequence) arrayList.get(i3), false, ContentPreviewViewer.this.resourcesProvider);
                        actionBarMenuSubItemAddItem.setTag(Integer.valueOf(i3));
                        actionBarMenuSubItemAddItem.setOnClickListener(viewOnClickListenerC00841);
                    }
                    int i4 = -2;
                    ContentPreviewViewer.this.popupWindow = new ActionBarPopupWindow(actionBarPopupWindowLayout, i4, i4) { // from class: org.rbmain.ui.ContentPreviewViewer.1.2
                        @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
                        public void dismiss() {
                            super.dismiss();
                            ContentPreviewViewer contentPreviewViewer = ContentPreviewViewer.this;
                            contentPreviewViewer.popupWindow = null;
                            contentPreviewViewer.menuVisible = false;
                            if (ContentPreviewViewer.this.closeOnDismiss) {
                                ContentPreviewViewer.this.close();
                            }
                        }
                    };
                    ContentPreviewViewer.this.popupWindow.setPauseNotifications(true);
                    ContentPreviewViewer.this.popupWindow.setDismissAnimationDuration(100);
                    ContentPreviewViewer.this.popupWindow.setScaleOut(true);
                    ContentPreviewViewer.this.popupWindow.setOutsideTouchable(true);
                    ContentPreviewViewer.this.popupWindow.setClippingEnabled(true);
                    ContentPreviewViewer.this.popupWindow.setAnimationStyle(R.style.PopupContextAnimation);
                    ContentPreviewViewer.this.popupWindow.setFocusable(true);
                    actionBarPopupWindowLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
                    ContentPreviewViewer.this.popupWindow.setInputMethodMode(2);
                    ContentPreviewViewer.this.popupWindow.getContentView().setFocusableInTouchMode(true);
                    if (Build.VERSION.SDK_INT >= 21 && ContentPreviewViewer.this.lastInsets != null) {
                        stableInsetBottom3 = ContentPreviewViewer.this.lastInsets.getStableInsetBottom() + ContentPreviewViewer.this.lastInsets.getStableInsetTop();
                        stableInsetTop3 = ContentPreviewViewer.this.lastInsets.getStableInsetTop();
                    } else {
                        stableInsetTop3 = AndroidUtilities.statusBarHeight;
                        stableInsetBottom3 = 0;
                    }
                    int iMax = ((int) (ContentPreviewViewer.this.moveY + Math.max(stableInsetTop3 + r4 + (ContentPreviewViewer.this.stickerEmojiLayout != null ? AndroidUtilities.dp(40.0f) : 0), ((ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom3) - ContentPreviewViewer.this.keyboardHeight) / 2) + ((ContentPreviewViewer.this.currentContentType == 1 ? Math.min(ContentPreviewViewer.this.containerView.getWidth(), ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom3) - AndroidUtilities.dp(40.0f) : (int) (ContentPreviewViewer.this.drawEffect ? Math.min(ContentPreviewViewer.this.containerView.getWidth(), ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom3) - AndroidUtilities.dpf2(40.0f) : Math.min(ContentPreviewViewer.this.containerView.getWidth(), ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom3) / 1.8f)) / 2))) + AndroidUtilities.dp(24.0f);
                    if (ContentPreviewViewer.this.drawEffect) {
                        iMax += AndroidUtilities.dp(24.0f);
                    }
                    ContentPreviewViewer contentPreviewViewer = ContentPreviewViewer.this;
                    contentPreviewViewer.popupWindow.showAtLocation(contentPreviewViewer.containerView, 0, (int) ((ContentPreviewViewer.this.containerView.getMeasuredWidth() - actionBarPopupWindowLayout.getMeasuredWidth()) / 2.0f), iMax);
                    ContentPreviewViewer.this.containerView.performHapticFeedback(0);
                    return;
                }
                ContentPreviewViewer.this.showUnlockPremiumView();
                ContentPreviewViewer.this.menuVisible = true;
                ContentPreviewViewer.this.containerView.invalidate();
                ContentPreviewViewer.this.containerView.performHapticFeedback(0);
                return;
            }
            if (ContentPreviewViewer.this.currentContentType != 2 || ContentPreviewViewer.this.delegate == null) {
                if (ContentPreviewViewer.this.delegate != null) {
                    ContentPreviewViewer.this.menuVisible = true;
                    ContentPreviewViewer.this.containerView.invalidate();
                    ArrayList arrayList4 = new ArrayList();
                    final ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    if (ContentPreviewViewer.this.delegate.needSend(ContentPreviewViewer.this.currentContentType) && !ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                        arrayList4.add(LocaleController.getString("SendGifPreview", R.string.SendGifPreview));
                        arrayList6.add(Integer.valueOf(R.drawable.msg_send));
                        arrayList5.add(0);
                    }
                    if (ContentPreviewViewer.this.delegate.needSend(ContentPreviewViewer.this.currentContentType) && !ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                        arrayList4.add(LocaleController.getString("SendWithoutSound", R.string.SendWithoutSound));
                        arrayList6.add(Integer.valueOf(R.drawable.input_notify_off));
                        arrayList5.add(4);
                    }
                    if (ContentPreviewViewer.this.delegate.canSchedule()) {
                        arrayList4.add(LocaleController.getString("Schedule", R.string.Schedule));
                        arrayList6.add(Integer.valueOf(R.drawable.msg_autodelete));
                        arrayList5.add(3);
                    }
                    if (ContentPreviewViewer.this.currentDocument != null) {
                        zHasRecentGif = MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).hasRecentGif(ContentPreviewViewer.this.currentDocument);
                        if (zHasRecentGif) {
                            arrayList4.add(LocaleController.formatString("Delete", R.string.Delete, new Object[0]));
                            arrayList6.add(Integer.valueOf(R.drawable.msg_delete));
                            arrayList5.add(1);
                        } else {
                            arrayList4.add(LocaleController.formatString("SaveToGIFs", R.string.SaveToGIFs, new Object[0]));
                            arrayList6.add(Integer.valueOf(R.drawable.msg_gif_add));
                            arrayList5.add(2);
                        }
                    } else {
                        zHasRecentGif = false;
                    }
                    if (arrayList4.isEmpty()) {
                        return;
                    }
                    int[] iArr2 = new int[arrayList6.size()];
                    for (int i5 = 0; i5 < arrayList6.size(); i5++) {
                        iArr2[i5] = ((Integer) arrayList6.get(i5)).intValue();
                    }
                    ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = new ActionBarPopupWindow.ActionBarPopupWindowLayout(ContentPreviewViewer.this.containerView.getContext(), R.drawable.popup_fixed_alert2, ContentPreviewViewer.this.resourcesProvider);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: org.rbmain.ui.ContentPreviewViewer$1$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$run$3(arrayList5, view);
                        }
                    };
                    for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                        ActionBarMenuSubItem actionBarMenuSubItemAddItem2 = ActionBarMenuItem.addItem(actionBarPopupWindowLayout2, ((Integer) arrayList6.get(i6)).intValue(), (CharSequence) arrayList4.get(i6), false, ContentPreviewViewer.this.resourcesProvider);
                        actionBarMenuSubItemAddItem2.setTag(Integer.valueOf(i6));
                        actionBarMenuSubItemAddItem2.setOnClickListener(onClickListener);
                        if (zHasRecentGif && i6 == arrayList4.size() - 1) {
                            actionBarMenuSubItemAddItem2.setColors(ContentPreviewViewer.this.getThemedColor(Theme.key_text_RedBold), ContentPreviewViewer.this.getThemedColor(Theme.key_text_RedRegular));
                        }
                    }
                    int i7 = -2;
                    ContentPreviewViewer.this.popupWindow = new ActionBarPopupWindow(actionBarPopupWindowLayout2, i7, i7) { // from class: org.rbmain.ui.ContentPreviewViewer.1.4
                        @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
                        public void dismiss() {
                            super.dismiss();
                            ContentPreviewViewer contentPreviewViewer2 = ContentPreviewViewer.this;
                            contentPreviewViewer2.popupWindow = null;
                            contentPreviewViewer2.menuVisible = false;
                            if (ContentPreviewViewer.this.closeOnDismiss) {
                                ContentPreviewViewer.this.close();
                            }
                        }
                    };
                    ContentPreviewViewer.this.popupWindow.setPauseNotifications(true);
                    ContentPreviewViewer.this.popupWindow.setDismissAnimationDuration(ImageReceiver.DEFAULT_CROSSFADE_DURATION);
                    ContentPreviewViewer.this.popupWindow.setScaleOut(true);
                    ContentPreviewViewer.this.popupWindow.setOutsideTouchable(true);
                    ContentPreviewViewer.this.popupWindow.setClippingEnabled(true);
                    ContentPreviewViewer.this.popupWindow.setAnimationStyle(R.style.PopupContextAnimation);
                    ContentPreviewViewer.this.popupWindow.setFocusable(true);
                    actionBarPopupWindowLayout2.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
                    ContentPreviewViewer.this.popupWindow.setInputMethodMode(2);
                    ContentPreviewViewer.this.popupWindow.getContentView().setFocusableInTouchMode(true);
                    if (Build.VERSION.SDK_INT >= 21 && ContentPreviewViewer.this.lastInsets != null) {
                        stableInsetBottom = ContentPreviewViewer.this.lastInsets.getStableInsetBottom() + ContentPreviewViewer.this.lastInsets.getStableInsetTop();
                        stableInsetTop = ContentPreviewViewer.this.lastInsets.getStableInsetTop();
                    } else {
                        stableInsetTop = AndroidUtilities.statusBarHeight;
                        stableInsetBottom = 0;
                    }
                    int iMin = (Math.min(ContentPreviewViewer.this.containerView.getWidth(), ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom) - AndroidUtilities.dp(40.0f)) / 2;
                    int iMax2 = (int) (((int) (ContentPreviewViewer.this.moveY + Math.max(stableInsetTop + iMin + (ContentPreviewViewer.this.stickerEmojiLayout != null ? AndroidUtilities.dp(40.0f) : 0), ((ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom) - ContentPreviewViewer.this.keyboardHeight) / 2) + iMin)) + (AndroidUtilities.dp(24.0f) - ContentPreviewViewer.this.moveY));
                    ContentPreviewViewer contentPreviewViewer2 = ContentPreviewViewer.this;
                    contentPreviewViewer2.popupWindow.showAtLocation(contentPreviewViewer2.containerView, 0, (int) ((ContentPreviewViewer.this.containerView.getMeasuredWidth() - actionBarPopupWindowLayout2.getMeasuredWidth()) / 2.0f), iMax2);
                    ContentPreviewViewer.this.containerView.performHapticFeedback(0);
                    if (ContentPreviewViewer.this.moveY != 0.0f) {
                        if (ContentPreviewViewer.this.finalMoveY == 0.0f) {
                            ContentPreviewViewer.this.finalMoveY = 0.0f;
                            ContentPreviewViewer contentPreviewViewer3 = ContentPreviewViewer.this;
                            contentPreviewViewer3.startMoveY = contentPreviewViewer3.moveY;
                        }
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ContentPreviewViewer$1$$ExternalSyntheticLambda0
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                this.f$0.lambda$run$4(valueAnimator);
                            }
                        });
                        valueAnimatorOfFloat.setDuration(350L);
                        valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.DEFAULT);
                        valueAnimatorOfFloat.start();
                        return;
                    }
                    return;
                }
                return;
            }
            ContentPreviewViewer.this.menuVisible = true;
            ContentPreviewViewer.this.containerView.invalidate();
            ArrayList arrayList7 = new ArrayList();
            final ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            if (ContentPreviewViewer.this.delegate.needSend(ContentPreviewViewer.this.currentContentType)) {
                arrayList7.add(LocaleController.getString("SendEmojiPreview", R.string.SendEmojiPreview));
                arrayList9.add(Integer.valueOf(R.drawable.msg_send));
                arrayList8.add(0);
            }
            Boolean boolCanSetAsStatus = ContentPreviewViewer.this.delegate.canSetAsStatus(ContentPreviewViewer.this.currentDocument);
            if (boolCanSetAsStatus != null) {
                if (boolCanSetAsStatus.booleanValue()) {
                    arrayList7.add(LocaleController.getString("SetAsEmojiStatus", R.string.SetAsEmojiStatus));
                    arrayList9.add(Integer.valueOf(R.drawable.msg_smile_status));
                    arrayList8.add(1);
                } else {
                    arrayList7.add(LocaleController.getString("RemoveStatus", R.string.RemoveStatus));
                    arrayList9.add(Integer.valueOf(R.drawable.msg_smile_status));
                    arrayList8.add(2);
                }
            }
            if (ContentPreviewViewer.this.delegate.needCopy()) {
                arrayList7.add(LocaleController.getString("CopyEmojiPreview", R.string.CopyEmojiPreview));
                arrayList9.add(Integer.valueOf(R.drawable.msg_copy));
                arrayList8.add(3);
            }
            if (ContentPreviewViewer.this.delegate.needRemoveFromRecent(ContentPreviewViewer.this.currentDocument)) {
                arrayList7.add(LocaleController.getString("RemoveFromRecent", R.string.RemoveFromRecent));
                arrayList9.add(Integer.valueOf(R.drawable.msg_delete));
                arrayList8.add(4);
            }
            if (arrayList7.isEmpty()) {
                return;
            }
            int[] iArr3 = new int[arrayList9.size()];
            for (int i8 = 0; i8 < arrayList9.size(); i8++) {
                iArr3[i8] = ((Integer) arrayList9.get(i8)).intValue();
            }
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout3 = new ActionBarPopupWindow.ActionBarPopupWindowLayout(ContentPreviewViewer.this.containerView.getContext(), R.drawable.popup_fixed_alert2, ContentPreviewViewer.this.resourcesProvider);
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: org.rbmain.ui.ContentPreviewViewer$1$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$run$0(arrayList8, view);
                }
            };
            int i9 = 0;
            while (i9 < arrayList7.size()) {
                ActionBarMenuSubItem actionBarMenuSubItemAddItem3 = ActionBarMenuItem.addItem(i9 == 0, i9 == arrayList7.size() - 1, actionBarPopupWindowLayout3, ((Integer) arrayList9.get(i9)).intValue(), (CharSequence) arrayList7.get(i9), false, ContentPreviewViewer.this.resourcesProvider);
                if (((Integer) arrayList8.get(i9)).intValue() == 4) {
                    actionBarMenuSubItemAddItem3.setIconColor(ContentPreviewViewer.this.getThemedColor(Theme.key_text_RedRegular));
                    actionBarMenuSubItemAddItem3.setTextColor(ContentPreviewViewer.this.getThemedColor(Theme.key_text_RedBold));
                }
                actionBarMenuSubItemAddItem3.setTag(Integer.valueOf(i9));
                actionBarMenuSubItemAddItem3.setOnClickListener(onClickListener2);
                i9++;
            }
            int i10 = -2;
            ContentPreviewViewer.this.popupWindow = new ActionBarPopupWindow(actionBarPopupWindowLayout3, i10, i10) { // from class: org.rbmain.ui.ContentPreviewViewer.1.3
                @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
                public void dismiss() {
                    super.dismiss();
                    ContentPreviewViewer contentPreviewViewer4 = ContentPreviewViewer.this;
                    contentPreviewViewer4.popupWindow = null;
                    contentPreviewViewer4.menuVisible = false;
                    if (ContentPreviewViewer.this.closeOnDismiss) {
                        ContentPreviewViewer.this.close();
                    }
                }
            };
            ContentPreviewViewer.this.popupWindow.setPauseNotifications(true);
            ContentPreviewViewer.this.popupWindow.setDismissAnimationDuration(ImageReceiver.DEFAULT_CROSSFADE_DURATION);
            ContentPreviewViewer.this.popupWindow.setScaleOut(true);
            ContentPreviewViewer.this.popupWindow.setOutsideTouchable(true);
            ContentPreviewViewer.this.popupWindow.setClippingEnabled(true);
            ContentPreviewViewer.this.popupWindow.setAnimationStyle(R.style.PopupContextAnimation);
            ContentPreviewViewer.this.popupWindow.setFocusable(true);
            actionBarPopupWindowLayout3.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
            ContentPreviewViewer.this.popupWindow.setInputMethodMode(2);
            ContentPreviewViewer.this.popupWindow.getContentView().setFocusableInTouchMode(true);
            if (Build.VERSION.SDK_INT >= 21 && ContentPreviewViewer.this.lastInsets != null) {
                stableInsetBottom2 = ContentPreviewViewer.this.lastInsets.getStableInsetBottom() + ContentPreviewViewer.this.lastInsets.getStableInsetTop();
                stableInsetTop2 = ContentPreviewViewer.this.lastInsets.getStableInsetTop();
            } else {
                stableInsetTop2 = AndroidUtilities.statusBarHeight;
                stableInsetBottom2 = 0;
            }
            int iMin2 = (Math.min(ContentPreviewViewer.this.containerView.getWidth(), ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom2) - AndroidUtilities.dp(40.0f)) / 2;
            int iMax3 = (int) (((int) (ContentPreviewViewer.this.moveY + Math.max(stableInsetTop2 + iMin2 + (ContentPreviewViewer.this.stickerEmojiLayout != null ? AndroidUtilities.dp(40.0f) : 0), ((ContentPreviewViewer.this.containerView.getHeight() - stableInsetBottom2) - ContentPreviewViewer.this.keyboardHeight) / 2) + iMin2)) + (AndroidUtilities.dp(24.0f) - ContentPreviewViewer.this.moveY));
            ContentPreviewViewer contentPreviewViewer4 = ContentPreviewViewer.this;
            contentPreviewViewer4.popupWindow.showAtLocation(contentPreviewViewer4.containerView, 0, (int) ((ContentPreviewViewer.this.containerView.getMeasuredWidth() - actionBarPopupWindowLayout3.getMeasuredWidth()) / 2.0f), iMax3);
            ActionBarPopupWindow.startAnimation(actionBarPopupWindowLayout3);
            ContentPreviewViewer.this.containerView.performHapticFeedback(0);
            if (ContentPreviewViewer.this.moveY != 0.0f) {
                if (ContentPreviewViewer.this.finalMoveY == 0.0f) {
                    ContentPreviewViewer.this.finalMoveY = 0.0f;
                    ContentPreviewViewer contentPreviewViewer5 = ContentPreviewViewer.this;
                    contentPreviewViewer5.startMoveY = contentPreviewViewer5.moveY;
                }
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ContentPreviewViewer$1$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$run$1(valueAnimator);
                    }
                });
                valueAnimatorOfFloat2.setDuration(350L);
                valueAnimatorOfFloat2.setInterpolator(CubicBezierInterpolator.DEFAULT);
                valueAnimatorOfFloat2.start();
            }
        }

        /* renamed from: org.rbmain.ui.ContentPreviewViewer$1$1, reason: invalid class name and collision with other inner class name */
        class ViewOnClickListenerC00841 implements View.OnClickListener {
            final /* synthetic */ ArrayList val$actions;
            final /* synthetic */ boolean val$inFavs;

            ViewOnClickListenerC00841(ArrayList arrayList, boolean z) {
                this.val$actions = arrayList;
                this.val$inFavs = z;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentPreviewViewer.this.parentActivity == null) {
                    return;
                }
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (((Integer) this.val$actions.get(iIntValue)).intValue() == 0 || ((Integer) this.val$actions.get(iIntValue)).intValue() == 6) {
                    if (ContentPreviewViewer.this.delegate != null) {
                        ContentPreviewViewer.this.delegate.sendSticker(ContentPreviewViewer.this.currentDocument, ContentPreviewViewer.this.currentQuery, ContentPreviewViewer.this.parentObject, ((Integer) this.val$actions.get(iIntValue)).intValue() == 0, 0);
                    }
                } else if (((Integer) this.val$actions.get(iIntValue)).intValue() == 1) {
                    if (ContentPreviewViewer.this.delegate != null) {
                        ContentPreviewViewer.this.delegate.openSet(ContentPreviewViewer.this.currentStickerSet, ContentPreviewViewer.this.clearsInputField);
                    }
                } else if (((Integer) this.val$actions.get(iIntValue)).intValue() == 2) {
                    MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).addRecentSticker(2, ContentPreviewViewer.this.parentObject, ContentPreviewViewer.this.currentDocument, (int) (System.currentTimeMillis() / 1000), this.val$inFavs);
                } else if (((Integer) this.val$actions.get(iIntValue)).intValue() == 3) {
                    final TLRPC$Document tLRPC$Document = ContentPreviewViewer.this.currentDocument;
                    final Object obj = ContentPreviewViewer.this.parentObject;
                    final String str = ContentPreviewViewer.this.currentQuery;
                    final ContentPreviewViewerDelegate contentPreviewViewerDelegate = ContentPreviewViewer.this.delegate;
                    if (contentPreviewViewerDelegate == null) {
                        return;
                    } else {
                        AlertsCreator.createScheduleDatePickerDialog(ContentPreviewViewer.this.parentActivity, contentPreviewViewerDelegate.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.ContentPreviewViewer$1$1$$ExternalSyntheticLambda0
                            @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                            public final void didSelectDate(boolean z, int i) {
                                contentPreviewViewerDelegate.sendSticker(tLRPC$Document, str, obj, z, i);
                            }
                        });
                    }
                } else if (((Integer) this.val$actions.get(iIntValue)).intValue() == 4) {
                    MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).addRecentSticker(0, ContentPreviewViewer.this.parentObject, ContentPreviewViewer.this.currentDocument, (int) (System.currentTimeMillis() / 1000), true);
                } else {
                    ((Integer) this.val$actions.get(iIntValue)).intValue();
                }
                ActionBarPopupWindow actionBarPopupWindow = ContentPreviewViewer.this.popupWindow;
                if (actionBarPopupWindow != null) {
                    actionBarPopupWindow.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(ArrayList arrayList, View view) {
            if (ContentPreviewViewer.this.parentActivity == null || ContentPreviewViewer.this.delegate == null) {
                return;
            }
            int iIntValue = ((Integer) arrayList.get(((Integer) view.getTag()).intValue())).intValue();
            if (iIntValue == 0) {
                ContentPreviewViewer.this.delegate.sendEmoji(ContentPreviewViewer.this.currentDocument);
            } else if (iIntValue == 1) {
                ContentPreviewViewer.this.delegate.setAsEmojiStatus(ContentPreviewViewer.this.currentDocument, null);
            } else if (iIntValue == 2) {
                ContentPreviewViewer.this.delegate.setAsEmojiStatus(null, null);
            } else if (iIntValue == 3) {
                ContentPreviewViewer.this.delegate.copyEmoji(ContentPreviewViewer.this.currentDocument);
            } else if (iIntValue == 4) {
                ContentPreviewViewer.this.delegate.removeFromRecent(ContentPreviewViewer.this.currentDocument);
            }
            ActionBarPopupWindow actionBarPopupWindow = ContentPreviewViewer.this.popupWindow;
            if (actionBarPopupWindow != null) {
                actionBarPopupWindow.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(ValueAnimator valueAnimator) {
            ContentPreviewViewer.this.currentMoveYProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ContentPreviewViewer contentPreviewViewer = ContentPreviewViewer.this;
            contentPreviewViewer.moveY = contentPreviewViewer.startMoveY + ((ContentPreviewViewer.this.finalMoveY - ContentPreviewViewer.this.startMoveY) * ContentPreviewViewer.this.currentMoveYProgress);
            ContentPreviewViewer.this.containerView.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$3(ArrayList arrayList, View view) {
            if (ContentPreviewViewer.this.parentActivity == null) {
                return;
            }
            int iIntValue = ((Integer) view.getTag()).intValue();
            if (((Integer) arrayList.get(iIntValue)).intValue() == 0) {
                ContentPreviewViewer.this.delegate.sendGif(ContentPreviewViewer.this.currentDocument != null ? ContentPreviewViewer.this.currentDocument : ContentPreviewViewer.this.inlineResult, ContentPreviewViewer.this.parentObject, true, 0);
            } else if (((Integer) arrayList.get(iIntValue)).intValue() == 4) {
                ContentPreviewViewer.this.delegate.sendGif(ContentPreviewViewer.this.currentDocument != null ? ContentPreviewViewer.this.currentDocument : ContentPreviewViewer.this.inlineResult, ContentPreviewViewer.this.parentObject, false, 0);
            } else if (((Integer) arrayList.get(iIntValue)).intValue() == 1) {
                MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).removeRecentGif(ContentPreviewViewer.this.currentDocument);
                ContentPreviewViewer.this.delegate.gifAddedOrDeleted();
            } else if (((Integer) arrayList.get(iIntValue)).intValue() == 2) {
                MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).addRecentGif(ContentPreviewViewer.this.currentDocument, (int) (System.currentTimeMillis() / 1000), true);
                MessagesController.getInstance(ContentPreviewViewer.this.currentAccount).saveGif("gif", ContentPreviewViewer.this.currentDocument);
                ContentPreviewViewer.this.delegate.gifAddedOrDeleted();
            } else if (((Integer) arrayList.get(iIntValue)).intValue() == 3) {
                final TLRPC$Document tLRPC$Document = ContentPreviewViewer.this.currentDocument;
                final TLRPC$BotInlineResult tLRPC$BotInlineResult = ContentPreviewViewer.this.inlineResult;
                final Object obj = ContentPreviewViewer.this.parentObject;
                final ContentPreviewViewerDelegate contentPreviewViewerDelegate = ContentPreviewViewer.this.delegate;
                AlertsCreator.createScheduleDatePickerDialog(ContentPreviewViewer.this.parentActivity, contentPreviewViewerDelegate.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.ContentPreviewViewer$1$$ExternalSyntheticLambda4
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i) {
                        ContentPreviewViewer.AnonymousClass1.lambda$run$2(contentPreviewViewerDelegate, tLRPC$Document, tLRPC$BotInlineResult, obj, z, i);
                    }
                }, ContentPreviewViewer.this.resourcesProvider);
            }
            ActionBarPopupWindow actionBarPopupWindow = ContentPreviewViewer.this.popupWindow;
            if (actionBarPopupWindow != null) {
                actionBarPopupWindow.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void lambda$run$2(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document, TLRPC$BotInlineResult tLRPC$BotInlineResult, Object obj, boolean z, int i) {
            if (tLRPC$Document == null) {
                tLRPC$Document = tLRPC$BotInlineResult;
            }
            contentPreviewViewerDelegate.sendGif(tLRPC$Document, obj, z, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$4(ValueAnimator valueAnimator) {
            ContentPreviewViewer.this.currentMoveYProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ContentPreviewViewer contentPreviewViewer = ContentPreviewViewer.this;
            contentPreviewViewer.moveY = contentPreviewViewer.startMoveY + ((ContentPreviewViewer.this.finalMoveY - ContentPreviewViewer.this.startMoveY) * ContentPreviewViewer.this.currentMoveYProgress);
            ContentPreviewViewer.this.containerView.invalidate();
        }
    }

    public static ContentPreviewViewer getInstance() {
        ContentPreviewViewer contentPreviewViewer = Instance;
        if (contentPreviewViewer == null) {
            synchronized (PhotoViewer.class) {
                contentPreviewViewer = Instance;
                if (contentPreviewViewer == null) {
                    contentPreviewViewer = new ContentPreviewViewer();
                    Instance = contentPreviewViewer;
                }
            }
        }
        return contentPreviewViewer;
    }

    public static boolean hasInstance() {
        return Instance != null;
    }

    public void reset() {
        Runnable runnable = this.openPreviewRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.openPreviewRunnable = null;
        }
        View view = this.currentPreviewCell;
        if (view != null) {
            if (view instanceof StickerEmojiCell) {
                ((StickerEmojiCell) view).setScaled(false);
            } else if (view instanceof StickerCell) {
                ((StickerCell) view).setScaled(false);
            } else if (view instanceof ContextLinkCell) {
                ((ContextLinkCell) view).setScaled(false);
            }
            this.currentPreviewCell = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.MotionEvent r16, final org.rbmain.ui.Components.RecyclerListView r17, int r18, final java.lang.Object r19, org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate r20, org.rbmain.ui.ActionBar.Theme.ResourcesProvider r21) {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ContentPreviewViewer.onTouch(android.view.MotionEvent, org.rbmain.ui.Components.RecyclerListView, int, java.lang.Object, org.rbmain.ui.ContentPreviewViewer$ContentPreviewViewerDelegate, org.rbmain.ui.ActionBar.Theme$ResourcesProvider):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onTouch$0(RecyclerListView recyclerListView, Object obj) {
        if (recyclerListView instanceof RecyclerListView) {
            recyclerListView.setOnItemClickListener((RecyclerListView.OnItemClickListener) obj);
        }
    }

    protected void runSmoothHaptic() {
        if (Build.VERSION.SDK_INT >= 26) {
            Vibrator vibrator = (Vibrator) this.containerView.getContext().getSystemService("vibrator");
            if (this.vibrationEffect == null) {
                this.vibrationEffect = VibrationEffect.createWaveform(new long[]{0, 2}, -1);
            }
            vibrator.cancel();
            vibrator.vibrate(this.vibrationEffect);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8, final org.rbmain.ui.Components.RecyclerListView r9, int r10, org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate r11, final org.rbmain.ui.ActionBar.Theme.ResourcesProvider r12) {
        /*
            r7 = this;
            r7.delegate = r11
            r7.resourcesProvider = r12
            r10 = 0
            if (r11 == 0) goto Le
            boolean r11 = r11.can()
            if (r11 != 0) goto Le
            return r10
        Le:
            int r11 = r8.getAction()
            if (r11 != 0) goto Lca
            float r11 = r8.getX()
            int r11 = (int) r11
            float r8 = r8.getY()
            int r8 = (int) r8
            int r0 = r9.getChildCount()
            r1 = 0
        L23:
            if (r1 >= r0) goto Lca
            android.view.View r2 = r9.getChildAt(r1)
            if (r2 != 0) goto L2c
            return r10
        L2c:
            int r3 = r2.getTop()
            int r4 = r2.getBottom()
            int r5 = r2.getLeft()
            int r6 = r2.getRight()
            if (r3 > r8) goto Lc6
            if (r4 < r8) goto Lc6
            if (r5 > r11) goto Lc6
            if (r6 >= r11) goto L46
            goto Lc6
        L46:
            boolean r0 = r2 instanceof org.rbmain.ui.Cells.StickerEmojiCell
            r1 = -1
            r3 = 1
            if (r0 == 0) goto L5c
            r0 = r2
            org.rbmain.ui.Cells.StickerEmojiCell r0 = (org.rbmain.ui.Cells.StickerEmojiCell) r0
            boolean r0 = r0.showingBitmap()
            if (r0 == 0) goto Laf
            org.rbmain.messenger.ImageReceiver r0 = r7.centerImage
            r0.setRoundRadius(r10)
        L5a:
            r0 = 0
            goto Lb0
        L5c:
            boolean r0 = r2 instanceof org.rbmain.ui.Cells.StickerCell
            if (r0 == 0) goto L6f
            r0 = r2
            org.rbmain.ui.Cells.StickerCell r0 = (org.rbmain.ui.Cells.StickerCell) r0
            boolean r0 = r0.showingBitmap()
            if (r0 == 0) goto Laf
            org.rbmain.messenger.ImageReceiver r0 = r7.centerImage
            r0.setRoundRadius(r10)
            goto L5a
        L6f:
            boolean r0 = r2 instanceof org.rbmain.ui.Cells.ContextLinkCell
            if (r0 == 0) goto L9b
            r0 = r2
            org.rbmain.ui.Cells.ContextLinkCell r0 = (org.rbmain.ui.Cells.ContextLinkCell) r0
            boolean r4 = r0.showingBitmap()
            if (r4 == 0) goto Laf
            boolean r4 = r0.isSticker()
            if (r4 == 0) goto L88
            org.rbmain.messenger.ImageReceiver r0 = r7.centerImage
            r0.setRoundRadius(r10)
            goto L5a
        L88:
            boolean r0 = r0.isGif()
            if (r0 == 0) goto Laf
            org.rbmain.messenger.ImageReceiver r0 = r7.centerImage
            r4 = 1086324736(0x40c00000, float:6.0)
            int r4 = org.rbmain.messenger.AndroidUtilities.dp(r4)
            r0.setRoundRadius(r4)
            r0 = 1
            goto Lb0
        L9b:
            boolean r0 = r2 instanceof org.rbmain.ui.Components.SuggestEmojiView.EmojiImageView
            if (r0 == 0) goto Laf
            r0 = r2
            org.rbmain.ui.Components.SuggestEmojiView$EmojiImageView r0 = (org.rbmain.ui.Components.SuggestEmojiView.EmojiImageView) r0
            android.graphics.drawable.Drawable r0 = r0.drawable
            boolean r0 = r0 instanceof org.rbmain.ui.Components.AnimatedEmojiDrawable
            if (r0 == 0) goto Laf
            r0 = 2
            org.rbmain.messenger.ImageReceiver r4 = r7.centerImage
            r4.setRoundRadius(r10)
            goto Lb0
        Laf:
            r0 = -1
        Lb0:
            if (r0 != r1) goto Lb3
            return r10
        Lb3:
            r7.startX = r11
            r7.startY = r8
            r7.currentPreviewCell = r2
            org.rbmain.ui.ContentPreviewViewer$$ExternalSyntheticLambda4 r8 = new org.rbmain.ui.ContentPreviewViewer$$ExternalSyntheticLambda4
            r8.<init>()
            r7.openPreviewRunnable = r8
            r9 = 200(0xc8, double:9.9E-322)
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r8, r9)
            return r3
        Lc6:
            int r1 = r1 + 1
            goto L23
        Lca:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ContentPreviewViewer.onInterceptTouchEvent(android.view.MotionEvent, org.rbmain.ui.Components.RecyclerListView, int, org.rbmain.ui.ContentPreviewViewer$ContentPreviewViewerDelegate, org.rbmain.ui.ActionBar.Theme$ResourcesProvider):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$onInterceptTouchEvent$1(org.rbmain.ui.Components.RecyclerListView r15, int r16, org.rbmain.ui.ActionBar.Theme.ResourcesProvider r17) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ContentPreviewViewer.lambda$onInterceptTouchEvent$1(org.rbmain.ui.Components.RecyclerListView, int, org.rbmain.ui.ActionBar.Theme$ResourcesProvider):void");
    }

    public void setParentActivity(Activity activity) {
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.centerImage.setCurrentAccount(i);
        this.centerImage.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
        this.effectImage.setCurrentAccount(this.currentAccount);
        this.effectImage.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
        if (this.parentActivity == activity) {
            return;
        }
        this.parentActivity = activity;
        this.slideUpDrawable = activity.getResources().getDrawable(R.drawable.preview_arrow);
        FrameLayout frameLayout = new FrameLayout(activity);
        this.windowView = frameLayout;
        frameLayout.setFocusable(true);
        this.windowView.setFocusableInTouchMode(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.windowView.setFitsSystemWindows(true);
            this.windowView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: org.rbmain.ui.ContentPreviewViewer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$setParentActivity$2(view, windowInsets);
                }
            });
        }
        FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(activity) { // from class: org.rbmain.ui.ContentPreviewViewer.2
            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                ContentPreviewViewer.this.centerImage.onAttachedToWindow();
                ContentPreviewViewer.this.effectImage.onAttachedToWindow();
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                ContentPreviewViewer.this.centerImage.onDetachedFromWindow();
                ContentPreviewViewer.this.effectImage.onDetachedFromWindow();
            }
        };
        this.containerView = frameLayoutDrawer;
        frameLayoutDrawer.setFocusable(false);
        this.windowView.addView(this.containerView, LayoutHelper.createFrame(-1, -1, 51));
        this.containerView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.ContentPreviewViewer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setParentActivity$3(view, motionEvent);
            }
        });
        MessagesController.getInstance(this.currentAccount);
        this.keyboardHeight = MessagesController.getGlobalEmojiSettings().getInt("kbd_height", AndroidUtilities.dp(200.0f));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 48;
        layoutParams.type = 99;
        if (i2 >= 21) {
            layoutParams.flags = -2147417848;
        } else {
            layoutParams.flags = 8;
        }
        this.centerImage.setAspectFit(true);
        this.centerImage.setInvalidateAll(true);
        this.centerImage.setParentView(this.containerView);
        this.effectImage.setAspectFit(true);
        this.effectImage.setInvalidateAll(true);
        this.effectImage.setParentView(this.containerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$setParentActivity$2(View view, WindowInsets windowInsets) {
        this.lastInsets = windowInsets;
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setParentActivity$3(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 6 || motionEvent.getAction() == 3) {
            close();
        }
        return true;
    }

    public void open(TLRPC$Document tLRPC$Document, Object obj, String str, String str2, TLRPC$BotInlineResult tLRPC$BotInlineResult, int i, boolean z, Object obj2, Theme.ResourcesProvider resourcesProvider) {
        ContentPreviewViewerDelegate contentPreviewViewerDelegate;
        TLRPC$InputStickerSet tLRPC$InputStickerSet;
        if (this.parentActivity == null || this.windowView == null) {
            return;
        }
        this.resourcesProvider = resourcesProvider;
        this.isRecentSticker = z;
        TLRPC$InputStickerSet tLRPC$InputStickerSet2 = null;
        this.stickerEmojiLayout = null;
        this.backgroundDrawable.setColor(Theme.getActiveTheme().isDark() ? 1895825408 : 1692853990);
        this.drawEffect = false;
        this.centerImage.setColorFilter(null);
        if (i != 0 && i != 2) {
            if (tLRPC$Document != null) {
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
                TLRPC$VideoSize documentVideoThumb = MessageObject.getDocumentVideoThumb(tLRPC$Document);
                ImageLocation forDocument = ImageLocation.getForDocument(tLRPC$Document);
                forDocument.imageType = 2;
                if (documentVideoThumb != null) {
                    this.centerImage.setImage(forDocument, null, ImageLocation.getForDocument(documentVideoThumb, tLRPC$Document), null, ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document), "90_90_b", null, tLRPC$Document.size, null, "gif" + tLRPC$Document, 0);
                } else {
                    this.centerImage.setImage(forDocument, null, ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document), "90_90_b", tLRPC$Document.size, null, "gif" + tLRPC$Document, 0);
                }
            } else {
                if (tLRPC$BotInlineResult == null || tLRPC$BotInlineResult.content == null) {
                    return;
                }
                TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.thumb;
                if ((tLRPC$WebDocument instanceof TLRPC$TL_webDocument) && "video/mp4".equals(tLRPC$WebDocument.mime_type)) {
                    this.centerImage.setImage(ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.content)), null, ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.thumb)), null, ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.thumb)), "90_90_b", null, tLRPC$BotInlineResult.content.size, null, "gif" + tLRPC$BotInlineResult, 1);
                } else {
                    this.centerImage.setImage(ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.content)), null, ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.thumb)), "90_90_b", tLRPC$BotInlineResult.content.size, null, "gif" + tLRPC$BotInlineResult, 1);
                }
            }
            AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
            AndroidUtilities.runOnUIThread(this.showSheetRunnable, 2000L);
        } else {
            if (tLRPC$Document == null && obj == null) {
                return;
            }
            if (textPaint == null) {
                TextPaint textPaint2 = new TextPaint(1);
                textPaint = textPaint2;
                textPaint2.setTextSize(AndroidUtilities.dp(24.0f));
            }
            this.effectImage.clearImage();
            this.drawEffect = false;
            if (tLRPC$Document != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= tLRPC$Document.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i2);
                    if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) && (tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset) != null) {
                        tLRPC$InputStickerSet2 = tLRPC$InputStickerSet;
                        break;
                    }
                    i2++;
                }
                if (i == 2 && str != null) {
                    this.stickerEmojiLayout = new StaticLayout(Emoji.replaceEmoji(str, textPaint.getFontMetricsInt(), AndroidUtilities.dp(24.0f), false), textPaint, AndroidUtilities.dp(500.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                }
                if ((tLRPC$InputStickerSet2 != null || i == 2) && ((contentPreviewViewerDelegate = this.delegate) == null || contentPreviewViewerDelegate.needMenu())) {
                    AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
                    AndroidUtilities.runOnUIThread(this.showSheetRunnable, 1300L);
                }
                this.currentStickerSet = tLRPC$InputStickerSet2;
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
                if (MessageObject.isVideoStickerDocument(tLRPC$Document)) {
                    this.centerImage.setImage(ImageLocation.getForDocument(tLRPC$Document), null, ImageLocation.getForDocument(closestPhotoSizeWithSize2, tLRPC$Document), null, null, 0L, "webp", this.currentStickerSet, 1);
                } else {
                    this.centerImage.setImage(ImageLocation.getForDocument(tLRPC$Document), (String) null, ImageLocation.getForDocument(closestPhotoSizeWithSize2, tLRPC$Document), (String) null, "webp", this.currentStickerSet, 1);
                    if (MessageObject.isPremiumSticker(tLRPC$Document)) {
                        this.drawEffect = true;
                        this.effectImage.setImage(ImageLocation.getForDocument(MessageObject.getPremiumStickerAnimation(tLRPC$Document), tLRPC$Document), (String) null, (ImageLocation) null, (String) null, "tgs", this.currentStickerSet, 1);
                    }
                }
                if (MessageObject.isTextColorEmoji(tLRPC$Document)) {
                    this.centerImage.setColorFilter(Theme.chat_animatedEmojiTextColorFilter);
                }
                if (this.stickerEmojiLayout == null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= tLRPC$Document.attributes.size()) {
                            break;
                        }
                        TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = tLRPC$Document.attributes.get(i3);
                        if ((tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeSticker) && !TextUtils.isEmpty(tLRPC$DocumentAttribute2.alt)) {
                            this.stickerEmojiLayout = new StaticLayout(Emoji.replaceEmoji(tLRPC$DocumentAttribute2.alt, textPaint.getFontMetricsInt(), AndroidUtilities.dp(24.0f), false), textPaint, AndroidUtilities.dp(500.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        if (this.centerImage.getLottieAnimation() != null) {
            this.centerImage.getLottieAnimation().setCurrentFrame(0);
        }
        if (this.drawEffect && this.effectImage.getLottieAnimation() != null) {
            this.effectImage.getLottieAnimation().setCurrentFrame(0);
        }
        this.currentContentType = i;
        this.currentDocument = tLRPC$Document;
        this.currentQuery = str2;
        this.inlineResult = tLRPC$BotInlineResult;
        this.parentObject = obj2;
        this.resourcesProvider = resourcesProvider;
        this.containerView.invalidate();
        if (this.isVisible) {
            return;
        }
        AndroidUtilities.lockOrientation(this.parentActivity);
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        ((WindowManager) this.parentActivity.getSystemService("window")).addView(this.windowView, this.windowLayoutParams);
        this.isVisible = true;
        this.showProgress = 0.0f;
        this.lastTouchY = -10000.0f;
        this.currentMoveYProgress = 0.0f;
        this.finalMoveY = 0.0f;
        this.currentMoveY = 0.0f;
        this.moveY = 0.0f;
        this.lastUpdateTime = System.currentTimeMillis();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 8);
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void closeWithMenu() {
        this.menuVisible = false;
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
            this.popupWindow = null;
        }
        close();
    }

    public void close() {
        if (this.parentActivity == null || this.menuVisible) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
        this.showProgress = 1.0f;
        this.lastUpdateTime = System.currentTimeMillis();
        this.containerView.invalidate();
        this.currentDocument = null;
        this.currentStickerSet = null;
        this.currentQuery = null;
        this.delegate = null;
        this.isVisible = false;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 8);
    }

    public void destroy() {
        this.isVisible = false;
        this.delegate = null;
        this.currentDocument = null;
        this.currentQuery = null;
        this.currentStickerSet = null;
        if (this.parentActivity == null || this.windowView == null) {
            return;
        }
        Bitmap bitmap = this.blurrBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.blurrBitmap = null;
        }
        this.blurProgress = 0.0f;
        this.menuVisible = false;
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeViewImmediate(this.windowView);
            }
            this.windowView = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        Instance = null;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 8);
    }

    private float rubberYPoisition(float f, float f2) {
        return (-((1.0f - (1.0f / (((Math.abs(f) * 0.55f) / f2) + 1.0f))) * f2)) * (f >= 0.0f ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ContentPreviewViewer.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDraw$4() {
        this.centerImage.setImageBitmap((Bitmap) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }

    private void prepareBlurBitmap() {
        Activity activity = this.parentActivity;
        if (activity == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        int measuredWidth = (int) (decorView.getMeasuredWidth() / 12.0f);
        int measuredHeight = (int) (decorView.getMeasuredHeight() / 12.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(0.083333336f, 0.083333336f);
        canvas.drawColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        decorView.draw(canvas);
        Activity activity2 = this.parentActivity;
        if ((activity2 instanceof LaunchActivity) && ((LaunchActivity) activity2).getActionBarLayout().getLastFragment().getVisibleDialog() != null) {
            ((LaunchActivity) this.parentActivity).getActionBarLayout().getLastFragment().getVisibleDialog().getWindow().getDecorView().draw(canvas);
        }
        Utilities.stackBlurBitmap(bitmapCreateBitmap, Math.max(10, Math.max(measuredWidth, measuredHeight) / 180));
        this.blurrBitmap = bitmapCreateBitmap;
    }
}
