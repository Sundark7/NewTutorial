package com.example.g0294.tutorial.adapterview;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemClass implements Parcelable {
    public static final Parcelable.Creator<ItemClass> CREATOR = new Parcelable.Creator<ItemClass>() {
        public ItemClass createFromParcel(Parcel source) {
            return new ItemClass(source);
        }

        public ItemClass[] newArray(int size) {
            return new ItemClass[size];
        }
    };
    String text;
    int image;

    public ItemClass(String text, int image) {

        this.text = text;
        this.image = image;
    }

    protected ItemClass(Parcel in) {
        this.text = in.readString();
        this.image = in.readInt();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeInt(this.image);
    }
}
