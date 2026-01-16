package ir.nasim;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.lS, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16537lS implements InterfaceC13330g27, SG1 {
    private final InterfaceC13330g27 a;
    public final C15946kS b;
    private final a c;

    /* renamed from: ir.nasim.lS$a */
    public static final class a implements InterfaceC12694f27 {
        private final C15946kS a;

        /* renamed from: ir.nasim.lS$a$a, reason: collision with other inner class name */
        static final class C1372a extends AbstractC8614Ws3 implements UA2 {
            public static final C1372a e = new C1372a();

            C1372a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "obj");
                return interfaceC12694f27.N();
            }
        }

        /* renamed from: ir.nasim.lS$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ String e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(1);
                this.e = str;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "db");
                interfaceC12694f27.O(this.e);
                return null;
            }
        }

        /* renamed from: ir.nasim.lS$a$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object[] f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr) {
                super(1);
                this.e = str;
                this.f = objArr;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "db");
                interfaceC12694f27.i0(this.e, this.f);
                return null;
            }
        }

        /* renamed from: ir.nasim.lS$a$d */
        /* synthetic */ class d extends EB2 implements UA2 {
            public static final d a = new d();

            d() {
                super(1, InterfaceC12694f27.class, "inTransaction", "inTransaction()Z", 0);
            }

            @Override // ir.nasim.UA2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "p0");
                return Boolean.valueOf(interfaceC12694f27.D1());
            }
        }

        /* renamed from: ir.nasim.lS$a$e */
        static final class e extends AbstractC8614Ws3 implements UA2 {
            public static final e e = new e();

            e() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "db");
                return Boolean.valueOf(interfaceC12694f27.N1());
            }
        }

        /* renamed from: ir.nasim.lS$a$f */
        static final class f extends AbstractC8614Ws3 implements UA2 {
            public static final f e = new f();

            f() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "obj");
                return interfaceC12694f27.A();
            }
        }

        /* renamed from: ir.nasim.lS$a$g */
        static final class g extends AbstractC8614Ws3 implements UA2 {
            public static final g e = new g();

            g() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "it");
                return null;
            }
        }

        public a(C15946kS c15946kS) {
            AbstractC13042fc3.i(c15946kS, "autoCloser");
            this.a = c15946kS;
        }

        @Override // ir.nasim.InterfaceC12694f27
        public String A() {
            return (String) this.a.g(f.e);
        }

        @Override // ir.nasim.InterfaceC12694f27
        public boolean D1() {
            if (this.a.h() == null) {
                return false;
            }
            return ((Boolean) this.a.g(d.a)).booleanValue();
        }

        @Override // ir.nasim.InterfaceC12694f27
        public void I() {
            try {
                this.a.j().I();
            } catch (Throwable th) {
                this.a.e();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC12694f27
        public List N() {
            return (List) this.a.g(C1372a.e);
        }

        @Override // ir.nasim.InterfaceC12694f27
        public boolean N1() {
            return ((Boolean) this.a.g(e.e)).booleanValue();
        }

        @Override // ir.nasim.InterfaceC12694f27
        public void O(String str) {
            AbstractC13042fc3.i(str, "sql");
            this.a.g(new b(str));
        }

        @Override // ir.nasim.InterfaceC12694f27
        public Cursor P1(InterfaceC14514i27 interfaceC14514i27) {
            AbstractC13042fc3.i(interfaceC14514i27, "query");
            try {
                return new c(this.a.j().P1(interfaceC14514i27), this.a);
            } catch (Throwable th) {
                this.a.e();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC12694f27
        public InterfaceC15121j27 Z0(String str) {
            AbstractC13042fc3.i(str, "sql");
            return new b(str, this.a);
        }

        public final void a() {
            this.a.g(g.e);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.d();
        }

        @Override // ir.nasim.InterfaceC12694f27
        public void h0() {
            C19938rB7 c19938rB7;
            InterfaceC12694f27 interfaceC12694f27H = this.a.h();
            if (interfaceC12694f27H != null) {
                interfaceC12694f27H.h0();
                c19938rB7 = C19938rB7.a;
            } else {
                c19938rB7 = null;
            }
            if (c19938rB7 == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
            }
        }

        @Override // ir.nasim.InterfaceC12694f27
        public void i0(String str, Object[] objArr) {
            AbstractC13042fc3.i(str, "sql");
            AbstractC13042fc3.i(objArr, "bindArgs");
            this.a.g(new c(str, objArr));
        }

        @Override // ir.nasim.InterfaceC12694f27
        public boolean isOpen() {
            InterfaceC12694f27 interfaceC12694f27H = this.a.h();
            if (interfaceC12694f27H == null) {
                return false;
            }
            return interfaceC12694f27H.isOpen();
        }

        @Override // ir.nasim.InterfaceC12694f27
        public void j0() {
            try {
                this.a.j().j0();
            } catch (Throwable th) {
                this.a.e();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC12694f27
        public Cursor p0(InterfaceC14514i27 interfaceC14514i27, CancellationSignal cancellationSignal) {
            AbstractC13042fc3.i(interfaceC14514i27, "query");
            try {
                return new c(this.a.j().p0(interfaceC14514i27, cancellationSignal), this.a);
            } catch (Throwable th) {
                this.a.e();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC12694f27
        public Cursor r1(String str) {
            AbstractC13042fc3.i(str, "query");
            try {
                return new c(this.a.j().r1(str), this.a);
            } catch (Throwable th) {
                this.a.e();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC12694f27
        public void t0() {
            if (this.a.h() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null".toString());
            }
            try {
                InterfaceC12694f27 interfaceC12694f27H = this.a.h();
                AbstractC13042fc3.f(interfaceC12694f27H);
                interfaceC12694f27H.t0();
            } finally {
                this.a.e();
            }
        }
    }

    /* renamed from: ir.nasim.lS$c */
    private static final class c implements Cursor {
        private final Cursor a;
        private final C15946kS b;

        public c(Cursor cursor, C15946kS c15946kS) {
            AbstractC13042fc3.i(cursor, "delegate");
            AbstractC13042fc3.i(c15946kS, "autoCloser");
            this.a = cursor;
            this.b = c15946kS;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
            this.b.e();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
            this.a.copyStringToBuffer(i, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i) {
            return this.a.getBlob(i);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i) {
            return this.a.getColumnName(i);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i) {
            return this.a.getDouble(i);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i) {
            return this.a.getFloat(i);
        }

        @Override // android.database.Cursor
        public int getInt(int i) {
            return this.a.getInt(i);
        }

        @Override // android.database.Cursor
        public long getLong(int i) {
            return this.a.getLong(i);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return C10080b27.a(this.a);
        }

        @Override // android.database.Cursor
        public List getNotificationUris() {
            return C12103e27.a(this.a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i) {
            return this.a.getShort(i);
        }

        @Override // android.database.Cursor
        public String getString(int i) {
            return this.a.getString(i);
        }

        @Override // android.database.Cursor
        public int getType(int i) {
            return this.a.getType(i);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i) {
            return this.a.isNull(i);
        }

        @Override // android.database.Cursor
        public boolean move(int i) {
            return this.a.move(i);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i) {
            return this.a.moveToPosition(i);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.a.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            AbstractC13042fc3.i(bundle, "extras");
            C11460d27.a(this.a, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver contentResolver, List list) {
            AbstractC13042fc3.i(contentResolver, "cr");
            AbstractC13042fc3.i(list, "uris");
            C12103e27.b(this.a, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public C16537lS(InterfaceC13330g27 interfaceC13330g27, C15946kS c15946kS) {
        AbstractC13042fc3.i(interfaceC13330g27, "delegate");
        AbstractC13042fc3.i(c15946kS, "autoCloser");
        this.a = interfaceC13330g27;
        this.b = c15946kS;
        c15946kS.k(a());
        this.c = new a(c15946kS);
    }

    @Override // ir.nasim.InterfaceC13330g27
    public InterfaceC12694f27 E() {
        this.c.a();
        return this.c;
    }

    @Override // ir.nasim.SG1
    public InterfaceC13330g27 a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC13330g27, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }

    @Override // ir.nasim.InterfaceC13330g27
    public String getDatabaseName() {
        return this.a.getDatabaseName();
    }

    @Override // ir.nasim.InterfaceC13330g27
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.a.setWriteAheadLoggingEnabled(z);
    }

    /* renamed from: ir.nasim.lS$b */
    private static final class b implements InterfaceC15121j27 {
        private final String a;
        private final C15946kS b;
        private final ArrayList c;

        /* renamed from: ir.nasim.lS$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Long invoke(InterfaceC15121j27 interfaceC15121j27) {
                AbstractC13042fc3.i(interfaceC15121j27, "obj");
                return Long.valueOf(interfaceC15121j27.M0());
            }
        }

        /* renamed from: ir.nasim.lS$b$b, reason: collision with other inner class name */
        static final class C1373b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1373b(UA2 ua2) {
                super(1);
                this.f = ua2;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC12694f27 interfaceC12694f27) {
                AbstractC13042fc3.i(interfaceC12694f27, "db");
                InterfaceC15121j27 interfaceC15121j27Z0 = interfaceC12694f27.Z0(b.this.a);
                b.this.c(interfaceC15121j27Z0);
                return this.f.invoke(interfaceC15121j27Z0);
            }
        }

        /* renamed from: ir.nasim.lS$b$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            public static final c e = new c();

            c() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(InterfaceC15121j27 interfaceC15121j27) {
                AbstractC13042fc3.i(interfaceC15121j27, "obj");
                return Integer.valueOf(interfaceC15121j27.V());
            }
        }

        public b(String str, C15946kS c15946kS) {
            AbstractC13042fc3.i(str, "sql");
            AbstractC13042fc3.i(c15946kS, "autoCloser");
            this.a = str;
            this.b = c15946kS;
            this.c = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(InterfaceC15121j27 interfaceC15121j27) {
            Iterator it = this.c.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                Object obj = this.c.get(i);
                if (obj == null) {
                    interfaceC15121j27.y1(i2);
                } else if (obj instanceof Long) {
                    interfaceC15121j27.k1(i2, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    interfaceC15121j27.Y(i2, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    interfaceC15121j27.U0(i2, (String) obj);
                } else if (obj instanceof byte[]) {
                    interfaceC15121j27.n1(i2, (byte[]) obj);
                }
                i = i2;
            }
        }

        private final Object d(UA2 ua2) {
            return this.b.g(new C1373b(ua2));
        }

        private final void e(int i, Object obj) {
            int size;
            int i2 = i - 1;
            if (i2 >= this.c.size() && (size = this.c.size()) <= i2) {
                while (true) {
                    this.c.add(null);
                    if (size == i2) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.c.set(i2, obj);
        }

        @Override // ir.nasim.InterfaceC15121j27
        public long M0() {
            return ((Number) d(a.e)).longValue();
        }

        @Override // ir.nasim.InterfaceC13921h27
        public void U0(int i, String str) {
            AbstractC13042fc3.i(str, "value");
            e(i, str);
        }

        @Override // ir.nasim.InterfaceC15121j27
        public int V() {
            return ((Number) d(c.e)).intValue();
        }

        @Override // ir.nasim.InterfaceC13921h27
        public void Y(int i, double d) {
            e(i, Double.valueOf(d));
        }

        @Override // ir.nasim.InterfaceC13921h27
        public void k1(int i, long j) {
            e(i, Long.valueOf(j));
        }

        @Override // ir.nasim.InterfaceC13921h27
        public void n1(int i, byte[] bArr) {
            AbstractC13042fc3.i(bArr, "value");
            e(i, bArr);
        }

        @Override // ir.nasim.InterfaceC13921h27
        public void y1(int i) {
            e(i, null);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
