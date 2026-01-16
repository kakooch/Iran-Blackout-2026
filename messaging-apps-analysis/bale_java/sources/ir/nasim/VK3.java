package ir.nasim;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class VK3 {
    private final int a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private Bitmap f;

    public VK3(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public VK3 a(float f) {
        VK3 vk3 = new VK3((int) (this.a * f), (int) (this.b * f), this.c, this.d, this.e);
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            vk3.g(Bitmap.createScaledBitmap(bitmap, vk3.a, vk3.b, true));
        }
        return vk3;
    }

    public Bitmap b() {
        return this.f;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.a;
    }

    public void g(Bitmap bitmap) {
        this.f = bitmap;
    }
}
