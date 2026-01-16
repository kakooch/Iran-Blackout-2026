package ir.nasim.jaryan.feed.model.db;

import ai.bale.proto.MagazineStruct$FeedAlbumItem;
import ai.bale.proto.MagazineStruct$FeedAlbumMessage;
import ai.bale.proto.MagazineStruct$FeedMessage;
import ai.bale.proto.MagazineStruct$FeedMessageContainer;
import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$MessageReaction;
import ai.bale.proto.MessagingStruct$TextMessage;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.C12056dy;
import ir.nasim.C15759k74;
import ir.nasim.C22114uh2;
import ir.nasim.C23196wW4;
import ir.nasim.C4026Dj2;
import ir.nasim.C8386Vt0;
import ir.nasim.InterfaceC14123hO3;
import ir.nasim.XV4;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class a implements InterfaceC14123hO3 {
    private final AbsFeedMessageDataEntity.AlbumMessage b(MagazineStruct$FeedAlbumMessage magazineStruct$FeedAlbumMessage) {
        List<MagazineStruct$FeedAlbumItem> itemsList = magazineStruct$FeedAlbumMessage.getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        List<MagazineStruct$FeedAlbumItem> list = itemsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MagazineStruct$FeedAlbumItem magazineStruct$FeedAlbumItem : list) {
            long rid = magazineStruct$FeedAlbumItem.getMessageId().getRid();
            long date = magazineStruct$FeedAlbumItem.getMessageId().getDate();
            MessagingStruct$DocumentMessage documentMessage = magazineStruct$FeedAlbumItem.getDocumentMessage();
            AbstractC13042fc3.h(documentMessage, "getDocumentMessage(...)");
            AbsFeedMessageDataEntity absFeedMessageDataEntityC = c(documentMessage);
            AbstractC13042fc3.g(absFeedMessageDataEntityC, "null cannot be cast to non-null type ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity.MediaMessage");
            arrayList.add(new AbsFeedMessageDataEntity.AlbumItem(rid, date, (AbsFeedMessageDataEntity.MediaMessage) absFeedMessageDataEntityC));
        }
        return new AbsFeedMessageDataEntity.AlbumMessage(arrayList, 0, null, 6, null);
    }

    private final AbsFeedMessageDataEntity c(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        C12056dy c12056dy = new C12056dy(messagingStruct$DocumentMessage.getFileId(), messagingStruct$DocumentMessage.getAccessHash(), Integer.valueOf(messagingStruct$DocumentMessage.getFileStorageVersion().getValue()));
        String name = messagingStruct$DocumentMessage.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        FileReference fileReference = new FileReference(c12056dy, name, messagingStruct$DocumentMessage.getCaption().getText(), messagingStruct$DocumentMessage.getFileSize());
        if (messagingStruct$DocumentMessage.getExt().hasDocumentExPhoto()) {
            byte[] bArrA0 = messagingStruct$DocumentMessage.getThumb().getThumb().a0();
            AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
            String text = messagingStruct$DocumentMessage.getCaption().getText();
            AbstractC13042fc3.h(text, "getText(...)");
            return new AbsFeedMessageDataEntity.PhotoMessage(bArrA0, text, fileReference.getFileName(), fileReference.getFileId(), fileReference.getAccessHash(), fileReference.getFileStorageVersion(), fileReference.getFileSize(), messagingStruct$DocumentMessage.getExt().getDocumentExPhoto().getH(), messagingStruct$DocumentMessage.getExt().getDocumentExPhoto().getW(), 0, null, 1536, null);
        }
        if (messagingStruct$DocumentMessage.getExt().hasDocumentExVideo()) {
            byte[] bArrA02 = messagingStruct$DocumentMessage.getThumb().getThumb().a0();
            AbstractC13042fc3.h(bArrA02, "toByteArray(...)");
            String text2 = messagingStruct$DocumentMessage.getCaption().getText();
            AbstractC13042fc3.h(text2, "getText(...)");
            return new AbsFeedMessageDataEntity.VideoMessage(bArrA02, text2, fileReference.getFileName(), fileReference.getFileId(), fileReference.getAccessHash(), fileReference.getFileStorageVersion(), messagingStruct$DocumentMessage.getMimeType(), messagingStruct$DocumentMessage.getFileSize(), messagingStruct$DocumentMessage.getExt().getDocumentExVideo().getH(), messagingStruct$DocumentMessage.getExt().getDocumentExVideo().getW(), messagingStruct$DocumentMessage.getExt().getDocumentExVideo().getDuration(), 0, null, 6144, null);
        }
        if (!messagingStruct$DocumentMessage.getExt().hasDocumentExGif()) {
            throw new IllegalStateException("");
        }
        byte[] bArrA03 = messagingStruct$DocumentMessage.getThumb().getThumb().a0();
        AbstractC13042fc3.h(bArrA03, "toByteArray(...)");
        String text3 = messagingStruct$DocumentMessage.getCaption().getText();
        AbstractC13042fc3.h(text3, "getText(...)");
        return new AbsFeedMessageDataEntity.GifMessage(bArrA03, text3, fileReference.getFileName(), fileReference.getFileId(), fileReference.getAccessHash(), fileReference.getFileStorageVersion(), fileReference.getFileSize(), messagingStruct$DocumentMessage.getExt().getDocumentExGif().getH(), messagingStruct$DocumentMessage.getExt().getDocumentExGif().getW(), 0, null, 1536, null);
    }

    private final AbsFeedMessageDataEntity d(MagazineStruct$FeedMessage magazineStruct$FeedMessage) {
        if (magazineStruct$FeedMessage.hasTextMessage()) {
            MessagingStruct$TextMessage textMessage = magazineStruct$FeedMessage.getTextMessage();
            AbstractC13042fc3.h(textMessage, "getTextMessage(...)");
            return e(textMessage);
        }
        if (magazineStruct$FeedMessage.hasDocumentMessage()) {
            MessagingStruct$DocumentMessage documentMessage = magazineStruct$FeedMessage.getDocumentMessage();
            AbstractC13042fc3.h(documentMessage, "getDocumentMessage(...)");
            return c(documentMessage);
        }
        if (!magazineStruct$FeedMessage.hasAlbumMessage()) {
            return new AbsFeedMessageDataEntity.UnknownMessage(0, null, 3, null);
        }
        MagazineStruct$FeedAlbumMessage albumMessage = magazineStruct$FeedMessage.getAlbumMessage();
        AbstractC13042fc3.h(albumMessage, "getAlbumMessage(...)");
        return b(albumMessage);
    }

    private final AbsFeedMessageDataEntity.TextMessage e(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        String text = messagingStruct$TextMessage.getText();
        AbstractC13042fc3.h(text, "getText(...)");
        List<Integer> mentionsList = messagingStruct$TextMessage.getMentionsList();
        AbstractC13042fc3.h(mentionsList, "getMentionsList(...)");
        return new AbsFeedMessageDataEntity.TextMessage(text, mentionsList, 0, null, 12, null);
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C22114uh2 a(XV4 xv4) {
        long itemDate;
        long itemRid;
        AbstractC13042fc3.i(xv4, "input");
        int iIntValue = ((Number) xv4.f()).intValue();
        MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer = (MagazineStruct$FeedMessageContainer) xv4.e();
        ExPeer exPeer = new ExPeer(ExPeerType.fromValue(magazineStruct$FeedMessageContainer.getExPeer().getTypeValue()), magazineStruct$FeedMessageContainer.getExPeer().getId());
        MagazineStruct$FeedMessage message = magazineStruct$FeedMessageContainer.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        AbsFeedMessageDataEntity absFeedMessageDataEntityD = d(message);
        long rid = magazineStruct$FeedMessageContainer.getRid();
        long date = magazineStruct$FeedMessageContainer.getDate();
        long fileId = magazineStruct$FeedMessageContainer.getMessage().getDocumentMessage().getFileId();
        if (absFeedMessageDataEntityD instanceof AbsFeedMessageDataEntity.AlbumMessage) {
            AbsFeedMessageDataEntity.AlbumMessage albumMessage = (AbsFeedMessageDataEntity.AlbumMessage) absFeedMessageDataEntityD;
            itemRid = ((AbsFeedMessageDataEntity.AlbumItem) AbstractC15401jX0.q0(albumMessage.getAlbumItems())).getItemRid();
            itemDate = ((AbsFeedMessageDataEntity.AlbumItem) AbstractC15401jX0.q0(albumMessage.getAlbumItems())).getItemDate();
        } else {
            itemDate = date;
            itemRid = rid;
        }
        int peerId = exPeer.getPeerId();
        ExPeerType exPeerType = exPeer.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        byte[] bArrA = C23196wW4.a.a(absFeedMessageDataEntityD);
        List<MessagingStruct$MessageReaction> reactionsList = magazineStruct$FeedMessageContainer.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        List<MessagingStruct$MessageReaction> list = reactionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            MessagingStruct$MessageReaction messagingStruct$MessageReaction = (MessagingStruct$MessageReaction) it.next();
            String code = messagingStruct$MessageReaction.getCode();
            AbstractC13042fc3.h(code, "getCode(...)");
            long value = messagingStruct$MessageReaction.getCardinality().getValue();
            AbstractC13042fc3.h(messagingStruct$MessageReaction.getUsersList(), "getUsersList(...)");
            arrayList.add(new C15759k74(code, value, !r3.isEmpty()));
        }
        Integer numValueOf = magazineStruct$FeedMessageContainer.getForwardedCount().isInitialized() ? Integer.valueOf(magazineStruct$FeedMessageContainer.getForwardedCount().getValue()) : null;
        int senderUid = magazineStruct$FeedMessageContainer.getSenderUid();
        Integer numValueOf2 = magazineStruct$FeedMessageContainer.getUpvoteCount().isInitialized() ? Integer.valueOf(magazineStruct$FeedMessageContainer.getUpvoteCount().getValue()) : null;
        Boolean boolValueOf = magazineStruct$FeedMessageContainer.getIsUpvotedByMe().isInitialized() ? Boolean.valueOf(magazineStruct$FeedMessageContainer.getIsUpvotedByMe().getValue()) : null;
        int holderType = absFeedMessageDataEntityD.getHolderType();
        String text = magazineStruct$FeedMessageContainer.getCategory().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String text2 = magazineStruct$FeedMessageContainer.getTag().getFa().getText();
        AbstractC13042fc3.h(text2, "getText(...)");
        Boolean bool = boolValueOf;
        String text3 = magazineStruct$FeedMessageContainer.getTag().getEn().getText();
        AbstractC13042fc3.h(text3, "getText(...)");
        return new C22114uh2(0L, itemRid, itemDate, peerId, exPeerType, bArrA, arrayList, numValueOf, senderUid, numValueOf2, bool, text, holderType, new C4026Dj2(text2, text3), null, Long.valueOf(magazineStruct$FeedMessageContainer.getGroupedId().getValue()), (C8386Vt0.w6() && magazineStruct$FeedMessageContainer.getHasComment().getValue()) ? Integer.valueOf(magazineStruct$FeedMessageContainer.getRepliesInfo().getRepliesCount()) : null, iIntValue, fileId, 16385, null);
    }
}
