package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.DialogsActivity;

/* loaded from: classes5.dex */
public class FiltersListBottomSheet extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private ListAdapter adapter;
    private FiltersListBottomSheetDelegate delegate;
    private ArrayList<MessagesController.DialogFilter> dialogFilters;
    private boolean ignoreLayout;
    private RecyclerListView listView;
    private int scrollOffsetY;
    private View shadow;
    private AnimatorSet shadowAnimation;
    private TextView titleTextView;

    public interface FiltersListBottomSheetDelegate {
        void didSelectFilter(MessagesController.DialogFilter dialogFilter);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public FiltersListBottomSheet(DialogsActivity dialogsActivity, ArrayList<Long> arrayList) {
        super(dialogsActivity.getParentActivity(), false);
        this.dialogFilters = getCanAddDialogFilters(dialogsActivity, arrayList);
        Activity parentActivity = dialogsActivity.getParentActivity();
        FrameLayout frameLayout = new FrameLayout(parentActivity) { // from class: org.rbmain.ui.Components.FiltersListBottomSheet.1
            private boolean fullHeight;
            private RectF rect = new RectF();

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && FiltersListBottomSheet.this.scrollOffsetY != 0 && motionEvent.getY() < FiltersListBottomSheet.this.scrollOffsetY) {
                    FiltersListBottomSheet.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !FiltersListBottomSheet.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int size = View.MeasureSpec.getSize(i2);
                if (Build.VERSION.SDK_INT >= 21) {
                    FiltersListBottomSheet.this.ignoreLayout = true;
                    setPadding(((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingLeft, 0);
                    FiltersListBottomSheet.this.ignoreLayout = false;
                }
                int iDp = AndroidUtilities.dp(48.0f) + (AndroidUtilities.dp(48.0f) * FiltersListBottomSheet.this.adapter.getItemCount()) + ((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingTop + AndroidUtilities.statusBarHeight;
                double d = iDp;
                int i3 = size / 5;
                double d2 = i3;
                Double.isNaN(d2);
                int i4 = d < d2 * 3.2d ? 0 : i3 * 2;
                if (i4 != 0 && iDp < size) {
                    i4 -= size - iDp;
                }
                if (i4 == 0) {
                    i4 = ((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingTop;
                }
                if (FiltersListBottomSheet.this.listView.getPaddingTop() != i4) {
                    FiltersListBottomSheet.this.ignoreLayout = true;
                    FiltersListBottomSheet.this.listView.setPadding(AndroidUtilities.dp(10.0f), i4, AndroidUtilities.dp(10.0f), 0);
                    FiltersListBottomSheet.this.ignoreLayout = false;
                }
                this.fullHeight = iDp >= size;
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                FiltersListBottomSheet.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (FiltersListBottomSheet.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x007d A[PHI: r0 r1
              0x007d: PHI (r0v4 int) = (r0v3 int), (r0v25 int) binds: [B:3:0x002d, B:5:0x0035] A[DONT_GENERATE, DONT_INLINE]
              0x007d: PHI (r1v7 int) = (r1v6 int), (r1v23 int) binds: [B:3:0x002d, B:5:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r13) {
                /*
                    Method dump skipped, instructions count: 314
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.FiltersListBottomSheet.AnonymousClass1.onDraw(android.graphics.Canvas):void");
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(48.0f);
        View view = new View(parentActivity);
        this.shadow = view;
        view.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.shadow.setAlpha(0.0f);
        this.shadow.setVisibility(4);
        this.shadow.setTag(1);
        this.containerView.addView(this.shadow, layoutParams);
        RecyclerListView recyclerListView = new RecyclerListView(parentActivity) { // from class: org.rbmain.ui.Components.FiltersListBottomSheet.2
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (FiltersListBottomSheet.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setTag(14);
        this.listView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(parentActivity);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        this.listView.setClipToPadding(false);
        this.listView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.FiltersListBottomSheet.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                FiltersListBottomSheet.this.updateLayout();
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.FiltersListBottomSheet$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i2) {
                this.f$0.lambda$new$0(view2, i2);
            }
        });
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
        TextView textView = new TextView(parentActivity);
        this.titleTextView = textView;
        textView.setLines(1);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.titleTextView.setTextSize(1, 20.0f);
        this.titleTextView.setLinkTextColor(Theme.getColor(Theme.key_dialogTextLink));
        this.titleTextView.setHighlightColor(Theme.getColor(Theme.key_dialogLinkSelection));
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.titleTextView.setGravity(16);
        this.titleTextView.setText(LocaleController.getString("FilterChoose", R.string.FilterChoose));
        this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.containerView.addView(this.titleTextView, LayoutHelper.createFrame(-1, 50.0f, 51, 0.0f, 0.0f, 40.0f, 0.0f));
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i) {
        this.delegate.didSelectFilter(this.adapter.getItem(i));
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.titleTextView.setTranslationY(this.scrollOffsetY);
            this.shadow.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
            return;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(false);
            i = top;
        } else {
            runShadowAnimation(true);
        }
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = i;
            recyclerListView2.setTopGlowOffset(i);
            this.titleTextView.setTranslationY(this.scrollOffsetY);
            this.shadow.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
        }
    }

    private void runShadowAnimation(final boolean z) {
        if ((!z || this.shadow.getTag() == null) && (z || this.shadow.getTag() != null)) {
            return;
        }
        this.shadow.setTag(z ? null : 1);
        if (z) {
            this.shadow.setVisibility(0);
        }
        AnimatorSet animatorSet = this.shadowAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.shadowAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet2.playTogether(animatorArr);
        this.shadowAnimation.setDuration(150L);
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.FiltersListBottomSheet.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (FiltersListBottomSheet.this.shadowAnimation == null || !FiltersListBottomSheet.this.shadowAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    FiltersListBottomSheet.this.shadow.setVisibility(4);
                }
                FiltersListBottomSheet.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (FiltersListBottomSheet.this.shadowAnimation == null || !FiltersListBottomSheet.this.shadowAnimation.equals(animator)) {
                    return;
                }
                FiltersListBottomSheet.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        RecyclerListView recyclerListView;
        if (i != NotificationCenter.emojiDidLoad || (recyclerListView = this.listView) == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.listView.getChildAt(i3).invalidate();
        }
    }

    public void setDelegate(FiltersListBottomSheetDelegate filtersListBottomSheetDelegate) {
        this.delegate = filtersListBottomSheetDelegate;
    }

    public static ArrayList<MessagesController.DialogFilter> getCanAddDialogFilters(BaseFragment baseFragment, ArrayList<Long> arrayList) {
        ArrayList<MessagesController.DialogFilter> arrayList2 = new ArrayList<>();
        ArrayList<MessagesController.DialogFilter> arrayList3 = baseFragment.getMessagesController().dialogFilters;
        int size = arrayList3.size();
        for (int i = 0; i < size; i++) {
            MessagesController.DialogFilter dialogFilter = arrayList3.get(i);
            if (!getDialogsCount(baseFragment, dialogFilter, arrayList, true, true).isEmpty()) {
                arrayList2.add(dialogFilter);
            }
        }
        return arrayList2;
    }

    public static ArrayList<Integer> getDialogsCount(BaseFragment baseFragment, MessagesController.DialogFilter dialogFilter, ArrayList<Long> arrayList, boolean z, boolean z2) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            long jLongValue = arrayList.get(i).longValue();
            int i2 = (int) jLongValue;
            if (i2 == 0) {
                TLRPC$EncryptedChat encryptedChat = baseFragment.getMessagesController().getEncryptedChat(Integer.valueOf((int) (jLongValue >> 32)));
                if (encryptedChat != null) {
                    i2 = encryptedChat.user_id;
                    if (arrayList2.contains(Integer.valueOf(i2))) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (dialogFilter == null || ((!z || !dialogFilter.alwaysShow.contains(Integer.valueOf(i2))) && (z || !dialogFilter.neverShow.contains(Integer.valueOf(i2))))) {
                arrayList2.add(Integer.valueOf(i2));
                if (z2) {
                    break;
                }
            }
        }
        return arrayList2;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        public MessagesController.DialogFilter getItem(int i) {
            if (i < FiltersListBottomSheet.this.dialogFilters.size()) {
                return (MessagesController.DialogFilter) FiltersListBottomSheet.this.dialogFilters.get(i);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = FiltersListBottomSheet.this.dialogFilters.size();
            return size < 10 ? size + 1 : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            BottomSheet.BottomSheetCell bottomSheetCell = new BottomSheet.BottomSheetCell(this.context, 0);
            bottomSheetCell.setBackground(null);
            bottomSheetCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(bottomSheetCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r5, int r6) throws android.content.res.Resources.NotFoundException {
            /*
                r4 = this;
                android.view.View r5 = r5.itemView
                org.rbmain.ui.ActionBar.BottomSheet$BottomSheetCell r5 = (org.rbmain.ui.ActionBar.BottomSheet.BottomSheetCell) r5
                org.rbmain.ui.Components.FiltersListBottomSheet r0 = org.rbmain.ui.Components.FiltersListBottomSheet.this
                java.util.ArrayList r0 = org.rbmain.ui.Components.FiltersListBottomSheet.access$2500(r0)
                int r0 = r0.size()
                if (r6 >= r0) goto L8d
                android.widget.ImageView r0 = r5.getImageView()
                android.graphics.PorterDuffColorFilter r1 = new android.graphics.PorterDuffColorFilter
                int r2 = org.rbmain.ui.ActionBar.Theme.key_dialogIcon
                int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r1.<init>(r2, r3)
                r0.setColorFilter(r1)
                org.rbmain.ui.Components.FiltersListBottomSheet r0 = org.rbmain.ui.Components.FiltersListBottomSheet.this
                java.util.ArrayList r0 = org.rbmain.ui.Components.FiltersListBottomSheet.access$2500(r0)
                java.lang.Object r6 = r0.get(r6)
                org.rbmain.messenger.MessagesController$DialogFilter r6 = (org.rbmain.messenger.MessagesController.DialogFilter) r6
                int r0 = org.rbmain.ui.ActionBar.Theme.key_dialogTextBlack
                int r0 = org.rbmain.ui.ActionBar.Theme.getColor(r0)
                r5.setTextColor(r0)
                int r0 = r6.flags
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_CONTACTS
                int r3 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS
                r2 = r2 | r3
                if (r1 != r2) goto L49
                r0 = 2131231895(0x7f080497, float:1.8079884E38)
                goto L87
            L49:
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ
                r1 = r1 & r0
                if (r1 == 0) goto L58
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r2 = r0 & r1
                if (r2 != r1) goto L58
                r0 = 2131231914(0x7f0804aa, float:1.8079922E38)
                goto L87
            L58:
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_CHANNELS
                if (r1 != r2) goto L63
                r0 = 2131231845(0x7f080465, float:1.8079783E38)
                goto L87
            L63:
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_GROUPS
                if (r1 != r2) goto L6e
                r0 = 2131231869(0x7f08047d, float:1.8079831E38)
                goto L87
            L6e:
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_CONTACTS
                if (r1 != r2) goto L79
                r0 = 2131231859(0x7f080473, float:1.807981E38)
                goto L87
            L79:
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r0 = r0 & r1
                int r1 = org.rbmain.messenger.MessagesController.DIALOG_FILTER_FLAG_BOTS
                if (r0 != r1) goto L84
                r0 = 2131231844(0x7f080464, float:1.807978E38)
                goto L87
            L84:
                r0 = 2131231868(0x7f08047c, float:1.807983E38)
            L87:
                java.lang.String r6 = r6.name
                r5.setTextAndIcon(r6, r0)
                goto Le9
            L8d:
                android.widget.ImageView r6 = r5.getImageView()
                r0 = 0
                r6.setColorFilter(r0)
                android.content.Context r6 = r4.context
                android.content.res.Resources r6 = r6.getResources()
                r0 = 2131232308(0x7f080634, float:1.8080722E38)
                android.graphics.drawable.Drawable r6 = r6.getDrawable(r0)
                android.content.Context r0 = r4.context
                android.content.res.Resources r0 = r0.getResources()
                r1 = 2131232309(0x7f080635, float:1.8080724E38)
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                android.graphics.PorterDuffColorFilter r1 = new android.graphics.PorterDuffColorFilter
                int r2 = org.rbmain.ui.ActionBar.Theme.key_switchTrackChecked
                int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r1.<init>(r2, r3)
                r6.setColorFilter(r1)
                android.graphics.PorterDuffColorFilter r1 = new android.graphics.PorterDuffColorFilter
                int r2 = org.rbmain.ui.ActionBar.Theme.key_checkboxCheck
                int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r1.<init>(r2, r3)
                r0.setColorFilter(r1)
                org.rbmain.ui.Components.CombinedDrawable r1 = new org.rbmain.ui.Components.CombinedDrawable
                r1.<init>(r6, r0)
                int r6 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundWhiteBlueText4
                int r6 = org.rbmain.ui.ActionBar.Theme.getColor(r6)
                r5.setTextColor(r6)
                r6 = 2131887716(0x7f120664, float:1.9410047E38)
                java.lang.String r0 = "CreateNewFilter"
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r0, r6)
                r5.setTextAndIcon(r6, r1)
            Le9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.FiltersListBottomSheet.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }
    }
}
