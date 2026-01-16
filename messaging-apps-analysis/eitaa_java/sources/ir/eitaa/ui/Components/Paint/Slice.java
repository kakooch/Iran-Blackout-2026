package ir.eitaa.ui.Components.Paint;

import android.graphics.RectF;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class Slice {
    private RectF bounds;
    private File file;

    public Slice(final ByteBuffer data, RectF rect, DispatchQueue queue) throws IOException {
        this.bounds = rect;
        try {
            this.file = File.createTempFile("paint", ".bin", ApplicationLoader.applicationContext.getCacheDir());
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this.file == null) {
            return;
        }
        storeData(data);
    }

    public void cleanResources() {
        File file = this.file;
        if (file != null) {
            file.delete();
            this.file = null;
        }
    }

    private void storeData(ByteBuffer data) throws IOException {
        try {
            byte[] bArrArray = data.array();
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            Deflater deflater = new Deflater(1, true);
            deflater.setInput(bArrArray, data.arrayOffset(), data.remaining());
            deflater.finish();
            byte[] bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
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
            byte[] bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
            byte[] bArr2 = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
            FileInputStream fileInputStream = new FileInputStream(this.file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Inflater inflater = new Inflater(true);
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    inflater.setInput(bArr, 0, i);
                }
                while (true) {
                    int iInflate = inflater.inflate(bArr2, 0, Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
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
