package ir.nasim;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import ir.nasim.InterfaceC8666Wy1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.vp7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22789vp7 implements InterfaceC8666Wy1 {
    private final Uri a;
    private final C3617Bp7 b;
    private InputStream c;

    /* renamed from: ir.nasim.vp7$a */
    static class a implements InterfaceC25159zp7 {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // ir.nasim.InterfaceC25159zp7
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* renamed from: ir.nasim.vp7$b */
    static class b implements InterfaceC25159zp7 {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // ir.nasim.InterfaceC25159zp7
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    C22789vp7(Uri uri, C3617Bp7 c3617Bp7) {
        this.a = uri;
        this.b = c3617Bp7;
    }

    private static C22789vp7 c(Context context, Uri uri, InterfaceC25159zp7 interfaceC25159zp7) {
        return new C22789vp7(uri, new C3617Bp7(com.bumptech.glide.b.c(context).j().g(), interfaceC25159zp7, com.bumptech.glide.b.c(context).e(), context.getContentResolver()));
    }

    public static C22789vp7 f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static C22789vp7 g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws Throwable {
        InputStream inputStreamD = this.b.d(this.a);
        int iA = inputStreamD != null ? this.b.a(this.a) : -1;
        return iA != -1 ? new C20204rd2(inputStreamD, iA) : inputStreamD;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public Class a() {
        return InputStream.class;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void b() throws IOException {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public EnumC21012sz1 d() {
        return EnumC21012sz1.LOCAL;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.c = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.c(e);
        }
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void cancel() {
    }
}
