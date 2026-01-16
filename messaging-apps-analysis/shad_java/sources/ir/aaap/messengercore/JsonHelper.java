package ir.aaap.messengercore;

/* loaded from: classes3.dex */
public interface JsonHelper {
    <T> T fromJson(String str, Class<T> cls) throws Exception;

    String toJson(Object obj);
}
