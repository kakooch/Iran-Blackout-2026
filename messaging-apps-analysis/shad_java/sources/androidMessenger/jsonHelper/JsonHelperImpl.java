package androidMessenger.jsonHelper;

import com.google.gson.Gson;
import ir.aaap.messengercore.JsonHelper;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class JsonHelperImpl implements JsonHelper {
    @Override // ir.aaap.messengercore.JsonHelper
    public String toJson(Object obj) {
        return ApplicationLoader.getGson().toJson(obj);
    }

    @Override // ir.aaap.messengercore.JsonHelper
    public <T> T fromJson(String str, Class<T> cls) throws Exception {
        return (T) new Gson().fromJson(str, (Class) cls);
    }
}
