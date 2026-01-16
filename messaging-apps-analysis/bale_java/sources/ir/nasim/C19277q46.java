package ir.nasim;

import android.content.Context;
import android.net.Uri;
import ir.nasim.DD;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

/* renamed from: ir.nasim.q46, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19277q46 extends C16913m46 {
    private static final a c = new a(null);
    private final String b;

    /* renamed from: ir.nasim.q46$a */
    private static final class a {
        private a() {
        }

        public final String a(Context context, Uri uri) throws IOException {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(uri, "uri");
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenInputStream);
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    AbstractC8839Xn7.b(inputStreamReader, stringWriter, 0, 2, null);
                    String string = stringWriter.toString();
                    YV0.a(stringWriter, null);
                    YV0.a(inputStreamReader, null);
                    return string;
                } finally {
                }
            } finally {
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C19277q46(String str) {
        this.b = str;
    }

    @Override // ir.nasim.C16913m46, ir.nasim.InterfaceC19868r46
    public DD c(int i) {
        return i == 0 ? new DD.b(this.b) : super.c(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C19277q46(Context context, Uri uri) {
        this(c.a(context, uri));
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(uri, "uri");
    }
}
