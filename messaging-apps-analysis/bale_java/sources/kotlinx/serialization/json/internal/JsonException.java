package kotlinx.serialization.json.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/json/internal/JsonException;", "Lkotlinx/serialization/SerializationException;", DialogEntity.COLUMN_MESSAGE, "", "(Ljava/lang/String;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public class JsonException extends SerializationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonException(String str) {
        super(str);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
    }
}
