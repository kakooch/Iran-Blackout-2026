package org.rbmain.ui.Components;

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
import com.facebook.stetho.server.http.HttpStatus;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.DialogCell;

/* loaded from: classes5.dex */
public class LinkActionView extends LinearLayout {
    private ActionBarPopupWindow actionBarPopupWindow;
    private final AvatarsContainer avatarsContainer;
    private boolean canEdit;
    private final TextView copyView;
    private Delegate delegate;
    BaseFragment fragment;
    private final FrameLayout frameLayout;
    private final TextView generateView;
    private boolean hideRevokeOption;
    private boolean isChannel;
    String link;
    TextView linkView;
    private boolean notSet;
    ImageView optionsView;
    private boolean permanent;
    float[] point;
    private QRCodeBottomSheet qrCodeBottomSheet;
    private final TextView removeView;
    private final TextView shareView;
    private int usersCount;

    public interface Delegate {

        /* renamed from: org.rbmain.ui.Components.LinkActionView$Delegate$-CC, reason: invalid class name */
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

    public LinkActionView(final Context context, final BaseFragment baseFragment, final BottomSheet bottomSheet, int i, boolean z, boolean z2) {
        super(context);
        this.canEdit = true;
        this.notSet = false;
        this.point = new float[2];
        this.fragment = baseFragment;
        this.permanent = z;
        this.isChannel = z2;
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
        this.generateView = textView2;
        textView2.setGravity(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.plus)), 0, 1, 0);
        spannableStringBuilder.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder.append((CharSequence) LocaleController.getString("LinkActionGenerate", R.string.LinkActionGenerate));
        spannableStringBuilder.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 0);
        textView2.setText(spannableStringBuilder);
        textView2.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setSingleLine(true);
        textView2.setVisibility(8);
        addView(textView2, LayoutHelper.createLinear(-1, 40, 0.0f, 20.0f, 0.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.copyView = textView3;
        textView3.setGravity(1);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_copy_filled)), 0, 1, 0);
        spannableStringBuilder2.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder2.append((CharSequence) LocaleController.getString("LinkActionCopy", R.string.LinkActionCopy));
        spannableStringBuilder2.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 0);
        textView3.setText(spannableStringBuilder2);
        textView3.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView3.setTextSize(1, 14.0f);
        textView3.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView3.setSingleLine(true);
        linearLayout.addView(textView3, LayoutHelper.createLinear(0, 40, 1.0f, 0, 4, 0, 4, 0));
        TextView textView4 = new TextView(context);
        this.shareView = textView4;
        textView4.setGravity(1);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        spannableStringBuilder3.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_share_filled)), 0, 1, 0);
        spannableStringBuilder3.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder3.append((CharSequence) LocaleController.getString("LinkActionShare", R.string.LinkActionShare));
        spannableStringBuilder3.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder3.length() - 1, spannableStringBuilder3.length(), 0);
        textView4.setText(spannableStringBuilder3);
        textView4.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView4.setTextSize(1, 14.0f);
        textView4.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView4.setSingleLine(true);
        linearLayout.addView(textView4, LayoutHelper.createLinear(0, 40, 1.0f, 4, 0, 4, 0));
        TextView textView5 = new TextView(context);
        this.removeView = textView5;
        textView5.setGravity(1);
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder();
        spannableStringBuilder4.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_delete_filled)), 0, 1, 0);
        spannableStringBuilder4.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder4.append((CharSequence) LocaleController.getString("DeleteLink", R.string.DeleteLink));
        spannableStringBuilder4.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder4.length() - 1, spannableStringBuilder4.length(), 0);
        textView5.setText(spannableStringBuilder4);
        textView5.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView5.setTextSize(1, 14.0f);
        textView5.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView5.setSingleLine(true);
        linearLayout.addView(textView5, LayoutHelper.createLinear(0, -2, 1.0f, 4, 0, 4, 0));
        textView5.setVisibility(8);
        addView(linearLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
        AvatarsContainer avatarsContainer = new AvatarsContainer(context);
        this.avatarsContainer = avatarsContainer;
        addView(avatarsContainer, LayoutHelper.createLinear(-1, 44, 0.0f, 12.0f, 0.0f, 0.0f));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(bottomSheet, baseFragment, view);
            }
        });
        if (z) {
            avatarsContainer.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(baseFragment, view);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$4(baseFragment, view);
            }
        });
        this.optionsView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$9(context, bottomSheet, baseFragment, view);
            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LinkActionView.this.copyView.callOnClick();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$10(view);
            }
        });
        updateColors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(BottomSheet bottomSheet, BaseFragment baseFragment, View view) {
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
    public /* synthetic */ void lambda$new$1(View view) {
        this.delegate.showUsersForPermanentLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(BaseFragment baseFragment, View view) {
        try {
            if (this.link == null) {
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.link);
            baseFragment.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("InviteToGroupByLink", R.string.InviteToGroupByLink)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(BaseFragment baseFragment, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("DeleteLink", R.string.DeleteLink));
        builder.setMessage(LocaleController.getString("DeleteLinkHelp", R.string.DeleteLinkHelp));
        builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$new$3(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(DialogInterface dialogInterface, int i) {
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.removeLink();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(Context context, BottomSheet bottomSheet, BaseFragment baseFragment, View view) {
        final FrameLayout container;
        if (this.actionBarPopupWindow != null) {
            return;
        }
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(context);
        if (!this.permanent && this.canEdit) {
            ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(context, true, false);
            actionBarMenuSubItem.setTextAndIcon(LocaleController.getString("Edit", R.string.Edit), R.drawable.msg_edit);
            actionBarPopupWindowLayout.addView((View) actionBarMenuSubItem, LayoutHelper.createLinear(-1, 48));
            actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$5(view2);
                }
            });
        }
        if (!this.notSet) {
            ActionBarMenuSubItem actionBarMenuSubItem2 = new ActionBarMenuSubItem(context, true, false);
            actionBarMenuSubItem2.setTextAndIcon(LocaleController.getString("GetQRCode", R.string.GetQRCode), R.drawable.msg_qrcode);
            actionBarPopupWindowLayout.addView((View) actionBarMenuSubItem2, LayoutHelper.createLinear(-1, 48));
            actionBarMenuSubItem2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$6(view2);
                }
            });
        }
        if (!this.hideRevokeOption) {
            ActionBarMenuSubItem actionBarMenuSubItem3 = new ActionBarMenuSubItem(context, false, true);
            actionBarMenuSubItem3.setTextAndIcon(LocaleController.getString("RevokeLink", R.string.RevokeLink), R.drawable.msg_delete);
            int i = Theme.key_text_RedRegular;
            actionBarMenuSubItem3.setColors(Theme.getColor(i), Theme.getColor(i));
            actionBarMenuSubItem3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$7(view2);
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
            final View view2 = new View(context) { // from class: org.rbmain.ui.Components.LinkActionView.1
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
            final ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener(this) { // from class: org.rbmain.ui.Components.LinkActionView.2
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
            actionBarPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: org.rbmain.ui.Components.LinkActionView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    LinkActionView.this.actionBarPopupWindow = null;
                    view2.animate().cancel();
                    view2.animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.LinkActionView.3.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
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
            actionBarPopupWindowLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda11
                @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.f$0.lambda$new$8(keyEvent);
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
    public /* synthetic */ void lambda$new$5(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.actionBarPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        this.delegate.editLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(View view) {
        showQrCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.actionBarPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        revokeLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && this.actionBarPopupWindow.isShowing()) {
            this.actionBarPopupWindow.dismiss(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$10(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.actionBarPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        generateLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.View] */
    public void getPointOnScreen(FrameLayout frameLayout, FrameLayout frameLayout2, float[] fArr) {
        float x = 0.0f;
        float y = 0.0f;
        while (frameLayout != frameLayout2) {
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
        fArr[0] = x - frameLayout2.getPaddingLeft();
        fArr[1] = y - frameLayout2.getPaddingTop();
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
        QRCodeBottomSheet qRCodeBottomSheet = new QRCodeBottomSheet(context, str2, LocaleController.getString(str, i)) { // from class: org.rbmain.ui.Components.LinkActionView.5
            @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
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
        TextView textView = this.generateView;
        int i = Theme.key_featuredStickers_buttonText;
        textView.setTextColor(Theme.getColor(i));
        this.copyView.setTextColor(Theme.getColor(i));
        this.shareView.setTextColor(Theme.getColor(i));
        this.removeView.setTextColor(Theme.getColor(i));
        TextView textView2 = this.generateView;
        int iDp = AndroidUtilities.dp(6.0f);
        int i2 = Theme.key_featuredStickers_addButton;
        int color = Theme.getColor(i2);
        int i3 = Theme.key_featuredStickers_addButtonPressed;
        textView2.setBackground(Theme.createSimpleSelectorRoundRectDrawable(iDp, color, Theme.getColor(i3)));
        this.copyView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(i2), Theme.getColor(i3)));
        this.shareView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(i2), Theme.getColor(i3)));
        this.removeView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_chat_attachAudioBackground), ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_windowBackgroundWhite), 120)));
        this.frameLayout.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_graySection), ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_listSelector), 76)));
        this.linkView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.optionsView.setColorFilter(Theme.getColor(Theme.key_dialogTextGray3));
        TextView textView3 = this.avatarsContainer.countTextView;
        int i4 = Theme.key_windowBackgroundWhiteBlueText;
        textView3.setTextColor(Theme.getColor(i4));
        this.avatarsContainer.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor(i4), 76)));
        QRCodeBottomSheet qRCodeBottomSheet = this.qrCodeBottomSheet;
        if (qRCodeBottomSheet != null) {
            qRCodeBottomSheet.updateColors();
        }
    }

    public void setLink(String str) {
        this.link = str;
        if (this.notSet) {
            this.linkView.setText(LocaleController.getString("NotSetLink", R.string.NotSetLink));
            return;
        }
        if (str == null) {
            this.linkView.setText(LocaleController.getString("Loading", R.string.Loading));
        } else if (str.startsWith("https://")) {
            this.linkView.setText(str.substring(8));
        } else {
            this.linkView.setText(str);
        }
    }

    public void setUnSetLink(boolean z) {
        if (this.notSet == z) {
            return;
        }
        this.notSet = z;
        if (z) {
            this.shareView.setVisibility(8);
            this.copyView.setVisibility(8);
            this.generateView.setVisibility(0);
        } else {
            this.shareView.setVisibility(0);
            this.copyView.setVisibility(0);
            this.generateView.setVisibility(8);
        }
        hideRevokeOption(this.notSet);
    }

    public void setRevoke(boolean z) {
        if (z) {
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

    public void showOptions(boolean z) {
        this.optionsView.setVisibility(z ? 0 : 8);
    }

    public void hideRevokeOption(boolean z) {
        if (this.hideRevokeOption != z) {
            this.hideRevokeOption = z;
            if (!z) {
                this.optionsView.setVisibility(0);
                ImageView imageView = this.optionsView;
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ic_ab_other));
                return;
            }
            showOptions(false);
        }
    }

    private class AvatarsContainer extends FrameLayout {
        AvatarsImageView avatarsImageView;
        TextView countTextView;

        public AvatarsContainer(Context context) {
            super(context);
            this.avatarsImageView = new AvatarsImageView(context, LinkActionView.this) { // from class: org.rbmain.ui.Components.LinkActionView.AvatarsContainer.1
                @Override // org.rbmain.ui.Components.AvatarsImageView, android.view.View
                protected void onMeasure(int i, int i2) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(Math.min(3, LinkActionView.this.usersCount) == 0 ? 0 : ((r2 - 1) * 20) + 24 + 8), 1073741824), i2);
                }
            };
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, LayoutHelper.createFrame(-2, -1, 1));
            TextView textView = new TextView(context);
            this.countTextView = textView;
            textView.setTextSize(1, 14.0f);
            this.countTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
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
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.LinkActionView$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$revokeLink$11(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$revokeLink$11(DialogInterface dialogInterface, int i) {
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.revokeLink();
        }
    }

    private void generateLink() {
        Delegate delegate;
        if (this.fragment.getParentActivity() == null || (delegate = this.delegate) == null) {
            return;
        }
        delegate.revokeLink();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public void setUsers(int i, ArrayList<TLRPC$User> arrayList) {
        this.usersCount = i;
        if (i == 0) {
            this.avatarsContainer.setVisibility(8);
            setPadding(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(18.0f), AndroidUtilities.dp(19.0f), AndroidUtilities.dp(18.0f));
        } else {
            this.avatarsContainer.setVisibility(0);
            setPadding(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(18.0f), AndroidUtilities.dp(19.0f), AndroidUtilities.dp(10.0f));
            this.avatarsContainer.countTextView.setText(LocaleController.formatPluralString("PeopleJoined", i));
            this.avatarsContainer.requestLayout();
        }
        if (arrayList != null) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (i2 < arrayList.size()) {
                    MessagesController.getInstance(UserConfig.selectedAccount).putUser(arrayList.get(i2), false);
                    this.avatarsContainer.avatarsImageView.setObject(i2, UserConfig.selectedAccount, arrayList.get(i2));
                } else {
                    this.avatarsContainer.avatarsImageView.setObject(i2, UserConfig.selectedAccount, null);
                }
                this.avatarsContainer.avatarsImageView.commitTransition(false);
            }
        }
    }

    public void loadUsers(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, int i) {
        setUsers(0, null);
    }

    public void setPermanent(boolean z) {
        this.permanent = z;
    }

    public void setCanEdit(boolean z) {
        this.canEdit = z;
    }
}
