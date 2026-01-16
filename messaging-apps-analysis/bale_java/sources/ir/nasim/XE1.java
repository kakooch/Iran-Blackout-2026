package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.AbstractC7426Rr;

/* loaded from: classes5.dex */
public final class XE1 implements InterfaceC7742Sz6 {
    private final Context a;

    public XE1(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    private final Bitmap b(String str) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        int iF = aVar.f(48.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapDecodeFile, tileMode, tileMode);
        Paint paint = new Paint(1);
        paint.setShader(bitmapShader);
        float width = iF / bitmapDecodeFile.getWidth();
        int iSave = canvas.save();
        canvas.scale(width, width, 0.0f, 0.0f);
        try {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight()), bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), paint);
            canvas.restoreToCount(iSave);
            Drawable drawableF = AbstractC4043Dl1.f(this.a, KB5.ic_bale);
            if (drawableF != null) {
                int iF2 = aVar.f(15.0f);
                int i = iF - iF2;
                int iF3 = i - aVar.f(2.0f);
                int iF4 = i - aVar.f(2.0f);
                drawableF.setBounds(iF3, iF4, iF3 + iF2, iF2 + iF4);
                drawableF.draw(canvas);
            }
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC7742Sz6
    public IconCompat a(String str) {
        AbstractC13042fc3.i(str, "filePath");
        IconCompat iconCompatI = IconCompat.i(b(str));
        AbstractC13042fc3.h(iconCompatI, "createWithBitmap(...)");
        return iconCompatI;
    }
}
