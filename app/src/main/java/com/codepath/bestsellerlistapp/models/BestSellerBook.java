package com.codepath.bestsellerlistapp.models;

import com.google.gson.annotations.SerializedName;

public class BestSellerBook {

   @SerializedName("rank")
   public int rank;

   @SerializedName("title")
   public String title;

   @SerializedName("author")
   public String author;

   @SerializedName("book_image")
   public String bookImageUrl;

   @SerializedName("publisher")
   public String publisher;

   @SerializedName("description")
   public String description;

   @SerializedName("amazon_product_url")
   public String amazonUrl;

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getBookImageUrl() {
      return bookImageUrl;
   }

   public void setBookImageUrl(String bookImageUrl) {
      this.bookImageUrl = bookImageUrl;
   }

   public String getPublisher() {
      return publisher;
   }

   public void setPublisher(String publisher) {
      this.publisher = publisher;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getAmazonUrl() {
      return amazonUrl;
   }

   public void setAmazonUrl(String amazonUrl) {
      this.amazonUrl = amazonUrl;
   }
}
