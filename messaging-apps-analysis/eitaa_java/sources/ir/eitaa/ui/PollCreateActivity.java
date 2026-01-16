package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
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
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.PollEditTextCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.ChatAttachAlertPollLayout;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.HintView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.PollCreateActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class PollCreateActivity extends BaseFragment {
    private int addAnswerRow;
    private int anonymousRow;
    private int answerHeaderRow;
    private int answerSectionRow;
    private int answerStartRow;
    private PollCreateActivityDelegate delegate;
    private ActionBarMenuItem doneItem;
    private boolean hintShowed;
    private HintView hintView;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean multipleChoise;
    private int multipleRow;
    private ChatActivity parentFragment;
    private int questionHeaderRow;
    private int questionRow;
    private int questionSectionRow;
    private String questionString;
    private int quizOnly;
    private boolean quizPoll;
    private int quizRow;
    private int rowCount;
    private int settingsHeaderRow;
    private int settingsSectionRow;
    private int solutionInfoRow;
    private int solutionRow;
    private CharSequence solutionString;
    private String[] answers = new String[10];
    private boolean[] answersChecks = new boolean[10];
    private int answersCount = 1;
    private boolean anonymousPoll = true;
    private int requestFieldFocusAtPosition = -1;

    public interface PollCreateActivityDelegate {
        void sendPoll(TLRPC$TL_messageMediaPoll poll, HashMap<String, String> params, boolean notify, int scheduleDate);
    }

    static /* synthetic */ int access$2210(PollCreateActivity pollCreateActivity) {
        int i = pollCreateActivity.answersCount;
        pollCreateActivity.answersCount = i - 1;
        return i;
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
            PollCreateActivity.this.listAdapter.swapElements(source.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState != 0) {
                PollCreateActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    public PollCreateActivity(ChatActivity chatActivity, Boolean quiz) {
        this.parentFragment = chatActivity;
        if (quiz != null) {
            boolean zBooleanValue = quiz.booleanValue();
            this.quizPoll = zBooleanValue;
            this.quizOnly = zBooleanValue ? 1 : 2;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        if (this.quizOnly == 1) {
            this.actionBar.setTitle(LocaleController.getString("NewQuiz", R.string.NewQuiz));
        } else {
            this.actionBar.setTitle(LocaleController.getString("NewPoll", R.string.NewPoll));
        }
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1());
        this.doneItem = this.actionBar.createMenu().addItem(1, LocaleController.getString("Create", R.string.Create).toUpperCase());
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.PollCreateActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView
            protected void requestChildOnScreen(View child, View focused) {
                if (child instanceof PollEditTextCell) {
                    super.requestChildOnScreen(child, focused);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                rectangle.bottom += AndroidUtilities.dp(60.0f);
                return super.requestChildRectangleOnScreen(child, rectangle, immediate);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        new ItemTouchHelper(new TouchHelperCallback()).attachToRecyclerView(this.listView);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PollCreateActivity$merrRAZo1qK6KDLreYAmzYbdI6M
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0$PollCreateActivity(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.PollCreateActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy == 0 || PollCreateActivity.this.hintView == null) {
                    return;
                }
                PollCreateActivity.this.hintView.hide();
            }
        });
        HintView hintView = new HintView(context, 4);
        this.hintView = hintView;
        hintView.setText(LocaleController.getString("PollTapToSelect", R.string.PollTapToSelect));
        this.hintView.setAlpha(0.0f);
        this.hintView.setVisibility(4);
        frameLayout2.addView(this.hintView, LayoutHelper.createFrame(-2, -2.0f, 51, 19.0f, 0.0f, 19.0f, 0.0f));
        checkDoneButton();
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.PollCreateActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) throws IOException {
            if (id == -1) {
                if (PollCreateActivity.this.checkDiscard()) {
                    PollCreateActivity.this.finishFragment();
                    return;
                }
                return;
            }
            if (id == 1) {
                if (PollCreateActivity.this.quizPoll && PollCreateActivity.this.doneItem.getAlpha() != 1.0f) {
                    int i = 0;
                    for (int i2 = 0; i2 < PollCreateActivity.this.answersChecks.length; i2++) {
                        if (!TextUtils.isEmpty(ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.answers[i2])) && PollCreateActivity.this.answersChecks[i2]) {
                            i++;
                        }
                    }
                    if (i <= 0) {
                        PollCreateActivity.this.showQuizHint();
                        return;
                    }
                    return;
                }
                final TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = new TLRPC$TL_messageMediaPoll();
                TLRPC$TL_poll tLRPC$TL_poll = new TLRPC$TL_poll();
                tLRPC$TL_messageMediaPoll.poll = tLRPC$TL_poll;
                tLRPC$TL_poll.multiple_choice = PollCreateActivity.this.multipleChoise;
                tLRPC$TL_messageMediaPoll.poll.quiz = PollCreateActivity.this.quizPoll;
                tLRPC$TL_messageMediaPoll.poll.public_voters = !PollCreateActivity.this.anonymousPoll;
                tLRPC$TL_messageMediaPoll.poll.question = ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.questionString).toString();
                SerializedData serializedData = new SerializedData(10);
                for (int i3 = 0; i3 < PollCreateActivity.this.answers.length; i3++) {
                    if (!TextUtils.isEmpty(ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.answers[i3]))) {
                        TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = new TLRPC$TL_pollAnswer();
                        tLRPC$TL_pollAnswer.text = ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.answers[i3]).toString();
                        tLRPC$TL_pollAnswer.option = new byte[]{(byte) (tLRPC$TL_messageMediaPoll.poll.answers.size() + 48)};
                        tLRPC$TL_messageMediaPoll.poll.answers.add(tLRPC$TL_pollAnswer);
                        if ((PollCreateActivity.this.multipleChoise || PollCreateActivity.this.quizPoll) && PollCreateActivity.this.answersChecks[i3]) {
                            serializedData.writeByte(tLRPC$TL_pollAnswer.option[0]);
                        }
                    }
                }
                final HashMap<String, String> map = new HashMap<>();
                map.put("answers", Utilities.bytesToHex(serializedData.toByteArray()));
                tLRPC$TL_messageMediaPoll.results = new TLRPC$TL_pollResults();
                CharSequence fixedString = ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.solutionString);
                if (fixedString != null) {
                    tLRPC$TL_messageMediaPoll.results.solution = fixedString.toString();
                    ArrayList<TLRPC$MessageEntity> entities = PollCreateActivity.this.getMediaDataController().getEntities(new CharSequence[]{fixedString}, true);
                    if (entities != null && !entities.isEmpty()) {
                        tLRPC$TL_messageMediaPoll.results.solution_entities = entities;
                    }
                    if (!TextUtils.isEmpty(tLRPC$TL_messageMediaPoll.results.solution)) {
                        tLRPC$TL_messageMediaPoll.results.flags |= 16;
                    }
                }
                if (PollCreateActivity.this.parentFragment.isInScheduleMode()) {
                    AlertsCreator.createScheduleDatePickerDialog(PollCreateActivity.this.getParentActivity(), PollCreateActivity.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PollCreateActivity$1$Gp1tnK_NoY-poh6VtSoWf7Tj5h8
                        @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i4) {
                            this.f$0.lambda$onItemClick$0$PollCreateActivity$1(tLRPC$TL_messageMediaPoll, map, z, i4);
                        }
                    });
                } else {
                    PollCreateActivity.this.delegate.sendPoll(tLRPC$TL_messageMediaPoll, map, true, 0);
                    PollCreateActivity.this.finishFragment();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$PollCreateActivity$1(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i) {
            PollCreateActivity.this.delegate.sendPoll(tLRPC$TL_messageMediaPoll, map, z, i);
            PollCreateActivity.this.finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$PollCreateActivity(View view, int i) {
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
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.quizRow);
                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                        ((TextCheckCell) viewHolderFindViewHolderForAdapterPosition.itemView).setChecked(false);
                    } else {
                        this.listAdapter.notifyItemChanged(this.quizRow);
                    }
                    this.listAdapter.notifyItemRangeRemoved(i2, 2);
                }
            } else {
                if (this.quizOnly != 0) {
                    return;
                }
                z = !z2;
                this.quizPoll = z;
                int i3 = this.solutionRow;
                updateRows();
                if (this.quizPoll) {
                    this.listAdapter.notifyItemRangeInserted(this.solutionRow, 2);
                } else {
                    this.listAdapter.notifyItemRangeRemoved(i3, 2);
                }
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQuizHint() {
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
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkDoneButton() {
        /*
            r7 = this;
            boolean r0 = r7.quizPoll
            r1 = 0
            if (r0 == 0) goto L25
            r0 = 0
            r2 = 0
        L7:
            boolean[] r3 = r7.answersChecks
            int r3 = r3.length
            if (r0 >= r3) goto L26
            java.lang.String[] r3 = r7.answers
            r3 = r3[r0]
            java.lang.CharSequence r3 = ir.eitaa.ui.Components.ChatAttachAlertPollLayout.getFixedString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L22
            boolean[] r3 = r7.answersChecks
            boolean r3 = r3[r0]
            if (r3 == 0) goto L22
            int r2 = r2 + 1
        L22:
            int r0 = r0 + 1
            goto L7
        L25:
            r2 = 0
        L26:
            java.lang.CharSequence r0 = r7.solutionString
            java.lang.CharSequence r0 = ir.eitaa.ui.Components.ChatAttachAlertPollLayout.getFixedString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            if (r0 != 0) goto L3e
            java.lang.CharSequence r0 = r7.solutionString
            int r0 = r0.length()
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 <= r4) goto L3e
            goto L87
        L3e:
            java.lang.String r0 = r7.questionString
            java.lang.CharSequence r0 = ir.eitaa.ui.Components.ChatAttachAlertPollLayout.getFixedString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L87
            java.lang.String r0 = r7.questionString
            int r0 = r0.length()
            r4 = 255(0xff, float:3.57E-43)
            if (r0 <= r4) goto L55
            goto L87
        L55:
            r0 = 0
            r4 = 0
        L57:
            java.lang.String[] r5 = r7.answers
            int r6 = r5.length
            if (r0 >= r6) goto L7b
            r5 = r5[r0]
            java.lang.CharSequence r5 = ir.eitaa.ui.Components.ChatAttachAlertPollLayout.getFixedString(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L78
            java.lang.String[] r5 = r7.answers
            r5 = r5[r0]
            int r5 = r5.length()
            r6 = 100
            if (r5 <= r6) goto L76
            r4 = 0
            goto L7b
        L76:
            int r4 = r4 + 1
        L78:
            int r0 = r0 + 1
            goto L57
        L7b:
            r0 = 2
            if (r4 < r0) goto L87
            boolean r0 = r7.quizPoll
            if (r0 == 0) goto L85
            if (r2 >= r3) goto L85
            goto L87
        L85:
            r0 = 1
            goto L88
        L87:
            r0 = 0
        L88:
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r4 = r7.doneItem
            boolean r5 = r7.quizPoll
            if (r5 == 0) goto L90
            if (r2 == 0) goto L92
        L90:
            if (r0 == 0) goto L93
        L92:
            r1 = 1
        L93:
            r4.setEnabled(r1)
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r1 = r7.doneItem
            if (r0 == 0) goto L9d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L9f
        L9d:
            r0 = 1056964608(0x3f000000, float:0.5)
        L9f:
            r1.setAlpha(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PollCreateActivity.checkDoneButton():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.questionHeaderRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.questionRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.questionSectionRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.answerHeaderRow = i3;
        int i5 = this.answersCount;
        if (i5 != 0) {
            this.answerStartRow = i4;
            this.rowCount = i4 + i5;
        } else {
            this.answerStartRow = -1;
        }
        if (i5 != this.answers.length) {
            int i6 = this.rowCount;
            this.rowCount = i6 + 1;
            this.addAnswerRow = i6;
        } else {
            this.addAnswerRow = -1;
        }
        int i7 = this.rowCount;
        int i8 = i7 + 1;
        this.rowCount = i8;
        this.answerSectionRow = i7;
        this.rowCount = i8 + 1;
        this.settingsHeaderRow = i8;
        TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
        if (!ChatObject.isChannel(currentChat) || currentChat.megagroup) {
            int i9 = this.rowCount;
            this.rowCount = i9 + 1;
            this.anonymousRow = i9;
        } else {
            this.anonymousRow = -1;
        }
        int i10 = this.quizOnly;
        if (i10 != 1) {
            int i11 = this.rowCount;
            this.rowCount = i11 + 1;
            this.multipleRow = i11;
        } else {
            this.multipleRow = -1;
        }
        if (i10 == 0) {
            int i12 = this.rowCount;
            this.rowCount = i12 + 1;
            this.quizRow = i12;
        } else {
            this.quizRow = -1;
        }
        int i13 = this.rowCount;
        int i14 = i13 + 1;
        this.rowCount = i14;
        this.settingsSectionRow = i13;
        if (this.quizPoll) {
            int i15 = i14 + 1;
            this.rowCount = i15;
            this.solutionRow = i14;
            this.rowCount = i15 + 1;
            this.solutionInfoRow = i15;
            return;
        }
        this.solutionRow = -1;
        this.solutionInfoRow = -1;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return checkDiscard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDiscard() {
        boolean zIsEmpty = TextUtils.isEmpty(ChatAttachAlertPollLayout.getFixedString(this.questionString));
        if (zIsEmpty) {
            for (int i = 0; i < this.answersCount && (zIsEmpty = TextUtils.isEmpty(ChatAttachAlertPollLayout.getFixedString(this.answers[i]))); i++) {
            }
        }
        if (!zIsEmpty) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("CancelPollAlertTitle", R.string.CancelPollAlertTitle));
            builder.setMessage(LocaleController.getString("CancelPollAlertText", R.string.CancelPollAlertText));
            builder.setPositiveButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PollCreateActivity$WonJXXttbHZqNDox2tT0A-BLxRQ
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$checkDiscard$1$PollCreateActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        }
        return zIsEmpty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$1$PollCreateActivity(DialogInterface dialogInterface, int i) {
        finishFragment();
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
                textView2.setTextColor(Theme.getColor(str2));
                textView2.setTag(str2);
                return;
            }
            pollEditTextCell.setText2("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNewField() {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PollCreateActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position != PollCreateActivity.this.questionHeaderRow) {
                    if (position == PollCreateActivity.this.answerHeaderRow) {
                        if (PollCreateActivity.this.quizOnly == 1) {
                            headerCell.setText(LocaleController.getString("QuizAnswers", R.string.QuizAnswers));
                            return;
                        } else {
                            headerCell.setText(LocaleController.getString("AnswerOptions", R.string.AnswerOptions));
                            return;
                        }
                    }
                    if (position == PollCreateActivity.this.settingsHeaderRow) {
                        headerCell.setText(LocaleController.getString("Settings", R.string.Settings));
                        return;
                    }
                    return;
                }
                headerCell.setText(LocaleController.getString("PollQuestion", R.string.PollQuestion));
                return;
            }
            if (itemViewType == 6) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (position == PollCreateActivity.this.anonymousRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("PollAnonymous", R.string.PollAnonymous), PollCreateActivity.this.anonymousPoll, (PollCreateActivity.this.multipleRow == -1 && PollCreateActivity.this.quizRow == -1) ? false : true);
                    textCheckCell.setEnabled(true, null);
                    return;
                } else if (position == PollCreateActivity.this.multipleRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("PollMultiple", R.string.PollMultiple), PollCreateActivity.this.multipleChoise, PollCreateActivity.this.quizRow != -1);
                    textCheckCell.setEnabled(true, null);
                    return;
                } else {
                    if (position == PollCreateActivity.this.quizRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("PollQuiz", R.string.PollQuiz), PollCreateActivity.this.quizPoll, false);
                        textCheckCell.setEnabled(PollCreateActivity.this.quizOnly == 0, null);
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
                drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("switchTrackChecked"), PorterDuff.Mode.MULTIPLY));
                drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("checkboxCheck"), PorterDuff.Mode.MULTIPLY));
                textCell.setTextAndIcon(LocaleController.getString("AddAnOption", R.string.AddAnOption), (Drawable) new CombinedDrawable(drawable, drawable2), false);
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
            textInfoPrivacyCell.setFixedSize(0);
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            if (position != PollCreateActivity.this.solutionInfoRow) {
                if (position == PollCreateActivity.this.settingsSectionRow) {
                    if (PollCreateActivity.this.quizOnly != 0) {
                        textInfoPrivacyCell.setFixedSize(12);
                        textInfoPrivacyCell.setText(null);
                        return;
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("QuizInfo", R.string.QuizInfo));
                        return;
                    }
                }
                if (10 - PollCreateActivity.this.answersCount <= 0) {
                    textInfoPrivacyCell.setText(LocaleController.getString("AddAnOptionInfoMax", R.string.AddAnOptionInfoMax));
                    return;
                } else {
                    textInfoPrivacyCell.setText(LocaleController.formatString("AddAnOptionInfo", R.string.AddAnOptionInfo, LocaleController.formatPluralString("Option", 10 - PollCreateActivity.this.answersCount)));
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
                pollEditTextCell.setTextAndHint(PollCreateActivity.this.questionString != null ? PollCreateActivity.this.questionString : "", LocaleController.getString("QuestionHint", R.string.QuestionHint), false);
                pollEditTextCell.setTag(null);
                PollCreateActivity.this.setTextLeft(holder.itemView, holder.getAdapterPosition());
                return;
            }
            if (itemViewType != 5) {
                if (itemViewType == 7) {
                    PollEditTextCell pollEditTextCell2 = (PollEditTextCell) holder.itemView;
                    pollEditTextCell2.setTag(1);
                    pollEditTextCell2.setTextAndHint(PollCreateActivity.this.solutionString != null ? PollCreateActivity.this.solutionString : "", LocaleController.getString("AddAnExplanation", R.string.AddAnExplanation), false);
                    pollEditTextCell2.setTag(null);
                    PollCreateActivity.this.setTextLeft(holder.itemView, holder.getAdapterPosition());
                    return;
                }
                return;
            }
            int adapterPosition = holder.getAdapterPosition();
            PollEditTextCell pollEditTextCell3 = (PollEditTextCell) holder.itemView;
            pollEditTextCell3.setTag(1);
            pollEditTextCell3.setTextAndHint(PollCreateActivity.this.answers[adapterPosition - PollCreateActivity.this.answerStartRow], LocaleController.getString("OptionHint", R.string.OptionHint), true);
            pollEditTextCell3.setTag(null);
            if (PollCreateActivity.this.requestFieldFocusAtPosition == adapterPosition) {
                EditTextBoldCursor textView = pollEditTextCell3.getTextView();
                textView.requestFocus();
                AndroidUtilities.showKeyboard(textView);
                PollCreateActivity.this.requestFieldFocusAtPosition = -1;
            }
            PollCreateActivity.this.setTextLeft(holder.itemView, adapterPosition);
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
            return adapterPosition == PollCreateActivity.this.addAnswerRow || adapterPosition == PollCreateActivity.this.anonymousRow || adapterPosition == PollCreateActivity.this.multipleRow || (PollCreateActivity.this.quizOnly == 0 && adapterPosition == PollCreateActivity.this.quizRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shadowSectionCell;
            if (i != 0) {
                boolean z = true;
                if (i == 1) {
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                } else if (i == 2) {
                    shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                } else if (i != 3) {
                    View.OnClickListener onClickListener = null;
                    if (i == 4) {
                        final PollEditTextCell pollEditTextCell = new PollEditTextCell(this.mContext, null);
                        pollEditTextCell.createErrorTextView();
                        pollEditTextCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.PollCreateActivity.ListAdapter.1
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
                                PollCreateActivity.this.questionString = s.toString();
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = PollCreateActivity.this.listView.findViewHolderForAdapterPosition(PollCreateActivity.this.questionRow);
                                if (viewHolderFindViewHolderForAdapterPosition != null) {
                                    PollCreateActivity pollCreateActivity = PollCreateActivity.this;
                                    pollCreateActivity.setTextLeft(viewHolderFindViewHolderForAdapterPosition.itemView, pollCreateActivity.questionRow);
                                }
                                PollCreateActivity.this.checkDoneButton();
                            }
                        });
                        shadowSectionCell = pollEditTextCell;
                    } else if (i == 6) {
                        View textCheckCell = new TextCheckCell(this.mContext);
                        textCheckCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        shadowSectionCell = textCheckCell;
                    } else if (i == 7) {
                        final PollEditTextCell pollEditTextCell2 = new PollEditTextCell(this.mContext, z, onClickListener) { // from class: ir.eitaa.ui.PollCreateActivity.ListAdapter.2
                            @Override // ir.eitaa.ui.Cells.PollEditTextCell
                            protected void onActionModeStart(EditTextBoldCursor editText, ActionMode actionMode) {
                                if (editText.isFocused() && editText.hasSelection()) {
                                    Menu menu = actionMode.getMenu();
                                    if (menu.findItem(android.R.id.copy) == null) {
                                        return;
                                    }
                                    PollCreateActivity.this.parentFragment.fillActionModeMenu(menu);
                                }
                            }
                        };
                        pollEditTextCell2.createErrorTextView();
                        pollEditTextCell2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        pollEditTextCell2.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.PollCreateActivity.ListAdapter.3
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable s) {
                                if (pollEditTextCell2.getTag() != null) {
                                    return;
                                }
                                PollCreateActivity.this.solutionString = s;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = PollCreateActivity.this.listView.findViewHolderForAdapterPosition(PollCreateActivity.this.solutionRow);
                                if (viewHolderFindViewHolderForAdapterPosition != null) {
                                    PollCreateActivity pollCreateActivity = PollCreateActivity.this;
                                    pollCreateActivity.setTextLeft(viewHolderFindViewHolderForAdapterPosition.itemView, pollCreateActivity.solutionRow);
                                }
                                PollCreateActivity.this.checkDoneButton();
                            }
                        });
                        shadowSectionCell = pollEditTextCell2;
                    } else {
                        final PollEditTextCell pollEditTextCell3 = new PollEditTextCell(this.mContext, new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PollCreateActivity$ListAdapter$UlPfyiwgySwDpecO8YDxsYpDT18
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.f$0.lambda$onCreateViewHolder$0$PollCreateActivity$ListAdapter(view);
                            }
                        }) { // from class: ir.eitaa.ui.PollCreateActivity.ListAdapter.4
                            @Override // ir.eitaa.ui.Cells.PollEditTextCell
                            protected boolean drawDivider() {
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(this);
                                if (viewHolderFindContainingViewHolder != null) {
                                    int adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition();
                                    if (PollCreateActivity.this.answersCount == 10 && adapterPosition == (PollCreateActivity.this.answerStartRow + PollCreateActivity.this.answersCount) - 1) {
                                        return false;
                                    }
                                }
                                return true;
                            }

                            @Override // ir.eitaa.ui.Cells.PollEditTextCell
                            protected boolean shouldShowCheckBox() {
                                return PollCreateActivity.this.quizPoll;
                            }

                            @Override // ir.eitaa.ui.Cells.PollEditTextCell
                            protected void onCheckBoxClick(PollEditTextCell editText, boolean checked) {
                                int adapterPosition;
                                if (checked && PollCreateActivity.this.quizPoll) {
                                    Arrays.fill(PollCreateActivity.this.answersChecks, false);
                                    PollCreateActivity.this.listView.getChildCount();
                                    for (int i2 = PollCreateActivity.this.answerStartRow; i2 < PollCreateActivity.this.answerStartRow + PollCreateActivity.this.answersCount; i2++) {
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = PollCreateActivity.this.listView.findViewHolderForAdapterPosition(i2);
                                        if (viewHolderFindViewHolderForAdapterPosition != null) {
                                            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                                            if (view instanceof PollEditTextCell) {
                                                ((PollEditTextCell) view).setChecked(false, true);
                                            }
                                        }
                                    }
                                }
                                super.onCheckBoxClick(editText, checked);
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(editText);
                                if (viewHolderFindContainingViewHolder != null && (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) != -1) {
                                    PollCreateActivity.this.answersChecks[adapterPosition - PollCreateActivity.this.answerStartRow] = checked;
                                }
                                PollCreateActivity.this.checkDoneButton();
                            }

                            @Override // ir.eitaa.ui.Cells.PollEditTextCell
                            protected boolean isChecked(PollEditTextCell editText) {
                                int adapterPosition;
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(editText);
                                if (viewHolderFindContainingViewHolder == null || (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) == -1) {
                                    return false;
                                }
                                return PollCreateActivity.this.answersChecks[adapterPosition - PollCreateActivity.this.answerStartRow];
                            }
                        };
                        pollEditTextCell3.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        pollEditTextCell3.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.PollCreateActivity.ListAdapter.5
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable s) {
                                int adapterPosition;
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(pollEditTextCell3);
                                if (viewHolderFindContainingViewHolder == null || (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition() - PollCreateActivity.this.answerStartRow) < 0 || adapterPosition >= PollCreateActivity.this.answers.length) {
                                    return;
                                }
                                PollCreateActivity.this.answers[adapterPosition] = s.toString();
                                PollCreateActivity.this.setTextLeft(pollEditTextCell3, adapterPosition);
                                PollCreateActivity.this.checkDoneButton();
                            }
                        });
                        pollEditTextCell3.setShowNextButton(true);
                        EditTextBoldCursor textView = pollEditTextCell3.getTextView();
                        textView.setImeOptions(textView.getImeOptions() | 5);
                        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PollCreateActivity$ListAdapter$Qw0l0aKTImGps6sVTP2u32ijQ4g
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                                return this.f$0.lambda$onCreateViewHolder$1$PollCreateActivity$ListAdapter(pollEditTextCell3, textView2, i2, keyEvent);
                            }
                        });
                        textView.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$PollCreateActivity$ListAdapter$1-F3w9swP9NyFaUZ7EFCC5wnvZg
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                                return PollCreateActivity.ListAdapter.lambda$onCreateViewHolder$2(pollEditTextCell3, view, i2, keyEvent);
                            }
                        });
                        shadowSectionCell = pollEditTextCell3;
                    }
                } else {
                    View textCell = new TextCell(this.mContext);
                    textCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textCell;
                }
            } else {
                View headerCell = new HeaderCell(this.mContext, "windowBackgroundWhiteBlueHeader", 21, 15, false);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = headerCell;
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00db  */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onCreateViewHolder$0$PollCreateActivity$ListAdapter(android.view.View r8) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PollCreateActivity.ListAdapter.lambda$onCreateViewHolder$0$PollCreateActivity$ListAdapter(android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$1$PollCreateActivity$ListAdapter(PollEditTextCell pollEditTextCell, TextView textView, int i, KeyEvent keyEvent) {
            int adapterPosition;
            if (i != 5) {
                return false;
            }
            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(pollEditTextCell);
            if (viewHolderFindContainingViewHolder != null && (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) != -1) {
                int i2 = adapterPosition - PollCreateActivity.this.answerStartRow;
                if (i2 != PollCreateActivity.this.answersCount - 1 || PollCreateActivity.this.answersCount >= 10) {
                    if (i2 != PollCreateActivity.this.answersCount - 1) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = PollCreateActivity.this.listView.findViewHolderForAdapterPosition(adapterPosition + 1);
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
                    PollCreateActivity.this.addNewField();
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
            if (position == PollCreateActivity.this.questionHeaderRow || position == PollCreateActivity.this.answerHeaderRow || position == PollCreateActivity.this.settingsHeaderRow) {
                return 0;
            }
            if (position == PollCreateActivity.this.questionSectionRow) {
                return 1;
            }
            if (position == PollCreateActivity.this.answerSectionRow || position == PollCreateActivity.this.settingsSectionRow || position == PollCreateActivity.this.solutionInfoRow) {
                return 2;
            }
            if (position == PollCreateActivity.this.addAnswerRow) {
                return 3;
            }
            if (position == PollCreateActivity.this.questionRow) {
                return 4;
            }
            if (position == PollCreateActivity.this.solutionRow) {
                return 7;
            }
            return (position == PollCreateActivity.this.anonymousRow || position == PollCreateActivity.this.multipleRow || position == PollCreateActivity.this.quizRow) ? 6 : 5;
        }

        public void swapElements(int fromIndex, int toIndex) {
            int i = fromIndex - PollCreateActivity.this.answerStartRow;
            int i2 = toIndex - PollCreateActivity.this.answerStartRow;
            if (i < 0 || i2 < 0 || i >= PollCreateActivity.this.answersCount || i2 >= PollCreateActivity.this.answersCount) {
                return;
            }
            String str = PollCreateActivity.this.answers[i];
            PollCreateActivity.this.answers[i] = PollCreateActivity.this.answers[i2];
            PollCreateActivity.this.answers[i2] = str;
            boolean z = PollCreateActivity.this.answersChecks[i];
            PollCreateActivity.this.answersChecks[i] = PollCreateActivity.this.answersChecks[i2];
            PollCreateActivity.this.answersChecks[i2] = z;
            notifyItemMoved(fromIndex, toIndex);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, PollEditTextCell.class, TextCheckCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
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
