package org.rbmain.ui.Components.Paint;

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
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLog;

/* loaded from: classes5.dex */
public class Slice {
    private RectF bounds;
    private File file;

    public Slice(ByteBuffer byteBuffer, RectF rectF, DispatchQueue dispatchQueue) throws IOException {
        this.bounds = rectF;
        try {
            this.file = File.createTempFile("paint", ".bin", ApplicationLoader.applicationContext.getCacheDir());
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this.file == null) {
            return;
        }
        storeData(byteBuffer);
    }

    public void cleanResources() {
        File file = this.file;
        if (file != null) {
            file.delete();
            this.file = null;
        }
    }

    private void storeData(ByteBuffer byteBuffer) throws IOException {
        try {
            byte[] bArrArray = byteBuffer.array();
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
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
            FileLog.e(e);
        }
    }

    public ByteBuffer getData() throws DataFormatException, IOException {
        try {
            byte[] bArr = new byte[1024];
            byte[] bArr2 = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(this.file);
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
                if (!inflater.finished()) {
                    inflater.needsInput();
                } else {
                    inflater.end();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteBufferWrap;
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public int getX() {
        return (int) this.bounds.left;
    }

    public int getY() {
        return (int) this.bounds.top;
    }

    public int getWidth() {
        return (int) this.bounds.width();
    }

    public int getHeight() {
        return (int) this.bounds.height();
    }
}
