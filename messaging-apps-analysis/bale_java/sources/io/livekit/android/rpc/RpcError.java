package io.livekit.android.rpc;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.CY6;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;
import livekit.LivekitModels$RpcError;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002\r\u001aB-\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lio/livekit/android/rpc/RpcError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "", DialogEntity.COLUMN_MESSAGE, "data", "", ParameterNames.CAUSE, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Llivekit/LivekitModels$RpcError;", "a", "()Llivekit/LivekitModels$RpcError;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getCode", "b", "Ljava/lang/String;", "getMessage", "c", "getData", "d", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "Companion", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final /* data */ class RpcError extends Exception {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String message;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String data;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final Throwable cause;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a c = new a("APPLICATION_ERROR", 0, 1500, "Application error in method handler");
        public static final a d = new a("CONNECTION_TIMEOUT", 1, 1501, "Connection timeout");
        public static final a e = new a("RESPONSE_TIMEOUT", 2, 1502, "Response timeout");
        public static final a f = new a("RECIPIENT_DISCONNECTED", 3, 1503, "Recipient disconnected");
        public static final a g = new a("RESPONSE_PAYLOAD_TOO_LARGE", 4, 1504, "Response payload too large");
        public static final a h = new a("SEND_FAILED", 5, 1505, "Failed to send");
        public static final a i = new a("UNSUPPORTED_METHOD", 6, 1400, "Method not supported at destination");
        public static final a j = new a("RECIPIENT_NOT_FOUND", 7, 1401, "Recipient not found");
        public static final a k = new a("REQUEST_PAYLOAD_TOO_LARGE", 8, 1402, "Request payload too large");
        public static final a l = new a("UNSUPPORTED_SERVER", 9, 1403, "RPC not supported by server");
        public static final a m = new a("UNSUPPORTED_VERSION", 10, 1404, "Unsupported RPC version");
        private static final /* synthetic */ a[] n;
        private static final /* synthetic */ F92 o;
        private final int a;
        private final String b;

        static {
            a[] aVarArrA = a();
            n = aVarArrA;
            o = G92.a(aVarArrA);
        }

        private a(String str, int i2, int i3, String str2) {
            this.a = i3;
            this.b = str2;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{c, d, e, f, g, h, i, j, k, l, m};
        }

        public static /* synthetic */ RpcError p(a aVar, String str, Throwable th, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
            if ((i2 & 1) != 0) {
                str = "";
            }
            if ((i2 & 2) != 0) {
                th = null;
            }
            return aVar.j(str, th);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) n.clone();
        }

        public final RpcError j(String str, Throwable th) {
            AbstractC13042fc3.i(str, "data");
            return new RpcError(this.a, this.b, str, th);
        }
    }

    /* renamed from: io.livekit.android.rpc.RpcError$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final RpcError a(LivekitModels$RpcError livekitModels$RpcError) {
            AbstractC13042fc3.i(livekitModels$RpcError, "proto");
            int code = livekitModels$RpcError.getCode();
            String message = livekitModels$RpcError.getMessage();
            if (message == null) {
                message = "";
            }
            String strB = CY6.b(message, 256);
            String data = livekitModels$RpcError.getData();
            AbstractC13042fc3.h(data, "getData(...)");
            return new RpcError(code, strB, CY6.b(data, 15360), null, 8, null);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ RpcError(int i, String str, String str2, Throwable th, int i2, ED1 ed1) {
        this(i, str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? null : th);
    }

    public final LivekitModels$RpcError a() {
        LivekitModels$RpcError.a aVarNewBuilder = LivekitModels$RpcError.newBuilder();
        aVarNewBuilder.A(this.code);
        aVarNewBuilder.C(getMessage());
        aVarNewBuilder.B(this.data);
        LivekitModels$RpcError livekitModels$RpcError = (LivekitModels$RpcError) aVarNewBuilder.a();
        AbstractC13042fc3.h(livekitModels$RpcError, "with(...)");
        return livekitModels$RpcError;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RpcError)) {
            return false;
        }
        RpcError rpcError = (RpcError) other;
        return this.code == rpcError.code && AbstractC13042fc3.d(this.message, rpcError.message) && AbstractC13042fc3.d(this.data, rpcError.data) && AbstractC13042fc3.d(this.cause, rpcError.cause);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31) + this.data.hashCode()) * 31;
        Throwable th = this.cause;
        return iHashCode + (th == null ? 0 : th.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RpcError(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", cause=" + this.cause + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcError(int i, String str, String str2, Throwable th) {
        super(str);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str2, "data");
        this.code = i;
        this.message = str;
        this.data = str2;
        this.cause = th;
    }
}
