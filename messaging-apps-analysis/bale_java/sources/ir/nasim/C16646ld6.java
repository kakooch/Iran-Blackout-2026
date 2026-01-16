package ir.nasim;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.gov.nist.core.Separators;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.ld6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16646ld6 extends SQLiteOpenHelper {
    private static final String c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + Separators.RPAREN;
    static int d = 5;
    private static final a e;
    private static final a f;
    private static final a g;
    private static final a h;
    private static final a i;
    private static final List j;
    private final int a;
    private boolean b;

    /* renamed from: ir.nasim.ld6$a */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: ir.nasim.gd6
            @Override // ir.nasim.C16646ld6.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                C16646ld6.j(sQLiteDatabase);
            }
        };
        e = aVar;
        a aVar2 = new a() { // from class: ir.nasim.hd6
            @Override // ir.nasim.C16646ld6.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                C16646ld6.k(sQLiteDatabase);
            }
        };
        f = aVar2;
        a aVar3 = new a() { // from class: ir.nasim.id6
            @Override // ir.nasim.C16646ld6.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        g = aVar3;
        a aVar4 = new a() { // from class: ir.nasim.jd6
            @Override // ir.nasim.C16646ld6.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                C16646ld6.m(sQLiteDatabase);
            }
        };
        h = aVar4;
        a aVar5 = new a() { // from class: ir.nasim.kd6
            @Override // ir.nasim.C16646ld6.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                C16646ld6.n(sQLiteDatabase);
            }
        };
        i = aVar5;
        j = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    C16646ld6(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.b = false;
        this.a = i2;
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        if (this.b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(c);
    }

    private void p(SQLiteDatabase sQLiteDatabase, int i2) {
        g(sQLiteDatabase);
        q(sQLiteDatabase, 0, i2);
    }

    private void q(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        List list = j;
        if (i3 <= list.size()) {
            while (i2 < i3) {
                ((a) j.get(i2)).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i3 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        p(sQLiteDatabase, this.a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        p(sQLiteDatabase, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        g(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        g(sQLiteDatabase);
        q(sQLiteDatabase, i2, i3);
    }
}
