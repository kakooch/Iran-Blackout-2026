package org.rbmain.ui;

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
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_poll;
import org.rbmain.tgnet.TLRPC$TL_pollAnswer;
import org.rbmain.tgnet.TLRPC$TL_pollResults;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.PollEditTextCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.ChatAttachAlertPollLayout;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.HintView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.PollCreateActivity;

/* loaded from: classes4.dex */
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
        void sendPoll(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap<String, String> map, boolean z, int i);
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
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
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
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
                return false;
            }
            PollCreateActivity.this.listAdapter.swapElements(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (i != 0) {
                PollCreateActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            }
            super.onSelectedChanged(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    public PollCreateActivity(ChatActivity chatActivity, Boolean bool) {
        this.parentFragment = chatActivity;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            this.quizPoll = zBooleanValue;
            this.quizOnly = zBooleanValue ? 1 : 2;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(this, context) { // from class: org.rbmain.ui.PollCreateActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView
            protected void requestChildOnScreen(View view, View view2) {
                if (view instanceof PollEditTextCell) {
                    super.requestChildOnScreen(view, view2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                rect.bottom += AndroidUtilities.dp(60.0f);
                return super.requestChildRectangleOnScreen(view, rect, z);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        new ItemTouchHelper(new TouchHelperCallback()).attachToRecyclerView(this.listView);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.PollCreateActivity$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.PollCreateActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 == 0 || PollCreateActivity.this.hintView == null) {
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

    /* renamed from: org.rbmain.ui.PollCreateActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            if (i == -1) {
                if (PollCreateActivity.this.checkDiscard()) {
                    PollCreateActivity.this.finishFragment();
                    return;
                }
                return;
            }
            if (i == 1) {
                if (PollCreateActivity.this.quizPoll && PollCreateActivity.this.doneItem.getAlpha() != 1.0f) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < PollCreateActivity.this.answersChecks.length; i3++) {
                        if (!TextUtils.isEmpty(ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.answers[i3])) && PollCreateActivity.this.answersChecks[i3]) {
                            i2++;
                        }
                    }
                    if (i2 <= 0) {
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
                for (int i4 = 0; i4 < PollCreateActivity.this.answers.length; i4++) {
                    if (!TextUtils.isEmpty(ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.answers[i4]))) {
                        TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = new TLRPC$TL_pollAnswer();
                        tLRPC$TL_pollAnswer.text = ChatAttachAlertPollLayout.getFixedString(PollCreateActivity.this.answers[i4]).toString();
                        tLRPC$TL_pollAnswer.option = new byte[]{(byte) (tLRPC$TL_messageMediaPoll.poll.answers.size() + 48)};
                        tLRPC$TL_messageMediaPoll.poll.answers.add(tLRPC$TL_pollAnswer);
                        if ((PollCreateActivity.this.multipleChoise || PollCreateActivity.this.quizPoll) && PollCreateActivity.this.answersChecks[i4]) {
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
                    AlertsCreator.createScheduleDatePickerDialog(PollCreateActivity.this.getParentActivity(), PollCreateActivity.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.PollCreateActivity$1$$ExternalSyntheticLambda0
                        @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i5) {
                            this.f$0.lambda$onItemClick$0(tLRPC$TL_messageMediaPoll, map, z, i5);
                        }
                    });
                } else {
                    PollCreateActivity.this.delegate.sendPoll(tLRPC$TL_messageMediaPoll, map, true, 0);
                    PollCreateActivity.this.finishFragment();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i) {
            PollCreateActivity.this.delegate.sendPoll(tLRPC$TL_messageMediaPoll, map, z, i);
            PollCreateActivity.this.finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkDoneButton() {
        /*
            r8 = this;
            boolean r0 = r8.quizPoll
            r1 = 0
            if (r0 == 0) goto L25
            r0 = 0
            r2 = 0
        L7:
            boolean[] r3 = r8.answersChecks
            int r3 = r3.length
            if (r0 >= r3) goto L26
            java.lang.String[] r3 = r8.answers
            r3 = r3[r0]
            java.lang.CharSequence r3 = org.rbmain.ui.Components.ChatAttachAlertPollLayout.getFixedString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L22
            boolean[] r3 = r8.answersChecks
            boolean r3 = r3[r0]
            if (r3 == 0) goto L22
            int r2 = r2 + 1
        L22:
            int r0 = r0 + 1
            goto L7
        L25:
            r2 = 0
        L26:
            java.lang.CharSequence r0 = r8.solutionString
            java.lang.CharSequence r0 = org.rbmain.ui.Components.ChatAttachAlertPollLayout.getFixedString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 100
            r4 = 1
            if (r0 != 0) goto L3e
            java.lang.CharSequence r0 = r8.solutionString
            int r0 = r0.length()
            if (r0 <= r3) goto L3e
            goto L85
        L3e:
            java.lang.String r0 = r8.questionString
            java.lang.CharSequence r0 = org.rbmain.ui.Components.ChatAttachAlertPollLayout.getFixedString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L85
            java.lang.String r0 = r8.questionString
            int r0 = r0.length()
            r5 = 255(0xff, float:3.57E-43)
            if (r0 <= r5) goto L55
            goto L85
        L55:
            r0 = 0
            r5 = 0
        L57:
            java.lang.String[] r6 = r8.answers
            int r7 = r6.length
            if (r0 >= r7) goto L79
            r6 = r6[r0]
            java.lang.CharSequence r6 = org.rbmain.ui.Components.ChatAttachAlertPollLayout.getFixedString(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L76
            java.lang.String[] r6 = r8.answers
            r6 = r6[r0]
            int r6 = r6.length()
            if (r6 <= r3) goto L74
            r5 = 0
            goto L79
        L74:
            int r5 = r5 + 1
        L76:
            int r0 = r0 + 1
            goto L57
        L79:
            r0 = 2
            if (r5 < r0) goto L85
            boolean r0 = r8.quizPoll
            if (r0 == 0) goto L83
            if (r2 >= r4) goto L83
            goto L85
        L83:
            r0 = 1
            goto L86
        L85:
            r0 = 0
        L86:
            org.rbmain.ui.ActionBar.ActionBarMenuItem r3 = r8.doneItem
            boolean r5 = r8.quizPoll
            if (r5 == 0) goto L8e
            if (r2 == 0) goto L90
        L8e:
            if (r0 == 0) goto L91
        L90:
            r1 = 1
        L91:
            r3.setEnabled(r1)
            org.rbmain.ui.ActionBar.ActionBarMenuItem r1 = r8.doneItem
            if (r0 == 0) goto L9b
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L9d
        L9b:
            r0 = 1056964608(0x3f000000, float:0.5)
        L9d:
            r1.setAlpha(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PollCreateActivity.checkDoneButton():void");
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
            builder.setPositiveButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PollCreateActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$checkDiscard$1(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        }
        return zIsEmpty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$1(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    public void setDelegate(PollCreateActivityDelegate pollCreateActivityDelegate) {
        this.delegate = pollCreateActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTextLeft(android.view.View r5, int r6) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof org.rbmain.ui.Cells.PollEditTextCell
            if (r0 != 0) goto L5
            return
        L5:
            org.rbmain.ui.Cells.PollEditTextCell r5 = (org.rbmain.ui.Cells.PollEditTextCell) r5
            int r0 = r4.questionRow
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 100
            if (r6 != r0) goto L1d
            java.lang.String r6 = r4.questionString
            if (r6 == 0) goto L19
            int r6 = r6.length()
            goto L1a
        L19:
            r6 = 0
        L1a:
            int r6 = 255 - r6
            goto L47
        L1d:
            int r0 = r4.solutionRow
            if (r6 != r0) goto L30
            java.lang.CharSequence r6 = r4.solutionString
            if (r6 == 0) goto L2a
            int r6 = r6.length()
            goto L2b
        L2a:
            r6 = 0
        L2b:
            int r6 = 100 - r6
            r1 = 100
            goto L47
        L30:
            int r0 = r4.answerStartRow
            if (r6 < r0) goto L84
            int r1 = r4.answersCount
            int r1 = r1 + r0
            if (r6 >= r1) goto L84
            int r6 = r6 - r0
            java.lang.String[] r0 = r4.answers
            r1 = r0[r6]
            if (r1 == 0) goto L2a
            r6 = r0[r6]
            int r6 = r6.length()
            goto L2b
        L47:
            float r0 = (float) r6
            float r1 = (float) r1
            r3 = 1060320051(0x3f333333, float:0.7)
            float r3 = r3 * r1
            float r1 = r1 - r3
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L7f
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0[r2] = r1
            java.lang.String r1 = "%d"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.setText2(r0)
            org.rbmain.ui.ActionBar.SimpleTextView r5 = r5.getTextView2()
            if (r6 >= 0) goto L6e
            int r6 = org.rbmain.ui.ActionBar.Theme.key_text_RedRegular
            goto L70
        L6e:
            int r6 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundWhiteGrayText3
        L70:
            int r0 = org.rbmain.ui.ActionBar.Theme.getColor(r6)
            r5.setTextColor(r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.setTag(r6)
            goto L84
        L7f:
            java.lang.String r6 = ""
            r5.setText2(r6)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PollCreateActivity.setTextLeft(android.view.View, int):void");
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != PollCreateActivity.this.questionHeaderRow) {
                    if (i == PollCreateActivity.this.answerHeaderRow) {
                        if (PollCreateActivity.this.quizOnly == 1) {
                            headerCell.setText(LocaleController.getString("QuizAnswers", R.string.QuizAnswers));
                            return;
                        } else {
                            headerCell.setText(LocaleController.getString("AnswerOptions", R.string.AnswerOptions));
                            return;
                        }
                    }
                    if (i == PollCreateActivity.this.settingsHeaderRow) {
                        headerCell.setText(LocaleController.getString("Settings", R.string.Settings));
                        return;
                    }
                    return;
                }
                headerCell.setText(LocaleController.getString("PollQuestion", R.string.PollQuestion));
                return;
            }
            if (itemViewType == 6) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (i == PollCreateActivity.this.anonymousRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("PollAnonymous", R.string.PollAnonymous), PollCreateActivity.this.anonymousPoll, (PollCreateActivity.this.multipleRow == -1 && PollCreateActivity.this.quizRow == -1) ? false : true);
                    textCheckCell.setEnabled(true, null);
                    return;
                } else if (i == PollCreateActivity.this.multipleRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("PollMultiple", R.string.PollMultiple), PollCreateActivity.this.multipleChoise, PollCreateActivity.this.quizRow != -1);
                    textCheckCell.setEnabled(true, null);
                    return;
                } else {
                    if (i == PollCreateActivity.this.quizRow) {
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
                TextCell textCell = (TextCell) viewHolder.itemView;
                textCell.setColors(-1, Theme.key_windowBackgroundWhiteBlueText4);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.poll_add_circle);
                Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.poll_add_plus);
                drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_switchTrackChecked), PorterDuff.Mode.MULTIPLY));
                drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_checkboxCheck), PorterDuff.Mode.MULTIPLY));
                textCell.setTextAndIcon(LocaleController.getString("AddAnOption", R.string.AddAnOption), (Drawable) new CombinedDrawable(drawable, drawable2), false);
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
            textInfoPrivacyCell.setFixedSize(0);
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
            if (i != PollCreateActivity.this.solutionInfoRow) {
                if (i == PollCreateActivity.this.settingsSectionRow) {
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
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            CharSequence charSequence = BuildConfig.FLAVOR;
            if (itemViewType == 4) {
                PollEditTextCell pollEditTextCell = (PollEditTextCell) viewHolder.itemView;
                pollEditTextCell.setTag(1);
                if (PollCreateActivity.this.questionString != null) {
                    charSequence = PollCreateActivity.this.questionString;
                }
                pollEditTextCell.setTextAndHint(charSequence, LocaleController.getString("QuestionHint", R.string.QuestionHint), false);
                pollEditTextCell.setTag(null);
                PollCreateActivity.this.setTextLeft(viewHolder.itemView, viewHolder.getAdapterPosition());
                return;
            }
            if (itemViewType != 5) {
                if (itemViewType == 7) {
                    PollEditTextCell pollEditTextCell2 = (PollEditTextCell) viewHolder.itemView;
                    pollEditTextCell2.setTag(1);
                    if (PollCreateActivity.this.solutionString != null) {
                        charSequence = PollCreateActivity.this.solutionString;
                    }
                    pollEditTextCell2.setTextAndHint(charSequence, LocaleController.getString("AddAnExplanation", R.string.AddAnExplanation), false);
                    pollEditTextCell2.setTag(null);
                    PollCreateActivity.this.setTextLeft(viewHolder.itemView, viewHolder.getAdapterPosition());
                    return;
                }
                return;
            }
            int adapterPosition = viewHolder.getAdapterPosition();
            PollEditTextCell pollEditTextCell3 = (PollEditTextCell) viewHolder.itemView;
            pollEditTextCell3.setTag(1);
            pollEditTextCell3.setTextAndHint(PollCreateActivity.this.answers[adapterPosition - PollCreateActivity.this.answerStartRow], LocaleController.getString("OptionHint", R.string.OptionHint), true);
            pollEditTextCell3.setTag(null);
            if (PollCreateActivity.this.requestFieldFocusAtPosition == adapterPosition) {
                EditTextBoldCursor textView = pollEditTextCell3.getTextView();
                textView.requestFocus();
                AndroidUtilities.showKeyboard(textView);
                PollCreateActivity.this.requestFieldFocusAtPosition = -1;
            }
            PollCreateActivity.this.setTextLeft(viewHolder.itemView, adapterPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 4) {
                EditTextBoldCursor textView = ((PollEditTextCell) viewHolder.itemView).getTextView();
                if (textView.isFocused()) {
                    textView.clearFocus();
                    AndroidUtilities.hideKeyboard(textView);
                }
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
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
                        pollEditTextCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: org.rbmain.ui.PollCreateActivity.ListAdapter.1
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                if (pollEditTextCell.getTag() != null) {
                                    return;
                                }
                                PollCreateActivity.this.questionString = editable.toString();
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
                        textCheckCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        shadowSectionCell = textCheckCell;
                    } else if (i == 7) {
                        final PollEditTextCell pollEditTextCell2 = new PollEditTextCell(this.mContext, z, onClickListener) { // from class: org.rbmain.ui.PollCreateActivity.ListAdapter.2
                            @Override // org.rbmain.ui.Cells.PollEditTextCell
                            protected void onActionModeStart(EditTextBoldCursor editTextBoldCursor, ActionMode actionMode) {
                                if (editTextBoldCursor.isFocused() && editTextBoldCursor.hasSelection()) {
                                    Menu menu = actionMode.getMenu();
                                    if (menu.findItem(android.R.id.copy) == null) {
                                        return;
                                    }
                                    PollCreateActivity.this.parentFragment.fillActionModeMenu(menu);
                                }
                            }
                        };
                        pollEditTextCell2.createErrorTextView();
                        pollEditTextCell2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        pollEditTextCell2.addTextWatcher(new TextWatcher() { // from class: org.rbmain.ui.PollCreateActivity.ListAdapter.3
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                if (pollEditTextCell2.getTag() != null) {
                                    return;
                                }
                                PollCreateActivity.this.solutionString = editable;
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
                        final PollEditTextCell pollEditTextCell3 = new PollEditTextCell(this.mContext, new View.OnClickListener() { // from class: org.rbmain.ui.PollCreateActivity$ListAdapter$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.f$0.lambda$onCreateViewHolder$0(view);
                            }
                        }) { // from class: org.rbmain.ui.PollCreateActivity.ListAdapter.4
                            @Override // org.rbmain.ui.Cells.PollEditTextCell
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

                            @Override // org.rbmain.ui.Cells.PollEditTextCell
                            protected boolean shouldShowCheckBox() {
                                return PollCreateActivity.this.quizPoll;
                            }

                            @Override // org.rbmain.ui.Cells.PollEditTextCell
                            protected void onCheckBoxClick(PollEditTextCell pollEditTextCell4, boolean z2) {
                                int adapterPosition;
                                if (z2 && PollCreateActivity.this.quizPoll) {
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
                                super.onCheckBoxClick(pollEditTextCell4, z2);
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(pollEditTextCell4);
                                if (viewHolderFindContainingViewHolder != null && (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) != -1) {
                                    PollCreateActivity.this.answersChecks[adapterPosition - PollCreateActivity.this.answerStartRow] = z2;
                                }
                                PollCreateActivity.this.checkDoneButton();
                            }

                            @Override // org.rbmain.ui.Cells.PollEditTextCell
                            protected boolean isChecked(PollEditTextCell pollEditTextCell4) {
                                int adapterPosition;
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(pollEditTextCell4);
                                if (viewHolderFindContainingViewHolder == null || (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition()) == -1) {
                                    return false;
                                }
                                return PollCreateActivity.this.answersChecks[adapterPosition - PollCreateActivity.this.answerStartRow];
                            }
                        };
                        pollEditTextCell3.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        pollEditTextCell3.addTextWatcher(new TextWatcher() { // from class: org.rbmain.ui.PollCreateActivity.ListAdapter.5
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                int adapterPosition;
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = PollCreateActivity.this.listView.findContainingViewHolder(pollEditTextCell3);
                                if (viewHolderFindContainingViewHolder == null || (adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition() - PollCreateActivity.this.answerStartRow) < 0 || adapterPosition >= PollCreateActivity.this.answers.length) {
                                    return;
                                }
                                PollCreateActivity.this.answers[adapterPosition] = editable.toString();
                                PollCreateActivity.this.setTextLeft(pollEditTextCell3, adapterPosition);
                                PollCreateActivity.this.checkDoneButton();
                            }
                        });
                        pollEditTextCell3.setShowNextButton(true);
                        EditTextBoldCursor textView = pollEditTextCell3.getTextView();
                        textView.setImeOptions(textView.getImeOptions() | 5);
                        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.PollCreateActivity$ListAdapter$$ExternalSyntheticLambda2
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                                return this.f$0.lambda$onCreateViewHolder$1(pollEditTextCell3, textView2, i2, keyEvent);
                            }
                        });
                        textView.setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.PollCreateActivity$ListAdapter$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                                return PollCreateActivity.ListAdapter.lambda$onCreateViewHolder$2(pollEditTextCell3, view, i2, keyEvent);
                            }
                        });
                        shadowSectionCell = pollEditTextCell3;
                    }
                } else {
                    View textCell = new TextCell(this.mContext);
                    textCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = textCell;
                }
            } else {
                View headerCell = new HeaderCell(this.mContext, Theme.key_windowBackgroundWhiteBlueHeader, 21, 15, false);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                shadowSectionCell = headerCell;
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onCreateViewHolder$0(android.view.View r8) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PollCreateActivity.ListAdapter.lambda$onCreateViewHolder$0(android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$1(PollEditTextCell pollEditTextCell, TextView textView, int i, KeyEvent keyEvent) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$onCreateViewHolder$2(PollEditTextCell pollEditTextCell, View view, int i, KeyEvent keyEvent) {
            EditTextBoldCursor editTextBoldCursor = (EditTextBoldCursor) view;
            if (i != 67 || keyEvent.getAction() != 0 || editTextBoldCursor.length() != 0) {
                return false;
            }
            pollEditTextCell.callOnDelete();
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == PollCreateActivity.this.questionHeaderRow || i == PollCreateActivity.this.answerHeaderRow || i == PollCreateActivity.this.settingsHeaderRow) {
                return 0;
            }
            if (i == PollCreateActivity.this.questionSectionRow) {
                return 1;
            }
            if (i == PollCreateActivity.this.answerSectionRow || i == PollCreateActivity.this.settingsSectionRow || i == PollCreateActivity.this.solutionInfoRow) {
                return 2;
            }
            if (i == PollCreateActivity.this.addAnswerRow) {
                return 3;
            }
            if (i == PollCreateActivity.this.questionRow) {
                return 4;
            }
            if (i == PollCreateActivity.this.solutionRow) {
                return 7;
            }
            return (i == PollCreateActivity.this.anonymousRow || i == PollCreateActivity.this.multipleRow || i == PollCreateActivity.this.quizRow) ? 6 : 5;
        }

        public void swapElements(int i, int i2) {
            int i3 = i - PollCreateActivity.this.answerStartRow;
            int i4 = i2 - PollCreateActivity.this.answerStartRow;
            if (i3 < 0 || i4 < 0 || i3 >= PollCreateActivity.this.answersCount || i4 >= PollCreateActivity.this.answersCount) {
                return;
            }
            String str = PollCreateActivity.this.answers[i3];
            PollCreateActivity.this.answers[i3] = PollCreateActivity.this.answers[i4];
            PollCreateActivity.this.answers[i4] = str;
            boolean z = PollCreateActivity.this.answersChecks[i3];
            PollCreateActivity.this.answersChecks[i3] = PollCreateActivity.this.answersChecks[i4];
            PollCreateActivity.this.answersChecks[i4] = z;
            notifyItemMoved(i, i2);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, PollEditTextCell.class, TextCheckCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i3 = Theme.key_text_RedRegular;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteHintText));
        int i5 = Theme.key_windowBackgroundWhiteGrayIcon;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"deleteImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"moveImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{PollEditTextCell.class}, new String[]{"deleteImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_stickers_menuSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{PollEditTextCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{PollEditTextCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i6 = Theme.key_checkboxCheck;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{PollEditTextCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        int i7 = Theme.key_switchTrackChecked;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        return arrayList;
    }
}
