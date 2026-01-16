package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputUserEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_chatInviteImporters;
import ir.eitaa.tgnet.TLRPC$TL_messages_getChatInviteImporters;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.DialogCell;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LinkActionView extends LinearLayout {
    private ActionBarPopupWindow actionBarPopupWindow;
    private final AvatarsContainer avatarsContainer;
    private boolean canEdit;
    private final TextView copyView;
    private Delegate delegate;
    BaseFragment fragment;
    private final FrameLayout frameLayout;
    private boolean hideRevokeOption;
    private boolean isChannel;
    String link;
    TextView linkView;
    boolean loadingImporters;
    ImageView optionsView;
    private boolean permanent;
    float[] point;
    private QRCodeBottomSheet qrCodeBottomSheet;
    private final TextView removeView;
    private boolean revoked;
    private final TextView shareView;
    private int usersCount;

    public interface Delegate {

        /* renamed from: ir.eitaa.ui.Components.LinkActionView$Delegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$editLink(Delegate delegate) {
            }

            public static void $default$removeLink(Delegate delegate) {
            }

            public static void $default$showUsersForPermanentLink(Delegate delegate) {
            }
        }

        void editLink();

        void removeLink();

        void revokeLink();

        void showUsersForPermanentLink();
    }

    public LinkActionView(final Context context, final BaseFragment fragment, final BottomSheet bottomSheet, long chatId, boolean permanent, boolean isChannel) {
        super(context);
        this.canEdit = true;
        this.point = new float[2];
        this.fragment = fragment;
        this.permanent = permanent;
        this.isChannel = isChannel;
        setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        TextView textView = new TextView(context);
        this.linkView = textView;
        textView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(18.0f), AndroidUtilities.dp(40.0f), AndroidUtilities.dp(18.0f));
        this.linkView.setTextSize(1, 16.0f);
        this.linkView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.linkView.setSingleLine(true);
        frameLayout.addView(this.linkView);
        ImageView imageView = new ImageView(context);
        this.optionsView = imageView;
        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_ab_other));
        this.optionsView.setScaleType(ImageView.ScaleType.CENTER);
        frameLayout.addView(this.optionsView, LayoutHelper.createFrame(40, 48, 21));
        addView(frameLayout, LayoutHelper.createLinear(-1, -2, 0, 4, 0, 4, 0));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        TextView textView2 = new TextView(context);
        this.copyView = textView2;
        textView2.setGravity(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_copy_filled)), 0, 1, 0);
        spannableStringBuilder.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder.append((CharSequence) LocaleController.getString("LinkActionCopy", R.string.LinkActionCopy));
        spannableStringBuilder.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 0);
        textView2.setText(spannableStringBuilder);
        textView2.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setSingleLine(true);
        linearLayout.addView(textView2, LayoutHelper.createLinear(0, 40, 1.0f, 0, 4, 0, 4, 0));
        TextView textView3 = new TextView(context);
        this.shareView = textView3;
        textView3.setGravity(1);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_share_filled)), 0, 1, 0);
        spannableStringBuilder2.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder2.append((CharSequence) LocaleController.getString("LinkActionShare", R.string.LinkActionShare));
        spannableStringBuilder2.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 0);
        textView3.setText(spannableStringBuilder2);
        textView3.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView3.setTextSize(1, 14.0f);
        textView3.setTypeface(AndroidUtilities.getFontFamily(true));
        textView3.setSingleLine(true);
        linearLayout.addView(textView3, LayoutHelper.createLinear(0, 40, 1.0f, 4, 0, 4, 0));
        TextView textView4 = new TextView(context);
        this.removeView = textView4;
        textView4.setGravity(1);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        spannableStringBuilder3.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_delete_filled)), 0, 1, 0);
        spannableStringBuilder3.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder3.append((CharSequence) LocaleController.getString("DeleteLink", R.string.DeleteLink));
        spannableStringBuilder3.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder3.length() - 1, spannableStringBuilder3.length(), 0);
        textView4.setText(spannableStringBuilder3);
        textView4.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView4.setTextSize(1, 14.0f);
        textView4.setTypeface(AndroidUtilities.getFontFamily(true));
        textView4.setSingleLine(true);
        linearLayout.addView(textView4, LayoutHelper.createLinear(0, -2, 1.0f, 4, 0, 4, 0));
        textView4.setVisibility(8);
        addView(linearLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
        AvatarsContainer avatarsContainer = new AvatarsContainer(context);
        this.avatarsContainer = avatarsContainer;
        addView(avatarsContainer, LayoutHelper.createLinear(-1, 44, 0.0f, 12.0f, 0.0f, 0.0f));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$OWbsPpOwmmuKrnxoroknFnrhG_k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$LinkActionView(bottomSheet, fragment, view);
            }
        });
        if (permanent) {
            avatarsContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$HCUrzsdVZTGQkd8wZrtc-HDiOko
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$LinkActionView(view);
                }
            });
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$vezgorE-kUYLWeJL3rjACb1Pyzc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$LinkActionView(fragment, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$uM53lPdURDlJBc6zXWxqk-3q6MQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$4$LinkActionView(fragment, view);
            }
        });
        this.optionsView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$yOdV8EDY1yG5CuKKz5XzdMNJbGs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$9$LinkActionView(context, bottomSheet, fragment, view);
            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.LinkActionView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LinkActionView.this.copyView.callOnClick();
            }
        });
        updateColors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$LinkActionView(BottomSheet bottomSheet, BaseFragment baseFragment, View view) {
        try {
            if (this.link == null) {
                return;
            }
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.link));
            if (bottomSheet != null && bottomSheet.getContainer() != null) {
                BulletinFactory.createCopyLinkBulletin(bottomSheet.getContainer()).show();
            } else {
                BulletinFactory.createCopyLinkBulletin(baseFragment).show();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$LinkActionView(View view) {
        this.delegate.showUsersForPermanentLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$LinkActionView(BaseFragment baseFragment, View view) {
        try {
            if (this.link == null) {
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.link);
            baseFragment.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("InviteToGroupByLink", R.string.InviteToGroupByLink)), 500);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$LinkActionView(BaseFragment baseFragment, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("DeleteLink", R.string.DeleteLink));
        builder.setMessage(LocaleController.getString("DeleteLinkHelp", R.string.DeleteLinkHelp));
        builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$J2R3aj8shM0Tq-UUk2MPhW6QekI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$new$3$LinkActionView(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$LinkActionView(DialogInterface dialogInterface, int i) {
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.removeLink();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$9$LinkActionView(Context context, BottomSheet bottomSheet, BaseFragment baseFragment, View view) {
        final FrameLayout container;
        if (this.actionBarPopupWindow != null) {
            return;
        }
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(context);
        if (!this.permanent && this.canEdit) {
            ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(context, true, false);
            actionBarMenuSubItem.setTextAndIcon(LocaleController.getString("Edit", R.string.Edit), R.drawable.msg_edit);
            actionBarPopupWindowLayout.addView((View) actionBarMenuSubItem, LayoutHelper.createLinear(-1, 48));
            actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$HSGLof7AFXl4WqaJ7C3-oqm3Huw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$5$LinkActionView(view2);
                }
            });
        }
        ActionBarMenuSubItem actionBarMenuSubItem2 = new ActionBarMenuSubItem(context, true, false);
        actionBarMenuSubItem2.setTextAndIcon(LocaleController.getString("GetQRCode", R.string.GetQRCode), R.drawable.msg_qrcode);
        actionBarPopupWindowLayout.addView((View) actionBarMenuSubItem2, LayoutHelper.createLinear(-1, 48));
        actionBarMenuSubItem2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$RJRFAvl5LFP_2QSUKmca96upbq0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$6$LinkActionView(view2);
            }
        });
        if (!this.hideRevokeOption) {
            ActionBarMenuSubItem actionBarMenuSubItem3 = new ActionBarMenuSubItem(context, false, true);
            actionBarMenuSubItem3.setTextAndIcon(LocaleController.getString("RevokeLink", R.string.RevokeLink), R.drawable.msg_delete);
            actionBarMenuSubItem3.setColors(Theme.getColor("windowBackgroundWhiteRedText"), Theme.getColor("windowBackgroundWhiteRedText"));
            actionBarMenuSubItem3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$_PEVe2QG0Ly6BeOxyzgU55228d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$7$LinkActionView(view2);
                }
            });
            actionBarPopupWindowLayout.addView((View) actionBarMenuSubItem3, LayoutHelper.createLinear(-1, 48));
        }
        if (bottomSheet == null) {
            container = baseFragment.getParentLayout();
        } else {
            container = bottomSheet.getContainer();
        }
        if (container != null) {
            getPointOnScreen(this.frameLayout, container, this.point);
            float paddingTop = this.point[1];
            final View view2 = new View(context) { // from class: ir.eitaa.ui.Components.LinkActionView.1
                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    canvas.drawColor(855638016);
                    LinkActionView linkActionView = LinkActionView.this;
                    linkActionView.getPointOnScreen(linkActionView.frameLayout, container, LinkActionView.this.point);
                    canvas.save();
                    float y = ((View) LinkActionView.this.frameLayout.getParent()).getY() + LinkActionView.this.frameLayout.getY();
                    if (y < 1.0f) {
                        canvas.clipRect(0.0f, (LinkActionView.this.point[1] - y) + 1.0f, getMeasuredWidth(), getMeasuredHeight());
                    }
                    float[] fArr = LinkActionView.this.point;
                    canvas.translate(fArr[0], fArr[1]);
                    LinkActionView.this.frameLayout.draw(canvas);
                    canvas.restore();
                }
            };
            final ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.LinkActionView.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    view2.invalidate();
                    return true;
                }
            };
            container.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
            container.addView(view2, LayoutHelper.createFrame(-1, -1.0f));
            float paddingLeft = 0.0f;
            view2.setAlpha(0.0f);
            view2.animate().alpha(1.0f).setDuration(150L);
            actionBarPopupWindowLayout.measure(View.MeasureSpec.makeMeasureSpec(container.getMeasuredWidth(), 0), View.MeasureSpec.makeMeasureSpec(container.getMeasuredHeight(), 0));
            ActionBarPopupWindow actionBarPopupWindow = new ActionBarPopupWindow(actionBarPopupWindowLayout, -2, -2);
            this.actionBarPopupWindow = actionBarPopupWindow;
            actionBarPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.eitaa.ui.Components.LinkActionView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    LinkActionView.this.actionBarPopupWindow = null;
                    view2.animate().cancel();
                    view2.animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.LinkActionView.3.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (view2.getParent() != null) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                container.removeView(view2);
                            }
                            container.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
                        }
                    });
                }
            });
            this.actionBarPopupWindow.setOutsideTouchable(true);
            this.actionBarPopupWindow.setFocusable(true);
            this.actionBarPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.actionBarPopupWindow.setAnimationStyle(R.style.PopupContextAnimation);
            this.actionBarPopupWindow.setInputMethodMode(2);
            this.actionBarPopupWindow.setSoftInputMode(0);
            actionBarPopupWindowLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$lIKo3OvNo8BlCc0t-z0-ELcahBQ
                @Override // ir.eitaa.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.f$0.lambda$new$8$LinkActionView(keyEvent);
                }
            });
            if (AndroidUtilities.isTablet()) {
                paddingTop += container.getPaddingTop();
                paddingLeft = 0.0f - container.getPaddingLeft();
            }
            this.actionBarPopupWindow.showAtLocation(container, 0, (int) (((container.getMeasuredWidth() - actionBarPopupWindowLayout.getMeasuredWidth()) - AndroidUtilities.dp(16.0f)) + container.getX() + paddingLeft), (int) (paddingTop + this.frameLayout.getMeasuredHeight() + container.getY()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$LinkActionView(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.actionBarPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        this.delegate.editLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$LinkActionView(View view) {
        showQrCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$7$LinkActionView(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.actionBarPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        revokeLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$8$LinkActionView(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && this.actionBarPopupWindow.isShowing()) {
            this.actionBarPopupWindow.dismiss(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.View] */
    public void getPointOnScreen(FrameLayout frameLayout, FrameLayout finalContainer, float[] point) {
        float x = 0.0f;
        float y = 0.0f;
        while (frameLayout != finalContainer) {
            y += frameLayout.getY();
            x += frameLayout.getX();
            if (frameLayout instanceof ScrollView) {
                y -= frameLayout.getScrollY();
            }
            frameLayout = (View) frameLayout.getParent();
            if (!(frameLayout instanceof ViewGroup)) {
                return;
            }
        }
        point[0] = x - finalContainer.getPaddingLeft();
        point[1] = y - finalContainer.getPaddingTop();
    }

    private void showQrCode() {
        int i;
        String str;
        Context context = getContext();
        String str2 = this.link;
        if (this.isChannel) {
            i = R.string.QRCodeLinkHelpChannel;
            str = "QRCodeLinkHelpChannel";
        } else {
            i = R.string.QRCodeLinkHelpGroup;
            str = "QRCodeLinkHelpGroup";
        }
        QRCodeBottomSheet qRCodeBottomSheet = new QRCodeBottomSheet(context, str2, LocaleController.getString(str, i)) { // from class: ir.eitaa.ui.Components.LinkActionView.5
            @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
            public void dismiss() {
                super.dismiss();
                LinkActionView.this.qrCodeBottomSheet = null;
            }
        };
        this.qrCodeBottomSheet = qRCodeBottomSheet;
        qRCodeBottomSheet.show();
        ActionBarPopupWindow actionBarPopupWindow = this.actionBarPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
    }

    public void updateColors() {
        this.copyView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.shareView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.removeView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.copyView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.shareView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.removeView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("chat_attachAudioBackground"), ColorUtils.setAlphaComponent(Theme.getColor("windowBackgroundWhite"), R.styleable.AppCompatTheme_windowNoTitle)));
        this.frameLayout.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("graySection"), ColorUtils.setAlphaComponent(Theme.getColor("listSelectorSDK21"), 76)));
        this.linkView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.optionsView.setColorFilter(Theme.getColor("dialogTextGray3"));
        this.avatarsContainer.countTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText"));
        this.avatarsContainer.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor("windowBackgroundWhiteBlueText"), 76)));
        QRCodeBottomSheet qRCodeBottomSheet = this.qrCodeBottomSheet;
        if (qRCodeBottomSheet != null) {
            qRCodeBottomSheet.updateColors();
        }
    }

    public void setLink(String link) {
        this.link = link;
        if (link == null) {
            this.linkView.setText(LocaleController.getString("Loading", R.string.Loading));
        } else if (link.startsWith("https://")) {
            this.linkView.setText(link.substring(8));
        } else {
            this.linkView.setText(link);
        }
    }

    public void setRevoke(boolean revoked) {
        this.revoked = revoked;
        if (revoked) {
            this.optionsView.setVisibility(8);
            this.shareView.setVisibility(8);
            this.copyView.setVisibility(8);
            this.removeView.setVisibility(0);
            return;
        }
        this.optionsView.setVisibility(0);
        this.shareView.setVisibility(0);
        this.copyView.setVisibility(0);
        this.removeView.setVisibility(8);
    }

    public void hideRevokeOption(boolean b) {
        if (this.hideRevokeOption != b) {
            this.hideRevokeOption = b;
            this.optionsView.setVisibility(0);
            ImageView imageView = this.optionsView;
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ic_ab_other));
        }
    }

    private class AvatarsContainer extends FrameLayout {
        AvatarsImageView avatarsImageView;
        TextView countTextView;

        public AvatarsContainer(Context context) {
            super(context);
            this.avatarsImageView = new AvatarsImageView(context, false) { // from class: ir.eitaa.ui.Components.LinkActionView.AvatarsContainer.1
                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(Math.min(3, LinkActionView.this.usersCount) == 0 ? 0 : ((r2 - 1) * 20) + 24 + 8), 1073741824), heightMeasureSpec);
                }
            };
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, LayoutHelper.createFrame(-2, -1, 1));
            TextView textView = new TextView(context);
            this.countTextView = textView;
            textView.setTextSize(1, 14.0f);
            this.countTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            linearLayout.addView(this.avatarsImageView, LayoutHelper.createLinear(-2, -1));
            linearLayout.addView(this.countTextView, LayoutHelper.createLinear(-2, -2, 16));
            setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
            this.avatarsImageView.commitTransition(false);
        }
    }

    private void revokeLink() {
        if (this.fragment.getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.fragment.getParentActivity());
        builder.setMessage(LocaleController.getString("RevokeAlert", R.string.RevokeAlert));
        builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$hHRGJXAIGdxSNxPs0Y_AlxInAlo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$revokeLink$10$LinkActionView(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$revokeLink$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$revokeLink$10$LinkActionView(DialogInterface dialogInterface, int i) {
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.revokeLink();
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public void setUsers(int usersCount, ArrayList<TLRPC$User> importers) {
        this.usersCount = usersCount;
        if (usersCount == 0) {
            this.avatarsContainer.setVisibility(8);
            setPadding(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(18.0f), AndroidUtilities.dp(19.0f), AndroidUtilities.dp(18.0f));
        } else {
            this.avatarsContainer.setVisibility(0);
            setPadding(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(18.0f), AndroidUtilities.dp(19.0f), AndroidUtilities.dp(10.0f));
            this.avatarsContainer.countTextView.setText(LocaleController.formatPluralString("PeopleJoined", usersCount));
            this.avatarsContainer.requestLayout();
        }
        if (importers != null) {
            for (int i = 0; i < 3; i++) {
                if (i < importers.size()) {
                    MessagesController.getInstance(UserConfig.selectedAccount).putUser(importers.get(i), false);
                    this.avatarsContainer.avatarsImageView.setObject(i, UserConfig.selectedAccount, importers.get(i));
                } else {
                    this.avatarsContainer.avatarsImageView.setObject(i, UserConfig.selectedAccount, null);
                }
            }
            this.avatarsContainer.avatarsImageView.commitTransition(false);
        }
    }

    public void loadUsers(final TLRPC$TL_chatInviteExported invite, long chatId) {
        if (invite == null) {
            setUsers(0, null);
            return;
        }
        setUsers(invite.usage, invite.importers);
        if (invite.usage <= 0 || invite.importers != null || this.loadingImporters) {
            return;
        }
        TLRPC$TL_messages_getChatInviteImporters tLRPC$TL_messages_getChatInviteImporters = new TLRPC$TL_messages_getChatInviteImporters();
        tLRPC$TL_messages_getChatInviteImporters.link = invite.link;
        tLRPC$TL_messages_getChatInviteImporters.peer = MessagesController.getInstance(UserConfig.selectedAccount).getInputPeer(-chatId);
        tLRPC$TL_messages_getChatInviteImporters.offset_user = new TLRPC$TL_inputUserEmpty();
        tLRPC$TL_messages_getChatInviteImporters.limit = Math.min(invite.usage, 3);
        this.loadingImporters = true;
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_messages_getChatInviteImporters, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$y3Gi5watPfEVFbu6a1URiLA7VYU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadUsers$12$LinkActionView(invite, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUsers$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUsers$12$LinkActionView(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$LinkActionView$qEwgnJmFmpe0Bnw3iJSS1YNOvbw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUsers$11$LinkActionView(tLRPC$TL_error, tLObject, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUsers$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUsers$11$LinkActionView(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        this.loadingImporters = false;
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_chatInviteImporters tLRPC$TL_messages_chatInviteImporters = (TLRPC$TL_messages_chatInviteImporters) tLObject;
            if (tLRPC$TL_chatInviteExported.importers == null) {
                tLRPC$TL_chatInviteExported.importers = new ArrayList<>(3);
            }
            tLRPC$TL_chatInviteExported.importers.clear();
            for (int i = 0; i < tLRPC$TL_messages_chatInviteImporters.users.size(); i++) {
                tLRPC$TL_chatInviteExported.importers.addAll(tLRPC$TL_messages_chatInviteImporters.users);
            }
            setUsers(tLRPC$TL_chatInviteExported.usage, tLRPC$TL_chatInviteExported.importers);
        }
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
}
