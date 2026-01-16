package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_channels_checkUsername;
import ir.eitaa.tgnet.TLRPC$TL_channels_exportInvite;
import ir.eitaa.tgnet.TLRPC$TL_channels_getAdminedPublicChannels;
import ir.eitaa.tgnet.TLRPC$TL_channels_updateUsername;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputChannelEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_chats;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.AdminedChannelCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.RadioButtonCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextBlockCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EditTextEmoji;
import ir.eitaa.ui.Components.ImageUpdater;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LinkActionView;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChannelCreateActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, ImageUpdater.ImageUpdaterDelegate {
    private ArrayList<AdminedChannelCell> adminedChannelCells;
    private TextInfoPrivacyCell adminedInfoCell;
    private LinearLayout adminnedChannelsLayout;
    private TLRPC$FileLocation avatar;
    private AnimatorSet avatarAnimation;
    private TLRPC$FileLocation avatarBig;
    private AvatarDrawable avatarDrawable;
    private RLottieImageView avatarEditor;
    private BackupImageView avatarImage;
    private View avatarOverlay;
    private RadialProgressView avatarProgressView;
    private RLottieDrawable cameraDrawable;
    private boolean canCreatePublic;
    private long chatId;
    private int checkReqId;
    private Runnable checkRunnable;
    private TextView checkTextView;
    private boolean createAfterUpload;
    private int currentStep;
    private EditTextBoldCursor descriptionTextView;
    private View doneButton;
    private boolean donePressed;
    private EditTextBoldCursor editText;
    private HeaderCell headerCell;
    private HeaderCell headerCell2;
    private TextView helpTextView;
    private ImageUpdater imageUpdater;
    private TLRPC$InputFile inputPhoto;
    private TLRPC$InputFile inputVideo;
    private String inputVideoPath;
    private TLRPC$ExportedChatInvite invite;
    private boolean isPrivate;
    private String lastCheckName;
    private boolean lastNameAvailable;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout2;
    private LinearLayout linkContainer;
    private LoadingCell loadingAdminedCell;
    private boolean loadingAdminedChannels;
    private boolean loadingInvite;
    private EditTextEmoji nameTextView;
    private String nameToSet;
    private LinkActionView permanentLinkView;
    private LinearLayout privateContainer;
    private AlertDialog progressDialog;
    private LinearLayout publicContainer;
    private RadioButtonCell radioButtonCell1;
    private RadioButtonCell radioButtonCell2;
    private ShadowSectionCell sectionCell;
    private TextInfoPrivacyCell typeInfoCell;
    private double videoTimestamp;

    static /* synthetic */ boolean lambda$createView$2(View view, MotionEvent motionEvent) {
        return true;
    }

    public ChannelCreateActivity(Bundle args) {
        super(args);
        this.adminedChannelCells = new ArrayList<>();
        this.canCreatePublic = true;
        int i = args.getInt("step", 0);
        this.currentStep = i;
        if (i == 0) {
            this.avatarDrawable = new AvatarDrawable();
            this.imageUpdater = new ImageUpdater(true);
            TLRPC$TL_channels_checkUsername tLRPC$TL_channels_checkUsername = new TLRPC$TL_channels_checkUsername();
            tLRPC$TL_channels_checkUsername.username = "1";
            tLRPC$TL_channels_checkUsername.channel = new TLRPC$TL_inputChannelEmpty();
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_checkUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$NIc0N26F__43_Isd_V4bYBeT678
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$1$ChannelCreateActivity(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (i == 1) {
            boolean z = args.getBoolean("canCreatePublic", true);
            this.canCreatePublic = z;
            this.isPrivate = !z;
            if (!z) {
                loadAdminedChannels();
            }
        }
        this.chatId = args.getLong("chat_id", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChannelCreateActivity(TLRPC$TL_error tLRPC$TL_error) {
        this.canCreatePublic = tLRPC$TL_error == null || !tLRPC$TL_error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChannelCreateActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$wCW0KtzDY07ra2z8IJMuovVV7GI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$ChannelCreateActivity(tLRPC$TL_error);
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatDidCreated);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatDidFailCreate);
        if (this.currentStep == 1) {
            generateLink();
        }
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.parentFragment = this;
            imageUpdater.setDelegate(this);
        }
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatDidCreated);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatDidFailCreate);
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.clear();
        }
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onResume();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onResume();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onPause();
        }
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onPause();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void dismissCurrentDialog() {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater == null || !imageUpdater.dismissCurrentDialog(this.visibleDialog)) {
            super.dismissCurrentDialog();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean dismissDialogOnPause(Dialog dialog) {
        ImageUpdater imageUpdater = this.imageUpdater;
        return (imageUpdater == null || imageUpdater.dismissDialogOnPause(dialog)) && super.dismissDialogOnPause(dialog);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onRequestPermissionsResultFragment(requestCode, permissions, grantResults);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji == null || !editTextEmoji.isPopupShowing()) {
            return true;
        }
        this.nameTextView.hidePopup(true);
        return false;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1());
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        int i = this.currentStep;
        if (i == 0) {
            this.actionBar.setTitle(LocaleController.getString("NewChannel", R.string.NewChannel));
            SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.ChannelCreateActivity.2
                private boolean ignoreLayout;

                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    int size = View.MeasureSpec.getSize(widthMeasureSpec);
                    int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                    setMeasuredDimension(size, size2);
                    int paddingTop = size2 - getPaddingTop();
                    measureChildWithMargins(((BaseFragment) ChannelCreateActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    if (measureKeyboardHeight() > AndroidUtilities.dp(20.0f)) {
                        this.ignoreLayout = true;
                        ChannelCreateActivity.this.nameTextView.hideEmojiView();
                        this.ignoreLayout = false;
                    }
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = getChildAt(i2);
                        if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) ChannelCreateActivity.this).actionBar) {
                            if (ChannelCreateActivity.this.nameTextView != null && ChannelCreateActivity.this.nameTextView.isPopupView(childAt)) {
                                if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                                    if (AndroidUtilities.isTablet()) {
                                        childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (paddingTop - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                                    } else {
                                        childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((paddingTop - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                                    }
                                } else {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                                }
                            } else {
                                measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                            }
                        }
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
                /* JADX WARN: Removed duplicated region for block: B:44:0x00bc  */
                @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
                    /*
                        r10 = this;
                        int r11 = r10.getChildCount()
                        int r0 = r10.measureKeyboardHeight()
                        r1 = 1101004800(0x41a00000, float:20.0)
                        int r1 = ir.eitaa.messenger.AndroidUtilities.dp(r1)
                        r2 = 0
                        if (r0 > r1) goto L26
                        boolean r1 = ir.eitaa.messenger.AndroidUtilities.isInMultiwindow
                        if (r1 != 0) goto L26
                        boolean r1 = ir.eitaa.messenger.AndroidUtilities.isTablet()
                        if (r1 != 0) goto L26
                        ir.eitaa.ui.ChannelCreateActivity r1 = ir.eitaa.ui.ChannelCreateActivity.this
                        ir.eitaa.ui.Components.EditTextEmoji r1 = ir.eitaa.ui.ChannelCreateActivity.access$200(r1)
                        int r1 = r1.getEmojiPadding()
                        goto L27
                    L26:
                        r1 = 0
                    L27:
                        r10.setBottomClip(r1)
                    L2a:
                        if (r2 >= r11) goto Lcf
                        android.view.View r3 = r10.getChildAt(r2)
                        int r4 = r3.getVisibility()
                        r5 = 8
                        if (r4 != r5) goto L3a
                        goto Lcb
                    L3a:
                        android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
                        android.widget.FrameLayout$LayoutParams r4 = (android.widget.FrameLayout.LayoutParams) r4
                        int r5 = r3.getMeasuredWidth()
                        int r6 = r3.getMeasuredHeight()
                        int r7 = r4.gravity
                        r8 = -1
                        if (r7 != r8) goto L4f
                        r7 = 51
                    L4f:
                        r8 = r7 & 7
                        r7 = r7 & 112(0x70, float:1.57E-43)
                        r8 = r8 & 7
                        r9 = 1
                        if (r8 == r9) goto L63
                        r9 = 5
                        if (r8 == r9) goto L5e
                        int r8 = r4.leftMargin
                        goto L6e
                    L5e:
                        int r8 = r14 - r5
                        int r9 = r4.rightMargin
                        goto L6d
                    L63:
                        int r8 = r14 - r12
                        int r8 = r8 - r5
                        int r8 = r8 / 2
                        int r9 = r4.leftMargin
                        int r8 = r8 + r9
                        int r9 = r4.rightMargin
                    L6d:
                        int r8 = r8 - r9
                    L6e:
                        r9 = 16
                        if (r7 == r9) goto L8c
                        r9 = 48
                        if (r7 == r9) goto L84
                        r9 = 80
                        if (r7 == r9) goto L7d
                        int r4 = r4.topMargin
                        goto L99
                    L7d:
                        int r7 = r15 - r1
                        int r7 = r7 - r13
                        int r7 = r7 - r6
                        int r4 = r4.bottomMargin
                        goto L97
                    L84:
                        int r4 = r4.topMargin
                        int r7 = r10.getPaddingTop()
                        int r4 = r4 + r7
                        goto L99
                    L8c:
                        int r7 = r15 - r1
                        int r7 = r7 - r13
                        int r7 = r7 - r6
                        int r7 = r7 / 2
                        int r9 = r4.topMargin
                        int r7 = r7 + r9
                        int r4 = r4.bottomMargin
                    L97:
                        int r4 = r7 - r4
                    L99:
                        ir.eitaa.ui.ChannelCreateActivity r7 = ir.eitaa.ui.ChannelCreateActivity.this
                        ir.eitaa.ui.Components.EditTextEmoji r7 = ir.eitaa.ui.ChannelCreateActivity.access$200(r7)
                        if (r7 == 0) goto Lc6
                        ir.eitaa.ui.ChannelCreateActivity r7 = ir.eitaa.ui.ChannelCreateActivity.this
                        ir.eitaa.ui.Components.EditTextEmoji r7 = ir.eitaa.ui.ChannelCreateActivity.access$200(r7)
                        boolean r7 = r7.isPopupView(r3)
                        if (r7 == 0) goto Lc6
                        boolean r4 = ir.eitaa.messenger.AndroidUtilities.isTablet()
                        if (r4 == 0) goto Lbc
                        int r4 = r10.getMeasuredHeight()
                        int r7 = r3.getMeasuredHeight()
                        goto Lc5
                    Lbc:
                        int r4 = r10.getMeasuredHeight()
                        int r4 = r4 + r0
                        int r7 = r3.getMeasuredHeight()
                    Lc5:
                        int r4 = r4 - r7
                    Lc6:
                        int r5 = r5 + r8
                        int r6 = r6 + r4
                        r3.layout(r8, r4, r5, r6)
                    Lcb:
                        int r2 = r2 + 1
                        goto L2a
                    Lcf:
                        r10.notifyHeightChanged()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelCreateActivity.AnonymousClass2.onLayout(boolean, int, int, int, int):void");
                }

                @Override // android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (this.ignoreLayout) {
                        return;
                    }
                    super.requestLayout();
                }
            };
            sizeNotifierFrameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$2vQCiuHxB5RMtg79lnwnCGhy_gA
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return ChannelCreateActivity.lambda$createView$2(view, motionEvent);
                }
            });
            this.fragmentView = sizeNotifierFrameLayout;
            sizeNotifierFrameLayout.setTag("windowBackgroundWhite");
            this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            LinearLayout linearLayout = new LinearLayout(context);
            this.linearLayout = linearLayout;
            linearLayout.setOrientation(1);
            sizeNotifierFrameLayout.addView(this.linearLayout, new FrameLayout.LayoutParams(-1, -2));
            FrameLayout frameLayout = new FrameLayout(context);
            this.linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2));
            BackupImageView backupImageView = new BackupImageView(context) { // from class: ir.eitaa.ui.ChannelCreateActivity.3
                @Override // android.view.View
                public void invalidate() {
                    if (ChannelCreateActivity.this.avatarOverlay != null) {
                        ChannelCreateActivity.this.avatarOverlay.invalidate();
                    }
                    super.invalidate();
                }

                @Override // android.view.View
                public void invalidate(int l, int t, int r, int b) {
                    if (ChannelCreateActivity.this.avatarOverlay != null) {
                        ChannelCreateActivity.this.avatarOverlay.invalidate();
                    }
                    super.invalidate(l, t, r, b);
                }
            };
            this.avatarImage = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(32.0f));
            this.avatarDrawable.setInfo(5L, null, null);
            this.avatarImage.setImageDrawable(this.avatarDrawable);
            BackupImageView backupImageView2 = this.avatarImage;
            boolean z = LocaleController.isRTL;
            frameLayout.addView(backupImageView2, LayoutHelper.createFrame(64, 64.0f, (z ? 5 : 3) | 48, z ? 0.0f : 16.0f, 12.0f, z ? 16.0f : 0.0f, 12.0f));
            final Paint paint = new Paint(1);
            paint.setColor(1426063360);
            View view = new View(context) { // from class: ir.eitaa.ui.ChannelCreateActivity.4
                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    if (ChannelCreateActivity.this.avatarImage == null || !ChannelCreateActivity.this.avatarImage.getImageReceiver().hasNotThumb()) {
                        return;
                    }
                    paint.setAlpha((int) (ChannelCreateActivity.this.avatarImage.getImageReceiver().getCurrentAlpha() * 85.0f));
                    canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth() / 2.0f, paint);
                }
            };
            this.avatarOverlay = view;
            boolean z2 = LocaleController.isRTL;
            frameLayout.addView(view, LayoutHelper.createFrame(64, 64.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 16.0f, 12.0f, z2 ? 16.0f : 0.0f, 12.0f));
            this.avatarOverlay.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$y3jquoDjr8UEXD-D0FcyqUj0R4k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$5$ChannelCreateActivity(view2);
                }
            });
            this.cameraDrawable = new RLottieDrawable(R.raw.camera, "2131623944", AndroidUtilities.dp(60.0f), AndroidUtilities.dp(60.0f), false, (int[]) null);
            RLottieImageView rLottieImageView = new RLottieImageView(context) { // from class: ir.eitaa.ui.ChannelCreateActivity.5
                @Override // android.view.View
                public void invalidate(int l, int t, int r, int b) {
                    super.invalidate(l, t, r, b);
                    ChannelCreateActivity.this.avatarOverlay.invalidate();
                }

                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    ChannelCreateActivity.this.avatarOverlay.invalidate();
                }
            };
            this.avatarEditor = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.avatarEditor.setAnimation(this.cameraDrawable);
            this.avatarEditor.setEnabled(false);
            this.avatarEditor.setClickable(false);
            this.avatarEditor.setPadding(AndroidUtilities.dp(2.0f), 0, 0, AndroidUtilities.dp(1.0f));
            RLottieImageView rLottieImageView2 = this.avatarEditor;
            boolean z3 = LocaleController.isRTL;
            frameLayout.addView(rLottieImageView2, LayoutHelper.createFrame(64, 64.0f, (z3 ? 5 : 3) | 48, z3 ? 0.0f : 16.0f, 12.0f, z3 ? 16.0f : 0.0f, 12.0f));
            RadialProgressView radialProgressView = new RadialProgressView(context);
            this.avatarProgressView = radialProgressView;
            radialProgressView.setSize(AndroidUtilities.dp(30.0f));
            this.avatarProgressView.setProgressColor(-1);
            this.avatarProgressView.setNoProgress(false);
            RadialProgressView radialProgressView2 = this.avatarProgressView;
            boolean z4 = LocaleController.isRTL;
            frameLayout.addView(radialProgressView2, LayoutHelper.createFrame(64, 64.0f, (z4 ? 5 : 3) | 48, z4 ? 0.0f : 16.0f, 12.0f, z4 ? 16.0f : 0.0f, 12.0f));
            showAvatarProgress(false, false);
            EditTextEmoji editTextEmoji2 = new EditTextEmoji(context, sizeNotifierFrameLayout, this, 0);
            this.nameTextView = editTextEmoji2;
            editTextEmoji2.setHint(LocaleController.getString("EnterChannelName", R.string.EnterChannelName));
            String str = this.nameToSet;
            if (str != null) {
                this.nameTextView.setText(str);
                this.nameToSet = null;
            }
            this.nameTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
            this.nameTextView.getEditText().setSingleLine(true);
            this.nameTextView.getEditText().setImeOptions(5);
            this.nameTextView.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$aZsL4TCZpl9w3dHwoT7Utxzmpek
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$createView$6$ChannelCreateActivity(textView, i2, keyEvent);
                }
            });
            EditTextEmoji editTextEmoji3 = this.nameTextView;
            boolean z5 = LocaleController.isRTL;
            frameLayout.addView(editTextEmoji3, LayoutHelper.createFrame(-1, -2.0f, 16, z5 ? 5.0f : 96.0f, 0.0f, z5 ? 96.0f : 5.0f, 0.0f));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.descriptionTextView = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 18.0f);
            this.descriptionTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.descriptionTextView.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.descriptionTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.descriptionTextView.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.descriptionTextView.setPadding(0, 0, 0, AndroidUtilities.dp(6.0f));
            this.descriptionTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.descriptionTextView.setInputType(180225);
            this.descriptionTextView.setImeOptions(6);
            this.descriptionTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(R.styleable.AppCompatTheme_windowNoTitle)});
            this.descriptionTextView.setHint(LocaleController.getString("DescriptionPlaceholder", R.string.DescriptionPlaceholder));
            this.descriptionTextView.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.descriptionTextView.setCursorSize(AndroidUtilities.dp(20.0f));
            this.descriptionTextView.setCursorWidth(1.5f);
            this.linearLayout.addView(this.descriptionTextView, LayoutHelper.createLinear(-1, -2, 24.0f, 18.0f, 24.0f, 0.0f));
            this.descriptionTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$jEwd8emCQRcrVHcNk_HIHMSRseo
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$createView$7$ChannelCreateActivity(textView, i2, keyEvent);
                }
            });
            this.descriptionTextView.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ChannelCreateActivity.6
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                }
            });
            TextView textView = new TextView(context);
            this.helpTextView = textView;
            textView.setTextSize(1, 15.0f);
            this.helpTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.helpTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText8"));
            this.helpTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.helpTextView.setText(LocaleController.getString("DescriptionInfo", R.string.DescriptionInfo));
            this.linearLayout.addView(this.helpTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 24, 10, 24, 20));
        } else if (i == 1) {
            ScrollView scrollView = new ScrollView(context);
            this.fragmentView = scrollView;
            ScrollView scrollView2 = scrollView;
            scrollView2.setFillViewport(true);
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.linearLayout = linearLayout2;
            linearLayout2.setOrientation(1);
            scrollView2.addView(this.linearLayout, new FrameLayout.LayoutParams(-1, -2));
            this.actionBar.setTitle(LocaleController.getString("ChannelSettingsTitle", R.string.ChannelSettingsTitle));
            this.fragmentView.setTag("windowBackgroundGray");
            this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
            HeaderCell headerCell = new HeaderCell(context, 23);
            this.headerCell2 = headerCell;
            headerCell.setHeight(46);
            this.headerCell2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.headerCell2.setText(LocaleController.getString("ChannelTypeHeader", R.string.ChannelTypeHeader));
            this.linearLayout.addView(this.headerCell2);
            LinearLayout linearLayout3 = new LinearLayout(context);
            this.linearLayout2 = linearLayout3;
            linearLayout3.setOrientation(1);
            this.linearLayout2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.linearLayout.addView(this.linearLayout2, LayoutHelper.createLinear(-1, -2));
            RadioButtonCell radioButtonCell = new RadioButtonCell(context);
            this.radioButtonCell1 = radioButtonCell;
            radioButtonCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            this.radioButtonCell1.setTextAndValue(LocaleController.getString("ChannelPublic", R.string.ChannelPublic), LocaleController.getString("ChannelPublicInfo", R.string.ChannelPublicInfo), false, !this.isPrivate);
            this.linearLayout2.addView(this.radioButtonCell1, LayoutHelper.createLinear(-1, -2));
            this.radioButtonCell1.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$hLULSIyk3qPulvZtxiwa9IK7ct8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$8$ChannelCreateActivity(view2);
                }
            });
            RadioButtonCell radioButtonCell2 = new RadioButtonCell(context);
            this.radioButtonCell2 = radioButtonCell2;
            radioButtonCell2.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            this.radioButtonCell2.setTextAndValue(LocaleController.getString("ChannelPrivate", R.string.ChannelPrivate), LocaleController.getString("ChannelPrivateInfo", R.string.ChannelPrivateInfo), false, this.isPrivate);
            this.linearLayout2.addView(this.radioButtonCell2, LayoutHelper.createLinear(-1, -2));
            this.radioButtonCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$E9XcwuYjJGSAak-7We8qSS6wy3g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$9$ChannelCreateActivity(view2);
                }
            });
            ShadowSectionCell shadowSectionCell = new ShadowSectionCell(context);
            this.sectionCell = shadowSectionCell;
            this.linearLayout.addView(shadowSectionCell, LayoutHelper.createLinear(-1, -2));
            LinearLayout linearLayout4 = new LinearLayout(context);
            this.linkContainer = linearLayout4;
            linearLayout4.setOrientation(1);
            this.linkContainer.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.linearLayout.addView(this.linkContainer, LayoutHelper.createLinear(-1, -2));
            HeaderCell headerCell2 = new HeaderCell(context);
            this.headerCell = headerCell2;
            this.linkContainer.addView(headerCell2);
            LinearLayout linearLayout5 = new LinearLayout(context);
            this.publicContainer = linearLayout5;
            linearLayout5.setOrientation(0);
            this.linkContainer.addView(this.publicContainer, LayoutHelper.createLinear(-1, 36, 17.0f, 7.0f, 17.0f, 0.0f));
            EditTextBoldCursor editTextBoldCursor2 = new EditTextBoldCursor(context);
            this.editText = editTextBoldCursor2;
            editTextBoldCursor2.setText(MessagesController.getInstance(this.currentAccount).linkPrefix + "/");
            this.editText.setTextSize(1, 18.0f);
            this.editText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.editText.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.editText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.editText.setMaxLines(1);
            this.editText.setLines(1);
            this.editText.setEnabled(false);
            this.editText.setBackgroundDrawable(null);
            this.editText.setPadding(0, 0, 0, 0);
            this.editText.setSingleLine(true);
            this.editText.setInputType(163840);
            this.editText.setImeOptions(6);
            this.publicContainer.addView(this.editText, LayoutHelper.createLinear(-2, 36));
            EditTextBoldCursor editTextBoldCursor3 = new EditTextBoldCursor(context);
            this.descriptionTextView = editTextBoldCursor3;
            editTextBoldCursor3.setTextSize(1, 18.0f);
            this.descriptionTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.descriptionTextView.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.descriptionTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.descriptionTextView.setMaxLines(1);
            this.descriptionTextView.setLines(1);
            this.descriptionTextView.setBackgroundDrawable(null);
            this.descriptionTextView.setPadding(0, 0, 0, 0);
            this.descriptionTextView.setSingleLine(true);
            this.descriptionTextView.setInputType(163872);
            this.descriptionTextView.setImeOptions(6);
            this.descriptionTextView.setHint(LocaleController.getString("ChannelUsernamePlaceholder", R.string.ChannelUsernamePlaceholder));
            this.descriptionTextView.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.descriptionTextView.setCursorSize(AndroidUtilities.dp(20.0f));
            this.descriptionTextView.setCursorWidth(1.5f);
            this.publicContainer.addView(this.descriptionTextView, LayoutHelper.createLinear(-1, 36));
            this.descriptionTextView.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ChannelCreateActivity.7
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                    ChannelCreateActivity channelCreateActivity = ChannelCreateActivity.this;
                    channelCreateActivity.checkUserName(channelCreateActivity.descriptionTextView.getText().toString());
                }
            });
            LinearLayout linearLayout6 = new LinearLayout(context);
            this.privateContainer = linearLayout6;
            linearLayout6.setOrientation(1);
            this.linkContainer.addView(this.privateContainer, LayoutHelper.createLinear(-1, -2));
            LinkActionView linkActionView = new LinkActionView(context, this, null, this.chatId, true, ChatObject.isChannel(getMessagesController().getChat(Long.valueOf(this.chatId))));
            this.permanentLinkView = linkActionView;
            linkActionView.hideRevokeOption(true);
            this.permanentLinkView.setUsers(0, null);
            this.privateContainer.addView(this.permanentLinkView);
            TextView textView2 = new TextView(context);
            this.checkTextView = textView2;
            textView2.setTextSize(1, 15.0f);
            this.checkTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.checkTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.checkTextView.setVisibility(8);
            this.linkContainer.addView(this.checkTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 17, 3, 17, 7));
            TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
            this.typeInfoCell = textInfoPrivacyCell;
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.linearLayout.addView(this.typeInfoCell, LayoutHelper.createLinear(-1, -2));
            LoadingCell loadingCell = new LoadingCell(context);
            this.loadingAdminedCell = loadingCell;
            this.linearLayout.addView(loadingCell, LayoutHelper.createLinear(-1, -2));
            LinearLayout linearLayout7 = new LinearLayout(context);
            this.adminnedChannelsLayout = linearLayout7;
            linearLayout7.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.adminnedChannelsLayout.setOrientation(1);
            this.linearLayout.addView(this.adminnedChannelsLayout, LayoutHelper.createLinear(-1, -2));
            TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
            this.adminedInfoCell = textInfoPrivacyCell2;
            textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.linearLayout.addView(this.adminedInfoCell, LayoutHelper.createLinear(-1, -2));
            updatePrivatePublic();
        }
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.ChannelCreateActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            if (id == -1) {
                ChannelCreateActivity.this.finishFragment();
                return;
            }
            if (id == 1) {
                if (ChannelCreateActivity.this.currentStep == 0) {
                    if (ChannelCreateActivity.this.donePressed || ChannelCreateActivity.this.getParentActivity() == null) {
                        return;
                    }
                    if (ChannelCreateActivity.this.nameTextView.length() != 0) {
                        ChannelCreateActivity.this.donePressed = true;
                        if (ChannelCreateActivity.this.imageUpdater.isUploadingImage()) {
                            ChannelCreateActivity.this.createAfterUpload = true;
                            ChannelCreateActivity.this.progressDialog = new AlertDialog(ChannelCreateActivity.this.getParentActivity(), 3);
                            ChannelCreateActivity.this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$1$23RPehBGIhx9KTz53SFUubaUUZQ
                                @Override // android.content.DialogInterface.OnCancelListener
                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.f$0.lambda$onItemClick$0$ChannelCreateActivity$1(dialogInterface);
                                }
                            });
                            ChannelCreateActivity.this.progressDialog.show();
                            return;
                        }
                        final int iCreateChat = MessagesController.getInstance(((BaseFragment) ChannelCreateActivity.this).currentAccount).createChat(ChannelCreateActivity.this.nameTextView.getText().toString(), new ArrayList<>(), ChannelCreateActivity.this.descriptionTextView.getText().toString(), 2, false, null, null, ChannelCreateActivity.this);
                        ChannelCreateActivity.this.progressDialog = new AlertDialog(ChannelCreateActivity.this.getParentActivity(), 3);
                        ChannelCreateActivity.this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$1$do4Lpmofq691MMVYw4xAGxp2xRc
                            @Override // android.content.DialogInterface.OnCancelListener
                            public final void onCancel(DialogInterface dialogInterface) {
                                this.f$0.lambda$onItemClick$1$ChannelCreateActivity$1(iCreateChat, dialogInterface);
                            }
                        });
                        ChannelCreateActivity.this.progressDialog.show();
                        return;
                    }
                    Vibrator vibrator = (Vibrator) ChannelCreateActivity.this.getParentActivity().getSystemService("vibrator");
                    if (vibrator != null) {
                        vibrator.vibrate(200L);
                    }
                    AndroidUtilities.shakeView(ChannelCreateActivity.this.nameTextView, 2.0f, 0);
                    return;
                }
                if (ChannelCreateActivity.this.currentStep == 1) {
                    if (!ChannelCreateActivity.this.isPrivate) {
                        if (ChannelCreateActivity.this.descriptionTextView.length() != 0) {
                            if (ChannelCreateActivity.this.lastNameAvailable) {
                                MessagesController.getInstance(((BaseFragment) ChannelCreateActivity.this).currentAccount).updateChannelUserName(ChannelCreateActivity.this.chatId, ChannelCreateActivity.this.lastCheckName);
                            } else {
                                Vibrator vibrator2 = (Vibrator) ChannelCreateActivity.this.getParentActivity().getSystemService("vibrator");
                                if (vibrator2 != null) {
                                    vibrator2.vibrate(200L);
                                }
                                AndroidUtilities.shakeView(ChannelCreateActivity.this.checkTextView, 2.0f, 0);
                                return;
                            }
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(ChannelCreateActivity.this.getParentActivity());
                            builder.setTitle(LocaleController.getString("ChannelPublicEmptyUsernameTitle", R.string.ChannelPublicEmptyUsernameTitle));
                            builder.setMessage(LocaleController.getString("ChannelPublicEmptyUsername", R.string.ChannelPublicEmptyUsername));
                            builder.setPositiveButton(LocaleController.getString("Close", R.string.Close), null);
                            ChannelCreateActivity.this.showDialog(builder.create());
                            return;
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("step", 2);
                    bundle.putLong("chatId", ChannelCreateActivity.this.chatId);
                    bundle.putInt("chatType", 2);
                    ChannelCreateActivity.this.presentFragment(new GroupCreateActivity(bundle), true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$ChannelCreateActivity$1(DialogInterface dialogInterface) {
            ChannelCreateActivity.this.createAfterUpload = false;
            ChannelCreateActivity.this.progressDialog = null;
            ChannelCreateActivity.this.donePressed = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$ChannelCreateActivity$1(int i, DialogInterface dialogInterface) {
            ConnectionsManager.getInstance(((BaseFragment) ChannelCreateActivity.this).currentAccount).cancelRequest(i, true);
            ChannelCreateActivity.this.donePressed = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ChannelCreateActivity(View view) {
        this.imageUpdater.openMenu(this.avatar != null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$_69CnWtM9lUxFm8fqmxGpcjgnKY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$3$ChannelCreateActivity();
            }
        }, new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$stz1tIbKSmrmh7C4jzMUPrqHx5c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) throws InterruptedException {
                this.f$0.lambda$createView$4$ChannelCreateActivity(dialogInterface);
            }
        });
        this.cameraDrawable.setCurrentFrame(0);
        this.cameraDrawable.setCustomEndFrame(43);
        this.avatarEditor.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ChannelCreateActivity() {
        this.avatar = null;
        this.avatarBig = null;
        this.inputPhoto = null;
        this.inputVideo = null;
        this.inputVideoPath = null;
        this.videoTimestamp = 0.0d;
        showAvatarProgress(false, true);
        this.avatarImage.setImage((ImageLocation) null, (String) null, this.avatarDrawable, (Object) null);
        this.avatarEditor.setAnimation(this.cameraDrawable);
        this.cameraDrawable.setCurrentFrame(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ChannelCreateActivity(DialogInterface dialogInterface) throws InterruptedException {
        if (!this.imageUpdater.isUploadingImage()) {
            this.cameraDrawable.setCustomEndFrame(86);
            this.avatarEditor.playAnimation();
        } else {
            this.cameraDrawable.setCurrentFrame(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$6$ChannelCreateActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 || TextUtils.isEmpty(this.nameTextView.getEditText().getText())) {
            return false;
        }
        this.descriptionTextView.requestFocus();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$7$ChannelCreateActivity(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        if (i != 6 || (view = this.doneButton) == null) {
            return false;
        }
        view.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$ChannelCreateActivity(View view) {
        if (this.isPrivate) {
            this.isPrivate = false;
            updatePrivatePublic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$ChannelCreateActivity(View view) {
        if (this.isPrivate) {
            return;
        }
        this.isPrivate = true;
        updatePrivatePublic();
    }

    private void generateLink() {
        if (this.loadingInvite || this.invite != null) {
            return;
        }
        TLRPC$ChatFull chatFull = getMessagesController().getChatFull(this.chatId);
        if (chatFull != null) {
            this.invite = chatFull.exported_invite;
        }
        if (this.invite != null) {
            return;
        }
        this.loadingInvite = true;
        TLRPC$TL_channels_exportInvite tLRPC$TL_channels_exportInvite = new TLRPC$TL_channels_exportInvite();
        tLRPC$TL_channels_exportInvite.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(this.chatId);
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_exportInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$4nnGItE5Gr1OKgQ4I601bT3dNPo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateLink$11$ChannelCreateActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateLink$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateLink$11$ChannelCreateActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$tWYhFlbmnu4lwD1tttoZBIJobBQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateLink$10$ChannelCreateActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateLink$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateLink$10$ChannelCreateActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.invite = (TLRPC$ExportedChatInvite) tLObject;
        }
        this.loadingInvite = false;
        LinkActionView linkActionView = this.permanentLinkView;
        TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = this.invite;
        linkActionView.setLink(tLRPC$ExportedChatInvite != null ? tLRPC$ExportedChatInvite.link : null);
    }

    private void updatePrivatePublic() {
        int i;
        String str;
        int i2;
        String str2;
        if (this.sectionCell == null) {
            return;
        }
        int i3 = 8;
        if (!this.isPrivate && !this.canCreatePublic) {
            this.typeInfoCell.setText(LocaleController.getString("ChangePublicLimitReached", R.string.ChangePublicLimitReached));
            this.typeInfoCell.setTag("windowBackgroundWhiteRedText4");
            this.typeInfoCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            this.linkContainer.setVisibility(8);
            this.sectionCell.setVisibility(8);
            if (this.loadingAdminedChannels) {
                this.loadingAdminedCell.setVisibility(0);
                this.adminnedChannelsLayout.setVisibility(8);
                TextInfoPrivacyCell textInfoPrivacyCell = this.typeInfoCell;
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                this.adminedInfoCell.setVisibility(8);
            } else {
                TextInfoPrivacyCell textInfoPrivacyCell2 = this.typeInfoCell;
                textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell2.getContext(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
                this.loadingAdminedCell.setVisibility(8);
                this.adminnedChannelsLayout.setVisibility(0);
                this.adminedInfoCell.setVisibility(0);
            }
        } else {
            this.typeInfoCell.setTag("windowBackgroundWhiteGrayText4");
            this.typeInfoCell.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
            this.sectionCell.setVisibility(0);
            this.adminedInfoCell.setVisibility(8);
            this.adminnedChannelsLayout.setVisibility(8);
            TextInfoPrivacyCell textInfoPrivacyCell3 = this.typeInfoCell;
            textInfoPrivacyCell3.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell3.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.linkContainer.setVisibility(0);
            this.loadingAdminedCell.setVisibility(8);
            TextInfoPrivacyCell textInfoPrivacyCell4 = this.typeInfoCell;
            if (this.isPrivate) {
                i = R.string.ChannelPrivateLinkHelp;
                str = "ChannelPrivateLinkHelp";
            } else {
                i = R.string.ChannelUsernameHelp;
                str = "ChannelUsernameHelp";
            }
            textInfoPrivacyCell4.setText(LocaleController.getString(str, i));
            HeaderCell headerCell = this.headerCell;
            if (this.isPrivate) {
                i2 = R.string.ChannelInviteLinkTitle;
                str2 = "ChannelInviteLinkTitle";
            } else {
                i2 = R.string.ChannelLinkTitle;
                str2 = "ChannelLinkTitle";
            }
            headerCell.setText(LocaleController.getString(str2, i2));
            this.publicContainer.setVisibility(this.isPrivate ? 8 : 0);
            this.privateContainer.setVisibility(this.isPrivate ? 0 : 8);
            this.linkContainer.setPadding(0, 0, 0, this.isPrivate ? 0 : AndroidUtilities.dp(7.0f));
            LinkActionView linkActionView = this.permanentLinkView;
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = this.invite;
            linkActionView.setLink(tLRPC$ExportedChatInvite != null ? tLRPC$ExportedChatInvite.link : null);
            TextView textView = this.checkTextView;
            if (!this.isPrivate && textView.length() != 0) {
                i3 = 0;
            }
            textView.setVisibility(i3);
        }
        this.radioButtonCell1.setChecked(!this.isPrivate, true);
        this.radioButtonCell2.setChecked(this.isPrivate, true);
        this.descriptionTextView.clearFocus();
        AndroidUtilities.hideKeyboard(this.descriptionTextView);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void onUploadProgressChanged(float progress) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(progress);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didStartUpload(boolean isVideo) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(0.0f);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didUploadPhoto(final TLRPC$InputFile photo, final TLRPC$InputFile video, final double videoStartTimestamp, final String videoPath, final TLRPC$PhotoSize bigSize, final TLRPC$PhotoSize smallSize) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$mAGiQcaQYc9blVz0H3Ef4jWadRE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$12$ChannelCreateActivity(photo, video, videoPath, videoStartTimestamp, smallSize, bigSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didUploadPhoto$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didUploadPhoto$12$ChannelCreateActivity(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, String str, double d, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
        if (tLRPC$InputFile != null || tLRPC$InputFile2 != null) {
            this.inputPhoto = tLRPC$InputFile;
            this.inputVideo = tLRPC$InputFile2;
            this.inputVideoPath = str;
            this.videoTimestamp = d;
            if (this.createAfterUpload) {
                try {
                    AlertDialog alertDialog = this.progressDialog;
                    if (alertDialog != null && alertDialog.isShowing()) {
                        this.progressDialog.dismiss();
                        this.progressDialog = null;
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.donePressed = false;
                this.doneButton.performClick();
            }
            showAvatarProgress(false, true);
            return;
        }
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
        this.avatar = tLRPC$FileLocation;
        this.avatarBig = tLRPC$PhotoSize2.location;
        this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", this.avatarDrawable, (Object) null);
        showAvatarProgress(true, false);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public String getInitialSearchString() {
        return this.nameTextView.getText().toString();
    }

    private void showAvatarProgress(final boolean show, boolean animated) {
        if (this.avatarEditor == null) {
            return;
        }
        AnimatorSet animatorSet = this.avatarAnimation;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.avatarAnimation.cancel();
            this.avatarAnimation = null;
        }
        if (!animated) {
            if (show) {
                this.avatarEditor.setAlpha(1.0f);
                this.avatarEditor.setVisibility(4);
                this.avatarProgressView.setAlpha(1.0f);
                this.avatarProgressView.setVisibility(0);
                return;
            }
            this.avatarEditor.setAlpha(1.0f);
            this.avatarEditor.setVisibility(0);
            this.avatarProgressView.setAlpha(0.0f);
            this.avatarProgressView.setVisibility(4);
            return;
        }
        this.avatarAnimation = new AnimatorSet();
        if (show) {
            this.avatarProgressView.setVisibility(0);
            this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarEditor, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
        } else {
            if (this.avatarEditor.getVisibility() != 0) {
                this.avatarEditor.setAlpha(0.0f);
            }
            this.avatarEditor.setVisibility(0);
            this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarEditor, (Property<RLottieImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f));
        }
        this.avatarAnimation.setDuration(180L);
        this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChannelCreateActivity.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ChannelCreateActivity.this.avatarAnimation == null || ChannelCreateActivity.this.avatarEditor == null) {
                    return;
                }
                if (show) {
                    ChannelCreateActivity.this.avatarEditor.setVisibility(4);
                } else {
                    ChannelCreateActivity.this.avatarProgressView.setVisibility(4);
                }
                ChannelCreateActivity.this.avatarAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                ChannelCreateActivity.this.avatarAnimation = null;
            }
        });
        this.avatarAnimation.start();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) throws InterruptedException, Resources.NotFoundException {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle args) {
        String str;
        if (this.currentStep == 0) {
            ImageUpdater imageUpdater = this.imageUpdater;
            if (imageUpdater != null && (str = imageUpdater.currentPicturePath) != null) {
                args.putString("path", str);
            }
            EditTextEmoji editTextEmoji = this.nameTextView;
            if (editTextEmoji != null) {
                String string = editTextEmoji.getText().toString();
                if (string.length() != 0) {
                    args.putString("nameTextView", string);
                }
            }
        }
    }

    public void restoreSelfArgs(Bundle args) {
        if (this.currentStep == 0) {
            ImageUpdater imageUpdater = this.imageUpdater;
            if (imageUpdater != null) {
                imageUpdater.currentPicturePath = args.getString("path");
            }
            String string = args.getString("nameTextView");
            if (string != null) {
                EditTextEmoji editTextEmoji = this.nameTextView;
                if (editTextEmoji != null) {
                    editTextEmoji.setText(string);
                } else {
                    this.nameToSet = string;
                }
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (!isOpen || this.currentStep == 1) {
            return;
        }
        this.nameTextView.requestFocus();
        this.nameTextView.openKeyboard();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.chatDidFailCreate) {
            AlertDialog alertDialog = this.progressDialog;
            if (alertDialog != null) {
                try {
                    alertDialog.dismiss();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            this.donePressed = false;
            return;
        }
        if (id == NotificationCenter.chatDidCreated) {
            AlertDialog alertDialog2 = this.progressDialog;
            if (alertDialog2 != null) {
                try {
                    alertDialog2.dismiss();
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            long jLongValue = ((Long) args[0]).longValue();
            Bundle bundle = new Bundle();
            bundle.putInt("step", 1);
            bundle.putLong("chat_id", jLongValue);
            bundle.putBoolean("canCreatePublic", this.canCreatePublic);
            if (this.inputPhoto != null || this.inputVideo != null) {
                MessagesController.getInstance(this.currentAccount).changeChatAvatar(jLongValue, null, this.inputPhoto, this.inputVideo, this.videoTimestamp, this.inputVideoPath, this.avatar, this.avatarBig, null);
            }
            presentFragment(new ChannelCreateActivity(bundle), true);
        }
    }

    private void loadAdminedChannels() {
        if (this.loadingAdminedChannels) {
            return;
        }
        this.loadingAdminedChannels = true;
        updatePrivatePublic();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_channels_getAdminedPublicChannels(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$rbMzP1o5GTJnSBA3rJAl5oCEKeU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$18$ChannelCreateActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$18$ChannelCreateActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$ZEJ8boj-dES8ljyH4Vhd-22WEo0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAdminedChannels$17$ChannelCreateActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$17$ChannelCreateActivity(TLObject tLObject) {
        this.loadingAdminedChannels = false;
        if (tLObject == null || getParentActivity() == null) {
            return;
        }
        for (int i = 0; i < this.adminedChannelCells.size(); i++) {
            this.linearLayout.removeView(this.adminedChannelCells.get(i));
        }
        this.adminedChannelCells.clear();
        TLRPC$TL_messages_chats tLRPC$TL_messages_chats = (TLRPC$TL_messages_chats) tLObject;
        for (int i2 = 0; i2 < tLRPC$TL_messages_chats.chats.size(); i2++) {
            AdminedChannelCell adminedChannelCell = new AdminedChannelCell(getParentActivity(), new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$l3CYuUKQTb8g1Ms-nssLpvjZxcc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$loadAdminedChannels$16$ChannelCreateActivity(view);
                }
            });
            TLRPC$Chat tLRPC$Chat = tLRPC$TL_messages_chats.chats.get(i2);
            boolean z = true;
            if (i2 != tLRPC$TL_messages_chats.chats.size() - 1) {
                z = false;
            }
            adminedChannelCell.setChannel(tLRPC$Chat, z);
            this.adminedChannelCells.add(adminedChannelCell);
            this.adminnedChannelsLayout.addView(adminedChannelCell, LayoutHelper.createLinear(-1, 72));
        }
        updatePrivatePublic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$16$ChannelCreateActivity(View view) {
        final TLRPC$Chat currentChannel = ((AdminedChannelCell) view.getParent()).getCurrentChannel();
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (currentChannel.megagroup) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlert", R.string.RevokeLinkAlert, MessagesController.getInstance(this.currentAccount).linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlertChannel", R.string.RevokeLinkAlertChannel, MessagesController.getInstance(this.currentAccount).linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        }
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$1p3MojZVJfW7kIAbz6XI7s7ZJWE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$loadAdminedChannels$15$ChannelCreateActivity(currentChannel, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$15$ChannelCreateActivity(TLRPC$Chat tLRPC$Chat, DialogInterface dialogInterface, int i) {
        TLRPC$TL_channels_updateUsername tLRPC$TL_channels_updateUsername = new TLRPC$TL_channels_updateUsername();
        tLRPC$TL_channels_updateUsername.channel = MessagesController.getInputChannel(tLRPC$Chat);
        tLRPC$TL_channels_updateUsername.username = "";
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_updateUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$O3TSq5iTlFZoiZBcjCfdD3Dc_Qw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$14$ChannelCreateActivity(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$14$ChannelCreateActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$iWAXQrcaFkrhEjs7xdnOKKGhCnw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadAdminedChannels$13$ChannelCreateActivity();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$13$ChannelCreateActivity() {
        this.canCreatePublic = true;
        if (this.descriptionTextView.length() > 0) {
            checkUserName(this.descriptionTextView.getText().toString());
        }
        updatePrivatePublic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUserName(final String name) {
        if (name != null && name.length() > 0) {
            this.checkTextView.setVisibility(0);
        } else {
            this.checkTextView.setVisibility(8);
        }
        Runnable runnable = this.checkRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.checkRunnable = null;
            this.lastCheckName = null;
            if (this.checkReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.checkReqId, true);
            }
        }
        this.lastNameAvailable = false;
        if (name != null) {
            if (name.startsWith("_") || name.endsWith("_")) {
                this.checkTextView.setText(LocaleController.getString("LinkInvalid", R.string.LinkInvalid));
                this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
                return false;
            }
            for (int i = 0; i < name.length(); i++) {
                char cCharAt = name.charAt(i);
                if (i == 0 && cCharAt >= '0' && cCharAt <= '9') {
                    this.checkTextView.setText(LocaleController.getString("LinkInvalidStartNumber", R.string.LinkInvalidStartNumber));
                    this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                    this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
                    return false;
                }
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != '_'))) {
                    this.checkTextView.setText(LocaleController.getString("LinkInvalid", R.string.LinkInvalid));
                    this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                    this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
                    return false;
                }
            }
        }
        if (name == null || name.length() < 5) {
            this.checkTextView.setText(LocaleController.getString("LinkInvalidShort", R.string.LinkInvalidShort));
            this.checkTextView.setTag("windowBackgroundWhiteRedText4");
            this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            return false;
        }
        if (name.length() > 32) {
            this.checkTextView.setText(LocaleController.getString("LinkInvalidLong", R.string.LinkInvalidLong));
            this.checkTextView.setTag("windowBackgroundWhiteRedText4");
            this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            return false;
        }
        this.checkTextView.setText(LocaleController.getString("LinkChecking", R.string.LinkChecking));
        this.checkTextView.setTag("windowBackgroundWhiteGrayText8");
        this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText8"));
        this.lastCheckName = name;
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$KpzuKArU0rMeLbd98s4SXFQounw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$21$ChannelCreateActivity(name);
            }
        };
        this.checkRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 300L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$21$ChannelCreateActivity(final String str) {
        TLRPC$TL_channels_checkUsername tLRPC$TL_channels_checkUsername = new TLRPC$TL_channels_checkUsername();
        tLRPC$TL_channels_checkUsername.username = str;
        tLRPC$TL_channels_checkUsername.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(this.chatId);
        this.checkReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_checkUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$K6SWBe81e3nBnsj5meShqfk7Ebs
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUserName$20$ChannelCreateActivity(str, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$20$ChannelCreateActivity(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$nYzSpEZOPKUblWeZ78Ypd9OGx4c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$19$ChannelCreateActivity(str, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$19$ChannelCreateActivity(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            this.checkTextView.setText(LocaleController.formatString("LinkAvailable", R.string.LinkAvailable, str));
            this.checkTextView.setTag("windowBackgroundWhiteGreenText");
            this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGreenText"));
            this.lastNameAvailable = true;
            return;
        }
        if (tLRPC$TL_error != null && tLRPC$TL_error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH")) {
            this.canCreatePublic = false;
            loadAdminedChannels();
        } else {
            this.checkTextView.setText(LocaleController.getString("LinkInUse", R.string.LinkInUse));
        }
        this.checkTextView.setTag("windowBackgroundWhiteRedText4");
        this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
        this.lastNameAvailable = false;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelCreateActivity$9f3lW8qNgpkYscqwMzQkixvgKME
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$22$ChannelCreateActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.helpTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText8"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linkContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.sectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.headerCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.headerCell2, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhiteGrayText8"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhiteGreenText"));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.adminedInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.privateContainer, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.privateContainer, 0, new Class[]{TextBlockCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.loadingAdminedCell, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_LINKCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"deleteButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$22$ChannelCreateActivity() {
        LinearLayout linearLayout = this.adminnedChannelsLayout;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.adminnedChannelsLayout.getChildAt(i);
                if (childAt instanceof AdminedChannelCell) {
                    ((AdminedChannelCell) childAt).update();
                }
            }
        }
    }
}
