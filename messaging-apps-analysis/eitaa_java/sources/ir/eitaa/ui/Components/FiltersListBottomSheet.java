package ir.eitaa.ui.Components;

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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.DialogsActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
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
        void didSelectFilter(MessagesController.DialogFilter filter);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public FiltersListBottomSheet(DialogsActivity baseFragment, ArrayList<Long> selectedDialogs) {
        super(baseFragment.getParentActivity(), false);
        this.dialogFilters = getCanAddDialogFilters(baseFragment, selectedDialogs);
        Activity parentActivity = baseFragment.getParentActivity();
        FrameLayout frameLayout = new FrameLayout(parentActivity) { // from class: ir.eitaa.ui.Components.FiltersListBottomSheet.1
            private boolean fullHeight;
            private RectF rect = new RectF();

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && FiltersListBottomSheet.this.scrollOffsetY != 0 && ev.getY() < FiltersListBottomSheet.this.scrollOffsetY) {
                    FiltersListBottomSheet.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !FiltersListBottomSheet.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                if (Build.VERSION.SDK_INT >= 21) {
                    FiltersListBottomSheet.this.ignoreLayout = true;
                    setPadding(((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingLeft, 0);
                    FiltersListBottomSheet.this.ignoreLayout = false;
                }
                int iDp = AndroidUtilities.dp(48.0f) + (AndroidUtilities.dp(48.0f) * FiltersListBottomSheet.this.adapter.getItemCount()) + ((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingTop + AndroidUtilities.statusBarHeight;
                double d = iDp;
                int i = size / 5;
                double d2 = i;
                Double.isNaN(d2);
                int i2 = d < d2 * 3.2d ? 0 : i * 2;
                if (i2 != 0 && iDp < size) {
                    i2 -= size - iDp;
                }
                if (i2 == 0) {
                    i2 = ((BottomSheet) FiltersListBottomSheet.this).backgroundPaddingTop;
                }
                if (FiltersListBottomSheet.this.listView.getPaddingTop() != i2) {
                    FiltersListBottomSheet.this.ignoreLayout = true;
                    FiltersListBottomSheet.this.listView.setPadding(AndroidUtilities.dp(10.0f), i2, AndroidUtilities.dp(10.0f), 0);
                    FiltersListBottomSheet.this.ignoreLayout = false;
                }
                this.fullHeight = iDp >= size;
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
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
              0x007d: PHI (r0v4 int) = (r0v3 int), (r0v24 int) binds: [B:3:0x002d, B:5:0x0035] A[DONT_GENERATE, DONT_INLINE]
              0x007d: PHI (r1v7 int) = (r1v6 int), (r1v17 int) binds: [B:3:0x002d, B:5:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r13) {
                /*
                    Method dump skipped, instructions count: 312
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FiltersListBottomSheet.AnonymousClass1.onDraw(android.graphics.Canvas):void");
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
        view.setBackgroundColor(Theme.getColor("dialogShadowLine"));
        this.shadow.setAlpha(0.0f);
        this.shadow.setVisibility(4);
        this.shadow.setTag(1);
        this.containerView.addView(this.shadow, layoutParams);
        RecyclerListView recyclerListView = new RecyclerListView(parentActivity) { // from class: ir.eitaa.ui.Components.FiltersListBottomSheet.2
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
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
        this.listView.setGlowColor(Theme.getColor("dialogScrollGlow"));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.FiltersListBottomSheet.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                FiltersListBottomSheet.this.updateLayout();
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FiltersListBottomSheet$vle0Ybw_3svOpg3BHN0ns8B_pVY
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i2) {
                this.f$0.lambda$new$0$FiltersListBottomSheet(view2, i2);
            }
        });
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
        TextView textView = new TextView(parentActivity);
        this.titleTextView = textView;
        textView.setLines(1);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setTextColor(Theme.getColor("dialogTextBlack"));
        this.titleTextView.setTextSize(1, 20.0f);
        this.titleTextView.setLinkTextColor(Theme.getColor("dialogTextLink"));
        this.titleTextView.setHighlightColor(Theme.getColor("dialogLinkSelection"));
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.titleTextView.setGravity(16);
        this.titleTextView.setText(LocaleController.getString("FilterChoose", R.string.FilterChoose));
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.containerView.addView(this.titleTextView, LayoutHelper.createFrame(-1, 50.0f, 51, 0.0f, 0.0f, 40.0f, 0.0f));
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$FiltersListBottomSheet(View view, int i) {
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

    private void runShadowAnimation(final boolean show) {
        if ((!show || this.shadow.getTag() == null) && (show || this.shadow.getTag() != null)) {
            return;
        }
        this.shadow.setTag(show ? null : 1);
        if (show) {
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
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet2.playTogether(animatorArr);
        this.shadowAnimation.setDuration(150L);
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FiltersListBottomSheet.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (FiltersListBottomSheet.this.shadowAnimation == null || !FiltersListBottomSheet.this.shadowAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    FiltersListBottomSheet.this.shadow.setVisibility(4);
                }
                FiltersListBottomSheet.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (FiltersListBottomSheet.this.shadowAnimation == null || !FiltersListBottomSheet.this.shadowAnimation.equals(animation)) {
                    return;
                }
                FiltersListBottomSheet.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        RecyclerListView recyclerListView;
        if (id != NotificationCenter.emojiLoaded || (recyclerListView = this.listView) == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.listView.getChildAt(i).invalidate();
        }
    }

    public void setDelegate(FiltersListBottomSheetDelegate filtersListBottomSheetDelegate) {
        this.delegate = filtersListBottomSheetDelegate;
    }

    public static ArrayList<MessagesController.DialogFilter> getCanAddDialogFilters(BaseFragment fragment, ArrayList<Long> selectedDialogs) {
        ArrayList<MessagesController.DialogFilter> arrayList = new ArrayList<>();
        ArrayList<MessagesController.DialogFilter> arrayList2 = fragment.getMessagesController().dialogFilters;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            MessagesController.DialogFilter dialogFilter = arrayList2.get(i);
            if (!getDialogsCount(fragment, dialogFilter, selectedDialogs, true, true).isEmpty()) {
                arrayList.add(dialogFilter);
            }
        }
        return arrayList;
    }

    public static ArrayList<Long> getDialogsCount(BaseFragment fragment, MessagesController.DialogFilter filter, ArrayList<Long> selectedDialogs, boolean always, boolean check) {
        ArrayList<Long> arrayList = new ArrayList<>();
        int size = selectedDialogs.size();
        for (int i = 0; i < size; i++) {
            long jLongValue = selectedDialogs.get(i).longValue();
            if (DialogObject.isEncryptedDialog(jLongValue)) {
                TLRPC$EncryptedChat encryptedChat = fragment.getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(jLongValue)));
                if (encryptedChat != null) {
                    jLongValue = encryptedChat.user_id;
                    if (arrayList.contains(Long.valueOf(jLongValue))) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (filter == null || ((!always || !filter.alwaysShow.contains(Long.valueOf(jLongValue))) && (always || !filter.neverShow.contains(Long.valueOf(jLongValue))))) {
                arrayList.add(Long.valueOf(jLongValue));
                if (check) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        public MessagesController.DialogFilter getItem(int position) {
            if (position < FiltersListBottomSheet.this.dialogFilters.size()) {
                return (MessagesController.DialogFilter) FiltersListBottomSheet.this.dialogFilters.get(position);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = FiltersListBottomSheet.this.dialogFilters.size();
            return size < 10 ? size + 1 : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
                ir.eitaa.ui.ActionBar.BottomSheet$BottomSheetCell r5 = (ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetCell) r5
                ir.eitaa.ui.Components.FiltersListBottomSheet r0 = ir.eitaa.ui.Components.FiltersListBottomSheet.this
                java.util.ArrayList r0 = ir.eitaa.ui.Components.FiltersListBottomSheet.access$2500(r0)
                int r0 = r0.size()
                if (r6 >= r0) goto L8d
                android.widget.ImageView r0 = r5.getImageView()
                android.graphics.PorterDuffColorFilter r1 = new android.graphics.PorterDuffColorFilter
                java.lang.String r2 = "dialogIcon"
                int r2 = ir.eitaa.ui.ActionBar.Theme.getColor(r2)
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r1.<init>(r2, r3)
                r0.setColorFilter(r1)
                ir.eitaa.ui.Components.FiltersListBottomSheet r0 = ir.eitaa.ui.Components.FiltersListBottomSheet.this
                java.util.ArrayList r0 = ir.eitaa.ui.Components.FiltersListBottomSheet.access$2500(r0)
                java.lang.Object r6 = r0.get(r6)
                ir.eitaa.messenger.MessagesController$DialogFilter r6 = (ir.eitaa.messenger.MessagesController.DialogFilter) r6
                java.lang.String r0 = "dialogTextBlack"
                int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r0)
                r5.setTextColor(r0)
                int r0 = r6.flags
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_CONTACTS
                int r3 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS
                r2 = r2 | r3
                if (r1 != r2) goto L49
                r0 = 2131231337(0x7f080269, float:1.8078752E38)
                goto L87
            L49:
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ
                r1 = r1 & r0
                if (r1 == 0) goto L58
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r2 = r0 & r1
                if (r2 != r1) goto L58
                r0 = 2131231351(0x7f080277, float:1.807878E38)
                goto L87
            L58:
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_CHANNELS
                if (r1 != r2) goto L63
                r0 = 2131231304(0x7f080248, float:1.8078685E38)
                goto L87
            L63:
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_GROUPS
                if (r1 != r2) goto L6e
                r0 = 2131231319(0x7f080257, float:1.8078716E38)
                goto L87
            L6e:
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r1 = r1 & r0
                int r2 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_CONTACTS
                if (r1 != r2) goto L79
                r0 = 2131231312(0x7f080250, float:1.8078701E38)
                goto L87
            L79:
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS
                r0 = r0 & r1
                int r1 = ir.eitaa.messenger.MessagesController.DIALOG_FILTER_FLAG_BOTS
                if (r0 != r1) goto L84
                r0 = 2131231303(0x7f080247, float:1.8078683E38)
                goto L87
            L84:
                r0 = 2131231318(0x7f080256, float:1.8078714E38)
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
                r0 = 2131231636(0x7f080394, float:1.8079359E38)
                android.graphics.drawable.Drawable r6 = r6.getDrawable(r0)
                android.content.Context r0 = r4.context
                android.content.res.Resources r0 = r0.getResources()
                r1 = 2131231637(0x7f080395, float:1.807936E38)
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                android.graphics.PorterDuffColorFilter r1 = new android.graphics.PorterDuffColorFilter
                java.lang.String r2 = "switchTrackChecked"
                int r2 = ir.eitaa.ui.ActionBar.Theme.getColor(r2)
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r1.<init>(r2, r3)
                r6.setColorFilter(r1)
                android.graphics.PorterDuffColorFilter r1 = new android.graphics.PorterDuffColorFilter
                java.lang.String r2 = "checkboxCheck"
                int r2 = ir.eitaa.ui.ActionBar.Theme.getColor(r2)
                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                r1.<init>(r2, r3)
                r0.setColorFilter(r1)
                ir.eitaa.ui.Components.CombinedDrawable r1 = new ir.eitaa.ui.Components.CombinedDrawable
                r1.<init>(r6, r0)
                java.lang.String r6 = "windowBackgroundWhiteBlueText4"
                int r6 = ir.eitaa.ui.ActionBar.Theme.getColor(r6)
                r5.setTextColor(r6)
                r6 = 2131690882(0x7f0f0582, float:1.901082E38)
                java.lang.String r0 = "CreateNewFilter"
                java.lang.String r6 = ir.eitaa.messenger.LocaleController.getString(r0, r6)
                r5.setTextAndIcon(r6, r1)
            Le9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FiltersListBottomSheet.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }
    }
}
