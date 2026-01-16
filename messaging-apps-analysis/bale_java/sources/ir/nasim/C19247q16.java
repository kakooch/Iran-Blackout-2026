package ir.nasim;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.q16, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19247q16 {
    private static final a c = new a(null);
    public static final int d = 8;
    private final Context a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.q16$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.q16$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C19247q16.this.c(null, null, this);
        }
    }

    /* renamed from: ir.nasim.q16$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C19247q16.this.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.q16$d */
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
            return C19247q16.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            int columnIndex;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                Cursor cursorQuery = C19247q16.this.a.getContentResolver().query(this.d, new String[]{"mime_type"}, null, null, null);
                if (cursorQuery == null) {
                    return null;
                }
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    String string = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("mime_type")) < 0) ? null : cursor2.getString(columnIndex);
                    YV0.a(cursor, null);
                    return string;
                } finally {
                }
            } catch (Exception e) {
                C19406qI3.c("RetrieveMimeTypeUseCase", "Failed to load mime type of " + this.d + " by querying", e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.q16$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(this.c);
                    return mediaMetadataRetriever.extractMetadata(12);
                } catch (Exception e) {
                    if (e instanceof CancellationException) {
                        throw e;
                    }
                    C19406qI3.c("RetrieveMimeTypeUseCase", "Failed to load mime type of " + this.c, e);
                    mediaMetadataRetriever.release();
                    return null;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.q16$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19247q16.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(C19247q16.this.a, this.d);
                    return mediaMetadataRetriever.extractMetadata(12);
                } catch (Exception e) {
                    if (e instanceof CancellationException) {
                        throw e;
                    }
                    C19406qI3.c("RetrieveMimeTypeUseCase", "Failed to load mime type of " + this.d, e);
                    mediaMetadataRetriever.release();
                    return null;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19247q16(Context context, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = context;
        this.b = abstractC13778go1;
    }

    private final Object d(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new d(uri, null), interfaceC20295rm1);
    }

    private final String e(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        AbstractC13042fc3.f(fileExtensionFromUrl);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = fileExtensionFromUrl.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }

    private final Object f(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new f(uri, null), interfaceC20295rm1);
    }

    private final Object g(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new e(str, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b7 A[Catch: Exception -> 0x00c3, TryCatch #0 {Exception -> 0x00c3, blocks: (B:41:0x00ab, B:43:0x00b7, B:47:0x00c5), top: B:53:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c5 A[Catch: Exception -> 0x00c3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c3, blocks: (B:41:0x00ab, B:43:0x00b7, B:47:0x00c5), top: B:53:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(android.net.Uri r9, ir.nasim.UA2 r10, ir.nasim.InterfaceC20295rm1 r11) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19247q16.b(android.net.Uri, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r6, ir.nasim.UA2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C19247q16.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.q16$b r0 = (ir.nasim.C19247q16.b) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.q16$b r0 = new ir.nasim.q16$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.a
            ir.nasim.q16 r7 = (ir.nasim.C19247q16) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L78
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.c
            r7 = r6
            ir.nasim.UA2 r7 = (ir.nasim.UA2) r7
            java.lang.Object r6 = r0.b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.a
            ir.nasim.q16 r2 = (ir.nasim.C19247q16) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L60
        L4d:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r5.g(r6, r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            r2 = r5
        L60:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L65
            return r8
        L65:
            if (r7 == 0) goto L7e
            r0.a = r2
            r0.b = r6
            r8 = 0
            r0.c = r8
            r0.f = r3
            java.lang.Object r8 = r7.invoke(r0)
            if (r8 != r1) goto L77
            return r1
        L77:
            r7 = r2
        L78:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L7d
            return r8
        L7d:
            r2 = r7
        L7e:
            java.lang.String r6 = r2.e(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19247q16.c(java.lang.String, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }
}
