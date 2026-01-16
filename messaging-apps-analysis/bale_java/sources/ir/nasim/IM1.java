package ir.nasim;

/* loaded from: classes5.dex */
public final class IM1 extends AbstractC9264Ze4 {
    public IM1() {
        super(2, 3);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("DROP VIEW folder_unread_peer_count_view");
        interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_view` AS SELECT assoc.folderId, COUNT(unread.peerUid) AS unreadPeerCount\n    FROM dialog_folder_associations AS assoc\n    LEFT JOIN dialog_peer_unread_state AS unread \n    ON assoc.peerUid = unread.peerUid\n    WHERE unread.isMute != 1\n    GROUP BY assoc.folderId");
        interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_excluding_archived_view` AS SELECT assoc.folderId, COUNT(unread.peerUid) AS unreadPeerCount\n    FROM dialog_folder_associations AS assoc\n    LEFT JOIN dialog_peer_unread_state AS unread \n      ON assoc.peerUid = unread.peerUid\n    LEFT JOIN dialog_folder_associations AS archived\n      ON assoc.peerUid = archived.peerUid AND archived.folderId = 11\n    WHERE unread.isMute != 1 \n      AND assoc.folderId != 11\n      AND (assoc.folderId != 0 OR archived.peerUid IS NULL)\n    GROUP BY assoc.folderId");
    }
}
