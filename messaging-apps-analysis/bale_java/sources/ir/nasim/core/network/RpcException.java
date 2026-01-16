package ir.nasim.core.network;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0016\u0018\u0000 \u00182\u00060\u0001j\u0002`\u0002:\u0001\fB'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017¨\u0006\u0019"}, d2 = {"Lir/nasim/core/network/RpcException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ParameterNames.TAG, "", "code", DialogEntity.COLUMN_MESSAGE, "", "isCanTryAgain", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "b", TokenNames.I, "()I", "c", "getMessage", "d", "Z", "()Z", "e", "base_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class RpcException extends Exception {

    /* renamed from: a, reason: from kotlin metadata */
    private final String tag;

    /* renamed from: b, reason: from kotlin metadata */
    private final int code;

    /* renamed from: c, reason: from kotlin metadata */
    private final String message;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean isCanTryAgain;

    public RpcException(String str, int i, String str2, boolean z) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        this.tag = str;
        this.code = i;
        this.message = str2;
        this.isCanTryAgain = z;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsCanTryAgain() {
        return this.isCanTryAgain;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final String getTag() {
        return this.tag;
    }
}
