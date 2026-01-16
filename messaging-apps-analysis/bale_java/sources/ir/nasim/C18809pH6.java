package ir.nasim;

import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* renamed from: ir.nasim.pH6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C18809pH6 {
    private long a;

    private long b(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    private long c(byte[] bArr, int i) {
        return ((b(bArr, i) - 2208988800L) * 1000) + ((b(bArr, i + 4) * 1000) / 4294967296L);
    }

    private void e(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        bArr[i] = (byte) (r2 >> 24);
        bArr[i + 1] = (byte) (r2 >> 16);
        bArr[i + 2] = (byte) (r2 >> 8);
        bArr[i + 3] = (byte) (j2 + 2208988800L);
        long j4 = (j3 * 4294967296L) / 1000;
        bArr[i + 4] = (byte) (j4 >> 24);
        bArr[i + 5] = (byte) (j4 >> 16);
        bArr[i + 6] = (byte) (j4 >> 8);
        bArr[i + 7] = (byte) (Math.random() * 255.0d);
    }

    public long a() {
        return this.a;
    }

    public boolean d(String str, int i) throws Throwable {
        try {
            if (!C4100Dr4.b(C5721Ko.b)) {
                C19406qI3.a("SntpClient", "Network status is offline.", new Object[0]);
                return false;
            }
            DatagramSocket datagramSocket = null;
            try {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                try {
                    datagramSocket2.setSoTimeout(i);
                    byte[] bArr = new byte[48];
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName(str), 123);
                    bArr[0] = 27;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    e(bArr, 40, jCurrentTimeMillis);
                    datagramSocket2.send(datagramPacket);
                    datagramSocket2.receive(new DatagramPacket(bArr, 48));
                    long jElapsedRealtime2 = jCurrentTimeMillis + (SystemClock.elapsedRealtime() - jElapsedRealtime);
                    long jC = c(bArr, 24);
                    this.a = ((c(bArr, 32) - jC) + (c(bArr, 40) - jElapsedRealtime2)) / 2;
                    datagramSocket2.close();
                    return true;
                } catch (Exception unused) {
                    datagramSocket = datagramSocket2;
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    datagramSocket = datagramSocket2;
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
        }
    }
}
