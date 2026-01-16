package ir.appp.ui.ActionBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidMessenger.ServiceLocator;
import androidMessenger.proxy.IdStorage;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.observers.DisposableObserver;
import ir.appp.ui.ActionBar.RubinoSharePostDialog;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.AddStoryFragment;
import ir.resaneh1.iptv.fragment.rubino.DialogInSharePostCell;
import ir.resaneh1.iptv.fragment.rubino.PostCommentInSharePostCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.SharePostToStoryCell;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostData;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.RubinoStoryData;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.WidgetStoryObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoPost;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.ForegroundColorSpanThemable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ShareAlert;

/* loaded from: classes3.dex */
public class RubinoSharePostDialog extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private static int sharePostType = 1;
    private static int shareStoryType = 2;
    private final PostCommentInSharePostCell commentView;
    private final int currentAccount;
    private final TextView doneTextView;
    private final FrameLayout frameLayout2;
    private final FrameLayout frameLayoutTop;
    private final LinearLayoutManager layoutManager;
    private final ShareDialogsAdapter listAdapter;
    private final RecyclerListView listView;
    private DisposableObserver<Integer> loadDiaologdisposable;
    private final EditTextBoldCursor nameTextView;
    private final RubinoPostObject postObject;
    private int scrollOffsetY;
    private final ShareSearchAdapter searchAdapter;
    private final EmptyTextProgressView searchEmptyView;
    private LongSparseArray<TLRPC$Dialog> selectedDialogs;
    private final View shadow;
    private final View shadow2;
    private final Drawable shadowDrawable;
    private final StoryObject storyObject;
    private int topBeforeSwitch;
    private int type;

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public RubinoSharePostDialog(int i, final Context context, final RubinoPostObject rubinoPostObject, StoryObject storyObject) {
        super(context, true);
        this.selectedDialogs = new LongSparseArray<>();
        this.type = 0;
        this.currentAccount = i;
        ServiceLocator.getInstance(i).getCoreMainClass().initChatMapFromDbIfNeeded();
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow).mutate();
        this.shadowDrawable = drawableMutate;
        int i2 = Theme.key_dialogBackground;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
        this.searchAdapter = new ShareSearchAdapter(context);
        this.postObject = rubinoPostObject;
        this.storyObject = storyObject;
        if (RubinoController.getInstance(i).hasPermissionAddStory()) {
            if (rubinoPostObject != null) {
                this.type = sharePostType;
            } else if (storyObject != null) {
                this.type = shareStoryType;
            }
        }
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.1
            private boolean ignoreLayout = false;

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && RubinoSharePostDialog.this.scrollOffsetY != 0 && motionEvent.getY() < RubinoSharePostDialog.this.scrollOffsetY) {
                    RubinoSharePostDialog.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !RubinoSharePostDialog.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i3, int i4) {
                int size = View.MeasureSpec.getSize(i4);
                if (Build.VERSION.SDK_INT >= 21) {
                    size -= AndroidUtilities.statusBarHeight;
                }
                int iDp = AndroidUtilities.dp(48.0f) + (Math.max(3, (int) Math.ceil(Math.max(RubinoSharePostDialog.this.searchAdapter.getItemCount(), RubinoSharePostDialog.this.listAdapter.getItemCount()) / 4.0f)) * AndroidUtilities.dp(100.0f)) + ((BottomSheet) RubinoSharePostDialog.this).backgroundPaddingTop;
                int iDp2 = iDp < size ? 0 : (size - ((size / 5) * 3)) + AndroidUtilities.dp(8.0f);
                if (RubinoSharePostDialog.this.listView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    RubinoSharePostDialog.this.listView.setPadding(AndroidUtilities.dp(6.0f), iDp2, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(RubinoSharePostDialog.this.frameLayout2.getTag() != null ? 56.0f : 8.0f));
                    this.ignoreLayout = false;
                }
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i3, int i4, int i5, int i6) {
                super.onLayout(z, i3, i4, i5, i6);
                RubinoSharePostDialog.this.updateLayout();
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
                RubinoSharePostDialog.this.shadowDrawable.setBounds(0, RubinoSharePostDialog.this.scrollOffsetY - ((BottomSheet) RubinoSharePostDialog.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                RubinoSharePostDialog.this.shadowDrawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i3 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i3, 0, i3, 0);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.frameLayoutTop = frameLayout2;
        frameLayout2.setBackgroundColor(Theme.getColor(i2));
        frameLayout2.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        PostCommentInSharePostCell postCommentInSharePostCell = new PostCommentInSharePostCell(context);
        this.commentView = postCommentInSharePostCell;
        if (rubinoPostObject != null) {
            postCommentInSharePostCell.setData(rubinoPostObject.post.full_thumbnail_url, BuildConfig.FLAVOR);
        } else if (storyObject != null) {
            postCommentInSharePostCell.setData(storyObject.full_thumbnail_url, BuildConfig.FLAVOR);
        }
        frameLayout2.addView(postCommentInSharePostCell, LayoutHelper.createFrame(-1, -2.0f, 48, 4.0f, 0.0f, 4.0f, 0.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        Theme.ThemeInfo currentTheme = Theme.getCurrentTheme();
        if (currentTheme.isDark()) {
            if (currentTheme.getName().equals("Night") || currentTheme.getName().equals("Dark")) {
                frameLayout3.setBackground(context.getResources().getDrawable(R.drawable.rubino_shape_rectangle_grey));
            } else {
                frameLayout3.setBackground(context.getResources().getDrawable(R.drawable.rubino_shape_transparent_rectangle_border_grey_c6));
            }
        } else {
            frameLayout3.setBackground(context.getResources().getDrawable(R.drawable.rubino_shape_transparent_rectangle_border_grey_c6));
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_ab_search);
        int i4 = Theme.key_rubinoGrayColor;
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.SRC_ATOP));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
        frameLayout3.addView(imageView, LayoutHelper.createFrame(32, 32.0f, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        final ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_canvas_close));
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.SRC_ATOP));
        imageView2.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        imageView2.setVisibility(8);
        frameLayout3.addView(imageView2, LayoutHelper.createFrame(40, 40, 19));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RubinoSharePostDialog.this.nameTextView != null) {
                    RubinoSharePostDialog.this.nameTextView.setText(BuildConfig.FLAVOR);
                }
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.nameTextView = editTextBoldCursor;
        editTextBoldCursor.setHint(LocaleController.getString("ShareSendTo", R.string.rubinoSearch));
        editTextBoldCursor.setMaxLines(1);
        editTextBoldCursor.setSingleLine(true);
        editTextBoldCursor.setGravity(21);
        editTextBoldCursor.setTextSize(2, 13.0f);
        editTextBoldCursor.setBackgroundDrawable(null);
        editTextBoldCursor.setHintTextColor(Theme.getColor(Theme.key_dialogTextHint));
        editTextBoldCursor.setImeOptions(268435456);
        editTextBoldCursor.setInputType(16385);
        int i5 = Theme.key_dialogTextBlack;
        editTextBoldCursor.setCursorColor(Theme.getColor(i5));
        editTextBoldCursor.setCursorSize(AndroidUtilities.dp(12.0f));
        editTextBoldCursor.setCursorWidth(1.5f);
        editTextBoldCursor.setTypeface(Theme.getRubinoTypeFaceRegular());
        editTextBoldCursor.setTextColor(Theme.getColor(i5));
        frameLayout3.addView(editTextBoldCursor, LayoutHelper.createFrame(-1, 36.0f, 21, 48.0f, 0.0f, 40.0f, 0.0f));
        frameLayout2.addView(frameLayout3, LayoutHelper.createFrame(-1, 36.0f, 48, 16.0f, 84.0f, 16.0f, 4.0f));
        editTextBoldCursor.addTextChangedListener(new TextWatcher() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = RubinoSharePostDialog.this.nameTextView.getText().toString();
                if (string.length() != 0) {
                    imageView2.setVisibility(0);
                    if (RubinoSharePostDialog.this.listView.getAdapter() != RubinoSharePostDialog.this.searchAdapter) {
                        RubinoSharePostDialog rubinoSharePostDialog = RubinoSharePostDialog.this;
                        rubinoSharePostDialog.topBeforeSwitch = rubinoSharePostDialog.getCurrentTop();
                        RubinoSharePostDialog.this.listView.setAdapter(RubinoSharePostDialog.this.searchAdapter);
                        RubinoSharePostDialog.this.searchAdapter.notifyDataSetChanged();
                    }
                    if (RubinoSharePostDialog.this.searchEmptyView != null) {
                        RubinoSharePostDialog.this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                    }
                } else {
                    imageView2.setVisibility(8);
                    if (RubinoSharePostDialog.this.listView.getAdapter() != RubinoSharePostDialog.this.listAdapter) {
                        int currentTop = RubinoSharePostDialog.this.getCurrentTop();
                        RubinoSharePostDialog.this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
                        RubinoSharePostDialog.this.listView.setAdapter(RubinoSharePostDialog.this.listAdapter);
                        RubinoSharePostDialog.this.listAdapter.notifyDataSetChanged();
                        if (currentTop > 0) {
                            RubinoSharePostDialog.this.layoutManager.scrollToPositionWithOffset(0, -currentTop);
                        }
                    }
                }
                if (RubinoSharePostDialog.this.searchAdapter != null) {
                    RubinoSharePostDialog.this.searchAdapter.searchDialogs(string);
                }
            }
        });
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setTag(13);
        recyclerListView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f));
        recyclerListView.setClipToPadding(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        recyclerListView.setHorizontalScrollBarEnabled(false);
        recyclerListView.setVerticalScrollBarEnabled(false);
        this.containerView.addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 120.0f, 0.0f, 0.0f));
        ShareDialogsAdapter shareDialogsAdapter = new ShareDialogsAdapter(context);
        this.listAdapter = shareDialogsAdapter;
        recyclerListView.setAdapter(shareDialogsAdapter);
        recyclerListView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 120.0f, 0.0f, 0.0f));
        recyclerListView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.5
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i6) {
                if (i6 < 0) {
                    return;
                }
                if (i6 != 0 || RubinoSharePostDialog.this.type != RubinoSharePostDialog.sharePostType || RubinoSharePostDialog.this.listView.getAdapter() != RubinoSharePostDialog.this.listAdapter) {
                    TLRPC$Dialog item = RubinoSharePostDialog.this.listView.getAdapter() == RubinoSharePostDialog.this.listAdapter ? RubinoSharePostDialog.this.listAdapter.getItem(i6) : RubinoSharePostDialog.this.searchAdapter.getItem(i6);
                    if (item == null || IdStorage.getInstance().getDialogId(item.id) == null) {
                        return;
                    }
                    DialogInSharePostCell dialogInSharePostCell = (DialogInSharePostCell) view;
                    if (RubinoSharePostDialog.this.selectedDialogs.indexOfKey(item.id) < 0) {
                        RubinoSharePostDialog.this.selectedDialogs.put(item.id, item);
                        dialogInSharePostCell.setSelected(true, true);
                        RubinoSharePostDialog rubinoSharePostDialog = RubinoSharePostDialog.this;
                        rubinoSharePostDialog.send((TLRPC$Dialog) rubinoSharePostDialog.selectedDialogs.get(item.id));
                    }
                    RubinoSharePostDialog.this.updateDownButton();
                    return;
                }
                if (!new File(rubinoPostObject.photoSlideObject.getPhotos().get(rubinoPostObject.photoSlideObject.getCurrentIndex()).getDownloadFile().getPath()).exists()) {
                    ToastiLikeSnack.showL(context, LocaleController.getString(R.string.rubinoSharePostError));
                    return;
                }
                WidgetStoryObject widgetStoryObject = new WidgetStoryObject();
                widgetStoryObject.type = WidgetStoryObject.WidgetTypeEnum.Post;
                widgetStoryObject.rubinoPostObject = rubinoPostObject;
                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new AddStoryFragment(widgetStoryObject, DimensionHelper.getStoryHWRatio()));
            }
        });
        recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i6, int i7) {
                RubinoSharePostDialog.this.updateLayout();
            }
        });
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.searchEmptyView = emptyTextProgressView;
        emptyTextProgressView.setShowAtCenter(true);
        emptyTextProgressView.showTextView();
        emptyTextProgressView.setText(LocaleController.getString("NoChats", R.string.NoChats));
        recyclerListView.setEmptyView(emptyTextProgressView);
        this.containerView.addView(emptyTextProgressView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 64.0f, 0.0f, 0.0f));
        this.containerView.addView(frameLayout2, LayoutHelper.createFrame(-1, 120.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        View view = new View(context);
        this.shadow = view;
        view.setBackgroundColor(Theme.getColor(i4));
        view.setAlpha(0.2f);
        this.containerView.addView(view, LayoutHelper.createFrame(-1, 1.0f, 51, 0.0f, 66.0f, 0.0f, 0.0f));
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.frameLayout2 = frameLayout4;
        frameLayout4.setBackgroundColor(Theme.getColor(i2));
        this.containerView.addView(frameLayout4, LayoutHelper.createFrame(-1, -2, 83));
        frameLayout4.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        TextView textView = new TextView(context);
        this.doneTextView = textView;
        textView.setText(LocaleController.getString(R.string.rubinoSharePostDown));
        textView.setTextColor(-1);
        textView.setTextSize(2, 15.0f);
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setGravity(17);
        textView.setBackground(context.getResources().getDrawable(R.drawable.rubino_follow_background_shape_blue));
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RubinoSharePostDialog.this.dismiss();
            }
        });
        frameLayout4.addView(textView, LayoutHelper.createFrame(-1, 44.0f, 51, 0.0f, 1.0f, 0.0f, 0.0f));
        updateDownButton();
        View view2 = new View(context);
        this.shadow2 = view2;
        view2.setBackgroundResource(R.drawable.header_shadow_reverse);
        view2.setTranslationY(AndroidUtilities.dp(53.0f));
        this.containerView.addView(view2, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        if (shareDialogsAdapter.dialogs.isEmpty()) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.dialogsNeedReload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownButton() {
        if (this.selectedDialogs.size() <= 0) {
            this.doneTextView.setVisibility(8);
            this.frameLayout2.setTag(null);
        } else {
            this.doneTextView.setVisibility(0);
            this.frameLayout2.setTag(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentTop() {
        if (this.listView.getChildCount() == 0) {
            return -1000;
        }
        int top = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        if (holder == null) {
            return -1000;
        }
        int paddingTop = this.listView.getPaddingTop();
        if (holder.getAdapterPosition() == 0 && childAt.getTop() >= 0) {
            top = childAt.getTop();
        }
        return paddingTop - top;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        int i3 = NotificationCenter.dialogsNeedReload;
        if (i == i3) {
            ShareDialogsAdapter shareDialogsAdapter = this.listAdapter;
            if (shareDialogsAdapter != null) {
                shareDialogsAdapter.fetchDialogs();
            }
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            return;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        if (top > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = top;
        }
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView = this.listView;
            this.scrollOffsetY = i;
            recyclerListView.setTopGlowOffset(i);
            this.frameLayoutTop.setTranslationY(this.scrollOffsetY);
            this.shadow.setTranslationY(this.scrollOffsetY);
            this.searchEmptyView.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send(TLRPC$Dialog tLRPC$Dialog) {
        if (tLRPC$Dialog == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) AndroidUtilities.getTrimmedString(this.commentView.getText() + BuildConfig.FLAVOR));
        sb.append(BuildConfig.FLAVOR);
        String string = sb.toString();
        if (string.length() > 0) {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(string, tLRPC$Dialog.id, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
        if (this.postObject != null) {
            RubinoPostData rubinoPostData = new RubinoPostData();
            RubinoPostObject rubinoPostObject = this.postObject;
            Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
            rubinoPostData.post_id = postObjectFromServer.id;
            RubinoProfileObject rubinoProfileObject = rubinoPostObject.profile;
            rubinoPostData.post_profile_id = rubinoProfileObject.id;
            rubinoPostData.profileObject = rubinoProfileObject;
            rubinoPostData.rubinoPost = postObjectFromServer;
            TLRPC$TL_messageMediaRubinoPost tLRPC$TL_messageMediaRubinoPost = new TLRPC$TL_messageMediaRubinoPost();
            tLRPC$TL_messageMediaRubinoPost.rubinoPostData = rubinoPostData;
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(tLRPC$TL_messageMediaRubinoPost, tLRPC$Dialog.id, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
            return;
        }
        if (this.storyObject != null) {
            RubinoStoryData rubinoStoryData = new RubinoStoryData();
            StoryObject storyObject = this.storyObject;
            rubinoStoryData.story_id = storyObject.id;
            rubinoStoryData.story_profile_id = storyObject.profile_id;
            rubinoStoryData.storyObject = storyObject;
            rubinoStoryData.profileObject = StoryController.getInstance(this.currentAccount).getInstantProfile(this.storyObject.profile_id);
            rubinoStoryData.type = RubinoStoryData.Type.Direct;
            TLRPC$TL_messageMediaRubinoStory tLRPC$TL_messageMediaRubinoStory = new TLRPC$TL_messageMediaRubinoStory();
            tLRPC$TL_messageMediaRubinoStory.rubinoStoryData = rubinoStoryData;
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(tLRPC$TL_messageMediaRubinoStory, tLRPC$Dialog.id, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        DisposableObserver<Integer> disposableObserver = this.loadDiaologdisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        AndroidUtilities.hideKeyboard(this.nameTextView);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.dialogsNeedReload);
    }

    private class ShareDialogsAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();
        private LongSparseArray<TLRPC$Dialog> dialogsMap = new LongSparseArray<>();

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ShareDialogsAdapter(Context context) {
            this.context = context;
            fetchDialogs();
        }

        public void fetchDialogs() {
            long j;
            int i;
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
            this.dialogs.clear();
            this.dialogsMap.clear();
            int i2 = UserConfig.getInstance(RubinoSharePostDialog.this.currentAccount).clientUserId;
            if (!MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).dialogsForward.isEmpty()) {
                TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).dialogsForward.get(0);
                this.dialogs.add(tLRPC$Dialog);
                this.dialogsMap.put(tLRPC$Dialog.id, tLRPC$Dialog);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<TLRPC$Dialog> allDialogs = MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).getAllDialogs();
            for (int i3 = 0; i3 < allDialogs.size(); i3++) {
                TLRPC$Dialog tLRPC$Dialog2 = allDialogs.get(i3);
                if ((tLRPC$Dialog2 instanceof TLRPC$TL_dialog) && (i = (int) (j = tLRPC$Dialog2.id)) != i2) {
                    int i4 = (int) (j >> 32);
                    if (i != 0 && i4 != 1) {
                        if (i > 0) {
                            TLRPC$User user = MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).getUser(Integer.valueOf(i));
                            if (user == null || !user.support) {
                                if (tLRPC$Dialog2.folder_id == 1) {
                                    arrayList.add(tLRPC$Dialog2);
                                } else {
                                    this.dialogs.add(tLRPC$Dialog2);
                                }
                                this.dialogsMap.put(tLRPC$Dialog2.id, tLRPC$Dialog2);
                            }
                        } else {
                            TLRPC$Chat chat = MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).getChat(Integer.valueOf(-i));
                            if (chat != null && !ChatObject.isNotInChat(chat) && ((!chat.gigagroup || ChatObject.hasAdminRights(chat)) && (!ChatObject.isChannel(chat) || chat.creator || (((tLRPC$TL_chatAdminRights = chat.admin_rights) != null && tLRPC$TL_chatAdminRights.post_messages) || chat.megagroup)))) {
                                if (tLRPC$Dialog2.folder_id == 1) {
                                    arrayList.add(tLRPC$Dialog2);
                                } else {
                                    this.dialogs.add(tLRPC$Dialog2);
                                }
                                this.dialogsMap.put(tLRPC$Dialog2.id, tLRPC$Dialog2);
                            }
                        }
                    }
                }
            }
            this.dialogs.addAll(arrayList);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dialogs.size() + (RubinoSharePostDialog.this.type == RubinoSharePostDialog.sharePostType ? 1 : 0);
        }

        public TLRPC$Dialog getItem(int i) {
            if (i < 0) {
                return null;
            }
            if (i == 0 && RubinoSharePostDialog.this.type == RubinoSharePostDialog.sharePostType) {
                return null;
            }
            if (i - (RubinoSharePostDialog.this.type == RubinoSharePostDialog.sharePostType ? 1 : 0) < this.dialogs.size()) {
                return this.dialogs.get(i - (RubinoSharePostDialog.this.type != RubinoSharePostDialog.sharePostType ? 0 : 1));
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View dialogInSharePostCell;
            if (i == 0) {
                dialogInSharePostCell = new DialogInSharePostCell(this.context);
                dialogInSharePostCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                dialogInSharePostCell = new SharePostToStoryCell(this.context);
                dialogInSharePostCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(dialogInSharePostCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                DialogInSharePostCell dialogInSharePostCell = (DialogInSharePostCell) viewHolder.itemView;
                TLRPC$Dialog item = getItem(i);
                dialogInSharePostCell.setDialog((int) item.id, RubinoSharePostDialog.this.selectedDialogs.indexOfKey(item.id) >= 0, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (i == 0 && RubinoSharePostDialog.this.type == RubinoSharePostDialog.sharePostType) ? 1 : 0;
        }
    }

    public class ShareSearchAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int lastGlobalSearchId;
        private int lastLocalSearchId;
        private int lastSearchId;
        private String lastSearchText;
        private SearchAdapterHelper searchAdapterHelper;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private Runnable searchRunnable;
        private Runnable searchRunnable2;
        private int waitingResponseCount;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == 0 ? 1 : 0;
        }

        static /* synthetic */ int access$2110(ShareSearchAdapter shareSearchAdapter) {
            int i = shareSearchAdapter.waitingResponseCount;
            shareSearchAdapter.waitingResponseCount = i - 1;
            return i;
        }

        public ShareSearchAdapter(Context context) {
            this.context = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate(RubinoSharePostDialog.this) { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog.ShareSearchAdapter.1
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public void onDataSetChanged(int i) {
                    ShareSearchAdapter.access$2110(ShareSearchAdapter.this);
                    ShareSearchAdapter.this.lastGlobalSearchId = i;
                    if (ShareSearchAdapter.this.lastLocalSearchId != i) {
                        ShareSearchAdapter.this.searchResult.clear();
                    }
                    ShareSearchAdapter.this.notifyDataSetChanged();
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public boolean canApplySearchResults(int i) {
                    return i == ShareSearchAdapter.this.lastSearchId;
                }
            });
        }

        private void searchDialogsInternal(final String str, final int i) {
            MessagesStorage.getInstance(RubinoSharePostDialog.this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog$ShareSearchAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogsInternal$1(str, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogsInternal$1(String str, int i) {
            try {
                String lowerCase = str.trim().toLowerCase();
                if (lowerCase.length() == 0) {
                    this.lastSearchId = -1;
                    updateSearchResults(new ArrayList<>(), this.lastSearchId);
                    return;
                }
                String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
                if (lowerCase.equals(translitString) || translitString.length() == 0) {
                    translitString = null;
                }
                String[] strArr = new String[(translitString != null ? 1 : 0) + 1];
                strArr[0] = lowerCase;
                if (translitString != null) {
                    strArr[1] = translitString;
                }
                ArrayList<Object> arrayList = new ArrayList<>();
                AccountInstance.getInstance(RubinoSharePostDialog.this.currentAccount).getDialogsProxy().localSearch(strArr[0], null, null, arrayList);
                Collections.sort(arrayList, new Comparator() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog$ShareSearchAdapter$$ExternalSyntheticLambda4
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return RubinoSharePostDialog.ShareSearchAdapter.lambda$searchDialogsInternal$0(obj, obj2);
                    }
                });
                updateSearchResults(arrayList, i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$searchDialogsInternal$0(Object obj, Object obj2) {
            int i = ((ShareAlert.DialogSearchResult) obj).date;
            int i2 = ((ShareAlert.DialogSearchResult) obj2).date;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final int i) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog$ShareSearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$2(i, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$2(int i, ArrayList arrayList) {
            if (i != this.lastSearchId) {
                return;
            }
            this.lastLocalSearchId = i;
            if (this.lastGlobalSearchId != i) {
                this.searchAdapterHelper.clear();
            }
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                ShareAlert.DialogSearchResult dialogSearchResult = (ShareAlert.DialogSearchResult) arrayList.get(i2);
                TLObject tLObject = dialogSearchResult.object;
                if (tLObject instanceof TLRPC$User) {
                    TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                    if (!tLRPC$User.support) {
                        MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).putUser(tLRPC$User, true);
                    } else {
                        arrayList.remove(dialogSearchResult);
                    }
                } else if (tLObject instanceof TLRPC$Chat) {
                    MessagesController.getInstance(RubinoSharePostDialog.this.currentAccount).putChat((TLRPC$Chat) tLObject, true);
                }
                i2++;
            }
            boolean z = !this.searchResult.isEmpty() && arrayList.isEmpty();
            boolean z2 = this.searchResult.isEmpty() && arrayList.isEmpty();
            if (z) {
                RubinoSharePostDialog rubinoSharePostDialog = RubinoSharePostDialog.this;
                rubinoSharePostDialog.topBeforeSwitch = rubinoSharePostDialog.getCurrentTop();
            }
            this.searchResult = arrayList;
            this.searchAdapterHelper.mergeResults(arrayList);
            notifyDataSetChanged();
            if (!z2 && !z && RubinoSharePostDialog.this.topBeforeSwitch > 0) {
                RubinoSharePostDialog.this.layoutManager.scrollToPositionWithOffset(0, -RubinoSharePostDialog.this.topBeforeSwitch);
                RubinoSharePostDialog.this.topBeforeSwitch = -1000;
            }
            RubinoSharePostDialog.this.searchEmptyView.showTextView();
        }

        public void searchDialogs(final String str) {
            if (str == null || !str.equals(this.lastSearchText)) {
                this.lastSearchText = str;
                if (this.searchRunnable != null) {
                    Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                    this.searchRunnable = null;
                }
                Runnable runnable = this.searchRunnable2;
                if (runnable != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable);
                    this.searchRunnable2 = null;
                }
                if (TextUtils.isEmpty(str)) {
                    this.searchResult.clear();
                    this.searchAdapterHelper.mergeResults(null);
                    this.searchAdapterHelper.queryServerSearch(null, true, true, true, true, false, 0, false, 0, 0);
                    RubinoSharePostDialog rubinoSharePostDialog = RubinoSharePostDialog.this;
                    rubinoSharePostDialog.topBeforeSwitch = rubinoSharePostDialog.getCurrentTop();
                    this.lastSearchId = -1;
                    notifyDataSetChanged();
                    return;
                }
                final int i = this.lastSearchId + 1;
                this.lastSearchId = i;
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable2 = new Runnable() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog$ShareSearchAdapter$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchDialogs$4(str, i);
                    }
                };
                this.searchRunnable = runnable2;
                dispatchQueue.postRunnable(runnable2, 600L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$4(final String str, final int i) {
            this.searchRunnable = null;
            searchDialogsInternal(str, i);
            Runnable runnable = new Runnable() { // from class: ir.appp.ui.ActionBar.RubinoSharePostDialog$ShareSearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$3(i, str);
                }
            };
            this.searchRunnable2 = runnable;
            AndroidUtilities.runOnUIThread(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$3(int i, String str) {
            this.searchRunnable2 = null;
            if (i != this.lastSearchId) {
                return;
            }
            this.searchAdapterHelper.queryServerSearch(str, true, true, true, true, false, 0, false, 0, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.searchResult.size() + this.searchAdapterHelper.getLocalServerSearch().size();
            return size != 0 ? size + 1 : size;
        }

        public TLRPC$Dialog getItem(int i) {
            int i2 = i - 1;
            TLRPC$TL_dialog tLRPC$TL_dialog = null;
            if (i2 < 0) {
                return null;
            }
            if (i2 < this.searchResult.size()) {
                return ((ShareAlert.DialogSearchResult) this.searchResult.get(i2)).dialog;
            }
            int size = i2 - this.searchResult.size();
            ArrayList<TLObject> localServerSearch = this.searchAdapterHelper.getLocalServerSearch();
            if (size < localServerSearch.size()) {
                TLObject tLObject = localServerSearch.get(size);
                tLRPC$TL_dialog = new TLRPC$TL_dialog();
                if (tLObject instanceof TLRPC$User) {
                    tLRPC$TL_dialog.id = ((TLRPC$User) tLObject).id;
                } else {
                    tLRPC$TL_dialog.id = -((TLRPC$Chat) tLObject).id;
                }
            }
            return tLRPC$TL_dialog;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View dialogInSharePostCell;
            if (i == 0) {
                dialogInSharePostCell = new DialogInSharePostCell(this.context);
                dialogInSharePostCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                dialogInSharePostCell = new SharePostToStoryCell(this.context);
                dialogInSharePostCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(dialogInSharePostCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            long j;
            CharSequence name;
            long j2;
            int iIndexOfIgnoreCase;
            if (viewHolder.getItemViewType() == 0) {
                int i2 = i - 1;
                DialogInSharePostCell dialogInSharePostCell = (DialogInSharePostCell) viewHolder.itemView;
                if (i2 < this.searchResult.size()) {
                    ShareAlert.DialogSearchResult dialogSearchResult = (ShareAlert.DialogSearchResult) this.searchResult.get(i2);
                    j2 = dialogSearchResult.dialog.id;
                    name = dialogSearchResult.name;
                } else {
                    TLObject tLObject = this.searchAdapterHelper.getLocalServerSearch().get(i2 - this.searchResult.size());
                    if (tLObject instanceof TLRPC$User) {
                        TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                        j = tLRPC$User.id;
                        name = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
                    } else {
                        TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                        j = -tLRPC$Chat.id;
                        name = tLRPC$Chat.title;
                    }
                    String lastFoundUsername = this.searchAdapterHelper.getLastFoundUsername();
                    if (!TextUtils.isEmpty(lastFoundUsername) && name != null && (iIndexOfIgnoreCase = AndroidUtilities.indexOfIgnoreCase(name.toString(), lastFoundUsername)) != -1) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
                        spannableStringBuilder.setSpan(new ForegroundColorSpanThemable(Theme.key_windowBackgroundWhiteBlueText4), iIndexOfIgnoreCase, lastFoundUsername.length() + iIndexOfIgnoreCase, 33);
                        name = spannableStringBuilder;
                    }
                    j2 = j;
                }
                dialogInSharePostCell.setDialog((int) j2, RubinoSharePostDialog.this.selectedDialogs.indexOfKey(j2) >= 0, name);
            }
        }
    }
}
