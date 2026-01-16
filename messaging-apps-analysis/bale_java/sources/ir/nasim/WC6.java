package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class WC6 extends EC6 implements InterfaceC24671z07 {
    private final String n;

    class a extends D07 {
        a() {
        }

        @Override // ir.nasim.KB1
        public void y() {
            WC6.this.r(this);
        }
    }

    protected WC6(String str) {
        super(new C07[2], new D07[2]);
        this.n = str;
        u(1024);
    }

    protected abstract InterfaceC24081y07 A(byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.EC6
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final C07 g() {
        return new C07();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.EC6
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public final D07 h() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.EC6
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException i(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.EC6
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException j(C07 c07, D07 d07, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) AbstractC20011rK.e(c07.c);
            d07.z(c07.e, A(byteBuffer.array(), byteBuffer.limit(), z), c07.i);
            d07.q(RecyclerView.UNDEFINED_DURATION);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    @Override // ir.nasim.InterfaceC24671z07
    public void a(long j) {
    }
}
