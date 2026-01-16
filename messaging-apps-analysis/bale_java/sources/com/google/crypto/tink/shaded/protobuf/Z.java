package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
abstract class Z {

    class a implements b {
        final /* synthetic */ AbstractC2345g a;

        a(AbstractC2345g abstractC2345g) {
            this.a = abstractC2345g;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Z.b
        public byte a(int i) {
            return this.a.j(i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Z.b
        public int size() {
            return this.a.size();
        }
    }

    private interface b {
        byte a(int i);

        int size();
    }

    static String a(AbstractC2345g abstractC2345g) {
        return b(new a(abstractC2345g));
    }

    static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i = 0; i < bVar.size(); i++) {
            byte bA = bVar.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bA);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String c(String str) {
        return a(AbstractC2345g.E(str));
    }
}
