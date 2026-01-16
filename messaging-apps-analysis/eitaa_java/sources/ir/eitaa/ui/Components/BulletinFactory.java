package ir.eitaa.ui.Components;

import android.content.Context;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.Bulletin;

/* loaded from: classes3.dex */
public final class BulletinFactory {
    private final FrameLayout containerLayout;
    private final BaseFragment fragment;
    private final Theme.ResourcesProvider resourcesProvider;

    public static BulletinFactory of(BaseFragment fragment) {
        return new BulletinFactory(fragment);
    }

    public static BulletinFactory of(FrameLayout containerLayout, Theme.ResourcesProvider resourcesProvider) {
        return new BulletinFactory(containerLayout, resourcesProvider);
    }

    public static boolean canShowBulletin(BaseFragment fragment) {
        return (fragment == null || fragment.getParentActivity() == null || fragment.getLayoutContainer() == null) ? false : true;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PHOTO' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class FileType {
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType AUDIO;
        public static final FileType AUDIOS;
        public static final FileType GIF;
        public static final FileType MEDIA;
        public static final FileType PHOTO;
        public static final FileType PHOTOS;
        public static final FileType PHOTO_TO_DOWNLOADS;
        public static final FileType UNKNOWN;
        public static final FileType UNKNOWNS;
        public static final FileType VIDEO;
        public static final FileType VIDEOS;
        public static final FileType VIDEO_TO_DOWNLOADS;
        private final Icon icon;
        private final String localeKey;
        private final int localeRes;
        private final boolean plural;

        public static FileType valueOf(String name) {
            return (FileType) Enum.valueOf(FileType.class, name);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }

        static {
            Icon icon = Icon.SAVED_TO_GALLERY;
            FileType fileType = new FileType("PHOTO", 0, "PhotoSavedHint", R.string.PhotoSavedHint, icon);
            PHOTO = fileType;
            FileType fileType2 = new FileType("PHOTOS", 1, "PhotosSavedHint", icon);
            PHOTOS = fileType2;
            FileType fileType3 = new FileType("VIDEO", 2, "VideoSavedHint", R.string.VideoSavedHint, icon);
            VIDEO = fileType3;
            FileType fileType4 = new FileType("VIDEOS", 3, "VideosSavedHint", icon);
            VIDEOS = fileType4;
            FileType fileType5 = new FileType("MEDIA", 4, "MediaSavedHint", icon);
            MEDIA = fileType5;
            Icon icon2 = Icon.SAVED_TO_DOWNLOADS;
            FileType fileType6 = new FileType("PHOTO_TO_DOWNLOADS", 5, "PhotoSavedToDownloadsHint", R.string.PhotoSavedToDownloadsHint, icon2);
            PHOTO_TO_DOWNLOADS = fileType6;
            FileType fileType7 = new FileType("VIDEO_TO_DOWNLOADS", 6, "VideoSavedToDownloadsHint", R.string.VideoSavedToDownloadsHint, icon2);
            VIDEO_TO_DOWNLOADS = fileType7;
            FileType fileType8 = new FileType("GIF", 7, "GifSavedToDownloadsHint", icon2);
            GIF = fileType8;
            Icon icon3 = Icon.SAVED_TO_MUSIC;
            FileType fileType9 = new FileType("AUDIO", 8, "AudioSavedHint", R.string.AudioSavedHint, icon3);
            AUDIO = fileType9;
            FileType fileType10 = new FileType("AUDIOS", 9, "AudiosSavedHint", icon3);
            AUDIOS = fileType10;
            FileType fileType11 = new FileType("UNKNOWN", 10, "FileSavedHint", R.string.FileSavedHint, icon2);
            UNKNOWN = fileType11;
            FileType fileType12 = new FileType("UNKNOWNS", 11, "FilesSavedHint", icon2);
            UNKNOWNS = fileType12;
            $VALUES = new FileType[]{fileType, fileType2, fileType3, fileType4, fileType5, fileType6, fileType7, fileType8, fileType9, fileType10, fileType11, fileType12};
        }

        private FileType(String $enum$name, int $enum$ordinal, String localeKey, int localeRes, Icon icon) {
            this.localeKey = localeKey;
            this.localeRes = localeRes;
            this.icon = icon;
            this.plural = false;
        }

        private FileType(String $enum$name, int $enum$ordinal, String localeKey, Icon icon) {
            this.localeKey = localeKey;
            this.icon = icon;
            this.localeRes = 0;
            this.plural = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getText(int amount) {
            if (this.plural) {
                return LocaleController.formatPluralString(this.localeKey, amount);
            }
            return LocaleController.getString(this.localeKey, this.localeRes);
        }

        private enum Icon {
            SAVED_TO_DOWNLOADS(R.raw.ic_download, 2, "Box", "Arrow"),
            SAVED_TO_GALLERY(R.raw.ic_save_to_gallery, 0, "Box", "Arrow", "Mask", "Arrow 2", "Splash"),
            SAVED_TO_MUSIC(R.raw.ic_save_to_music, 2, "Box", "Arrow");

            private final String[] layers;
            private final int paddingBottom;
            private final int resId;

            Icon(int resId, int paddingBottom, String... layers) {
                this.resId = resId;
                this.paddingBottom = paddingBottom;
                this.layers = layers;
            }
        }
    }

    private BulletinFactory(BaseFragment fragment) {
        this.fragment = fragment;
        this.containerLayout = null;
        this.resourcesProvider = fragment != null ? fragment.getResourceProvider() : null;
    }

    private BulletinFactory(FrameLayout containerLayout, Theme.ResourcesProvider resourcesProvider) {
        this.containerLayout = containerLayout;
        this.fragment = null;
        this.resourcesProvider = resourcesProvider;
    }

    public Bulletin createSimpleBulletin(int iconRawId, String text) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), this.resourcesProvider);
        lottieLayout.setAnimation(iconRawId, 36, 36, new String[0]);
        lottieLayout.textView.setText(text);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(2);
        return create(lottieLayout, 1500);
    }

    public Bulletin createDownloadBulletin(FileType fileType) {
        return createDownloadBulletin(fileType, this.resourcesProvider);
    }

    public Bulletin createDownloadBulletin(FileType fileType, Theme.ResourcesProvider resourcesProvider) {
        return createDownloadBulletin(fileType, 1, resourcesProvider);
    }

    public Bulletin createDownloadBulletin(FileType fileType, int filesAmount, Theme.ResourcesProvider resourcesProvider) {
        return createDownloadBulletin(fileType, filesAmount, 0, 0, resourcesProvider);
    }

    public Bulletin createReportSent(Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider);
        lottieLayout.setAnimation(R.raw.chats_infotip, new String[0]);
        lottieLayout.textView.setText(LocaleController.getString("ReportChatSent", R.string.ReportChatSent));
        return create(lottieLayout, 1500);
    }

    public Bulletin createDownloadBulletin(FileType fileType, int filesAmount, int backgroundColor, int textColor) {
        return createDownloadBulletin(fileType, filesAmount, backgroundColor, textColor, null);
    }

    public Bulletin createDownloadBulletin(FileType fileType, int filesAmount, int backgroundColor, int textColor, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout;
        if (backgroundColor != 0 && textColor != 0) {
            lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider, backgroundColor, textColor);
        } else {
            lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider);
        }
        lottieLayout.setAnimation(fileType.icon.resId, fileType.icon.layers);
        lottieLayout.textView.setText(fileType.getText(filesAmount));
        if (fileType.icon.paddingBottom != 0) {
            lottieLayout.setIconPaddingBottom(fileType.icon.paddingBottom);
        }
        return create(lottieLayout, 1500);
    }

    public Bulletin createErrorBulletin(CharSequence errorMessage) {
        return createErrorBulletin(errorMessage, null);
    }

    public Bulletin createErrorBulletin(CharSequence errorMessage, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider);
        lottieLayout.setAnimation(R.raw.chats_infotip, new String[0]);
        lottieLayout.textView.setText(errorMessage);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(2);
        return create(lottieLayout, 1500);
    }

    public Bulletin createCopyLinkBulletin() {
        return createCopyLinkBulletin(false, this.resourcesProvider);
    }

    public Bulletin createCopyBulletin(String message) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), null);
        lottieLayout.setAnimation(R.raw.copy, 36, 36, "NULL ROTATION", "Back", "Front");
        lottieLayout.textView.setText(message);
        return create(lottieLayout, 1500);
    }

    public Bulletin createCopyLinkBulletin(boolean isPrivate, Theme.ResourcesProvider resourcesProvider) {
        if (isPrivate) {
            Bulletin.TwoLineLottieLayout twoLineLottieLayout = new Bulletin.TwoLineLottieLayout(getContext(), resourcesProvider);
            twoLineLottieLayout.setAnimation(R.raw.voip_invite, 36, 36, "Wibe", "Circle");
            twoLineLottieLayout.titleTextView.setText(LocaleController.getString("LinkCopied", R.string.LinkCopied));
            twoLineLottieLayout.subtitleTextView.setText(LocaleController.getString("LinkCopiedPrivateInfo", R.string.LinkCopiedPrivateInfo));
            return create(twoLineLottieLayout, 2750);
        }
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider);
        lottieLayout.setAnimation(R.raw.voip_invite, 36, 36, "Wibe", "Circle");
        lottieLayout.textView.setText(LocaleController.getString("LinkCopied", R.string.LinkCopied));
        return create(lottieLayout, 1500);
    }

    private Bulletin create(Bulletin.Layout layout, int duration) {
        BaseFragment baseFragment = this.fragment;
        if (baseFragment != null) {
            return Bulletin.make(baseFragment, layout, duration);
        }
        return Bulletin.make(this.containerLayout, layout, duration);
    }

    private Context getContext() {
        BaseFragment baseFragment = this.fragment;
        return baseFragment != null ? baseFragment.getParentActivity() : this.containerLayout.getContext();
    }

    public static Bulletin createMuteBulletin(BaseFragment fragment, int setting) {
        return createMuteBulletin(fragment, setting, (Theme.ResourcesProvider) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.eitaa.ui.Components.Bulletin createMuteBulletin(ir.eitaa.ui.ActionBar.BaseFragment r9, int r10, ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r11) {
        /*
            ir.eitaa.ui.Components.Bulletin$LottieLayout r0 = new ir.eitaa.ui.Components.Bulletin$LottieLayout
            android.app.Activity r1 = r9.getParentActivity()
            r0.<init>(r1, r11)
            java.lang.String r11 = "Hours"
            r1 = 2131692824(0x7f0f0d18, float:1.901476E38)
            java.lang.String r2 = "NotificationsMutedForHint"
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r10 == 0) goto L58
            if (r10 == r7) goto L49
            if (r10 == r5) goto L3a
            if (r10 == r4) goto L30
            if (r10 != r3) goto L2a
            r10 = 2131692852(0x7f0f0d34, float:1.9014816E38)
            java.lang.String r11 = "NotificationsUnmutedHint"
            java.lang.String r10 = ir.eitaa.messenger.LocaleController.getString(r11, r10)
            r11 = 0
            goto L65
        L2a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>()
            throw r9
        L30:
            r10 = 2131692825(0x7f0f0d19, float:1.9014761E38)
            java.lang.String r11 = "NotificationsMutedHint"
            java.lang.String r10 = ir.eitaa.messenger.LocaleController.getString(r11, r10)
            goto L64
        L3a:
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.String r11 = "Days"
            java.lang.String r11 = ir.eitaa.messenger.LocaleController.formatPluralString(r11, r5)
            r10[r6] = r11
            java.lang.String r10 = ir.eitaa.messenger.LocaleController.formatString(r2, r1, r10)
            goto L64
        L49:
            java.lang.Object[] r10 = new java.lang.Object[r7]
            r8 = 8
            java.lang.String r11 = ir.eitaa.messenger.LocaleController.formatPluralString(r11, r8)
            r10[r6] = r11
            java.lang.String r10 = ir.eitaa.messenger.LocaleController.formatString(r2, r1, r10)
            goto L64
        L58:
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.String r11 = ir.eitaa.messenger.LocaleController.formatPluralString(r11, r7)
            r10[r6] = r11
            java.lang.String r10 = ir.eitaa.messenger.LocaleController.formatString(r2, r1, r10)
        L64:
            r11 = 1
        L65:
            if (r11 == 0) goto L85
            r11 = 2131623987(0x7f0e0033, float:1.887514E38)
            r1 = 5
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = "Body Main"
            r1[r6] = r2
            java.lang.String r2 = "Body Top"
            r1[r7] = r2
            java.lang.String r2 = "Line"
            r1[r5] = r2
            java.lang.String r2 = "Curve Big"
            r1[r4] = r2
            java.lang.String r2 = "Curve Small"
            r1[r3] = r2
            r0.setAnimation(r11, r1)
            goto L9d
        L85:
            r11 = 2131623992(0x7f0e0038, float:1.8875151E38)
            java.lang.String[] r1 = new java.lang.String[r3]
            java.lang.String r2 = "BODY"
            r1[r6] = r2
            java.lang.String r2 = "Wibe Big"
            r1[r7] = r2
            java.lang.String r2 = "Wibe Big 3"
            r1[r5] = r2
            java.lang.String r2 = "Wibe Small"
            r1[r4] = r2
            r0.setAnimation(r11, r1)
        L9d:
            android.widget.TextView r11 = r0.textView
            r11.setText(r10)
            r10 = 1500(0x5dc, float:2.102E-42)
            ir.eitaa.ui.Components.Bulletin r9 = ir.eitaa.ui.Components.Bulletin.make(r9, r0, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.BulletinFactory.createMuteBulletin(ir.eitaa.ui.ActionBar.BaseFragment, int, ir.eitaa.ui.ActionBar.Theme$ResourcesProvider):ir.eitaa.ui.Components.Bulletin");
    }

    public static Bulletin createMuteBulletin(BaseFragment fragment, boolean muted, Theme.ResourcesProvider resourcesProvider) {
        return createMuteBulletin(fragment, muted ? 3 : 4, resourcesProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bulletin createUnpinAllMessagesBulletin(BaseFragment baseFragment, int i, boolean z, Runnable runnable, Runnable runnable2, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout;
        if (baseFragment.getParentActivity() == null) {
            if (runnable2 == null) {
                return null;
            }
            runnable2.run();
            return null;
        }
        if (z) {
            Bulletin.TwoLineLottieLayout twoLineLottieLayout = new Bulletin.TwoLineLottieLayout(baseFragment.getParentActivity(), resourcesProvider);
            twoLineLottieLayout.setAnimation(R.raw.ic_unpin, 28, 28, "Pin", "Line");
            twoLineLottieLayout.titleTextView.setText(LocaleController.getString("PinnedMessagesHidden", R.string.PinnedMessagesHidden));
            twoLineLottieLayout.subtitleTextView.setText(LocaleController.getString("PinnedMessagesHiddenInfo", R.string.PinnedMessagesHiddenInfo));
            lottieLayout = twoLineLottieLayout;
        } else {
            Bulletin.LottieLayout lottieLayout2 = new Bulletin.LottieLayout(baseFragment.getParentActivity(), resourcesProvider);
            lottieLayout2.setAnimation(R.raw.ic_unpin, 28, 28, "Pin", "Line");
            lottieLayout2.textView.setText(LocaleController.formatPluralString("MessagesUnpinned", i));
            lottieLayout = lottieLayout2;
        }
        lottieLayout.setButton(new Bulletin.UndoButton(baseFragment.getParentActivity(), true, resourcesProvider).setUndoAction(runnable).setDelayedAction(runnable2));
        return Bulletin.make(baseFragment, lottieLayout, 5000);
    }

    public static Bulletin createSaveToGalleryBulletin(BaseFragment fragment, boolean video, Theme.ResourcesProvider resourcesProvider) {
        return of(fragment).createDownloadBulletin(video ? FileType.VIDEO : FileType.PHOTO, resourcesProvider);
    }

    public static Bulletin createSaveToGalleryBulletin(FrameLayout containerLayout, boolean video, int backgroundColor, int textColor) {
        return of(containerLayout, null).createDownloadBulletin(video ? FileType.VIDEO : FileType.PHOTO, 1, backgroundColor, textColor);
    }

    public static Bulletin createPromoteToAdminBulletin(BaseFragment fragment, String userFirstName) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(fragment.getParentActivity(), null);
        lottieLayout.setAnimation(R.raw.ic_admin, "Shield");
        lottieLayout.textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("UserSetAsAdminHint", R.string.UserSetAsAdminHint, userFirstName)));
        return Bulletin.make(fragment, lottieLayout, 1500);
    }

    public static Bulletin createRemoveFromChatBulletin(BaseFragment fragment, TLRPC$User user, String chatName) {
        String string;
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(fragment.getParentActivity(), null);
        lottieLayout.setAnimation(R.raw.ic_ban, "Hand");
        if (user.deleted) {
            string = LocaleController.formatString("HiddenName", R.string.HiddenName, new Object[0]);
        } else {
            string = user.first_name;
        }
        lottieLayout.textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("UserRemovedFromChatHint", R.string.UserRemovedFromChatHint, string, chatName)));
        return Bulletin.make(fragment, lottieLayout, 1500);
    }

    public static Bulletin createBanBulletin(BaseFragment fragment, boolean banned) {
        String string;
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(fragment.getParentActivity(), null);
        if (banned) {
            lottieLayout.setAnimation(R.raw.ic_ban, "Hand");
            string = LocaleController.getString("UserBlocked", R.string.UserBlocked);
        } else {
            lottieLayout.setAnimation(R.raw.ic_unban, "Main", "Finger 1", "Finger 2", "Finger 3", "Finger 4");
            string = LocaleController.getString("UserUnblocked", R.string.UserUnblocked);
        }
        lottieLayout.textView.setText(AndroidUtilities.replaceTags(string));
        return Bulletin.make(fragment, lottieLayout, 1500);
    }

    public static Bulletin createCopyLinkBulletin(BaseFragment fragment) {
        return of(fragment).createCopyLinkBulletin();
    }

    public static Bulletin createCopyLinkBulletin(FrameLayout containerView) {
        return of(containerView, null).createCopyLinkBulletin();
    }

    public static Bulletin createPinMessageBulletin(BaseFragment fragment, Theme.ResourcesProvider resourcesProvider) {
        return createPinMessageBulletin(fragment, true, null, null, resourcesProvider);
    }

    public static Bulletin createUnpinMessageBulletin(BaseFragment fragment, Runnable undoAction, Runnable delayedAction, Theme.ResourcesProvider resourcesProvider) {
        return createPinMessageBulletin(fragment, false, undoAction, delayedAction, resourcesProvider);
    }

    private static Bulletin createPinMessageBulletin(BaseFragment fragment, boolean pinned, Runnable undoAction, Runnable delayedAction, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(fragment.getParentActivity(), resourcesProvider);
        lottieLayout.setAnimation(pinned ? R.raw.ic_pin : R.raw.ic_unpin, 28, 28, "Pin", "Line");
        lottieLayout.textView.setText(LocaleController.getString(pinned ? "MessagePinnedHint" : "MessageUnpinnedHint", pinned ? R.string.MessagePinnedHint : R.string.MessageUnpinnedHint));
        if (!pinned) {
            lottieLayout.setButton(new Bulletin.UndoButton(fragment.getParentActivity(), true, resourcesProvider).setUndoAction(undoAction).setDelayedAction(delayedAction));
        }
        return Bulletin.make(fragment, lottieLayout, pinned ? 1500 : 5000);
    }
}
