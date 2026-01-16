package ir.nasim;

import android.graphics.RectF;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* renamed from: ir.nasim.hE6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C14036hE6 {
    private RectF a;
    private File b;

    public C14036hE6(ByteBuffer byteBuffer, RectF rectF) throws IOException {
        this.a = rectF;
        try {
            this.b = File.createTempFile("paint", ".bin", C5721Ko.b.getCacheDir());
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
        if (this.b == null) {
            return;
        }
        g(byteBuffer);
    }

    private void g(ByteBuffer byteBuffer) throws IOException {
        try {
            byte[] bArrArray = byteBuffer.array();
            FileOutputStream fileOutputStream = new FileOutputStream(this.b);
            Deflater deflater = new Deflater(1, true);
            deflater.setInput(bArrArray, byteBuffer.arrayOffset(), byteBuffer.remaining());
            deflater.finish();
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                fileOutputStream.write(bArr, 0, deflater.deflate(bArr));
            }
            deflater.end();
            fileOutputStream.close();
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
    }

    public void a() {
        File file = this.b;
        if (file != null) {
            file.delete();
            this.b = null;
        }
    }

    public ByteBuffer b() throws DataFormatException, IOException {
        try {
            byte[] bArr = new byte[1024];
            byte[] bArr2 = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(this.b);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Inflater inflater = new Inflater(true);
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    inflater.setInput(bArr, 0, i);
                }
                while (true) {
                    int iInflate = inflater.inflate(bArr2, 0, 1024);
                    if (iInflate == 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, iInflate);
                }
                if (inflater.finished()) {
                    inflater.end();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteBufferWrap;
                }
                inflater.needsInput();
            }
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
            return null;
        }
    }

    public int c() {
        return (int) this.a.height();
    }

    public int d() {
        return (int) this.a.width();
    }

    public int e() {
        return (int) this.a.left;
    }

    public int f() {
        return (int) this.a.top;
    }
}
