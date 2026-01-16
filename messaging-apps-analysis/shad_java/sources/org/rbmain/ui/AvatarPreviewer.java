package org.rbmain.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.Components.RadialProgress2;

/* loaded from: classes4.dex */
public class AvatarPreviewer {
    private static AvatarPreviewer INSTANCE;
    private Layout layout;
    private ViewGroup view;
    private boolean visible;
    private WindowManager windowManager;

    public interface Callback {
        void onMenuClick(MenuItem menuItem);
    }

    public static AvatarPreviewer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AvatarPreviewer();
        }
        return INSTANCE;
    }

    public static boolean hasVisibleInstance() {
        AvatarPreviewer avatarPreviewer = INSTANCE;
        return avatarPreviewer != null && avatarPreviewer.visible;
    }

    public static boolean canPreview(Data data) {
        return (data == null || (data.imageLocation == null && data.thumbImageLocation == null)) ? false : true;
    }

    public void show(ViewGroup viewGroup, Data data, Callback callback) {
        Preconditions.checkNotNull(viewGroup);
        Preconditions.checkNotNull(data);
        Preconditions.checkNotNull(callback);
        Context context = viewGroup.getContext();
        if (this.view != viewGroup) {
            close();
            this.view = viewGroup;
            this.windowManager = (WindowManager) ContextCompat.getSystemService(context, WindowManager.class);
            this.layout = new Layout(context, callback) { // from class: org.rbmain.ui.AvatarPreviewer.1
                @Override // org.rbmain.ui.AvatarPreviewer.Layout
                protected void onHide() {
                    AvatarPreviewer.this.close();
                }
            };
        }
        this.layout.setData(data);
        if (this.visible) {
            return;
        }
        if (this.layout.getParent() != null) {
            this.windowManager.removeView(this.layout);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 99, 0, -3);
        if (Build.VERSION.SDK_INT >= 21) {
            layoutParams.flags = -2147286784;
        }
        this.windowManager.addView(this.layout, layoutParams);
        viewGroup.requestDisallowInterceptTouchEvent(true);
        this.visible = true;
    }

    public void close() {
        if (this.visible) {
            this.visible = false;
            if (this.layout.getParent() != null) {
                this.windowManager.removeView(this.layout);
            }
            this.layout.recycle();
            this.layout = null;
            this.view.requestDisallowInterceptTouchEvent(false);
            this.view = null;
            this.windowManager = null;
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        Layout layout = this.layout;
        if (layout != null) {
            layout.onTouchEvent(motionEvent);
        }
    }

    public enum MenuItem {
        OPEN_PROFILE("OpenProfile", R.string.OpenProfile, R.drawable.msg_openprofile),
        OPEN_CHANNEL("OpenChannel2", R.string.OpenChannel2, R.drawable.msg_channel),
        OPEN_GROUP("OpenGroup2", R.string.OpenGroup2, R.drawable.msg_discussion),
        SEND_MESSAGE("SendMessage", R.string.SendMessage, R.drawable.msg_discussion),
        MENTION("Mention", R.string.Mention, R.drawable.msg_mention);

        private final int iconResId;
        private final String labelKey;
        private final int labelResId;

        MenuItem(String str, int i, int i2) {
            this.labelKey = str;
            this.labelResId = i;
            this.iconResId = i2;
        }
    }

    public static class Data {
        private final String imageFilter;
        private final ImageLocation imageLocation;
        private final InfoLoadTask<?, ?> infoLoadTask;
        private final MenuItem[] menuItems;
        private final Object parentObject;
        private final String thumbImageFilter;
        private final ImageLocation thumbImageLocation;
        private final String videoFileName;
        private final String videoFilter;
        private final ImageLocation videoLocation;

        public static Data of(TLRPC$User tLRPC$User, int i, MenuItem... menuItemArr) {
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(tLRPC$User, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(tLRPC$User, 1);
            return new Data(forUserOrChat, forUserOrChat2, null, null, (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b", null, null, tLRPC$User, menuItemArr, new UserInfoLoadTask(tLRPC$User, i));
        }

        public static Data of(TLRPC$UserFull tLRPC$UserFull, MenuItem... menuItemArr) {
            ImageLocation imageLocation;
            String attachFileName;
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(tLRPC$UserFull.user, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(tLRPC$UserFull.user, 1);
            String str = null;
            String str2 = (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b";
            TLRPC$Photo tLRPC$Photo = tLRPC$UserFull.profile_photo;
            if (tLRPC$Photo == null || tLRPC$Photo.video_sizes.isEmpty()) {
                imageLocation = null;
                attachFileName = null;
            } else {
                TLRPC$VideoSize tLRPC$VideoSize = tLRPC$UserFull.profile_photo.video_sizes.get(0);
                ImageLocation forPhoto = ImageLocation.getForPhoto(tLRPC$VideoSize, tLRPC$UserFull.profile_photo);
                attachFileName = FileLoader.getAttachFileName(tLRPC$VideoSize);
                imageLocation = forPhoto;
            }
            if (imageLocation != null && imageLocation.imageType == 2) {
                str = ImageLoader.AUTOPLAY_FILTER;
            }
            return new Data(forUserOrChat, forUserOrChat2, imageLocation, null, str2, str, attachFileName, tLRPC$UserFull.user, menuItemArr, null);
        }

        public static Data of(TLRPC$Chat tLRPC$Chat, int i, MenuItem... menuItemArr) {
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(tLRPC$Chat, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(tLRPC$Chat, 1);
            return new Data(forUserOrChat, forUserOrChat2, null, null, (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b", null, null, tLRPC$Chat, menuItemArr, new ChatInfoLoadTask(tLRPC$Chat, i));
        }

        public static Data of(TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull, MenuItem... menuItemArr) {
            ImageLocation forPhoto;
            String attachFileName;
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(tLRPC$Chat, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(tLRPC$Chat, 1);
            String str = (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b";
            TLRPC$Photo tLRPC$Photo = tLRPC$ChatFull.chat_photo;
            if (tLRPC$Photo == null || tLRPC$Photo.video_sizes.isEmpty()) {
                forPhoto = null;
                attachFileName = null;
            } else {
                TLRPC$VideoSize tLRPC$VideoSize = tLRPC$ChatFull.chat_photo.video_sizes.get(0);
                forPhoto = ImageLocation.getForPhoto(tLRPC$VideoSize, tLRPC$ChatFull.chat_photo);
                attachFileName = FileLoader.getAttachFileName(tLRPC$VideoSize);
            }
            return new Data(forUserOrChat, forUserOrChat2, forPhoto, null, str, (forPhoto == null || forPhoto.imageType != 2) ? null : ImageLoader.AUTOPLAY_FILTER, attachFileName, tLRPC$Chat, menuItemArr, null);
        }

        private Data(ImageLocation imageLocation, ImageLocation imageLocation2, ImageLocation imageLocation3, String str, String str2, String str3, String str4, Object obj, MenuItem[] menuItemArr, InfoLoadTask<?, ?> infoLoadTask) {
            this.imageLocation = imageLocation;
            this.thumbImageLocation = imageLocation2;
            this.videoLocation = imageLocation3;
            this.imageFilter = str;
            this.thumbImageFilter = str2;
            this.videoFilter = str3;
            this.videoFileName = str4;
            this.parentObject = obj;
            this.menuItems = menuItemArr;
            this.infoLoadTask = infoLoadTask;
        }
    }

    private static class UserInfoLoadTask extends InfoLoadTask<TLRPC$User, TLRPC$UserFull> {
        public UserInfoLoadTask(TLRPC$User tLRPC$User, int i) {
            super(tLRPC$User, i, NotificationCenter.userInfoDidLoad);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.rbmain.ui.AvatarPreviewer.InfoLoadTask
        protected void load() {
            MessagesController.getInstance(UserConfig.selectedAccount).loadUserInfo((TLRPC$User) this.argument, false, this.classGuid);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.rbmain.ui.AvatarPreviewer.InfoLoadTask
        protected void onReceiveNotification(Object... objArr) {
            if (((Integer) objArr[0]).intValue() == ((TLRPC$User) this.argument).id) {
                onResult((TLRPC$UserFull) objArr[1]);
            }
        }
    }

    private static class ChatInfoLoadTask extends InfoLoadTask<TLRPC$Chat, TLRPC$ChatFull> {
        public ChatInfoLoadTask(TLRPC$Chat tLRPC$Chat, int i) {
            super(tLRPC$Chat, i, NotificationCenter.chatInfoDidLoad);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.rbmain.ui.AvatarPreviewer.InfoLoadTask
        protected void load() {
            MessagesController.getInstance(UserConfig.selectedAccount).loadFullChat(((TLRPC$Chat) this.argument).id, this.classGuid, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.rbmain.ui.AvatarPreviewer.InfoLoadTask
        protected void onReceiveNotification(Object... objArr) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull == null || tLRPC$ChatFull.id != ((TLRPC$Chat) this.argument).id) {
                return;
            }
            onResult(tLRPC$ChatFull);
        }
    }

    private static abstract class InfoLoadTask<A, B> {
        protected final A argument;
        protected final int classGuid;
        private boolean loading;
        private final int notificationId;
        private Consumer<B> onResult;
        private final NotificationCenter.NotificationCenterDelegate observer = new NotificationCenter.NotificationCenterDelegate() { // from class: org.rbmain.ui.AvatarPreviewer.InfoLoadTask.1
            @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
            public void didReceivedNotification(int i, int i2, Object... objArr) {
                if (InfoLoadTask.this.loading && i == InfoLoadTask.this.notificationId) {
                    InfoLoadTask.this.onReceiveNotification(objArr);
                }
            }
        };
        private final NotificationCenter notificationCenter = NotificationCenter.getInstance(UserConfig.selectedAccount);

        protected abstract void load();

        protected abstract void onReceiveNotification(Object... objArr);

        public InfoLoadTask(A a, int i, int i2) {
            this.argument = a;
            this.classGuid = i;
            this.notificationId = i2;
        }

        public final void load(Consumer<B> consumer) {
            if (this.loading) {
                return;
            }
            this.loading = true;
            this.onResult = consumer;
            this.notificationCenter.addObserver(this.observer, this.notificationId);
            load();
        }

        public final void cancel() {
            if (this.loading) {
                this.loading = false;
                this.notificationCenter.removeObserver(this.observer, this.notificationId);
            }
        }

        protected final void onResult(B b) {
            if (this.loading) {
                cancel();
                this.onResult.accept(b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class Layout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
        private final Drawable arrowDrawable;
        private final ColorDrawable backgroundDrawable;
        private final Callback callback;
        private float downY;
        private final ImageReceiver imageReceiver;
        private InfoLoadTask<?, ?> infoLoadTask;
        private WindowInsets insets;
        private final Interpolator interpolator;
        private long lastUpdateTime;
        private MenuItem[] menuItems;
        private ValueAnimator moveAnimator;
        private float moveProgress;
        private float progress;
        private ValueAnimator progressHideAnimator;
        private ValueAnimator progressShowAnimator;
        private final RadialProgress2 radialProgress;
        private final int radialProgressSize;
        private boolean recycled;
        private boolean showProgress;
        private boolean showing;
        private String videoFileName;
        private BottomSheet visibleSheet;

        protected abstract void onHide();

        public Layout(Context context, Callback callback) {
            super(context);
            this.radialProgressSize = AndroidUtilities.dp(64.0f);
            new Rect();
            this.interpolator = new AccelerateDecelerateInterpolator();
            this.backgroundDrawable = new ColorDrawable(1895825408);
            ImageReceiver imageReceiver = new ImageReceiver();
            this.imageReceiver = imageReceiver;
            this.downY = -1.0f;
            this.callback = callback;
            setWillNotDraw(false);
            setFitsSystemWindows(true);
            imageReceiver.setAspectFit(true);
            imageReceiver.setInvalidateAll(true);
            imageReceiver.setRoundRadius(AndroidUtilities.dp(6.0f));
            imageReceiver.setParentView(this);
            RadialProgress2 radialProgress2 = new RadialProgress2(this);
            this.radialProgress = radialProgress2;
            radialProgress2.setOverrideAlpha(0.0f);
            radialProgress2.setIcon(10, false, false);
            radialProgress2.setColors(1107296256, 1107296256, -1, -1);
            this.arrowDrawable = ContextCompat.getDrawable(context, R.drawable.preview_arrow);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.fileDidLoad);
            NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.FileLoadProgressChanged);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.fileDidLoad);
            NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.FileLoadProgressChanged);
        }

        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int i, int i2, Object... objArr) {
            if (!this.showProgress || TextUtils.isEmpty(this.videoFileName)) {
                return;
            }
            if (i == NotificationCenter.fileDidLoad) {
                if (TextUtils.equals((String) objArr[0], this.videoFileName)) {
                    this.radialProgress.setProgress(1.0f, true);
                }
            } else if (i == NotificationCenter.FileLoadProgressChanged && TextUtils.equals((String) objArr[0], this.videoFileName) && this.radialProgress != null) {
                this.radialProgress.setProgress(Math.min(1.0f, ((Long) objArr[1]).longValue() / ((Long) objArr[2]).longValue()), true);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!this.showing) {
                return false;
            }
            if (this.moveAnimator == null) {
                if (motionEvent.getActionMasked() == 1) {
                    this.downY = -1.0f;
                    setShowing(false);
                } else if (motionEvent.getActionMasked() == 2) {
                    if (this.downY < 0.0f) {
                        this.downY = motionEvent.getY();
                    } else {
                        float fMax = Math.max(-1.0f, Math.min(0.0f, (motionEvent.getY() - this.downY) / AndroidUtilities.dp(56.0f)));
                        this.moveProgress = fMax;
                        if (fMax == -1.0f) {
                            performHapticFeedback(0);
                            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.moveProgress, 0.0f);
                            this.moveAnimator = valueAnimatorOfFloat;
                            valueAnimatorOfFloat.setDuration(200L);
                            this.moveAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.AvatarPreviewer$Layout$$ExternalSyntheticLambda1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    this.f$0.lambda$onTouchEvent$0(valueAnimator);
                                }
                            });
                            this.moveAnimator.start();
                            showBottomSheet();
                        }
                        invalidate();
                    }
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTouchEvent$0(ValueAnimator valueAnimator) {
            this.moveProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidate();
        }

        private void showBottomSheet() {
            MenuItem[] menuItemArr = this.menuItems;
            CharSequence[] charSequenceArr = new CharSequence[menuItemArr.length];
            int[] iArr = new int[menuItemArr.length];
            int i = 0;
            while (true) {
                MenuItem[] menuItemArr2 = this.menuItems;
                if (i < menuItemArr2.length) {
                    charSequenceArr[i] = LocaleController.getString(menuItemArr2[i].labelKey, this.menuItems[i].labelResId);
                    iArr[i] = this.menuItems[i].iconResId;
                    i++;
                } else {
                    BottomSheet dimBehind = new BottomSheet.Builder(getContext()).setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.AvatarPreviewer$Layout$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$showBottomSheet$1(dialogInterface, i2);
                        }
                    }).setDimBehind(false);
                    this.visibleSheet = dimBehind;
                    dimBehind.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.AvatarPreviewer$Layout$$ExternalSyntheticLambda4
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$showBottomSheet$2(dialogInterface);
                        }
                    });
                    this.visibleSheet.show();
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showBottomSheet$1(DialogInterface dialogInterface, int i) {
            this.callback.onMenuClick(this.menuItems[i]);
            setShowing(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showBottomSheet$2(DialogInterface dialogInterface) {
            this.visibleSheet = null;
            setShowing(false);
        }

        @Override // android.view.View
        public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
            this.insets = windowInsets;
            invalidateSize();
            return windowInsets.consumeStableInsets();
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            invalidateSize();
        }

        public void invalidateSize() {
            int iMax;
            int stableInsetRight;
            int width = getWidth();
            int height = getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            this.backgroundDrawable.setBounds(0, 0, width, height);
            int iDp = AndroidUtilities.dp(8.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                int stableInsetLeft = this.insets.getStableInsetLeft() + iDp;
                stableInsetRight = this.insets.getStableInsetRight() + iDp;
                iMax = iDp + Math.max(this.insets.getStableInsetTop(), this.insets.getStableInsetBottom());
                iDp = stableInsetLeft;
            } else {
                iMax = iDp;
                stableInsetRight = iMax;
            }
            int intrinsicWidth = this.arrowDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.arrowDrawable.getIntrinsicHeight();
            int iDp2 = AndroidUtilities.dp(24.0f);
            int i = width - (stableInsetRight + iDp);
            int i2 = height - (iMax * 2);
            int iMin = Math.min(i, i2);
            int i3 = intrinsicHeight / 2;
            int i4 = ((i - iMin) / 2) + iDp;
            int i5 = ((i2 - iMin) / 2) + iMax + (i > i2 ? iDp2 + i3 : 0);
            this.imageReceiver.setImageCoords(i4, i5, iMin, iMin - (i > i2 ? r9 : 0));
            int centerX = (int) this.imageReceiver.getCenterX();
            int centerY = (int) this.imageReceiver.getCenterY();
            RadialProgress2 radialProgress2 = this.radialProgress;
            int i6 = this.radialProgressSize;
            radialProgress2.setProgressRect(centerX - (i6 / 2), centerY - (i6 / 2), centerX + (i6 / 2), centerY + (i6 / 2));
            int i7 = i4 + (iMin / 2);
            int i8 = i5 - iDp2;
            int i9 = intrinsicWidth / 2;
            this.arrowDrawable.setBounds(i7 - i9, i8 - i3, i7 + i9, i8 + i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r10) {
            /*
                Method dump skipped, instructions count: 464
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.AvatarPreviewer.Layout.onDraw(android.graphics.Canvas):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDraw$3(ValueAnimator valueAnimator) {
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDraw$4(ValueAnimator valueAnimator) {
            invalidate();
        }

        public void setData(final Data data) {
            this.menuItems = data.menuItems;
            this.showProgress = data.videoLocation != null;
            this.videoFileName = data.videoFileName;
            recycleInfoLoadTask();
            if (data.infoLoadTask != null) {
                InfoLoadTask<?, ?> infoLoadTask = data.infoLoadTask;
                this.infoLoadTask = infoLoadTask;
                infoLoadTask.load(new Consumer() { // from class: org.rbmain.ui.AvatarPreviewer$Layout$$ExternalSyntheticLambda5
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        this.f$0.lambda$setData$5(data, obj);
                    }
                });
            }
            this.imageReceiver.setCurrentAccount(UserConfig.selectedAccount);
            this.imageReceiver.setImage(data.videoLocation, data.videoFilter, data.imageLocation, data.imageFilter, data.thumbImageLocation, data.thumbImageFilter, null, 0L, null, data.parentObject, 1);
            setShowing(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void lambda$setData$5(Data data, Object obj) {
            if (this.recycled) {
                return;
            }
            if (obj instanceof TLRPC$UserFull) {
                setData(Data.of((TLRPC$UserFull) obj, data.menuItems));
            } else if (obj instanceof TLRPC$ChatFull) {
                setData(Data.of((TLRPC$Chat) data.infoLoadTask.argument, (TLRPC$ChatFull) obj, data.menuItems));
            }
        }

        private void setShowing(boolean z) {
            if (this.showing != z) {
                this.showing = z;
                this.lastUpdateTime = AnimationUtils.currentAnimationTimeMillis();
                invalidate();
            }
        }

        public void recycle() {
            this.recycled = true;
            ValueAnimator valueAnimator = this.moveAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            BottomSheet bottomSheet = this.visibleSheet;
            if (bottomSheet != null) {
                bottomSheet.cancel();
            }
            recycleInfoLoadTask();
        }

        private void recycleInfoLoadTask() {
            InfoLoadTask<?, ?> infoLoadTask = this.infoLoadTask;
            if (infoLoadTask != null) {
                infoLoadTask.cancel();
                this.infoLoadTask = null;
            }
        }
    }
}
