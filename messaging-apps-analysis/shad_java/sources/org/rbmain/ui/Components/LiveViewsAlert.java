package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.ChatConverter;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.UserInfo;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_live;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.LiveActivity;

/* loaded from: classes5.dex */
public class LiveViewsAlert extends BottomSheet {
    public static final Property<UserCell, Float> USER_CELL_PROPERTY = new AnimationProperties.FloatProperty<UserCell>("placeholderAlpha") { // from class: org.rbmain.ui.Components.LiveViewsAlert.1
        @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
        public void setValue(UserCell userCell, float f) {
            userCell.setPlaceholderAlpha(f);
        }

        @Override // android.util.Property
        public Float get(UserCell userCell) {
            return Float.valueOf(userCell.getPlaceholderAlpha());
        }
    };
    private ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarShadow;
    private float gradientWidth;
    private boolean hasContinue;
    private int lastReqId;
    private Adapter listAdapter;
    private RecyclerListView listView;
    private final TLRPC$TL_live live;
    private LiveActivity liveActivity;
    private boolean loadingResults;
    private MessageObject messageObject;
    private TLRPC$InputPeer peer;
    private LinearGradient placeholderGradient;
    private Matrix placeholderMatrix;
    private Paint placeholderPaint;
    private RectF rect;
    private int scrollOffsetY;
    private Drawable shadowDrawable;
    private String start_id;
    private TextView titleTextView;
    private float totalTranslation;
    private final List<TLRPC$User> viewers;
    private final Map<String, ChatAbsObject> viewersAbsMap;
    private final SparseArray<TLRPC$User> viewersMap;

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    static /* synthetic */ float access$2716(LiveViewsAlert liveViewsAlert, float f) {
        float f2 = liveViewsAlert.totalTranslation + f;
        liveViewsAlert.totalTranslation = f2;
        return f2;
    }

    static /* synthetic */ float access$2724(LiveViewsAlert liveViewsAlert, float f) {
        float f2 = liveViewsAlert.totalTranslation - f;
        liveViewsAlert.totalTranslation = f2;
        return f2;
    }

