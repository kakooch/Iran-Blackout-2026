package ir.nasim;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class J13 extends YC2 {
    private static final a s = new a(null);
    public static final int t = 8;
    private final Context k;
    private final AbstractC13778go1 l;
    private final InterfaceC9173Yu3 m;
    private final InterfaceC9173Yu3 n;
    private final InterfaceC9173Yu3 o;
    private final InterfaceC9173Yu3 p;
    private final c q;
    private final b r;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends ContentObserver {
        b() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            J13.this.i().c(C19938rB7.a);
        }
    }

    public static final class c extends ContentObserver {
        c() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            J13.this.j().c(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Cursor c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Cursor cursor, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = cursor;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Cursor cursor = this.c;
            try {
                Cursor cursor2 = cursor;
                int columnIndex = cursor2.getColumnIndex("bucket_id");
                int columnIndex2 = cursor2.getColumnIndex("bucket_display_name");
                HashMap map = new HashMap(cursor2.getCount());
                if (!cursor2.moveToFirst()) {
                    Map mapK = AbstractC20051rO3.k();
                    YV0.a(cursor, null);
                    return mapK;
                }
                do {
                    long j = cursor2.getLong(columnIndex);
                    String string = cursor2.getString(columnIndex2);
                    if (string == null) {
                        C19406qI3.j("ImageDataSource", "MediaStore.Bucket_Display_Name with id(" + j + ") was null", new Object[0]);
                    }
                    Long lE = AbstractC6392Nk0.e(j);
                    Object xv4 = map.get(lE);
                    if (xv4 == null) {
                        xv4 = new XV4(string, AbstractC6392Nk0.d(0));
                        map.put(lE, xv4);
                    }
                    XV4 xv42 = (XV4) xv4;
                    map.put(AbstractC6392Nk0.e(j), XV4.d(xv42, null, AbstractC6392Nk0.d(((Number) xv42.f()).intValue() + 1), 1, null));
                } while (cursor2.moveToNext());
                LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(map.size()));
                for (Object obj2 : map.entrySet()) {
                    Object key = ((Map.Entry) obj2).getKey();
                    Map.Entry entry = (Map.Entry) obj2;
                    long jLongValue = ((Number) entry.getKey()).longValue();
                    XV4 xv43 = (XV4) entry.getValue();
                    linkedHashMap.put(key, new C3808Cl0(jLongValue, ((Number) xv43.b()).intValue(), (String) xv43.a()));
                }
                YV0.a(cursor, null);
                return linkedHashMap;
            } finally {
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return J13.this.k(this);
        }
    }

    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return J13.this.l(this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri d;

        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((C9588aD2) obj2).d()), Long.valueOf(((C9588aD2) obj).d()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return J13.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            J13 j13 = J13.this;
            Cursor cursorJ = j13.J(j13.k, this.d);
            if (cursorJ != null) {
                Cursor cursor = cursorJ;
                J13 j132 = J13.this;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor2.getColumnIndex("_id");
                    int columnIndex2 = cursor2.getColumnIndex("_data");
                    int columnIndex3 = cursor2.getColumnIndex(j132.B());
                    int columnIndex4 = cursor2.getColumnIndex("orientation");
                    int columnIndex5 = cursor2.getColumnIndex("bucket_id");
                    while (cursor2.moveToNext()) {
                        String string = cursor2.getString(columnIndex2);
                        String str = string.length() > 0 ? string : null;
                        if (str != null) {
                            arrayList.add(new C9588aD2(cursor2.getInt(columnIndex), str, null, cursor2.getLong(columnIndex3), cursor2.getInt(columnIndex4), cursor2.getLong(columnIndex5)));
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    YV0.a(cursor, null);
                } finally {
                }
            }
            return AbstractC15401jX0.a1(arrayList, new a());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public J13(Context context, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.k = context;
        this.l = abstractC13778go1;
        this.m = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.F13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return J13.D();
            }
        });
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.G13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return J13.y();
            }
        });
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.H13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return J13.G();
            }
        });
        this.p = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.I13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return J13.H(this.a);
            }
        });
        this.q = new c();
        this.r = new b();
        K();
    }

    private final Uri A() {
        return (Uri) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B() {
        return (String) this.o.getValue();
    }

    private final String[] C() {
        return (String[]) this.p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri D() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Images.Media.getContentUri("internal") : MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    }

    private final Object E(Cursor cursor, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.l, new d(cursor, null), interfaceC20295rm1);
    }

    private final Object F(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new g(uri, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String G() {
        return Build.VERSION.SDK_INT > 28 ? "date_modified" : "datetaken";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] H(J13 j13) {
        AbstractC13042fc3.i(j13, "this$0");
        return new String[]{"_id", "_data", j13.B(), "orientation", "bucket_id"};
    }

    private final Cursor I(Context context, Uri uri) {
        return context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name"}, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Cursor J(Context context, Uri uri) {
        return context.getContentResolver().query(uri, C(), null, null, (Build.VERSION.SDK_INT > 28 ? "date_modified" : "datetaken") + " DESC");
    }

    private final void K() {
        ContentResolver contentResolver = this.k.getContentResolver();
        contentResolver.registerContentObserver(A(), true, this.q);
        contentResolver.registerContentObserver(z(), true, this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri y() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Images.Media.getContentUri("external") : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    private final Uri z() {
        return (Uri) this.n.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YC2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object k(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.J13.e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.J13$e r0 = (ir.nasim.J13.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.J13$e r0 = new ir.nasim.J13$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            android.content.Context r6 = r5.k
            android.net.Uri r2 = r5.z()
            java.lang.String r4 = "<get-externalStorageUri>(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r4)
            android.database.Cursor r6 = r5.I(r6, r2)
            if (r6 == 0) goto L51
            r0.c = r3
            java.lang.Object r6 = r5.E(r6, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            java.util.Map r6 = (java.util.Map) r6
            goto L52
        L51:
            r6 = 0
        L52:
            if (r6 != 0) goto L58
            java.util.Map r6 = ir.nasim.AbstractC18278oO3.k()
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J13.k(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YC2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object l(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.J13.f
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.J13$f r0 = (ir.nasim.J13.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.J13$f r0 = new ir.nasim.J13$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            android.content.Context r6 = r5.k
            android.net.Uri r2 = r5.A()
            java.lang.String r4 = "<get-internalStorageUri>(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r4)
            android.database.Cursor r6 = r5.I(r6, r2)
            if (r6 == 0) goto L51
            r0.c = r3
            java.lang.Object r6 = r5.E(r6, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            java.util.Map r6 = (java.util.Map) r6
            goto L52
        L51:
            r6 = 0
        L52:
            if (r6 != 0) goto L58
            java.util.Map r6 = ir.nasim.AbstractC18278oO3.k()
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J13.l(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YC2
    protected Object m(InterfaceC20295rm1 interfaceC20295rm1) {
        Uri uriZ = z();
        AbstractC13042fc3.h(uriZ, "<get-externalStorageUri>(...)");
        return F(uriZ, interfaceC20295rm1);
    }

    @Override // ir.nasim.YC2
    protected Object n(InterfaceC20295rm1 interfaceC20295rm1) {
        Uri uriA = A();
        AbstractC13042fc3.h(uriA, "<get-internalStorageUri>(...)");
        return F(uriA, interfaceC20295rm1);
    }
}
