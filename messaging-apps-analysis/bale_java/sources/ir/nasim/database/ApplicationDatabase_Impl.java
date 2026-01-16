package ir.nasim.database;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.room.d;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC7311Re1;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C10599bs6;
import ir.nasim.C13143fj7;
import ir.nasim.C13857gw0;
import ir.nasim.C19256q25;
import ir.nasim.C19674ql;
import ir.nasim.C20207rd5;
import ir.nasim.C21348tW;
import ir.nasim.C5611Kb6;
import ir.nasim.C5822Kz1;
import ir.nasim.C6955Pr6;
import ir.nasim.C7545Se1;
import ir.nasim.C7580Si0;
import ir.nasim.C8384Vs7;
import ir.nasim.D26;
import ir.nasim.DD3;
import ir.nasim.ED3;
import ir.nasim.EF;
import ir.nasim.FF;
import ir.nasim.FX6;
import ir.nasim.GF;
import ir.nasim.GX6;
import ir.nasim.HD4;
import ir.nasim.HF;
import ir.nasim.ID4;
import ir.nasim.IF;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC13266fw0;
import ir.nasim.InterfaceC13330g27;
import ir.nasim.InterfaceC18665p25;
import ir.nasim.InterfaceC19083pl;
import ir.nasim.InterfaceC19600qd5;
import ir.nasim.InterfaceC20728sW;
import ir.nasim.InterfaceC5377Jb6;
import ir.nasim.InterfaceC6721Or6;
import ir.nasim.InterfaceC7346Ri0;
import ir.nasim.InterfaceC8150Us7;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9982as6;
import ir.nasim.J26;
import ir.nasim.JF;
import ir.nasim.KF;
import ir.nasim.LF;
import ir.nasim.MF;
import ir.nasim.NF;
import ir.nasim.OF;
import ir.nasim.PF;
import ir.nasim.QI7;
import ir.nasim.RI7;
import ir.nasim.SA2;
import ir.nasim.UY1;
import ir.nasim.WY1;
import ir.nasim.database.ApplicationDatabase_Impl;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000f0\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r\u0012\u0004\u0012\u00020\u00130\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001a0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010HR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001d0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010HR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020 0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010HR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020#0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010HR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010HR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020)0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010HR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020,0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010HR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020V0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010HR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020/0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010HR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u0002020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010HR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u0002050G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010HR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u0002080G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010HR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020;0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010HR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020>0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010HR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020A0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010HR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020D0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010H¨\u0006i"}, d2 = {"Lir/nasim/database/ApplicationDatabase_Impl;", "Lir/nasim/database/ApplicationDatabase;", "<init>", "()V", "Lir/nasim/Kz1;", "config", "Lir/nasim/g27;", "i", "(Lir/nasim/Kz1;)Lir/nasim/g27;", "Landroidx/room/d;", "h", "()Landroidx/room/d;", "", "Ljava/lang/Class;", "", "", "r", "()Ljava/util/Map;", "", "Lir/nasim/JS;", "q", "()Ljava/util/Set;", "autoMigrationSpecs", "Lir/nasim/Ze4;", "k", "(Ljava/util/Map;)Ljava/util/List;", "Lir/nasim/fw0;", TokenNames.L, "()Lir/nasim/fw0;", "Lir/nasim/pl;", TokenNames.I, "()Lir/nasim/pl;", "Lir/nasim/DD3;", TokenNames.O, "()Lir/nasim/DD3;", "Lir/nasim/Jb6;", TokenNames.S, "()Lir/nasim/Jb6;", "Lir/nasim/HD4;", "P", "()Lir/nasim/HD4;", "Lir/nasim/Or6;", TokenNames.T, "()Lir/nasim/Or6;", "Lir/nasim/Ri0;", TokenNames.K, "()Lir/nasim/Ri0;", "Lir/nasim/QI7;", "W", "()Lir/nasim/QI7;", "Lir/nasim/Re1;", TokenNames.M, "()Lir/nasim/Re1;", "Lir/nasim/FX6;", TokenNames.U, "()Lir/nasim/FX6;", "Lir/nasim/UY1;", "N", "()Lir/nasim/UY1;", "Lir/nasim/qd5;", TokenNames.R, "()Lir/nasim/qd5;", "Lir/nasim/Us7;", TokenNames.V, "()Lir/nasim/Us7;", "Lir/nasim/p25;", "Q", "()Lir/nasim/p25;", "Lir/nasim/sW;", "J", "()Lir/nasim/sW;", "Lir/nasim/Yu3;", "Lir/nasim/Yu3;", "_callLogDao", "s", "_albumIdToMessageIdDao", "t", "_liveStreamDao", "u", "_savedGifDao", "v", "_notificationRecordDao", "w", "_serviceItemsDao", "x", "_botItemsDao", "Lir/nasim/as6;", "y", "_serviceSectionsDao", "z", "_userPresenceDao", "A", "_contactDao", "B", "_storyWidgetDao", TokenNames.C, "_downloadStateDao", "D", "_pinMessageDao", TokenNames.E, "_topPeersDao", TokenNames.F, "_peerClicksDao", "G", "_badgeDao", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ApplicationDatabase_Impl extends ApplicationDatabase {

    /* renamed from: r, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _callLogDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.QF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.q0(this.a);
        }
    });

    /* renamed from: s, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _albumIdToMessageIdDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.dG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.n0(this.a);
        }
    });

    /* renamed from: t, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _liveStreamDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.eG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.t0(this.a);
        }
    });

    /* renamed from: u, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _savedGifDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.fG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.x0(this.a);
        }
    });

    /* renamed from: v, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _notificationRecordDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.RF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.u0(this.a);
        }
    });

    /* renamed from: w, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _serviceItemsDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.SF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.y0(this.a);
        }
    });

    /* renamed from: x, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _botItemsDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.TF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.p0(this.a);
        }
    });

    /* renamed from: y, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _serviceSectionsDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.z0(this.a);
        }
    });

    /* renamed from: z, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _userPresenceDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.C0(this.a);
        }
    });

    /* renamed from: A, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _contactDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.r0(this.a);
        }
    });

    /* renamed from: B, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _storyWidgetDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.A0(this.a);
        }
    });

    /* renamed from: C, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _downloadStateDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.YF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.s0(this.a);
        }
    });

    /* renamed from: D, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _pinMessageDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ZF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.w0(this.a);
        }
    });

    /* renamed from: E, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _topPeersDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.B0(this.a);
        }
    });

    /* renamed from: F, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _peerClicksDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.v0(this.a);
        }
    });

    /* renamed from: G, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _badgeDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.cG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationDatabase_Impl.o0(this.a);
        }
    });

    public static final class a extends J26.b {
        a() {
            super(21);
        }

        @Override // ir.nasim.J26.b
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `call_log` (`time` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `peer` INTEGER NOT NULL, `initiator` INTEGER NOT NULL, `finisher` INTEGER NOT NULL, `personal_call_state` INTEGER NOT NULL, `group_call_state` INTEGER NOT NULL, `id` INTEGER NOT NULL, `peersList` TEXT NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `aLbum_message_id` (`peer_unique_id` INTEGER NOT NULL, `album_id` INTEGER NOT NULL, `message_id` INTEGER NOT NULL, `message_date` INTEGER NOT NULL, PRIMARY KEY(`peer_unique_id`, `message_id`, `message_date`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `saved_gifs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `file_id` INTEGER NOT NULL, `access_hash` INTEGER NOT NULL, `file_storage_version` INTEGER NOT NULL, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `file_size` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `used_at` INTEGER NOT NULL, `mime_type` TEXT, `thumb` BLOB)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `notification_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `peer_id` TEXT NOT NULL, `message_rid` TEXT NOT NULL, `message_date` INTEGER NOT NULL, `push_type` INTEGER NOT NULL, `push_send_date` INTEGER NOT NULL, `content` TEXT, `reaction_count` INTEGER)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `service_items` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `icon` TEXT NOT NULL, `custom_icon` TEXT, `badge` TEXT, `action` INTEGER NOT NULL, `peer_id` INTEGER, `peer_type` INTEGER, `url` TEXT, `event_key` TEXT, `event_name` TEXT, `section_id` INTEGER NOT NULL, `min_app_version` INTEGER NOT NULL DEFAULT 0, `max_app_version` INTEGER NOT NULL DEFAULT 999999, `menu_items` TEXT, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `bot_items` (`id` INTEGER NOT NULL, `description` TEXT NOT NULL, `section_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `service_sections` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `badge` TEXT, `badge_type` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `user_presences` (`peer_unique_id` INTEGER NOT NULL, `last_seen` INTEGER NOT NULL, `state` INTEGER NOT NULL, `unknown` INTEGER NOT NULL, PRIMARY KEY(`peer_unique_id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `contacts` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL COLLATE LOCALIZED, `isBot` INTEGER NOT NULL, `sortKey` INTEGER NOT NULL, `avatarByte` BLOB, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `story_widget` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `story_id` TEXT NOT NULL, `trait_case` TEXT NOT NULL, `widget_data` TEXT NOT NULL, `expiration_date` INTEGER NOT NULL, `coordinates` TEXT)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `download_state` (`file_id` INTEGER NOT NULL, `access_hash` INTEGER NOT NULL, `file_name` TEXT NOT NULL, `file_size` INTEGER NOT NULL, `file_path` TEXT NOT NULL, `file_state` TEXT NOT NULL, PRIMARY KEY(`file_id`, `access_hash`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `live_streams_new` (`live_key` INTEGER NOT NULL, `peer_unique_id` INTEGER NOT NULL, `message_rid` INTEGER NOT NULL, `message_date` INTEGER NOT NULL, `user_count` INTEGER NOT NULL, PRIMARY KEY(`live_key`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `pin_message` (`peer_unique_id` INTEGER NOT NULL, `ex_peer_type` INTEGER NOT NULL, `message_rid` INTEGER NOT NULL, `message_date` INTEGER NOT NULL, `message_edited_at` INTEGER NOT NULL, PRIMARY KEY(`peer_unique_id`, `ex_peer_type`, `message_rid`, `message_date`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `top-peer` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `peerId` INTEGER NOT NULL, `score` INTEGER NOT NULL)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `peer_click` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `peerId` INTEGER NOT NULL, `clickCounts` INTEGER NOT NULL)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `premium_badges` (`badgeId` INTEGER NOT NULL, `url` TEXT NOT NULL, `mediaFormat` INTEGER NOT NULL, `downloadedContent` BLOB, PRIMARY KEY(`badgeId`, `url`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC12694f27.O("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cd86db9778b0760631b6dcc3cc7bf944')");
        }

        @Override // ir.nasim.J26.b
        public void b(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `call_log`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `aLbum_message_id`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `saved_gifs`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `notification_records`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `service_items`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `bot_items`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `service_sections`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `user_presences`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `contacts`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `story_widget`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `download_state`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `live_streams_new`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `pin_message`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `top-peer`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `peer_click`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `premium_badges`");
            List list = ((D26) ApplicationDatabase_Impl.this).h;
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
            List list = ((D26) ApplicationDatabase_Impl.this).h;
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
            ((D26) ApplicationDatabase_Impl.this).a = interfaceC12694f27;
            ApplicationDatabase_Impl.this.z(interfaceC12694f27);
            List list = ((D26) ApplicationDatabase_Impl.this).h;
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
        public J26.c g(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            HashMap map = new HashMap(10);
            map.put("time", new C13143fj7.a("time", "INTEGER", true, 0, null, 1));
            map.put("duration", new C13143fj7.a("duration", "INTEGER", true, 0, null, 1));
            map.put("peer", new C13143fj7.a("peer", "INTEGER", true, 0, null, 1));
            map.put("initiator", new C13143fj7.a("initiator", "INTEGER", true, 0, null, 1));
            map.put("finisher", new C13143fj7.a("finisher", "INTEGER", true, 0, null, 1));
            map.put("personal_call_state", new C13143fj7.a("personal_call_state", "INTEGER", true, 0, null, 1));
            map.put("group_call_state", new C13143fj7.a("group_call_state", "INTEGER", true, 0, null, 1));
            map.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map.put("peersList", new C13143fj7.a("peersList", "TEXT", true, 0, null, 1));
            map.put("state", new C13143fj7.a("state", "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj7 = new C13143fj7("call_log", map, new HashSet(0), new HashSet(0));
            C13143fj7.b bVar = C13143fj7.e;
            C13143fj7 c13143fj7A = bVar.a(interfaceC12694f27, "call_log");
            if (!c13143fj7.equals(c13143fj7A)) {
                return new J26.c(false, "call_log(ir.nasim.database.entity.CallLogEntity).\n Expected:\n" + c13143fj7 + "\n Found:\n" + c13143fj7A);
            }
            HashMap map2 = new HashMap(4);
            map2.put(PinMessageEntity.COLS_PEER_UNIQUE_ID, new C13143fj7.a(PinMessageEntity.COLS_PEER_UNIQUE_ID, "INTEGER", true, 1, null, 1));
            map2.put("album_id", new C13143fj7.a("album_id", "INTEGER", true, 0, null, 1));
            map2.put("message_id", new C13143fj7.a("message_id", "INTEGER", true, 2, null, 1));
            map2.put(PinMessageEntity.COLS_MESSAGE_DATE, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_DATE, "INTEGER", true, 3, null, 1));
            C13143fj7 c13143fj72 = new C13143fj7("aLbum_message_id", map2, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A2 = bVar.a(interfaceC12694f27, "aLbum_message_id");
            if (!c13143fj72.equals(c13143fj7A2)) {
                return new J26.c(false, "aLbum_message_id(ir.nasim.database.entity.ALbumIdToMessageIdEntity).\n Expected:\n" + c13143fj72 + "\n Found:\n" + c13143fj7A2);
            }
            HashMap map3 = new HashMap(11);
            map3.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map3.put("file_id", new C13143fj7.a("file_id", "INTEGER", true, 0, null, 1));
            map3.put("access_hash", new C13143fj7.a("access_hash", "INTEGER", true, 0, null, 1));
            map3.put("file_storage_version", new C13143fj7.a("file_storage_version", "INTEGER", true, 0, null, 1));
            map3.put("width", new C13143fj7.a("width", "INTEGER", true, 0, null, 1));
            map3.put("height", new C13143fj7.a("height", "INTEGER", true, 0, null, 1));
            map3.put("file_size", new C13143fj7.a("file_size", "INTEGER", true, 0, null, 1));
            map3.put("duration", new C13143fj7.a("duration", "INTEGER", true, 0, null, 1));
            map3.put("used_at", new C13143fj7.a("used_at", "INTEGER", true, 0, null, 1));
            map3.put("mime_type", new C13143fj7.a("mime_type", "TEXT", false, 0, null, 1));
            map3.put("thumb", new C13143fj7.a("thumb", "BLOB", false, 0, null, 1));
            C13143fj7 c13143fj73 = new C13143fj7("saved_gifs", map3, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A3 = bVar.a(interfaceC12694f27, "saved_gifs");
            if (!c13143fj73.equals(c13143fj7A3)) {
                return new J26.c(false, "saved_gifs(ir.nasim.database.entity.SavedGifEntity).\n Expected:\n" + c13143fj73 + "\n Found:\n" + c13143fj7A3);
            }
            HashMap map4 = new HashMap(8);
            map4.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map4.put("peer_id", new C13143fj7.a("peer_id", "TEXT", true, 0, null, 1));
            map4.put(PinMessageEntity.COLS_MESSAGE_RID, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_RID, "TEXT", true, 0, null, 1));
            map4.put(PinMessageEntity.COLS_MESSAGE_DATE, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_DATE, "INTEGER", true, 0, null, 1));
            map4.put("push_type", new C13143fj7.a("push_type", "INTEGER", true, 0, null, 1));
            map4.put("push_send_date", new C13143fj7.a("push_send_date", "INTEGER", true, 0, null, 1));
            map4.put("content", new C13143fj7.a("content", "TEXT", false, 0, null, 1));
            map4.put("reaction_count", new C13143fj7.a("reaction_count", "INTEGER", false, 0, null, 1));
            C13143fj7 c13143fj74 = new C13143fj7("notification_records", map4, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A4 = bVar.a(interfaceC12694f27, "notification_records");
            if (!c13143fj74.equals(c13143fj7A4)) {
                return new J26.c(false, "notification_records(ir.nasim.database.entity.NotificationRecordEntity).\n Expected:\n" + c13143fj74 + "\n Found:\n" + c13143fj7A4);
            }
            HashMap map5 = new HashMap(15);
            map5.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map5.put("title", new C13143fj7.a("title", "TEXT", true, 0, null, 1));
            map5.put(ParameterNames.ICON, new C13143fj7.a(ParameterNames.ICON, "TEXT", true, 0, null, 1));
            map5.put("custom_icon", new C13143fj7.a("custom_icon", "TEXT", false, 0, null, 1));
            map5.put("badge", new C13143fj7.a("badge", "TEXT", false, 0, null, 1));
            map5.put("action", new C13143fj7.a("action", "INTEGER", true, 0, null, 1));
            map5.put("peer_id", new C13143fj7.a("peer_id", "INTEGER", false, 0, null, 1));
            map5.put("peer_type", new C13143fj7.a("peer_type", "INTEGER", false, 0, null, 1));
            map5.put("url", new C13143fj7.a("url", "TEXT", false, 0, null, 1));
            map5.put("event_key", new C13143fj7.a("event_key", "TEXT", false, 0, null, 1));
            map5.put("event_name", new C13143fj7.a("event_name", "TEXT", false, 0, null, 1));
            map5.put("section_id", new C13143fj7.a("section_id", "INTEGER", true, 0, null, 1));
            map5.put("min_app_version", new C13143fj7.a("min_app_version", "INTEGER", true, 0, "0", 1));
            map5.put("max_app_version", new C13143fj7.a("max_app_version", "INTEGER", true, 0, "999999", 1));
            map5.put("menu_items", new C13143fj7.a("menu_items", "TEXT", false, 0, null, 1));
            C13143fj7 c13143fj75 = new C13143fj7("service_items", map5, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A5 = bVar.a(interfaceC12694f27, "service_items");
            if (!c13143fj75.equals(c13143fj7A5)) {
                return new J26.c(false, "service_items(ir.nasim.database.entity.ServiceItemEntity).\n Expected:\n" + c13143fj75 + "\n Found:\n" + c13143fj7A5);
            }
            HashMap map6 = new HashMap(3);
            map6.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map6.put("description", new C13143fj7.a("description", "TEXT", true, 0, null, 1));
            map6.put("section_id", new C13143fj7.a("section_id", "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj76 = new C13143fj7("bot_items", map6, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A6 = bVar.a(interfaceC12694f27, "bot_items");
            if (!c13143fj76.equals(c13143fj7A6)) {
                return new J26.c(false, "bot_items(ir.nasim.database.entity.BotItemEntity).\n Expected:\n" + c13143fj76 + "\n Found:\n" + c13143fj7A6);
            }
            HashMap map7 = new HashMap(4);
            map7.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map7.put("title", new C13143fj7.a("title", "TEXT", true, 0, null, 1));
            map7.put("badge", new C13143fj7.a("badge", "TEXT", false, 0, null, 1));
            map7.put("badge_type", new C13143fj7.a("badge_type", "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj77 = new C13143fj7("service_sections", map7, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A7 = bVar.a(interfaceC12694f27, "service_sections");
            if (!c13143fj77.equals(c13143fj7A7)) {
                return new J26.c(false, "service_sections(ir.nasim.database.entity.ServiceSectionEntity).\n Expected:\n" + c13143fj77 + "\n Found:\n" + c13143fj7A7);
            }
            HashMap map8 = new HashMap(4);
            map8.put(PinMessageEntity.COLS_PEER_UNIQUE_ID, new C13143fj7.a(PinMessageEntity.COLS_PEER_UNIQUE_ID, "INTEGER", true, 1, null, 1));
            map8.put("last_seen", new C13143fj7.a("last_seen", "INTEGER", true, 0, null, 1));
            map8.put("state", new C13143fj7.a("state", "INTEGER", true, 0, null, 1));
            map8.put(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, new C13143fj7.a(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj78 = new C13143fj7("user_presences", map8, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A8 = bVar.a(interfaceC12694f27, "user_presences");
            if (!c13143fj78.equals(c13143fj7A8)) {
                return new J26.c(false, "user_presences(ir.nasim.database.entity.UserPresenceEntity).\n Expected:\n" + c13143fj78 + "\n Found:\n" + c13143fj7A8);
            }
            HashMap map9 = new HashMap(5);
            map9.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map9.put("name", new C13143fj7.a("name", "TEXT", true, 0, null, 1));
            map9.put(ContactEntity.COLUMN_IS_BOT, new C13143fj7.a(ContactEntity.COLUMN_IS_BOT, "INTEGER", true, 0, null, 1));
            map9.put(ContactEntity.COLUMN_SORT_KEY, new C13143fj7.a(ContactEntity.COLUMN_SORT_KEY, "INTEGER", true, 0, null, 1));
            map9.put(ContactEntity.COLUMN_AVATAR_BYTE, new C13143fj7.a(ContactEntity.COLUMN_AVATAR_BYTE, "BLOB", false, 0, null, 1));
            C13143fj7 c13143fj79 = new C13143fj7(ContactEntity.TABLE_NAME, map9, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A9 = bVar.a(interfaceC12694f27, ContactEntity.TABLE_NAME);
            if (!c13143fj79.equals(c13143fj7A9)) {
                return new J26.c(false, "contacts(ir.nasim.database.entity.ContactEntity).\n Expected:\n" + c13143fj79 + "\n Found:\n" + c13143fj7A9);
            }
            HashMap map10 = new HashMap(6);
            map10.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map10.put("story_id", new C13143fj7.a("story_id", "TEXT", true, 0, null, 1));
            map10.put("trait_case", new C13143fj7.a("trait_case", "TEXT", true, 0, null, 1));
            map10.put("widget_data", new C13143fj7.a("widget_data", "TEXT", true, 0, null, 1));
            map10.put("expiration_date", new C13143fj7.a("expiration_date", "INTEGER", true, 0, null, 1));
            map10.put("coordinates", new C13143fj7.a("coordinates", "TEXT", false, 0, null, 1));
            C13143fj7 c13143fj710 = new C13143fj7("story_widget", map10, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A10 = bVar.a(interfaceC12694f27, "story_widget");
            if (!c13143fj710.equals(c13143fj7A10)) {
                return new J26.c(false, "story_widget(ir.nasim.database.entity.StoryWidgetEntity).\n Expected:\n" + c13143fj710 + "\n Found:\n" + c13143fj7A10);
            }
            HashMap map11 = new HashMap(6);
            map11.put("file_id", new C13143fj7.a("file_id", "INTEGER", true, 1, null, 1));
            map11.put("access_hash", new C13143fj7.a("access_hash", "INTEGER", true, 2, null, 1));
            map11.put("file_name", new C13143fj7.a("file_name", "TEXT", true, 0, null, 1));
            map11.put("file_size", new C13143fj7.a("file_size", "INTEGER", true, 0, null, 1));
            map11.put("file_path", new C13143fj7.a("file_path", "TEXT", true, 0, null, 1));
            map11.put("file_state", new C13143fj7.a("file_state", "TEXT", true, 0, null, 1));
            C13143fj7 c13143fj711 = new C13143fj7("download_state", map11, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A11 = bVar.a(interfaceC12694f27, "download_state");
            if (!c13143fj711.equals(c13143fj7A11)) {
                return new J26.c(false, "download_state(ir.nasim.database.entity.DownloadStateEntity).\n Expected:\n" + c13143fj711 + "\n Found:\n" + c13143fj7A11);
            }
            HashMap map12 = new HashMap(5);
            map12.put("live_key", new C13143fj7.a("live_key", "INTEGER", true, 1, null, 1));
            map12.put(PinMessageEntity.COLS_PEER_UNIQUE_ID, new C13143fj7.a(PinMessageEntity.COLS_PEER_UNIQUE_ID, "INTEGER", true, 0, null, 1));
            map12.put(PinMessageEntity.COLS_MESSAGE_RID, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_RID, "INTEGER", true, 0, null, 1));
            map12.put(PinMessageEntity.COLS_MESSAGE_DATE, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_DATE, "INTEGER", true, 0, null, 1));
            map12.put("user_count", new C13143fj7.a("user_count", "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj712 = new C13143fj7("live_streams_new", map12, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A12 = bVar.a(interfaceC12694f27, "live_streams_new");
            if (!c13143fj712.equals(c13143fj7A12)) {
                return new J26.c(false, "live_streams_new(ir.nasim.database.entity.LiveStreamEntity).\n Expected:\n" + c13143fj712 + "\n Found:\n" + c13143fj7A12);
            }
            HashMap map13 = new HashMap(5);
            map13.put(PinMessageEntity.COLS_PEER_UNIQUE_ID, new C13143fj7.a(PinMessageEntity.COLS_PEER_UNIQUE_ID, "INTEGER", true, 1, null, 1));
            map13.put(PinMessageEntity.COLS_EX_PEER_TYPE, new C13143fj7.a(PinMessageEntity.COLS_EX_PEER_TYPE, "INTEGER", true, 2, null, 1));
            map13.put(PinMessageEntity.COLS_MESSAGE_RID, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_RID, "INTEGER", true, 3, null, 1));
            map13.put(PinMessageEntity.COLS_MESSAGE_DATE, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_DATE, "INTEGER", true, 4, null, 1));
            map13.put(PinMessageEntity.COLS_MESSAGE_EDITED_AT, new C13143fj7.a(PinMessageEntity.COLS_MESSAGE_EDITED_AT, "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj713 = new C13143fj7(PinMessageEntity.ENTITY_NAME, map13, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A13 = bVar.a(interfaceC12694f27, PinMessageEntity.ENTITY_NAME);
            if (!c13143fj713.equals(c13143fj7A13)) {
                return new J26.c(false, "pin_message(ir.nasim.database.pinMessages.PinMessageEntity).\n Expected:\n" + c13143fj713 + "\n Found:\n" + c13143fj7A13);
            }
            HashMap map14 = new HashMap(3);
            map14.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map14.put("peerId", new C13143fj7.a("peerId", "INTEGER", true, 0, null, 1));
            map14.put("score", new C13143fj7.a("score", "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj714 = new C13143fj7("top-peer", map14, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A14 = bVar.a(interfaceC12694f27, "top-peer");
            if (!c13143fj714.equals(c13143fj7A14)) {
                return new J26.c(false, "top-peer(ir.nasim.database.entity.TopPeerEntity).\n Expected:\n" + c13143fj714 + "\n Found:\n" + c13143fj7A14);
            }
            HashMap map15 = new HashMap(3);
            map15.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map15.put("peerId", new C13143fj7.a("peerId", "INTEGER", true, 0, null, 1));
            map15.put("clickCounts", new C13143fj7.a("clickCounts", "INTEGER", true, 0, null, 1));
            C13143fj7 c13143fj715 = new C13143fj7("peer_click", map15, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A15 = bVar.a(interfaceC12694f27, "peer_click");
            if (!c13143fj715.equals(c13143fj7A15)) {
                return new J26.c(false, "peer_click(ir.nasim.database.entity.PeerClicksEntity).\n Expected:\n" + c13143fj715 + "\n Found:\n" + c13143fj7A15);
            }
            HashMap map16 = new HashMap(4);
            map16.put("badgeId", new C13143fj7.a("badgeId", "INTEGER", true, 1, null, 1));
            map16.put("url", new C13143fj7.a("url", "TEXT", true, 2, null, 1));
            map16.put("mediaFormat", new C13143fj7.a("mediaFormat", "INTEGER", true, 0, null, 1));
            map16.put("downloadedContent", new C13143fj7.a("downloadedContent", "BLOB", false, 0, null, 1));
            C13143fj7 c13143fj716 = new C13143fj7("premium_badges", map16, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A16 = bVar.a(interfaceC12694f27, "premium_badges");
            if (c13143fj716.equals(c13143fj7A16)) {
                return new J26.c(true, null);
            }
            return new J26.c(false, "premium_badges(ir.nasim.database.entity.PremiumBadgeEntity).\n Expected:\n" + c13143fj716 + "\n Found:\n" + c13143fj7A16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GX6 A0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new GX6(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8384Vs7 B0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C8384Vs7(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RI7 C0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new RI7(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19674ql n0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C19674ql(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C21348tW o0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C21348tW(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7580Si0 p0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C7580Si0(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C13857gw0 q0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C13857gw0(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7545Se1 r0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C7545Se1(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WY1 s0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new WY1(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ED3 t0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new ED3(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ID4 u0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new ID4(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19256q25 v0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C19256q25(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20207rd5 w0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C20207rd5(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C5611Kb6 x0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C5611Kb6(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6955Pr6 y0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C6955Pr6(applicationDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10599bs6 z0(ApplicationDatabase_Impl applicationDatabase_Impl) {
        AbstractC13042fc3.i(applicationDatabase_Impl, "this$0");
        return new C10599bs6(applicationDatabase_Impl);
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC19083pl I() {
        return (InterfaceC19083pl) this._albumIdToMessageIdDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC20728sW J() {
        return (InterfaceC20728sW) this._badgeDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC7346Ri0 K() {
        return (InterfaceC7346Ri0) this._botItemsDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC13266fw0 L() {
        return (InterfaceC13266fw0) this._callLogDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public AbstractC7311Re1 M() {
        return (AbstractC7311Re1) this._contactDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public UY1 N() {
        return (UY1) this._downloadStateDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public DD3 O() {
        return (DD3) this._liveStreamDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public HD4 P() {
        return (HD4) this._notificationRecordDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC18665p25 Q() {
        return (InterfaceC18665p25) this._peerClicksDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC19600qd5 R() {
        return (InterfaceC19600qd5) this._pinMessageDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC5377Jb6 S() {
        return (InterfaceC5377Jb6) this._savedGifDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC6721Or6 T() {
        return (InterfaceC6721Or6) this._serviceItemsDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public FX6 U() {
        return (FX6) this._storyWidgetDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public InterfaceC8150Us7 V() {
        return (InterfaceC8150Us7) this._topPeersDao.getValue();
    }

    @Override // ir.nasim.database.ApplicationDatabase
    public QI7 W() {
        return (QI7) this._userPresenceDao.getValue();
    }

    @Override // ir.nasim.D26
    protected d h() {
        return new d(this, new HashMap(0), new HashMap(0), "call_log", "aLbum_message_id", "saved_gifs", "notification_records", "service_items", "bot_items", "service_sections", "user_presences", ContactEntity.TABLE_NAME, "story_widget", "download_state", "live_streams_new", PinMessageEntity.ENTITY_NAME, "top-peer", "peer_click", "premium_badges");
    }

    @Override // ir.nasim.D26
    protected InterfaceC13330g27 i(C5822Kz1 config) {
        AbstractC13042fc3.i(config, "config");
        return config.c.a(InterfaceC13330g27.b.f.a(config.a).c(config.b).b(new J26(config, new a(), "cd86db9778b0760631b6dcc3cc7bf944", "60c58c0836407449efee32778b13eac4")).a());
    }

    @Override // ir.nasim.D26
    public List k(Map autoMigrationSpecs) {
        AbstractC13042fc3.i(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OF());
        arrayList.add(new PF());
        arrayList.add(new EF());
        arrayList.add(new FF());
        arrayList.add(new GF());
        arrayList.add(new HF());
        arrayList.add(new IF());
        arrayList.add(new JF());
        arrayList.add(new KF());
        arrayList.add(new LF());
        arrayList.add(new MF());
        arrayList.add(new NF());
        return arrayList;
    }

    @Override // ir.nasim.D26
    public Set q() {
        return new HashSet();
    }

    @Override // ir.nasim.D26
    protected Map r() {
        HashMap map = new HashMap();
        map.put(InterfaceC13266fw0.class, C13857gw0.i.a());
        map.put(InterfaceC19083pl.class, C19674ql.d.a());
        map.put(DD3.class, ED3.f.a());
        map.put(InterfaceC5377Jb6.class, C5611Kb6.d.a());
        map.put(HD4.class, ID4.k.a());
        map.put(InterfaceC6721Or6.class, C6955Pr6.e.a());
        map.put(InterfaceC7346Ri0.class, C7580Si0.d.a());
        map.put(InterfaceC9982as6.class, C10599bs6.d.a());
        map.put(QI7.class, RI7.d.a());
        map.put(AbstractC7311Re1.class, C7545Se1.d.a());
        map.put(FX6.class, GX6.g.a());
        map.put(UY1.class, WY1.g.a());
        map.put(InterfaceC19600qd5.class, C20207rd5.f.a());
        map.put(InterfaceC8150Us7.class, C8384Vs7.e.a());
        map.put(InterfaceC18665p25.class, C19256q25.c.a());
        map.put(InterfaceC20728sW.class, C21348tW.c.a());
        return map;
    }
}
