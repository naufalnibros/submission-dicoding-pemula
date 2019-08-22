package id.co.naufalnibros.dicoding_pemula.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Pesan implements Parcelable {

    private String gender;
    private String nama_pengirim;
    private String pesan;

    public Pesan(String gender, String nama_pengirim, String pesan) {
        this.gender = gender;
        this.nama_pengirim = nama_pengirim;
        this.pesan = pesan;
    }

    protected Pesan(Parcel in) {
        gender = in.readString();
        nama_pengirim = in.readString();
        pesan = in.readString();
    }

    public static final Creator<Pesan> CREATOR = new Creator<Pesan>() {
        @Override
        public Pesan createFromParcel(Parcel in) {
            return new Pesan(in);
        }

        @Override
        public Pesan[] newArray(int size) {
            return new Pesan[size];
        }
    };

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNama_pengirim() {
        return nama_pengirim;
    }

    public void setNama_pengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gender);
        parcel.writeString(nama_pengirim);
        parcel.writeString(pesan);
    }
}
