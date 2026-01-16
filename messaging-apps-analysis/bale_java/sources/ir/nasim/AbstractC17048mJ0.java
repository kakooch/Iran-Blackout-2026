package ir.nasim;

/* renamed from: ir.nasim.mJ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17048mJ0 {
    private static final AbstractC9264Ze4 a = new a();
    private static final AbstractC9264Ze4 b = new b();

    /* renamed from: ir.nasim.mJ0$a */
    public static final class a extends AbstractC9264Ze4 {
        a() {
            super(3, 4);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("DROP VIEW IF EXISTS folder_unread_peer_count_view");
            interfaceC12694f27.O("DROP VIEW IF EXISTS folder_unread_peer_count_excluding_archived_view");
            interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_view` AS SELECT assoc.folderId AS folderId, COUNT(unread.peerUid) AS unreadPeerCount FROM dialog_folder_associations AS assoc JOIN dialog_peer_unread_state AS unread ON assoc.peerUid = unread.peerUid LEFT JOIN dialogs AS dialog ON dialog.peerUid = assoc.peerUid WHERE unread.isMute != 1 AND ((dialog.peerUid IS NULL OR dialog.markAsUnRead = 1)OR (dialog.isLocallyDeleted = 0 AND dialog.unreadCount > 0)) GROUP BY assoc.folderId");
            interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_excluding_archived_view` AS SELECT assoc.folderId AS folderId, COUNT(unread.peerUid) AS unreadPeerCount FROM dialog_folder_associations AS assoc JOIN dialog_peer_unread_state AS unread ON assoc.peerUid = unread.peerUid LEFT JOIN dialog_folder_associations AS archived ON assoc.peerUid = archived.peerUid AND archived.folderId = 11 LEFT JOIN dialogs AS dialog ON dialog.peerUid = assoc.peerUid WHERE unread.isMute != 1 AND assoc.folderId != 11 AND (assoc.folderId != 0 OR archived.peerUid IS NULL) AND ((dialog.peerUid IS NULL OR dialog.markAsUnRead = 1)OR (dialog.isLocallyDeleted = 0 AND dialog.unreadCount > 0)) GROUP BY assoc.folderId");
        }
    }

    /* renamed from: ir.nasim.mJ0$b */
    public static final class b extends AbstractC9264Ze4 {
        b() {
            super(4, 5);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            AbstractC17048mJ0.a().a(interfaceC12694f27);
        }
    }

    public static final AbstractC9264Ze4 a() {
        return a;
    }

    public static final AbstractC9264Ze4 b() {
        return b;
    }
}
