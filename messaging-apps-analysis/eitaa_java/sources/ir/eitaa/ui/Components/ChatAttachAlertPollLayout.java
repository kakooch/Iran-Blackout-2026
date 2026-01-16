package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$TL_poll;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswer;
import ir.eitaa.tgnet.TLRPC$TL_pollResults;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.PollEditTextCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.ChatAttachAlertPollLayout;
import ir.eitaa.ui.Components.RecyclerListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChatAttachAlertPollLayout extends ChatAttachAlert.AttachAlertLayout {
    private int addAnswerRow;
    private boolean allowNesterScroll;
    private boolean anonymousPoll;
    private int anonymousRow;
    private int answerHeaderRow;
    private int answerSectionRow;
    private int answerStartRow;
    private String[] answers;
    private boolean[] answersChecks;
    private int answersCount;
    private PollCreateActivityDelegate delegate;
    private int emptyRow;
    private boolean hintShowed;
    private HintView hintView;
    private boolean ignoreLayout;
    private SimpleItemAnimator itemAnimator;
    private FillLastLinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean multipleChoise;
    private int multipleRow;
    private int paddingRow;
    private int questionHeaderRow;
    private int questionRow;
    private int questionSectionRow;
    private String questionString;
    private int quizOnly;
    private boolean quizPoll;
    private int quizRow;
    private int requestFieldFocusAtPosition;
    private int rowCount;
    private int settingsHeaderRow;
    private int settingsSectionRow;
    private int solutionInfoRow;
    private int solutionRow;
    private CharSequence solutionString;
    private int topPadding;

    public interface PollCreateActivityDelegate {
        void sendPoll(TLRPC$TL_messageMediaPoll poll, HashMap<String, String> params, boolean notify, int scheduleDate);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int needsActionBar() {
        return 1;
    }

    static /* synthetic */ int access$1210(ChatAttachAlertPollLayout chatAttachAlertPollLayout) {
        int i = chatAttachAlertPollLayout.answersCount;
        chatAttachAlertPollLayout.answersCount = i - 1;
        return i;
    }

    private static class EmptyView extends View {
        public EmptyView(Context context) {
            super(context);
        }
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }

        public TouchHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 5) {
                return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            if (source.getItemViewType() != target.getItemViewType()) {
                return false;
            }
            ChatAttachAlertPollLayout.this.listAdapter.swapElements(source.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState != 0) {
                ChatAttachAlertPollLayout.this.listView.setItemAnimator(ChatAttachAlertPollLayout.this.itemAnimator);
                ChatAttachAlertPollLayout.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
                viewHolder.itemView.setBackgroundColor(ChatAttachAlertPollLayout.this.getThemedColor("dialogBackground"));
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
            viewHolder.itemView.setBackground(null);
        }
    }

    public ChatAttachAlertPollLayout(ChatAttachAlert alert, Context context, Theme.ResourcesProvider resourcesProvider) {
        super(alert, context, resourcesProvider);
        this.answers = new String[10];
        this.answersChecks = new boolean[10];
        this.answersCount = 1;
        this.anonymousPoll = true;
        this.requestFieldFocusAtPosition = -1;
        updateRows();
        this.listAdapter = new ListAdapter(context);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.1
            @Override // androidx.recyclerview.widget.RecyclerView
            protected void requestChildOnScreen(View child, View focused) {
                if (child instanceof PollEditTextCell) {
                    super.requestChildOnScreen(child, focused);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View child, android.graphics.Rect rectangle, boolean immediate) {
                rectangle.bottom += AndroidUtilities.dp(60.0f);
                return super.requestChildRectangleOnScreen(child, rectangle, immediate);
            }
        };
        this.listView = recyclerListView;
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.2
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void onMoveAnimationUpdate(RecyclerView.ViewHolder holder) {
                if (holder.getAdapterPosition() == 0) {
                    ChatAttachAlertPollLayout chatAttachAlertPollLayout = ChatAttachAlertPollLayout.this;
                    chatAttachAlertPollLayout.parentAlert.updateLayout(chatAttachAlertPollLayout, true, 0);
                }
            }
        };
        this.itemAnimator = defaultItemAnimator;
        recyclerListView.setItemAnimator(defaultItemAnimator);
        this.listView.setClipToPadding(false);
        this.listView.setVerticalScrollBarEnabled(false);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        RecyclerListView recyclerListView2 = this.listView;
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(context, 1, false, AndroidUtilities.dp(53.0f), this.listView) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.3
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.3.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int snapPreference) {
                        return super.calculateDyToMakeVisible(view, snapPreference) - (ChatAttachAlertPollLayout.this.topPadding - AndroidUtilities.dp(7.0f));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int dx) {
                        return super.calculateTimeForDeceleration(dx) * 2;
                    }
                };
                linearSmoothScroller.setTargetPosition(position);
                startSmoothScroll(linearSmoothScroller);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            protected int[] getChildRectangleOnScreenScrollAmount(View child, android.graphics.Rect rect) {
                int[] iArr = new int[2];
                int height = getHeight() - getPaddingBottom();
                int top = (child.getTop() + rect.top) - child.getScrollY();
                int iHeight = rect.height() + top;
                int i = top - 0;
                int iMin = Math.min(0, i);
                int iMax = Math.max(0, iHeight - height);
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iArr[0] = 0;
                iArr[1] = iMin;
                return iArr;
            }
        };
        this.layoutManager = fillLastLinearLayoutManager;
        recyclerListView2.setLayoutManager(fillLastLinearLayoutManager);
        this.layoutManager.setSkipFirstItem();
        new ItemTouchHelper(new TouchHelperCallback()).attachToRecyclerView(this.listView);
        addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setPreserveFocusAfterLayout(true);
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPollLayout$F6uFohXbI5e_-DHKkfIW7FjheG8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0$ChatAttachAlertPollLayout(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ChatAttachAlertPollLayout chatAttachAlertPollLayout = ChatAttachAlertPollLayout.this;
                chatAttachAlertPollLayout.parentAlert.updateLayout(chatAttachAlertPollLayout, true, dy);
                if (dy == 0 || ChatAttachAlertPollLayout.this.hintView == null) {
                    return;
                }
                ChatAttachAlertPollLayout.this.hintView.hide();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                RecyclerListView.Holder holder;
                if (newState == 0) {
                    int iDp = AndroidUtilities.dp(13.0f);
                    int backgroundPaddingTop = ChatAttachAlertPollLayout.this.parentAlert.getBackgroundPaddingTop();
                    if (((ChatAttachAlertPollLayout.this.parentAlert.scrollOffsetY[0] - backgroundPaddingTop) - iDp) + backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || (holder = (RecyclerListView.Holder) ChatAttachAlertPollLayout.this.listView.findViewHolderForAdapterPosition(1)) == null || holder.itemView.getTop() <= AndroidUtilities.dp(53.0f)) {
                        return;
                    }
                    ChatAttachAlertPollLayout.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(53.0f));
                }
            }
        });
        HintView hintView = new HintView(context, 4);
        this.hintView = hintView;
        hintView.setText(LocaleController.getString("PollTapToSelect", R.string.PollTapToSelect));
        this.hintView.setAlpha(0.0f);
        this.hintView.setVisibility(4);
        addView(this.hintView, LayoutHelper.createFrame(-2, -2.0f, 51, 19.0f, 0.0f, 19.0f, 0.0f));
        checkDoneButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatAttachAlertPollLayout(View view, int i) {
        boolean z;
        if (i == this.addAnswerRow) {
            addNewField();
            return;
        }
        if (view instanceof TextCheckCell) {
            TextCheckCell textCheckCell = (TextCheckCell) view;
            boolean z2 = this.quizPoll;
            if (i == this.anonymousRow) {
                z = !this.anonymousPoll;
                this.anonymousPoll = z;
            } else if (i == this.multipleRow) {
                z = !this.multipleChoise;
                this.multipleChoise = z;
                if (z && z2) {
                    int i2 = this.solutionRow;
                    this.quizPoll = false;
                    updateRows();
                    this.listView.setItemAnimator(this.itemAnimator);
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.quizRow);
                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                        ((TextCheckCell) viewHolderFindViewHolderForAdapterPosition.itemView).setChecked(false);
                    } else {
                        this.listAdapter.notifyItemChanged(this.quizRow);
                    }
                    this.listAdapter.notifyItemRangeRemoved(i2, 2);
                    this.listAdapter.notifyItemChanged(this.emptyRow);
                }
            } else {
                if (this.quizOnly != 0) {
                    return;
                }
                this.listView.setItemAnimator(this.itemAnimator);
                z = !this.quizPoll;
                this.quizPoll = z;
                int i3 = this.solutionRow;
                updateRows();
                if (this.quizPoll) {
                    this.listAdapter.notifyItemRangeInserted(this.solutionRow, 2);
                } else {
                    this.listAdapter.notifyItemRangeRemoved(i3, 2);
                }
                this.listAdapter.notifyItemChanged(this.emptyRow);
                if (this.quizPoll && this.multipleChoise) {
                    this.multipleChoise = false;
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(this.multipleRow);
                    if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                        ((TextCheckCell) viewHolderFindViewHolderForAdapterPosition2.itemView).setChecked(false);
                    } else {
                        this.listAdapter.notifyItemChanged(this.multipleRow);
                    }
                }
                if (this.quizPoll) {
                    int i4 = 0;
                    boolean z3 = false;
                    while (true) {
                        boolean[] zArr = this.answersChecks;
                        if (i4 >= zArr.length) {
                            break;
                        }
                        if (z3) {
                            zArr[i4] = false;
                        } else if (zArr[i4]) {
                            z3 = true;
                        }
                        i4++;
                    }
                }
            }
            if (this.hintShowed && !this.quizPoll) {
                this.hintView.hide();
            }
            this.listView.getChildCount();
            for (int i5 = this.answerStartRow; i5 < this.answerStartRow + this.answersCount; i5++) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition3 = this.listView.findViewHolderForAdapterPosition(i5);
                if (viewHolderFindViewHolderForAdapterPosition3 != null) {
                    View view2 = viewHolderFindViewHolderForAdapterPosition3.itemView;
                    if (view2 instanceof PollEditTextCell) {
                        PollEditTextCell pollEditTextCell = (PollEditTextCell) view2;
                        pollEditTextCell.setShowCheckBox(this.quizPoll, true);
                        pollEditTextCell.setChecked(this.answersChecks[i5 - this.answerStartRow], z2);
                        if (pollEditTextCell.getTop() > AndroidUtilities.dp(40.0f) && i == this.quizRow && !this.hintShowed) {
                            this.hintView.showForView(pollEditTextCell.getCheckBox(), true);
                            this.hintShowed = true;
                        }
                    }
                }
            }
            textCheckCell.setChecked(z);
            checkDoneButton();
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onResume() {
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHideShowProgress(float progress) {
        ActionBarMenuItem actionBarMenuItem = this.parentAlert.doneItem;
        actionBarMenuItem.setAlpha((actionBarMenuItem.isEnabled() ? 1.0f : 0.5f) * progress);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onMenuItemClick(int id) throws IOException {
        if (id == 40) {
            if (this.quizPoll && this.parentAlert.doneItem.getAlpha() != 1.0f) {
                int i = 0;
                for (int i2 = 0; i2 < this.answersChecks.length; i2++) {
                    if (!TextUtils.isEmpty(getFixedString(this.answers[i2])) && this.answersChecks[i2]) {
                        i++;
                    }
                }
                if (i <= 0) {
                    showQuizHint();
                    return;
                }
                return;
            }
            final TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = new TLRPC$TL_messageMediaPoll();
            TLRPC$TL_poll tLRPC$TL_poll = new TLRPC$TL_poll();
            tLRPC$TL_messageMediaPoll.poll = tLRPC$TL_poll;
            tLRPC$TL_poll.multiple_choice = this.multipleChoise;
            tLRPC$TL_poll.quiz = this.quizPoll;
            tLRPC$TL_poll.public_voters = !this.anonymousPoll;
            tLRPC$TL_poll.question = getFixedString(this.questionString).toString();
            SerializedData serializedData = new SerializedData(10);
            int i3 = 0;
            while (true) {
                String[] strArr = this.answers;
                if (i3 >= strArr.length) {
                    break;
                }
                if (!TextUtils.isEmpty(getFixedString(strArr[i3]))) {
                    TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = new TLRPC$TL_pollAnswer();
                    tLRPC$TL_pollAnswer.text = getFixedString(this.answers[i3]).toString();
                    tLRPC$TL_pollAnswer.option = new byte[]{(byte) (tLRPC$TL_messageMediaPoll.poll.answers.size() + 48)};
                    tLRPC$TL_messageMediaPoll.poll.answers.add(tLRPC$TL_pollAnswer);
                    if ((this.multipleChoise || this.quizPoll) && this.answersChecks[i3]) {
                        serializedData.writeByte(tLRPC$TL_pollAnswer.option[0]);
                    }
                }
                i3++;
            }
            final HashMap<String, String> map = new HashMap<>();
            map.put("answers", Utilities.bytesToHex(serializedData.toByteArray()));
            tLRPC$TL_messageMediaPoll.results = new TLRPC$TL_pollResults();
            CharSequence fixedString = getFixedString(this.solutionString);
            if (fixedString != null) {
                tLRPC$TL_messageMediaPoll.results.solution = fixedString.toString();
                ArrayList<TLRPC$MessageEntity> entities = MediaDataController.getInstance(this.parentAlert.currentAccount).getEntities(new CharSequence[]{fixedString}, true);
                if (entities != null && !entities.isEmpty()) {
                    tLRPC$TL_messageMediaPoll.results.solution_entities = entities;
                }
                if (!TextUtils.isEmpty(tLRPC$TL_messageMediaPoll.results.solution)) {
                    tLRPC$TL_messageMediaPoll.results.flags |= 16;
                }
            }
            ChatActivity chatActivity = (ChatActivity) this.parentAlert.baseFragment;
            if (chatActivity.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(chatActivity.getParentActivity(), chatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPollLayout$PZnCrUTeKwf92vJv9bRoTEvfOlM
                    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i4) {
                        this.f$0.lambda$onMenuItemClick$1$ChatAttachAlertPollLayout(tLRPC$TL_messageMediaPoll, map, z, i4);
                    }
                });
            } else {
                this.delegate.sendPoll(tLRPC$TL_messageMediaPoll, map, true, 0);
                this.parentAlert.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMenuItemClick$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMenuItemClick$1$ChatAttachAlertPollLayout(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i) {
        this.delegate.sendPoll(tLRPC$TL_messageMediaPoll, map, z, i);
        this.parentAlert.dismiss();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        View childAt;
        if (this.listView.getChildCount() <= 0 || (childAt = this.listView.getChildAt(1)) == null) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int y = ((int) childAt.getY()) - AndroidUtilities.dp(8.0f);
        int i = (y <= 0 || holder == null || holder.getAdapterPosition() != 1) ? 0 : y;
        if (y < 0 || holder == null || holder.getAdapterPosition() != 0) {
            y = i;
        }
        return y + AndroidUtilities.dp(25.0f);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(17.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.topPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r3, int r4) {
        /*
            r2 = this;
            ir.eitaa.ui.Components.ChatAttachAlert r3 = r2.parentAlert
            ir.eitaa.ui.Components.SizeNotifierFrameLayout r3 = r3.sizeNotifierFrameLayout
            int r3 = r3.measureKeyboardHeight()
            r0 = 1101004800(0x41a00000, float:20.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            r1 = 0
            if (r3 <= r0) goto L1d
            r3 = 1112539136(0x42500000, float:52.0)
            int r3 = ir.eitaa.messenger.AndroidUtilities.dp(r3)
            ir.eitaa.ui.Components.ChatAttachAlert r4 = r2.parentAlert
            r4.setAllowNestedScroll(r1)
            goto L46
        L1d:
            boolean r3 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r3 != 0) goto L31
            android.graphics.Point r3 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r0 = r3.x
            int r3 = r3.y
            if (r0 <= r3) goto L31
            float r3 = (float) r4
            r4 = 1080033280(0x40600000, float:3.5)
            float r3 = r3 / r4
            int r3 = (int) r3
            goto L35
        L31:
            int r4 = r4 / 5
            int r3 = r4 * 2
        L35:
            r4 = 1095761920(0x41500000, float:13.0)
            int r4 = ir.eitaa.messenger.AndroidUtilities.dp(r4)
            int r3 = r3 - r4
            if (r3 >= 0) goto L3f
            r3 = 0
        L3f:
            ir.eitaa.ui.Components.ChatAttachAlert r4 = r2.parentAlert
            boolean r0 = r2.allowNesterScroll
            r4.setAllowNestedScroll(r0)
        L46:
            r4 = 1
            r2.ignoreLayout = r4
            int r4 = r2.topPadding
            if (r4 == r3) goto L5c
            r2.topPadding = r3
            ir.eitaa.ui.Components.RecyclerListView r3 = r2.listView
            r4 = 0
            r3.setItemAnimator(r4)
            ir.eitaa.ui.Components.ChatAttachAlertPollLayout$ListAdapter r3 = r2.listAdapter
            int r4 = r2.paddingRow
            r3.notifyItemChanged(r4)
        L5c:
            r2.ignoreLayout = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.onPreMeasure(int, int):void");
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getButtonsHideOffset() {
        return AndroidUtilities.dp(70.0f);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(1);
    }

    public static CharSequence getFixedString(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            return text;
        }
        CharSequence trimmedString = AndroidUtilities.getTrimmedString(text);
        while (TextUtils.indexOf(trimmedString, "\n\n\n") >= 0) {
            trimmedString = TextUtils.replace(trimmedString, new String[]{"\n\n\n"}, new CharSequence[]{"\n\n"});
        }
        while (TextUtils.indexOf(trimmedString, "\n\n\n") == 0) {
            trimmedString = TextUtils.replace(trimmedString, new String[]{"\n\n\n"}, new CharSequence[]{"\n\n"});
        }
        return trimmedString;
    }

    private void showQuizHint() {
        this.listView.getChildCount();
        for (int i = this.answerStartRow; i < this.answerStartRow + this.answersCount; i++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                if (view instanceof PollEditTextCell) {
                    PollEditTextCell pollEditTextCell = (PollEditTextCell) view;
                    if (pollEditTextCell.getTop() > AndroidUtilities.dp(40.0f)) {
                        this.hintView.showForView(pollEditTextCell.getCheckBox(), true);
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDoneButton() {
        int i;
        if (this.quizPoll) {
            i = 0;
            for (int i2 = 0; i2 < this.answersChecks.length; i2++) {
                if (!TextUtils.isEmpty(getFixedString(this.answers[i2])) && this.answersChecks[i2]) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        boolean z = (TextUtils.isEmpty(getFixedString(this.solutionString)) || this.solutionString.length() <= 200) && !TextUtils.isEmpty(getFixedString(this.questionString)) && this.questionString.length() <= 255;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            String[] strArr = this.answers;
            if (i3 >= strArr.length) {
                break;
            }
            if (!TextUtils.isEmpty(getFixedString(strArr[i3]))) {
                if (this.answers[i3].length() > 100) {
                    i4 = 0;
                    z2 = true;
                    break;
                } else {
                    i4++;
                    z2 = true;
                }
            }
            i3++;
        }
        if (i4 < 2 || (this.quizPoll && i < 1)) {
            z = false;
        }
        if (!TextUtils.isEmpty(this.solutionString) || !TextUtils.isEmpty(this.questionString) || z2) {
            this.allowNesterScroll = false;
        } else {
            this.allowNesterScroll = true;
        }
        this.parentAlert.setAllowNestedScroll(this.allowNesterScroll);
        this.parentAlert.doneItem.setEnabled((this.quizPoll && i == 0) || z);
        this.parentAlert.doneItem.setAlpha(z ? 1.0f : 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.paddingRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.questionHeaderRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.questionRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.questionSectionRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.answerHeaderRow = i4;
        int i6 = this.answersCount;
        if (i6 != 0) {
            this.answerStartRow = i5;
            this.rowCount = i5 + i6;
        } else {
            this.answerStartRow = -1;
        }
        if (i6 != this.answers.length) {
            int i7 = this.rowCount;
            this.rowCount = i7 + 1;
            this.addAnswerRow = i7;
        } else {
            this.addAnswerRow = -1;
        }
        int i8 = this.rowCount;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.answerSectionRow = i8;
        this.rowCount = i9 + 1;
        this.settingsHeaderRow = i9;
        TLRPC$Chat currentChat = ((ChatActivity) this.parentAlert.baseFragment).getCurrentChat();
        if (!ChatObject.isChannel(currentChat) || currentChat.megagroup) {
            int i10 = this.rowCount;
            this.rowCount = i10 + 1;
            this.anonymousRow = i10;
        } else {
            this.anonymousRow = -1;
        }
        int i11 = this.quizOnly;
        if (i11 != 1) {
            int i12 = this.rowCount;
            this.rowCount = i12 + 1;
            this.multipleRow = i12;
        } else {
            this.multipleRow = -1;
        }
        if (i11 == 0) {
            int i13 = this.rowCount;
            this.rowCount = i13 + 1;
            this.quizRow = i13;
        } else {
            this.quizRow = -1;
        }
        int i14 = this.rowCount;
        int i15 = i14 + 1;
        this.rowCount = i15;
        this.settingsSectionRow = i14;
        if (this.quizPoll) {
            int i16 = i15 + 1;
            this.rowCount = i16;
            this.solutionRow = i15;
            this.rowCount = i16 + 1;
            this.solutionInfoRow = i16;
        } else {
            this.solutionRow = -1;
            this.solutionInfoRow = -1;
        }
        int i17 = this.rowCount;
        this.rowCount = i17 + 1;
        this.emptyRow = i17;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        if (this.quizOnly == 1) {
            this.parentAlert.actionBar.setTitle(LocaleController.getString("NewQuiz", R.string.NewQuiz));
        } else {
            this.parentAlert.actionBar.setTitle(LocaleController.getString("NewPoll", R.string.NewPoll));
        }
        this.parentAlert.doneItem.setVisibility(0);
        this.layoutManager.scrollToPositionWithOffset(0, 0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHidden() {
        this.parentAlert.doneItem.setVisibility(4);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    boolean onBackPressed() {
        if (checkDiscard()) {
            return super.onBackPressed();
        }
        return true;
    }

    private boolean checkDiscard() {
        boolean zIsEmpty = TextUtils.isEmpty(getFixedString(this.questionString));
        if (zIsEmpty) {
            for (int i = 0; i < this.answersCount && (zIsEmpty = TextUtils.isEmpty(getFixedString(this.answers[i]))); i++) {
            }
        }
        if (!zIsEmpty) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.parentAlert.baseFragment.getParentActivity());
            builder.setTitle(LocaleController.getString("CancelPollAlertTitle", R.string.CancelPollAlertTitle));
            builder.setMessage(LocaleController.getString("CancelPollAlertText", R.string.CancelPollAlertText));
            builder.setPositiveButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPollLayout$4cgGTFaM3vHfUytuWT74_jM4pe8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$checkDiscard$2$ChatAttachAlertPollLayout(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            builder.show();
        }
        return zIsEmpty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$2$ChatAttachAlertPollLayout(DialogInterface dialogInterface, int i) {
        this.parentAlert.dismiss();
    }

    public void setDelegate(PollCreateActivityDelegate pollCreateActivityDelegate) {
        this.delegate = pollCreateActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextLeft(View cell, int index) {
        int length;
        if (cell instanceof PollEditTextCell) {
            PollEditTextCell pollEditTextCell = (PollEditTextCell) cell;
            int i = 100;
            if (index == this.questionRow) {
                String str = this.questionString;
                length = 255 - (str != null ? str.length() : 0);
                i = 255;
            } else if (index == this.solutionRow) {
                CharSequence charSequence = this.solutionString;
                length = 200 - (charSequence != null ? charSequence.length() : 0);
                i = 200;
            } else {
                int i2 = this.answerStartRow;
                if (index < i2 || index >= this.answersCount + i2) {
                    return;
                }
                int i3 = index - i2;
                String[] strArr = this.answers;
                length = 100 - (strArr[i3] != null ? strArr[i3].length() : 0);
            }
            float f = i;
            if (length <= f - (0.7f * f)) {
                pollEditTextCell.setText2(String.format("%d", Integer.valueOf(length)));
                SimpleTextView textView2 = pollEditTextCell.getTextView2();
                String str2 = length < 0 ? "windowBackgroundWhiteRedText5" : "windowBackgroundWhiteGrayText3";
                textView2.setTextColor(getThemedColor(str2));
                textView2.setTag(str2);
                return;
            }
            pollEditTextCell.setText2("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNewField() {
        this.listView.setItemAnimator(this.itemAnimator);
        boolean[] zArr = this.answersChecks;
        int i = this.answersCount;
        zArr[i] = false;
        int i2 = i + 1;
        this.answersCount = i2;
        if (i2 == this.answers.length) {
            this.listAdapter.notifyItemRemoved(this.addAnswerRow);
        }
        this.listAdapter.notifyItemInserted(this.addAnswerRow);
        updateRows();
        this.requestFieldFocusAtPosition = (this.answerStartRow + this.answersCount) - 1;
        this.listAdapter.notifyItemChanged(this.answerSectionRow);
        this.listAdapter.notifyItemChanged(this.emptyRow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChatAttachAlertPollLayout.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position == ChatAttachAlertPollLayout.this.questionHeaderRow) {
                    headerCell.getTextView().setGravity(19);
                    headerCell.setText(LocaleController.getString("PollQuestion", R.string.PollQuestion));
                    return;
                }
                headerCell.getTextView().setGravity((LocaleController.isRTL ? 5 : 3) | 16);
                if (position == ChatAttachAlertPollLayout.this.answerHeaderRow) {
                    if (ChatAttachAlertPollLayout.this.quizOnly == 1) {
                        headerCell.setText(LocaleController.getString("QuizAnswers", R.string.QuizAnswers));
                        return;
                    } else {
                        headerCell.setText(LocaleController.getString("AnswerOptions", R.string.AnswerOptions));
                        return;
                    }
                }
                if (position == ChatAttachAlertPollLayout.this.settingsHeaderRow) {
                    headerCell.setText(LocaleController.getString("Settings", R.string.Settings));
                    return;
                }
                return;
            }
            if (itemViewType == 6) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (position == ChatAttachAlertPollLayout.this.anonymousRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("PollAnonymous", R.string.PollAnonymous), ChatAttachAlertPollLayout.this.anonymousPoll, (ChatAttachAlertPollLayout.this.multipleRow == -1 && ChatAttachAlertPollLayout.this.quizRow == -1) ? false : true);
                    textCheckCell.setEnabled(true, null);
                    return;
                } else if (position == ChatAttachAlertPollLayout.this.multipleRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("PollMultiple", R.string.PollMultiple), ChatAttachAlertPollLayout.this.multipleChoise, ChatAttachAlertPollLayout.this.quizRow != -1);
                    textCheckCell.setEnabled(true, null);
                    return;
                } else {
                    if (position == ChatAttachAlertPollLayout.this.quizRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("PollQuiz", R.string.PollQuiz), ChatAttachAlertPollLayout.this.quizPoll, false);
                        textCheckCell.setEnabled(ChatAttachAlertPollLayout.this.quizOnly == 0, null);
                        return;
                    }
                    return;
                }
            }
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    return;
                }
                TextCell textCell = (TextCell) holder.itemView;
                textCell.setColors(null, "windowBackgroundWhiteBlueText4");
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.poll_add_circle);
                Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.poll_add_plus);
                drawable.setColorFilter(new PorterDuffColorFilter(ChatAttachAlertPollLayout.this.getThemedColor("switchTrackChecked"), PorterDuff.Mode.MULTIPLY));
                drawable2.setColorFilter(new PorterDuffColorFilter(ChatAttachAlertPollLayout.this.getThemedColor("checkboxCheck"), PorterDuff.Mode.MULTIPLY));
                textCell.setTextAndIcon(LocaleController.getString("AddAnOption", R.string.AddAnOption), (Drawable) new CombinedDrawable(drawable, drawable2), false);
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
            CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(ChatAttachAlertPollLayout.this.getThemedColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            combinedDrawable.setFullsize(true);
            textInfoPrivacyCell.setBackgroundDrawable(combinedDrawable);
            if (position != ChatAttachAlertPollLayout.this.solutionInfoRow) {
                if (position == ChatAttachAlertPollLayout.this.settingsSectionRow) {
                    if (ChatAttachAlertPollLayout.this.quizOnly != 0) {
                        textInfoPrivacyCell.setText(null);
                        return;
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("QuizInfo", R.string.QuizInfo));
                        return;
                    }
                }
                if (10 - ChatAttachAlertPollLayout.this.answersCount <= 0) {
                    textInfoPrivacyCell.setText(LocaleController.getString("AddAnOptionInfoMax", R.string.AddAnOptionInfoMax));
                    return;
                } else {
                    textInfoPrivacyCell.setText(LocaleController.formatString("AddAnOptionInfo", R.string.AddAnOptionInfo, LocaleController.formatPluralString("Option", 10 - ChatAttachAlertPollLayout.this.answersCount)));
                    return;
                }
            }
            textInfoPrivacyCell.setText(LocaleController.getString("AddAnExplanationInfo", R.string.AddAnExplanationInfo));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 4) {
                PollEditTextCell pollEditTextCell = (PollEditTextCell) holder.itemView;
                pollEditTextCell.setTag(1);
                pollEditTextCell.setTextAndHint(ChatAttachAlertPollLayout.this.questionString != null ? ChatAttachAlertPollLayout.this.questionString : "", LocaleController.getString("QuestionHint", R.string.QuestionHint), false);
                pollEditTextCell.setTag(null);
                ChatAttachAlertPollLayout.this.setTextLeft(holder.itemView, holder.getAdapterPosition());
                return;
            }
            if (itemViewType != 5) {
                if (itemViewType == 7) {
                    PollEditTextCell pollEditTextCell2 = (PollEditTextCell) holder.itemView;
                    pollEditTextCell2.setTag(1);
                    pollEditTextCell2.setTextAndHint(ChatAttachAlertPollLayout.this.solutionString != null ? ChatAttachAlertPollLayout.this.solutionString : "", LocaleController.getString("AddAnExplanation", R.string.AddAnExplanation), false);
                    pollEditTextCell2.setTag(null);
                    ChatAttachAlertPollLayout.this.setTextLeft(holder.itemView, holder.getAdapterPosition());
                    return;
                }
                return;
            }
            int adapterPosition = holder.getAdapterPosition();
            PollEditTextCell pollEditTextCell3 = (PollEditTextCell) holder.itemView;
            pollEditTextCell3.setTag(1);
            pollEditTextCell3.setTextAndHint(ChatAttachAlertPollLayout.this.answers[adapterPosition - ChatAttachAlertPollLayout.this.answerStartRow], LocaleController.getString("OptionHint", R.string.OptionHint), true);
            pollEditTextCell3.setTag(null);
            if (ChatAttachAlertPollLayout.this.requestFieldFocusAtPosition == adapterPosition) {
                EditTextBoldCursor textView = pollEditTextCell3.getTextView();
                textView.requestFocus();
                AndroidUtilities.showKeyboard(textView);
                ChatAttachAlertPollLayout.this.requestFieldFocusAtPosition = -1;
            }
            ChatAttachAlertPollLayout.this.setTextLeft(holder.itemView, adapterPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 4) {
                EditTextBoldCursor textView = ((PollEditTextCell) holder.itemView).getTextView();
                if (textView.isFocused()) {
                    textView.clearFocus();
                    AndroidUtilities.hideKeyboard(textView);
                }
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == ChatAttachAlertPollLayout.this.addAnswerRow || adapterPosition == ChatAttachAlertPollLayout.this.anonymousRow || adapterPosition == ChatAttachAlertPollLayout.this.multipleRow || (ChatAttachAlertPollLayout.this.quizOnly == 0 && adapterPosition == ChatAttachAlertPollLayout.this.quizRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final PollEditTextCell pollEditTextCell;
            View headerCell;
            View.OnClickListener onClickListener = null;
            boolean z = true;
            switch (i) {
                case 0:
                    headerCell = new HeaderCell(this.mContext, "windowBackgroundWhiteBlueHeader", 21, 15, false);
                    break;
                case 1:
                    View shadowSectionCell = new ShadowSectionCell(this.mContext);
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(ChatAttachAlertPollLayout.this.getThemedColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    combinedDrawable.setFullsize(true);
                    shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                    headerCell = shadowSectionCell;
                    break;
                case 2:
                    headerCell = new TextInfoPrivacyCell(this.mContext);
                    break;
                case 3:
                    headerCell = new TextCell(this.mContext);
                    break;
                case 4:
                    pollEditTextCell = new PollEditTextCell(this.mContext, onClickListener) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.1
                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected void onFieldTouchUp(EditTextBoldCursor editText) {
                            ChatAttachAlertPollLayout.this.parentAlert.makeFocusable(editText, true);
                        }
                    };
                    pollEditTextCell.createErrorTextView();
                    pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.2
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (pollEditTextCell.getTag() != null) {
                                return;
                            }
                            ChatAttachAlertPollLayout.this.questionString = s.toString();
                            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ChatAttachAlertPollLayout.this.listView.findViewHolderForAdapterPosition(ChatAttachAlertPollLayout.this.questionRow);
                            if (viewHolderFindViewHolderForAdapterPosition != null) {
                                ChatAttachAlertPollLayout chatAttachAlertPollLayout = ChatAttachAlertPollLayout.this;
                                chatAttachAlertPollLayout.setTextLeft(viewHolderFindViewHolderForAdapterPosition.itemView, chatAttachAlertPollLayout.questionRow);
                            }
                            ChatAttachAlertPollLayout.this.checkDoneButton();
                        }
                    });
                    headerCell = pollEditTextCell;
                    break;
                case 5:
                default:
                    final PollEditTextCell pollEditTextCell2 = new PollEditTextCell(this.mContext, new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPollLayout$ListAdapter$8TwNOvwLjQ4bhC8709NA7jOha6E
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$0$ChatAttachAlertPollLayout$ListAdapter(view);
                        }
                    }) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.6
                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected boolean drawDivider() {
                            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = ChatAttachAlertPollLayout.this.listView.findContainingViewHolder(this);
                            if (viewHolderFindContainingViewHolder != null) {
                                int adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition();
                                if (ChatAttachAlertPollLayout.this.answersCount == 10 && adapterPosition == (ChatAttachAlertPollLayout.this.answerStartRow + ChatAttachAlertPollLayout.this.answersCount) - 1) {
                                    return false;
                                }
                            }
                            return true;
                        }

                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected boolean shouldShowCheckBox() {
                            return ChatAttachAlertPollLayout.this.quizPoll;
                        }

                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected void onFieldTouchUp(EditTextBoldCursor editText) {
                            ChatAttachAlertPollLayout.this.parentAlert.makeFocusable(editText, true);
                        }

                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected void onCheckBoxClick(PollEditTextCell editText, boolean checked) {
                            int adapterPosition;
                            if (checked && ChatAttachAlertPollLayout.this.quizPoll) {
                                Arrays.fill(ChatAttachAlertPollLayout.this.answersChecks, false);
                                ChatAttachAlertPollLayout.this.listView.getChildCount();
                                for (int i2 = ChatAttachAlertPollLayout.this.answerStartRow; i2 < ChatAttachAlertPollLayout.this.answerStartRow + ChatAttachAlertPollLayout.this.answersCount; i2++) {
                                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ChatAttachAlertPollLayout.this.listView.findViewHolderForAdapterPosition(i2);
                                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                                        View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                                        if (view instanceof PollEditTextCell) {
                                            ((PollEditTextCell) view).setChecked(false, true);
                                        }
                                    }
                                }
                            }
                            super.onCheckBoxClick(editText, checked);
                            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = ChatAttachAlertPollLayout.this.listView.findContainingViewHolder(editText);
                            if (viewHolderFindContainingViewHolder != null && (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) != -1) {
                                ChatAttachAlertPollLayout.this.answersChecks[adapterPosition - ChatAttachAlertPollLayout.this.answerStartRow] = checked;
                            }
                            ChatAttachAlertPollLayout.this.checkDoneButton();
                        }

                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected boolean isChecked(PollEditTextCell editText) {
                            int adapterPosition;
                            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = ChatAttachAlertPollLayout.this.listView.findContainingViewHolder(editText);
                            if (viewHolderFindContainingViewHolder == null || (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) == -1) {
                                return false;
                            }
                            return ChatAttachAlertPollLayout.this.answersChecks[adapterPosition - ChatAttachAlertPollLayout.this.answerStartRow];
                        }
                    };
                    pollEditTextCell2.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.7
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            int adapterPosition;
                            int adapterPosition2;
                            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = ChatAttachAlertPollLayout.this.listView.findContainingViewHolder(pollEditTextCell2);
                            if (viewHolderFindContainingViewHolder == null || (adapterPosition2 = (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) - ChatAttachAlertPollLayout.this.answerStartRow) < 0 || adapterPosition2 >= ChatAttachAlertPollLayout.this.answers.length) {
                                return;
                            }
                            ChatAttachAlertPollLayout.this.answers[adapterPosition2] = s.toString();
                            ChatAttachAlertPollLayout.this.setTextLeft(pollEditTextCell2, adapterPosition);
                            ChatAttachAlertPollLayout.this.checkDoneButton();
                        }
                    });
                    pollEditTextCell2.setShowNextButton(true);
                    EditTextBoldCursor textView = pollEditTextCell2.getTextView();
                    textView.setImeOptions(textView.getImeOptions() | 5);
                    textView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPollLayout$ListAdapter$xe4IPKt6V2sqCcEY4G3Dj5SKjSc
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                            return this.f$0.lambda$onCreateViewHolder$1$ChatAttachAlertPollLayout$ListAdapter(pollEditTextCell2, textView2, i2, keyEvent);
                        }
                    });
                    textView.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPollLayout$ListAdapter$MuTY9mtOpuvtjXei1lpVHbG-jHA
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                            return ChatAttachAlertPollLayout.ListAdapter.lambda$onCreateViewHolder$2(pollEditTextCell2, view, i2, keyEvent);
                        }
                    });
                    headerCell = pollEditTextCell2;
                    break;
                case 6:
                    headerCell = new TextCheckCell(this.mContext);
                    break;
                case 7:
                    pollEditTextCell = new PollEditTextCell(this.mContext, z, onClickListener) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.3
                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected void onFieldTouchUp(EditTextBoldCursor editText) {
                            ChatAttachAlertPollLayout.this.parentAlert.makeFocusable(editText, true);
                        }

                        @Override // ir.eitaa.ui.Cells.PollEditTextCell
                        protected void onActionModeStart(EditTextBoldCursor editText, ActionMode actionMode) {
                            if (editText.isFocused() && editText.hasSelection()) {
                                Menu menu = actionMode.getMenu();
                                if (menu.findItem(android.R.id.copy) == null) {
                                    return;
                                }
                                ((ChatActivity) ChatAttachAlertPollLayout.this.parentAlert.baseFragment).fillActionModeMenu(menu);
                            }
                        }
                    };
                    pollEditTextCell.createErrorTextView();
                    pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.4
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (pollEditTextCell.getTag() != null) {
                                return;
                            }
                            ChatAttachAlertPollLayout.this.solutionString = s;
                            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ChatAttachAlertPollLayout.this.listView.findViewHolderForAdapterPosition(ChatAttachAlertPollLayout.this.solutionRow);
                            if (viewHolderFindViewHolderForAdapterPosition != null) {
                                ChatAttachAlertPollLayout chatAttachAlertPollLayout = ChatAttachAlertPollLayout.this;
                                chatAttachAlertPollLayout.setTextLeft(viewHolderFindViewHolderForAdapterPosition.itemView, chatAttachAlertPollLayout.solutionRow);
                            }
                            ChatAttachAlertPollLayout.this.checkDoneButton();
                        }
                    });
                    headerCell = pollEditTextCell;
                    break;
                case 8:
                    View emptyView = new EmptyView(this.mContext);
                    emptyView.setBackgroundColor(ChatAttachAlertPollLayout.this.getThemedColor("windowBackgroundGray"));
                    headerCell = emptyView;
                    break;
                case 9:
                    headerCell = new View(this.mContext) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.5
                        @Override // android.view.View
                        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), ChatAttachAlertPollLayout.this.topPadding);
                        }
                    };
                    break;
            }
            headerCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(headerCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ea  */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onCreateViewHolder$0$ChatAttachAlertPollLayout$ListAdapter(android.view.View r8) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertPollLayout.ListAdapter.lambda$onCreateViewHolder$0$ChatAttachAlertPollLayout$ListAdapter(android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$1$ChatAttachAlertPollLayout$ListAdapter(PollEditTextCell pollEditTextCell, TextView textView, int i, KeyEvent keyEvent) {
            int adapterPosition;
            if (i != 5) {
                return false;
            }
            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = ChatAttachAlertPollLayout.this.listView.findContainingViewHolder(pollEditTextCell);
            if (viewHolderFindContainingViewHolder != null && (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) != -1) {
                int i2 = adapterPosition - ChatAttachAlertPollLayout.this.answerStartRow;
                if (i2 != ChatAttachAlertPollLayout.this.answersCount - 1 || ChatAttachAlertPollLayout.this.answersCount >= 10) {
                    if (i2 != ChatAttachAlertPollLayout.this.answersCount - 1) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ChatAttachAlertPollLayout.this.listView.findViewHolderForAdapterPosition(adapterPosition + 1);
                        if (viewHolderFindViewHolderForAdapterPosition != null) {
                            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                            if (view instanceof PollEditTextCell) {
                                ((PollEditTextCell) view).getTextView().requestFocus();
                            }
                        }
                    } else {
                        AndroidUtilities.hideKeyboard(pollEditTextCell.getTextView());
                    }
                } else {
                    ChatAttachAlertPollLayout.this.addNewField();
                }
            }
            return true;
        }

        static /* synthetic */ boolean lambda$onCreateViewHolder$2(PollEditTextCell pollEditTextCell, View view, int i, KeyEvent keyEvent) {
            EditTextBoldCursor editTextBoldCursor = (EditTextBoldCursor) view;
            if (i != 67 || keyEvent.getAction() != 0 || editTextBoldCursor.length() != 0) {
                return false;
            }
            pollEditTextCell.callOnDelete();
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ChatAttachAlertPollLayout.this.questionHeaderRow || position == ChatAttachAlertPollLayout.this.answerHeaderRow || position == ChatAttachAlertPollLayout.this.settingsHeaderRow) {
                return 0;
            }
            if (position == ChatAttachAlertPollLayout.this.questionSectionRow) {
                return 1;
            }
            if (position == ChatAttachAlertPollLayout.this.answerSectionRow || position == ChatAttachAlertPollLayout.this.settingsSectionRow || position == ChatAttachAlertPollLayout.this.solutionInfoRow) {
                return 2;
            }
            if (position == ChatAttachAlertPollLayout.this.addAnswerRow) {
                return 3;
            }
            if (position == ChatAttachAlertPollLayout.this.questionRow) {
                return 4;
            }
            if (position == ChatAttachAlertPollLayout.this.solutionRow) {
                return 7;
            }
            if (position == ChatAttachAlertPollLayout.this.anonymousRow || position == ChatAttachAlertPollLayout.this.multipleRow || position == ChatAttachAlertPollLayout.this.quizRow) {
                return 6;
            }
            if (position == ChatAttachAlertPollLayout.this.emptyRow) {
                return 8;
            }
            return position == ChatAttachAlertPollLayout.this.paddingRow ? 9 : 5;
        }

        public void swapElements(int fromIndex, int toIndex) {
            int i = fromIndex - ChatAttachAlertPollLayout.this.answerStartRow;
            int i2 = toIndex - ChatAttachAlertPollLayout.this.answerStartRow;
            if (i < 0 || i2 < 0 || i >= ChatAttachAlertPollLayout.this.answersCount || i2 >= ChatAttachAlertPollLayout.this.answersCount) {
                return;
            }
            String str = ChatAttachAlertPollLayout.this.answers[i];
            ChatAttachAlertPollLayout.this.answers[i] = ChatAttachAlertPollLayout.this.answers[i2];
            ChatAttachAlertPollLayout.this.answers[i2] = str;
            boolean z = ChatAttachAlertPollLayout.this.answersChecks[i];
            ChatAttachAlertPollLayout.this.answersChecks[i] = ChatAttachAlertPollLayout.this.answersChecks[i2];
            ChatAttachAlertPollLayout.this.answersChecks[i2] = z;
            notifyItemMoved(fromIndex, toIndex);
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogScrollGlow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{EmptyView.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"deleteImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"moveImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{PollEditTextCell.class}, new String[]{"deleteImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menuSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{PollEditTextCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{PollEditTextCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{PollEditTextCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        return arrayList;
    }
}
