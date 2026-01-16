package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import ir.nasim.core.modules.file.entity.FileReference;
import java.io.ByteArrayOutputStream;

/* renamed from: ir.nasim.ht, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14419ht {
    private final int a;
    private final C4626Fy b;
    private final int c;
    private final Long d;
    private final FileReference e;

    public C14419ht(int i, C4626Fy c4626Fy, int i2, Long l) {
        AbstractC13042fc3.i(c4626Fy, "apiImageLocation");
        this.a = i;
        this.b = c4626Fy;
        this.c = i2;
        this.d = l;
        C12056dy fileLocation = c4626Fy.getFileLocation();
        this.e = fileLocation != null ? new FileReference(fileLocation, "sticker.webp", "", c4626Fy.getFileSize()) : null;
    }

    private final byte[] a() {
        Context contextD = C5721Ko.a.d();
        Object obj = C17981nt.b().get(Integer.valueOf(this.a));
        AbstractC13042fc3.f(obj);
        Bitmap bitmapO = V13.o(C17981nt.c(contextD, ((Number) obj).intValue()), 30, 30);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmapO != null) {
            bitmapO.compress(Bitmap.CompressFormat.WEBP, 30, byteArrayOutputStream);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AbstractC13042fc3.h(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final String b() {
        int i = this.c;
        int i2 = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(i2);
        return sb.toString();
    }

    public final FileReference c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public final C5316Iv e() {
        return new C5316Iv(Integer.valueOf(this.a), a(), this.b, Integer.valueOf(this.c), this.d);
    }
}
