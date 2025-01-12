package com.codepath.bestsellerlistapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.bestsellerlistapp.models.BestSellerBook;

import java.util.List;



/**
 * {@link RecyclerView.Adapter} that can display a {@link BestSellerBook} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class BestSellerBooksRecyclerViewAdapter extends RecyclerView.Adapter<BestSellerBooksRecyclerViewAdapter.BookViewHolder> {

    Context context;
    private final List<BestSellerBook> books;
    private final OnListFragmentInteractionListener mListener;

    public BestSellerBooksRecyclerViewAdapter(List<BestSellerBook> items, OnListFragmentInteractionListener listener) {
        books = items;
        mListener = listener;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_best_seller_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, int position) {
        Log.d("BestSellerBookAdapter", "OnBindViewHolder" + position);
        BestSellerBook bestSellerBook = books.get(position);
        Glide.with(holder.mView)
                .load(bestSellerBook.bookImageUrl)
                .centerInside()
                .into(holder.mBookImage);
        holder.bind(bestSellerBook);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(holder.mItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mBookTitle;
        public final TextView mBookAuthor;
        public BestSellerBook mItem;
//        public final TextView mBookRank;
        public final ImageView mBookImage;
        public final TextView mBookDescription;
        public final Button mBookUrl;



        public BookViewHolder(View view) {
            super(view);
            mView = view;
            mBookTitle = (TextView) view.findViewById(R.id.book_title);
            mBookAuthor = (TextView) view.findViewById(R.id.book_author);
//            mBookRank = (TextView) view.findViewById(R.id.ranking);
            mBookImage = (ImageView) view.findViewById(R.id.book_image);
            mBookDescription = (TextView) view.findViewById(R.id.book_description);
            mBookUrl = (Button) view.findViewById(R.id.buy_button);

        }

        @Override
        public String toString() {
            return mBookTitle.toString() + " '" + mBookAuthor.getText() + "'";
                   // + mBookRank.getText() + "'" + mBookUrl.getText() + "'" + mBookDescription.getText();
        }

        public void bind(BestSellerBook bestSellerBook) {
            //holder.mItem = books.get(position);
            mBookTitle.setText(bestSellerBook.getTitle());
            //holder.mBookTitle.setText(books.get(position).title);
            mBookAuthor.setText(bestSellerBook.getAuthor());
            //holder.mBookAuthor.setText(books.get(position).author);
//            mBookRank.setText(bestSellerBook.getRank());
            //holder.mBookRank.setText(books.get(position).rank);
            mBookDescription.setText(bestSellerBook.getDescription());
            //holder.mBookDescription.setText(books.get(position).description);
            mBookUrl.setText(bestSellerBook.getAmazonUrl());
            //holder.mBookUrl.setText(books.get(position).amazonUrl);
        }
    }
}
