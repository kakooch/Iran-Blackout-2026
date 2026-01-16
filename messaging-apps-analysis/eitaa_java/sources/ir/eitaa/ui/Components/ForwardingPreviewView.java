package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.ChatListItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManagerFixed;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ForwardingMessagesParams;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.PinchToZoomHelper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ForwardingPreviewView extends FrameLayout {
    ActionBar actionBar;
    ArrayList<ActionBarMenuSubItem> actionItems;
    Adapter adapter;
    LinearLayout buttonsLayout;
    LinearLayout buttonsLayout2;
    Runnable changeBoundsRunnable;
    ActionBarMenuSubItem changeRecipientView;
    GridLayoutManagerFixed chatLayoutManager;
    RecyclerListView chatListView;
    SizeNotifierFrameLayout chatPreviewContainer;
    int chatTopOffset;
    private final int currentAccount;
    TLRPC$Chat currentChat;
    int currentTopOffset;
    TLRPC$User currentUser;
    float currentYOffset;
    private final ArrayList<MessageObject.GroupedMessages> drawingGroups;
    private boolean firstLayout;
    ForwardingMessagesParams forwardingMessagesParams;
    ActionBarMenuSubItem hideCaptionView;
    ActionBarMenuSubItem hideSendersNameView;
    boolean isLandscapeMode;
    ChatListItemAnimator itemAnimator;
    int lastSize;
    LinearLayout menuContainer;
    ScrollView menuScrollView;
    ValueAnimator offsetsAnimator;
    android.graphics.Rect rect;
    private final ResourcesDelegate resourcesProvider;
    boolean returnSendersNames;
    ActionBarMenuSubItem sendMessagesView;
    ActionBarMenuSubItem showCaptionView;
    ActionBarMenuSubItem showSendersNameView;
    boolean showing;
    boolean updateAfterAnimations;
    float yOffset;

    public interface ResourcesDelegate extends Theme.ResourcesProvider {
        Drawable getWallpaperDrawable();

        boolean isWallpaperMotion();
    }

    private void updateColors() {
    }

    protected void didSendPressed() {
    }

    protected void onDismiss(boolean canShowKeyboard) {
        throw null;
    }

    protected void selectAnotherChat() {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ForwardingPreviewView(Context context, final ForwardingMessagesParams params, TLRPC$User user, TLRPC$Chat chat, int currentAccount, final ResourcesDelegate resourcesProvider) {
        int i;
        String str;
        int i2;
        String str2;
        super(context);
        this.actionItems = new ArrayList<>();
        this.rect = new android.graphics.Rect();
        this.firstLayout = true;
        this.changeBoundsRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator valueAnimator = ForwardingPreviewView.this.offsetsAnimator;
                if (valueAnimator == null || valueAnimator.isRunning()) {
                    return;
                }
                ForwardingPreviewView.this.offsetsAnimator.start();
            }
        };
        this.drawingGroups = new ArrayList<>(10);
        this.currentAccount = currentAccount;
        this.currentUser = user;
        this.currentChat = chat;
        this.forwardingMessagesParams = params;
        this.resourcesProvider = resourcesProvider;
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.2
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout
            protected Drawable getNewDrawable() {
                Drawable wallpaperDrawable = resourcesProvider.getWallpaperDrawable();
                return wallpaperDrawable != null ? wallpaperDrawable : super.getNewDrawable();
            }
        };
        this.chatPreviewContainer = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setBackgroundImage(resourcesProvider.getWallpaperDrawable(), resourcesProvider.isWallpaperMotion());
        this.chatPreviewContainer.setOccupyStatusBar(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.chatPreviewContainer.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.3
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, ForwardingPreviewView.this.currentTopOffset + 1, view.getMeasuredWidth(), view.getMeasuredHeight(), AndroidUtilities.dp(6.0f));
                }
            });
            this.chatPreviewContainer.setClipToOutline(true);
            this.chatPreviewContainer.setElevation(AndroidUtilities.dp(4.0f));
        }
        ActionBar actionBar = new ActionBar(context, resourcesProvider);
        this.actionBar = actionBar;
        actionBar.setBackgroundColor(getThemedColor("actionBarDefault"));
        this.actionBar.setOccupyStatusBar(false);
        RecyclerListView recyclerListView = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.4
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (!(child instanceof ChatMessageCell)) {
                    return true;
                }
                ChatMessageCell chatMessageCell = (ChatMessageCell) child;
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                chatMessageCell.drawCheckBox(canvas);
                canvas.save();
                canvas.translate(chatMessageCell.getX(), chatMessageCell.getY());
                chatMessageCell.drawMessageText(canvas, chatMessageCell.getMessageObject().textLayoutBlocks, true, 1.0f, false);
                if (chatMessageCell.getCurrentMessagesGroup() != null || chatMessageCell.getTransitionParams().animateBackgroundBoundsInner) {
                    chatMessageCell.drawNamesLayout(canvas, 1.0f);
                }
                if ((chatMessageCell.getCurrentPosition() != null && chatMessageCell.getCurrentPosition().last) || chatMessageCell.getTransitionParams().animateBackgroundBoundsInner) {
                    chatMessageCell.drawTime(canvas, 1.0f, true);
                }
                if ((chatMessageCell.getCurrentPosition() != null && chatMessageCell.getCurrentPosition().last) || chatMessageCell.getCurrentPosition() == null) {
                    chatMessageCell.drawCaptionLayout(canvas, false, 1.0f);
                }
                chatMessageCell.getTransitionParams().recordDrawingStatePreview();
                canvas.restore();
                return zDrawChild;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt instanceof ChatMessageCell) {
                        ((ChatMessageCell) childAt).setParentViewSize(ForwardingPreviewView.this.chatPreviewContainer.getMeasuredWidth(), ForwardingPreviewView.this.chatPreviewContainer.getBackgroundSizeY());
                    }
                }
                drawChatBackgroundElements(canvas);
                super.dispatchDraw(canvas);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                super.onLayout(changed, l, t, r, b);
                ForwardingPreviewView.this.updatePositions();
            }

            /* JADX WARN: Removed duplicated region for block: B:117:0x02a4  */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r3v9 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private void drawChatBackgroundElements(android.graphics.Canvas r29) {
                /*
                    Method dump skipped, instructions count: 695
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ForwardingPreviewView.AnonymousClass4.drawChatBackgroundElements(android.graphics.Canvas):void");
            }
        };
        this.chatListView = recyclerListView;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(null, this.chatListView, resourcesProvider, currentAccount);
        this.itemAnimator = anonymousClass5;
        recyclerListView.setItemAnimator(anonymousClass5);
        this.chatListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                for (int i3 = 0; i3 < ForwardingPreviewView.this.chatListView.getChildCount(); i3++) {
                    ((ChatMessageCell) ForwardingPreviewView.this.chatListView.getChildAt(i3)).setParentViewSize(ForwardingPreviewView.this.chatPreviewContainer.getMeasuredWidth(), ForwardingPreviewView.this.chatPreviewContainer.getBackgroundSizeY());
                }
            }
        });
        this.chatListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.7
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int position) {
                if (ForwardingPreviewView.this.forwardingMessagesParams.previewMessages.size() <= 1) {
                    return;
                }
                int id = params.previewMessages.get(position).getId();
                boolean z = !params.selectedIds.get(id, false);
                if (ForwardingPreviewView.this.forwardingMessagesParams.selectedIds.size() != 1 || z) {
                    if (!z) {
                        params.selectedIds.delete(id);
                    } else {
                        params.selectedIds.put(id, z);
                    }
                    ((ChatMessageCell) view).setChecked(z, z, true);
                    ForwardingPreviewView.this.actionBar.setTitle(LocaleController.formatPluralString("PreviewForwardMessagesCount", params.selectedIds.size()));
                }
            }
        });
        RecyclerListView recyclerListView2 = this.chatListView;
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        recyclerListView2.setAdapter(adapter);
        this.chatListView.setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f));
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(context, 1000, 1, true, params);
        this.chatLayoutManager = anonymousClass8;
        anonymousClass8.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.9
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if (position < 0 || position >= params.previewMessages.size()) {
                    return 1000;
                }
                MessageObject messageObject = params.previewMessages.get(position);
                MessageObject.GroupedMessages validGroupedMessage = ForwardingPreviewView.this.getValidGroupedMessage(messageObject);
                if (validGroupedMessage != null) {
                    return validGroupedMessage.positions.get(messageObject).spanSize;
                }
                return 1000;
            }
        });
        this.chatListView.setClipToPadding(false);
        this.chatListView.setLayoutManager(this.chatLayoutManager);
        this.chatListView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.10
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                ChatMessageCell chatMessageCell;
                MessageObject.GroupedMessages currentMessagesGroup;
                MessageObject.GroupedMessagePosition currentPosition;
                int i3 = 0;
                outRect.bottom = 0;
                if (!(view instanceof ChatMessageCell) || (currentMessagesGroup = (chatMessageCell = (ChatMessageCell) view).getCurrentMessagesGroup()) == null || (currentPosition = chatMessageCell.getCurrentPosition()) == null || currentPosition.siblingHeights == null) {
                    return;
                }
                android.graphics.Point point = AndroidUtilities.displaySize;
                float fMax = Math.max(point.x, point.y) * 0.5f;
                int extraInsetHeight = chatMessageCell.getExtraInsetHeight();
                int i4 = 0;
                while (true) {
                    if (i4 >= currentPosition.siblingHeights.length) {
                        break;
                    }
                    extraInsetHeight += (int) Math.ceil(r3[i4] * fMax);
                    i4++;
                }
                int iRound = extraInsetHeight + ((currentPosition.maxY - currentPosition.minY) * Math.round(AndroidUtilities.density * 7.0f));
                int size = currentMessagesGroup.posArray.size();
                while (true) {
                    if (i3 < size) {
                        MessageObject.GroupedMessagePosition groupedMessagePosition = currentMessagesGroup.posArray.get(i3);
                        byte b = groupedMessagePosition.minY;
                        byte b2 = currentPosition.minY;
                        if (b == b2 && ((groupedMessagePosition.minX != currentPosition.minX || groupedMessagePosition.maxX != currentPosition.maxX || b != b2 || groupedMessagePosition.maxY != currentPosition.maxY) && b == b2)) {
                            iRound -= ((int) Math.ceil(fMax * groupedMessagePosition.ph)) - AndroidUtilities.dp(4.0f);
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                outRect.bottom = -iRound;
            }
        });
        this.chatPreviewContainer.addView(this.chatListView);
        addView(this.chatPreviewContainer, LayoutHelper.createFrame(-1, 400.0f, 0, 8.0f, 0.0f, 8.0f, 0.0f));
        this.chatPreviewContainer.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        ScrollView scrollView = new ScrollView(context);
        this.menuScrollView = scrollView;
        addView(scrollView, LayoutHelper.createFrame(-2, -2.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.menuContainer = linearLayout;
        linearLayout.setOrientation(1);
        this.menuScrollView.addView(this.menuContainer);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.buttonsLayout = linearLayout2;
        linearLayout2.setOrientation(1);
        Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.popup_fixed_alert).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        this.buttonsLayout.setBackground(drawableMutate);
        this.menuContainer.addView(this.buttonsLayout, LayoutHelper.createFrame(-1, -2.0f));
        ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(context, true, true, false, resourcesProvider);
        this.showSendersNameView = actionBarMenuSubItem;
        this.buttonsLayout.addView(actionBarMenuSubItem, LayoutHelper.createFrame(-1, 48.0f));
        ActionBarMenuSubItem actionBarMenuSubItem2 = this.showSendersNameView;
        if (this.forwardingMessagesParams.multiplyUsers) {
            i = R.string.ShowSenderNames;
            str = "ShowSenderNames";
        } else {
            i = R.string.ShowSendersName;
            str = "ShowSendersName";
        }
        actionBarMenuSubItem2.setTextAndIcon(LocaleController.getString(str, i), 0);
        this.showSendersNameView.setChecked(true);
        ActionBarMenuSubItem actionBarMenuSubItem3 = new ActionBarMenuSubItem(context, true, false, !params.hasCaption, resourcesProvider);
        this.hideSendersNameView = actionBarMenuSubItem3;
        this.buttonsLayout.addView(actionBarMenuSubItem3, LayoutHelper.createFrame(-1, 48.0f));
        ActionBarMenuSubItem actionBarMenuSubItem4 = this.hideSendersNameView;
        if (this.forwardingMessagesParams.multiplyUsers) {
            i2 = R.string.HideSenderNames;
            str2 = "HideSenderNames";
        } else {
            i2 = R.string.HideSendersName;
            str2 = "HideSendersName";
        }
        actionBarMenuSubItem4.setTextAndIcon(LocaleController.getString(str2, i2), 0);
        this.hideSendersNameView.setChecked(false);
        if (this.forwardingMessagesParams.hasCaption) {
            View view = new View(context) { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.11
                @Override // android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(2, 1073741824));
                }
            };
            view.setBackgroundColor(getThemedColor("divider"));
            this.buttonsLayout.addView(view, LayoutHelper.createFrame(-1, -2.0f));
            ActionBarMenuSubItem actionBarMenuSubItem5 = new ActionBarMenuSubItem(context, true, false, false, resourcesProvider);
            this.showCaptionView = actionBarMenuSubItem5;
            this.buttonsLayout.addView(actionBarMenuSubItem5, LayoutHelper.createFrame(-1, 48.0f));
            this.showCaptionView.setTextAndIcon(LocaleController.getString("ShowCaption", R.string.ShowCaption), 0);
            this.showCaptionView.setChecked(true);
            ActionBarMenuSubItem actionBarMenuSubItem6 = new ActionBarMenuSubItem(context, true, false, true, resourcesProvider);
            this.hideCaptionView = actionBarMenuSubItem6;
            this.buttonsLayout.addView(actionBarMenuSubItem6, LayoutHelper.createFrame(-1, 48.0f));
            this.hideCaptionView.setTextAndIcon(LocaleController.getString("HideCaption", R.string.HideCaption), 0);
            this.hideCaptionView.setChecked(false);
        }
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.buttonsLayout2 = linearLayout3;
        linearLayout3.setOrientation(1);
        Drawable drawableMutate2 = getContext().getResources().getDrawable(R.drawable.popup_fixed_alert).mutate();
        drawableMutate2.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        this.buttonsLayout2.setBackground(drawableMutate2);
        this.menuContainer.addView(this.buttonsLayout2, LayoutHelper.createFrame(-1, -2.0f, 0, 0.0f, this.forwardingMessagesParams.hasSenders ? -8.0f : 0.0f, 0.0f, 0.0f));
        ActionBarMenuSubItem actionBarMenuSubItem7 = new ActionBarMenuSubItem(context, true, false, (Theme.ResourcesProvider) resourcesProvider);
        this.changeRecipientView = actionBarMenuSubItem7;
        this.buttonsLayout2.addView(actionBarMenuSubItem7, LayoutHelper.createFrame(-1, 48.0f));
        this.changeRecipientView.setTextAndIcon(LocaleController.getString("ChangeRecipient", R.string.ChangeRecipient), R.drawable.msg_forward_replace);
        ActionBarMenuSubItem actionBarMenuSubItem8 = new ActionBarMenuSubItem(context, false, true, (Theme.ResourcesProvider) resourcesProvider);
        this.sendMessagesView = actionBarMenuSubItem8;
        this.buttonsLayout2.addView(actionBarMenuSubItem8, LayoutHelper.createFrame(-1, 48.0f));
        this.sendMessagesView.setTextAndIcon(LocaleController.getString("ForwardSendMessages", R.string.ForwardSendMessages), R.drawable.msg_forward_send);
        if (this.forwardingMessagesParams.hasSenders) {
            this.actionItems.add(this.showSendersNameView);
            this.actionItems.add(this.hideSendersNameView);
            if (params.hasCaption) {
                this.actionItems.add(this.showCaptionView);
                this.actionItems.add(this.hideCaptionView);
            }
        }
        this.actionItems.add(this.changeRecipientView);
        this.actionItems.add(this.sendMessagesView);
        this.showSendersNameView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$k6OhGEd44-kU3GQnmKIRzKc9W4c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0$ForwardingPreviewView(params, view2);
            }
        });
        this.hideSendersNameView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$P-_WxLV1jm1AVSxxAfLGoQp5UWQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$1$ForwardingPreviewView(params, view2);
            }
        });
        if (params.hasCaption) {
            this.showCaptionView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$cwg7IAs6SxF4aug0C63xzyTo03A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$2$ForwardingPreviewView(params, view2);
                }
            });
            this.hideCaptionView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$Beem6fFM1f3esh45-dtGygkVh_g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$3$ForwardingPreviewView(params, view2);
                }
            });
        }
        this.showSendersNameView.setChecked(!params.hideForwardSendersName);
        this.hideSendersNameView.setChecked(params.hideForwardSendersName);
        if (params.hasCaption) {
            this.showCaptionView.setChecked(!params.hideCaption);
            this.hideCaptionView.setChecked(params.hideCaption);
        }
        if (!params.hasSenders) {
            this.buttonsLayout.setVisibility(8);
        }
        this.sendMessagesView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$V4-gYzVVgWn4b6FTn-00Z0wunIg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$4$ForwardingPreviewView(view2);
            }
        });
        this.changeRecipientView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$m6RMR4qVSbt11HfRf4N6rj7IuUk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$5$ForwardingPreviewView(view2);
            }
        });
        updateMessages();
        updateSubtitle();
        this.actionBar.setTitle(LocaleController.formatPluralString("PreviewForwardMessagesCount", params.selectedIds.size()));
        this.menuScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$x3Z5u88xLA6EI0DQA_BoPB4Zqec
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.lambda$new$6$ForwardingPreviewView(view2, motionEvent);
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$96ANC1VqOQ8LaDDO81Ih_09xbmg
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.lambda$new$7$ForwardingPreviewView(view2, motionEvent);
            }
        });
        this.showing = true;
        setAlpha(0.0f);
        setScaleX(0.95f);
        setScaleY(0.95f);
        animate().alpha(1.0f).scaleX(1.0f).setDuration(250L).setInterpolator(ChatListItemAnimator.DEFAULT_INTERPOLATOR).scaleY(1.0f);
        updateColors();
    }

    /* renamed from: ir.eitaa.ui.Components.ForwardingPreviewView$5, reason: invalid class name */
    class AnonymousClass5 extends ChatListItemAnimator {
        Runnable finishRunnable;
        int scrollAnimationIndex;
        final /* synthetic */ int val$currentAccount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(ChatActivity activity, RecyclerListView listView, Theme.ResourcesProvider resourcesProvider, final int val$currentAccount) {
            super(activity, listView, resourcesProvider);
            this.val$currentAccount = val$currentAccount;
            this.scrollAnimationIndex = -1;
        }

        @Override // androidx.recyclerview.widget.ChatListItemAnimator
        public void onAnimationStart() {
            super.onAnimationStart();
            AndroidUtilities.cancelRunOnUIThread(ForwardingPreviewView.this.changeBoundsRunnable);
            ForwardingPreviewView.this.changeBoundsRunnable.run();
            if (this.scrollAnimationIndex == -1) {
                this.scrollAnimationIndex = NotificationCenter.getInstance(this.val$currentAccount).setAnimationInProgress(this.scrollAnimationIndex, null, false);
            }
            Runnable runnable = this.finishRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.finishRunnable = null;
            }
        }

        @Override // androidx.recyclerview.widget.ChatListItemAnimator, androidx.recyclerview.widget.DefaultItemAnimator
        protected void onAllAnimationsDone() {
            super.onAllAnimationsDone();
            Runnable runnable = this.finishRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            final int i = this.val$currentAccount;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$5$1A2Y9EABtadKpzu0Z9kJN2gJSTA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAllAnimationsDone$0$ForwardingPreviewView$5(i);
                }
            };
            this.finishRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2);
            ForwardingPreviewView forwardingPreviewView = ForwardingPreviewView.this;
            if (forwardingPreviewView.updateAfterAnimations) {
                forwardingPreviewView.updateAfterAnimations = false;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$5$P20JTHovdiDS0pmftxpr7sW_T6U
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAllAnimationsDone$1$ForwardingPreviewView$5();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAllAnimationsDone$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAllAnimationsDone$0$ForwardingPreviewView$5(int i) {
            if (this.scrollAnimationIndex != -1) {
                NotificationCenter.getInstance(i).onAnimationFinish(this.scrollAnimationIndex);
                this.scrollAnimationIndex = -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAllAnimationsDone$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAllAnimationsDone$1$ForwardingPreviewView$5() {
            ForwardingPreviewView.this.updateMessages();
        }

        @Override // androidx.recyclerview.widget.ChatListItemAnimator, androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void endAnimations() {
            super.endAnimations();
            Runnable runnable = this.finishRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            final int i = this.val$currentAccount;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$5$MGjXep5y773i0kGZrWKTGS2PE94
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$endAnimations$2$ForwardingPreviewView$5(i);
                }
            };
            this.finishRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$endAnimations$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$endAnimations$2$ForwardingPreviewView$5(int i) {
            if (this.scrollAnimationIndex != -1) {
                NotificationCenter.getInstance(i).onAnimationFinish(this.scrollAnimationIndex);
                this.scrollAnimationIndex = -1;
            }
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ForwardingPreviewView$8, reason: invalid class name */
    class AnonymousClass8 extends GridLayoutManagerFixed {
        final /* synthetic */ ForwardingMessagesParams val$params;

        @Override // androidx.recyclerview.widget.GridLayoutManagerFixed
        public boolean shouldLayoutChildFromOpositeSide(View child) {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Context context, int spanCount, int orientation, boolean reverseLayout, final ForwardingMessagesParams val$params) {
            super(context, spanCount, orientation, reverseLayout);
            this.val$params = val$params;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManagerFixed
        protected boolean hasSiblingChild(int position) {
            byte b;
            MessageObject messageObject = this.val$params.previewMessages.get(position);
            MessageObject.GroupedMessages validGroupedMessage = ForwardingPreviewView.this.getValidGroupedMessage(messageObject);
            if (validGroupedMessage != null) {
                MessageObject.GroupedMessagePosition groupedMessagePosition = validGroupedMessage.positions.get(messageObject);
                if (groupedMessagePosition.minX != groupedMessagePosition.maxX && (b = groupedMessagePosition.minY) == groupedMessagePosition.maxY && b != 0) {
                    int size = validGroupedMessage.posArray.size();
                    for (int i = 0; i < size; i++) {
                        MessageObject.GroupedMessagePosition groupedMessagePosition2 = validGroupedMessage.posArray.get(i);
                        if (groupedMessagePosition2 != groupedMessagePosition) {
                            byte b2 = groupedMessagePosition2.minY;
                            byte b3 = groupedMessagePosition.minY;
                            if (b2 <= b3 && groupedMessagePosition2.maxY >= b3) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            if (BuildVars.DEBUG_PRIVATE_VERSION) {
                super.onLayoutChildren(recycler, state);
                return;
            }
            try {
                super.onLayoutChildren(recycler, state);
            } catch (Exception e) {
                FileLog.e(e);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$8$vMCpzZN6tw6MmL4R3f807QdS7j4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onLayoutChildren$0$ForwardingPreviewView$8();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLayoutChildren$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayoutChildren$0$ForwardingPreviewView$8() {
            ForwardingPreviewView.this.adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ForwardingPreviewView(ForwardingMessagesParams forwardingMessagesParams, View view) {
        if (forwardingMessagesParams.hideForwardSendersName) {
            this.returnSendersNames = false;
            this.showSendersNameView.setChecked(true);
            this.hideSendersNameView.setChecked(false);
            ActionBarMenuSubItem actionBarMenuSubItem = this.showCaptionView;
            if (actionBarMenuSubItem != null) {
                actionBarMenuSubItem.setChecked(true);
                this.hideCaptionView.setChecked(false);
            }
            forwardingMessagesParams.hideForwardSendersName = false;
            forwardingMessagesParams.hideCaption = false;
            updateMessages();
            updateSubtitle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ForwardingPreviewView(ForwardingMessagesParams forwardingMessagesParams, View view) {
        if (forwardingMessagesParams.hideForwardSendersName) {
            return;
        }
        this.returnSendersNames = false;
        this.showSendersNameView.setChecked(false);
        this.hideSendersNameView.setChecked(true);
        forwardingMessagesParams.hideForwardSendersName = true;
        updateMessages();
        updateSubtitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ForwardingPreviewView(ForwardingMessagesParams forwardingMessagesParams, View view) {
        if (forwardingMessagesParams.hideCaption) {
            if (this.returnSendersNames) {
                forwardingMessagesParams.hideForwardSendersName = false;
            }
            this.returnSendersNames = false;
            this.showCaptionView.setChecked(true);
            this.hideCaptionView.setChecked(false);
            this.showSendersNameView.setChecked(true ^ forwardingMessagesParams.hideForwardSendersName);
            this.hideSendersNameView.setChecked(forwardingMessagesParams.hideForwardSendersName);
            forwardingMessagesParams.hideCaption = false;
            updateMessages();
            updateSubtitle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ForwardingPreviewView(ForwardingMessagesParams forwardingMessagesParams, View view) {
        if (forwardingMessagesParams.hideCaption) {
            return;
        }
        this.showCaptionView.setChecked(false);
        this.hideCaptionView.setChecked(true);
        this.showSendersNameView.setChecked(false);
        this.hideSendersNameView.setChecked(true);
        if (!forwardingMessagesParams.hideForwardSendersName) {
            forwardingMessagesParams.hideForwardSendersName = true;
            this.returnSendersNames = true;
        }
        forwardingMessagesParams.hideCaption = true;
        updateMessages();
        updateSubtitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$ForwardingPreviewView(View view) {
        didSendPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$ForwardingPreviewView(View view) {
        selectAnotherChat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$6$ForwardingPreviewView(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            dismiss(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$7$ForwardingPreviewView(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            dismiss(true);
        }
        return true;
    }

    private void updateSubtitle() {
        ForwardingMessagesParams forwardingMessagesParams = this.forwardingMessagesParams;
        if (!forwardingMessagesParams.hasSenders) {
            if (forwardingMessagesParams.willSeeSenders) {
                TLRPC$User tLRPC$User = this.currentUser;
                if (tLRPC$User != null) {
                    this.actionBar.setSubtitle(LocaleController.formatString("ForwardPreviewSendersNameVisible", R.string.ForwardPreviewSendersNameVisible, ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name)));
                    return;
                } else if (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup) {
                    this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameVisibleChannel", R.string.ForwardPreviewSendersNameVisibleChannel));
                    return;
                } else {
                    this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameVisibleGroup", R.string.ForwardPreviewSendersNameVisibleGroup));
                    return;
                }
            }
            TLRPC$User tLRPC$User2 = this.currentUser;
            if (tLRPC$User2 != null) {
                this.actionBar.setSubtitle(LocaleController.formatString("ForwardPreviewSendersNameVisible", R.string.ForwardPreviewSendersNameVisible, ContactsController.formatName(tLRPC$User2.first_name, tLRPC$User2.last_name)));
                return;
            } else if (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup) {
                this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameHiddenChannel", R.string.ForwardPreviewSendersNameHiddenChannel));
                return;
            } else {
                this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameHiddenGroup", R.string.ForwardPreviewSendersNameHiddenGroup));
                return;
            }
        }
        if (!forwardingMessagesParams.hideForwardSendersName) {
            TLRPC$User tLRPC$User3 = this.currentUser;
            if (tLRPC$User3 != null) {
                this.actionBar.setSubtitle(LocaleController.formatString("ForwardPreviewSendersNameVisible", R.string.ForwardPreviewSendersNameVisible, ContactsController.formatName(tLRPC$User3.first_name, tLRPC$User3.last_name)));
                return;
            } else if (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup) {
                this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameVisibleChannel", R.string.ForwardPreviewSendersNameVisibleChannel));
                return;
            } else {
                this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameVisibleGroup", R.string.ForwardPreviewSendersNameVisibleGroup));
                return;
            }
        }
        TLRPC$User tLRPC$User4 = this.currentUser;
        if (tLRPC$User4 != null) {
            this.actionBar.setSubtitle(LocaleController.formatString("ForwardPreviewSendersNameHidden", R.string.ForwardPreviewSendersNameHidden, ContactsController.formatName(tLRPC$User4.first_name, tLRPC$User4.last_name)));
        } else if (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup) {
            this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameHiddenChannel", R.string.ForwardPreviewSendersNameHiddenChannel));
        } else {
            this.actionBar.setSubtitle(LocaleController.getString("ForwardPreviewSendersNameHiddenGroup", R.string.ForwardPreviewSendersNameHiddenGroup));
        }
    }

    public void dismiss(boolean canShowKeyboard) {
        if (this.showing) {
            this.showing = false;
            animate().alpha(0.0f).scaleX(0.95f).scaleY(0.95f).setDuration(250L).setInterpolator(ChatListItemAnimator.DEFAULT_INTERPOLATOR).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.12
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (ForwardingPreviewView.this.getParent() != null) {
                        ((ViewGroup) ForwardingPreviewView.this.getParent()).removeView(ForwardingPreviewView.this);
                    }
                }
            });
            onDismiss(canShowKeyboard);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMessages() {
        if (this.itemAnimator.isRunning()) {
            this.updateAfterAnimations = true;
            return;
        }
        for (int i = 0; i < this.forwardingMessagesParams.previewMessages.size(); i++) {
            MessageObject messageObject = this.forwardingMessagesParams.previewMessages.get(i);
            messageObject.forceUpdate = true;
            ForwardingMessagesParams forwardingMessagesParams = this.forwardingMessagesParams;
            if (forwardingMessagesParams.hideForwardSendersName) {
                messageObject.messageOwner.flags &= -5;
            } else {
                messageObject.messageOwner.flags |= 4;
            }
            if (forwardingMessagesParams.hideCaption) {
                messageObject.caption = null;
            } else {
                messageObject.generateCaption();
            }
            if (messageObject.isPoll()) {
                ForwardingMessagesParams.PreviewMediaPoll previewMediaPoll = (ForwardingMessagesParams.PreviewMediaPoll) messageObject.messageOwner.media;
                previewMediaPoll.results.total_voters = this.forwardingMessagesParams.hideCaption ? 0 : previewMediaPoll.totalVotersCached;
            }
        }
        for (int i2 = 0; i2 < this.forwardingMessagesParams.pollChoosenAnswers.size(); i2++) {
            this.forwardingMessagesParams.pollChoosenAnswers.get(i2).chosen = !this.forwardingMessagesParams.hideForwardSendersName;
        }
        for (int i3 = 0; i3 < this.forwardingMessagesParams.groupedMessagesMap.size(); i3++) {
            this.itemAnimator.groupWillChanged(this.forwardingMessagesParams.groupedMessagesMap.valueAt(i3));
        }
        this.adapter.notifyItemRangeChanged(0, this.forwardingMessagesParams.previewMessages.size());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.isLandscapeMode = View.MeasureSpec.getSize(widthMeasureSpec) > View.MeasureSpec.getSize(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (this.isLandscapeMode) {
            size = (int) (View.MeasureSpec.getSize(widthMeasureSpec) * 0.38f);
        }
        int measuredWidth = 0;
        for (int i = 0; i < this.actionItems.size(); i++) {
            this.actionItems.get(i).measure(View.MeasureSpec.makeMeasureSpec(size, 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 0));
            if (this.actionItems.get(i).getMeasuredWidth() > measuredWidth) {
                measuredWidth = this.actionItems.get(i).getMeasuredWidth();
            }
        }
        this.buttonsLayout.getBackground().getPadding(this.rect);
        android.graphics.Rect rect = this.rect;
        int i2 = measuredWidth + rect.left + rect.right;
        this.buttonsLayout.getLayoutParams().width = i2;
        this.buttonsLayout2.getLayoutParams().width = i2;
        this.buttonsLayout.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 0));
        this.buttonsLayout2.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 0));
        ((ViewGroup.MarginLayoutParams) this.chatListView.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
        if (this.isLandscapeMode) {
            this.chatPreviewContainer.getLayoutParams().height = -1;
            ((ViewGroup.MarginLayoutParams) this.chatPreviewContainer.getLayoutParams()).topMargin = AndroidUtilities.dp(8.0f);
            ((ViewGroup.MarginLayoutParams) this.chatPreviewContainer.getLayoutParams()).bottomMargin = AndroidUtilities.dp(8.0f);
            this.chatPreviewContainer.getLayoutParams().width = (int) Math.min(View.MeasureSpec.getSize(widthMeasureSpec), Math.max(AndroidUtilities.dp(340.0f), View.MeasureSpec.getSize(widthMeasureSpec) * 0.6f));
            this.menuScrollView.getLayoutParams().height = -1;
        } else {
            ((ViewGroup.MarginLayoutParams) this.chatPreviewContainer.getLayoutParams()).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) this.chatPreviewContainer.getLayoutParams()).bottomMargin = 0;
            this.chatPreviewContainer.getLayoutParams().height = ((View.MeasureSpec.getSize(heightMeasureSpec) - AndroidUtilities.dp(6.0f)) - this.buttonsLayout.getMeasuredHeight()) - this.buttonsLayout2.getMeasuredHeight();
            if (this.chatPreviewContainer.getLayoutParams().height < View.MeasureSpec.getSize(heightMeasureSpec) * 0.5f) {
                this.chatPreviewContainer.getLayoutParams().height = (int) (View.MeasureSpec.getSize(heightMeasureSpec) * 0.5f);
            }
            this.chatPreviewContainer.getLayoutParams().width = -1;
            this.menuScrollView.getLayoutParams().height = View.MeasureSpec.getSize(heightMeasureSpec) - this.chatPreviewContainer.getLayoutParams().height;
        }
        int size2 = (View.MeasureSpec.getSize(widthMeasureSpec) + View.MeasureSpec.getSize(heightMeasureSpec)) << 16;
        if (this.lastSize != size2) {
            for (int i3 = 0; i3 < this.forwardingMessagesParams.previewMessages.size(); i3++) {
                if (this.isLandscapeMode) {
                    this.forwardingMessagesParams.previewMessages.get(i3).parentWidth = this.chatPreviewContainer.getLayoutParams().width;
                } else {
                    this.forwardingMessagesParams.previewMessages.get(i3).parentWidth = View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(16.0f);
                }
                this.forwardingMessagesParams.previewMessages.get(i3).resetLayout();
                this.forwardingMessagesParams.previewMessages.get(i3).forceUpdate = true;
                Adapter adapter = this.adapter;
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
            this.firstLayout = true;
        }
        this.lastSize = size2;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updatePositions();
        this.firstLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePositions() {
        final int i = this.chatTopOffset;
        final float f = this.yOffset;
        if (!this.isLandscapeMode) {
            if (this.chatListView.getChildCount() == 0 || this.chatListView.getChildCount() > this.forwardingMessagesParams.previewMessages.size()) {
                this.chatTopOffset = 0;
            } else {
                int top = this.chatListView.getChildAt(0).getTop();
                for (int i2 = 1; i2 < this.chatListView.getChildCount(); i2++) {
                    if (this.chatListView.getChildAt(i2).getTop() < top) {
                        top = this.chatListView.getChildAt(i2).getTop();
                    }
                }
                int iDp = top - AndroidUtilities.dp(4.0f);
                if (iDp < 0) {
                    this.chatTopOffset = 0;
                } else {
                    this.chatTopOffset = iDp;
                }
            }
            float fDp = (AndroidUtilities.dp(8.0f) + (((getMeasuredHeight() - AndroidUtilities.dp(16.0f)) - (((this.buttonsLayout.getMeasuredHeight() + this.buttonsLayout2.getMeasuredHeight()) - AndroidUtilities.dp(8.0f)) + (this.chatPreviewContainer.getMeasuredHeight() - this.chatTopOffset))) / 2.0f)) - this.chatTopOffset;
            this.yOffset = fDp;
            if (fDp > AndroidUtilities.dp(8.0f)) {
                this.yOffset = AndroidUtilities.dp(8.0f);
            }
            this.menuScrollView.setTranslationX(getMeasuredWidth() - this.menuScrollView.getMeasuredWidth());
        } else {
            this.yOffset = 0.0f;
            this.chatTopOffset = 0;
            this.menuScrollView.setTranslationX(this.chatListView.getMeasuredWidth() + AndroidUtilities.dp(8.0f));
        }
        boolean z = this.firstLayout;
        if (z || (this.chatTopOffset == i && this.yOffset == f)) {
            if (z) {
                float f2 = this.yOffset;
                this.currentYOffset = f2;
                int i3 = this.chatTopOffset;
                this.currentTopOffset = i3;
                setOffset(f2, i3);
                return;
            }
            return;
        }
        ValueAnimator valueAnimator = this.offsetsAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.offsetsAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ForwardingPreviewView$kpyOYlLVEspr1NZiUlQ8RmJRUpU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$updatePositions$8$ForwardingPreviewView(i, f, valueAnimator2);
            }
        });
        this.offsetsAnimator.setDuration(250L);
        this.offsetsAnimator.setInterpolator(ChatListItemAnimator.DEFAULT_INTERPOLATOR);
        this.offsetsAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ForwardingPreviewView forwardingPreviewView = ForwardingPreviewView.this;
                forwardingPreviewView.offsetsAnimator = null;
                forwardingPreviewView.setOffset(forwardingPreviewView.yOffset, forwardingPreviewView.chatTopOffset);
            }
        });
        AndroidUtilities.runOnUIThread(this.changeBoundsRunnable, 50L);
        this.currentTopOffset = i;
        this.currentYOffset = f;
        setOffset(f, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updatePositions$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updatePositions$8$ForwardingPreviewView(int i, float f, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f2 = 1.0f - fFloatValue;
        int i2 = (int) ((i * f2) + (this.chatTopOffset * fFloatValue));
        this.currentTopOffset = i2;
        float f3 = (f * f2) + (this.yOffset * fFloatValue);
        this.currentYOffset = f3;
        setOffset(f3, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffset(float yOffset, int chatTopOffset) {
        if (this.isLandscapeMode) {
            this.actionBar.setTranslationY(0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                this.chatPreviewContainer.invalidateOutline();
            }
            this.chatPreviewContainer.setTranslationY(0.0f);
            this.menuScrollView.setTranslationY(0.0f);
            return;
        }
        this.actionBar.setTranslationY(chatTopOffset);
        if (Build.VERSION.SDK_INT >= 21) {
            this.chatPreviewContainer.invalidateOutline();
        }
        this.chatPreviewContainer.setTranslationY(yOffset);
        this.menuScrollView.setTranslationY((yOffset + this.chatPreviewContainer.getMeasuredHeight()) - AndroidUtilities.dp(2.0f));
    }

    public boolean isShowing() {
        return this.showing;
    }

    private class Adapter extends RecyclerView.Adapter {
        private Adapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new ChatMessageCell(parent.getContext(), ForwardingPreviewView.this.resourcesProvider));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException, NumberFormatException {
            ChatMessageCell chatMessageCell = (ChatMessageCell) holder.itemView;
            chatMessageCell.setParentViewSize(ForwardingPreviewView.this.chatListView.getMeasuredWidth(), ForwardingPreviewView.this.chatListView.getMeasuredHeight());
            int id = chatMessageCell.getMessageObject() != null ? chatMessageCell.getMessageObject().getId() : 0;
            MessageObject messageObject = ForwardingPreviewView.this.forwardingMessagesParams.previewMessages.get(position);
            ForwardingMessagesParams forwardingMessagesParams = ForwardingPreviewView.this.forwardingMessagesParams;
            chatMessageCell.setMessageObject(messageObject, forwardingMessagesParams.groupedMessagesMap.get(forwardingMessagesParams.previewMessages.get(position).getGroupId()), true, true);
            chatMessageCell.setDelegate(new ChatMessageCell.ChatMessageCellDelegate() { // from class: ir.eitaa.ui.Components.ForwardingPreviewView.Adapter.1
                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean canPerformActions() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$canPerformActions(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didLongPress(ChatMessageCell chatMessageCell2, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPress(this, chatMessageCell2, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean didLongPressChannelAvatar(ChatMessageCell chatMessageCell2, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressChannelAvatar(this, chatMessageCell2, tLRPC$Chat, i, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean didLongPressUserAvatar(ChatMessageCell chatMessageCell2, TLRPC$User tLRPC$User, float f, float f2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressUserAvatar(this, chatMessageCell2, tLRPC$User, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressBotButton(ChatMessageCell chatMessageCell2, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressBotButton(this, chatMessageCell2, tLRPC$KeyboardButton);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressCancelSendButton(ChatMessageCell chatMessageCell2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCancelSendButton(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressChannelAvatar(ChatMessageCell chatMessageCell2, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressChannelAvatar(this, chatMessageCell2, tLRPC$Chat, i, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressCommentButton(ChatMessageCell chatMessageCell2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCommentButton(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressHiddenForward(ChatMessageCell chatMessageCell2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHiddenForward(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressHint(ChatMessageCell chatMessageCell2, int i) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHint(this, chatMessageCell2, i);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressImage(ChatMessageCell chatMessageCell2, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressImage(this, chatMessageCell2, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressInstantButton(ChatMessageCell chatMessageCell2, int i) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressInstantButton(this, chatMessageCell2, i);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressOther(ChatMessageCell chatMessageCell2, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressOther(this, chatMessageCell2, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressReaction(ChatMessageCell chatMessageCell2, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReaction(this, chatMessageCell2, tLRPC$TL_reactionCount);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressReplyMessage(ChatMessageCell chatMessageCell2, int i) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReplyMessage(this, chatMessageCell2, i);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressSideButton(ChatMessageCell chatMessageCell2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressSideButton(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressTime(ChatMessageCell chatMessageCell2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressTime(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressUrl(ChatMessageCell chatMessageCell2, CharacterStyle characterStyle, boolean z) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressUrl(this, chatMessageCell2, characterStyle, z);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressUserAvatar(ChatMessageCell chatMessageCell2, TLRPC$User tLRPC$User, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressUserAvatar(this, chatMessageCell2, tLRPC$User, f, f2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressViaBot(ChatMessageCell chatMessageCell2, String str) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressViaBot(this, chatMessageCell2, str);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressVoteButtons(ChatMessageCell chatMessageCell2, ArrayList arrayList, int i, int i2, int i3) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressVoteButtons(this, chatMessageCell2, arrayList, i, i2, i3);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressedShareToMine(ChatMessageCell chatMessageCell2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressedShareToMine(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didStartVideoStream(MessageObject messageObject2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didStartVideoStream(this, messageObject2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ String getAdminRank(long j) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getAdminRank(this, j);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ PinchToZoomHelper getPinchToZoomHelper() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getPinchToZoomHelper(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getTextSelectionHelper(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean hasSelectedMessages() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$hasSelectedMessages(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean isLandscape() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$isLandscape(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean keyboardIsOpened() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$keyboardIsOpened(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void needOpenWebView(MessageObject messageObject2, String str, String str2, String str3, String str4, int i, int i2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$needOpenWebView(this, messageObject2, str, str2, str3, str4, i, i2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean needPlayMessage(MessageObject messageObject2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$needPlayMessage(this, messageObject2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void needReloadPolls() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$needReloadPolls(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void onDiceFinished() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$onDiceFinished(this);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void setShouldNotRepeatSticker(MessageObject messageObject2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$setShouldNotRepeatSticker(this, messageObject2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean shouldDrawThreadProgress(ChatMessageCell chatMessageCell2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldDrawThreadProgress(this, chatMessageCell2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean shouldRepeatSticker(MessageObject messageObject2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldRepeatSticker(this, messageObject2);
                }

                @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void videoTimerReached() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$videoTimerReached(this);
                }
            });
            if (ForwardingPreviewView.this.forwardingMessagesParams.previewMessages.size() > 1) {
                chatMessageCell.setCheckBoxVisible(true, false);
                boolean z = id == ForwardingPreviewView.this.forwardingMessagesParams.previewMessages.get(position).getId();
                ForwardingMessagesParams forwardingMessagesParams2 = ForwardingPreviewView.this.forwardingMessagesParams;
                boolean z2 = forwardingMessagesParams2.selectedIds.get(forwardingMessagesParams2.previewMessages.get(position).getId(), false);
                chatMessageCell.setChecked(z2, z2, z);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ForwardingPreviewView.this.forwardingMessagesParams.previewMessages.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageObject.GroupedMessages getValidGroupedMessage(MessageObject message) {
        if (message.getGroupId() == 0) {
            return null;
        }
        MessageObject.GroupedMessages groupedMessages = this.forwardingMessagesParams.groupedMessagesMap.get(message.getGroupId());
        if (groupedMessages == null || (groupedMessages.messages.size() > 1 && groupedMessages.positions.get(message) != null)) {
            return groupedMessages;
        }
        return null;
    }

    private int getThemedColor(String key) {
        ResourcesDelegate resourcesDelegate = this.resourcesProvider;
        Integer color = resourcesDelegate != null ? resourcesDelegate.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
