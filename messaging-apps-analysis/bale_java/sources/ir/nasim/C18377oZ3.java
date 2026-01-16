package ir.nasim;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: ir.nasim.oZ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18377oZ3 implements InterfaceC13701gg4 {
    private final Context a;

    /* renamed from: ir.nasim.oZ3$a */
    public static final class a implements InterfaceC14292hg4 {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C18377oZ3(this.a);
        }
    }

    public C18377oZ3(Context context) {
        this.a = context;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(uri), new b(this.a, uri));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return AbstractC19559qZ3.c(uri);
    }

    /* renamed from: ir.nasim.oZ3$b */
    private static class b implements InterfaceC8666Wy1 {
        private static final String[] c = {"_data"};
        private final Context a;
        private final Uri b;

        b(Context context, Uri uri) {
            this.a = context;
            this.b = uri;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return File.class;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            Cursor cursorQuery = this.a.getContentResolver().query(this.b, c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.b));
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }
}
