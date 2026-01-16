package ir.resaneh1.iptv.helper;

/* loaded from: classes3.dex */
public class RndHelper {
    public static int getRndForString(String str) {
        return (int) (str.hashCode() + (System.currentTimeMillis() / 15000));
    }
}
