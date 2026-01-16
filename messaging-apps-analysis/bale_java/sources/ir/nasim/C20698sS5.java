package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.sS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20698sS5 extends TP5 {
    private int a;
    private long b;
    private long c;
    private String d;
    private String e;
    private C8421Vx f;
    private TB g;
    private long h;

    public static C20698sS5 r(byte[] bArr) {
        return (C20698sS5) AbstractC16720ll0.b(new C20698sS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = (C8421Vx) c19084pl0.z(6, new C8421Vx());
        this.g = (TB) c19084pl0.z(7, new TB());
        this.h = c19084pl0.i(8);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
        C8421Vx c8421Vx = this.f;
        if (c8421Vx != null) {
            c19675ql0.i(6, c8421Vx);
        }
        TB tb = this.g;
        if (tb != null) {
            c19675ql0.i(7, tb);
        }
        c19675ql0.g(8, this.h);
    }

    public String toString() {
        return "rpc GetNasimFileUploadUrl{}";
    }
}
