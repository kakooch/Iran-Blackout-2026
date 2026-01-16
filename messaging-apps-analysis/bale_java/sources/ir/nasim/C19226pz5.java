package ir.nasim;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: ir.nasim.pz5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19226pz5 implements InterfaceC13701gg4 {
    private final Context a;
    private final InterfaceC13701gg4 b;
    private final InterfaceC13701gg4 c;
    private final Class d;

    /* renamed from: ir.nasim.pz5$a */
    private static abstract class a implements InterfaceC14292hg4 {
        private final Context a;
        private final Class b;

        a(Context context, Class cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public final InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C19226pz5(this.a, c23932xl4.d(File.class, this.b), c23932xl4.d(Uri.class, this.b), this.b);
        }
    }

    /* renamed from: ir.nasim.pz5$b */
    public static final class b extends a {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* renamed from: ir.nasim.pz5$c */
    public static final class c extends a {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* renamed from: ir.nasim.pz5$d */
    private static final class d implements InterfaceC8666Wy1 {
        private static final String[] k = {"_data"};
        private final Context a;
        private final InterfaceC13701gg4 b;
        private final InterfaceC13701gg4 c;
        private final Uri d;
        private final int e;
        private final int f;
        private final HL4 g;
        private final Class h;
        private volatile boolean i;
        private volatile InterfaceC8666Wy1 j;

        d(Context context, InterfaceC13701gg4 interfaceC13701gg4, InterfaceC13701gg4 interfaceC13701gg42, Uri uri, int i, int i2, HL4 hl4, Class cls) {
            this.a = context.getApplicationContext();
            this.b = interfaceC13701gg4;
            this.c = interfaceC13701gg42;
            this.d = uri;
            this.e = i;
            this.f = i2;
            this.g = hl4;
            this.h = cls;
        }

        private InterfaceC13701gg4.a c() {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.b(h(this.d), this.e, this.f, this.g);
            }
            if (AbstractC19559qZ3.a(this.d)) {
                return this.c.b(this.d, this.e, this.f, this.g);
            }
            return this.c.b(g() ? MediaStore.setRequireOriginal(this.d) : this.d, this.e, this.f, this.g);
        }

        private InterfaceC8666Wy1 f() {
            InterfaceC13701gg4.a aVarC = c();
            if (aVarC != null) {
                return aVarC.c;
            }
            return null;
        }

        private boolean g() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        private File h(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.a.getContentResolver().query(uri, k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
            InterfaceC8666Wy1 interfaceC8666Wy1 = this.j;
            if (interfaceC8666Wy1 != null) {
                interfaceC8666Wy1.b();
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
            this.i = true;
            InterfaceC8666Wy1 interfaceC8666Wy1 = this.j;
            if (interfaceC8666Wy1 != null) {
                interfaceC8666Wy1.cancel();
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            try {
                InterfaceC8666Wy1 interfaceC8666Wy1F = f();
                if (interfaceC8666Wy1F == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                    return;
                }
                this.j = interfaceC8666Wy1F;
                if (this.i) {
                    cancel();
                } else {
                    interfaceC8666Wy1F.e(enumC6212Mq5, aVar);
                }
            } catch (FileNotFoundException e) {
                aVar.c(e);
            }
        }
    }

    C19226pz5(Context context, InterfaceC13701gg4 interfaceC13701gg4, InterfaceC13701gg4 interfaceC13701gg42, Class cls) {
        this.a = context.getApplicationContext();
        this.b = interfaceC13701gg4;
        this.c = interfaceC13701gg42;
        this.d = cls;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(uri), new d(this.a, this.b, this.c, uri, i, i2, hl4, this.d));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && AbstractC19559qZ3.c(uri);
    }
}
