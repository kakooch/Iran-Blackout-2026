package com.google.android.exoplayer2.source;

import android.net.Uri;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C24512yk4;
import ir.nasim.C8292Vi5;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC12462ef2;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;
import ir.nasim.RD1;
import java.io.EOFException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    private final InterfaceC12462ef2 a;
    private InterfaceC9262Ze2 b;
    private InterfaceC9845af2 c;

    public BundledExtractorsAdapter(InterfaceC12462ef2 interfaceC12462ef2) {
        this.a = interfaceC12462ef2;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void a(long j, long j2) {
        ((InterfaceC9262Ze2) AbstractC20011rK.e(this.b)).a(j, j2);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int b(C8292Vi5 c8292Vi5) {
        return ((InterfaceC9262Ze2) AbstractC20011rK.e(this.b)).e((InterfaceC9845af2) AbstractC20011rK.e(this.c), c8292Vi5);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void c(InterfaceC18631oz1 interfaceC18631oz1, Uri uri, Map map, long j, long j2, InterfaceC10465bf2 interfaceC10465bf2) throws UnrecognizedInputFormatException {
        RD1 rd1 = new RD1(interfaceC18631oz1, j, j2);
        this.c = rd1;
        if (this.b != null) {
            return;
        }
        InterfaceC9262Ze2[] interfaceC9262Ze2ArrB = this.a.b(uri, map);
        if (interfaceC9262Ze2ArrB.length == 1) {
            this.b = interfaceC9262Ze2ArrB[0];
        } else {
            int length = interfaceC9262Ze2ArrB.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                InterfaceC9262Ze2 interfaceC9262Ze2 = interfaceC9262Ze2ArrB[i];
                try {
                } catch (EOFException unused) {
                    if (this.b != null || rd1.getPosition() == j) {
                    }
                } catch (Throwable th) {
                    AbstractC20011rK.g(this.b != null || rd1.getPosition() == j);
                    rd1.e();
                    throw th;
                }
                if (interfaceC9262Ze2.d(rd1)) {
                    this.b = interfaceC9262Ze2;
                    AbstractC20011rK.g(true);
                    rd1.e();
                    break;
                } else {
                    boolean z = this.b != null || rd1.getPosition() == j;
                    AbstractC20011rK.g(z);
                    rd1.e();
                    i++;
                }
            }
            if (this.b == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + AbstractC9683aN7.J(interfaceC9262Ze2ArrB) + ") could read the stream.", (Uri) AbstractC20011rK.e(uri));
            }
        }
        this.b.b(interfaceC10465bf2);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void d() {
        InterfaceC9262Ze2 interfaceC9262Ze2 = this.b;
        if (interfaceC9262Ze2 instanceof C24512yk4) {
            ((C24512yk4) interfaceC9262Ze2).j();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long e() {
        InterfaceC9845af2 interfaceC9845af2 = this.c;
        if (interfaceC9845af2 != null) {
            return interfaceC9845af2.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        InterfaceC9262Ze2 interfaceC9262Ze2 = this.b;
        if (interfaceC9262Ze2 != null) {
            interfaceC9262Ze2.release();
            this.b = null;
        }
        this.c = null;
    }
}