    public class UserCell extends FrameLayout {
        private ArrayList<Animator> animators;
        private AvatarDrawable avatarDrawable;
        private BackupImageView avatarImageView;
        private TLRPC$User currentUser;
        private boolean drawPlaceholder;
        private TLRPC$FileLocation lastAvatar;
        private String lastName;
        private int lastStatus;
        private SimpleTextView nameTextView;
        private boolean needDivider;
        private float placeholderAlpha;
        private int placeholderNum;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public UserCell(Context context) {
            super(context);
            int i = UserConfig.selectedAccount;
            this.placeholderAlpha = 1.0f;
            setWillNotDraw(false);
            this.avatarDrawable = new AvatarDrawable();
            BackupImageView backupImageView = new BackupImageView(context);
            this.avatarImageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(18.0f));
            BackupImageView backupImageView2 = this.avatarImageView;
            boolean z = LocaleController.isRTL;
            addView(backupImageView2, LayoutHelper.createFrame(36, 36.0f, (z ? 5 : 3) | 48, z ? 0.0f : 14.0f, 6.0f, z ? 14.0f : 0.0f, 0.0f));
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.nameTextView = simpleTextView;
            simpleTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.nameTextView.setTextSize(16);
            this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            SimpleTextView simpleTextView2 = this.nameTextView;
            boolean z2 = LocaleController.isRTL;
            addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, (z2 ? 5 : 3) | 48, z2 ? 28.0f : 65.0f, 14.0f, z2 ? 65.0f : 28.0f, 0.0f));
        }

        public void setData(TLRPC$User tLRPC$User, int i, boolean z) {
            this.currentUser = tLRPC$User;
            this.needDivider = z;
            this.drawPlaceholder = tLRPC$User == null;
            this.placeholderNum = i;
            if (tLRPC$User == null) {
                this.nameTextView.setText(BuildConfig.FLAVOR);
                this.avatarImageView.setImageDrawable(null);
            } else {
                update(0);
            }
            ArrayList<Animator> arrayList = this.animators;
            if (arrayList != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.avatarImageView, (Property<BackupImageView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.nameTextView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this, LiveViewsAlert.USER_CELL_PROPERTY, 1.0f, 0.0f));
            } else {
                if (this.drawPlaceholder) {
                    return;
                }
                this.placeholderAlpha = 0.0f;
            }
        }

        @Keep
        public void setPlaceholderAlpha(float f) {
            this.placeholderAlpha = f;
            invalidate();
        }

        @Keep
        public float getPlaceholderAlpha() {
            return this.placeholderAlpha;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0061 A[PHI: r1
          0x0061: PHI (r1v5 java.lang.String) = (r1v0 java.lang.String), (r1v0 java.lang.String), (r1v0 java.lang.String), (r1v7 java.lang.String) binds: [B:36:0x0049, B:38:0x004d, B:40:0x0050, B:44:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0064 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void update(int r12) {
            /*
                r11 = this;
                org.rbmain.tgnet.TLRPC$User r0 = r11.currentUser
                r1 = 0
                if (r0 == 0) goto Lc
                org.rbmain.tgnet.TLRPC$UserProfilePhoto r2 = r0.photo
                if (r2 == 0) goto Lc
                org.rbmain.tgnet.TLRPC$FileLocation r2 = r2.photo_small
                goto Ld
            Lc:
                r2 = r1
            Ld:
                r3 = 0
                if (r12 == 0) goto L65
                r4 = r12 & 2
                r5 = 1
                if (r4 == 0) goto L33
                org.rbmain.tgnet.TLRPC$FileLocation r4 = r11.lastAvatar
                if (r4 == 0) goto L1b
                if (r2 == 0) goto L31
            L1b:
                if (r4 != 0) goto L1f
                if (r2 != 0) goto L31
            L1f:
                if (r4 == 0) goto L33
                if (r2 == 0) goto L33
                long r6 = r4.volume_id
                long r8 = r2.volume_id
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 != 0) goto L31
                int r4 = r4.local_id
                int r6 = r2.local_id
                if (r4 == r6) goto L33
            L31:
                r4 = 1
                goto L34
            L33:
                r4 = 0
            L34:
                if (r0 == 0) goto L49
                if (r4 != 0) goto L49
                r6 = r12 & 4
                if (r6 == 0) goto L49
                org.rbmain.tgnet.TLRPC$UserStatus r6 = r0.status
                if (r6 == 0) goto L43
                int r6 = r6.expires
                goto L44
            L43:
                r6 = 0
            L44:
                int r7 = r11.lastStatus
                if (r6 == r7) goto L49
                r4 = 1
            L49:
                if (r4 != 0) goto L61
                java.lang.String r6 = r11.lastName
                if (r6 == 0) goto L61
                r12 = r12 & r5
                if (r12 == 0) goto L61
                if (r0 == 0) goto L58
                java.lang.String r1 = org.rbmain.messenger.UserObject.getUserName(r0)
            L58:
                java.lang.String r12 = r11.lastName
                boolean r12 = r1.equals(r12)
                if (r12 != 0) goto L61
                goto L62
            L61:
                r5 = r4
            L62:
                if (r5 != 0) goto L65
                return
            L65:
                org.rbmain.ui.Components.AvatarDrawable r12 = r11.avatarDrawable
                org.rbmain.tgnet.TLRPC$User r0 = r11.currentUser
                r12.setInfo(r0)
                org.rbmain.tgnet.TLRPC$User r12 = r11.currentUser
                org.rbmain.tgnet.TLRPC$UserStatus r0 = r12.status
                if (r0 == 0) goto L77
                int r0 = r0.expires
                r11.lastStatus = r0
                goto L79
            L77:
                r11.lastStatus = r3
            L79:
                if (r12 == 0) goto L84
                if (r1 != 0) goto L81
                java.lang.String r1 = org.rbmain.messenger.UserObject.getUserName(r12)
            L81:
                r11.lastName = r1
                goto L88
            L84:
                java.lang.String r12 = ""
                r11.lastName = r12
            L88:
                org.rbmain.ui.ActionBar.SimpleTextView r12 = r11.nameTextView
                java.lang.String r0 = r11.lastName
                r12.setText(r0)
                r11.lastAvatar = r2
                org.rbmain.tgnet.TLRPC$User r12 = r11.currentUser
                if (r12 == 0) goto L9d
                org.rbmain.ui.Components.BackupImageView r0 = r11.avatarImageView
                org.rbmain.ui.Components.AvatarDrawable r1 = r11.avatarDrawable
                r0.setForUserOrChat(r12, r1)
                goto La4
            L9d:
                org.rbmain.ui.Components.BackupImageView r12 = r11.avatarImageView
                org.rbmain.ui.Components.AvatarDrawable r0 = r11.avatarDrawable
                r12.setImageDrawable(r0)
            La4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.LiveViewsAlert.UserCell.update(int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int iDp;
            int iDp2;
            int iDp3;
            int iDp4;
            if (this.drawPlaceholder || this.placeholderAlpha != 0.0f) {
                LiveViewsAlert.this.placeholderPaint.setAlpha((int) (this.placeholderAlpha * 255.0f));
                canvas.drawCircle(this.avatarImageView.getLeft() + (this.avatarImageView.getMeasuredWidth() / 2), this.avatarImageView.getTop() + (this.avatarImageView.getMeasuredHeight() / 2), this.avatarImageView.getMeasuredWidth() / 2, LiveViewsAlert.this.placeholderPaint);
                if (this.placeholderNum % 2 == 0) {
                    iDp = AndroidUtilities.dp(65.0f);
                    iDp2 = AndroidUtilities.dp(48.0f);
                } else {
                    iDp = AndroidUtilities.dp(65.0f);
                    iDp2 = AndroidUtilities.dp(60.0f);
                }
                if (LocaleController.isRTL) {
                    iDp = (getMeasuredWidth() - iDp) - iDp2;
                }
                LiveViewsAlert.this.rect.set(iDp, r2 - AndroidUtilities.dp(4.0f), iDp + iDp2, AndroidUtilities.dp(4.0f) + r2);
                canvas.drawRoundRect(LiveViewsAlert.this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), LiveViewsAlert.this.placeholderPaint);
                if (this.placeholderNum % 2 == 0) {
                    iDp3 = AndroidUtilities.dp(119.0f);
                    iDp4 = AndroidUtilities.dp(60.0f);
                } else {
                    iDp3 = AndroidUtilities.dp(131.0f);
                    iDp4 = AndroidUtilities.dp(80.0f);
                }
                if (LocaleController.isRTL) {
                    iDp3 = (getMeasuredWidth() - iDp3) - iDp4;
                }
                LiveViewsAlert.this.rect.set(iDp3, r2 - AndroidUtilities.dp(4.0f), iDp3 + iDp4, r2 + AndroidUtilities.dp(4.0f));
                canvas.drawRoundRect(LiveViewsAlert.this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), LiveViewsAlert.this.placeholderPaint);
            }
            if (this.needDivider) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(64.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(64.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }
    }

    public LiveViewsAlert(final LiveActivity liveActivity, MessageObject messageObject) {
        super(liveActivity.getParentActivity(), true);
        this.placeholderPaint = new Paint(1);
        this.loadingResults = true;
        this.rect = new RectF();
        this.hasContinue = true;
        this.lastReqId = 0;
        this.viewersMap = new SparseArray<>();
        this.viewers = new ArrayList();
        this.viewersAbsMap = new HashMap();
        this.messageObject = messageObject;
        this.liveActivity = liveActivity;
        Activity parentActivity = liveActivity.getParentActivity();
        this.live = this.messageObject.messageOwner.media.live;
        TLRPC$Chat currentChat = liveActivity.getCurrentChat();
        TLRPC$User currentUser = liveActivity.getCurrentUser();
        if (ChatObject.isChannel(currentChat)) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            this.peer = tLRPC$TL_inputPeerChannel;
            tLRPC$TL_inputPeerChannel.channel_id = currentChat.id;
            tLRPC$TL_inputPeerChannel.access_hash = currentChat.access_hash;
        } else if (currentChat != null) {
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            this.peer = tLRPC$TL_inputPeerChat;
            tLRPC$TL_inputPeerChat.chat_id = currentChat.id;
        } else {
            TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            this.peer = tLRPC$TL_inputPeerUser;
            tLRPC$TL_inputPeerUser.user_id = currentUser.id;
            tLRPC$TL_inputPeerUser.access_hash = currentUser.access_hash;
        }
        getLiveViewers();
        updatePlaceholder();
        Drawable drawableMutate = parentActivity.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        int i = Theme.key_dialogBackground;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(parentActivity) { // from class: org.rbmain.ui.Components.LiveViewsAlert.2
            private boolean ignoreLayout = false;
            private RectF rect = new RectF();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int size = View.MeasureSpec.getSize(i3);
                if (Build.VERSION.SDK_INT >= 21 && !((BottomSheet) LiveViewsAlert.this).isFullscreen) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                int paddingTop = size - getPaddingTop();
                ((FrameLayout.LayoutParams) LiveViewsAlert.this.listView.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                ((FrameLayout.LayoutParams) LiveViewsAlert.this.actionBarShadow.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                int iDp = ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop + AndroidUtilities.dp(15.0f) + AndroidUtilities.statusBarHeight;
                LiveViewsAlert.this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2 - (((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft * 2)), 1073741824), i3);
                int measuredHeight = iDp + LiveViewsAlert.this.titleTextView.getMeasuredHeight() + AndroidUtilities.dp(32.0f) + (AndroidUtilities.dp(50.0f) * (LiveViewsAlert.this.listAdapter.getItemCount() - 1));
                int iDp2 = (measuredHeight < paddingTop ? paddingTop - measuredHeight : paddingTop - ((paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f);
                if (LiveViewsAlert.this.listView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    LiveViewsAlert.this.listView.setPinnedSectionOffsetY(-iDp2);
                    LiveViewsAlert.this.listView.setPadding(0, iDp2, 0, 0);
                    this.ignoreLayout = false;
                }
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                LiveViewsAlert.this.updateLayout(false);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && LiveViewsAlert.this.scrollOffsetY != 0 && motionEvent.getY() < LiveViewsAlert.this.scrollOffsetY + AndroidUtilities.dp(12.0f) && LiveViewsAlert.this.actionBar.getAlpha() == 0.0f) {
                    LiveViewsAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !LiveViewsAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                int iDp = AndroidUtilities.dp(13.0f);
                int translationY = (LiveViewsAlert.this.scrollOffsetY - ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop) - iDp;
                if (((BottomSheet) LiveViewsAlert.this).currentSheetAnimationType == 1) {
                    translationY = (int) (translationY + LiveViewsAlert.this.listView.getTranslationY());
                }
                int iDp2 = AndroidUtilities.dp(20.0f) + translationY;
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop;
                if (((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop + translationY < ActionBar.getCurrentActionBarHeight()) {
                    float fDp = iDp + AndroidUtilities.dp(4.0f);
                    float fMin = Math.min(1.0f, ((ActionBar.getCurrentActionBarHeight() - translationY) - ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop) / fDp);
                    int currentActionBarHeight = (int) ((ActionBar.getCurrentActionBarHeight() - fDp) * fMin);
                    translationY -= currentActionBarHeight;
                    iDp2 -= currentActionBarHeight;
                    measuredHeight += currentActionBarHeight;
                    f = 1.0f - fMin;
                } else {
                    f = 1.0f;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    int i2 = AndroidUtilities.statusBarHeight;
                    translationY += i2;
                    iDp2 += i2;
                }
                LiveViewsAlert.this.shadowDrawable.setBounds(0, translationY, getMeasuredWidth(), measuredHeight);
                LiveViewsAlert.this.shadowDrawable.draw(canvas);
                if (f != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(Theme.getColor(Theme.key_dialogBackground));
                    this.rect.set(((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft, ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop + translationY, getMeasuredWidth() - ((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft, ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop + translationY + AndroidUtilities.dp(24.0f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(12.0f) * f, AndroidUtilities.dp(12.0f) * f, Theme.dialogs_onlineCirclePaint);
                }
                if (f != 0.0f) {
                    int iDp3 = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp3) / 2, iDp2, (getMeasuredWidth() + iDp3) / 2, iDp2 + AndroidUtilities.dp(4.0f));
                    int color = Theme.getColor(Theme.key_sheet_scrollUp);
                    int iAlpha = Color.alpha(color);
                    Theme.dialogs_onlineCirclePaint.setColor(color);
                    Theme.dialogs_onlineCirclePaint.setAlpha((int) (iAlpha * 1.0f * f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                }
                int color2 = Theme.getColor(Theme.key_dialogBackground);
                Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (LiveViewsAlert.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(color2) * 0.8f), (int) (Color.green(color2) * 0.8f), (int) (Color.blue(color2) * 0.8f)));
                canvas.drawRect(((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) LiveViewsAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, Theme.dialogs_onlineCirclePaint);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i2 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i2, 0, i2, 0);
        RecyclerListView recyclerListView = new RecyclerListView(parentActivity) { // from class: org.rbmain.ui.Components.LiveViewsAlert.3
            long lastUpdateTime;

            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return f2 >= ((float) (LiveViewsAlert.this.scrollOffsetY + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (LiveViewsAlert.this.loadingResults) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jAbs = Math.abs(this.lastUpdateTime - jElapsedRealtime);
                    if (jAbs > 17) {
                        jAbs = 16;
                    }
                    this.lastUpdateTime = jElapsedRealtime;
                    LiveViewsAlert liveViewsAlert = LiveViewsAlert.this;
                    LiveViewsAlert.access$2716(liveViewsAlert, (jAbs * liveViewsAlert.gradientWidth) / 1800.0f);
                    while (LiveViewsAlert.this.totalTranslation >= LiveViewsAlert.this.gradientWidth * 2.0f) {
                        LiveViewsAlert liveViewsAlert2 = LiveViewsAlert.this;
                        LiveViewsAlert.access$2724(liveViewsAlert2, liveViewsAlert2.gradientWidth * 2.0f);
                    }
                    LiveViewsAlert.this.placeholderMatrix.setTranslate(LiveViewsAlert.this.totalTranslation, 0.0f);
                    LiveViewsAlert.this.placeholderGradient.setLocalMatrix(LiveViewsAlert.this.placeholderMatrix);
                    invalidateViews();
                    invalidate();
                }
                super.dispatchDraw(canvas);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setSectionsType(2);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        RecyclerListView recyclerListView2 = this.listView;
        Adapter adapter = new Adapter(parentActivity);
        this.listAdapter = adapter;
        recyclerListView2.setAdapter(adapter);
        this.listView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.LiveViewsAlert$$ExternalSyntheticLambda3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$new$0(liveActivity, view, i3);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.LiveViewsAlert.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                if (LiveViewsAlert.this.listView.getChildCount() <= 0) {
                    return;
                }
                LiveViewsAlert.this.updateLayout(true);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (i3 == 0) {
                    if (((LiveViewsAlert.this.scrollOffsetY - ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f)) + ((BottomSheet) LiveViewsAlert.this).backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || !LiveViewsAlert.this.listView.canScrollVertically(1)) {
                        return;
                    }
                    LiveViewsAlert.this.listView.getChildAt(0);
                    RecyclerListView.Holder holder = (RecyclerListView.Holder) LiveViewsAlert.this.listView.findViewHolderForAdapterPosition(0);
                    if (holder == null || holder.itemView.getTop() <= AndroidUtilities.dp(7.0f)) {
                        return;
                    }
                    LiveViewsAlert.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(7.0f));
                }
            }
        });
        TextView textView = new TextView(parentActivity);
        this.titleTextView = textView;
        textView.setTextSize(1, 18.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.titleTextView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(21.0f));
        TextView textView2 = this.titleTextView;
        int i3 = Theme.key_dialogTextBlack;
        textView2.setTextColor(Theme.getColor(i3));
        this.titleTextView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        TextView textView3 = this.titleTextView;
        textView3.setText(Emoji.replaceEmoji("poll.question", textView3.getPaint().getFontMetricsInt(), AndroidUtilities.dp(18.0f), false));
        ActionBar actionBar = new ActionBar(parentActivity) { // from class: org.rbmain.ui.Components.LiveViewsAlert.5
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                ((BottomSheet) LiveViewsAlert.this).containerView.invalidate();
            }
        };
        this.actionBar = actionBar;
        actionBar.setBackgroundColor(Theme.getColor(i));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setItemsColor(Theme.getColor(i3), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_dialogButtonSelector), false);
        this.actionBar.setTitleColor(Theme.getColor(i3));
        this.actionBar.setSubtitleColor(Theme.getColor(Theme.key_player_actionBarSubtitle));
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAlpha(0.0f);
        this.actionBar.setTitle(LocaleController.getString("LiveViewers", R.string.LiveViewers));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.Components.LiveViewsAlert.6
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i4) {
                if (i4 == -1) {
                    LiveViewsAlert.this.dismiss();
                }
            }
        });
        View view = new View(parentActivity);
        this.actionBarShadow = view;
        view.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(LiveActivity liveActivity, View view, int i) {
        if (liveActivity == null || liveActivity.getParentActivity() == null || i == 0) {
            return;
        }
        liveActivity.showBlockAbsObject(this.viewersAbsMap.get(IdStorage.getInstance().getDialogId(this.viewers.get(i - 1).id)));
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        if (this.lastReqId != 0) {
            this.liveActivity.getCoreMainClass().cancelRequest(this.lastReqId);
        }
        super.dismissInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(boolean z) {
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        int iDp = AndroidUtilities.dp(7.0f);
        if (top < AndroidUtilities.dp(7.0f) || holder == null || holder.getAdapterPosition() != 0) {
            top = iDp;
        }
        boolean z2 = top <= AndroidUtilities.dp(12.0f);
        if ((z2 && this.actionBar.getTag() == null) || (!z2 && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z2 ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            AnimatorSet animatorSet3 = this.actionBarAnimation;
            Animator[] animatorArr = new Animator[2];
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z2 ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr);
            View view = this.actionBarShadow;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = z2 ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr);
            this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.LiveViewsAlert.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    LiveViewsAlert.this.actionBarAnimation = null;
                }
            });
            this.actionBarAnimation.start();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
        int iDp2 = top + (layoutParams.topMargin - AndroidUtilities.dp(11.0f));
        if (this.scrollOffsetY != iDp2) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = iDp2;
            recyclerListView2.setTopGlowOffset(iDp2 - layoutParams.topMargin);
            this.containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholder() {
        if (this.placeholderPaint == null) {
            return;
        }
        int color = Theme.getColor(Theme.key_dialogBackground);
        int color2 = Theme.getColor(Theme.key_dialogBackgroundGray);
        int averageColor = AndroidUtilities.getAverageColor(color2, color);
        this.placeholderPaint.setColor(color2);
        float fDp = AndroidUtilities.dp(500.0f);
        this.gradientWidth = fDp;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, fDp, 0.0f, new int[]{color2, averageColor, color2}, new float[]{0.0f, 0.18f, 0.36f}, Shader.TileMode.REPEAT);
        this.placeholderGradient = linearGradient;
        this.placeholderPaint.setShader(linearGradient);
        Matrix matrix = new Matrix();
        this.placeholderMatrix = matrix;
        this.placeholderGradient.setLocalMatrix(matrix);
    }

    public void getLiveViewers() {
        if (this.hasContinue && this.lastReqId == 0) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.LiveViewsAlert$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getLiveViewers$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLiveViewers$1() {
        this.lastReqId = this.liveActivity.getCoreMainClass().getLiveViewers(this.live.live_id, this.start_id, new LoadListener<LiveModels.GetLiveViewersOutput>() { // from class: org.rbmain.ui.Components.LiveViewsAlert.8
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LiveModels.GetLiveViewersOutput getLiveViewersOutput) {
                LiveViewsAlert.this.lastReqId = 0;
                LiveViewsAlert.this.hasContinue = getLiveViewersOutput.has_continue;
                LiveViewsAlert.this.start_id = getLiveViewersOutput.next_start_id;
                ArrayList<ChatAbsObject> arrayList = getLiveViewersOutput.abs_objects;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<ChatAbsObject> it = getLiveViewersOutput.abs_objects.iterator();
                    while (it.hasNext()) {
                        ChatAbsObject next = it.next();
                        int iGenerateDialogId = (int) IdStorage.getInstance().generateDialogId(next.object_guid);
                        LiveViewsAlert.this.viewersMap.put(iGenerateDialogId, ChatConverter.convertUser(LiveViewsAlert.this.liveActivity.getCoreMainClass(), iGenerateDialogId, next, (UserInfo) null, (Chat) null));
                        LiveViewsAlert.this.viewersAbsMap.put(next.object_guid, next);
                    }
                }
                LiveViewsAlert.this.updateList();
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LiveViewsAlert.this.lastReqId = 0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateList() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.LiveViewsAlert$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateList$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateList$2() {
        this.viewers.clear();
        if (this.viewersMap.size() > 0) {
            for (int i = 0; i < this.viewersMap.size(); i++) {
                this.viewers.add(this.viewersMap.get(this.viewersMap.keyAt(i)));
            }
        }
        this.listAdapter.notifyDataSetChanged();
    }

    public class Adapter extends RecyclerListView.FastScrollAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
        }

        public Adapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.itemView instanceof UserCell;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View userCell;
            if (i == 0) {
                TextCell textCell = new TextCell(this.mContext, 23, true);
                textCell.setOffsetFromImage(65);
                textCell.setColors(Theme.key_switchTrackChecked, Theme.key_windowBackgroundWhiteBlueText4);
                userCell = textCell;
            } else {
                userCell = i != 1 ? null : LiveViewsAlert.this.new UserCell(this.mContext);
            }
            return new RecyclerListView.Holder(userCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i == getItemCount() - 1 && LiveViewsAlert.this.hasContinue) {
                LiveViewsAlert.this.getLiveViewers();
            }
            View view = viewHolder.itemView;
            if (view instanceof TextCell) {
                ((TextCell) view).setText(LocaleController.getString(R.string.LiveViewers), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 1) {
                UserCell userCell = (UserCell) viewHolder.itemView;
                int adapterPosition = viewHolder.getAdapterPosition();
                userCell.setData((TLRPC$User) LiveViewsAlert.this.viewers.get(adapterPosition - 1), adapterPosition, adapterPosition != getItemCount() - 1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LiveViewsAlert.this.viewers.size() + 1;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.Components.LiveViewsAlert$$ExternalSyntheticLambda2
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updatePlaceholder();
            }
        };
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, null, null, Theme.key_sheet_scrollUp));
        ViewGroup viewGroup = this.containerView;
        Drawable[] drawableArr = {this.shadowDrawable};
        int i = Theme.key_dialogBackground;
        arrayList.add(new ThemeDescription(viewGroup, 0, null, null, drawableArr, null, i));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_dialogScrollGlow));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_AB_ITEMSCOLOR;
        int i3 = Theme.key_dialogTextBlack;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBTITLECOLOR, null, null, null, null, Theme.key_player_actionBarSubtitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBarShadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_dialogShadowLine));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, i));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_dialogBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        return arrayList;
    }
}
