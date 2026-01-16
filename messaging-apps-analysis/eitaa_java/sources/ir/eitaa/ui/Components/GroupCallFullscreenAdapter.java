package ir.eitaa.ui.Components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.GroupCallUserCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.voip.GroupCallMiniTextureView;
import ir.eitaa.ui.Components.voip.GroupCallRenderersContainer;
import ir.eitaa.ui.Components.voip.GroupCallStatusIcon;
import ir.eitaa.ui.GroupCallActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupCallFullscreenAdapter extends RecyclerListView.SelectionAdapter {
    private final GroupCallActivity activity;
    private ArrayList<GroupCallMiniTextureView> attachedRenderers;
    private final int currentAccount;
    private ChatObject.Call groupCall;
    private GroupCallRenderersContainer renderersContainer;
    private final ArrayList<ChatObject.VideoParticipant> videoParticipants = new ArrayList<>();
    private final ArrayList<TLRPC$TL_groupCallParticipant> participants = new ArrayList<>();
    private boolean visible = false;

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return false;
    }

    public GroupCallFullscreenAdapter(ChatObject.Call groupCall, int currentAccount, GroupCallActivity activity) {
        this.groupCall = groupCall;
        this.currentAccount = currentAccount;
        this.activity = activity;
    }

    public void setRenderersPool(ArrayList<GroupCallMiniTextureView> attachedRenderers, GroupCallRenderersContainer renderersContainer) {
        this.attachedRenderers = attachedRenderers;
        this.renderersContainer = renderersContainer;
    }

    public void setGroupCall(ChatObject.Call groupCall) {
        this.groupCall = groupCall;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerListView.Holder(new GroupCallUserCell(parent.getContext()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatObject.VideoParticipant videoParticipant;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        GroupCallUserCell groupCallUserCell = (GroupCallUserCell) holder.itemView;
        ChatObject.VideoParticipant videoParticipant2 = groupCallUserCell.videoParticipant;
        if (position < this.videoParticipants.size()) {
            videoParticipant = this.videoParticipants.get(position);
            tLRPC$TL_groupCallParticipant = this.videoParticipants.get(position).participant;
        } else {
            if (position - this.videoParticipants.size() >= this.participants.size()) {
                return;
            }
            videoParticipant = null;
            tLRPC$TL_groupCallParticipant = this.participants.get(position - this.videoParticipants.size());
        }
        groupCallUserCell.setParticipant(videoParticipant, tLRPC$TL_groupCallParticipant);
        if (videoParticipant2 != null && !videoParticipant2.equals(videoParticipant) && groupCallUserCell.attached && groupCallUserCell.getRenderer() != null) {
            groupCallUserCell.attachRenderer(false);
            if (videoParticipant != null) {
                groupCallUserCell.attachRenderer(true);
                return;
            }
            return;
        }
        if (groupCallUserCell.attached) {
            if (groupCallUserCell.getRenderer() == null && videoParticipant != null && this.visible) {
                groupCallUserCell.attachRenderer(true);
            } else {
                if (groupCallUserCell.getRenderer() == null || videoParticipant != null) {
                    return;
                }
                groupCallUserCell.attachRenderer(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.videoParticipants.size() + this.participants.size();
    }

    public void setVisibility(RecyclerListView listView, boolean visibility) {
        this.visible = visibility;
        for (int i = 0; i < listView.getChildCount(); i++) {
            View childAt = listView.getChildAt(i);
            if (childAt instanceof GroupCallUserCell) {
                GroupCallUserCell groupCallUserCell = (GroupCallUserCell) childAt;
                if (groupCallUserCell.getVideoParticipant() != null) {
                    groupCallUserCell.attachRenderer(visibility);
                }
            }
        }
    }

    public void scrollTo(ChatObject.VideoParticipant videoParticipant, RecyclerListView fullscreenUsersListView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) fullscreenUsersListView.getLayoutManager();
        if (linearLayoutManager == null) {
            return;
        }
        for (int i = 0; i < this.videoParticipants.size(); i++) {
            if (this.videoParticipants.get(i).equals(videoParticipant)) {
                linearLayoutManager.scrollToPositionWithOffset(i, AndroidUtilities.dp(13.0f));
                return;
            }
        }
    }

    public class GroupCallUserCell extends FrameLayout implements GroupCallStatusIcon.Callback {
        boolean attached;
        AvatarDrawable avatarDrawable;
        private BackupImageView avatarImageView;
        GroupCallUserCell.AvatarWavesDrawable avatarWavesDrawable;
        Paint backgroundPaint;
        ValueAnimator colorAnimator;
        private TLRPC$Chat currentChat;
        private TLRPC$User currentUser;
        String drawingName;
        boolean hasAvatar;
        int lastColor;
        int lastWavesColor;
        RLottieImageView muteButton;
        String name;
        int nameWidth;
        TLRPC$TL_groupCallParticipant participant;
        long peerId;
        float progress;
        GroupCallMiniTextureView renderer;
        boolean selected;
        Paint selectionPaint;
        float selectionProgress;
        boolean skipInvalidate;
        GroupCallStatusIcon statusIcon;
        TextPaint textPaint;
        ChatObject.VideoParticipant videoParticipant;

        public GroupCallUserCell(Context context) {
            super(context);
            this.avatarDrawable = new AvatarDrawable();
            this.backgroundPaint = new Paint(1);
            this.selectionPaint = new Paint(1);
            this.progress = 1.0f;
            this.textPaint = new TextPaint(1);
            this.avatarWavesDrawable = new GroupCallUserCell.AvatarWavesDrawable(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(29.0f));
            this.avatarDrawable.setTextSize((int) (AndroidUtilities.dp(18.0f) / 1.15f));
            BackupImageView backupImageView = new BackupImageView(context);
            this.avatarImageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(20.0f));
            addView(this.avatarImageView, LayoutHelper.createFrame(40, 40.0f, 1, 0.0f, 9.0f, 0.0f, 9.0f));
            setWillNotDraw(false);
            this.backgroundPaint.setColor(Theme.getColor("voipgroup_listViewBackground"));
            this.selectionPaint.setColor(Theme.getColor("voipgroup_speakingText"));
            this.selectionPaint.setStyle(Paint.Style.STROKE);
            this.selectionPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
            this.textPaint.setColor(-1);
            RLottieImageView rLottieImageView = new RLottieImageView(context) { // from class: ir.eitaa.ui.Components.GroupCallFullscreenAdapter.GroupCallUserCell.1
                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    GroupCallUserCell.this.invalidate();
                }
            };
            this.muteButton = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.muteButton, LayoutHelper.createFrame(24, 24.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
            if (this.name != null) {
                int iMin = (int) Math.min(AndroidUtilities.dp(46.0f), this.textPaint.measureText(this.name));
                this.nameWidth = iMin;
                this.drawingName = TextUtils.ellipsize(this.name, this.textPaint, iMin, TextUtils.TruncateAt.END).toString();
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        }

        public void setParticipant(ChatObject.VideoParticipant videoParticipant, TLRPC$TL_groupCallParticipant participant) {
            this.videoParticipant = videoParticipant;
            this.participant = participant;
            long j = this.peerId;
            long peerId = MessageObject.getPeerId(participant.peer);
            this.peerId = peerId;
            if (peerId > 0) {
                TLRPC$User user = AccountInstance.getInstance(GroupCallFullscreenAdapter.this.currentAccount).getMessagesController().getUser(Long.valueOf(this.peerId));
                this.currentUser = user;
                this.currentChat = null;
                this.avatarDrawable.setInfo(user);
                this.name = UserObject.getFirstName(this.currentUser);
                this.avatarImageView.getImageReceiver().setCurrentAccount(GroupCallFullscreenAdapter.this.currentAccount);
                ImageLocation forUser = ImageLocation.getForUser(this.currentUser, 1);
                this.hasAvatar = forUser != null;
                this.avatarImageView.setImage(forUser, "50_50", this.avatarDrawable, this.currentUser);
            } else {
                TLRPC$Chat chat = AccountInstance.getInstance(GroupCallFullscreenAdapter.this.currentAccount).getMessagesController().getChat(Long.valueOf(-this.peerId));
                this.currentChat = chat;
                this.currentUser = null;
                this.avatarDrawable.setInfo(chat);
                TLRPC$Chat tLRPC$Chat = this.currentChat;
                if (tLRPC$Chat != null) {
                    this.name = tLRPC$Chat.title;
                    this.avatarImageView.getImageReceiver().setCurrentAccount(GroupCallFullscreenAdapter.this.currentAccount);
                    ImageLocation forChat = ImageLocation.getForChat(this.currentChat, 1);
                    this.hasAvatar = forChat != null;
                    this.avatarImageView.setImage(forChat, "50_50", this.avatarDrawable, this.currentChat);
                }
            }
            boolean z = j == this.peerId;
            if (videoParticipant == null) {
                this.selected = GroupCallFullscreenAdapter.this.renderersContainer.fullscreenPeerId == MessageObject.getPeerId(participant.peer);
            } else if (GroupCallFullscreenAdapter.this.renderersContainer.fullscreenParticipant != null) {
                this.selected = GroupCallFullscreenAdapter.this.renderersContainer.fullscreenParticipant.equals(videoParticipant);
            } else {
                this.selected = false;
            }
            if (!z) {
                setSelectedProgress(this.selected ? 1.0f : 0.0f);
            }
            GroupCallStatusIcon groupCallStatusIcon = this.statusIcon;
            if (groupCallStatusIcon != null) {
                groupCallStatusIcon.setParticipant(participant, z);
                updateState(z);
            }
        }

        @Override // android.view.View
        public void setAlpha(float alpha) {
            super.setAlpha(alpha);
        }

        public void setProgressToFullscreen(float progress) {
            if (this.progress == progress) {
                return;
            }
            this.progress = progress;
            if (progress == 1.0f) {
                this.avatarImageView.setTranslationY(0.0f);
                this.avatarImageView.setScaleX(1.0f);
                this.avatarImageView.setScaleY(1.0f);
                this.backgroundPaint.setAlpha(255);
                invalidate();
                GroupCallMiniTextureView groupCallMiniTextureView = this.renderer;
                if (groupCallMiniTextureView != null) {
                    groupCallMiniTextureView.invalidate();
                    return;
                }
                return;
            }
            float f = 1.0f - progress;
            float fDp = ((AndroidUtilities.dp(46.0f) / AndroidUtilities.dp(40.0f)) * f) + (1.0f * progress);
            this.avatarImageView.setTranslationY((-((this.avatarImageView.getTop() + (this.avatarImageView.getMeasuredHeight() / 2.0f)) - (getMeasuredHeight() / 2.0f))) * f);
            this.avatarImageView.setScaleX(fDp);
            this.avatarImageView.setScaleY(fDp);
            this.backgroundPaint.setAlpha((int) (progress * 255.0f));
            invalidate();
            GroupCallMiniTextureView groupCallMiniTextureView2 = this.renderer;
            if (groupCallMiniTextureView2 != null) {
                groupCallMiniTextureView2.invalidate();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            GroupCallMiniTextureView groupCallMiniTextureView = this.renderer;
            if (groupCallMiniTextureView != null && groupCallMiniTextureView.isFullyVisible() && !GroupCallFullscreenAdapter.this.activity.drawingForBlur) {
                drawSelection(canvas);
                return;
            }
            if (this.progress > 0.0f) {
                float measuredWidth = (getMeasuredWidth() / 2.0f) * (1.0f - this.progress);
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(measuredWidth, measuredWidth, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - measuredWidth);
                canvas.drawRoundRect(rectF, AndroidUtilities.dp(13.0f), AndroidUtilities.dp(13.0f), this.backgroundPaint);
                drawSelection(canvas);
            }
            float x = this.avatarImageView.getX() + (this.avatarImageView.getMeasuredWidth() / 2);
            float y = this.avatarImageView.getY() + (this.avatarImageView.getMeasuredHeight() / 2);
            this.avatarWavesDrawable.update();
            this.avatarWavesDrawable.draw(canvas, x, y, this);
            float f = this.progress;
            float fDp = ((AndroidUtilities.dp(46.0f) / AndroidUtilities.dp(40.0f)) * (1.0f - f)) + (f * 1.0f);
            this.avatarImageView.setScaleX(this.avatarWavesDrawable.getAvatarScale() * fDp);
            this.avatarImageView.setScaleY(this.avatarWavesDrawable.getAvatarScale() * fDp);
            super.dispatchDraw(canvas);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void drawSelection(android.graphics.Canvas r7) {
            /*
                r6 = this;
                boolean r0 = r6.selected
                r1 = 1037726734(0x3dda740e, float:0.10666667)
                r2 = 0
                r3 = 1065353216(0x3f800000, float:1.0)
                if (r0 == 0) goto L1f
                float r4 = r6.selectionProgress
                int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r5 == 0) goto L1f
                float r4 = r4 + r1
                int r0 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r0 <= 0) goto L18
                r4 = 1065353216(0x3f800000, float:1.0)
                goto L1b
            L18:
                r6.invalidate()
            L1b:
                r6.setSelectedProgress(r4)
                goto L34
            L1f:
                if (r0 != 0) goto L34
                float r0 = r6.selectionProgress
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L34
                float r0 = r0 - r1
                int r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r1 >= 0) goto L2e
                r0 = 0
                goto L31
            L2e:
                r6.invalidate()
            L31:
                r6.setSelectedProgress(r0)
            L34:
                float r0 = r6.selectionProgress
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L7a
                int r0 = r6.getMeasuredWidth()
                float r0 = (float) r0
                r1 = 1073741824(0x40000000, float:2.0)
                float r0 = r0 / r1
                float r2 = r6.progress
                float r3 = r3 - r2
                float r0 = r0 * r3
                android.graphics.RectF r2 = ir.eitaa.messenger.AndroidUtilities.rectTmp
                int r3 = r6.getMeasuredWidth()
                float r3 = (float) r3
                float r3 = r3 - r0
                int r4 = r6.getMeasuredHeight()
                float r4 = (float) r4
                float r4 = r4 - r0
                r2.set(r0, r0, r3, r4)
                android.graphics.Paint r0 = r6.selectionPaint
                float r0 = r0.getStrokeWidth()
                float r0 = r0 / r1
                android.graphics.Paint r3 = r6.selectionPaint
                float r3 = r3.getStrokeWidth()
                float r3 = r3 / r1
                r2.inset(r0, r3)
                r0 = 1094713344(0x41400000, float:12.0)
                int r1 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
                float r1 = (float) r1
                int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
                float r0 = (float) r0
                android.graphics.Paint r3 = r6.selectionPaint
                r7.drawRoundRect(r2, r1, r0, r3)
            L7a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupCallFullscreenAdapter.GroupCallUserCell.drawSelection(android.graphics.Canvas):void");
        }

        private void setSelectedProgress(float p) {
            if (this.selectionProgress != p) {
                this.selectionProgress = p;
                this.selectionPaint.setAlpha((int) (p * 255.0f));
            }
        }

        public long getPeerId() {
            return this.peerId;
        }

        public BackupImageView getAvatarImageView() {
            return this.avatarImageView;
        }

        public TLRPC$TL_groupCallParticipant getParticipant() {
            return this.participant;
        }

        public ChatObject.VideoParticipant getVideoParticipant() {
            return this.videoParticipant;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (GroupCallFullscreenAdapter.this.visible && this.videoParticipant != null) {
                attachRenderer(true);
            }
            this.attached = true;
            if (GroupCallFullscreenAdapter.this.activity.statusIconPool.size() > 0) {
                this.statusIcon = GroupCallFullscreenAdapter.this.activity.statusIconPool.remove(GroupCallFullscreenAdapter.this.activity.statusIconPool.size() - 1);
            } else {
                this.statusIcon = new GroupCallStatusIcon();
            }
            this.statusIcon.setCallback(this);
            this.statusIcon.setImageView(this.muteButton);
            this.statusIcon.setParticipant(this.participant, false);
            updateState(false);
            this.avatarWavesDrawable.setShowWaves(this.statusIcon.isSpeaking(), this);
            if (this.statusIcon.isSpeaking()) {
                return;
            }
            this.avatarWavesDrawable.setAmplitude(0.0d);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            attachRenderer(false);
            this.attached = false;
            if (this.statusIcon != null) {
                GroupCallFullscreenAdapter.this.activity.statusIconPool.add(this.statusIcon);
                this.statusIcon.setImageView(null);
                this.statusIcon.setCallback(null);
            }
            this.statusIcon = null;
        }

        public void attachRenderer(boolean attach) {
            if (GroupCallFullscreenAdapter.this.activity.isDismissed()) {
                return;
            }
            if (attach && this.renderer == null) {
                this.renderer = GroupCallMiniTextureView.getOrCreate(GroupCallFullscreenAdapter.this.attachedRenderers, GroupCallFullscreenAdapter.this.renderersContainer, null, this, null, this.videoParticipant, GroupCallFullscreenAdapter.this.groupCall, GroupCallFullscreenAdapter.this.activity);
            } else {
                if (attach) {
                    return;
                }
                GroupCallMiniTextureView groupCallMiniTextureView = this.renderer;
                if (groupCallMiniTextureView != null) {
                    groupCallMiniTextureView.setSecondaryView(null);
                }
                this.renderer = null;
            }
        }

        public void setRenderer(GroupCallMiniTextureView renderer) {
            this.renderer = renderer;
        }

        public void drawOverlays(Canvas canvas) {
            if (this.drawingName != null) {
                canvas.save();
                int measuredWidth = ((getMeasuredWidth() - this.nameWidth) - AndroidUtilities.dp(24.0f)) / 2;
                this.textPaint.setAlpha((int) (this.progress * 255.0f * getAlpha()));
                canvas.drawText(this.drawingName, AndroidUtilities.dp(22.0f) + measuredWidth, AndroidUtilities.dp(69.0f), this.textPaint);
                canvas.restore();
                canvas.save();
                canvas.translate(measuredWidth, AndroidUtilities.dp(53.0f));
                if (this.muteButton.getDrawable() != null) {
                    this.muteButton.getDrawable().setAlpha((int) (this.progress * 255.0f * getAlpha()));
                    this.muteButton.draw(canvas);
                    this.muteButton.getDrawable().setAlpha(255);
                }
                canvas.restore();
            }
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            if (child == this.muteButton) {
                return true;
            }
            return super.drawChild(canvas, child, drawingTime);
        }

        public float getProgressToFullscreen() {
            return this.progress;
        }

        public GroupCallMiniTextureView getRenderer() {
            return this.renderer;
        }

        public void setAmplitude(double value) {
            GroupCallStatusIcon groupCallStatusIcon = this.statusIcon;
            if (groupCallStatusIcon != null) {
                groupCallStatusIcon.setAmplitude(value);
            }
            this.avatarWavesDrawable.setAmplitude(value);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateState(boolean r10) {
            /*
                r9 = this;
                ir.eitaa.ui.Components.voip.GroupCallStatusIcon r0 = r9.statusIcon
                if (r0 != 0) goto L5
                return
            L5:
                r0.updateIcon(r10)
                ir.eitaa.ui.Components.voip.GroupCallStatusIcon r0 = r9.statusIcon
                boolean r0 = r0.isMutedByMe()
                if (r0 == 0) goto L18
                java.lang.String r0 = "voipgroup_mutedByAdminIcon"
                int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r0)
            L16:
                r1 = r0
                goto L33
            L18:
                ir.eitaa.ui.Components.voip.GroupCallStatusIcon r0 = r9.statusIcon
                boolean r0 = r0.isSpeaking()
                if (r0 == 0) goto L27
                java.lang.String r0 = "voipgroup_speakingText"
                int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r0)
                goto L16
            L27:
                java.lang.String r0 = "voipgroup_nameText"
                int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r0)
                java.lang.String r1 = "voipgroup_listeningText"
                int r1 = ir.eitaa.ui.ActionBar.Theme.getColor(r1)
            L33:
                if (r10 != 0) goto L6c
                android.animation.ValueAnimator r10 = r9.colorAnimator
                if (r10 == 0) goto L41
                r10.removeAllListeners()
                android.animation.ValueAnimator r10 = r9.colorAnimator
                r10.cancel()
            L41:
                r9.lastColor = r0
                r9.lastWavesColor = r1
                ir.eitaa.ui.Components.RLottieImageView r10 = r9.muteButton
                android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r2.<init>(r0, r3)
                r10.setColorFilter(r2)
                android.text.TextPaint r10 = r9.textPaint
                int r0 = r9.lastColor
                r10.setColor(r0)
                android.graphics.Paint r10 = r9.selectionPaint
                r10.setColor(r1)
                ir.eitaa.ui.Cells.GroupCallUserCell$AvatarWavesDrawable r10 = r9.avatarWavesDrawable
                r0 = 38
                int r0 = androidx.core.graphics.ColorUtils.setAlphaComponent(r1, r0)
                r10.setColor(r0)
                r9.invalidate()
                goto L97
            L6c:
                int r4 = r9.lastColor
                int r6 = r9.lastWavesColor
                r10 = 2
                float[] r10 = new float[r10]
                r10 = {x0098: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
                android.animation.ValueAnimator r10 = android.animation.ValueAnimator.ofFloat(r10)
                r9.colorAnimator = r10
                ir.eitaa.ui.Components.-$$Lambda$GroupCallFullscreenAdapter$GroupCallUserCell$deq1YpaKJBFX4z5-YXts9F62A2s r8 = new ir.eitaa.ui.Components.-$$Lambda$GroupCallFullscreenAdapter$GroupCallUserCell$deq1YpaKJBFX4z5-YXts9F62A2s
                r2 = r8
                r3 = r9
                r5 = r0
                r7 = r1
                r2.<init>()
                r10.addUpdateListener(r8)
                android.animation.ValueAnimator r10 = r9.colorAnimator
                ir.eitaa.ui.Components.GroupCallFullscreenAdapter$GroupCallUserCell$2 r2 = new ir.eitaa.ui.Components.GroupCallFullscreenAdapter$GroupCallUserCell$2
                r2.<init>()
                r10.addListener(r2)
                android.animation.ValueAnimator r10 = r9.colorAnimator
                r10.start()
            L97:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupCallFullscreenAdapter.GroupCallUserCell.updateState(boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateState$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateState$0$GroupCallFullscreenAdapter$GroupCallUserCell(int i, int i2, int i3, int i4, ValueAnimator valueAnimator) {
            this.lastColor = ColorUtils.blendARGB(i, i2, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.lastWavesColor = ColorUtils.blendARGB(i3, i4, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.muteButton.setColorFilter(new PorterDuffColorFilter(this.lastColor, PorterDuff.Mode.MULTIPLY));
            this.textPaint.setColor(this.lastColor);
            this.selectionPaint.setColor(this.lastWavesColor);
            this.avatarWavesDrawable.setColor(ColorUtils.setAlphaComponent(this.lastWavesColor, 38));
            invalidate();
        }

        @Override // android.view.View
        public void invalidate() {
            if (this.skipInvalidate) {
                return;
            }
            this.skipInvalidate = true;
            super.invalidate();
            GroupCallMiniTextureView groupCallMiniTextureView = this.renderer;
            if (groupCallMiniTextureView == null) {
                GroupCallFullscreenAdapter.this.renderersContainer.invalidate();
            } else {
                groupCallMiniTextureView.invalidate();
            }
            this.skipInvalidate = false;
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallStatusIcon.Callback
        public void onStatusChanged() {
            this.avatarWavesDrawable.setShowWaves(this.statusIcon.isSpeaking(), this);
            updateState(true);
        }

        public boolean isRemoving(RecyclerListView listView) {
            return listView.getChildAdapterPosition(this) == -1;
        }
    }

    public void update(boolean animated, RecyclerListView listView) {
        if (this.groupCall == null) {
            return;
        }
        if (animated) {
            final ArrayList arrayList = new ArrayList(this.participants);
            final ArrayList arrayList2 = new ArrayList(this.videoParticipants);
            this.participants.clear();
            this.participants.addAll(this.groupCall.visibleParticipants);
            this.videoParticipants.clear();
            this.videoParticipants.addAll(this.groupCall.visibleVideoParticipants);
            DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: ir.eitaa.ui.Components.GroupCallFullscreenAdapter.1
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return true;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return arrayList2.size() + arrayList.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return GroupCallFullscreenAdapter.this.videoParticipants.size() + GroupCallFullscreenAdapter.this.participants.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
                    if (oldItemPosition < arrayList2.size() && newItemPosition < GroupCallFullscreenAdapter.this.videoParticipants.size()) {
                        return ((ChatObject.VideoParticipant) arrayList2.get(oldItemPosition)).equals(GroupCallFullscreenAdapter.this.videoParticipants.get(newItemPosition));
                    }
                    int size = oldItemPosition - arrayList2.size();
                    int size2 = newItemPosition - GroupCallFullscreenAdapter.this.videoParticipants.size();
                    if (size2 >= 0 && size2 < GroupCallFullscreenAdapter.this.participants.size() && size >= 0 && size < arrayList.size()) {
                        return MessageObject.getPeerId(((TLRPC$TL_groupCallParticipant) arrayList.get(size)).peer) == MessageObject.getPeerId(((TLRPC$TL_groupCallParticipant) GroupCallFullscreenAdapter.this.participants.get(size2)).peer);
                    }
                    if (oldItemPosition < arrayList2.size()) {
                        tLRPC$TL_groupCallParticipant = ((ChatObject.VideoParticipant) arrayList2.get(oldItemPosition)).participant;
                    } else {
                        tLRPC$TL_groupCallParticipant = (TLRPC$TL_groupCallParticipant) arrayList.get(size);
                    }
                    return MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == MessageObject.getPeerId((newItemPosition < GroupCallFullscreenAdapter.this.videoParticipants.size() ? ((ChatObject.VideoParticipant) GroupCallFullscreenAdapter.this.videoParticipants.get(newItemPosition)).participant : (TLRPC$TL_groupCallParticipant) GroupCallFullscreenAdapter.this.participants.get(size2)).peer);
                }
            }).dispatchUpdatesTo(this);
            AndroidUtilities.updateVisibleRows(listView);
            return;
        }
        this.participants.clear();
        this.participants.addAll(this.groupCall.visibleParticipants);
        this.videoParticipants.clear();
        this.videoParticipants.addAll(this.groupCall.visibleVideoParticipants);
        notifyDataSetChanged();
    }
}
