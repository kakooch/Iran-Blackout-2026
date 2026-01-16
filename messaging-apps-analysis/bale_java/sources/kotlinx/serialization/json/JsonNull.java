package kotlinx.serialization.json;

import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C8308Vk3;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlinx/serialization/json/JsonNull;", "Lkotlinx/serialization/json/JsonPrimitive;", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "content", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();

    /* renamed from: a, reason: from kotlin metadata */
    private static final String content = "null";
    private static final /* synthetic */ InterfaceC9173Yu3 b = AbstractC13269fw3.b(EnumC4870Gx3.b, a.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KSerializer invoke() {
            return C8308Vk3.a;
        }
    }

    private JsonNull() {
        super(null);
    }

    private final /* synthetic */ KSerializer h() {
        return (KSerializer) b.getValue();
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String f() {
        return content;
    }

    public final KSerializer serializer() {
        return h();
    }
}
