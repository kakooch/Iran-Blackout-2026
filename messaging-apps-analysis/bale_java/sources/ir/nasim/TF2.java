package ir.nasim;

import android.content.Context;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes4.dex */
public final class TF2 {
    private static final a d = new a(null);
    public static final int e = 8;
    private final Context a;
    private final AbstractC13778go1 b;
    private final int c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ Context d;
        final /* synthetic */ Uri e;
        final /* synthetic */ String f;
        final /* synthetic */ String[] g;
        final /* synthetic */ TF2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, Uri uri, String str, String[] strArr, TF2 tf2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = context;
            this.e = uri;
            this.f = str;
            this.g = strArr;
            this.h = tf2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Closeable closeable;
            Throwable th;
            String str;
            int columnIndex;
            String string;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Cursor cursorQuery = this.d.getContentResolver().query(this.e, new String[]{"_data"}, this.f, this.g, null);
                    if (cursorQuery == null) {
                        return null;
                    }
                    Cursor cursor = cursorQuery;
                    TF2 tf2 = this.h;
                    try {
                        Cursor cursor2 = cursor;
                        if (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_data")) < 0 || (string = cursor2.getString(columnIndex)) == null) {
                            closeable = cursor;
                            str = null;
                            YV0.a(closeable, null);
                            return str;
                        }
                        this.b = cursor;
                        this.c = 1;
                        Object objT = tf2.t(string, this);
                        if (objT == objE) {
                            return objE;
                        }
                        closeable = cursor;
                        obj = objT;
                    } catch (Throwable th2) {
                        closeable = cursor;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable = (Closeable) this.b;
                    try {
                        AbstractC10685c16.b(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            YV0.a(closeable, th);
                            throw th4;
                        }
                    }
                }
                str = (String) obj;
                YV0.a(closeable, null);
                return str;
            } catch (Exception e) {
                C19406qI3.d("GetFilePathFromUriUseCase", e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Context c;
        final /* synthetic */ Uri d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = context;
            this.d = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            int columnIndex;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Cursor cursorQuery = this.c.getContentResolver().query(this.d, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                String string = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_display_name")) < 0) ? null : cursor2.getString(columnIndex);
                YV0.a(cursor, null);
                return string;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    YV0.a(cursor, th);
                    throw th2;
                }
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TF2.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            int columnIndex;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Cursor cursorQuery = TF2.this.a.getContentResolver().query(this.d, null, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex("_display_name")) >= 0) {
                        String string = cursor2.getString(columnIndex);
                        YV0.a(cursor, null);
                        return string;
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    YV0.a(cursor, null);
                } finally {
                }
            }
            String string2 = this.d.toString();
            AbstractC13042fc3.h(string2, "toString(...)");
            return AbstractC15401jX0.F0(AbstractC20762sZ6.N0(string2, new String[]{Separators.SLASH}, false, 0, 6, null));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;
        int f;
        final /* synthetic */ Uri h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TF2.this.new e(this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:60|100|61|62|107|63|(1:65)(7:66|111|67|(0)|70|79|(2:80|115)(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0186, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0187, code lost:
        
            r2 = r16;
            r4 = r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x018b, code lost:
        
            r3 = r20;
            r1 = r21;
         */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0180 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01a6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0174 -> B:111:0x017c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x019d -> B:70:0x0181). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 513
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TF2.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri c;
        final /* synthetic */ TF2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Uri uri, TF2 tf2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = uri;
            this.d = tf2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009a A[ORIG_RETURN, RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.b
                r2 = 1
                if (r1 == 0) goto L18
                if (r1 != r2) goto L10
                ir.nasim.AbstractC10685c16.b(r10)
                goto L97
            L10:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L18:
                ir.nasim.AbstractC10685c16.b(r10)
                android.net.Uri r10 = r9.c
                java.lang.String r3 = android.provider.DocumentsContract.getDocumentId(r10)
                ir.nasim.AbstractC13042fc3.f(r3)
                java.lang.String r10 = ":"
                java.lang.String[] r4 = new java.lang.String[]{r10}
                r7 = 6
                r8 = 0
                r5 = 0
                r6 = 0
                java.util.List r10 = ir.nasim.AbstractC14836iZ6.N0(r3, r4, r5, r6, r7, r8)
                java.lang.Object r1 = ir.nasim.ZW0.s0(r10)
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L73
                int r3 = r1.hashCode()
                r4 = 93166550(0x58d9bd6, float:1.3316821E-35)
                if (r3 == r4) goto L67
                r4 = 100313435(0x5faa95b, float:2.3572098E-35)
                if (r3 == r4) goto L5b
                r4 = 112202875(0x6b0147b, float:6.6233935E-35)
                if (r3 == r4) goto L4e
                goto L73
            L4e:
                java.lang.String r3 = "video"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L57
                goto L73
            L57:
                android.net.Uri r1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            L59:
                r5 = r1
                goto L7a
            L5b:
                java.lang.String r3 = "image"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L64
                goto L73
            L64:
                android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                goto L59
            L67:
                java.lang.String r3 = "audio"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L70
                goto L73
            L70:
                android.net.Uri r1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                goto L59
            L73:
                java.lang.String r1 = "external"
                android.net.Uri r1 = android.provider.MediaStore.Files.getContentUri(r1)
                goto L59
            L7a:
                java.lang.String[] r7 = new java.lang.String[r2]
                r1 = 0
                java.lang.Object r10 = r10.get(r2)
                r7[r1] = r10
                if (r5 == 0) goto L9a
                ir.nasim.TF2 r3 = r9.d
                android.content.Context r4 = ir.nasim.TF2.a(r3)
                r9.b = r2
                java.lang.String r6 = "_id = ?"
                r8 = r9
                java.lang.Object r10 = ir.nasim.TF2.c(r3, r4, r5, r6, r7, r8)
                if (r10 != r0) goto L97
                return r0
            L97:
                java.lang.String r10 = (java.lang.String) r10
                goto L9b
            L9a:
                r10 = 0
            L9b:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TF2.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri c;
        final /* synthetic */ TF2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Uri uri, TF2 tf2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = uri;
            this.d = tf2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strO;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    String authority = this.c.getAuthority();
                    if (authority == null) {
                        strO = null;
                    } else {
                        int iHashCode = authority.hashCode();
                        if (iHashCode != 320699453) {
                            if (iHashCode != 596745902) {
                                if (iHashCode == 1734583286 && authority.equals("com.android.providers.media.documents")) {
                                    TF2 tf2 = this.d;
                                    Uri uri = this.c;
                                    this.b = 2;
                                    obj = tf2.p(uri, this);
                                    if (obj == objE) {
                                        return objE;
                                    }
                                    strO = (String) obj;
                                }
                            } else if (authority.equals("com.android.externalstorage.documents")) {
                                strO = this.d.o(this.c);
                            }
                        } else if (authority.equals("com.android.providers.downloads.documents")) {
                            TF2 tf22 = this.d;
                            Uri uri2 = this.c;
                            this.b = 1;
                            obj = tf22.n(uri2, this);
                            if (obj == objE) {
                                return objE;
                            }
                            strO = (String) obj;
                        }
                        strO = null;
                    }
                    return (String) obj;
                }
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    strO = (String) obj;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return (String) obj;
                    }
                    AbstractC10685c16.b(obj);
                    strO = (String) obj;
                }
                if (strO == null) {
                    return null;
                }
                TF2 tf23 = this.d;
                this.b = 3;
                obj = tf23.t(strO, this);
                if (obj == objE) {
                    return objE;
                }
                return (String) obj;
            } catch (Exception e) {
                C19406qI3.d("GetFilePathFromUriUseCase", e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return TF2.this.r(null, this);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TF2.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    TF2 tf2 = TF2.this;
                    Uri uri = this.d;
                    this.b = 1;
                    obj = tf2.m(uri, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                String str = (String) obj;
                if (str == null) {
                    str = "temp_" + AbstractC17026mG5.a.k();
                }
                File file = new File(TF2.this.a.getCacheDir(), str);
                file.delete();
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    InputStream inputStreamOpenInputStream = TF2.this.a.getContentResolver().openInputStream(this.d);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            AbstractC6392Nk0.e(AbstractC7873To0.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null));
                            YV0.a(inputStreamOpenInputStream, null);
                        } finally {
                        }
                    }
                    YV0.a(fileOutputStream, null);
                    return file.getPath();
                } finally {
                }
            } catch (Exception e) {
                C19406qI3.d("GetFilePathFromUriUseCase", e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                String str = this.c;
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                if (file.canRead()) {
                    return str;
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public TF2(Context context, AbstractC13778go1 abstractC13778go1, int i2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = context;
        this.b = abstractC13778go1;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(Context context, Uri uri, String str, String[] strArr, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new b(context, uri, str, strArr, this, null), interfaceC20295rm1);
    }

    static /* synthetic */ Object k(TF2 tf2, Context context, Uri uri, String str, String[] strArr, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        return tf2.j(context, uri, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : strArr, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(Context context, Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new c(context, uri, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new d(uri, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new e(uri, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o(Uri uri) {
        String str;
        String str2;
        String documentId = DocumentsContract.getDocumentId(uri);
        AbstractC13042fc3.f(documentId);
        List listN0 = AbstractC20762sZ6.N0(documentId, new String[]{":"}, false, 0, 6, null);
        String str3 = (String) listN0.get(0);
        String str4 = Separators.SLASH + listN0.get(1);
        if (AbstractC20153rZ6.D("primary", str3, true)) {
            String str5 = Environment.getExternalStorageDirectory() + str4;
            if (new File(str5).exists()) {
                return str5;
            }
        }
        String str6 = System.getenv("SECONDARY_STORAGE");
        if (str6 != null) {
            str = str6 + str4;
        } else {
            str = null;
        }
        if (str != null && new File(str).exists()) {
            return str;
        }
        String str7 = System.getenv("EXTERNAL_STORAGE");
        if (str7 != null) {
            str2 = str7 + str4;
        } else {
            str2 = null;
        }
        if (str2 == null || !new File(str2).exists()) {
            return null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new f(uri, this, null), interfaceC20295rm1);
    }

    private final Object q(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new g(uri, this, null), interfaceC20295rm1);
    }

    private final Object s(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new i(uri, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new j(str, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(android.net.Uri r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TF2.r(android.net.Uri, ir.nasim.rm1):java.lang.Object");
    }
}
