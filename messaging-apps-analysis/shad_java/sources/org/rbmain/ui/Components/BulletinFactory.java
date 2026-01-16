package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Bulletin;

/* loaded from: classes5.dex */
public final class BulletinFactory {
    private final FrameLayout containerLayout;
    private final BaseFragment fragment;
    private final Theme.ResourcesProvider resourcesProvider;

    public static BulletinFactory of(BaseFragment baseFragment) {
        return new BulletinFactory(baseFragment);
    }

    public static BulletinFactory of(FrameLayout frameLayout, Theme.ResourcesProvider resourcesProvider) {
        return new BulletinFactory(frameLayout, resourcesProvider);
    }

    public static boolean canShowBulletin(BaseFragment baseFragment) {
        return (baseFragment == null || baseFragment.getParentActivity() == null || baseFragment.getLayoutContainer() == null) ? false : true;
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
        public static final FileType GIF_TO_DOWNLOADS;
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

        public static FileType valueOf(String str) {
            return (FileType) Enum.valueOf(FileType.class, str);
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
            FileType fileType8 = new FileType("GIF", 7, "GifSavedHint", R.string.GifSavedHint, Icon.SAVED_TO_GIFS);
            GIF = fileType8;
            FileType fileType9 = new FileType("GIF_TO_DOWNLOADS", 8, "GifSavedToDownloadsHint", R.string.GifSavedToDownloadsHint, icon2);
            GIF_TO_DOWNLOADS = fileType9;
            Icon icon3 = Icon.SAVED_TO_MUSIC;
            FileType fileType10 = new FileType("AUDIO", 9, "AudioSavedHint", R.string.AudioSavedHint, icon3);
            AUDIO = fileType10;
            FileType fileType11 = new FileType("AUDIOS", 10, "AudiosSavedHint", icon3);
            AUDIOS = fileType11;
            FileType fileType12 = new FileType("UNKNOWN", 11, "FileSavedHint", R.string.FileSavedHint, icon2);
            UNKNOWN = fileType12;
            FileType fileType13 = new FileType("UNKNOWNS", 12, "FilesSavedHint", icon2);
            UNKNOWNS = fileType13;
            $VALUES = new FileType[]{fileType, fileType2, fileType3, fileType4, fileType5, fileType6, fileType7, fileType8, fileType9, fileType10, fileType11, fileType12, fileType13};
        }

        private FileType(String str, int i, String str2, int i2, Icon icon) {
            this.localeKey = str2;
            this.localeRes = i2;
            this.icon = icon;
            this.plural = false;
        }

        private FileType(String str, int i, String str2, Icon icon) {
            this.localeKey = str2;
            this.icon = icon;
            this.localeRes = 0;
            this.plural = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getText(int i) {
            if (this.plural) {
                return LocaleController.formatPluralString(this.localeKey, i);
            }
            return LocaleController.getString(this.localeKey, this.localeRes);
        }

        private enum Icon {
            SAVED_TO_DOWNLOADS(R.raw.ic_download, 2, "Box", "Arrow"),
            SAVED_TO_GALLERY(R.raw.ic_save_to_gallery, 0, "Box", "Arrow", "Mask", "Arrow 2", "Splash"),
            SAVED_TO_MUSIC(R.raw.ic_save_to_music, 2, "Box", "Arrow"),
            SAVED_TO_GIFS(R.raw.ic_save_to_gifs, 0, "gif");

            private final String[] layers;
            private final int paddingBottom;
            private final int resId;

            Icon(int i, int i2, String... strArr) {
                this.resId = i;
                this.paddingBottom = i2;
                this.layers = strArr;
            }
        }
    }

    private BulletinFactory(BaseFragment baseFragment) {
        this.fragment = baseFragment;
        this.containerLayout = null;
        this.resourcesProvider = baseFragment != null ? baseFragment.getResourceProvider() : null;
    }

    private BulletinFactory(FrameLayout frameLayout, Theme.ResourcesProvider resourcesProvider) {
        this.containerLayout = frameLayout;
        this.fragment = null;
        this.resourcesProvider = resourcesProvider;
    }

    public Bulletin createSimpleBulletin(int i, CharSequence charSequence) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), this.resourcesProvider);
        lottieLayout.setAnimation(i, 36, 36, new String[0]);
        lottieLayout.textView.setText(charSequence);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(2);
        return create(lottieLayout, charSequence.length() < 20 ? 1500 : 2750);
    }

    public Bulletin createSimpleBulletin(int i, CharSequence charSequence, int i2) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), this.resourcesProvider);
        lottieLayout.setAnimation(i, 36, 36, new String[0]);
        if (charSequence != null) {
            String string = charSequence.toString();
            SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(charSequence);
            int i3 = 0;
            for (int iIndexOf = string.indexOf(10); iIndexOf >= 0 && iIndexOf < charSequence.length(); iIndexOf = string.indexOf(10, iIndexOf + 1)) {
                if (i3 >= i2) {
                    spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) " ");
                }
                i3++;
            }
            charSequence = spannableStringBuilder;
        }
        lottieLayout.textView.setText(charSequence);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(i2);
        return create(lottieLayout, charSequence.length() < 20 ? 1500 : 2750);
    }

    public Bulletin createSimpleBulletin(int i, CharSequence charSequence, CharSequence charSequence2, int i2, Runnable runnable) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), this.resourcesProvider);
        lottieLayout.setAnimation(i, 36, 36, new String[0]);
        lottieLayout.textView.setTextSize(1, 14.0f);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(3);
        lottieLayout.textView.setText(charSequence);
        lottieLayout.setButton(new Bulletin.UndoButton(getContext(), true, this.resourcesProvider).setText(charSequence2).setUndoAction(runnable));
        return create(lottieLayout, i2);
    }

    public Bulletin createSimpleBulletin(Drawable drawable, CharSequence charSequence) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), this.resourcesProvider);
        lottieLayout.imageView.setImageDrawable(drawable);
        lottieLayout.textView.setText(charSequence);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(2);
        return create(lottieLayout, 2750);
    }

    public Bulletin createUsersBulletin(List<TLRPC$User> list, CharSequence charSequence, CharSequence charSequence2) {
        int i;
        Bulletin.UsersLayout usersLayout = new Bulletin.UsersLayout(getContext(), charSequence2 != null, this.resourcesProvider);
        if (list != null) {
            i = 0;
            for (int i2 = 0; i2 < list.size() && i < 3; i2++) {
                TLRPC$User tLRPC$User = list.get(i2);
                if (tLRPC$User != null) {
                    i++;
                    usersLayout.avatarsImageView.setCount(i);
                    usersLayout.avatarsImageView.setObject(i - 1, UserConfig.selectedAccount, tLRPC$User);
                }
            }
            if (list.size() == 1) {
                usersLayout.avatarsImageView.setTranslationX(AndroidUtilities.dp(4.0f));
                usersLayout.avatarsImageView.setScaleX(1.2f);
                usersLayout.avatarsImageView.setScaleY(1.2f);
            } else {
                usersLayout.avatarsImageView.setScaleX(1.0f);
                usersLayout.avatarsImageView.setScaleY(1.0f);
            }
        } else {
            i = 0;
        }
        usersLayout.avatarsImageView.commitTransition(false);
        if (charSequence2 != null) {
            usersLayout.textView.setSingleLine(true);
            usersLayout.textView.setMaxLines(1);
            usersLayout.textView.setText(charSequence);
            usersLayout.subtitleView.setText(charSequence2);
            usersLayout.subtitleView.setSingleLine(true);
            usersLayout.subtitleView.setMaxLines(1);
            if (usersLayout.linearLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                int iDp = AndroidUtilities.dp(70 - ((3 - i) * 12));
                if (LocaleController.isRTL) {
                    ((ViewGroup.MarginLayoutParams) usersLayout.linearLayout.getLayoutParams()).rightMargin = iDp;
                } else {
                    ((ViewGroup.MarginLayoutParams) usersLayout.linearLayout.getLayoutParams()).leftMargin = iDp;
                }
            }
        } else {
            usersLayout.textView.setSingleLine(false);
            usersLayout.textView.setMaxLines(2);
            usersLayout.textView.setText(charSequence);
            if (usersLayout.textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                int iDp2 = AndroidUtilities.dp(70 - ((3 - i) * 12));
                if (LocaleController.isRTL) {
                    ((ViewGroup.MarginLayoutParams) usersLayout.textView.getLayoutParams()).rightMargin = iDp2;
                } else {
                    ((ViewGroup.MarginLayoutParams) usersLayout.textView.getLayoutParams()).leftMargin = iDp2;
                }
            }
        }
        return create(usersLayout, 5000);
    }

    public Bulletin createEmojiBulletin(TLRPC$Document tLRPC$Document, CharSequence charSequence, CharSequence charSequence2, Runnable runnable) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), this.resourcesProvider);
        if (MessageObject.isTextColorEmoji(tLRPC$Document)) {
            lottieLayout.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_undo_infoColor), PorterDuff.Mode.SRC_IN));
        }
        lottieLayout.setAnimation(tLRPC$Document, 36, 36, new String[0]);
        if (lottieLayout.imageView.getImageReceiver() != null) {
            lottieLayout.imageView.getImageReceiver().setRoundRadius(AndroidUtilities.dp(4.0f));
        }
        lottieLayout.textView.setText(charSequence);
        lottieLayout.textView.setTextSize(1, 14.0f);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(3);
        lottieLayout.setButton(new Bulletin.UndoButton(getContext(), true, this.resourcesProvider).setText(charSequence2).setUndoAction(runnable));
        return create(lottieLayout, 2750);
    }

    public Bulletin createDownloadBulletin(FileType fileType) {
        return createDownloadBulletin(fileType, this.resourcesProvider);
    }

    public Bulletin createDownloadBulletin(FileType fileType, Theme.ResourcesProvider resourcesProvider) {
        return createDownloadBulletin(fileType, 1, resourcesProvider);
    }

    public Bulletin createDownloadBulletin(FileType fileType, int i, Theme.ResourcesProvider resourcesProvider) {
        return createDownloadBulletin(fileType, i, 0, 0, resourcesProvider);
    }

    public Bulletin createReportSent() {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext());
        lottieLayout.setAnimation(R.raw.chats_infotip, new String[0]);
        lottieLayout.textView.setText(LocaleController.getString("ReportChatSent", R.string.ReportChatSent));
        return create(lottieLayout, 1500);
    }

    public Bulletin createDownloadBulletin(FileType fileType, int i, int i2, int i3) {
        return createDownloadBulletin(fileType, i, i2, i3, null);
    }

    public Bulletin createDownloadBulletin(FileType fileType, int i, int i2, int i3, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout;
        if (i2 != 0 && i3 != 0) {
            lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider, i2, i3);
        } else {
            lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider);
        }
        lottieLayout.setAnimation(fileType.icon.resId, fileType.icon.layers);
        lottieLayout.textView.setText(fileType.getText(i));
        if (fileType.icon.paddingBottom != 0) {
            lottieLayout.setIconPaddingBottom(fileType.icon.paddingBottom);
        }
        return create(lottieLayout, 1500);
    }

    public Bulletin createErrorBulletin(CharSequence charSequence) {
        return createErrorBulletin(charSequence, null);
    }

    public Bulletin createErrorBulletin(CharSequence charSequence, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), resourcesProvider);
        lottieLayout.setAnimation(R.raw.chats_infotip, new String[0]);
        lottieLayout.textView.setText(charSequence);
        lottieLayout.textView.setSingleLine(false);
        lottieLayout.textView.setMaxLines(2);
        return create(lottieLayout, 1500);
    }

    public Bulletin createCopyLinkBulletin() {
        return createCopyLinkBulletin(false, this.resourcesProvider);
    }

    public Bulletin createCopyBulletin(String str) {
        return createCopyBulletin(str, null);
    }

    public Bulletin createCopyBulletin(String str, Theme.ResourcesProvider resourcesProvider) {
        if (!AndroidUtilities.shouldShowClipboardToast()) {
            return new Bulletin.EmptyBulletin();
        }
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext(), null);
        lottieLayout.setAnimation(R.raw.copy, 36, 36, "NULL ROTATION", "Back", "Front");
        lottieLayout.textView.setText(str);
        return create(lottieLayout, 1500);
    }

    public Bulletin createCopyLinkBulletin(boolean z, Theme.ResourcesProvider resourcesProvider) {
        if (!AndroidUtilities.shouldShowClipboardToast()) {
            return new Bulletin.EmptyBulletin();
        }
        if (z) {
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

    public Bulletin createCustomBulletin(String str, int i) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(getContext());
        lottieLayout.textView.setText(str);
        return create(lottieLayout, i);
    }

    public Bulletin createCustomBulletin(String str) {
        return createCustomBulletin(str, 2000);
    }

    private Bulletin create(Bulletin.Layout layout, int i) {
        BaseFragment baseFragment = this.fragment;
        if (baseFragment != null) {
            return Bulletin.make(baseFragment, layout, i);
        }
        return Bulletin.make(this.containerLayout, layout, i);
    }

    private Context getContext() {
        Context context;
        BaseFragment baseFragment = this.fragment;
        if (baseFragment != null) {
            context = baseFragment.getParentActivity();
            if (context == null && this.fragment.getLayoutContainer() != null) {
                context = this.fragment.getLayoutContainer().getContext();
            }
        } else {
            FrameLayout frameLayout = this.containerLayout;
            context = frameLayout != null ? frameLayout.getContext() : null;
        }
        return context == null ? ApplicationLoader.applicationContext : context;
    }

    public static Bulletin createMuteBulletin(BaseFragment baseFragment, int i) {
        return createMuteBulletin(baseFragment, i, 0, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.rbmain.ui.Components.Bulletin createMuteBulletin(org.rbmain.ui.ActionBar.BaseFragment r9, int r10, int r11, org.rbmain.ui.ActionBar.Theme.ResourcesProvider r12) {
        /*
            org.rbmain.ui.Components.Bulletin$LottieLayout r0 = new org.rbmain.ui.Components.Bulletin$LottieLayout
            android.app.Activity r1 = r9.getParentActivity()
            r0.<init>(r1, r12)
            java.lang.String r12 = "Hours"
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2131890073(0x7f120f99, float:1.9414828E38)
            java.lang.String r5 = "NotificationsMutedForHint"
            r6 = 2
            r7 = 0
            r8 = 1
            if (r10 == 0) goto L6a
            if (r10 == r8) goto L5b
            if (r10 == r6) goto L4c
            if (r10 == r3) goto L42
            if (r10 == r2) goto L36
            if (r10 != r1) goto L30
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r11 = org.rbmain.messenger.LocaleController.formatTTLString(r11)
            r10[r7] = r11
            java.lang.String r10 = org.rbmain.messenger.LocaleController.formatString(r5, r4, r10)
            r11 = 1
            goto L77
        L30:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>()
            throw r9
        L36:
            r10 = 2131890106(0x7f120fba, float:1.9414894E38)
            java.lang.String r11 = "NotificationsUnmutedHint"
            java.lang.String r10 = org.rbmain.messenger.LocaleController.getString(r11, r10)
            r11 = 0
            r12 = 0
            goto L78
        L42:
            r10 = 2131890074(0x7f120f9a, float:1.941483E38)
            java.lang.String r11 = "NotificationsMutedHint"
            java.lang.String r10 = org.rbmain.messenger.LocaleController.getString(r11, r10)
            goto L76
        L4c:
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r11 = "Days"
            java.lang.String r11 = org.rbmain.messenger.LocaleController.formatPluralString(r11, r6)
            r10[r7] = r11
            java.lang.String r10 = org.rbmain.messenger.LocaleController.formatString(r5, r4, r10)
            goto L76
        L5b:
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r11 = 8
            java.lang.String r11 = org.rbmain.messenger.LocaleController.formatPluralString(r12, r11)
            r10[r7] = r11
            java.lang.String r10 = org.rbmain.messenger.LocaleController.formatString(r5, r4, r10)
            goto L76
        L6a:
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r11 = org.rbmain.messenger.LocaleController.formatPluralString(r12, r8)
            r10[r7] = r11
            java.lang.String r10 = org.rbmain.messenger.LocaleController.formatString(r5, r4, r10)
        L76:
            r11 = 0
        L77:
            r12 = 1
        L78:
            if (r11 == 0) goto L83
            r11 = 2131820614(0x7f110046, float:1.9273948E38)
            java.lang.String[] r12 = new java.lang.String[r7]
            r0.setAnimation(r11, r12)
            goto Lba
        L83:
            if (r12 == 0) goto La2
            r11 = 2131820598(0x7f110036, float:1.9273915E38)
            java.lang.String[] r12 = new java.lang.String[r1]
            java.lang.String r1 = "Body Main"
            r12[r7] = r1
            java.lang.String r1 = "Body Top"
            r12[r8] = r1
            java.lang.String r1 = "Line"
            r12[r6] = r1
            java.lang.String r1 = "Curve Big"
            r12[r3] = r1
            java.lang.String r1 = "Curve Small"
            r12[r2] = r1
            r0.setAnimation(r11, r12)
            goto Lba
        La2:
            r11 = 2131820604(0x7f11003c, float:1.9273928E38)
            java.lang.String[] r12 = new java.lang.String[r2]
            java.lang.String r1 = "BODY"
            r12[r7] = r1
            java.lang.String r1 = "Wibe Big"
            r12[r8] = r1
            java.lang.String r1 = "Wibe Big 3"
            r12[r6] = r1
            java.lang.String r1 = "Wibe Small"
            r12[r3] = r1
            r0.setAnimation(r11, r12)
        Lba:
            org.rbmain.ui.Components.LinkSpanDrawable$LinksTextView r11 = r0.textView
            r11.setText(r10)
            r10 = 1500(0x5dc, float:2.102E-42)
            org.rbmain.ui.Components.Bulletin r9 = org.rbmain.ui.Components.Bulletin.make(r9, r0, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.BulletinFactory.createMuteBulletin(org.rbmain.ui.ActionBar.BaseFragment, int, int, org.rbmain.ui.ActionBar.Theme$ResourcesProvider):org.rbmain.ui.Components.Bulletin");
    }

    public static Bulletin createMuteBulletin(BaseFragment baseFragment, boolean z, Theme.ResourcesProvider resourcesProvider) {
        return createMuteBulletin(baseFragment, z ? 3 : 4, 0, resourcesProvider);
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

    public static Bulletin createSaveToGalleryBulletin(BaseFragment baseFragment, boolean z, Theme.ResourcesProvider resourcesProvider) {
        return of(baseFragment).createDownloadBulletin(z ? FileType.VIDEO : FileType.PHOTO, resourcesProvider);
    }

    public static Bulletin createSaveToGalleryBulletin(BaseFragment baseFragment, boolean z) {
        return of(baseFragment).createDownloadBulletin(z ? FileType.VIDEO : FileType.PHOTO, null);
    }

    public static Bulletin createSaveToGalleryBulletin(FrameLayout frameLayout, boolean z, int i, int i2) {
        return of(frameLayout, null).createDownloadBulletin(z ? FileType.VIDEO : FileType.PHOTO, 1, i, i2);
    }

    public static Bulletin createPromoteToAdminBulletin(BaseFragment baseFragment, String str) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(baseFragment.getParentActivity(), baseFragment.getResourceProvider());
        lottieLayout.setAnimation(R.raw.ic_admin, "Shield");
        lottieLayout.textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("UserSetAsAdminHint", R.string.UserSetAsAdminHint, str)));
        return Bulletin.make(baseFragment, lottieLayout, 1500);
    }

    public static Bulletin createRemoveFromChatBulletin(BaseFragment baseFragment, TLRPC$User tLRPC$User, String str) {
        String string;
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(baseFragment.getParentActivity(), baseFragment.getResourceProvider());
        lottieLayout.setAnimation(R.raw.ic_ban, "Hand");
        if (tLRPC$User.deleted) {
            string = LocaleController.formatString("HiddenName", R.string.HiddenName, new Object[0]);
        } else {
            string = tLRPC$User.first_name;
        }
        lottieLayout.textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("UserRemovedFromChatHint", R.string.UserRemovedFromChatHint, string, str)));
        return Bulletin.make(baseFragment, lottieLayout, 1500);
    }

    public static Bulletin createBanBulletin(BaseFragment baseFragment, boolean z) {
        String string;
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(baseFragment.getParentActivity(), baseFragment.getResourceProvider());
        if (z) {
            lottieLayout.setAnimation(R.raw.ic_ban, "Hand");
            string = LocaleController.getString("UserBlocked", R.string.UserBlocked);
        } else {
            lottieLayout.setAnimation(R.raw.ic_unban, "Main", "Finger 1", "Finger 2", "Finger 3", "Finger 4");
            string = LocaleController.getString("UserUnblocked", R.string.UserUnblocked);
        }
        lottieLayout.textView.setText(AndroidUtilities.replaceTags(string));
        return Bulletin.make(baseFragment, lottieLayout, 1500);
    }

    public static Bulletin createCopyLinkBulletin(BaseFragment baseFragment) {
        return of(baseFragment).createCopyLinkBulletin();
    }

    public static Bulletin createCopyLinkBulletin(FrameLayout frameLayout) {
        return of(frameLayout, null).createCopyLinkBulletin();
    }

    public static Bulletin createPinMessageBulletin(BaseFragment baseFragment, Theme.ResourcesProvider resourcesProvider) {
        return createPinMessageBulletin(baseFragment, true, null, null, resourcesProvider);
    }

    public static Bulletin createUnpinMessageBulletin(BaseFragment baseFragment, Runnable runnable, Runnable runnable2, Theme.ResourcesProvider resourcesProvider) {
        return createPinMessageBulletin(baseFragment, false, runnable, runnable2, resourcesProvider);
    }

    private static Bulletin createPinMessageBulletin(BaseFragment baseFragment, boolean z, Runnable runnable, Runnable runnable2, Theme.ResourcesProvider resourcesProvider) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(baseFragment.getParentActivity(), resourcesProvider);
        lottieLayout.setAnimation(z ? R.raw.ic_pin : R.raw.ic_unpin, 28, 28, "Pin", "Line");
        lottieLayout.textView.setText(LocaleController.getString(z ? "MessagePinnedHint" : "MessageUnpinnedHint", z ? R.string.MessagePinnedHint : R.string.MessageUnpinnedHint));
        if (!z) {
            lottieLayout.setButton(new Bulletin.UndoButton(baseFragment.getParentActivity(), true, resourcesProvider).setUndoAction(runnable).setDelayedAction(runnable2));
        }
        return Bulletin.make(baseFragment, lottieLayout, z ? 1500 : 5000);
    }

    public static Bulletin createSoundEnabledBulletin(BaseFragment baseFragment, int i, Theme.ResourcesProvider resourcesProvider) {
        String string;
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(baseFragment.getParentActivity(), resourcesProvider);
        boolean z = true;
        if (i == 0) {
            string = LocaleController.getString("SoundOnHint", R.string.SoundOnHint);
        } else if (i == 1) {
            string = LocaleController.getString("SoundOffHint", R.string.SoundOffHint);
            z = false;
        } else {
            throw new IllegalArgumentException();
        }
        if (z) {
            lottieLayout.setAnimation(R.raw.sound_on, new String[0]);
        } else {
            lottieLayout.setAnimation(R.raw.sound_off, new String[0]);
        }
        lottieLayout.textView.setText(string);
        return Bulletin.make(baseFragment, lottieLayout, 1500);
    }
}
