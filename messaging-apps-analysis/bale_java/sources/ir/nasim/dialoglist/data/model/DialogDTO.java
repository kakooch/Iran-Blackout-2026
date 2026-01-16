package ir.nasim.dialoglist.data.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19428qK7;
import ir.nasim.AbstractC25195zt3;
import ir.nasim.ED1;
import ir.nasim.MM1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.MessageState;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\bE\b\u0087\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0000¢\u0006\u0004\b%\u0010&J\u001b\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010$\u001a\u00020\u0000¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010,J\u0010\u00100\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b6\u00105J\u0010\u00107\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b7\u00105J\u0012\u00108\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b8\u00109J\u0012\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b:\u00109J\u0010\u0010;\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b;\u00105J\u0012\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b<\u00101J\u0010\u0010=\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b=\u00105J\u0010\u0010>\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b@\u00105J\u0010\u0010A\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bA\u00105J\u0012\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bB\u00101J\u0012\u0010C\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\bC\u0010DJ\u0012\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bG\u00105J\u0010\u0010H\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bH\u00105J\u0010\u0010I\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bI\u00105J\u0010\u0010J\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\bJ\u0010?J\u0010\u0010K\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\bK\u00101J\u008c\u0002\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\bN\u00101J\u0010\u0010O\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\bO\u0010?J\u001a\u0010P\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bP\u0010QR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010R\u001a\u0004\bS\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010T\u001a\u0004\bU\u0010.R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010R\u001a\u0004\bV\u0010,R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010W\u001a\u0004\bX\u00101R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010Y\u001a\u0004\bZ\u00103R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010[\u001a\u0004\b\f\u00105R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010[\u001a\u0004\b\r\u00105R\u0017\u0010\u000e\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010[\u001a\u0004\b\\\u00105R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010]\u001a\u0004\b^\u00109R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010]\u001a\u0004\b_\u00109R\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010[\u001a\u0004\b\u0012\u00105R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010W\u001a\u0004\b`\u00101R\u0017\u0010\u0014\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010[\u001a\u0004\b\u0014\u00105R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010a\u001a\u0004\bb\u0010?R\u0017\u0010\u0017\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010[\u001a\u0004\bc\u00105R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010[\u001a\u0004\bd\u00105R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010W\u001a\u0004\be\u00101R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010f\u001a\u0004\bg\u0010DR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010h\u001a\u0004\bi\u0010FR\u0017\u0010\u001d\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010[\u001a\u0004\b\u001d\u00105R\u0017\u0010\u001e\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010[\u001a\u0004\bj\u00105R\u0017\u0010\u001f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010[\u001a\u0004\b\u001f\u00105R\u0017\u0010 \u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b \u0010a\u001a\u0004\bk\u0010?R\u0017\u0010!\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010W\u001a\u0004\bl\u00101¨\u0006m"}, d2 = {"Lir/nasim/dialoglist/data/model/DialogDTO;", "", "", "peerUniqueId", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, DialogEntity.COLUMN_SORT_DATE, "", "userName", "Lir/nasim/qK7;", "userType", "", "isMuted", "isPersonalSpace", DialogEntity.COLUMN_HAS_BLUE_TICK, "Lir/nasim/zt3;", "noneDraftLastMessage", "previewLastMessage", DialogEntity.COLUMN_IS_DELETED_ACCOUNT, "formattedTime", DialogEntity.COLUMN_IS_PINNED, "", "unreadMessageCount", "markAsUnread", "hasMention", "lastReactionEmoji", "Lir/nasim/database/dailogLists/MessageState;", "messageState", "lastMessageIsMine", DialogEntity.COLUMN_IS_FORWARDED, DialogEntity.COLUMN_HAS_MAIN_WEBAPP, "isFormalDialog", "formalDialogsMaxUnreadCount", "contentDescription", "<init>", "(JLir/nasim/core/modules/profile/entity/ExPeerType;JLjava/lang/String;Lir/nasim/qK7;ZZZLir/nasim/zt3;Lir/nasim/zt3;ZLjava/lang/String;ZIZZLjava/lang/String;Lir/nasim/database/dailogLists/MessageState;Ljava/lang/Boolean;ZZZILjava/lang/String;)V", "other", "isContentEqual", "(Lir/nasim/dialoglist/data/model/DialogDTO;)Z", "", "Lir/nasim/MM1;", "getChangedPayload", "(Lir/nasim/dialoglist/data/model/DialogDTO;)Ljava/util/Set;", "component1", "()J", "component2", "()Lir/nasim/core/modules/profile/entity/ExPeerType;", "component3", "component4", "()Ljava/lang/String;", "component5", "()Lir/nasim/qK7;", "component6", "()Z", "component7", "component8", "component9", "()Lir/nasim/zt3;", "component10", "component11", "component12", "component13", "component14", "()I", "component15", "component16", "component17", "component18", "()Lir/nasim/database/dailogLists/MessageState;", "component19", "()Ljava/lang/Boolean;", "component20", "component21", "component22", "component23", "component24", "copy", "(JLir/nasim/core/modules/profile/entity/ExPeerType;JLjava/lang/String;Lir/nasim/qK7;ZZZLir/nasim/zt3;Lir/nasim/zt3;ZLjava/lang/String;ZIZZLjava/lang/String;Lir/nasim/database/dailogLists/MessageState;Ljava/lang/Boolean;ZZZILjava/lang/String;)Lir/nasim/dialoglist/data/model/DialogDTO;", "toString", "hashCode", "equals", "(Ljava/lang/Object;)Z", "J", "getPeerUniqueId", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "getExPeerType", "getSortDate", "Ljava/lang/String;", "getUserName", "Lir/nasim/qK7;", "getUserType", "Z", "getHasBlueTick", "Lir/nasim/zt3;", "getNoneDraftLastMessage", "getPreviewLastMessage", "getFormattedTime", TokenNames.I, "getUnreadMessageCount", "getMarkAsUnread", "getHasMention", "getLastReactionEmoji", "Lir/nasim/database/dailogLists/MessageState;", "getMessageState", "Ljava/lang/Boolean;", "getLastMessageIsMine", "getHasMainWebApp", "getFormalDialogsMaxUnreadCount", "getContentDescription", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class DialogDTO {
    public static final int $stable = 0;
    private final String contentDescription;
    private final ExPeerType exPeerType;
    private final int formalDialogsMaxUnreadCount;
    private final String formattedTime;
    private final boolean hasBlueTick;
    private final boolean hasMainWebApp;
    private final boolean hasMention;
    private final boolean isDeletedAccount;
    private final boolean isFormalDialog;
    private final boolean isForwarded;
    private final boolean isMuted;
    private final boolean isPersonalSpace;
    private final boolean isPinned;
    private final Boolean lastMessageIsMine;
    private final String lastReactionEmoji;
    private final boolean markAsUnread;
    private final MessageState messageState;
    private final AbstractC25195zt3 noneDraftLastMessage;
    private final long peerUniqueId;
    private final AbstractC25195zt3 previewLastMessage;
    private final long sortDate;
    private final int unreadMessageCount;
    private final String userName;
    private final AbstractC19428qK7 userType;

    public DialogDTO(long j, ExPeerType exPeerType, long j2, String str, AbstractC19428qK7 abstractC19428qK7, boolean z, boolean z2, boolean z3, AbstractC25195zt3 abstractC25195zt3, AbstractC25195zt3 abstractC25195zt32, boolean z4, String str2, boolean z5, int i, boolean z6, boolean z7, String str3, MessageState messageState, Boolean bool, boolean z8, boolean z9, boolean z10, int i2, String str4) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(str, "userName");
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        AbstractC13042fc3.i(str4, "contentDescription");
        this.peerUniqueId = j;
        this.exPeerType = exPeerType;
        this.sortDate = j2;
        this.userName = str;
        this.userType = abstractC19428qK7;
        this.isMuted = z;
        this.isPersonalSpace = z2;
        this.hasBlueTick = z3;
        this.noneDraftLastMessage = abstractC25195zt3;
        this.previewLastMessage = abstractC25195zt32;
        this.isDeletedAccount = z4;
        this.formattedTime = str2;
        this.isPinned = z5;
        this.unreadMessageCount = i;
        this.markAsUnread = z6;
        this.hasMention = z7;
        this.lastReactionEmoji = str3;
        this.messageState = messageState;
        this.lastMessageIsMine = bool;
        this.isForwarded = z8;
        this.hasMainWebApp = z9;
        this.isFormalDialog = z10;
        this.formalDialogsMaxUnreadCount = i2;
        this.contentDescription = str4;
    }

    /* renamed from: component1, reason: from getter */
    public final long getPeerUniqueId() {
        return this.peerUniqueId;
    }

    /* renamed from: component10, reason: from getter */
    public final AbstractC25195zt3 getPreviewLastMessage() {
        return this.previewLastMessage;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsDeletedAccount() {
        return this.isDeletedAccount;
    }

    /* renamed from: component12, reason: from getter */
    public final String getFormattedTime() {
        return this.formattedTime;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component14, reason: from getter */
    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getMarkAsUnread() {
        return this.markAsUnread;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getHasMention() {
        return this.hasMention;
    }

    /* renamed from: component17, reason: from getter */
    public final String getLastReactionEmoji() {
        return this.lastReactionEmoji;
    }

    /* renamed from: component18, reason: from getter */
    public final MessageState getMessageState() {
        return this.messageState;
    }

    /* renamed from: component19, reason: from getter */
    public final Boolean getLastMessageIsMine() {
        return this.lastMessageIsMine;
    }

    /* renamed from: component2, reason: from getter */
    public final ExPeerType getExPeerType() {
        return this.exPeerType;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsForwarded() {
        return this.isForwarded;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getHasMainWebApp() {
        return this.hasMainWebApp;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getIsFormalDialog() {
        return this.isFormalDialog;
    }

    /* renamed from: component23, reason: from getter */
    public final int getFormalDialogsMaxUnreadCount() {
        return this.formalDialogsMaxUnreadCount;
    }

    /* renamed from: component24, reason: from getter */
    public final String getContentDescription() {
        return this.contentDescription;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSortDate() {
        return this.sortDate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component5, reason: from getter */
    public final AbstractC19428qK7 getUserType() {
        return this.userType;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsPersonalSpace() {
        return this.isPersonalSpace;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getHasBlueTick() {
        return this.hasBlueTick;
    }

    /* renamed from: component9, reason: from getter */
    public final AbstractC25195zt3 getNoneDraftLastMessage() {
        return this.noneDraftLastMessage;
    }

    public final DialogDTO copy(long peerUniqueId, ExPeerType exPeerType, long sortDate, String userName, AbstractC19428qK7 userType, boolean isMuted, boolean isPersonalSpace, boolean hasBlueTick, AbstractC25195zt3 noneDraftLastMessage, AbstractC25195zt3 previewLastMessage, boolean isDeletedAccount, String formattedTime, boolean isPinned, int unreadMessageCount, boolean markAsUnread, boolean hasMention, String lastReactionEmoji, MessageState messageState, Boolean lastMessageIsMine, boolean isForwarded, boolean hasMainWebApp, boolean isFormalDialog, int formalDialogsMaxUnreadCount, String contentDescription) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(userName, "userName");
        AbstractC13042fc3.i(userType, "userType");
        AbstractC13042fc3.i(contentDescription, "contentDescription");
        return new DialogDTO(peerUniqueId, exPeerType, sortDate, userName, userType, isMuted, isPersonalSpace, hasBlueTick, noneDraftLastMessage, previewLastMessage, isDeletedAccount, formattedTime, isPinned, unreadMessageCount, markAsUnread, hasMention, lastReactionEmoji, messageState, lastMessageIsMine, isForwarded, hasMainWebApp, isFormalDialog, formalDialogsMaxUnreadCount, contentDescription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogDTO)) {
            return false;
        }
        DialogDTO dialogDTO = (DialogDTO) other;
        return this.peerUniqueId == dialogDTO.peerUniqueId && this.exPeerType == dialogDTO.exPeerType && this.sortDate == dialogDTO.sortDate && AbstractC13042fc3.d(this.userName, dialogDTO.userName) && AbstractC13042fc3.d(this.userType, dialogDTO.userType) && this.isMuted == dialogDTO.isMuted && this.isPersonalSpace == dialogDTO.isPersonalSpace && this.hasBlueTick == dialogDTO.hasBlueTick && AbstractC13042fc3.d(this.noneDraftLastMessage, dialogDTO.noneDraftLastMessage) && AbstractC13042fc3.d(this.previewLastMessage, dialogDTO.previewLastMessage) && this.isDeletedAccount == dialogDTO.isDeletedAccount && AbstractC13042fc3.d(this.formattedTime, dialogDTO.formattedTime) && this.isPinned == dialogDTO.isPinned && this.unreadMessageCount == dialogDTO.unreadMessageCount && this.markAsUnread == dialogDTO.markAsUnread && this.hasMention == dialogDTO.hasMention && AbstractC13042fc3.d(this.lastReactionEmoji, dialogDTO.lastReactionEmoji) && this.messageState == dialogDTO.messageState && AbstractC13042fc3.d(this.lastMessageIsMine, dialogDTO.lastMessageIsMine) && this.isForwarded == dialogDTO.isForwarded && this.hasMainWebApp == dialogDTO.hasMainWebApp && this.isFormalDialog == dialogDTO.isFormalDialog && this.formalDialogsMaxUnreadCount == dialogDTO.formalDialogsMaxUnreadCount && AbstractC13042fc3.d(this.contentDescription, dialogDTO.contentDescription);
    }

    public final Set<MM1> getChangedPayload(DialogDTO other) {
        AbstractC13042fc3.i(other, "other");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.isPinned != other.isPinned) {
            linkedHashSet.add(MM1.a);
        }
        return linkedHashSet;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final ExPeerType getExPeerType() {
        return this.exPeerType;
    }

    public final int getFormalDialogsMaxUnreadCount() {
        return this.formalDialogsMaxUnreadCount;
    }

    public final String getFormattedTime() {
        return this.formattedTime;
    }

    public final boolean getHasBlueTick() {
        return this.hasBlueTick;
    }

    public final boolean getHasMainWebApp() {
        return this.hasMainWebApp;
    }

    public final boolean getHasMention() {
        return this.hasMention;
    }

    public final Boolean getLastMessageIsMine() {
        return this.lastMessageIsMine;
    }

    public final String getLastReactionEmoji() {
        return this.lastReactionEmoji;
    }

    public final boolean getMarkAsUnread() {
        return this.markAsUnread;
    }

    public final MessageState getMessageState() {
        return this.messageState;
    }

    public final AbstractC25195zt3 getNoneDraftLastMessage() {
        return this.noneDraftLastMessage;
    }

    public final long getPeerUniqueId() {
        return this.peerUniqueId;
    }

    public final AbstractC25195zt3 getPreviewLastMessage() {
        return this.previewLastMessage;
    }

    public final long getSortDate() {
        return this.sortDate;
    }

    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final AbstractC19428qK7 getUserType() {
        return this.userType;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((Long.hashCode(this.peerUniqueId) * 31) + this.exPeerType.hashCode()) * 31) + Long.hashCode(this.sortDate)) * 31) + this.userName.hashCode()) * 31) + this.userType.hashCode()) * 31) + Boolean.hashCode(this.isMuted)) * 31) + Boolean.hashCode(this.isPersonalSpace)) * 31) + Boolean.hashCode(this.hasBlueTick)) * 31;
        AbstractC25195zt3 abstractC25195zt3 = this.noneDraftLastMessage;
        int iHashCode2 = (iHashCode + (abstractC25195zt3 == null ? 0 : abstractC25195zt3.hashCode())) * 31;
        AbstractC25195zt3 abstractC25195zt32 = this.previewLastMessage;
        int iHashCode3 = (((iHashCode2 + (abstractC25195zt32 == null ? 0 : abstractC25195zt32.hashCode())) * 31) + Boolean.hashCode(this.isDeletedAccount)) * 31;
        String str = this.formattedTime;
        int iHashCode4 = (((((((((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isPinned)) * 31) + Integer.hashCode(this.unreadMessageCount)) * 31) + Boolean.hashCode(this.markAsUnread)) * 31) + Boolean.hashCode(this.hasMention)) * 31;
        String str2 = this.lastReactionEmoji;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MessageState messageState = this.messageState;
        int iHashCode6 = (iHashCode5 + (messageState == null ? 0 : messageState.hashCode())) * 31;
        Boolean bool = this.lastMessageIsMine;
        return ((((((((((iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31) + Boolean.hashCode(this.isForwarded)) * 31) + Boolean.hashCode(this.hasMainWebApp)) * 31) + Boolean.hashCode(this.isFormalDialog)) * 31) + Integer.hashCode(this.formalDialogsMaxUnreadCount)) * 31) + this.contentDescription.hashCode();
    }

    public final boolean isContentEqual(DialogDTO other) {
        AbstractC13042fc3.i(other, "other");
        return this.isPinned == other.isPinned;
    }

    public final boolean isDeletedAccount() {
        return this.isDeletedAccount;
    }

    public final boolean isFormalDialog() {
        return this.isFormalDialog;
    }

    public final boolean isForwarded() {
        return this.isForwarded;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean isPersonalSpace() {
        return this.isPersonalSpace;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public String toString() {
        return "DialogDTO(peerUniqueId=" + this.peerUniqueId + ", exPeerType=" + this.exPeerType + ", sortDate=" + this.sortDate + ", userName=" + this.userName + ", userType=" + this.userType + ", isMuted=" + this.isMuted + ", isPersonalSpace=" + this.isPersonalSpace + ", hasBlueTick=" + this.hasBlueTick + ", noneDraftLastMessage=" + this.noneDraftLastMessage + ", previewLastMessage=" + this.previewLastMessage + ", isDeletedAccount=" + this.isDeletedAccount + ", formattedTime=" + this.formattedTime + ", isPinned=" + this.isPinned + ", unreadMessageCount=" + this.unreadMessageCount + ", markAsUnread=" + this.markAsUnread + ", hasMention=" + this.hasMention + ", lastReactionEmoji=" + this.lastReactionEmoji + ", messageState=" + this.messageState + ", lastMessageIsMine=" + this.lastMessageIsMine + ", isForwarded=" + this.isForwarded + ", hasMainWebApp=" + this.hasMainWebApp + ", isFormalDialog=" + this.isFormalDialog + ", formalDialogsMaxUnreadCount=" + this.formalDialogsMaxUnreadCount + ", contentDescription=" + this.contentDescription + Separators.RPAREN;
    }

    public /* synthetic */ DialogDTO(long j, ExPeerType exPeerType, long j2, String str, AbstractC19428qK7 abstractC19428qK7, boolean z, boolean z2, boolean z3, AbstractC25195zt3 abstractC25195zt3, AbstractC25195zt3 abstractC25195zt32, boolean z4, String str2, boolean z5, int i, boolean z6, boolean z7, String str3, MessageState messageState, Boolean bool, boolean z8, boolean z9, boolean z10, int i2, String str4, int i3, ED1 ed1) {
        this(j, exPeerType, j2, str, abstractC19428qK7, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? false : z3, (i3 & 256) != 0 ? null : abstractC25195zt3, (i3 & 512) != 0 ? null : abstractC25195zt32, (i3 & 1024) != 0 ? false : z4, (i3 & 2048) != 0 ? null : str2, (i3 & 4096) != 0 ? false : z5, (i3 & 8192) != 0 ? 0 : i, (i3 & 16384) != 0 ? false : z6, (32768 & i3) != 0 ? false : z7, (65536 & i3) != 0 ? "" : str3, (131072 & i3) != 0 ? null : messageState, (262144 & i3) != 0 ? null : bool, (524288 & i3) != 0 ? false : z8, (1048576 & i3) != 0 ? false : z9, (2097152 & i3) != 0 ? false : z10, (4194304 & i3) != 0 ? 0 : i2, (i3 & 8388608) != 0 ? "" : str4);
    }
}
