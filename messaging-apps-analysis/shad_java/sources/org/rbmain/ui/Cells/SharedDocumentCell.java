package org.rbmain.ui.Cells;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.util.Date;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_photoSizeEmpty;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.DotDividerSpan;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.LineProgressView;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.FilteredSearchView;

/* loaded from: classes4.dex */
public class SharedDocumentCell extends FrameLayout implements DownloadController.FileDownloadProgressListener {
    private int TAG;
    private CharSequence caption;
    private TextView captionTextView;
    private CheckBox2 checkBox;
    private int currentAccount;
    private TextView dateTextView;
    private SpannableStringBuilder dotSpan;
    private TextView extTextView;
    boolean ignoreRequestLayout;
    private boolean loaded;
    private boolean loading;
    private MessageObject message;
    private TextView nameTextView;
    private boolean needDivider;
    private ImageView placeholderImageView;
    private LineProgressView progressView;
    private TextView rightDateTextView;
    private RLottieDrawable statusDrawable;
    private RLottieImageView statusImageView;
    private BackupImageView thumbImageView;
    private int viewType;

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String str, long j, long j2, boolean z) {
    }

    public SharedDocumentCell(Context context) {
        this(context, 0);
    }

    public SharedDocumentCell(Context context, int i) {
        super(context);
        int i2 = UserConfig.selectedAccount;
        this.currentAccount = i2;
        this.viewType = i;
        this.TAG = DownloadController.getInstance(i2).generateObserverTag();
        ImageView imageView = new ImageView(context);
        this.placeholderImageView = imageView;
        if (i == 1) {
            boolean z = LocaleController.isRTL;
            addView(imageView, LayoutHelper.createFrame(42, 42.0f, (z ? 5 : 3) | 48, z ? 0.0f : 15.0f, 12.0f, z ? 15.0f : 0.0f, 0.0f));
        } else {
            boolean z2 = LocaleController.isRTL;
            addView(imageView, LayoutHelper.createFrame(40, 40.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 12.0f, 8.0f, z2 ? 12.0f : 0.0f, 0.0f));
        }
        TextView textView = new TextView(context);
        this.extTextView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_files_iconText));
        this.extTextView.setTextSize(1, 14.0f);
        this.extTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.extTextView.setLines(1);
        this.extTextView.setMaxLines(1);
        this.extTextView.setSingleLine(true);
        this.extTextView.setGravity(17);
        this.extTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.extTextView.setImportantForAccessibility(2);
        if (i == 1) {
            View view = this.extTextView;
            boolean z3 = LocaleController.isRTL;
            addView(view, LayoutHelper.createFrame(32, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 0.0f : 20.0f, 28.0f, z3 ? 20.0f : 0.0f, 0.0f));
        } else {
            View view2 = this.extTextView;
            boolean z4 = LocaleController.isRTL;
            addView(view2, LayoutHelper.createFrame(32, -2.0f, (z4 ? 5 : 3) | 48, z4 ? 0.0f : 16.0f, 22.0f, z4 ? 16.0f : 0.0f, 0.0f));
        }
        BackupImageView backupImageView = new BackupImageView(context) { // from class: org.rbmain.ui.Cells.SharedDocumentCell.1
            @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
            protected void onDraw(Canvas canvas) {
                float currentAlpha = SharedDocumentCell.this.thumbImageView.getImageReceiver().hasBitmapImage() ? 1.0f - SharedDocumentCell.this.thumbImageView.getImageReceiver().getCurrentAlpha() : 1.0f;
                SharedDocumentCell.this.extTextView.setAlpha(currentAlpha);
                SharedDocumentCell.this.placeholderImageView.setAlpha(currentAlpha);
                super.onDraw(canvas);
            }
        };
        this.thumbImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(4.0f));
        if (i == 1) {
            View view3 = this.thumbImageView;
            boolean z5 = LocaleController.isRTL;
            addView(view3, LayoutHelper.createFrame(42, 42.0f, (z5 ? 5 : 3) | 48, z5 ? 0.0f : 16.0f, 12.0f, z5 ? 16.0f : 0.0f, 0.0f));
        } else {
            View view4 = this.thumbImageView;
            boolean z6 = LocaleController.isRTL;
            addView(view4, LayoutHelper.createFrame(40, 40.0f, (z6 ? 5 : 3) | 48, z6 ? 0.0f : 12.0f, 8.0f, z6 ? 12.0f : 0.0f, 0.0f));
        }
        TextView textView2 = new TextView(context);
        this.nameTextView = textView2;
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        textView2.setTextColor(Theme.getColor(i3));
        this.nameTextView.setTextSize(1, 16.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        if (i == 1) {
            this.nameTextView.setLines(1);
            this.nameTextView.setMaxLines(1);
            this.nameTextView.setSingleLine(true);
            View view5 = this.nameTextView;
            boolean z7 = LocaleController.isRTL;
            addView(view5, LayoutHelper.createFrame(-1, -2.0f, (z7 ? 5 : 3) | 48, z7 ? 8.0f : 72.0f, 9.0f, z7 ? 72.0f : 8.0f, 0.0f));
        } else if (i == 2) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            boolean z8 = LocaleController.isRTL;
            addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, (z8 ? 5 : 3) | 48, z8 ? 16.0f : 72.0f, 5.0f, z8 ? 72.0f : 16.0f, 0.0f));
            TextView textView3 = new TextView(context);
            this.rightDateTextView = textView3;
            textView3.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
            this.rightDateTextView.setTextSize(1, 14.0f);
            if (!LocaleController.isRTL) {
                linearLayout.addView(this.nameTextView, LayoutHelper.createLinear(-2, -2, 1.0f));
                linearLayout.addView(this.rightDateTextView, LayoutHelper.createLinear(-2, -2, 0.0f, 4, 0, 0, 0));
            } else {
                linearLayout.addView(this.rightDateTextView, LayoutHelper.createLinear(-2, -2, 0.0f));
                linearLayout.addView(this.nameTextView, LayoutHelper.createLinear(-2, -2, 1.0f, 0, 0, 4, 0));
            }
            this.nameTextView.setMaxLines(2);
            TextView textView4 = new TextView(context);
            this.captionTextView = textView4;
            textView4.setTextColor(Theme.getColor(i3));
            this.captionTextView.setLines(1);
            this.captionTextView.setMaxLines(1);
            this.captionTextView.setSingleLine(true);
            this.captionTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.captionTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            this.captionTextView.setTextSize(1, 13.0f);
            View view6 = this.captionTextView;
            boolean z9 = LocaleController.isRTL;
            addView(view6, LayoutHelper.createFrame(-1, -2.0f, (z9 ? 5 : 3) | 48, z9 ? 8.0f : 72.0f, 30.0f, z9 ? 72.0f : 8.0f, 0.0f));
            this.captionTextView.setVisibility(8);
        } else {
            this.nameTextView.setMaxLines(2);
            View view7 = this.nameTextView;
            boolean z10 = LocaleController.isRTL;
            addView(view7, LayoutHelper.createFrame(-1, -2.0f, (z10 ? 5 : 3) | 48, z10 ? 8.0f : 72.0f, 5.0f, z10 ? 72.0f : 8.0f, 0.0f));
        }
        this.statusDrawable = new RLottieDrawable(R.raw.download_arrow, "download_arrow", AndroidUtilities.dp(14.0f), AndroidUtilities.dp(14.0f), true, null);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.statusImageView = rLottieImageView;
        rLottieImageView.setAnimation(this.statusDrawable);
        this.statusImageView.setVisibility(4);
        RLottieImageView rLottieImageView2 = this.statusImageView;
        int i4 = Theme.key_sharedMedia_startStopLoadIcon;
        rLottieImageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.MULTIPLY));
        if (i == 1) {
            View view8 = this.statusImageView;
            boolean z11 = LocaleController.isRTL;
            addView(view8, LayoutHelper.createFrame(14, 14.0f, (z11 ? 5 : 3) | 48, z11 ? 8.0f : 70.0f, 37.0f, z11 ? 72.0f : 8.0f, 0.0f));
        } else {
            View view9 = this.statusImageView;
            boolean z12 = LocaleController.isRTL;
            addView(view9, LayoutHelper.createFrame(14, 14.0f, (z12 ? 5 : 3) | 48, z12 ? 8.0f : 70.0f, 33.0f, z12 ? 72.0f : 8.0f, 0.0f));
        }
        TextView textView5 = new TextView(context);
        this.dateTextView = textView5;
        textView5.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        this.dateTextView.setLines(1);
        this.dateTextView.setMaxLines(1);
        this.dateTextView.setSingleLine(true);
        this.dateTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.dateTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        if (i == 1) {
            this.dateTextView.setTextSize(1, 13.0f);
            View view10 = this.dateTextView;
            boolean z13 = LocaleController.isRTL;
            addView(view10, LayoutHelper.createFrame(-1, -2.0f, (z13 ? 5 : 3) | 48, z13 ? 8.0f : 72.0f, 34.0f, z13 ? 72.0f : 8.0f, 0.0f));
        } else {
            this.dateTextView.setTextSize(1, 13.0f);
            View view11 = this.dateTextView;
            boolean z14 = LocaleController.isRTL;
            addView(view11, LayoutHelper.createFrame(-1, -2.0f, (z14 ? 5 : 3) | 48, z14 ? 8.0f : 72.0f, 30.0f, z14 ? 72.0f : 8.0f, 0.0f));
        }
        LineProgressView lineProgressView = new LineProgressView(context);
        this.progressView = lineProgressView;
        lineProgressView.setProgressColor(Theme.getColor(i4));
        View view12 = this.progressView;
        boolean z15 = LocaleController.isRTL;
        addView(view12, LayoutHelper.createFrame(-1, 2.0f, (z15 ? 5 : 3) | 48, z15 ? 0.0f : 72.0f, 54.0f, z15 ? 72.0f : 0.0f, 0.0f));
        CheckBox2 checkBox2 = new CheckBox2(context, 21);
        this.checkBox = checkBox2;
        checkBox2.setVisibility(4);
        this.checkBox.setColor(-1, Theme.key_windowBackgroundWhite, Theme.key_checkboxCheck);
        this.checkBox.setDrawUnchecked(false);
        this.checkBox.setDrawBackgroundAsArc(2);
        if (i == 1) {
            View view13 = this.checkBox;
            boolean z16 = LocaleController.isRTL;
            addView(view13, LayoutHelper.createFrame(24, 24.0f, (z16 ? 5 : 3) | 48, z16 ? 0.0f : 38.0f, 36.0f, z16 ? 38.0f : 0.0f, 0.0f));
        } else {
            View view14 = this.checkBox;
            boolean z17 = LocaleController.isRTL;
            addView(view14, LayoutHelper.createFrame(24, 24.0f, (z17 ? 5 : 3) | 48, z17 ? 0.0f : 33.0f, 28.0f, z17 ? 33.0f : 0.0f, 0.0f));
        }
        if (i == 2) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(".");
            this.dotSpan = spannableStringBuilder;
            spannableStringBuilder.setSpan(new DotDividerSpan(), 0, 1, 0);
        }
    }

    public void setTextAndValueAndTypeAndThumb(String str, String str2, String str3, String str4, int i, boolean z) {
        int i2;
        int i3;
        this.nameTextView.setText(str);
        this.dateTextView.setText(str2);
        if (str3 != null) {
            this.extTextView.setVisibility(0);
            this.extTextView.setText(str3.toLowerCase());
        } else {
            this.extTextView.setVisibility(4);
        }
        this.needDivider = z;
        if (i == 0) {
            this.placeholderImageView.setImageResource(AndroidUtilities.getThumbForNameOrMime(str, str3, false));
            this.placeholderImageView.setVisibility(0);
        } else {
            this.placeholderImageView.setVisibility(4);
        }
        if (str4 != null || i != 0) {
            if (str4 != null) {
                this.thumbImageView.setImage(str4, "42_42", null);
            } else {
                CombinedDrawable combinedDrawableCreateCircleDrawableWithIcon = Theme.createCircleDrawableWithIcon(AndroidUtilities.dp(42.0f), i);
                if (i == R.drawable.files_storage) {
                    i2 = Theme.key_chat_attachLocationBackground;
                    i3 = Theme.key_chat_attachIcon;
                } else if (i == R.drawable.files_gallery) {
                    i2 = Theme.key_chat_attachContactBackground;
                    i3 = Theme.key_chat_attachIcon;
                } else if (i == R.drawable.files_music) {
                    i2 = Theme.key_chat_attachAudioBackground;
                    i3 = Theme.key_chat_attachIcon;
                } else if (i == R.drawable.files_internal) {
                    i2 = Theme.key_chat_attachGalleryBackground;
                    i3 = Theme.key_chat_attachIcon;
                } else {
                    i2 = Theme.key_files_folderIconBackground;
                    i3 = Theme.key_files_folderIcon;
                }
                Theme.setCombinedDrawableColor(combinedDrawableCreateCircleDrawableWithIcon, Theme.getColor(i2), false);
                Theme.setCombinedDrawableColor(combinedDrawableCreateCircleDrawableWithIcon, Theme.getColor(i3), true);
                this.thumbImageView.setImageDrawable(combinedDrawableCreateCircleDrawableWithIcon);
            }
            this.thumbImageView.setVisibility(0);
        } else {
            this.extTextView.setAlpha(1.0f);
            this.placeholderImageView.setAlpha(1.0f);
            this.thumbImageView.setImageBitmap(null);
            this.thumbImageView.setVisibility(4);
        }
        setWillNotDraw(true ^ this.needDivider);
    }

    public void setPhotoEntry(MediaController.PhotoEntry photoEntry) {
        String str;
        String str2 = photoEntry.thumbPath;
        if (str2 != null) {
            this.thumbImageView.setImage(str2, null, Theme.chat_attachEmptyDrawable);
            str = photoEntry.thumbPath;
        } else if (photoEntry.path != null) {
            if (photoEntry.isVideo) {
                this.thumbImageView.setOrientation(0, true);
                this.thumbImageView.setImage("vthumb://" + photoEntry.imageId + ":" + photoEntry.path, null, Theme.chat_attachEmptyDrawable);
            } else {
                this.thumbImageView.setOrientation(photoEntry.orientation, true);
                this.thumbImageView.setImage("thumb://" + photoEntry.imageId + ":" + photoEntry.path, null, Theme.chat_attachEmptyDrawable);
            }
            str = photoEntry.path;
        } else {
            this.thumbImageView.setImageDrawable(Theme.chat_attachEmptyDrawable);
            str = BuildConfig.FLAVOR;
        }
        File file = new File(str);
        this.nameTextView.setText(file.getName());
        FileLoader.getFileExtension(file);
        StringBuilder sb = new StringBuilder();
        this.extTextView.setVisibility(8);
        if (photoEntry.width != 0 && photoEntry.height != 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(String.format(Locale.US, "%dx%d", Integer.valueOf(photoEntry.width), Integer.valueOf(photoEntry.height)));
        }
        if (photoEntry.isVideo) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(AndroidUtilities.formatShortDuration(photoEntry.duration));
        }
        if (photoEntry.size != 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(AndroidUtilities.formatFileSize(photoEntry.size));
        }
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(LocaleController.getInstance().formatterStats.format(photoEntry.dateTaken));
        this.dateTextView.setText(sb);
        this.placeholderImageView.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.progressView.getVisibility() == 0) {
            updateFileExistIcon(false);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.checkBox.getVisibility() != 0) {
            this.checkBox.setVisibility(0);
        }
        this.checkBox.setChecked(z, z2);
    }

    public void setDocument(MessageObject messageObject, boolean z) {
        boolean z2;
        boolean z3;
        String str;
        String str2;
        MessageObject messageObject2 = this.message;
        if (messageObject2 == null || messageObject == null || messageObject2.getId() == messageObject.getId()) {
            z2 = z;
            z3 = false;
        } else {
            z2 = z;
            z3 = true;
        }
        this.needDivider = z2;
        this.message = messageObject;
        this.loaded = false;
        this.loading = false;
        TLRPC$Document document = messageObject.getDocument();
        String lowerCase = BuildConfig.FLAVOR;
        if (document != null) {
            String str3 = null;
            if (messageObject.isMusic()) {
                for (int i = 0; i < document.attributes.size(); i++) {
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                    if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) && (((str = tLRPC$DocumentAttribute.performer) != null && str.length() != 0) || ((str2 = tLRPC$DocumentAttribute.title) != null && str2.length() != 0))) {
                        str3 = messageObject.getMusicAuthor() + " - " + messageObject.getMusicTitle();
                    }
                }
            }
            String documentFileName = FileLoader.getDocumentFileName(document);
            if (str3 == null) {
                str3 = documentFileName;
            }
            CharSequence charSequenceHighlightText = AndroidUtilities.highlightText(str3, messageObject.highlightedWords);
            if (charSequenceHighlightText != null) {
                this.nameTextView.setText(charSequenceHighlightText);
            } else {
                this.nameTextView.setText(str3);
            }
            this.placeholderImageView.setVisibility(0);
            this.extTextView.setVisibility(0);
            this.placeholderImageView.setImageResource(AndroidUtilities.getThumbForNameOrMime(documentFileName, document.mime_type, false));
            TextView textView = this.extTextView;
            int iLastIndexOf = documentFileName.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                lowerCase = documentFileName.substring(iLastIndexOf + 1).toLowerCase();
            }
            textView.setText(lowerCase);
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 320);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 40);
            if (closestPhotoSizeWithSize2 == closestPhotoSizeWithSize) {
                closestPhotoSizeWithSize = null;
            }
            if ((closestPhotoSizeWithSize2 instanceof TLRPC$TL_photoSizeEmpty) || closestPhotoSizeWithSize2 == null) {
                this.thumbImageView.setVisibility(4);
                this.thumbImageView.setImageBitmap(null);
                this.extTextView.setAlpha(1.0f);
                this.placeholderImageView.setAlpha(1.0f);
            } else {
                this.thumbImageView.getImageReceiver().setNeedsQualityThumb(closestPhotoSizeWithSize == null);
                this.thumbImageView.getImageReceiver().setShouldGenerateQualityThumb(closestPhotoSizeWithSize == null);
                this.thumbImageView.setVisibility(0);
                this.thumbImageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, document), "40_40", ImageLocation.getForDocument(closestPhotoSizeWithSize2, document), "40_40_b", null, 0L, 1, messageObject);
            }
            long j = messageObject.messageOwner.date * 1000;
            if (this.viewType == 2) {
                this.dateTextView.setText(new SpannableStringBuilder().append((CharSequence) AndroidUtilities.formatFileSize(document.size)).append(' ').append((CharSequence) this.dotSpan).append(' ').append(FilteredSearchView.createFromInfoString(messageObject)));
                this.rightDateTextView.setText(LocaleController.stringForMessageListDate(messageObject.messageOwner.date));
            } else {
                this.dateTextView.setText(String.format("%s, %s", AndroidUtilities.formatFileSize(document.size), LocaleController.formatString("formatDateAtTime", R.string.formatDateAtTime, LocaleController.getInstance().formatterYear.format(new Date(j)), LocaleController.getInstance().formatterDay.format(new Date(j)))));
            }
            if (messageObject.hasHighlightedWords() && !TextUtils.isEmpty(this.message.messageOwner.message)) {
                CharSequence charSequenceHighlightText2 = AndroidUtilities.highlightText(this.message.messageOwner.message.replace("\n", " ").replaceAll(" +", " ").trim(), this.message.highlightedWords);
                this.caption = charSequenceHighlightText2;
                TextView textView2 = this.captionTextView;
                if (textView2 != null) {
                    textView2.setVisibility(charSequenceHighlightText2 == null ? 8 : 0);
                }
            } else {
                TextView textView3 = this.captionTextView;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
        } else {
            this.nameTextView.setText(BuildConfig.FLAVOR);
            this.extTextView.setText(BuildConfig.FLAVOR);
            this.dateTextView.setText(BuildConfig.FLAVOR);
            this.placeholderImageView.setVisibility(0);
            this.extTextView.setVisibility(0);
            this.extTextView.setAlpha(1.0f);
            this.placeholderImageView.setAlpha(1.0f);
            this.thumbImageView.setVisibility(4);
            this.thumbImageView.setImageBitmap(null);
            this.caption = null;
            TextView textView4 = this.captionTextView;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        setWillNotDraw(!this.needDivider);
        this.progressView.setProgress(0.0f, false);
        updateFileExistIcon(z3);
    }

    public void updateFileExistIcon(boolean z) {
        if (z && Build.VERSION.SDK_INT >= 19) {
            TransitionSet transitionSet = new TransitionSet();
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(150L);
            transitionSet.addTransition(new Fade().setDuration(150L)).addTransition(changeBounds);
            transitionSet.setOrdering(0);
            transitionSet.setInterpolator((TimeInterpolator) CubicBezierInterpolator.DEFAULT);
            TransitionManager.beginDelayedTransition(this, transitionSet);
        }
        MessageObject messageObject = this.message;
        if (messageObject != null && messageObject.messageOwner.media != null) {
            this.loaded = false;
            if (messageObject.attachPathExists || messageObject.mediaExists) {
                this.statusImageView.setVisibility(4);
                this.progressView.setVisibility(4);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dateTextView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : 72.0f);
                    layoutParams.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 8.0f);
                    this.dateTextView.requestLayout();
                }
                this.loading = false;
                this.loaded = true;
                DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                return;
            }
            String attachFileName = FileLoader.getAttachFileName(messageObject.getDocument());
            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(attachFileName, this.message, this);
            this.loading = FileLoader.getInstance(this.currentAccount).isLoadingFile(attachFileName);
            this.statusImageView.setVisibility(0);
            this.statusDrawable.setCustomEndFrame(this.loading ? 15 : 0);
            this.statusDrawable.setPlayInDirectionOfCustomEndFrame(true);
            if (z) {
                this.statusImageView.playAnimation();
            } else {
                this.statusDrawable.setCurrentFrame(this.loading ? 15 : 0);
                this.statusImageView.invalidate();
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dateTextView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : 86.0f);
                layoutParams2.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? 86.0f : 8.0f);
                this.dateTextView.requestLayout();
            }
            if (this.loading) {
                this.progressView.setVisibility(0);
                Float fileProgress = ImageLoader.getInstance().getFileProgress(attachFileName);
                if (fileProgress == null) {
                    fileProgress = Float.valueOf(0.0f);
                }
                this.progressView.setProgress(fileProgress.floatValue(), false);
                return;
            }
            this.progressView.setVisibility(4);
            return;
        }
        this.loading = false;
        this.loaded = true;
        this.progressView.setVisibility(4);
        this.progressView.setProgress(0.0f, false);
        this.statusImageView.setVisibility(4);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.dateTextView.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : 72.0f);
            layoutParams3.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 8.0f);
            this.dateTextView.requestLayout();
        }
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
    }

    public MessageObject getMessage() {
        return this.message;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public boolean isLoading() {
        return this.loading;
    }

    public BackupImageView getImageView() {
        return this.thumbImageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.viewType == 1) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(56.0f), 1073741824));
        int iDp = AndroidUtilities.dp(34.0f) + this.nameTextView.getMeasuredHeight() + (this.needDivider ? 1 : 0);
        if (this.caption != null && this.captionTextView != null && this.message.hasHighlightedWords()) {
            this.ignoreRequestLayout = true;
            this.captionTextView.setText(AndroidUtilities.ellipsizeCenterEnd(this.caption, this.message.highlightedWords.get(0), this.captionTextView.getMeasuredWidth(), this.captionTextView.getPaint(), 130));
            this.ignoreRequestLayout = false;
            iDp += this.captionTextView.getMeasuredHeight() + AndroidUtilities.dp(3.0f);
        }
        setMeasuredDimension(getMeasuredWidth(), iDp);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreRequestLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TextView textView;
        super.onLayout(z, i, i2, i3, i4);
        if (this.viewType != 1 && this.nameTextView.getLineCount() <= 1 && (textView = this.captionTextView) != null) {
            textView.getVisibility();
        }
        int measuredHeight = this.nameTextView.getMeasuredHeight() - AndroidUtilities.dp(22.0f);
        TextView textView2 = this.captionTextView;
        if (textView2 != null && textView2.getVisibility() == 0) {
            TextView textView3 = this.captionTextView;
            textView3.layout(textView3.getLeft(), this.captionTextView.getTop() + measuredHeight, this.captionTextView.getRight(), this.captionTextView.getBottom() + measuredHeight);
            measuredHeight += this.captionTextView.getMeasuredHeight() + AndroidUtilities.dp(3.0f);
        }
        TextView textView4 = this.dateTextView;
        textView4.layout(textView4.getLeft(), this.dateTextView.getTop() + measuredHeight, this.dateTextView.getRight(), this.dateTextView.getBottom() + measuredHeight);
        RLottieImageView rLottieImageView = this.statusImageView;
        rLottieImageView.layout(rLottieImageView.getLeft(), this.statusImageView.getTop() + measuredHeight, this.statusImageView.getRight(), measuredHeight + this.statusImageView.getBottom());
        LineProgressView lineProgressView = this.progressView;
        lineProgressView.layout(lineProgressView.getLeft(), (getMeasuredHeight() - this.progressView.getMeasuredHeight()) - (this.needDivider ? 1 : 0), this.progressView.getRight(), getMeasuredHeight() - (this.needDivider ? 1 : 0));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(AndroidUtilities.dp(72.0f), getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String str, boolean z) {
        updateFileExistIcon(true);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String str) {
        this.progressView.setProgress(1.0f, true);
        updateFileExistIcon(true);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String str, long j, long j2) {
        if (this.progressView.getVisibility() != 0) {
            updateFileExistIcon(true);
        }
        this.progressView.setProgress(Math.min(1.0f, j / j2), true);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.checkBox.isChecked()) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(true);
        }
    }
}
