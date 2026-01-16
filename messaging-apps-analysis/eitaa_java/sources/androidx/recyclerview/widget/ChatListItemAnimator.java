package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.BotHelpCell;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.ChatGreetingsView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.TextMessageEnterTransition;
import ir.eitaa.ui.VoiceMessageEnterTransition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ChatListItemAnimator extends DefaultItemAnimator {
    public static final Interpolator DEFAULT_INTERPOLATOR = new CubicBezierInterpolator(0.19919472913616398d, 0.010644531250000006d, 0.27920937042459737d, 0.91025390625d);
    private final ChatActivity activity;
    long alphaEnterDelay;
    private ChatGreetingsView chatGreetingsView;
    private RecyclerView.ViewHolder greetingsSticker;
    private final RecyclerListView recyclerListView;
    boolean reset;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean reversePositions;
    private boolean shouldAnimateEnterFromBottom;
    private HashMap<Integer, MessageObject.GroupedMessages> willRemovedGroup = new HashMap<>();
    private ArrayList<MessageObject.GroupedMessages> willChangedGroups = new ArrayList<>();
    HashMap<RecyclerView.ViewHolder, Animator> animators = new HashMap<>();
    ArrayList<Runnable> runOnAnimationsEnd = new ArrayList<>();
    HashMap<Long, Long> groupIdToEnterDelay = new HashMap<>();

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public long getChangeDuration() {
        return 250L;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    protected long getMoveAnimationDelay() {
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public long getMoveDuration() {
        return 250L;
    }

    public void onAnimationStart() {
    }

    public ChatListItemAnimator(ChatActivity activity, RecyclerListView listView, Theme.ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.activity = activity;
        this.recyclerListView = listView;
        this.translationInterpolator = DEFAULT_INTERPOLATOR;
        setSupportsChangeAnimations(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void runPendingAnimations() {
        /*
            r6 = this;
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r6.mPendingRemovals
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            java.util.ArrayList<androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo> r2 = r6.mPendingMoves
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r1
            java.util.ArrayList<androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo> r3 = r6.mPendingChanges
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r1
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r4 = r6.mPendingAdditions
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r1
            if (r0 != 0) goto L26
            if (r2 != 0) goto L26
            if (r4 != 0) goto L26
            if (r3 != 0) goto L26
            return
        L26:
            boolean r0 = r6.shouldAnimateEnterFromBottom
            r2 = 0
            if (r0 == 0) goto L70
            r0 = 0
            r3 = 0
        L2d:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r4 = r6.mPendingAdditions
            int r4 = r4.size()
            if (r0 >= r4) goto L6f
            boolean r4 = r6.reversePositions
            if (r4 == 0) goto L5d
            ir.eitaa.ui.Components.RecyclerListView r4 = r6.recyclerListView
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r4.getAdapter()
            if (r4 != 0) goto L43
            r4 = 0
            goto L4d
        L43:
            ir.eitaa.ui.Components.RecyclerListView r4 = r6.recyclerListView
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r4.getAdapter()
            int r4 = r4.getItemCount()
        L4d:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r5 = r6.mPendingAdditions
            java.lang.Object r5 = r5.get(r0)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r5 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r5
            int r5 = r5.getLayoutPosition()
            int r4 = r4 - r1
            if (r5 != r4) goto L6c
            goto L6b
        L5d:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r4 = r6.mPendingAdditions
            java.lang.Object r4 = r4.get(r0)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r4 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r4
            int r4 = r4.getLayoutPosition()
            if (r4 != 0) goto L6c
        L6b:
            r3 = 1
        L6c:
            int r0 = r0 + 1
            goto L2d
        L6f:
            r2 = r3
        L70:
            r6.onAnimationStart()
            if (r2 == 0) goto L79
            r6.runMessageEnterTransition()
            goto L7c
        L79:
            r6.runAlphaEnterTransition()
        L7c:
            r0 = 2
            float[] r0 = new float[r0]
            r0 = {x009e: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r0 = android.animation.ValueAnimator.ofFloat(r0)
            androidx.recyclerview.widget.-$$Lambda$ChatListItemAnimator$wgAhkmlJimTkWjuWDt7_4VCnHdc r1 = new androidx.recyclerview.widget.-$$Lambda$ChatListItemAnimator$wgAhkmlJimTkWjuWDt7_4VCnHdc
            r1.<init>()
            r0.addUpdateListener(r1)
            long r1 = r6.getRemoveDuration()
            long r3 = r6.getMoveDuration()
            long r1 = r1 + r3
            r0.setDuration(r1)
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ChatListItemAnimator.runPendingAnimations():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runPendingAnimations$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runPendingAnimations$0$ChatListItemAnimator(ValueAnimator valueAnimator) {
        ChatActivity chatActivity = this.activity;
        if (chatActivity != null) {
            chatActivity.onListItemAniamtorTick();
        } else {
            this.recyclerListView.invalidate();
        }
    }

    private void runAlphaEnterTransition() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z2) {
                final ArrayList<DefaultItemAnimator.MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.ChatListItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.MoveInfo moveInfo = (DefaultItemAnimator.MoveInfo) it2.next();
                            ChatListItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo);
                        }
                        arrayList.clear();
                        ChatListItemAnimator.this.mMovesList.remove(arrayList);
                    }
                };
                if (this.delayAnimations && z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).holder.itemView, runnable, getMoveAnimationDelay());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<DefaultItemAnimator.ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.ChatListItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            ChatListItemAnimator.this.animateChangeImpl((DefaultItemAnimator.ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        ChatListItemAnimator.this.mChangesList.remove(arrayList2);
                    }
                };
                if (this.delayAnimations && z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).oldHolder.itemView, runnable2, 0L);
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mPendingAdditions);
                this.mPendingAdditions.clear();
                this.alphaEnterDelay = 0L;
                Collections.sort(arrayList3, $$Lambda$ChatListItemAnimator$fMA4B9JeOB9Sk0vsM3Ncxldsc.INSTANCE);
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    animateAddImpl((RecyclerView.ViewHolder) it2.next());
                }
                arrayList3.clear();
            }
        }
    }

    static /* synthetic */ int lambda$runAlphaEnterTransition$1(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return viewHolder2.itemView.getTop() - viewHolder.itemView.getTop();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void runMessageEnterTransition() {
        /*
            r6 = this;
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r6.mPendingRemovals
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            java.util.ArrayList<androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo> r1 = r6.mPendingMoves
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            java.util.ArrayList<androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo> r2 = r6.mPendingChanges
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r3 = r6.mPendingAdditions
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ 1
            if (r0 != 0) goto L29
            if (r1 != 0) goto L29
            if (r3 != 0) goto L29
            if (r2 != 0) goto L29
            return
        L29:
            r0 = 0
            r2 = 0
        L2b:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r4 = r6.mPendingAdditions
            int r4 = r4.size()
            if (r0 >= r4) goto L66
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r4 = r6.mPendingAdditions
            java.lang.Object r4 = r4.get(r0)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r4 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r4
            android.view.View r4 = r4.itemView
            boolean r5 = r4 instanceof ir.eitaa.ui.Cells.ChatMessageCell
            if (r5 == 0) goto L54
            ir.eitaa.ui.Cells.ChatMessageCell r4 = (ir.eitaa.ui.Cells.ChatMessageCell) r4
            ir.eitaa.messenger.MessageObject$GroupedMessagePosition r5 = r4.getCurrentPosition()
            if (r5 == 0) goto L54
            ir.eitaa.messenger.MessageObject$GroupedMessagePosition r4 = r4.getCurrentPosition()
            int r4 = r4.flags
            r4 = r4 & 1
            if (r4 != 0) goto L54
            goto L63
        L54:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r4 = r6.mPendingAdditions
            java.lang.Object r4 = r4.get(r0)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r4 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r4
            android.view.View r4 = r4.itemView
            int r4 = r4.getHeight()
            int r2 = r2 + r4
        L63:
            int r0 = r0 + 1
            goto L2b
        L66:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r6.mPendingRemovals
            java.util.Iterator r0 = r0.iterator()
        L6c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L7c
            java.lang.Object r4 = r0.next()
            androidx.recyclerview.widget.RecyclerView$ViewHolder r4 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r4
            r6.animateRemoveImpl(r4)
            goto L6c
        L7c:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r6.mPendingRemovals
            r0.clear()
            if (r1 == 0) goto Lab
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList<androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo> r1 = r6.mPendingMoves
            r0.addAll(r1)
            java.util.ArrayList<androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo> r1 = r6.mPendingMoves
            r1.clear()
            java.util.Iterator r1 = r0.iterator()
        L96:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto La8
            java.lang.Object r4 = r1.next()
            androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo r4 = (androidx.recyclerview.widget.DefaultItemAnimator.MoveInfo) r4
            androidx.recyclerview.widget.RecyclerView$ViewHolder r5 = r4.holder
            r6.animateMoveImpl(r5, r4)
            goto L96
        La8:
            r0.clear()
        Lab:
            if (r3 == 0) goto Ld3
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r1 = r6.mPendingAdditions
            r0.addAll(r1)
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r1 = r6.mPendingAdditions
            r1.clear()
            java.util.Iterator r1 = r0.iterator()
        Lc0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Ld0
            java.lang.Object r3 = r1.next()
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r3
            r6.animateAddImpl(r3, r2)
            goto Lc0
        Ld0:
            r0.clear()
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ChatListItemAnimator.runMessageEnterTransition():void");
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preLayoutInfo, RecyclerView.ItemAnimator.ItemHolderInfo postLayoutInfo) {
        int height;
        boolean zAnimateAppearance = super.animateAppearance(viewHolder, preLayoutInfo, postLayoutInfo);
        if (zAnimateAppearance && this.shouldAnimateEnterFromBottom) {
            boolean z = false;
            for (int i = 0; i < this.mPendingAdditions.size(); i++) {
                if (this.mPendingAdditions.get(i).getLayoutPosition() == 0) {
                    z = true;
                }
            }
            if (z) {
                height = 0;
                for (int i2 = 0; i2 < this.mPendingAdditions.size(); i2++) {
                    height += this.mPendingAdditions.get(i2).itemView.getHeight();
                }
            } else {
                height = 0;
            }
            for (int i3 = 0; i3 < this.mPendingAdditions.size(); i3++) {
                this.mPendingAdditions.get(i3).itemView.setTranslationY(height);
            }
        }
        return zAnimateAppearance;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        resetAnimation(holder);
        holder.itemView.setAlpha(0.0f);
        if (!this.shouldAnimateEnterFromBottom) {
            holder.itemView.setScaleX(0.9f);
            holder.itemView.setScaleY(0.9f);
        } else {
            View view = holder.itemView;
            if (view instanceof ChatMessageCell) {
                ((ChatMessageCell) view).getTransitionParams().messageEntering = true;
            }
        }
        this.mPendingAdditions.add(holder);
        return true;
    }

    public void animateAddImpl(final RecyclerView.ViewHolder holder, int addedItemsHeight) {
        final View view = holder.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mAddAnimations.add(holder);
        view.setTranslationY(addedItemsHeight);
        holder.itemView.setScaleX(1.0f);
        holder.itemView.setScaleY(1.0f);
        View view2 = holder.itemView;
        ChatMessageCell chatMessageCell = view2 instanceof ChatMessageCell ? (ChatMessageCell) view2 : null;
        if (chatMessageCell == null || !chatMessageCell.getTransitionParams().ignoreAlpha) {
            holder.itemView.setAlpha(1.0f);
        }
        if (chatMessageCell != null && this.activity.animatingMessageObjects.contains(chatMessageCell.getMessageObject())) {
            this.activity.animatingMessageObjects.remove(chatMessageCell.getMessageObject());
            if (this.activity.getChatActivityEnterView().canShowMessageTransition()) {
                if (chatMessageCell.getMessageObject().isVoice()) {
                    if (Math.abs(view.getTranslationY()) < view.getMeasuredHeight() * 3.0f) {
                        new VoiceMessageEnterTransition(chatMessageCell, this.activity.getChatActivityEnterView(), this.recyclerListView, this.activity.messageEnterTransitionContainer, this.resourcesProvider).start();
                    }
                } else if (SharedConfig.getDevicePerformanceClass() != 0 && Math.abs(view.getTranslationY()) < this.recyclerListView.getMeasuredHeight()) {
                    ChatActivity chatActivity = this.activity;
                    new TextMessageEnterTransition(chatMessageCell, chatActivity, this.recyclerListView, chatActivity.messageEnterTransitionContainer, this.resourcesProvider).start();
                }
                this.activity.getChatActivityEnterView().startMessageTransition();
            }
        }
        viewPropertyAnimatorAnimate.translationY(0.0f).setDuration(getMoveDuration()).setInterpolator(this.translationInterpolator).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.ChatListItemAnimator.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ChatListItemAnimator.this.dispatchAddStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setTranslationY(0.0f);
                View view3 = view;
                if (view3 instanceof ChatMessageCell) {
                    ((ChatMessageCell) view3).getTransitionParams().messageEntering = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view3 = view;
                if (view3 instanceof ChatMessageCell) {
                    ((ChatMessageCell) view3).getTransitionParams().messageEntering = false;
                }
                viewPropertyAnimatorAnimate.setListener(null);
                if (ChatListItemAnimator.this.mAddAnimations.remove(holder)) {
                    ChatListItemAnimator.this.dispatchAddFinished(holder);
                    ChatListItemAnimator.this.dispatchFinishedWhenDone();
                }
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("animate remove");
        }
        boolean zAnimateRemove = super.animateRemove(holder, info);
        if (zAnimateRemove && info != null) {
            int i = info.top;
            int top = holder.itemView.getTop();
            int left = holder.itemView.getLeft() - info.left;
            if (top - i != 0) {
                holder.itemView.setTranslationY(-r2);
            }
            View view = holder.itemView;
            if (view instanceof ChatMessageCell) {
                ChatMessageCell chatMessageCell = (ChatMessageCell) view;
                if (left != 0) {
                    chatMessageCell.setAnimationOffsetX(-left);
                }
                if (info instanceof ItemHolderInfoExtended) {
                    ItemHolderInfoExtended itemHolderInfoExtended = (ItemHolderInfoExtended) info;
                    chatMessageCell.setImageCoords(itemHolderInfoExtended.imageX, itemHolderInfoExtended.imageY, itemHolderInfoExtended.imageWidth, itemHolderInfoExtended.imageHeight);
                }
            } else if (left != 0) {
                view.setTranslationX(-left);
            }
        }
        return zAnimateRemove;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean animateMove(androidx.recyclerview.widget.RecyclerView.ViewHolder r24, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ChatListItemAnimator.animateMove(androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo, int, int, int, int):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v16 */
    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void animateMoveImpl(final androidx.recyclerview.widget.RecyclerView.ViewHolder r26, androidx.recyclerview.widget.DefaultItemAnimator.MoveInfo r27) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ChatListItemAnimator.animateMoveImpl(androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo):void");
    }

    static /* synthetic */ void lambda$animateMoveImpl$2(MoveInfoExtended moveInfoExtended, ChatMessageCell.TransitionParams transitionParams, boolean z, float f, float f2, ChatMessageCell chatMessageCell, int[] iArr, RecyclerView.ViewHolder viewHolder, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f3 = 1.0f - fFloatValue;
        float f4 = (moveInfoExtended.imageX * f3) + (transitionParams.animateToImageX * fFloatValue);
        float f5 = (moveInfoExtended.imageY * f3) + (transitionParams.animateToImageY * fFloatValue);
        float f6 = (moveInfoExtended.imageWidth * f3) + (transitionParams.animateToImageW * fFloatValue);
        float f7 = (moveInfoExtended.imageHeight * f3) + (transitionParams.animateToImageH * fFloatValue);
        if (z) {
            float f8 = (f * f3) + (f2 * fFloatValue);
            transitionParams.captionEnterProgress = f8;
            if (chatMessageCell.getCurrentMessagesGroup() != null) {
                chatMessageCell.getCurrentMessagesGroup().transitionParams.captionEnterProgress = f8;
            }
        }
        if (transitionParams.animateRadius) {
            int[] iArr2 = transitionParams.animateToRadius;
            chatMessageCell.getPhotoImage().setRoundRadius((int) ((iArr[0] * f3) + (iArr2[0] * fFloatValue)), (int) ((iArr[1] * f3) + (iArr2[1] * fFloatValue)), (int) ((iArr[2] * f3) + (iArr2[2] * fFloatValue)), (int) ((iArr[3] * f3) + (iArr2[3] * fFloatValue)));
        }
        chatMessageCell.setImageCoords(f4, f5, f6, f7);
        viewHolder.itemView.invalidate();
    }

    static /* synthetic */ void lambda$animateMoveImpl$3(MoveInfoExtended moveInfoExtended, ChatMessageCell.TransitionParams transitionParams, ChatMessageCell chatMessageCell, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (moveInfoExtended.animateBackgroundOnly) {
            transitionParams.deltaLeft = (-moveInfoExtended.deltaLeft) * fFloatValue;
            transitionParams.deltaRight = (-moveInfoExtended.deltaRight) * fFloatValue;
            transitionParams.deltaTop = (-moveInfoExtended.deltaTop) * fFloatValue;
            transitionParams.deltaBottom = (-moveInfoExtended.deltaBottom) * fFloatValue;
        } else {
            transitionParams.deltaLeft = ((-moveInfoExtended.deltaLeft) * fFloatValue) - chatMessageCell.getAnimationOffsetX();
            transitionParams.deltaRight = ((-moveInfoExtended.deltaRight) * fFloatValue) - chatMessageCell.getAnimationOffsetX();
            transitionParams.deltaTop = ((-moveInfoExtended.deltaTop) * fFloatValue) - chatMessageCell.getTranslationY();
            transitionParams.deltaBottom = ((-moveInfoExtended.deltaBottom) * fFloatValue) - chatMessageCell.getTranslationY();
        }
        chatMessageCell.invalidate();
    }

    static /* synthetic */ void lambda$animateMoveImpl$4(MessageObject.GroupedMessages.TransitionParams transitionParams, MoveInfoExtended moveInfoExtended, boolean z, float f, float f2, RecyclerListView recyclerListView, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        transitionParams.offsetTop = moveInfoExtended.groupOffsetTop * fFloatValue;
        transitionParams.offsetBottom = moveInfoExtended.groupOffsetBottom * fFloatValue;
        transitionParams.offsetLeft = moveInfoExtended.groupOffsetLeft * fFloatValue;
        transitionParams.offsetRight = moveInfoExtended.groupOffsetRight * fFloatValue;
        if (z) {
            transitionParams.captionEnterProgress = (f * fFloatValue) + (f2 * (1.0f - fFloatValue));
        }
        if (recyclerListView != null) {
            recyclerListView.invalidate();
        }
    }

    static /* synthetic */ void lambda$animateMoveImpl$5(ChatMessageCell.TransitionParams transitionParams, ChatMessageCell chatMessageCell, ValueAnimator valueAnimator) {
        transitionParams.changePinnedBottomProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        chatMessageCell.invalidate();
    }

    static /* synthetic */ void lambda$animateMoveImpl$6(ChatMessageCell.TransitionParams transitionParams, ChatMessageCell chatMessageCell, ValueAnimator valueAnimator) {
        transitionParams.animateChangeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        chatMessageCell.invalidate();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    public void resetAnimation(RecyclerView.ViewHolder holder) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("reset animation");
        }
        this.reset = true;
        super.resetAnimation(holder);
        this.reset = false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY) {
        float translationX;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("animate change");
        }
        if (oldHolder == newHolder) {
            return animateMove(oldHolder, info, fromX, fromY, toX, toY);
        }
        View view = oldHolder.itemView;
        if (view instanceof ChatMessageCell) {
            translationX = ((ChatMessageCell) view).getAnimationOffsetX();
        } else {
            translationX = view.getTranslationX();
        }
        float translationY = oldHolder.itemView.getTranslationY();
        float alpha = oldHolder.itemView.getAlpha();
        resetAnimation(oldHolder);
        int i = (int) ((toX - fromX) - translationX);
        int i2 = (int) ((toY - fromY) - translationY);
        View view2 = oldHolder.itemView;
        if (view2 instanceof ChatMessageCell) {
            ((ChatMessageCell) view2).setAnimationOffsetX(translationX);
        } else {
            view2.setTranslationX(translationX);
        }
        oldHolder.itemView.setTranslationY(translationY);
        oldHolder.itemView.setAlpha(alpha);
        if (newHolder != null) {
            resetAnimation(newHolder);
            View view3 = newHolder.itemView;
            if (view3 instanceof ChatMessageCell) {
                ((ChatMessageCell) view3).setAnimationOffsetX(-i);
            } else {
                view3.setTranslationX(-i);
            }
            newHolder.itemView.setTranslationY(-i2);
            newHolder.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new DefaultItemAnimator.ChangeInfo(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    void animateChangeImpl(final DefaultItemAnimator.ChangeInfo changeInfo) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("animate change impl");
        }
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        final View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        final View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            duration.translationX(changeInfo.toX - changeInfo.fromX);
            duration.translationY(changeInfo.toY - changeInfo.fromY);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.ChatListItemAnimator.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ChatListItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setScaleX(1.0f);
                    view.setScaleX(1.0f);
                    View view3 = view;
                    if (view3 instanceof ChatMessageCell) {
                        ((ChatMessageCell) view3).setAnimationOffsetX(0.0f);
                    } else {
                        view3.setTranslationX(0.0f);
                    }
                    view.setTranslationY(0.0f);
                    if (ChatListItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder)) {
                        ChatListItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                        ChatListItemAnimator.this.dispatchFinishedWhenDone();
                    }
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.mChangeAnimations.add(changeInfo.newHolder);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.ChatListItemAnimator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ChatListItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setScaleX(1.0f);
                    view2.setScaleX(1.0f);
                    View view3 = view2;
                    if (view3 instanceof ChatMessageCell) {
                        ((ChatMessageCell) view3).setAnimationOffsetX(0.0f);
                    } else {
                        view3.setTranslationX(0.0f);
                    }
                    view2.setTranslationY(0.0f);
                    if (ChatListItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder)) {
                        ChatListItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                        ChatListItemAnimator.this.dispatchFinishedWhenDone();
                    }
                }
            }).start();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(RecyclerView.State state, RecyclerView.ViewHolder viewHolder, int changeFlags, List<Object> payloads) {
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfoRecordPreLayoutInformation = super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
        View view = viewHolder.itemView;
        if (!(view instanceof ChatMessageCell)) {
            return itemHolderInfoRecordPreLayoutInformation;
        }
        ItemHolderInfoExtended itemHolderInfoExtended = new ItemHolderInfoExtended();
        itemHolderInfoExtended.left = itemHolderInfoRecordPreLayoutInformation.left;
        itemHolderInfoExtended.top = itemHolderInfoRecordPreLayoutInformation.top;
        itemHolderInfoExtended.right = itemHolderInfoRecordPreLayoutInformation.right;
        itemHolderInfoExtended.bottom = itemHolderInfoRecordPreLayoutInformation.bottom;
        ChatMessageCell.TransitionParams transitionParams = ((ChatMessageCell) view).getTransitionParams();
        itemHolderInfoExtended.imageX = transitionParams.lastDrawingImageX;
        itemHolderInfoExtended.imageY = transitionParams.lastDrawingImageY;
        itemHolderInfoExtended.imageWidth = transitionParams.lastDrawingImageW;
        itemHolderInfoExtended.imageHeight = transitionParams.lastDrawingImageH;
        return itemHolderInfoExtended;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    protected void onAllAnimationsDone() {
        super.onAllAnimationsDone();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("all animations done");
        }
        this.recyclerListView.setClipChildren(true);
        while (!this.runOnAnimationsEnd.isEmpty()) {
            this.runOnAnimationsEnd.remove(0).run();
        }
        cancelAnimators();
    }

    private void cancelAnimators() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("cancel animations");
        }
        ArrayList arrayList = new ArrayList(this.animators.values());
        this.animators.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (animator != null) {
                animator.cancel();
            }
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder item) {
        Animator animatorRemove = this.animators.remove(item);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        super.endAnimation(item);
        restoreTransitionParams(item.itemView);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("end animation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreTransitionParams(View view) {
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationY(0.0f);
        if (view instanceof BotHelpCell) {
            int measuredHeight = (this.recyclerListView.getMeasuredHeight() / 2) - (view.getMeasuredHeight() / 2);
            ((BotHelpCell) view).setAnimating(false);
            if (view.getTop() > measuredHeight) {
                view.setTranslationY(measuredHeight - view.getTop());
                return;
            } else {
                view.setTranslationY(0.0f);
                return;
            }
        }
        if (view instanceof ChatMessageCell) {
            ChatMessageCell chatMessageCell = (ChatMessageCell) view;
            chatMessageCell.getTransitionParams().resetAnimation();
            chatMessageCell.setAnimationOffsetX(0.0f);
            return;
        }
        view.setTranslationX(0.0f);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("end animations");
        }
        Iterator<MessageObject.GroupedMessages> it = this.willChangedGroups.iterator();
        while (it.hasNext()) {
            it.next().transitionParams.isNewGroup = false;
        }
        this.willChangedGroups.clear();
        cancelAnimators();
        ChatGreetingsView chatGreetingsView = this.chatGreetingsView;
        if (chatGreetingsView != null) {
            chatGreetingsView.stickerToSendView.setAlpha(1.0f);
        }
        this.greetingsSticker = null;
        this.chatGreetingsView = null;
        for (int size = this.mPendingMoves.size() - 1; size >= 0; size--) {
            DefaultItemAnimator.MoveInfo moveInfo = this.mPendingMoves.get(size);
            restoreTransitionParams(moveInfo.holder.itemView);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            RecyclerView.ViewHolder viewHolder = this.mPendingRemovals.get(size2);
            restoreTransitionParams(viewHolder.itemView);
            dispatchRemoveFinished(viewHolder);
            this.mPendingRemovals.remove(size2);
        }
        for (int size3 = this.mPendingAdditions.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder2 = this.mPendingAdditions.get(size3);
            restoreTransitionParams(viewHolder2.itemView);
            dispatchAddFinished(viewHolder2);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<DefaultItemAnimator.MoveInfo> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    DefaultItemAnimator.MoveInfo moveInfo2 = arrayList.get(size6);
                    restoreTransitionParams(moveInfo2.holder.itemView);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder3 = arrayList2.get(size8);
                    restoreTransitionParams(viewHolder3.itemView);
                    dispatchAddFinished(viewHolder3);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<DefaultItemAnimator.ChangeInfo> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    protected boolean endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo changeInfo, RecyclerView.ViewHolder item) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("end change if necessary");
        }
        Animator animatorRemove = this.animators.remove(item);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        boolean z = false;
        if (changeInfo.newHolder == item) {
            changeInfo.newHolder = null;
        } else {
            if (changeInfo.oldHolder != item) {
                return false;
            }
            changeInfo.oldHolder = null;
            z = true;
        }
        restoreTransitionParams(item.itemView);
        dispatchChangeFinished(item, z);
        return true;
    }

    public void groupWillTransformToSingleMessage(MessageObject.GroupedMessages groupedMessages) {
        this.willRemovedGroup.put(Integer.valueOf(groupedMessages.messages.get(0).getId()), groupedMessages);
    }

    public void groupWillChanged(MessageObject.GroupedMessages groupedMessages) {
        if (groupedMessages.messages.size() == 0) {
            groupedMessages.transitionParams.drawBackgroundForDeletedItems = true;
            return;
        }
        MessageObject.GroupedMessages.TransitionParams transitionParams = groupedMessages.transitionParams;
        if (transitionParams.top == 0 && transitionParams.bottom == 0 && transitionParams.left == 0 && transitionParams.right == 0) {
            int childCount = this.recyclerListView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = this.recyclerListView.getChildAt(i);
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                    MessageObject messageObject = chatMessageCell.getMessageObject();
                    if (chatMessageCell.getTransitionParams().wasDraw && groupedMessages.messages.contains(messageObject)) {
                        groupedMessages.transitionParams.top = chatMessageCell.getTop() + chatMessageCell.getBackgroundDrawableTop();
                        groupedMessages.transitionParams.bottom = chatMessageCell.getTop() + chatMessageCell.getBackgroundDrawableBottom();
                        groupedMessages.transitionParams.left = chatMessageCell.getLeft() + chatMessageCell.getBackgroundDrawableLeft();
                        groupedMessages.transitionParams.right = chatMessageCell.getLeft() + chatMessageCell.getBackgroundDrawableRight();
                        groupedMessages.transitionParams.drawCaptionLayout = chatMessageCell.hasCaptionLayout();
                        groupedMessages.transitionParams.pinnedTop = chatMessageCell.isPinnedTop();
                        groupedMessages.transitionParams.pinnedBotton = chatMessageCell.isPinnedBottom();
                        groupedMessages.transitionParams.isNewGroup = true;
                        break;
                    }
                }
                i++;
            }
        }
        this.willChangedGroups.add(groupedMessages);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0257  */
    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateAddImpl(final androidx.recyclerview.widget.RecyclerView.ViewHolder r29) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ChatListItemAnimator.animateAddImpl(androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
    }

    static /* synthetic */ void lambda$animateAddImpl$7(ChatMessageCell chatMessageCell, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        chatMessageCell.getTransitionParams().animateChangeProgress = fFloatValue;
        if (chatMessageCell.getTransitionParams().animateChangeProgress > 1.0f) {
            chatMessageCell.getTransitionParams().animateChangeProgress = 1.0f;
        }
        float f9 = 1.0f - fFloatValue;
        chatMessageCell.getPhotoImage().setImageCoords(f + (f2 * f9), f3 + (f4 * f9), (f5 * f9) + (f6 * fFloatValue), (f7 * f9) + (f8 * fFloatValue));
        chatMessageCell.invalidate();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator
    protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("animate remove impl");
        }
        final View view = holder.itemView;
        this.mRemoveAnimations.add(holder);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), 0.0f);
        dispatchRemoveStarting(holder);
        objectAnimatorOfFloat.setDuration(getRemoveDuration());
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.ChatListItemAnimator.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                view.setAlpha(1.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                if (ChatListItemAnimator.this.mRemoveAnimations.remove(holder)) {
                    ChatListItemAnimator.this.dispatchRemoveFinished(holder);
                    ChatListItemAnimator.this.dispatchFinishedWhenDone();
                }
            }
        });
        this.animators.put(holder, objectAnimatorOfFloat);
        objectAnimatorOfFloat.start();
        this.recyclerListView.stopScroll();
    }

    public void setShouldAnimateEnterFromBottom(boolean shouldAnimateEnterFromBottom) {
        this.shouldAnimateEnterFromBottom = shouldAnimateEnterFromBottom;
    }

    public void onDestroy() {
        onAllAnimationsDone();
    }

    public boolean willRemoved(View view) {
        RecyclerView.ViewHolder childViewHolder = this.recyclerListView.getChildViewHolder(view);
        if (childViewHolder != null) {
            return this.mPendingRemovals.contains(childViewHolder) || this.mRemoveAnimations.contains(childViewHolder);
        }
        return false;
    }

    public boolean willAddedFromAlpha(View view) {
        RecyclerView.ViewHolder childViewHolder;
        if (this.shouldAnimateEnterFromBottom || (childViewHolder = this.recyclerListView.getChildViewHolder(view)) == null) {
            return false;
        }
        return this.mPendingAdditions.contains(childViewHolder) || this.mAddAnimations.contains(childViewHolder);
    }

    public void onGreetingStickerTransition(RecyclerView.ViewHolder holder, ChatGreetingsView greetingsViewContainer) {
        this.greetingsSticker = holder;
        this.chatGreetingsView = greetingsViewContainer;
        this.shouldAnimateEnterFromBottom = false;
    }

    public void setReversePositions(boolean reversePositions) {
        this.reversePositions = reversePositions;
    }

    class MoveInfoExtended extends DefaultItemAnimator.MoveInfo {
        public boolean animateBackgroundOnly;
        public boolean animateChangeGroupBackground;
        public boolean animateChangeInternal;
        boolean animateImage;
        public boolean animatePinnedBottom;
        boolean animateRemoveGroup;
        int deltaBottom;
        int deltaLeft;
        int deltaRight;
        int deltaTop;
        public int groupOffsetBottom;
        public int groupOffsetLeft;
        public int groupOffsetRight;
        public int groupOffsetTop;
        float imageHeight;
        float imageWidth;
        float imageX;
        float imageY;

        MoveInfoExtended(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
            super(holder, fromX, fromY, toX, toY);
        }
    }

    class ItemHolderInfoExtended extends RecyclerView.ItemAnimator.ItemHolderInfo {
        float imageHeight;
        float imageWidth;
        float imageX;
        float imageY;

        ItemHolderInfoExtended() {
        }
    }
}
