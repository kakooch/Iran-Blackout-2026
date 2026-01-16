package okio;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC11442d1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.ED1;
import ir.nasim.UA2;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import okio.Options;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u0019*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005:\u0001\u0019B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokio/TypedOptions;", "", TokenNames.T, "Lir/nasim/d1;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "list", "Lokio/Options;", "options", "<init>", "(Ljava/util/List;Lokio/Options;)V", "", "index", "get", "(I)Ljava/lang/Object;", "Lokio/Options;", "getOptions$okio", "()Lokio/Options;", "Ljava/util/List;", "getList$okio", "()Ljava/util/List;", "getSize", "()I", "size", "Companion", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class TypedOptions<T> extends AbstractC11442d1 implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<T> list;
    private final Options options;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lokio/TypedOptions$Companion;", "", "<init>", "()V", TokenNames.T, "", "values", "Lkotlin/Function1;", "Lokio/ByteString;", "encode", "Lokio/TypedOptions;", "of", "(Ljava/lang/Iterable;Lir/nasim/UA2;)Lokio/TypedOptions;", "okio"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> TypedOptions<T> of(Iterable<? extends T> values, UA2 encode) {
            AbstractC13042fc3.i(values, "values");
            AbstractC13042fc3.i(encode, "encode");
            List listM1 = AbstractC15401jX0.m1(values);
            Options.Companion companion = Options.INSTANCE;
            int size = listM1.size();
            ByteString[] byteStringArr = new ByteString[size];
            for (int i = 0; i < size; i++) {
                byteStringArr[i] = encode.invoke(listM1.get(i));
            }
            return new TypedOptions<>(listM1, companion.of(byteStringArr));
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public TypedOptions(List<? extends T> list, Options options) {
        AbstractC13042fc3.i(list, "list");
        AbstractC13042fc3.i(options, "options");
        this.options = options;
        List<T> listM1 = AbstractC15401jX0.m1(list);
        this.list = listM1;
        if (listM1.size() != options.size()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public static final <T> TypedOptions<T> of(Iterable<? extends T> iterable, UA2 ua2) {
        return INSTANCE.of(iterable, ua2);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public T get(int index) {
        return this.list.get(index);
    }

    public final List<T> getList$okio() {
        return this.list;
    }

    /* renamed from: getOptions$okio, reason: from getter */
    public final Options getOptions() {
        return this.options;
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.list.size();
    }
}
