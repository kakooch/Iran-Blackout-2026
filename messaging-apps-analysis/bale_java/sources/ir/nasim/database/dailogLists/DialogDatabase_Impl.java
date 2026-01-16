package ir.nasim.database.dailogLists;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C13143fj7;
import ir.nasim.C5822Kz1;
import ir.nasim.D26;
import ir.nasim.HM1;
import ir.nasim.IM1;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC13330g27;
import ir.nasim.InterfaceC16512lP1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J26;
import ir.nasim.KW7;
import ir.nasim.SA2;
import ir.nasim.database.dailogLists.DialogDatabase_Impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000f0\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r\u0012\u0004\u0012\u00020\u00130\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020 0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$¨\u0006)"}, d2 = {"Lir/nasim/database/dailogLists/DialogDatabase_Impl;", "Lir/nasim/database/dailogLists/DialogDatabase;", "<init>", "()V", "Lir/nasim/Kz1;", "config", "Lir/nasim/g27;", "i", "(Lir/nasim/Kz1;)Lir/nasim/g27;", "Landroidx/room/d;", "h", "()Landroidx/room/d;", "", "Ljava/lang/Class;", "", "", "r", "()Ljava/util/Map;", "", "Lir/nasim/JS;", "q", "()Ljava/util/Set;", "autoMigrationSpecs", "Lir/nasim/Ze4;", "k", "(Ljava/util/Map;)Ljava/util/List;", "Lir/nasim/HM1;", "H", "()Lir/nasim/HM1;", "Lir/nasim/database/dailogLists/c;", TokenNames.I, "()Lir/nasim/database/dailogLists/c;", "Lir/nasim/lP1;", "J", "()Lir/nasim/lP1;", "Lir/nasim/Yu3;", "Lir/nasim/Yu3;", "_dialogDao", "_dialogFolderDao", "s", "_dialogPeerUnreadStateDao", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class DialogDatabase_Impl extends DialogDatabase {

    /* renamed from: q, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _dialogDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.JM1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return DialogDatabase_Impl.N(this.a);
        }
    });

    /* renamed from: r, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _dialogFolderDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.KM1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return DialogDatabase_Impl.O(this.a);
        }
    });

    /* renamed from: s, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _dialogPeerUnreadStateDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.LM1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return DialogDatabase_Impl.P(this.a);
        }
    });

    public static final class a extends J26.b {
        a() {
            super(5);
        }

        @Override // ir.nasim.J26.b
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `dialogs` (`peerUid` INTEGER NOT NULL, `rid` INTEGER NOT NULL, `dialogTitle` TEXT NOT NULL, `sortDate` INTEGER NOT NULL, `unreadCount` INTEGER NOT NULL, `isDeletedAccount` INTEGER NOT NULL, `draft` TEXT, `draftDate` INTEGER, `isGroupCallRunning` INTEGER NOT NULL, `exPeerType` TEXT NOT NULL, `puppetType` TEXT, `message` TEXT, `hasBlueTick` INTEGER, `firstUnreadDate` INTEGER, `unreadMentions` TEXT, `unreadReActions` TEXT, `isLocallyDeleted` INTEGER NOT NULL, `isForwarded` INTEGER NOT NULL, `markAsUnRead` INTEGER, `hasMainWebApp` INTEGER NOT NULL, `isPinned` INTEGER, PRIMARY KEY(`peerUid`))");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_dialogs_sortDate` ON `dialogs` (`sortDate`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `dialog_folders` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `sortIndex` INTEGER NOT NULL, `lastLoadedDate` INTEGER, `hasEndOfPaginationReached` INTEGER NOT NULL, `hasPinnedItemLoaded` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `dialog_folder_associations` (`peerUid` INTEGER NOT NULL, `folderId` INTEGER NOT NULL, `pinnedIndex` INTEGER, PRIMARY KEY(`peerUid`, `folderId`))");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_dialog_folder_associations_peerUid` ON `dialog_folder_associations` (`peerUid`)");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_dialog_folder_associations_folderId` ON `dialog_folder_associations` (`folderId`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `dialog_peer_unread_state` (`peerUid` INTEGER NOT NULL, `isMute` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`peerUid`))");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_dialog_peer_unread_state_peerUid` ON `dialog_peer_unread_state` (`peerUid`)");
            interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_view` AS SELECT assoc.folderId AS folderId, COUNT(unread.peerUid) AS unreadPeerCount FROM dialog_folder_associations AS assoc JOIN dialog_peer_unread_state AS unread ON assoc.peerUid = unread.peerUid LEFT JOIN dialogs AS dialog ON dialog.peerUid = assoc.peerUid WHERE unread.isMute != 1 AND ((dialog.peerUid IS NULL OR dialog.markAsUnRead = 1)OR (dialog.isLocallyDeleted = 0 AND dialog.unreadCount > 0)) GROUP BY assoc.folderId");
            interfaceC12694f27.O("CREATE VIEW `folder_unread_peer_count_excluding_archived_view` AS SELECT assoc.folderId AS folderId, COUNT(unread.peerUid) AS unreadPeerCount FROM dialog_folder_associations AS assoc JOIN dialog_peer_unread_state AS unread ON assoc.peerUid = unread.peerUid LEFT JOIN dialog_folder_associations AS archived ON assoc.peerUid = archived.peerUid AND archived.folderId = 11 LEFT JOIN dialogs AS dialog ON dialog.peerUid = assoc.peerUid WHERE unread.isMute != 1 AND assoc.folderId != 11 AND (assoc.folderId != 0 OR archived.peerUid IS NULL) AND ((dialog.peerUid IS NULL OR dialog.markAsUnRead = 1)OR (dialog.isLocallyDeleted = 0 AND dialog.unreadCount > 0)) GROUP BY assoc.folderId");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC12694f27.O("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '74dd97b0a919f3ac0eff5690d9b63793')");
        }

        @Override // ir.nasim.J26.b
        public void b(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `dialogs`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `dialog_folders`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `dialog_folder_associations`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `dialog_peer_unread_state`");
            interfaceC12694f27.O("DROP VIEW IF EXISTS `folder_unread_peer_count_view`");
            interfaceC12694f27.O("DROP VIEW IF EXISTS `folder_unread_peer_count_excluding_archived_view`");
            List list = ((D26) DialogDatabase_Impl.this).h;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((D26.b) it.next()).b(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void c(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            List list = ((D26) DialogDatabase_Impl.this).h;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((D26.b) it.next()).a(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void d(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            ((D26) DialogDatabase_Impl.this).a = interfaceC12694f27;
            DialogDatabase_Impl.this.z(interfaceC12694f27);
            List list = ((D26) DialogDatabase_Impl.this).h;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((D26.b) it.next()).c(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void e(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }

        @Override // ir.nasim.J26.b
        public void f(InterfaceC12694f27 interfaceC12694f27) throws IOException {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            AbstractC7716Sx1.b(interfaceC12694f27);
        }

        @Override // ir.nasim.J26.b
        public J26.c g(InterfaceC12694f27 interfaceC12694f27) throws IOException {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            HashMap map = new HashMap(21);
            map.put("peerUid", new C13143fj7.a("peerUid", "INTEGER", true, 1, null, 1));
            map.put(DialogEntity.COLUMN_RID, new C13143fj7.a(DialogEntity.COLUMN_RID, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_DIALOG_TITLE, new C13143fj7.a(DialogEntity.COLUMN_DIALOG_TITLE, "TEXT", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_SORT_DATE, new C13143fj7.a(DialogEntity.COLUMN_SORT_DATE, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_UNREAD_COUNT, new C13143fj7.a(DialogEntity.COLUMN_UNREAD_COUNT, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_IS_DELETED_ACCOUNT, new C13143fj7.a(DialogEntity.COLUMN_IS_DELETED_ACCOUNT, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_DRAFT, new C13143fj7.a(DialogEntity.COLUMN_DRAFT, "TEXT", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_DRAFT_DATE, new C13143fj7.a(DialogEntity.COLUMN_DRAFT_DATE, "INTEGER", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_IS_GROUP_CALL_RUNNING, new C13143fj7.a(DialogEntity.COLUMN_IS_GROUP_CALL_RUNNING, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_EX_PEER_TYPE, new C13143fj7.a(DialogEntity.COLUMN_EX_PEER_TYPE, "TEXT", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_PUPPET_TYPE, new C13143fj7.a(DialogEntity.COLUMN_PUPPET_TYPE, "TEXT", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_MESSAGE, new C13143fj7.a(DialogEntity.COLUMN_MESSAGE, "TEXT", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_HAS_BLUE_TICK, new C13143fj7.a(DialogEntity.COLUMN_HAS_BLUE_TICK, "INTEGER", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_FIRST_UNREAD_DATE, new C13143fj7.a(DialogEntity.COLUMN_FIRST_UNREAD_DATE, "INTEGER", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_UNREAD_MENTIONS_DATE, new C13143fj7.a(DialogEntity.COLUMN_UNREAD_MENTIONS_DATE, "TEXT", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_UNREAD_RE_ACTION_DATE, new C13143fj7.a(DialogEntity.COLUMN_UNREAD_RE_ACTION_DATE, "TEXT", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_DELETED_LOCALLY, new C13143fj7.a(DialogEntity.COLUMN_DELETED_LOCALLY, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_IS_FORWARDED, new C13143fj7.a(DialogEntity.COLUMN_IS_FORWARDED, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_MARK_AS_UNREAD, new C13143fj7.a(DialogEntity.COLUMN_MARK_AS_UNREAD, "INTEGER", false, 0, null, 1));
            map.put(DialogEntity.COLUMN_HAS_MAIN_WEBAPP, new C13143fj7.a(DialogEntity.COLUMN_HAS_MAIN_WEBAPP, "INTEGER", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_IS_PINNED, new C13143fj7.a(DialogEntity.COLUMN_IS_PINNED, "INTEGER", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new C13143fj7.e("index_dialogs_sortDate", false, AbstractC9766aX0.e(DialogEntity.COLUMN_SORT_DATE), AbstractC9766aX0.e("ASC")));
            C13143fj7 c13143fj7 = new C13143fj7(DialogEntity.TABLE_NAME, map, hashSet, hashSet2);
            C13143fj7.b bVar = C13143fj7.e;
            C13143fj7 c13143fj7A = bVar.a(interfaceC12694f27, DialogEntity.TABLE_NAME);
            if (!c13143fj7.equals(c13143fj7A)) {
                return new J26.c(false, "dialogs(ir.nasim.database.dailogLists.DialogEntity).\n Expected:\n" + c13143fj7 + "\n Found:\n" + c13143fj7A);
            }
            HashMap map2 = new HashMap(7);
            map2.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map2.put("name", new C13143fj7.a("name", "TEXT", true, 0, null, 1));
            map2.put(DialogFolderEntity.COLUMN_INDEX, new C13143fj7.a(DialogFolderEntity.COLUMN_INDEX, "INTEGER", true, 0, null, 1));
            map2.put(DialogFolderEntity.COLUMN_LOADED_DATE, new C13143fj7.a(DialogFolderEntity.COLUMN_LOADED_DATE, "INTEGER", false, 0, null, 1));
            map2.put(DialogFolderEntity.COLUMN_HAS_END_OF_PAGINATION_REACHED, new C13143fj7.a(DialogFolderEntity.COLUMN_HAS_END_OF_PAGINATION_REACHED, "INTEGER", true, 0, null, 1));
            map2.put(DialogFolderEntity.COLUMN_HAS_PINNED_ITEM_LOADED, new C13143fj7.a(DialogFolderEntity.COLUMN_HAS_PINNED_ITEM_LOADED, "INTEGER", true, 0, null, 1));
            map2.put(DialogFolderEntity.COLUMN_IS_ACTIVE, new C13143fj7.a(DialogFolderEntity.COLUMN_IS_ACTIVE, "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj72 = new C13143fj7(DialogFolderEntity.TABLE_NAME, map2, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A2 = bVar.a(interfaceC12694f27, DialogFolderEntity.TABLE_NAME);
            if (!c13143fj72.equals(c13143fj7A2)) {
                return new J26.c(false, "dialog_folders(ir.nasim.database.dailogLists.DialogFolderEntity).\n Expected:\n" + c13143fj72 + "\n Found:\n" + c13143fj7A2);
            }
            HashMap map3 = new HashMap(3);
            map3.put("peerUid", new C13143fj7.a("peerUid", "INTEGER", true, 1, null, 1));
            map3.put(DialogFolderAssociationEntity.COLUMN_FOLDER_ID, new C13143fj7.a(DialogFolderAssociationEntity.COLUMN_FOLDER_ID, "INTEGER", true, 2, null, 1));
            map3.put(DialogFolderAssociationEntity.COLUMN_PINNED_INDEX, new C13143fj7.a(DialogFolderAssociationEntity.COLUMN_PINNED_INDEX, "INTEGER", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new C13143fj7.e("index_dialog_folder_associations_peerUid", false, AbstractC9766aX0.e("peerUid"), AbstractC9766aX0.e("ASC")));
            hashSet4.add(new C13143fj7.e("index_dialog_folder_associations_folderId", false, AbstractC9766aX0.e(DialogFolderAssociationEntity.COLUMN_FOLDER_ID), AbstractC9766aX0.e("ASC")));
            C13143fj7 c13143fj73 = new C13143fj7(DialogFolderAssociationEntity.TABLE_NAME, map3, hashSet3, hashSet4);
            C13143fj7 c13143fj7A3 = bVar.a(interfaceC12694f27, DialogFolderAssociationEntity.TABLE_NAME);
            if (!c13143fj73.equals(c13143fj7A3)) {
                return new J26.c(false, "dialog_folder_associations(ir.nasim.database.dailogLists.DialogFolderAssociationEntity).\n Expected:\n" + c13143fj73 + "\n Found:\n" + c13143fj7A3);
            }
            HashMap map4 = new HashMap(2);
            map4.put("peerUid", new C13143fj7.a("peerUid", "INTEGER", true, 1, null, 1));
            map4.put("isMute", new C13143fj7.a("isMute", "INTEGER", true, 0, "0", 1));
            HashSet hashSet5 = new HashSet(0);
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new C13143fj7.e("index_dialog_peer_unread_state_peerUid", false, AbstractC9766aX0.e("peerUid"), AbstractC9766aX0.e("ASC")));
            C13143fj7 c13143fj74 = new C13143fj7(DialogPeerUnreadStateEntity.TABLE_NAME, map4, hashSet5, hashSet6);
            C13143fj7 c13143fj7A4 = bVar.a(interfaceC12694f27, DialogPeerUnreadStateEntity.TABLE_NAME);
            if (!c13143fj74.equals(c13143fj7A4)) {
                return new J26.c(false, "dialog_peer_unread_state(ir.nasim.database.dailogLists.DialogPeerUnreadStateEntity).\n Expected:\n" + c13143fj74 + "\n Found:\n" + c13143fj7A4);
            }
            KW7 kw7 = new KW7("folder_unread_peer_count_view", "CREATE VIEW `folder_unread_peer_count_view` AS SELECT assoc.folderId AS folderId, COUNT(unread.peerUid) AS unreadPeerCount FROM dialog_folder_associations AS assoc JOIN dialog_peer_unread_state AS unread ON assoc.peerUid = unread.peerUid LEFT JOIN dialogs AS dialog ON dialog.peerUid = assoc.peerUid WHERE unread.isMute != 1 AND ((dialog.peerUid IS NULL OR dialog.markAsUnRead = 1)OR (dialog.isLocallyDeleted = 0 AND dialog.unreadCount > 0)) GROUP BY assoc.folderId");
            KW7.a aVar = KW7.c;
            KW7 kw7A = aVar.a(interfaceC12694f27, "folder_unread_peer_count_view");
            if (!kw7.equals(kw7A)) {
                return new J26.c(false, "folder_unread_peer_count_view(ir.nasim.database.dailogLists.FolderUnreadPeerCountEntity).\n Expected:\n" + kw7 + "\n Found:\n" + kw7A);
            }
            KW7 kw72 = new KW7("folder_unread_peer_count_excluding_archived_view", "CREATE VIEW `folder_unread_peer_count_excluding_archived_view` AS SELECT assoc.folderId AS folderId, COUNT(unread.peerUid) AS unreadPeerCount FROM dialog_folder_associations AS assoc JOIN dialog_peer_unread_state AS unread ON assoc.peerUid = unread.peerUid LEFT JOIN dialog_folder_associations AS archived ON assoc.peerUid = archived.peerUid AND archived.folderId = 11 LEFT JOIN dialogs AS dialog ON dialog.peerUid = assoc.peerUid WHERE unread.isMute != 1 AND assoc.folderId != 11 AND (assoc.folderId != 0 OR archived.peerUid IS NULL) AND ((dialog.peerUid IS NULL OR dialog.markAsUnRead = 1)OR (dialog.isLocallyDeleted = 0 AND dialog.unreadCount > 0)) GROUP BY assoc.folderId");
            KW7 kw7A2 = aVar.a(interfaceC12694f27, "folder_unread_peer_count_excluding_archived_view");
            if (kw72.equals(kw7A2)) {
                return new J26.c(true, null);
            }
            return new J26.c(false, "folder_unread_peer_count_excluding_archived_view(ir.nasim.database.dailogLists.FolderUnreadPeerCountExcludingArchivedEntity).\n Expected:\n" + kw72 + "\n Found:\n" + kw7A2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.database.dailogLists.a N(DialogDatabase_Impl dialogDatabase_Impl) {
        AbstractC13042fc3.i(dialogDatabase_Impl, "this$0");
        return new ir.nasim.database.dailogLists.a(dialogDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d O(DialogDatabase_Impl dialogDatabase_Impl) {
        AbstractC13042fc3.i(dialogDatabase_Impl, "this$0");
        return new d(dialogDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e P(DialogDatabase_Impl dialogDatabase_Impl) {
        AbstractC13042fc3.i(dialogDatabase_Impl, "this$0");
        return new e(dialogDatabase_Impl);
    }

    @Override // ir.nasim.database.dailogLists.DialogDatabase
    public HM1 H() {
        return (HM1) this._dialogDao.getValue();
    }

    @Override // ir.nasim.database.dailogLists.DialogDatabase
    public c I() {
        return (c) this._dialogFolderDao.getValue();
    }

    @Override // ir.nasim.database.dailogLists.DialogDatabase
    public InterfaceC16512lP1 J() {
        return (InterfaceC16512lP1) this._dialogPeerUnreadStateDao.getValue();
    }

    @Override // ir.nasim.D26
    protected androidx.room.d h() {
        HashMap map = new HashMap(0);
        HashMap map2 = new HashMap(2);
        HashSet hashSet = new HashSet(3);
        hashSet.add(DialogFolderAssociationEntity.TABLE_NAME);
        hashSet.add(DialogPeerUnreadStateEntity.TABLE_NAME);
        hashSet.add(DialogEntity.TABLE_NAME);
        map2.put("folder_unread_peer_count_view", hashSet);
        HashSet hashSet2 = new HashSet(3);
        hashSet2.add(DialogFolderAssociationEntity.TABLE_NAME);
        hashSet2.add(DialogPeerUnreadStateEntity.TABLE_NAME);
        hashSet2.add(DialogEntity.TABLE_NAME);
        map2.put("folder_unread_peer_count_excluding_archived_view", hashSet2);
        return new androidx.room.d(this, map, map2, DialogEntity.TABLE_NAME, DialogFolderEntity.TABLE_NAME, DialogFolderAssociationEntity.TABLE_NAME, DialogPeerUnreadStateEntity.TABLE_NAME);
    }

    @Override // ir.nasim.D26
    protected InterfaceC13330g27 i(C5822Kz1 config) {
        AbstractC13042fc3.i(config, "config");
        return config.c.a(InterfaceC13330g27.b.f.a(config.a).c(config.b).b(new J26(config, new a(), "74dd97b0a919f3ac0eff5690d9b63793", "d2609e8f3dd14374332c4bafecf591d7")).a());
    }

    @Override // ir.nasim.D26
    public List k(Map autoMigrationSpecs) {
        AbstractC13042fc3.i(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        arrayList.add(new IM1());
        return arrayList;
    }

    @Override // ir.nasim.D26
    public Set q() {
        return new HashSet();
    }

    @Override // ir.nasim.D26
    protected Map r() {
        HashMap map = new HashMap();
        map.put(HM1.class, ir.nasim.database.dailogLists.a.o.a());
        map.put(c.class, d.s.a());
        map.put(InterfaceC16512lP1.class, e.e.a());
        return map;
    }
}
