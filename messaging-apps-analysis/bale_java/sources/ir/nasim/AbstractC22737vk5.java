package ir.nasim;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;

/* renamed from: ir.nasim.vk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22737vk5 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.vk5$a */
    public static final class a {
        private a() {
        }

        public final C23923xk5 a(InputStream inputStream) throws CorruptionException {
            AbstractC13042fc3.i(inputStream, "input");
            try {
                C23923xk5 c23923xk5J = C23923xk5.J(inputStream);
                AbstractC13042fc3.h(c23923xk5J, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return c23923xk5J;
            } catch (InvalidProtocolBufferException e) {
                throw new CorruptionException("Unable to parse preferences proto.", e);
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
