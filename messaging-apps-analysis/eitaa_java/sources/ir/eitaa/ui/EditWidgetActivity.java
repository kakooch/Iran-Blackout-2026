package ir.eitaa.ui;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatsWidgetProvider;
import ir.eitaa.messenger.ContactsWidgetProvider;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.ChatActionCell;
import ir.eitaa.ui.Cells.GroupCreateUserCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.InviteMembersBottomSheet;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EditWidgetActivity extends BaseFragment {
    private int chatsEndRow;
    private int chatsStartRow;
    private int currentWidgetId;
    private EditWidgetActivityDelegate delegate;
    private int infoRow;
    private ItemTouchHelper itemTouchHelper;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private ImageView previewImageView;
    private int previewRow;
    private int rowCount;
    private int selectChatsRow;
    private ArrayList<Long> selectedDialogs = new ArrayList<>();
    private WidgetPreviewCell widgetPreviewCell;
    private int widgetType;

    public interface EditWidgetActivityDelegate {
        void didSelectDialogs(ArrayList<Long> dialogs);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return false;
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        private boolean moved;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }

        public TouchHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 3) {
                return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            if (source.getItemViewType() != target.getItemViewType()) {
                return false;
            }
            int adapterPosition = source.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (EditWidgetActivity.this.listAdapter.swapElements(adapterPosition, adapterPosition2)) {
                ((GroupCreateUserCell) source.itemView).setDrawDivider(adapterPosition2 != EditWidgetActivity.this.chatsEndRow - 1);
                ((GroupCreateUserCell) target.itemView).setDrawDivider(adapterPosition != EditWidgetActivity.this.chatsEndRow - 1);
                this.moved = true;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) throws Resources.NotFoundException {
            if (actionState != 0) {
                EditWidgetActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            } else if (this.moved) {
                if (EditWidgetActivity.this.widgetPreviewCell != null) {
                    EditWidgetActivity.this.widgetPreviewCell.updateDialogs();
                }
                this.moved = false;
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    public class WidgetPreviewCell extends FrameLayout {
        private Drawable backgroundDrawable;
        private BackgroundGradientDrawable.Disposable backgroundGradientDisposable;
        private RectF bitmapRect;
        private ViewGroup[] cells;
        private Drawable oldBackgroundDrawable;
        private BackgroundGradientDrawable.Disposable oldBackgroundGradientDisposable;
        private Paint roundPaint;
        private Drawable shadowDrawable;

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchSetPressed(boolean pressed) {
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return false;
        }

        public WidgetPreviewCell(Context context) throws Resources.NotFoundException {
            super(context);
            this.roundPaint = new Paint(1);
            this.bitmapRect = new RectF();
            this.cells = new ViewGroup[2];
            int i = 0;
            setWillNotDraw(false);
            setPadding(0, AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, LayoutHelper.createFrame(-2, -2, 17));
            ChatActionCell chatActionCell = new ChatActionCell(context);
            chatActionCell.setCustomText(LocaleController.getString("WidgetPreview", R.string.WidgetPreview));
            linearLayout.addView(chatActionCell, LayoutHelper.createLinear(-2, -2, 17, 0, 0, 0, 4));
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(1);
            linearLayout2.setBackgroundResource(R.drawable.widget_bg);
            linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-2, -2, 17, 10, 0, 10, 0));
            EditWidgetActivity.this.previewImageView = new ImageView(context);
            if (EditWidgetActivity.this.widgetType == 0) {
                while (i < 2) {
                    this.cells[i] = (ViewGroup) EditWidgetActivity.this.getParentActivity().getLayoutInflater().inflate(R.layout.shortcut_widget_item, (ViewGroup) null);
                    linearLayout2.addView(this.cells[i], LayoutHelper.createLinear(-1, -2));
                    i++;
                }
                linearLayout2.addView(EditWidgetActivity.this.previewImageView, LayoutHelper.createLinear(218, 160, 17));
                EditWidgetActivity.this.previewImageView.setImageResource(R.drawable.chats_widget_preview);
            } else if (EditWidgetActivity.this.widgetType == 1) {
                while (i < 2) {
                    this.cells[i] = (ViewGroup) EditWidgetActivity.this.getParentActivity().getLayoutInflater().inflate(R.layout.contacts_widget_item, (ViewGroup) null);
                    linearLayout2.addView(this.cells[i], LayoutHelper.createLinear(160, -2));
                    i++;
                }
                linearLayout2.addView(EditWidgetActivity.this.previewImageView, LayoutHelper.createLinear(160, 160, 17));
                EditWidgetActivity.this.previewImageView.setImageResource(R.drawable.contacts_widget_preview);
            }
            updateDialogs();
            this.shadowDrawable = Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow");
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:148|(2:150|(1:152)(1:153))(2:154|(2:156|(1:158)(1:159))(8:161|(2:163|(1:165)(1:166))(1:167)|168|408|169|173|402|182))|160|168|408|169|173|402|182) */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x0412, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x0413, code lost:
        
            ir.eitaa.messenger.FileLog.e(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0287  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:233:0x058b  */
        /* JADX WARN: Removed duplicated region for block: B:240:0x05ce  */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0623  */
        /* JADX WARN: Removed duplicated region for block: B:371:0x08d1  */
        /* JADX WARN: Removed duplicated region for block: B:384:0x0921  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x016a  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01b8 A[Catch: all -> 0x021c, TryCatch #5 {all -> 0x021c, blocks: (B:70:0x016b, B:72:0x0179, B:75:0x018f, B:77:0x019a, B:82:0x01b0, B:88:0x0208, B:78:0x01a0, B:80:0x01a6, B:81:0x01ab, B:84:0x01b8, B:86:0x01c3, B:87:0x01d2), top: B:406:0x016b }] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0233  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateDialogs() throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 2415
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.EditWidgetActivity.WidgetPreviewCell.updateDialogs():void");
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(264.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Drawable cachedWallpaperNonBlocking = Theme.getCachedWallpaperNonBlocking();
            if (cachedWallpaperNonBlocking != this.backgroundDrawable && cachedWallpaperNonBlocking != null) {
                if (Theme.isAnimatingColor()) {
                    this.oldBackgroundDrawable = this.backgroundDrawable;
                    this.oldBackgroundGradientDisposable = this.backgroundGradientDisposable;
                } else {
                    BackgroundGradientDrawable.Disposable disposable = this.backgroundGradientDisposable;
                    if (disposable != null) {
                        disposable.dispose();
                        this.backgroundGradientDisposable = null;
                    }
                }
                this.backgroundDrawable = cachedWallpaperNonBlocking;
            }
            float themeAnimationValue = ((BaseFragment) EditWidgetActivity.this).parentLayout.getThemeAnimationValue();
            int i = 0;
            while (i < 2) {
                Drawable drawable = i == 0 ? this.oldBackgroundDrawable : this.backgroundDrawable;
                if (drawable != null) {
                    if (i == 1 && this.oldBackgroundDrawable != null && ((BaseFragment) EditWidgetActivity.this).parentLayout != null) {
                        drawable.setAlpha((int) (255.0f * themeAnimationValue));
                    } else {
                        drawable.setAlpha(255);
                    }
                    if ((drawable instanceof ColorDrawable) || (drawable instanceof GradientDrawable) || (drawable instanceof MotionBackgroundDrawable)) {
                        drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                        if (drawable instanceof BackgroundGradientDrawable) {
                            this.backgroundGradientDisposable = ((BackgroundGradientDrawable) drawable).drawExactBoundsSize(canvas, this);
                        } else {
                            drawable.draw(canvas);
                        }
                    } else if (drawable instanceof BitmapDrawable) {
                        if (((BitmapDrawable) drawable).getTileModeX() == Shader.TileMode.REPEAT) {
                            canvas.save();
                            float f = 2.0f / AndroidUtilities.density;
                            canvas.scale(f, f);
                            drawable.setBounds(0, 0, (int) Math.ceil(getMeasuredWidth() / f), (int) Math.ceil(getMeasuredHeight() / f));
                        } else {
                            int measuredHeight = getMeasuredHeight();
                            float fMax = Math.max(getMeasuredWidth() / drawable.getIntrinsicWidth(), measuredHeight / drawable.getIntrinsicHeight());
                            int iCeil = (int) Math.ceil(drawable.getIntrinsicWidth() * fMax);
                            int iCeil2 = (int) Math.ceil(drawable.getIntrinsicHeight() * fMax);
                            int measuredWidth = (getMeasuredWidth() - iCeil) / 2;
                            int i2 = (measuredHeight - iCeil2) / 2;
                            canvas.save();
                            canvas.clipRect(0, 0, iCeil, getMeasuredHeight());
                            drawable.setBounds(measuredWidth, i2, iCeil + measuredWidth, iCeil2 + i2);
                        }
                        drawable.draw(canvas);
                        canvas.restore();
                    }
                    if (i == 0 && this.oldBackgroundDrawable != null && themeAnimationValue >= 1.0f) {
                        BackgroundGradientDrawable.Disposable disposable2 = this.oldBackgroundGradientDisposable;
                        if (disposable2 != null) {
                            disposable2.dispose();
                            this.oldBackgroundGradientDisposable = null;
                        }
                        this.oldBackgroundDrawable = null;
                        invalidate();
                    }
                }
                i++;
            }
            this.shadowDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.shadowDrawable.draw(canvas);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BackgroundGradientDrawable.Disposable disposable = this.backgroundGradientDisposable;
            if (disposable != null) {
                disposable.dispose();
                this.backgroundGradientDisposable = null;
            }
            BackgroundGradientDrawable.Disposable disposable2 = this.oldBackgroundGradientDisposable;
            if (disposable2 != null) {
                disposable2.dispose();
                this.oldBackgroundGradientDisposable = null;
            }
        }
    }

    public EditWidgetActivity(int type, int widgetId) throws InterruptedException {
        this.widgetType = type;
        this.currentWidgetId = widgetId;
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        ArrayList<TLRPC$Chat> arrayList2 = new ArrayList<>();
        getMessagesStorage().getWidgetDialogIds(this.currentWidgetId, this.widgetType, this.selectedDialogs, arrayList, arrayList2, true);
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        updateRows();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        DialogsActivity.loadDialogs(AccountInstance.getInstance(this.currentAccount));
        getMediaDataController().loadHints(true);
        return super.onFragmentCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.previewRow = 0;
        this.rowCount = i + 1;
        this.selectChatsRow = i;
        if (this.selectedDialogs.isEmpty()) {
            this.chatsStartRow = -1;
            this.chatsEndRow = -1;
        } else {
            int i2 = this.rowCount;
            this.chatsStartRow = i2;
            int size = i2 + this.selectedDialogs.size();
            this.rowCount = size;
            this.chatsEndRow = size;
        }
        int i3 = this.rowCount;
        this.rowCount = i3 + 1;
        this.infoRow = i3;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    public void setDelegate(EditWidgetActivityDelegate editWidgetActivityDelegate) {
        this.delegate = editWidgetActivityDelegate;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        if (this.widgetType == 0) {
            this.actionBar.setTitle(LocaleController.getString("WidgetChats", R.string.WidgetChats));
        } else {
            this.actionBar.setTitle(LocaleController.getString("WidgetShortcuts", R.string.WidgetShortcuts));
        }
        this.actionBar.createMenu().addItem(1, LocaleController.getString("Done", R.string.Done).toUpperCase());
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.EditWidgetActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (EditWidgetActivity.this.delegate == null) {
                        EditWidgetActivity.this.finishActivity();
                        return;
                    } else {
                        EditWidgetActivity.this.finishFragment();
                        return;
                    }
                }
                if (id != 1 || EditWidgetActivity.this.getParentActivity() == null) {
                    return;
                }
                EditWidgetActivity.this.getMessagesStorage().putWidgetDialogs(EditWidgetActivity.this.currentWidgetId, EditWidgetActivity.this.selectedDialogs);
                SharedPreferences.Editor editorEdit = EditWidgetActivity.this.getParentActivity().getSharedPreferences("shortcut_widget", 0).edit();
                editorEdit.putInt("account" + EditWidgetActivity.this.currentWidgetId, ((BaseFragment) EditWidgetActivity.this).currentAccount);
                editorEdit.putInt("type" + EditWidgetActivity.this.currentWidgetId, EditWidgetActivity.this.widgetType);
                editorEdit.commit();
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(EditWidgetActivity.this.getParentActivity());
                if (EditWidgetActivity.this.widgetType == 0) {
                    ChatsWidgetProvider.updateWidget(EditWidgetActivity.this.getParentActivity(), appWidgetManager, EditWidgetActivity.this.currentWidgetId);
                } else {
                    ContactsWidgetProvider.updateWidget(EditWidgetActivity.this.getParentActivity(), appWidgetManager, EditWidgetActivity.this.currentWidgetId);
                }
                if (EditWidgetActivity.this.delegate != null) {
                    EditWidgetActivity.this.delegate.didSelectDialogs(EditWidgetActivity.this.selectedDialogs);
                } else {
                    EditWidgetActivity.this.finishActivity();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.fragmentView = frameLayout;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setAdapter(this.listAdapter);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TouchHelperCallback());
        this.itemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.listView);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$EditWidgetActivity$2TNwH7dS6xG7uZNbIX45O0bCqA8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$1$EditWidgetActivity(context, view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new AnonymousClass2());
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$EditWidgetActivity(Context context, View view, int i) {
        if (i == this.selectChatsRow) {
            InviteMembersBottomSheet inviteMembersBottomSheet = new InviteMembersBottomSheet(context, this.currentAccount, null, 0L, this, null);
            inviteMembersBottomSheet.setDelegate(new InviteMembersBottomSheet.InviteMembersBottomSheetDelegate() { // from class: ir.eitaa.ui.-$$Lambda$EditWidgetActivity$1JYt5D4qqVtKuLupUNBD-KogQzY
                @Override // ir.eitaa.ui.Components.InviteMembersBottomSheet.InviteMembersBottomSheetDelegate
                public final void didSelectDialogs(ArrayList arrayList) throws Resources.NotFoundException {
                    this.f$0.lambda$createView$0$EditWidgetActivity(arrayList);
                }
            }, this.selectedDialogs);
            inviteMembersBottomSheet.setSelectedContacts(this.selectedDialogs);
            showDialog(inviteMembersBottomSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$EditWidgetActivity(ArrayList arrayList) throws Resources.NotFoundException {
        this.selectedDialogs.clear();
        this.selectedDialogs.addAll(arrayList);
        updateRows();
        WidgetPreviewCell widgetPreviewCell = this.widgetPreviewCell;
        if (widgetPreviewCell != null) {
            widgetPreviewCell.updateDialogs();
        }
    }

    /* renamed from: ir.eitaa.ui.EditWidgetActivity$2, reason: invalid class name */
    class AnonymousClass2 implements RecyclerListView.OnItemLongClickListenerExtended {
        private Rect rect = new Rect();

        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
        public void onLongClickRelease() {
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
        public void onMove(float dx, float dy) {
        }

        AnonymousClass2() {
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
        public boolean onItemClick(View view, final int position, float x, float y) {
            if (EditWidgetActivity.this.getParentActivity() != null && (view instanceof GroupCreateUserCell)) {
                ((ImageView) view.getTag(R.id.object_tag)).getHitRect(this.rect);
                if (!this.rect.contains((int) x, (int) y)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditWidgetActivity.this.getParentActivity());
                    builder.setItems(new CharSequence[]{LocaleController.getString("Delete", R.string.Delete)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$EditWidgetActivity$2$MyqX90ETwR4WmE6_NJGDDYDKZwI
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
                            this.f$0.lambda$onItemClick$0$EditWidgetActivity$2(position, dialogInterface, i);
                        }
                    });
                    EditWidgetActivity.this.showDialog(builder.create());
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$EditWidgetActivity$2(int i, DialogInterface dialogInterface, int i2) throws Resources.NotFoundException {
            if (i2 == 0) {
                EditWidgetActivity.this.selectedDialogs.remove(i - EditWidgetActivity.this.chatsStartRow);
                EditWidgetActivity.this.updateRows();
                if (EditWidgetActivity.this.widgetPreviewCell != null) {
                    EditWidgetActivity.this.widgetPreviewCell.updateDialogs();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (getParentActivity() == null) {
            return;
        }
        getParentActivity().finish();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SnxdrVZH3cZKNTZUXRKIgil2ZzM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.removeSelfFromStack();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return EditWidgetActivity.this.rowCount;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 1 || itemViewType == 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            if (i == 0) {
                FrameLayout textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                frameLayout = textInfoPrivacyCell;
            } else if (i == 1) {
                FrameLayout textCell = new TextCell(this.mContext);
                textCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = textCell;
            } else if (i == 2) {
                frameLayout = EditWidgetActivity.this.widgetPreviewCell = EditWidgetActivity.this.new WidgetPreviewCell(this.mContext);
            } else {
                final GroupCreateUserCell groupCreateUserCell = new GroupCreateUserCell(this.mContext, 0, 0, false);
                ImageView imageView = new ImageView(this.mContext);
                imageView.setImageResource(R.drawable.list_reorder);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                groupCreateUserCell.setTag(R.id.object_tag, imageView);
                groupCreateUserCell.addView(imageView, LayoutHelper.createFrame(40, -1.0f, (LocaleController.isRTL ? 3 : 5) | 16, 10.0f, 0.0f, 10.0f, 0.0f));
                imageView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$EditWidgetActivity$ListAdapter$m0Cu-cuhDuXrgSKNqERxy8mRHGY
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$onCreateViewHolder$0$EditWidgetActivity$ListAdapter(groupCreateUserCell, view, motionEvent);
                    }
                });
                imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_pinnedIcon"), PorterDuff.Mode.MULTIPLY));
                frameLayout = groupCreateUserCell;
            }
            return new RecyclerListView.Holder(frameLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0$EditWidgetActivity$ListAdapter(GroupCreateUserCell groupCreateUserCell, View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            EditWidgetActivity.this.itemTouchHelper.startDrag(EditWidgetActivity.this.listView.getChildViewHolder(groupCreateUserCell));
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position == EditWidgetActivity.this.infoRow) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (EditWidgetActivity.this.widgetType != 0) {
                        if (EditWidgetActivity.this.widgetType == 1) {
                            spannableStringBuilder.append((CharSequence) LocaleController.getString("EditWidgetContactsInfo", R.string.EditWidgetContactsInfo));
                        }
                    } else {
                        spannableStringBuilder.append((CharSequence) LocaleController.getString("EditWidgetChatsInfo", R.string.EditWidgetChatsInfo));
                    }
                    if (SharedConfig.passcodeHash.length() > 0) {
                        spannableStringBuilder.append((CharSequence) "\n\n").append((CharSequence) AndroidUtilities.replaceTags(LocaleController.getString("WidgetPasscode2", R.string.WidgetPasscode2)));
                    }
                    textInfoPrivacyCell.setText(spannableStringBuilder);
                    return;
                }
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType != 3) {
                    return;
                }
                GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) holder.itemView;
                long jLongValue = ((Long) EditWidgetActivity.this.selectedDialogs.get(position - EditWidgetActivity.this.chatsStartRow)).longValue();
                if (DialogObject.isUserDialog(jLongValue)) {
                    groupCreateUserCell.setObject(EditWidgetActivity.this.getMessagesController().getUser(Long.valueOf(jLongValue)), null, null, position != EditWidgetActivity.this.chatsEndRow - 1);
                    return;
                } else {
                    groupCreateUserCell.setObject(EditWidgetActivity.this.getMessagesController().getChat(Long.valueOf(-jLongValue)), null, null, position != EditWidgetActivity.this.chatsEndRow - 1);
                    return;
                }
            }
            TextCell textCell = (TextCell) holder.itemView;
            textCell.setColors(null, "windowBackgroundWhiteBlueText4");
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.poll_add_circle);
            Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.poll_add_plus);
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("switchTrackChecked"), PorterDuff.Mode.MULTIPLY));
            drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("checkboxCheck"), PorterDuff.Mode.MULTIPLY));
            textCell.setTextAndIcon(LocaleController.getString("SelectChats", R.string.SelectChats), new CombinedDrawable(drawable, drawable2), EditWidgetActivity.this.chatsStartRow != -1);
            textCell.getImageView().setPadding(0, AndroidUtilities.dp(7.0f), 0, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 3 || itemViewType == 1) {
                holder.itemView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == EditWidgetActivity.this.previewRow) {
                return 2;
            }
            if (position == EditWidgetActivity.this.selectChatsRow) {
                return 1;
            }
            return position == EditWidgetActivity.this.infoRow ? 0 : 3;
        }

        public boolean swapElements(int fromIndex, int toIndex) {
            int i = fromIndex - EditWidgetActivity.this.chatsStartRow;
            int i2 = toIndex - EditWidgetActivity.this.chatsStartRow;
            int i3 = EditWidgetActivity.this.chatsEndRow - EditWidgetActivity.this.chatsStartRow;
            if (i < 0 || i2 < 0 || i >= i3 || i2 >= i3) {
                return false;
            }
            Long l = (Long) EditWidgetActivity.this.selectedDialogs.get(i);
            EditWidgetActivity.this.selectedDialogs.set(i, (Long) EditWidgetActivity.this.selectedDialogs.get(i2));
            EditWidgetActivity.this.selectedDialogs.set(i2, l);
            notifyItemMoved(fromIndex, toIndex);
            return true;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.delegate == null) {
            finishActivity();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        return arrayList;
    }
}
