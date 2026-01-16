package ir.eitaa.ui;

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
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$ChannelParticipantsFilter;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$TL_ads_AdPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_getAdsPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationChatMembers;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantSelf;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsAdmins;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsBanned;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsContacts;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsKicked;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsRecent;
import ir.eitaa.tgnet.TLRPC$TL_channels_editBanned;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipant;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.ManageChatTextCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell2;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.ChatRightsEditActivity;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.GigagroupConvertAlert;
import ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.SimpleAdsList;
import ir.eitaa.ui.Components.StickerEmptyView;
import ir.eitaa.ui.Components.UndoView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ChatUsersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int adRow;
    private int adSectionRow;
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
    private LongSparseArray<TLObject> botsMap;
    private int changeInfoRow;
    private long chatId;
    private ArrayList<TLObject> contacts;
    private boolean contactsEndReached;
    private int contactsEndRow;
    private int contactsHeaderRow;
    private LongSparseArray<TLObject> contactsMap;
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
    private boolean hasAds;
    private LongSparseArray<TLRPC$TL_groupCallParticipant> ignoredUsers;
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
    private boolean openTransitionStarted;
    private ArrayList<TLObject> participants;
    private int participantsDivider2Row;
    private int participantsDividerRow;
    private int participantsEndRow;
    private int participantsInfoRow;
    private LongSparseArray<TLObject> participantsMap;
    private int participantsStartRow;
    private int permissionsSectionRow;
    private int pinMessagesRow;
    private View progressBar;
    private int recentActionsRow;
    private int removedUsersRow;
    private int restricted1SectionRow;
    private int rowCount;
    private ActionBarMenuItem searchItem;
    private SearchAdapter searchListViewAdapter;
    private boolean searching;
    private int selectType;
    private int selectedSlowmode;
    private int sendForwardedMessagesRow;
    private int sendMediaRow;
    private int sendMessagesRow;
    private int sendPollsRow;
    private int sendStickersRow;
    private SimpleAdsList simpleAds;
    private int slowmodeInfoRow;
    private int slowmodeRow;
    private int slowmodeSelectRow;
    private int type;
    private UndoView undoView;
    private int untilDateRow;
    private int viewParticipantsRow;

    public interface ChatUsersActivityDelegate {

        /* renamed from: ir.eitaa.ui.ChatUsersActivity$ChatUsersActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didChangeOwner(ChatUsersActivityDelegate chatUsersActivityDelegate, TLRPC$User tLRPC$User) {
            }

            public static void $default$didKickParticipant(ChatUsersActivityDelegate chatUsersActivityDelegate, long j) {
            }

            public static void $default$didSelectUser(ChatUsersActivityDelegate chatUsersActivityDelegate, long j) {
            }
        }

        void didAddParticipantToList(long uid, TLObject participant);

        void didChangeOwner(TLRPC$User user);

        void didKickParticipant(long userId);

        void didSelectUser(long uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSecondsForIndex(int index) {
        if (index == 1) {
            return 10;
        }
        if (index == 2) {
            return 30;
        }
        if (index == 3) {
            return 60;
        }
        if (index == 4) {
            return 300;
        }
        if (index == 5) {
            return 900;
        }
        return index == 6 ? 3600 : 0;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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
            this.accessibilityDelegate = new IntSeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.ChatUsersActivity.ChooseView.1
                @Override // ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate
                public int getProgress() {
                    return ChatUsersActivity.this.selectedSlowmode;
                }

                @Override // ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate
                public void setProgress(int progress) {
                    ChooseView.this.setItem(progress);
                }

                @Override // ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate
                public int getMaxValue() {
                    return ChooseView.this.strings.size() - 1;
                }

                @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
                protected CharSequence getContentDescription(View host) {
                    if (ChatUsersActivity.this.selectedSlowmode == 0) {
                        return LocaleController.getString("SlowmodeOff", R.string.SlowmodeOff);
                    }
                    ChatUsersActivity chatUsersActivity = ChatUsersActivity.this;
                    return chatUsersActivity.formatSeconds(chatUsersActivity.getSecondsForIndex(chatUsersActivity.selectedSlowmode));
                }
            };
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            this.accessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(this, info);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int action, Bundle arguments) {
            return super.performAccessibilityAction(action, arguments) || this.accessibilityDelegate.performAccessibilityActionInternal(this, action, arguments);
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
        public void setItem(int index) {
            if (ChatUsersActivity.this.info == null) {
                return;
            }
            ChatUsersActivity.this.selectedSlowmode = index;
            ChatUsersActivity.this.listViewAdapter.notifyItemChanged(ChatUsersActivity.this.slowmodeInfoRow);
            invalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(74.0f), 1073741824));
            this.circleSize = AndroidUtilities.dp(6.0f);
            this.gapSize = AndroidUtilities.dp(2.0f);
            this.sideSide = AndroidUtilities.dp(22.0f);
            this.lineSize = (((getMeasuredWidth() - (this.circleSize * this.strings.size())) - ((this.gapSize * 2) * (this.strings.size() - 1))) - (this.sideSide * 2)) / (this.strings.size() - 1);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.textPaint.setColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            int measuredHeight = (getMeasuredHeight() / 2) + AndroidUtilities.dp(11.0f);
            int i = 0;
            while (i < this.strings.size()) {
                int i2 = this.sideSide;
                int i3 = this.lineSize + (this.gapSize * 2);
                int i4 = this.circleSize;
                int i5 = i2 + ((i3 + i4) * i) + (i4 / 2);
                if (i <= ChatUsersActivity.this.selectedSlowmode) {
                    this.paint.setColor(Theme.getColor("switchTrackChecked"));
                } else {
                    this.paint.setColor(Theme.getColor("switchTrack"));
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

    public ChatUsersActivity(Bundle args) {
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        super(args);
        this.defaultBannedRights = new TLRPC$TL_chatBannedRights();
        this.participants = new ArrayList<>();
        this.bots = new ArrayList<>();
        this.contacts = new ArrayList<>();
        this.participantsMap = new LongSparseArray<>();
        this.botsMap = new LongSparseArray<>();
        this.contactsMap = new LongSparseArray<>();
        this.slowmodeRow = -1;
        this.slowmodeSelectRow = -1;
        this.slowmodeInfoRow = -1;
        this.chatId = this.arguments.getLong("chat_id");
        this.type = this.arguments.getInt("type");
        this.needOpenSearch = this.arguments.getBoolean("open_search");
        this.selectType = this.arguments.getInt("selectType");
        TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.chatId));
        this.currentChat = chat;
        if (chat != null && (tLRPC$TL_chatBannedRights = chat.default_banned_rights) != null) {
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = this.defaultBannedRights;
            tLRPC$TL_chatBannedRights2.view_messages = tLRPC$TL_chatBannedRights.view_messages;
            tLRPC$TL_chatBannedRights2.send_stickers = tLRPC$TL_chatBannedRights.send_stickers;
            tLRPC$TL_chatBannedRights2.send_media = tLRPC$TL_chatBannedRights.send_media;
            tLRPC$TL_chatBannedRights2.embed_links = tLRPC$TL_chatBannedRights.embed_links;
            tLRPC$TL_chatBannedRights2.send_messages = tLRPC$TL_chatBannedRights.send_messages;
            tLRPC$TL_chatBannedRights2.send_forwarded_messages = tLRPC$TL_chatBannedRights.send_forwarded_messages;
            tLRPC$TL_chatBannedRights2.send_games = tLRPC$TL_chatBannedRights.send_games;
            tLRPC$TL_chatBannedRights2.send_inline = tLRPC$TL_chatBannedRights.send_inline;
            tLRPC$TL_chatBannedRights2.send_gifs = tLRPC$TL_chatBannedRights.send_gifs;
            tLRPC$TL_chatBannedRights2.pin_messages = tLRPC$TL_chatBannedRights.pin_messages;
            tLRPC$TL_chatBannedRights2.send_polls = tLRPC$TL_chatBannedRights.send_polls;
            tLRPC$TL_chatBannedRights2.invite_users = tLRPC$TL_chatBannedRights.invite_users;
            tLRPC$TL_chatBannedRights2.change_info = tLRPC$TL_chatBannedRights.change_info;
            tLRPC$TL_chatBannedRights2.view_participants = tLRPC$TL_chatBannedRights.view_participants;
            tLRPC$TL_chatBannedRights2.until_date = tLRPC$TL_chatBannedRights.until_date;
        }
        this.initialBannedRights = ChatObject.getBannedRightsString(this.defaultBannedRights);
        this.isChannel = ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateRows() {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.updateRows():void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.chatInfoDidLoad);
        loadChatParticipants(0, 200);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ChatUsersActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (ChatUsersActivity.this.checkDiscard()) {
                        ChatUsersActivity.this.finishFragment();
                    }
                } else if (id == 1) {
                    ChatUsersActivity.this.processDone();
                }
            }
        });
        if (this.selectType != 0 || (i = this.type) == 2 || i == 0 || i == 3) {
            this.searchListViewAdapter = new SearchAdapter(context);
            ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
            ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.ChatUsersActivity.2
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchExpand() {
                    ChatUsersActivity.this.searching = true;
                    if (ChatUsersActivity.this.doneItem != null) {
                        ChatUsersActivity.this.doneItem.setVisibility(8);
                    }
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchCollapse() throws InterruptedException {
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

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) throws InterruptedException {
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
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.ChatUsersActivity.3
            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                canvas.drawColor(Theme.getColor(ChatUsersActivity.this.listView.getAdapter() == ChatUsersActivity.this.searchListViewAdapter ? "windowBackgroundWhite" : "windowBackgroundGray"));
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
        this.emptyView.setVisibility(8);
        this.emptyView.setAnimateLayoutChange(true);
        this.emptyView.showProgress(true, false);
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.addView(frameLayout3, 0);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.ChatUsersActivity.4
            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                if (((BaseFragment) ChatUsersActivity.this).fragmentView != null) {
                    ((BaseFragment) ChatUsersActivity.this).fragmentView.invalidate();
                }
            }
        };
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, i, z) { // from class: ir.eitaa.ui.ChatUsersActivity.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
                if (!ChatUsersActivity.this.firstLoaded && ChatUsersActivity.this.type == 0 && ChatUsersActivity.this.participants.size() == 0) {
                    return 0;
                }
                return super.scrollVerticallyBy(dy, recycler, state);
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: ir.eitaa.ui.ChatUsersActivity.6
            int animationIndex = -1;

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected long getAddAnimationDelay(long removeDuration, long moveDuration, long changeDuration) {
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$A_eLkA13o0NoIxcR2ebq9SF-HiQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                this.f$0.lambda$createView$1$ChatUsersActivity(view, i4);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$D3vs85uEDkSLv0W_wQ_f5UmUlqY
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i4) {
                return this.f$0.lambda$createView$2$ChatUsersActivity(view, i4);
            }
        });
        if (this.searchItem != null) {
            this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ChatUsersActivity.18
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == 1) {
                        AndroidUtilities.hideKeyboard(ChatUsersActivity.this.getParentActivity().getCurrentFocus());
                    }
                }
            });
        }
        UndoView undoView = new UndoView(context);
        this.undoView = undoView;
        frameLayout2.addView(undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        updateRows();
        loadAds();
        this.listView.setEmptyView(this.emptyView);
        this.listView.setAnimateEmptyView(false, 0);
        if (this.needOpenSearch) {
            this.searchItem.openSearch(false);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:361:? A[RETURN, SYNTHETIC] */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$1$ChatUsersActivity(android.view.View r35, int r36) {
        /*
            Method dump skipped, instructions count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.lambda$createView$1$ChatUsersActivity(android.view.View, int):void");
    }

    /* renamed from: ir.eitaa.ui.ChatUsersActivity$8, reason: invalid class name */
    class AnonymousClass8 implements ChatUsersActivityDelegate {
        @Override // ir.eitaa.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public /* synthetic */ void didKickParticipant(long j) {
            ChatUsersActivityDelegate.CC.$default$didKickParticipant(this, j);
        }

        AnonymousClass8() {
        }

        @Override // ir.eitaa.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public void didAddParticipantToList(long uid, TLObject participant) {
            if (participant == null || ChatUsersActivity.this.participantsMap.get(uid) != null) {
                return;
            }
            DiffCallback diffCallbackSaveState = ChatUsersActivity.this.saveState();
            ChatUsersActivity.this.participants.add(participant);
            ChatUsersActivity.this.participantsMap.put(uid, participant);
            ChatUsersActivity chatUsersActivity = ChatUsersActivity.this;
            chatUsersActivity.sortAdmins(chatUsersActivity.participants);
            ChatUsersActivity.this.updateListAnimated(diffCallbackSaveState);
        }

        @Override // ir.eitaa.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public void didChangeOwner(TLRPC$User user) {
            ChatUsersActivity.this.onOwnerChaged(user);
        }

        @Override // ir.eitaa.ui.ChatUsersActivity.ChatUsersActivityDelegate
        public void didSelectUser(long uid) {
            final TLRPC$User user = ChatUsersActivity.this.getMessagesController().getUser(Long.valueOf(uid));
            if (user != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$8$JLRHHzDxgU-mM3EPfreDKCeCyHM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didSelectUser$0$ChatUsersActivity$8(user);
                    }
                }, 200L);
            }
            if (ChatUsersActivity.this.participantsMap.get(uid) == null) {
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
        /* renamed from: lambda$didSelectUser$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didSelectUser$0$ChatUsersActivity$8(TLRPC$User tLRPC$User) {
            if (BulletinFactory.canShowBulletin(ChatUsersActivity.this)) {
                BulletinFactory.createPromoteToAdminBulletin(ChatUsersActivity.this, tLRPC$User.first_name).show();
            }
        }
    }

    /* renamed from: ir.eitaa.ui.ChatUsersActivity$16, reason: invalid class name */
    class AnonymousClass16 extends GigagroupConvertAlert {
        @Override // ir.eitaa.ui.Components.GigagroupConvertAlert
        protected void onCancel() {
        }

        AnonymousClass16(final Context context, BaseFragment parentFragment) {
            super(context, parentFragment);
        }

        @Override // ir.eitaa.ui.Components.GigagroupConvertAlert
        protected void onCovert() {
            ChatUsersActivity.this.getMessagesController().convertToGigaGroup(ChatUsersActivity.this.getParentActivity(), ChatUsersActivity.this.currentChat, ChatUsersActivity.this, new MessagesStorage.BooleanCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$16$a7Ac3j8vdOmE-Tz18XXD2tHaLZg
                @Override // ir.eitaa.messenger.MessagesStorage.BooleanCallback
                public final void run(boolean z) {
                    this.f$0.lambda$onCovert$0$ChatUsersActivity$16(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCovert$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCovert$0$ChatUsersActivity$16(boolean z) {
            if (!z || ((BaseFragment) ChatUsersActivity.this).parentLayout == null) {
                return;
            }
            BaseFragment baseFragment = ((BaseFragment) ChatUsersActivity.this).parentLayout.fragmentsStack.get(((BaseFragment) ChatUsersActivity.this).parentLayout.fragmentsStack.size() - 2);
            if (baseFragment instanceof ChatEditActivity) {
                baseFragment.removeSelfFromStack();
                Bundle bundle = new Bundle();
                bundle.putLong("chat_id", ChatUsersActivity.this.chatId);
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
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ChatUsersActivity(TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, DialogInterface dialogInterface, int i) {
        openRightsEdit(tLRPC$User.id, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, this.selectType == 1 ? 0 : 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$ChatUsersActivity(View view, int i) {
        if (getParentActivity() == null) {
            return false;
        }
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ListAdapter listAdapter = this.listViewAdapter;
        return adapter == listAdapter && createMenuForParticipant(listAdapter.getItem(i), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortAdmins(ArrayList<TLObject> participants) {
        Collections.sort(participants, new $$Lambda$ChatUsersActivity$4zAsf644lw13u4p98XTw6pXW4uw(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sortAdmins$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$sortAdmins$3$ChatUsersActivity(TLObject tLObject, TLObject tLObject2) {
        int channelAdminParticipantType = getChannelAdminParticipantType(tLObject);
        int channelAdminParticipantType2 = getChannelAdminParticipantType(tLObject2);
        if (channelAdminParticipantType > channelAdminParticipantType2) {
            return 1;
        }
        if (channelAdminParticipantType < channelAdminParticipantType2) {
            return -1;
        }
        if ((tLObject instanceof TLRPC$ChannelParticipant) && (tLObject2 instanceof TLRPC$ChannelParticipant)) {
            return (int) (MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer) - MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject2).peer));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showItemsAnimated(final int from) {
        if (this.isPaused || !this.openTransitionStarted) {
            return;
        }
        if (this.listView.getAdapter() == this.listViewAdapter && this.firstLoaded) {
            return;
        }
        final View view = null;
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof FlickerLoadingView) {
                view = childAt;
            }
        }
        if (view != null) {
            this.listView.removeView(view);
            from--;
        }
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.ChatUsersActivity.19
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ChatUsersActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = ChatUsersActivity.this.listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = ChatUsersActivity.this.listView.getChildAt(i2);
                    if (childAt2 != view && ChatUsersActivity.this.listView.getChildAdapterPosition(childAt2) >= from) {
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
                        objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChatUsersActivity.19.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onOwnerChaged(TLRPC$User user) {
        LongSparseArray<TLObject> longSparseArray;
        ArrayList<TLObject> arrayList;
        boolean z;
        this.undoView.showWithAction(-this.chatId, this.isChannel ? 9 : 10, user);
        this.currentChat.creator = false;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            boolean z3 = true;
            if (i == 0) {
                longSparseArray = this.contactsMap;
                arrayList = this.contacts;
            } else if (i == 1) {
                longSparseArray = this.botsMap;
                arrayList = this.bots;
            } else {
                longSparseArray = this.participantsMap;
                arrayList = this.participants;
            }
            TLObject tLObject = longSparseArray.get(user.id);
            if (tLObject instanceof TLRPC$ChannelParticipant) {
                TLRPC$TL_channelParticipantCreator tLRPC$TL_channelParticipantCreator = new TLRPC$TL_channelParticipantCreator();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_channelParticipantCreator.peer = tLRPC$TL_peerUser;
                long j = user.id;
                tLRPC$TL_peerUser.user_id = j;
                longSparseArray.put(j, tLRPC$TL_channelParticipantCreator);
                int iIndexOf = arrayList.indexOf(tLObject);
                if (iIndexOf >= 0) {
                    arrayList.set(iIndexOf, tLRPC$TL_channelParticipantCreator);
                }
                z2 = true;
                z = true;
            } else {
                z = false;
            }
            long clientUserId = getUserConfig().getClientUserId();
            TLObject tLObject2 = longSparseArray.get(clientUserId);
            if (tLObject2 instanceof TLRPC$ChannelParticipant) {
                TLRPC$TL_channelParticipantAdmin tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin();
                TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
                tLRPC$TL_channelParticipantAdmin.peer = tLRPC$TL_peerUser2;
                tLRPC$TL_peerUser2.user_id = clientUserId;
                tLRPC$TL_channelParticipantAdmin.self = true;
                tLRPC$TL_channelParticipantAdmin.inviter_id = clientUserId;
                tLRPC$TL_channelParticipantAdmin.promoted_by = clientUserId;
                tLRPC$TL_channelParticipantAdmin.date = (int) (System.currentTimeMillis() / 1000);
                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
                tLRPC$TL_channelParticipantAdmin.admin_rights = tLRPC$TL_chatAdminRights;
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
                longSparseArray.put(clientUserId, tLRPC$TL_channelParticipantAdmin);
                int iIndexOf2 = arrayList.indexOf(tLObject2);
                if (iIndexOf2 >= 0) {
                    arrayList.set(iIndexOf2, tLRPC$TL_channelParticipantAdmin);
                }
            } else {
                z3 = z;
            }
            if (z3) {
                Collections.sort(arrayList, new $$Lambda$ChatUsersActivity$xZae0pkYvHqWje1K8p3kS37Ma6Q(this));
            }
        }
        if (!z2) {
            TLRPC$TL_channelParticipantCreator tLRPC$TL_channelParticipantCreator2 = new TLRPC$TL_channelParticipantCreator();
            TLRPC$TL_peerUser tLRPC$TL_peerUser3 = new TLRPC$TL_peerUser();
            tLRPC$TL_channelParticipantCreator2.peer = tLRPC$TL_peerUser3;
            long j2 = user.id;
            tLRPC$TL_peerUser3.user_id = j2;
            this.participantsMap.put(j2, tLRPC$TL_channelParticipantCreator2);
            this.participants.add(tLRPC$TL_channelParticipantCreator2);
            sortAdmins(this.participants);
            updateRows();
        }
        this.listViewAdapter.notifyDataSetChanged();
        ChatUsersActivityDelegate chatUsersActivityDelegate = this.delegate;
        if (chatUsersActivityDelegate != null) {
            chatUsersActivityDelegate.didChangeOwner(user);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onOwnerChaged$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$onOwnerChaged$4$ChatUsersActivity(TLObject tLObject, TLObject tLObject2) {
        int channelAdminParticipantType = getChannelAdminParticipantType(tLObject);
        int channelAdminParticipantType2 = getChannelAdminParticipantType(tLObject2);
        if (channelAdminParticipantType > channelAdminParticipantType2) {
            return 1;
        }
        return channelAdminParticipantType < channelAdminParticipantType2 ? -1 : 0;
    }

    private void openRightsEdit2(final long peerId, final int date, TLObject participant, TLRPC$TL_chatAdminRights adminRights, TLRPC$TL_chatBannedRights bannedRights, String rank, boolean canEditAdmin, final int type, boolean removeFragment) {
        final boolean[] zArr = new boolean[1];
        boolean z = (participant instanceof TLRPC$TL_channelParticipantAdmin) || (participant instanceof TLRPC$TL_chatParticipantAdmin);
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(peerId, this.chatId, adminRights, this.defaultBannedRights, bannedRights, rank, type, true, false) { // from class: ir.eitaa.ui.ChatUsersActivity.20
            @Override // ir.eitaa.ui.ActionBar.BaseFragment
            protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
                if (!isOpen && backward && zArr[0] && BulletinFactory.canShowBulletin(ChatUsersActivity.this)) {
                    if (peerId > 0) {
                        TLRPC$User user = getMessagesController().getUser(Long.valueOf(peerId));
                        if (user != null) {
                            BulletinFactory.createPromoteToAdminBulletin(ChatUsersActivity.this, user.first_name).show();
                            return;
                        }
                        return;
                    }
                    TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(-peerId));
                    if (chat != null) {
                        BulletinFactory.createPromoteToAdminBulletin(ChatUsersActivity.this, chat.title).show();
                    }
                }
            }
        };
        final boolean z2 = z;
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: ir.eitaa.ui.ChatUsersActivity.21
            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank2) {
                TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
                TLRPC$ChannelParticipant tLRPC$TL_channelParticipant;
                int i = type;
                if (i != 0) {
                    if (i == 1 && rights == 0) {
                        ChatUsersActivity.this.removeParticipants(peerId);
                        return;
                    }
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= ChatUsersActivity.this.participants.size()) {
                        break;
                    }
                    TLObject tLObject = (TLObject) ChatUsersActivity.this.participants.get(i2);
                    if (tLObject instanceof TLRPC$ChannelParticipant) {
                        if (MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer) == peerId) {
                            if (rights == 1) {
                                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin();
                            } else {
                                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant();
                            }
                            tLRPC$TL_channelParticipant.admin_rights = rightsAdmin;
                            tLRPC$TL_channelParticipant.banned_rights = rightsBanned;
                            tLRPC$TL_channelParticipant.inviter_id = ChatUsersActivity.this.getUserConfig().getClientUserId();
                            if (peerId > 0) {
                                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                                tLRPC$TL_channelParticipant.peer = tLRPC$TL_peerUser;
                                tLRPC$TL_peerUser.user_id = peerId;
                            } else {
                                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                                tLRPC$TL_channelParticipant.peer = tLRPC$TL_peerChannel;
                                tLRPC$TL_peerChannel.channel_id = -peerId;
                            }
                            tLRPC$TL_channelParticipant.date = date;
                            tLRPC$TL_channelParticipant.flags |= 4;
                            tLRPC$TL_channelParticipant.rank = rank2;
                            ChatUsersActivity.this.participants.set(i2, tLRPC$TL_channelParticipant);
                        }
                    } else if (tLObject instanceof TLRPC$ChatParticipant) {
                        TLRPC$ChatParticipant tLRPC$ChatParticipant = (TLRPC$ChatParticipant) tLObject;
                        if (rights == 1) {
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
                    i2++;
                }
                if (rights != 1 || z2) {
                    return;
                }
                zArr[0] = true;
            }

            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didChangeOwner(TLRPC$User user) {
                ChatUsersActivity.this.onOwnerChaged(user);
            }
        });
        presentFragment(chatRightsEditActivity);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean canBeginSlide() {
        return checkDiscard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openRightsEdit(final long user_id, final TLObject participant, TLRPC$TL_chatAdminRights adminRights, TLRPC$TL_chatBannedRights bannedRights, String rank, boolean canEditAdmin, int type, final boolean removeFragment) {
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(user_id, this.chatId, adminRights, this.defaultBannedRights, bannedRights, rank, type, canEditAdmin, participant == null);
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: ir.eitaa.ui.ChatUsersActivity.22
            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank2) {
                TLObject tLObject = participant;
                if (tLObject instanceof TLRPC$ChannelParticipant) {
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject;
                    tLRPC$ChannelParticipant.admin_rights = rightsAdmin;
                    tLRPC$ChannelParticipant.banned_rights = rightsBanned;
                    tLRPC$ChannelParticipant.rank = rank2;
                }
                if (ChatUsersActivity.this.delegate == null || rights != 1) {
                    if (ChatUsersActivity.this.delegate != null) {
                        ChatUsersActivity.this.delegate.didAddParticipantToList(user_id, participant);
                    }
                } else {
                    ChatUsersActivity.this.delegate.didSelectUser(user_id);
                }
                if (removeFragment) {
                    ChatUsersActivity.this.removeSelfFromStack();
                }
            }

            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didChangeOwner(TLRPC$User user) {
                ChatUsersActivity.this.onOwnerChaged(user);
            }
        });
        presentFragment(chatRightsEditActivity, removeFragment);
    }

    private void removeParticipant(long userId) {
        if (ChatObject.isChannel(this.currentChat)) {
            getMessagesController().deleteParticipantFromChat(this.chatId, getMessagesController().getUser(Long.valueOf(userId)), null);
            ChatUsersActivityDelegate chatUsersActivityDelegate = this.delegate;
            if (chatUsersActivityDelegate != null) {
                chatUsersActivityDelegate.didKickParticipant(userId);
            }
            finishFragment();
        }
    }

    private TLObject getAnyParticipant(long userId) {
        LongSparseArray<TLObject> longSparseArray;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                longSparseArray = this.contactsMap;
            } else if (i == 1) {
                longSparseArray = this.botsMap;
            } else {
                longSparseArray = this.participantsMap;
            }
            TLObject tLObject = longSparseArray.get(userId);
            if (tLObject != null) {
                return tLObject;
            }
        }
        return null;
    }

    private void removeParticipants(TLObject object) {
        if (object instanceof TLRPC$ChatParticipant) {
            removeParticipants(((TLRPC$ChatParticipant) object).user_id);
        } else if (object instanceof TLRPC$ChannelParticipant) {
            removeParticipants(MessageObject.getPeerId(((TLRPC$ChannelParticipant) object).peer));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParticipants(long peerId) {
        LongSparseArray<TLObject> longSparseArray;
        ArrayList<TLObject> arrayList;
        DiffCallback diffCallbackSaveState = saveState();
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                longSparseArray = this.contactsMap;
                arrayList = this.contacts;
            } else if (i == 1) {
                longSparseArray = this.botsMap;
                arrayList = this.bots;
            } else {
                longSparseArray = this.participantsMap;
                arrayList = this.participants;
            }
            TLObject tLObject = longSparseArray.get(peerId);
            if (tLObject != null) {
                longSparseArray.remove(peerId);
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
            searchAdapter.removeUserId(peerId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParticipantWithRights(TLRPC$ChannelParticipant channelParticipant, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, long user_id, boolean withDelegate) {
        LongSparseArray<TLObject> longSparseArray;
        ChatUsersActivityDelegate chatUsersActivityDelegate;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                longSparseArray = this.contactsMap;
            } else if (i == 1) {
                longSparseArray = this.botsMap;
            } else {
                longSparseArray = this.participantsMap;
            }
            TLObject tLObject = longSparseArray.get(MessageObject.getPeerId(channelParticipant.peer));
            if (tLObject instanceof TLRPC$ChannelParticipant) {
                channelParticipant = (TLRPC$ChannelParticipant) tLObject;
                channelParticipant.admin_rights = rightsAdmin;
                channelParticipant.banned_rights = rightsBanned;
                if (withDelegate) {
                    channelParticipant.promoted_by = getUserConfig().getClientUserId();
                }
            }
            if (withDelegate && tLObject != null && !z && (chatUsersActivityDelegate = this.delegate) != null) {
                chatUsersActivityDelegate.didAddParticipantToList(user_id, tLObject);
                z = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean createMenuForParticipant(final ir.eitaa.tgnet.TLObject r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.createMenuForParticipant(ir.eitaa.tgnet.TLObject, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenuForParticipant$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenuForParticipant$6$ChatUsersActivity(final ArrayList arrayList, TLRPC$User tLRPC$User, final long j, final boolean z, final TLObject tLObject, final int i, final TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final String str, DialogInterface dialogInterface, final int i2) {
        if (((Integer) arrayList.get(i2)).intValue() == 2) {
            getMessagesController().deleteParticipantFromChat(this.chatId, tLRPC$User, null);
            removeParticipants(j);
            if (this.currentChat == null || tLRPC$User == null || !BulletinFactory.canShowBulletin(this)) {
                return;
            }
            BulletinFactory.createRemoveFromChatBulletin(this, tLRPC$User, this.currentChat.title).show();
            return;
        }
        if (((Integer) arrayList.get(i2)).intValue() == 1 && z && ((tLObject instanceof TLRPC$TL_channelParticipantAdmin) || (tLObject instanceof TLRPC$TL_chatParticipantAdmin))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.formatString("AdminWillBeRemoved", R.string.AdminWillBeRemoved, UserObject.getUserName(tLRPC$User)));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$HZlLSjbcLA6zgamXdpgfB2o8ow4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i3) {
                    this.f$0.lambda$createMenuForParticipant$5$ChatUsersActivity(j, i, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, arrayList, i2, dialogInterface2, i3);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        openRightsEdit2(j, i, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, ((Integer) arrayList.get(i2)).intValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenuForParticipant$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenuForParticipant$5$ChatUsersActivity(long j, int i, TLObject tLObject, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, boolean z, ArrayList arrayList, int i2, DialogInterface dialogInterface, int i3) {
        openRightsEdit2(j, i, tLObject, tLRPC$TL_chatAdminRights, tLRPC$TL_chatBannedRights, str, z, ((Integer) arrayList.get(i2)).intValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenuForParticipant$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenuForParticipant$9$ChatUsersActivity(CharSequence[] charSequenceArr, long j, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, String str, final TLObject tLObject, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        TLRPC$Chat chat;
        int i4 = this.type;
        if (i4 == 1) {
            if (i == 0 && charSequenceArr.length == 2) {
                ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(j, this.chatId, tLRPC$TL_chatAdminRights, null, null, str, 0, true, false);
                chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: ir.eitaa.ui.ChatUsersActivity.23
                    @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                    public void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank) {
                        TLObject tLObject2 = tLObject;
                        if (tLObject2 instanceof TLRPC$ChannelParticipant) {
                            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject2;
                            tLRPC$ChannelParticipant.admin_rights = rightsAdmin;
                            tLRPC$ChannelParticipant.banned_rights = rightsBanned;
                            tLRPC$ChannelParticipant.rank = rank;
                            ChatUsersActivity.this.updateParticipantWithRights(tLRPC$ChannelParticipant, rightsAdmin, rightsBanned, 0L, false);
                        }
                    }

                    @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                    public void didChangeOwner(TLRPC$User user) {
                        ChatUsersActivity.this.onOwnerChaged(user);
                    }
                });
                presentFragment(chatRightsEditActivity);
                return;
            } else {
                getMessagesController().setUserAdminRole(this.chatId, getMessagesController().getUser(Long.valueOf(j)), new TLRPC$TL_chatAdminRights(), "", true ^ this.isChannel, this, false);
                removeParticipants(j);
                return;
            }
        }
        if (i4 != 0 && i4 != 3) {
            if (i == 0) {
                TLRPC$User user = null;
                if (j > 0) {
                    chat = null;
                    user = getMessagesController().getUser(Long.valueOf(j));
                } else {
                    chat = getMessagesController().getChat(Long.valueOf(-j));
                }
                getMessagesController().deleteParticipantFromChat(this.chatId, user, chat, null, false, false);
                return;
            }
            return;
        }
        if (i == 0) {
            if (i4 == 3) {
                ChatRightsEditActivity chatRightsEditActivity2 = new ChatRightsEditActivity(j, this.chatId, null, this.defaultBannedRights, tLRPC$TL_chatBannedRights, str, 1, true, false);
                chatRightsEditActivity2.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: ir.eitaa.ui.ChatUsersActivity.24
                    @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                    public void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank) {
                        TLObject tLObject2 = tLObject;
                        if (tLObject2 instanceof TLRPC$ChannelParticipant) {
                            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject2;
                            tLRPC$ChannelParticipant.admin_rights = rightsAdmin;
                            tLRPC$ChannelParticipant.banned_rights = rightsBanned;
                            tLRPC$ChannelParticipant.rank = rank;
                            ChatUsersActivity.this.updateParticipantWithRights(tLRPC$ChannelParticipant, rightsAdmin, rightsBanned, 0L, false);
                        }
                    }

                    @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
                    public void didChangeOwner(TLRPC$User user2) {
                        ChatUsersActivity.this.onOwnerChaged(user2);
                    }
                });
                presentFragment(chatRightsEditActivity2);
            } else if (i4 == 0 && j > 0) {
                i3 = 1;
                i2 = i;
                getMessagesController().addUserToChat(this.chatId, getMessagesController().getUser(Long.valueOf(j)), 0, null, this, null);
            }
            i2 = i;
            i3 = 1;
        } else {
            i2 = i;
            i3 = 1;
            if (i2 == 1) {
                TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned = new TLRPC$TL_channels_editBanned();
                tLRPC$TL_channels_editBanned.participant = getMessagesController().getInputPeer(j);
                tLRPC$TL_channels_editBanned.channel = getMessagesController().getInputChannel(this.chatId);
                tLRPC$TL_channels_editBanned.banned_rights = new TLRPC$TL_chatBannedRights();
                getConnectionsManager().sendRequest(tLRPC$TL_channels_editBanned, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$BdOJBQvVhy8d9ba9tuOWllg4Z3E
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$createMenuForParticipant$8$ChatUsersActivity(tLObject2, tLRPC$TL_error);
                    }
                });
            }
        }
        if ((i2 == 0 && this.type == 0) || i2 == i3) {
            removeParticipants(tLObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenuForParticipant$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenuForParticipant$8$ChatUsersActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            getMessagesController().processUpdates(tLRPC$Updates, false);
            if (tLRPC$Updates.chats.isEmpty()) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$ujoHb588ReMKrDoeTYe9eWPUVgA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createMenuForParticipant$7$ChatUsersActivity(tLRPC$Updates);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenuForParticipant$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenuForParticipant$7$ChatUsersActivity(TLRPC$Updates tLRPC$Updates) {
        getMessagesController().loadFullChat(tLRPC$Updates.chats.get(0).id, 0, true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
            boolean zBooleanValue = ((Boolean) args[2]).booleanValue();
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$t7EuyT6xAaQSq-a6TmQgMhPx4RU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$10$ChatUsersActivity();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$10$ChatUsersActivity() {
        loadChatParticipants(0, 200);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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
    public String formatSeconds(int seconds) {
        if (seconds < 60) {
            return LocaleController.formatPluralString("Seconds", seconds);
        }
        if (seconds < 3600) {
            return LocaleController.formatPluralString("Minutes", seconds / 60);
        }
        return LocaleController.formatPluralString("Hours", (seconds / 60) / 60);
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
        builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$s0c4cZuAURXTW1Nha4Z3xwYwQZo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$11$ChatUsersActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$jlk8yS1MzbXmKogQo0h_G2ZU3QA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$12$ChatUsersActivity(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$11$ChatUsersActivity(DialogInterface dialogInterface, int i) {
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$12$ChatUsersActivity(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    public boolean hasSelectType() {
        return this.selectType != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatUserPermissions(TLRPC$TL_chatBannedRights rights) {
        if (rights == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = rights.view_messages;
        if (z && this.defaultBannedRights.view_messages != z) {
            sb.append(LocaleController.getString("UserRestrictionsNoRead", R.string.UserRestrictionsNoRead));
        }
        boolean z2 = rights.send_messages;
        if (z2 && this.defaultBannedRights.send_messages != z2) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSend", R.string.UserRestrictionsNoSend));
        }
        boolean z3 = rights.send_media;
        if (z3 && this.defaultBannedRights.send_media != z3) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSendMedia", R.string.UserRestrictionsNoSendMedia));
        }
        boolean z4 = rights.send_stickers;
        if (z4 && this.defaultBannedRights.send_stickers != z4) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSendStickers", R.string.UserRestrictionsNoSendStickers));
        }
        boolean z5 = rights.send_polls;
        if (z5 && this.defaultBannedRights.send_polls != z5) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoSendPolls", R.string.UserRestrictionsNoSendPolls));
        }
        boolean z6 = rights.embed_links;
        if (z6 && this.defaultBannedRights.embed_links != z6) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoEmbedLinks", R.string.UserRestrictionsNoEmbedLinks));
        }
        boolean z7 = rights.invite_users;
        if (z7 && this.defaultBannedRights.invite_users != z7) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoInviteUsers", R.string.UserRestrictionsNoInviteUsers));
        }
        boolean z8 = rights.pin_messages;
        if (z8 && this.defaultBannedRights.pin_messages != z8) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(LocaleController.getString("UserRestrictionsNoPinMessages", R.string.UserRestrictionsNoPinMessages));
        }
        boolean z9 = rights.change_info;
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
            MessagesController.getInstance(this.currentAccount).convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.LongCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$v0XkECKgZllGtj2k15GBmBqUKDk
                @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                public final void run(long j) {
                    this.f$0.lambda$processDone$13$ChatUsersActivity(j);
                }
            });
            return;
        }
        if (!ChatObject.getBannedRightsString(this.defaultBannedRights).equals(this.initialBannedRights)) {
            getMessagesController().setDefaultBannedRole(this.chatId, this.defaultBannedRights, ChatObject.isChannel(this.currentChat), this);
            TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.chatId));
            if (chat != null) {
                chat.default_banned_rights = this.defaultBannedRights;
            }
        }
        int i = this.selectedSlowmode;
        if (i != this.initialSlowmode && (tLRPC$ChatFull = this.info) != null) {
            tLRPC$ChatFull.slowmode_seconds = getSecondsForIndex(i);
            this.info.flags |= 131072;
            getMessagesController().setChannelSlowMode(this.chatId, this.info.slowmode_seconds);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$13$ChatUsersActivity(long j) {
        if (j != 0) {
            this.chatId = j;
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(j));
            processDone();
        }
    }

    public void setInfo(TLRPC$ChatFull chatFull) {
        this.info = chatFull;
        if (chatFull != null) {
            int currentSlowmode = getCurrentSlowmode();
            this.initialSlowmode = currentSlowmode;
            this.selectedSlowmode = currentSlowmode;
        }
    }

    private int getChannelAdminParticipantType(TLObject participant) {
        if ((participant instanceof TLRPC$TL_channelParticipantCreator) || (participant instanceof TLRPC$TL_channelParticipantSelf)) {
            return 0;
        }
        return ((participant instanceof TLRPC$TL_channelParticipantAdmin) || (participant instanceof TLRPC$TL_channelParticipant)) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadChatParticipants(int offset, int count) {
        if (this.loadingUsers) {
            return;
        }
        this.contactsEndReached = false;
        this.botsEndReached = false;
        loadChatParticipants(offset, count, true);
    }

    private void loadChatParticipants(int offset, int count, boolean reset) {
        TLRPC$Chat tLRPC$Chat;
        LongSparseArray<TLRPC$TL_groupCallParticipant> longSparseArray;
        int i = 0;
        if (!ChatObject.isChannel(this.currentChat)) {
            this.loadingUsers = false;
            this.participants.clear();
            this.bots.clear();
            this.contacts.clear();
            this.participantsMap.clear();
            this.contactsMap.clear();
            this.botsMap.clear();
            int i2 = this.type;
            if (i2 == 1) {
                TLRPC$ChatFull tLRPC$ChatFull = this.info;
                if (tLRPC$ChatFull != null) {
                    int size = tLRPC$ChatFull.participants.participants.size();
                    while (i < size) {
                        TLRPC$ChatParticipant tLRPC$ChatParticipant = this.info.participants.participants.get(i);
                        if ((tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantCreator) || (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin)) {
                            this.participants.add(tLRPC$ChatParticipant);
                        }
                        this.participantsMap.put(tLRPC$ChatParticipant.user_id, tLRPC$ChatParticipant);
                        i++;
                    }
                }
            } else if (i2 == 2 && this.info != null) {
                long j = getUserConfig().clientUserId;
                int size2 = this.info.participants.participants.size();
                while (i < size2) {
                    TLRPC$ChatParticipant tLRPC$ChatParticipant2 = this.info.participants.participants.get(i);
                    if ((this.selectType == 0 || tLRPC$ChatParticipant2.user_id != j) && ((longSparseArray = this.ignoredUsers) == null || longSparseArray.indexOfKey(tLRPC$ChatParticipant2.user_id) < 0)) {
                        if (this.selectType == 1) {
                            if (getContactsController().isContact(tLRPC$ChatParticipant2.user_id)) {
                                this.contacts.add(tLRPC$ChatParticipant2);
                                this.contactsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            } else if (!UserObject.isDeleted(getMessagesController().getUser(Long.valueOf(tLRPC$ChatParticipant2.user_id)))) {
                                this.participants.add(tLRPC$ChatParticipant2);
                                this.participantsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            }
                        } else if (getContactsController().isContact(tLRPC$ChatParticipant2.user_id)) {
                            this.contacts.add(tLRPC$ChatParticipant2);
                            this.contactsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                        } else {
                            TLRPC$User user = getMessagesController().getUser(Long.valueOf(tLRPC$ChatParticipant2.user_id));
                            if (user != null && user.bot) {
                                this.bots.add(tLRPC$ChatParticipant2);
                                this.botsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            } else {
                                this.participants.add(tLRPC$ChatParticipant2);
                                this.participantsMap.put(tLRPC$ChatParticipant2.user_id, tLRPC$ChatParticipant2);
                            }
                        }
                    }
                    i++;
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
        int i3 = this.type;
        if (i3 == 0) {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsKicked();
        } else if (i3 == 1) {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsAdmins();
        } else if (i3 == 2) {
            TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
            if (tLRPC$ChatFull2 != null && tLRPC$ChatFull2.participants_count <= 200 && (tLRPC$Chat = this.currentChat) != null && tLRPC$Chat.megagroup) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
            } else if (this.selectType == 1) {
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
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$ChannelParticipantsFilter() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantsBots
                    public static int constructor = -1328445861;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream) {
                        stream.writeInt32(constructor);
                    }
                };
                this.botsEndReached = true;
                loadChatParticipants(0, 200, false);
            } else {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
            }
        } else if (i3 == 3) {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsBanned();
        }
        tLRPC$TL_channels_getParticipants.filter.q = "";
        tLRPC$TL_channels_getParticipants.offset = offset;
        tLRPC$TL_channels_getParticipants.limit = count;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$VkyFuykL3JPMq24y5gxVYt7ipOE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChatParticipants$15$ChatUsersActivity(tLRPC$TL_channels_getParticipants, tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChatParticipants$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChatParticipants$15$ChatUsersActivity(final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$50gtMiNSKdcPCTwxKKWsjH9y08o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatParticipants$14$ChatUsersActivity(tLRPC$TL_error, tLObject, tLRPC$TL_channels_getParticipants);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0144 -> B:98:0x0147). Please report as a decompilation issue!!! */
    /* renamed from: lambda$loadChatParticipants$14, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadChatParticipants$14$ChatUsersActivity(ir.eitaa.tgnet.TLRPC$TL_error r9, ir.eitaa.tgnet.TLObject r10, ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants r11) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.lambda$loadChatParticipants$14$ChatUsersActivity(ir.eitaa.tgnet.TLRPC$TL_error, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortUsers(ArrayList<TLObject> objects) {
        Collections.sort(objects, new $$Lambda$ChatUsersActivity$3QZXr67l2Fc_MEYVZxCbhJMY5Y0(this, getConnectionsManager().getCurrentTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sortUsers$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$sortUsers$16$ChatUsersActivity(int i, TLObject tLObject, TLObject tLObject2) {
        int i2;
        TLRPC$UserStatus tLRPC$UserStatus;
        TLRPC$UserStatus tLRPC$UserStatus2;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant2 = (TLRPC$ChannelParticipant) tLObject2;
        long peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
        long peerId2 = MessageObject.getPeerId(tLRPC$ChannelParticipant2.peer);
        int i3 = -100;
        if (peerId > 0) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer)));
            if (user == null || (tLRPC$UserStatus2 = user.status) == null) {
                i2 = 0;
            } else {
                i2 = user.self ? i + 50000 : tLRPC$UserStatus2.expires;
            }
        } else {
            i2 = -100;
        }
        if (peerId2 > 0) {
            TLRPC$User user2 = getMessagesController().getUser(Long.valueOf(MessageObject.getPeerId(tLRPC$ChannelParticipant2.peer)));
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            this.openTransitionStarted = true;
        }
        if (isOpen && !backward && this.needOpenSearch) {
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
        private LongSparseArray<TLObject> searchResultMap = new LongSparseArray<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private int totalCount = 0;

        public SearchAdapter(Context context) {
            this.mContext = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SearchAdapter$fAiXO_dqE2p6NWXQHlSnYkT20p0
                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i) {
                    this.f$0.lambda$new$0$ChatUsersActivity$SearchAdapter(i);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ChatUsersActivity$SearchAdapter(int i) {
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

        public void searchUsers(final String query) throws InterruptedException {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            this.searchResult.clear();
            this.searchResultMap.clear();
            this.searchResultNames.clear();
            this.searchAdapterHelper.mergeResults(null);
            this.searchAdapterHelper.queryServerSearch(null, ChatUsersActivity.this.type != 0, false, true, false, false, ChatObject.isChannel(ChatUsersActivity.this.currentChat) ? ChatUsersActivity.this.chatId : 0L, false, ChatUsersActivity.this.type, 0);
            notifyDataSetChanged();
            if (TextUtils.isEmpty(query)) {
                return;
            }
            this.searchInProgress = true;
            ChatUsersActivity.this.emptyView.showProgress(true, true);
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SearchAdapter$YJas0Y5CQxGCyBaWclcl6ZMHQHM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchUsers$1$ChatUsersActivity$SearchAdapter(query);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$searchUsers$1$ChatUsersActivity$SearchAdapter(final String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SearchAdapter$E2LlCN3yJ1xvxiCtpjdbicC4yiw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$3$ChatUsersActivity$SearchAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$3$ChatUsersActivity$SearchAdapter(final String str) {
            this.searchRunnable = null;
            final ArrayList arrayList = (ChatObject.isChannel(ChatUsersActivity.this.currentChat) || ChatUsersActivity.this.info == null) ? null : new ArrayList(ChatUsersActivity.this.info.participants.participants);
            final ArrayList arrayList2 = ChatUsersActivity.this.selectType == 1 ? new ArrayList(ChatUsersActivity.this.getContactsController().contacts) : null;
            if (arrayList != null || arrayList2 != null) {
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SearchAdapter$bFqfmnRfRmt9UpZELtywoCACONQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processSearch$2$ChatUsersActivity$SearchAdapter(str, arrayList, arrayList2);
                    }
                });
            } else {
                this.searchInProgress = false;
            }
            this.searchAdapterHelper.queryServerSearch(str, ChatUsersActivity.this.selectType != 0, false, true, false, false, ChatObject.isChannel(ChatUsersActivity.this.currentChat) ? ChatUsersActivity.this.chatId : 0L, false, ChatUsersActivity.this.type, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:104:0x02a1 A[LOOP:3: B:81:0x020d->B:104:0x02a1, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x0153 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0259 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0188 A[LOOP:1: B:39:0x0100->B:64:0x0188, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0256  */
        /* JADX WARN: Type inference failed for: r15v1 */
        /* JADX WARN: Type inference failed for: r15v2 */
        /* JADX WARN: Type inference failed for: r15v3, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r15v4 */
        /* JADX WARN: Type inference failed for: r15v6 */
        /* JADX WARN: Type inference failed for: r15v7 */
        /* JADX WARN: Type inference failed for: r15v8 */
        /* JADX WARN: Type inference failed for: r6v8, types: [androidx.collection.LongSparseArray] */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v21 */
        /* JADX WARN: Type inference failed for: r9v23 */
        /* renamed from: lambda$processSearch$2, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$2$ChatUsersActivity$SearchAdapter(java.lang.String r24, java.util.ArrayList r25, java.util.ArrayList r26) {
            /*
                Method dump skipped, instructions count: 706
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.SearchAdapter.lambda$processSearch$2$ChatUsersActivity$SearchAdapter(java.lang.String, java.util.ArrayList, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<Object> users, final LongSparseArray<TLObject> usersMap, final ArrayList<CharSequence> names, final ArrayList<TLObject> participants) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SearchAdapter$D5vVrtGCMu_WxY3P7U7AmJtUn-U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4$ChatUsersActivity$SearchAdapter(users, usersMap, names, participants);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$4$ChatUsersActivity$SearchAdapter(ArrayList arrayList, LongSparseArray longSparseArray, ArrayList arrayList2, ArrayList arrayList3) {
            if (ChatUsersActivity.this.searching) {
                this.searchInProgress = false;
                this.searchResult = arrayList;
                this.searchResultMap = longSparseArray;
                this.searchResultNames = arrayList2;
                this.searchAdapterHelper.mergeResults(arrayList);
                if (!ChatObject.isChannel(ChatUsersActivity.this.currentChat)) {
                    ArrayList<TLObject> groupSearch = this.searchAdapterHelper.getGroupSearch();
                    groupSearch.clear();
                    groupSearch.addAll(arrayList3);
                }
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != 1;
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

        public void removeUserId(long userId) {
            this.searchAdapterHelper.removeUserId(userId);
            TLObject tLObject = this.searchResultMap.get(userId);
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
        /* renamed from: lambda$onCreateViewHolder$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$5$ChatUsersActivity$SearchAdapter(ManageChatUserCell manageChatUserCell, boolean z) {
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
                manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SearchAdapter$3kxxl3tJDGdVEPJqKL5EyIr7bwo
                    @Override // ir.eitaa.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                    public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                        return this.f$0.lambda$onCreateViewHolder$5$ChatUsersActivity$SearchAdapter(manageChatUserCell2, z);
                    }
                });
                graySectionCell = manageChatUserCell;
            } else {
                graySectionCell = new GraySectionCell(this.mContext);
            }
            return new RecyclerListView.Holder(graySectionCell);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x013c  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r17, int r18) {
            /*
                Method dump skipped, instructions count: 460
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.SearchAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 7) {
                return ChatObject.canChangeChatInfo(ChatUsersActivity.this.currentChat);
            }
            if (itemViewType != 0) {
                return itemViewType == 0 || itemViewType == 2 || itemViewType == 6;
            }
            Object currentObject = ((ManageChatUserCell) holder.itemView).getCurrentObject();
            return (ChatUsersActivity.this.type != 1 && (currentObject instanceof TLRPC$User) && ((TLRPC$User) currentObject).self) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChatUsersActivity.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0$ChatUsersActivity$ListAdapter(ManageChatUserCell manageChatUserCell, boolean z) {
            return ChatUsersActivity.this.createMenuForParticipant(ChatUsersActivity.this.listViewAdapter.getItem(((Integer) manageChatUserCell.getTag()).intValue()), !z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$1$ChatUsersActivity$ListAdapter(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
            Browser.performAdAction(this.mContext, tLRPC$Ads_Ad, ChatUsersActivity.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View loadingCell;
            TLRPC$InputPeer tLRPC$TL_inputPeerChat;
            if (i != 10) {
                int i2 = 6;
                if (i == 11) {
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setViewType(6);
                    flickerLoadingView.showDate(false);
                    flickerLoadingView.setPaddingLeft(AndroidUtilities.dp(5.0f));
                    flickerLoadingView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    flickerLoadingView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    loadingCell = flickerLoadingView;
                } else if (i != 1399) {
                    switch (i) {
                        case 0:
                            Context context = this.mContext;
                            int i3 = (ChatUsersActivity.this.type == 0 || ChatUsersActivity.this.type == 3) ? 7 : 6;
                            if (ChatUsersActivity.this.type != 0 && ChatUsersActivity.this.type != 3) {
                                i2 = 2;
                            }
                            ManageChatUserCell manageChatUserCell = new ManageChatUserCell(context, i3, i2, ChatUsersActivity.this.selectType == 0);
                            manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$ListAdapter$Lu2P_v1SKliy0tUof1YKuhcePWw
                                @Override // ir.eitaa.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                                public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                                    return this.f$0.lambda$onCreateViewHolder$0$ChatUsersActivity$ListAdapter(manageChatUserCell2, z);
                                }
                            });
                            loadingCell = manageChatUserCell;
                            break;
                        case 1:
                            loadingCell = new TextInfoPrivacyCell(this.mContext);
                            break;
                        case 2:
                            View manageChatTextCell = new ManageChatTextCell(this.mContext);
                            manageChatTextCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            loadingCell = manageChatTextCell;
                            break;
                        case 3:
                            loadingCell = new ShadowSectionCell(this.mContext);
                            break;
                        case 4:
                            FrameLayout frameLayout = new FrameLayout(this.mContext) { // from class: ir.eitaa.ui.ChatUsersActivity.ListAdapter.1
                                @Override // android.widget.FrameLayout, android.view.View
                                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec) - AndroidUtilities.dp(56.0f), 1073741824));
                                }
                            };
                            frameLayout.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                            LinearLayout linearLayout = new LinearLayout(this.mContext);
                            linearLayout.setOrientation(1);
                            frameLayout.addView(linearLayout, LayoutHelper.createFrame(-2, -2.0f, 17, 20.0f, 0.0f, 20.0f, 0.0f));
                            ImageView imageView = new ImageView(this.mContext);
                            imageView.setImageResource(R.drawable.group_ban_empty);
                            imageView.setScaleType(ImageView.ScaleType.CENTER);
                            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("emptyListPlaceholder"), PorterDuff.Mode.MULTIPLY));
                            linearLayout.addView(imageView, LayoutHelper.createLinear(-2, -2, 1));
                            TextView textView = new TextView(this.mContext);
                            textView.setText(LocaleController.getString("NoBlockedUsers", R.string.NoBlockedUsers));
                            textView.setTextColor(Theme.getColor("emptyListPlaceholder"));
                            textView.setTextSize(1, 16.0f);
                            textView.setGravity(1);
                            textView.setTypeface(AndroidUtilities.getFontFamily(true));
                            linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 1, 0, 10, 0, 0));
                            TextView textView2 = new TextView(this.mContext);
                            if (ChatUsersActivity.this.isChannel) {
                                textView2.setText(LocaleController.getString("NoBlockedChannel2", R.string.NoBlockedChannel2));
                            } else {
                                textView2.setText(LocaleController.getString("NoBlockedGroup2", R.string.NoBlockedGroup2));
                            }
                            textView2.setTextColor(Theme.getColor("emptyListPlaceholder"));
                            textView2.setTextSize(1, 15.0f);
                            textView2.setGravity(1);
                            linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 1, 0, 10, 0, 0));
                            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                            loadingCell = frameLayout;
                            break;
                        case 5:
                            HeaderCell headerCell = new HeaderCell(this.mContext, "windowBackgroundWhiteBlueHeader", 21, 11, false);
                            headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            headerCell.setHeight(43);
                            loadingCell = headerCell;
                            break;
                        case 6:
                            View textSettingsCell = new TextSettingsCell(this.mContext);
                            textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            loadingCell = textSettingsCell;
                            break;
                        case 7:
                            View textCheckCell2 = new TextCheckCell2(this.mContext);
                            textCheckCell2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            loadingCell = textCheckCell2;
                            break;
                        case 8:
                            View graySectionCell = new GraySectionCell(this.mContext);
                            graySectionCell.setBackground(null);
                            loadingCell = graySectionCell;
                            break;
                        default:
                            View chooseView = ChatUsersActivity.this.new ChooseView(this.mContext);
                            chooseView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            loadingCell = chooseView;
                            break;
                    }
                } else {
                    ChatUsersActivity.this.simpleAds = new SimpleAdsList(this.mContext);
                    ChatUsersActivity.this.simpleAds.setDelegate(new SimpleAdsList.Delegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$ListAdapter$pMoHjc3gUah-AWUJ_zSGEnoQgS4
                        @Override // ir.eitaa.ui.Components.SimpleAdsList.Delegate
                        public final void onAdClicked(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
                            this.f$0.lambda$onCreateViewHolder$1$ChatUsersActivity$ListAdapter(tLRPC$Ads_Ad);
                        }
                    });
                    ChatUsersActivity.this.simpleAds.location = new TLRPC$TL_ads_inputAdsLocationChatMembers();
                    if (ChatObject.isChannel(ChatUsersActivity.this.currentChat)) {
                        tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChannel();
                        tLRPC$TL_inputPeerChat.channel_id = ChatUsersActivity.this.currentChat.id;
                        tLRPC$TL_inputPeerChat.access_hash = ChatUsersActivity.this.currentChat.access_hash;
                    } else {
                        tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                        tLRPC$TL_inputPeerChat.chat_id = ChatUsersActivity.this.currentChat.id;
                    }
                    ChatUsersActivity.this.simpleAds.location.peer = tLRPC$TL_inputPeerChat;
                    View view = ChatUsersActivity.this.simpleAds;
                    view.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    loadingCell = view;
                }
            } else {
                loadingCell = new LoadingCell(this.mContext, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(120.0f));
            }
            return new RecyclerListView.Holder(loadingCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:283:0x0714 A[PHI: r9
          0x0714: PHI (r9v17 int) = (r9v9 int), (r9v21 int) binds: [B:291:0x0740, B:282:0x0712] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:341:0x085c  */
        /* JADX WARN: Removed duplicated region for block: B:342:0x085f  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r21, int r22) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 2188
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatUsersActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ChatUsersActivity.this.addNewRow || position == ChatUsersActivity.this.addNew2Row || position == ChatUsersActivity.this.recentActionsRow || position == ChatUsersActivity.this.gigaConvertRow) {
                return 2;
            }
            if ((position >= ChatUsersActivity.this.participantsStartRow && position < ChatUsersActivity.this.participantsEndRow) || ((position >= ChatUsersActivity.this.botStartRow && position < ChatUsersActivity.this.botEndRow) || (position >= ChatUsersActivity.this.contactsStartRow && position < ChatUsersActivity.this.contactsEndRow))) {
                return 0;
            }
            if (position == ChatUsersActivity.this.addNewSectionRow || position == ChatUsersActivity.this.participantsDividerRow || position == ChatUsersActivity.this.participantsDivider2Row || position == ChatUsersActivity.this.adSectionRow) {
                return 3;
            }
            if (position == ChatUsersActivity.this.restricted1SectionRow || position == ChatUsersActivity.this.permissionsSectionRow || position == ChatUsersActivity.this.slowmodeRow || position == ChatUsersActivity.this.gigaHeaderRow) {
                return 5;
            }
            if (position == ChatUsersActivity.this.participantsInfoRow || position == ChatUsersActivity.this.slowmodeInfoRow || position == ChatUsersActivity.this.gigaInfoRow) {
                return 1;
            }
            if (position == ChatUsersActivity.this.blockedEmptyRow) {
                return 4;
            }
            if (position == ChatUsersActivity.this.removedUsersRow || position == ChatUsersActivity.this.untilDateRow) {
                return 6;
            }
            if (position == ChatUsersActivity.this.changeInfoRow || position == ChatUsersActivity.this.addUsersRow || position == ChatUsersActivity.this.pinMessagesRow || position == ChatUsersActivity.this.sendMessagesRow || position == ChatUsersActivity.this.sendForwardedMessagesRow || position == ChatUsersActivity.this.sendMediaRow || position == ChatUsersActivity.this.sendStickersRow || position == ChatUsersActivity.this.embedLinksRow || position == ChatUsersActivity.this.sendPollsRow || position == ChatUsersActivity.this.viewParticipantsRow) {
                return 7;
            }
            if (position == ChatUsersActivity.this.membersHeaderRow || position == ChatUsersActivity.this.contactsHeaderRow || position == ChatUsersActivity.this.botHeaderRow || position == ChatUsersActivity.this.loadingHeaderRow) {
                return 8;
            }
            if (position == ChatUsersActivity.this.slowmodeSelectRow) {
                return 9;
            }
            if (position == ChatUsersActivity.this.loadingProgressRow) {
                return 10;
            }
            if (position == ChatUsersActivity.this.loadingUserCellRow) {
                return 11;
            }
            return position == ChatUsersActivity.this.adRow ? 1399 : 0;
        }

        public TLObject getItem(int position) {
            if (position < ChatUsersActivity.this.participantsStartRow || position >= ChatUsersActivity.this.participantsEndRow) {
                if (position < ChatUsersActivity.this.contactsStartRow || position >= ChatUsersActivity.this.contactsEndRow) {
                    if (position < ChatUsersActivity.this.botStartRow || position >= ChatUsersActivity.this.botEndRow) {
                        return null;
                    }
                    return (TLObject) ChatUsersActivity.this.bots.get(position - ChatUsersActivity.this.botStartRow);
                }
                return (TLObject) ChatUsersActivity.this.contacts.get(position - ChatUsersActivity.this.contactsStartRow);
            }
            return (TLObject) ChatUsersActivity.this.participants.get(position - ChatUsersActivity.this.participantsStartRow);
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

    public void updateListAnimated(DiffCallback savedState) {
        if (this.listViewAdapter == null) {
            updateRows();
            return;
        }
        updateRows();
        savedState.fillPositions(savedState.newPositionToItem);
        DiffUtil.calculateDiff(savedState).dispatchUpdatesTo(this.listViewAdapter);
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
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            if (oldItemPosition >= this.oldBotStartRow && oldItemPosition < this.oldBotEndRow && newItemPosition >= ChatUsersActivity.this.botStartRow && newItemPosition < ChatUsersActivity.this.botEndRow) {
                return this.oldBots.get(oldItemPosition - this.oldBotStartRow).equals(ChatUsersActivity.this.bots.get(newItemPosition - ChatUsersActivity.this.botStartRow));
            }
            if (oldItemPosition >= this.oldContactsStartRow && oldItemPosition < this.oldContactsEndRow && newItemPosition >= ChatUsersActivity.this.contactsStartRow && newItemPosition < ChatUsersActivity.this.contactsEndRow) {
                return this.oldContacts.get(oldItemPosition - this.oldContactsStartRow).equals(ChatUsersActivity.this.contacts.get(newItemPosition - ChatUsersActivity.this.contactsStartRow));
            }
            if (oldItemPosition < this.oldParticipantsStartRow || oldItemPosition >= this.oldParticipantsEndRow || newItemPosition < ChatUsersActivity.this.participantsStartRow || newItemPosition >= ChatUsersActivity.this.participantsEndRow) {
                return this.oldPositionToItem.get(oldItemPosition) == this.newPositionToItem.get(newItemPosition);
            }
            return this.oldParticipants.get(oldItemPosition - this.oldParticipantsStartRow).equals(ChatUsersActivity.this.participants.get(newItemPosition - ChatUsersActivity.this.participantsStartRow));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition) && ChatUsersActivity.this.restricted1SectionRow != newItemPosition;
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
            put(20, ChatUsersActivity.this.pinMessagesRow, sparseIntArray);
            put(21, ChatUsersActivity.this.changeInfoRow, sparseIntArray);
            put(22, ChatUsersActivity.this.removedUsersRow, sparseIntArray);
            put(23, ChatUsersActivity.this.contactsHeaderRow, sparseIntArray);
            put(24, ChatUsersActivity.this.botHeaderRow, sparseIntArray);
            put(25, ChatUsersActivity.this.membersHeaderRow, sparseIntArray);
            put(26, ChatUsersActivity.this.slowmodeRow, sparseIntArray);
            put(27, ChatUsersActivity.this.slowmodeSelectRow, sparseIntArray);
            put(28, ChatUsersActivity.this.slowmodeInfoRow, sparseIntArray);
            put(29, ChatUsersActivity.this.loadingProgressRow, sparseIntArray);
            put(30, ChatUsersActivity.this.loadingUserCellRow, sparseIntArray);
            put(31, ChatUsersActivity.this.loadingHeaderRow, sparseIntArray);
        }

        private void put(int id, int position, SparseIntArray sparseIntArray) {
            if (position >= 0) {
                sparseIntArray.put(position, id);
            }
        }
    }

    private void loadAds() {
        TLRPC$InputPeer tLRPC$TL_inputPeerChat;
        if (this.currentChat == null || this.type != 2) {
            return;
        }
        TLRPC$TL_ads_getAdsPack tLRPC$TL_ads_getAdsPack = new TLRPC$TL_ads_getAdsPack();
        tLRPC$TL_ads_getAdsPack.location = new TLRPC$TL_ads_inputAdsLocationChatMembers();
        if (ChatObject.isChannel(this.currentChat)) {
            tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChannel();
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            tLRPC$TL_inputPeerChat.channel_id = tLRPC$Chat.id;
            tLRPC$TL_inputPeerChat.access_hash = tLRPC$Chat.access_hash;
        } else {
            tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = this.currentChat.id;
        }
        tLRPC$TL_ads_getAdsPack.location.peer = tLRPC$TL_inputPeerChat;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_ads_getAdsPack, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$tube7B41sYUETtTpBFPrdJoqGsI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAds$19$ChatUsersActivity(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$19$ChatUsersActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$xgxJlgbbpz4BneWuiPaVpb2awz8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAds$18$ChatUsersActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$18$ChatUsersActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            final TLRPC$TL_ads_AdPack tLRPC$TL_ads_AdPack = (TLRPC$TL_ads_AdPack) tLObject;
            final ArrayList arrayList = new ArrayList();
            Iterator<TLRPC$Ads_Ad> it = tLRPC$TL_ads_AdPack.ads.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            ImageLoader.saveAdsThumbs(arrayList);
            if (arrayList.size() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$SvvyvBYUdnxuB7Thadk9vvQhCC0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadAds$17$ChatUsersActivity(arrayList, tLRPC$TL_ads_AdPack);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$17$ChatUsersActivity(ArrayList arrayList, TLRPC$TL_ads_AdPack tLRPC$TL_ads_AdPack) {
        this.hasAds = true;
        SimpleAdsList simpleAdsList = this.simpleAds;
        if (simpleAdsList != null) {
            simpleAdsList.showAds(arrayList);
            this.simpleAds.setTitle(tLRPC$TL_ads_AdPack.title);
        }
        if (this.listViewAdapter != null) {
            updateRows();
            this.listViewAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatUsersActivity$tiNU8-_BPmTx71dWEtb_A7BwKMM
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$20$ChatUsersActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, ManageChatUserCell.class, ManageChatTextCell.class, TextCheckCell2.class, TextSettingsCell.class, ChooseView.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switch2Track"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switch2TrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "undo_background"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerEmptyView.class}, new String[]{"title"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerEmptyView.class}, new String[]{"subtitle"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$20$ChatUsersActivity() {
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
