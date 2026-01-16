package kotlinx.serialization;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001f\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "", "", "missingFields", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Throwable;)V", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "a", "Ljava/util/List;", "()Ljava/util/List;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class MissingFieldException extends SerializationException {

    /* renamed from: a, reason: from kotlin metadata */
    private final List missingFields;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(List list, String str, Throwable th) {
        super(str, th);
        AbstractC13042fc3.i(list, "missingFields");
        this.missingFields = list;
    }

    /* renamed from: a, reason: from getter */
    public final List getMissingFields() {
        return this.missingFields;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MissingFieldException(List list, String str) {
        String str2;
        AbstractC13042fc3.i(list, "missingFields");
        AbstractC13042fc3.i(str, "serialName");
        if (list.size() == 1) {
            str2 = "Field '" + ((String) list.get(0)) + "' is required for type with serial name '" + str + "', but it was missing";
        } else {
            str2 = "Fields " + list + " are required for type with serial name '" + str + "', but they were missing";
        }
        this(list, str2, null);
    }
}
