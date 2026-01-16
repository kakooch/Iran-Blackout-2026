package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$TL_channels_setStickers;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetShortName;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.StickerSetCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.StickersAlert;
import org.rbmain.ui.Components.URLSpanNoUnderline;

/* loaded from: classes4.dex */
public class GroupStickersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int chatId;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private boolean donePressed;
    private EditTextBoldCursor editText;
    private ImageView eraseImageView;
    private int headerRow;
    private boolean ignoreTextChanges;
    private TLRPC$ChatFull info;
    private int infoRow;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private LinearLayout nameContainer;
    private int nameRow;
    private ContextProgressView progressView;
    private Runnable queryRunnable;
    private int reqId;
    private int rowCount;
    private boolean searchWas;
    private boolean searching;
    private int selectedStickerRow;
    private TLRPC$TL_messages_stickerSet selectedStickerSet;
    private int stickersEndRow;
    private int stickersShadowRow;
    private int stickersStartRow;
    private EditTextBoldCursor usernameTextView;

    public GroupStickersActivity(int i) {
        this.chatId = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        MediaDataController.getInstance(this.currentAccount).checkStickers(0);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatInfoDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupStickersDidLoad);
        updateRows();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatInfoDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupStickersDidLoad);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        TLRPC$StickerSet tLRPC$StickerSet;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("GroupStickers", R.string.GroupStickers));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.GroupStickersActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i != -1) {
                    if (i != 1 || GroupStickersActivity.this.donePressed) {
                        return;
                    }
                    GroupStickersActivity.this.donePressed = true;
                    if (GroupStickersActivity.this.searching) {
                        GroupStickersActivity.this.showEditDoneProgress(true);
                        return;
                    } else {
                        GroupStickersActivity.this.saveStickerSet();
                        return;
                    }
                }
                GroupStickersActivity.this.finishFragment();
            }
        });
        this.doneItem = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        contextProgressView.setAlpha(0.0f);
        this.progressView.setScaleX(0.1f);
        this.progressView.setScaleY(0.1f);
        this.progressView.setVisibility(4);
        this.doneItem.addView(this.progressView, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout = new LinearLayout(context) { // from class: org.rbmain.ui.GroupStickersActivity.2
            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
            }

            @Override // android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                if (GroupStickersActivity.this.selectedStickerSet != null) {
                    canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.dividerPaint);
                }
            }
        };
        this.nameContainer = linearLayout;
        linearLayout.setWeightSum(1.0f);
        this.nameContainer.setWillNotDraw(false);
        this.nameContainer.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.nameContainer.setOrientation(0);
        this.nameContainer.setPadding(AndroidUtilities.dp(17.0f), 0, AndroidUtilities.dp(14.0f), 0);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setText(MessagesController.getInstance(this.currentAccount).linkPrefix + "/addstickers/");
        this.editText.setTextSize(1, 17.0f);
        EditTextBoldCursor editTextBoldCursor2 = this.editText;
        int i = Theme.key_windowBackgroundWhiteHintText;
        editTextBoldCursor2.setHintTextColor(Theme.getColor(i));
        EditTextBoldCursor editTextBoldCursor3 = this.editText;
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        editTextBoldCursor3.setTextColor(Theme.getColor(i2));
        this.editText.setMaxLines(1);
        this.editText.setLines(1);
        this.editText.setEnabled(false);
        this.editText.setFocusable(false);
        this.editText.setBackgroundDrawable(null);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setGravity(16);
        this.editText.setSingleLine(true);
        this.editText.setInputType(163840);
        this.editText.setImeOptions(6);
        this.nameContainer.addView(this.editText, LayoutHelper.createLinear(-2, 42));
        EditTextBoldCursor editTextBoldCursor4 = new EditTextBoldCursor(context);
        this.usernameTextView = editTextBoldCursor4;
        editTextBoldCursor4.setTextSize(1, 17.0f);
        this.usernameTextView.setCursorColor(Theme.getColor(i2));
        this.usernameTextView.setCursorSize(AndroidUtilities.dp(20.0f));
        this.usernameTextView.setCursorWidth(1.5f);
        this.usernameTextView.setHintTextColor(Theme.getColor(i));
        this.usernameTextView.setTextColor(Theme.getColor(i2));
        this.usernameTextView.setMaxLines(1);
        this.usernameTextView.setLines(1);
        this.usernameTextView.setBackgroundDrawable(null);
        this.usernameTextView.setPadding(0, 0, 0, 0);
        this.usernameTextView.setSingleLine(true);
        this.usernameTextView.setGravity(16);
        this.usernameTextView.setInputType(163872);
        this.usernameTextView.setImeOptions(6);
        this.usernameTextView.setHint(LocaleController.getString("ChooseStickerSetPlaceholder", R.string.ChooseStickerSetPlaceholder));
        this.usernameTextView.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.GroupStickersActivity.3
            boolean ignoreTextChange;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (GroupStickersActivity.this.eraseImageView != null) {
                    GroupStickersActivity.this.eraseImageView.setVisibility(editable.length() > 0 ? 0 : 4);
                }
                if (this.ignoreTextChange || GroupStickersActivity.this.ignoreTextChanges) {
                    return;
                }
                if (editable.length() > 5) {
                    this.ignoreTextChange = true;
                    try {
                        Uri uri = Uri.parse(editable.toString());
                        if (uri != null) {
                            List<String> pathSegments = uri.getPathSegments();
                            if (pathSegments.size() == 2 && pathSegments.get(0).toLowerCase().equals("addstickers")) {
                                GroupStickersActivity.this.usernameTextView.setText(pathSegments.get(1));
                                GroupStickersActivity.this.usernameTextView.setSelection(GroupStickersActivity.this.usernameTextView.length());
                            }
                        }
                    } catch (Exception unused) {
                    }
                    this.ignoreTextChange = false;
                }
                GroupStickersActivity.this.resolveStickerSet();
            }
        });
        this.nameContainer.addView(this.usernameTextView, LayoutHelper.createLinear(0, 42, 1.0f));
        ImageView imageView = new ImageView(context);
        this.eraseImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.eraseImageView.setImageResource(R.drawable.ic_close_white);
        this.eraseImageView.setPadding(AndroidUtilities.dp(16.0f), 0, 0, 0);
        this.eraseImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3), PorterDuff.Mode.MULTIPLY));
        this.eraseImageView.setVisibility(4);
        this.eraseImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        this.nameContainer.addView(this.eraseImageView, LayoutHelper.createLinear(42, 42, 0.0f));
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull != null && (tLRPC$StickerSet = tLRPC$ChatFull.stickerset) != null) {
            this.ignoreTextChanges = true;
            this.usernameTextView.setText(tLRPC$StickerSet.short_name);
            EditTextBoldCursor editTextBoldCursor5 = this.usernameTextView;
            editTextBoldCursor5.setSelection(editTextBoldCursor5.length());
            this.ignoreTextChanges = false;
        }
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFocusable(true);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context) { // from class: org.rbmain.ui.GroupStickersActivity.4
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(this.layoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda7
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$createView$1(view, i3);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.GroupStickersActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (i3 == 1) {
                    AndroidUtilities.hideKeyboard(GroupStickersActivity.this.getParentActivity().getCurrentFocus());
                }
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        this.searchWas = false;
        this.selectedStickerSet = null;
        this.usernameTextView.setText(BuildConfig.FLAVOR);
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view, int i) {
        if (getParentActivity() == null) {
            return;
        }
        int i2 = this.selectedStickerRow;
        if (i == i2) {
            if (this.selectedStickerSet == null) {
                return;
            }
            showDialog(new StickersAlert(getParentActivity(), this, null, this.selectedStickerSet, null));
            return;
        }
        if (i < this.stickersStartRow || i >= this.stickersEndRow) {
            return;
        }
        boolean z = i2 == -1;
        int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
        int top = holder != null ? holder.itemView.getTop() : ConnectionsManager.DEFAULT_DATACENTER_ID;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = MediaDataController.getInstance(this.currentAccount).getStickerSets(0).get(i - this.stickersStartRow);
        this.selectedStickerSet = tLRPC$TL_messages_stickerSet;
        this.ignoreTextChanges = true;
        this.usernameTextView.setText(tLRPC$TL_messages_stickerSet.set.short_name);
        EditTextBoldCursor editTextBoldCursor = this.usernameTextView;
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        this.ignoreTextChanges = false;
        AndroidUtilities.hideKeyboard(this.usernameTextView);
        updateRows();
        if (!z || top == Integer.MAX_VALUE) {
            return;
        }
        this.layoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition + 1, top);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        TLRPC$StickerSet tLRPC$StickerSet;
        if (i == NotificationCenter.stickersDidLoad) {
            if (((Integer) objArr[0]).intValue() == 0) {
                updateRows();
                return;
            }
            return;
        }
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull.id == this.chatId) {
                if (this.info == null && tLRPC$ChatFull.stickerset != null) {
                    this.selectedStickerSet = MediaDataController.getInstance(this.currentAccount).getGroupStickerSetById(tLRPC$ChatFull.stickerset);
                }
                this.info = tLRPC$ChatFull;
                updateRows();
                return;
            }
            return;
        }
        if (i == NotificationCenter.groupStickersDidLoad) {
            ((Long) objArr[0]).longValue();
            TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
            if (tLRPC$ChatFull2 == null || (tLRPC$StickerSet = tLRPC$ChatFull2.stickerset) == null || tLRPC$StickerSet.id != i) {
                return;
            }
            updateRows();
        }
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        if (tLRPC$ChatFull == null || tLRPC$ChatFull.stickerset == null) {
            return;
        }
        this.selectedStickerSet = MediaDataController.getInstance(this.currentAccount).getGroupStickerSetById(this.info.stickerset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolveStickerSet() {
        if (this.listAdapter == null) {
            return;
        }
        if (this.reqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        Runnable runnable = this.queryRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.queryRunnable = null;
        }
        this.selectedStickerSet = null;
        if (this.usernameTextView.length() <= 0) {
            this.searching = false;
            this.searchWas = false;
            if (this.selectedStickerRow != -1) {
                updateRows();
                return;
            }
            return;
        }
        this.searching = true;
        this.searchWas = true;
        final String string = this.usernameTextView.getText().toString();
        TLRPC$TL_messages_stickerSet stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName(string);
        if (stickerSetByName != null) {
            this.selectedStickerSet = stickerSetByName;
        }
        int i = this.selectedStickerRow;
        if (i == -1) {
            updateRows();
        } else {
            this.listAdapter.notifyItemChanged(i);
        }
        if (stickerSetByName != null) {
            this.searching = false;
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resolveStickerSet$4(string);
            }
        };
        this.queryRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resolveStickerSet$4(String str) {
        if (this.queryRunnable == null) {
            return;
        }
        TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
        TLRPC$TL_inputStickerSetShortName tLRPC$TL_inputStickerSetShortName = new TLRPC$TL_inputStickerSetShortName();
        tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetShortName;
        tLRPC$TL_inputStickerSetShortName.short_name = str;
        this.reqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda6
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$resolveStickerSet$3(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resolveStickerSet$3(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resolveStickerSet$2(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resolveStickerSet$2(TLObject tLObject) {
        this.searching = false;
        if (tLObject instanceof TLRPC$TL_messages_stickerSet) {
            this.selectedStickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
            if (this.donePressed) {
                saveStickerSet();
            } else {
                int i = this.selectedStickerRow;
                if (i != -1) {
                    this.listAdapter.notifyItemChanged(i);
                } else {
                    updateRows();
                }
            }
        } else {
            int i2 = this.selectedStickerRow;
            if (i2 != -1) {
                this.listAdapter.notifyItemChanged(i2);
            }
            if (this.donePressed) {
                this.donePressed = false;
                showEditDoneProgress(false);
                if (getParentActivity() != null) {
                    Toast.makeText(getParentActivity(), LocaleController.getString("AddStickersNotFound", R.string.AddStickersNotFound), 0).show();
                }
            }
        }
        this.reqId = 0;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onTransitionAnimationEnd$5();
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTransitionAnimationEnd$5() {
        EditTextBoldCursor editTextBoldCursor = this.usernameTextView;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.usernameTextView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveStickerSet() {
        TLRPC$StickerSet tLRPC$StickerSet;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull == null || (((tLRPC$StickerSet = tLRPC$ChatFull.stickerset) != null && (tLRPC$TL_messages_stickerSet = this.selectedStickerSet) != null && tLRPC$TL_messages_stickerSet.set.id == tLRPC$StickerSet.id) || (tLRPC$StickerSet == null && this.selectedStickerSet == null))) {
            finishFragment();
            return;
        }
        showEditDoneProgress(true);
        TLRPC$TL_channels_setStickers tLRPC$TL_channels_setStickers = new TLRPC$TL_channels_setStickers();
        tLRPC$TL_channels_setStickers.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(this.chatId);
        if (this.selectedStickerSet == null) {
            tLRPC$TL_channels_setStickers.stickerset = new TLRPC$TL_inputStickerSetEmpty();
        } else {
            MessagesController.getEmojiSettings(this.currentAccount).edit().remove("group_hide_stickers_" + this.info.id).apply();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_channels_setStickers.stickerset = tLRPC$TL_inputStickerSetID;
            TLRPC$StickerSet tLRPC$StickerSet2 = this.selectedStickerSet.set;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet2.id;
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet2.access_hash;
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_setStickers, new RequestDelegate() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda5
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$saveStickerSet$7(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveStickerSet$7(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupStickersActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveStickerSet$6(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveStickerSet$6(TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.selectedStickerSet;
            if (tLRPC$TL_messages_stickerSet == null) {
                this.info.stickerset = null;
            } else {
                this.info.stickerset = tLRPC$TL_messages_stickerSet.set;
                MediaDataController.getInstance(this.currentAccount).putGroupStickerSet(this.selectedStickerSet);
            }
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            if (tLRPC$ChatFull.stickerset == null) {
                tLRPC$ChatFull.flags |= 256;
            } else {
                tLRPC$ChatFull.flags &= -257;
            }
            MessagesStorage.getInstance(this.currentAccount).updateChatInfo(this.info, false);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.chatInfoDidLoad, this.info, 0, Boolean.TRUE, Boolean.FALSE);
            finishFragment();
            return;
        }
        Toast.makeText(getParentActivity(), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text, 0).show();
        this.donePressed = false;
        showEditDoneProgress(false);
    }

    private void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.nameRow = 0;
        if (this.selectedStickerSet != null || this.searchWas) {
            this.rowCount = i + 1;
            this.selectedStickerRow = i;
        } else {
            this.selectedStickerRow = -1;
        }
        int i2 = this.rowCount;
        this.rowCount = i2 + 1;
        this.infoRow = i2;
        ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = MediaDataController.getInstance(this.currentAccount).getStickerSets(0);
        if (!stickerSets.isEmpty()) {
            int i3 = this.rowCount;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.headerRow = i3;
            this.stickersStartRow = i4;
            this.stickersEndRow = i4 + stickerSets.size();
            int size = this.rowCount + stickerSets.size();
            this.rowCount = size;
            this.rowCount = size + 1;
            this.stickersShadowRow = size;
        } else {
            this.headerRow = -1;
            this.stickersStartRow = -1;
            this.stickersEndRow = -1;
            this.stickersShadowRow = -1;
        }
        LinearLayout linearLayout = this.nameContainer;
        if (linearLayout != null) {
            linearLayout.invalidate();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (MessagesController.getGlobalMainSettings().getBoolean("view_animations", true)) {
            return;
        }
        this.usernameTextView.requestFocus();
        AndroidUtilities.showKeyboard(this.usernameTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(final boolean z) {
        if (this.doneItem == null) {
            return;
        }
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.doneItemAnimation = new AnimatorSet();
        if (z) {
            this.progressView.setVisibility(0);
            this.doneItem.setEnabled(false);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getContentView(), "scaleX", 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), "scaleY", 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), "alpha", 0.0f), ObjectAnimator.ofFloat(this.progressView, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.progressView, "alpha", 1.0f));
        } else {
            this.doneItem.getContentView().setVisibility(0);
            this.doneItem.setEnabled(true);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.progressView, "alpha", 0.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), "scaleX", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), "scaleY", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), "alpha", 1.0f));
        }
        this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupStickersActivity.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (GroupStickersActivity.this.doneItemAnimation == null || !GroupStickersActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    GroupStickersActivity.this.progressView.setVisibility(4);
                } else {
                    GroupStickersActivity.this.doneItem.getContentView().setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (GroupStickersActivity.this.doneItemAnimation == null || !GroupStickersActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                GroupStickersActivity.this.doneItemAnimation = null;
            }
        });
        this.doneItemAnimation.setDuration(150L);
        this.doneItemAnimation.start();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return GroupStickersActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = MediaDataController.getInstance(((BaseFragment) GroupStickersActivity.this).currentAccount).getStickerSets(0);
                int i2 = i - GroupStickersActivity.this.stickersStartRow;
                StickerSetCell stickerSetCell = (StickerSetCell) viewHolder.itemView;
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSets.get(i2);
                stickerSetCell.setStickersSet(stickerSets.get(i2), i2 != stickerSets.size() - 1);
                stickerSetCell.setChecked(tLRPC$TL_messages_stickerSet.set.id == (GroupStickersActivity.this.selectedStickerSet != null ? GroupStickersActivity.this.selectedStickerSet.set.id : (GroupStickersActivity.this.info == null || GroupStickersActivity.this.info.stickerset == null) ? 0L : GroupStickersActivity.this.info.stickerset.id));
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType == 4) {
                    ((HeaderCell) viewHolder.itemView).setText(LocaleController.getString("ChooseFromYourStickers", R.string.ChooseFromYourStickers));
                    return;
                }
                if (itemViewType != 5) {
                    return;
                }
                StickerSetCell stickerSetCell2 = (StickerSetCell) viewHolder.itemView;
                if (GroupStickersActivity.this.selectedStickerSet != null) {
                    stickerSetCell2.setStickersSet(GroupStickersActivity.this.selectedStickerSet, false);
                    return;
                } else if (GroupStickersActivity.this.searching) {
                    stickerSetCell2.setText(LocaleController.getString("Loading", R.string.Loading), null, 0, false);
                    return;
                } else {
                    stickerSetCell2.setText(LocaleController.getString("ChooseStickerSetNotFound", R.string.ChooseStickerSetNotFound), LocaleController.getString("ChooseStickerSetNotFoundInfo", R.string.ChooseStickerSetNotFoundInfo), R.drawable.ic_smiles2_sad, false);
                    return;
                }
            }
            if (i == GroupStickersActivity.this.infoRow) {
                String string = LocaleController.getString("ChooseStickerSetMy", R.string.ChooseStickerSetMy);
                String str = "@stickers";
                int iIndexOf = string.indexOf("@stickers");
                if (iIndexOf != -1) {
                    try {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                        spannableStringBuilder.setSpan(new URLSpanNoUnderline(str) { // from class: org.rbmain.ui.GroupStickersActivity.ListAdapter.1
                            @Override // org.rbmain.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                MessagesController.getInstance(((BaseFragment) GroupStickersActivity.this).currentAccount).openByUserName("stickers", GroupStickersActivity.this, 1);
                            }
                        }, iIndexOf, iIndexOf + 9, 18);
                        ((TextInfoPrivacyCell) viewHolder.itemView).setText(spannableStringBuilder);
                        return;
                    } catch (Exception e) {
                        FileLog.e(e);
                        ((TextInfoPrivacyCell) viewHolder.itemView).setText(string);
                        return;
                    }
                }
                ((TextInfoPrivacyCell) viewHolder.itemView).setText(string);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2 || itemViewType == 5;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup r4, int r5) {
            /*
                r3 = this;
                r4 = 3
                r0 = 2
                if (r5 == 0) goto L54
                r1 = 1
                r2 = 2131231387(0x7f08029b, float:1.8078854E38)
                if (r5 == r1) goto L41
                if (r5 == r0) goto L3a
                if (r5 == r4) goto L27
                r1 = 4
                if (r5 == r1) goto L16
                r1 = 5
                if (r5 == r1) goto L54
                r4 = 0
                goto L69
            L16:
                org.rbmain.ui.Cells.HeaderCell r4 = new org.rbmain.ui.Cells.HeaderCell
                android.content.Context r5 = r3.mContext
                r4.<init>(r5)
                int r5 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundWhite
                int r5 = org.rbmain.ui.ActionBar.Theme.getColor(r5)
                r4.setBackgroundColor(r5)
                goto L69
            L27:
                org.rbmain.ui.Cells.ShadowSectionCell r4 = new org.rbmain.ui.Cells.ShadowSectionCell
                android.content.Context r5 = r3.mContext
                r4.<init>(r5)
                android.content.Context r5 = r3.mContext
                int r0 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundGrayShadow
                android.graphics.drawable.Drawable r5 = org.rbmain.ui.ActionBar.Theme.getThemedDrawable(r5, r2, r0)
                r4.setBackgroundDrawable(r5)
                goto L69
            L3a:
                org.rbmain.ui.GroupStickersActivity r4 = org.rbmain.ui.GroupStickersActivity.this
                android.widget.LinearLayout r4 = org.rbmain.ui.GroupStickersActivity.access$1800(r4)
                goto L69
            L41:
                org.rbmain.ui.Cells.TextInfoPrivacyCell r4 = new org.rbmain.ui.Cells.TextInfoPrivacyCell
                android.content.Context r5 = r3.mContext
                r4.<init>(r5)
                android.content.Context r5 = r3.mContext
                int r0 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundGrayShadow
                android.graphics.drawable.Drawable r5 = org.rbmain.ui.ActionBar.Theme.getThemedDrawable(r5, r2, r0)
                r4.setBackgroundDrawable(r5)
                goto L69
            L54:
                org.rbmain.ui.Cells.StickerSetCell r1 = new org.rbmain.ui.Cells.StickerSetCell
                android.content.Context r2 = r3.mContext
                if (r5 != 0) goto L5b
                goto L5c
            L5b:
                r4 = 2
            L5c:
                r1.<init>(r2, r4)
                int r4 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundWhite
                int r4 = org.rbmain.ui.ActionBar.Theme.getColor(r4)
                r1.setBackgroundColor(r4)
                r4 = r1
            L69:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r5 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
                r0 = -1
                r1 = -2
                r5.<init>(r0, r1)
                r4.setLayoutParams(r5)
                org.rbmain.ui.Components.RecyclerListView$Holder r5 = new org.rbmain.ui.Components.RecyclerListView$Holder
                r5.<init>(r4)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupStickersActivity.ListAdapter.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= GroupStickersActivity.this.stickersStartRow && i < GroupStickersActivity.this.stickersEndRow) {
                return 0;
            }
            if (i == GroupStickersActivity.this.infoRow) {
                return 1;
            }
            if (i == GroupStickersActivity.this.nameRow) {
                return 2;
            }
            if (i == GroupStickersActivity.this.stickersShadowRow) {
                return 3;
            }
            if (i == GroupStickersActivity.this.headerRow) {
                return 4;
            }
            return i == GroupStickersActivity.this.selectedStickerRow ? 5 : 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{StickerSetCell.class, TextSettingsCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        EditTextBoldCursor editTextBoldCursor = this.editText;
        int i4 = ThemeDescription.FLAG_TEXTCOLOR;
        int i5 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i4, null, null, null, null, i5));
        EditTextBoldCursor editTextBoldCursor2 = this.editText;
        int i6 = ThemeDescription.FLAG_HINTTEXTCOLOR;
        int i7 = Theme.key_windowBackgroundWhiteHintText;
        arrayList.add(new ThemeDescription(editTextBoldCursor2, i6, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.usernameTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.usernameTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i7));
        int i8 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteLinkText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.nameContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{StickerSetCell.class}, new String[]{"optionsButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_stickers_menuSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"optionsButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_stickers_menu));
        return arrayList;
    }
}
