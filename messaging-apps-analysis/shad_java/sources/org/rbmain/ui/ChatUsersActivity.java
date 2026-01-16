package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.model.Chat;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$ChannelParticipantsFilter;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatParticipant;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$TL_channelParticipant;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantSelf;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsAdmins;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsBanned;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsBots;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsContacts;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsKicked;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsRecent;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_editBanned;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipants;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatParticipant;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_updateChatDefaultBannedRights;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.ManageChatTextCell;
import org.rbmain.ui.Cells.ManageChatUserCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell2;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.ChatRightsEditActivity;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.GigagroupConvertAlert;
import org.rbmain.ui.Components.IntSeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.StickerEmptyView;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.GroupCreateActivity;

/* loaded from: classes4.dex */
public class ChatUsersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int addNew2Row;
    private int addNewRow;
    private int addNewSectionRow;
    private int addUsersRow;
    private int blockedEmptyRow;
    private int botEndRow;
    private int botHeaderRow;
    private int botStartRow;
    private ArrayList<TLObject> bots;
    private boolean botsEndReached;
    private SparseArray<TLObject> botsMap;
    private int changeInfoRow;
    private int chatId;
    private ArrayList<TLObject> contacts;
    private boolean contactsEndReached;
    private int contactsEndRow;
    private int contactsHeaderRow;
    private SparseArray<TLObject> contactsMap;
    private int contactsStartRow;
    private TLRPC$Chat currentChat;
    private TLRPC$TL_chatBannedRights defaultBannedRights;
    private int delayResults;
    private ChatUsersActivityDelegate delegate;
    private ActionBarMenuItem doneItem;
    private int embedLinksRow;
    private StickerEmptyView emptyView;
    private boolean firstLoaded;
    private FlickerLoadingView flickerLoadingView;
    private int gigaConvertRow;
    private int gigaHeaderRow;
    private int gigaInfoRow;
    private boolean hasContinue;
    private SparseArray<TLRPC$TL_groupCallParticipant> ignoredUsers;
    private TLRPC$ChatFull info;
    private String initialBannedRights;
    private int initialSlowmode;
    private boolean isChannel;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private int loadingHeaderRow;
    private int loadingProgressRow;
    private int loadingUserCellRow;
    private boolean loadingUsers;
    private int membersHeaderRow;
    private boolean needOpenSearch;
    private String nextStartId;
    private boolean openTransitionStarted;
    private ArrayList<TLObject> participants;
    private int participantsDivider2Row;
    private int participantsDividerRow;
    private int participantsEndRow;
    private int participantsInfoRow;
    private SparseArray<TLObject> participantsMap;
    private int participantsStartRow;
    private int permissionsSectionRow;
    private int pinMessagesRow;
    private View progressBar;
    private AlertDialog progressDialog;
    private String querySearch;
    private int recentActionsRow;
    private int removedUsersRow;
    private int restricted1SectionRow;
    private int rowCount;
    private ActionBarMenuItem searchItem;
    private SearchAdapter searchListViewAdapter;
    private boolean searching;
    private int selectType;
    private int selectedSlowmode;
    private int sendMediaRow;
    private int sendMessagesRow;
    private int sendPollsRow;
    private int sendStickersRow;
    private int slowmodeInfoRow;
    private int slowmodeRow;
    private int slowmodeSelectRow;
    private int type;
    private UndoView undoView;
    private int viewAdminsRow;
    private int viewMembersRow;

    public interface ChatUsersActivityDelegate {

        /* renamed from: org.rbmain.ui.ChatUsersActivity$ChatUsersActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didKickParticipant(ChatUsersActivityDelegate chatUsersActivityDelegate, int i) {
            }

            public static void $default$didSelectUser(ChatUsersActivityDelegate chatUsersActivityDelegate, int i) {
            }
        }

        void didAddParticipantToList(int i, TLObject tLObject);

        void didKickParticipant(int i);

        void didSelectUser(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSecondsForIndex(int i) {
        if (i == 1) {
            return 10;
        }
        if (i == 2) {
            return 30;
        }
        if (i == 3) {
            return 60;
        }
        if (i == 4) {
            return 300;
        }
        return i == 5 ? DBHelper.GET_STICKER_LIMIT : i == 6 ? 3600 : 0;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean needDelayOpenAnimation() {
        return true;
    }

    private class ChooseView extends View {
        private final SeekBarAccessibilityDelegate accessibilityDelegate;
        private int circleSize;
        private int gapSize;
        private int lineSize;
        private boolean moving;
        private final Paint paint;
        private int sideSide;
        private ArrayList<Integer> sizes;
        private boolean startMoving;
        private int startMovingItem;
        private float startX;
        private ArrayList<String> strings;
        private final TextPaint textPaint;

        public ChooseView(Context context) {
            String string;
            super(context);
            this.strings = new ArrayList<>();
            this.sizes = new ArrayList<>();
            this.paint = new Paint(1);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(13.0f));
            int i = 0;
            while (i < 7) {
                if (i == 0) {
                    string = LocaleController.getString("SlowmodeOff", R.string.SlowmodeOff);
                } else if (i == 1) {
                    string = LocaleController.formatString("SlowmodeSeconds", R.string.SlowmodeSeconds, 10);
                } else if (i == 2) {
                    string = LocaleController.formatString("SlowmodeSeconds", R.string.SlowmodeSeconds, 30);
                } else if (i == 3) {
                    string = LocaleController.formatString("SlowmodeMinutes", R.string.SlowmodeMinutes, 1);
                } else if (i != 4) {
                    string = i != 5 ? LocaleController.formatString("SlowmodeHours", R.string.SlowmodeHours, 1) : LocaleController.formatString("SlowmodeMinutes", R.string.SlowmodeMinutes, 15);
                } else {
                    string = LocaleController.formatString("SlowmodeMinutes", R.string.SlowmodeMinutes, 5);
                }
                this.strings.add(string);
                this.sizes.add(Integer.valueOf((int) Math.ceil(this.textPaint.measureText(string))));
                i++;
            }
            this.accessibilityDelegate = new IntSeekBarAccessibilityDelegate(ChatUsersActivity.this) { // from class: org.rbmain.ui.ChatUsersActivity.ChooseView.1
                @Override // org.rbmain.ui.Components.IntSeekBarAccessibilityDelegate
                public int getProgress() {
                    return ChatUsersActivity.this.selectedSlowmode;
                }

                @Override // org.rbmain.ui.Components.IntSeekBarAccessibilityDelegate
                public void setProgress(int i2) {
                    ChooseView.this.setItem(i2);
                }

                @Override // org.rbmain.ui.Components.IntSeekBarAccessibilityDelegate
                public int getMaxValue() {
                    return ChooseView.this.strings.size() - 1;
                }

                @Override // org.rbmain.ui.Components.SeekBarAccessibilityDelegate
                protected CharSequence getContentDescription(View view) {
                    if (ChatUsersActivity.this.selectedSlowmode == 0) {
                        return LocaleController.getString("SlowmodeOff", R.string.SlowmodeOff);
                    }
                    ChatUsersActivity chatUsersActivity = ChatUsersActivity.this;
                    return chatUsersActivity.formatSeconds(chatUsersActivity.getSecondsForIndex(chatUsersActivity.selectedSlowmode));
                }
            };
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            this.accessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(this, accessibilityNodeInfo);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return super.performAccessibilityAction(i, bundle) || this.accessibilityDelegate.performAccessibilityActionInternal(this, i, bundle);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            int i = 0;
            if (motionEvent.getAction() == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.strings.size()) {
                        break;
                    }
                    int i3 = this.sideSide;
                    int i4 = this.lineSize + (this.gapSize * 2);
                    int i5 = this.circleSize;
                    int i6 = i3 + ((i4 + i5) * i2) + (i5 / 2);
                    if (x <= i6 - AndroidUtilities.dp(15.0f) || x >= i6 + AndroidUtilities.dp(15.0f)) {
                        i2++;
                    } else {
                        this.startMoving = i2 == ChatUsersActivity.this.selectedSlowmode;
                        this.startX = x;
                        this.startMovingItem = ChatUsersActivity.this.selectedSlowmode;
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                if (this.startMoving) {
                    if (Math.abs(this.startX - x) >= AndroidUtilities.getPixelsInCM(0.5f, true)) {
                        this.moving = true;
                        this.startMoving = false;
                    }
                } else if (this.moving) {
                    while (true) {
                        if (i >= this.strings.size()) {
                            break;
                        }
                        int i7 = this.sideSide;
                        int i8 = this.lineSize;
                        int i9 = this.gapSize;
                        int i10 = this.circleSize;
                        int i11 = i7 + (((i9 * 2) + i8 + i10) * i) + (i10 / 2);
                        int i12 = (i8 / 2) + (i10 / 2) + i9;
                        if (x <= i11 - i12 || x >= i11 + i12) {
                            i++;
                        } else if (ChatUsersActivity.this.selectedSlowmode != i) {
                            setItem(i);
                        }
                    }
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.moving) {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= this.strings.size()) {
                            break;
                        }
                        int i14 = this.sideSide;
                        int i15 = this.lineSize + (this.gapSize * 2);
                        int i16 = this.circleSize;
                        int i17 = i14 + ((i15 + i16) * i13) + (i16 / 2);
                        if (x <= i17 - AndroidUtilities.dp(15.0f) || x >= i17 + AndroidUtilities.dp(15.0f)) {
                            i13++;
                        } else if (ChatUsersActivity.this.selectedSlowmode != i13) {
                            setItem(i13);
                        }
                    }
                } else if (ChatUsersActivity.this.selectedSlowmode != this.startMovingItem) {
                    setItem(ChatUsersActivity.this.selectedSlowmode);
                }
                this.startMoving = false;
                this.moving = false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setItem(int i) {
            if (ChatUsersActivity.this.info == null) {
                return;
            }
            ChatUsersActivity.this.selectedSlowmode = i;
            ChatUsersActivity.this.listViewAdapter.notifyItemChanged(ChatUsersActivity.this.slowmodeInfoRow);
            invalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(74.0f), 1073741824));
            this.circleSize = AndroidUtilities.dp(6.0f);
            this.gapSize = AndroidUtilities.dp(2.0f);
            this.sideSide = AndroidUtilities.dp(22.0f);
            this.lineSize = (((getMeasuredWidth() - (this.circleSize * this.strings.size())) - ((this.gapSize * 2) * (this.strings.size() - 1))) - (this.sideSide * 2)) / (this.strings.size() - 1);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.textPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
            int measuredHeight = (getMeasuredHeight() / 2) + AndroidUtilities.dp(11.0f);
            int i = 0;
            while (i < this.strings.size()) {
                int i2 = this.sideSide;
                int i3 = this.lineSize + (this.gapSize * 2);
                int i4 = this.circleSize;
                int i5 = i2 + ((i3 + i4) * i) + (i4 / 2);
                if (i <= ChatUsersActivity.this.selectedSlowmode) {
                    this.paint.setColor(Theme.getColor(Theme.key_switchTrackChecked));
                } else {
                    this.paint.setColor(Theme.getColor(Theme.key_switchTrack));
                }
                canvas.drawCircle(i5, measuredHeight, i == ChatUsersActivity.this.selectedSlowmode ? AndroidUtilities.dp(6.0f) : this.circleSize / 2, this.paint);
                if (i != 0) {
                    int i6 = (i5 - (this.circleSize / 2)) - this.gapSize;
                    int iDp = this.lineSize;
                    int iDp2 = i6 - iDp;
                    if (i == ChatUsersActivity.this.selectedSlowmode || i == ChatUsersActivity.this.selectedSlowmode + 1) {
                        iDp -= AndroidUtilities.dp(3.0f);
                    }
                    if (i == ChatUsersActivity.this.selectedSlowmode + 1) {
                        iDp2 += AndroidUtilities.dp(3.0f);
                    }
                    canvas.drawRect(iDp2, measuredHeight - AndroidUtilities.dp(1.0f), iDp2 + iDp, AndroidUtilities.dp(1.0f) + measuredHeight, this.paint);
                }
                int iIntValue = this.sizes.get(i).intValue();
                String str = this.strings.get(i);
                if (i == 0) {
                    canvas.drawText(str, AndroidUtilities.dp(22.0f), AndroidUtilities.dp(28.0f), this.textPaint);
                } else if (i == this.strings.size() - 1) {
                    canvas.drawText(str, (getMeasuredWidth() - iIntValue) - AndroidUtilities.dp(22.0f), AndroidUtilities.dp(28.0f), this.textPaint);
                } else {
                    canvas.drawText(str, i5 - (iIntValue / 2), AndroidUtilities.dp(28.0f), this.textPaint);
                }
                i++;
            }
        }
    }

    public ChatUsersActivity(Bundle bundle) {
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        super(bundle);
        this.defaultBannedRights = new TLRPC$TL_chatBannedRights();
        this.participants = new ArrayList<>();
        this.bots = new ArrayList<>();
        this.contacts = new ArrayList<>();
        this.participantsMap = new SparseArray<>();
        this.botsMap = new SparseArray<>();
        this.contactsMap = new SparseArray<>();
        this.nextStartId = null;
        this.hasContinue = true;
        this.querySearch = BuildConfig.FLAVOR;
        this.chatId = this.arguments.getInt("chat_id");
        this.type = this.arguments.getInt("type");
        this.needOpenSearch = this.arguments.getBoolean("open_search");
        this.selectType = this.arguments.getInt("selectType");
        TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(this.chatId));
        this.currentChat = chat;
        if (chat != null && (tLRPC$TL_chatBannedRights = chat.default_banned_rights) != null) {
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = this.defaultBannedRights;
            tLRPC$TL_chatBannedRights2.view_messages = tLRPC$TL_chatBannedRights.view_messages;
            tLRPC$TL_chatBannedRights2.send_stickers = tLRPC$TL_chatBannedRights.send_stickers;
            tLRPC$TL_chatBannedRights2.send_media = tLRPC$TL_chatBannedRights.send_media;
            tLRPC$TL_chatBannedRights2.embed_links = tLRPC$TL_chatBannedRights.embed_links;
            tLRPC$TL_chatBannedRights2.send_messages = tLRPC$TL_chatBannedRights.send_messages;
            tLRPC$TL_chatBannedRights2.send_games = tLRPC$TL_chatBannedRights.send_games;
            tLRPC$TL_chatBannedRights2.send_inline = tLRPC$TL_chatBannedRights.send_inline;
            tLRPC$TL_chatBannedRights2.send_gifs = tLRPC$TL_chatBannedRights.send_gifs;
            tLRPC$TL_chatBannedRights2.pin_messages = tLRPC$TL_chatBannedRights.pin_messages;
            tLRPC$TL_chatBannedRights2.send_polls = tLRPC$TL_chatBannedRights.send_polls;
            tLRPC$TL_chatBannedRights2.invite_users = tLRPC$TL_chatBannedRights.invite_users;
            tLRPC$TL_chatBannedRights2.change_info = tLRPC$TL_chatBannedRights.change_info;
        }
        this.initialBannedRights = ChatObject.getBannedRightsString(this.defaultBannedRights);
        this.isChannel = ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateRows() {
        /*
            Method dump skipped, instructions count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatUsersActivity.updateRows():void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.chatInfoDidLoad);
        loadChatParticipants(0, 200);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        int i;
        boolean z = false;
        this.searching = false;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        int i2 = this.type;
        if (i2 == 3) {
            this.actionBar.setTitle(LocaleController.getString("ChannelPermissions", R.string.ChannelPermissions));
        } else if (i2 == 0) {
            this.actionBar.setTitle(LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist));
        } else if (i2 == 1) {
            this.actionBar.setTitle(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators));
        } else if (i2 == 2) {
            int i3 = this.selectType;
            if (i3 == 0) {
                if (this.isChannel) {
                    this.actionBar.setTitle(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers));
                } else {
                    this.actionBar.setTitle(LocaleController.getString("ChannelMembers", R.string.ChannelMembers));
                }
            } else if (i3 == 1) {
                this.actionBar.setTitle(LocaleController.getString("ChannelAddAdmin", R.string.ChannelAddAdmin));
            } else if (i3 == 2) {
                this.actionBar.setTitle(LocaleController.getString("ChannelBlockUser", R.string.ChannelBlockUser));
            } else if (i3 == 3) {
                this.actionBar.setTitle(LocaleController.getString("ChannelAddException", R.string.ChannelAddException));
            }
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ChatUsersActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i4) {
                if (i4 == -1) {
                    if (ChatUsersActivity.this.checkDiscard()) {
                        ChatUsersActivity.this.finishFragment();
                    }
                } else if (i4 == 1) {
                    ChatUsersActivity.this.processDone();
                }
            }
        });
        if (this.selectType != 0 || (i = this.type) == 2 || i == 0 || i == 3 || i == 1) {
            this.searchListViewAdapter = new SearchAdapter(context);
            ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
            ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.ChatUsersActivity.2
                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchExpand() {
                    ChatUsersActivity.this.searching = true;
                    if (ChatUsersActivity.this.doneItem != null) {
                        ChatUsersActivity.this.doneItem.setVisibility(8);
                    }
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchCollapse() {
                    ChatUsersActivity.this.searchListViewAdapter.searchUsers(null);
                    ChatUsersActivity.this.searching = false;
                    ChatUsersActivity.this.listView.setAnimateEmptyView(false, 0);
                    ChatUsersActivity.this.listView.setAdapter(ChatUsersActivity.this.listViewAdapter);
                    ChatUsersActivity.this.listViewAdapter.notifyDataSetChanged();
                    ChatUsersActivity.this.listView.setFastScrollVisible(true);
                    ChatUsersActivity.this.listView.setVerticalScrollBarEnabled(false);
                    if (ChatUsersActivity.this.doneItem != null) {
                        ChatUsersActivity.this.doneItem.setVisibility(0);
                    }
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) {
                    if (ChatUsersActivity.this.searchListViewAdapter == null) {
                        return;
                    }
                    String string = editText.getText().toString();
                    int itemCount = ChatUsersActivity.this.listView.getAdapter() == null ? 0 : ChatUsersActivity.this.listView.getAdapter().getItemCount();
                    ChatUsersActivity.this.searchListViewAdapter.searchUsers(string);
                    if (TextUtils.isEmpty(string) && ChatUsersActivity.this.listView != null && ChatUsersActivity.this.listView.getAdapter() != ChatUsersActivity.this.listViewAdapter) {
                        ChatUsersActivity.this.listView.setAnimateEmptyView(false, 0);
                        ChatUsersActivity.this.listView.setAdapter(ChatUsersActivity.this.listViewAdapter);
                        if (itemCount == 0) {
                            ChatUsersActivity.this.showItemsAnimated(0);
                        }
                    }
                    ChatUsersActivity.this.progressBar.setVisibility(8);
                    ChatUsersActivity.this.flickerLoadingView.setVisibility(0);
                }
            });
            this.searchItem = actionBarMenuItemSearchListener;
            if (this.type == 3) {
                actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("ChannelSearchException", R.string.ChannelSearchException));
                this.searchItem.setVisibility(8);
            } else {
                actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
            }
            if (!ChatObject.isChannel(this.currentChat) && !this.currentChat.creator) {
                this.searchItem.setVisibility(8);
            }
            if (this.type == 3) {
                this.doneItem = actionBarMenuCreateMenu.addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
            }
        }
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.ChatUsersActivity.3
            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                canvas.drawColor(Theme.getColor(ChatUsersActivity.this.listView.getAdapter() == ChatUsersActivity.this.searchListViewAdapter ? Theme.key_windowBackgroundWhite : Theme.key_windowBackgroundGray));
                super.dispatchDraw(canvas);
            }
        };
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        FrameLayout frameLayout3 = new FrameLayout(context);
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        this.flickerLoadingView = flickerLoadingView;
        flickerLoadingView.setViewType(6);
        this.flickerLoadingView.showDate(false);
        this.flickerLoadingView.setUseHeaderOffset(true);
        frameLayout3.addView(this.flickerLoadingView);
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        frameLayout3.addView(radialProgressView, LayoutHelper.createFrame(-2, -2, 17));
        this.flickerLoadingView.setVisibility(8);
        this.progressBar.setVisibility(8);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(context, frameLayout3, 1);
        this.emptyView = stickerEmptyView;
        stickerEmptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
        this.emptyView.subtitle.setText(LocaleController.getString("SearchEmptyViewFilteredSubtitle2", R.string.SearchEmptyViewFilteredSubtitle2));
        this.emptyView.setVisibility(8);
        this.emptyView.setAnimateLayoutChange(true);
        this.emptyView.showProgress(true, false);
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.addView(frameLayout3, 0);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.ChatUsersActivity.4
            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                View view = ChatUsersActivity.this.fragmentView;
                if (view != null) {
                    view.invalidate();
                }
            }
        };
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, i, z) { // from class: org.rbmain.ui.ChatUsersActivity.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
                if (!ChatUsersActivity.this.firstLoaded && ChatUsersActivity.this.type == 0 && ChatUsersActivity.this.participants.size() == 0) {
                    return 0;
                }
                return super.scrollVerticallyBy(i4, recycler, state);
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: org.rbmain.ui.ChatUsersActivity.6
            int animationIndex = -1;

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected long getAddAnimationDelay(long j, long j2, long j3) {
                return 0L;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
            public long getAddDuration() {
                return 220L;
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected long getMoveAnimationDelay() {
                return 0L;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
            public long getMoveDuration() {
                return 220L;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
            public long getRemoveDuration() {
                return 220L;
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void onAllAnimationsDone() {
                super.onAllAnimationsDone();
                ChatUsersActivity.this.getNotificationCenter().onAnimationFinish(this.animationIndex);
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
            public void runPendingAnimations() {
                boolean z2 = !this.mPendingRemovals.isEmpty();
                boolean z3 = !this.mPendingMoves.isEmpty();
                boolean z4 = !this.mPendingChanges.isEmpty();
                boolean z5 = !this.mPendingAdditions.isEmpty();
                if (z2 || z3 || z5 || z4) {
                    this.animationIndex = ChatUsersActivity.this.getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
                }
                super.runPendingAnimations();
            }
        };
        this.listView.setItemAnimator(defaultItemAnimator);
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.listView.setAnimateEmptyView(true, 0);
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda26
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                this.f$0.lambda$createView$4(view, i4);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda27
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i4) {
                return this.f$0.lambda$createView$5(view, i4);
            }
        });
        if (this.searchItem != null) {
            this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.ChatUsersActivity.12
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (i4 == 1) {
                        AndroidUtilities.hideKeyboard(ChatUsersActivity.this.getParentActivity().getCurrentFocus());
                    }
                }
            });
        }
        this.listView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.ChatUsersActivity.13
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                super.onScrollStateChanged(recyclerView, i4);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                super.onScrolled(recyclerView, i4, i5);
                if (ChatUsersActivity.this.loadingUsers || recyclerView.getChildCount() <= 0) {
                    return;
                }
                int iFindLastVisibleItemPosition = ChatUsersActivity.this.layoutManager.findLastVisibleItemPosition();
                if (iFindLastVisibleItemPosition == -1 || ChatUsersActivity.this.searching || !ChatUsersActivity.this.hasContinue || recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() - iFindLastVisibleItemPosition >= 10) {
                    if (ChatUsersActivity.this.searchListViewAdapter == null || iFindLastVisibleItemPosition == -1 || !ChatUsersActivity.this.searching || !ChatUsersActivity.this.searchListViewAdapter.searchAdapterHelper.searchHasContinue || recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() - iFindLastVisibleItemPosition >= 10) {
                        return;
                    }
                    ChatUsersActivity.this.searchListViewAdapter.searchAdapterHelper.queryServerSearch(ChatUsersActivity.this.querySearch, false, false, true, false, false, ChatObject.isChannel(ChatUsersActivity.this.currentChat) ? ChatUsersActivity.this.chatId : 0, false, ChatUsersActivity.this.type, 1, ChatUsersActivity.this.searchListViewAdapter.searchAdapterHelper.searchNextStartId);
                    return;
                }
                ChatUsersActivity.this.loadChatParticipants(0, 0, false);
            }
        });
        UndoView undoView = new UndoView(context);
        this.undoView = undoView;
        frameLayout2.addView(undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        updateRows();
        this.listView.setEmptyView(this.emptyView);
        this.listView.setAnimateEmptyView(false, 0);
        if (this.needOpenSearch) {
            this.searchItem.openSearch(false);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view, int i) {
        int i2;
        TLObject tLObject;
        String str;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        boolean z;
        int peerId;
        boolean zCanBlockUsers;
        final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2;
        boolean z2 = false;
        boolean z3 = this.listView.getAdapter() == this.listViewAdapter;
        if (z3) {
            if (i == this.addNewRow) {
                int i3 = this.type;
                if (i3 == 0 || i3 == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("chat_id", this.chatId);
                    bundle.putInt("type", 2);
                    bundle.putInt("selectType", this.type != 0 ? 3 : 2);
                    ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
                    chatUsersActivity.setInfo(this.info);
                    chatUsersActivity.setDelegate(new ChatUsersActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.7
                        @Override // org.rbmain.ui.ChatUsersActivity.ChatUsersActivityDelegate
                        public /* synthetic */ void didSelectUser(int i4) {
                            ChatUsersActivityDelegate.CC.$default$didSelectUser(this, i4);
                        }

                        @Override // org.rbmain.ui.ChatUsersActivity.ChatUsersActivityDelegate
                        public void didAddParticipantToList(int i4, TLObject tLObject2) {
                            if (ChatUsersActivity.this.participantsMap.get(i4) == null) {
                                DiffCallback diffCallbackSaveState = ChatUsersActivity.this.saveState();
                                ChatUsersActivity.this.participants.add(tLObject2);
                                ChatUsersActivity.this.participantsMap.put(i4, tLObject2);
                                ChatUsersActivity chatUsersActivity2 = ChatUsersActivity.this;
                                chatUsersActivity2.sortUsers(chatUsersActivity2.participants);
                                ChatUsersActivity.this.updateListAnimated(diffCallbackSaveState);
                            }
                        }

                        @Override // org.rbmain.ui.ChatUsersActivity.ChatUsersActivityDelegate
                        public void didKickParticipant(int i4) {
                            if (ChatUsersActivity.this.participantsMap.get(i4) == null) {
                                DiffCallback diffCallbackSaveState = ChatUsersActivity.this.saveState();
                                TLRPC$TL_channelParticipantBanned tLRPC$TL_channelParticipantBanned = new TLRPC$TL_channelParticipantBanned();
                                if (i4 > 0) {
                                    TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                                    tLRPC$TL_channelParticipantBanned.peer = tLRPC$TL_peerUser;
                                    tLRPC$TL_peerUser.user_id = i4;
                                } else {
                                    TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                                    tLRPC$TL_channelParticipantBanned.peer = tLRPC$TL_peerChannel;
                                    tLRPC$TL_peerChannel.channel_id = -i4;
                                }
                                tLRPC$TL_channelParticipantBanned.date = ChatUsersActivity.this.getConnectionsManager().getCurrentTime();
                                tLRPC$TL_channelParticipantBanned.kicked_by = ChatUsersActivity.this.getAccountInstance().getUserConfig().clientUserId;
                                ChatUsersActivity.this.info.kicked_count++;
                                ChatUsersActivity.this.participants.add(tLRPC$TL_channelParticipantBanned);
                                ChatUsersActivity.this.participantsMap.put(i4, tLRPC$TL_channelParticipantBanned);
                                ChatUsersActivity chatUsersActivity2 = ChatUsersActivity.this;
                                chatUsersActivity2.sortUsers(chatUsersActivity2.participants);
                                ChatUsersActivity.this.updateListAnimated(diffCallbackSaveState);
                            }
                        }
                    });
                    presentFragment(chatUsersActivity);
                    return;
                }
                if (i3 == 1) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("chat_id", this.chatId);
                    bundle2.putInt("type", 2);
                    bundle2.putInt("selectType", 1);
                    ChatUsersActivity chatUsersActivity2 = new ChatUsersActivity(bundle2);
                    chatUsersActivity2.setDelegate(new AnonymousClass8());
                    chatUsersActivity2.setInfo(this.info);
                    presentFragment(chatUsersActivity2);
                    return;
                }
                if (i3 == 2) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putBoolean("addToGroup", true);
                    bundle3.putInt(this.isChannel ? "channelId" : "chatId", this.currentChat.id);
                    GroupCreateActivity groupCreateActivity = new GroupCreateActivity(bundle3);
                    groupCreateActivity.setInfo(this.info);
                    SparseArray<TLObject> sparseArray = this.contactsMap;
                    groupCreateActivity.setIgnoreUsers((sparseArray == null || sparseArray.size() == 0) ? this.participantsMap : this.contactsMap);
                    groupCreateActivity.setDelegate(new GroupCreateActivity.ContactsAddActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.9
                        @Override // org.rbmain.ui.GroupCreateActivity.ContactsAddActivityDelegate
                        public void didSelectUsers(ArrayList<TLRPC$User> arrayList, int i4) {
                            DiffCallback diffCallbackSaveState = ChatUsersActivity.this.saveState();
                            ArrayList arrayList2 = (ChatUsersActivity.this.contactsMap == null || ChatUsersActivity.this.contactsMap.size() == 0) ? ChatUsersActivity.this.participants : ChatUsersActivity.this.contacts;
                            SparseArray sparseArray2 = (ChatUsersActivity.this.contactsMap == null || ChatUsersActivity.this.contactsMap.size() == 0) ? ChatUsersActivity.this.participantsMap : ChatUsersActivity.this.contactsMap;
                            ArrayList<TLRPC$InputUser> arrayList3 = new ArrayList<>();
                            int size = arrayList.size();
                            int i5 = 0;
                            for (int i6 = 0; i6 < size; i6++) {
                                TLRPC$User tLRPC$User = arrayList.get(i6);
                                ChatUsersActivity.this.getMessagesController().putUser(tLRPC$User, false);
                                arrayList3.add(ChatUsersActivity.this.getMessagesController().getInputUser(tLRPC$User));
                                if (sparseArray2.get(tLRPC$User.id) == null) {
                                    if (ChatObject.isChannel(ChatUsersActivity.this.currentChat)) {
                                        TLRPC$TL_channelParticipant tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant();
                                        tLRPC$TL_channelParticipant.inviter_id = ChatUsersActivity.this.getUserConfig().getClientUserId();
                                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                                        tLRPC$TL_channelParticipant.peer = tLRPC$TL_peerUser;
                                        tLRPC$TL_peerUser.user_id = tLRPC$User.id;
                                        tLRPC$TL_channelParticipant.date = ChatUsersActivity.this.getConnectionsManager().getCurrentTime();
                                        arrayList2.add(i5, tLRPC$TL_channelParticipant);
                                        i5++;
                                        sparseArray2.put(tLRPC$User.id, tLRPC$TL_channelParticipant);
                                    } else {
                                        TLRPC$TL_chatParticipant tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                                        tLRPC$TL_chatParticipant.user_id = tLRPC$User.id;
                                        tLRPC$TL_chatParticipant.inviter_id = ChatUsersActivity.this.getUserConfig().getClientUserId();
                                        arrayList2.add(i5, tLRPC$TL_chatParticipant);
                                        i5++;
                                        sparseArray2.put(tLRPC$User.id, tLRPC$TL_chatParticipant);
                                    }
                                }
                            }
                            ChatUsersActivity.this.getMessagesController().addUsersToChannel(ChatUsersActivity.this.chatId, arrayList3, ChatUsersActivity.this);
                            if (arrayList2 == ChatUsersActivity.this.participants) {
                                ChatUsersActivity chatUsersActivity3 = ChatUsersActivity.this;
                                chatUsersActivity3.sortAdmins(chatUsersActivity3.participants);
                            }
                            ChatUsersActivity.this.updateListAnimated(diffCallbackSaveState);
                        }

                        @Override // org.rbmain.ui.GroupCreateActivity.ContactsAddActivityDelegate
                        public void needAddBot(TLRPC$User tLRPC$User) {
                            ChatUsersActivity.this.openRightsEdit(tLRPC$User.id, null, null, null, BuildConfig.FLAVOR, true, 0, false);
                        }
                    });
                    presentFragment(groupCreateActivity);
                    return;
                }
                return;
            }
            if (i == this.recentActionsRow) {
                presentFragment(new ChannelAdminLogActivity(this.currentChat));
                return;
            }
            if (i == this.removedUsersRow) {
                Bundle bundle4 = new Bundle();
                bundle4.putInt("chat_id", this.chatId);
                bundle4.putInt("type", 0);
                ChatUsersActivity chatUsersActivity3 = new ChatUsersActivity(bundle4);
                chatUsersActivity3.setInfo(this.info);
                presentFragment(chatUsersActivity3);
                return;
            }
            if (i == this.gigaConvertRow) {
                showDialog(new AnonymousClass10(getParentActivity(), this));
            } else {
                if (i == this.addNew2Row) {
                    presentFragment(new GroupInviteActivity(this.chatId));
                    return;
                }
                if (i > this.permissionsSectionRow && i <= this.viewAdminsRow) {
                    TextCheckCell2 textCheckCell2 = (TextCheckCell2) view;
                    if (textCheckCell2.isEnabled()) {
                        if (textCheckCell2.hasIcon()) {
                            if (!TextUtils.isEmpty(this.currentChat.username) && (i == this.pinMessagesRow || i == this.changeInfoRow)) {
                                BulletinFactory.of(this).createErrorBulletin(LocaleController.getString("EditCantEditPermissionsPublic", R.string.EditCantEditPermissionsPublic)).show();
                                return;
                            } else {
                                BulletinFactory.of(this).createErrorBulletin(LocaleController.getString("EditCantEditPermissions", R.string.EditCantEditPermissions)).show();
                                return;
                            }
                        }
                        textCheckCell2.setChecked(!textCheckCell2.isChecked());
                        if (i == this.changeInfoRow) {
                            this.defaultBannedRights.change_info = !r0.change_info;
                            return;
                        }
                        if (i == this.addUsersRow) {
                            if (textCheckCell2.isChecked()) {
                                this.defaultBannedRights.view_members = false;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.viewMembersRow);
                                if (viewHolderFindViewHolderForAdapterPosition != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition.itemView).setChecked(true);
                                }
                            }
                            this.defaultBannedRights.invite_users = !r0.invite_users;
                            return;
                        }
                        if (i == this.viewMembersRow) {
                            if (!textCheckCell2.isChecked()) {
                                this.defaultBannedRights.invite_users = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(this.addUsersRow);
                                if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition2.itemView).setChecked(false);
                                }
                            }
                            this.defaultBannedRights.view_members = !r0.view_members;
                            return;
                        }
                        if (i == this.viewAdminsRow) {
                            this.defaultBannedRights.view_admins = !r0.view_admins;
                            return;
                        }
                        if (i == this.pinMessagesRow) {
                            this.defaultBannedRights.pin_messages = !r0.pin_messages;
                            return;
                        }
                        boolean z4 = !textCheckCell2.isChecked();
                        int i4 = this.sendMessagesRow;
                        if (i == i4) {
                            this.defaultBannedRights.send_messages = !r0.send_messages;
                        } else if (i == this.sendMediaRow) {
                            this.defaultBannedRights.send_media = !r0.send_media;
                        } else if (i == this.sendStickersRow) {
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights3 = this.defaultBannedRights;
                            boolean z5 = !tLRPC$TL_chatBannedRights3.send_stickers;
                            tLRPC$TL_chatBannedRights3.send_inline = z5;
                            tLRPC$TL_chatBannedRights3.send_gifs = z5;
                            tLRPC$TL_chatBannedRights3.send_games = z5;
                            tLRPC$TL_chatBannedRights3.send_stickers = z5;
                        } else if (i == this.embedLinksRow) {
                            this.defaultBannedRights.embed_links = !r0.embed_links;
                        } else if (i == this.sendPollsRow) {
                            this.defaultBannedRights.send_polls = !r0.send_polls;
                        }
                        if (z4) {
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights4 = this.defaultBannedRights;
                            if (tLRPC$TL_chatBannedRights4.view_messages && !tLRPC$TL_chatBannedRights4.send_messages) {
                                tLRPC$TL_chatBannedRights4.send_messages = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition3 = this.listView.findViewHolderForAdapterPosition(i4);
                                if (viewHolderFindViewHolderForAdapterPosition3 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition3.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights5 = this.defaultBannedRights;
                            if ((tLRPC$TL_chatBannedRights5.view_messages || tLRPC$TL_chatBannedRights5.send_messages) && !tLRPC$TL_chatBannedRights5.send_media) {
                                tLRPC$TL_chatBannedRights5.send_media = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition4 = this.listView.findViewHolderForAdapterPosition(this.sendMediaRow);
                                if (viewHolderFindViewHolderForAdapterPosition4 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition4.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights6 = this.defaultBannedRights;
                            if ((tLRPC$TL_chatBannedRights6.view_messages || tLRPC$TL_chatBannedRights6.send_messages) && !tLRPC$TL_chatBannedRights6.send_polls) {
                                tLRPC$TL_chatBannedRights6.send_polls = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition5 = this.listView.findViewHolderForAdapterPosition(this.sendPollsRow);
                                if (viewHolderFindViewHolderForAdapterPosition5 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition5.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights7 = this.defaultBannedRights;
                            if ((tLRPC$TL_chatBannedRights7.view_messages || tLRPC$TL_chatBannedRights7.send_messages) && !tLRPC$TL_chatBannedRights7.send_stickers) {
                                tLRPC$TL_chatBannedRights7.send_inline = true;
                                tLRPC$TL_chatBannedRights7.send_gifs = true;
                                tLRPC$TL_chatBannedRights7.send_games = true;
                                tLRPC$TL_chatBannedRights7.send_stickers = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition6 = this.listView.findViewHolderForAdapterPosition(this.sendStickersRow);
                                if (viewHolderFindViewHolderForAdapterPosition6 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition6.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights8 = this.defaultBannedRights;
                            if ((tLRPC$TL_chatBannedRights8.view_messages || tLRPC$TL_chatBannedRights8.send_messages) && !tLRPC$TL_chatBannedRights8.embed_links) {
                                tLRPC$TL_chatBannedRights8.embed_links = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition7 = this.listView.findViewHolderForAdapterPosition(this.embedLinksRow);
                                if (viewHolderFindViewHolderForAdapterPosition7 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition7.itemView).setChecked(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights9 = this.defaultBannedRights;
                        if (!(tLRPC$TL_chatBannedRights9.embed_links && tLRPC$TL_chatBannedRights9.send_inline && tLRPC$TL_chatBannedRights9.send_media && tLRPC$TL_chatBannedRights9.send_polls) && tLRPC$TL_chatBannedRights9.send_messages) {
                            tLRPC$TL_chatBannedRights9.send_messages = false;
                            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition8 = this.listView.findViewHolderForAdapterPosition(i4);
                            if (viewHolderFindViewHolderForAdapterPosition8 != null) {
                                ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition8.itemView).setChecked(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        if (z3) {
            TLObject item = this.listViewAdapter.getItem(i);
            if (item instanceof TLRPC$ChannelParticipant) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) item;
                peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
                tLRPC$TL_chatBannedRights = tLRPC$ChannelParticipant.banned_rights;
                tLRPC$TL_chatAdminRights = tLRPC$ChannelParticipant.admin_rights;
                str = tLRPC$ChannelParticipant.rank;
                HashSet<Chat.ChatAccessEnum> hashSet = this.currentChat.accessEnumHashSet;
                boolean z6 = hashSet != null && (hashSet.contains(Chat.ChatAccessEnum.SuperAdmin) || tLRPC$ChannelParticipant.can_edit || this.currentChat.accessEnumHashSet.contains(Chat.ChatAccessEnum.SetAdmin));
                if ((item instanceof TLRPC$TL_channelParticipantCreator) && (tLRPC$TL_chatAdminRights = ((TLRPC$TL_channelParticipantCreator) item).admin_rights) == null) {
                    tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
                    tLRPC$TL_chatAdminRights.add_admins = true;
                    tLRPC$TL_chatAdminRights.pin_messages = true;
                    tLRPC$TL_chatAdminRights.invite_users = true;
                    tLRPC$TL_chatAdminRights.ban_users = true;
                    tLRPC$TL_chatAdminRights.delete_messages = true;
                    tLRPC$TL_chatAdminRights.edit_messages = true;
                    tLRPC$TL_chatAdminRights.post_messages = true;
                    tLRPC$TL_chatAdminRights.change_info = true;
                    if (!this.isChannel) {
                        tLRPC$TL_chatAdminRights.manage_call = true;
                    }
                }
                tLObject = item;
                z = z6;
            } else if (item instanceof TLRPC$ChatParticipant) {
                int i5 = ((TLRPC$ChatParticipant) item).user_id;
                boolean z7 = this.currentChat.creator;
                if (item instanceof TLRPC$TL_chatParticipantCreator) {
                    tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
                    tLRPC$TL_chatAdminRights.add_admins = true;
                    tLRPC$TL_chatAdminRights.pin_messages = true;
                    tLRPC$TL_chatAdminRights.invite_users = true;
                    tLRPC$TL_chatAdminRights.ban_users = true;
                    tLRPC$TL_chatAdminRights.delete_messages = true;
                    tLRPC$TL_chatAdminRights.edit_messages = true;
                    tLRPC$TL_chatAdminRights.post_messages = true;
                    tLRPC$TL_chatAdminRights.change_info = true;
                    if (!this.isChannel) {
                        tLRPC$TL_chatAdminRights.manage_call = true;
                    }
                } else {
                    tLRPC$TL_chatAdminRights = null;
                }
                tLObject = item;
                str = BuildConfig.FLAVOR;
                z = z7;
                peerId = i5;
                tLRPC$TL_chatBannedRights = null;
            } else {
                tLObject = item;
                str = BuildConfig.FLAVOR;
                tLRPC$TL_chatBannedRights = null;
                tLRPC$TL_chatAdminRights = null;
                peerId = 0;
                z = false;
            }
        } else {
            TLObject item2 = this.searchListViewAdapter.getItem(i);
            if (item2 instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) item2;
                getMessagesController().putUser(tLRPC$User, false);
                int i6 = tLRPC$User.id;
                i2 = i6;
                item2 = getAnyParticipant(i6);
            } else {
                if (!(item2 instanceof TLRPC$ChannelParticipant) && !(item2 instanceof TLRPC$ChatParticipant)) {
                    item2 = null;
                }
                i2 = 0;
            }
            if (item2 instanceof TLRPC$ChannelParticipant) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant2 = (TLRPC$ChannelParticipant) item2;
                peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant2.peer);
                tLObject = item2;
                z = !((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin) || (tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantCreator)) || tLRPC$ChannelParticipant2.can_edit;
                tLRPC$TL_chatBannedRights = tLRPC$ChannelParticipant2.banned_rights;
                tLRPC$TL_chatAdminRights = tLRPC$ChannelParticipant2.admin_rights;
                str = tLRPC$ChannelParticipant2.rank;
            } else if (item2 instanceof TLRPC$ChatParticipant) {
                int i7 = ((TLRPC$ChatParticipant) item2).user_id;
                boolean z8 = this.currentChat.creator;
                tLObject = item2;
                str = BuildConfig.FLAVOR;
                tLRPC$TL_chatAdminRights = null;
                z = z8;
                peerId = i7;
                tLRPC$TL_chatBannedRights = null;
            } else {
                tLObject = item2;
                str = BuildConfig.FLAVOR;
                tLRPC$TL_chatBannedRights = null;
                tLRPC$TL_chatAdminRights = null;
                z = item2 == null;
                peerId = i2;
            }
        }
        if (peerId != 0) {
            int i8 = this.selectType;
            if (i8 != 0) {
                if (i8 == 3 || i8 == 1) {
                    if (i8 != 1 && z && ((tLObject instanceof TLRPC$TL_channelParticipantAdmin) || (tLObject instanceof TLRPC$TL_chatParticipantAdmin))) {
                        final TLRPC$User user = getMessagesController().getUser(Integer.valueOf(peerId));
                        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder.setMessage(LocaleController.formatString("AdminWillBeRemoved", R.string.AdminWillBeRemoved, UserObject.getUserName(user)));
                        final TLObject tLObject2 = tLObject;
                        final TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2 = tLRPC$TL_chatAdminRights;
                        final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights10 = tLRPC$TL_chatBannedRights;
                        final String str2 = str;
                        final boolean z9 = z;
                        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda7
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i9) {
                                this.f$0.lambda$createView$0(user, tLObject2, tLRPC$TL_chatAdminRights2, tLRPC$TL_chatBannedRights10, str2, z9, dialogInterface, i9);
                            }
                        });
                        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                        showDialog(builder.create());
                        return;
                    }
                    openRightsEdit(peerId, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, i8 == 1 ? 0 : 1, i8 == 1 || i8 == 3);
                    return;
                }
                removeParticipant(peerId);
                return;
            }
            int i9 = this.type;
            if (i9 == 1) {
                if (peerId != getUserConfig().getClientUserId() && (this.currentChat.accessEnumHashSet.contains(Chat.ChatAccessEnum.SuperAdmin) || z)) {
                    z2 = true;
                }
                zCanBlockUsers = z2;
            } else {
                zCanBlockUsers = (i9 == 0 || i9 == 3) ? ChatObject.canBlockUsers(this.currentChat) : false;
            }
            int i10 = this.type;
            if (i10 == 0 || ((i10 != 1 && this.isChannel) || (i10 == 2 && this.selectType == 0))) {
                if (peerId == getUserConfig().getClientUserId()) {
                    return;
                }
                Bundle bundle5 = new Bundle();
                if (peerId > 0) {
                    bundle5.putInt("user_id", peerId);
                } else {
                    bundle5.putInt("chat_id", -peerId);
                }
                presentFragment(new ProfileActivity(bundle5));
                return;
            }
            if (tLRPC$TL_chatBannedRights == null) {
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights11 = new TLRPC$TL_chatBannedRights();
                tLRPC$TL_chatBannedRights11.view_messages = true;
                tLRPC$TL_chatBannedRights11.send_stickers = true;
                tLRPC$TL_chatBannedRights11.send_media = true;
                tLRPC$TL_chatBannedRights11.embed_links = true;
                tLRPC$TL_chatBannedRights11.send_messages = true;
                tLRPC$TL_chatBannedRights11.send_games = true;
                tLRPC$TL_chatBannedRights11.send_inline = true;
                tLRPC$TL_chatBannedRights11.send_gifs = true;
                tLRPC$TL_chatBannedRights11.pin_messages = true;
                tLRPC$TL_chatBannedRights11.send_polls = true;
                tLRPC$TL_chatBannedRights11.invite_users = true;
                tLRPC$TL_chatBannedRights11.change_info = true;
                tLRPC$TL_chatBannedRights2 = tLRPC$TL_chatBannedRights11;
            } else {
                tLRPC$TL_chatBannedRights2 = tLRPC$TL_chatBannedRights;
            }
            this.progressDialog = new AlertDialog(getParentActivity(), 3);
            final int i11 = peerId;
            final String str3 = str;
            final boolean z10 = zCanBlockUsers;
            final TLObject tLObject3 = tLObject;
            getDialogsProxy().loadAdminRights(this.chatId, peerId, new RequestDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda22
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject4, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$2(i11, tLRPC$TL_chatBannedRights2, str3, z10, tLObject3, tLObject4, tLRPC$TL_error);
                }
            });
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$createView$3(dialogInterface);
                }
            });
            this.progressDialog.show();
        }
    }

    /* renamed from: org.rbmain.ui.ChatUsersActivity$8, reason: invalid class name */
    class AnonymousClass8 implements ChatUsersActivityDelegate {
        @Override // org.rbmain.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public /* synthetic */ void didKickParticipant(int i) {
            ChatUsersActivityDelegate.CC.$default$didKickParticipant(this, i);
        }

        AnonymousClass8() {
        }

        @Override // org.rbmain.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public void didAddParticipantToList(int i, TLObject tLObject) {
            if (tLObject == null || ChatUsersActivity.this.participantsMap.get(i) != null) {
                return;
            }
            DiffCallback diffCallbackSaveState = ChatUsersActivity.this.saveState();
            ChatUsersActivity.this.participants.add(tLObject);
            ChatUsersActivity.this.participantsMap.put(i, tLObject);
            ChatUsersActivity chatUsersActivity = ChatUsersActivity.this;
            chatUsersActivity.sortAdmins(chatUsersActivity.participants);
            ChatUsersActivity.this.updateListAnimated(diffCallbackSaveState);
        }

        @Override // org.rbmain.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public void didSelectUser(int i) {
            final TLRPC$User user = ChatUsersActivity.this.getMessagesController().getUser(Integer.valueOf(i));
            if (user != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$8$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didSelectUser$0(user);
                    }
                }, 200L);
            }
            if (ChatUsersActivity.this.participantsMap.get(i) == null) {
                DiffCallback diffCallbackSaveState = ChatUsersActivity.this.saveState();
                TLRPC$TL_channelParticipantAdmin tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_channelParticipantAdmin.peer = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = user.id;
                tLRPC$TL_channelParticipantAdmin.date = ChatUsersActivity.this.getConnectionsManager().getCurrentTime();
                tLRPC$TL_channelParticipantAdmin.promoted_by = ChatUsersActivity.this.getAccountInstance().getUserConfig().clientUserId;
                ChatUsersActivity.this.participants.add(tLRPC$TL_channelParticipantAdmin);
                ChatUsersActivity.this.participantsMap.put(user.id, tLRPC$TL_channelParticipantAdmin);
                ChatUsersActivity chatUsersActivity = ChatUsersActivity.this;
                chatUsersActivity.sortAdmins(chatUsersActivity.participants);
                ChatUsersActivity.this.updateListAnimated(diffCallbackSaveState);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didSelectUser$0(TLRPC$User tLRPC$User) {
            if (BulletinFactory.canShowBulletin(ChatUsersActivity.this)) {
                BulletinFactory.createPromoteToAdminBulletin(ChatUsersActivity.this, tLRPC$User.first_name).show();
            }
        }
    }

    /* renamed from: org.rbmain.ui.ChatUsersActivity$10, reason: invalid class name */
    class AnonymousClass10 extends GigagroupConvertAlert {
        @Override // org.rbmain.ui.Components.GigagroupConvertAlert
        protected void onCancel() {
        }

        AnonymousClass10(Context context, BaseFragment baseFragment) {
            super(context, baseFragment);
        }

        @Override // org.rbmain.ui.Components.GigagroupConvertAlert
        protected void onCovert() {
            ChatUsersActivity.this.getMessagesController().convertToGigaGroup(ChatUsersActivity.this.getParentActivity(), ChatUsersActivity.this.currentChat, ChatUsersActivity.this, new MessagesStorage.BooleanCallback() { // from class: org.rbmain.ui.ChatUsersActivity$10$$ExternalSyntheticLambda0
                @Override // org.rbmain.messenger.MessagesStorage.BooleanCallback
                public final void run(boolean z) {
                    this.f$0.lambda$onCovert$0(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCovert$0(boolean z) {
            if (!z || ((BaseFragment) ChatUsersActivity.this).parentLayout == null) {
                return;
            }
            BaseFragment baseFragment = ((BaseFragment) ChatUsersActivity.this).parentLayout.fragmentsStack.get(((BaseFragment) ChatUsersActivity.this).parentLayout.fragmentsStack.size() - 2);
            if (baseFragment instanceof ChatEditActivity) {
                baseFragment.removeSelfFromStack();
                Bundle bundle = new Bundle();
                bundle.putInt("chat_id", ChatUsersActivity.this.chatId);
                ChatEditActivity chatEditActivity = new ChatEditActivity(bundle);
                chatEditActivity.setInfo(ChatUsersActivity.this.info);
                ((BaseFragment) ChatUsersActivity.this).parentLayout.addFragmentToStack(chatEditActivity, ((BaseFragment) ChatUsersActivity.this).parentLayout.fragmentsStack.size() - 1);
                ChatUsersActivity.this.finishFragment();
                chatEditActivity.showConvertTooltip();
                return;
            }
            ChatUsersActivity.this.finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, DialogInterface dialogInterface, int i) {
        openRightsEdit(tLRPC$User.id, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, this.selectType == 1 ? 0 : 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(final int i, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, final boolean z, final TLObject tLObject, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1(tLRPC$TL_error, i, tLObject2, tLRPC$TL_chatBannedRights, str, z, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(TLRPC$TL_error tLRPC$TL_error, int i, TLObject tLObject, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, final TLObject tLObject2) {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (tLRPC$TL_error == null) {
            ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(i, this.chatId, (TLRPC$TL_chatAdminRights) tLObject, this.defaultBannedRights, tLRPC$TL_chatBannedRights, str, this.type == 1 ? 0 : 1, z, tLObject2 == null);
            chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.11
                @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                public void didSetRights(int i2, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str2) {
                    TLObject tLObject3 = tLObject2;
                    if (tLObject3 instanceof TLRPC$ChannelParticipant) {
                        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject3;
                        tLRPC$ChannelParticipant.admin_rights = tLRPC$TL_chatAdminRights;
                        tLRPC$ChannelParticipant.banned_rights = tLRPC$TL_chatBannedRights2;
                        tLRPC$ChannelParticipant.rank = str2;
                        ChatUsersActivity.this.updateParticipantWithRights(tLRPC$ChannelParticipant, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights2, 0, false);
                    }
                }
            });
            presentFragment(chatRightsEditActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(DialogInterface dialogInterface) {
        this.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$5(View view, int i) {
        if (getParentActivity() == null) {
            return false;
        }
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ListAdapter listAdapter = this.listViewAdapter;
        return adapter == listAdapter && createMenuForParticipant(listAdapter.getItem(i), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortAdmins(ArrayList<TLObject> arrayList) {
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda16
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$sortAdmins$6((TLObject) obj, (TLObject) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$sortAdmins$6(TLObject tLObject, TLObject tLObject2) {
        int channelAdminParticipantType = getChannelAdminParticipantType(tLObject);
        int channelAdminParticipantType2 = getChannelAdminParticipantType(tLObject2);
        if (channelAdminParticipantType > channelAdminParticipantType2) {
            return 1;
        }
        if (channelAdminParticipantType < channelAdminParticipantType2) {
            return -1;
        }
        if ((tLObject instanceof TLRPC$ChannelParticipant) && (tLObject2 instanceof TLRPC$ChannelParticipant)) {
            return MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer) - MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject2).peer);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showItemsAnimated(final int i) {
        if (this.isPaused || !this.openTransitionStarted) {
            return;
        }
        if (this.listView.getAdapter() == this.listViewAdapter && this.firstLoaded) {
            return;
        }
        final View view = null;
        for (int i2 = 0; i2 < this.listView.getChildCount(); i2++) {
            View childAt = this.listView.getChildAt(i2);
            if (childAt instanceof FlickerLoadingView) {
                view = childAt;
            }
        }
        if (view != null) {
            this.listView.removeView(view);
            i--;
        }
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.ChatUsersActivity.14
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ChatUsersActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = ChatUsersActivity.this.listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = ChatUsersActivity.this.listView.getChildAt(i3);
                    if (childAt2 != view && ChatUsersActivity.this.listView.getChildAdapterPosition(childAt2) >= i) {
                        childAt2.setAlpha(0.0f);
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        objectAnimatorOfFloat.setStartDelay((int) ((Math.min(ChatUsersActivity.this.listView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / ChatUsersActivity.this.listView.getMeasuredHeight()) * 100.0f));
                        objectAnimatorOfFloat.setDuration(200L);
                        animatorSet.playTogether(objectAnimatorOfFloat);
                    }
                }
                View view2 = view;
                if (view2 != null && view2.getParent() == null) {
                    ChatUsersActivity.this.listView.addView(view);
                    final RecyclerView.LayoutManager layoutManager = ChatUsersActivity.this.listView.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.ignoreView(view);
                        View view3 = view;
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, view3.getAlpha(), 0.0f);
                        objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ChatUsersActivity.14.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                view.setAlpha(1.0f);
                                layoutManager.stopIgnoringView(view);
                                ChatUsersActivity.this.listView.removeView(view);
                            }
                        });
                        objectAnimatorOfFloat2.start();
                    }
                }
                animatorSet.start();
                return true;
            }
        });
    }

    private void openRightsEdit2(final int i, final int i2, final TLObject tLObject, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, boolean z, final int i3, boolean z2) {
        this.progressDialog = new AlertDialog(getParentActivity(), 3);
        getDialogsProxy().loadAdminRights(this.chatId, i, new RequestDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda23
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$openRightsEdit2$9(tLObject, i, tLRPC$TL_chatBannedRights, str, i3, i2, tLObject2, tLRPC$TL_error);
            }
        });
        this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$openRightsEdit2$10(dialogInterface);
            }
        });
        this.progressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openRightsEdit2$9(final TLObject tLObject, final int i, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, final int i2, final int i3, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openRightsEdit2$8(tLRPC$TL_error, tLObject, i, tLObject2, tLRPC$TL_chatBannedRights, str, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openRightsEdit2$8(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, final int i, TLObject tLObject2, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, final int i2, final int i3) {
        this.progressDialog.dismiss();
        if (tLRPC$TL_error == null) {
            final boolean[] zArr = new boolean[1];
            boolean z = (tLObject instanceof TLRPC$TL_channelParticipantAdmin) || (tLObject instanceof TLRPC$TL_chatParticipantAdmin);
            ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(i, this.chatId, (TLRPC$TL_chatAdminRights) tLObject2, this.defaultBannedRights, tLRPC$TL_chatBannedRights, str, i2, true, false) { // from class: org.rbmain.ui.ChatUsersActivity.15
                @Override // org.rbmain.ui.ActionBar.BaseFragment
                protected void onTransitionAnimationEnd(boolean z2, boolean z3) {
                    if (!z2 && z3 && zArr[0] && BulletinFactory.canShowBulletin(ChatUsersActivity.this)) {
                        if (i > 0) {
                            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(i));
                            if (user != null) {
                                BulletinFactory.createPromoteToAdminBulletin(ChatUsersActivity.this, user.first_name).show();
                                return;
                            }
                            return;
                        }
                        TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(-i));
                        if (chat != null) {
                            BulletinFactory.createPromoteToAdminBulletin(ChatUsersActivity.this, chat.title).show();
                        }
                    }
                }
            };
            final boolean z2 = z;
            chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.16
                @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                public void didSetRights(int i4, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str2) {
                    TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
                    TLRPC$ChannelParticipant tLRPC$TL_channelParticipant;
                    int i5 = i2;
                    if (i5 != 0) {
                        if (i5 == 1 && i4 == 0) {
                            ChatUsersActivity.this.removeParticipants(i);
                            return;
                        }
                        return;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= ChatUsersActivity.this.participants.size()) {
                            break;
                        }
                        TLObject tLObject3 = (TLObject) ChatUsersActivity.this.participants.get(i6);
                        if (tLObject3 instanceof TLRPC$ChannelParticipant) {
                            if (MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject3).peer) == i) {
                                if (i4 == 1) {
                                    tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin();
                                } else {
                                    tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant();
                                }
                                tLRPC$TL_channelParticipant.admin_rights = tLRPC$TL_chatAdminRights;
                                tLRPC$TL_channelParticipant.banned_rights = tLRPC$TL_chatBannedRights2;
                                tLRPC$TL_channelParticipant.inviter_id = ChatUsersActivity.this.getUserConfig().getClientUserId();
                                if (i > 0) {
                                    TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                                    tLRPC$TL_channelParticipant.peer = tLRPC$TL_peerUser;
                                    tLRPC$TL_peerUser.user_id = i;
                                } else {
                                    TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                                    tLRPC$TL_channelParticipant.peer = tLRPC$TL_peerChannel;
                                    tLRPC$TL_peerChannel.channel_id = -i;
                                }
                                tLRPC$TL_channelParticipant.date = i3;
                                tLRPC$TL_channelParticipant.flags |= 4;
                                tLRPC$TL_channelParticipant.rank = str2;
                                ChatUsersActivity.this.participants.set(i6, tLRPC$TL_channelParticipant);
                                ChatUsersActivity.this.participantsMap.put(i, tLRPC$TL_channelParticipant);
                            }
                        } else if (tLObject3 instanceof TLRPC$ChatParticipant) {
                            TLRPC$ChatParticipant tLRPC$ChatParticipant = (TLRPC$ChatParticipant) tLObject3;
                            if (i4 == 1) {
                                tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipantAdmin();
                            } else {
                                tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                            }
                            tLRPC$TL_chatParticipant.user_id = tLRPC$ChatParticipant.user_id;
                            tLRPC$TL_chatParticipant.date = tLRPC$ChatParticipant.date;
                            tLRPC$TL_chatParticipant.inviter_id = tLRPC$ChatParticipant.inviter_id;
                            int iIndexOf = ChatUsersActivity.this.info.participants.participants.indexOf(tLRPC$ChatParticipant);
                            if (iIndexOf >= 0) {
                                ChatUsersActivity.this.info.participants.participants.set(iIndexOf, tLRPC$TL_chatParticipant);
                            }
                            ChatUsersActivity.this.loadChatParticipants(0, 200);
                        }
                        i6++;
                    }
                    if (i4 != 1 || z2) {
                        return;
                    }
                    zArr[0] = true;
                }
            });
            presentFragment(chatRightsEditActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openRightsEdit2$10(DialogInterface dialogInterface) {
        this.progressDialog = null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean canBeginSlide() {
        return checkDiscard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openRightsEdit(final int i, final TLObject tLObject, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, int i2, final boolean z2) {
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(i, this.chatId, tLRPC$TL_chatAdminRights, this.defaultBannedRights, tLRPC$TL_chatBannedRights, str, i2, z, tLObject == null);
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.17
            @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int i3, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str2) {
                TLObject tLObject2 = tLObject;
                if (tLObject2 instanceof TLRPC$ChannelParticipant) {
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject2;
                    tLRPC$ChannelParticipant.admin_rights = tLRPC$TL_chatAdminRights2;
                    tLRPC$ChannelParticipant.banned_rights = tLRPC$TL_chatBannedRights2;
                    tLRPC$ChannelParticipant.rank = str2;
                }
                if (ChatUsersActivity.this.delegate == null || i3 != 1) {
                    if (ChatUsersActivity.this.delegate != null) {
                        ChatUsersActivity.this.delegate.didAddParticipantToList(i, tLObject);
                    }
                } else {
                    ChatUsersActivity.this.delegate.didSelectUser(i);
                }
                if (z2) {
                    ChatUsersActivity.this.removeSelfFromStack();
                }
            }
        });
        presentFragment(chatRightsEditActivity, z2);
    }

    private void removeParticipant(int i) {
        if (ChatObject.isChannel(this.currentChat)) {
            getMessagesController().deleteParticipantFromChat(this.chatId, getMessagesController().getUser(Integer.valueOf(i)), null);
            ChatUsersActivityDelegate chatUsersActivityDelegate = this.delegate;
            if (chatUsersActivityDelegate != null) {
                chatUsersActivityDelegate.didKickParticipant(i);
            }
            finishFragment();
        }
    }

    private TLObject getAnyParticipant(int i) {
        SparseArray<TLObject> sparseArray;
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 == 0) {
                sparseArray = this.contactsMap;
            } else if (i2 == 1) {
                sparseArray = this.botsMap;
            } else {
                sparseArray = this.participantsMap;
            }
            TLObject tLObject = sparseArray.get(i);
            if (tLObject != null) {
                return tLObject;
            }
        }
        return null;
    }

    private void removeParticipants(TLObject tLObject) {
        if (tLObject instanceof TLRPC$ChatParticipant) {
            removeParticipants(((TLRPC$ChatParticipant) tLObject).user_id);
        } else if (tLObject instanceof TLRPC$ChannelParticipant) {
            removeParticipants(MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParticipants(int i) {
        SparseArray<TLObject> sparseArray;
        ArrayList<TLObject> arrayList;
        DiffCallback diffCallbackSaveState = saveState();
        boolean z = false;
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 == 0) {
                sparseArray = this.contactsMap;
                arrayList = this.contacts;
            } else if (i2 == 1) {
                sparseArray = this.botsMap;
                arrayList = this.bots;
            } else {
                sparseArray = this.participantsMap;
                arrayList = this.participants;
            }
            TLObject tLObject = sparseArray.get(i);
            if (tLObject != null) {
                sparseArray.remove(i);
                arrayList.remove(tLObject);
                if (this.type == 0) {
                    this.info.kicked_count--;
                }
                z = true;
            }
        }
        if (z) {
            updateListAnimated(diffCallbackSaveState);
        }
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchListViewAdapter;
        if (adapter == searchAdapter) {
            searchAdapter.removeUserId(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParticipantWithRights(TLRPC$ChannelParticipant tLRPC$ChannelParticipant, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, int i, boolean z) {
        SparseArray<TLObject> sparseArray;
        ChatUsersActivityDelegate chatUsersActivityDelegate;
        boolean z2 = false;
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 == 0) {
                sparseArray = this.contactsMap;
            } else if (i2 == 1) {
                sparseArray = this.botsMap;
            } else {
                sparseArray = this.participantsMap;
            }
            TLObject tLObject = sparseArray.get(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer));
            if (tLObject instanceof TLRPC$ChannelParticipant) {
                tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject;
                tLRPC$ChannelParticipant.admin_rights = tLRPC$TL_chatAdminRights;
                tLRPC$ChannelParticipant.banned_rights = tLRPC$TL_chatBannedRights;
                if (z) {
                    tLRPC$ChannelParticipant.promoted_by = getUserConfig().getClientUserId();
                }
            }
            if (z && tLObject != null && !z2 && (chatUsersActivityDelegate = this.delegate) != null) {
                chatUsersActivityDelegate.didAddParticipantToList(i, tLObject);
                z2 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:134:0x026f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean createMenuForParticipant(final org.rbmain.tgnet.TLObject r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatUsersActivity.createMenuForParticipant(org.rbmain.tgnet.TLObject, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$12(final ArrayList arrayList, TLRPC$User tLRPC$User, final int i, final boolean z, final TLObject tLObject, final int i2, final TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, DialogInterface dialogInterface, final int i3) {
        if (((Integer) arrayList.get(i3)).intValue() == 2) {
            getMessagesController().deleteParticipantFromChat(this.chatId, tLRPC$User, null);
            removeParticipants(i);
            if (this.currentChat == null || tLRPC$User == null || !BulletinFactory.canShowBulletin(this)) {
                return;
            }
            BulletinFactory.createRemoveFromChatBulletin(this, tLRPC$User, this.currentChat.title).show();
            return;
        }
        if (((Integer) arrayList.get(i3)).intValue() == 1 && z && ((tLObject instanceof TLRPC$TL_channelParticipantAdmin) || (tLObject instanceof TLRPC$TL_chatParticipantAdmin))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.formatString("AdminWillBeRemoved", R.string.AdminWillBeRemoved, UserObject.getUserName(tLRPC$User)));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i4) {
                    this.f$0.lambda$createMenuForParticipant$11(i, i2, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, arrayList, i3, dialogInterface2, i4);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        openRightsEdit2(i, i2, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, ((Integer) arrayList.get(i3)).intValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$11(int i, int i2, TLObject tLObject, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, ArrayList arrayList, int i3, DialogInterface dialogInterface, int i4) {
        openRightsEdit2(i, i2, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, ((Integer) arrayList.get(i3)).intValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$18(CharSequence[] charSequenceArr, final int i, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, final boolean z, final TLObject tLObject, DialogInterface dialogInterface, int i2) {
        int i3;
        TLRPC$Chat chat;
        int i4 = this.type;
        if (i4 == 1) {
            if (i2 == 0 && charSequenceArr.length == 2) {
                this.progressDialog = new AlertDialog(getParentActivity(), 3);
                getDialogsProxy().loadAdminRights(this.chatId, i, new RequestDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda21
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$createMenuForParticipant$14(i, tLRPC$TL_chatBannedRights, str, z, tLObject, tLObject2, tLRPC$TL_error);
                    }
                });
                this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface2) {
                        this.f$0.lambda$createMenuForParticipant$15(dialogInterface2);
                    }
                });
                this.progressDialog.show();
                return;
            }
            getMessagesController().setUserAdminRole(this.chatId, getMessagesController().getUser(Integer.valueOf(i)), new TLRPC$TL_chatAdminRights(), BuildConfig.FLAVOR, !this.isChannel, this, false, true);
            removeParticipants(i);
            return;
        }
        if (i4 != 0 && i4 != 3) {
            if (i2 == 0) {
                TLRPC$User user = null;
                if (i > 0) {
                    chat = null;
                    user = getMessagesController().getUser(Integer.valueOf(i));
                } else {
                    chat = getMessagesController().getChat(Integer.valueOf(-i));
                }
                getMessagesController().deleteParticipantFromChat(this.chatId, user, chat, null, false, false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            if (i4 == 3) {
                ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(i, this.chatId, null, this.defaultBannedRights, tLRPC$TL_chatBannedRights, str, 1, true, false);
                chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.19
                    @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                    public void didSetRights(int i5, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str2) {
                        TLObject tLObject2 = tLObject;
                        if (tLObject2 instanceof TLRPC$ChannelParticipant) {
                            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject2;
                            tLRPC$ChannelParticipant.admin_rights = tLRPC$TL_chatAdminRights;
                            tLRPC$ChannelParticipant.banned_rights = tLRPC$TL_chatBannedRights2;
                            tLRPC$ChannelParticipant.rank = str2;
                            ChatUsersActivity.this.updateParticipantWithRights(tLRPC$ChannelParticipant, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights2, 0, false);
                        }
                    }
                });
                presentFragment(chatRightsEditActivity);
            } else if (i4 == 0 && i > 0) {
                i3 = 1;
                getMessagesController().addUserToChat(this.chatId, getMessagesController().getUser(Integer.valueOf(i)), 0, null, this, null);
            }
            i3 = 1;
        } else {
            i3 = 1;
            if (i2 == 1) {
                TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned = new TLRPC$TL_channels_editBanned();
                tLRPC$TL_channels_editBanned.participant = getMessagesController().getInputPeer(i);
                tLRPC$TL_channels_editBanned.channel = getMessagesController().getInputChannel(this.chatId);
                tLRPC$TL_channels_editBanned.banned_rights = new TLRPC$TL_chatBannedRights();
                getDialogsProxy().removeMemberFromBanList(tLRPC$TL_channels_editBanned, new RequestDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda20
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$createMenuForParticipant$17(tLObject2, tLRPC$TL_error);
                    }
                });
            }
        }
        if ((i2 == 0 && this.type == 0) || i2 == i3) {
            removeParticipants(tLObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$14(final int i, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, final boolean z, final TLObject tLObject, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createMenuForParticipant$13(tLRPC$TL_error, i, tLObject2, tLRPC$TL_chatBannedRights, str, z, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$13(TLRPC$TL_error tLRPC$TL_error, int i, TLObject tLObject, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, final TLObject tLObject2) {
        this.progressDialog.dismiss();
        if (tLRPC$TL_error == null) {
            ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(i, this.chatId, (TLRPC$TL_chatAdminRights) tLObject, this.defaultBannedRights, tLRPC$TL_chatBannedRights, str, this.type == 1 ? 0 : 1, z, tLObject2 == null);
            chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ChatUsersActivity.18
                @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                public void didSetRights(int i2, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str2) {
                    TLObject tLObject3 = tLObject2;
                    if (tLObject3 instanceof TLRPC$ChannelParticipant) {
                        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject3;
                        tLRPC$ChannelParticipant.admin_rights = tLRPC$TL_chatAdminRights;
                        tLRPC$ChannelParticipant.banned_rights = tLRPC$TL_chatBannedRights2;
                        tLRPC$ChannelParticipant.rank = str2;
                        ChatUsersActivity.this.updateParticipantWithRights(tLRPC$ChannelParticipant, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights2, 0, false);
                    }
                }
            });
            presentFragment(chatRightsEditActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$15(DialogInterface dialogInterface) {
        this.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$17(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            getMessagesController().processUpdates(tLRPC$Updates, false);
            if (tLRPC$Updates.chats.isEmpty()) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createMenuForParticipant$16(tLRPC$Updates);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenuForParticipant$16(TLRPC$Updates tLRPC$Updates) {
        getMessagesController().loadFullChat(tLRPC$Updates.chats.get(0).id, 0, true);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
            if (tLRPC$ChatFull.id == this.chatId) {
                if (zBooleanValue && ChatObject.isChannel(this.currentChat)) {
                    return;
                }
                boolean z = this.info != null;
                this.info = tLRPC$ChatFull;
                if (!z) {
                    int currentSlowmode = getCurrentSlowmode();
                    this.initialSlowmode = currentSlowmode;
                    this.selectedSlowmode = currentSlowmode;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$19();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$19() {
        loadChatParticipants(0, 200);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return checkDiscard();
    }

    public void setDelegate(ChatUsersActivityDelegate chatUsersActivityDelegate) {
        this.delegate = chatUsersActivityDelegate;
    }

    private int getCurrentSlowmode() {
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull == null) {
            return 0;
        }
        int i = tLRPC$ChatFull.slowmode_seconds;
        if (i == 10) {
            return 1;
        }
        if (i == 30) {
            return 2;
        }
        if (i == 60) {
            return 3;
        }
        if (i == 300) {
            return 4;
        }
        if (i == 900) {
            return 5;
        }
        return i == 3600 ? 6 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatSeconds(int i) {
        if (i < 60) {
            return LocaleController.formatPluralString("Seconds", i);
        }
        if (i < 3600) {
            return LocaleController.formatPluralString("Minutes", i / 60);
        }
        return LocaleController.formatPluralString("Hours", (i / 60) / 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDiscard() {
        if (ChatObject.getBannedRightsString(this.defaultBannedRights).equals(this.initialBannedRights) && this.initialSlowmode == this.selectedSlowmode) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("UserRestrictionsApplyChanges", R.string.UserRestrictionsApplyChanges));
        if (this.isChannel) {
            builder.setMessage(LocaleController.getString("ChannelSettingsChangedAlert", R.string.ChannelSettingsChangedAlert));
        } else {
            builder.setMessage(LocaleController.getString("GroupSettingsChangedAlert", R.string.GroupSettingsChangedAlert));
        }
        builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$20(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$21(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$20(DialogInterface dialogInterface, int i) {
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$21(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    public boolean hasSelectType() {
        return this.selectType != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatUserPermissions(TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        if (tLRPC$TL_chatBannedRights == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = tLRPC$TL_chatBannedRights.view_messages;
        if (z && this.defaultBannedRights.view_messages != z) {
            sb.append(LocaleController.getString("UserRestrictionsNoRead", R.string.UserRestrictionsNoRead));
        }
        boolean z2 = tLRPC$TL_chatBannedRights.send_messages;
        if (z2 && this.defaultBannedRights.send_messages != z2) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSend", R.string.UserRestrictionsNoSend));
        }
        boolean z3 = tLRPC$TL_chatBannedRights.send_media;
        if (z3 && this.defaultBannedRights.send_media != z3) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSendMedia", R.string.UserRestrictionsNoSendMedia));
        }
        boolean z4 = tLRPC$TL_chatBannedRights.send_stickers;
        if (z4 && this.defaultBannedRights.send_stickers != z4) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSendStickers", R.string.UserRestrictionsNoSendStickers));
        }
        boolean z5 = tLRPC$TL_chatBannedRights.send_polls;
        if (z5 && this.defaultBannedRights.send_polls != z5) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSendPolls", R.string.UserRestrictionsNoSendPolls));
        }
        boolean z6 = tLRPC$TL_chatBannedRights.embed_links;
        if (z6 && this.defaultBannedRights.embed_links != z6) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoEmbedLinks", R.string.UserRestrictionsNoEmbedLinks));
        }
        boolean z7 = tLRPC$TL_chatBannedRights.invite_users;
        if (z7 && this.defaultBannedRights.invite_users != z7) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoInviteUsers", R.string.UserRestrictionsNoInviteUsers));
        }
        boolean z8 = tLRPC$TL_chatBannedRights.pin_messages;
        if (z8 && this.defaultBannedRights.pin_messages != z8) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoPinMessages", R.string.UserRestrictionsNoPinMessages));
        }
        boolean z9 = tLRPC$TL_chatBannedRights.change_info;
        if (z9 && this.defaultBannedRights.change_info != z9) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoChangeInfo", R.string.UserRestrictionsNoChangeInfo));
        }
        if (sb.length() != 0) {
            sb.replace(0, 1, sb.substring(0, 1).toUpperCase());
            sb.append('.');
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        TLRPC$ChatFull tLRPC$ChatFull;
        if (this.type != 3) {
            return;
        }
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat.creator && !ChatObject.isChannel(tLRPC$Chat) && this.selectedSlowmode != this.initialSlowmode && this.info != null) {
            MessagesController.getInstance(this.currentAccount).convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda18
                @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                public final void run(int i) {
                    this.f$0.lambda$processDone$22(i);
                }
            });
            return;
        }
        if (!ChatObject.getBannedRightsString(this.defaultBannedRights).equals(this.initialBannedRights)) {
            getMessagesController().setDefaultBannedRole(this.chatId, this.defaultBannedRights, ChatObject.isChannel(this.currentChat), this);
            TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(this.chatId));
            if (chat != null) {
                chat.default_banned_rights = this.defaultBannedRights;
            }
        }
        int i = this.selectedSlowmode;
        if (i != this.initialSlowmode && (tLRPC$ChatFull = this.info) != null) {
            tLRPC$ChatFull.slowmode_seconds = getSecondsForIndex(i);
            this.info.flags |= MessagesController.UPDATE_MASK_REORDER;
            getMessagesController().setChannelSlowMode(this.chatId, this.info.slowmode_seconds);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$22(int i) {
        if (i != 0) {
            this.chatId = i;
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(i));
            processDone();
        }
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        if (tLRPC$ChatFull != null) {
            int currentSlowmode = getCurrentSlowmode();
            this.initialSlowmode = currentSlowmode;
            this.selectedSlowmode = currentSlowmode;
        }
    }

    private int getChannelAdminParticipantType(TLObject tLObject) {
        if ((tLObject instanceof TLRPC$TL_channelParticipantCreator) || (tLObject instanceof TLRPC$TL_channelParticipantSelf)) {
            return 0;
        }
        return ((tLObject instanceof TLRPC$TL_channelParticipantAdmin) || (tLObject instanceof TLRPC$TL_channelParticipant)) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadChatParticipants(int i, int i2) {
        if (this.loadingUsers) {
            return;
        }
        this.contactsEndReached = true;
        this.botsEndReached = true;
        loadChatParticipants(i, i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadChatParticipants(int i, int i2, boolean z) {
        TLRPC$Chat tLRPC$Chat;
        SparseArray<TLRPC$TL_groupCallParticipant> sparseArray;
        int i3 = 0;
        if (!ChatObject.isChannel(this.currentChat)) {
            this.loadingUsers = false;
            this.participants.clear();
            this.bots.clear();
            this.contacts.clear();
            this.participantsMap.clear();
            this.contactsMap.clear();
            this.botsMap.clear();
            int i4 = this.type;
            if (i4 == 1) {
                TLRPC$ChatFull tLRPC$ChatFull = this.info;
                if (tLRPC$ChatFull != null) {
                    int size = tLRPC$ChatFull.participants.participants.size();
                    while (i3 < size) {
                        TLRPC$ChatParticipant tLRPC$ChatParticipant = this.info.participants.participants.get(i3);
                        if ((tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantCreator) || (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin)) {
                            this.participants.add(tLRPC$ChatParticipant);
                        }
                        this.participantsMap.put(tLRPC$ChatParticipant.user_id, tLRPC$ChatParticipant);
                        i3++;
                    }
                }
            } else if (i4 == 2 && this.info != null) {
                int i5 = getUserConfig().clientUserId;
                int size2 = this.info.participants.participants.size();
                while (i3 < size2) {
                    TLRPC$ChatParticipant tLRPC$ChatParticipant2 = this.info.participants.participants.get(i3);
                    if ((this.selectType == 0 || tLRPC$ChatParticipant2.user_id != i5) && ((sparseArray = this.ignoredUsers) == null || sparseArray.indexOfKey(tLRPC$ChatParticipant2.user_id) < 0)) {
                        if (this.selectType == 1) {
                            if (getContactsController().isContact(tLRPC$ChatParticipant2.user_id)) {
                                this.contacts.add(tLRPC$ChatParticipant2);
                                this.contactsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            } else if (!UserObject.isDeleted(getMessagesController().getUser(Integer.valueOf(tLRPC$ChatParticipant2.user_id)))) {
                                this.participants.add(tLRPC$ChatParticipant2);
                                this.participantsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            }
                        } else if (getContactsController().isContact(tLRPC$ChatParticipant2.user_id)) {
                            this.contacts.add(tLRPC$ChatParticipant2);
                            this.contactsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                        } else {
                            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$ChatParticipant2.user_id));
                            if (user != null && user.bot) {
                                this.bots.add(tLRPC$ChatParticipant2);
                                this.botsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            } else {
                                this.participants.add(tLRPC$ChatParticipant2);
                                this.participantsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            }
                        }
                    }
                    i3++;
                }
            }
            ListAdapter listAdapter = this.listViewAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
            updateRows();
            ListAdapter listAdapter2 = this.listViewAdapter;
            if (listAdapter2 != null) {
                listAdapter2.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.loadingUsers = true;
        StickerEmptyView stickerEmptyView = this.emptyView;
        if (stickerEmptyView != null) {
            stickerEmptyView.showProgress(true, false);
        }
        ListAdapter listAdapter3 = this.listViewAdapter;
        if (listAdapter3 != null) {
            listAdapter3.notifyDataSetChanged();
        }
        final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
        tLRPC$TL_channels_getParticipants.channel = getMessagesController().getInputChannel(this.chatId);
        int i6 = this.type;
        if (i6 == 0) {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsKicked();
        } else if (i6 == 1) {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsAdmins();
        } else if (i6 == 2) {
            int i7 = this.selectType;
            if (i7 == 1) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$ChannelParticipantsFilter() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantsNotAdmins
                };
            } else {
                TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
                if (tLRPC$ChatFull2 != null && tLRPC$ChatFull2.participants_count <= 200 && (tLRPC$Chat = this.currentChat) != null && tLRPC$Chat.megagroup) {
                    tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
                } else if (i7 == 1) {
                    if (!this.contactsEndReached) {
                        this.delayResults = 2;
                        tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsContacts();
                        this.contactsEndReached = true;
                        loadChatParticipants(0, 200, false);
                    } else {
                        tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
                    }
                } else if (!this.contactsEndReached) {
                    this.delayResults = 3;
                    tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsContacts();
                    this.contactsEndReached = true;
                    loadChatParticipants(0, 200, false);
                } else if (!this.botsEndReached) {
                    tLRPC$TL_channels_getParticipants.filter = new TLRPC$ChannelParticipantsFilter() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantsBots
                        public static int constructor = -1328445861;

                        @Override // org.rbmain.tgnet.TLObject
                        public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                            abstractSerializedData.writeInt32(constructor);
                        }
                    };
                    this.botsEndReached = true;
                    loadChatParticipants(0, 200, false);
                } else {
                    tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
                }
            }
        } else if (i6 == 3) {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsBanned();
        }
        TLRPC$ChannelParticipantsFilter tLRPC$ChannelParticipantsFilter = tLRPC$TL_channels_getParticipants.filter;
        tLRPC$ChannelParticipantsFilter.q = BuildConfig.FLAVOR;
        tLRPC$TL_channels_getParticipants.offset = i;
        tLRPC$TL_channels_getParticipants.limit = i2;
        String str = z ? null : this.nextStartId;
        this.nextStartId = str;
        tLRPC$TL_channels_getParticipants.nextStartId = str;
        if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsBanned) {
            getDialogsProxy().getDefaultBannedRights(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda19
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadChatParticipants$24(tLObject, tLRPC$TL_error);
                }
            });
        } else if (this.hasContinue) {
            getDialogsProxy().getMembersByType(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda24
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadChatParticipants$26(tLRPC$TL_channels_getParticipants, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChatParticipants$24(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatParticipants$23(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChatParticipants$23(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error != null) {
            finishFragment();
        }
        if (tLObject != null) {
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = ((TLRPC$TL_updateChatDefaultBannedRights) tLObject).default_banned_rights;
            this.defaultBannedRights = tLRPC$TL_chatBannedRights;
            this.initialBannedRights = ChatObject.getBannedRightsString(tLRPC$TL_chatBannedRights);
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChatParticipants$26(final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatParticipants$25(tLRPC$TL_error, tLObject, tLRPC$TL_channels_getParticipants);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChatParticipants$25(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants) {
        ArrayList<TLObject> arrayList;
        SparseArray<TLObject> sparseArray;
        SparseArray<TLRPC$TL_groupCallParticipant> sparseArray2;
        if (tLRPC$TL_error == null) {
            TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
            this.nextStartId = tLRPC$TL_channels_channelParticipants.nextStartId;
            this.hasContinue = tLRPC$TL_channels_channelParticipants.hasContinue;
            if (this.type == 1) {
                getMessagesController().processLoadedAdminsResponse(this.chatId, tLRPC$TL_channels_channelParticipants);
            }
            getMessagesController().putUsers(tLRPC$TL_channels_channelParticipants.users, false);
            getMessagesController().putChats(tLRPC$TL_channels_channelParticipants.chats, false);
            int clientUserId = getUserConfig().getClientUserId();
            if (this.selectType != 0) {
                int i = 0;
                while (true) {
                    if (i >= tLRPC$TL_channels_channelParticipants.participants.size()) {
                        break;
                    }
                    if (MessageObject.getPeerId(tLRPC$TL_channels_channelParticipants.participants.get(i).peer) == clientUserId) {
                        tLRPC$TL_channels_channelParticipants.participants.remove(i);
                        break;
                    }
                    i++;
                }
            }
            if (this.type == 2) {
                this.delayResults--;
                TLRPC$ChannelParticipantsFilter tLRPC$ChannelParticipantsFilter = tLRPC$TL_channels_getParticipants.filter;
                if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsContacts) {
                    arrayList = this.contacts;
                    sparseArray = this.contactsMap;
                } else if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsBots) {
                    arrayList = this.bots;
                    sparseArray = this.botsMap;
                } else {
                    arrayList = this.participants;
                    sparseArray = this.participantsMap;
                }
            } else {
                arrayList = this.participants;
                sparseArray = this.participantsMap;
                sparseArray.clear();
            }
            arrayList.addAll(tLRPC$TL_channels_channelParticipants.participants);
            int size = tLRPC$TL_channels_channelParticipants.participants.size();
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i2);
                sparseArray.put(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer), tLRPC$ChannelParticipant);
            }
            if (this.type == 2) {
                int size2 = this.participants.size();
                int i3 = 0;
                while (i3 < size2) {
                    TLObject tLObject2 = this.participants.get(i3);
                    if (!(tLObject2 instanceof TLRPC$ChannelParticipant)) {
                        this.participants.remove(i3);
                    } else {
                        int peerId = MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject2).peer);
                        if ((this.contactsMap.get(peerId) == null && this.botsMap.get(peerId) == null && (this.selectType != 1 || peerId <= 0 || !UserObject.isDeleted(getMessagesController().getUser(Integer.valueOf(peerId)))) && ((sparseArray2 = this.ignoredUsers) == null || sparseArray2.indexOfKey(peerId) < 0)) ? false : true) {
                            this.participants.remove(i3);
                            this.participantsMap.remove(peerId);
                        } else {
                            i3++;
                        }
                    }
                    i3--;
                    size2--;
                    i3++;
                }
            }
        }
        if (this.type != 2 || this.delayResults <= 0) {
            ListAdapter listAdapter = this.listViewAdapter;
            showItemsAnimated(listAdapter != null ? listAdapter.getItemCount() : 0);
            this.loadingUsers = false;
            this.firstLoaded = true;
        }
        updateRows();
        if (this.listViewAdapter != null) {
            this.listView.setAnimateEmptyView(this.openTransitionStarted, 0);
            this.listViewAdapter.notifyDataSetChanged();
            if (this.emptyView != null && this.listViewAdapter.getItemCount() == 0 && this.firstLoaded) {
                this.emptyView.showProgress(false, true);
            }
        }
        resumeDelayedFragmentAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortUsers(ArrayList<TLObject> arrayList) {
        final int currentTime = getConnectionsManager().getCurrentTime();
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda17
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$sortUsers$27(currentTime, (TLObject) obj, (TLObject) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$sortUsers$27(int i, TLObject tLObject, TLObject tLObject2) {
        int i2;
        TLRPC$UserStatus tLRPC$UserStatus;
        TLRPC$UserStatus tLRPC$UserStatus2;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant2 = (TLRPC$ChannelParticipant) tLObject2;
        int peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
        int peerId2 = MessageObject.getPeerId(tLRPC$ChannelParticipant2.peer);
        int i3 = -100;
        if (peerId > 0) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer)));
            if (user == null || (tLRPC$UserStatus2 = user.status) == null) {
                i2 = 0;
            } else {
                i2 = user.self ? i + 50000 : tLRPC$UserStatus2.expires;
            }
        } else {
            i2 = -100;
        }
        if (peerId2 > 0) {
            TLRPC$User user2 = getMessagesController().getUser(Integer.valueOf(MessageObject.getPeerId(tLRPC$ChannelParticipant2.peer)));
            if (user2 == null || (tLRPC$UserStatus = user2.status) == null) {
                i3 = 0;
            } else {
                i3 = user2.self ? i + 50000 : tLRPC$UserStatus.expires;
            }
        }
        if (i2 > 0 && i3 > 0) {
            if (i2 > i3) {
                return 1;
            }
            return i2 < i3 ? -1 : 0;
        }
        if (i2 < 0 && i3 < 0) {
            if (i2 > i3) {
                return 1;
            }
            return i2 < i3 ? -1 : 0;
        }
        if ((i2 >= 0 || i3 <= 0) && (i2 != 0 || i3 == 0)) {
            return ((i3 >= 0 || i2 <= 0) && (i3 != 0 || i2 == 0)) ? 0 : 1;
        }
        return -1;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        StickerEmptyView stickerEmptyView = this.emptyView;
        if (stickerEmptyView != null) {
            stickerEmptyView.requestLayout();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            this.openTransitionStarted = true;
        }
        if (z && !z2 && this.needOpenSearch) {
            this.searchItem.getSearchField().requestFocus();
            AndroidUtilities.showKeyboard(this.searchItem.getSearchField());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int contactsStartRow;
        private int globalStartRow;
        private int groupStartRow;
        private Context mContext;
        private SearchAdapterHelper searchAdapterHelper;
        private boolean searchInProgress;
        private Runnable searchRunnable;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private SparseArray<TLObject> searchResultMap = new SparseArray<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private int totalCount = 0;

        public SearchAdapter(Context context) {
            this.mContext = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$SearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i) {
                    this.f$0.lambda$new$0(i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i) {
            if (this.searchAdapterHelper.isSearchInProgress()) {
                return;
            }
            int itemCount = getItemCount();
            notifyDataSetChanged();
            if (getItemCount() > itemCount) {
                ChatUsersActivity.this.showItemsAnimated(itemCount);
            }
            if (this.searchInProgress || getItemCount() != 0 || i == 0) {
                return;
            }
            ChatUsersActivity.this.emptyView.showProgress(false, true);
        }

        public void searchUsers(final String str) {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            this.searchResult.clear();
            this.searchResultMap.clear();
            this.searchResultNames.clear();
            this.searchAdapterHelper.mergeResults(null);
            this.searchAdapterHelper.queryServerSearch(null, false, false, true, false, false, ChatObject.isChannel(ChatUsersActivity.this.currentChat) ? ChatUsersActivity.this.chatId : 0, false, ChatUsersActivity.this.type, 0);
            notifyDataSetChanged();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.searchInProgress = true;
            ChatUsersActivity.this.emptyView.showProgress(true, true);
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$SearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchUsers$1(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 600L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$searchUsers$1(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$SearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$3(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processSearch$3(final String str) {
            final ArrayList arrayList = null;
            this.searchRunnable = null;
            if (ChatObject.isChannel(ChatUsersActivity.this.currentChat) && !ChatUsersActivity.this.participants.isEmpty()) {
                arrayList = new ArrayList(ChatUsersActivity.this.participants);
            }
            if (ChatUsersActivity.this.selectType == 1) {
                new ArrayList(ChatUsersActivity.this.getContactsController().contacts);
            }
            if (arrayList != null) {
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$SearchAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processSearch$2(str, arrayList);
                    }
                });
            } else {
                this.searchInProgress = false;
            }
            if (ChatUsersActivity.this.hasContinue || ChatUsersActivity.this.isChannel) {
                ChatUsersActivity.this.querySearch = str;
                this.searchAdapterHelper.queryServerSearch(str, false, false, true, false, false, ChatObject.isChannel(ChatUsersActivity.this.currentChat) ? ChatUsersActivity.this.chatId : 0, false, ChatUsersActivity.this.type, 1, ChatUsersActivity.this.nextStartId);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01a0 A[LOOP:1: B:38:0x00e9->B:76:0x01a0, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0168 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$2(java.lang.String r23, java.util.ArrayList r24) {
            /*
                Method dump skipped, instructions count: 462
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatUsersActivity.SearchAdapter.lambda$processSearch$2(java.lang.String, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final SparseArray<TLObject> sparseArray, final ArrayList<CharSequence> arrayList2, final ArrayList<TLObject> arrayList3) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatUsersActivity$SearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4(arrayList, sparseArray, arrayList2, arrayList3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$4(ArrayList arrayList, SparseArray sparseArray, ArrayList arrayList2, ArrayList arrayList3) {
            if (ChatUsersActivity.this.searching) {
                this.searchInProgress = false;
                this.searchResult = arrayList;
                this.searchResultMap = sparseArray;
                this.searchResultNames = arrayList2;
                this.searchAdapterHelper.mergeResults(arrayList);
                ArrayList<TLObject> groupSearch = this.searchAdapterHelper.getGroupSearch();
                groupSearch.clear();
                groupSearch.addAll(arrayList3);
                int itemCount = getItemCount();
                notifyDataSetChanged();
                if (getItemCount() > itemCount) {
                    ChatUsersActivity.this.showItemsAnimated(itemCount);
                }
                if (this.searchAdapterHelper.isSearchInProgress() || getItemCount() != 0) {
                    return;
                }
                ChatUsersActivity.this.emptyView.showProgress(false, true);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            this.totalCount = 0;
            int size = this.searchAdapterHelper.getGroupSearch().size();
            if (size != 0) {
                this.groupStartRow = 0;
                this.totalCount += size + 1;
            } else {
                this.groupStartRow = -1;
            }
            int size2 = this.searchResult.size();
            if (size2 != 0) {
                int i = this.totalCount;
                this.contactsStartRow = i;
                this.totalCount = i + size2 + 1;
            } else {
                this.contactsStartRow = -1;
            }
            int size3 = this.searchAdapterHelper.getGlobalSearch().size();
            if (size3 != 0) {
                int i2 = this.totalCount;
                this.globalStartRow = i2;
                this.totalCount = i2 + size3 + 1;
            } else {
                this.globalStartRow = -1;
            }
            if (ChatUsersActivity.this.searching && ChatUsersActivity.this.listView != null && ChatUsersActivity.this.listView.getAdapter() != ChatUsersActivity.this.searchListViewAdapter) {
                ChatUsersActivity.this.listView.setAnimateEmptyView(true, 0);
                ChatUsersActivity.this.listView.setAdapter(ChatUsersActivity.this.searchListViewAdapter);
                ChatUsersActivity.this.listView.setFastScrollVisible(false);
                ChatUsersActivity.this.listView.setVerticalScrollBarEnabled(true);
            }
            super.notifyDataSetChanged();
        }

        public void removeUserId(int i) {
            this.searchAdapterHelper.removeUserId(i);
            TLObject tLObject = this.searchResultMap.get(i);
            if (tLObject != null) {
                this.searchResult.remove(tLObject);
            }
            notifyDataSetChanged();
        }

        public TLObject getItem(int i) {
            int size = this.searchAdapterHelper.getGroupSearch().size();
            if (size != 0) {
                int i2 = size + 1;
                if (i2 > i) {
                    if (i == 0) {
                        return null;
                    }
                    return this.searchAdapterHelper.getGroupSearch().get(i - 1);
                }
                i -= i2;
            }
            int size2 = this.searchResult.size();
            if (size2 != 0) {
                int i3 = size2 + 1;
                if (i3 > i) {
                    if (i == 0) {
                        return null;
                    }
                    return (TLObject) this.searchResult.get(i - 1);
                }
                i -= i3;
            }
            int size3 = this.searchAdapterHelper.getGlobalSearch().size();
            if (size3 == 0 || size3 + 1 <= i || i == 0) {
                return null;
            }
            return this.searchAdapterHelper.getGlobalSearch().get(i - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$5(ManageChatUserCell manageChatUserCell, boolean z) {
            TLObject item = getItem(((Integer) manageChatUserCell.getTag()).intValue());
            if (!(item instanceof TLRPC$ChannelParticipant)) {
                return false;
            }
            return ChatUsersActivity.this.createMenuForParticipant((TLRPC$ChannelParticipant) item, !z);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout graySectionCell;
            if (i == 0) {
                ManageChatUserCell manageChatUserCell = new ManageChatUserCell(this.mContext, 2, 2, ChatUsersActivity.this.selectType == 0);
                manageChatUserCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$SearchAdapter$$ExternalSyntheticLambda5
                    @Override // org.rbmain.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                    public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                        return this.f$0.lambda$onCreateViewHolder$5(manageChatUserCell2, z);
                    }
                });
                graySectionCell = manageChatUserCell;
            } else {
                graySectionCell = new GraySectionCell(this.mContext);
            }
            return new RecyclerListView.Holder(graySectionCell);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) {
            /*
                Method dump skipped, instructions count: 451
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatUsersActivity.SearchAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (i == this.globalStartRow || i == this.groupStartRow || i == this.contactsStartRow) ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 7) {
                return ChatObject.canBlockUsers(ChatUsersActivity.this.currentChat);
            }
            if (itemViewType != 0) {
                return itemViewType == 0 || itemViewType == 2 || itemViewType == 6;
            }
            Object currentObject = ((ManageChatUserCell) viewHolder.itemView).getCurrentObject();
            return (ChatUsersActivity.this.type != 1 && (currentObject instanceof TLRPC$User) && ((TLRPC$User) currentObject).self) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChatUsersActivity.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0(ManageChatUserCell manageChatUserCell, boolean z) {
            return ChatUsersActivity.this.createMenuForParticipant(ChatUsersActivity.this.listViewAdapter.getItem(((Integer) manageChatUserCell.getTag()).intValue()), !z);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textInfoPrivacyCell;
            int i2 = 6;
            switch (i) {
                case 0:
                    Context context = this.mContext;
                    int i3 = (ChatUsersActivity.this.type == 0 || ChatUsersActivity.this.type == 3) ? 7 : 6;
                    if (ChatUsersActivity.this.type != 0 && ChatUsersActivity.this.type != 3) {
                        i2 = 2;
                    }
                    ManageChatUserCell manageChatUserCell = new ManageChatUserCell(context, i3, i2, ChatUsersActivity.this.selectType == 0);
                    manageChatUserCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$ListAdapter$$ExternalSyntheticLambda0
                        @Override // org.rbmain.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                        public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                            return this.f$0.lambda$onCreateViewHolder$0(manageChatUserCell2, z);
                        }
                    });
                    textInfoPrivacyCell = manageChatUserCell;
                    break;
                case 1:
                    textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                    break;
                case 2:
                    View manageChatTextCell = new ManageChatTextCell(this.mContext);
                    manageChatTextCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    textInfoPrivacyCell = manageChatTextCell;
                    break;
                case 3:
                    textInfoPrivacyCell = new ShadowSectionCell(this.mContext);
                    break;
                case 4:
                    FrameLayout frameLayout = new FrameLayout(this, this.mContext) { // from class: org.rbmain.ui.ChatUsersActivity.ListAdapter.1
                        @Override // android.widget.FrameLayout, android.view.View
                        protected void onMeasure(int i4, int i5) {
                            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) - AndroidUtilities.dp(56.0f), 1073741824));
                        }
                    };
                    frameLayout.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    LinearLayout linearLayout = new LinearLayout(this.mContext);
                    linearLayout.setOrientation(1);
                    frameLayout.addView(linearLayout, LayoutHelper.createFrame(-2, -2.0f, 17, 20.0f, 0.0f, 20.0f, 0.0f));
                    ImageView imageView = new ImageView(this.mContext);
                    imageView.setImageResource(R.drawable.group_ban_empty);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    int i4 = Theme.key_emptyListPlaceholder;
                    imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.MULTIPLY));
                    linearLayout.addView(imageView, LayoutHelper.createLinear(-2, -2, 1));
                    TextView textView = new TextView(this.mContext);
                    textView.setText(LocaleController.getString("NoBlockedUsers", R.string.NoBlockedUsers));
                    textView.setTextColor(Theme.getColor(i4));
                    textView.setTextSize(1, 16.0f);
                    textView.setGravity(1);
                    textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                    linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 1, 0, 10, 0, 0));
                    TextView textView2 = new TextView(this.mContext);
                    if (ChatUsersActivity.this.isChannel) {
                        textView2.setText(LocaleController.getString("NoBlockedChannel2", R.string.NoBlockedChannel2));
                    } else {
                        textView2.setText(LocaleController.getString("NoBlockedGroup2", R.string.NoBlockedGroup2));
                    }
                    textView2.setTextColor(Theme.getColor(i4));
                    textView2.setTextSize(1, 15.0f);
                    textView2.setGravity(1);
                    linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 1, 0, 10, 0, 0));
                    frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    textInfoPrivacyCell = frameLayout;
                    break;
                case 5:
                    HeaderCell headerCell = new HeaderCell(this.mContext, Theme.key_windowBackgroundWhiteBlueHeader, 21, 11, false);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    headerCell.setHeight(43);
                    textInfoPrivacyCell = headerCell;
                    break;
                case 6:
                    View textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    textInfoPrivacyCell = textSettingsCell;
                    break;
                case 7:
                    View textCheckCell2 = new TextCheckCell2(this.mContext);
                    textCheckCell2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    textInfoPrivacyCell = textCheckCell2;
                    break;
                case 8:
                    View graySectionCell = new GraySectionCell(this.mContext);
                    graySectionCell.setBackground(null);
                    textInfoPrivacyCell = graySectionCell;
                    break;
                case 9:
                default:
                    View chooseView = ChatUsersActivity.this.new ChooseView(this.mContext);
                    chooseView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    textInfoPrivacyCell = chooseView;
                    break;
                case 10:
                    textInfoPrivacyCell = new LoadingCell(this.mContext, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(120.0f));
                    break;
                case 11:
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setViewType(6);
                    flickerLoadingView.showDate(false);
                    flickerLoadingView.setPaddingLeft(AndroidUtilities.dp(5.0f));
                    flickerLoadingView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    flickerLoadingView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    textInfoPrivacyCell = flickerLoadingView;
                    break;
            }
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:270:0x06c6 A[PHI: r9
          0x06c6: PHI (r9v16 int) = (r9v9 int), (r9v20 int) binds: [B:278:0x06f2, B:269:0x06c4] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:326:0x07f5  */
        /* JADX WARN: Removed duplicated region for block: B:327:0x07f8  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r17, int r18) {
            /*
                Method dump skipped, instructions count: 2080
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatUsersActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ChatUsersActivity.this.addNewRow || i == ChatUsersActivity.this.addNew2Row || i == ChatUsersActivity.this.recentActionsRow || i == ChatUsersActivity.this.gigaConvertRow) {
                return 2;
            }
            if ((i >= ChatUsersActivity.this.participantsStartRow && i < ChatUsersActivity.this.participantsEndRow) || ((i >= ChatUsersActivity.this.botStartRow && i < ChatUsersActivity.this.botEndRow) || (i >= ChatUsersActivity.this.contactsStartRow && i < ChatUsersActivity.this.contactsEndRow))) {
                return 0;
            }
            if (i == ChatUsersActivity.this.addNewSectionRow || i == ChatUsersActivity.this.participantsDividerRow || i == ChatUsersActivity.this.participantsDivider2Row) {
                return 3;
            }
            if (i == ChatUsersActivity.this.restricted1SectionRow || i == ChatUsersActivity.this.permissionsSectionRow || i == ChatUsersActivity.this.slowmodeRow || i == ChatUsersActivity.this.gigaHeaderRow) {
                return 5;
            }
            if (i == ChatUsersActivity.this.participantsInfoRow || i == ChatUsersActivity.this.slowmodeInfoRow || i == ChatUsersActivity.this.gigaInfoRow) {
                return 1;
            }
            if (i == ChatUsersActivity.this.blockedEmptyRow) {
                return 4;
            }
            if (i == ChatUsersActivity.this.removedUsersRow) {
                return 6;
            }
            if (i == ChatUsersActivity.this.changeInfoRow || i == ChatUsersActivity.this.addUsersRow || i == ChatUsersActivity.this.viewMembersRow || i == ChatUsersActivity.this.viewAdminsRow || i == ChatUsersActivity.this.pinMessagesRow || i == ChatUsersActivity.this.sendMessagesRow || i == ChatUsersActivity.this.sendMediaRow || i == ChatUsersActivity.this.sendStickersRow || i == ChatUsersActivity.this.embedLinksRow || i == ChatUsersActivity.this.sendPollsRow) {
                return 7;
            }
            if (i == ChatUsersActivity.this.membersHeaderRow || i == ChatUsersActivity.this.contactsHeaderRow || i == ChatUsersActivity.this.botHeaderRow || i == ChatUsersActivity.this.loadingHeaderRow) {
                return 8;
            }
            if (i == ChatUsersActivity.this.slowmodeSelectRow) {
                return 9;
            }
            if (i == ChatUsersActivity.this.loadingProgressRow) {
                return 10;
            }
            return i == ChatUsersActivity.this.loadingUserCellRow ? 11 : 0;
        }

        public TLObject getItem(int i) {
            if (i < ChatUsersActivity.this.participantsStartRow || i >= ChatUsersActivity.this.participantsEndRow) {
                if (i < ChatUsersActivity.this.contactsStartRow || i >= ChatUsersActivity.this.contactsEndRow) {
                    if (i < ChatUsersActivity.this.botStartRow || i >= ChatUsersActivity.this.botEndRow) {
                        return null;
                    }
                    return (TLObject) ChatUsersActivity.this.bots.get(i - ChatUsersActivity.this.botStartRow);
                }
                return (TLObject) ChatUsersActivity.this.contacts.get(i - ChatUsersActivity.this.contactsStartRow);
            }
            return (TLObject) ChatUsersActivity.this.participants.get(i - ChatUsersActivity.this.participantsStartRow);
        }
    }

    public DiffCallback saveState() {
        DiffCallback diffCallback = new DiffCallback();
        diffCallback.oldRowCount = this.rowCount;
        diffCallback.oldBotStartRow = this.botStartRow;
        diffCallback.oldBotEndRow = this.botEndRow;
        diffCallback.oldBots.clear();
        diffCallback.oldBots.addAll(this.bots);
        diffCallback.oldContactsEndRow = this.contactsEndRow;
        diffCallback.oldContactsStartRow = this.contactsStartRow;
        diffCallback.oldContacts.clear();
        diffCallback.oldContacts.addAll(this.contacts);
        diffCallback.oldParticipantsStartRow = this.participantsStartRow;
        diffCallback.oldParticipantsEndRow = this.participantsEndRow;
        diffCallback.oldParticipants.clear();
        diffCallback.oldParticipants.addAll(this.participants);
        diffCallback.fillPositions(diffCallback.oldPositionToItem);
        return diffCallback;
    }

    public void updateListAnimated(DiffCallback diffCallback) {
        if (this.listViewAdapter == null) {
            updateRows();
            return;
        }
        updateRows();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null || this.layoutManager == null || recyclerListView.getChildCount() <= 0) {
            return;
        }
        View childAt = null;
        int i = 0;
        int childAdapterPosition = -1;
        while (true) {
            if (i >= this.listView.getChildCount()) {
                break;
            }
            RecyclerListView recyclerListView2 = this.listView;
            childAdapterPosition = recyclerListView2.getChildAdapterPosition(recyclerListView2.getChildAt(i));
            if (childAdapterPosition != -1) {
                childAt = this.listView.getChildAt(i);
                break;
            }
            i++;
        }
        if (childAt != null) {
            this.layoutManager.scrollToPositionWithOffset(childAdapterPosition, childAt.getTop() - this.listView.getPaddingTop());
        }
    }

    private class DiffCallback extends DiffUtil.Callback {
        SparseIntArray newPositionToItem;
        int oldBotEndRow;
        int oldBotStartRow;
        private ArrayList<TLObject> oldBots;
        private ArrayList<TLObject> oldContacts;
        int oldContactsEndRow;
        int oldContactsStartRow;
        private ArrayList<TLObject> oldParticipants;
        int oldParticipantsEndRow;
        int oldParticipantsStartRow;
        SparseIntArray oldPositionToItem;
        int oldRowCount;

        private DiffCallback() {
            this.oldPositionToItem = new SparseIntArray();
            this.newPositionToItem = new SparseIntArray();
            this.oldParticipants = new ArrayList<>();
            this.oldBots = new ArrayList<>();
            this.oldContacts = new ArrayList<>();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldRowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return ChatUsersActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            if (i >= this.oldBotStartRow && i < this.oldBotEndRow && i2 >= ChatUsersActivity.this.botStartRow && i2 < ChatUsersActivity.this.botEndRow) {
                return this.oldBots.get(i - this.oldBotStartRow).equals(ChatUsersActivity.this.bots.get(i2 - ChatUsersActivity.this.botStartRow));
            }
            if (i >= this.oldContactsStartRow && i < this.oldContactsEndRow && i2 >= ChatUsersActivity.this.contactsStartRow && i2 < ChatUsersActivity.this.contactsEndRow) {
                return this.oldContacts.get(i - this.oldContactsStartRow).equals(ChatUsersActivity.this.contacts.get(i2 - ChatUsersActivity.this.contactsStartRow));
            }
            if (i < this.oldParticipantsStartRow || i >= this.oldParticipantsEndRow || i2 < ChatUsersActivity.this.participantsStartRow || i2 >= ChatUsersActivity.this.participantsEndRow) {
                return this.oldPositionToItem.get(i) == this.newPositionToItem.get(i2);
            }
            return this.oldParticipants.get(i - this.oldParticipantsStartRow).equals(ChatUsersActivity.this.participants.get(i2 - ChatUsersActivity.this.participantsStartRow));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return areItemsTheSame(i, i2) && ChatUsersActivity.this.restricted1SectionRow != i2;
        }

        public void fillPositions(SparseIntArray sparseIntArray) {
            sparseIntArray.clear();
            put(1, ChatUsersActivity.this.recentActionsRow, sparseIntArray);
            put(2, ChatUsersActivity.this.addNewRow, sparseIntArray);
            put(3, ChatUsersActivity.this.addNew2Row, sparseIntArray);
            put(4, ChatUsersActivity.this.addNewSectionRow, sparseIntArray);
            put(5, ChatUsersActivity.this.restricted1SectionRow, sparseIntArray);
            put(6, ChatUsersActivity.this.participantsDividerRow, sparseIntArray);
            put(7, ChatUsersActivity.this.participantsDivider2Row, sparseIntArray);
            put(8, ChatUsersActivity.this.gigaHeaderRow, sparseIntArray);
            put(9, ChatUsersActivity.this.gigaConvertRow, sparseIntArray);
            put(10, ChatUsersActivity.this.gigaInfoRow, sparseIntArray);
            put(11, ChatUsersActivity.this.participantsInfoRow, sparseIntArray);
            put(12, ChatUsersActivity.this.blockedEmptyRow, sparseIntArray);
            put(13, ChatUsersActivity.this.permissionsSectionRow, sparseIntArray);
            put(14, ChatUsersActivity.this.sendMessagesRow, sparseIntArray);
            put(15, ChatUsersActivity.this.sendMediaRow, sparseIntArray);
            put(16, ChatUsersActivity.this.sendStickersRow, sparseIntArray);
            put(17, ChatUsersActivity.this.sendPollsRow, sparseIntArray);
            put(18, ChatUsersActivity.this.embedLinksRow, sparseIntArray);
            put(19, ChatUsersActivity.this.addUsersRow, sparseIntArray);
            put(20, ChatUsersActivity.this.viewMembersRow, sparseIntArray);
            put(21, ChatUsersActivity.this.viewAdminsRow, sparseIntArray);
            put(22, ChatUsersActivity.this.pinMessagesRow, sparseIntArray);
            put(23, ChatUsersActivity.this.changeInfoRow, sparseIntArray);
            put(24, ChatUsersActivity.this.removedUsersRow, sparseIntArray);
            put(25, ChatUsersActivity.this.contactsHeaderRow, sparseIntArray);
            put(26, ChatUsersActivity.this.botHeaderRow, sparseIntArray);
            put(27, ChatUsersActivity.this.membersHeaderRow, sparseIntArray);
            put(28, ChatUsersActivity.this.slowmodeRow, sparseIntArray);
            put(29, ChatUsersActivity.this.slowmodeSelectRow, sparseIntArray);
            put(30, ChatUsersActivity.this.slowmodeInfoRow, sparseIntArray);
            put(31, ChatUsersActivity.this.loadingProgressRow, sparseIntArray);
            put(32, ChatUsersActivity.this.loadingUserCellRow, sparseIntArray);
            put(33, ChatUsersActivity.this.loadingHeaderRow, sparseIntArray);
        }

        private void put(int i, int i2, SparseIntArray sparseIntArray) {
            if (i2 >= 0) {
                sparseIntArray.put(i2, i);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ChatUsersActivity$$ExternalSyntheticLambda25
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$28();
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, ManageChatUserCell.class, ManageChatTextCell.class, TextCheckCell2.class, TextSettingsCell.class, ChooseView.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        int i3 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switch2Track));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switch2TrackChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_windowBackgroundWhiteGrayText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_undo_background));
        int i6 = Theme.key_undo_cancelColor;
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        int i7 = Theme.key_undo_infoColor;
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueButton));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerEmptyView.class}, new String[]{"title"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerEmptyView.class}, new String[]{"subtitle"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$28() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof ManageChatUserCell) {
                    ((ManageChatUserCell) childAt).update(0);
                }
            }
        }
    }
}
