package ir.nasim.database.dailogLists;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9264Ze4;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.JS;
import ir.nasim.database.dailogLists.DialogDatabase;

/* loaded from: classes5.dex */
public final class b extends AbstractC9264Ze4 {
    private final JS c;

    public b() {
        super(1, 2);
        this.c = new DialogDatabase.b();
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("DROP VIEW folder_unread_peer_count_view");
        interfaceC12694f27.O("ALTER TABLE `dialog_peer_unread_state` ADD COLUMN `isMute` INTEGER NOT NULL DEFAULT 0");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `_new_dialog_peer_unread_state` (`peerUid` INTEGER NOT NULL, `isMute` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`peerUid`))");
        interfaceC12694f27.O("INSERT INTO `_new_dialog_peer_unread_state` (`peerUid`) SELECT `peerUid` FROM `dialog_peer_unread_state`");
        interfaceC12694f27.O("DROP TABLE `dialog_peer_unread_state`");
        interfaceC12694f27.O("ALTER TABLE `_new_dialog_peer_unread_state` RENAME TO `dialog_peer_unread_state`");
        interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_dialog_peer_unread_state_peerUid` ON `dialog_peer_unread_state` (`peerUid`)");
        interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_view` AS SELECT assoc.folderId, COUNT(unread.peerUid) AS unreadPeerCount\n    FROM dialog_folder_associations AS assoc\n    LEFT JOIN dialog_peer_unread_state AS unread \n    ON assoc.peerUid = unread.peerUid\n    WHERE unread.isMute != 1\n    GROUP BY assoc.folderId");
        this.c.a(interfaceC12694f27);
    }
}
