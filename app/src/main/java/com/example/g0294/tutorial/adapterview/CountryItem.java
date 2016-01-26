package com.example.g0294.tutorial.adapterview;

import android.os.Parcel;
import android.os.Parcelable;

public class CountryItem implements Parcelable {
    public static final Creator<CountryItem> CREATOR = new Creator<CountryItem>() {
        public CountryItem createFromParcel(Parcel source) {
            return new CountryItem(source);
        }

        public CountryItem[] newArray(int size) {
            return new CountryItem[size];
        }
    };
    String country;
    int image_id;

    public CountryItem(String country, int image_id) {
        this.country = country;
        this.image_id = image_id;
    }

    protected CountryItem(Parcel in) {
        this.country = in.readString();
        this.image_id = in.readInt();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.country);
        dest.writeInt(this.image_id);
    }
}
