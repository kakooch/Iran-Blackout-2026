package ir.eitaa.ui;

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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.Components.RadialProgress2;

/* loaded from: classes3.dex */
public class AvatarPreviewer {
    private static AvatarPreviewer INSTANCE;
    private Callback callback;
    private Context context;
    private Layout layout;
    private ViewGroup view;
    private boolean visible;
    private WindowManager windowManager;

    public interface Callback {
        void onMenuClick(MenuItem item);
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

    public void show(ViewGroup parentContainer, Data data, Callback callback) {
        Preconditions.checkNotNull(parentContainer);
        Preconditions.checkNotNull(data);
        Preconditions.checkNotNull(callback);
        Context context = parentContainer.getContext();
        if (this.view != parentContainer) {
            close();
            this.view = parentContainer;
            this.context = context;
            this.windowManager = (WindowManager) ContextCompat.getSystemService(context, WindowManager.class);
            this.layout = new Layout(context, callback) { // from class: ir.eitaa.ui.AvatarPreviewer.1
                @Override // ir.eitaa.ui.AvatarPreviewer.Layout
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
        parentContainer.requestDisallowInterceptTouchEvent(true);
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
            this.context = null;
            this.windowManager = null;
            this.callback = null;
        }
    }

    public void onTouchEvent(MotionEvent event) {
        Layout layout = this.layout;
        if (layout != null) {
            layout.onTouchEvent(event);
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

        MenuItem(String labelKey, int labelResId, int iconResId) {
            this.labelKey = labelKey;
            this.labelResId = labelResId;
            this.iconResId = iconResId;
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

        public static Data of(TLRPC$User user, int classGuid, MenuItem... menuItems) {
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(user, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(user, 1);
            return new Data(forUserOrChat, forUserOrChat2, null, null, (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b", null, null, user, menuItems, new UserInfoLoadTask(user, classGuid));
        }

        public static Data of(TLRPC$UserFull userFull, MenuItem... menuItems) {
            ImageLocation imageLocation;
            String attachFileName;
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(userFull.user, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(userFull.user, 1);
            String str = null;
            String str2 = (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b";
            TLRPC$Photo tLRPC$Photo = userFull.profile_photo;
            if (tLRPC$Photo == null || tLRPC$Photo.video_sizes.isEmpty()) {
                imageLocation = null;
                attachFileName = null;
            } else {
                TLRPC$VideoSize tLRPC$VideoSize = userFull.profile_photo.video_sizes.get(0);
                ImageLocation forPhoto = ImageLocation.getForPhoto(tLRPC$VideoSize, userFull.profile_photo);
                attachFileName = FileLoader.getAttachFileName(tLRPC$VideoSize);
                imageLocation = forPhoto;
            }
            if (imageLocation != null && imageLocation.imageType == 2) {
                str = ImageLoader.AUTOPLAY_FILTER;
            }
            return new Data(forUserOrChat, forUserOrChat2, imageLocation, null, str2, str, attachFileName, userFull.user, menuItems, null);
        }

        public static Data of(TLRPC$Chat chat, int classGuid, MenuItem... menuItems) {
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(chat, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(chat, 1);
            return new Data(forUserOrChat, forUserOrChat2, null, null, (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b", null, null, chat, menuItems, new ChatInfoLoadTask(chat, classGuid));
        }

        public static Data of(TLRPC$Chat chat, TLRPC$ChatFull chatFull, MenuItem... menuItems) {
            ImageLocation forPhoto;
            String attachFileName;
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(chat, 0);
            ImageLocation forUserOrChat2 = ImageLocation.getForUserOrChat(chat, 1);
            String str = (forUserOrChat2 == null || !(forUserOrChat2.photoSize instanceof TLRPC$TL_photoStrippedSize)) ? null : "b";
            TLRPC$Photo tLRPC$Photo = chatFull.chat_photo;
            if (tLRPC$Photo == null || tLRPC$Photo.video_sizes.isEmpty()) {
                forPhoto = null;
                attachFileName = null;
            } else {
                TLRPC$VideoSize tLRPC$VideoSize = chatFull.chat_photo.video_sizes.get(0);
                forPhoto = ImageLocation.getForPhoto(tLRPC$VideoSize, chatFull.chat_photo);
                attachFileName = FileLoader.getAttachFileName(tLRPC$VideoSize);
            }
            return new Data(forUserOrChat, forUserOrChat2, forPhoto, null, str, (forPhoto == null || forPhoto.imageType != 2) ? null : ImageLoader.AUTOPLAY_FILTER, attachFileName, chat, menuItems, null);
        }

        private Data(ImageLocation imageLocation, ImageLocation thumbImageLocation, ImageLocation videoLocation, String imageFilter, String thumbImageFilter, String videoFilter, String videoFileName, Object parentObject, MenuItem[] menuItems, InfoLoadTask<?, ?> infoLoadTask) {
            this.imageLocation = imageLocation;
            this.thumbImageLocation = thumbImageLocation;
            this.videoLocation = videoLocation;
            this.imageFilter = imageFilter;
            this.thumbImageFilter = thumbImageFilter;
            this.videoFilter = videoFilter;
            this.videoFileName = videoFileName;
            this.parentObject = parentObject;
            this.menuItems = menuItems;
            this.infoLoadTask = infoLoadTask;
        }
    }

    private static class UserInfoLoadTask extends InfoLoadTask<TLRPC$User, TLRPC$UserFull> {
        public UserInfoLoadTask(TLRPC$User argument, int classGuid) {
            super(argument, classGuid, NotificationCenter.userInfoDidLoad);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.eitaa.ui.AvatarPreviewer.InfoLoadTask
        protected void load() {
            MessagesController.getInstance(UserConfig.selectedAccount).loadUserInfo((TLRPC$User) this.argument, false, this.classGuid);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.eitaa.ui.AvatarPreviewer.InfoLoadTask
        protected void onReceiveNotification(Object... args) {
            if (((Long) args[0]).longValue() == ((TLRPC$User) this.argument).id) {
                onResult((TLRPC$UserFull) args[1]);
            }
        }
    }

    private static class ChatInfoLoadTask extends InfoLoadTask<TLRPC$Chat, TLRPC$ChatFull> {
        public ChatInfoLoadTask(TLRPC$Chat argument, int classGuid) {
            super(argument, classGuid, NotificationCenter.chatInfoDidLoad);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.eitaa.ui.AvatarPreviewer.InfoLoadTask
        protected void load() {
            MessagesController.getInstance(UserConfig.selectedAccount).loadFullChat(((TLRPC$Chat) this.argument).id, this.classGuid, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.eitaa.ui.AvatarPreviewer.InfoLoadTask
        protected void onReceiveNotification(Object... args) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
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
        private final NotificationCenter.NotificationCenterDelegate observer = new NotificationCenter.NotificationCenterDelegate() { // from class: ir.eitaa.ui.AvatarPreviewer.InfoLoadTask.1
            @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
            public void didReceivedNotification(int id, int account, Object... args) {
                if (InfoLoadTask.this.loading && id == InfoLoadTask.this.notificationId) {
                    InfoLoadTask.this.onReceiveNotification(args);
                }
            }
        };
        private final NotificationCenter notificationCenter = NotificationCenter.getInstance(UserConfig.selectedAccount);

        protected abstract void load();

        protected abstract void onReceiveNotification(Object... args);

        public InfoLoadTask(A argument, int classGuid, int notificationId) {
            this.argument = argument;
            this.classGuid = classGuid;
            this.notificationId = notificationId;
        }

        public final void load(Consumer<B> onResult) {
            if (this.loading) {
                return;
            }
            this.loading = true;
            this.onResult = onResult;
            this.notificationCenter.addObserver(this.observer, this.notificationId);
            load();
        }

        public final void cancel() {
            if (this.loading) {
                this.loading = false;
                this.notificationCenter.removeObserver(this.observer, this.notificationId);
            }
        }

        protected final void onResult(B result) {
            if (this.loading) {
                cancel();
                this.onResult.accept(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class Layout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
        private final Drawable arrowDrawable;
        private final ColorDrawable backgroundDrawable;
        private final Callback callback;
        private final int[] coords;
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
        private final Rect rect;
        private boolean recycled;
        private boolean showProgress;
        private boolean showing;
        private String videoFileName;
        private BottomSheet visibleSheet;

        protected abstract void onHide();

        public Layout(Context context, Callback callback) {
            super(context);
            this.radialProgressSize = AndroidUtilities.dp(64.0f);
            this.coords = new int[2];
            this.rect = new Rect();
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
            NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.fileLoadProgressChanged);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            if (!this.showProgress || TextUtils.isEmpty(this.videoFileName)) {
                return;
            }
            if (id == NotificationCenter.fileLoaded) {
                if (TextUtils.equals((String) args[0], this.videoFileName)) {
                    this.radialProgress.setProgress(1.0f, true);
                }
            } else if (id == NotificationCenter.fileLoadProgressChanged && TextUtils.equals((String) args[0], this.videoFileName) && this.radialProgress != null) {
                this.radialProgress.setProgress(Math.min(1.0f, ((Long) args[1]).longValue() / ((Long) args[2]).longValue()), true);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (!this.showing) {
                return false;
            }
            if (this.moveAnimator == null) {
                if (event.getActionMasked() == 1) {
                    this.downY = -1.0f;
                    setShowing(false);
                } else if (event.getActionMasked() == 2) {
                    if (this.downY < 0.0f) {
                        this.downY = event.getY();
                    } else {
                        float fMax = Math.max(-1.0f, Math.min(0.0f, (event.getY() - this.downY) / AndroidUtilities.dp(56.0f)));
                        this.moveProgress = fMax;
                        if (fMax == -1.0f) {
                            performHapticFeedback(0);
                            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.moveProgress, 0.0f);
                            this.moveAnimator = valueAnimatorOfFloat;
                            valueAnimatorOfFloat.setDuration(200L);
                            this.moveAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$AvatarPreviewer$Layout$-j9AiT8i8hBmeA39LJSRWaf9qoE
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    this.f$0.lambda$onTouchEvent$0$AvatarPreviewer$Layout(valueAnimator);
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
        /* renamed from: lambda$onTouchEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTouchEvent$0$AvatarPreviewer$Layout(ValueAnimator valueAnimator) {
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
                    BottomSheet dimBehind = new BottomSheet.Builder(getContext()).setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$AvatarPreviewer$Layout$vapds_T4ZVw6BjlyERQJ2d_BeS0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$showBottomSheet$1$AvatarPreviewer$Layout(dialogInterface, i2);
                        }
                    }).setDimBehind(false);
                    this.visibleSheet = dimBehind;
                    dimBehind.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$AvatarPreviewer$Layout$2G_CLaLtE8QoP5Vm3oQq43RwD74
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$showBottomSheet$2$AvatarPreviewer$Layout(dialogInterface);
                        }
                    });
                    this.visibleSheet.show();
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showBottomSheet$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showBottomSheet$1$AvatarPreviewer$Layout(DialogInterface dialogInterface, int i) {
            this.callback.onMenuClick(this.menuItems[i]);
            setShowing(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showBottomSheet$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showBottomSheet$2$AvatarPreviewer$Layout(DialogInterface dialogInterface) {
            this.visibleSheet = null;
            setShowing(false);
        }

        @Override // android.view.View
        public WindowInsets onApplyWindowInsets(WindowInsets insets) {
            this.insets = insets;
            invalidateSize();
            return insets.consumeStableInsets();
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
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
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.AvatarPreviewer.Layout.onDraw(android.graphics.Canvas):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDraw$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDraw$3$AvatarPreviewer$Layout(ValueAnimator valueAnimator) {
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDraw$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDraw$4$AvatarPreviewer$Layout(ValueAnimator valueAnimator) {
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
                infoLoadTask.load(new Consumer() { // from class: ir.eitaa.ui.-$$Lambda$AvatarPreviewer$Layout$duAwSXQTsA-uitQ7aPvlMeMqxdg
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        this.f$0.lambda$setData$5$AvatarPreviewer$Layout(data, obj);
                    }
                });
            }
            this.imageReceiver.setCurrentAccount(UserConfig.selectedAccount);
            this.imageReceiver.setImage(data.videoLocation, data.videoFilter, data.imageLocation, data.imageFilter, data.thumbImageLocation, data.thumbImageFilter, null, 0, null, data.parentObject, 1);
            setShowing(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: lambda$setData$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setData$5$AvatarPreviewer$Layout(Data data, Object obj) {
            if (this.recycled) {
                return;
            }
            if (obj instanceof TLRPC$UserFull) {
                setData(Data.of((TLRPC$UserFull) obj, data.menuItems));
            } else if (obj instanceof TLRPC$ChatFull) {
                setData(Data.of((TLRPC$Chat) data.infoLoadTask.argument, (TLRPC$ChatFull) obj, data.menuItems));
            }
        }

        private void setShowing(boolean showing) {
            if (this.showing != showing) {
                this.showing = showing;
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
