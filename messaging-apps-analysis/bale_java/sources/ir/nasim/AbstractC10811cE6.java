package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.util.Size;
import org.xbill.DNS.SimpleResolver;

/* renamed from: ir.nasim.cE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10811cE6 {
    public static final Size a = new Size(0, 0);
    public static final Size b = new Size(320, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
    public static final Size c = new Size(640, 480);
    public static final Size d = new Size(720, 480);
    public static final Size e = new Size(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720);
    public static final Size f = new Size(1920, 1080);
    public static final Size g = new Size(1920, 1440);

    public static int a(int i, int i2) {
        return i * i2;
    }

    public static int b(Size size) {
        return a(size.getWidth(), size.getHeight());
    }

    public static boolean c(Size size, Size size2) {
        return b(size) < b(size2);
    }
}
